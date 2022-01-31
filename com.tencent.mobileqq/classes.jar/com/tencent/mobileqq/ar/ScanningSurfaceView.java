package com.tencent.mobileqq.ar;

import aaeb;
import aaec;
import aaed;
import aaee;
import aaef;
import aaeg;
import aaeh;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.olympic.activity.ARTipsManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ScanningSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private float jdField_a_of_type_Float = 1.0F;
  private long jdField_a_of_type_Long = 50L;
  BlurMaskFilter jdField_a_of_type_AndroidGraphicsBlurMaskFilter;
  Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  SweepGradient jdField_a_of_type_AndroidGraphicsSweepGradient;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new aaeb(this);
  public FaceUIController a;
  private ScanningData jdField_a_of_type_ComTencentMobileqqArScanningData;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new aaed(this);
  private List jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  volatile boolean jdField_a_of_type_Boolean = false;
  float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 0.5F };
  int[] jdField_a_of_type_ArrayOfInt = { Color.argb(255, 30, 255, 236), Color.argb(255, 0, 191, 255) };
  private Handler jdField_b_of_type_AndroidOsHandler;
  private HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  private CopyOnWriteArrayList jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public ScanningSurfaceView(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public ScanningSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  public ScanningSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 >= paramFloat1) {
      return paramFloat2 - paramFloat1;
    }
    return 360.0F + paramFloat2 - paramFloat1;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    if (paramBitmap == null) {
      return null;
    }
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramFloat1 / f1, paramFloat2 / f2);
    int i = (int)f1;
    int j = (int)f2;
    try
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      for (;;)
      {
        QLog.e("ScanningSurfaceView", 1, "zoomImage got an OutOfMemoryError.", paramBitmap);
        paramBitmap = null;
      }
    }
  }
  
  private ScanningData a()
  {
    int i = 0;
    ScanningData localScanningData1;
    if (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
    {
      localScanningData1 = (ScanningData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
      if ((localScanningData1 == null) || (!localScanningData1.jdField_a_of_type_Boolean) || (!localScanningData1.jdField_f_of_type_Boolean) || (localScanningData1.jdField_e_of_type_Boolean)) {}
    }
    for (;;)
    {
      if ((localScanningData1 == null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            ScanningData localScanningData2 = (ScanningData)((Map.Entry)localIterator.next()).getValue();
            if ((localScanningData2 != null) && (localScanningData2.jdField_a_of_type_Boolean) && (localScanningData2.jdField_f_of_type_Boolean) && (!localScanningData2.jdField_e_of_type_Boolean))
            {
              return localScanningData2;
              i += 1;
              break;
            }
          }
        }
      }
      return localScanningData1;
      localScanningData1 = null;
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    ScanningData localScanningData1;
    int m;
    int j;
    if (paramCanvas != null)
    {
      localScanningData1 = a();
      m = 0;
      j = 1;
      if (m >= this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()) {
        break label5794;
      }
      localScanningData2 = (ScanningData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(m);
      if (localScanningData2 != null) {
        break label48;
      }
    }
    label48:
    label336:
    label371:
    label3707:
    label3839:
    while ((j == 0) || (this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.a.a() == 0))
    {
      ScanningData localScanningData2;
      return;
      Object localObject;
      if (!localScanningData2.jdField_h_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new aaee(this, localScanningData2, localScanningData1));
        if ((localScanningData2.jdField_a_of_type_Boolean) && (!localScanningData2.jdField_b_of_type_Boolean) && (localScanningData2.jdField_g_of_type_Boolean) && (!localScanningData2.jdField_e_of_type_Boolean) && (!TextUtils.isEmpty(localScanningData2.jdField_d_of_type_JavaLangString)) && (!this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(localScanningData2.jdField_d_of_type_JavaLangString)))
        {
          localObject = localScanningData2.jdField_d_of_type_JavaLangString;
          String str = localScanningData2.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aaef(this, (String)localObject, str), 4000L);
        }
      }
      localScanningData2.jdField_a_of_type_AndroidGraphicsPaint.setColor(localScanningData2.jdField_e_of_type_Int);
      localScanningData2.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(localScanningData2.jdField_i_of_type_Float);
      float f1;
      float f5;
      float f2;
      float f3;
      float f4;
      float f6;
      float f7;
      if (((localScanningData2.jdField_a_of_type_Boolean) || (localScanningData2.jdField_c_of_type_Boolean)) && (localScanningData2.jdField_f_of_type_Boolean) && (!localScanningData2.jdField_e_of_type_Boolean))
      {
        localScanningData2.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(localScanningData2.v * 255.0F));
        f1 = localScanningData2.jdField_f_of_type_Float * localScanningData2.jdField_g_of_type_Float + localScanningData2.jdField_i_of_type_Float;
        localObject = new RectF(localScanningData2.jdField_a_of_type_Float - f1, localScanningData2.jdField_b_of_type_Float - f1, localScanningData2.jdField_a_of_type_Float + f1, f1 + localScanningData2.jdField_b_of_type_Float);
        if ((localScanningData2.jdField_e_of_type_Int != -1) && (localScanningData2.jdField_a_of_type_Boolean) && (!localScanningData2.jdField_e_of_type_Boolean)) {
          break label3619;
        }
        localScanningData2.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
        if (localScanningData2.aA == 0.0F) {
          break label3707;
        }
        this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter = new BlurMaskFilter(localScanningData2.aB * localScanningData2.aA, BlurMaskFilter.Blur.SOLID);
        if (this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter == null) {
          break label3715;
        }
        localScanningData2.jdField_a_of_type_AndroidGraphicsPaint.setMaskFilter(this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter);
        localScanningData2.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
        f1 = localScanningData2.jdField_j_of_type_Float;
        paramCanvas.drawArc((RectF)localObject, localScanningData2.jdField_h_of_type_Float + f1, a(localScanningData2.jdField_j_of_type_Float + localScanningData2.jdField_h_of_type_Float, localScanningData2.jdField_k_of_type_Float + localScanningData2.jdField_h_of_type_Float), false, localScanningData2.jdField_a_of_type_AndroidGraphicsPaint);
        if ((localScanningData2.jdField_e_of_type_Int != -1) && (localScanningData2.jdField_a_of_type_Boolean) && (!localScanningData2.jdField_e_of_type_Boolean)) {
          break label3728;
        }
        localScanningData2.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
        if (this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter == null) {
          break label3839;
        }
        localScanningData2.jdField_a_of_type_AndroidGraphicsPaint.setMaskFilter(this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter);
        localScanningData2.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
        f1 = localScanningData2.jdField_l_of_type_Float;
        paramCanvas.drawArc((RectF)localObject, localScanningData2.jdField_h_of_type_Float + f1, a(localScanningData2.jdField_l_of_type_Float + localScanningData2.jdField_h_of_type_Float, localScanningData2.m + localScanningData2.jdField_h_of_type_Float), false, localScanningData2.jdField_a_of_type_AndroidGraphicsPaint);
        if ((localScanningData2.u > 0.0F) && ((localScanningData2.jdField_a_of_type_Boolean) || (localScanningData2.jdField_c_of_type_Boolean)) && (localScanningData2.jdField_f_of_type_Boolean) && (!localScanningData2.jdField_e_of_type_Boolean))
        {
          f5 = localScanningData2.jdField_i_of_type_Float;
          localScanningData2.jdField_q_of_type_Float = ((float)((localScanningData2.jdField_f_of_type_Float * localScanningData2.jdField_g_of_type_Float + f5) * Math.cos((localScanningData2.o + localScanningData2.jdField_h_of_type_Float) * 3.141592653589793D / 180.0D) + localScanningData2.jdField_a_of_type_Float));
          localScanningData2.jdField_r_of_type_Float = ((float)((localScanningData2.jdField_f_of_type_Float * localScanningData2.jdField_g_of_type_Float + f5) * Math.sin((localScanningData2.o + localScanningData2.jdField_h_of_type_Float) * 3.141592653589793D / 180.0D) + localScanningData2.jdField_b_of_type_Float));
          f2 = localScanningData2.p + localScanningData2.jdField_h_of_type_Float;
          f3 = f2 + 120.0F;
          f4 = 120.0F + f3;
          f1 = f2;
          if (f2 >= 360.0F) {
            f1 = f2 - 360.0F;
          }
          f2 = f3;
          if (f3 >= 360.0F) {
            f2 = f3 - 360.0F;
          }
          f3 = f4;
          if (f4 >= 360.0F) {
            f3 = f4 - 360.0F;
          }
          f4 = (float)(localScanningData2.jdField_n_of_type_Float * localScanningData2.jdField_g_of_type_Float * Math.cos(f1 * 3.141592653589793D / 180.0D) + localScanningData2.jdField_q_of_type_Float);
          f1 = (float)(localScanningData2.jdField_n_of_type_Float * localScanningData2.jdField_g_of_type_Float * Math.sin(f1 * 3.141592653589793D / 180.0D) + localScanningData2.jdField_r_of_type_Float);
          f6 = (float)(localScanningData2.jdField_n_of_type_Float * localScanningData2.jdField_g_of_type_Float * Math.cos(f2 * 3.141592653589793D / 180.0D) + localScanningData2.jdField_q_of_type_Float);
          f2 = (float)(localScanningData2.jdField_n_of_type_Float * localScanningData2.jdField_g_of_type_Float * Math.sin(f2 * 3.141592653589793D / 180.0D) + localScanningData2.jdField_r_of_type_Float);
          f7 = (float)(localScanningData2.jdField_n_of_type_Float * localScanningData2.jdField_g_of_type_Float * Math.cos(f3 * 3.141592653589793D / 180.0D) + localScanningData2.jdField_q_of_type_Float);
          f3 = (float)(localScanningData2.jdField_n_of_type_Float * localScanningData2.jdField_g_of_type_Float * Math.sin(f3 * 3.141592653589793D / 180.0D) + localScanningData2.jdField_r_of_type_Float);
          localObject = new Path();
          ((Path)localObject).moveTo(f4, f1);
          ((Path)localObject).lineTo(f6, f2);
          ((Path)localObject).lineTo(f7, f3);
          ((Path)localObject).close();
          localScanningData2.jdField_b_of_type_AndroidGraphicsPaint.setColor(localScanningData2.jdField_c_of_type_Int);
          localScanningData2.jdField_b_of_type_AndroidGraphicsPaint.setAlpha((int)(localScanningData2.u * 255.0F));
          paramCanvas.drawPath((Path)localObject, localScanningData2.jdField_b_of_type_AndroidGraphicsPaint);
          localScanningData2.jdField_s_of_type_Float = ((float)((localScanningData2.jdField_f_of_type_Float * localScanningData2.jdField_g_of_type_Float + f5) * Math.cos((localScanningData2.p + localScanningData2.jdField_h_of_type_Float) * 3.141592653589793D / 180.0D) + localScanningData2.jdField_a_of_type_Float));
          localScanningData2.t = ((float)((localScanningData2.jdField_f_of_type_Float * localScanningData2.jdField_g_of_type_Float + f5) * Math.sin((localScanningData2.p + localScanningData2.jdField_h_of_type_Float) * 3.141592653589793D / 180.0D) + localScanningData2.jdField_b_of_type_Float));
          f2 = localScanningData2.o + localScanningData2.jdField_h_of_type_Float;
          f3 = f2 + 120.0F;
          f4 = 120.0F + f3;
          f1 = f2;
          if (f2 >= 360.0F) {
            f1 = f2 - 360.0F;
          }
          f2 = f3;
          if (f3 >= 360.0F) {
            f2 = f3 - 360.0F;
          }
          f3 = f4;
          if (f4 >= 360.0F) {
            f3 = f4 - 360.0F;
          }
          f4 = (float)(localScanningData2.jdField_n_of_type_Float * localScanningData2.jdField_g_of_type_Float * Math.cos(f1 * 3.141592653589793D / 180.0D) + localScanningData2.jdField_s_of_type_Float);
          f1 = (float)(localScanningData2.jdField_n_of_type_Float * localScanningData2.jdField_g_of_type_Float * Math.sin(f1 * 3.141592653589793D / 180.0D) + localScanningData2.t);
          f5 = (float)(localScanningData2.jdField_n_of_type_Float * localScanningData2.jdField_g_of_type_Float * Math.cos(f2 * 3.141592653589793D / 180.0D) + localScanningData2.jdField_s_of_type_Float);
          f2 = (float)(localScanningData2.jdField_n_of_type_Float * localScanningData2.jdField_g_of_type_Float * Math.sin(f2 * 3.141592653589793D / 180.0D) + localScanningData2.t);
          f6 = (float)(localScanningData2.jdField_n_of_type_Float * localScanningData2.jdField_g_of_type_Float * Math.cos(f3 * 3.141592653589793D / 180.0D) + localScanningData2.jdField_s_of_type_Float);
          f3 = (float)(localScanningData2.jdField_n_of_type_Float * localScanningData2.jdField_g_of_type_Float * Math.sin(f3 * 3.141592653589793D / 180.0D) + localScanningData2.t);
          ((Path)localObject).reset();
          ((Path)localObject).moveTo(f4, f1);
          ((Path)localObject).lineTo(f5, f2);
          ((Path)localObject).lineTo(f6, f3);
          ((Path)localObject).close();
          localScanningData2.jdField_b_of_type_AndroidGraphicsPaint.setColor(localScanningData2.jdField_d_of_type_Int);
          localScanningData2.jdField_b_of_type_AndroidGraphicsPaint.setAlpha((int)(localScanningData2.u * 255.0F));
          paramCanvas.drawPath((Path)localObject, localScanningData2.jdField_b_of_type_AndroidGraphicsPaint);
        }
        if ((localScanningData2.J > 0.0F) && ((localScanningData2.jdField_a_of_type_Boolean) || (localScanningData2.jdField_c_of_type_Boolean)) && (localScanningData2.jdField_f_of_type_Boolean) && (!localScanningData2.jdField_e_of_type_Boolean))
        {
          localScanningData2.jdField_c_of_type_AndroidGraphicsPaint.setColor(localScanningData2.jdField_g_of_type_Int);
          localScanningData2.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(localScanningData2.E);
          localScanningData2.jdField_c_of_type_AndroidGraphicsPaint.setAlpha((int)(localScanningData2.J * 255.0F * 0.4D));
          f1 = localScanningData2.B * localScanningData2.C + localScanningData2.E;
          localObject = new RectF(localScanningData2.jdField_a_of_type_Float - f1, localScanningData2.jdField_b_of_type_Float - f1, localScanningData2.jdField_a_of_type_Float + f1, f1 + localScanningData2.jdField_b_of_type_Float);
          f1 = localScanningData2.F;
          paramCanvas.drawArc((RectF)localObject, localScanningData2.D + f1, a(localScanningData2.F + localScanningData2.D, localScanningData2.G + localScanningData2.D), false, localScanningData2.jdField_c_of_type_AndroidGraphicsPaint);
          f1 = localScanningData2.H;
          paramCanvas.drawArc((RectF)localObject, localScanningData2.D + f1, a(localScanningData2.H + localScanningData2.D, localScanningData2.I + localScanningData2.D), false, localScanningData2.jdField_c_of_type_AndroidGraphicsPaint);
        }
        localScanningData2.jdField_d_of_type_AndroidGraphicsPaint.setColor(localScanningData2.jdField_h_of_type_Int);
        localScanningData2.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth(localScanningData2.P);
        localScanningData2.jdField_d_of_type_AndroidGraphicsPaint.setAlpha((int)(localScanningData2.W * 255.0F * 0.3D));
        f1 = localScanningData2.L * localScanningData2.M + localScanningData2.P;
        localObject = new RectF(localScanningData2.jdField_a_of_type_Float - f1, localScanningData2.jdField_b_of_type_Float - f1, localScanningData2.jdField_a_of_type_Float + f1, f1 + localScanningData2.jdField_b_of_type_Float);
        f1 = localScanningData2.Q;
        paramCanvas.drawArc((RectF)localObject, localScanningData2.N + f1, a(localScanningData2.Q + localScanningData2.N, localScanningData2.R + localScanningData2.N), false, localScanningData2.jdField_d_of_type_AndroidGraphicsPaint);
        f1 = localScanningData2.U;
        paramCanvas.drawArc((RectF)localObject, localScanningData2.N + f1, a(localScanningData2.U + localScanningData2.N, localScanningData2.V + localScanningData2.N), false, localScanningData2.jdField_d_of_type_AndroidGraphicsPaint);
        f1 = localScanningData2.S;
        paramCanvas.drawArc((RectF)localObject, localScanningData2.N + f1, a(localScanningData2.S + localScanningData2.N, localScanningData2.T + localScanningData2.N), false, localScanningData2.jdField_d_of_type_AndroidGraphicsPaint);
        if ((localScanningData2.af > 0.0F) && ((localScanningData2.jdField_a_of_type_Boolean) || (localScanningData2.jdField_c_of_type_Boolean)) && (localScanningData2.jdField_f_of_type_Boolean) && (!localScanningData2.jdField_e_of_type_Boolean))
        {
          localScanningData2.jdField_e_of_type_AndroidGraphicsPaint.setColor(localScanningData2.jdField_i_of_type_Int);
          localScanningData2.jdField_e_of_type_AndroidGraphicsPaint.setStrokeWidth(localScanningData2.Y);
          localScanningData2.jdField_e_of_type_AndroidGraphicsPaint.setAlpha((int)(localScanningData2.af * 255.0F));
          f1 = localScanningData2.Z;
          paramCanvas.drawArc((RectF)localObject, localScanningData2.N + f1, a(localScanningData2.Z + localScanningData2.N, localScanningData2.aa + localScanningData2.N), false, localScanningData2.jdField_e_of_type_AndroidGraphicsPaint);
          f1 = localScanningData2.ad;
          paramCanvas.drawArc((RectF)localObject, localScanningData2.N + f1, a(localScanningData2.ad + localScanningData2.N, localScanningData2.ae + localScanningData2.N), false, localScanningData2.jdField_e_of_type_AndroidGraphicsPaint);
          f1 = localScanningData2.ab;
          paramCanvas.drawArc((RectF)localObject, localScanningData2.N + f1, a(localScanningData2.ab + localScanningData2.N, localScanningData2.ac + localScanningData2.N), false, localScanningData2.jdField_e_of_type_AndroidGraphicsPaint);
        }
        if ((localScanningData2.aj > 0.0F) && ((localScanningData2.jdField_a_of_type_Boolean) || (localScanningData2.jdField_c_of_type_Boolean)) && (localScanningData2.jdField_f_of_type_Boolean) && (!localScanningData2.jdField_e_of_type_Boolean))
        {
          localScanningData2.jdField_f_of_type_AndroidGraphicsPaint.setColor(localScanningData2.jdField_j_of_type_Int);
          localScanningData2.jdField_f_of_type_AndroidGraphicsPaint.setStrokeWidth(localScanningData2.ai);
          localScanningData2.jdField_f_of_type_AndroidGraphicsPaint.setAlpha((int)(localScanningData2.aj * 255.0F * 0.1D));
          f1 = localScanningData2.ai / 2.0F;
          paramCanvas.drawCircle(localScanningData2.jdField_a_of_type_Float, localScanningData2.jdField_b_of_type_Float, f1 + localScanningData2.ag * localScanningData2.ah, localScanningData2.jdField_f_of_type_AndroidGraphicsPaint);
        }
        if ((localScanningData2.aw > 0.0F) && ((localScanningData2.jdField_a_of_type_Boolean) || (localScanningData2.jdField_c_of_type_Boolean)) && (localScanningData2.jdField_f_of_type_Boolean) && (!localScanningData2.jdField_e_of_type_Boolean))
        {
          localScanningData2.jdField_g_of_type_AndroidGraphicsPaint.setColor(localScanningData2.jdField_k_of_type_Int);
          localScanningData2.jdField_g_of_type_AndroidGraphicsPaint.setStrokeWidth(localScanningData2.an);
          localScanningData2.jdField_g_of_type_AndroidGraphicsPaint.setAlpha((int)(localScanningData2.aw * 255.0F * 0.3D));
          f1 = localScanningData2.am * localScanningData2.ak + localScanningData2.an;
          localObject = new RectF(localScanningData2.jdField_a_of_type_Float - f1, localScanningData2.jdField_b_of_type_Float - f1, localScanningData2.jdField_a_of_type_Float + f1, f1 + localScanningData2.jdField_b_of_type_Float);
          f1 = localScanningData2.aq;
          paramCanvas.drawArc((RectF)localObject, localScanningData2.al + f1, a(localScanningData2.aq + localScanningData2.al, localScanningData2.ar + localScanningData2.al), false, localScanningData2.jdField_g_of_type_AndroidGraphicsPaint);
          f1 = localScanningData2.ao;
          paramCanvas.drawArc((RectF)localObject, localScanningData2.al + f1, a(localScanningData2.ao + localScanningData2.al, localScanningData2.ap + localScanningData2.al), false, localScanningData2.jdField_g_of_type_AndroidGraphicsPaint);
          f1 = localScanningData2.au;
          paramCanvas.drawArc((RectF)localObject, localScanningData2.al + f1, a(localScanningData2.au + localScanningData2.al, localScanningData2.av + localScanningData2.al), false, localScanningData2.jdField_g_of_type_AndroidGraphicsPaint);
          f1 = localScanningData2.as;
          paramCanvas.drawArc((RectF)localObject, localScanningData2.al + f1, a(localScanningData2.as + localScanningData2.al, localScanningData2.at + localScanningData2.al), false, localScanningData2.jdField_g_of_type_AndroidGraphicsPaint);
        }
        if ((localScanningData2.az > 0.0F) && ((localScanningData2.jdField_a_of_type_Boolean) || (localScanningData2.jdField_c_of_type_Boolean)) && (localScanningData2.jdField_f_of_type_Boolean) && (!localScanningData2.jdField_e_of_type_Boolean))
        {
          localScanningData2.jdField_h_of_type_AndroidGraphicsPaint.setColor(localScanningData2.jdField_l_of_type_Int);
          localScanningData2.jdField_h_of_type_AndroidGraphicsPaint.setAlpha((int)(localScanningData2.az * 255.0F));
          paramCanvas.drawCircle(localScanningData2.jdField_a_of_type_Float, localScanningData2.jdField_b_of_type_Float, 0.0F + localScanningData2.ay * localScanningData2.ax, localScanningData2.jdField_h_of_type_AndroidGraphicsPaint);
        }
        if ((!localScanningData2.jdField_f_of_type_Boolean) || (localScanningData2.aV <= 0.0F) || (localScanningData2.jdField_e_of_type_Boolean)) {
          break label4630;
        }
        localScanningData2.jdField_j_of_type_AndroidGraphicsPaint.setAlpha((int)(localScanningData2.aV * 255.0F));
        localScanningData2.jdField_j_of_type_AndroidGraphicsPaint.setStrokeWidth(localScanningData2.aI);
        localScanningData2.jdField_i_of_type_AndroidGraphicsPaint.setStrokeWidth(localScanningData2.aH);
        localScanningData2.jdField_i_of_type_AndroidGraphicsPaint.setAlpha((int)(localScanningData2.aV * 255.0F));
        if ((!localScanningData2.jdField_a_of_type_Boolean) || (localScanningData2.C == 0.0F)) {
          break label3852;
        }
        localScanningData2.aC = ((localScanningData2.B * localScanningData2.C + localScanningData2.E) * 2.0F / 3.6F);
        if (localScanningData2.aC > localScanningData2.aD) {
          localScanningData2.aC = localScanningData2.aD;
        }
        if (localScanningData2.aC < localScanningData2.aE) {
          localScanningData2.aC = localScanningData2.aE;
        }
        localScanningData2.aF = (localScanningData2.jdField_a_of_type_Float - localScanningData2.jdField_f_of_type_Float * localScanningData2.jdField_g_of_type_Float - localScanningData2.jdField_i_of_type_Float - localScanningData2.aS);
        localScanningData2.aG = (localScanningData2.jdField_b_of_type_Float - localScanningData2.jdField_f_of_type_Float * localScanningData2.jdField_g_of_type_Float - localScanningData2.jdField_i_of_type_Float - localScanningData2.aT * localScanningData2.bg);
        if ((!localScanningData2.jdField_a_of_type_Boolean) || (!localScanningData2.jdField_f_of_type_Boolean) || (localScanningData2.C == 0.0F)) {
          break label3883;
        }
        localScanningData2.aF = (localScanningData2.jdField_a_of_type_Float - localScanningData2.jdField_f_of_type_Float * localScanningData2.jdField_g_of_type_Float - localScanningData2.jdField_i_of_type_Float - localScanningData2.aS - ScanningData.Dip2PxCache.jdField_e_of_type_Int);
        localScanningData2.x = (localScanningData2.aG - localScanningData2.aC);
        localScanningData2.z = (localScanningData2.jdField_b_of_type_Float + localScanningData2.B * localScanningData2.C + localScanningData2.E);
        localScanningData2.A = (localScanningData2.jdField_a_of_type_Float + localScanningData2.B * localScanningData2.C + localScanningData2.E);
        localScanningData2.y = localScanningData2.aF;
        f2 = localScanningData2.jdField_a_of_type_Float;
        f3 = localScanningData2.L;
        f4 = localScanningData2.ai;
        f5 = localScanningData2.bV;
        f6 = localScanningData2.bI;
        f7 = localScanningData2.bK;
        if ((TextUtils.isEmpty(localScanningData2.jdField_e_of_type_JavaLangString)) || (TextUtils.isEmpty(localScanningData2.jdField_f_of_type_JavaLangString))) {
          break label4630;
        }
        localScanningData2.jdField_f_of_type_JavaLangString = localScanningData2.jdField_f_of_type_JavaLangString.toUpperCase();
        localScanningData2.jdField_j_of_type_AndroidGraphicsPaint.setTextSize(localScanningData2.aO * localScanningData2.bg);
        localScanningData2.jdField_j_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
        if (localScanningData2.aV == 0.0F) {
          break label3968;
        }
        localScanningData2.jdField_j_of_type_AndroidGraphicsPaint.setShadowLayer(localScanningData2.aX, 0.0F, localScanningData2.aY, localScanningData2.jdField_n_of_type_Int);
      }
      float f8;
      float f9;
      float f10;
      float f11;
      for (;;)
      {
        localObject = localScanningData2.jdField_j_of_type_AndroidGraphicsPaint.getFontMetrics();
        f8 = localScanningData2.aG;
        f9 = ((Paint.FontMetrics)localObject).top;
        f1 = localScanningData2.aG;
        f1 = ((Paint.FontMetrics)localObject).ascent;
        f1 = localScanningData2.aG;
        f1 = ((Paint.FontMetrics)localObject).descent;
        f10 = localScanningData2.aG;
        f11 = ((Paint.FontMetrics)localObject).bottom;
        if (localScanningData2.aK != 0.0F) {
          break label3995;
        }
        float f12 = localScanningData2.y;
        f1 = localScanningData2.aJ;
        localScanningData2.jdField_a_of_type_AndroidTextTextPaint.setTextSize(localScanningData2.bg * f1);
        while (localScanningData2.jdField_a_of_type_AndroidTextTextPaint.measureText(localScanningData2.jdField_e_of_type_JavaLangString) > f2 + f3 + f4 + f5 - f6 - 4.0F * f7 - f12)
        {
          f1 -= 1.0F;
          localScanningData2.jdField_a_of_type_AndroidTextTextPaint.setTextSize(localScanningData2.bg * f1);
        }
        localScanningData2.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(localScanningData2.v * 255.0F * 0.5D));
        break;
        this.jdField_a_of_type_AndroidGraphicsSweepGradient = new SweepGradient(localScanningData2.jdField_a_of_type_Float, localScanningData2.jdField_b_of_type_Float, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat);
        this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(localScanningData2.jdField_j_of_type_Float + localScanningData2.jdField_h_of_type_Float - 5.0F, localScanningData2.jdField_a_of_type_Float, localScanningData2.jdField_b_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsSweepGradient.setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
        localScanningData2.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsSweepGradient);
        break label336;
        this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter = null;
        break label371;
        localScanningData2.jdField_a_of_type_AndroidGraphicsPaint.setMaskFilter(null);
        break label401;
        this.jdField_a_of_type_ArrayOfInt = new int[] { localScanningData2.jdField_b_of_type_Int, localScanningData2.jdField_a_of_type_Int };
        this.jdField_a_of_type_AndroidGraphicsSweepGradient = new SweepGradient(localScanningData2.jdField_a_of_type_Float, localScanningData2.jdField_b_of_type_Float, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat);
        this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(localScanningData2.jdField_l_of_type_Float + localScanningData2.jdField_h_of_type_Float - 5.0F, localScanningData2.jdField_a_of_type_Float, localScanningData2.jdField_b_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsSweepGradient.setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
        localScanningData2.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsSweepGradient);
        break label487;
        localScanningData2.jdField_a_of_type_AndroidGraphicsPaint.setMaskFilter(null);
        break label517;
        localScanningData2.aC = ((localScanningData2.jdField_f_of_type_Float * localScanningData2.jdField_g_of_type_Float + localScanningData2.jdField_i_of_type_Float) * 2.0F / 3.6F);
        break label3023;
        localScanningData2.x = (localScanningData2.aG - localScanningData2.aC);
        localScanningData2.z = (localScanningData2.jdField_b_of_type_Float + localScanningData2.jdField_f_of_type_Float * localScanningData2.jdField_g_of_type_Float + localScanningData2.jdField_i_of_type_Float);
        localScanningData2.A = (localScanningData2.jdField_a_of_type_Float + localScanningData2.jdField_f_of_type_Float * localScanningData2.jdField_g_of_type_Float + localScanningData2.jdField_i_of_type_Float);
        localScanningData2.y = localScanningData2.aF;
        break label3292;
        localScanningData2.jdField_j_of_type_AndroidGraphicsPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      }
      localScanningData2.aK = (f1 / localScanningData2.jdField_c_of_type_Float);
      localScanningData2.aJ = (localScanningData2.aK * localScanningData2.jdField_c_of_type_Float);
      if (localScanningData2.aJ > localScanningData2.aM) {
        localScanningData2.aJ = localScanningData2.aM;
      }
      if (localScanningData2.aJ < localScanningData2.aN) {
        localScanningData2.aJ = localScanningData2.aN;
      }
      if (localScanningData2.aO > localScanningData2.aQ) {
        localScanningData2.aO = localScanningData2.aQ;
      }
      if (localScanningData2.aO < localScanningData2.aR) {
        localScanningData2.aO = localScanningData2.aR;
      }
      localScanningData2.jdField_i_of_type_AndroidGraphicsPaint.setTextSize(localScanningData2.aJ * localScanningData2.bg);
      localScanningData2.jdField_i_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
      int k;
      int i;
      if (localScanningData2.jdField_a_of_type_Boolean)
      {
        localScanningData2.jdField_i_of_type_AndroidGraphicsPaint.setFakeBoldText(true);
        if (localScanningData2.aV == 0.0F) {
          break label5685;
        }
        localScanningData2.jdField_i_of_type_AndroidGraphicsPaint.setShadowLayer(localScanningData2.aX, 0.0F, localScanningData2.aY, localScanningData2.jdField_n_of_type_Int);
        paramCanvas.drawText(localScanningData2.jdField_f_of_type_JavaLangString, localScanningData2.aF, localScanningData2.aG, localScanningData2.jdField_j_of_type_AndroidGraphicsPaint);
        paramCanvas.drawText(localScanningData2.jdField_e_of_type_JavaLangString, localScanningData2.aF, localScanningData2.aG - localScanningData2.aU - (f11 + f10 - (f8 + f9)), localScanningData2.jdField_i_of_type_AndroidGraphicsPaint);
        localScanningData2.jdField_k_of_type_AndroidGraphicsPaint.setAlpha((int)(localScanningData2.bc * 255.0F));
        f1 = localScanningData2.aG + localScanningData2.aT * localScanningData2.bg;
        f2 = localScanningData2.aF + localScanningData2.bf;
        f3 = f1 + localScanningData2.bd * localScanningData2.bg;
        f4 = f2 + (float)(localScanningData2.be * localScanningData2.bg * Math.cos(localScanningData2.ba * 3.141592653589793D / 180.0D));
        f5 = f3 + (float)(localScanningData2.be * localScanningData2.bg * Math.sin(localScanningData2.ba * 3.141592653589793D / 180.0D));
        f6 = (float)(localScanningData2.be * localScanningData2.bg * 2.0F / 3.0F * Math.cos(localScanningData2.ba * 3.141592653589793D / 180.0D));
        f6 = (float)(localScanningData2.be * localScanningData2.bg * 2.0F / 3.0F * Math.sin(localScanningData2.ba * 3.141592653589793D / 180.0D));
        f6 = (float)(localScanningData2.be * localScanningData2.bg / 3.0F * Math.cos(localScanningData2.ba * 3.141592653589793D / 180.0D));
        f6 = (float)(localScanningData2.be * localScanningData2.bg / 3.0F * Math.sin(localScanningData2.ba * 3.141592653589793D / 180.0D));
        if (localScanningData2.bc >= 0.2D) {
          paramCanvas.drawLine(f4, f5, f2, f3, localScanningData2.jdField_k_of_type_AndroidGraphicsPaint);
        }
        if (localScanningData2.bc >= 0.5D) {
          paramCanvas.drawLine(f2, f3, f2, f1, localScanningData2.jdField_k_of_type_AndroidGraphicsPaint);
        }
        localScanningData2.jdField_l_of_type_AndroidGraphicsPaint.setAlpha((int)(localScanningData2.bc * 255.0F));
        paramCanvas.drawCircle(f4, f5, localScanningData2.bh, localScanningData2.jdField_l_of_type_AndroidGraphicsPaint);
        k = j;
        if (localScanningData2.bk <= 0.0F) {
          break label5760;
        }
        if (!localScanningData2.jdField_a_of_type_Boolean)
        {
          k = j;
          if (!localScanningData2.jdField_c_of_type_Boolean) {
            break label5760;
          }
        }
        k = j;
        if (localScanningData2.jdField_e_of_type_Boolean) {
          break label5760;
        }
        if (!localScanningData2.jdField_f_of_type_Boolean) {
          break label5706;
        }
        if ((TextUtils.isEmpty(localScanningData2.jdField_g_of_type_JavaLangString)) || (TextUtils.isEmpty(localScanningData2.jdField_h_of_type_JavaLangString))) {
          break label5700;
        }
        i = 1;
        k = j;
        if (i == 0) {
          break label5760;
        }
        i = 0;
        j = this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.a.a();
        if (!localScanningData2.jdField_f_of_type_Boolean) {
          break label5729;
        }
        k = i;
        if (j == 3) {
          break label5760;
        }
        this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.a.a(3, localScanningData2.jdField_g_of_type_JavaLangString, localScanningData2.jdField_h_of_type_JavaLangString, new aaeg(this, localScanningData2));
        i = 0;
        if ((localScanningData2.jdField_g_of_type_Boolean) && ((localScanningData2.jdField_a_of_type_Boolean) || (localScanningData2.jdField_c_of_type_Boolean)) && (localScanningData2.jdField_f_of_type_Boolean) && (!localScanningData2.jdField_e_of_type_Boolean) && (localScanningData2.bH > 0.0F))
        {
          localScanningData2.jdField_q_of_type_AndroidGraphicsPaint.setAlpha((int)(localScanningData2.bH * 255.0F));
          localObject = new RectF(localScanningData2.jdField_a_of_type_Float + localScanningData2.L + localScanningData2.ai + localScanningData2.bV - localScanningData2.bI - 4.0F * localScanningData2.bK, localScanningData2.jdField_b_of_type_Float - localScanningData2.L - localScanningData2.ai - localScanningData2.bW + 4.0F * localScanningData2.bK, localScanningData2.jdField_a_of_type_Float + localScanningData2.L + localScanningData2.ai + localScanningData2.bV - 4.0F * localScanningData2.bK, localScanningData2.jdField_b_of_type_Float - localScanningData2.L - localScanningData2.ai - localScanningData2.bW + localScanningData2.bI + 4.0F * localScanningData2.bK);
          localScanningData2.bX = ((RectF)localObject).left;
          localScanningData2.bY = ((RectF)localObject).right;
          localScanningData2.bZ = ((RectF)localObject).top;
          localScanningData2.ca = ((RectF)localObject).bottom;
          localScanningData2.bQ = ((RectF)localObject).centerX();
          localScanningData2.bR = ((RectF)localObject).centerY();
          if ((localScanningData2.jdField_b_of_type_AndroidGraphicsBitmap != null) && ((localScanningData2.bJ != localScanningData2.bI) || (localScanningData2.jdField_a_of_type_AndroidGraphicsBitmap == null)))
          {
            localScanningData2.bJ = localScanningData2.bI;
            localScanningData2.jdField_a_of_type_AndroidGraphicsBitmap = a(localScanningData2.jdField_b_of_type_AndroidGraphicsBitmap, localScanningData2.bI, localScanningData2.bI);
            if (localScanningData2.jdField_a_of_type_AndroidGraphicsBitmap != null) {
              localScanningData2.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a(localScanningData2.jdField_a_of_type_AndroidGraphicsBitmap, localScanningData2.bI / 2.0F, (int)localScanningData2.bI, (int)localScanningData2.bI);
            }
          }
          if (localScanningData2.jdField_a_of_type_AndroidGraphicsBitmap != null) {
            break label5767;
          }
          localScanningData2.jdField_q_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#e7e7e7"));
          localScanningData2.jdField_q_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
          paramCanvas.drawCircle(localScanningData2.bQ, localScanningData2.bR, localScanningData2.bI / 2.0F, localScanningData2.jdField_q_of_type_AndroidGraphicsPaint);
        }
      }
      for (;;)
      {
        localScanningData2.jdField_q_of_type_AndroidGraphicsPaint.setColor(-1);
        localScanningData2.jdField_q_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
        paramCanvas.drawCircle(localScanningData2.bQ, localScanningData2.bR, localScanningData2.bI / 2.0F, localScanningData2.jdField_q_of_type_AndroidGraphicsPaint);
        localScanningData2.jdField_s_of_type_AndroidGraphicsPaint.setAlpha((int)(localScanningData2.bT * 255.0F * 0.5D));
        paramCanvas.drawCircle(localScanningData2.bQ, localScanningData2.bR, localScanningData2.bP * localScanningData2.bU, localScanningData2.jdField_s_of_type_AndroidGraphicsPaint);
        localScanningData2.jdField_r_of_type_AndroidGraphicsPaint.setAlpha((int)(localScanningData2.bH * 255.0F));
        localScanningData2.bN = ((float)(localScanningData2.bP * 1.2D * Math.cos(localScanningData2.bM * 3.141592653589793D / 180.0D) + localScanningData2.bQ));
        localScanningData2.bO = ((float)(localScanningData2.bP * 1.2D * Math.sin(localScanningData2.bM * 3.141592653589793D / 180.0D) + localScanningData2.bR));
        f1 = (float)(localScanningData2.bL * Math.cos(0.0F * 3.141592653589793D / 180.0D) + localScanningData2.bN);
        f2 = (float)(localScanningData2.bL * Math.sin(0.0F * 3.141592653589793D / 180.0D) + localScanningData2.bO);
        f3 = (float)(localScanningData2.bL * Math.cos(120.0F * 3.141592653589793D / 180.0D) + localScanningData2.bN);
        f4 = (float)(localScanningData2.bL * Math.sin(120.0F * 3.141592653589793D / 180.0D) + localScanningData2.bO);
        f5 = (float)(localScanningData2.bL * Math.cos(240.0F * 3.141592653589793D / 180.0D) + localScanningData2.bN);
        f6 = (float)(localScanningData2.bL * Math.sin(240.0F * 3.141592653589793D / 180.0D) + localScanningData2.bO);
        localObject = new Path();
        ((Path)localObject).moveTo(f1, f2);
        ((Path)localObject).lineTo(f3, f4);
        ((Path)localObject).lineTo(f5, f6);
        ((Path)localObject).close();
        paramCanvas.drawPath((Path)localObject, localScanningData2.jdField_r_of_type_AndroidGraphicsPaint);
        m += 1;
        j = i;
        break;
        localScanningData2.jdField_i_of_type_AndroidGraphicsPaint.setFakeBoldText(false);
        break label4154;
        localScanningData2.jdField_i_of_type_AndroidGraphicsPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        break label4188;
        i = 0;
        break label4709;
        if (!TextUtils.isEmpty(localScanningData2.jdField_g_of_type_JavaLangString))
        {
          i = 1;
          break label4709;
        }
        i = 0;
        break label4709;
        k = i;
        if (j != 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.a.a(2, localScanningData2.jdField_g_of_type_JavaLangString, false);
          k = i;
        }
        i = k;
        break label4785;
        paramCanvas.drawBitmap(localScanningData2.jdField_a_of_type_AndroidGraphicsBitmap, ((RectF)localObject).left, ((RectF)localObject).top, localScanningData2.jdField_q_of_type_AndroidGraphicsPaint);
      }
    }
    label401:
    label487:
    this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.a.a();
    label517:
    label3023:
    label3292:
    label4188:
    label4709:
    return;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    QLog.d("ScanningSurfaceView", 1, "onClick" + paramMotionEvent.getRawX() + "---" + paramMotionEvent.getRawY());
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    int i = 0;
    paramMotionEvent = null;
    if (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
    {
      paramMotionEvent = (ScanningData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
      if ((paramMotionEvent == null) || (f1 < paramMotionEvent.bX) || (f1 > paramMotionEvent.bY) || (f2 > paramMotionEvent.ca) || (f2 < paramMotionEvent.bZ)) {}
    }
    for (i = 1;; i = 0)
    {
      MotionEvent localMotionEvent = paramMotionEvent;
      int j;
      if (i == 0)
      {
        j = 0;
        label136:
        localMotionEvent = paramMotionEvent;
        if (j < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
        {
          paramMotionEvent = (ScanningData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(j);
          if ((paramMotionEvent != null) && (f1 >= paramMotionEvent.y) && (f1 <= paramMotionEvent.A) && (f2 <= paramMotionEvent.z) && (f2 >= paramMotionEvent.x + paramMotionEvent.aC))
          {
            j = 1;
            localMotionEvent = paramMotionEvent;
          }
        }
      }
      for (;;)
      {
        if ((j != 0) && (localMotionEvent != null) && (localMotionEvent.jdField_f_of_type_Boolean) && (!localMotionEvent.jdField_a_of_type_Boolean) && (!localMotionEvent.jdField_e_of_type_Boolean))
        {
          paramMotionEvent = a();
          this.jdField_a_of_type_AndroidOsHandler.post(new aaeh(this, paramMotionEvent, localMotionEvent));
        }
        if ((i != 0) && (localMotionEvent != null) && (localMotionEvent.jdField_g_of_type_Boolean)) {
          b(localMotionEvent.jdField_b_of_type_JavaLangString);
        }
        if (j != 0) {
          ReportController.b(null, "dc00898", "", "", "0X8008356", "0X8008356", 0, 0, "", "", "", "");
        }
        while (i == 0)
        {
          return;
          i += 1;
          break;
          j += 1;
          break label136;
        }
        ReportController.b(null, "dc00898", "", "", "0X800834D", "0X800834D", 0, 0, "", "", "", "");
        return;
        j = 0;
      }
    }
  }
  
  private void a(ScanningData paramScanningData)
  {
    if ((paramScanningData == null) || (paramScanningData.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(Integer.valueOf(paramScanningData.jdField_f_of_type_Int)))) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramScanningData.jdField_f_of_type_Int), paramScanningData);
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (getContext() != null)) {}
    try
    {
      Intent localIntent = new Intent(getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("finish_animation_up_down", true);
      getContext().startActivity(localIntent);
      if ((getContext() instanceof Activity)) {
        ((Activity)getContext()).overridePendingTransition(2131034134, 0);
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ScanningSurfaceView", 1, "start QQBrowserActivity catch an Exception.", paramString);
    }
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((ScanningData)paramList.next());
      }
    }
  }
  
  private boolean a(ScanningData paramScanningData1, ScanningData paramScanningData2)
  {
    return (paramScanningData1 != null) && (paramScanningData2 != null) && (paramScanningData1.jdField_f_of_type_Int == paramScanningData2.jdField_f_of_type_Int);
  }
  
  private void b(ScanningData paramScanningData)
  {
    int i;
    if (paramScanningData != null) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
        {
          ScanningData localScanningData = (ScanningData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          if (localScanningData != null)
          {
            if ((localScanningData.jdField_f_of_type_Int != paramScanningData.jdField_f_of_type_Int) || (localScanningData.jdField_e_of_type_Boolean != paramScanningData.jdField_e_of_type_Boolean)) {
              break label90;
            }
            return;
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(i);
          break label90;
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramScanningData);
        return;
      }
      catch (Exception paramScanningData)
      {
        QLog.e("ScanningSurfaceView", 1, "addFaceData", paramScanningData);
      }
      return;
      label90:
      i += 1;
    }
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (getContext() != null)) {}
    try
    {
      Intent localIntent = new Intent(getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      getContext().startActivity(localIntent);
      ReportController.b(null, "dc00898", "", "", "0X800834F", "0X800834F", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ScanningSurfaceView", 1, "start QQBrowserActivity catch an Exception.", paramString);
    }
  }
  
  private void c(ScanningData paramScanningData)
  {
    if ((paramScanningData != null) && ((paramScanningData.jdField_b_of_type_AndroidGraphicsBitmap == null) || (paramScanningData.jdField_a_of_type_AndroidGraphicsBitmap == null)) && (!TextUtils.isEmpty(paramScanningData.jdField_a_of_type_JavaLangString))) {
      ThreadManager.post(new aaec(this, paramScanningData), 5, null, true);
    }
  }
  
  private void d()
  {
    setZOrderOnTop(true);
    this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setFormat(-2);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("ScanningSurfaceAnimationThread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_b_of_type_AndroidOsHandlerThread = new HandlerThread("ScanningSurfaceDrawThread");
    this.jdField_b_of_type_AndroidOsHandlerThread.start();
    this.jdField_b_of_type_AndroidOsHandler = new Handler(this.jdField_b_of_type_AndroidOsHandlerThread.getLooper());
    setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
  }
  
  private void d(ScanningData paramScanningData)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
      {
        ScanningData localScanningData = (ScanningData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
        if (a(localScanningData, paramScanningData))
        {
          localScanningData.jdField_a_of_type_Boolean = paramScanningData.jdField_a_of_type_Boolean;
          if (QLog.isColorLevel()) {
            QLog.d("ScanningSurfaceView", 2, "6=" + localScanningData.jdField_a_of_type_Boolean);
          }
          localScanningData.jdField_c_of_type_Boolean = paramScanningData.jdField_c_of_type_Boolean;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void e()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localCanvas = this.jdField_a_of_type_AndroidViewSurfaceHolder.lockCanvas();
        if (localCanvas != null)
        {
          localObject1 = localCanvas;
          localObject3 = localCanvas;
          localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
          localObject1 = localCanvas;
          localObject3 = localCanvas;
          if (!this.jdField_b_of_type_Boolean) {
            continue;
          }
          localObject1 = localCanvas;
          localObject3 = localCanvas;
          QLog.d("ScanningSurfaceView", 1, "clearCanvas");
        }
      }
      catch (Exception localException4)
      {
        Canvas localCanvas;
        localObject3 = localObject1;
        QLog.e("ScanningSurfaceView", 1, "doDraw catch an exception.", localException4);
        if (localObject1 == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(localObject1);
          return;
        }
        catch (Exception localException1)
        {
          QLog.e("ScanningSurfaceView", 1, "doDraw finally catch an exception.", localException1);
          return;
        }
      }
      finally
      {
        if (localObject3 == null) {
          break label161;
        }
      }
      try
      {
        this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(localCanvas);
        return;
      }
      catch (Exception localException2)
      {
        QLog.e("ScanningSurfaceView", 1, "doDraw finally catch an exception.", localException2);
        return;
      }
      localObject1 = localCanvas;
      localObject3 = localCanvas;
      a(localCanvas);
      localObject1 = localCanvas;
      localObject3 = localCanvas;
      QLog.d("ScanningSurfaceView", 1, "drawCanvas");
    }
    try
    {
      this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(localObject3);
      label161:
      throw localObject2;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        QLog.e("ScanningSurfaceView", 1, "doDraw finally catch an exception.", localException3);
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void b()
  {
    float f1;
    int i;
    int j;
    Object localObject2;
    int k;
    Object localObject1;
    DrawView2.FaceData localFaceData;
    RectF localRectF;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if (a() == null)
      {
        if (this.jdField_a_of_type_JavaUtilList.get(0) != null) {}
        for (f1 = ((DrawView2.FaceData)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Float;; f1 = 0.0F)
        {
          i = 1;
          for (j = 0; i < this.jdField_a_of_type_JavaUtilList.size(); j = k)
          {
            localObject2 = (DrawView2.FaceData)this.jdField_a_of_type_JavaUtilList.get(i);
            k = j;
            if (localObject2 != null)
            {
              k = j;
              if (((DrawView2.FaceData)localObject2).jdField_a_of_type_Float > f1) {
                k = i;
              }
            }
            if ((localObject2 != null) && (QLog.isColorLevel()))
            {
              localObject1 = "普通人";
              if (!TextUtils.isEmpty(((DrawView2.FaceData)localObject2).jdField_a_of_type_JavaLangString)) {
                localObject1 = ((DrawView2.FaceData)localObject2).jdField_a_of_type_JavaLangString;
              }
              QLog.d("ScanningSurfaceView", 2, "name = " + (String)localObject1 + ",confidence = " + ((DrawView2.FaceData)localObject2).jdField_a_of_type_Float + ",faceId = " + ((DrawView2.FaceData)localObject2).jdField_a_of_type_Int + ",isTmpFace = " + ((DrawView2.FaceData)localObject2).jdField_e_of_type_Boolean);
            }
            i += 1;
          }
        }
        localObject1 = (DrawView2.FaceData)this.jdField_a_of_type_JavaUtilList.get(j);
        if (localObject1 != null) {
          ((DrawView2.FaceData)localObject1).jdField_a_of_type_Boolean = true;
        }
      }
      j = 0;
      if (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        localFaceData = (DrawView2.FaceData)this.jdField_a_of_type_JavaUtilList.get(j);
        if (localFaceData != null)
        {
          localRectF = localFaceData.a();
          i = 0;
          if (i >= this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()) {
            break label1653;
          }
          localObject2 = (ScanningData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          if ((localObject2 != null) && (((ScanningData)localObject2).jdField_f_of_type_Int == localFaceData.jdField_a_of_type_Int) && (((ScanningData)localObject2).jdField_e_of_type_Boolean == localFaceData.jdField_e_of_type_Boolean)) {
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      k = i;
      if (!localFaceData.jdField_e_of_type_Boolean)
      {
        localObject1 = localObject2;
        k = i;
        if (i == 0)
        {
          localObject1 = localObject2;
          k = i;
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(localFaceData.jdField_a_of_type_Int)))
          {
            localObject2 = (ScanningData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(localFaceData.jdField_a_of_type_Int));
            localObject1 = localObject2;
            k = i;
            if (localObject2 != null)
            {
              b((ScanningData)localObject2);
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(localFaceData.jdField_a_of_type_Int));
              k = 1;
              localObject1 = localObject2;
            }
          }
        }
      }
      if (k == 0) {
        if ((localFaceData.jdField_a_of_type_Boolean) && (localFaceData.jdField_b_of_type_Boolean) && (!localFaceData.jdField_e_of_type_Boolean))
        {
          localObject1 = new MainFaceScanningData(getContext());
          label519:
          ((ScanningData)localObject1).jdField_e_of_type_Boolean = localFaceData.jdField_e_of_type_Boolean;
          ((ScanningData)localObject1).jdField_f_of_type_Int = localFaceData.jdField_a_of_type_Int;
          if (!localFaceData.jdField_e_of_type_Boolean)
          {
            ((ScanningData)localObject1).jdField_a_of_type_Boolean = localFaceData.jdField_a_of_type_Boolean;
            if (QLog.isColorLevel()) {
              QLog.d("ScanningSurfaceView", 2, "1=" + ((ScanningData)localObject1).jdField_a_of_type_Boolean);
            }
            ((ScanningData)localObject1).jdField_d_of_type_JavaLangString = localFaceData.jdField_b_of_type_JavaLangString;
            ((ScanningData)localObject1).jdField_e_of_type_JavaLangString = localFaceData.jdField_a_of_type_JavaLangString;
            ((ScanningData)localObject1).jdField_f_of_type_JavaLangString = localFaceData.jdField_c_of_type_JavaLangString;
            ((ScanningData)localObject1).jdField_b_of_type_JavaLangString = localFaceData.jdField_f_of_type_JavaLangString;
            ((ScanningData)localObject1).jdField_f_of_type_Boolean = localFaceData.jdField_b_of_type_Boolean;
            ((ScanningData)localObject1).jdField_g_of_type_Boolean = localFaceData.jdField_c_of_type_Boolean;
            ((ScanningData)localObject1).jdField_a_of_type_AndroidGraphicsRectF = localRectF;
            ((ScanningData)localObject1).jdField_a_of_type_JavaLangString = localFaceData.jdField_h_of_type_JavaLangString;
            ((ScanningData)localObject1).jdField_c_of_type_JavaLangString = localFaceData.jdField_g_of_type_JavaLangString;
            if (!((ScanningData)localObject1).jdField_f_of_type_Boolean) {
              break label1001;
            }
            ((ScanningData)localObject1).jdField_g_of_type_JavaLangString = localFaceData.jdField_d_of_type_JavaLangString;
            ((ScanningData)localObject1).jdField_h_of_type_JavaLangString = localFaceData.jdField_e_of_type_JavaLangString;
            label708:
            if ((!((ScanningData)localObject1).jdField_d_of_type_Boolean) && (QLog.isColorLevel()))
            {
              ((ScanningData)localObject1).jdField_d_of_type_Boolean = true;
              QLog.d("ScanningSurfaceView", 2, "isMainFace = " + ((ScanningData)localObject1).jdField_a_of_type_Boolean + ", fNCH = " + ((ScanningData)localObject1).jdField_e_of_type_JavaLangString + ", faceID = " + ((ScanningData)localObject1).jdField_f_of_type_Int + ", isStar = " + ((ScanningData)localObject1).jdField_f_of_type_Boolean + ", isActivate = " + ((ScanningData)localObject1).jdField_g_of_type_Boolean + ", fCTitleText = " + ((ScanningData)localObject1).jdField_g_of_type_JavaLangString + ", fCContentText = " + ((ScanningData)localObject1).jdField_h_of_type_JavaLangString + ", url = " + ((ScanningData)localObject1).jdField_b_of_type_JavaLangString + ", imgUrl = " + ((ScanningData)localObject1).jdField_a_of_type_JavaLangString + ", wikiUrl = " + ((ScanningData)localObject1).jdField_c_of_type_JavaLangString);
            }
          }
          b((ScanningData)localObject1);
        }
      }
      for (;;)
      {
        ((ScanningData)localObject1).jdField_a_of_type_AndroidGraphicsRectF = localRectF;
        if (((ScanningData)localObject1).jdField_a_of_type_Boolean)
        {
          i = 0;
          for (;;)
          {
            if (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
            {
              localObject2 = (ScanningData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
              if ((localObject2 != null) && (((ScanningData)localObject2).jdField_f_of_type_Int != ((ScanningData)localObject1).jdField_f_of_type_Int) && (!((ScanningData)localObject2).jdField_f_of_type_Boolean) && (((ScanningData)localObject2).jdField_a_of_type_Boolean)) {
                ((ScanningData)localObject2).jdField_a_of_type_Boolean = false;
              }
              i += 1;
              continue;
              i += 1;
              break;
              localObject1 = new SubFaceScanningData(getContext());
              break label519;
              label1001:
              localObject2 = ARGlobalRemoteManager.a(getContext()).a();
              if (localObject2 == null) {
                break label708;
              }
              ((ScanningData)localObject1).jdField_g_of_type_JavaLangString = ((ARScanStarFaceConfigInfo)localObject2).jdField_a_of_type_JavaLangString;
              break label708;
            }
          }
        }
        if (localRectF != null)
        {
          f1 = localRectF.centerX();
          float f2 = localRectF.centerY();
          this.jdField_a_of_type_ComTencentMobileqqArScanningData = ((ScanningData)localObject1);
          if ((Math.abs(f1 - ((ScanningData)localObject1).jdField_a_of_type_Float) > ScanningData.Dip2PxCache.jdField_j_of_type_Int) || (Math.abs(f2 - ((ScanningData)localObject1).jdField_b_of_type_Float) > ScanningData.Dip2PxCache.jdField_j_of_type_Int))
          {
            ((ScanningData)localObject1).jdField_a_of_type_Float = f1;
            ((ScanningData)localObject1).jdField_b_of_type_Float = f2;
          }
          QLog.d("ScanningSurfaceView", 1, "centerX = " + f1 + ", centerY = " + f2);
          f1 = (float)Math.sqrt(localRectF.width() * localRectF.width() + localRectF.height() * localRectF.height());
          f1 = Math.min(((ScanningData)localObject1).K, f1 / 2.0F);
          if (((ScanningData)localObject1).O > 0.0F)
          {
            this.jdField_a_of_type_Float = (f1 / ((ScanningData)localObject1).O);
            label1200:
            if (this.jdField_a_of_type_Float > 100.0F) {
              this.jdField_a_of_type_Float = 1.0F;
            }
            if (!((ScanningData)localObject1).jdField_b_of_type_Boolean) {
              break label1376;
            }
            this.jdField_a_of_type_Float *= 0.9F;
            label1236:
            QLog.d("ScanningSurfaceView", 1, "scale = " + this.jdField_a_of_type_Float + ",scanningData.scale = " + ((ScanningData)localObject1).jdField_c_of_type_Float + ", trueRadius = " + f1 + ", iBCRadiusFix = " + ((ScanningData)localObject1).O);
          }
        }
        else
        {
          if (!this.jdField_c_of_type_Boolean) {
            break label1391;
          }
          if (Math.abs(((ScanningData)localObject1).jdField_c_of_type_Float - this.jdField_a_of_type_Float) >= 0.03D)
          {
            ((ScanningData)localObject1).b();
            ((ScanningData)localObject1).a(this.jdField_a_of_type_Float);
          }
        }
        for (;;)
        {
          if (!((ScanningData)localObject1).jdField_e_of_type_Boolean) {
            c((ScanningData)localObject1);
          }
          j += 1;
          break;
          this.jdField_a_of_type_Float = 1.0F;
          break label1200;
          label1376:
          this.jdField_a_of_type_Float *= 0.95F;
          break label1236;
          label1391:
          ((ScanningData)localObject1).b();
          ((ScanningData)localObject1).a(this.jdField_a_of_type_Float);
        }
        i = 0;
        if (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
        {
          localObject1 = (ScanningData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          j = 0;
          label1437:
          if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label1644;
          }
          localObject2 = (DrawView2.FaceData)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((localObject2 == null) || (localObject1 == null) || (((ScanningData)localObject1).jdField_f_of_type_Int != ((DrawView2.FaceData)localObject2).jdField_a_of_type_Int) || (((ScanningData)localObject1).jdField_e_of_type_Boolean != ((DrawView2.FaceData)localObject2).jdField_e_of_type_Boolean)) {}
        }
        label1644:
        for (j = 1;; j = 0)
        {
          if (j == 0)
          {
            a((ScanningData)localObject1);
            this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(i);
            QLog.d("ckwkenvencai", 1, "remove2");
          }
          i += 1;
          break;
          j += 1;
          break label1437;
          this.jdField_b_of_type_Boolean = false;
          if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0))
          {
            this.jdField_c_of_type_Boolean = true;
            this.jdField_b_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
          }
          if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0) {
            this.jdField_c_of_type_Boolean = false;
          }
          do
          {
            return;
            c();
            QLog.e("ScanningSurfaceView", 1, "lost the face data.");
          } while (this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.a.a() == 0);
          this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.a.a();
          return;
        }
      }
      label1653:
      i = 0;
      localObject2 = null;
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    if ((this.jdField_a_of_type_ComTencentMobileqqArFaceUIController != null) && (this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.a != null) && (this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.a.a() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.a.a();
    }
    QLog.d("ScanningSurfaceView", 1, "clear the animation and face data.");
  }
  
  public void setFaceData(List paramList)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      b();
      return;
    }
    catch (Exception paramList)
    {
      QLog.e("ScanningSurfaceView", 1, "setFaceData catch an exception.", paramList);
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanningSurfaceView", 2, "surfaceChanged");
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanningSurfaceView", 2, "surfaceCreated");
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    c();
    if (QLog.isColorLevel()) {
      QLog.d("ScanningSurfaceView", 2, "surfaceDestroyed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanningSurfaceView
 * JD-Core Version:    0.7.0.1
 */