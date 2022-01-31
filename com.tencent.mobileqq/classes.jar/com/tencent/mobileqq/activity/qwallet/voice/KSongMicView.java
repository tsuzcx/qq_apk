package com.tencent.mobileqq.activity.qwallet.voice;

import ahiw;
import ahjd;
import ahje;
import ahjf;
import ajya;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import baxn;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KSongMicView
  extends View
{
  float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  private ahjf jdField_a_of_type_Ahjf;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(5);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private List<ahje> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private float jdField_b_of_type_Float = baxn.a(getContext(), 2.0F);
  private int jdField_b_of_type_Int;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public KSongMicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    int i = baxn.a(getContext(), 90.0F);
    this.c = i;
    this.jdField_b_of_type_Int = i;
    this.d = baxn.a(getContext(), 28.0F);
    this.e = baxn.a(getContext(), 36.5F);
    this.f = baxn.a(getContext(), 12.0F);
    this.g = baxn.a(getContext(), 100.0F);
    ViewCompat.setImportantForAccessibility(this, 1);
    setContentDescription(ajya.a(2131705970));
    setClickable(true);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt1, int paramInt2)
  {
    ahje localahje = new ahje(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramInt1, paramInt2);
    this.jdField_a_of_type_JavaUtilList.add(localahje);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(2);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ahjd(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_JavaUtilList.clear();
    a(0.93F * a(), b(), 0.8F, 0.1F, 1.0F, 1.05F, 1.0F, 0.95F, 0, 30);
    a(1.03F * a(), 0.975F * b(), 0.5F, 0.1F, 1.0F, 0.95F, 1.0F, 0.95F, 0, -30);
    a(1.03F * a(), 1.1F * b(), 0.1F, 0.5F, 1.0F, 0.95F, 1.0F, 0.95F, 0, 30);
    a(1.07F * a(), 1.02F * b(), 0.1F, 0.8F, 1.0F, 0.9F, 1.0F, 0.95F, 0, 30);
    c();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 1.1F, 1.0F }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 1.1F, 1.0F }) });
    localObjectAnimator.setDuration(200L);
    localObjectAnimator.setInterpolator(new LinearInterpolator());
    localObjectAnimator.start();
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    invalidate();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f2 = 1.0F;
    super.onDraw(paramCanvas);
    Object localObject;
    int i;
    if (this.jdField_a_of_type_Int == 3)
    {
      this.jdField_b_of_type_Float = baxn.a(getContext(), 1.0F);
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ahje localahje = (ahje)((Iterator)localObject).next();
        paramCanvas.save();
        f2 = localahje.jdField_a_of_type_Float;
        f1 = localahje.jdField_b_of_type_Float;
        f2 = (getWidth() - f2) / 2.0F;
        f1 = (getHeight() - f1) / 2.0F;
        i = (int)(255.0F * localahje.c);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-3405);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i);
        this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_b_of_type_Float * 0.5F + f2, this.jdField_b_of_type_Float * 0.5F + f1, getWidth() - this.jdField_b_of_type_Float * 0.5F - f2, getHeight() - this.jdField_b_of_type_Float * 0.5F - f1);
        paramCanvas.scale(localahje.d, localahje.e, getWidth() / 2, getHeight() / 2);
        paramCanvas.rotate(localahje.jdField_a_of_type_Int, getWidth() / 2, getHeight() / 2);
        paramCanvas.drawOval(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.restore();
      }
    }
    this.jdField_b_of_type_Float = baxn.a(getContext(), 1.0F);
    paramCanvas.save();
    paramCanvas.translate((getWidth() - a()) / 2, (getHeight() - b()) / 2);
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 2))
    {
      i = 255;
      f1 = f2;
      if (this.jdField_a_of_type_Int != 0) {
        if (this.jdField_a_of_type_Int != 2) {
          break label638;
        }
      }
    }
    label638:
    for (float f1 = f2;; f1 = 0.95F)
    {
      paramCanvas.scale(f1, f1, getWidth() / 2, getHeight() / 2);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(16728412);
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, a(), b());
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i);
      paramCanvas.drawOval(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-3405);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i);
      this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_b_of_type_Float * 0.5F, this.jdField_b_of_type_Float * 0.5F, a() - this.jdField_b_of_type_Float * 0.5F, b() - this.jdField_b_of_type_Float * 0.5F);
      paramCanvas.drawOval(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1))
      {
        localObject = getResources().getDrawable(2130846390);
        int j = (a() - this.d) / 2;
        ((Drawable)localObject).setBounds(j, j, this.d + j, this.e + j);
        ((Drawable)localObject).setAlpha(i);
        ((Drawable)localObject).draw(paramCanvas);
      }
      paramCanvas.restore();
      return;
      i = 127;
      break;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 1;
    boolean bool2 = true;
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      boolean bool1 = super.onTouchEvent(paramMotionEvent);
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.jdField_a_of_type_Int == 3);
        bool1 = bool2;
      } while (this.jdField_a_of_type_Int != 0);
      this.jdField_a_of_type_Int = 1;
      invalidate();
      if (this.jdField_a_of_type_Ahjf != null) {
        this.jdField_a_of_type_Ahjf.l();
      }
      this.jdField_a_of_type_Float = paramMotionEvent.getRawY();
      return true;
    } while (this.jdField_a_of_type_Int != 1);
    float f1 = this.jdField_a_of_type_Float;
    paramMotionEvent.getRawY();
    int i = j;
    if (ahiw.a(this, paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) {
      if (paramMotionEvent.getAction() != 3) {
        break label218;
      }
    }
    label218:
    for (i = j;; i = 0)
    {
      if (i != 0)
      {
        if (this.jdField_a_of_type_Ahjf != null) {
          this.jdField_a_of_type_Ahjf.n();
        }
        b();
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Int = 2;
      invalidate();
      if (this.jdField_a_of_type_Ahjf == null) {
        break;
      }
      this.jdField_a_of_type_Ahjf.m();
      break;
    }
  }
  
  public void setStatusListener(ahjf paramahjf)
  {
    this.jdField_a_of_type_Ahjf = paramahjf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.KSongMicView
 * JD-Core Version:    0.7.0.1
 */