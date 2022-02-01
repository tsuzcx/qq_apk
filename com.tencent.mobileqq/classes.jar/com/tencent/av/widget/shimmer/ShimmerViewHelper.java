package com.tencent.av.widget.shimmer;

import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;

public class ShimmerViewHelper
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private LinearGradient jdField_a_of_type_AndroidGraphicsLinearGradient;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private View jdField_a_of_type_AndroidViewView;
  private ShimmerViewHelper.AnimationSetupCallback jdField_a_of_type_ComTencentAvWidgetShimmerShimmerViewHelper$AnimationSetupCallback;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public ShimmerViewHelper(View paramView, Paint paramPaint, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidGraphicsPaint = paramPaint;
    a(paramAttributeSet);
  }
  
  /* Error */
  private void a(AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_m1
    //   2: putfield 33	com/tencent/av/widget/shimmer/ShimmerViewHelper:jdField_b_of_type_Int	I
    //   5: aload_1
    //   6: ifnull +72 -> 78
    //   9: aload_0
    //   10: getfield 23	com/tencent/av/widget/shimmer/ShimmerViewHelper:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   13: invokevirtual 39	android/view/View:getContext	()Landroid/content/Context;
    //   16: aload_1
    //   17: getstatic 45	com/tencent/qqrtc/api/R$styleable:bw	[I
    //   20: iconst_0
    //   21: iconst_0
    //   22: invokevirtual 51	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +51 -> 78
    //   30: aload_0
    //   31: aload_1
    //   32: getstatic 52	com/tencent/qqrtc/api/R$styleable:jdField_b_of_type_Int	I
    //   35: iconst_m1
    //   36: invokevirtual 58	android/content/res/TypedArray:getColor	(II)I
    //   39: putfield 33	com/tencent/av/widget/shimmer/ShimmerViewHelper:jdField_b_of_type_Int	I
    //   42: aload_1
    //   43: invokevirtual 61	android/content/res/TypedArray:recycle	()V
    //   46: goto +32 -> 78
    //   49: astore_2
    //   50: goto +22 -> 72
    //   53: astore_2
    //   54: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq -15 -> 42
    //   60: ldc 69
    //   62: iconst_2
    //   63: ldc 71
    //   65: aload_2
    //   66: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   69: goto -27 -> 42
    //   72: aload_1
    //   73: invokevirtual 61	android/content/res/TypedArray:recycle	()V
    //   76: aload_2
    //   77: athrow
    //   78: aload_0
    //   79: new 77	android/graphics/Matrix
    //   82: dup
    //   83: invokespecial 78	android/graphics/Matrix:<init>	()V
    //   86: putfield 80	com/tencent/av/widget/shimmer/ShimmerViewHelper:jdField_a_of_type_AndroidGraphicsMatrix	Landroid/graphics/Matrix;
    //   89: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	ShimmerViewHelper
    //   0	90	1	paramAttributeSet	AttributeSet
    //   49	1	2	localObject	Object
    //   53	24	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   30	42	49	finally
    //   54	69	49	finally
    //   30	42	53	java/lang/Exception
  }
  
  private void c()
  {
    float f = -this.jdField_a_of_type_AndroidViewView.getWidth();
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_b_of_type_Int;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(f, 0.0F, 0.0F, 0.0F, new int[] { i, j, i }, new float[] { 0.0F, 0.5F, 1.0F }, localTileMode);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsLinearGradient);
  }
  
  protected void a()
  {
    c();
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      ShimmerViewHelper.AnimationSetupCallback localAnimationSetupCallback = this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerViewHelper$AnimationSetupCallback;
      if (localAnimationSetupCallback != null) {
        localAnimationSetupCallback.a(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_b_of_type_Boolean) {
      c();
    }
  }
  
  public void a(ShimmerViewHelper.AnimationSetupCallback paramAnimationSetupCallback)
  {
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerViewHelper$AnimationSetupCallback = paramAnimationSetupCallback;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsPaint.getShader() == null) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsLinearGradient);
      }
      this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(this.jdField_a_of_type_Float * 2.0F, 0.0F);
      this.jdField_a_of_type_AndroidGraphicsLinearGradient.setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_b_of_type_Boolean) {
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.widget.shimmer.ShimmerViewHelper
 * JD-Core Version:    0.7.0.1
 */