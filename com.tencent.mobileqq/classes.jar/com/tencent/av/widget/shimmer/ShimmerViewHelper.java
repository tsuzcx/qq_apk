package com.tencent.av.widget.shimmer;

import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;

public class ShimmerViewHelper
{
  private View a;
  private Paint b;
  private float c;
  private LinearGradient d;
  private Matrix e;
  private int f;
  private int g;
  private boolean h = true;
  private boolean i;
  private ShimmerViewHelper.AnimationSetupCallback j;
  
  public ShimmerViewHelper(View paramView, Paint paramPaint, AttributeSet paramAttributeSet)
  {
    this.a = paramView;
    this.b = paramPaint;
    a(paramAttributeSet);
  }
  
  /* Error */
  private void a(AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_m1
    //   2: putfield 41	com/tencent/av/widget/shimmer/ShimmerViewHelper:g	I
    //   5: aload_1
    //   6: ifnull +72 -> 78
    //   9: aload_0
    //   10: getfield 31	com/tencent/av/widget/shimmer/ShimmerViewHelper:a	Landroid/view/View;
    //   13: invokevirtual 47	android/view/View:getContext	()Landroid/content/Context;
    //   16: aload_1
    //   17: getstatic 53	com/tencent/qqrtc/api/R$styleable:bz	[I
    //   20: iconst_0
    //   21: iconst_0
    //   22: invokevirtual 59	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +51 -> 78
    //   30: aload_0
    //   31: aload_1
    //   32: getstatic 62	com/tencent/qqrtc/api/R$styleable:bA	I
    //   35: iconst_m1
    //   36: invokevirtual 68	android/content/res/TypedArray:getColor	(II)I
    //   39: putfield 41	com/tencent/av/widget/shimmer/ShimmerViewHelper:g	I
    //   42: aload_1
    //   43: invokevirtual 71	android/content/res/TypedArray:recycle	()V
    //   46: goto +32 -> 78
    //   49: astore_2
    //   50: goto +22 -> 72
    //   53: astore_2
    //   54: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq -15 -> 42
    //   60: ldc 79
    //   62: iconst_2
    //   63: ldc 81
    //   65: aload_2
    //   66: invokestatic 84	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   69: goto -27 -> 42
    //   72: aload_1
    //   73: invokevirtual 71	android/content/res/TypedArray:recycle	()V
    //   76: aload_2
    //   77: athrow
    //   78: aload_0
    //   79: new 86	android/graphics/Matrix
    //   82: dup
    //   83: invokespecial 87	android/graphics/Matrix:<init>	()V
    //   86: putfield 89	com/tencent/av/widget/shimmer/ShimmerViewHelper:e	Landroid/graphics/Matrix;
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
  
  private void g()
  {
    float f1 = -this.a.getWidth();
    int k = this.f;
    int m = this.g;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.d = new LinearGradient(f1, 0.0F, 0.0F, 0.0F, new int[] { k, m, k }, new float[] { 0.0F, 0.5F, 1.0F }, localTileMode);
    this.b.setShader(this.d);
  }
  
  public float a()
  {
    return this.c;
  }
  
  public void a(float paramFloat)
  {
    this.c = paramFloat;
    this.a.invalidate();
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
    if (this.i) {
      g();
    }
  }
  
  public void a(ShimmerViewHelper.AnimationSetupCallback paramAnimationSetupCallback)
  {
    this.j = paramAnimationSetupCallback;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
    if (this.i) {
      g();
    }
  }
  
  public boolean b()
  {
    return this.h;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public int d()
  {
    return this.g;
  }
  
  protected void e()
  {
    g();
    if (!this.i)
    {
      this.i = true;
      ShimmerViewHelper.AnimationSetupCallback localAnimationSetupCallback = this.j;
      if (localAnimationSetupCallback != null) {
        localAnimationSetupCallback.a(this.a);
      }
    }
  }
  
  public void f()
  {
    if (this.h)
    {
      if (this.b.getShader() == null) {
        this.b.setShader(this.d);
      }
      this.e.setTranslate(this.c * 2.0F, 0.0F);
      this.d.setLocalMatrix(this.e);
      return;
    }
    this.b.setShader(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.widget.shimmer.ShimmerViewHelper
 * JD-Core Version:    0.7.0.1
 */