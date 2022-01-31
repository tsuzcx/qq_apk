package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ArrayBlockingQueue;
import rqd;
import rqe;

class LayoutInflateProcessor$InflateTask
  implements Runnable
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private rqd[] jdField_a_of_type_ArrayOfRqd;
  
  public LayoutInflateProcessor$InflateTask(rqd[] paramArrayOfrqd, LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_ArrayOfRqd = paramArrayOfrqd;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
  }
  
  private boolean a(rqd paramrqd)
  {
    if ((paramrqd.a == null) || (paramrqd.a.size() >= 9)) {}
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("LayoutPreloadInflater", 2, "preload start: resid=" + this.jdField_a_of_type_AndroidViewLayoutInflater.getContext().getResources().getResourceEntryName(rqd.a(paramrqd)));
      }
      try
      {
        View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(rqd.a(paramrqd), rqd.a(paramrqd), false);
        if (localView == null) {
          continue;
        }
        if (rqd.a(paramrqd) != null) {
          rqd.a(paramrqd).a(localView);
        }
        if ((paramrqd.a == null) || (paramrqd.a.size() >= 9)) {
          continue;
        }
        paramrqd.a.add(localView);
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
    rqd[] arrayOfrqd = this.jdField_a_of_type_ArrayOfRqd;
    int k = arrayOfrqd.length;
    int i = 0;
    if (i < k)
    {
      rqd localrqd = arrayOfrqd[i];
      if (localrqd == null) {}
      for (;;)
      {
        i += 1;
        break;
        int j = 0;
        while ((j < rqd.b(localrqd)) && (a(localrqd))) {
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