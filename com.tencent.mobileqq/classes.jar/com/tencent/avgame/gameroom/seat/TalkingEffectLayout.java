package com.tencent.avgame.gameroom.seat;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.qphone.base.util.QLog;

public class TalkingEffectLayout
  extends RelativeLayout
{
  private ImageView a;
  private ImageView b;
  private int c;
  private int d;
  private Path e;
  private RectF f;
  private float g;
  private float h;
  private AnimatorSet i;
  private Animator.AnimatorListener j;
  
  public TalkingEffectLayout(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public TalkingEffectLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public TalkingEffectLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void c()
  {
    this.e = new Path();
    this.f = new RectF();
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
    this.b = new ImageView(getContext());
    Bitmap localBitmap = AVGameUtil.c("avgame_pk_player_talking_inner.png");
    if (localBitmap != null) {
      this.b.setImageBitmap(localBitmap);
    } else {
      this.b.setImageDrawable(getResources().getDrawable(2130838913));
    }
    this.a = new ImageView(getContext());
    localBitmap = AVGameUtil.c("avgame_pk_player_talking_outer.png");
    if (localBitmap != null) {
      this.a.setImageBitmap(localBitmap);
    } else {
      this.a.setImageDrawable(getResources().getDrawable(2130838914));
    }
    addView(this.a, new RelativeLayout.LayoutParams(-1, -1));
    addView(this.b, new RelativeLayout.LayoutParams(-1, -1));
  }
  
  private void d()
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      ((AnimatorSet)localObject).cancel();
      this.i.removeAllListeners();
    }
    localObject = ObjectAnimator.ofFloat(this.b, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.a, "alpha", new float[] { 0.0F, 0.35F, 0.35F, 0.35F, 0.0F });
    int k = this.c;
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, "clipPadding", new float[] { k * 0.0666667F, k * 0.01111111F, k * 0.03333334F, k * 0.01111111F, k * 0.0666667F });
    ((ObjectAnimator)localObject).setDuration(1000L);
    localObjectAnimator1.setDuration(1000L);
    localObjectAnimator2.setDuration(1000L);
    this.i = new AnimatorSet();
    this.i.playTogether(new Animator[] { localObject, localObjectAnimator1, localObjectAnimator2 });
    this.i.addListener(new TalkingEffectLayout.1(this));
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playAnimation animatorSet = ");
      ((StringBuilder)localObject).append(this.i);
      QLog.d("TalkingEffectLayout", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.i;
    if (localObject == null) {
      return;
    }
    if (((AnimatorSet)localObject).isRunning()) {
      return;
    }
    this.i.start();
  }
  
  public void b()
  {
    AnimatorSet localAnimatorSet = this.i;
    if (localAnimatorSet == null) {
      return;
    }
    localAnimatorSet.cancel();
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    this.e.reset();
    float f1 = this.h;
    float f2 = this.c;
    float f3 = this.d;
    this.f.set(f1, f1, f2 - f1, f3 - f1);
    int k = this.c;
    this.g = (k * 0.1333333F + (k * 0.08888889F - this.h));
    Path localPath = this.e;
    RectF localRectF = this.f;
    f1 = this.g;
    localPath.addRoundRect(localRectF, f1, f1, Path.Direction.CW);
    paramCanvas.clipPath(this.e);
    super.dispatchDraw(paramCanvas);
  }
  
  public float getClipPadding()
  {
    return this.h;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = this.c;
    if ((paramInt3 == 0) || (paramInt3 != paramInt1))
    {
      this.c = paramInt1;
      this.d = paramInt2;
      d();
    }
  }
  
  public void setAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.j = paramAnimatorListener;
  }
  
  public void setClipPadding(float paramFloat)
  {
    this.h = paramFloat;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.TalkingEffectLayout
 * JD-Core Version:    0.7.0.1
 */