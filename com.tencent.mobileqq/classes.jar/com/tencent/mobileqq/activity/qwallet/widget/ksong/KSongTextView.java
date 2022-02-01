package com.tencent.mobileqq.activity.qwallet.widget.ksong;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class KSongTextView
  extends TextView
{
  public static final int SP_SIZE_DEFAULT = 14;
  private static final String TAG = "KSongTextView";
  public static final int TYPE_DOWN_TIME = 0;
  public static final int TYPE_UP_TIME = 1;
  private long downTimeStart = 0L;
  private Matrix mGradientMatrix;
  private LinearGradient mLinearGradient;
  private float mTranslate = 0.0F;
  private KSHelper.KListener mkl;
  private int text_color;
  private long timeDelay = 50L;
  private float transStep = 0.0F;
  private int type = 1;
  
  public KSongTextView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public KSongTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @SuppressLint({"NewApi"})
  public KSongTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext, paramAttributeSet, paramInt);
  }
  
  /* Error */
  private void initView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: getstatic 64	com/tencent/mobileqq/R$styleable:Qwsong	[I
    //   5: iload_3
    //   6: iconst_0
    //   7: invokevirtual 70	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   10: astore_1
    //   11: aload_0
    //   12: aload_1
    //   13: iconst_1
    //   14: sipush -256
    //   17: invokevirtual 76	android/content/res/TypedArray:getColor	(II)I
    //   20: aload_1
    //   21: iconst_0
    //   22: iconst_m1
    //   23: invokevirtual 76	android/content/res/TypedArray:getColor	(II)I
    //   26: invokevirtual 80	com/tencent/mobileqq/activity/qwallet/widget/ksong/KSongTextView:initKSongGradient	(II)V
    //   29: aload_0
    //   30: aload_0
    //   31: invokevirtual 84	com/tencent/mobileqq/activity/qwallet/widget/ksong/KSongTextView:getCurrentTextColor	()I
    //   34: putfield 86	com/tencent/mobileqq/activity/qwallet/widget/ksong/KSongTextView:text_color	I
    //   37: aload_1
    //   38: invokevirtual 90	android/content/res/TypedArray:recycle	()V
    //   41: return
    //   42: astore_2
    //   43: aload_1
    //   44: invokevirtual 90	android/content/res/TypedArray:recycle	()V
    //   47: return
    //   48: astore_2
    //   49: aload_1
    //   50: invokevirtual 90	android/content/res/TypedArray:recycle	()V
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	KSongTextView
    //   0	55	1	paramContext	Context
    //   0	55	2	paramAttributeSet	AttributeSet
    //   0	55	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   11	37	42	java/lang/Exception
    //   11	37	48	finally
  }
  
  protected final int dp2px(float paramFloat)
  {
    return AIOUtils.a(paramFloat, getResources());
  }
  
  public void initKSongGradient(int paramInt1, int paramInt2)
  {
    Object localObject1 = getPaint();
    Object localObject2 = Shader.TileMode.CLAMP;
    localObject2 = new LinearGradient(-1.0F, 0.0F, 0.0F, 0.0F, new int[] { paramInt1, paramInt2 }, null, (Shader.TileMode)localObject2);
    this.mLinearGradient = ((LinearGradient)localObject2);
    ((TextPaint)localObject1).setShader((Shader)localObject2);
    localObject1 = this.mLinearGradient;
    localObject2 = new Matrix();
    this.mGradientMatrix = ((Matrix)localObject2);
    ((LinearGradient)localObject1).setLocalMatrix((Matrix)localObject2);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mGradientMatrix == null) {
      return;
    }
    QLog.i("KSongTextView", 2, "type = " + this.type);
    if (this.type == 0)
    {
      this.mTranslate -= this.transStep;
      if (this.mTranslate <= 0.0F)
      {
        if (this.mkl != null) {
          this.mkl.complete();
        }
        setVisibility(4);
        return;
      }
      if (this.mkl != null) {
        this.mkl.update(System.currentTimeMillis() - this.downTimeStart);
      }
      postInvalidateDelayed(this.timeDelay);
    }
    this.mGradientMatrix.setTranslate(this.mTranslate, 0.0F);
    this.mLinearGradient.setLocalMatrix(this.mGradientMatrix);
  }
  
  public void reset()
  {
    updateRate(0.0F, 14, this.text_color);
  }
  
  public void startDownTime(long paramLong, KSHelper.KListener paramKListener)
  {
    QLog.i("KSongTextView", 2, "startDownTime = " + paramLong);
    if (4 == getVisibility()) {
      setVisibility(0);
    }
    this.type = 0;
    this.mkl = paramKListener;
    this.mTranslate = getPaint().measureText(getText().toString());
    paramLong /= this.timeDelay;
    this.transStep = (this.mTranslate / (float)paramLong);
    this.downTimeStart = System.currentTimeMillis();
    postInvalidate();
  }
  
  public void updateRate(float paramFloat, int paramInt1, int paramInt2)
  {
    float f = getPaint().measureText(getText().toString());
    this.mTranslate = (f * paramFloat);
    if (this.mTranslate > f) {
      this.mTranslate = f;
    }
    if (paramInt1 > 0) {
      setTextSize(2, paramInt1);
    }
    setTextColor(paramInt2);
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.ksong.KSongTextView
 * JD-Core Version:    0.7.0.1
 */