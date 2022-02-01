package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;

final class CrossEngineResManager$2
  implements OnLoadListener
{
  CrossEngineResManager$2(CrossEngineResManager.LoadListener paramLoadListener) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (paramInt == 0)
    {
      String str1 = paramLoadExtResult.getSoLoadPath("Standalone");
      String str2 = paramLoadExtResult.getRelatedFilesFolder("Standalone");
      paramLoadExtResult = paramLoadExtResult.getVer("Standalone");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[CrossEngine] download so success. cePath=");
      localStringBuilder.append(str1);
      localStringBuilder.append(" assetsPath=");
      localStringBuilder.append(str2);
      localStringBuilder.append(" version=");
      localStringBuilder.append(paramLoadExtResult);
      QLog.i("[cmshow]CrossEngineResManager", 1, localStringBuilder.toString());
      if ((CrossEngineResManager.a(paramLoadExtResult)) || (!CrossEngineResManager.b()))
      {
        if (CmShowWnsUtils.Z()) {
          CrossEngineResManager.c();
        }
        if (CrossEngineResManager.a(str2, ApolloConstant.k, false, true, true) != 0)
        {
          QLog.e("[cmshow]CrossEngineResManager", 1, "[CrossEngine] copy assets failed");
          paramLoadExtResult = this.a;
          if (paramLoadExtResult != null) {
            paramLoadExtResult.a(-2);
          }
          return;
        }
        CrossEngineResManager.b(paramLoadExtResult);
      }
      paramLoadExtResult = this.a;
      if (paramLoadExtResult != null) {
        paramLoadExtResult.a(0);
      }
    }
    else
    {
      paramLoadExtResult = new StringBuilder();
      paramLoadExtResult.append("[CrossEngine] download so failed. resCode=");
      paramLoadExtResult.append(paramInt);
      QLog.e("[cmshow]CrossEngineResManager", 1, paramLoadExtResult.toString());
      paramLoadExtResult = this.a;
      if (paramLoadExtResult != null) {
        paramLoadExtResult.a(-1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.CrossEngineResManager.2
 * JD-Core Version:    0.7.0.1
 */