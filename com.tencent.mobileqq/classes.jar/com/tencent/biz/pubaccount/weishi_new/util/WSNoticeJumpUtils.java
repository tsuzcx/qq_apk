package com.tencent.biz.pubaccount.weishi_new.util;

import UserGrowth.stNotificationRsp;
import UserGrowth.stReportItem;
import UserGrowth.stSchema;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.jump.WSStSchemaJumpManager;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;

public class WSNoticeJumpUtils
{
  private static int a(stNotificationRsp paramstNotificationRsp)
  {
    if (paramstNotificationRsp == null) {
      return 102;
    }
    switch (paramstNotificationRsp.type)
    {
    case 4: 
    case 5: 
    default: 
      return 102;
    case 1: 
    case 2: 
    case 3: 
      return 101;
    }
    return 103;
  }
  
  private static stSchema a(stNotificationRsp paramstNotificationRsp)
  {
    stSchema localstSchema = new stSchema();
    localstSchema.schema = a(paramstNotificationRsp);
    localstSchema.H5Url = paramstNotificationRsp.h5Url;
    return localstSchema;
  }
  
  private static WSDownloadParams a(stNotificationRsp paramstNotificationRsp)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mEventId = a(paramstNotificationRsp);
    localWSDownloadParams.mTestId = WeishiUtils.a(4);
    stReportItem localstReportItem = UserActionReportPresenter.a();
    localstReportItem.pagetype = 4;
    localstReportItem.optype = 115;
    localWSDownloadParams.mStReportItem = localstReportItem;
    localWSDownloadParams.mScheme = a(paramstNotificationRsp);
    return localWSDownloadParams;
  }
  
  private static String a(stNotificationRsp paramstNotificationRsp)
  {
    if (paramstNotificationRsp == null) {
      return "weishi://main";
    }
    if (!TextUtils.isEmpty(paramstNotificationRsp.scheme_url)) {
      return paramstNotificationRsp.scheme_url;
    }
    switch (paramstNotificationRsp.type)
    {
    default: 
      return "weishi://main";
    }
    return "weishi://message";
  }
  
  public static void a(Context paramContext, stNotificationRsp paramstNotificationRsp, String paramString)
  {
    if ((paramContext == null) || (paramstNotificationRsp == null)) {
      return;
    }
    stSchema localstSchema = a(paramstNotificationRsp);
    new WSStSchemaJumpManager(paramContext).a(localstSchema).a(true).a(a(paramstNotificationRsp)).a(new WSNoticeJumpUtils.1(paramstNotificationRsp, paramString)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSNoticeJumpUtils
 * JD-Core Version:    0.7.0.1
 */