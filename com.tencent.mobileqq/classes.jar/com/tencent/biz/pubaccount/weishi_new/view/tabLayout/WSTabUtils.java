package com.tencent.biz.pubaccount.weishi_new.view.tabLayout;

import UserGrowth.stSchema;
import UserGrowth.stTabInfo;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.jump.WSStSchemaJumpManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;

public class WSTabUtils
{
  private static WSDownloadParams a(String paramString)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = WSGlobalConfig.a().d();
    localWSDownloadParams.mTestId = WeishiUtils.a(localWSDownloadParams.mScene);
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  public static void a(Context paramContext, stTabInfo paramstTabInfo, int paramInt, boolean paramBoolean)
  {
    if (WeishiUtils.o()) {
      return;
    }
    if ((paramstTabInfo != null) && (paramContext != null))
    {
      new WSStSchemaJumpManager(paramContext).a(paramstTabInfo.schema).a(true).a(a(paramstTabInfo.schema.schema)).a(new WSTabUtils.1(paramInt, paramBoolean)).j();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSTabUtils.java][tabImgBtnClick] context or tabInfo is null !!! context:");
    localStringBuilder.append(paramContext);
    localStringBuilder.append(", tabInfo:");
    localStringBuilder.append(paramstTabInfo);
    WSLog.d("WSTabUtils", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabUtils
 * JD-Core Version:    0.7.0.1
 */