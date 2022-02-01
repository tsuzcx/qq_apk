package com.tencent.mobileqq.ar;

import amtj;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import aodj;
import aodo;
import aodz;
import aoec;
import aoed;
import axqp;
import bcef;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ObjectSurfaceView
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
  public aodo a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ObjectSurfaceView.1(this);
  private List<aodj> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<String, ObjectBaseData> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<ObjectBaseData> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 0.5F };
  int[] jdField_a_of_type_ArrayOfInt = { Color.argb(255, 30, 255, 236), Color.argb(255, 0, 191, 255) };
  private Handler jdField_b_of_type_AndroidOsHandler;
  private HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  private CopyOnWriteArrayList<String> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_b_of_type_Boolean;
  
  public ObjectSurfaceView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public ObjectSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public ObjectSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 >= paramFloat1) {
      return paramFloat2 - paramFloat1;
    }
    return 360.0F + paramFloat2 - paramFloat1;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private long a(ObjectBaseData paramObjectBaseData)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramObjectBaseData.jdField_f_of_type_Boolean)
    {
      l1 = l2;
      if (paramObjectBaseData.aV > 0.0F)
      {
        l1 = l2;
        if (!paramObjectBaseData.jdField_e_of_type_Boolean)
        {
          l1 = l2;
          if (!TextUtils.isEmpty(paramObjectBaseData.jdField_f_of_type_JavaLangString))
          {
            l1 = l2;
            if (!TextUtils.isEmpty(paramObjectBaseData.jdField_g_of_type_JavaLangString))
            {
              l2 = 0L + a(getContext(), 10.0F) + 32L;
              if (paramObjectBaseData.jdField_f_of_type_JavaLangString.length() >= 8) {
                break label100;
              }
              l1 = l2 + 60L;
            }
          }
        }
      }
    }
    label100:
    do
    {
      return l1;
      if (paramObjectBaseData.jdField_f_of_type_JavaLangString.length() == 8) {
        return l2 + 52L;
      }
      l1 = l2;
    } while (paramObjectBaseData.jdField_f_of_type_JavaLangString.length() <= 8);
    return l2 + 160L;
  }
  
  private ObjectBaseData a()
  {
    int i = 0;
    ObjectBaseData localObjectBaseData1;
    if (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
    {
      localObjectBaseData1 = (ObjectBaseData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
      if ((localObjectBaseData1 == null) || (!localObjectBaseData1.jdField_a_of_type_Boolean) || (!localObjectBaseData1.jdField_f_of_type_Boolean) || (localObjectBaseData1.jdField_e_of_type_Boolean)) {}
    }
    for (;;)
    {
      if ((localObjectBaseData1 == null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            ObjectBaseData localObjectBaseData2 = (ObjectBaseData)((Map.Entry)localIterator.next()).getValue();
            if ((localObjectBaseData2 != null) && (localObjectBaseData2.jdField_a_of_type_Boolean) && (localObjectBaseData2.jdField_f_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean))
            {
              return localObjectBaseData2;
              i += 1;
              break;
            }
          }
        }
      }
      return localObjectBaseData1;
      localObjectBaseData1 = null;
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    ObjectBaseData localObjectBaseData1;
    int m;
    int j;
    if (paramCanvas != null)
    {
      localObjectBaseData1 = a();
      m = 0;
      j = 1;
      if (m >= this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()) {
        break label6529;
      }
      localObjectBaseData2 = (ObjectBaseData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(m);
      if (localObjectBaseData2 != null) {
        break label48;
      }
    }
    label48:
    label247:
    label4473:
    label6522:
    while (j == 0)
    {
      ObjectBaseData localObjectBaseData2;
      return;
      Object localObject1;
      Object localObject2;
      if (!localObjectBaseData2.jdField_h_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new ObjectSurfaceView.2(this, localObjectBaseData2, localObjectBaseData1));
        if ((localObjectBaseData2.jdField_a_of_type_Boolean) && (!localObjectBaseData2.jdField_b_of_type_Boolean) && (localObjectBaseData2.jdField_g_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean))
        {
          if (TextUtils.isEmpty(localObjectBaseData2.jdField_d_of_type_JavaLangString)) {
            break label3620;
          }
          if (!this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(localObjectBaseData2.jdField_d_of_type_JavaLangString))
          {
            localObject1 = localObjectBaseData2.jdField_d_of_type_JavaLangString;
            localObject2 = localObjectBaseData2.jdField_b_of_type_JavaLangString;
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ObjectSurfaceView.3(this, (String)localObject1, (String)localObject2), 4000L);
          }
        }
      }
      localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setColor(localObjectBaseData2.jdField_e_of_type_Int);
      localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(localObjectBaseData2.jdField_i_of_type_Float);
      float f1;
      float f5;
      float f2;
      float f3;
      float f4;
      float f6;
      float f7;
      float f8;
      if (((localObjectBaseData2.jdField_a_of_type_Boolean) || (localObjectBaseData2.jdField_c_of_type_Boolean)) && (localObjectBaseData2.jdField_f_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean))
      {
        localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.v * 255.0F));
        f1 = localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + localObjectBaseData2.jdField_i_of_type_Float;
        localObject1 = new RectF(localObjectBaseData2.jdField_a_of_type_Float - f1, localObjectBaseData2.jdField_b_of_type_Float - f1, localObjectBaseData2.jdField_a_of_type_Float + f1, f1 + localObjectBaseData2.jdField_b_of_type_Float);
        if ((localObjectBaseData2.jdField_e_of_type_Int != -1) && (localObjectBaseData2.jdField_a_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean)) {
          break label3678;
        }
        localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
        if (localObjectBaseData2.aA == 0.0F) {
          break label3766;
        }
        this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter = new BlurMaskFilter(localObjectBaseData2.aB * localObjectBaseData2.aA, BlurMaskFilter.Blur.SOLID);
        if (this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter == null) {
          break label3774;
        }
        localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setMaskFilter(this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter);
        localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
        f1 = localObjectBaseData2.jdField_j_of_type_Float;
        paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.jdField_h_of_type_Float + f1, a(localObjectBaseData2.jdField_j_of_type_Float + localObjectBaseData2.jdField_h_of_type_Float, localObjectBaseData2.jdField_k_of_type_Float + localObjectBaseData2.jdField_h_of_type_Float), false, localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint);
        if ((localObjectBaseData2.jdField_e_of_type_Int != -1) && (localObjectBaseData2.jdField_a_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean)) {
          break label3787;
        }
        localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
        if (this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter == null) {
          break label3898;
        }
        localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setMaskFilter(this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter);
        localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
        f1 = localObjectBaseData2.jdField_l_of_type_Float;
        paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.jdField_h_of_type_Float + f1, a(localObjectBaseData2.jdField_l_of_type_Float + localObjectBaseData2.jdField_h_of_type_Float, localObjectBaseData2.jdField_m_of_type_Float + localObjectBaseData2.jdField_h_of_type_Float), false, localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint);
        if ((localObjectBaseData2.u > 0.0F) && ((localObjectBaseData2.jdField_a_of_type_Boolean) || (localObjectBaseData2.jdField_c_of_type_Boolean)) && (localObjectBaseData2.jdField_f_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean))
        {
          f5 = localObjectBaseData2.jdField_i_of_type_Float;
          localObjectBaseData2.q = ((float)((localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + f5) * Math.cos((localObjectBaseData2.o + localObjectBaseData2.jdField_h_of_type_Float) * 3.141592653589793D / 180.0D) + localObjectBaseData2.jdField_a_of_type_Float));
          localObjectBaseData2.r = ((float)((localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + f5) * Math.sin((localObjectBaseData2.o + localObjectBaseData2.jdField_h_of_type_Float) * 3.141592653589793D / 180.0D) + localObjectBaseData2.jdField_b_of_type_Float));
          f2 = localObjectBaseData2.p + localObjectBaseData2.jdField_h_of_type_Float;
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
          f4 = (float)(localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float * Math.cos(f1 * 3.141592653589793D / 180.0D) + localObjectBaseData2.q);
          f1 = (float)(localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float * Math.sin(f1 * 3.141592653589793D / 180.0D) + localObjectBaseData2.r);
          f6 = (float)(localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float * Math.cos(f2 * 3.141592653589793D / 180.0D) + localObjectBaseData2.q);
          f2 = (float)(localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float * Math.sin(f2 * 3.141592653589793D / 180.0D) + localObjectBaseData2.r);
          f7 = (float)(localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float * Math.cos(f3 * 3.141592653589793D / 180.0D) + localObjectBaseData2.q);
          f3 = (float)(localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float * Math.sin(f3 * 3.141592653589793D / 180.0D) + localObjectBaseData2.r);
          localObject1 = new Path();
          ((Path)localObject1).moveTo(f4, f1);
          ((Path)localObject1).lineTo(f6, f2);
          ((Path)localObject1).lineTo(f7, f3);
          ((Path)localObject1).close();
          localObjectBaseData2.jdField_b_of_type_AndroidGraphicsPaint.setColor(localObjectBaseData2.jdField_c_of_type_Int);
          localObjectBaseData2.jdField_b_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.u * 255.0F));
          paramCanvas.drawPath((Path)localObject1, localObjectBaseData2.jdField_b_of_type_AndroidGraphicsPaint);
          localObjectBaseData2.s = ((float)((localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + f5) * Math.cos((localObjectBaseData2.p + localObjectBaseData2.jdField_h_of_type_Float) * 3.141592653589793D / 180.0D) + localObjectBaseData2.jdField_a_of_type_Float));
          localObjectBaseData2.t = ((float)((localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + f5) * Math.sin((localObjectBaseData2.p + localObjectBaseData2.jdField_h_of_type_Float) * 3.141592653589793D / 180.0D) + localObjectBaseData2.jdField_b_of_type_Float));
          f2 = localObjectBaseData2.o + localObjectBaseData2.jdField_h_of_type_Float;
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
          f4 = (float)(localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float * Math.cos(f1 * 3.141592653589793D / 180.0D) + localObjectBaseData2.s);
          f1 = (float)(localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float * Math.sin(f1 * 3.141592653589793D / 180.0D) + localObjectBaseData2.t);
          f5 = (float)(localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float * Math.cos(f2 * 3.141592653589793D / 180.0D) + localObjectBaseData2.s);
          f2 = (float)(localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float * Math.sin(f2 * 3.141592653589793D / 180.0D) + localObjectBaseData2.t);
          f6 = (float)(localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float * Math.cos(f3 * 3.141592653589793D / 180.0D) + localObjectBaseData2.s);
          f3 = (float)(localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float * Math.sin(f3 * 3.141592653589793D / 180.0D) + localObjectBaseData2.t);
          ((Path)localObject1).reset();
          ((Path)localObject1).moveTo(f4, f1);
          ((Path)localObject1).lineTo(f5, f2);
          ((Path)localObject1).lineTo(f6, f3);
          ((Path)localObject1).close();
          localObjectBaseData2.jdField_b_of_type_AndroidGraphicsPaint.setColor(localObjectBaseData2.jdField_d_of_type_Int);
          localObjectBaseData2.jdField_b_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.u * 255.0F));
          paramCanvas.drawPath((Path)localObject1, localObjectBaseData2.jdField_b_of_type_AndroidGraphicsPaint);
        }
        if ((localObjectBaseData2.J > 0.0F) && ((localObjectBaseData2.jdField_a_of_type_Boolean) || (localObjectBaseData2.jdField_c_of_type_Boolean)) && (localObjectBaseData2.jdField_f_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean))
        {
          localObjectBaseData2.jdField_c_of_type_AndroidGraphicsPaint.setColor(localObjectBaseData2.jdField_f_of_type_Int);
          localObjectBaseData2.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(localObjectBaseData2.E);
          localObjectBaseData2.jdField_c_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.J * 255.0F * 0.4D));
          f1 = localObjectBaseData2.B * localObjectBaseData2.C + localObjectBaseData2.E;
          localObject1 = new RectF(localObjectBaseData2.jdField_a_of_type_Float - f1, localObjectBaseData2.jdField_b_of_type_Float - f1, localObjectBaseData2.jdField_a_of_type_Float + f1, f1 + localObjectBaseData2.jdField_b_of_type_Float);
          f1 = localObjectBaseData2.F;
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.D + f1, a(localObjectBaseData2.F + localObjectBaseData2.D, localObjectBaseData2.G + localObjectBaseData2.D), false, localObjectBaseData2.jdField_c_of_type_AndroidGraphicsPaint);
          f1 = localObjectBaseData2.H;
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.D + f1, a(localObjectBaseData2.H + localObjectBaseData2.D, localObjectBaseData2.I + localObjectBaseData2.D), false, localObjectBaseData2.jdField_c_of_type_AndroidGraphicsPaint);
        }
        localObjectBaseData2.jdField_d_of_type_AndroidGraphicsPaint.setColor(localObjectBaseData2.jdField_g_of_type_Int);
        localObjectBaseData2.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth(localObjectBaseData2.P);
        localObjectBaseData2.jdField_d_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.W * 255.0F * 0.3D));
        f1 = localObjectBaseData2.L * localObjectBaseData2.M + localObjectBaseData2.P;
        localObject1 = new RectF(localObjectBaseData2.jdField_a_of_type_Float - f1, localObjectBaseData2.jdField_b_of_type_Float - f1, localObjectBaseData2.jdField_a_of_type_Float + f1, f1 + localObjectBaseData2.jdField_b_of_type_Float);
        f1 = localObjectBaseData2.Q;
        paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.N + f1, a(localObjectBaseData2.Q + localObjectBaseData2.N, localObjectBaseData2.R + localObjectBaseData2.N), false, localObjectBaseData2.jdField_d_of_type_AndroidGraphicsPaint);
        f1 = localObjectBaseData2.U;
        paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.N + f1, a(localObjectBaseData2.U + localObjectBaseData2.N, localObjectBaseData2.V + localObjectBaseData2.N), false, localObjectBaseData2.jdField_d_of_type_AndroidGraphicsPaint);
        f1 = localObjectBaseData2.S;
        paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.N + f1, a(localObjectBaseData2.S + localObjectBaseData2.N, localObjectBaseData2.T + localObjectBaseData2.N), false, localObjectBaseData2.jdField_d_of_type_AndroidGraphicsPaint);
        if ((localObjectBaseData2.af > 0.0F) && ((localObjectBaseData2.jdField_a_of_type_Boolean) || (localObjectBaseData2.jdField_c_of_type_Boolean)) && (localObjectBaseData2.jdField_f_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean))
        {
          localObjectBaseData2.jdField_e_of_type_AndroidGraphicsPaint.setColor(localObjectBaseData2.jdField_h_of_type_Int);
          localObjectBaseData2.jdField_e_of_type_AndroidGraphicsPaint.setStrokeWidth(localObjectBaseData2.Y);
          localObjectBaseData2.jdField_e_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.af * 255.0F));
          f1 = localObjectBaseData2.Z;
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.N + f1, a(localObjectBaseData2.Z + localObjectBaseData2.N, localObjectBaseData2.aa + localObjectBaseData2.N), false, localObjectBaseData2.jdField_e_of_type_AndroidGraphicsPaint);
          f1 = localObjectBaseData2.ad;
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.N + f1, a(localObjectBaseData2.ad + localObjectBaseData2.N, localObjectBaseData2.ae + localObjectBaseData2.N), false, localObjectBaseData2.jdField_e_of_type_AndroidGraphicsPaint);
          f1 = localObjectBaseData2.ab;
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.N + f1, a(localObjectBaseData2.ab + localObjectBaseData2.N, localObjectBaseData2.ac + localObjectBaseData2.N), false, localObjectBaseData2.jdField_e_of_type_AndroidGraphicsPaint);
        }
        if ((localObjectBaseData2.aj > 0.0F) && ((localObjectBaseData2.jdField_a_of_type_Boolean) || (localObjectBaseData2.jdField_c_of_type_Boolean)) && (localObjectBaseData2.jdField_f_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean))
        {
          localObjectBaseData2.jdField_f_of_type_AndroidGraphicsPaint.setColor(localObjectBaseData2.jdField_i_of_type_Int);
          localObjectBaseData2.jdField_f_of_type_AndroidGraphicsPaint.setStrokeWidth(localObjectBaseData2.ai);
          localObjectBaseData2.jdField_f_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.aj * 255.0F * 0.1D));
          f1 = localObjectBaseData2.ai / 2.0F;
          paramCanvas.drawCircle(localObjectBaseData2.jdField_a_of_type_Float, localObjectBaseData2.jdField_b_of_type_Float, f1 + localObjectBaseData2.ag * localObjectBaseData2.ah, localObjectBaseData2.jdField_f_of_type_AndroidGraphicsPaint);
        }
        if ((localObjectBaseData2.aw > 0.0F) && ((localObjectBaseData2.jdField_a_of_type_Boolean) || (localObjectBaseData2.jdField_c_of_type_Boolean)) && (localObjectBaseData2.jdField_f_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean))
        {
          localObjectBaseData2.jdField_g_of_type_AndroidGraphicsPaint.setColor(localObjectBaseData2.jdField_j_of_type_Int);
          localObjectBaseData2.jdField_g_of_type_AndroidGraphicsPaint.setStrokeWidth(localObjectBaseData2.an);
          localObjectBaseData2.jdField_g_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.aw * 255.0F * 0.3D));
          f1 = localObjectBaseData2.am * localObjectBaseData2.ak + localObjectBaseData2.an;
          localObject1 = new RectF(localObjectBaseData2.jdField_a_of_type_Float - f1, localObjectBaseData2.jdField_b_of_type_Float - f1, localObjectBaseData2.jdField_a_of_type_Float + f1, f1 + localObjectBaseData2.jdField_b_of_type_Float);
          f1 = localObjectBaseData2.aq;
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.al + f1, a(localObjectBaseData2.aq + localObjectBaseData2.al, localObjectBaseData2.ar + localObjectBaseData2.al), false, localObjectBaseData2.jdField_g_of_type_AndroidGraphicsPaint);
          f1 = localObjectBaseData2.ao;
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.al + f1, a(localObjectBaseData2.ao + localObjectBaseData2.al, localObjectBaseData2.ap + localObjectBaseData2.al), false, localObjectBaseData2.jdField_g_of_type_AndroidGraphicsPaint);
          f1 = localObjectBaseData2.au;
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.al + f1, a(localObjectBaseData2.au + localObjectBaseData2.al, localObjectBaseData2.av + localObjectBaseData2.al), false, localObjectBaseData2.jdField_g_of_type_AndroidGraphicsPaint);
          f1 = localObjectBaseData2.as;
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.al + f1, a(localObjectBaseData2.as + localObjectBaseData2.al, localObjectBaseData2.at + localObjectBaseData2.al), false, localObjectBaseData2.jdField_g_of_type_AndroidGraphicsPaint);
        }
        if ((localObjectBaseData2.az > 0.0F) && ((localObjectBaseData2.jdField_a_of_type_Boolean) || (localObjectBaseData2.jdField_c_of_type_Boolean)) && (localObjectBaseData2.jdField_f_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean))
        {
          localObjectBaseData2.jdField_h_of_type_AndroidGraphicsPaint.setColor(localObjectBaseData2.jdField_k_of_type_Int);
          localObjectBaseData2.jdField_h_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.az * 255.0F));
          paramCanvas.drawCircle(localObjectBaseData2.jdField_a_of_type_Float, localObjectBaseData2.jdField_b_of_type_Float, 0.0F + localObjectBaseData2.ay * localObjectBaseData2.ax, localObjectBaseData2.jdField_h_of_type_AndroidGraphicsPaint);
        }
        i = 1;
        if (localObjectBaseData2.jdField_b_of_type_Float < localObjectBaseData2.jdField_f_of_type_Float + (float)a(localObjectBaseData2) + 80.0F) {
          i = 2;
        }
        if ((!localObjectBaseData2.jdField_f_of_type_Boolean) || (localObjectBaseData2.aV <= 0.0F) || (localObjectBaseData2.jdField_e_of_type_Boolean) || (i != 1)) {
          break label4888;
        }
        localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.aV * 255.0F));
        localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setStrokeWidth(localObjectBaseData2.aI);
        localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setStrokeWidth(localObjectBaseData2.aH);
        localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.aV * 255.0F));
        if ((!localObjectBaseData2.jdField_a_of_type_Boolean) || (localObjectBaseData2.C == 0.0F)) {
          break label3911;
        }
        localObjectBaseData2.aC = ((localObjectBaseData2.B * localObjectBaseData2.C + localObjectBaseData2.E) * 2.0F / 3.6F);
        if (localObjectBaseData2.aC > localObjectBaseData2.aD) {
          localObjectBaseData2.aC = localObjectBaseData2.aD;
        }
        if (localObjectBaseData2.aC < localObjectBaseData2.aE) {
          localObjectBaseData2.aC = localObjectBaseData2.aE;
        }
        localObjectBaseData2.aF = (localObjectBaseData2.jdField_a_of_type_Float - localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float - localObjectBaseData2.jdField_i_of_type_Float - localObjectBaseData2.aS);
        localObjectBaseData2.aG = (localObjectBaseData2.jdField_b_of_type_Float - localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float - localObjectBaseData2.jdField_i_of_type_Float - localObjectBaseData2.aT * localObjectBaseData2.bg);
        if ((!localObjectBaseData2.jdField_a_of_type_Boolean) || (!localObjectBaseData2.jdField_f_of_type_Boolean) || (localObjectBaseData2.C == 0.0F)) {
          break label3942;
        }
        localObjectBaseData2.aF = (localObjectBaseData2.jdField_a_of_type_Float - localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float - localObjectBaseData2.jdField_i_of_type_Float - localObjectBaseData2.aS - aoec.jdField_e_of_type_Int);
        localObjectBaseData2.x = (localObjectBaseData2.aG - localObjectBaseData2.aC);
        localObjectBaseData2.z = (localObjectBaseData2.jdField_b_of_type_Float + localObjectBaseData2.B * localObjectBaseData2.C + localObjectBaseData2.E);
        localObjectBaseData2.A = (localObjectBaseData2.jdField_a_of_type_Float + localObjectBaseData2.B * localObjectBaseData2.C + localObjectBaseData2.E);
        localObjectBaseData2.y = localObjectBaseData2.aF;
        f3 = localObjectBaseData2.jdField_a_of_type_Float;
        f4 = localObjectBaseData2.L;
        f5 = localObjectBaseData2.ai;
        f6 = localObjectBaseData2.bQ;
        f7 = localObjectBaseData2.bI;
        f8 = localObjectBaseData2.bJ;
        if ((TextUtils.isEmpty(localObjectBaseData2.jdField_f_of_type_JavaLangString)) || (TextUtils.isEmpty(localObjectBaseData2.jdField_g_of_type_JavaLangString))) {
          break label4473;
        }
        localObjectBaseData2.jdField_g_of_type_JavaLangString = localObjectBaseData2.jdField_g_of_type_JavaLangString.toUpperCase();
        localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setTextSize(localObjectBaseData2.aO * localObjectBaseData2.bg);
        localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
        if (localObjectBaseData2.aV == 0.0F) {
          break label4027;
        }
        localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setShadowLayer(localObjectBaseData2.aX, 0.0F, localObjectBaseData2.aY, localObjectBaseData2.jdField_m_of_type_Int);
      }
      float f9;
      float f10;
      for (;;)
      {
        localObject1 = localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.getFontMetrics();
        f2 = localObjectBaseData2.aG + ((Paint.FontMetrics)localObject1).top;
        f1 = localObjectBaseData2.aG;
        f9 = ((Paint.FontMetrics)localObject1).bottom + f1;
        if (localObjectBaseData2.aK != 0.0F) {
          break label4054;
        }
        f10 = localObjectBaseData2.y;
        f1 = localObjectBaseData2.aJ;
        localObjectBaseData2.jdField_a_of_type_AndroidTextTextPaint.setTextSize(localObjectBaseData2.bg * f1);
        while (localObjectBaseData2.jdField_a_of_type_AndroidTextTextPaint.measureText(localObjectBaseData2.jdField_f_of_type_JavaLangString) > f3 + f4 + f5 + f6 - f7 - 4.0F * f8 - f10)
        {
          f1 -= 1.0F;
          localObjectBaseData2.jdField_a_of_type_AndroidTextTextPaint.setTextSize(localObjectBaseData2.bg * f1);
        }
        if (!localObjectBaseData2.jdField_g_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ObjectSurfaceView.4(this, localObjectBaseData2), 4000L);
        break;
        localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.v * 255.0F * 0.5D));
        break label247;
        this.jdField_a_of_type_AndroidGraphicsSweepGradient = new SweepGradient(localObjectBaseData2.jdField_a_of_type_Float, localObjectBaseData2.jdField_b_of_type_Float, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat);
        this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(localObjectBaseData2.jdField_j_of_type_Float + localObjectBaseData2.jdField_h_of_type_Float - 5.0F, localObjectBaseData2.jdField_a_of_type_Float, localObjectBaseData2.jdField_b_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsSweepGradient.setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
        localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsSweepGradient);
        break label337;
        this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter = null;
        break label372;
        localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setMaskFilter(null);
        break label402;
        this.jdField_a_of_type_ArrayOfInt = new int[] { localObjectBaseData2.jdField_b_of_type_Int, localObjectBaseData2.jdField_a_of_type_Int };
        this.jdField_a_of_type_AndroidGraphicsSweepGradient = new SweepGradient(localObjectBaseData2.jdField_a_of_type_Float, localObjectBaseData2.jdField_b_of_type_Float, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat);
        this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(localObjectBaseData2.jdField_l_of_type_Float + localObjectBaseData2.jdField_h_of_type_Float - 5.0F, localObjectBaseData2.jdField_a_of_type_Float, localObjectBaseData2.jdField_b_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsSweepGradient.setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
        localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsSweepGradient);
        break label488;
        localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setMaskFilter(null);
        break label518;
        localObjectBaseData2.aC = ((localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + localObjectBaseData2.jdField_i_of_type_Float) * 2.0F / 3.6F);
        break label3072;
        localObjectBaseData2.x = (localObjectBaseData2.aG - localObjectBaseData2.aC);
        localObjectBaseData2.z = (localObjectBaseData2.jdField_b_of_type_Float + localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + localObjectBaseData2.jdField_i_of_type_Float);
        localObjectBaseData2.A = (localObjectBaseData2.jdField_a_of_type_Float + localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + localObjectBaseData2.jdField_i_of_type_Float);
        localObjectBaseData2.y = localObjectBaseData2.aF;
        break label3341;
        localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      }
      localObjectBaseData2.aK = (f1 / localObjectBaseData2.jdField_c_of_type_Float);
      localObjectBaseData2.aJ = (localObjectBaseData2.aK * localObjectBaseData2.jdField_c_of_type_Float);
      localObjectBaseData2.aJ = localObjectBaseData2.aM;
      localObjectBaseData2.aO = localObjectBaseData2.aQ;
      localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setTextSize(localObjectBaseData2.aJ * localObjectBaseData2.bg);
      localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
      int k;
      String str;
      boolean bool;
      if (localObjectBaseData2.jdField_a_of_type_Boolean)
      {
        localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setFakeBoldText(true);
        if (localObjectBaseData2.aV == 0.0F) {
          break label4684;
        }
        localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setShadowLayer(localObjectBaseData2.aX, 0.0F, localObjectBaseData2.aY, localObjectBaseData2.jdField_m_of_type_Int);
        paramCanvas.drawText(localObjectBaseData2.jdField_g_of_type_JavaLangString, localObjectBaseData2.aF, localObjectBaseData2.aG, localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint);
        i = localObjectBaseData2.jdField_f_of_type_JavaLangString.length();
        if (i >= 9) {
          break label4699;
        }
        paramCanvas.drawText(localObjectBaseData2.jdField_f_of_type_JavaLangString, localObjectBaseData2.aF, localObjectBaseData2.aG - localObjectBaseData2.aU - (f9 - f2), localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint);
        localObjectBaseData2.jdField_k_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.bc * 255.0F));
        f1 = localObjectBaseData2.aG + localObjectBaseData2.aT * localObjectBaseData2.bg;
        f2 = localObjectBaseData2.aF + localObjectBaseData2.bf;
        f3 = f1 + localObjectBaseData2.bd * localObjectBaseData2.bg;
        f4 = f2 + (float)(localObjectBaseData2.be * localObjectBaseData2.bg * Math.cos(localObjectBaseData2.ba * 3.141592653589793D / 180.0D));
        f5 = f3 + (float)(localObjectBaseData2.be * localObjectBaseData2.bg * Math.sin(localObjectBaseData2.ba * 3.141592653589793D / 180.0D));
        if (localObjectBaseData2.bc >= 0.2D) {
          paramCanvas.drawLine(f4, f5, f2, f3, localObjectBaseData2.jdField_k_of_type_AndroidGraphicsPaint);
        }
        if (localObjectBaseData2.bc >= 0.5D) {
          paramCanvas.drawLine(f2, f3, f2, f1, localObjectBaseData2.jdField_k_of_type_AndroidGraphicsPaint);
        }
        localObjectBaseData2.jdField_l_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.bc * 255.0F));
        paramCanvas.drawCircle(f4, f5, localObjectBaseData2.bh, localObjectBaseData2.jdField_l_of_type_AndroidGraphicsPaint);
        k = j;
        if (localObjectBaseData2.bk <= 0.0F) {
          break label6522;
        }
        if (!localObjectBaseData2.jdField_a_of_type_Boolean)
        {
          k = j;
          if (!localObjectBaseData2.jdField_c_of_type_Boolean) {
            break label6522;
          }
        }
        k = j;
        if (localObjectBaseData2.jdField_e_of_type_Boolean) {
          break label6522;
        }
        if (!localObjectBaseData2.jdField_f_of_type_Boolean) {
          break label6462;
        }
        if ((TextUtils.isEmpty(localObjectBaseData2.jdField_h_of_type_JavaLangString)) || (TextUtils.isEmpty(localObjectBaseData2.jdField_i_of_type_JavaLangString))) {
          break label6456;
        }
        i = 1;
        k = j;
        if (i == 0) {
          break label6522;
        }
        i = 0;
        j = this.jdField_a_of_type_Aodo.a.a();
        if (!localObjectBaseData2.jdField_f_of_type_Boolean) {
          break label6491;
        }
        k = i;
        if (j == 3) {
          break label6522;
        }
        localObject1 = this.jdField_a_of_type_Aodo.a;
        localObject2 = localObjectBaseData2.jdField_h_of_type_JavaLangString;
        str = localObjectBaseData2.jdField_i_of_type_JavaLangString;
        aoed localaoed = new aoed(this, localObjectBaseData2);
        if (TextUtils.isEmpty(localObjectBaseData2.jdField_c_of_type_JavaLangString)) {
          break label6485;
        }
        bool = true;
        ((axqp)localObject1).a((String)localObject2, str, localaoed, bool);
      }
      for (int i = 0;; i = k)
      {
        m += 1;
        j = i;
        break;
        localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setFakeBoldText(false);
        break label4137;
        localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        break label4171;
        str = localObjectBaseData2.jdField_f_of_type_JavaLangString.substring(0, 7);
        localObject2 = localObjectBaseData2.jdField_f_of_type_JavaLangString.substring(7, i);
        localObject1 = localObject2;
        if (((String)localObject2).length() > 7) {
          localObject1 = ((String)localObject2).substring(0, 6) + "...";
        }
        localObject2 = new Rect();
        localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.getTextBounds((String)localObject1, 0, ((String)localObject1).length(), (Rect)localObject2);
        f1 = localObjectBaseData2.aU;
        i = (int)(((Rect)localObject2).bottom - ((Rect)localObject2).top + f1);
        paramCanvas.drawText((String)localObject1, localObjectBaseData2.aF, localObjectBaseData2.aG - (f9 - f2), localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint);
        i = (int)(i + (f9 - f2 + 20.0F));
        paramCanvas.drawText(str, localObjectBaseData2.aF, localObjectBaseData2.aG - i, localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint);
        break label4247;
        if ((!localObjectBaseData2.jdField_f_of_type_Boolean) || (localObjectBaseData2.aV <= 0.0F) || (localObjectBaseData2.jdField_e_of_type_Boolean) || (i != 2)) {
          break label4473;
        }
        localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.aV * 255.0F));
        localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setStrokeWidth(localObjectBaseData2.aI);
        localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setStrokeWidth(localObjectBaseData2.aH);
        localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.aV * 255.0F));
        if ((localObjectBaseData2.jdField_a_of_type_Boolean) && (localObjectBaseData2.C != 0.0F))
        {
          localObjectBaseData2.aC = ((localObjectBaseData2.B * localObjectBaseData2.C + localObjectBaseData2.E) * 2.0F / 3.6F);
          if (localObjectBaseData2.aC > localObjectBaseData2.aD) {
            localObjectBaseData2.aC = localObjectBaseData2.aD;
          }
          if (localObjectBaseData2.aC < localObjectBaseData2.aE) {
            localObjectBaseData2.aC = localObjectBaseData2.aE;
          }
          localObjectBaseData2.aF = (localObjectBaseData2.jdField_a_of_type_Float - localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float - localObjectBaseData2.jdField_i_of_type_Float - localObjectBaseData2.aS);
          localObjectBaseData2.aG = (localObjectBaseData2.jdField_b_of_type_Float + localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + localObjectBaseData2.jdField_i_of_type_Float + localObjectBaseData2.aT * localObjectBaseData2.bg);
          if ((!localObjectBaseData2.jdField_a_of_type_Boolean) || (!localObjectBaseData2.jdField_f_of_type_Boolean) || (localObjectBaseData2.C == 0.0F)) {
            break label5607;
          }
          localObjectBaseData2.aF = (localObjectBaseData2.jdField_a_of_type_Float - localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float - localObjectBaseData2.jdField_i_of_type_Float - localObjectBaseData2.aS - aoec.jdField_e_of_type_Int);
          localObjectBaseData2.x = (localObjectBaseData2.jdField_b_of_type_Float + localObjectBaseData2.B * localObjectBaseData2.C + localObjectBaseData2.E);
          localObjectBaseData2.z = (localObjectBaseData2.aG + localObjectBaseData2.aC);
          localObjectBaseData2.A = (localObjectBaseData2.jdField_a_of_type_Float + localObjectBaseData2.B * localObjectBaseData2.C + localObjectBaseData2.E);
          localObjectBaseData2.y = localObjectBaseData2.aF;
          f4 = localObjectBaseData2.jdField_a_of_type_Float;
          f5 = localObjectBaseData2.L;
          f6 = localObjectBaseData2.ai;
          f7 = localObjectBaseData2.bQ;
          f8 = localObjectBaseData2.bI;
          f9 = localObjectBaseData2.bJ;
          if ((TextUtils.isEmpty(localObjectBaseData2.jdField_f_of_type_JavaLangString)) || (TextUtils.isEmpty(localObjectBaseData2.jdField_g_of_type_JavaLangString))) {
            break label4473;
          }
          localObjectBaseData2.jdField_g_of_type_JavaLangString = localObjectBaseData2.jdField_g_of_type_JavaLangString.toUpperCase();
          localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setTextSize(localObjectBaseData2.aO * localObjectBaseData2.bg);
          localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
          if (localObjectBaseData2.aV == 0.0F) {
            break label5692;
          }
          localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setShadowLayer(localObjectBaseData2.aX, 0.0F, localObjectBaseData2.aY, localObjectBaseData2.jdField_m_of_type_Int);
        }
        for (;;)
        {
          localObject1 = localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.getFontMetrics();
          f2 = localObjectBaseData2.aG + ((Paint.FontMetrics)localObject1).top;
          f1 = localObjectBaseData2.aG;
          f3 = ((Paint.FontMetrics)localObject1).bottom + f1;
          if (localObjectBaseData2.aK != 0.0F) {
            break label5719;
          }
          f10 = localObjectBaseData2.y;
          f1 = localObjectBaseData2.aJ;
          localObjectBaseData2.jdField_a_of_type_AndroidTextTextPaint.setTextSize(localObjectBaseData2.bg * f1);
          while (localObjectBaseData2.jdField_a_of_type_AndroidTextTextPaint.measureText(localObjectBaseData2.jdField_f_of_type_JavaLangString) > f4 + f5 + f6 + f7 - f8 - 4.0F * f9 - f10)
          {
            f1 -= 1.0F;
            localObjectBaseData2.jdField_a_of_type_AndroidTextTextPaint.setTextSize(localObjectBaseData2.bg * f1);
          }
          localObjectBaseData2.aC = ((localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + localObjectBaseData2.jdField_i_of_type_Float) * 2.0F / 3.6F);
          break;
          localObjectBaseData2.x = (localObjectBaseData2.aG - localObjectBaseData2.aC);
          localObjectBaseData2.z = (localObjectBaseData2.jdField_b_of_type_Float + localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + localObjectBaseData2.jdField_i_of_type_Float);
          localObjectBaseData2.A = (localObjectBaseData2.jdField_a_of_type_Float + localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + localObjectBaseData2.jdField_i_of_type_Float);
          localObjectBaseData2.y = localObjectBaseData2.aF;
          break label5297;
          localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        }
        localObjectBaseData2.aK = (f1 / localObjectBaseData2.jdField_c_of_type_Float);
        localObjectBaseData2.aJ = (localObjectBaseData2.aK * localObjectBaseData2.jdField_c_of_type_Float);
        localObjectBaseData2.aJ = localObjectBaseData2.aM;
        localObjectBaseData2.aO = localObjectBaseData2.aQ;
        localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setTextSize(localObjectBaseData2.aJ * localObjectBaseData2.bg);
        localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
        long l1;
        long l2;
        if (localObjectBaseData2.jdField_a_of_type_Boolean)
        {
          localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setFakeBoldText(true);
          if (localObjectBaseData2.aV == 0.0F) {
            break label6389;
          }
          localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setShadowLayer(localObjectBaseData2.aX, 0.0F, localObjectBaseData2.aY, localObjectBaseData2.jdField_m_of_type_Int);
          i = localObjectBaseData2.jdField_f_of_type_JavaLangString.length();
          k = (int)(f3 - f2);
          if (i < 9) {
            break label6404;
          }
          str = localObjectBaseData2.jdField_f_of_type_JavaLangString.substring(0, 7);
          localObject2 = localObjectBaseData2.jdField_f_of_type_JavaLangString.substring(7, i);
          localObject1 = localObject2;
          if (((String)localObject2).length() > 7) {
            localObject1 = ((String)localObject2).substring(0, 6) + "...";
          }
          localObject2 = new Rect();
          localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.getTextBounds(str, 0, str.length(), (Rect)localObject2);
          l1 = ((Rect)localObject2).bottom - ((Rect)localObject2).top;
          paramCanvas.drawText(str, localObjectBaseData2.aF, localObjectBaseData2.aG + (float)l1, localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint);
          localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.getTextBounds((String)localObject1, 0, ((String)localObject1).length(), (Rect)localObject2);
          l2 = ((Rect)localObject2).bottom - ((Rect)localObject2).top;
          paramCanvas.drawText((String)localObject1, localObjectBaseData2.aF, localObjectBaseData2.aG + (float)l2 + (float)l1 + 20.0F, localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint);
        }
        for (f1 = (float)(l1 + l2 + 20L);; f1 = f3 - f2 + localObjectBaseData2.aU)
        {
          localObject1 = new Rect();
          localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.getTextBounds(localObjectBaseData2.jdField_g_of_type_JavaLangString, 0, localObjectBaseData2.jdField_g_of_type_JavaLangString.length(), (Rect)localObject1);
          paramCanvas.drawText(localObjectBaseData2.jdField_g_of_type_JavaLangString, localObjectBaseData2.aF, f1 + localObjectBaseData2.aG + (((Rect)localObject1).bottom - ((Rect)localObject1).top) + 20.0F, localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint);
          localObjectBaseData2.jdField_k_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.bc * 255.0F));
          f1 = localObjectBaseData2.aG - localObjectBaseData2.aT * localObjectBaseData2.bg;
          f2 = localObjectBaseData2.aF + localObjectBaseData2.bf;
          f3 = f1 - localObjectBaseData2.bd * localObjectBaseData2.bg;
          f4 = f2 + (float)(localObjectBaseData2.be * localObjectBaseData2.bg * Math.cos(localObjectBaseData2.ba * 3.141592653589793D / 180.0D));
          f5 = f3 - (float)(localObjectBaseData2.be * localObjectBaseData2.bg * Math.sin(localObjectBaseData2.ba * 3.141592653589793D / 180.0D));
          if (localObjectBaseData2.bc >= 0.2D) {
            paramCanvas.drawLine(f4, f5, f2, f3, localObjectBaseData2.jdField_k_of_type_AndroidGraphicsPaint);
          }
          if (localObjectBaseData2.bc >= 0.5D) {
            paramCanvas.drawLine(f2, f3, f2, f1, localObjectBaseData2.jdField_k_of_type_AndroidGraphicsPaint);
          }
          localObjectBaseData2.jdField_l_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.bc * 255.0F));
          paramCanvas.drawCircle(f4, f5, localObjectBaseData2.bh, localObjectBaseData2.jdField_l_of_type_AndroidGraphicsPaint);
          break;
          localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setFakeBoldText(false);
          break label5802;
          localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
          break label5836;
          localObject1 = localObjectBaseData2.jdField_f_of_type_JavaLangString;
          f1 = localObjectBaseData2.aF;
          f4 = localObjectBaseData2.aG;
          paramCanvas.drawText((String)localObject1, f1, k + f4, localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint);
        }
        i = 0;
        break label4552;
        if (!TextUtils.isEmpty(localObjectBaseData2.jdField_h_of_type_JavaLangString))
        {
          i = 1;
          break label4552;
        }
        i = 0;
        break label4552;
        bool = false;
        break label4643;
        k = i;
        if (j != 2)
        {
          this.jdField_a_of_type_Aodo.a.a(2, localObjectBaseData2.jdField_h_of_type_JavaLangString, false);
          k = i;
        }
      }
    }
    label337:
    label372:
    label6389:
    this.jdField_a_of_type_Aodo.a.a();
    label402:
    label488:
    this.jdField_a_of_type_Aodo.a.a();
    label518:
    label3341:
    label3620:
    label3678:
    label3942:
    label5607:
    return;
  }
  
  private void a(ObjectBaseData paramObjectBaseData)
  {
    if ((paramObjectBaseData == null) || (paramObjectBaseData.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(paramObjectBaseData.jdField_e_of_type_JavaLangString))) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramObjectBaseData.jdField_e_of_type_JavaLangString, paramObjectBaseData);
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
        ((Activity)getContext()).overridePendingTransition(2130771997, 0);
      }
      bcef.b(null, "dc00898", "", "", "0X800899A", "0X800899A", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ObjectSurfaceView", 1, "start QQBrowserActivity catch an Exception.", paramString);
    }
  }
  
  private void a(List<ObjectBaseData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((ObjectBaseData)paramList.next());
      }
    }
  }
  
  private void b(ObjectBaseData paramObjectBaseData)
  {
    int i;
    if (paramObjectBaseData != null) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
        {
          ObjectBaseData localObjectBaseData = (ObjectBaseData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          if (localObjectBaseData != null)
          {
            if ((!localObjectBaseData.jdField_e_of_type_JavaLangString.equals(paramObjectBaseData.jdField_e_of_type_JavaLangString)) || (localObjectBaseData.jdField_e_of_type_Boolean != paramObjectBaseData.jdField_e_of_type_Boolean)) {
              break label94;
            }
            return;
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(i);
          break label94;
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramObjectBaseData);
        return;
      }
      catch (Exception paramObjectBaseData)
      {
        QLog.e("ObjectSurfaceView", 1, "addObjectData", paramObjectBaseData);
      }
      return;
      label94:
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
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ObjectSurfaceView", 1, "start QQBrowserActivity catch an Exception.", paramString);
    }
  }
  
  private void c()
  {
    setZOrderOnTop(true);
    this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setFormat(-2);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("ObjectSurfaceViewAnimationThread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_b_of_type_AndroidOsHandlerThread = new HandlerThread("ObjectSurfaceViewDrawThread");
    this.jdField_b_of_type_AndroidOsHandlerThread.start();
    this.jdField_b_of_type_AndroidOsHandler = new Handler(this.jdField_b_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  private void d()
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
          if (!this.jdField_a_of_type_Boolean) {
            continue;
          }
          localObject1 = localCanvas;
          localObject3 = localCanvas;
          QLog.d("ObjectSurfaceView", 1, "clearCanvas");
        }
      }
      catch (Exception localException4)
      {
        Canvas localCanvas;
        localObject3 = localObject1;
        QLog.e("ObjectSurfaceView", 1, "doDraw catch an exception.", localException4);
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
          QLog.e("ObjectSurfaceView", 1, "doDraw finally catch an exception.", localException1);
          return;
        }
      }
      finally
      {
        if (localObject3 == null) {
          break label166;
        }
      }
      try
      {
        this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(localCanvas);
        return;
      }
      catch (Exception localException2)
      {
        QLog.e("ObjectSurfaceView", 1, "doDraw finally catch an exception.", localException2);
        return;
      }
      localObject1 = localCanvas;
      localObject3 = localCanvas;
      a(localCanvas);
      localObject1 = localCanvas;
      localObject3 = localCanvas;
      QLog.d("ObjectSurfaceView", 1, "drawCanvas");
    }
    try
    {
      this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(localObject3);
      label166:
      throw localObject2;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        QLog.e("ObjectSurfaceView", 1, "doDraw finally catch an exception.", localException3);
      }
    }
  }
  
  public void a()
  {
    float f1;
    int i;
    int j;
    Object localObject2;
    int k;
    Object localObject1;
    aodj localaodj;
    RectF localRectF;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if (a() == null)
      {
        if (this.jdField_a_of_type_JavaUtilList.get(0) != null) {}
        for (f1 = ((aodj)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Float;; f1 = 0.0F)
        {
          i = 1;
          for (j = 0; i < this.jdField_a_of_type_JavaUtilList.size(); j = k)
          {
            localObject2 = (aodj)this.jdField_a_of_type_JavaUtilList.get(i);
            k = j;
            if (localObject2 != null)
            {
              k = j;
              if (((aodj)localObject2).jdField_a_of_type_Float > f1) {
                k = i;
              }
            }
            if ((localObject2 != null) && (QLog.isColorLevel()))
            {
              localObject1 = amtj.a(2131706798);
              if (!TextUtils.isEmpty(((aodj)localObject2).jdField_a_of_type_JavaLangString)) {
                localObject1 = ((aodj)localObject2).jdField_a_of_type_JavaLangString;
              }
              QLog.d("ObjectSurfaceView", 2, "name = " + (String)localObject1 + ",confidence = " + ((aodj)localObject2).jdField_a_of_type_Float + ",faceId = " + ((aodj)localObject2).jdField_a_of_type_Int + ",isTmpFace = " + ((aodj)localObject2).jdField_e_of_type_Boolean);
            }
            i += 1;
          }
        }
        localObject1 = (aodj)this.jdField_a_of_type_JavaUtilList.get(j);
        if (localObject1 != null) {
          ((aodj)localObject1).jdField_a_of_type_Boolean = true;
        }
      }
      j = 0;
      if (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        localaodj = (aodj)this.jdField_a_of_type_JavaUtilList.get(j);
        if (localaodj != null)
        {
          localRectF = localaodj.a();
          i = 0;
          if (i >= this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()) {
            break label1496;
          }
          localObject2 = (ObjectBaseData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          if ((localObject2 != null) && (((ObjectBaseData)localObject2).jdField_e_of_type_JavaLangString.equals(localaodj.jdField_a_of_type_JavaLangString)) && (((ObjectBaseData)localObject2).jdField_e_of_type_Boolean == localaodj.jdField_e_of_type_Boolean)) {
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      k = i;
      if (!localaodj.jdField_e_of_type_Boolean)
      {
        localObject1 = localObject2;
        k = i;
        if (i == 0)
        {
          localObject1 = localObject2;
          k = i;
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(localaodj.jdField_a_of_type_Int)))
          {
            localObject2 = (ObjectBaseData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(localaodj.jdField_a_of_type_Int));
            localObject1 = localObject2;
            k = i;
            if (localObject2 != null)
            {
              b((ObjectBaseData)localObject2);
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(localaodj.jdField_a_of_type_Int));
              k = 1;
              localObject1 = localObject2;
            }
          }
        }
      }
      if (k == 0)
      {
        localObject1 = new aodz(getContext());
        ((ObjectBaseData)localObject1).jdField_e_of_type_Boolean = localaodj.jdField_e_of_type_Boolean;
        ((ObjectBaseData)localObject1).jdField_e_of_type_JavaLangString = localaodj.jdField_a_of_type_JavaLangString;
        if (!localaodj.jdField_e_of_type_Boolean)
        {
          ((ObjectBaseData)localObject1).jdField_a_of_type_Boolean = localaodj.jdField_a_of_type_Boolean;
          if (QLog.isColorLevel()) {
            QLog.d("ObjectSurfaceView", 2, "1=" + ((ObjectBaseData)localObject1).jdField_a_of_type_Boolean);
          }
          ((ObjectBaseData)localObject1).jdField_d_of_type_JavaLangString = localaodj.jdField_b_of_type_JavaLangString;
          ((ObjectBaseData)localObject1).jdField_f_of_type_JavaLangString = localaodj.jdField_a_of_type_JavaLangString;
          ((ObjectBaseData)localObject1).jdField_b_of_type_JavaLangString = localaodj.jdField_f_of_type_JavaLangString;
          ((ObjectBaseData)localObject1).jdField_f_of_type_Boolean = localaodj.jdField_b_of_type_Boolean;
          ((ObjectBaseData)localObject1).jdField_g_of_type_Boolean = localaodj.jdField_c_of_type_Boolean;
          ((ObjectBaseData)localObject1).jdField_a_of_type_AndroidGraphicsRectF = localRectF;
          ((ObjectBaseData)localObject1).jdField_a_of_type_JavaLangString = localaodj.jdField_h_of_type_JavaLangString;
          ((ObjectBaseData)localObject1).jdField_c_of_type_JavaLangString = localaodj.jdField_g_of_type_JavaLangString;
          ((ObjectBaseData)localObject1).jdField_h_of_type_JavaLangString = localaodj.jdField_d_of_type_JavaLangString;
          ((ObjectBaseData)localObject1).jdField_i_of_type_JavaLangString = localaodj.jdField_e_of_type_JavaLangString;
          if ((!((ObjectBaseData)localObject1).jdField_d_of_type_Boolean) && (QLog.isColorLevel()))
          {
            ((ObjectBaseData)localObject1).jdField_d_of_type_Boolean = true;
            QLog.d("ObjectSurfaceView", 2, "isMainFace = " + ((ObjectBaseData)localObject1).jdField_a_of_type_Boolean + ", fNCH = " + ((ObjectBaseData)localObject1).jdField_f_of_type_JavaLangString + ", faceID = " + ((ObjectBaseData)localObject1).jdField_e_of_type_JavaLangString + ", isStar = " + ((ObjectBaseData)localObject1).jdField_f_of_type_Boolean + ", isActivate = " + ((ObjectBaseData)localObject1).jdField_g_of_type_Boolean + ", fCTitleText = " + ((ObjectBaseData)localObject1).jdField_h_of_type_JavaLangString + ", fCContentText = " + ((ObjectBaseData)localObject1).jdField_i_of_type_JavaLangString + ", url = " + ((ObjectBaseData)localObject1).jdField_b_of_type_JavaLangString + ", imgUrl = " + ((ObjectBaseData)localObject1).jdField_a_of_type_JavaLangString + ", wikiUrl = " + ((ObjectBaseData)localObject1).jdField_c_of_type_JavaLangString);
          }
        }
        b((ObjectBaseData)localObject1);
      }
      for (;;)
      {
        ((ObjectBaseData)localObject1).jdField_a_of_type_AndroidGraphicsRectF = localRectF;
        ((ObjectBaseData)localObject1).jdField_g_of_type_JavaLangString = localaodj.jdField_c_of_type_JavaLangString;
        if (((ObjectBaseData)localObject1).jdField_a_of_type_Boolean)
        {
          i = 0;
          for (;;)
          {
            if (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
            {
              localObject2 = (ObjectBaseData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
              if ((localObject2 != null) && (!((ObjectBaseData)localObject2).jdField_e_of_type_JavaLangString.equals(((ObjectBaseData)localObject1).jdField_e_of_type_JavaLangString)) && (!((ObjectBaseData)localObject2).jdField_f_of_type_Boolean) && (((ObjectBaseData)localObject2).jdField_a_of_type_Boolean)) {
                ((ObjectBaseData)localObject2).jdField_a_of_type_Boolean = false;
              }
              i += 1;
              continue;
              i += 1;
              break;
            }
          }
        }
        if (localRectF != null)
        {
          f1 = localRectF.centerX();
          float f2 = localRectF.centerY();
          if ((Math.abs(f1 - ((ObjectBaseData)localObject1).jdField_a_of_type_Float) > aoec.jdField_j_of_type_Int) || (Math.abs(f2 - ((ObjectBaseData)localObject1).jdField_b_of_type_Float) > aoec.jdField_j_of_type_Int))
          {
            ((ObjectBaseData)localObject1).jdField_a_of_type_Float = f1;
            ((ObjectBaseData)localObject1).jdField_b_of_type_Float = f2;
          }
          QLog.d("ObjectSurfaceView", 1, "centerX = " + f1 + ", centerY = " + f2);
          f1 = (float)Math.sqrt(localRectF.width() * localRectF.width() + localRectF.height() * localRectF.height());
          f1 = Math.min(((ObjectBaseData)localObject1).K, f1 / 2.0F);
          this.jdField_a_of_type_Float = 1.0F;
          QLog.d("ObjectSurfaceView", 1, "scale = " + this.jdField_a_of_type_Float + ",scanningData.scale = " + ((ObjectBaseData)localObject1).jdField_c_of_type_Float + ", trueRadius = " + f1 + ", iBCRadiusFix = " + ((ObjectBaseData)localObject1).O);
        }
        if (this.jdField_b_of_type_Boolean) {
          if (Math.abs(((ObjectBaseData)localObject1).jdField_c_of_type_Float - this.jdField_a_of_type_Float) >= 0.03D)
          {
            ((ObjectBaseData)localObject1).b();
            ((ObjectBaseData)localObject1).a(this.jdField_a_of_type_Float);
          }
        }
        for (;;)
        {
          j += 1;
          break;
          ((ObjectBaseData)localObject1).b();
          ((ObjectBaseData)localObject1).a(this.jdField_a_of_type_Float);
        }
        i = 0;
        if (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
        {
          localObject1 = (ObjectBaseData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          j = 0;
          label1278:
          if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label1487;
          }
          localObject2 = (aodj)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((localObject2 == null) || (localObject1 == null) || (!((ObjectBaseData)localObject1).jdField_e_of_type_JavaLangString.equals(((aodj)localObject2).jdField_a_of_type_JavaLangString)) || (((ObjectBaseData)localObject1).jdField_e_of_type_Boolean != ((aodj)localObject2).jdField_e_of_type_Boolean)) {}
        }
        label1487:
        for (j = 1;; j = 0)
        {
          if (j == 0)
          {
            a((ObjectBaseData)localObject1);
            this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(i);
            QLog.d("ckwkenvencai", 1, "remove2");
          }
          i += 1;
          break;
          j += 1;
          break label1278;
          this.jdField_a_of_type_Boolean = false;
          if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0))
          {
            this.jdField_b_of_type_Boolean = true;
            this.jdField_b_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
          }
          if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0) {
            this.jdField_b_of_type_Boolean = false;
          }
          return;
          b();
          QLog.e("ObjectSurfaceView", 1, "lost the face data.");
          this.jdField_a_of_type_Aodo.a.a();
          this.jdField_a_of_type_Aodo.a.a();
          return;
        }
      }
      label1496:
      i = 0;
      localObject2 = null;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Aodo.a.a();
    this.jdField_a_of_type_Aodo.a.a();
    QLog.d("ObjectSurfaceView", 1, "clear the animation and face data.");
  }
  
  public void setFaceData(List<aodj> paramList)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      a();
      return;
    }
    catch (Exception paramList)
    {
      QLog.e("ObjectSurfaceView", 1, "setFaceData catch an exception.", paramList);
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ObjectSurfaceView", 2, "surfaceChanged");
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ObjectSurfaceView", 2, "surfaceCreated");
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    b();
    if (QLog.isColorLevel()) {
      QLog.d("ObjectSurfaceView", 2, "surfaceDestroyed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ObjectSurfaceView
 * JD-Core Version:    0.7.0.1
 */