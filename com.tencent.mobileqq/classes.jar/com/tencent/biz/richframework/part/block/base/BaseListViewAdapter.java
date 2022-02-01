package com.tencent.biz.richframework.part.block.base;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class BaseListViewAdapter<E>
  extends RecyclerView.Adapter
  implements Application.ActivityLifecycleCallbacks, RFHookAdapterDataObserver.HookDataObserverDelegate
{
  private static final String TAG = "BaseListViewAdapter";
  protected boolean isOnResume = true;
  protected ArrayList<E> mDataList = new ArrayList();
  private boolean mEnableHookDataObserver;
  private final SparseArray<RFHookAdapterDataObserver> mHookDataObserverSet = new SparseArray();
  private Handler mMainHandler;
  private final Set<RecyclerView.AdapterDataObserver> mNeedNotifyDataObservers = new HashSet();
  protected RecyclerView mRecyclerView;
  
  private boolean isAdapterExistActivity(Activity paramActivity)
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    return (localRecyclerView != null) && (localRecyclerView.getContext() == paramActivity);
  }
  
  public void addAll(List<E> paramList)
  {
    if (paramList == null) {
      return;
    }
    int i = this.mDataList.size();
    this.mDataList.addAll(paramList);
    notifyItemRangeInserted(i, paramList.size());
  }
  
  public void addAll(E[] paramArrayOfE)
  {
    if (paramArrayOfE == null) {
      return;
    }
    int i = this.mDataList.size();
    this.mDataList.addAll(Arrays.asList(paramArrayOfE));
    notifyItemRangeInserted(i, paramArrayOfE.length);
  }
  
  public E addData(E paramE)
  {
    if (paramE == null) {
      return null;
    }
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (localObject == paramE) {
        return localObject;
      }
      if (isItemEqual(localObject, paramE))
      {
        copyItem(localObject, paramE);
        return localObject;
      }
    }
    if (this.mDataList.add(paramE))
    {
      paramE = this.mDataList;
      return paramE.get(paramE.size() - 1);
    }
    return null;
  }
  
  public void addData(E paramE, int paramInt)
  {
    this.mDataList.add(paramInt, paramE);
  }
  
  public void clearData()
  {
    this.mDataList.clear();
  }
  
  protected void copyItem(E paramE1, E paramE2) {}
  
  public void delete(int paramInt)
  {
    if (paramInt < this.mDataList.size()) {
      this.mDataList.remove(paramInt);
    }
  }
  
  public ArrayList<E> getDataList()
  {
    return this.mDataList;
  }
  
  public int getDataNumber()
  {
    return this.mDataList.size();
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  public Handler getMainHandler()
  {
    if (this.mMainHandler == null) {
      this.mMainHandler = new Handler(Looper.getMainLooper());
    }
    return this.mMainHandler;
  }
  
  protected boolean isItemEqual(E paramE1, E paramE2)
  {
    return false;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (!isAdapterExistActivity(paramActivity)) {
      return;
    }
    this.isOnResume = false;
    QLog.d("BaseListViewAdapter", 4, "onActivityPaused");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (!isAdapterExistActivity(paramActivity)) {
      return;
    }
    this.isOnResume = true;
    paramActivity = this.mNeedNotifyDataObservers.iterator();
    while (paramActivity.hasNext())
    {
      RecyclerView.AdapterDataObserver localAdapterDataObserver = (RecyclerView.AdapterDataObserver)paramActivity.next();
      RFThreadManager.getUIHandler().post(new BaseListViewAdapter.1(this, localAdapterDataObserver));
    }
    this.mNeedNotifyDataObservers.clear();
    QLog.d("BaseListViewAdapter", 4, "onActivityResumed");
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    QLog.d("BaseListViewAdapter", 4, "onActivityStarted");
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (!isAdapterExistActivity(paramActivity)) {
      return;
    }
    this.isOnResume = false;
    QLog.d("BaseListViewAdapter", 4, "onActivityStopped");
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.mRecyclerView = paramRecyclerView;
  }
  
  public void onDetachedFromRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    getMainHandler().removeCallbacksAndMessages(null);
  }
  
  public boolean onInterceptDataObserver(RecyclerView.AdapterDataObserver paramAdapterDataObserver)
  {
    if (!this.isOnResume) {
      this.mNeedNotifyDataObservers.add(paramAdapterDataObserver);
    }
    return this.isOnResume ^ true;
  }
  
  public void registerAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver paramAdapterDataObserver)
  {
    if (!this.mEnableHookDataObserver)
    {
      super.registerAdapterDataObserver(paramAdapterDataObserver);
      return;
    }
    if (paramAdapterDataObserver != null)
    {
      if (this.mHookDataObserverSet.get(paramAdapterDataObserver.hashCode()) != null)
      {
        QLog.e("BaseListViewAdapter", 1, "already register observer");
        return;
      }
      RFHookAdapterDataObserver localRFHookAdapterDataObserver = new RFHookAdapterDataObserver(paramAdapterDataObserver, this);
      this.mHookDataObserverSet.put(paramAdapterDataObserver.hashCode(), localRFHookAdapterDataObserver);
      super.registerAdapterDataObserver(localRFHookAdapterDataObserver);
      return;
    }
    throw new IllegalArgumentException("The observer is null.");
  }
  
  public void setDatas(List<E> paramList)
  {
    this.mDataList.clear();
    if (paramList == null) {
      return;
    }
    this.mDataList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void setDatas(List<E> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    this.mDataList.clear();
    this.mDataList.addAll(paramList);
    notifyItemRangeInserted(paramInt, paramList.size());
  }
  
  public void setEnableHookDataObserver(boolean paramBoolean)
  {
    this.mEnableHookDataObserver = paramBoolean;
  }
  
  public void unregisterAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver paramAdapterDataObserver)
  {
    if (!this.mEnableHookDataObserver)
    {
      super.unregisterAdapterDataObserver(paramAdapterDataObserver);
      return;
    }
    if (paramAdapterDataObserver != null)
    {
      paramAdapterDataObserver = (RFHookAdapterDataObserver)this.mHookDataObserverSet.get(paramAdapterDataObserver.hashCode());
      if (paramAdapterDataObserver == null)
      {
        QLog.e("BaseListViewAdapter", 1, "unregister error!");
        return;
      }
      super.unregisterAdapterDataObserver(paramAdapterDataObserver);
      return;
    }
    throw new IllegalArgumentException("The observer is null.");
  }
  
  public void updateData(E paramE, int paramInt)
  {
    if (paramE != null)
    {
      if (paramInt >= this.mDataList.size()) {
        return;
      }
      this.mDataList.set(paramInt, paramE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
 * JD-Core Version:    0.7.0.1
 */