package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ArrayBlockingQueue;
import raj;
import rak;

class LayoutInflateProcessor$InflateTask
  implements Runnable
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private raj[] jdField_a_of_type_ArrayOfRaj;
  
  public LayoutInflateProcessor$InflateTask(raj[] paramArrayOfraj, LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_ArrayOfRaj = paramArrayOfraj;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
  }
  
  private boolean a(raj paramraj)
  {
    if ((paramraj.a == null) || (paramraj.a.size() >= 9)) {}
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("LayoutPreloadInflater", 2, "preload start: resid=" + this.jdField_a_of_type_AndroidViewLayoutInflater.getContext().getResources().getResourceEntryName(raj.a(paramraj)));
      }
      try
      {
        View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(raj.a(paramraj), raj.a(paramraj), false);
        if (localView == null) {
          continue;
        }
        if (raj.a(paramraj) != null) {
          raj.a(paramraj).a(localView);
        }
        if ((paramraj.a == null) || (paramraj.a.size() >= 9)) {
          continue;
        }
        paramraj.a.add(localView);
        return true;
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("LayoutPreloadInflater", 2, "Failed to inflate resource in the background! Retrying on the UI thread", localRuntimeException);
          }
          Object localObject = null;
        }
      }
    }
  }
  
  public void run()
  {
    raj[] arrayOfraj = this.jdField_a_of_type_ArrayOfRaj;
    int k = arrayOfraj.length;
    int i = 0;
    if (i < k)
    {
      raj localraj = arrayOfraj[i];
      if (localraj == null) {}
      for (;;)
      {
        i += 1;
        break;
        int j = 0;
        while ((j < raj.b(localraj)) && (a(localraj))) {
          j += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.LayoutInflateProcessor.InflateTask
 * JD-Core Version:    0.7.0.1
 */