package com.tencent.mobileqq.activity.aio.item;

import agkl;
import agkp;
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
import bcef;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;
import vjr;

public class PttAudioWaveView
  extends View
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = a(this.jdField_i_of_type_Int, 0.33F);
  private agkl jdField_a_of_type_Agkl;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private PorterDuff.Mode jdField_a_of_type_AndroidGraphicsPorterDuff$Mode = PorterDuff.Mode.SRC_IN;
  PorterDuffXfermode jdField_a_of_type_AndroidGraphicsPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Xfermode jdField_a_of_type_AndroidGraphicsXfermode;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  Runnable jdField_a_of_type_JavaLangRunnable = new PttAudioWaveView.1(this);
  boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[0];
  private int[] jdField_a_of_type_ArrayOfInt;
  float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  Canvas jdField_b_of_type_AndroidGraphicsCanvas;
  boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float;
  int jdField_d_of_type_Int;
  public boolean d;
  private float jdField_e_of_type_Float;
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
  private int s;
  private int t;
  private int u;
  private int v;
  
  public PttAudioWaveView(Context paramContext)
  {
    super(paramContext);
    this.jdField_d_of_type_Boolean = false;
    c();
  }
  
  public PttAudioWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_d_of_type_Boolean = false;
    c();
  }
  
  public PttAudioWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_d_of_type_Boolean = false;
    c();
  }
  
  public static float a(int paramInt1, int paramInt2, float paramFloat)
  {
    return (float)(1.0D - Math.pow(1.0F - paramInt1 / paramInt2, 2.0F * paramFloat));
  }
  
  public static int a(int paramInt, float paramFloat)
  {
    float f1 = (paramInt >> 16 & 0xFF) / 255.0F;
    float f2 = (paramInt >> 8 & 0xFF) / 255.0F;
    float f3 = (paramInt & 0xFF) / 255.0F;
    paramInt = (int)((paramInt >> 24 & 0xFF) / 255.0F * paramFloat * 255.0F + 0.5F);
    return (int)(f1 * 255.0F + 0.5F) << 16 | paramInt << 24 | (int)(f2 * 255.0F + 0.5F) << 8 | (int)(f3 * 255.0F + 0.5F);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      paramBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    }
    int i1;
    int i2;
    Bitmap localBitmap;
    do
    {
      do
      {
        return paramBitmap;
        i1 = paramBitmap.getWidth();
        i2 = paramBitmap.getHeight();
      } while ((i1 == paramInt1) && (i2 == paramInt2));
      localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      paramBitmap = localBitmap;
    } while (!QLog.isColorLevel());
    QLog.d("PttAudioWaveView", 2, "initBitmap change width =" + paramInt1 + " height=" + paramInt2 + " oldBitmapWidth =" + i1 + " oldBitmpHeight=" + i2);
    return localBitmap;
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Float = ((paramFloat - paramInt1) / (paramInt2 - paramInt1));
  }
  
  private void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.r);
    if (this.jdField_d_of_type_Float > this.s) {
      this.jdField_d_of_type_Float = this.s;
    }
    if (this.jdField_d_of_type_Float < this.t) {
      this.jdField_d_of_type_Float = this.t;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      float f1 = this.jdField_d_of_type_Float;
      float f2 = this.jdField_d_of_type_Float;
      float f3 = getMeasuredHeight();
      int i1 = this.jdField_a_of_type_Int;
      int i2 = this.jdField_i_of_type_Int;
      int i3 = this.jdField_a_of_type_Int;
      Object localObject = Shader.TileMode.CLAMP;
      localObject = new LinearGradient(f1, 0.0F, f2, f3, new int[] { i1, i2, i3 }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject);
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader((Shader)localObject);
      paramCanvas.drawLine(this.jdField_d_of_type_Float, 0.0F, this.jdField_d_of_type_Float, getMeasuredHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if ((paramView != null) && (paramView.isPressed() != paramBoolean) && ((agkp)paramView.getTag() != null))
    {
      ChatMessage localChatMessage = AIOUtils.getMessage(paramView);
      if ((localChatMessage != null) && (localChatMessage.vipBubbleID == 0L)) {
        paramView.setPressed(paramBoolean);
      }
    }
    super.setPressed(paramBoolean);
  }
  
  public static int[] a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt < 100)
    {
      int[] arrayOfInt2 = new int[paramInt];
      i1 = 0;
      for (;;)
      {
        arrayOfInt1 = arrayOfInt2;
        if (i1 >= paramInt) {
          break;
        }
        arrayOfInt2[i1] = ((int)(paramArrayOfInt[i1] * 0.02480583F));
        if (arrayOfInt2[i1] > 255) {
          arrayOfInt2[i1] = 255;
        }
        i1 += 1;
      }
    }
    int[] arrayOfInt1 = new int[100];
    float f3 = paramInt / 100.0F;
    long l1 = 0L;
    int i2 = 0;
    int i3 = 0;
    int i1 = 0;
    float f2;
    for (float f1 = f3; i2 < paramInt; f1 = f2)
    {
      long l2 = l1 + paramArrayOfInt[i2];
      int i5 = i1 + 1;
      int i4 = i3;
      i1 = i5;
      l1 = l2;
      f2 = f1;
      if (i2 > f1)
      {
        arrayOfInt1[i3] = ((int)((float)l2 / i5 * 0.02480583F));
        if (arrayOfInt1[i3] > 255) {
          arrayOfInt1[i3] = 255;
        }
        i4 = i3 + 1;
        f2 = f3 * (i4 + 1);
        i1 = 0;
        l1 = 0L;
      }
      i2 += 1;
      i3 = i4;
    }
    return arrayOfInt1;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_i_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.j);
    this.k = (ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2);
    this.jdField_a_of_type_AndroidGraphicsXfermode = new PorterDuffXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode);
    this.l = AIOUtils.dp2px(3.0F, getResources());
    this.o = this.l;
    this.q = (AIOUtils.dp2px(3.0F, getResources()) - 1);
    this.r = AIOUtils.dp2px(1.0F, getResources());
    this.u = AIOUtils.dp2px(174.0F, getResources());
    this.v = AIOUtils.dp2px(5.0F, getResources());
  }
  
  private void d()
  {
    int i1 = 0;
    if ((this.jdField_b_of_type_AndroidGraphicsCanvas == null) || (this.jdField_a_of_type_AndroidGraphicsPaint == null) || (this.jdField_a_of_type_ArrayOfFloat.length <= 0) || (!this.jdField_g_of_type_Boolean)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PttAudioWaveView", 2, "drawBitMapDesWave mSelectColor=" + Integer.toHexString(this.jdField_i_of_type_Int) + "bitmpt" + this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight() + " " + this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth() + " len" + this.jdField_a_of_type_ArrayOfFloat.length + " this=" + this);
      }
      this.jdField_g_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_i_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode);
      this.jdField_b_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      while (i1 < this.jdField_a_of_type_ArrayOfFloat.length)
      {
        a(i1, this.jdField_h_of_type_Int - this.jdField_a_of_type_ArrayOfFloat[i1] / 2.0F, this.jdField_h_of_type_Int + this.jdField_a_of_type_ArrayOfFloat[i1] / 2.0F);
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
    float f1 = this.jdField_e_of_type_Float * this.jdField_a_of_type_ArrayOfFloat.length;
    paramFloat /= f1;
    return (f1 - (this.jdField_e_of_type_Float - this.q)) * paramFloat;
  }
  
  public void a()
  {
    this.jdField_i_of_type_Boolean = true;
    int i2 = this.jdField_a_of_type_ArrayOfInt.length;
    this.jdField_a_of_type_ArrayOfFloat = new float[this.jdField_a_of_type_ArrayOfInt.length];
    int i3 = this.m;
    int i4 = this.n;
    int i1 = 0;
    float f1;
    float f2;
    if (i1 < this.jdField_a_of_type_ArrayOfFloat.length)
    {
      f1 = a(this.jdField_a_of_type_ArrayOfInt[i1], 255, this.jdField_f_of_type_Float);
      if (f1 > 0.9D) {
        f2 = this.l;
      }
      for (f1 = f1 * (this.n - this.l) + f2 + (float)Math.sin(6.28D / (i2 % 4 + 3) * i1) * (i3 - i4);; f1 = f1 * (this.m - this.l) + f2)
      {
        if (f1 > this.o) {
          this.o = ((int)f1);
        }
        this.jdField_a_of_type_ArrayOfFloat[i1] = f1;
        i1 += 1;
        break;
        f2 = this.l;
      }
    }
    i1 = 1;
    while (i1 < this.jdField_a_of_type_ArrayOfFloat.length - 1)
    {
      f1 = this.jdField_a_of_type_ArrayOfFloat[(i1 - 1)];
      f2 = this.jdField_a_of_type_ArrayOfFloat[(i1 + 1)];
      if (f1 * 0.5D > this.jdField_a_of_type_ArrayOfFloat[i1]) {
        this.jdField_a_of_type_ArrayOfFloat[i1] = ((f1 + this.jdField_a_of_type_ArrayOfFloat[i1]) / 2.0F);
      }
      if (f2 * 0.5D > this.jdField_a_of_type_ArrayOfFloat[i1]) {
        this.jdField_a_of_type_ArrayOfFloat[i1] = ((f2 + this.jdField_a_of_type_ArrayOfFloat[i1]) / 2.0F);
      }
      i1 += 1;
    }
  }
  
  protected void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    int i1 = this.jdField_a_of_type_ArrayOfFloat.length;
    float f2 = (getMeasuredWidth() - this.j - this.jdField_b_of_type_Int - this.jdField_d_of_type_Int) / i1;
    float f1 = f2;
    if (f2 > this.v) {
      f1 = this.v;
    }
    this.jdField_e_of_type_Float = f1;
    i1 = (int)(f1 * paramInt) + this.j + this.jdField_b_of_type_Int;
    int i2 = i1 + this.q;
    this.jdField_a_of_type_AndroidGraphicsRectF.set(i1, paramFloat1, i2, paramFloat2);
    this.jdField_b_of_type_AndroidGraphicsCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (paramInt == this.jdField_a_of_type_ArrayOfFloat.length - 1) {
      this.s = i2;
    }
    if (paramInt == 0) {
      this.t = i1;
    }
    paramInt = (int)(this.q / 2.0F);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(i1, paramFloat1 - paramInt + 1.0F, i2, paramInt + paramFloat1 + 1.0F);
    this.jdField_b_of_type_AndroidGraphicsCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 180.0F, 180.0F, true, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(i1, paramFloat2 - paramInt - 1.0F, i2, paramInt + paramFloat2 - 1.0F);
    this.jdField_b_of_type_AndroidGraphicsCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 180.0F, -180.0F, true, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttAudioWaveView", 2, "destory");
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) || (this.jdField_b_of_type_AndroidGraphicsBitmap == null) || (this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())) {
      return;
    }
    d();
    int i1;
    if ((this.jdField_d_of_type_Float > 0.0F) || (this.jdField_d_of_type_Boolean))
    {
      i1 = paramCanvas.saveLayer(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight(), null, 31);
      this.jdField_h_of_type_Boolean = true;
    }
    for (;;)
    {
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
      if (!this.jdField_h_of_type_Boolean) {
        break;
      }
      paramCanvas.restoreToCount(i1);
      this.jdField_h_of_type_Boolean = false;
      return;
      paramCanvas.save();
      i1 = 0;
    }
    paramCanvas.restore();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (QLog.isColorLevel()) {
      QLog.d("PttAudioWaveView", 2, "onLayout changed=" + paramBoolean + " left=" + paramInt1 + " top=" + paramInt2 + " right=" + paramInt3 + " bottom=" + paramInt4 + " hasDataConvert=" + this.jdField_i_of_type_Boolean);
    }
    if ((getMeasuredWidth() <= 0) || (getMeasuredHeight() <= 0)) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      this.jdField_b_of_type_Int = getPaddingLeft();
      this.jdField_c_of_type_Int = getPaddingTop();
      this.jdField_d_of_type_Int = getPaddingRight();
      this.jdField_e_of_type_Int = getPaddingBottom();
      this.jdField_g_of_type_Int = ((this.jdField_g_of_type_Int + getMeasuredWidth() / 2) / 2 - getMeasuredWidth() / 2);
      if (this.jdField_g_of_type_Int < 0) {
        this.jdField_g_of_type_Int = 0;
      }
      this.jdField_h_of_type_Int = (getMeasuredHeight() / 2);
      this.m = (getMeasuredHeight() - AIOUtils.dp2px(this.jdField_f_of_type_Int, getResources()) * 2);
      if (this.m < AIOUtils.dp2px(12.0F, getResources())) {
        this.m = AIOUtils.dp2px(12.0F, getResources());
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.u + this.jdField_b_of_type_Int + this.jdField_d_of_type_Int, getMeasuredHeight() + this.jdField_c_of_type_Int + this.jdField_e_of_type_Int);
      this.jdField_b_of_type_AndroidGraphicsBitmap = a(this.jdField_b_of_type_AndroidGraphicsBitmap, this.u + this.jdField_b_of_type_Int + this.jdField_d_of_type_Int, getMeasuredHeight() + this.jdField_c_of_type_Int + this.jdField_e_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_b_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_b_of_type_AndroidGraphicsBitmap);
      this.jdField_g_of_type_Boolean = true;
      this.p = (this.jdField_h_of_type_Int + this.m / 2);
      this.n = ((int)(this.m * 0.8D));
    } while (this.jdField_i_of_type_Boolean);
    a();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
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
    }
    do
    {
      do
      {
        do
        {
          try
          {
            a((View)getParent().getParent().getParent(), true);
            getHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
            bool1 = true;
            return bool1;
          }
          catch (Exception paramMotionEvent)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PttAudioWaveView", 2, "onTouchEvent ACTION_DOWN error:" + paramMotionEvent.toString());
              }
            }
          }
          if (paramMotionEvent.getAction() == 2)
          {
            float f1 = Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float);
            float f2 = Math.abs(paramMotionEvent.getY() - this.jdField_b_of_type_Float);
            if ((f1 > this.k) || (f2 > this.k))
            {
              if (this.jdField_c_of_type_Boolean)
              {
                this.jdField_d_of_type_Float = paramMotionEvent.getX();
                invalidate();
                a(paramMotionEvent.getX(), this.t, this.s);
                if ((this.jdField_a_of_type_Agkl != null) && (!this.jdField_d_of_type_Boolean))
                {
                  this.jdField_d_of_type_Boolean = true;
                  this.jdField_a_of_type_Agkl.a(this);
                }
              }
              getHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
              this.jdField_b_of_type_Boolean = true;
            }
            return true;
          }
          if (paramMotionEvent.getAction() != 1) {
            break;
          }
          getHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_d_of_type_Boolean = false;
          try
          {
            a((View)getParent().getParent().getParent(), false);
            if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
            {
              if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
                this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this);
              }
              return true;
            }
          }
          catch (Exception paramMotionEvent)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PttAudioWaveView", 2, "ACTION_UP error:" + paramMotionEvent.toString());
              }
            }
            bool1 = bool2;
          }
        } while (this.jdField_a_of_type_Boolean);
        bool1 = bool2;
      } while (!this.jdField_c_of_type_Boolean);
      if (this.jdField_a_of_type_Agkl != null)
      {
        this.jdField_a_of_type_Agkl.a(this, this.jdField_c_of_type_Float);
        bcef.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 3, 0, "", "", "", "");
      }
      return true;
      boolean bool1 = bool2;
    } while (paramMotionEvent.getAction() != 3);
    getHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_d_of_type_Boolean = false;
    return false;
  }
  
  public void setAudioData(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    this.jdField_i_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("PttAudioWaveView", 2, "setAudioData mCenterHeight=" + this.jdField_h_of_type_Int + " data.length" + this.jdField_a_of_type_ArrayOfFloat.length);
    }
    int i2 = paramInt1 / AIOUtils.dp2px(5.0F, getResources());
    int i1 = i2;
    if (i2 > 34) {
      i1 = 34;
    }
    if (i1 < 3) {}
    for (i2 = 3;; i2 = i1)
    {
      if (paramArrayOfInt == null)
      {
        this.jdField_a_of_type_ArrayOfInt = new int[i2];
        paramArrayOfInt = new Random(System.currentTimeMillis());
        paramInt1 = 0;
        while (paramInt1 < i2)
        {
          this.jdField_a_of_type_ArrayOfInt[paramInt1] = paramArrayOfInt.nextInt(255);
          paramInt1 += 1;
        }
      }
      int[] arrayOfInt = new int[i2];
      float f2 = paramArrayOfInt.length / i2;
      i1 = 0;
      long l1 = 0L;
      int i4 = 0;
      int i7 = 0;
      int i6 = 0;
      int i5 = 255;
      int i3 = 0;
      float f1 = f2;
      int i8;
      if (i3 < paramArrayOfInt.length)
      {
        l1 += paramArrayOfInt[i3];
        i8 = i1 + 1;
        if ((i3 < f1) && (i3 != paramArrayOfInt.length - 1)) {
          break label512;
        }
        i1 = i4 + 1;
        arrayOfInt[i4] = ((int)(l1 / i8));
        i7 += arrayOfInt[(i1 - 1)];
        i6 = Math.max(i6, arrayOfInt[(i1 - 1)]);
        i5 = Math.min(i5, arrayOfInt[(i1 - 1)]);
        f1 = f2 * (i1 + 1);
        l1 = 0L;
        i8 = 0;
        i4 = i1;
      }
      label512:
      for (i1 = i8;; i1 = i8)
      {
        i3 += 1;
        break;
        this.jdField_a_of_type_ArrayOfInt = arrayOfInt;
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
          paramArrayOfInt.put("waveMax", String.valueOf(i6));
          paramArrayOfInt.put("waveMin", String.valueOf(i5));
          paramArrayOfInt.put("waveAvg", String.valueOf(i7 / i2));
          paramArrayOfInt.put("waveVar", String.valueOf(Math.sqrt(vjr.a(arrayOfInt))));
          if (QLog.isColorLevel()) {
            QLog.d("PttAudioWaveView", 2, "real do report");
          }
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "PttWaveInfo", true, 0L, 0L, paramArrayOfInt, "");
        }
        return;
      }
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
  
  public void setSeekListener(agkl paramagkl)
  {
    this.jdField_a_of_type_Agkl = paramagkl;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttAudioWaveView
 * JD-Core Version:    0.7.0.1
 */