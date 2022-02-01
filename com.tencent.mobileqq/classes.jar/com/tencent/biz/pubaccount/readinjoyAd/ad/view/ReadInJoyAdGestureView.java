package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import ois;
import org.json.JSONObject;
import skq;
import swi;
import ufs;
import ufy;
import uks;
import uvp;

public class ReadInJoyAdGestureView
  extends RelativeLayout
{
  static Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = -1;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Paint jdField_a_of_type_AndroidGraphicsPaint = null;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  JumpMode jdField_a_of_type_ComTencentBizPubaccountNativeAdReportJumpMode = JumpMode.FAIL;
  private VideoAdInfo jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
  ReadInJoyAdGestureView.LongPressRunnable jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView$LongPressRunnable = new ReadInJoyAdGestureView.LongPressRunnable(this);
  Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyAdGestureView.1(this);
  String jdField_a_of_type_JavaLangString;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private ufs jdField_a_of_type_Ufs;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  Paint jdField_b_of_type_AndroidGraphicsPaint = null;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float = -1.0F;
  Paint jdField_c_of_type_AndroidGraphicsPaint = null;
  boolean jdField_c_of_type_Boolean = false;
  float jdField_d_of_type_Float = -1.0F;
  Paint jdField_d_of_type_AndroidGraphicsPaint = null;
  boolean jdField_d_of_type_Boolean = false;
  float jdField_e_of_type_Float = -1.0F;
  boolean jdField_e_of_type_Boolean = true;
  float jdField_f_of_type_Float = -1.0F;
  private boolean jdField_f_of_type_Boolean;
  float jdField_g_of_type_Float = -1.0F;
  private boolean jdField_g_of_type_Boolean = true;
  float h = -1.0F;
  float i = -1.0F;
  float j = -1.0F;
  float k;
  float l;
  float m = -15.0F;
  
  public ReadInJoyAdGestureView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ReadInJoyAdGestureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    a();
  }
  
  public ReadInJoyAdGestureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private long a(ufs paramufs)
  {
    if ((paramufs != null) && (paramufs.jdField_c_of_type_Long > 0L)) {
      return paramufs.jdField_c_of_type_Long;
    }
    return 500L;
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    if (BaseApplicationImpl.getContext() == null) {
      return;
    }
    int n = ViewUtils.getScreenWidth();
    int i1 = ViewUtils.getScreenHeight();
    if ((i1 == 0) || (n == 0)) {
      QLog.e("ReadInJoyAdGestureView", 2, "initStartPostionXY get Screen width and high error screenHigh:" + i1 + " screenWidth:" + n);
    }
    float f3 = (float)(n * 1.0D / i1);
    float f2 = n;
    float f1 = i1;
    if (f3 >= 0.5625F) {
      f2 = i1 * 0.5625F;
    }
    for (;;)
    {
      this.jdField_g_of_type_Float = (f2 * paramFloat1 + n / 2);
      this.h = (f1 * paramFloat2 + i1 / 2 - AIOUtils.dp2px(58.0F, BaseApplicationImpl.getContext().getResources()));
      return;
      f1 = n / 0.5625F;
    }
  }
  
  private void a(ufs paramufs, MotionEvent paramMotionEvent)
  {
    if ((paramufs == null) || (paramMotionEvent == null)) {}
    do
    {
      return;
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 1: 
        this.jdField_a_of_type_AndroidGraphicsPath.reset();
        this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
        return;
      case 2: 
        this.jdField_g_of_type_Boolean = false;
        this.jdField_a_of_type_Boolean = true;
        this.k = this.jdField_a_of_type_Float;
        this.l = this.jdField_b_of_type_Float;
        postDelayed(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView$LongPressRunnable, a(paramufs));
        invalidate();
        return;
      }
    } while ((this.jdField_a_of_type_Float < this.jdField_g_of_type_Float) || (this.jdField_a_of_type_Float > this.jdField_g_of_type_Float + this.jdField_e_of_type_Float) || (this.jdField_b_of_type_Float < this.h) || (this.jdField_b_of_type_Float > this.h + this.jdField_f_of_type_Float));
    this.jdField_b_of_type_Boolean = true;
  }
  
  private int[] a(float paramFloat1, float paramFloat2)
  {
    int n = -1;
    int[] arrayOfInt = new int[2];
    int[] tmp9_7 = arrayOfInt;
    tmp9_7[0] = -1;
    int[] tmp13_9 = tmp9_7;
    tmp13_9[1] = -1;
    tmp13_9;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return arrayOfInt;
    }
    int i1;
    if ((paramFloat1 - this.jdField_e_of_type_Float / 2.0F > 0.0F) && (this.jdField_e_of_type_Float / 2.0F + paramFloat1 < getWidth()) && (paramFloat2 - this.jdField_f_of_type_Float / 2.0F > 0.0F) && (this.jdField_f_of_type_Float / 2.0F + paramFloat2 < getHeight()))
    {
      i1 = (int)paramFloat1;
      n = (int)paramFloat2;
    }
    for (;;)
    {
      arrayOfInt[0] = i1;
      arrayOfInt[1] = n;
      return arrayOfInt;
      if ((this.jdField_e_of_type_Float / 2.0F + paramFloat1 >= getWidth()) && (paramFloat2 - this.jdField_f_of_type_Float / 2.0F > 0.0F) && (this.jdField_f_of_type_Float / 2.0F + paramFloat2 < getHeight()))
      {
        i1 = (int)(getWidth() - this.jdField_e_of_type_Float / 2.0F);
        n = (int)paramFloat2;
      }
      else if ((paramFloat1 - this.jdField_e_of_type_Float / 2.0F < 0.0F) && (paramFloat2 - this.jdField_f_of_type_Float / 2.0F > 0.0F) && (this.jdField_f_of_type_Float / 2.0F + paramFloat2 < getHeight()))
      {
        i1 = (int)(this.jdField_e_of_type_Float / 2.0F);
        n = (int)paramFloat2;
      }
      else if ((this.jdField_f_of_type_Float / 2.0F + paramFloat2 >= getHeight()) && (paramFloat1 - this.jdField_e_of_type_Float / 2.0F > 0.0F) && (this.jdField_e_of_type_Float / 2.0F + paramFloat1 < getWidth()))
      {
        i1 = (int)paramFloat1;
        n = (int)(getHeight() - this.jdField_f_of_type_Float / 2.0F);
      }
      else if ((paramFloat2 - this.jdField_f_of_type_Float / 2.0F <= 0.0F) && (paramFloat1 - this.jdField_e_of_type_Float / 2.0F > 0.0F) && (this.jdField_e_of_type_Float / 2.0F + paramFloat1 < getWidth()))
      {
        i1 = (int)paramFloat1;
        n = (int)(this.jdField_f_of_type_Float / 2.0F);
      }
      else if ((paramFloat1 - this.jdField_e_of_type_Float / 2.0F <= 0.0F) && (paramFloat2 - this.jdField_f_of_type_Float / 2.0F <= 0.0F))
      {
        i1 = (int)(this.jdField_e_of_type_Float / 2.0F);
        n = (int)this.jdField_f_of_type_Float / 2;
      }
      else if ((paramFloat1 - this.jdField_e_of_type_Float / 2.0F <= 0.0F) && (this.jdField_f_of_type_Float / 2.0F + paramFloat2 >= getHeight()))
      {
        i1 = (int)this.jdField_e_of_type_Float / 2;
        n = (int)(getHeight() - this.jdField_f_of_type_Float / 2.0F);
      }
      else if ((this.jdField_e_of_type_Float / 2.0F + paramFloat1 >= getWidth()) && (paramFloat2 - this.jdField_f_of_type_Float / 2.0F <= 0.0F))
      {
        i1 = (int)(getWidth() - this.jdField_e_of_type_Float / 2.0F);
        n = (int)(this.jdField_f_of_type_Float / 2.0F);
      }
      else if ((this.jdField_e_of_type_Float / 2.0F + paramFloat1 >= getWidth()) && (this.jdField_f_of_type_Float / 2.0F + paramFloat2 >= getHeight()))
      {
        i1 = (int)(getWidth() - this.jdField_e_of_type_Float / 2.0F);
        n = (int)(getHeight() - this.jdField_f_of_type_Float / 2.0F);
      }
      else
      {
        i1 = -1;
      }
    }
  }
  
  private void b(ufs paramufs, MotionEvent paramMotionEvent)
  {
    if ((paramufs == null) || (paramMotionEvent == null)) {}
    do
    {
      float f1;
      float f2;
      do
      {
        float f3;
        float f4;
        do
        {
          return;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          f3 = this.jdField_a_of_type_Float;
          f4 = this.jdField_b_of_type_Float;
          f5 = Math.abs(f1 - f3);
          f6 = Math.abs(f2 - f4);
          if (((this.jdField_a_of_type_Int == 1) && ((f5 >= paramufs.jdField_b_of_type_Int) || (f6 >= paramufs.jdField_b_of_type_Int))) || ((this.jdField_a_of_type_Int == 2) && ((f5 >= 40.0F) || (f6 >= 40.0F))) || ((this.jdField_a_of_type_Int == 3) && ((f5 >= 40.0F) || (f6 >= 40.0F)))) {
            this.jdField_f_of_type_Boolean = true;
          }
          switch (this.jdField_a_of_type_Int)
          {
          default: 
            return;
          }
        } while (!this.jdField_f_of_type_Boolean);
        float f5 = (f1 + f3) / 2.0F;
        float f6 = (f2 + f4) / 2.0F;
        this.jdField_a_of_type_AndroidGraphicsPath.quadTo(f3, f4, f5, f6);
        invalidate();
        this.jdField_a_of_type_Float = f1;
        this.jdField_b_of_type_Float = f2;
        return;
        invalidate();
        return;
      } while (!this.jdField_b_of_type_Boolean);
      paramufs = a(f1, f2);
      this.i = paramufs[0];
      this.j = paramufs[1];
    } while ((this.i == -1.0F) || (this.j == -1.0F));
    invalidate();
  }
  
  private void c(ufs paramufs, MotionEvent paramMotionEvent)
  {
    if ((paramufs == null) || (paramMotionEvent == null)) {}
    do
    {
      do
      {
        return;
        invalidate();
        switch (this.jdField_a_of_type_Int)
        {
        default: 
          return;
        case 1: 
          this.jdField_a_of_type_AndroidGraphicsPath.reset();
        }
      } while (!this.jdField_f_of_type_Boolean);
      c();
      this.jdField_f_of_type_Boolean = false;
      return;
      this.jdField_g_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = false;
      return;
    } while ((!this.jdField_b_of_type_Boolean) || (!this.jdField_f_of_type_Boolean));
    c();
    this.jdField_b_of_type_Boolean = false;
    this.i = -1.0F;
    this.j = -1.0F;
    this.jdField_g_of_type_Float = -1.0F;
    this.h = -1.0F;
  }
  
  private void d()
  {
    try
    {
      switch (this.jdField_a_of_type_Int)
      {
      case 1: 
        if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
          this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(AIOUtils.dp2px(9.0F, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources()));
        }
        if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_AndroidGraphicsPaint == null)) {
          return;
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor(this.jdField_b_of_type_JavaLangString));
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_c_of_type_AndroidGraphicsPaint != null) && (this.jdField_d_of_type_AndroidGraphicsPaint != null))
    {
      this.jdField_c_of_type_AndroidGraphicsPaint.setColor(Color.parseColor(this.jdField_b_of_type_JavaLangString));
      this.jdField_d_of_type_AndroidGraphicsPaint.setColor(Color.parseColor(this.jdField_b_of_type_JavaLangString));
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(18.0F);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint.setAlpha(153);
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_d_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_d_of_type_AndroidGraphicsPaint.setAlpha(51);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth(24.0F);
  }
  
  public void a(ufs paramufs)
  {
    if ((paramufs == null) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return;
    }
    this.jdField_a_of_type_Int = paramufs.jdField_a_of_type_Int;
    this.jdField_c_of_type_Float = ((float)paramufs.jdField_c_of_type_Double);
    this.jdField_d_of_type_Float = ((float)paramufs.d);
    this.jdField_e_of_type_Float = AIOUtils.dp2px((float)paramufs.jdField_b_of_type_Double, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources());
    this.jdField_f_of_type_Float = AIOUtils.dp2px((float)paramufs.jdField_a_of_type_Double, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources());
    a(this.jdField_c_of_type_Float, this.jdField_d_of_type_Float);
    this.i = a(this.jdField_g_of_type_Float + this.jdField_e_of_type_Float / 2.0F, this.h + this.jdField_f_of_type_Float / 2.0F)[0];
    this.j = a(this.jdField_g_of_type_Float + this.jdField_e_of_type_Float / 2.0F, this.h + this.jdField_f_of_type_Float / 2.0F)[1];
    this.jdField_a_of_type_JavaLangString = paramufs.jdField_b_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramufs.jdField_c_of_type_JavaLangString;
    paramufs = paramufs.jdField_a_of_type_JavaLangString;
    d();
    ThreadManager.getSubThreadHandler().post(new ReadInJoyAdGestureView.2(this, paramufs));
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!this.jdField_d_of_type_Boolean) && (paramBoolean) && (jdField_a_of_type_AndroidOsHandler != null))
    {
      jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
    if ((!paramBoolean) && (jdField_a_of_type_AndroidOsHandler != null)) {
      jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportJumpMode != JumpMode.FAIL;
  }
  
  public void b()
  {
    invalidate();
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportJumpMode = JumpMode.FAIL;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    switch (this.jdField_a_of_type_Int)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      return;
      this.jdField_a_of_type_Boolean = false;
      removeCallbacks(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView$LongPressRunnable);
      return;
      this.jdField_b_of_type_Boolean = false;
      a(this.jdField_c_of_type_Float, this.jdField_d_of_type_Float);
    } while (jdField_a_of_type_AndroidOsHandler == null);
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportJumpMode = uvp.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ois.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo), null, 3, false, null);
      ois.a(new ufy().a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(1).b(10).a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportJumpMode).a(ois.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)).e(uks.a(1, this.jdField_a_of_type_Int)).a());
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      requestDisallowInterceptTouchEvent(true);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    switch (this.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_AndroidGraphicsPath == null) || (this.jdField_a_of_type_AndroidGraphicsPaint == null) || (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportJumpMode != JumpMode.FAIL));
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
      } while ((this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportJumpMode != JumpMode.FAIL) || (!this.jdField_a_of_type_Boolean));
      paramCanvas.drawCircle(this.k, this.l, 60.0F, this.jdField_c_of_type_AndroidGraphicsPaint);
      paramCanvas.drawArc(new RectF(this.k - 72.0F, this.l - 72.0F, this.k + 72.0F, this.l + 72.0F), 0.0F, 360.0F, false, this.jdField_d_of_type_AndroidGraphicsPaint);
      return;
    } while ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportJumpMode != JumpMode.FAIL));
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_f_of_type_Boolean))
    {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, new Rect(0, 0, (int)this.jdField_e_of_type_Float, (int)this.jdField_f_of_type_Float), new Rect((int)(this.i - this.jdField_e_of_type_Float / 2.0F), (int)(this.j - this.jdField_f_of_type_Float / 2.0F), (int)(this.i + this.jdField_e_of_type_Float / 2.0F), (int)(this.j + this.jdField_f_of_type_Float / 2.0F)), this.jdField_b_of_type_AndroidGraphicsPaint);
      return;
    }
    paramCanvas.save();
    paramCanvas.rotate(this.m, this.jdField_g_of_type_Float + this.jdField_e_of_type_Float / 2.0F, this.h + this.jdField_f_of_type_Float / 2.0F);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_g_of_type_Float, this.h, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      a(this.jdField_a_of_type_Ufs, paramMotionEvent);
      continue;
      b(this.jdField_a_of_type_Ufs, paramMotionEvent);
      continue;
      c(this.jdField_a_of_type_Ufs, paramMotionEvent);
    }
  }
  
  public void setGestureAdInfo(swi paramswi, Context paramContext)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    }
    if ((!this.jdField_c_of_type_Boolean) && (paramswi != null) && (paramswi.a != null) && (paramswi.a.a != null) && (paramswi.a.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null)) {
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = paramswi.a.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) {
          return;
        }
        paramswi = new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.v);
        if (paramswi != null)
        {
          this.jdField_a_of_type_Ufs = ufs.a(paramswi.optJSONObject("GesturesAd_info"));
          a(this.jdField_a_of_type_Ufs);
        }
        this.jdField_c_of_type_Boolean = true;
        invalidate();
        return;
      }
      catch (Exception paramswi)
      {
        paramswi.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdGestureView
 * JD-Core Version:    0.7.0.1
 */