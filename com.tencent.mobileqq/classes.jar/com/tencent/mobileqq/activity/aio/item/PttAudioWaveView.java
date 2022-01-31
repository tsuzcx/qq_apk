package com.tencent.mobileqq.activity.aio.item;

import actn;
import adwq;
import adwu;
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
import axqw;
import axrl;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import srh;

public class PttAudioWaveView
  extends View
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int;
  private adwq jdField_a_of_type_Adwq;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private PorterDuff.Mode jdField_a_of_type_AndroidGraphicsPorterDuff$Mode = PorterDuff.Mode.SRC_IN;
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
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float;
  int jdField_d_of_type_Int;
  public boolean d;
  private float jdField_e_of_type_Float;
  int jdField_e_of_type_Int = 15;
  boolean jdField_e_of_type_Boolean = true;
  private float jdField_f_of_type_Float = 1.5F;
  private int jdField_f_of_type_Int;
  boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = -1;
  private volatile boolean jdField_g_of_type_Boolean = true;
  private int h = -1;
  private int i = 1;
  private int j;
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
  
  private void a(float paramFloat, int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Float = ((paramFloat - paramInt1) / (paramInt2 - paramInt1));
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if ((paramView != null) && (paramView.isPressed() != paramBoolean) && ((adwu)paramView.getTag() != null))
    {
      ChatMessage localChatMessage = actn.a(paramView);
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
      arrayOfInt = new int[paramInt];
      i1 = 0;
      while (i1 < paramInt)
      {
        arrayOfInt[i1] = ((int)(paramArrayOfInt[i1] * 0.02480583F));
        if (arrayOfInt[i1] > 255) {
          arrayOfInt[i1] = 255;
        }
        i1 += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PttAudioWaveView", 2, new Object[] { "sample1：", Arrays.toString(arrayOfInt) });
      }
      return arrayOfInt;
    }
    int[] arrayOfInt = new int[100];
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
        arrayOfInt[i3] = ((int)((float)l2 / i5 * 0.02480583F));
        if (arrayOfInt[i3] > 255) {
          arrayOfInt[i3] = 255;
        }
        i4 = i3 + 1;
        f2 = f3 * (i4 + 1);
        i1 = 0;
        l1 = 0L;
      }
      i2 += 1;
      i3 = i4;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PttAudioWaveView", 2, new Object[] { "sample1：", Arrays.toString(arrayOfInt) });
    }
    return arrayOfInt;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.h);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.h);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.i);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.i);
    this.j = (ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2);
    this.jdField_a_of_type_AndroidGraphicsXfermode = new PorterDuffXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode);
    this.k = actn.a(3.0F, getResources());
    this.n = this.k;
    this.p = (actn.a(3.0F, getResources()) - 1);
    this.q = actn.a(1.0F, getResources());
    this.t = actn.a(174.0F, getResources());
  }
  
  public float a(float paramFloat)
  {
    float f1 = this.jdField_e_of_type_Float * this.jdField_a_of_type_ArrayOfFloat.length;
    paramFloat /= f1;
    return (f1 - (this.jdField_e_of_type_Float - this.p)) * paramFloat;
  }
  
  public void a()
  {
    this.jdField_g_of_type_Boolean = true;
    int i2 = this.jdField_a_of_type_ArrayOfInt.length;
    this.jdField_a_of_type_ArrayOfFloat = new float[this.jdField_a_of_type_ArrayOfInt.length];
    int i3 = this.l;
    int i4 = this.m;
    int i1 = 0;
    float f1;
    float f2;
    if (i1 < this.jdField_a_of_type_ArrayOfFloat.length)
    {
      f1 = a(this.jdField_a_of_type_ArrayOfInt[i1], 255, this.jdField_f_of_type_Float);
      if (f1 > 0.9D) {
        f2 = this.k;
      }
      for (f1 = f1 * (this.m - this.k) + f2 + (float)Math.sin(6.28D / (i2 % 4 + 3) * i1) * (i3 - i4);; f1 = f1 * (this.l - this.k) + f2)
      {
        if (f1 > this.n) {
          this.n = ((int)f1);
        }
        this.jdField_a_of_type_ArrayOfFloat[i1] = f1;
        i1 += 1;
        break;
        f2 = this.k;
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
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.h);
    int i1 = this.jdField_a_of_type_ArrayOfFloat.length;
    float f2 = (getMeasuredWidth() - this.i - this.jdField_a_of_type_Int - this.jdField_c_of_type_Int) / i1;
    float f1 = f2;
    if (f2 > actn.a(5.0F, getResources())) {
      f1 = actn.a(5.0F, getResources());
    }
    this.jdField_e_of_type_Float = f1;
    i1 = (int)(f1 * paramInt) + this.i + this.jdField_a_of_type_Int;
    RectF localRectF = new RectF(i1, paramFloat1, this.p + i1, paramFloat2);
    this.jdField_b_of_type_AndroidGraphicsCanvas.drawRect(localRectF, this.jdField_b_of_type_AndroidGraphicsPaint);
    if (paramInt == this.jdField_a_of_type_ArrayOfFloat.length - 1) {
      this.r = (this.p + i1);
    }
    if (paramInt == 0) {
      this.s = i1;
    }
    paramInt = (int)(this.p / 2.0F);
    localRectF = new RectF(i1, paramFloat1 - paramInt + 1.0F, this.p + i1, paramInt + paramFloat1 + 1.0F);
    this.jdField_b_of_type_AndroidGraphicsCanvas.drawArc(localRectF, 180.0F, 180.0F, true, this.jdField_b_of_type_AndroidGraphicsPaint);
    localRectF = new RectF(i1, paramFloat2 - paramInt, this.p + i1, paramInt + paramFloat2);
    this.jdField_b_of_type_AndroidGraphicsCanvas.drawArc(localRectF, 180.0F, -180.0F, true, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  public void b()
  {
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
    this.jdField_a_of_type_Int = getPaddingLeft();
    this.jdField_b_of_type_Int = getPaddingTop();
    this.jdField_c_of_type_Int = getPaddingRight();
    this.jdField_d_of_type_Int = getPaddingBottom();
    if (QLog.isColorLevel()) {
      QLog.d("PttAudioWaveView", 2, "mCenterHeight =" + this.jdField_g_of_type_Int + " hasDataConvert=" + this.jdField_g_of_type_Boolean + " mheight=" + getMeasuredHeight() + "  mWidth=" + getMeasuredWidth());
    }
    if (this.jdField_g_of_type_Int < 0)
    {
      this.jdField_f_of_type_Int = ((this.jdField_f_of_type_Int + getMeasuredWidth() / 2) / 2 - getMeasuredWidth() / 2);
      if (this.jdField_f_of_type_Int < 0) {
        this.jdField_f_of_type_Int = 0;
      }
      this.jdField_g_of_type_Int = (getMeasuredHeight() / 2);
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.t + this.jdField_a_of_type_Int + this.jdField_c_of_type_Int, getMeasuredHeight() + this.jdField_b_of_type_Int + this.jdField_d_of_type_Int, Bitmap.Config.ARGB_8888);
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.t + this.jdField_a_of_type_Int + this.jdField_c_of_type_Int, getMeasuredHeight() + this.jdField_b_of_type_Int + this.jdField_d_of_type_Int, Bitmap.Config.ARGB_8888);
      this.l = (getMeasuredHeight() - actn.a(this.jdField_e_of_type_Int, getResources()) * 2);
      if (this.l < actn.a(12.0F, getResources())) {
        this.l = actn.a(12.0F, getResources());
      }
      this.m = ((int)(this.l * 0.8D));
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_b_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_b_of_type_AndroidGraphicsBitmap);
      this.o = (this.jdField_g_of_type_Int + this.l / 2);
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) || (this.jdField_b_of_type_AndroidGraphicsBitmap == null) || (this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())) {
      return;
    }
    if (!this.jdField_g_of_type_Boolean) {
      a();
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.h);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.h);
    int i2 = paramCanvas.saveLayer(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight(), null, 31);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_b_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_ArrayOfFloat.length)
    {
      a(i1, this.jdField_g_of_type_Int - this.jdField_a_of_type_ArrayOfFloat[i1] / 2.0F, this.jdField_g_of_type_Int + this.jdField_a_of_type_ArrayOfFloat[i1] / 2.0F);
      i1 += 1;
    }
    Object localObject;
    if (this.jdField_d_of_type_Float > 0.0F)
    {
      localObject = new RectF();
      ((RectF)localObject).set(0.0F, 0.0F, this.jdField_d_of_type_Float, getMeasuredHeight());
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawRect((RectF)localObject, this.jdField_b_of_type_AndroidGraphicsPaint);
      localObject = new RectF();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(75);
      ((RectF)localObject).set(this.jdField_d_of_type_Float, 0.0F, getMeasuredWidth(), getMeasuredHeight());
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawRect((RectF)localObject, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    for (;;)
    {
      paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_b_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsXfermode);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      if ((this.jdField_d_of_type_Float > 0.0F) || (this.jdField_d_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.q);
        if (this.jdField_d_of_type_Float > this.r) {
          this.jdField_d_of_type_Float = this.r;
        }
        if (this.jdField_d_of_type_Float < this.s) {
          this.jdField_d_of_type_Float = this.s;
        }
        if (this.jdField_e_of_type_Boolean)
        {
          i1 = a(this.h, 0.33F);
          float f1 = this.jdField_d_of_type_Float;
          float f2 = this.jdField_d_of_type_Float;
          float f3 = getMeasuredHeight();
          int i3 = this.h;
          localObject = Shader.TileMode.CLAMP;
          localObject = new LinearGradient(f1, 0.0F, f2, f3, new int[] { i1, i3, i1 }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject);
          this.jdField_a_of_type_AndroidGraphicsPaint.setShader((Shader)localObject);
          paramCanvas.drawLine(this.jdField_d_of_type_Float, 0.0F, this.jdField_d_of_type_Float, getMeasuredHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
          this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
        }
      }
      paramCanvas.restoreToCount(i2);
      return;
      if (!this.jdField_c_of_type_Boolean)
      {
        localObject = new RectF();
        ((RectF)localObject).set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawRect((RectF)localObject, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
      else
      {
        localObject = new RectF();
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(75);
        ((RectF)localObject).set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawRect((RectF)localObject, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
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
            if ((f1 > this.j) || (f2 > this.j))
            {
              if (this.jdField_c_of_type_Boolean)
              {
                this.jdField_d_of_type_Float = paramMotionEvent.getX();
                invalidate();
                a(paramMotionEvent.getX(), this.s, this.r);
                if ((this.jdField_a_of_type_Adwq != null) && (!this.jdField_d_of_type_Boolean))
                {
                  this.jdField_d_of_type_Boolean = true;
                  this.jdField_a_of_type_Adwq.a(this);
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
      if (this.jdField_a_of_type_Adwq != null)
      {
        this.jdField_a_of_type_Adwq.a(this, this.jdField_c_of_type_Float);
        axqw.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 3, 0, "", "", "", "");
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
    this.jdField_g_of_type_Boolean = false;
    int i2 = paramInt1 / actn.a(5.0F, getResources());
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
          break label438;
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
      label438:
      for (i1 = i8;; i1 = i8)
      {
        i3 += 1;
        break;
        this.jdField_a_of_type_ArrayOfInt = arrayOfInt;
        if (new Random().nextInt(1000) == 520)
        {
          paramArrayOfInt = new HashMap();
          paramArrayOfInt.put("voiceLength", String.valueOf(paramInt2));
          paramArrayOfInt.put("waveWidth", String.valueOf(paramInt1));
          paramArrayOfInt.put("waveNum", String.valueOf(i2));
          paramArrayOfInt.put("waveMax", String.valueOf(i6));
          paramArrayOfInt.put("waveMin", String.valueOf(i5));
          paramArrayOfInt.put("waveAvg", String.valueOf(i7 / i2));
          paramArrayOfInt.put("waveVar", String.valueOf(Math.sqrt(srh.a(arrayOfInt))));
          if (QLog.isColorLevel()) {
            QLog.d("PttAudioWaveView", 2, "real do report");
          }
          axrl.a(BaseApplication.getContext()).a("", "PttWaveInfo", true, 0L, 0L, paramArrayOfInt, "");
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
    this.jdField_e_of_type_Int = paramInt;
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
    this.jdField_c_of_type_Float = a(paramFloat);
    this.jdField_d_of_type_Float = (this.r * this.jdField_c_of_type_Float);
    invalidate();
  }
  
  public void setProgressColor(int paramInt)
  {
    int i1 = 0;
    if (paramInt != this.h)
    {
      this.h = paramInt;
      i1 = 1;
    }
    if (i1 != 0) {
      invalidate();
    }
  }
  
  public void setSeekListener(adwq paramadwq)
  {
    this.jdField_a_of_type_Adwq = paramadwq;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttAudioWaveView
 * JD-Core Version:    0.7.0.1
 */