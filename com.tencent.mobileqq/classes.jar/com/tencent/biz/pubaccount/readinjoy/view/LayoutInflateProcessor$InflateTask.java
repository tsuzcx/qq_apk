package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ArrayBlockingQueue;
import snb;
import snc;

class LayoutInflateProcessor$InflateTask
  implements Runnable
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private snb[] jdField_a_of_type_ArrayOfSnb;
  
  public LayoutInflateProcessor$InflateTask(snb[] paramArrayOfsnb, LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_ArrayOfSnb = paramArrayOfsnb;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
  }
  
  private boolean a(snb paramsnb)
  {
    if ((paramsnb.a == null) || (paramsnb.a.size() >= 9)) {}
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("LayoutPreloadInflater", 2, "preload start: resid=" + this.jdField_a_of_type_AndroidViewLayoutInflater.getContext().getResources().getResourceEntryName(snb.a(paramsnb)));
      }
      try
      {
        View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(snb.a(paramsnb), snb.a(paramsnb), false);
        if (localView == null) {
          continue;
        }
        if (snb.a(paramsnb) != null) {
          snb.a(paramsnb).a(localView);
        }
        if ((paramsnb.a == null) || (paramsnb.a.size() >= 9)) {
          continue;
        }
        paramsnb.a.add(localView);
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
    snb[] arrayOfsnb = this.jdField_a_of_type_ArrayOfSnb;
    int k = arrayOfsnb.length;
    int i = 0;
    if (i < k)
    {
      snb localsnb = arrayOfsnb[i];
      if (localsnb == null) {}
      for (;;)
      {
        i += 1;
        break;
        int j = 0;
        while ((j < snb.b(localsnb)) && (a(localsnb))) {
          j += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.LayoutInflateProcessor.InflateTask
 * JD-Core Version:    0.7.0.1
 */