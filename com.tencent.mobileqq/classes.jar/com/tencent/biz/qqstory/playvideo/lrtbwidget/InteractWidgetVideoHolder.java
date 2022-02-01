package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeInteractViewUtils;
import com.tencent.biz.qqstory.playmode.util.PlayModePollViewUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.PollWidgetUtils;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.IPollWidget;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.OnPollDetailClickListener;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.OnWidgetElementClickListener;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetElement;
import com.tencent.biz.qqstory.view.widget.InteractPasterWidget;
import com.tencent.biz.qqstory.view.widget.RateWidget;
import com.tencent.biz.qqstory.view.widget.RateWidget.AttendViewClickListener;
import com.tencent.biz.qqstory.view.widget.RateWidget.WidgetRatingChangedListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.Locale;

public class InteractWidgetVideoHolder
  extends VideoHolderBase
  implements PollWidgetUtils.OnPollDetailClickListener, PollWidgetUtils.OnWidgetElementClickListener, RateWidget.AttendViewClickListener, RateWidget.WidgetRatingChangedListener, IEventReceiver
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373354);
  private InteractWidgetVideoHolder.GetPollInfoReceiver jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetInteractWidgetVideoHolder$GetPollInfoReceiver;
  private InteractWidgetVideoHolder.SendVidRateDataResultReceiver jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetInteractWidgetVideoHolder$SendVidRateDataResultReceiver;
  private PollWidgetUtils.IPollWidget jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget;
  private InteractPasterWidget jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget;
  private boolean c = false;
  
  public InteractWidgetVideoHolder(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    paramViewGroup.setVisibility(4);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull StoryPlayerVideoData paramStoryPlayerVideoData, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramStoryPlayerVideoData, paramStoryPlayerGroupHolder);
    if (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.c()) {
      return;
    }
    paramStoryPlayerVideoData = ((StoryManager)SuperManager.a(5)).b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a);
    if ((paramStoryPlayerVideoData != null) && (paramStoryPlayerVideoData.isPollVideo()))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget = PollWidgetUtils.a(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext(), 1, 1, null);
      }
      PlayModePollViewUtils.a(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget, 0, paramStoryPlayerVideoData);
      PlayModePollViewUtils.b(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget, paramInt2, paramStoryPlayerVideoData);
      return;
    }
    if ((paramStoryPlayerVideoData != null) && (paramStoryPlayerVideoData.isInteractVideo()))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget = new RateWidget(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
      }
      PlayModeInteractViewUtils.a(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget, paramInt2, paramStoryPlayerVideoData);
      PlayModeInteractViewUtils.b(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget, paramInt2, paramStoryPlayerVideoData);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
  }
  
  public void a(PollWidgetUtils.IPollWidget paramIPollWidget)
  {
    paramIPollWidget = ((StoryManager)SuperManager.a(5)).b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a);
    if (paramIPollWidget != null)
    {
      StoryReportor.a("play_video", "vote_detail", 1, 0, new String[0]);
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "https://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0&vid=%s", new Object[] { paramIPollWidget.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a().startActivity(localIntent);
    }
  }
  
  public void a(PollWidgetUtils.IPollWidget paramIPollWidget, PollWidgetUtils.WidgetElement paramWidgetElement)
  {
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a);
    if (localStoryVideoItem == null) {
      return;
    }
    PlayModePollViewUtils.a(this, this, paramIPollWidget, this.b, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.b, localStoryVideoItem, paramWidgetElement);
  }
  
  public void a(RateWidget paramRateWidget)
  {
    paramRateWidget = ((StoryManager)SuperManager.a(5)).b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a);
    if (paramRateWidget != null)
    {
      StoryReportor.a("play_video", "vote_detail", 2, 0, new String[0]);
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "https://story.now.qq.com/m/score/index.html?vid=%s&_wv=3&_nav_alpha=0", new Object[] { paramRateWidget.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a().startActivity(localIntent);
    }
  }
  
  public void a(RateWidget paramRateWidget, float paramFloat)
  {
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a);
    if (localStoryVideoItem == null)
    {
      SLog.e("InteractWidgetPageHolder", "video item is null while rate changed.");
      return;
    }
    PlayModeInteractViewUtils.a(this.b, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.b, localStoryVideoItem, paramRateWidget, paramFloat);
  }
  
  protected void b()
  {
    super.b();
    this.c = true;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetInteractWidgetVideoHolder$GetPollInfoReceiver = new InteractWidgetVideoHolder.GetPollInfoReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetInteractWidgetVideoHolder$SendVidRateDataResultReceiver = new InteractWidgetVideoHolder.SendVidRateDataResultReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetInteractWidgetVideoHolder$GetPollInfoReceiver);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetInteractWidgetVideoHolder$SendVidRateDataResultReceiver);
    a(new InteractWidgetVideoHolder.1(this));
  }
  
  public boolean isValidate()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.InteractWidgetVideoHolder
 * JD-Core Version:    0.7.0.1
 */