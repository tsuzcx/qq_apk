package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ArrayBlockingQueue;
import sln;
import slo;

class LayoutInflateProcessor$InflateTask
  implements Runnable
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private sln[] jdField_a_of_type_ArrayOfSln;
  
  public LayoutInflateProcessor$InflateTask(sln[] paramArrayOfsln, LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_ArrayOfSln = paramArrayOfsln;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
  }
  
  private boolean a(sln paramsln)
  {
    if ((paramsln.a == null) || (paramsln.a.size() >= 9)) {}
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("LayoutPreloadInflater", 2, "preload start: resid=" + this.jdField_a_of_type_AndroidViewLayoutInflater.getContext().getResources().getResourceEntryName(sln.a(paramsln)));
      }
      try
      {
        View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(sln.a(paramsln), sln.a(paramsln), false);
        if (localView == null) {
          continue;
        }
        if (sln.a(paramsln) != null) {
          sln.a(paramsln).a(localView);
        }
        if ((paramsln.a == null) || (paramsln.a.size() >= 9)) {
          continue;
        }
        paramsln.a.add(localView);
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
    sln[] arrayOfsln = this.jdField_a_of_type_ArrayOfSln;
    int k = arrayOfsln.length;
    int i = 0;
    if (i < k)
    {
      sln localsln = arrayOfsln[i];
      if (localsln == null) {}
      for (;;)
      {
        i += 1;
        break;
        int j = 0;
        while ((j < sln.b(localsln)) && (a(localsln))) {
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