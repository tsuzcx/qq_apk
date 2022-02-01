package com.tencent.mobileqq.apollo.api.res.impl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;

final class ApolloSoLoaderImpl$2
  implements OnLoadListener
{
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    QLog.i("ApolloSoLoader", 1, "[loadAllSo] predownload result=" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloSoLoaderImpl.2
 * JD-Core Version:    0.7.0.1
 */