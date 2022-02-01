package com.tencent.mobileqq.apollo.res.api.impl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;

final class ApolloSoLoaderImpl$2
  implements OnLoadListener
{
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    paramLoadExtResult = new StringBuilder();
    paramLoadExtResult.append("[loadAllSo] predownload result=");
    paramLoadExtResult.append(paramInt);
    QLog.i("[cmshow]ApolloSoLoader", 1, paramLoadExtResult.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloSoLoaderImpl.2
 * JD-Core Version:    0.7.0.1
 */