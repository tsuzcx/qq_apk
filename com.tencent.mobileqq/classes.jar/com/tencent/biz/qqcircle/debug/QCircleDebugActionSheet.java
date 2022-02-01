package com.tencent.biz.qqcircle.debug;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.requests.QCircleFeedbackHitRequest;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleFeedbackhit.StFeedbackCommonInfo;

public class QCircleDebugActionSheet
{
  public static void a(Activity paramActivity, QCircleShareInfo paramQCircleShareInfo)
  {
    if ((paramQCircleShareInfo != null) && (paramQCircleShareInfo.b != null))
    {
      if (paramActivity == null) {
        return;
      }
      paramActivity = ActionSheet.a(paramActivity);
      paramActivity.a(2131895680, 0);
      paramActivity.a(2131895681, 0);
      paramActivity.a(2131895663, 0);
      paramActivity.a(2131895662, 0);
      paramActivity.e(2131887648);
      paramActivity.a(new QCircleDebugActionSheet.1(paramActivity, paramQCircleShareInfo));
      if (!paramActivity.isShowing()) {
        paramActivity.show();
      }
    }
  }
  
  private static void a(FeedCloudMeta.StFeed paramStFeed, int paramInt1, int paramInt2)
  {
    QQCircleFeedbackhit.StFeedbackCommonInfo localStFeedbackCommonInfo = new QQCircleFeedbackhit.StFeedbackCommonInfo();
    localStFeedbackCommonInfo.feedId.set(paramStFeed.id.get());
    localStFeedbackCommonInfo.sourceUin.set(paramStFeed.poster.id.get());
    localStFeedbackCommonInfo.operationUin.set(HostDataTransUtils.getAccount());
    localStFeedbackCommonInfo.level.set(paramInt2);
    String str2 = paramStFeed.poster.nick.get();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramStFeed.id.get();
    }
    localStFeedbackCommonInfo.sourceUinName.set(str1);
    paramStFeed = new FeedCloudCommon.StCommonExt();
    VSNetworkHelper.getInstance().sendRequest(new QCircleFeedbackHitRequest(localStFeedbackCommonInfo, paramInt1, paramStFeed), new QCircleDebugActionSheet.2());
  }
  
  private static void e(FeedCloudMeta.StFeed paramStFeed)
  {
    a(paramStFeed, 0, 0);
  }
  
  private static void f(FeedCloudMeta.StFeed paramStFeed)
  {
    a(paramStFeed, 3, 0);
  }
  
  private static void g(FeedCloudMeta.StFeed paramStFeed)
  {
    a(paramStFeed, 4, 0);
  }
  
  private static void h(FeedCloudMeta.StFeed paramStFeed)
  {
    a(paramStFeed, 2, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.debug.QCircleDebugActionSheet
 * JD-Core Version:    0.7.0.1
 */