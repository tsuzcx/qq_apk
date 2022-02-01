package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.comment.StoryFailCommentCacher;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TrimmableManager;
import com.tencent.biz.qqstory.storyHome.QQStoryMainController;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;

public class Now
  extends Frame
{
  private long jdField_a_of_type_Long = -1L;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected ProgressBar a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected StoryConfigManager a;
  protected QQStoryMainController a;
  private MystoryListView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new Now.1(this);
  public String a;
  protected boolean a;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  private RelativeLayout d;
  
  public Now()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController = new QQStoryMainController(new Now.2(this), QQStoryMainController.b);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    case 3: 
    case 12: 
    default: 
      paramInt2 = 2;
    }
    for (;;)
    {
      StoryReportor.a("home_page", "time_stay", paramInt2, paramInt1, new String[] { "1", "1" });
      return;
      paramInt2 = 4;
      continue;
      paramInt2 = 3;
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.c(false);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131379533));
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131379451));
    IphoneTitleBarActivity.setLayerType((ViewGroup)a(2131377159));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131372446));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new Now.4(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131369534));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131363844));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719722);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369509));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131380176));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)a(2131375105));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      SimpleUIUtil.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850507);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850507);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167030));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167030));
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView = ((MystoryListView)a(2131375082));
    this.d = ((RelativeLayout)a(2131375022));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setIsNowTab(true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setDivider(null);
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getParent()).setBackgroundColor(a().getColor(2131167093));
  }
  
  @TargetApi(16)
  private void m()
  {
    int j = 1;
    if ((this.d == null) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView == null)) {
      return;
    }
    Object localObject;
    if (ThemeUtil.isNowThemeIsDIY())
    {
      localObject = new ThemeBackground();
      ThemeBackground.getThemeBackground(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getContext(), "theme_bg_message_path_png", ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getCurrentAccountUin(), (ThemeBackground)localObject);
      if (("null".equals(((ThemeBackground)localObject).path)) || (((ThemeBackground)localObject).img == null)) {
        break label265;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setContentBackground(((ThemeBackground)localObject).img);
      this.d.setBackgroundColor(a().getColor(2131167093));
    }
    label258:
    label265:
    for (int i = 1;; i = 0)
    {
      j = 0;
      while ((i == 0) && (j == 0))
      {
        if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_MqqAppAppRuntime, false, null)) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setContentBackground(a().getDrawable(2130850501), false);
        }
        for (;;)
        {
          this.d.setBackgroundColor(a().getColor(2131167093));
          return;
          if (!ThemeUtil.isNowThemeIsAnimate()) {
            break label258;
          }
          localObject = ThemeUtil.getAnimatePathByTag(2);
          Drawable localDrawable = super.a().getDrawable(2130850434);
          localObject = VasApngUtil.getApngDrawable(this.jdField_a_of_type_MqqAppAppRuntime, (String)localObject, "-conversation-", localDrawable, VasApngUtil.converstionTag, "-now-", null);
          if (localObject == null) {
            break label258;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setBackgroundDrawable(null);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setContentBackground(null);
          this.d.setBackgroundDrawable((Drawable)localObject);
          i = 0;
          break;
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setContentBackground(a().getDrawable(2130838980), false);
        }
        j = 0;
        i = 0;
      }
      break;
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    SLog.b("Q.qqstory.home:NowTab", "Now tab run onCreateView!");
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.inflate(2131561873, null));
    return this.jdField_b_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void a()
  {
    super.a();
    c();
    SLog.b("Q.qqstory.home:NowTab", "Now tab onFrameTabClick--------------");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    super.a(paramQBaseActivity);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(paramQBaseActivity);
  }
  
  protected void a(boolean paramBoolean)
  {
    View localView1;
    View localView2;
    if (((Boolean)((StoryConfigManager)SuperManager.a(10)).b("upload_video_use_bdh", Boolean.valueOf(false))).booleanValue())
    {
      localView1 = a().findViewById(16908307);
      localView2 = a().findViewById(16908305);
      if (!paramBoolean) {
        break label86;
      }
    }
    label86:
    for (int i = 0;; i = 8)
    {
      if (paramBoolean) {
        a().getDimensionPixelSize(2131297347);
      }
      if (localView1 != null) {
        localView1.setVisibility(i);
      }
      if (localView2 != null) {}
      return;
    }
  }
  
  public void b()
  {
    m();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      SimpleUIUtil.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850507);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850507);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167030));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167030));
    }
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    SLog.a("Q.qqstory.home:NowTab", "Now tab run onResume! tabChange=%s", Boolean.valueOf(paramBoolean));
    paramBoolean = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.c();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.b(a());
    if (this.jdField_b_of_type_Boolean)
    {
      if (FrameHelperActivity.b())
      {
        FrameHelperActivity.c(true);
        FrameHelperActivity.w();
      }
      this.jdField_b_of_type_Boolean = false;
    }
    if (!paramBoolean) {
      g();
    }
    Handler localHandler = new Handler();
    localHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    localHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
    ApngImage.playByTag(5);
    Bosses.get().postLightWeightJob(new Now.3(this), 10);
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.b()) {
      return true;
    }
    return super.b();
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getFirstVisiblePosition() > 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setSelection(0);
    }
  }
  
  public void e(boolean paramBoolean) {}
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager = ((StoryConfigManager)SuperManager.a(10));
    SLog.d("Q.qqstory.home:NowTab", "Now tab run onCreate! action:%d", new Object[] { Integer.valueOf(a().getIntent().getIntExtra("action", 0)) });
    i();
    j();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(null);
    this.jdField_a_of_type_Boolean = true;
    StoryUploadProcessor.checkUploadSessionKey();
    ((TrimmableManager)SuperManager.a(26)).a(0);
  }
  
  public void h()
  {
    super.h();
    SLog.d("Q.qqstory.home:NowTab", "Now tab run onStop!");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.c(a());
  }
  
  public void k()
  {
    super.k();
    SLog.d("Q.qqstory.home:NowTab", "Now tab run onDestroy!");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.d(a());
    StoryFailCommentCacher.a().b();
  }
  
  public void l()
  {
    super.l();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.j();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.b();
  }
  
  public void n()
  {
    super.n();
    SLog.d("Q.qqstory.home:NowTab", "Now tab run onPause!");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a();
    new Handler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ApngImage.pauseByTag(5);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.b();
    if ((this.jdField_a_of_type_Long > 0L) && (a().isResume()))
    {
      int i = a().getIntent().getIntExtra("action", 0);
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = -1L;
      a((int)(l1 - l2), i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Now
 * JD-Core Version:    0.7.0.1
 */