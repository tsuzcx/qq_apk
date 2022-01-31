package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ArrayBlockingQueue;
import rqd;

public class LayoutInflateProcessor
{
  private SparseArray<ArrayBlockingQueue<View>> jdField_a_of_type_AndroidUtilSparseArray;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public LayoutInflateProcessor(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  private void a(rqd paramrqd)
  {
    if (paramrqd == null) {
      return;
    }
    ArrayBlockingQueue localArrayBlockingQueue2 = (ArrayBlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(rqd.a(paramrqd));
    ArrayBlockingQueue localArrayBlockingQueue1;
    if (localArrayBlockingQueue2 == null)
    {
      localArrayBlockingQueue1 = new ArrayBlockingQueue(9);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(rqd.a(paramrqd), localArrayBlockingQueue1);
    }
    do
    {
      paramrqd.a = localArrayBlockingQueue1;
      return;
      localArrayBlockingQueue1 = localArrayBlockingQueue2;
    } while (localArrayBlockingQueue2.size() != 9);
  }
  
  @NonNull
  public View a(int paramInt, boolean paramBoolean, ViewGroup.LayoutParams paramLayoutParams)
  {
    Object localObject = (ArrayBlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = (View)((ArrayBlockingQueue)localObject).poll();
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LayoutPreloadInflater", 2, "inflate: hit cache! resid=" + this.jdField_a_of_type_AndroidViewLayoutInflater.getContext().getResources().getResourceEntryName(paramInt));
        }
        ((View)localObject).setLayoutParams(paramLayoutParams);
        return localObject;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LayoutPreloadInflater", 2, "inflate: miss cache, resid=" + this.jdField_a_of_type_AndroidViewLayoutInflater.getContext().getResources().getResourceEntryName(paramInt) + " faultTolerant=" + paramBoolean);
    }
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt, null, false);
      ((View)localObject).setLayoutParams(paramLayoutParams);
      return localObject;
    }
    return null;
  }
  
  @UiThread
  public void a()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  @UiThread
  public void a(rqd[] paramArrayOfrqd)
  {
    int j = paramArrayOfrqd.length;
    int i = 0;
    while (i < j)
    {
      a(paramArrayOfrqd[i]);
      i += 1;
    }
    ThreadManager.excute(new LayoutInflateProcessor.InflateTask(paramArrayOfrqd, this.jdField_a_of_type_AndroidViewLayoutInflater), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.LayoutInflateProcessor
 * JD-Core Version:    0.7.0.1
 */