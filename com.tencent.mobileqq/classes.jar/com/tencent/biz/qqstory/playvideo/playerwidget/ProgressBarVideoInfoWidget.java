package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.graphics.Color;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.playvideo.NewProgressControler;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.GroupHolderContainer;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.SplitedProgressBar;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.util.LiuHaiUtils;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;
import mqq.os.MqqHandler;

public class ProgressBarVideoInfoWidget
  extends AbsVideoInfoWidget
{
  @NonNull
  private NewProgressControler a;
  public SplitedProgressBar a;
  
  public ProgressBarVideoInfoWidget(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private int d()
  {
    int i = ScreenUtil.getInstantScreenWidth(this.jdField_a_of_type_AndroidViewView.getContext());
    int j = ScreenUtil.getInstantScreenHeight(this.jdField_a_of_type_AndroidViewView.getContext());
    int k = ScreenUtil.getNavigationBarHeight(this.jdField_a_of_type_AndroidViewView.getContext());
    boolean bool = ScreenUtil.checkDeviceHasNavigationBar(this.jdField_a_of_type_AndroidViewView.getContext());
    int m = ScreenUtil.getRealWidth(this.jdField_a_of_type_AndroidViewView.getContext());
    int n = ScreenUtil.getRealHeight(this.jdField_a_of_type_AndroidViewView.getContext());
    SLog.b("FredguoFix", "hasNavi: " + bool + ", naviHeight " + k);
    SLog.b("FredguoFix", "debug: instantWidth " + i + ", instantHeight" + j + ", rawWidth " + m + ", rawHeight " + n);
    SLog.b("FredguoFix", "ScreenWidth " + ScreenUtil.SCREEN_WIDTH + ", ScreenHeight " + ScreenUtil.SCREEN_HIGHT);
    if (bool) {
      return -2;
    }
    return (int)Math.min(ScreenUtil.SCREEN_HIGHT - ScreenUtil.SCREEN_WIDTH / 9.0F * 16.0F, 140.0F);
  }
  
  public String a()
  {
    return "ProgressBarVideoInfoWidget";
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar = ((SplitedProgressBar)paramView.findViewById(2131381504));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoNewProgressControler = new NewProgressControler(this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar);
    if (LiuHaiUtils.c(b()))
    {
      paramView = (LinearLayout)a().jdField_a_of_type_AndroidViewView.findViewById(2131363822);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.height = d();
      if (!ScreenUtil.checkDeviceHasNavigationBar(this.jdField_a_of_type_AndroidViewView.getContext())) {
        paramView.setBackgroundColor(Color.parseColor("#181818"));
      }
      paramView.setLayoutParams(localLayoutParams);
    }
    a(new ProgressBarVideoInfoWidget.1(this));
  }
  
  protected void a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem) {}
  
  public void a(IVideoView paramIVideoView)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ProgressBarVideoInfoWidget.2(this, paramIVideoView));
    }
    if (!this.d)
    {
      h();
      j();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoNewProgressControler != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoNewProgressControler.a(paramIVideoView);
    }
  }
  
  protected void a(@NonNull Map<Subscriber, String> paramMap) {}
  
  protected boolean a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramStoryPlayerVideoData.a == null) || (paramStoryPlayerVideoData.a.a != 13);
  }
  
  protected int b()
  {
    return 2131561967;
  }
  
  protected void f() {}
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoNewProgressControler.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.ProgressBarVideoInfoWidget
 * JD-Core Version:    0.7.0.1
 */