package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Xfermode;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;

public class PttAudioWaveView
  extends View
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = a(this.jdField_i_of_type_Int, 0.33F);
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private PorterDuff.Mode jdField_a_of_type_AndroidGraphicsPorterDuff$Mode = PorterDuff.Mode.SRC_IN;
  PorterDuffXfermode jdField_a_of_type_AndroidGraphicsPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Xfermode jdField_a_of_type_AndroidGraphicsXfermode;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  PttAudioWaveView.OnPressListener jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView$OnPressListener;
  private PttAudioWaveView.SeekProgressListener jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView$SeekProgressListener;
  Runnable jdField_a_of_type_JavaLangRunnable = new PttAudioWaveView.1(this);
  boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[0];
  private int[] jdField_a_of_type_ArrayOfInt;
  float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  Canvas jdField_b_of_type_AndroidGraphicsCanvas;
  boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = 0.0F;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float = 0.0F;
  int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean = false;
  private float jdField_e_of_type_Float = 0.0F;
  int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean = true;
  private float jdField_f_of_type_Float = 1.5F;
  int jdField_f_of_type_Int = 15;
  boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int;
  boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int = -1;
  boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int = -1;
  private volatile boolean jdField_i_of_type_Boolean = true;
  private int j = 1;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s = 0;
  private int t = 0;
  private int u;
  private int v;
  
  public PttAudioWaveView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public PttAudioWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public PttAudioWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  public static double a(int[] paramArrayOfInt)
  {
    int i3 = paramArrayOfInt.length;
    int i2 = 0;
    double d2 = 0.0D;
    double d1 = 0.0D;
    int i1 = 0;
    while (i1 < i3)
    {
      d3 = paramArrayOfInt[i1];
      Double.isNaN(d3);
      d1 += d3;
      i1 += 1;
    }
    double d3 = i3;
    Double.isNaN(d3);
    double d4 = d1 / d3;
    d1 = d2;
    i1 = i2;
    while (i1 < i3)
    {
      d2 = paramArrayOfInt[i1];
      Double.isNaN(d2);
      double d5 = paramArrayOfInt[i1];
      Double.isNaN(d5);
      d1 += (d2 - d4) * (d5 - d4);
      i1 += 1;
    }
    Double.isNaN(d3);
    return d1 / d3;
  }
  
  public static float a(int paramInt1, int paramInt2, float paramFloat)
  {
    return (float)(1.0D - Math.pow(1.0F - paramInt1 / paramInt2, paramFloat * 2.0F));
  }
  
  public static int a(int paramInt, float paramFloat)
  {
    float f1 = (paramInt >> 16 & 0xFF) / 255.0F;
    float f2 = (paramInt >> 8 & 0xFF) / 255.0F;
    float f3 = (paramInt & 0xFF) / 255.0F;
    return (int)((paramInt >> 24 & 0xFF) / 255.0F * paramFloat * 255.0F + 0.5F) << 24 | (int)(f1 * 255.0F + 0.5F) << 16 | (int)(f2 * 255.0F + 0.5F) << 8 | (int)(f3 * 255.0F + 0.5F);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    }
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    if ((i1 == paramInt1) && (i2 == paramInt2)) {
      return paramBitmap;
    }
    paramBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initBitmap change width =");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" height=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" oldBitmapWidth =");
      localStringBuilder.append(i1);
      localStringBuilder.append(" oldBitmpHeight=");
      localStringBuilder.append(i2);
      QLog.d("PttAudioWaveView", 2, localStringBuilder.toString());
    }
    return paramBitmap;
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Float = ((paramFloat - paramInt1) / (paramInt2 - paramInt1));
  }
  
  private void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.r);
    float f1 = this.jdField_d_of_type_Float;
    int i1 = this.s;
    if (f1 > i1) {
      this.jdField_d_of_type_Float = i1;
    }
    f1 = this.jdField_d_of_type_Float;
    i1 = this.t;
    if (f1 < i1) {
      this.jdField_d_of_type_Float = i1;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      f1 = this.jdField_d_of_type_Float;
      float f2 = getMeasuredHeight();
      i1 = this.jdField_a_of_type_Int;
      int i2 = this.jdField_i_of_type_Int;
      Object localObject = Shader.TileMode.CLAMP;
      localObject = new LinearGradient(f1, 0.0F, f1, f2, new int[] { i1, i2, i1 }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject);
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader((Shader)localObject);
      f1 = this.jdField_d_of_type_Float;
      paramCanvas.drawLine(f1, 0.0F, f1, getMeasuredHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    PttAudioWaveView.OnPressListener localOnPressListener = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView$OnPressListener;
    if (localOnPressListener != null) {
      localOnPressListener.a(paramBoolean);
    }
    super.setPressed(paramBoolean);
  }
  
  public static int[] a(int[] paramArrayOfInt, int paramInt)
  {
    int i1 = 0;
    if (paramInt < 100)
    {
      arrayOfInt = new int[paramInt];
      while (i1 < paramInt)
      {
        arrayOfInt[i1] = ((int)(paramArrayOfInt[i1] * 0.02480583F));
        if (arrayOfInt[i1] > 255) {
          arrayOfInt[i1] = 255;
        }
        i1 += 1;
      }
      return arrayOfInt;
    }
    int[] arrayOfInt = new int[100];
    float f3 = paramInt / 100.0F;
    float f1 = f3;
    long l1 = 0L;
    int i2 = 0;
    i1 = 0;
    int i4;
    for (int i3 = 0; i2 < paramInt; i3 = i4)
    {
      long l2 = l1 + paramArrayOfInt[i2];
      int i5 = i1 + 1;
      l1 = l2;
      i1 = i5;
      float f2 = f1;
      i4 = i3;
      if (i2 > f1)
      {
        arrayOfInt[i3] = ((int)((float)l2 / i5 * 0.02480583F));
        if (arrayOfInt[i3] > 255) {
          arrayOfInt[i3] = 255;
        }
        i4 = i3 + 1;
        f2 = (i4 + 1) * f3;
        i1 = 0;
        l1 = 0L;
      }
      i2 += 1;
      f1 = f2;
    }
    return arrayOfInt;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_i_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.j);
    this.k = (ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2);
    this.jdField_a_of_type_AndroidGraphicsXfermode = new PorterDuffXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode);
    this.l = ViewUtils.a(3.0F);
    this.o = this.l;
    this.q = (ViewUtils.a(3.0F) - 1);
    this.r = ViewUtils.a(1.0F);
    this.u = ViewUtils.a(174.0F);
    this.v = ViewUtils.a(5.0F);
  }
  
  private void d()
  {
    if ((this.jdField_b_of_type_AndroidGraphicsCanvas != null) && (this.jdField_a_of_type_AndroidGraphicsPaint != null) && (this.jdField_a_of_type_ArrayOfFloat.length > 0))
    {
      if (!this.jdField_g_of_type_Boolean) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("drawBitMapDesWave mSelectColor=");
        ((StringBuilder)localObject).append(Integer.toHexString(this.jdField_i_of_type_Int));
        ((StringBuilder)localObject).append("bitmpt");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight());
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth());
        ((StringBuilder)localObject).append(" len");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfFloat.length);
        ((StringBuilder)localObject).append(" this=");
        ((StringBuilder)localObject).append(this);
        QLog.d("PttAudioWaveView", 2, ((StringBuilder)localObject).toString());
      }
      int i1 = 0;
      this.jdField_g_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_i_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode);
      this.jdField_b_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      for (;;)
      {
        localObject = this.jdField_a_of_type_ArrayOfFloat;
        if (i1 >= localObject.length) {
          break;
        }
        int i2 = this.jdField_h_of_type_Int;
        a(i1, i2 - localObject[i1] / 2.0F, i2 + localObject[i1] / 2.0F);
        i1 += 1;
      }
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode);
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_d_of_type_Float, getMeasuredHeight());
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(75);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_d_of_type_Float, 0.0F, getMeasuredWidth(), getMeasuredHeight());
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
  }
  
  public float a(float paramFloat)
  {
    float f1 = this.jdField_e_of_type_Float;
    float f2 = this.jdField_a_of_type_ArrayOfFloat.length * f1;
    return paramFloat / f2 * (f2 - (f1 - this.q));
  }
  
  public void a()
  {
    this.jdField_i_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    int i2 = localObject.length;
    this.jdField_a_of_type_ArrayOfFloat = new float[localObject.length];
    int i3 = this.m;
    int i4 = this.n;
    int i1 = 0;
    float f1;
    double d1;
    float f2;
    while (i1 < this.jdField_a_of_type_ArrayOfFloat.length)
    {
      f1 = a(this.jdField_a_of_type_ArrayOfInt[i1], 255, this.jdField_f_of_type_Float);
      int i5;
      float f3;
      if (f1 > 0.9D)
      {
        i5 = this.l;
        f3 = i5 + f1 * (this.n - i5);
        d1 = i2 % 4 + 3;
        Double.isNaN(d1);
        d1 = 6.28D / d1;
        double d2 = i1;
        Double.isNaN(d2);
        f1 = (float)Math.sin(d1 * d2);
        f2 = i3 - i4;
      }
      else
      {
        i5 = this.l;
        f3 = i5;
        f2 = this.m - i5;
      }
      f1 = f3 + f1 * f2;
      if (f1 > this.o) {
        this.o = ((int)f1);
      }
      this.jdField_a_of_type_ArrayOfFloat[i1] = f1;
      i1 += 1;
    }
    for (i1 = 1;; i1 = i2)
    {
      localObject = this.jdField_a_of_type_ArrayOfFloat;
      if (i1 >= localObject.length - 1) {
        break;
      }
      f1 = localObject[(i1 - 1)];
      i2 = i1 + 1;
      f2 = localObject[i2];
      d1 = f1;
      Double.isNaN(d1);
      if (d1 * 0.5D > localObject[i1]) {
        localObject[i1] = ((f1 + localObject[i1]) / 2.0F);
      }
      d1 = f2;
      Double.isNaN(d1);
      localObject = this.jdField_a_of_type_ArrayOfFloat;
      if (d1 * 0.5D > localObject[i1]) {
        localObject[i1] = ((localObject[i1] + f2) / 2.0F);
      }
    }
  }
  
  protected void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    int i1 = this.jdField_a_of_type_ArrayOfFloat.length;
    float f2 = (getMeasuredWidth() - this.j - this.jdField_b_of_type_Int - this.jdField_d_of_type_Int) / i1;
    i1 = this.v;
    float f1 = f2;
    if (f2 > i1) {
      f1 = i1;
    }
    this.jdField_e_of_type_Float = f1;
    i1 = (int)(paramInt * f1) + this.j + this.jdField_b_of_type_Int;
    int i2 = this.q + i1;
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    f1 = i1;
    f2 = i2;
    localRectF.set(f1, paramFloat1, f2, paramFloat2);
    this.jdField_b_of_type_AndroidGraphicsCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (paramInt == this.jdField_a_of_type_ArrayOfFloat.length - 1) {
      this.s = i2;
    }
    if (paramInt == 0) {
      this.t = i1;
    }
    paramInt = (int)(this.q / 2.0F);
    localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    float f3 = paramInt;
    localRectF.set(f1, paramFloat1 - f3 + 1.0F, f2, paramFloat1 + f3 + 1.0F);
    this.jdField_b_of_type_AndroidGraphicsCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 180.0F, 180.0F, true, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(f1, paramFloat2 - f3 - 1.0F, f2, paramFloat2 + f3 - 1.0F);
    this.jdField_b_of_type_AndroidGraphicsCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 180.0F, -180.0F, true, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttAudioWaveView", 2, "destory");
    }
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    localBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      localBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
      if (localBitmap != null)
      {
        if (localBitmap.isRecycled()) {
          return;
        }
        d();
        int i1;
        if ((this.jdField_d_of_type_Float <= 0.0F) && (!this.jdField_d_of_type_Boolean))
        {
          paramCanvas.save();
          i1 = 0;
        }
        else
        {
          i1 = paramCanvas.saveLayer(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight(), null, 31);
          this.jdField_h_of_type_Boolean = true;
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_i_of_type_Int);
        paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
        if (this.jdField_d_of_type_Float > 0.0F)
        {
          e();
          this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsXfermode);
          paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
          this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
        }
        if ((this.jdField_d_of_type_Float > 0.0F) || (this.jdField_d_of_type_Boolean)) {
          a(paramCanvas);
        }
        if (this.jdField_h_of_type_Boolean)
        {
          paramCanvas.restoreToCount(i1);
          this.jdField_h_of_type_Boolean = false;
          return;
        }
        paramCanvas.restore();
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLayout changed=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" left=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" top=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" right=");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" bottom=");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append(" hasDataConvert=");
      localStringBuilder.append(this.jdField_i_of_type_Boolean);
      QLog.d("PttAudioWaveView", 2, localStringBuilder.toString());
    }
    if (getMeasuredWidth() > 0)
    {
      if (getMeasuredHeight() <= 0) {
        return;
      }
      if (paramBoolean)
      {
        this.jdField_b_of_type_Int = getPaddingLeft();
        this.jdField_c_of_type_Int = getPaddingTop();
        this.jdField_d_of_type_Int = getPaddingRight();
        this.jdField_e_of_type_Int = getPaddingBottom();
        this.jdField_g_of_type_Int = ((this.jdField_g_of_type_Int + getMeasuredWidth() / 2) / 2 - getMeasuredWidth() / 2);
        if (this.jdField_g_of_type_Int < 0) {
          this.jdField_g_of_type_Int = 0;
        }
        this.jdField_h_of_type_Int = (getMeasuredHeight() / 2);
        this.m = (getMeasuredHeight() - ViewUtils.b(this.jdField_f_of_type_Int) * 2);
        if (this.m < ViewUtils.b(12.0F)) {
          this.m = ViewUtils.b(12.0F);
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.u + this.jdField_b_of_type_Int + this.jdField_d_of_type_Int, getMeasuredHeight() + this.jdField_c_of_type_Int + this.jdField_e_of_type_Int);
        this.jdField_b_of_type_AndroidGraphicsBitmap = a(this.jdField_b_of_type_AndroidGraphicsBitmap, this.u + this.jdField_b_of_type_Int + this.jdField_d_of_type_Int, getMeasuredHeight() + this.jdField_c_of_type_Int + this.jdField_e_of_type_Int);
        this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
        this.jdField_b_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_b_of_type_AndroidGraphicsBitmap);
        this.jdField_g_of_type_Boolean = true;
        paramInt1 = this.jdField_h_of_type_Int;
        paramInt2 = this.m;
        this.p = (paramInt1 + paramInt2 / 2);
        double d1 = paramInt2;
        Double.isNaN(d1);
        this.n = ((int)(d1 * 0.8D));
        if (!this.jdField_i_of_type_Boolean) {
          a();
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      if (this.jdField_f_of_type_Boolean) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = false;
      a(true);
      getHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      return true;
    }
    if (paramMotionEvent.getAction() == 2)
    {
      float f1 = Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float);
      float f2 = Math.abs(paramMotionEvent.getY() - this.jdField_b_of_type_Float);
      int i1 = this.k;
      if ((f1 > i1) || (f2 > i1))
      {
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_d_of_type_Float = paramMotionEvent.getX();
          invalidate();
          a(paramMotionEvent.getX(), this.t, this.s);
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView$SeekProgressListener;
          if ((paramMotionEvent != null) && (!this.jdField_d_of_type_Boolean))
          {
            this.jdField_d_of_type_Boolean = true;
            paramMotionEvent.a(this);
          }
        }
        getHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_b_of_type_Boolean = true;
      }
      return true;
    }
    if (paramMotionEvent.getAction() == 1)
    {
      getHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_d_of_type_Boolean = false;
      a(false);
      if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        paramMotionEvent = this.jdField_a_of_type_AndroidViewView$OnClickListener;
        if (paramMotionEvent != null) {
          paramMotionEvent.onClick(this);
        }
        return true;
      }
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
      {
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView$SeekProgressListener;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.a(this, this.jdField_c_of_type_Float);
          ReportController.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 3, 0, "", "", "", "");
        }
        return true;
      }
    }
    else if (paramMotionEvent.getAction() == 3)
    {
      getHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_d_of_type_Boolean = false;
    }
    return false;
  }
  
  public void setAudioData(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i3 = 0;
    this.jdField_i_of_type_Boolean = false;
    boolean bool = QLog.isColorLevel();
    String str = "PttAudioWaveView";
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setAudioData mCenterHeight=");
      ((StringBuilder)localObject).append(this.jdField_h_of_type_Int);
      ((StringBuilder)localObject).append(" data.length");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfFloat.length);
      QLog.d("PttAudioWaveView", 2, ((StringBuilder)localObject).toString());
    }
    int i1 = paramInt1 / ViewUtils.b(5.0F);
    int i2 = i1;
    if (i1 > 34) {
      i2 = 34;
    }
    i1 = i2;
    if (i2 < 3) {
      i1 = 3;
    }
    if (paramArrayOfInt == null)
    {
      this.jdField_a_of_type_ArrayOfInt = new int[i1];
      paramArrayOfInt = new Random(System.currentTimeMillis());
      paramInt1 = i3;
      while (paramInt1 < i1)
      {
        this.jdField_a_of_type_ArrayOfInt[paramInt1] = paramArrayOfInt.nextInt(255);
        paramInt1 += 1;
      }
      return;
    }
    Object localObject = new int[i1];
    float f1 = paramArrayOfInt.length;
    float f3 = i1;
    float f2 = f1 / f3;
    f1 = f2;
    int i6 = 255;
    i3 = 0;
    int i8 = 0;
    int i4 = 0;
    long l1 = 0L;
    int i9 = 0;
    int i5 = 0;
    i2 = i1;
    while (i3 < paramArrayOfInt.length)
    {
      long l2 = l1 + paramArrayOfInt[i3];
      int i12 = i9 + 1;
      int i11;
      int i10;
      int i7;
      if (i3 < f1)
      {
        i11 = i6;
        i10 = i8;
        i9 = i4;
        l1 = l2;
        i1 = i12;
        i7 = i5;
        if (i3 != paramArrayOfInt.length - 1) {}
      }
      else
      {
        i7 = i5 + 1;
        localObject[i5] = ((int)(l2 / i12));
        i1 = i7 - 1;
        i10 = i8 + localObject[i1];
        i9 = Math.max(i4, localObject[i1]);
        i11 = Math.min(i6, localObject[i1]);
        f1 = i7 + 1;
        f1 *= f2;
        l1 = 0L;
        i1 = 0;
      }
      i3 += 1;
      i6 = i11;
      i8 = i10;
      i4 = i9;
      i9 = i1;
      i5 = i7;
    }
    this.jdField_a_of_type_ArrayOfInt = ((int[])localObject);
    if ((this.jdField_a_of_type_ArrayOfFloat.length <= 0) && (this.jdField_h_of_type_Int > 0))
    {
      a();
      this.jdField_g_of_type_Boolean = true;
    }
    if (new Random().nextInt(1000) == 520)
    {
      paramArrayOfInt = new HashMap();
      paramArrayOfInt.put("voiceLength", String.valueOf(paramInt2));
      paramArrayOfInt.put("waveWidth", String.valueOf(paramInt1));
      paramArrayOfInt.put("waveNum", String.valueOf(i2));
      paramArrayOfInt.put("waveMax", String.valueOf(i4));
      paramArrayOfInt.put("waveMin", String.valueOf(i6));
      paramArrayOfInt.put("waveAvg", String.valueOf(i8 / f3));
      paramArrayOfInt.put("waveVar", String.valueOf(Math.sqrt(a((int[])localObject))));
      if (QLog.isColorLevel()) {
        QLog.d(str, 2, "real do report");
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "PttWaveInfo", true, 0L, 0L, paramArrayOfInt, "");
    }
  }
  
  public void setCanSupportSlide(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setMaxTopBottomPadding(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
  }
  
  public void setOnPressListener(PttAudioWaveView.OnPressListener paramOnPressListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView$OnPressListener = paramOnPressListener;
  }
  
  public void setProgress(float paramFloat)
  {
    float f1 = paramFloat;
    if (paramFloat > 1.0F) {
      f1 = 1.0F;
    }
    this.jdField_c_of_type_Float = a(f1);
    this.jdField_d_of_type_Float = (this.s * this.jdField_c_of_type_Float);
    invalidate();
  }
  
  public void setProgressColor(int paramInt)
  {
    if (paramInt != this.jdField_i_of_type_Int)
    {
      this.jdField_i_of_type_Int = paramInt;
      this.jdField_a_of_type_Int = a(this.jdField_i_of_type_Int, 0.33F);
      this.jdField_g_of_type_Boolean = true;
      invalidate();
    }
  }
  
  public void setSeekListener(PttAudioWaveView.SeekProgressListener paramSeekProgressListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView$SeekProgressListener = paramSeekProgressListener;
  }
  
  public void setShouldDisallowInterceptTouch(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void setShowProgressLine(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttAudioWaveView
 * JD-Core Version:    0.7.0.1
 */