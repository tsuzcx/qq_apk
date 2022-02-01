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
  private static stSchema a(stNotificationRsp paramstNotificationRsp)
  {
    stSchema localstSchema = new stSchema();
    localstSchema.schema = b(paramstNotificationRsp);
    localstSchema.H5Url = paramstNotificationRsp.h5Url;
    return localstSchema;
  }
  
  public static void a(Context paramContext, stNotificationRsp paramstNotificationRsp, String paramString)
  {
    if (paramContext != null)
    {
      if (paramstNotificationRsp == null) {
        return;
      }
      stSchema localstSchema = a(paramstNotificationRsp);
      new WSStSchemaJumpManager(paramContext).a(localstSchema).a(true).a(c(paramstNotificationRsp)).a(new WSNoticeJumpUtils.1(paramstNotificationRsp, paramString)).j();
    }
  }
  
  private static String b(stNotificationRsp paramstNotificationRsp)
  {
    if (paramstNotificationRsp == null) {
      return "weishi://main";
    }
    if (!TextUtils.isEmpty(paramstNotificationRsp.scheme_url)) {
      return paramstNotificationRsp.scheme_url;
    }
    int i = paramstNotificationRsp.type;
    if ((i != 1) && (i != 2) && (i != 3)) {
      return "weishi://main";
    }
    return "weishi://message";
  }
  
  private static WSDownloadParams c(stNotificationRsp paramstNotificationRsp)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mEventId = d(paramstNotificationRsp);
    localWSDownloadParams.mTestId = WeishiUtils.a(4);
    stReportItem localstReportItem = UserActionReportPresenter.a();
    localstReportItem.pagetype = 4;
    localstReportItem.optype = 115;
    localWSDownloadParams.mStReportItem = localstReportItem;
    localWSDownloadParams.mScheme = b(paramstNotificationRsp);
    return localWSDownloadParams;
  }
  
  private static int d(stNotificationRsp paramstNotificationRsp)
  {
    if (paramstNotificationRsp == null) {
      return 102;
    }
    int i = paramstNotificationRsp.type;
    if ((i != 1) && (i != 2) && (i != 3))
    {
      if (i != 6) {
        return 102;
      }
      return 103;
    }
    return 101;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSNoticeJumpUtils
 * JD-Core Version:    0.7.0.1
 */