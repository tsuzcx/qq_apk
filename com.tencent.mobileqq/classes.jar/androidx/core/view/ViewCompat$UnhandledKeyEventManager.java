package androidx.core.view;

import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.R.id;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

class ViewCompat$UnhandledKeyEventManager
{
  private static final ArrayList<WeakReference<View>> sViewsWithListeners = new ArrayList();
  private SparseArray<WeakReference<View>> mCapturedKeys = null;
  private WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent = null;
  @Nullable
  private WeakHashMap<View, Boolean> mViewsContainingListeners = null;
  
  static UnhandledKeyEventManager at(View paramView)
  {
    UnhandledKeyEventManager localUnhandledKeyEventManager2 = (UnhandledKeyEventManager)paramView.getTag(R.id.tag_unhandled_key_event_manager);
    UnhandledKeyEventManager localUnhandledKeyEventManager1 = localUnhandledKeyEventManager2;
    if (localUnhandledKeyEventManager2 == null)
    {
      localUnhandledKeyEventManager1 = new UnhandledKeyEventManager();
      paramView.setTag(R.id.tag_unhandled_key_event_manager, localUnhandledKeyEventManager1);
    }
    return localUnhandledKeyEventManager1;
  }
  
  @Nullable
  private View dispatchInOrder(View paramView, KeyEvent paramKeyEvent)
  {
    Object localObject = this.mViewsContainingListeners;
    if (localObject != null)
    {
      if (!((WeakHashMap)localObject).containsKey(paramView)) {
        return null;
      }
      if ((paramView instanceof ViewGroup))
      {
        localObject = (ViewGroup)paramView;
        int i = ((ViewGroup)localObject).getChildCount() - 1;
        while (i >= 0)
        {
          View localView = dispatchInOrder(((ViewGroup)localObject).getChildAt(i), paramKeyEvent);
          if (localView != null) {
            return localView;
          }
          i -= 1;
        }
      }
      if (onUnhandledKeyEvent(paramView, paramKeyEvent)) {
        return paramView;
      }
    }
    return null;
  }
  
  private SparseArray<WeakReference<View>> getCapturedKeys()
  {
    if (this.mCapturedKeys == null) {
      this.mCapturedKeys = new SparseArray();
    }
    return this.mCapturedKeys;
  }
  
  private boolean onUnhandledKeyEvent(@NonNull View paramView, @NonNull KeyEvent paramKeyEvent)
  {
    ArrayList localArrayList = (ArrayList)paramView.getTag(R.id.tag_unhandled_key_listeners);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        if (((ViewCompat.OnUnhandledKeyEventListenerCompat)localArrayList.get(i)).onUnhandledKeyEvent(paramView, paramKeyEvent)) {
          return true;
        }
        i -= 1;
      }
    }
    return false;
  }
  
  private void recalcViewsWithUnhandled()
  {
    Object localObject1 = this.mViewsContainingListeners;
    if (localObject1 != null) {
      ((WeakHashMap)localObject1).clear();
    }
    if (sViewsWithListeners.isEmpty()) {
      return;
    }
    int i;
    synchronized (sViewsWithListeners)
    {
      if (this.mViewsContainingListeners == null) {
        this.mViewsContainingListeners = new WeakHashMap();
      }
      i = sViewsWithListeners.size() - 1;
      if (i >= 0)
      {
        localObject1 = (View)((WeakReference)sViewsWithListeners.get(i)).get();
        if (localObject1 == null)
        {
          sViewsWithListeners.remove(i);
        }
        else
        {
          this.mViewsContainingListeners.put(localObject1, Boolean.TRUE);
          for (localObject1 = ((View)localObject1).getParent(); (localObject1 instanceof View); localObject1 = ((ViewParent)localObject1).getParent()) {
            this.mViewsContainingListeners.put((View)localObject1, Boolean.TRUE);
          }
        }
      }
      else
      {
        return;
      }
    }
  }
  
  static void registerListeningView(View paramView)
  {
    synchronized (sViewsWithListeners)
    {
      Iterator localIterator = sViewsWithListeners.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramView) {
          return;
        }
      }
      sViewsWithListeners.add(new WeakReference(paramView));
      return;
    }
    for (;;)
    {
      throw paramView;
    }
  }
  
  static void unregisterListeningView(View paramView)
  {
    ArrayList localArrayList = sViewsWithListeners;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < sViewsWithListeners.size())
        {
          if (((WeakReference)sViewsWithListeners.get(i)).get() == paramView) {
            sViewsWithListeners.remove(i);
          }
        }
        else {
          return;
        }
      }
      finally
      {
        continue;
        throw paramView;
        continue;
        i += 1;
      }
    }
  }
  
  boolean dispatch(View paramView, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0) {
      recalcViewsWithUnhandled();
    }
    paramView = dispatchInOrder(paramView, paramKeyEvent);
    if (paramKeyEvent.getAction() == 0)
    {
      int i = paramKeyEvent.getKeyCode();
      if ((paramView != null) && (!KeyEvent.isModifierKey(i))) {
        getCapturedKeys().put(i, new WeakReference(paramView));
      }
    }
    return paramView != null;
  }
  
  boolean preDispatch(KeyEvent paramKeyEvent)
  {
    Object localObject1 = this.mLastDispatchedPreViewKeyEvent;
    if ((localObject1 != null) && (((WeakReference)localObject1).get() == paramKeyEvent)) {
      return false;
    }
    this.mLastDispatchedPreViewKeyEvent = new WeakReference(paramKeyEvent);
    Object localObject2 = null;
    SparseArray localSparseArray = getCapturedKeys();
    localObject1 = localObject2;
    if (paramKeyEvent.getAction() == 1)
    {
      int i = localSparseArray.indexOfKey(paramKeyEvent.getKeyCode());
      localObject1 = localObject2;
      if (i >= 0)
      {
        localObject1 = (WeakReference)localSparseArray.valueAt(i);
        localSparseArray.removeAt(i);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = (WeakReference)localSparseArray.get(paramKeyEvent.getKeyCode());
    }
    if (localObject2 != null)
    {
      localObject1 = (View)((WeakReference)localObject2).get();
      if ((localObject1 != null) && (ViewCompat.isAttachedToWindow((View)localObject1))) {
        onUnhandledKeyEvent((View)localObject1, paramKeyEvent);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.ViewCompat.UnhandledKeyEventManager
 * JD-Core Version:    0.7.0.1
 */