package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Dialog;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
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
  
  public WeishiTagVideoInfoWidget(View paramView)
  {
    super(paramView);
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
      int i = paramStoryPlayerVideoData.mSourceTagType;
      if (i != 1) {
        break label123;
      }
      j();
      ReportController.b(null, "dc00898", "", "", "weishi_share_videoplay", "story_entry_exp", 0, 0, "", "", "", "");
      paramStoryVideoItem = VideoSourceTagInfoHelper.b(i);
      switch (i)
      {
      default: 
        paramStoryPlayerVideoData = paramStoryVideoItem;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStoryPlayerVideoData);
      return;
      this.f = true;
      this.c = paramStoryVideoItem.mVid;
      break;
      label123:
      k();
      return;
      paramStoryPlayerVideoData = paramStoryVideoItem;
      if (TextUtils.isEmpty(paramStoryVideoItem)) {
        paramStoryPlayerVideoData = "来自微视APP";
      }
    }
  }
  
  protected void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new WeishiTagVideoInfoWidget.GetUserInfoReceiver(this), "");
  }
  
  protected boolean a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    if ((paramStoryPlayerVideoData.a != null) && (paramStoryPlayerVideoData.a.a == 13)) {}
    while (paramStoryVideoItem.mSourceTagType != 1) {
      return false;
    }
    return true;
  }
  
  protected int b()
  {
    return -1;
  }
  
  protected void f() {}
  
  protected void g() {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
      if (localObject != null) {
        break label41;
      }
      SLog.e(this.b, "click error , video info not found");
    }
    label41:
    VideoViewVideoHolder localVideoViewVideoHolder;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = null;
      break;
      localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
      VideoSourceTagInfoHelper.a(((StoryVideoItem)localObject).mSourceTagType);
      switch (((StoryVideoItem)localObject).mSourceTagType)
      {
      }
    }
    Dialog localDialog = WeShiGuideDialog.a(b(), ((StoryVideoItem)localObject).mOwnerUid, "4", ((StoryVideoItem)localObject).mVid, 3, ((StoryVideoItem)localObject).mWsSchema);
    if (localDialog != null)
    {
      localDialog.setOnDismissListener(new WeishiTagVideoInfoWidget.1(this, localVideoViewVideoHolder));
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
    }
    int i;
    if (WeishiGuideUtils.a(b()))
    {
      i = 2;
      label154:
      StoryReportor.a("weishi_share", "tag_clk", 0, i, new String[] { "4", ((StoryVideoItem)localObject).mOwnerUid, "weishi", ((StoryVideoItem)localObject).mVid });
      if (!WeishiGuideUtils.a(b())) {
        break label235;
      }
    }
    label235:
    for (Object localObject = "story_clk_ws";; localObject = "story_dl_ws")
    {
      ReportController.b(null, "dc00898", "", "", "weishi_share_videoplay", (String)localObject, 0, 0, "", "", "", "");
      break;
      i = 1;
      break label154;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.WeishiTagVideoInfoWidget
 * JD-Core Version:    0.7.0.1
 */