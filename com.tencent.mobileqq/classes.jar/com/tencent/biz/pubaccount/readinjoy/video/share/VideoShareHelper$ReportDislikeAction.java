package com.tencent.biz.pubaccount.readinjoy.video.share;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class VideoShareHelper$ReportDislikeAction
  extends ShareAction
{
  VideoShareHelper$ReportDislikeAction(VideoShareHelper paramVideoShareHelper) {}
  
  private void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    try
    {
      if (!VideoShareHelper.a(this.a).isShowing())
      {
        if ((VersionUtils.g()) && (!ShortVideoUtils.isInFullScreenBlackList()))
        {
          VideoShareHelper.a(this.a).getWindow().setFlags(8, 8);
          VideoShareHelper.a(this.a).getWindow().getDecorView().setSystemUiVisibility(VideoShareHelper.a(this.a).getWindow().getDecorView().getSystemUiVisibility());
          VideoShareHelper.a(this.a).setOnShowListener(new VideoShareHelper.ReportDislikeAction.3(this));
        }
        VideoShareHelper.a(this.a).show();
        paramBaseArticleInfo = new VideoR5.Builder(VideoReporter.a(null, null, null, null, paramJSONObject)).i(paramBaseArticleInfo.innerUniqueID).a().a();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, null, "0X800913B", "0X800913B", 0, 0, null, null, null, paramBaseArticleInfo, false);
      }
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "dislikeSheet.show exception=" + paramBaseArticleInfo);
    }
  }
  
  public int a()
  {
    return 7;
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoShareHelper.a(this.a, false);
    paramString = new JSONObject();
    try
    {
      paramString.put("channel_id", VideoShareHelper.a(this.a));
      paramString.put("source", 1);
      if ((paramBaseArticleInfo.mDislikeInfos != null) && (paramBaseArticleInfo.mDislikeInfos.size() > 0))
      {
        VideoShareHelper.a(this.a, (ActionSheet)ActionSheetHelper.a(VideoShareHelper.a(this.a), null));
        paramActionSheetItem = new VideoShareHelper.ReportDislikeAction.1(this);
        VideoShareHelper.a(this.a).registerWatchDisMissActionListener(paramActionSheetItem);
        paramActionSheetItem = new ReadInJoyDisLikeDialogView(VideoShareHelper.a(this.a));
        paramActionSheetItem.setOnUninterestConfirmListener(new VideoShareHelper.ReportDislikeAction.2(this, paramBaseArticleInfo, paramString));
        paramActionSheetItem.setUninterestData(paramBaseArticleInfo.mDislikeInfos);
        VideoShareHelper.a(this.a).setActionContentView(paramActionSheetItem, null);
        a(paramBaseArticleInfo, paramString);
        return;
      }
    }
    catch (JSONException paramActionSheetItem)
    {
      do
      {
        for (;;)
        {
          paramActionSheetItem.printStackTrace();
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "文章ID为：" + paramBaseArticleInfo.mArticleID + "的负反馈数据为空!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.share.VideoShareHelper.ReportDislikeAction
 * JD-Core Version:    0.7.0.1
 */