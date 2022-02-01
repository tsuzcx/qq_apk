package com.tencent.biz.qqcircle.widgets;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption.Builder;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadTask;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

public class QCircleFolderTabView
{
  private static RFWMultiDownloadHelper i = new RFWMultiDownloadHelper();
  private FrameLayout a;
  private TextView b;
  private ImageView c;
  private ImageView d;
  private QQAnimationDrawable e;
  private volatile boolean f;
  private final Runnable g = new QCircleFolderTabView.1(this);
  private final AnimationDrawableFactory.CreateResultListener h = new QCircleFolderTabView.2(this);
  
  static
  {
    i.addTask(new RFWMultiDownloadHelper.DownloadTask(QCircleSkinHelper.getInstance().getUrl("following_badge_animation"), QCirclePluginConfig.e()));
    i.start();
  }
  
  public QCircleFolderTabView(ViewGroup paramViewGroup)
  {
    this.a = ((FrameLayout)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626831, paramViewGroup, false));
    this.b = ((TextView)this.a.findViewById(16908308));
    this.c = ((ImageView)this.a.findViewById(2131439444));
    this.d = ((ImageView)this.a.findViewById(2131439452));
  }
  
  private void h()
  {
    if ((this.e != null) && (this.c != null))
    {
      if (this.f)
      {
        QLog.e("QCircleFolderTabView", 1, "playUpdateAnim action canceled,direct return!");
        return;
      }
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(22).setSubActionType(15).setThrActionType(1));
      this.e.stop();
      this.c.setImageDrawable(this.e);
      this.c.setVisibility(0);
      this.e.b(true);
      this.e.start();
      RFThreadManager.getUIHandler().postDelayed(this.g, EeveeRedpointUtil.getFollowTabClearRedDotDelayInSecond() * 1000L);
      QLog.d("QCircleFolderTabView", 1, "playUpdateAnim called");
      return;
    }
    QLog.e("QCircleFolderTabView", 1, "playUpdateAnim AnimationDrawable is null or updateAnimView is null!");
  }
  
  private void i()
  {
    ImageView localImageView = this.c;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
  }
  
  private void j()
  {
    QLog.d("QCircleFolderTabView", 1, "playDismissAnim");
    if (this.c != null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.758F, 1, 0.25F);
      localScaleAnimation.setDuration(200L);
      localScaleAnimation.setAnimationListener(new QCircleFolderTabView.3(this));
      Drawable localDrawable = this.c.getResources().getDrawable(2130845093);
      this.c.setImageDrawable(localDrawable);
      this.c.startAnimation(localScaleAnimation);
    }
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a(View paramView)
  {
    if (paramView.getParent() == null) {
      return;
    }
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      localViewGroup.setClipChildren(false);
      localViewGroup.setClipToPadding(false);
    }
    if ((paramView.getParent() instanceof View)) {
      a((View)paramView.getParent());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hideUpdateAnim called,need show dismiss Anim:");
    localStringBuilder.append(paramBoolean);
    QLog.d("QCircleFolderTabView", 1, localStringBuilder.toString());
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(22).setSubActionType(15).setThrActionType(2));
    if (paramBoolean)
    {
      j();
      return;
    }
    this.f = true;
    i();
  }
  
  public void b()
  {
    if (this.e == null)
    {
      QLog.d("QCircleFolderTabView", 1, "showUpdateAnim Async fetchAnimDrawable first!");
      Object localObject = QCircleSkinHelper.getInstance().getUrl("following_badge_animation");
      if (RFWDownloaderFactory.getDownloader(QCirclePluginConfig.e()).isFileDownLoaded((String)localObject))
      {
        QLog.d("QCircleFolderTabView", 1, "showUpdateAnim AnimDrawable already downloaded!");
        localObject = new AnimationDrawableCreateOption.Builder((String)localObject);
        ((AnimationDrawableCreateOption.Builder)localObject).b(40);
        ((AnimationDrawableCreateOption.Builder)localObject).a(2147483647L);
        ((AnimationDrawableCreateOption.Builder)localObject).a(true);
        ((AnimationDrawableCreateOption.Builder)localObject).b(true);
        AnimationDrawableFactory.a().a(hashCode(), ((AnimationDrawableCreateOption.Builder)localObject).a(), this.h);
        return;
      }
      c();
      QLog.d("QCircleFolderTabView", 1, "showUpdateAnim AnimDrawable need download,show default dot first!");
      return;
    }
    QLog.d("QCircleFolderTabView", 1, "showUpdateAnim sync!");
    h();
  }
  
  public void c()
  {
    if (this.c == null)
    {
      QLog.e("QCircleFolderTabView", 1, "showDefaultUpdateDot updateAnimView is null!");
      return;
    }
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(22).setSubActionType(15).setThrActionType(1));
    Drawable localDrawable = this.c.getResources().getDrawable(2130845093);
    this.c.setImageDrawable(localDrawable);
    this.c.setVisibility(0);
    RFThreadManager.getUIHandler().postDelayed(this.g, EeveeRedpointUtil.getFollowTabClearRedDotDelayInSecond() * 1000L);
    QLog.d("QCircleFolderTabView", 1, "showDefaultUpdateDot called");
  }
  
  public void d()
  {
    RFThreadManager.getUIHandler().removeCallbacks(this.g);
  }
  
  public void e()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      if (((QQAnimationDrawable)localObject).isRunning()) {
        this.e.stop();
      }
      localObject = this.c;
      if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
      {
        localObject = this.c.getResources().getDrawable(2130845093);
        this.c.setImageDrawable((Drawable)localObject);
        QLog.e("QCircleFolderTabView", 1, "onPause，stop running update animation");
      }
    }
  }
  
  public void f()
  {
    QLog.d("QCircleFolderTabView", 2, "showNewTips");
    a(this.a);
    this.d.setVisibility(0);
  }
  
  public void g()
  {
    QLog.d("QCircleFolderTabView", 2, "hideNewTips");
    this.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFolderTabView
 * JD-Core Version:    0.7.0.1
 */