package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Dialog;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.VideoSourceTagInfoHelper;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.biz.qqstory.view.WeShiGuideDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;

public class WeishiTagVideoInfoWidget
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private TextView s;
  private boolean t = false;
  private String u = "";
  
  public WeishiTagVideoInfoWidget(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected void a(View paramView)
  {
    this.s = ((TextView)paramView);
    this.s.setOnClickListener(this);
  }
  
  protected void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new WeishiTagVideoInfoWidget.GetUserInfoReceiver(this), "");
  }
  
  protected boolean a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    if ((paramStoryPlayerVideoData.a != null) && (paramStoryPlayerVideoData.a.b == 13)) {
      return false;
    }
    return paramStoryVideoItem.mSourceTagType == 1;
  }
  
  protected void b(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    paramStoryPlayerVideoData = paramStoryPlayerVideoData.e();
    if (paramStoryPlayerVideoData == null)
    {
      A();
      return;
    }
    if (TextUtils.equals(this.u, paramStoryVideoItem.mVid))
    {
      this.t = false;
    }
    else
    {
      this.t = true;
      this.u = paramStoryVideoItem.mVid;
    }
    int i = paramStoryPlayerVideoData.mSourceTagType;
    if (i == 1)
    {
      z();
      ReportController.b(null, "dc00898", "", "", "weishi_share_videoplay", "story_entry_exp", 0, 0, "", "", "", "");
      paramStoryVideoItem = VideoSourceTagInfoHelper.b(i);
      if (i != 1)
      {
        paramStoryPlayerVideoData = paramStoryVideoItem;
      }
      else
      {
        paramStoryPlayerVideoData = paramStoryVideoItem;
        if (TextUtils.isEmpty(paramStoryVideoItem)) {
          paramStoryPlayerVideoData = "来自微视APP";
        }
      }
      this.s.setText(paramStoryPlayerVideoData);
      return;
    }
    A();
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (this.p != null) {
      localObject = this.p.e();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      SLog.e(this.i, "click error , video info not found");
    }
    else
    {
      VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)d()).r();
      VideoSourceTagInfoHelper.a(((StoryVideoItem)localObject).mSourceTagType);
      if (((StoryVideoItem)localObject).mSourceTagType == 1)
      {
        Dialog localDialog = WeShiGuideDialog.a(y(), ((StoryVideoItem)localObject).mOwnerUid, "4", ((StoryVideoItem)localObject).mVid, 3, ((StoryVideoItem)localObject).mWsSchema);
        if (localDialog != null)
        {
          localDialog.setOnDismissListener(new WeishiTagVideoInfoWidget.1(this, localVideoViewVideoHolder));
          if (localVideoViewVideoHolder != null) {
            localVideoViewVideoHolder.c(true);
          }
        }
        int i;
        if (WeishiGuideUtils.a(y())) {
          i = 2;
        } else {
          i = 1;
        }
        StoryReportor.a("weishi_share", "tag_clk", 0, i, new String[] { "4", ((StoryVideoItem)localObject).mOwnerUid, "weishi", ((StoryVideoItem)localObject).mVid });
        if (WeishiGuideUtils.a(y())) {
          localObject = "story_clk_ws";
        } else {
          localObject = "story_dl_ws";
        }
        ReportController.b(null, "dc00898", "", "", "weishi_share_videoplay", (String)localObject, 0, 0, "", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void q() {}
  
  protected void r() {}
  
  protected int s()
  {
    return -1;
  }
  
  public String t()
  {
    return "WeishiTagVideoInfoWidget";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.WeishiTagVideoInfoWidget
 * JD-Core Version:    0.7.0.1
 */