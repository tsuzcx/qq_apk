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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
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
import tjb;
import tjc;
import tjd;
import tje;

public class Now
  extends Frame
{
  private long jdField_a_of_type_Long = -1L;
  public ImageView a;
  protected ProgressBar a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  protected StoryConfigManager a;
  public QQStoryMainController a;
  private MystoryListView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new tjb(this);
  public String a;
  protected boolean a;
  public RelativeLayout b;
  public TextView b;
  public boolean b;
  private RelativeLayout c;
  public TextView c;
  private RelativeLayout d;
  
  public Now()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController = new QQStoryMainController(new tjc(this), QQStoryMainController.b);
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
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.c(false);
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131363398));
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131362599));
    IphoneTitleBarActivity.setLayerType((ViewGroup)a(2131363261));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131372185));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new tje(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131363400));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131367261));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131433308);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131370714));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131372187));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)a(2131372186));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      return;
    }
    a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130845951);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130845951);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131494218));
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131494218));
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView = ((MystoryListView)a(2131371756));
    this.d = ((RelativeLayout)a(2131372035));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setIsNowTab(true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setDivider(null);
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getParent()).setBackgroundColor(a().getColor(2131494261));
  }
  
  @TargetApi(16)
  private void p()
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
        break label261;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setContentBackground(((ThemeBackground)localObject).img);
      this.d.setBackgroundColor(a().getColor(2131494261));
    }
    label261:
    for (int i = 1;; i = 0)
    {
      j = 0;
      while ((i == 0) && (j == 0))
      {
        if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setContentBackground(a().getDrawable(2130845945), false);
        }
        for (;;)
        {
          this.d.setBackgroundColor(a().getColor(2131494261));
          return;
          if (!ThemeUtil.isNowThemeIsAnimate()) {
            break label254;
          }
          localObject = ThemeUtil.getAnimatePathByTag(2);
          Drawable localDrawable = super.a().getDrawable(2130845888);
          localObject = VasApngUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, "-conversation-", localDrawable, VasApngUtil.a, "-now-", null);
          if (localObject == null) {
            break label254;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setBackgroundDrawable(null);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setContentBackground(null);
          this.d.setBackgroundDrawable((Drawable)localObject);
          i = 0;
          break;
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setContentBackground(a().getDrawable(2130838220), false);
        }
        label254:
        j = 0;
        i = 0;
      }
      break;
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    SLog.b("Q.qqstory.home:NowTab", "Now tab run onCreateView!");
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.inflate(2130970807, null));
    return this.jdField_b_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void a() {}
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected void a(BaseActivity paramBaseActivity)
  {
    super.a(paramBaseActivity);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(paramBaseActivity);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    SLog.a("Q.qqstory.home:NowTab", "Now tab run onResume! tabChange=%s", Boolean.valueOf(paramBoolean));
    paramBoolean = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.d();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a();
    if (this.jdField_b_of_type_Boolean)
    {
      if (FrameHelperActivity.a())
      {
        FrameHelperActivity.b(true);
        FrameHelperActivity.o();
      }
      this.jdField_b_of_type_Boolean = false;
    }
    if (!paramBoolean) {
      l();
    }
    Handler localHandler = new Handler();
    localHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    localHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
    ApngImage.playByTag(5);
    Bosses.get().postLightWeightJob(new tjd(this), 10);
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.c()) {
      return true;
    }
    return super.a();
  }
  
  public void b()
  {
    p();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      return;
    }
    a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130845951);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130845951);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131494218));
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131494218));
  }
  
  public void b(boolean paramBoolean)
  {
    View localView1;
    View localView2;
    int i;
    if (((Boolean)((StoryConfigManager)SuperManager.a(10)).b("upload_video_use_bdh", Boolean.valueOf(false))).booleanValue())
    {
      localView1 = a().findViewById(16908307);
      localView2 = a().findViewById(16908305);
      if (!paramBoolean) {
        break label98;
      }
      i = 0;
      if (!paramBoolean) {
        break label104;
      }
    }
    label98:
    label104:
    for (int j = a().getDimensionPixelSize(2131558436);; j = 0)
    {
      if (localView1 != null) {
        localView1.setVisibility(i);
      }
      if (localView2 != null) {
        localView2.setPadding(0, 0, 0, j);
      }
      return;
      i = 8;
      break;
    }
  }
  
  protected void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.n();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.e();
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getFirstVisiblePosition() > 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setSelection(0);
    }
  }
  
  protected void e()
  {
    super.e();
    d();
    SLog.b("Q.qqstory.home:NowTab", "Now tab onFrameTabClick--------------");
  }
  
  protected void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager = ((StoryConfigManager)SuperManager.a(10));
    SLog.d("Q.qqstory.home:NowTab", "Now tab run onCreate! action:%d", new Object[] { Integer.valueOf(a().getIntent().getIntExtra("action", 0)) });
    n();
    o();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(null);
    this.jdField_a_of_type_Boolean = true;
    StoryUploadProcessor.q();
    ((TrimmableManager)SuperManager.a(26)).a(0);
  }
  
  public void i()
  {
    super.i();
    SLog.d("Q.qqstory.home:NowTab", "Now tab run onPause!");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.b();
    new Handler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ApngImage.pauseByTag(5);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.c();
    if ((this.jdField_a_of_type_Long > 0L) && (a().isResume()))
    {
      int i = a().getIntent().getIntExtra("action", 0);
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = -1L;
      a((int)(l1 - l2), i);
    }
  }
  
  public void j()
  {
    super.j();
    SLog.d("Q.qqstory.home:NowTab", "Now tab run onStop!");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.c();
  }
  
  protected void k()
  {
    super.k();
    SLog.d("Q.qqstory.home:NowTab", "Now tab run onDestroy!");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.d();
    StoryFailCommentCacher.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Now
 * JD-Core Version:    0.7.0.1
 */