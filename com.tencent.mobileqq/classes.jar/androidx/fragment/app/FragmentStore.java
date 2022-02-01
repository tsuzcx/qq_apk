package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class FragmentStore
{
  private static final String TAG = "FragmentManager";
  private final HashMap<String, FragmentStateManager> mActive = new HashMap();
  private final ArrayList<Fragment> mAdded = new ArrayList();
  
  void addFragment(@NonNull Fragment paramFragment)
  {
    if (this.mAdded.contains(paramFragment)) {
      throw new IllegalStateException("Fragment already added: " + paramFragment);
    }
    synchronized (this.mAdded)
    {
      this.mAdded.add(paramFragment);
      paramFragment.mAdded = true;
      return;
    }
  }
  
  void burpActive()
  {
    this.mActive.values().removeAll(Collections.singleton(null));
  }
  
  boolean containsActiveFragment(@NonNull String paramString)
  {
    return this.mActive.containsKey(paramString);
  }
  
  void dispatchStateChange(int paramInt)
  {
    Iterator localIterator = this.mAdded.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Fragment)localIterator.next();
      localObject = (FragmentStateManager)this.mActive.get(((Fragment)localObject).mWho);
      if (localObject != null) {
        ((FragmentStateManager)localObject).setFragmentManagerState(paramInt);
      }
    }
    localIterator = this.mActive.values().iterator();
    while (localIterator.hasNext())
    {
      localObject = (FragmentStateManager)localIterator.next();
      if (localObject != null) {
        ((FragmentStateManager)localObject).setFragmentManagerState(paramInt);
      }
    }
  }
  
  void dump(@NonNull String paramString, @Nullable FileDescriptor paramFileDescriptor, @NonNull PrintWriter paramPrintWriter, @Nullable String[] paramArrayOfString)
  {
    String str = paramString + "    ";
    if (!this.mActive.isEmpty())
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("Active Fragments:");
      Iterator localIterator = this.mActive.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (FragmentStateManager)localIterator.next();
        paramPrintWriter.print(paramString);
        if (localObject != null)
        {
          localObject = ((FragmentStateManager)localObject).getFragment();
          paramPrintWriter.println(localObject);
          ((Fragment)localObject).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }
        else
        {
          paramPrintWriter.println("null");
        }
      }
    }
    int j = this.mAdded.size();
    if (j > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Added Fragments:");
      int i = 0;
      while (i < j)
      {
        paramFileDescriptor = (Fragment)this.mAdded.get(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(i);
        paramPrintWriter.print(": ");
        paramPrintWriter.println(paramFileDescriptor.toString());
        i += 1;
      }
    }
  }
  
  @Nullable
  Fragment findActiveFragment(@NonNull String paramString)
  {
    paramString = (FragmentStateManager)this.mActive.get(paramString);
    if (paramString != null) {
      return paramString.getFragment();
    }
    return null;
  }
  
  @Nullable
  Fragment findFragmentById(@IdRes int paramInt)
  {
    int i = this.mAdded.size() - 1;
    while (i >= 0)
    {
      localObject1 = (Fragment)this.mAdded.get(i);
      if ((localObject1 != null) && (((Fragment)localObject1).mFragmentId == paramInt)) {
        return localObject1;
      }
      i -= 1;
    }
    Object localObject1 = this.mActive.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (FragmentStateManager)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = ((FragmentStateManager)localObject2).getFragment();
        if (((Fragment)localObject2).mFragmentId == paramInt) {
          return localObject2;
        }
      }
    }
    return null;
  }
  
  @Nullable
  Fragment findFragmentByTag(@Nullable String paramString)
  {
    Object localObject1;
    if (paramString != null)
    {
      int i = this.mAdded.size() - 1;
      while (i >= 0)
      {
        localObject1 = (Fragment)this.mAdded.get(i);
        if ((localObject1 != null) && (paramString.equals(((Fragment)localObject1).mTag))) {
          return localObject1;
        }
        i -= 1;
      }
    }
    if (paramString != null)
    {
      localObject1 = this.mActive.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (FragmentStateManager)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((FragmentStateManager)localObject2).getFragment();
          if (paramString.equals(((Fragment)localObject2).mTag)) {
            return localObject2;
          }
        }
      }
    }
    return null;
  }
  
  @Nullable
  Fragment findFragmentByWho(@NonNull String paramString)
  {
    Iterator localIterator = this.mActive.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (FragmentStateManager)localIterator.next();
      if (localObject != null)
      {
        localObject = ((FragmentStateManager)localObject).getFragment().findFragmentByWho(paramString);
        if (localObject != null) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  Fragment findFragmentUnder(@NonNull Fragment paramFragment)
  {
    ViewGroup localViewGroup = paramFragment.mContainer;
    Object localObject = paramFragment.mView;
    if ((localViewGroup == null) || (localObject == null))
    {
      paramFragment = null;
      return paramFragment;
    }
    int i = this.mAdded.indexOf(paramFragment) - 1;
    for (;;)
    {
      if (i < 0) {
        break label76;
      }
      localObject = (Fragment)this.mAdded.get(i);
      if (((Fragment)localObject).mContainer == localViewGroup)
      {
        paramFragment = (Fragment)localObject;
        if (((Fragment)localObject).mView != null) {
          break;
        }
      }
      i -= 1;
    }
    label76:
    return null;
  }
  
  int getActiveFragmentCount()
  {
    return this.mActive.size();
  }
  
  @NonNull
  List<Fragment> getActiveFragments()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mActive.values().iterator();
    while (localIterator.hasNext())
    {
      FragmentStateManager localFragmentStateManager = (FragmentStateManager)localIterator.next();
      if (localFragmentStateManager != null) {
        localArrayList.add(localFragmentStateManager.getFragment());
      } else {
        localArrayList.add(null);
      }
    }
    return localArrayList;
  }
  
  @Nullable
  FragmentStateManager getFragmentStateManager(@NonNull String paramString)
  {
    return (FragmentStateManager)this.mActive.get(paramString);
  }
  
  @NonNull
  List<Fragment> getFragments()
  {
    if (this.mAdded.isEmpty()) {
      return Collections.emptyList();
    }
    synchronized (this.mAdded)
    {
      ArrayList localArrayList2 = new ArrayList(this.mAdded);
      return localArrayList2;
    }
  }
  
  void makeActive(@NonNull FragmentStateManager paramFragmentStateManager)
  {
    this.mActive.put(paramFragmentStateManager.getFragment().mWho, paramFragmentStateManager);
  }
  
  void makeInactive(@NonNull FragmentStateManager paramFragmentStateManager)
  {
    paramFragmentStateManager = paramFragmentStateManager.getFragment();
    Iterator localIterator = this.mActive.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (FragmentStateManager)localIterator.next();
      if (localObject != null)
      {
        localObject = ((FragmentStateManager)localObject).getFragment();
        if (paramFragmentStateManager.mWho.equals(((Fragment)localObject).mTargetWho))
        {
          ((Fragment)localObject).mTarget = paramFragmentStateManager;
          ((Fragment)localObject).mTargetWho = null;
        }
      }
    }
    this.mActive.put(paramFragmentStateManager.mWho, null);
    if (paramFragmentStateManager.mTargetWho != null) {
      paramFragmentStateManager.mTarget = findActiveFragment(paramFragmentStateManager.mTargetWho);
    }
  }
  
  void removeFragment(@NonNull Fragment paramFragment)
  {
    synchronized (this.mAdded)
    {
      this.mAdded.remove(paramFragment);
      paramFragment.mAdded = false;
      return;
    }
  }
  
  void resetActiveFragments()
  {
    this.mActive.clear();
  }
  
  void restoreAddedFragments(@Nullable List<String> paramList)
  {
    this.mAdded.clear();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        Fragment localFragment = findActiveFragment(str);
        if (localFragment == null) {
          throw new IllegalStateException("No instantiated fragment for (" + str + ")");
        }
        if (FragmentManager.isLoggingEnabled(2)) {
          Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + localFragment);
        }
        addFragment(localFragment);
      }
    }
  }
  
  @NonNull
  ArrayList<FragmentState> saveActiveFragments()
  {
    ArrayList localArrayList = new ArrayList(this.mActive.size());
    Iterator localIterator = this.mActive.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (FragmentStateManager)localIterator.next();
      if (localObject != null)
      {
        Fragment localFragment = ((FragmentStateManager)localObject).getFragment();
        localObject = ((FragmentStateManager)localObject).saveState();
        localArrayList.add(localObject);
        if (FragmentManager.isLoggingEnabled(2)) {
          Log.v("FragmentManager", "Saved state of " + localFragment + ": " + ((FragmentState)localObject).mSavedFragmentState);
        }
      }
    }
    return localArrayList;
  }
  
  @Nullable
  ArrayList<String> saveAddedFragments()
  {
    synchronized (this.mAdded)
    {
      if (this.mAdded.isEmpty()) {
        return null;
      }
      ArrayList localArrayList2 = new ArrayList(this.mAdded.size());
      Iterator localIterator = this.mAdded.iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        localArrayList2.add(localFragment.mWho);
        if (FragmentManager.isLoggingEnabled(2)) {
          Log.v("FragmentManager", "saveAllState: adding fragment (" + localFragment.mWho + "): " + localFragment);
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.FragmentStore
 * JD-Core Version:    0.7.0.1
 */