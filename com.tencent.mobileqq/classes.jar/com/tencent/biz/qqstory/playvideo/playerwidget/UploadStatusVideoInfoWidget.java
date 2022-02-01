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
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean f;
  
  public UploadStatusVideoInfoWidget(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  public String a()
  {
    return "UploadStatusVideoInfoWidget";
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131380770));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380772));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131380771));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380773));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.isUploadFail())
    {
      j();
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramStoryVideoItem.mUpLoadFailedError != 10404) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699934);
      } else {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699936);
      }
      if (this.f)
      {
        this.f = false;
        StoryReportor.a("play_video", "retrypub_fail", 0, 0, new String[] { String.valueOf(a().mReportData.from), "", "", paramStoryVideoItem.mVid });
        return;
      }
      StoryReportor.a("play_video", "exp_pub_fail", 0, 0, new String[] { String.valueOf(a().mReportData.from), "", "", paramStoryVideoItem.mVid });
      return;
    }
    if (paramStoryVideoItem.isUploading())
    {
      j();
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      int i = StoryVideoUploadProgressManager.a().a(paramStoryVideoItem.mVid);
      if (i >= 0)
      {
        TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131715694));
        localStringBuilder.append(i);
        localStringBuilder.append("%");
        localTextView.setText(localStringBuilder.toString());
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715696));
      }
      StoryVideoUploadProgressManager.a().a(paramStoryVideoItem.mVid, new UploadStatusVideoInfoWidget.1(this));
      return;
    }
    k();
  }
  
  public void a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    a(paramStoryVideoItem);
  }
  
  protected void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new UploadStatusVideoInfoWidget.StoryVideoPublishStatusReceiver(this), "");
  }
  
  protected boolean a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramStoryVideoItem.isUploadFail()) || (paramStoryVideoItem.isUploading());
  }
  
  public int b()
  {
    return 2131561822;
  }
  
  protected void f() {}
  
  protected void g() {}
  
  public void onClick(View paramView)
  {
    StoryVideoItem localStoryVideoItem;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData != null) {
      localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
    } else {
      localStoryVideoItem = null;
    }
    if (localStoryVideoItem == null)
    {
      SLog.d(this.b, "video item not found ,click error..");
    }
    else if (paramView.getId() == 2131380770)
    {
      int i = localStoryVideoItem.mUploadStatus;
      if ((i == 3) || (i == 6))
      {
        if (!PlayModeUtils.a(localStoryVideoItem, b())) {
          StoryReportor.a("play_video", "retrypub_fail", 0, 0, new String[0]);
        } else {
          this.f = true;
        }
        StoryReportor.a("play_video", "clk_pub_fail", 0, 0, new String[] { String.valueOf(a().mReportData.from) });
        SLog.b(this.b, "on retry click !");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.UploadStatusVideoInfoWidget
 * JD-Core Version:    0.7.0.1
 */