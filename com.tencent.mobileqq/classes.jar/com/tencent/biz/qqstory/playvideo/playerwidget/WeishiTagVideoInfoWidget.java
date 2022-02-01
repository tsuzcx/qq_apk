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
  private TextView a;
  private String c = "";
  private boolean f = false;
  
  public WeishiTagVideoInfoWidget(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  public String a()
  {
    return "WeishiTagVideoInfoWidget";
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  protected void a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    paramStoryPlayerVideoData = paramStoryPlayerVideoData.a();
    if (paramStoryPlayerVideoData == null)
    {
      k();
      return;
    }
    if (TextUtils.equals(this.c, paramStoryVideoItem.mVid))
    {
      this.f = false;
    }
    else
    {
      this.f = true;
      this.c = paramStoryVideoItem.mVid;
    }
    int i = paramStoryPlayerVideoData.mSourceTagType;
    if (i == 1)
    {
      j();
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStoryPlayerVideoData);
      return;
    }
    k();
  }
  
  protected void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new WeishiTagVideoInfoWidget.GetUserInfoReceiver(this), "");
  }
  
  protected boolean a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    if ((paramStoryPlayerVideoData.a != null) && (paramStoryPlayerVideoData.a.a == 13)) {
      return false;
    }
    return paramStoryVideoItem.mSourceTagType == 1;
  }
  
  protected int b()
  {
    return -1;
  }
  
  protected void f() {}
  
  protected void g() {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData != null) {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      SLog.e(this.b, "click error , video info not found");
    }
    else
    {
      VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
      VideoSourceTagInfoHelper.a(((StoryVideoItem)localObject).mSourceTagType);
      if (((StoryVideoItem)localObject).mSourceTagType == 1)
      {
        Dialog localDialog = WeShiGuideDialog.a(b(), ((StoryVideoItem)localObject).mOwnerUid, "4", ((StoryVideoItem)localObject).mVid, 3, ((StoryVideoItem)localObject).mWsSchema);
        if (localDialog != null)
        {
          localDialog.setOnDismissListener(new WeishiTagVideoInfoWidget.1(this, localVideoViewVideoHolder));
          if (localVideoViewVideoHolder != null) {
            localVideoViewVideoHolder.c(true);
          }
        }
        int i;
        if (WeishiGuideUtils.a(b())) {
          i = 2;
        } else {
          i = 1;
        }
        StoryReportor.a("weishi_share", "tag_clk", 0, i, new String[] { "4", ((StoryVideoItem)localObject).mOwnerUid, "weishi", ((StoryVideoItem)localObject).mVid });
        if (WeishiGuideUtils.a(b())) {
          localObject = "story_clk_ws";
        } else {
          localObject = "story_dl_ws";
        }
        ReportController.b(null, "dc00898", "", "", "weishi_share_videoplay", (String)localObject, 0, 0, "", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.WeishiTagVideoInfoWidget
 * JD-Core Version:    0.7.0.1
 */