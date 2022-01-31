package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ArrayBlockingQueue;
import rag;
import rah;

class LayoutInflateProcessor$InflateTask
  implements Runnable
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private rag[] jdField_a_of_type_ArrayOfRag;
  
  public LayoutInflateProcessor$InflateTask(rag[] paramArrayOfrag, LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_ArrayOfRag = paramArrayOfrag;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
  }
  
  private boolean a(rag paramrag)
  {
    if ((paramrag.a == null) || (paramrag.a.size() >= 9)) {}
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("LayoutPreloadInflater", 2, "preload start: resid=" + this.jdField_a_of_type_AndroidViewLayoutInflater.getContext().getResources().getResourceEntryName(rag.a(paramrag)));
      }
      try
      {
        View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(rag.a(paramrag), rag.a(paramrag), false);
        if (localView == null) {
          continue;
        }
        if (rag.a(paramrag) != null) {
          rag.a(paramrag).a(localView);
        }
        if ((paramrag.a == null) || (paramrag.a.size() >= 9)) {
          continue;
        }
        paramrag.a.add(localView);
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
    rag[] arrayOfrag = this.jdField_a_of_type_ArrayOfRag;
    int k = arrayOfrag.length;
    int i = 0;
    if (i < k)
    {
      rag localrag = arrayOfrag[i];
      if (localrag == null) {}
      for (;;)
      {
        i += 1;
        break;
        int j = 0;
        while ((j < rag.b(localrag)) && (a(localrag))) {
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