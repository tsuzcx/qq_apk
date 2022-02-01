package com.tencent.biz.qqcircle.flutter.utils;

import android.app.Activity;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;

public class QCircleFlutterNativeShareUtils
{
  private static QCircleShareInfo a(FeedCloudMeta.StFeed paramStFeed, QCircleExtraTypeInfo paramQCircleExtraTypeInfo, int paramInt, boolean paramBoolean)
  {
    QCircleShareInfo localQCircleShareInfo = new QCircleShareInfo();
    localQCircleShareInfo.c = paramQCircleExtraTypeInfo;
    localQCircleShareInfo.b = paramStFeed;
    localQCircleShareInfo.d = 0;
    if (paramBoolean)
    {
      localQCircleShareInfo.j = (QCirclePluginUtil.d(localQCircleShareInfo.b) ^ true);
      localQCircleShareInfo.k = true;
      localQCircleShareInfo.i = QCirclePluginUtil.d(localQCircleShareInfo.b);
      localQCircleShareInfo.l = false;
      localQCircleShareInfo.m = false;
      paramQCircleExtraTypeInfo = new QQCircleFeedBase.StFeedBusiReqData();
    }
    for (;;)
    {
      try
      {
        paramQCircleExtraTypeInfo.mergeFrom(paramStFeed.busiData.get().toByteArray());
        List localList = paramQCircleExtraTypeInfo.uninterest_buttons.get();
        if ((localList == null) || (localList.size() <= 0)) {
          break label361;
        }
        paramBoolean = true;
        localQCircleShareInfo.l = paramBoolean;
        if ((paramQCircleExtraTypeInfo.pushList != null) && (QCirclePushInfoManager.a().d(paramStFeed.id.get())))
        {
          localQCircleShareInfo.n = true;
          a(localQCircleShareInfo);
        }
      }
      catch (Exception paramQCircleExtraTypeInfo)
      {
        QLog.e("QCircleFlutterNativeShareUtils", 1, "[createShareInfo]", paramQCircleExtraTypeInfo);
      }
      paramQCircleExtraTypeInfo = paramStFeed.opMask2.get();
      if (paramQCircleExtraTypeInfo != null)
      {
        if ((!QCirclePluginUtil.b((FeedCloudMeta.StUser)paramStFeed.poster.get())) && (paramQCircleExtraTypeInfo.contains(Integer.valueOf(1)))) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        localQCircleShareInfo.m = paramBoolean;
        localQCircleShareInfo.p = paramQCircleExtraTypeInfo.contains(Integer.valueOf(10));
        localQCircleShareInfo.e = paramInt;
        QLog.d("QCircleFlutterNativeShareUtils", 1, new Object[] { "[createShareInfo] ", "isShowHideThisWork: ", Boolean.valueOf(localQCircleShareInfo.m), " | isShowDownLoad: ", Boolean.valueOf(localQCircleShareInfo.p), " | picDownPos: ", Integer.valueOf(paramInt) });
        return localQCircleShareInfo;
        localQCircleShareInfo.l = false;
        localQCircleShareInfo.i = false;
        localQCircleShareInfo.p = false;
        localQCircleShareInfo.j = false;
        localQCircleShareInfo.k = false;
        localQCircleShareInfo.n = false;
      }
      return localQCircleShareInfo;
      label361:
      paramBoolean = false;
    }
  }
  
  public static void a(Activity paramActivity, QCircleFlutterNativeShareUtils.ShareActionSheetParam paramShareActionSheetParam)
  {
    Object localObject2 = null;
    QCircleExtraTypeInfo localQCircleExtraTypeInfo;
    if (paramShareActionSheetParam == null) {
      localQCircleExtraTypeInfo = null;
    } else {
      localQCircleExtraTypeInfo = QCircleFlutterNativeShareUtils.ShareActionSheetParam.a(paramShareActionSheetParam);
    }
    FeedCloudMeta.StFeed localStFeed;
    if (localQCircleExtraTypeInfo == null) {
      localStFeed = null;
    } else {
      localStFeed = localQCircleExtraTypeInfo.mFeed;
    }
    Object localObject1;
    if (paramShareActionSheetParam == null) {
      localObject1 = null;
    } else {
      localObject1 = Integer.valueOf(QCircleFlutterNativeShareUtils.ShareActionSheetParam.b(paramShareActionSheetParam));
    }
    int i = ((Integer)localObject1).intValue();
    if (paramShareActionSheetParam == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = QCircleFlutterNativeShareUtils.ShareActionSheetParam.c(paramShareActionSheetParam);
    }
    if (localStFeed == null)
    {
      QLog.d("QCircleFlutterNativeShareUtils", 1, "[showShareActionSheet] feed not is null.");
      return;
    }
    paramShareActionSheetParam = a(localStFeed, localQCircleExtraTypeInfo, i, paramShareActionSheetParam.a());
    paramActivity = new QCircleSharePartV2(paramActivity);
    paramActivity.a((QCircleReportBean)localObject1);
    paramActivity.a("share_action_show_share_sheet", paramShareActionSheetParam);
  }
  
  private static void a(QCircleShareInfo paramQCircleShareInfo)
  {
    if (paramQCircleShareInfo == null) {
      return;
    }
    Object localObject = paramQCircleShareInfo.c;
    QCircleLpReportDc05507.DataBuilder localDataBuilder = null;
    if (localObject != null) {
      localObject = paramQCircleShareInfo.c.mFeed;
    } else {
      localObject = null;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder1 = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject).setActionType(122).setSubActionType(1);
    localObject = paramQCircleShareInfo.c;
    String str = "";
    if ((localObject != null) && (paramQCircleShareInfo.c.mFeed != null)) {
      localObject = paramQCircleShareInfo.c.mFeed.poster.id.get();
    } else {
      localObject = "";
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(localDataBuilder1.setToUin((String)localObject)));
    localObject = localDataBuilder;
    if (paramQCircleShareInfo.c != null) {
      localObject = paramQCircleShareInfo.c.mFeed;
    }
    localDataBuilder = QCirclePluginReportUtil.d((FeedCloudMeta.StFeed)localObject).setActionType(122).setSubActionType(1);
    localObject = str;
    if (paramQCircleShareInfo.c != null)
    {
      localObject = str;
      if (paramQCircleShareInfo.c.mFeed != null) {
        localObject = paramQCircleShareInfo.c.mFeed.poster.id.get();
      }
    }
    QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(localDataBuilder.setToUin((String)localObject)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.utils.QCircleFlutterNativeShareUtils
 * JD-Core Version:    0.7.0.1
 */