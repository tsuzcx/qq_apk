package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ArrayBlockingQueue;
import syx;
import syy;

class LayoutInflateProcessor$InflateTask
  implements Runnable
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private syx[] jdField_a_of_type_ArrayOfSyx;
  
  public LayoutInflateProcessor$InflateTask(syx[] paramArrayOfsyx, LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_ArrayOfSyx = paramArrayOfsyx;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
  }
  
  private boolean a(syx paramsyx)
  {
    if ((paramsyx.a == null) || (paramsyx.a.size() >= 9)) {}
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("LayoutPreloadInflater", 2, "preload start: resid=" + this.jdField_a_of_type_AndroidViewLayoutInflater.getContext().getResources().getResourceEntryName(syx.a(paramsyx)));
      }
      try
      {
        View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(syx.a(paramsyx), syx.a(paramsyx), false);
        if (localView == null) {
          continue;
        }
        if (syx.a(paramsyx) != null) {
          syx.a(paramsyx).a(localView);
        }
        if ((paramsyx.a == null) || (paramsyx.a.size() >= 9)) {
          continue;
        }
        paramsyx.a.add(localView);
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
    syx[] arrayOfsyx = this.jdField_a_of_type_ArrayOfSyx;
    int k = arrayOfsyx.length;
    int i = 0;
    if (i < k)
    {
      syx localsyx = arrayOfsyx[i];
      if (localsyx == null) {}
      for (;;)
      {
        i += 1;
        break;
        int j = 0;
        while ((j < syx.b(localsyx)) && (a(localsyx))) {
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