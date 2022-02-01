package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.video.share.ShareAction;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class VideoFeedsShareController$ReportDislikeAction
  extends ShareAction
{
  VideoFeedsShareController$ReportDislikeAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public int a()
  {
    return 7;
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoFeedsShareController.b(this.a, true);
    paramVideoInfo = new JSONObject();
    try
    {
      paramVideoInfo.put("channel_id", 409409);
      paramVideoInfo.put("source", 2);
      paramString = VideoFeedsShareController.a(this.a);
      if ((paramString.a != null) && (paramString.a.size() > 0))
      {
        VideoFeedsShareController.a(this.a, (ActionSheet)ActionSheetHelper.a(VideoFeedsShareController.a(this.a), null));
        paramActionSheetItem = new VideoFeedsShareController.ReportDislikeAction.1(this);
        VideoFeedsShareController.a(this.a).registerWatchDisMissActionListener(paramActionSheetItem);
        paramActionSheetItem = new ReadInJoyDisLikeDialogView(VideoFeedsShareController.a(this.a));
        paramActionSheetItem.setOnUninterestConfirmListener(new VideoFeedsShareController.ReportDislikeAction.2(this, paramString, paramVideoInfo));
        paramActionSheetItem.setUninterestData(paramString.a);
        VideoFeedsShareController.a(this.a).setActionContentView(paramActionSheetItem, null);
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        try
        {
          if (!VideoFeedsShareController.a(this.a).isShowing())
          {
            if ((VersionUtils.g()) && (!ShortVideoUtils.isInFullScreenBlackList()))
            {
              VideoFeedsShareController.a(this.a).getWindow().setFlags(8, 8);
              VideoFeedsShareController.a(this.a).getWindow().getDecorView().setSystemUiVisibility(VideoFeedsShareController.a(this.a).getWindow().getDecorView().getSystemUiVisibility());
              VideoFeedsShareController.a(this.a).setOnShowListener(new VideoFeedsShareController.ReportDislikeAction.3(this));
            }
            VideoFeedsShareController.a(this.a).show();
            paramVideoInfo = new VideoR5.Builder(VideoReporter.a(null, null, null, null, paramVideoInfo)).i(paramString.g).a().a();
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, null, "0X800913B", "0X800913B", 0, 0, null, null, null, paramVideoInfo, false);
          }
          return;
        }
        catch (Exception paramVideoInfo)
        {
          VideoFeedsShareController.a(this.a, "dislikeSheet.show exception=" + paramVideoInfo);
          return;
        }
        paramString = paramString;
        paramString.printStackTrace();
      }
    }
    VideoFeedsShareController.a(this.a, "文章ID为：" + paramString.g + HardCodeUtil.a(2131716070));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.ReportDislikeAction
 * JD-Core Version:    0.7.0.1
 */