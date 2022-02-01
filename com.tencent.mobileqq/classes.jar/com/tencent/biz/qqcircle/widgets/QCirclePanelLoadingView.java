package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption.Builder;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.qphone.base.util.QLog;

public class QCirclePanelLoadingView
  extends QCircleBaseWidgetView
{
  private ImageView a;
  private QQAnimationDrawable b;
  private TextView c;
  private int d = 2130845174;
  private boolean e = false;
  private final AnimationDrawableFactory.CreateResultListener f = new QCirclePanelLoadingView.1(this);
  
  public QCirclePanelLoadingView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCirclePanelLoadingView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public QCirclePanelLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCirclePanelLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void c()
  {
    if (this.b == null)
    {
      QLog.d("QCirclePanelLoadingView", 1, "showDynamicLogoView Async fetchAnimDrawable first!");
      if (RFWDownloaderFactory.getDownloader(QCirclePluginConfig.e()).isFileDownLoaded("https://downv6.qq.com/video_story/qcircle/animation/pull_refresh_logo.zip"))
      {
        QLog.d("QCirclePanelLoadingView", 1, "showDynamicLogoView AnimDrawable already downloaded!");
        AnimationDrawableCreateOption.Builder localBuilder = new AnimationDrawableCreateOption.Builder("https://downv6.qq.com/video_story/qcircle/animation/pull_refresh_logo.zip");
        localBuilder.b(67);
        localBuilder.a(2147483647L);
        localBuilder.a(false);
        localBuilder.b(true);
        AnimationDrawableFactory.a().a(hashCode(), localBuilder.a(), this.f);
        return;
      }
      f();
      QLog.d("QCirclePanelLoadingView", 1, "showDynamicLogoView AnimDrawable need download,show static logo first!");
      return;
    }
    QLog.d("QCirclePanelLoadingView", 1, "showUpdateAnim sync!");
    d();
  }
  
  private void d()
  {
    if (!this.e) {
      return;
    }
    if ((this.b != null) && (this.a != null))
    {
      setVisibility(0);
      this.a.setImageDrawable(this.b);
      this.b.start();
    }
  }
  
  private void e()
  {
    QQAnimationDrawable localQQAnimationDrawable = this.b;
    if (localQQAnimationDrawable == null) {
      return;
    }
    if (localQQAnimationDrawable.isRunning()) {
      this.b.stop();
    }
  }
  
  private void f()
  {
    if (!this.e) {
      return;
    }
    e();
    ImageView localImageView = this.a;
    if (localImageView != null)
    {
      localImageView.setImageResource(this.d);
      setVisibility(0);
    }
  }
  
  public void a()
  {
    this.e = true;
    c();
  }
  
  public void a(int paramInt)
  {
    paramInt /= 2;
    int i = ViewUtils.a(37.0F);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = (paramInt - i);
    localLayoutParams.gravity = 1;
    setLayoutParams(localLayoutParams);
    this.e = true;
  }
  
  public void b()
  {
    setVisibility(8);
    this.e = false;
    e();
  }
  
  protected void bindData(Object paramObject, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131626888;
  }
  
  protected String getLogTag()
  {
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b();
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((ImageView)paramView.findViewById(2131428364));
    this.c = ((TextView)paramView.findViewById(2131437644));
    if (Build.VERSION.SDK_INT >= 21) {
      this.c.setLetterSpacing(0.1F);
    }
  }
  
  public void setReportBean(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePanelLoadingView
 * JD-Core Version:    0.7.0.1
 */