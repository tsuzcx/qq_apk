package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ArrayBlockingQueue;
import sef;
import seg;

class LayoutInflateProcessor$InflateTask
  implements Runnable
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private sef[] jdField_a_of_type_ArrayOfSef;
  
  public LayoutInflateProcessor$InflateTask(sef[] paramArrayOfsef, LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_ArrayOfSef = paramArrayOfsef;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
  }
  
  private boolean a(sef paramsef)
  {
    if ((paramsef.a == null) || (paramsef.a.size() >= 9)) {}
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("LayoutPreloadInflater", 2, "preload start: resid=" + this.jdField_a_of_type_AndroidViewLayoutInflater.getContext().getResources().getResourceEntryName(sef.a(paramsef)));
      }
      try
      {
        View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(sef.a(paramsef), sef.a(paramsef), false);
        if (localView == null) {
          continue;
        }
        if (sef.a(paramsef) != null) {
          sef.a(paramsef).a(localView);
        }
        if ((paramsef.a == null) || (paramsef.a.size() >= 9)) {
          continue;
        }
        paramsef.a.add(localView);
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
    sef[] arrayOfsef = this.jdField_a_of_type_ArrayOfSef;
    int k = arrayOfsef.length;
    int i = 0;
    if (i < k)
    {
      sef localsef = arrayOfsef[i];
      if (localsef == null) {}
      for (;;)
      {
        i += 1;
        break;
        int j = 0;
        while ((j < sef.b(localsef)) && (a(localsef))) {
          j += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.LayoutInflateProcessor.InflateTask
 * JD-Core Version:    0.7.0.1
 */