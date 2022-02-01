package com.tencent.mobileqq.ark.core;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.AsyncFailInfo;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;

final class ArkMultiProc$1
  implements OnLoadListener
{
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("load jsc, res=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", fail=");
    if (paramLoadExtResult.failInfo != null) {
      paramLoadExtResult = paramLoadExtResult.failInfo.toString();
    } else {
      paramLoadExtResult = "(empty)";
    }
    localStringBuilder.append(paramLoadExtResult);
    QLog.i("ArkApp.MultiProc", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkMultiProc.1
 * JD-Core Version:    0.7.0.1
 */