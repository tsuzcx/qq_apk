package com.tencent.mobileqq.apollo.statistics.product;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class ApolloConfigDataReport$5
  implements BusinessObserver
{
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloConfigDataReport", 2, new Object[] { "interceptReport onReceive isSuccess:", Boolean.valueOf(paramBoolean), ",bundle", paramBundle.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.ApolloConfigDataReport.5
 * JD-Core Version:    0.7.0.1
 */