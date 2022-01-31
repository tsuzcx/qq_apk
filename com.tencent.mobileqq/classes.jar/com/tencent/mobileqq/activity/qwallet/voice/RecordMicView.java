package com.tencent.mobileqq.activity.qwallet.voice;

import ajfe;
import ajff;
import ajfg;
import alud;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import bdaq;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecordMicView
  extends View
{
  float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 10000;
  private ajfg jdField_a_of_type_Ajfg;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(5);
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private List<ajff> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private float jdField_b_of_type_Float = bdaq.a(getContext(), 2.0F);
  private int jdField_b_of_type_Int = 0;
  private int c;
  private int d;
  private int e;
  
  public RecordMicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    int i = bdaq.a(getContext(), 120.0F);
    this.d = i;
    this.c = i;
    this.e = bdaq.a(getContext(), 33.0F);
    ViewCompat.setImportantForAccessibility(this, 1);
    setContentDescription(alud.a(2131713674));
    setClickable(true);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt1, int paramInt2)
  {
    ajff localajff = new ajff(bdaq.a(getContext(), paramFloat1), bdaq.a(getContext(), paramFloat2), paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramInt1, paramInt2);
    this.jdField_a_of_type_JavaUtilList.add(localajff);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(2);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ajfe(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_JavaUtilList.clear();
    a(112.0F, 120.0F, 0.8F, 0.1F, 1.0F, 1.05F, 1.0F, 0.95F, 0, 30);
    a(124.0F, 117.0F, 0.5F, 0.1F, 1.0F, 0.95F, 1.0F, 0.95F, 0, -30);
    a(124.0F, 132.0F, 0.1F, 0.5F, 1.0F, 0.95F, 1.0F, 0.95F, 0, 30);
    a(128.0F, 122.0F, 0.1F, 0.8F, 1.0F, 0.9F, 1.0F, 0.95F, 0, 30);
    d();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 1.1F, 1.0F }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 1.1F, 1.0F }) });
    localObjectAnimator.setDuration(200L);
    localObjectAnimator.setInterpolator(new LinearInterpolator());
    localObjectAnimator.start();
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RecordMicView.2(this), this.jdField_a_of_type_Int);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_Int = 0;
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
    float f1 = 1.0F;
    super.onDraw(paramCanvas);
    Object localObject;
    int i;
    if (this.jdField_b_of_type_Int == 2)
    {
      this.jdField_b_of_type_Float = bdaq.a(getContext(), 1.0F);
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ajff localajff = (ajff)((Iterator)localObject).next();
        paramCanvas.save();
        float f2 = localajff.jdField_a_of_type_Float;
        f1 = localajff.jdField_b_of_type_Float;
        f2 = (getWidth() - f2) / 2.0F;
        f1 = (getHeight() - f1) / 2.0F;
        i = (int)(255.0F * localajff.c);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-3405);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i);
        this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_b_of_type_Float * 0.5F + f2, this.jdField_b_of_type_Float * 0.5F + f1, getWidth() - this.jdField_b_of_type_Float * 0.5F - f2, getHeight() - this.jdField_b_of_type_Float * 0.5F - f1);
        paramCanvas.scale(localajff.d, localajff.e, getWidth() / 2, getHeight() / 2);
        paramCanvas.rotate(localajff.jdField_a_of_type_Int, getWidth() / 2, getHeight() / 2);
        paramCanvas.drawOval(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.restore();
      }
      paramCanvas.save();
      paramCanvas.translate((getWidth() - a()) / 2, (getHeight() - b()) / 2);
      localObject = getResources().getDrawable(2130846864);
      ((Drawable)localObject).setBounds(0, 0, a(), b());
      ((Drawable)localObject).setAlpha(127);
      ((Drawable)localObject).draw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    this.jdField_b_of_type_Float = bdaq.a(getContext(), 2.0F);
    paramCanvas.save();
    paramCanvas.translate((getWidth() - a()) / 2, (getHeight() - b()) / 2);
    if (this.jdField_b_of_type_Int == 0)
    {
      i = 255;
      if (this.jdField_b_of_type_Int != 0) {
        break label659;
      }
    }
    for (;;)
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
      localObject = getResources().getDrawable(2130846864);
      ((Drawable)localObject).setBounds(0, 0, a(), b());
      ((Drawable)localObject).setAlpha(i);
      ((Drawable)localObject).draw(paramCanvas);
      paramCanvas.restore();
      return;
      i = 127;
      break;
      label659:
      f1 = 0.95F;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
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
        } while (this.jdField_b_of_type_Int == 2);
        bool1 = bool2;
      } while (this.jdField_b_of_type_Int != 0);
      this.jdField_b_of_type_Int = 1;
      invalidate();
      b();
      if (this.jdField_a_of_type_Ajfg != null) {
        this.jdField_a_of_type_Ajfg.a();
      }
      this.jdField_a_of_type_Float = paramMotionEvent.getRawY();
      return true;
    } while (this.jdField_b_of_type_Int != 1);
    if (this.jdField_a_of_type_Float - paramMotionEvent.getRawY() > this.e) {}
    for (;;)
    {
      if (i != 0)
      {
        if (this.jdField_a_of_type_Ajfg != null) {
          this.jdField_a_of_type_Ajfg.d();
        }
        c();
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if (this.jdField_a_of_type_Boolean) {
        a();
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Ajfg == null) {
          break label204;
        }
        this.jdField_a_of_type_Ajfg.b();
        break;
        c();
      }
      label204:
      break;
      i = 0;
    }
  }
  
  public void setRecordTime(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setStatusListener(ajfg paramajfg)
  {
    this.jdField_a_of_type_Ajfg = paramajfg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.RecordMicView
 * JD-Core Version:    0.7.0.1
 */