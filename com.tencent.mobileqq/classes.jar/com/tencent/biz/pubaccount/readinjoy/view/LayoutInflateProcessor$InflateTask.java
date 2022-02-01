package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ArrayBlockingQueue;

class LayoutInflateProcessor$InflateTask
  implements Runnable
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private LayoutInflateProcessor.InflateParams[] jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor$InflateParams;
  
  public LayoutInflateProcessor$InflateTask(LayoutInflateProcessor.InflateParams[] paramArrayOfInflateParams, LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor$InflateParams = paramArrayOfInflateParams;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
  }
  
  private boolean a(LayoutInflateProcessor.InflateParams paramInflateParams)
  {
    if ((paramInflateParams.a == null) || (paramInflateParams.a.size() >= 9)) {}
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("LayoutPreloadInflater", 2, "preload start: resid=" + this.jdField_a_of_type_AndroidViewLayoutInflater.getContext().getResources().getResourceEntryName(LayoutInflateProcessor.InflateParams.a(paramInflateParams)));
      }
      try
      {
        View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(LayoutInflateProcessor.InflateParams.a(paramInflateParams), LayoutInflateProcessor.InflateParams.a(paramInflateParams), false);
        if (localView == null) {
          continue;
        }
        if (LayoutInflateProcessor.InflateParams.a(paramInflateParams) != null) {
          LayoutInflateProcessor.InflateParams.a(paramInflateParams).a(localView);
        }
        if ((paramInflateParams.a == null) || (paramInflateParams.a.size() >= 9)) {
          continue;
        }
        paramInflateParams.a.add(localView);
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
    LayoutInflateProcessor.InflateParams[] arrayOfInflateParams = this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor$InflateParams;
    int k = arrayOfInflateParams.length;
    int i = 0;
    if (i < k)
    {
      LayoutInflateProcessor.InflateParams localInflateParams = arrayOfInflateParams[i];
      if (localInflateParams == null) {}
      for (;;)
      {
        i += 1;
        break;
        int j = 0;
        while ((j < LayoutInflateProcessor.InflateParams.b(localInflateParams)) && (a(localInflateParams))) {
          j += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.LayoutInflateProcessor.InflateTask
 * JD-Core Version:    0.7.0.1
 */