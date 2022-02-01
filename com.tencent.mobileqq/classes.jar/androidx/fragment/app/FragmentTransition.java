package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class FragmentTransition
{
  private static final int[] INVERSE_OPS = { 0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10 };
  private static final FragmentTransitionImpl PLATFORM_IMPL;
  private static final FragmentTransitionImpl SUPPORT_IMPL = resolveSupportImpl();
  
  static
  {
    FragmentTransitionCompat21 localFragmentTransitionCompat21;
    if (Build.VERSION.SDK_INT >= 21) {
      localFragmentTransitionCompat21 = new FragmentTransitionCompat21();
    } else {
      localFragmentTransitionCompat21 = null;
    }
    PLATFORM_IMPL = localFragmentTransitionCompat21;
  }
  
  private static void addSharedElementsWithMatchingNames(ArrayList<View> paramArrayList, ArrayMap<String, View> paramArrayMap, Collection<String> paramCollection)
  {
    int i = paramArrayMap.size() - 1;
    while (i >= 0)
    {
      View localView = (View)paramArrayMap.valueAt(i);
      if (paramCollection.contains(ViewCompat.getTransitionName(localView))) {
        paramArrayList.add(localView);
      }
      i -= 1;
    }
  }
  
  private static void addToFirstInLastOut(BackStackRecord paramBackStackRecord, FragmentTransaction.Op paramOp, SparseArray<FragmentTransition.FragmentContainerTransition> paramSparseArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    Fragment localFragment = paramOp.mFragment;
    if (localFragment == null) {
      return;
    }
    int n = localFragment.mContainerId;
    if (n == 0) {
      return;
    }
    if (paramBoolean1) {
      i = INVERSE_OPS[paramOp.mCmd];
    } else {
      i = paramOp.mCmd;
    }
    boolean bool2 = false;
    boolean bool1 = false;
    if (i != 1) {
      if (i != 3) {
        if (i != 4) {
          if (i != 5)
          {
            if (i == 6) {
              break label197;
            }
            if (i == 7) {
              break label291;
            }
          }
        }
      }
    }
    int j;
    int k;
    for (int i = 0;; i = 1)
    {
      j = 0;
      k = 0;
      break;
      if (paramBoolean2)
      {
        if ((!localFragment.mHiddenChanged) || (localFragment.mHidden) || (!localFragment.mAdded)) {
          break label328;
        }
      }
      else
      {
        bool1 = localFragment.mHidden;
        continue;
        if (paramBoolean2)
        {
          if ((!localFragment.mHiddenChanged) || (!localFragment.mAdded) || (!localFragment.mHidden)) {}
        }
        else {
          for (;;)
          {
            break;
            if ((!localFragment.mAdded) || (localFragment.mHidden)) {
              break label245;
            }
            continue;
            label197:
            if (!paramBoolean2) {
              break label251;
            }
            if ((localFragment.mAdded) || (localFragment.mView == null) || (localFragment.mView.getVisibility() != 0) || (localFragment.mPostponedAlpha < 0.0F)) {
              break label245;
            }
          }
        }
        for (;;)
        {
          i = 1;
          break;
          label245:
          label251:
          do
          {
            i = 0;
            break;
          } while ((!localFragment.mAdded) || (localFragment.mHidden));
        }
        int m = 0;
        j = 1;
        bool1 = bool2;
        k = i;
        i = m;
        break;
        label291:
        if (paramBoolean2)
        {
          bool1 = localFragment.mIsNewlyAdded;
          continue;
        }
        if ((localFragment.mAdded) || (localFragment.mHidden)) {
          break label328;
        }
      }
      bool1 = true;
      continue;
      label328:
      bool1 = false;
    }
    Object localObject = (FragmentTransition.FragmentContainerTransition)paramSparseArray.get(n);
    paramOp = (FragmentTransaction.Op)localObject;
    if (bool1)
    {
      paramOp = ensureContainer((FragmentTransition.FragmentContainerTransition)localObject, paramSparseArray, n);
      paramOp.lastIn = localFragment;
      paramOp.lastInIsPop = paramBoolean1;
      paramOp.lastInTransaction = paramBackStackRecord;
    }
    if ((!paramBoolean2) && (i != 0))
    {
      if ((paramOp != null) && (paramOp.firstOut == localFragment)) {
        paramOp.firstOut = null;
      }
      localObject = paramBackStackRecord.mManager;
      if ((localFragment.mState < 1) && (((FragmentManager)localObject).mCurState >= 1) && (!paramBackStackRecord.mReorderingAllowed))
      {
        ((FragmentManager)localObject).makeActive(localFragment);
        ((FragmentManager)localObject).moveToState(localFragment, 1);
      }
    }
    localObject = paramOp;
    if (k != 0) {
      if (paramOp != null)
      {
        localObject = paramOp;
        if (paramOp.firstOut != null) {}
      }
      else
      {
        localObject = ensureContainer(paramOp, paramSparseArray, n);
        ((FragmentTransition.FragmentContainerTransition)localObject).firstOut = localFragment;
        ((FragmentTransition.FragmentContainerTransition)localObject).firstOutIsPop = paramBoolean1;
        ((FragmentTransition.FragmentContainerTransition)localObject).firstOutTransaction = paramBackStackRecord;
      }
    }
    if ((!paramBoolean2) && (j != 0) && (localObject != null) && (((FragmentTransition.FragmentContainerTransition)localObject).lastIn == localFragment)) {
      ((FragmentTransition.FragmentContainerTransition)localObject).lastIn = null;
    }
  }
  
  public static void calculateFragments(BackStackRecord paramBackStackRecord, SparseArray<FragmentTransition.FragmentContainerTransition> paramSparseArray, boolean paramBoolean)
  {
    int j = paramBackStackRecord.mOps.size();
    int i = 0;
    while (i < j)
    {
      addToFirstInLastOut(paramBackStackRecord, (FragmentTransaction.Op)paramBackStackRecord.mOps.get(i), paramSparseArray, false, paramBoolean);
      i += 1;
    }
  }
  
  private static ArrayMap<String, String> calculateNameOverrides(int paramInt1, ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt2, int paramInt3)
  {
    ArrayMap localArrayMap = new ArrayMap();
    paramInt3 -= 1;
    while (paramInt3 >= paramInt2)
    {
      Object localObject = (BackStackRecord)paramArrayList.get(paramInt3);
      if (((BackStackRecord)localObject).interactsWith(paramInt1))
      {
        boolean bool = ((Boolean)paramArrayList1.get(paramInt3)).booleanValue();
        if (((BackStackRecord)localObject).mSharedElementSourceNames != null)
        {
          int j = ((BackStackRecord)localObject).mSharedElementSourceNames.size();
          ArrayList localArrayList2;
          ArrayList localArrayList1;
          if (bool)
          {
            localArrayList2 = ((BackStackRecord)localObject).mSharedElementSourceNames;
            localArrayList1 = ((BackStackRecord)localObject).mSharedElementTargetNames;
          }
          else
          {
            localArrayList1 = ((BackStackRecord)localObject).mSharedElementSourceNames;
            localArrayList2 = ((BackStackRecord)localObject).mSharedElementTargetNames;
          }
          int i = 0;
          while (i < j)
          {
            localObject = (String)localArrayList1.get(i);
            String str1 = (String)localArrayList2.get(i);
            String str2 = (String)localArrayMap.remove(str1);
            if (str2 != null) {
              localArrayMap.put(localObject, str2);
            } else {
              localArrayMap.put(localObject, str1);
            }
            i += 1;
          }
        }
      }
      paramInt3 -= 1;
    }
    return localArrayMap;
  }
  
  public static void calculatePopFragments(BackStackRecord paramBackStackRecord, SparseArray<FragmentTransition.FragmentContainerTransition> paramSparseArray, boolean paramBoolean)
  {
    if (!paramBackStackRecord.mManager.mContainer.onHasView()) {
      return;
    }
    int i = paramBackStackRecord.mOps.size() - 1;
    while (i >= 0)
    {
      addToFirstInLastOut(paramBackStackRecord, (FragmentTransaction.Op)paramBackStackRecord.mOps.get(i), paramSparseArray, true, paramBoolean);
      i -= 1;
    }
  }
  
  static void callSharedElementStartEnd(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean1, ArrayMap<String, View> paramArrayMap, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      paramFragment1 = paramFragment2.getEnterTransitionCallback();
    } else {
      paramFragment1 = paramFragment1.getEnterTransitionCallback();
    }
    if (paramFragment1 != null)
    {
      paramFragment2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      int i;
      if (paramArrayMap == null) {
        i = 0;
      } else {
        i = paramArrayMap.size();
      }
      while (j < i)
      {
        localArrayList.add(paramArrayMap.keyAt(j));
        paramFragment2.add(paramArrayMap.valueAt(j));
        j += 1;
      }
      if (paramBoolean2)
      {
        paramFragment1.onSharedElementStart(localArrayList, paramFragment2, null);
        return;
      }
      paramFragment1.onSharedElementEnd(localArrayList, paramFragment2, null);
    }
  }
  
  private static boolean canHandleAll(FragmentTransitionImpl paramFragmentTransitionImpl, List<Object> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (!paramFragmentTransitionImpl.canHandle(paramList.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  static ArrayMap<String, View> captureInSharedElements(FragmentTransitionImpl paramFragmentTransitionImpl, ArrayMap<String, String> paramArrayMap, Object paramObject, FragmentTransition.FragmentContainerTransition paramFragmentContainerTransition)
  {
    Fragment localFragment = paramFragmentContainerTransition.lastIn;
    View localView = localFragment.getView();
    if ((!paramArrayMap.isEmpty()) && (paramObject != null) && (localView != null))
    {
      ArrayMap localArrayMap = new ArrayMap();
      paramFragmentTransitionImpl.findNamedViews(localArrayMap, localView);
      paramFragmentTransitionImpl = paramFragmentContainerTransition.lastInTransaction;
      if (paramFragmentContainerTransition.lastInIsPop)
      {
        paramObject = localFragment.getExitTransitionCallback();
        paramFragmentTransitionImpl = paramFragmentTransitionImpl.mSharedElementSourceNames;
      }
      else
      {
        paramObject = localFragment.getEnterTransitionCallback();
        paramFragmentTransitionImpl = paramFragmentTransitionImpl.mSharedElementTargetNames;
      }
      if (paramFragmentTransitionImpl != null)
      {
        localArrayMap.retainAll(paramFragmentTransitionImpl);
        localArrayMap.retainAll(paramArrayMap.values());
      }
      if (paramObject != null)
      {
        paramObject.onMapSharedElements(paramFragmentTransitionImpl, localArrayMap);
        int i = paramFragmentTransitionImpl.size() - 1;
        while (i >= 0)
        {
          paramFragmentContainerTransition = (String)paramFragmentTransitionImpl.get(i);
          paramObject = (View)localArrayMap.get(paramFragmentContainerTransition);
          if (paramObject == null)
          {
            paramObject = findKeyForValue(paramArrayMap, paramFragmentContainerTransition);
            if (paramObject != null) {
              paramArrayMap.remove(paramObject);
            }
          }
          else if (!paramFragmentContainerTransition.equals(ViewCompat.getTransitionName(paramObject)))
          {
            paramFragmentContainerTransition = findKeyForValue(paramArrayMap, paramFragmentContainerTransition);
            if (paramFragmentContainerTransition != null) {
              paramArrayMap.put(paramFragmentContainerTransition, ViewCompat.getTransitionName(paramObject));
            }
          }
          i -= 1;
        }
      }
      retainValues(paramArrayMap, localArrayMap);
      return localArrayMap;
    }
    paramArrayMap.clear();
    return null;
  }
  
  private static ArrayMap<String, View> captureOutSharedElements(FragmentTransitionImpl paramFragmentTransitionImpl, ArrayMap<String, String> paramArrayMap, Object paramObject, FragmentTransition.FragmentContainerTransition paramFragmentContainerTransition)
  {
    if ((!paramArrayMap.isEmpty()) && (paramObject != null))
    {
      paramObject = paramFragmentContainerTransition.firstOut;
      ArrayMap localArrayMap = new ArrayMap();
      paramFragmentTransitionImpl.findNamedViews(localArrayMap, paramObject.requireView());
      paramFragmentTransitionImpl = paramFragmentContainerTransition.firstOutTransaction;
      if (paramFragmentContainerTransition.firstOutIsPop)
      {
        paramObject = paramObject.getEnterTransitionCallback();
        paramFragmentTransitionImpl = paramFragmentTransitionImpl.mSharedElementTargetNames;
      }
      else
      {
        paramObject = paramObject.getExitTransitionCallback();
        paramFragmentTransitionImpl = paramFragmentTransitionImpl.mSharedElementSourceNames;
      }
      if (paramFragmentTransitionImpl != null) {
        localArrayMap.retainAll(paramFragmentTransitionImpl);
      }
      if (paramObject != null)
      {
        paramObject.onMapSharedElements(paramFragmentTransitionImpl, localArrayMap);
        int i = paramFragmentTransitionImpl.size() - 1;
        while (i >= 0)
        {
          paramFragmentContainerTransition = (String)paramFragmentTransitionImpl.get(i);
          paramObject = (View)localArrayMap.get(paramFragmentContainerTransition);
          if (paramObject == null)
          {
            paramArrayMap.remove(paramFragmentContainerTransition);
          }
          else if (!paramFragmentContainerTransition.equals(ViewCompat.getTransitionName(paramObject)))
          {
            paramFragmentContainerTransition = (String)paramArrayMap.remove(paramFragmentContainerTransition);
            paramArrayMap.put(ViewCompat.getTransitionName(paramObject), paramFragmentContainerTransition);
          }
          i -= 1;
        }
      }
      paramArrayMap.retainAll(localArrayMap.keySet());
      return localArrayMap;
    }
    paramArrayMap.clear();
    return null;
  }
  
  private static FragmentTransitionImpl chooseImpl(Fragment paramFragment1, Fragment paramFragment2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramFragment1 != null)
    {
      Object localObject = paramFragment1.getExitTransition();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      localObject = paramFragment1.getReturnTransition();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      paramFragment1 = paramFragment1.getSharedElementReturnTransition();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
    }
    if (paramFragment2 != null)
    {
      paramFragment1 = paramFragment2.getEnterTransition();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
      paramFragment1 = paramFragment2.getReenterTransition();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
      paramFragment1 = paramFragment2.getSharedElementEnterTransition();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    paramFragment1 = PLATFORM_IMPL;
    if ((paramFragment1 != null) && (canHandleAll(paramFragment1, localArrayList))) {
      return PLATFORM_IMPL;
    }
    paramFragment1 = SUPPORT_IMPL;
    if ((paramFragment1 != null) && (canHandleAll(paramFragment1, localArrayList))) {
      return SUPPORT_IMPL;
    }
    if ((PLATFORM_IMPL == null) && (SUPPORT_IMPL == null)) {
      return null;
    }
    throw new IllegalArgumentException("Invalid Transition types");
  }
  
  static ArrayList<View> configureEnteringExitingViews(FragmentTransitionImpl paramFragmentTransitionImpl, Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, View paramView)
  {
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramFragment = paramFragment.getView();
      if (paramFragment != null) {
        paramFragmentTransitionImpl.captureTransitioningViews(localArrayList, paramFragment);
      }
      if (paramArrayList != null) {
        localArrayList.removeAll(paramArrayList);
      }
      paramFragment = localArrayList;
      if (!localArrayList.isEmpty())
      {
        localArrayList.add(paramView);
        paramFragmentTransitionImpl.addTargets(paramObject, localArrayList);
        return localArrayList;
      }
    }
    else
    {
      paramFragment = null;
    }
    return paramFragment;
  }
  
  private static Object configureSharedElementsOrdered(FragmentTransitionImpl paramFragmentTransitionImpl, ViewGroup paramViewGroup, View paramView, ArrayMap<String, String> paramArrayMap, FragmentTransition.FragmentContainerTransition paramFragmentContainerTransition, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2, Object paramObject1, Object paramObject2)
  {
    Fragment localFragment1 = paramFragmentContainerTransition.lastIn;
    Fragment localFragment2 = paramFragmentContainerTransition.firstOut;
    if (localFragment1 != null)
    {
      if (localFragment2 == null) {
        return null;
      }
      boolean bool = paramFragmentContainerTransition.lastInIsPop;
      Object localObject;
      if (paramArrayMap.isEmpty()) {
        localObject = null;
      } else {
        localObject = getSharedElementTransition(paramFragmentTransitionImpl, localFragment1, localFragment2, bool);
      }
      ArrayMap localArrayMap = captureOutSharedElements(paramFragmentTransitionImpl, paramArrayMap, localObject, paramFragmentContainerTransition);
      if (paramArrayMap.isEmpty()) {
        localObject = null;
      } else {
        paramArrayList1.addAll(localArrayMap.values());
      }
      if ((paramObject1 == null) && (paramObject2 == null) && (localObject == null)) {
        return null;
      }
      callSharedElementStartEnd(localFragment1, localFragment2, bool, localArrayMap, true);
      if (localObject != null)
      {
        Rect localRect = new Rect();
        paramFragmentTransitionImpl.setSharedElementTargets(localObject, paramView, paramArrayList1);
        setOutEpicenter(paramFragmentTransitionImpl, localObject, paramObject2, localArrayMap, paramFragmentContainerTransition.firstOutIsPop, paramFragmentContainerTransition.firstOutTransaction);
        paramObject2 = localRect;
        if (paramObject1 != null)
        {
          paramFragmentTransitionImpl.setEpicenter(paramObject1, localRect);
          paramObject2 = localRect;
        }
      }
      else
      {
        paramObject2 = null;
      }
      OneShotPreDrawListener.add(paramViewGroup, new FragmentTransition.6(paramFragmentTransitionImpl, paramArrayMap, localObject, paramFragmentContainerTransition, paramArrayList2, paramView, localFragment1, localFragment2, bool, paramArrayList1, paramObject1, paramObject2));
      return localObject;
    }
    return null;
  }
  
  private static Object configureSharedElementsReordered(FragmentTransitionImpl paramFragmentTransitionImpl, ViewGroup paramViewGroup, View paramView, ArrayMap<String, String> paramArrayMap, FragmentTransition.FragmentContainerTransition paramFragmentContainerTransition, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2, Object paramObject1, Object paramObject2)
  {
    Fragment localFragment1 = paramFragmentContainerTransition.lastIn;
    Fragment localFragment2 = paramFragmentContainerTransition.firstOut;
    if (localFragment1 != null) {
      localFragment1.requireView().setVisibility(0);
    }
    if (localFragment1 != null)
    {
      if (localFragment2 == null) {
        return null;
      }
      boolean bool = paramFragmentContainerTransition.lastInIsPop;
      Object localObject;
      if (paramArrayMap.isEmpty()) {
        localObject = null;
      } else {
        localObject = getSharedElementTransition(paramFragmentTransitionImpl, localFragment1, localFragment2, bool);
      }
      ArrayMap localArrayMap2 = captureOutSharedElements(paramFragmentTransitionImpl, paramArrayMap, localObject, paramFragmentContainerTransition);
      ArrayMap localArrayMap1 = captureInSharedElements(paramFragmentTransitionImpl, paramArrayMap, localObject, paramFragmentContainerTransition);
      if (paramArrayMap.isEmpty())
      {
        if (localArrayMap2 != null) {
          localArrayMap2.clear();
        }
        if (localArrayMap1 != null) {
          localArrayMap1.clear();
        }
        paramArrayMap = null;
      }
      else
      {
        addSharedElementsWithMatchingNames(paramArrayList1, localArrayMap2, paramArrayMap.keySet());
        addSharedElementsWithMatchingNames(paramArrayList2, localArrayMap1, paramArrayMap.values());
        paramArrayMap = localObject;
      }
      if ((paramObject1 == null) && (paramObject2 == null) && (paramArrayMap == null)) {
        return null;
      }
      callSharedElementStartEnd(localFragment1, localFragment2, bool, localArrayMap2, true);
      if (paramArrayMap != null)
      {
        paramArrayList2.add(paramView);
        paramFragmentTransitionImpl.setSharedElementTargets(paramArrayMap, paramView, paramArrayList1);
        setOutEpicenter(paramFragmentTransitionImpl, paramArrayMap, paramObject2, localArrayMap2, paramFragmentContainerTransition.firstOutIsPop, paramFragmentContainerTransition.firstOutTransaction);
        paramView = new Rect();
        paramFragmentContainerTransition = getInEpicenterView(localArrayMap1, paramFragmentContainerTransition, paramObject1, bool);
        if (paramFragmentContainerTransition != null) {
          paramFragmentTransitionImpl.setEpicenter(paramObject1, paramView);
        }
        paramArrayList1 = paramView;
      }
      else
      {
        paramView = null;
        paramArrayList1 = paramView;
        paramFragmentContainerTransition = paramView;
      }
      OneShotPreDrawListener.add(paramViewGroup, new FragmentTransition.5(localFragment1, localFragment2, bool, localArrayMap1, paramFragmentContainerTransition, paramFragmentTransitionImpl, paramArrayList1));
      return paramArrayMap;
    }
    return null;
  }
  
  private static void configureTransitionsOrdered(FragmentManager paramFragmentManager, int paramInt, FragmentTransition.FragmentContainerTransition paramFragmentContainerTransition, View paramView, ArrayMap<String, String> paramArrayMap, FragmentTransition.Callback paramCallback)
  {
    if (paramFragmentManager.mContainer.onHasView()) {
      paramFragmentManager = (ViewGroup)paramFragmentManager.mContainer.onFindViewById(paramInt);
    } else {
      paramFragmentManager = null;
    }
    if (paramFragmentManager == null) {
      return;
    }
    Fragment localFragment1 = paramFragmentContainerTransition.lastIn;
    Fragment localFragment2 = paramFragmentContainerTransition.firstOut;
    FragmentTransitionImpl localFragmentTransitionImpl = chooseImpl(localFragment2, localFragment1);
    if (localFragmentTransitionImpl == null) {
      return;
    }
    boolean bool1 = paramFragmentContainerTransition.lastInIsPop;
    boolean bool2 = paramFragmentContainerTransition.firstOutIsPop;
    Object localObject2 = getEnterTransition(localFragmentTransitionImpl, localFragment1, bool1);
    Object localObject1 = getExitTransition(localFragmentTransitionImpl, localFragment2, bool2);
    Object localObject4 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject3 = configureSharedElementsOrdered(localFragmentTransitionImpl, paramFragmentManager, paramView, paramArrayMap, paramFragmentContainerTransition, (ArrayList)localObject4, localArrayList1, localObject2, localObject1);
    if ((localObject2 == null) && (localObject3 == null) && (localObject1 == null)) {
      return;
    }
    ArrayList localArrayList2 = configureEnteringExitingViews(localFragmentTransitionImpl, localObject1, localFragment2, (ArrayList)localObject4, paramView);
    if ((localArrayList2 != null) && (!localArrayList2.isEmpty())) {
      break label183;
    }
    localObject1 = null;
    label183:
    localFragmentTransitionImpl.addTarget(localObject2, paramView);
    paramFragmentContainerTransition = mergeTransitions(localFragmentTransitionImpl, localObject2, localObject1, localObject3, localFragment1, paramFragmentContainerTransition.lastInIsPop);
    if ((localFragment2 != null) && (localArrayList2 != null) && ((localArrayList2.size() > 0) || (((ArrayList)localObject4).size() > 0)))
    {
      localObject4 = new CancellationSignal();
      paramCallback.onStart(localFragment2, (CancellationSignal)localObject4);
      localFragmentTransitionImpl.setListenerForTransitionEnd(localFragment2, paramFragmentContainerTransition, (CancellationSignal)localObject4, new FragmentTransition.3(paramCallback, localFragment2, (CancellationSignal)localObject4));
    }
    if (paramFragmentContainerTransition != null)
    {
      paramCallback = new ArrayList();
      localFragmentTransitionImpl.scheduleRemoveTargets(paramFragmentContainerTransition, localObject2, paramCallback, localObject1, localArrayList2, localObject3, localArrayList1);
      scheduleTargetChange(localFragmentTransitionImpl, paramFragmentManager, localFragment1, paramView, localArrayList1, localObject2, paramCallback, localObject1, localArrayList2);
      localFragmentTransitionImpl.setNameOverridesOrdered(paramFragmentManager, localArrayList1, paramArrayMap);
      localFragmentTransitionImpl.beginDelayedTransition(paramFragmentManager, paramFragmentContainerTransition);
      localFragmentTransitionImpl.scheduleNameReset(paramFragmentManager, localArrayList1, paramArrayMap);
    }
  }
  
  private static void configureTransitionsReordered(FragmentManager paramFragmentManager, int paramInt, FragmentTransition.FragmentContainerTransition paramFragmentContainerTransition, View paramView, ArrayMap<String, String> paramArrayMap, FragmentTransition.Callback paramCallback)
  {
    if (paramFragmentManager.mContainer.onHasView()) {
      paramFragmentManager = (ViewGroup)paramFragmentManager.mContainer.onFindViewById(paramInt);
    } else {
      paramFragmentManager = null;
    }
    if (paramFragmentManager == null) {
      return;
    }
    Object localObject4 = paramFragmentContainerTransition.lastIn;
    Fragment localFragment = paramFragmentContainerTransition.firstOut;
    FragmentTransitionImpl localFragmentTransitionImpl = chooseImpl(localFragment, (Fragment)localObject4);
    if (localFragmentTransitionImpl == null) {
      return;
    }
    boolean bool1 = paramFragmentContainerTransition.lastInIsPop;
    boolean bool2 = paramFragmentContainerTransition.firstOutIsPop;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = getEnterTransition(localFragmentTransitionImpl, (Fragment)localObject4, bool1);
    Object localObject1 = getExitTransition(localFragmentTransitionImpl, localFragment, bool2);
    Object localObject3 = configureSharedElementsReordered(localFragmentTransitionImpl, paramFragmentManager, paramView, paramArrayMap, paramFragmentContainerTransition, localArrayList2, localArrayList1, localObject2, localObject1);
    if ((localObject2 == null) && (localObject3 == null) && (localObject1 == null)) {
      return;
    }
    paramFragmentContainerTransition = (FragmentTransition.FragmentContainerTransition)localObject1;
    localObject1 = configureEnteringExitingViews(localFragmentTransitionImpl, paramFragmentContainerTransition, localFragment, localArrayList2, paramView);
    paramView = configureEnteringExitingViews(localFragmentTransitionImpl, localObject2, (Fragment)localObject4, localArrayList1, paramView);
    setViewVisibility(paramView, 4);
    localObject4 = mergeTransitions(localFragmentTransitionImpl, localObject2, paramFragmentContainerTransition, localObject3, (Fragment)localObject4, bool1);
    if ((localFragment != null) && (localObject1 != null) && ((((ArrayList)localObject1).size() > 0) || (localArrayList2.size() > 0)))
    {
      CancellationSignal localCancellationSignal = new CancellationSignal();
      paramCallback.onStart(localFragment, localCancellationSignal);
      localFragmentTransitionImpl.setListenerForTransitionEnd(localFragment, localObject4, localCancellationSignal, new FragmentTransition.1(paramCallback, localFragment, localCancellationSignal));
    }
    if (localObject4 != null)
    {
      replaceHide(localFragmentTransitionImpl, paramFragmentContainerTransition, localFragment, (ArrayList)localObject1);
      paramCallback = localFragmentTransitionImpl.prepareSetNameOverridesReordered(localArrayList1);
      localFragmentTransitionImpl.scheduleRemoveTargets(localObject4, localObject2, paramView, paramFragmentContainerTransition, (ArrayList)localObject1, localObject3, localArrayList1);
      localFragmentTransitionImpl.beginDelayedTransition(paramFragmentManager, localObject4);
      localFragmentTransitionImpl.setNameOverridesReordered(paramFragmentManager, localArrayList2, localArrayList1, paramCallback, paramArrayMap);
      setViewVisibility(paramView, 0);
      localFragmentTransitionImpl.swapSharedElementTargets(localObject3, localArrayList2, localArrayList1);
    }
  }
  
  private static FragmentTransition.FragmentContainerTransition ensureContainer(FragmentTransition.FragmentContainerTransition paramFragmentContainerTransition, SparseArray<FragmentTransition.FragmentContainerTransition> paramSparseArray, int paramInt)
  {
    FragmentTransition.FragmentContainerTransition localFragmentContainerTransition = paramFragmentContainerTransition;
    if (paramFragmentContainerTransition == null)
    {
      localFragmentContainerTransition = new FragmentTransition.FragmentContainerTransition();
      paramSparseArray.put(paramInt, localFragmentContainerTransition);
    }
    return localFragmentContainerTransition;
  }
  
  private static String findKeyForValue(ArrayMap<String, String> paramArrayMap, String paramString)
  {
    int j = paramArrayMap.size();
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(paramArrayMap.valueAt(i))) {
        return (String)paramArrayMap.keyAt(i);
      }
      i += 1;
    }
    return null;
  }
  
  private static Object getEnterTransition(FragmentTransitionImpl paramFragmentTransitionImpl, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {
      paramFragment = paramFragment.getReenterTransition();
    } else {
      paramFragment = paramFragment.getEnterTransition();
    }
    return paramFragmentTransitionImpl.cloneTransition(paramFragment);
  }
  
  private static Object getExitTransition(FragmentTransitionImpl paramFragmentTransitionImpl, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {
      paramFragment = paramFragment.getReturnTransition();
    } else {
      paramFragment = paramFragment.getExitTransition();
    }
    return paramFragmentTransitionImpl.cloneTransition(paramFragment);
  }
  
  static View getInEpicenterView(ArrayMap<String, View> paramArrayMap, FragmentTransition.FragmentContainerTransition paramFragmentContainerTransition, Object paramObject, boolean paramBoolean)
  {
    paramFragmentContainerTransition = paramFragmentContainerTransition.lastInTransaction;
    if ((paramObject != null) && (paramArrayMap != null) && (paramFragmentContainerTransition.mSharedElementSourceNames != null) && (!paramFragmentContainerTransition.mSharedElementSourceNames.isEmpty()))
    {
      if (paramBoolean) {
        paramFragmentContainerTransition = (String)paramFragmentContainerTransition.mSharedElementSourceNames.get(0);
      } else {
        paramFragmentContainerTransition = (String)paramFragmentContainerTransition.mSharedElementTargetNames.get(0);
      }
      return (View)paramArrayMap.get(paramFragmentContainerTransition);
    }
    return null;
  }
  
  private static Object getSharedElementTransition(FragmentTransitionImpl paramFragmentTransitionImpl, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean)
  {
    if ((paramFragment1 != null) && (paramFragment2 != null))
    {
      if (paramBoolean) {
        paramFragment1 = paramFragment2.getSharedElementReturnTransition();
      } else {
        paramFragment1 = paramFragment1.getSharedElementEnterTransition();
      }
      return paramFragmentTransitionImpl.wrapTransitionInSet(paramFragmentTransitionImpl.cloneTransition(paramFragment1));
    }
    return null;
  }
  
  private static Object mergeTransitions(FragmentTransitionImpl paramFragmentTransitionImpl, Object paramObject1, Object paramObject2, Object paramObject3, Fragment paramFragment, boolean paramBoolean)
  {
    if ((paramObject1 != null) && (paramObject2 != null) && (paramFragment != null))
    {
      if (paramBoolean) {
        paramBoolean = paramFragment.getAllowReturnTransitionOverlap();
      } else {
        paramBoolean = paramFragment.getAllowEnterTransitionOverlap();
      }
    }
    else {
      paramBoolean = true;
    }
    if (paramBoolean) {
      return paramFragmentTransitionImpl.mergeTransitionsTogether(paramObject2, paramObject1, paramObject3);
    }
    return paramFragmentTransitionImpl.mergeTransitionsInSequence(paramObject2, paramObject1, paramObject3);
  }
  
  private static void replaceHide(FragmentTransitionImpl paramFragmentTransitionImpl, Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList)
  {
    if ((paramFragment != null) && (paramObject != null) && (paramFragment.mAdded) && (paramFragment.mHidden) && (paramFragment.mHiddenChanged))
    {
      paramFragment.setHideReplaced(true);
      paramFragmentTransitionImpl.scheduleHideFragmentView(paramObject, paramFragment.getView(), paramArrayList);
      OneShotPreDrawListener.add(paramFragment.mContainer, new FragmentTransition.2(paramArrayList));
    }
  }
  
  private static FragmentTransitionImpl resolveSupportImpl()
  {
    try
    {
      FragmentTransitionImpl localFragmentTransitionImpl = (FragmentTransitionImpl)Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localFragmentTransitionImpl;
    }
    catch (Exception localException)
    {
      label26:
      break label26;
    }
    return null;
  }
  
  private static void retainValues(ArrayMap<String, String> paramArrayMap, ArrayMap<String, View> paramArrayMap1)
  {
    int i = paramArrayMap.size() - 1;
    while (i >= 0)
    {
      if (!paramArrayMap1.containsKey((String)paramArrayMap.valueAt(i))) {
        paramArrayMap.removeAt(i);
      }
      i -= 1;
    }
  }
  
  private static void scheduleTargetChange(FragmentTransitionImpl paramFragmentTransitionImpl, ViewGroup paramViewGroup, Fragment paramFragment, View paramView, ArrayList<View> paramArrayList1, Object paramObject1, ArrayList<View> paramArrayList2, Object paramObject2, ArrayList<View> paramArrayList3)
  {
    OneShotPreDrawListener.add(paramViewGroup, new FragmentTransition.4(paramObject1, paramFragmentTransitionImpl, paramView, paramFragment, paramArrayList1, paramArrayList2, paramArrayList3, paramObject2));
  }
  
  private static void setOutEpicenter(FragmentTransitionImpl paramFragmentTransitionImpl, Object paramObject1, Object paramObject2, ArrayMap<String, View> paramArrayMap, boolean paramBoolean, BackStackRecord paramBackStackRecord)
  {
    if ((paramBackStackRecord.mSharedElementSourceNames != null) && (!paramBackStackRecord.mSharedElementSourceNames.isEmpty()))
    {
      if (paramBoolean) {
        paramBackStackRecord = (String)paramBackStackRecord.mSharedElementTargetNames.get(0);
      } else {
        paramBackStackRecord = (String)paramBackStackRecord.mSharedElementSourceNames.get(0);
      }
      paramArrayMap = (View)paramArrayMap.get(paramBackStackRecord);
      paramFragmentTransitionImpl.setEpicenter(paramObject1, paramArrayMap);
      if (paramObject2 != null) {
        paramFragmentTransitionImpl.setEpicenter(paramObject2, paramArrayMap);
      }
    }
  }
  
  static void setViewVisibility(ArrayList<View> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return;
    }
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      ((View)paramArrayList.get(i)).setVisibility(paramInt);
      i -= 1;
    }
  }
  
  static void startTransitions(FragmentManager paramFragmentManager, ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, boolean paramBoolean, FragmentTransition.Callback paramCallback)
  {
    if (paramFragmentManager.mCurState < 1) {
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    int i = paramInt1;
    Object localObject;
    while (i < paramInt2)
    {
      localObject = (BackStackRecord)paramArrayList.get(i);
      if (((Boolean)paramArrayList1.get(i)).booleanValue()) {
        calculatePopFragments((BackStackRecord)localObject, localSparseArray, paramBoolean);
      } else {
        calculateFragments((BackStackRecord)localObject, localSparseArray, paramBoolean);
      }
      i += 1;
    }
    if (localSparseArray.size() != 0)
    {
      localObject = new View(paramFragmentManager.mHost.getContext());
      int j = localSparseArray.size();
      i = 0;
      while (i < j)
      {
        int k = localSparseArray.keyAt(i);
        ArrayMap localArrayMap = calculateNameOverrides(k, paramArrayList, paramArrayList1, paramInt1, paramInt2);
        FragmentTransition.FragmentContainerTransition localFragmentContainerTransition = (FragmentTransition.FragmentContainerTransition)localSparseArray.valueAt(i);
        if (paramBoolean) {
          configureTransitionsReordered(paramFragmentManager, k, localFragmentContainerTransition, (View)localObject, localArrayMap, paramCallback);
        } else {
          configureTransitionsOrdered(paramFragmentManager, k, localFragmentContainerTransition, (View)localObject, localArrayMap, paramCallback);
        }
        i += 1;
      }
    }
  }
  
  static boolean supportsTransition()
  {
    return (PLATFORM_IMPL != null) || (SUPPORT_IMPL != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentTransition
 * JD-Core Version:    0.7.0.1
 */