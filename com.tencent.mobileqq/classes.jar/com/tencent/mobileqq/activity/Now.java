package com.tencent.mobileqq.activity;

import aelr;
import aels;
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
import anun;
import bdfk;
import com.tencent.biz.qqstory.storyHome.QQStoryMainController;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import whi;
import wjl;
import wjs;
import wjy;
import ykq;
import ykv;

public class Now
  extends anun
{
  private long jdField_a_of_type_Long = -1L;
  public ImageView a;
  protected ProgressBar a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  protected QQStoryMainController a;
  private MystoryListView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new Now.1(this);
  public String a;
  protected wjl a;
  protected boolean a;
  public RelativeLayout b;
  public TextView b;
  public boolean b;
  private RelativeLayout c;
  public TextView c;
  private RelativeLayout d;
  
  public Now()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController = new QQStoryMainController(new aelr(this), QQStoryMainController.b);
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
      ykv.a("home_page", "time_stay", paramInt2, paramInt1, new String[] { "1", "1" });
      return;
      paramInt2 = 4;
      continue;
      paramInt2 = 3;
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.c(false);
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131379099));
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131379020));
    IphoneTitleBarActivity.setLayerType((ViewGroup)a(2131376760));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131372144));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aels(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131369278));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131363748));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719165);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369253));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131379748));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)a(2131374734));
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
      bdfk.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850109);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850109);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167023));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167023));
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView = ((MystoryListView)a(2131374711));
    this.d = ((RelativeLayout)a(2131374651));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setIsNowTab(true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setDivider(null);
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getParent()).setBackgroundColor(a().getColor(2131167086));
  }
  
  @TargetApi(16)
  private void n()
  {
    int j = 1;
    if ((this.d == null) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView == null)) {
      return;
    }
    Object localObject;
    if (ThemeUtil.isNowThemeIsDIY())
    {
      localObject = new ThemeBackground();
      ThemeBackground.getThemeBackground(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getContext(), "theme_bg_message_path_png", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (ThemeBackground)localObject);
      if (("null".equals(((ThemeBackground)localObject).path)) || (((ThemeBackground)localObject).img == null)) {
        break label262;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setContentBackground(((ThemeBackground)localObject).img);
      this.d.setBackgroundColor(a().getColor(2131167086));
    }
    label262:
    for (int i = 1;; i = 0)
    {
      j = 0;
      while ((i == 0) && (j == 0))
      {
        if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setContentBackground(a().getDrawable(2130850103), false);
        }
        for (;;)
        {
          this.d.setBackgroundColor(a().getColor(2131167086));
          return;
          if (!ThemeUtil.isNowThemeIsAnimate()) {
            break label255;
          }
          localObject = ThemeUtil.getAnimatePathByTag(2);
          Drawable localDrawable = super.a().getDrawable(2130850036);
          localObject = VasApngUtil.getApngDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, "-conversation-", localDrawable, VasApngUtil.converstionTag, "-now-", null);
          if (localObject == null) {
            break label255;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setBackgroundDrawable(null);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setContentBackground(null);
          this.d.setBackgroundDrawable((Drawable)localObject);
          i = 0;
          break;
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setContentBackground(a().getDrawable(2130838912), false);
        }
        label255:
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
  
  private void q()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    ykq.b("Q.qqstory.home:NowTab", "Now tab run onCreateView!");
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.inflate(2131561741, null));
    return this.jdField_b_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.j();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.b();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    super.a(paramBaseActivity);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(paramBaseActivity);
  }
  
  public void a(boolean paramBoolean)
  {
    View localView1;
    View localView2;
    if (((Boolean)((wjl)wjs.a(10)).b("upload_video_use_bdh", Boolean.valueOf(false))).booleanValue())
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
        a().getDimensionPixelSize(2131297321);
      }
      if (localView1 != null) {
        localView1.setVisibility(i);
      }
      if (localView2 != null) {}
      return;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.b()) {
      return true;
    }
    return super.a();
  }
  
  public void aa_()
  {
    super.aa_();
    d();
    ykq.b("Q.qqstory.home:NowTab", "Now tab onFrameTabClick--------------");
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c()
  {
    n();
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
      bdfk.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850109);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850109);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167023));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167023));
    }
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getFirstVisiblePosition() > 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setSelection(0);
    }
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_Wjl = ((wjl)wjs.a(10));
    ykq.d("Q.qqstory.home:NowTab", "Now tab run onCreate! action:%d", new Object[] { Integer.valueOf(a().getIntent().getIntExtra("action", 0)) });
    l();
    m();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(null);
    this.jdField_a_of_type_Boolean = true;
    StoryUploadProcessor.checkUploadSessionKey();
    ((wjy)wjs.a(26)).a(0);
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    ykq.a("Q.qqstory.home:NowTab", "Now tab run onResume! tabChange=%s", Boolean.valueOf(paramBoolean));
    paramBoolean = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.c();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.b(a());
    if (this.jdField_b_of_type_Boolean)
    {
      if (FrameHelperActivity.b())
      {
        FrameHelperActivity.c(true);
        FrameHelperActivity.t();
      }
      this.jdField_b_of_type_Boolean = false;
    }
    if (!paramBoolean) {
      j();
    }
    Handler localHandler = new Handler();
    localHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    localHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
    ApngImage.playByTag(5);
    Bosses.get().postLightWeightJob(new Now.3(this), 10);
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public void g()
  {
    super.g();
    ykq.d("Q.qqstory.home:NowTab", "Now tab run onPause!");
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
  
  public void h()
  {
    super.h();
    ykq.d("Q.qqstory.home:NowTab", "Now tab run onStop!");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.c(a());
  }
  
  public void i()
  {
    super.i();
    ykq.d("Q.qqstory.home:NowTab", "Now tab run onDestroy!");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.d(a());
    whi.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Now
 * JD-Core Version:    0.7.0.1
 */