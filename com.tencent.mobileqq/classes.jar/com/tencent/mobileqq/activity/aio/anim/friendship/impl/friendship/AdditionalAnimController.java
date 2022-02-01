package com.tencent.mobileqq.activity.aio.anim.friendship.impl.friendship;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public class AdditionalAnimController
{
  private Context a;
  private Bitmap b;
  private View c;
  private ImageView d;
  private ValueAnimator e;
  private View.OnClickListener f;
  
  public AdditionalAnimController(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdditionalAnimController", 2, "playAnimation");
    }
    if (this.e != null)
    {
      ImageView localImageView = this.d;
      if (localImageView != null) {
        localImageView.setImageBitmap(this.b);
      }
      this.e.start();
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdditionalAnimController", 2, "setOnCloseClickListener");
    }
    this.f = paramOnClickListener;
    paramOnClickListener = this.f;
    if (paramOnClickListener != null)
    {
      ImageView localImageView = this.d;
      if (localImageView != null) {
        localImageView.setOnClickListener(paramOnClickListener);
      }
    }
  }
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdditionalAnimController", 2, "setBackgroundView");
    }
    this.c = paramView;
    this.e = ValueAnimator.ofObject(new AdditionalAnimController.AlphaEvaluator(null), new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    this.e.setDuration(3350L);
    this.e.addUpdateListener(new AdditionalAnimController.1(this));
  }
  
  public void a(FriendShipLayout paramFriendShipLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdditionalAnimController", 2, "setRootContainer");
    }
    if (paramFriendShipLayout != null)
    {
      this.d = new ImageView(this.a);
      this.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 53;
      localLayoutParams.topMargin = ScreenUtil.dip2px(30.0F);
      localLayoutParams.rightMargin = ScreenUtil.dip2px(30.0F);
      paramFriendShipLayout.addView(this.d, localLayoutParams);
      paramFriendShipLayout = this.f;
      if (paramFriendShipLayout != null) {
        this.d.setOnClickListener(paramFriendShipLayout);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCloseBtnBitmapPath: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AdditionalAnimController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inScaled = true;
    ((BitmapFactory.Options)localObject).inDensity = 320;
    try
    {
      if ((this.b != null) && (!this.b.isRecycled()))
      {
        if (this.d != null) {
          this.d.setImageDrawable(null);
        }
        this.b.recycle();
      }
      this.b = ImageUtil.a(paramString, (BitmapFactory.Options)localObject);
      return;
    }
    catch (Exception paramString)
    {
      break label120;
    }
    catch (OutOfMemoryError paramString)
    {
      label106:
      break label106;
    }
    QLog.e("AdditionalAnimController", 1, "Decode bitmap OOM");
    this.b = null;
    return;
    label120:
    QLog.e("AdditionalAnimController", 1, "Decode bitmap error");
    this.b = null;
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdditionalAnimController", 2, "isAnimating");
    }
    ValueAnimator localValueAnimator = this.e;
    if (localValueAnimator != null) {
      localValueAnimator.isRunning();
    }
    return false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdditionalAnimController", 2, "cancelAnimation");
    }
    if (this.e != null)
    {
      ImageView localImageView = this.d;
      if (localImageView != null) {
        localImageView.setImageDrawable(null);
      }
      this.e.cancel();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdditionalAnimController", 2, "recycleBitmaps");
    }
    Object localObject = this.b;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      localObject = this.d;
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(null);
      }
      this.b.recycle();
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdditionalAnimController", 2, "pauseAnimation");
    }
    if ((this.e != null) && (Build.VERSION.SDK_INT >= 19)) {
      this.e.pause();
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdditionalAnimController", 2, "resumeAnimation");
    }
    if ((this.e != null) && (Build.VERSION.SDK_INT >= 19)) {
      this.e.resume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.friendship.AdditionalAnimController
 * JD-Core Version:    0.7.0.1
 */