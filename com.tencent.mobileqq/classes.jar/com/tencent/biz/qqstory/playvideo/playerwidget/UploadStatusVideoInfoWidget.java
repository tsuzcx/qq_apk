package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;

public class UploadStatusVideoInfoWidget
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private LinearLayout s;
  private ImageView t;
  private ProgressBar u;
  private TextView v;
  private boolean w;
  
  public UploadStatusVideoInfoWidget(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  public void a(View paramView)
  {
    this.s = ((LinearLayout)paramView.findViewById(2131449739));
    this.t = ((ImageView)paramView.findViewById(2131449741));
    this.u = ((ProgressBar)paramView.findViewById(2131449740));
    this.v = ((TextView)paramView.findViewById(2131449742));
    this.s.setOnClickListener(this);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.isUploadFail())
    {
      z();
      this.u.setVisibility(8);
      this.t.setVisibility(0);
      if (paramStoryVideoItem.mUpLoadFailedError != 10404) {
        this.v.setText(2131897987);
      } else {
        this.v.setText(2131897989);
      }
      if (this.w)
      {
        this.w = false;
        StoryReportor.a("play_video", "retrypub_fail", 0, 0, new String[] { String.valueOf(i().mReportData.from), "", "", paramStoryVideoItem.mVid });
        return;
      }
      StoryReportor.a("play_video", "exp_pub_fail", 0, 0, new String[] { String.valueOf(i().mReportData.from), "", "", paramStoryVideoItem.mVid });
      return;
    }
    if (paramStoryVideoItem.isUploading())
    {
      z();
      this.u.setVisibility(0);
      this.t.setVisibility(8);
      int i = StoryVideoUploadProgressManager.a().f(paramStoryVideoItem.mVid);
      if (i >= 0)
      {
        TextView localTextView = this.v;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131913160));
        localStringBuilder.append(i);
        localStringBuilder.append("%");
        localTextView.setText(localStringBuilder.toString());
      }
      else
      {
        this.v.setText(HardCodeUtil.a(2131913162));
      }
      StoryVideoUploadProgressManager.a().a(paramStoryVideoItem.mVid, new UploadStatusVideoInfoWidget.1(this));
      return;
    }
    A();
  }
  
  protected void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new UploadStatusVideoInfoWidget.StoryVideoPublishStatusReceiver(this), "");
  }
  
  protected boolean a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramStoryVideoItem.isUploadFail()) || (paramStoryVideoItem.isUploading());
  }
  
  public void b(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    a(paramStoryVideoItem);
  }
  
  public void onClick(View paramView)
  {
    StoryVideoItem localStoryVideoItem;
    if (this.p != null) {
      localStoryVideoItem = this.p.e();
    } else {
      localStoryVideoItem = null;
    }
    if (localStoryVideoItem == null)
    {
      SLog.d(this.i, "video item not found ,click error..");
    }
    else if (paramView.getId() == 2131449739)
    {
      int i = localStoryVideoItem.mUploadStatus;
      if ((i == 3) || (i == 6))
      {
        if (!PlayModeUtils.a(localStoryVideoItem, y())) {
          StoryReportor.a("play_video", "retrypub_fail", 0, 0, new String[0]);
        } else {
          this.w = true;
        }
        StoryReportor.a("play_video", "clk_pub_fail", 0, 0, new String[] { String.valueOf(i().mReportData.from) });
        SLog.b(this.i, "on retry click !");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void q() {}
  
  protected void r() {}
  
  public int s()
  {
    return 2131628201;
  }
  
  public String t()
  {
    return "UploadStatusVideoInfoWidget";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.UploadStatusVideoInfoWidget
 * JD-Core Version:    0.7.0.1
 */