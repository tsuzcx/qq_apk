package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.tencent.qphone.base.util.QLog;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class FragmentManagerImpl
  extends FragmentManager
{
  static final Interpolator ACCELERATE_CUBIC;
  static final Interpolator ACCELERATE_QUINT;
  static final int ANIM_DUR = 220;
  public static final int ANIM_STYLE_CLOSE_ENTER = 3;
  public static final int ANIM_STYLE_CLOSE_EXIT = 4;
  public static final int ANIM_STYLE_FADE_ENTER = 5;
  public static final int ANIM_STYLE_FADE_EXIT = 6;
  public static final int ANIM_STYLE_OPEN_ENTER = 1;
  public static final int ANIM_STYLE_OPEN_EXIT = 2;
  static final boolean DEBUG = false;
  static final Interpolator DECELERATE_CUBIC;
  static final Interpolator DECELERATE_QUINT;
  static final boolean HONEYCOMB;
  static final String TAG = "FragmentManager";
  static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
  static final String TARGET_STATE_TAG = "android:target_state";
  static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
  static final String VIEW_STATE_TAG = "android:view_state";
  ArrayList mActive;
  FragmentActivity mActivity;
  ArrayList mAdded;
  ArrayList mAvailBackStackIndices;
  ArrayList mAvailIndices;
  ArrayList mBackStack;
  ArrayList mBackStackChangeListeners;
  ArrayList mBackStackIndices;
  FragmentContainer mContainer;
  ArrayList mCreatedMenus;
  int mCurState = 0;
  boolean mDestroyed;
  Runnable mExecCommit = new FragmentManagerImpl.1(this);
  boolean mExecutingActions;
  boolean mHavePendingDeferredStart;
  boolean mNeedMenuInvalidate;
  String mNoTransactionsBecause;
  Fragment mParent;
  ArrayList mPendingActions;
  SparseArray mStateArray = null;
  Bundle mStateBundle = null;
  boolean mStateSaved;
  Runnable[] mTmpActions;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (boolean bool = true;; bool = false)
    {
      HONEYCOMB = bool;
      DECELERATE_QUINT = new DecelerateInterpolator(2.5F);
      DECELERATE_CUBIC = new DecelerateInterpolator(1.5F);
      ACCELERATE_QUINT = new AccelerateInterpolator(2.5F);
      ACCELERATE_CUBIC = new AccelerateInterpolator(1.5F);
      return;
    }
  }
  
  private void checkStateLoss()
  {
    if (this.mStateSaved) {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
    if (this.mNoTransactionsBecause != null) {
      throw new IllegalStateException("Can not perform this action inside of " + this.mNoTransactionsBecause);
    }
  }
  
  static Animation makeFadeAnimation(Context paramContext, float paramFloat1, float paramFloat2)
  {
    paramContext = new AlphaAnimation(paramFloat1, paramFloat2);
    paramContext.setInterpolator(DECELERATE_CUBIC);
    paramContext.setDuration(220L);
    return paramContext;
  }
  
  static Animation makeOpenCloseAnimation(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramContext = new AnimationSet(false);
    Object localObject = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setInterpolator(DECELERATE_QUINT);
    ((ScaleAnimation)localObject).setDuration(220L);
    paramContext.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(paramFloat3, paramFloat4);
    ((AlphaAnimation)localObject).setInterpolator(DECELERATE_CUBIC);
    ((AlphaAnimation)localObject).setDuration(220L);
    paramContext.addAnimation((Animation)localObject);
    return paramContext;
  }
  
  public static int reverseTransit(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 4097: 
      return 8194;
    case 8194: 
      return 4097;
    }
    return 4099;
  }
  
  private void throwException(RuntimeException paramRuntimeException)
  {
    if (QLog.isDevelopLevel()) {
      QLog.e("FragmentManager", 4, paramRuntimeException.getMessage());
    }
    if (QLog.isDevelopLevel()) {
      QLog.e("FragmentManager", 4, "Activity state:");
    }
    PrintWriter localPrintWriter = new PrintWriter(new LogWriter("FragmentManager"));
    if (this.mActivity != null) {}
    for (;;)
    {
      try
      {
        this.mActivity.dump("  ", null, localPrintWriter, new String[0]);
        throw paramRuntimeException;
      }
      catch (Exception localException1)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.e("FragmentManager", 4, "Failed dumping state", localException1);
        continue;
      }
      try
      {
        dump("  ", null, localException1, new String[0]);
      }
      catch (Exception localException2) {}
      if (QLog.isDevelopLevel()) {
        QLog.e("FragmentManager", 4, "Failed dumping state", localException2);
      }
    }
  }
  
  public static int transitToStyleIndex(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 4097: 
      if (paramBoolean) {
        return 1;
      }
      return 2;
    case 8194: 
      if (paramBoolean) {
        return 3;
      }
      return 4;
    }
    if (paramBoolean) {
      return 5;
    }
    return 6;
  }
  
  void addBackStackState(BackStackRecord paramBackStackRecord)
  {
    if (this.mBackStack == null) {
      this.mBackStack = new ArrayList();
    }
    this.mBackStack.add(paramBackStackRecord);
    reportBackStackChanged();
  }
  
  public void addFragment(Fragment paramFragment, boolean paramBoolean)
  {
    if (this.mAdded == null) {
      this.mAdded = new ArrayList();
    }
    makeActive(paramFragment);
    if (!paramFragment.mDetached)
    {
      if (this.mAdded.contains(paramFragment)) {
        throw new IllegalStateException("Fragment already added: " + paramFragment);
      }
      this.mAdded.add(paramFragment);
      paramFragment.mAdded = true;
      paramFragment.mRemoving = false;
      if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      if (paramBoolean) {
        moveToState(paramFragment);
      }
    }
  }
  
  public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    if (this.mBackStackChangeListeners == null) {
      this.mBackStackChangeListeners = new ArrayList();
    }
    this.mBackStackChangeListeners.add(paramOnBackStackChangedListener);
  }
  
  public int allocBackStackIndex(BackStackRecord paramBackStackRecord)
  {
    try
    {
      if ((this.mAvailBackStackIndices == null) || (this.mAvailBackStackIndices.size() <= 0))
      {
        if (this.mBackStackIndices == null) {
          this.mBackStackIndices = new ArrayList();
        }
        i = this.mBackStackIndices.size();
        this.mBackStackIndices.add(paramBackStackRecord);
        return i;
      }
      int i = ((Integer)this.mAvailBackStackIndices.remove(this.mAvailBackStackIndices.size() - 1)).intValue();
      this.mBackStackIndices.set(i, paramBackStackRecord);
      return i;
    }
    finally {}
  }
  
  public void attachActivity(FragmentActivity paramFragmentActivity, FragmentContainer paramFragmentContainer, Fragment paramFragment)
  {
    if (this.mActivity != null) {
      throw new IllegalStateException("Already attached");
    }
    this.mActivity = paramFragmentActivity;
    this.mContainer = paramFragmentContainer;
    this.mParent = paramFragment;
  }
  
  public void attachFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (paramFragment.mDetached)
    {
      paramFragment.mDetached = false;
      if (!paramFragment.mAdded)
      {
        if (this.mAdded == null) {
          this.mAdded = new ArrayList();
        }
        if (this.mAdded.contains(paramFragment)) {
          throw new IllegalStateException("Fragment already added: " + paramFragment);
        }
        this.mAdded.add(paramFragment);
        paramFragment.mAdded = true;
        if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
          this.mNeedMenuInvalidate = true;
        }
        moveToState(paramFragment, this.mCurState, paramInt1, paramInt2, false);
      }
    }
  }
  
  public FragmentTransaction beginTransaction()
  {
    return new BackStackRecord(this);
  }
  
  public void detachFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (!paramFragment.mDetached)
    {
      paramFragment.mDetached = true;
      if (paramFragment.mAdded)
      {
        if (this.mAdded != null) {
          this.mAdded.remove(paramFragment);
        }
        if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
          this.mNeedMenuInvalidate = true;
        }
        paramFragment.mAdded = false;
        moveToState(paramFragment, 1, paramInt1, paramInt2, false);
      }
    }
  }
  
  public void dispatchActivityCreated()
  {
    this.mStateSaved = false;
    moveToState(2, false);
  }
  
  public void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.mAdded != null)
    {
      int i = 0;
      while (i < this.mAdded.size())
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if (localFragment != null) {
          localFragment.performConfigurationChanged(paramConfiguration);
        }
        i += 1;
      }
    }
  }
  
  public boolean dispatchContextItemSelected(MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (this.mAdded != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < this.mAdded.size())
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if ((localFragment != null) && (localFragment.performContextItemSelected(paramMenuItem))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void dispatchCreate()
  {
    this.mStateSaved = false;
    moveToState(1, false);
  }
  
  public boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    int j = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    if (this.mAdded != null)
    {
      i = 0;
      boolean bool1 = false;
      for (;;)
      {
        localObject2 = localObject1;
        bool2 = bool1;
        if (i >= this.mAdded.size()) {
          break;
        }
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        localObject2 = localObject1;
        bool2 = bool1;
        if (localFragment != null)
        {
          localObject2 = localObject1;
          bool2 = bool1;
          if (localFragment.performCreateOptionsMenu(paramMenu, paramMenuInflater))
          {
            bool2 = true;
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localFragment);
          }
        }
        i += 1;
        bool1 = bool2;
        localObject1 = localObject2;
      }
    }
    boolean bool2 = false;
    if (this.mCreatedMenus != null)
    {
      i = j;
      while (i < this.mCreatedMenus.size())
      {
        paramMenu = (Fragment)this.mCreatedMenus.get(i);
        if ((localObject2 == null) || (!((ArrayList)localObject2).contains(paramMenu))) {
          paramMenu.onDestroyOptionsMenu();
        }
        i += 1;
      }
    }
    this.mCreatedMenus = ((ArrayList)localObject2);
    return bool2;
  }
  
  public void dispatchDestroy()
  {
    this.mDestroyed = true;
    execPendingActions();
    moveToState(0, false);
    this.mActivity = null;
    this.mContainer = null;
    this.mParent = null;
  }
  
  public void dispatchDestroyView()
  {
    moveToState(1, false);
  }
  
  public void dispatchLowMemory()
  {
    if (this.mAdded != null)
    {
      int i = 0;
      while (i < this.mAdded.size())
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if (localFragment != null) {
          localFragment.performLowMemory();
        }
        i += 1;
      }
    }
  }
  
  public boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (this.mAdded != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < this.mAdded.size())
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if ((localFragment != null) && (localFragment.performOptionsItemSelected(paramMenuItem))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void dispatchOptionsMenuClosed(Menu paramMenu)
  {
    if (this.mAdded != null)
    {
      int i = 0;
      while (i < this.mAdded.size())
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if (localFragment != null) {
          localFragment.performOptionsMenuClosed(paramMenu);
        }
        i += 1;
      }
    }
  }
  
  public void dispatchPause()
  {
    moveToState(4, false);
  }
  
  public boolean dispatchPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.mAdded != null)
    {
      int i = 0;
      for (boolean bool1 = false;; bool1 = bool2)
      {
        bool2 = bool1;
        if (i >= this.mAdded.size()) {
          break;
        }
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        bool2 = bool1;
        if (localFragment != null)
        {
          bool2 = bool1;
          if (localFragment.performPrepareOptionsMenu(paramMenu)) {
            bool2 = true;
          }
        }
        i += 1;
      }
    }
    boolean bool2 = false;
    return bool2;
  }
  
  public void dispatchReallyStop()
  {
    moveToState(2, false);
  }
  
  public void dispatchResume()
  {
    this.mStateSaved = false;
    moveToState(5, false);
  }
  
  public void dispatchStart()
  {
    this.mStateSaved = false;
    moveToState(4, false);
  }
  
  public void dispatchStop()
  {
    this.mStateSaved = true;
    moveToState(3, false);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    String str = paramString + "    ";
    int k;
    int i;
    Object localObject;
    if (this.mActive != null)
    {
      k = this.mActive.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments in ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(":");
        i = 0;
        while (i < k)
        {
          localObject = (Fragment)this.mActive.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localObject);
          if (localObject != null) {
            ((Fragment)localObject).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          }
          i += 1;
        }
      }
    }
    if (this.mAdded != null)
    {
      k = this.mAdded.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Added Fragments:");
        i = 0;
        while (i < k)
        {
          localObject = (Fragment)this.mAdded.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(((Fragment)localObject).toString());
          i += 1;
        }
      }
    }
    if (this.mCreatedMenus != null)
    {
      k = this.mCreatedMenus.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        i = 0;
        while (i < k)
        {
          localObject = (Fragment)this.mCreatedMenus.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(((Fragment)localObject).toString());
          i += 1;
        }
      }
    }
    if (this.mBackStack != null)
    {
      k = this.mBackStack.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        i = 0;
        while (i < k)
        {
          localObject = (BackStackRecord)this.mBackStack.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(((BackStackRecord)localObject).toString());
          ((BackStackRecord)localObject).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          i += 1;
        }
      }
    }
    try
    {
      if (this.mBackStackIndices != null)
      {
        k = this.mBackStackIndices.size();
        if (k > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Back Stack Indices:");
          i = 0;
          while (i < k)
          {
            paramFileDescriptor = (BackStackRecord)this.mBackStackIndices.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i += 1;
          }
        }
      }
      if ((this.mAvailBackStackIndices != null) && (this.mAvailBackStackIndices.size() > 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mAvailBackStackIndices: ");
        paramPrintWriter.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));
      }
      if (this.mPendingActions != null)
      {
        k = this.mPendingActions.size();
        if (k > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Pending Actions:");
          i = j;
          while (i < k)
          {
            paramFileDescriptor = (Runnable)this.mPendingActions.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i += 1;
          }
        }
      }
      paramPrintWriter.print(paramString);
    }
    finally {}
    paramPrintWriter.println("FragmentManager misc state:");
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mActivity=");
    paramPrintWriter.println(this.mActivity);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mContainer=");
    paramPrintWriter.println(this.mContainer);
    if (this.mParent != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mParent=");
      paramPrintWriter.println(this.mParent);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mCurState=");
    paramPrintWriter.print(this.mCurState);
    paramPrintWriter.print(" mStateSaved=");
    paramPrintWriter.print(this.mStateSaved);
    paramPrintWriter.print(" mDestroyed=");
    paramPrintWriter.println(this.mDestroyed);
    if (this.mNeedMenuInvalidate)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNeedMenuInvalidate=");
      paramPrintWriter.println(this.mNeedMenuInvalidate);
    }
    if (this.mNoTransactionsBecause != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNoTransactionsBecause=");
      paramPrintWriter.println(this.mNoTransactionsBecause);
    }
    if ((this.mAvailIndices != null) && (this.mAvailIndices.size() > 0))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mAvailIndices: ");
      paramPrintWriter.println(Arrays.toString(this.mAvailIndices.toArray()));
    }
  }
  
  /* Error */
  public void enqueueAction(Runnable paramRunnable, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifne +7 -> 8
    //   4: aload_0
    //   5: invokespecial 481	android/support/v4/app/FragmentManagerImpl:checkStateLoss	()V
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 361	android/support/v4/app/FragmentManagerImpl:mDestroyed	Z
    //   14: ifne +10 -> 24
    //   17: aload_0
    //   18: getfield 213	android/support/v4/app/FragmentManagerImpl:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   21: ifnonnull +19 -> 40
    //   24: new 124	java/lang/IllegalStateException
    //   27: dup
    //   28: ldc_w 483
    //   31: invokespecial 129	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   34: athrow
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    //   40: aload_0
    //   41: getfield 447	android/support/v4/app/FragmentManagerImpl:mPendingActions	Ljava/util/ArrayList;
    //   44: ifnonnull +14 -> 58
    //   47: aload_0
    //   48: new 237	java/util/ArrayList
    //   51: dup
    //   52: invokespecial 238	java/util/ArrayList:<init>	()V
    //   55: putfield 447	android/support/v4/app/FragmentManagerImpl:mPendingActions	Ljava/util/ArrayList;
    //   58: aload_0
    //   59: getfield 447	android/support/v4/app/FragmentManagerImpl:mPendingActions	Ljava/util/ArrayList;
    //   62: aload_1
    //   63: invokevirtual 242	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   66: pop
    //   67: aload_0
    //   68: getfield 447	android/support/v4/app/FragmentManagerImpl:mPendingActions	Ljava/util/ArrayList;
    //   71: invokevirtual 294	java/util/ArrayList:size	()I
    //   74: iconst_1
    //   75: if_icmpne +32 -> 107
    //   78: aload_0
    //   79: getfield 213	android/support/v4/app/FragmentManagerImpl:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   82: getfield 487	android/support/v4/app/FragmentActivity:mHandler	Landroid/os/Handler;
    //   85: aload_0
    //   86: getfield 119	android/support/v4/app/FragmentManagerImpl:mExecCommit	Ljava/lang/Runnable;
    //   89: invokevirtual 493	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   92: aload_0
    //   93: getfield 213	android/support/v4/app/FragmentManagerImpl:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   96: getfield 487	android/support/v4/app/FragmentActivity:mHandler	Landroid/os/Handler;
    //   99: aload_0
    //   100: getfield 119	android/support/v4/app/FragmentManagerImpl:mExecCommit	Ljava/lang/Runnable;
    //   103: invokevirtual 497	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   106: pop
    //   107: aload_0
    //   108: monitorexit
    //   109: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	FragmentManagerImpl
    //   0	110	1	paramRunnable	Runnable
    //   0	110	2	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   10	24	35	finally
    //   24	35	35	finally
    //   36	38	35	finally
    //   40	58	35	finally
    //   58	107	35	finally
    //   107	109	35	finally
  }
  
  public boolean execPendingActions()
  {
    if (this.mExecutingActions) {
      throw new IllegalStateException("Recursive entry to executePendingTransactions");
    }
    if (Looper.myLooper() != this.mActivity.mHandler.getLooper()) {
      throw new IllegalStateException("Must be called from main thread of process");
    }
    int j;
    for (boolean bool = false;; bool = true) {
      try
      {
        if ((this.mPendingActions == null) || (this.mPendingActions.size() == 0))
        {
          if (!this.mHavePendingDeferredStart) {
            break label276;
          }
          i = 0;
          int m;
          for (j = 0; i < this.mActive.size(); j = m)
          {
            Fragment localFragment = (Fragment)this.mActive.get(i);
            int k = j;
            if (localFragment != null)
            {
              k = j;
              if (localFragment.mLoaderManager != null) {
                m = j | localFragment.mLoaderManager.hasRunningLoaders();
              }
            }
            i += 1;
          }
        }
        j = this.mPendingActions.size();
        if ((this.mTmpActions == null) || (this.mTmpActions.length < j)) {
          this.mTmpActions = new Runnable[j];
        }
        this.mPendingActions.toArray(this.mTmpActions);
        this.mPendingActions.clear();
        this.mActivity.mHandler.removeCallbacks(this.mExecCommit);
        this.mExecutingActions = true;
        int i = 0;
        while (i < j)
        {
          this.mTmpActions[i].run();
          this.mTmpActions[i] = null;
          i += 1;
        }
        this.mExecutingActions = false;
      }
      finally {}
    }
    if (j == 0)
    {
      this.mHavePendingDeferredStart = false;
      startPendingDeferredFragments();
    }
    label276:
    return bool;
  }
  
  public boolean executePendingTransactions()
  {
    return execPendingActions();
  }
  
  public Fragment findFragmentById(int paramInt)
  {
    int i;
    Object localObject;
    if (this.mAdded != null)
    {
      i = this.mAdded.size() - 1;
      while (i >= 0)
      {
        localObject = (Fragment)this.mAdded.get(i);
        if ((localObject != null) && (((Fragment)localObject).mFragmentId == paramInt)) {
          return localObject;
        }
        i -= 1;
      }
    }
    if (this.mActive != null)
    {
      i = this.mActive.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label112;
        }
        Fragment localFragment = (Fragment)this.mActive.get(i);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (localFragment.mFragmentId == paramInt) {
            break;
          }
        }
        i -= 1;
      }
    }
    label112:
    return null;
  }
  
  public Fragment findFragmentByTag(String paramString)
  {
    int i;
    Object localObject;
    if ((this.mAdded != null) && (paramString != null))
    {
      i = this.mAdded.size() - 1;
      while (i >= 0)
      {
        localObject = (Fragment)this.mAdded.get(i);
        if ((localObject != null) && (paramString.equals(((Fragment)localObject).mTag))) {
          return localObject;
        }
        i -= 1;
      }
    }
    if ((this.mActive != null) && (paramString != null))
    {
      i = this.mActive.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label126;
        }
        Fragment localFragment = (Fragment)this.mActive.get(i);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (paramString.equals(localFragment.mTag)) {
            break;
          }
        }
        i -= 1;
      }
    }
    label126:
    return null;
  }
  
  public Fragment findFragmentByWho(String paramString)
  {
    if ((this.mActive != null) && (paramString != null))
    {
      int i = this.mActive.size() - 1;
      while (i >= 0)
      {
        Fragment localFragment = (Fragment)this.mActive.get(i);
        if (localFragment != null)
        {
          localFragment = localFragment.findFragmentByWho(paramString);
          if (localFragment != null) {
            return localFragment;
          }
        }
        i -= 1;
      }
    }
    return null;
  }
  
  public void freeBackStackIndex(int paramInt)
  {
    try
    {
      this.mBackStackIndices.set(paramInt, null);
      if (this.mAvailBackStackIndices == null) {
        this.mAvailBackStackIndices = new ArrayList();
      }
      this.mAvailBackStackIndices.add(Integer.valueOf(paramInt));
      return;
    }
    finally {}
  }
  
  public FragmentManager.BackStackEntry getBackStackEntryAt(int paramInt)
  {
    return (FragmentManager.BackStackEntry)this.mBackStack.get(paramInt);
  }
  
  public int getBackStackEntryCount()
  {
    if (this.mBackStack != null) {
      return this.mBackStack.size();
    }
    return 0;
  }
  
  public Fragment getFragment(Bundle paramBundle, String paramString)
  {
    int i = paramBundle.getInt(paramString, -1);
    if (i == -1) {
      paramBundle = null;
    }
    Fragment localFragment;
    do
    {
      return paramBundle;
      if (i >= this.mActive.size()) {
        throwException(new IllegalStateException("Fragement no longer exists for key " + paramString + ": index " + i));
      }
      localFragment = (Fragment)this.mActive.get(i);
      paramBundle = localFragment;
    } while (localFragment != null);
    throwException(new IllegalStateException("Fragement no longer exists for key " + paramString + ": index " + i));
    return localFragment;
  }
  
  public List getFragments()
  {
    return this.mActive;
  }
  
  public void hideFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (!paramFragment.mHidden)
    {
      paramFragment.mHidden = true;
      if (paramFragment.mView != null)
      {
        Animation localAnimation = loadAnimation(paramFragment, paramInt1, false, paramInt2);
        if (localAnimation != null) {
          paramFragment.mView.startAnimation(localAnimation);
        }
        paramFragment.mView.setVisibility(8);
      }
      if ((paramFragment.mAdded) && (paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      paramFragment.onHiddenChanged(true);
    }
  }
  
  Animation loadAnimation(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Animation localAnimation = paramFragment.onCreateAnimation(paramInt1, paramBoolean, paramFragment.mNextAnim);
    if (localAnimation != null) {
      paramFragment = localAnimation;
    }
    do
    {
      return paramFragment;
      if (paramFragment.mNextAnim == 0) {
        break;
      }
      localAnimation = AnimationUtils.loadAnimation(this.mActivity, paramFragment.mNextAnim);
      paramFragment = localAnimation;
    } while (localAnimation != null);
    if (paramInt1 == 0) {
      return null;
    }
    paramInt1 = transitToStyleIndex(paramInt1, paramBoolean);
    if (paramInt1 < 0) {
      return null;
    }
    switch (paramInt1)
    {
    default: 
      paramInt1 = paramInt2;
      if (paramInt2 == 0)
      {
        paramInt1 = paramInt2;
        if (this.mActivity.getWindow() != null) {
          paramInt1 = this.mActivity.getWindow().getAttributes().windowAnimations;
        }
      }
      if (paramInt1 == 0) {
        return null;
      }
      break;
    case 1: 
      return makeOpenCloseAnimation(this.mActivity, 1.125F, 1.0F, 0.0F, 1.0F);
    case 2: 
      return makeOpenCloseAnimation(this.mActivity, 1.0F, 0.975F, 1.0F, 0.0F);
    case 3: 
      return makeOpenCloseAnimation(this.mActivity, 0.975F, 1.0F, 0.0F, 1.0F);
    case 4: 
      return makeOpenCloseAnimation(this.mActivity, 1.0F, 1.075F, 1.0F, 0.0F);
    case 5: 
      return makeFadeAnimation(this.mActivity, 0.0F, 1.0F);
    case 6: 
      return makeFadeAnimation(this.mActivity, 1.0F, 0.0F);
    }
    return null;
  }
  
  void makeActive(Fragment paramFragment)
  {
    if (paramFragment.mIndex >= 0) {
      return;
    }
    if ((this.mAvailIndices == null) || (this.mAvailIndices.size() <= 0))
    {
      if (this.mActive == null) {
        this.mActive = new ArrayList();
      }
      paramFragment.setIndex(this.mActive.size(), this.mParent);
      this.mActive.add(paramFragment);
      return;
    }
    paramFragment.setIndex(((Integer)this.mAvailIndices.remove(this.mAvailIndices.size() - 1)).intValue(), this.mParent);
    this.mActive.set(paramFragment.mIndex, paramFragment);
  }
  
  void makeInactive(Fragment paramFragment)
  {
    if (paramFragment.mIndex < 0) {
      return;
    }
    this.mActive.set(paramFragment.mIndex, null);
    if (this.mAvailIndices == null) {
      this.mAvailIndices = new ArrayList();
    }
    this.mAvailIndices.add(Integer.valueOf(paramFragment.mIndex));
    this.mActivity.invalidateSupportFragment(paramFragment.mWho);
    paramFragment.initState();
  }
  
  void moveToState(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((this.mActivity == null) && (paramInt1 != 0)) {
      throw new IllegalStateException("No activity");
    }
    if ((!paramBoolean) && (this.mCurState == paramInt1)) {}
    do
    {
      return;
      this.mCurState = paramInt1;
    } while (this.mActive == null);
    int i = 0;
    boolean bool = false;
    label54:
    if (i < this.mActive.size())
    {
      Fragment localFragment = (Fragment)this.mActive.get(i);
      if (localFragment == null) {
        break label169;
      }
      moveToState(localFragment, paramInt1, paramInt2, paramInt3, false);
      if (localFragment.mLoaderManager == null) {
        break label169;
      }
      bool |= localFragment.mLoaderManager.hasRunningLoaders();
    }
    label169:
    for (;;)
    {
      i += 1;
      break label54;
      if (!bool) {
        startPendingDeferredFragments();
      }
      if ((!this.mNeedMenuInvalidate) || (this.mActivity == null) || (this.mCurState != 5)) {
        break;
      }
      this.mActivity.supportInvalidateOptionsMenu();
      this.mNeedMenuInvalidate = false;
      return;
    }
  }
  
  void moveToState(int paramInt, boolean paramBoolean)
  {
    moveToState(paramInt, 0, 0, paramBoolean);
  }
  
  void moveToState(Fragment paramFragment)
  {
    moveToState(paramFragment, this.mCurState, 0, 0, false);
  }
  
  void moveToState(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i;
    if (paramFragment.mAdded)
    {
      i = paramInt1;
      if (!paramFragment.mDetached) {}
    }
    else
    {
      i = paramInt1;
      if (paramInt1 > 1) {
        i = 1;
      }
    }
    int j = i;
    if (paramFragment.mRemoving)
    {
      j = i;
      if (i > paramFragment.mState) {
        j = paramFragment.mState;
      }
    }
    paramInt1 = j;
    if (paramFragment.mDeferStart)
    {
      paramInt1 = j;
      if (paramFragment.mState < 4)
      {
        paramInt1 = j;
        if (j > 3) {
          paramInt1 = 3;
        }
      }
    }
    int k;
    label521:
    Object localObject2;
    if (paramFragment.mState < paramInt1)
    {
      if ((paramFragment.mFromLayout) && (!paramFragment.mInLayout)) {
        return;
      }
      if (paramFragment.mAnimatingAway != null)
      {
        paramFragment.mAnimatingAway = null;
        moveToState(paramFragment, paramFragment.mStateAfterAnimating, 0, 0, true);
      }
      i = paramInt1;
      k = paramInt1;
      j = paramInt1;
      switch (paramFragment.mState)
      {
      default: 
        i = paramInt1;
        paramFragment.mState = i;
        return;
      case 0: 
        j = paramInt1;
        if (paramFragment.mSavedFragmentState != null)
        {
          paramFragment.mSavedViewState = paramFragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
          paramFragment.mTarget = getFragment(paramFragment.mSavedFragmentState, "android:target_state");
          if (paramFragment.mTarget != null) {
            paramFragment.mTargetRequestCode = paramFragment.mSavedFragmentState.getInt("android:target_req_state", 0);
          }
          paramFragment.mUserVisibleHint = paramFragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
          j = paramInt1;
          if (!paramFragment.mUserVisibleHint)
          {
            paramFragment.mDeferStart = true;
            j = paramInt1;
            if (paramInt1 > 3) {
              j = 3;
            }
          }
        }
        paramFragment.mActivity = this.mActivity;
        paramFragment.mParentFragment = this.mParent;
        if (this.mParent != null) {}
        for (localObject1 = this.mParent.mChildFragmentManager;; localObject1 = this.mActivity.mFragments)
        {
          paramFragment.mFragmentManager = ((FragmentManagerImpl)localObject1);
          paramFragment.mCalled = false;
          paramFragment.onAttach(this.mActivity);
          if (paramFragment.mCalled) {
            break;
          }
          throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onAttach()");
        }
        if (paramFragment.mParentFragment == null) {
          this.mActivity.onAttachFragment(paramFragment);
        }
        if (!paramFragment.mRetaining) {
          paramFragment.performCreate(paramFragment.mSavedFragmentState);
        }
        paramFragment.mRetaining = false;
        i = j;
        if (paramFragment.mFromLayout)
        {
          paramFragment.mView = paramFragment.performCreateView(paramFragment.getLayoutInflater(paramFragment.mSavedFragmentState), null, paramFragment.mSavedFragmentState);
          if (paramFragment.mView == null) {
            break label861;
          }
          paramFragment.mInnerView = paramFragment.mView;
          paramFragment.mView = NoSaveStateFrameLayout.wrap(paramFragment.mView);
          if (paramFragment.mHidden) {
            paramFragment.mView.setVisibility(8);
          }
          paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
          i = j;
        }
      case 1: 
        k = i;
        if (i > 1) {
          if (!paramFragment.mFromLayout)
          {
            if (paramFragment.mContainerId == 0) {
              break label1282;
            }
            localObject2 = (ViewGroup)this.mContainer.findViewById(paramFragment.mContainerId);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              if (!paramFragment.mRestored) {
                throwException(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(paramFragment.mContainerId) + " (" + paramFragment.getResources().getResourceName(paramFragment.mContainerId) + ") for fragment " + paramFragment));
              }
            }
          }
        }
        break;
      }
    }
    label1282:
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      paramFragment.mContainer = ((ViewGroup)localObject1);
      paramFragment.mView = paramFragment.performCreateView(paramFragment.getLayoutInflater(paramFragment.mSavedFragmentState), (ViewGroup)localObject1, paramFragment.mSavedFragmentState);
      if (paramFragment.mView != null)
      {
        paramFragment.mInnerView = paramFragment.mView;
        paramFragment.mView = NoSaveStateFrameLayout.wrap(paramFragment.mView);
        if (localObject1 != null)
        {
          localObject2 = loadAnimation(paramFragment, paramInt2, true, paramInt3);
          if (localObject2 != null) {
            paramFragment.mView.startAnimation((Animation)localObject2);
          }
          ((ViewGroup)localObject1).addView(paramFragment.mView);
        }
        if (paramFragment.mHidden) {
          paramFragment.mView.setVisibility(8);
        }
        paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
      }
      for (;;)
      {
        paramFragment.performActivityCreated(paramFragment.mSavedFragmentState);
        if (paramFragment.mView != null) {
          paramFragment.restoreViewState(paramFragment.mSavedFragmentState);
        }
        paramFragment.mSavedFragmentState = null;
        k = i;
        j = k;
        if (k > 3)
        {
          paramFragment.performStart();
          j = k;
        }
        i = j;
        if (j <= 4) {
          break;
        }
        paramFragment.mResumed = true;
        paramFragment.performResume();
        paramFragment.mSavedFragmentState = null;
        paramFragment.mSavedViewState = null;
        i = j;
        break;
        label861:
        paramFragment.mInnerView = null;
        i = j;
        break label521;
        paramFragment.mInnerView = null;
      }
      i = paramInt1;
      if (paramFragment.mState <= paramInt1) {
        break;
      }
      switch (paramFragment.mState)
      {
      default: 
        i = paramInt1;
        break;
      case 1: 
      case 5: 
      case 4: 
      case 3: 
      case 2: 
        label938:
        do
        {
          i = paramInt1;
          if (paramInt1 >= 1) {
            break;
          }
          if ((this.mDestroyed) && (paramFragment.mAnimatingAway != null))
          {
            localObject1 = paramFragment.mAnimatingAway;
            paramFragment.mAnimatingAway = null;
            ((View)localObject1).clearAnimation();
          }
          if (paramFragment.mAnimatingAway == null) {
            break label1173;
          }
          paramFragment.mStateAfterAnimating = paramInt1;
          i = 1;
          break;
          if (paramInt1 < 5)
          {
            paramFragment.performPause();
            paramFragment.mResumed = false;
          }
          if (paramInt1 < 4) {
            paramFragment.performStop();
          }
          if (paramInt1 < 3) {
            paramFragment.performReallyStop();
          }
        } while (paramInt1 >= 2);
        if ((paramFragment.mView != null) && (!this.mActivity.isFinishing()) && (paramFragment.mSavedViewState == null)) {
          saveFragmentViewState(paramFragment);
        }
        paramFragment.performDestroyView();
        if ((paramFragment.mView != null) && (paramFragment.mContainer != null)) {
          if ((this.mCurState <= 0) || (this.mDestroyed)) {
            break label1276;
          }
        }
        label1173:
        label1276:
        for (localObject1 = loadAnimation(paramFragment, paramInt2, false, paramInt3);; localObject1 = null)
        {
          if (localObject1 != null)
          {
            paramFragment.mAnimatingAway = paramFragment.mView;
            paramFragment.mStateAfterAnimating = paramInt1;
            ((Animation)localObject1).setAnimationListener(new FragmentManagerImpl.5(this, paramFragment));
            paramFragment.mView.startAnimation((Animation)localObject1);
          }
          paramFragment.mContainer.removeView(paramFragment.mView);
          paramFragment.mContainer = null;
          paramFragment.mView = null;
          paramFragment.mInnerView = null;
          break label938;
          if (!paramFragment.mRetaining) {
            paramFragment.performDestroy();
          }
          paramFragment.mCalled = false;
          paramFragment.onDetach();
          if (!paramFragment.mCalled) {
            throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onDetach()");
          }
          i = paramInt1;
          if (paramBoolean) {
            break;
          }
          if (!paramFragment.mRetaining)
          {
            makeInactive(paramFragment);
            i = paramInt1;
            break;
          }
          paramFragment.mActivity = null;
          paramFragment.mFragmentManager = null;
          i = paramInt1;
          break;
        }
      }
    }
  }
  
  public void noteStateNotSaved()
  {
    this.mStateSaved = false;
  }
  
  public void performPendingDeferredStart(Fragment paramFragment)
  {
    if (paramFragment.mDeferStart)
    {
      if (this.mExecutingActions) {
        this.mHavePendingDeferredStart = true;
      }
    }
    else {
      return;
    }
    paramFragment.mDeferStart = false;
    moveToState(paramFragment, this.mCurState, 0, 0, false);
  }
  
  public void popBackStack()
  {
    enqueueAction(new FragmentManagerImpl.2(this), false);
  }
  
  public void popBackStack(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt1);
    }
    enqueueAction(new FragmentManagerImpl.4(this, paramInt1, paramInt2), false);
  }
  
  public void popBackStack(String paramString, int paramInt)
  {
    enqueueAction(new FragmentManagerImpl.3(this, paramString, paramInt), false);
  }
  
  public boolean popBackStackImmediate()
  {
    checkStateLoss();
    executePendingTransactions();
    return popBackStackState(this.mActivity.mHandler, null, -1, 0);
  }
  
  public boolean popBackStackImmediate(int paramInt1, int paramInt2)
  {
    checkStateLoss();
    executePendingTransactions();
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt1);
    }
    return popBackStackState(this.mActivity.mHandler, null, paramInt1, paramInt2);
  }
  
  public boolean popBackStackImmediate(String paramString, int paramInt)
  {
    checkStateLoss();
    executePendingTransactions();
    return popBackStackState(this.mActivity.mHandler, paramString, -1, paramInt);
  }
  
  boolean popBackStackState(Handler paramHandler, String paramString, int paramInt1, int paramInt2)
  {
    if (this.mBackStack == null) {
      break label114;
    }
    label7:
    do
    {
      return false;
      if ((paramString != null) || (paramInt1 >= 0) || ((paramInt2 & 0x1) != 0)) {
        break;
      }
      paramInt1 = this.mBackStack.size() - 1;
    } while (paramInt1 < 0);
    ((BackStackRecord)this.mBackStack.remove(paramInt1)).popFromBackStack(true);
    reportBackStackChanged();
    for (;;)
    {
      return true;
      int i = -1;
      if ((paramString != null) || (paramInt1 >= 0))
      {
        int j = this.mBackStack.size() - 1;
        for (;;)
        {
          if (j >= 0)
          {
            paramHandler = (BackStackRecord)this.mBackStack.get(j);
            if ((paramString == null) || (!paramString.equals(paramHandler.getName()))) {}
          }
          else
          {
            label114:
            if (j < 0) {
              break label7;
            }
            i = j;
            if ((paramInt2 & 0x1) == 0) {
              break label223;
            }
            paramInt2 = j - 1;
            for (;;)
            {
              i = paramInt2;
              if (paramInt2 < 0) {
                break;
              }
              paramHandler = (BackStackRecord)this.mBackStack.get(paramInt2);
              if ((paramString == null) || (!paramString.equals(paramHandler.getName())))
              {
                i = paramInt2;
                if (paramInt1 < 0) {
                  break;
                }
                i = paramInt2;
                if (paramInt1 != paramHandler.mIndex) {
                  break;
                }
              }
              paramInt2 -= 1;
            }
          }
          if ((paramInt1 >= 0) && (paramInt1 == paramHandler.mIndex)) {
            break;
          }
          j -= 1;
        }
      }
      label223:
      if (i == this.mBackStack.size() - 1) {
        break label7;
      }
      paramHandler = new ArrayList();
      paramInt1 = this.mBackStack.size() - 1;
      while (paramInt1 > i)
      {
        paramHandler.add(this.mBackStack.remove(paramInt1));
        paramInt1 -= 1;
      }
      paramInt2 = paramHandler.size() - 1;
      paramInt1 = 0;
      if (paramInt1 <= paramInt2)
      {
        paramString = (BackStackRecord)paramHandler.get(paramInt1);
        if (paramInt1 == paramInt2) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.popFromBackStack(bool);
          paramInt1 += 1;
          break;
        }
      }
      reportBackStackChanged();
    }
  }
  
  public void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    if (paramFragment.mIndex < 0) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    paramBundle.putInt(paramString, paramFragment.mIndex);
  }
  
  public void removeFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (!paramFragment.isInBackStack())
    {
      i = 1;
      if ((!paramFragment.mDetached) || (i != 0))
      {
        if (this.mAdded != null) {
          this.mAdded.remove(paramFragment);
        }
        if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
          this.mNeedMenuInvalidate = true;
        }
        paramFragment.mAdded = false;
        paramFragment.mRemoving = true;
        if (i == 0) {
          break label92;
        }
      }
    }
    label92:
    for (int i = 0;; i = 1)
    {
      moveToState(paramFragment, i, paramInt1, paramInt2, false);
      return;
      i = 0;
      break;
    }
  }
  
  public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    if (this.mBackStackChangeListeners != null) {
      this.mBackStackChangeListeners.remove(paramOnBackStackChangedListener);
    }
  }
  
  void reportBackStackChanged()
  {
    if (this.mBackStackChangeListeners != null)
    {
      int i = 0;
      while (i < this.mBackStackChangeListeners.size())
      {
        ((FragmentManager.OnBackStackChangedListener)this.mBackStackChangeListeners.get(i)).onBackStackChanged();
        i += 1;
      }
    }
  }
  
  void restoreAllState(Parcelable paramParcelable, ArrayList paramArrayList)
  {
    int j = 0;
    if (paramParcelable == null) {}
    for (;;)
    {
      return;
      paramParcelable = (FragmentManagerState)paramParcelable;
      if (paramParcelable.mActive != null)
      {
        int i = 0;
        Object localObject1;
        for (;;)
        {
          if (i >= paramParcelable.mActive.length) {
            break label75;
          }
          localObject1 = paramParcelable.mActive[i];
          if (localObject1 != null)
          {
            localObject1 = ((FragmentState)localObject1).mArguments;
            if ((localObject1 != null) && (!((Bundle)localObject1).getBoolean("should_restore_from_kill", true))) {
              break;
            }
          }
          i += 1;
        }
        label75:
        Object localObject2;
        if (paramArrayList != null)
        {
          i = 0;
          while (i < paramArrayList.size())
          {
            localObject1 = (Fragment)paramArrayList.get(i);
            localObject2 = paramParcelable.mActive[localObject1.mIndex];
            ((FragmentState)localObject2).mInstance = ((Fragment)localObject1);
            ((Fragment)localObject1).mSavedViewState = null;
            ((Fragment)localObject1).mBackStackNesting = 0;
            ((Fragment)localObject1).mInLayout = false;
            ((Fragment)localObject1).mAdded = false;
            ((Fragment)localObject1).mTarget = null;
            if (((FragmentState)localObject2).mSavedFragmentState != null)
            {
              ((FragmentState)localObject2).mSavedFragmentState.setClassLoader(this.mActivity.getClassLoader());
              ((Fragment)localObject1).mSavedViewState = ((FragmentState)localObject2).mSavedFragmentState.getSparseParcelableArray("android:view_state");
            }
            i += 1;
          }
        }
        this.mActive = new ArrayList(paramParcelable.mActive.length);
        if (this.mAvailIndices != null) {
          this.mAvailIndices.clear();
        }
        i = 0;
        if (i < paramParcelable.mActive.length)
        {
          localObject1 = paramParcelable.mActive[i];
          if (localObject1 != null)
          {
            localObject2 = ((FragmentState)localObject1).instantiate(this.mActivity, this.mParent);
            this.mActive.add(localObject2);
            ((FragmentState)localObject1).mInstance = null;
          }
          for (;;)
          {
            i += 1;
            break;
            this.mActive.add(null);
            if (this.mAvailIndices == null) {
              this.mAvailIndices = new ArrayList();
            }
            this.mAvailIndices.add(Integer.valueOf(i));
          }
        }
        if (paramArrayList != null)
        {
          i = 0;
          if (i < paramArrayList.size())
          {
            localObject1 = (Fragment)paramArrayList.get(i);
            if (((Fragment)localObject1).mTargetIndex >= 0) {
              if (((Fragment)localObject1).mTargetIndex >= this.mActive.size()) {
                break label401;
              }
            }
            for (((Fragment)localObject1).mTarget = ((Fragment)this.mActive.get(((Fragment)localObject1).mTargetIndex));; ((Fragment)localObject1).mTarget = null)
            {
              i += 1;
              break;
              label401:
              if (QLog.isDevelopLevel()) {
                QLog.w("FragmentManager", 4, "Re-attaching retained fragment " + localObject1 + " target no longer exists: " + ((Fragment)localObject1).mTargetIndex);
              }
            }
          }
        }
        if (paramParcelable.mAdded != null)
        {
          this.mAdded = new ArrayList(paramParcelable.mAdded.length);
          i = 0;
          while (i < paramParcelable.mAdded.length)
          {
            paramArrayList = (Fragment)this.mActive.get(paramParcelable.mAdded[i]);
            if (paramArrayList == null) {
              throwException(new IllegalStateException("No instantiated fragment for index #" + paramParcelable.mAdded[i]));
            }
            paramArrayList.mAdded = true;
            if (this.mAdded.contains(paramArrayList)) {
              throw new IllegalStateException("Already added!");
            }
            this.mAdded.add(paramArrayList);
            i += 1;
          }
        }
        this.mAdded = null;
        if (paramParcelable.mBackStack == null) {
          break;
        }
        this.mBackStack = new ArrayList(paramParcelable.mBackStack.length);
        i = j;
        while (i < paramParcelable.mBackStack.length)
        {
          paramArrayList = paramParcelable.mBackStack[i].instantiate(this);
          this.mBackStack.add(paramArrayList);
          if (paramArrayList.mIndex >= 0) {
            setBackStackIndex(paramArrayList.mIndex, paramArrayList);
          }
          i += 1;
        }
      }
    }
    this.mBackStack = null;
  }
  
  ArrayList retainNonConfig()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.mActive != null)
    {
      int i = 0;
      localObject2 = localObject1;
      if (i < this.mActive.size())
      {
        Fragment localFragment = (Fragment)this.mActive.get(i);
        localObject2 = localObject1;
        if (localFragment != null)
        {
          localObject2 = localObject1;
          if (localFragment.mRetainInstance)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localFragment);
            localFragment.mRetaining = true;
            if (localFragment.mTarget == null) {
              break label123;
            }
          }
        }
        label123:
        for (int j = localFragment.mTarget.mIndex;; j = -1)
        {
          localFragment.mTargetIndex = j;
          i += 1;
          localObject1 = localObject2;
          break;
        }
      }
    }
    return localObject2;
  }
  
  Parcelable saveAllState()
  {
    Object localObject3 = null;
    execPendingActions();
    if (HONEYCOMB) {
      this.mStateSaved = true;
    }
    if ((this.mActive == null) || (this.mActive.size() <= 0)) {
      return null;
    }
    int k = this.mActive.size();
    FragmentState[] arrayOfFragmentState = new FragmentState[k];
    int j = 0;
    int i = 0;
    label56:
    Object localObject1;
    Object localObject2;
    if (j < k)
    {
      localObject1 = (Fragment)this.mActive.get(j);
      if (localObject1 == null) {
        break label557;
      }
      if (((Fragment)localObject1).mIndex < 0) {
        throwException(new IllegalStateException("Failure saving state: active " + localObject1 + " has cleared index: " + ((Fragment)localObject1).mIndex));
      }
      localObject2 = new FragmentState((Fragment)localObject1);
      arrayOfFragmentState[j] = localObject2;
      if ((((Fragment)localObject1).mState > 0) && (((FragmentState)localObject2).mSavedFragmentState == null))
      {
        ((FragmentState)localObject2).mSavedFragmentState = saveFragmentBasicState((Fragment)localObject1);
        if (((Fragment)localObject1).mTarget == null) {
          break label320;
        }
        if (((Fragment)localObject1).mTarget.mIndex < 0) {
          throwException(new IllegalStateException("Failure saving state: " + localObject1 + " has target not in fragment manager: " + ((Fragment)localObject1).mTarget));
        }
        if (((FragmentState)localObject2).mSavedFragmentState == null) {
          ((FragmentState)localObject2).mSavedFragmentState = new Bundle();
        }
        putFragment(((FragmentState)localObject2).mSavedFragmentState, "android:target_state", ((Fragment)localObject1).mTarget);
        if (((Fragment)localObject1).mTargetRequestCode == 0) {
          break label320;
        }
        ((FragmentState)localObject2).mSavedFragmentState.putInt("android:target_req_state", ((Fragment)localObject1).mTargetRequestCode);
        i = 1;
      }
    }
    label557:
    for (;;)
    {
      j += 1;
      break label56;
      ((FragmentState)localObject2).mSavedFragmentState = ((Fragment)localObject1).mSavedFragmentState;
      label320:
      i = 1;
      continue;
      if (i == 0) {
        break;
      }
      if (this.mAdded != null)
      {
        j = this.mAdded.size();
        if (j > 0)
        {
          localObject2 = new int[j];
          i = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (i >= j) {
              break;
            }
            localObject2[i] = ((Fragment)this.mAdded.get(i)).mIndex;
            if (localObject2[i] < 0) {
              throwException(new IllegalStateException("Failure saving state: active " + this.mAdded.get(i) + " has cleared index: " + localObject2[i]));
            }
            i += 1;
          }
        }
      }
      localObject1 = null;
      localObject2 = localObject3;
      if (this.mBackStack != null)
      {
        j = this.mBackStack.size();
        localObject2 = localObject3;
        if (j > 0)
        {
          localObject3 = new BackStackState[j];
          i = 0;
          for (;;)
          {
            localObject2 = localObject3;
            if (i >= j) {
              break;
            }
            localObject3[i] = new BackStackState(this, (BackStackRecord)this.mBackStack.get(i));
            i += 1;
          }
        }
      }
      localObject3 = new FragmentManagerState();
      ((FragmentManagerState)localObject3).mActive = arrayOfFragmentState;
      ((FragmentManagerState)localObject3).mAdded = ((int[])localObject1);
      ((FragmentManagerState)localObject3).mBackStack = ((BackStackState[])localObject2);
      return localObject3;
    }
  }
  
  Bundle saveFragmentBasicState(Fragment paramFragment)
  {
    if (this.mStateBundle == null) {
      this.mStateBundle = new Bundle();
    }
    paramFragment.performSaveInstanceState(this.mStateBundle);
    Object localObject2;
    if (!this.mStateBundle.isEmpty())
    {
      localObject2 = this.mStateBundle;
      this.mStateBundle = null;
    }
    for (;;)
    {
      if (paramFragment.mView != null) {
        saveFragmentViewState(paramFragment);
      }
      Object localObject1 = localObject2;
      if (paramFragment.mSavedViewState != null)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new Bundle();
        }
        ((Bundle)localObject1).putSparseParcelableArray("android:view_state", paramFragment.mSavedViewState);
      }
      localObject2 = localObject1;
      if (!paramFragment.mUserVisibleHint)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Bundle();
        }
        ((Bundle)localObject2).putBoolean("android:user_visible_hint", paramFragment.mUserVisibleHint);
      }
      return localObject2;
      localObject2 = null;
    }
  }
  
  public Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment)
  {
    Object localObject2 = null;
    if (paramFragment.mIndex < 0) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    Object localObject1 = localObject2;
    if (paramFragment.mState > 0)
    {
      paramFragment = saveFragmentBasicState(paramFragment);
      localObject1 = localObject2;
      if (paramFragment != null) {
        localObject1 = new Fragment.SavedState(paramFragment);
      }
    }
    return localObject1;
  }
  
  void saveFragmentViewState(Fragment paramFragment)
  {
    if (paramFragment.mInnerView == null) {
      return;
    }
    if (this.mStateArray == null) {
      this.mStateArray = new SparseArray();
    }
    for (;;)
    {
      paramFragment.mInnerView.saveHierarchyState(this.mStateArray);
      if (this.mStateArray.size() <= 0) {
        break;
      }
      paramFragment.mSavedViewState = this.mStateArray;
      this.mStateArray = null;
      return;
      this.mStateArray.clear();
    }
  }
  
  /* Error */
  public void setBackStackIndex(int paramInt, BackStackRecord paramBackStackRecord)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 296	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 237	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 238	java/util/ArrayList:<init>	()V
    //   17: putfield 296	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   20: aload_0
    //   21: getfield 296	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   24: invokevirtual 294	java/util/ArrayList:size	()I
    //   27: istore 4
    //   29: iload 4
    //   31: istore_3
    //   32: iload_1
    //   33: iload 4
    //   35: if_icmpge +16 -> 51
    //   38: aload_0
    //   39: getfield 296	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   42: iload_1
    //   43: aload_2
    //   44: invokevirtual 309	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   47: pop
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: iload_3
    //   52: iload_1
    //   53: if_icmpge +49 -> 102
    //   56: aload_0
    //   57: getfield 296	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   60: aconst_null
    //   61: invokevirtual 242	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   64: pop
    //   65: aload_0
    //   66: getfield 290	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   69: ifnonnull +14 -> 83
    //   72: aload_0
    //   73: new 237	java/util/ArrayList
    //   76: dup
    //   77: invokespecial 238	java/util/ArrayList:<init>	()V
    //   80: putfield 290	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   83: aload_0
    //   84: getfield 290	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   87: iload_3
    //   88: invokestatic 559	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   91: invokevirtual 242	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   94: pop
    //   95: iload_3
    //   96: iconst_1
    //   97: iadd
    //   98: istore_3
    //   99: goto -48 -> 51
    //   102: aload_0
    //   103: getfield 296	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   106: aload_2
    //   107: invokevirtual 242	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   110: pop
    //   111: goto -63 -> 48
    //   114: astore_2
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	FragmentManagerImpl
    //   0	119	1	paramInt	int
    //   0	119	2	paramBackStackRecord	BackStackRecord
    //   31	68	3	i	int
    //   27	9	4	j	int
    // Exception table:
    //   from	to	target	type
    //   2	20	114	finally
    //   20	29	114	finally
    //   38	48	114	finally
    //   48	50	114	finally
    //   56	83	114	finally
    //   83	95	114	finally
    //   102	111	114	finally
    //   115	117	114	finally
  }
  
  public void showFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (paramFragment.mHidden)
    {
      paramFragment.mHidden = false;
      if (paramFragment.mView != null)
      {
        Animation localAnimation = loadAnimation(paramFragment, paramInt1, true, paramInt2);
        if (localAnimation != null) {
          paramFragment.mView.startAnimation(localAnimation);
        }
        paramFragment.mView.setVisibility(0);
      }
      if ((paramFragment.mAdded) && (paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      paramFragment.onHiddenChanged(false);
    }
  }
  
  void startPendingDeferredFragments()
  {
    if (this.mActive == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mActive.size())
      {
        Fragment localFragment = (Fragment)this.mActive.get(i);
        if (localFragment != null) {
          performPendingDeferredStart(localFragment);
        }
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    if (this.mParent != null) {
      DebugUtils.buildShortClassTag(this.mParent, localStringBuilder);
    }
    for (;;)
    {
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
      DebugUtils.buildShortClassTag(this.mActivity, localStringBuilder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl
 * JD-Core Version:    0.7.0.1
 */