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
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
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
      break;
    case 8: 
    case 9: 
      paramInt2 = 3;
      break;
    case 1: 
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 10: 
    case 11: 
    case 13: 
      paramInt2 = 4;
    }
    StoryReportor.a("home_page", "time_stay", paramInt2, paramInt1, new String[] { "1", "1" });
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.c(false);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131378881));
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131378803));
    IphoneTitleBarActivity.setLayerType((ViewGroup)a(2131376636));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131372029));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new Now.4(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131369249));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131363772));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719446);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369224));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131379496));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)a(2131374622));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    else
    {
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850433);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850433);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167053));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167053));
    }
    SimpleUIUtil.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView = ((MystoryListView)a(2131374602));
    this.d = ((RelativeLayout)a(2131374553));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setIsNowTab(true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setDivider(null);
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getParent()).setBackgroundColor(a().getColor(2131167116));
  }
  
  @TargetApi(16)
  private void l()
  {
    if (this.d != null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView == null) {
        return;
      }
      boolean bool = ThemeUtil.isNowThemeIsDIY();
      int i = 1;
      Object localObject;
      int j;
      int k;
      if (bool)
      {
        localObject = new ThemeBackground();
        ThemeBackground.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getContext(), "theme_bg_message_path_png", ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getCurrentAccountUin(), (ThemeBackground)localObject);
        if ((!"null".equals(((ThemeBackground)localObject).jdField_a_of_type_JavaLangString)) && (((ThemeBackground)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setContentBackground(((ThemeBackground)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          this.d.setBackgroundColor(a().getColor(2131167116));
        }
        else
        {
          i = 0;
        }
        j = 0;
        k = i;
      }
      else
      {
        if (ThemeUtil.isNowThemeIsAnimate())
        {
          localObject = ThemeUtil.getAnimatePathByTag(2);
          Drawable localDrawable = super.a().getDrawable(2130850361);
          localObject = VasApngUtil.getApngDrawable(this.jdField_a_of_type_MqqAppAppRuntime, (String)localObject, "-conversation-", localDrawable, VasApngUtil.converstionTag, "-now-", null);
          if (localObject != null)
          {
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setBackgroundDrawable(null);
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setContentBackground(null);
            this.d.setBackgroundDrawable((Drawable)localObject);
            i = 1;
            break label206;
          }
        }
        i = 0;
        label206:
        k = 0;
        j = i;
      }
      if ((k == 0) && (j == 0))
      {
        if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_MqqAppAppRuntime, false, null)) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setContentBackground(a().getDrawable(2130850581), false);
        } else {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setContentBackground(a().getDrawable(2130838740), false);
        }
        this.d.setBackgroundColor(a().getColor(2131167116));
      }
    }
  }
  
  private void m()
  {
    ProgressBar localProgressBar = this.jdField_a_of_type_AndroidWidgetProgressBar;
    if (localProgressBar != null) {
      localProgressBar.setVisibility(0);
    }
  }
  
  private void n()
  {
    ProgressBar localProgressBar = this.jdField_a_of_type_AndroidWidgetProgressBar;
    if (localProgressBar != null) {
      localProgressBar.setVisibility(8);
    }
  }
  
  protected void U_()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getFirstVisiblePosition() > 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setSelection(0);
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    SLog.b("Q.qqstory.home:NowTab", "Now tab run onCreateView!");
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.inflate(2131561724, null));
    return this.jdField_b_of_type_AndroidWidgetRelativeLayout;
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager = ((StoryConfigManager)SuperManager.a(10));
    SLog.d("Q.qqstory.home:NowTab", "Now tab run onCreate! action:%d", new Object[] { Integer.valueOf(a().getIntent().getIntExtra("action", 0)) });
    j();
    k();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(null);
    this.jdField_a_of_type_Boolean = true;
    StoryUploadProcessor.checkUploadSessionKey();
    ((TrimmableManager)SuperManager.a(26)).a(0);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected void a(QBaseActivity paramQBaseActivity)
  {
    super.a(paramQBaseActivity);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(paramQBaseActivity);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    SLog.a("Q.qqstory.home:NowTab", "Now tab run onResume! tabChange=%s", Boolean.valueOf(paramBoolean));
    paramBoolean = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.c();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.b(a());
    if (this.jdField_b_of_type_Boolean)
    {
      if (FrameHelperActivity.b())
      {
        FrameHelperActivity.b(true);
        FrameHelperActivity.w();
      }
      this.jdField_b_of_type_Boolean = false;
    }
    if (!paramBoolean) {
      i();
    }
    Handler localHandler = new Handler();
    localHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    localHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
    ApngImage.playByTag(5);
    Bosses.get().postLightWeightJob(new Now.3(this), 10);
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.b()) {
      return true;
    }
    return super.a();
  }
  
  public void ab_()
  {
    super.ab_();
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
  
  public void b(boolean paramBoolean) {}
  
  public void c()
  {
    super.c();
    SLog.d("Q.qqstory.home:NowTab", "Now tab run onStop!");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.c(a());
  }
  
  protected void c(boolean paramBoolean)
  {
    Object localObject = (StoryConfigManager)SuperManager.a(10);
    int i = 0;
    if (((Boolean)((StoryConfigManager)localObject).b("upload_video_use_bdh", Boolean.valueOf(false))).booleanValue())
    {
      localObject = a().findViewById(16908307);
      a().findViewById(16908305);
      if (!paramBoolean) {
        i = 8;
      }
      if (paramBoolean) {
        a().getDimensionPixelSize(2131297336);
      }
      if (localObject != null) {
        ((View)localObject).setVisibility(i);
      }
    }
  }
  
  protected void d()
  {
    super.d();
    SLog.d("Q.qqstory.home:NowTab", "Now tab run onDestroy!");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.d(a());
    StoryFailCommentCacher.a().b();
  }
  
  public void e()
  {
    super.e();
    U_();
    SLog.b("Q.qqstory.home:NowTab", "Now tab onFrameTabClick--------------");
  }
  
  protected void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.j();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.b();
  }
  
  public void g()
  {
    l();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    else
    {
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850433);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850433);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167053));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167053));
    }
    SimpleUIUtil.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Now
 * JD-Core Version:    0.7.0.1
 */