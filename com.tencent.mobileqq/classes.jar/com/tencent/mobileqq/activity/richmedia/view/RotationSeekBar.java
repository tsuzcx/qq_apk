package com.tencent.mobileqq.activity.richmedia.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SeekBar;

public class RotationSeekBar
  extends SeekBar
{
  private static float jdField_a_of_type_Float = -1.0F;
  private static final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new AccelerateDecelerateInterpolator();
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private ValueAnimator b;
  
  public RotationSeekBar(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RotationSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RotationSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private float a()
  {
    if (jdField_a_of_type_Float == -1.0F) {
      jdField_a_of_type_Float = getContext().getResources().getDisplayMetrics().density;
    }
    return jdField_a_of_type_Float;
  }
  
  private int a(float paramFloat)
  {
    a();
    return Math.round(jdField_a_of_type_Float * paramFloat);
  }
  
  void a() {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if (this.b != null) {
      this.b.cancel();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_ArrayOfFloat != null)
    {
      int j = getMeasuredWidth();
      int i = getMeasuredHeight();
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131167363));
      }
      int k = a(2.0F);
      int m = i / 2;
      float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
      int n = arrayOfFloat.length;
      i = 0;
      while (i < n)
      {
        float f = arrayOfFloat[i];
        if ((f > 0.0F) && (f < 1.0F))
        {
          paramCanvas.save();
          paramCanvas.translate(f * j, m);
          paramCanvas.drawCircle(0.0F, 0.0F, k, this.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.restore();
        }
        i += 1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setAnimateEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  public void setProgress(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 147	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:jdField_a_of_type_Boolean	Z
    //   6: ifne +11 -> 17
    //   9: aload_0
    //   10: iload_1
    //   11: invokespecial 71	android/widget/SeekBar:setProgress	(I)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 79	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:jdField_a_of_type_AndroidAnimationValueAnimator	Landroid/animation/ValueAnimator;
    //   21: ifnull +10 -> 31
    //   24: aload_0
    //   25: getfield 79	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:jdField_a_of_type_AndroidAnimationValueAnimator	Landroid/animation/ValueAnimator;
    //   28: invokevirtual 84	android/animation/ValueAnimator:cancel	()V
    //   31: aload_0
    //   32: getfield 79	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:jdField_a_of_type_AndroidAnimationValueAnimator	Landroid/animation/ValueAnimator;
    //   35: ifnonnull +64 -> 99
    //   38: aload_0
    //   39: iconst_2
    //   40: newarray int
    //   42: dup
    //   43: iconst_0
    //   44: aload_0
    //   45: invokevirtual 150	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:getProgress	()I
    //   48: iastore
    //   49: dup
    //   50: iconst_1
    //   51: iload_1
    //   52: iastore
    //   53: invokestatic 154	android/animation/ValueAnimator:ofInt	([I)Landroid/animation/ValueAnimator;
    //   56: putfield 79	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:jdField_a_of_type_AndroidAnimationValueAnimator	Landroid/animation/ValueAnimator;
    //   59: aload_0
    //   60: getfield 79	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:jdField_a_of_type_AndroidAnimationValueAnimator	Landroid/animation/ValueAnimator;
    //   63: getstatic 24	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:jdField_a_of_type_AndroidViewAnimationInterpolator	Landroid/view/animation/Interpolator;
    //   66: invokevirtual 158	android/animation/ValueAnimator:setInterpolator	(Landroid/animation/TimeInterpolator;)V
    //   69: aload_0
    //   70: getfield 79	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:jdField_a_of_type_AndroidAnimationValueAnimator	Landroid/animation/ValueAnimator;
    //   73: new 160	alvm
    //   76: dup
    //   77: aload_0
    //   78: invokespecial 163	alvm:<init>	(Lcom/tencent/mobileqq/activity/richmedia/view/RotationSeekBar;)V
    //   81: invokevirtual 167	android/animation/ValueAnimator:addUpdateListener	(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    //   84: aload_0
    //   85: getfield 79	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:jdField_a_of_type_AndroidAnimationValueAnimator	Landroid/animation/ValueAnimator;
    //   88: invokevirtual 170	android/animation/ValueAnimator:start	()V
    //   91: goto -77 -> 14
    //   94: astore_2
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_2
    //   98: athrow
    //   99: aload_0
    //   100: getfield 79	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:jdField_a_of_type_AndroidAnimationValueAnimator	Landroid/animation/ValueAnimator;
    //   103: iconst_2
    //   104: newarray int
    //   106: dup
    //   107: iconst_0
    //   108: aload_0
    //   109: invokevirtual 150	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:getProgress	()I
    //   112: iastore
    //   113: dup
    //   114: iconst_1
    //   115: iload_1
    //   116: iastore
    //   117: invokevirtual 174	android/animation/ValueAnimator:setIntValues	([I)V
    //   120: goto -36 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	RotationSeekBar
    //   0	123	1	paramInt	int
    //   94	4	2	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	14	94	finally
    //   17	31	94	finally
    //   31	84	94	finally
    //   84	91	94	finally
    //   99	120	94	finally
  }
  
  /* Error */
  public void setSecondaryProgress(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 147	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:jdField_a_of_type_Boolean	Z
    //   6: ifne +11 -> 17
    //   9: aload_0
    //   10: iload_1
    //   11: invokespecial 74	android/widget/SeekBar:setSecondaryProgress	(I)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 86	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:b	Landroid/animation/ValueAnimator;
    //   21: ifnull +10 -> 31
    //   24: aload_0
    //   25: getfield 86	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:b	Landroid/animation/ValueAnimator;
    //   28: invokevirtual 84	android/animation/ValueAnimator:cancel	()V
    //   31: aload_0
    //   32: getfield 86	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:b	Landroid/animation/ValueAnimator;
    //   35: ifnonnull +64 -> 99
    //   38: aload_0
    //   39: iconst_2
    //   40: newarray int
    //   42: dup
    //   43: iconst_0
    //   44: aload_0
    //   45: invokevirtual 150	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:getProgress	()I
    //   48: iastore
    //   49: dup
    //   50: iconst_1
    //   51: iload_1
    //   52: iastore
    //   53: invokestatic 154	android/animation/ValueAnimator:ofInt	([I)Landroid/animation/ValueAnimator;
    //   56: putfield 86	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:b	Landroid/animation/ValueAnimator;
    //   59: aload_0
    //   60: getfield 86	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:b	Landroid/animation/ValueAnimator;
    //   63: getstatic 24	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:jdField_a_of_type_AndroidViewAnimationInterpolator	Landroid/view/animation/Interpolator;
    //   66: invokevirtual 158	android/animation/ValueAnimator:setInterpolator	(Landroid/animation/TimeInterpolator;)V
    //   69: aload_0
    //   70: getfield 86	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:b	Landroid/animation/ValueAnimator;
    //   73: new 176	alvn
    //   76: dup
    //   77: aload_0
    //   78: invokespecial 177	alvn:<init>	(Lcom/tencent/mobileqq/activity/richmedia/view/RotationSeekBar;)V
    //   81: invokevirtual 167	android/animation/ValueAnimator:addUpdateListener	(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    //   84: aload_0
    //   85: getfield 86	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:b	Landroid/animation/ValueAnimator;
    //   88: invokevirtual 170	android/animation/ValueAnimator:start	()V
    //   91: goto -77 -> 14
    //   94: astore_2
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_2
    //   98: athrow
    //   99: aload_0
    //   100: getfield 86	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:b	Landroid/animation/ValueAnimator;
    //   103: iconst_2
    //   104: newarray int
    //   106: dup
    //   107: iconst_0
    //   108: aload_0
    //   109: invokevirtual 150	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:getProgress	()I
    //   112: iastore
    //   113: dup
    //   114: iconst_1
    //   115: iload_1
    //   116: iastore
    //   117: invokevirtual 174	android/animation/ValueAnimator:setIntValues	([I)V
    //   120: goto -36 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	RotationSeekBar
    //   0	123	1	paramInt	int
    //   94	4	2	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	14	94	finally
    //   17	31	94	finally
    //   31	84	94	finally
    //   84	91	94	finally
    //   99	120	94	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.RotationSeekBar
 * JD-Core Version:    0.7.0.1
 */