package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption.Builder;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;

public class QFSPlusFollowView
  extends QCircleFollowView
  implements AnimationDrawableFactory.CreateResultListener
{
  public QFSPlusFollowView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QFSPlusFollowView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QFSPlusFollowView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void e()
  {
    AnimationDrawableCreateOption.Builder localBuilder = new AnimationDrawableCreateOption.Builder("https://downv6.qq.com/video_story/flashshow/animation/follow_btn_sep.zip");
    localBuilder.a(1000);
    localBuilder.a(1000L);
    localBuilder.a(true);
    localBuilder.b(true);
    AnimationDrawableFactory.a().a(hashCode(), localBuilder.a(), this);
  }
  
  protected void a()
  {
    super.a();
    setVisibility(8);
    setText("");
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      e();
      setClickable(false);
      return;
    }
    setVisibility(8);
    setClickable(true);
  }
  
  public void a(boolean paramBoolean, QQAnimationDrawable paramQQAnimationDrawable)
  {
    if ((paramBoolean) && (paramQQAnimationDrawable != null))
    {
      paramQQAnimationDrawable.b(true);
      setBackgroundDrawable(paramQQAnimationDrawable);
      paramQQAnimationDrawable.b(true);
      paramQQAnimationDrawable.start();
      postDelayed(new QFSPlusFollowView.1(this), 1000L);
      return;
    }
    post(new QFSPlusFollowView.2(this));
  }
  
  protected void b()
  {
    setVisibility(0);
    setClickable(true);
    setBackgroundDrawable(getResources().getDrawable(2130845821));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.QFSPlusFollowView
 * JD-Core Version:    0.7.0.1
 */