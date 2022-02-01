package com.tencent.mobileqq.activity.qwallet.widget.ksong;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KSongProsBar
  extends View
{
  private static final String TAG = "KSongProsBar";
  private Paint bgPaint = new Paint();
  private Paint fPaint = new Paint();
  private int h;
  private int lineH = 10;
  private KSHelper.Config mConfig;
  private int offTop;
  private RectF rect = new RectF();
  private int redus = 3;
  private String totalTime;
  private int txtMarginTop;
  private Paint txtPaint = new Paint();
  private int txtW;
  private String upTime;
  private int uprate;
  private int w;
  
  public KSongProsBar(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public KSongProsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @SuppressLint({"NewApi"})
  public KSongProsBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext, paramAttributeSet, paramInt);
  }
  
  private String convert2Time(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat("mm:ss").format(localDate);
  }
  
  private void initPaint(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext.getResources();
    paramContext = new Paint();
    paramContext.setAntiAlias(true);
    paramContext.setStrokeJoin(Paint.Join.ROUND);
    paramContext.setStrokeCap(Paint.Cap.ROUND);
    paramContext.setStyle(Paint.Style.FILL);
    this.fPaint = new Paint(paramContext);
    this.fPaint.setColor(paramInt1);
    this.bgPaint = new Paint(paramContext);
    this.bgPaint.setColor(paramInt2);
    this.txtPaint = new Paint(paramContext);
    this.txtPaint.setColor(paramInt3);
    this.txtPaint.setTextSize(dp(10.0F));
  }
  
  /* Error */
  private void initView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: getstatic 145	com/tencent/mobileqq/R$styleable:Qwsong	[I
    //   5: iload_3
    //   6: iconst_0
    //   7: invokevirtual 149	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   10: astore_2
    //   11: aload_0
    //   12: aload_1
    //   13: aload_2
    //   14: iconst_1
    //   15: sipush -256
    //   18: invokevirtual 155	android/content/res/TypedArray:getColor	(II)I
    //   21: aload_2
    //   22: iconst_0
    //   23: iconst_m1
    //   24: invokevirtual 155	android/content/res/TypedArray:getColor	(II)I
    //   27: aload_2
    //   28: iconst_2
    //   29: sipush -256
    //   32: invokevirtual 155	android/content/res/TypedArray:getColor	(II)I
    //   35: invokespecial 157	com/tencent/mobileqq/activity/qwallet/widget/ksong/KSongProsBar:initPaint	(Landroid/content/Context;III)V
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 56	com/tencent/mobileqq/activity/qwallet/widget/ksong/KSongProsBar:redus	I
    //   43: putfield 159	com/tencent/mobileqq/activity/qwallet/widget/ksong/KSongProsBar:uprate	I
    //   46: aload_0
    //   47: aload_0
    //   48: ldc 160
    //   50: invokevirtual 133	com/tencent/mobileqq/activity/qwallet/widget/ksong/KSongProsBar:dp	(F)I
    //   53: putfield 162	com/tencent/mobileqq/activity/qwallet/widget/ksong/KSongProsBar:txtMarginTop	I
    //   56: aload_2
    //   57: invokevirtual 165	android/content/res/TypedArray:recycle	()V
    //   60: return
    //   61: astore_1
    //   62: aload_2
    //   63: invokevirtual 165	android/content/res/TypedArray:recycle	()V
    //   66: return
    //   67: astore_1
    //   68: aload_2
    //   69: invokevirtual 165	android/content/res/TypedArray:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	KSongProsBar
    //   0	74	1	paramContext	Context
    //   0	74	2	paramAttributeSet	AttributeSet
    //   0	74	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   11	56	61	java/lang/Exception
    //   11	56	67	finally
  }
  
  protected final int dp(float paramFloat)
  {
    return AIOUtils.a(paramFloat, getResources());
  }
  
  public void init(KSHelper.Config paramConfig)
  {
    if (paramConfig == null) {
      return;
    }
    this.mConfig = paramConfig;
    this.totalTime = convert2Time(paramConfig.total);
    this.upTime = convert2Time(0L);
    postInvalidate();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    this.rect.set(0.0F, this.offTop, this.w, this.offTop + this.lineH);
    paramCanvas.drawRoundRect(this.rect, this.redus, this.redus, this.bgPaint);
    this.rect.set(0.0F, this.offTop, this.uprate, this.offTop + this.lineH);
    paramCanvas.drawRoundRect(this.rect, this.redus, this.redus, this.fPaint);
    if (!TextUtils.isEmpty(this.upTime)) {
      paramCanvas.drawText(this.upTime, 0.0F, this.offTop + this.txtMarginTop, this.txtPaint);
    }
    if (!TextUtils.isEmpty(this.totalTime)) {
      paramCanvas.drawText(this.totalTime, this.w - this.txtW, this.offTop + this.txtMarginTop, this.txtPaint);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.w = getMeasuredWidth();
    paramInt1 = getMeasuredHeight();
    this.h = paramInt1;
    this.offTop = (paramInt1 / 3);
    QLog.i("KSongProsBar", 2, "w = " + this.w + " h = " + this.h);
    if ((this.w > 0) || (this.h > 0))
    {
      Rect localRect = new Rect();
      this.txtPaint.getTextBounds("00:00", 0, "00:00".length(), localRect);
      this.txtW = localRect.width();
      postInvalidate();
    }
  }
  
  public void update(long paramLong)
  {
    if ((this.w <= 0) || (this.mConfig == null))
    {
      QLog.i("KSongProsBar", 2, "error call, not initialized...");
      return;
    }
    this.upTime = convert2Time(paramLong);
    this.uprate = ((int)((float)paramLong / (float)this.mConfig.total * this.w));
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.ksong.KSongProsBar
 * JD-Core Version:    0.7.0.1
 */