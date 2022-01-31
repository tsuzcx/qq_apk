package android.support.v4.app;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackRecord
  extends FragmentTransaction
  implements FragmentManager.BackStackEntry, Runnable
{
  static final int OP_ADD = 1;
  static final int OP_ATTACH = 7;
  static final int OP_DETACH = 6;
  static final int OP_HIDE = 4;
  static final int OP_NULL = 0;
  static final int OP_REMOVE = 3;
  static final int OP_REPLACE = 2;
  static final int OP_SHOW = 5;
  static final String TAG = "FragmentManager";
  boolean mAddToBackStack;
  boolean mAllowAddToBackStack = true;
  int mBreadCrumbShortTitleRes;
  CharSequence mBreadCrumbShortTitleText;
  int mBreadCrumbTitleRes;
  CharSequence mBreadCrumbTitleText;
  boolean mCommitted;
  int mEnterAnim;
  int mExitAnim;
  BackStackRecord.Op mHead;
  int mIndex = -1;
  final FragmentManagerImpl mManager;
  String mName;
  int mNumOp;
  int mPopEnterAnim;
  int mPopExitAnim;
  BackStackRecord.Op mTail;
  int mTransition;
  int mTransitionStyle;
  
  public BackStackRecord(FragmentManagerImpl paramFragmentManagerImpl)
  {
    this.mManager = paramFragmentManagerImpl;
  }
  
  private void doAddOp(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    paramFragment.mFragmentManager = this.mManager;
    if (paramString != null)
    {
      if ((paramFragment.mTag != null) && (!paramString.equals(paramFragment.mTag))) {
        throw new IllegalStateException("Can't change tag of fragment " + paramFragment + ": was " + paramFragment.mTag + " now " + paramString);
      }
      paramFragment.mTag = paramString;
    }
    if (paramInt1 != 0)
    {
      if ((paramFragment.mFragmentId != 0) && (paramFragment.mFragmentId != paramInt1)) {
        throw new IllegalStateException("Can't change container ID of fragment " + paramFragment + ": was " + paramFragment.mFragmentId + " now " + paramInt1);
      }
      paramFragment.mFragmentId = paramInt1;
      paramFragment.mContainerId = paramInt1;
    }
    paramString = new BackStackRecord.Op();
    paramString.cmd = paramInt2;
    paramString.fragment = paramFragment;
    addOp(paramString);
  }
  
  public FragmentTransaction add(int paramInt, Fragment paramFragment)
  {
    doAddOp(paramInt, paramFragment, null, 1);
    return this;
  }
  
  public FragmentTransaction add(int paramInt, Fragment paramFragment, String paramString)
  {
    doAddOp(paramInt, paramFragment, paramString, 1);
    return this;
  }
  
  public FragmentTransaction add(Fragment paramFragment, String paramString)
  {
    doAddOp(0, paramFragment, paramString, 1);
    return this;
  }
  
  void addOp(BackStackRecord.Op paramOp)
  {
    if (this.mHead == null)
    {
      this.mTail = paramOp;
      this.mHead = paramOp;
    }
    for (;;)
    {
      paramOp.enterAnim = this.mEnterAnim;
      paramOp.exitAnim = this.mExitAnim;
      paramOp.popEnterAnim = this.mPopEnterAnim;
      paramOp.popExitAnim = this.mPopExitAnim;
      this.mNumOp += 1;
      return;
      paramOp.prev = this.mTail;
      this.mTail.next = paramOp;
      this.mTail = paramOp;
    }
  }
  
  public FragmentTransaction addToBackStack(String paramString)
  {
    if (!this.mAllowAddToBackStack) {
      throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }
    this.mAddToBackStack = true;
    this.mName = paramString;
    return this;
  }
  
  public FragmentTransaction attach(Fragment paramFragment)
  {
    BackStackRecord.Op localOp = new BackStackRecord.Op();
    localOp.cmd = 7;
    localOp.fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  void bumpBackStackNesting(int paramInt)
  {
    if (!this.mAddToBackStack) {}
    for (;;)
    {
      return;
      for (BackStackRecord.Op localOp = this.mHead; localOp != null; localOp = localOp.next)
      {
        Fragment localFragment;
        if (localOp.fragment != null)
        {
          localFragment = localOp.fragment;
          localFragment.mBackStackNesting += paramInt;
        }
        if (localOp.removed != null)
        {
          int i = localOp.removed.size() - 1;
          while (i >= 0)
          {
            localFragment = (Fragment)localOp.removed.get(i);
            localFragment.mBackStackNesting += paramInt;
            i -= 1;
          }
        }
      }
    }
  }
  
  public int commit()
  {
    return commitInternal(false);
  }
  
  public int commitAllowingStateLoss()
  {
    return commitInternal(true);
  }
  
  int commitInternal(boolean paramBoolean)
  {
    if (this.mCommitted) {
      throw new IllegalStateException("commit already called");
    }
    this.mCommitted = true;
    if (this.mAddToBackStack) {}
    for (this.mIndex = this.mManager.allocBackStackIndex(this);; this.mIndex = -1)
    {
      this.mManager.enqueueAction(this, paramBoolean);
      return this.mIndex;
    }
  }
  
  public FragmentTransaction detach(Fragment paramFragment)
  {
    BackStackRecord.Op localOp = new BackStackRecord.Op();
    localOp.cmd = 6;
    localOp.fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  public FragmentTransaction disallowAddToBackStack()
  {
    if (this.mAddToBackStack) {
      throw new IllegalStateException("This transaction is already being added to the back stack");
    }
    this.mAllowAddToBackStack = false;
    return this;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    dump(paramString, paramPrintWriter, true);
  }
  
  public void dump(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(this.mName);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(this.mIndex);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(this.mCommitted);
      if (this.mTransition != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.mTransition));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(this.mTransitionStyle));
      }
      if ((this.mEnterAnim != 0) || (this.mExitAnim != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.mEnterAnim));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.mExitAnim));
      }
      if ((this.mPopEnterAnim != 0) || (this.mPopExitAnim != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.mPopEnterAnim));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.mPopExitAnim));
      }
      if ((this.mBreadCrumbTitleRes != 0) || (this.mBreadCrumbTitleText != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.mBreadCrumbTitleText);
      }
      if ((this.mBreadCrumbShortTitleRes != 0) || (this.mBreadCrumbShortTitleText != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.mBreadCrumbShortTitleText);
      }
    }
    if (this.mHead != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      String str2 = paramString + "    ";
      BackStackRecord.Op localOp = this.mHead;
      int i = 0;
      while (localOp != null)
      {
        String str1;
        int j;
        switch (localOp.cmd)
        {
        default: 
          str1 = "cmd=" + localOp.cmd;
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  Op #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.print(str1);
          paramPrintWriter.print(" ");
          paramPrintWriter.println(localOp.fragment);
          if (paramBoolean)
          {
            if ((localOp.enterAnim != 0) || (localOp.exitAnim != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("enterAnim=#");
              paramPrintWriter.print(Integer.toHexString(localOp.enterAnim));
              paramPrintWriter.print(" exitAnim=#");
              paramPrintWriter.println(Integer.toHexString(localOp.exitAnim));
            }
            if ((localOp.popEnterAnim != 0) || (localOp.popExitAnim != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("popEnterAnim=#");
              paramPrintWriter.print(Integer.toHexString(localOp.popEnterAnim));
              paramPrintWriter.print(" popExitAnim=#");
              paramPrintWriter.println(Integer.toHexString(localOp.popExitAnim));
            }
          }
          if ((localOp.removed == null) || (localOp.removed.size() <= 0)) {
            break label803;
          }
          j = 0;
          label637:
          if (j >= localOp.removed.size()) {
            break label803;
          }
          paramPrintWriter.print(str2);
          if (localOp.removed.size() == 1) {
            paramPrintWriter.print("Removed: ");
          }
          break;
        }
        for (;;)
        {
          paramPrintWriter.println(localOp.removed.get(j));
          j += 1;
          break label637;
          str1 = "NULL";
          break;
          str1 = "ADD";
          break;
          str1 = "REPLACE";
          break;
          str1 = "REMOVE";
          break;
          str1 = "HIDE";
          break;
          str1 = "SHOW";
          break;
          str1 = "DETACH";
          break;
          str1 = "ATTACH";
          break;
          if (j == 0) {
            paramPrintWriter.println("Removed:");
          }
          paramPrintWriter.print(str2);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(j);
          paramPrintWriter.print(": ");
        }
        label803:
        localOp = localOp.next;
        i += 1;
      }
    }
  }
  
  public CharSequence getBreadCrumbShortTitle()
  {
    if (this.mBreadCrumbShortTitleRes != 0) {
      return this.mManager.mActivity.getText(this.mBreadCrumbShortTitleRes);
    }
    return this.mBreadCrumbShortTitleText;
  }
  
  public int getBreadCrumbShortTitleRes()
  {
    return this.mBreadCrumbShortTitleRes;
  }
  
  public CharSequence getBreadCrumbTitle()
  {
    if (this.mBreadCrumbTitleRes != 0) {
      return this.mManager.mActivity.getText(this.mBreadCrumbTitleRes);
    }
    return this.mBreadCrumbTitleText;
  }
  
  public int getBreadCrumbTitleRes()
  {
    return this.mBreadCrumbTitleRes;
  }
  
  public int getId()
  {
    return this.mIndex;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getTransition()
  {
    return this.mTransition;
  }
  
  public int getTransitionStyle()
  {
    return this.mTransitionStyle;
  }
  
  public FragmentTransaction hide(Fragment paramFragment)
  {
    BackStackRecord.Op localOp = new BackStackRecord.Op();
    localOp.cmd = 4;
    localOp.fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  public boolean isAddToBackStackAllowed()
  {
    return this.mAllowAddToBackStack;
  }
  
  public boolean isEmpty()
  {
    return this.mNumOp == 0;
  }
  
  public void popFromBackStack(boolean paramBoolean)
  {
    bumpBackStackNesting(-1);
    BackStackRecord.Op localOp = this.mTail;
    if (localOp != null)
    {
      Fragment localFragment;
      switch (localOp.cmd)
      {
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + localOp.cmd);
      case 1: 
        localFragment = localOp.fragment;
        localFragment.mNextAnim = localOp.popExitAnim;
        this.mManager.removeFragment(localFragment, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
      }
      for (;;)
      {
        localOp = localOp.prev;
        break;
        localFragment = localOp.fragment;
        if (localFragment != null)
        {
          localFragment.mNextAnim = localOp.popExitAnim;
          this.mManager.removeFragment(localFragment, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
        }
        if (localOp.removed != null)
        {
          int i = 0;
          while (i < localOp.removed.size())
          {
            localFragment = (Fragment)localOp.removed.get(i);
            localFragment.mNextAnim = localOp.popEnterAnim;
            this.mManager.addFragment(localFragment, false);
            i += 1;
          }
          localFragment = localOp.fragment;
          localFragment.mNextAnim = localOp.popEnterAnim;
          this.mManager.addFragment(localFragment, false);
          continue;
          localFragment = localOp.fragment;
          localFragment.mNextAnim = localOp.popEnterAnim;
          this.mManager.showFragment(localFragment, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
          continue;
          localFragment = localOp.fragment;
          localFragment.mNextAnim = localOp.popExitAnim;
          this.mManager.hideFragment(localFragment, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
          continue;
          localFragment = localOp.fragment;
          localFragment.mNextAnim = localOp.popEnterAnim;
          this.mManager.attachFragment(localFragment, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
          continue;
          localFragment = localOp.fragment;
          localFragment.mNextAnim = localOp.popEnterAnim;
          this.mManager.detachFragment(localFragment, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
        }
      }
    }
    if (paramBoolean) {
      this.mManager.moveToState(this.mManager.mCurState, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle, true);
    }
    if (this.mIndex >= 0)
    {
      this.mManager.freeBackStackIndex(this.mIndex);
      this.mIndex = -1;
    }
  }
  
  public FragmentTransaction remove(Fragment paramFragment)
  {
    BackStackRecord.Op localOp = new BackStackRecord.Op();
    localOp.cmd = 3;
    localOp.fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  public FragmentTransaction replace(int paramInt, Fragment paramFragment)
  {
    return replace(paramInt, paramFragment, null);
  }
  
  public FragmentTransaction replace(int paramInt, Fragment paramFragment, String paramString)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Must use non-zero containerViewId");
    }
    doAddOp(paramInt, paramFragment, paramString, 2);
    return this;
  }
  
  public void run()
  {
    if ((this.mAddToBackStack) && (this.mIndex < 0)) {
      throw new IllegalStateException("addToBackStack() called after commit()");
    }
    bumpBackStackNesting(1);
    BackStackRecord.Op localOp = this.mHead;
    while (localOp != null) {
      if (localOp.fragment == null)
      {
        localOp = localOp.next;
      }
      else
      {
        Object localObject1;
        switch (localOp.cmd)
        {
        default: 
          throw new IllegalArgumentException("Unknown cmd: " + localOp.cmd);
        case 1: 
          localObject1 = localOp.fragment;
          ((Fragment)localObject1).mNextAnim = localOp.enterAnim;
          this.mManager.addFragment((Fragment)localObject1, false);
        }
        for (;;)
        {
          localOp = localOp.next;
          break;
          localObject1 = localOp.fragment;
          Object localObject2;
          if (this.mManager.mAdded != null)
          {
            int i = 0;
            localObject2 = localObject1;
            if (i < this.mManager.mAdded.size())
            {
              Fragment localFragment = (Fragment)this.mManager.mAdded.get(i);
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                if (localFragment.mContainerId != ((Fragment)localObject1).mContainerId) {}
              }
              else
              {
                if (localFragment != localObject1) {
                  break label254;
                }
                localObject2 = null;
                localOp.fragment = null;
              }
              for (;;)
              {
                i += 1;
                localObject1 = localObject2;
                break;
                label254:
                if (localOp.removed == null) {
                  localOp.removed = new ArrayList();
                }
                localOp.removed.add(localFragment);
                localFragment.mNextAnim = localOp.exitAnim;
                if (this.mAddToBackStack) {
                  localFragment.mBackStackNesting += 1;
                }
                this.mManager.removeFragment(localFragment, this.mTransition, this.mTransitionStyle);
                localObject2 = localObject1;
              }
            }
          }
          else
          {
            localObject2 = localObject1;
          }
          if (localObject2 != null)
          {
            localObject2.mNextAnim = localOp.enterAnim;
            this.mManager.addFragment(localObject2, false);
            continue;
            localObject1 = localOp.fragment;
            ((Fragment)localObject1).mNextAnim = localOp.exitAnim;
            this.mManager.removeFragment((Fragment)localObject1, this.mTransition, this.mTransitionStyle);
            continue;
            localObject1 = localOp.fragment;
            ((Fragment)localObject1).mNextAnim = localOp.exitAnim;
            this.mManager.hideFragment((Fragment)localObject1, this.mTransition, this.mTransitionStyle);
            continue;
            localObject1 = localOp.fragment;
            ((Fragment)localObject1).mNextAnim = localOp.enterAnim;
            this.mManager.showFragment((Fragment)localObject1, this.mTransition, this.mTransitionStyle);
            continue;
            localObject1 = localOp.fragment;
            ((Fragment)localObject1).mNextAnim = localOp.exitAnim;
            this.mManager.detachFragment((Fragment)localObject1, this.mTransition, this.mTransitionStyle);
            continue;
            localObject1 = localOp.fragment;
            ((Fragment)localObject1).mNextAnim = localOp.enterAnim;
            this.mManager.attachFragment((Fragment)localObject1, this.mTransition, this.mTransitionStyle);
          }
        }
      }
    }
    this.mManager.moveToState(this.mManager.mCurState, this.mTransition, this.mTransitionStyle, true);
    if (this.mAddToBackStack) {
      this.mManager.addBackStackState(this);
    }
  }
  
  public FragmentTransaction setBreadCrumbShortTitle(int paramInt)
  {
    this.mBreadCrumbShortTitleRes = paramInt;
    this.mBreadCrumbShortTitleText = null;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbShortTitle(CharSequence paramCharSequence)
  {
    this.mBreadCrumbShortTitleRes = 0;
    this.mBreadCrumbShortTitleText = paramCharSequence;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbTitle(int paramInt)
  {
    this.mBreadCrumbTitleRes = paramInt;
    this.mBreadCrumbTitleText = null;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbTitle(CharSequence paramCharSequence)
  {
    this.mBreadCrumbTitleRes = 0;
    this.mBreadCrumbTitleText = paramCharSequence;
    return this;
  }
  
  public FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2)
  {
    return setCustomAnimations(paramInt1, paramInt2, 0, 0);
  }
  
  public FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mEnterAnim = paramInt1;
    this.mExitAnim = paramInt2;
    this.mPopEnterAnim = paramInt3;
    this.mPopExitAnim = paramInt4;
    return this;
  }
  
  public FragmentTransaction setTransition(int paramInt)
  {
    this.mTransition = paramInt;
    return this;
  }
  
  public FragmentTransaction setTransitionStyle(int paramInt)
  {
    this.mTransitionStyle = paramInt;
    return this;
  }
  
  public FragmentTransaction show(Fragment paramFragment)
  {
    BackStackRecord.Op localOp = new BackStackRecord.Op();
    localOp.cmd = 5;
    localOp.fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.mIndex >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.mIndex);
    }
    if (this.mName != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.mName);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.app.BackStackRecord
 * JD-Core Version:    0.7.0.1
 */