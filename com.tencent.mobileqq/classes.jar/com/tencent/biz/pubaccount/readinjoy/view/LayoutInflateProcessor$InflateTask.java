package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ArrayBlockingQueue;
import qny;
import qnz;

class LayoutInflateProcessor$InflateTask
  implements Runnable
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private qny[] jdField_a_of_type_ArrayOfQny;
  
  public LayoutInflateProcessor$InflateTask(qny[] paramArrayOfqny, LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_ArrayOfQny = paramArrayOfqny;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
  }
  
  private boolean a(qny paramqny)
  {
    if ((paramqny.a == null) || (paramqny.a.size() >= 9)) {}
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("LayoutPreloadInflater", 2, "preload start: resid=" + this.jdField_a_of_type_AndroidViewLayoutInflater.getContext().getResources().getResourceEntryName(qny.a(paramqny)));
      }
      try
      {
        View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(qny.a(paramqny), qny.a(paramqny), false);
        if (localView == null) {
          continue;
        }
        if (qny.a(paramqny) != null) {
          qny.a(paramqny).a(localView);
        }
        if ((paramqny.a == null) || (paramqny.a.size() >= 9)) {
          continue;
        }
        paramqny.a.add(localView);
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
    qny[] arrayOfqny = this.jdField_a_of_type_ArrayOfQny;
    int k = arrayOfqny.length;
    int i = 0;
    if (i < k)
    {
      qny localqny = arrayOfqny[i];
      if (localqny == null) {}
      for (;;)
      {
        i += 1;
        break;
        int j = 0;
        while ((j < qny.b(localqny)) && (a(localqny))) {
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