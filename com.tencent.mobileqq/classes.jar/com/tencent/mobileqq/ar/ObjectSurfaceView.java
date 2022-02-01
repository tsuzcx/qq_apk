package com.tencent.mobileqq.ar;

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
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.olympic.activity.ARTipsManager;
import com.tencent.mobileqq.statistics.ReportController;
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
  public FaceUIController a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ObjectSurfaceView.1(this);
  private List<DrawView2.FaceData> jdField_a_of_type_JavaUtilList;
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
    return paramFloat2 + 360.0F - paramFloat1;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private long a(ObjectBaseData paramObjectBaseData)
  {
    if ((paramObjectBaseData.jdField_f_of_type_Boolean) && (paramObjectBaseData.aV > 0.0F) && (!paramObjectBaseData.jdField_e_of_type_Boolean) && (!TextUtils.isEmpty(paramObjectBaseData.jdField_f_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramObjectBaseData.jdField_g_of_type_JavaLangString)))
    {
      long l2 = a(getContext(), 10.0F) + 0L + 32L;
      long l1;
      if (paramObjectBaseData.jdField_f_of_type_JavaLangString.length() < 8) {
        l1 = 60L;
      }
      for (;;)
      {
        return l2 + l1;
        if (paramObjectBaseData.jdField_f_of_type_JavaLangString.length() == 8)
        {
          l1 = 52L;
        }
        else
        {
          if (paramObjectBaseData.jdField_f_of_type_JavaLangString.length() <= 8) {
            break;
          }
          l1 = 160L;
        }
      }
      return l2;
    }
    return 0L;
  }
  
  private ObjectBaseData a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
    {
      localObjectBaseData1 = (ObjectBaseData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
      if ((localObjectBaseData1 != null) && (localObjectBaseData1.jdField_a_of_type_Boolean) && (localObjectBaseData1.jdField_f_of_type_Boolean) && (!localObjectBaseData1.jdField_e_of_type_Boolean)) {
        break label62;
      }
      i += 1;
    }
    ObjectBaseData localObjectBaseData1 = null;
    label62:
    ObjectBaseData localObjectBaseData2 = localObjectBaseData1;
    if (localObjectBaseData1 == null)
    {
      localObjectBaseData2 = localObjectBaseData1;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        do
        {
          localObjectBaseData2 = localObjectBaseData1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObjectBaseData2 = (ObjectBaseData)((Map.Entry)localIterator.next()).getValue();
        } while ((localObjectBaseData2 == null) || (!localObjectBaseData2.jdField_a_of_type_Boolean) || (!localObjectBaseData2.jdField_f_of_type_Boolean) || (localObjectBaseData2.jdField_e_of_type_Boolean));
      }
    }
    return localObjectBaseData2;
  }
  
  private void a(Canvas paramCanvas)
  {
    Canvas localCanvas = paramCanvas;
    if (localCanvas != null)
    {
      ObjectBaseData localObjectBaseData1 = a();
      int k = 0;
      int m = 1;
      while (k < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
      {
        ObjectBaseData localObjectBaseData2 = (ObjectBaseData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(k);
        if (localObjectBaseData2 == null) {
          return;
        }
        Object localObject2;
        if (!localObjectBaseData2.jdField_h_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidOsHandler.post(new ObjectSurfaceView.2(this, localObjectBaseData2, localObjectBaseData1));
          if ((localObjectBaseData2.jdField_a_of_type_Boolean) && (!localObjectBaseData2.jdField_b_of_type_Boolean) && (localObjectBaseData2.jdField_g_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean)) {
            if (!TextUtils.isEmpty(localObjectBaseData2.jdField_d_of_type_JavaLangString))
            {
              if (!this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(localObjectBaseData2.jdField_d_of_type_JavaLangString))
              {
                localObject1 = localObjectBaseData2.jdField_d_of_type_JavaLangString;
                localObject2 = localObjectBaseData2.jdField_b_of_type_JavaLangString;
                this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ObjectSurfaceView.3(this, (String)localObject1, (String)localObject2), 4000L);
              }
            }
            else if (localObjectBaseData2.jdField_g_of_type_Boolean) {
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ObjectSurfaceView.4(this, localObjectBaseData2), 4000L);
            }
          }
        }
        localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setColor(localObjectBaseData2.jdField_e_of_type_Int);
        localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(localObjectBaseData2.jdField_i_of_type_Float);
        if (((localObjectBaseData2.jdField_a_of_type_Boolean) || (localObjectBaseData2.jdField_c_of_type_Boolean)) && (localObjectBaseData2.jdField_f_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean))
        {
          localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.v * 255.0F));
        }
        else
        {
          localObject1 = localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint;
          d1 = localObjectBaseData2.v * 255.0F;
          Double.isNaN(d1);
          ((Paint)localObject1).setAlpha((int)(d1 * 0.5D));
        }
        float f1 = localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + localObjectBaseData2.jdField_i_of_type_Float;
        Object localObject1 = new RectF(localObjectBaseData2.jdField_a_of_type_Float - f1, localObjectBaseData2.jdField_b_of_type_Float - f1, localObjectBaseData2.jdField_a_of_type_Float + f1, localObjectBaseData2.jdField_b_of_type_Float + f1);
        if ((localObjectBaseData2.jdField_e_of_type_Int != -1) && (localObjectBaseData2.jdField_a_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean))
        {
          this.jdField_a_of_type_AndroidGraphicsSweepGradient = new SweepGradient(localObjectBaseData2.jdField_a_of_type_Float, localObjectBaseData2.jdField_b_of_type_Float, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat);
          this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(localObjectBaseData2.jdField_j_of_type_Float + localObjectBaseData2.jdField_h_of_type_Float - 5.0F, localObjectBaseData2.jdField_a_of_type_Float, localObjectBaseData2.jdField_b_of_type_Float);
          this.jdField_a_of_type_AndroidGraphicsSweepGradient.setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
          localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsSweepGradient);
        }
        else
        {
          localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
        }
        if (localObjectBaseData2.aA != 0.0F) {
          this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter = new BlurMaskFilter(localObjectBaseData2.aB * localObjectBaseData2.aA, BlurMaskFilter.Blur.SOLID);
        } else {
          this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter = null;
        }
        if (this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter != null)
        {
          localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setMaskFilter(this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter);
          localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
        }
        else
        {
          localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setMaskFilter(null);
        }
        paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.jdField_j_of_type_Float + localObjectBaseData2.jdField_h_of_type_Float, a(localObjectBaseData2.jdField_j_of_type_Float + localObjectBaseData2.jdField_h_of_type_Float, localObjectBaseData2.jdField_k_of_type_Float + localObjectBaseData2.jdField_h_of_type_Float), false, localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint);
        if ((localObjectBaseData2.jdField_e_of_type_Int != -1) && (localObjectBaseData2.jdField_a_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean))
        {
          this.jdField_a_of_type_ArrayOfInt = new int[] { localObjectBaseData2.jdField_b_of_type_Int, localObjectBaseData2.jdField_a_of_type_Int };
          this.jdField_a_of_type_AndroidGraphicsSweepGradient = new SweepGradient(localObjectBaseData2.jdField_a_of_type_Float, localObjectBaseData2.jdField_b_of_type_Float, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat);
          this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(localObjectBaseData2.jdField_l_of_type_Float + localObjectBaseData2.jdField_h_of_type_Float - 5.0F, localObjectBaseData2.jdField_a_of_type_Float, localObjectBaseData2.jdField_b_of_type_Float);
          this.jdField_a_of_type_AndroidGraphicsSweepGradient.setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
          localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsSweepGradient);
        }
        else
        {
          localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
        }
        if (this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter != null)
        {
          localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setMaskFilter(this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter);
          localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
        }
        else
        {
          localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint.setMaskFilter(null);
        }
        paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.jdField_l_of_type_Float + localObjectBaseData2.jdField_h_of_type_Float, a(localObjectBaseData2.jdField_l_of_type_Float + localObjectBaseData2.jdField_h_of_type_Float, localObjectBaseData2.jdField_m_of_type_Float + localObjectBaseData2.jdField_h_of_type_Float), false, localObjectBaseData2.jdField_a_of_type_AndroidGraphicsPaint);
        float f5;
        double d2;
        float f2;
        float f3;
        float f4;
        float f6;
        float f7;
        if ((localObjectBaseData2.u > 0.0F) && ((localObjectBaseData2.jdField_a_of_type_Boolean) || (localObjectBaseData2.jdField_c_of_type_Boolean)) && (localObjectBaseData2.jdField_f_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean))
        {
          f5 = localObjectBaseData2.jdField_i_of_type_Float;
          d1 = localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + f5;
          d2 = localObjectBaseData2.o + localObjectBaseData2.jdField_h_of_type_Float;
          Double.isNaN(d2);
          d2 = Math.cos(d2 * 3.141592653589793D / 180.0D);
          Double.isNaN(d1);
          double d3 = localObjectBaseData2.jdField_a_of_type_Float;
          Double.isNaN(d3);
          localObjectBaseData2.q = ((float)(d1 * d2 + d3));
          d1 = localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + f5;
          d2 = localObjectBaseData2.o + localObjectBaseData2.jdField_h_of_type_Float;
          Double.isNaN(d2);
          d2 = Math.sin(d2 * 3.141592653589793D / 180.0D);
          Double.isNaN(d1);
          d3 = localObjectBaseData2.jdField_b_of_type_Float;
          Double.isNaN(d3);
          localObjectBaseData2.r = ((float)(d1 * d2 + d3));
          f2 = localObjectBaseData2.p + localObjectBaseData2.jdField_h_of_type_Float;
          f3 = f2 + 120.0F;
          f4 = f3 + 120.0F;
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
          d1 = localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float;
          d2 = f1;
          Double.isNaN(d2);
          d2 = d2 * 3.141592653589793D / 180.0D;
          d3 = Math.cos(d2);
          Double.isNaN(d1);
          double d4 = localObjectBaseData2.q;
          Double.isNaN(d4);
          f1 = (float)(d1 * d3 + d4);
          d1 = localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float;
          d2 = Math.sin(d2);
          Double.isNaN(d1);
          d3 = localObjectBaseData2.r;
          Double.isNaN(d3);
          f4 = (float)(d1 * d2 + d3);
          d1 = localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float;
          d2 = f2;
          Double.isNaN(d2);
          d2 = d2 * 3.141592653589793D / 180.0D;
          d3 = Math.cos(d2);
          Double.isNaN(d1);
          d4 = localObjectBaseData2.q;
          Double.isNaN(d4);
          f2 = (float)(d1 * d3 + d4);
          d1 = localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float;
          d2 = Math.sin(d2);
          Double.isNaN(d1);
          d3 = localObjectBaseData2.r;
          Double.isNaN(d3);
          f6 = (float)(d1 * d2 + d3);
          d1 = localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float;
          d2 = f3;
          Double.isNaN(d2);
          d2 = d2 * 3.141592653589793D / 180.0D;
          d3 = Math.cos(d2);
          Double.isNaN(d1);
          d4 = localObjectBaseData2.q;
          Double.isNaN(d4);
          f3 = (float)(d1 * d3 + d4);
          d1 = localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float;
          d2 = Math.sin(d2);
          Double.isNaN(d1);
          d3 = localObjectBaseData2.r;
          Double.isNaN(d3);
          f7 = (float)(d1 * d2 + d3);
          localObject1 = new Path();
          ((Path)localObject1).moveTo(f1, f4);
          ((Path)localObject1).lineTo(f2, f6);
          ((Path)localObject1).lineTo(f3, f7);
          ((Path)localObject1).close();
          localObjectBaseData2.jdField_b_of_type_AndroidGraphicsPaint.setColor(localObjectBaseData2.jdField_c_of_type_Int);
          localObjectBaseData2.jdField_b_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.u * 255.0F));
          paramCanvas.drawPath((Path)localObject1, localObjectBaseData2.jdField_b_of_type_AndroidGraphicsPaint);
          d1 = localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + f5;
          d2 = localObjectBaseData2.p + localObjectBaseData2.jdField_h_of_type_Float;
          Double.isNaN(d2);
          d2 = Math.cos(d2 * 3.141592653589793D / 180.0D);
          Double.isNaN(d1);
          d3 = localObjectBaseData2.jdField_a_of_type_Float;
          Double.isNaN(d3);
          localObjectBaseData2.s = ((float)(d1 * d2 + d3));
          d1 = localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + f5;
          d2 = localObjectBaseData2.p + localObjectBaseData2.jdField_h_of_type_Float;
          Double.isNaN(d2);
          d2 = Math.sin(d2 * 3.141592653589793D / 180.0D);
          Double.isNaN(d1);
          d3 = localObjectBaseData2.jdField_b_of_type_Float;
          Double.isNaN(d3);
          localObjectBaseData2.t = ((float)(d1 * d2 + d3));
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
          d1 = localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float;
          d2 = f1;
          Double.isNaN(d2);
          d2 = d2 * 3.141592653589793D / 180.0D;
          d3 = Math.cos(d2);
          Double.isNaN(d1);
          d4 = localObjectBaseData2.s;
          Double.isNaN(d4);
          f1 = (float)(d1 * d3 + d4);
          d1 = localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float;
          d2 = Math.sin(d2);
          Double.isNaN(d1);
          d3 = localObjectBaseData2.t;
          Double.isNaN(d3);
          f4 = (float)(d1 * d2 + d3);
          d1 = localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float;
          d2 = f2;
          Double.isNaN(d2);
          d2 = d2 * 3.141592653589793D / 180.0D;
          d3 = Math.cos(d2);
          Double.isNaN(d1);
          d4 = localObjectBaseData2.s;
          Double.isNaN(d4);
          f2 = (float)(d1 * d3 + d4);
          d1 = localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float;
          d2 = Math.sin(d2);
          Double.isNaN(d1);
          d3 = localObjectBaseData2.t;
          Double.isNaN(d3);
          f5 = (float)(d1 * d2 + d3);
          d1 = localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float;
          d2 = f3;
          Double.isNaN(d2);
          d2 = d2 * 3.141592653589793D / 180.0D;
          d3 = Math.cos(d2);
          Double.isNaN(d1);
          d4 = localObjectBaseData2.s;
          Double.isNaN(d4);
          f3 = (float)(d1 * d3 + d4);
          d1 = localObjectBaseData2.n * localObjectBaseData2.jdField_g_of_type_Float;
          d2 = Math.sin(d2);
          Double.isNaN(d1);
          d3 = localObjectBaseData2.t;
          Double.isNaN(d3);
          f6 = (float)(d1 * d2 + d3);
          ((Path)localObject1).reset();
          ((Path)localObject1).moveTo(f1, f4);
          ((Path)localObject1).lineTo(f2, f5);
          ((Path)localObject1).lineTo(f3, f6);
          ((Path)localObject1).close();
          localObjectBaseData2.jdField_b_of_type_AndroidGraphicsPaint.setColor(localObjectBaseData2.jdField_d_of_type_Int);
          localObjectBaseData2.jdField_b_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.u * 255.0F));
          localObject2 = localObjectBaseData2.jdField_b_of_type_AndroidGraphicsPaint;
          localCanvas = paramCanvas;
          localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
        }
        if ((localObjectBaseData2.J > 0.0F) && ((localObjectBaseData2.jdField_a_of_type_Boolean) || (localObjectBaseData2.jdField_c_of_type_Boolean)) && (localObjectBaseData2.jdField_f_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean))
        {
          localObjectBaseData2.jdField_c_of_type_AndroidGraphicsPaint.setColor(localObjectBaseData2.jdField_f_of_type_Int);
          localObjectBaseData2.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(localObjectBaseData2.E);
          localObject1 = localObjectBaseData2.jdField_c_of_type_AndroidGraphicsPaint;
          d1 = localObjectBaseData2.J * 255.0F;
          Double.isNaN(d1);
          ((Paint)localObject1).setAlpha((int)(d1 * 0.4D));
          f1 = localObjectBaseData2.B * localObjectBaseData2.C + localObjectBaseData2.E;
          localObject1 = new RectF(localObjectBaseData2.jdField_a_of_type_Float - f1, localObjectBaseData2.jdField_b_of_type_Float - f1, localObjectBaseData2.jdField_a_of_type_Float + f1, localObjectBaseData2.jdField_b_of_type_Float + f1);
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.F + localObjectBaseData2.D, a(localObjectBaseData2.F + localObjectBaseData2.D, localObjectBaseData2.G + localObjectBaseData2.D), false, localObjectBaseData2.jdField_c_of_type_AndroidGraphicsPaint);
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.H + localObjectBaseData2.D, a(localObjectBaseData2.H + localObjectBaseData2.D, localObjectBaseData2.I + localObjectBaseData2.D), false, localObjectBaseData2.jdField_c_of_type_AndroidGraphicsPaint);
        }
        localObjectBaseData2.jdField_d_of_type_AndroidGraphicsPaint.setColor(localObjectBaseData2.jdField_g_of_type_Int);
        localObjectBaseData2.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth(localObjectBaseData2.P);
        localObject1 = localObjectBaseData2.jdField_d_of_type_AndroidGraphicsPaint;
        double d1 = localObjectBaseData2.W * 255.0F;
        Double.isNaN(d1);
        ((Paint)localObject1).setAlpha((int)(d1 * 0.3D));
        f1 = localObjectBaseData2.L * localObjectBaseData2.M + localObjectBaseData2.P;
        localObject1 = new RectF(localObjectBaseData2.jdField_a_of_type_Float - f1, localObjectBaseData2.jdField_b_of_type_Float - f1, localObjectBaseData2.jdField_a_of_type_Float + f1, localObjectBaseData2.jdField_b_of_type_Float + f1);
        paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.Q + localObjectBaseData2.N, a(localObjectBaseData2.Q + localObjectBaseData2.N, localObjectBaseData2.R + localObjectBaseData2.N), false, localObjectBaseData2.jdField_d_of_type_AndroidGraphicsPaint);
        paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.U + localObjectBaseData2.N, a(localObjectBaseData2.U + localObjectBaseData2.N, localObjectBaseData2.V + localObjectBaseData2.N), false, localObjectBaseData2.jdField_d_of_type_AndroidGraphicsPaint);
        paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.S + localObjectBaseData2.N, a(localObjectBaseData2.S + localObjectBaseData2.N, localObjectBaseData2.T + localObjectBaseData2.N), false, localObjectBaseData2.jdField_d_of_type_AndroidGraphicsPaint);
        if ((localObjectBaseData2.af > 0.0F) && ((localObjectBaseData2.jdField_a_of_type_Boolean) || (localObjectBaseData2.jdField_c_of_type_Boolean)) && (localObjectBaseData2.jdField_f_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean))
        {
          localObjectBaseData2.jdField_e_of_type_AndroidGraphicsPaint.setColor(localObjectBaseData2.jdField_h_of_type_Int);
          localObjectBaseData2.jdField_e_of_type_AndroidGraphicsPaint.setStrokeWidth(localObjectBaseData2.Y);
          localObjectBaseData2.jdField_e_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.af * 255.0F));
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.Z + localObjectBaseData2.N, a(localObjectBaseData2.Z + localObjectBaseData2.N, localObjectBaseData2.aa + localObjectBaseData2.N), false, localObjectBaseData2.jdField_e_of_type_AndroidGraphicsPaint);
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.ad + localObjectBaseData2.N, a(localObjectBaseData2.ad + localObjectBaseData2.N, localObjectBaseData2.ae + localObjectBaseData2.N), false, localObjectBaseData2.jdField_e_of_type_AndroidGraphicsPaint);
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.ab + localObjectBaseData2.N, a(localObjectBaseData2.ab + localObjectBaseData2.N, localObjectBaseData2.ac + localObjectBaseData2.N), false, localObjectBaseData2.jdField_e_of_type_AndroidGraphicsPaint);
        }
        if ((localObjectBaseData2.aj > 0.0F) && ((localObjectBaseData2.jdField_a_of_type_Boolean) || (localObjectBaseData2.jdField_c_of_type_Boolean)) && (localObjectBaseData2.jdField_f_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean))
        {
          localObjectBaseData2.jdField_f_of_type_AndroidGraphicsPaint.setColor(localObjectBaseData2.jdField_i_of_type_Int);
          localObjectBaseData2.jdField_f_of_type_AndroidGraphicsPaint.setStrokeWidth(localObjectBaseData2.ai);
          localObject1 = localObjectBaseData2.jdField_f_of_type_AndroidGraphicsPaint;
          d1 = localObjectBaseData2.aj * 255.0F;
          Double.isNaN(d1);
          ((Paint)localObject1).setAlpha((int)(d1 * 0.1D));
          f1 = localObjectBaseData2.ai / 2.0F;
          localCanvas.drawCircle(localObjectBaseData2.jdField_a_of_type_Float, localObjectBaseData2.jdField_b_of_type_Float, localObjectBaseData2.ag * localObjectBaseData2.ah + f1, localObjectBaseData2.jdField_f_of_type_AndroidGraphicsPaint);
        }
        if ((localObjectBaseData2.aw > 0.0F) && ((localObjectBaseData2.jdField_a_of_type_Boolean) || (localObjectBaseData2.jdField_c_of_type_Boolean)) && (localObjectBaseData2.jdField_f_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean))
        {
          localObjectBaseData2.jdField_g_of_type_AndroidGraphicsPaint.setColor(localObjectBaseData2.jdField_j_of_type_Int);
          localObjectBaseData2.jdField_g_of_type_AndroidGraphicsPaint.setStrokeWidth(localObjectBaseData2.an);
          localObject1 = localObjectBaseData2.jdField_g_of_type_AndroidGraphicsPaint;
          d1 = localObjectBaseData2.aw * 255.0F;
          Double.isNaN(d1);
          ((Paint)localObject1).setAlpha((int)(d1 * 0.3D));
          f1 = localObjectBaseData2.am * localObjectBaseData2.ak + localObjectBaseData2.an;
          localObject1 = new RectF(localObjectBaseData2.jdField_a_of_type_Float - f1, localObjectBaseData2.jdField_b_of_type_Float - f1, localObjectBaseData2.jdField_a_of_type_Float + f1, localObjectBaseData2.jdField_b_of_type_Float + f1);
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.aq + localObjectBaseData2.al, a(localObjectBaseData2.aq + localObjectBaseData2.al, localObjectBaseData2.ar + localObjectBaseData2.al), false, localObjectBaseData2.jdField_g_of_type_AndroidGraphicsPaint);
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.ao + localObjectBaseData2.al, a(localObjectBaseData2.ao + localObjectBaseData2.al, localObjectBaseData2.ap + localObjectBaseData2.al), false, localObjectBaseData2.jdField_g_of_type_AndroidGraphicsPaint);
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.au + localObjectBaseData2.al, a(localObjectBaseData2.au + localObjectBaseData2.al, localObjectBaseData2.av + localObjectBaseData2.al), false, localObjectBaseData2.jdField_g_of_type_AndroidGraphicsPaint);
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.as + localObjectBaseData2.al, a(localObjectBaseData2.as + localObjectBaseData2.al, localObjectBaseData2.at + localObjectBaseData2.al), false, localObjectBaseData2.jdField_g_of_type_AndroidGraphicsPaint);
        }
        if ((localObjectBaseData2.az > 0.0F) && ((localObjectBaseData2.jdField_a_of_type_Boolean) || (localObjectBaseData2.jdField_c_of_type_Boolean)) && (localObjectBaseData2.jdField_f_of_type_Boolean) && (!localObjectBaseData2.jdField_e_of_type_Boolean))
        {
          localObjectBaseData2.jdField_h_of_type_AndroidGraphicsPaint.setColor(localObjectBaseData2.jdField_k_of_type_Int);
          localObjectBaseData2.jdField_h_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.az * 255.0F));
          localCanvas.drawCircle(localObjectBaseData2.jdField_a_of_type_Float, localObjectBaseData2.jdField_b_of_type_Float, localObjectBaseData2.ay * localObjectBaseData2.ax + 0.0F, localObjectBaseData2.jdField_h_of_type_AndroidGraphicsPaint);
        }
        int i;
        if (localObjectBaseData2.jdField_b_of_type_Float < localObjectBaseData2.jdField_f_of_type_Float + (float)a(localObjectBaseData2) + 80.0F) {
          i = 2;
        } else {
          i = 1;
        }
        float f8;
        float f9;
        float f10;
        String str;
        if ((localObjectBaseData2.jdField_f_of_type_Boolean) && (localObjectBaseData2.aV > 0.0F) && (!localObjectBaseData2.jdField_e_of_type_Boolean) && (i == 1))
        {
          localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.aV * 255.0F));
          localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setStrokeWidth(localObjectBaseData2.aI);
          localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setStrokeWidth(localObjectBaseData2.aH);
          localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.aV * 255.0F));
          if ((localObjectBaseData2.jdField_a_of_type_Boolean) && (localObjectBaseData2.C != 0.0F)) {
            localObjectBaseData2.aC = ((localObjectBaseData2.B * localObjectBaseData2.C + localObjectBaseData2.E) * 2.0F / 3.6F);
          } else {
            localObjectBaseData2.aC = ((localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + localObjectBaseData2.jdField_i_of_type_Float) * 2.0F / 3.6F);
          }
          if (localObjectBaseData2.aC > localObjectBaseData2.aD) {
            localObjectBaseData2.aC = localObjectBaseData2.aD;
          }
          if (localObjectBaseData2.aC < localObjectBaseData2.aE) {
            localObjectBaseData2.aC = localObjectBaseData2.aE;
          }
          localObjectBaseData2.aF = (localObjectBaseData2.jdField_a_of_type_Float - localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float - localObjectBaseData2.jdField_i_of_type_Float - localObjectBaseData2.aS);
          localObjectBaseData2.aG = (localObjectBaseData2.jdField_b_of_type_Float - localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float - localObjectBaseData2.jdField_i_of_type_Float - localObjectBaseData2.aT * localObjectBaseData2.bg);
          if ((localObjectBaseData2.jdField_a_of_type_Boolean) && (localObjectBaseData2.jdField_f_of_type_Boolean) && (localObjectBaseData2.C != 0.0F))
          {
            localObjectBaseData2.aF = (localObjectBaseData2.jdField_a_of_type_Float - localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float - localObjectBaseData2.jdField_i_of_type_Float - localObjectBaseData2.aS - ObjectBaseData.Dip2PxCache.jdField_e_of_type_Int);
            localObjectBaseData2.x = (localObjectBaseData2.aG - localObjectBaseData2.aC);
            localObjectBaseData2.z = (localObjectBaseData2.jdField_b_of_type_Float + localObjectBaseData2.B * localObjectBaseData2.C + localObjectBaseData2.E);
            localObjectBaseData2.A = (localObjectBaseData2.jdField_a_of_type_Float + localObjectBaseData2.B * localObjectBaseData2.C + localObjectBaseData2.E);
            localObjectBaseData2.y = localObjectBaseData2.aF;
          }
          else
          {
            localObjectBaseData2.x = (localObjectBaseData2.aG - localObjectBaseData2.aC);
            localObjectBaseData2.z = (localObjectBaseData2.jdField_b_of_type_Float + localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + localObjectBaseData2.jdField_i_of_type_Float);
            localObjectBaseData2.A = (localObjectBaseData2.jdField_a_of_type_Float + localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + localObjectBaseData2.jdField_i_of_type_Float);
            localObjectBaseData2.y = localObjectBaseData2.aF;
          }
          f4 = localObjectBaseData2.jdField_a_of_type_Float;
          f5 = localObjectBaseData2.L;
          f6 = localObjectBaseData2.ai;
          f7 = localObjectBaseData2.bQ;
          f8 = localObjectBaseData2.bI;
          f9 = localObjectBaseData2.bJ;
          if ((!TextUtils.isEmpty(localObjectBaseData2.jdField_f_of_type_JavaLangString)) && (!TextUtils.isEmpty(localObjectBaseData2.jdField_g_of_type_JavaLangString)))
          {
            localObjectBaseData2.jdField_g_of_type_JavaLangString = localObjectBaseData2.jdField_g_of_type_JavaLangString.toUpperCase();
            localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setTextSize(localObjectBaseData2.aO * localObjectBaseData2.bg);
            localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
            if (localObjectBaseData2.aV != 0.0F) {
              localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setShadowLayer(localObjectBaseData2.aX, 0.0F, localObjectBaseData2.aY, localObjectBaseData2.jdField_m_of_type_Int);
            } else {
              localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
            }
            localObject1 = localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.getFontMetrics();
            f2 = localObjectBaseData2.aG + ((Paint.FontMetrics)localObject1).top;
            f3 = localObjectBaseData2.aG + ((Paint.FontMetrics)localObject1).bottom;
            if (localObjectBaseData2.aK == 0.0F)
            {
              f10 = localObjectBaseData2.y;
              f1 = localObjectBaseData2.aJ;
              localObjectBaseData2.jdField_a_of_type_AndroidTextTextPaint.setTextSize(localObjectBaseData2.bg * f1);
              while (localObjectBaseData2.jdField_a_of_type_AndroidTextTextPaint.measureText(localObjectBaseData2.jdField_f_of_type_JavaLangString) > f4 + f5 + f6 + f7 - f8 - f9 * 4.0F - f10)
              {
                f1 -= 1.0F;
                localObjectBaseData2.jdField_a_of_type_AndroidTextTextPaint.setTextSize(localObjectBaseData2.bg * f1);
              }
              localObjectBaseData2.aK = (f1 / localObjectBaseData2.jdField_c_of_type_Float);
            }
            localObjectBaseData2.aJ = (localObjectBaseData2.aK * localObjectBaseData2.jdField_c_of_type_Float);
            localObjectBaseData2.aJ = localObjectBaseData2.aM;
            localObjectBaseData2.aO = localObjectBaseData2.aQ;
            localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setTextSize(localObjectBaseData2.aJ * localObjectBaseData2.bg);
            localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
            if (localObjectBaseData2.jdField_a_of_type_Boolean) {
              localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setFakeBoldText(true);
            } else {
              localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setFakeBoldText(false);
            }
            if (localObjectBaseData2.aV != 0.0F) {
              localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setShadowLayer(localObjectBaseData2.aX, 0.0F, localObjectBaseData2.aY, localObjectBaseData2.jdField_m_of_type_Int);
            } else {
              localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
            }
            localCanvas.drawText(localObjectBaseData2.jdField_g_of_type_JavaLangString, localObjectBaseData2.aF, localObjectBaseData2.aG, localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint);
            i = localObjectBaseData2.jdField_f_of_type_JavaLangString.length();
            if (i < 9)
            {
              localCanvas.drawText(localObjectBaseData2.jdField_f_of_type_JavaLangString, localObjectBaseData2.aF, localObjectBaseData2.aG - localObjectBaseData2.aU - (f3 - f2), localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint);
            }
            else
            {
              str = localObjectBaseData2.jdField_f_of_type_JavaLangString.substring(0, 7);
              localObject2 = localObjectBaseData2.jdField_f_of_type_JavaLangString.substring(7, i);
              localObject1 = localObject2;
              if (((String)localObject2).length() > 7)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(((String)localObject2).substring(0, 6));
                ((StringBuilder)localObject1).append("...");
                localObject1 = ((StringBuilder)localObject1).toString();
              }
              localObject2 = new Rect();
              localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.getTextBounds((String)localObject1, 0, ((String)localObject1).length(), (Rect)localObject2);
              i = (int)(localObjectBaseData2.aU + (((Rect)localObject2).bottom - ((Rect)localObject2).top));
              f1 = localObjectBaseData2.aF;
              f4 = localObjectBaseData2.aG;
              f2 = f3 - f2;
              localCanvas.drawText((String)localObject1, f1, f4 - f2, localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint);
              i = (int)(i + (f2 + 20.0F));
              localCanvas.drawText(str, localObjectBaseData2.aF, localObjectBaseData2.aG - i, localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint);
            }
            localObjectBaseData2.jdField_k_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.bc * 255.0F));
            f1 = localObjectBaseData2.aG + localObjectBaseData2.aT * localObjectBaseData2.bg;
            f2 = localObjectBaseData2.aF + localObjectBaseData2.bf;
            f3 = f1 + localObjectBaseData2.bd * localObjectBaseData2.bg;
            d1 = localObjectBaseData2.be * localObjectBaseData2.bg;
            d2 = localObjectBaseData2.ba;
            Double.isNaN(d2);
            d2 = Math.cos(d2 * 3.141592653589793D / 180.0D);
            Double.isNaN(d1);
            f4 = f2 + (float)(d1 * d2);
            d1 = localObjectBaseData2.be * localObjectBaseData2.bg;
            d2 = localObjectBaseData2.ba;
            Double.isNaN(d2);
            d2 = Math.sin(d2 * 3.141592653589793D / 180.0D);
            Double.isNaN(d1);
            f5 = f3 + (float)(d1 * d2);
            if (localObjectBaseData2.bc >= 0.2D) {
              paramCanvas.drawLine(f4, f5, f2, f3, localObjectBaseData2.jdField_k_of_type_AndroidGraphicsPaint);
            }
            if (localObjectBaseData2.bc >= 0.5D) {
              paramCanvas.drawLine(f2, f3, f2, f1, localObjectBaseData2.jdField_k_of_type_AndroidGraphicsPaint);
            }
            localObjectBaseData2.jdField_l_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.bc * 255.0F));
            localCanvas.drawCircle(f4, f5, localObjectBaseData2.bh, localObjectBaseData2.jdField_l_of_type_AndroidGraphicsPaint);
          }
        }
        else if ((localObjectBaseData2.jdField_f_of_type_Boolean) && (localObjectBaseData2.aV > 0.0F) && (!localObjectBaseData2.jdField_e_of_type_Boolean) && (i == 2))
        {
          localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.aV * 255.0F));
          localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setStrokeWidth(localObjectBaseData2.aI);
          localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setStrokeWidth(localObjectBaseData2.aH);
          localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.aV * 255.0F));
          if ((localObjectBaseData2.jdField_a_of_type_Boolean) && (localObjectBaseData2.C != 0.0F)) {
            localObjectBaseData2.aC = ((localObjectBaseData2.B * localObjectBaseData2.C + localObjectBaseData2.E) * 2.0F / 3.6F);
          } else {
            localObjectBaseData2.aC = ((localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + localObjectBaseData2.jdField_i_of_type_Float) * 2.0F / 3.6F);
          }
          if (localObjectBaseData2.aC > localObjectBaseData2.aD) {
            localObjectBaseData2.aC = localObjectBaseData2.aD;
          }
          if (localObjectBaseData2.aC < localObjectBaseData2.aE) {
            localObjectBaseData2.aC = localObjectBaseData2.aE;
          }
          localObjectBaseData2.aF = (localObjectBaseData2.jdField_a_of_type_Float - localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float - localObjectBaseData2.jdField_i_of_type_Float - localObjectBaseData2.aS);
          localObjectBaseData2.aG = (localObjectBaseData2.jdField_b_of_type_Float + localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + localObjectBaseData2.jdField_i_of_type_Float + localObjectBaseData2.aT * localObjectBaseData2.bg);
          if ((localObjectBaseData2.jdField_a_of_type_Boolean) && (localObjectBaseData2.jdField_f_of_type_Boolean) && (localObjectBaseData2.C != 0.0F))
          {
            localObjectBaseData2.aF = (localObjectBaseData2.jdField_a_of_type_Float - localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float - localObjectBaseData2.jdField_i_of_type_Float - localObjectBaseData2.aS - ObjectBaseData.Dip2PxCache.jdField_e_of_type_Int);
            localObjectBaseData2.x = (localObjectBaseData2.jdField_b_of_type_Float + localObjectBaseData2.B * localObjectBaseData2.C + localObjectBaseData2.E);
            localObjectBaseData2.z = (localObjectBaseData2.aG + localObjectBaseData2.aC);
            localObjectBaseData2.A = (localObjectBaseData2.jdField_a_of_type_Float + localObjectBaseData2.B * localObjectBaseData2.C + localObjectBaseData2.E);
            localObjectBaseData2.y = localObjectBaseData2.aF;
          }
          else
          {
            localObjectBaseData2.x = (localObjectBaseData2.aG - localObjectBaseData2.aC);
            localObjectBaseData2.z = (localObjectBaseData2.jdField_b_of_type_Float + localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + localObjectBaseData2.jdField_i_of_type_Float);
            localObjectBaseData2.A = (localObjectBaseData2.jdField_a_of_type_Float + localObjectBaseData2.jdField_f_of_type_Float * localObjectBaseData2.jdField_g_of_type_Float + localObjectBaseData2.jdField_i_of_type_Float);
            localObjectBaseData2.y = localObjectBaseData2.aF;
          }
          f2 = localObjectBaseData2.jdField_a_of_type_Float;
          f3 = localObjectBaseData2.L;
          f4 = localObjectBaseData2.ai;
          f5 = localObjectBaseData2.bQ;
          f6 = localObjectBaseData2.bI;
          f7 = localObjectBaseData2.bJ;
          if ((!TextUtils.isEmpty(localObjectBaseData2.jdField_f_of_type_JavaLangString)) && (!TextUtils.isEmpty(localObjectBaseData2.jdField_g_of_type_JavaLangString)))
          {
            localObjectBaseData2.jdField_g_of_type_JavaLangString = localObjectBaseData2.jdField_g_of_type_JavaLangString.toUpperCase();
            localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setTextSize(localObjectBaseData2.aO * localObjectBaseData2.bg);
            localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
            if (localObjectBaseData2.aV != 0.0F) {
              localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setShadowLayer(localObjectBaseData2.aX, 0.0F, localObjectBaseData2.aY, localObjectBaseData2.jdField_m_of_type_Int);
            } else {
              localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
            }
            localObject1 = localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.getFontMetrics();
            f8 = localObjectBaseData2.aG;
            f9 = ((Paint.FontMetrics)localObject1).top;
            f10 = localObjectBaseData2.aG;
            float f11 = ((Paint.FontMetrics)localObject1).bottom;
            if (localObjectBaseData2.aK == 0.0F)
            {
              float f12 = localObjectBaseData2.y;
              f1 = localObjectBaseData2.aJ;
              localObjectBaseData2.jdField_a_of_type_AndroidTextTextPaint.setTextSize(localObjectBaseData2.bg * f1);
              while (localObjectBaseData2.jdField_a_of_type_AndroidTextTextPaint.measureText(localObjectBaseData2.jdField_f_of_type_JavaLangString) > f2 + f3 + f4 + f5 - f6 - f7 * 4.0F - f12)
              {
                f1 -= 1.0F;
                localObjectBaseData2.jdField_a_of_type_AndroidTextTextPaint.setTextSize(localObjectBaseData2.bg * f1);
              }
              localObjectBaseData2.aK = (f1 / localObjectBaseData2.jdField_c_of_type_Float);
            }
            localObjectBaseData2.aJ = (localObjectBaseData2.aK * localObjectBaseData2.jdField_c_of_type_Float);
            localObjectBaseData2.aJ = localObjectBaseData2.aM;
            localObjectBaseData2.aO = localObjectBaseData2.aQ;
            localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setTextSize(localObjectBaseData2.aJ * localObjectBaseData2.bg);
            localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
            if (localObjectBaseData2.jdField_a_of_type_Boolean) {
              localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setFakeBoldText(true);
            } else {
              localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setFakeBoldText(false);
            }
            if (localObjectBaseData2.aV != 0.0F) {
              localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setShadowLayer(localObjectBaseData2.aX, 0.0F, localObjectBaseData2.aY, localObjectBaseData2.jdField_m_of_type_Int);
            } else {
              localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
            }
            i = localObjectBaseData2.jdField_f_of_type_JavaLangString.length();
            f1 = f10 + f11 - (f8 + f9);
            int n = (int)f1;
            if (i >= 9)
            {
              str = localObjectBaseData2.jdField_f_of_type_JavaLangString.substring(0, 7);
              localObject2 = localObjectBaseData2.jdField_f_of_type_JavaLangString.substring(7, i);
              localObject1 = localObject2;
              if (((String)localObject2).length() > 7)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(((String)localObject2).substring(0, 6));
                ((StringBuilder)localObject1).append("...");
                localObject1 = ((StringBuilder)localObject1).toString();
              }
              localObject2 = new Rect();
              localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.getTextBounds(str, 0, str.length(), (Rect)localObject2);
              long l1 = ((Rect)localObject2).bottom - ((Rect)localObject2).top;
              f1 = localObjectBaseData2.aF;
              f2 = localObjectBaseData2.aG;
              f3 = (float)l1;
              localCanvas.drawText(str, f1, f2 + f3, localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint);
              localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint.getTextBounds((String)localObject1, 0, ((String)localObject1).length(), (Rect)localObject2);
              long l2 = ((Rect)localObject2).bottom - ((Rect)localObject2).top;
              localCanvas.drawText((String)localObject1, localObjectBaseData2.aF, localObjectBaseData2.aG + (float)l2 + f3 + 20.0F, localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint);
              f1 = (float)(l1 + l2 + 20L);
            }
            else
            {
              localCanvas.drawText(localObjectBaseData2.jdField_f_of_type_JavaLangString, localObjectBaseData2.aF, localObjectBaseData2.aG + n, localObjectBaseData2.jdField_i_of_type_AndroidGraphicsPaint);
              f1 = localObjectBaseData2.aU + f1;
            }
            localObject1 = new Rect();
            localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint.getTextBounds(localObjectBaseData2.jdField_g_of_type_JavaLangString, 0, localObjectBaseData2.jdField_g_of_type_JavaLangString.length(), (Rect)localObject1);
            localCanvas.drawText(localObjectBaseData2.jdField_g_of_type_JavaLangString, localObjectBaseData2.aF, localObjectBaseData2.aG + f1 + (((Rect)localObject1).bottom - ((Rect)localObject1).top) + 20.0F, localObjectBaseData2.jdField_j_of_type_AndroidGraphicsPaint);
            localObjectBaseData2.jdField_k_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.bc * 255.0F));
            f1 = localObjectBaseData2.aG - localObjectBaseData2.aT * localObjectBaseData2.bg;
            f2 = localObjectBaseData2.aF + localObjectBaseData2.bf;
            f3 = f1 - localObjectBaseData2.bd * localObjectBaseData2.bg;
            d1 = localObjectBaseData2.be * localObjectBaseData2.bg;
            d2 = localObjectBaseData2.ba;
            Double.isNaN(d2);
            d2 = Math.cos(d2 * 3.141592653589793D / 180.0D);
            Double.isNaN(d1);
            f4 = f2 + (float)(d1 * d2);
            d1 = localObjectBaseData2.be * localObjectBaseData2.bg;
            d2 = localObjectBaseData2.ba;
            Double.isNaN(d2);
            d2 = Math.sin(d2 * 3.141592653589793D / 180.0D);
            Double.isNaN(d1);
            f5 = f3 - (float)(d1 * d2);
            if (localObjectBaseData2.bc >= 0.2D) {
              paramCanvas.drawLine(f4, f5, f2, f3, localObjectBaseData2.jdField_k_of_type_AndroidGraphicsPaint);
            }
            if (localObjectBaseData2.bc >= 0.5D) {
              paramCanvas.drawLine(f2, f3, f2, f1, localObjectBaseData2.jdField_k_of_type_AndroidGraphicsPaint);
            }
            localObjectBaseData2.jdField_l_of_type_AndroidGraphicsPaint.setAlpha((int)(localObjectBaseData2.bc * 255.0F));
            localCanvas.drawCircle(f4, f5, localObjectBaseData2.bh, localObjectBaseData2.jdField_l_of_type_AndroidGraphicsPaint);
          }
        }
        if ((localObjectBaseData2.bk > 0.0F) && ((localObjectBaseData2.jdField_a_of_type_Boolean) || (localObjectBaseData2.jdField_c_of_type_Boolean)) && (!localObjectBaseData2.jdField_e_of_type_Boolean))
        {
          boolean bool;
          if (localObjectBaseData2.jdField_f_of_type_Boolean)
          {
            if ((!TextUtils.isEmpty(localObjectBaseData2.jdField_h_of_type_JavaLangString)) && (!TextUtils.isEmpty(localObjectBaseData2.jdField_i_of_type_JavaLangString))) {
              i = 1;
            } else {
              i = 0;
            }
          }
          else {
            bool = TextUtils.isEmpty(localObjectBaseData2.jdField_h_of_type_JavaLangString) ^ true;
          }
          if (bool)
          {
            int j = this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.a.a();
            if (localObjectBaseData2.jdField_f_of_type_Boolean)
            {
              if (j != 3) {
                this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.a.a(localObjectBaseData2.jdField_h_of_type_JavaLangString, localObjectBaseData2.jdField_i_of_type_JavaLangString, new ObjectSurfaceView.5(this, localObjectBaseData2), TextUtils.isEmpty(localObjectBaseData2.jdField_c_of_type_JavaLangString) ^ true);
              }
            }
            else if (j != 2) {
              this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.a.a(2, localObjectBaseData2.jdField_h_of_type_JavaLangString, false);
            }
            m = 0;
          }
        }
        k += 1;
      }
      if (m != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.a.a();
        this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.a.a();
      }
    }
  }
  
  private void a(ObjectBaseData paramObjectBaseData)
  {
    if ((paramObjectBaseData != null) && (!paramObjectBaseData.jdField_e_of_type_Boolean))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(paramObjectBaseData.jdField_e_of_type_JavaLangString)) {
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramObjectBaseData.jdField_e_of_type_JavaLangString, paramObjectBaseData);
    }
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (getContext() != null)) {
      try
      {
        Intent localIntent = new Intent(getContext(), QQBrowserActivity.class);
        localIntent.putExtra("url", paramString);
        localIntent.putExtra("finish_animation_up_down", true);
        getContext().startActivity(localIntent);
        if ((getContext() instanceof Activity)) {
          ((Activity)getContext()).overridePendingTransition(2130772011, 0);
        }
        ReportController.b(null, "dc00898", "", "", "0X800899A", "0X800899A", 0, 0, "", "", "", "");
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("ObjectSurfaceView", 1, "start QQBrowserActivity catch an Exception.", paramString);
      }
    }
  }
  
  private void a(List<ObjectBaseData> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
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
    if ((!TextUtils.isEmpty(paramString)) && (getContext() != null)) {
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
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: getfield 921	com/tencent/mobileqq/ar/ObjectSurfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   8: invokeinterface 958 1 0
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull +66 -> 81
    //   18: aload_3
    //   19: astore_1
    //   20: aload_3
    //   21: astore_2
    //   22: aload_3
    //   23: iconst_0
    //   24: getstatic 964	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   27: invokevirtual 968	android/graphics/Canvas:drawColor	(ILandroid/graphics/PorterDuff$Mode;)V
    //   30: aload_3
    //   31: astore_1
    //   32: aload_3
    //   33: astore_2
    //   34: aload_0
    //   35: getfield 912	com/tencent/mobileqq/ar/ObjectSurfaceView:jdField_a_of_type_Boolean	Z
    //   38: ifeq +20 -> 58
    //   41: aload_3
    //   42: astore_1
    //   43: aload_3
    //   44: astore_2
    //   45: ldc_w 880
    //   48: iconst_1
    //   49: ldc_w 970
    //   52: invokestatic 973	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: goto +26 -> 81
    //   58: aload_3
    //   59: astore_1
    //   60: aload_3
    //   61: astore_2
    //   62: aload_0
    //   63: aload_3
    //   64: invokespecial 975	com/tencent/mobileqq/ar/ObjectSurfaceView:a	(Landroid/graphics/Canvas;)V
    //   67: aload_3
    //   68: astore_1
    //   69: aload_3
    //   70: astore_2
    //   71: ldc_w 880
    //   74: iconst_1
    //   75: ldc_w 977
    //   78: invokestatic 973	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_3
    //   82: ifnull +59 -> 141
    //   85: aload_0
    //   86: getfield 921	com/tencent/mobileqq/ar/ObjectSurfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   89: aload_3
    //   90: invokeinterface 980 2 0
    //   95: return
    //   96: astore_1
    //   97: ldc_w 880
    //   100: iconst_1
    //   101: ldc_w 982
    //   104: aload_1
    //   105: invokestatic 887	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   108: return
    //   109: astore_2
    //   110: goto +32 -> 142
    //   113: astore_3
    //   114: aload_2
    //   115: astore_1
    //   116: ldc_w 880
    //   119: iconst_1
    //   120: ldc_w 984
    //   123: aload_3
    //   124: invokestatic 887	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   127: aload_2
    //   128: ifnull +13 -> 141
    //   131: aload_0
    //   132: getfield 921	com/tencent/mobileqq/ar/ObjectSurfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   135: aload_2
    //   136: invokeinterface 980 2 0
    //   141: return
    //   142: aload_1
    //   143: ifnull +28 -> 171
    //   146: aload_0
    //   147: getfield 921	com/tencent/mobileqq/ar/ObjectSurfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   150: aload_1
    //   151: invokeinterface 980 2 0
    //   156: goto +15 -> 171
    //   159: astore_1
    //   160: ldc_w 880
    //   163: iconst_1
    //   164: ldc_w 982
    //   167: aload_1
    //   168: invokestatic 887	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   171: aload_2
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	ObjectSurfaceView
    //   3	66	1	localObject1	Object
    //   96	9	1	localException1	Exception
    //   115	36	1	localCanvas1	Canvas
    //   159	9	1	localException2	Exception
    //   1	70	2	localObject2	Object
    //   109	63	2	localCanvas2	Canvas
    //   13	77	3	localCanvas3	Canvas
    //   113	11	3	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   85	95	96	java/lang/Exception
    //   131	141	96	java/lang/Exception
    //   4	14	109	finally
    //   22	30	109	finally
    //   34	41	109	finally
    //   45	55	109	finally
    //   62	67	109	finally
    //   71	81	109	finally
    //   116	127	109	finally
    //   4	14	113	java/lang/Exception
    //   22	30	113	java/lang/Exception
    //   34	41	113	java/lang/Exception
    //   45	55	113	java/lang/Exception
    //   62	67	113	java/lang/Exception
    //   71	81	113	java/lang/Exception
    //   146	156	159	java/lang/Exception
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      float f1;
      Object localObject2;
      int k;
      Object localObject3;
      if (a() == null)
      {
        if (this.jdField_a_of_type_JavaUtilList.get(0) != null) {
          f1 = ((DrawView2.FaceData)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Float;
        } else {
          f1 = 0.0F;
        }
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
            localObject1 = HardCodeUtil.a(2131707693);
            if (!TextUtils.isEmpty(((DrawView2.FaceData)localObject2).jdField_a_of_type_JavaLangString)) {
              localObject1 = ((DrawView2.FaceData)localObject2).jdField_a_of_type_JavaLangString;
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("name = ");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(",confidence = ");
            ((StringBuilder)localObject3).append(((DrawView2.FaceData)localObject2).jdField_a_of_type_Float);
            ((StringBuilder)localObject3).append(",faceId = ");
            ((StringBuilder)localObject3).append(((DrawView2.FaceData)localObject2).jdField_a_of_type_Int);
            ((StringBuilder)localObject3).append(",isTmpFace = ");
            ((StringBuilder)localObject3).append(((DrawView2.FaceData)localObject2).jdField_e_of_type_Boolean);
            QLog.d("ObjectSurfaceView", 2, ((StringBuilder)localObject3).toString());
          }
          i += 1;
        }
        localObject1 = (DrawView2.FaceData)this.jdField_a_of_type_JavaUtilList.get(j);
        if (localObject1 != null) {
          ((DrawView2.FaceData)localObject1).jdField_a_of_type_Boolean = true;
        }
      }
      int j = 0;
      while (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        DrawView2.FaceData localFaceData = (DrawView2.FaceData)this.jdField_a_of_type_JavaUtilList.get(j);
        if (localFaceData != null)
        {
          localObject3 = localFaceData.a();
          i = 0;
          while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
          {
            localObject2 = (ObjectBaseData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
            if ((localObject2 != null) && (((ObjectBaseData)localObject2).jdField_e_of_type_JavaLangString.equals(localFaceData.jdField_a_of_type_JavaLangString)) && (((ObjectBaseData)localObject2).jdField_e_of_type_Boolean == localFaceData.jdField_e_of_type_Boolean))
            {
              i = 1;
              break label417;
            }
            i += 1;
          }
          localObject2 = null;
          i = 0;
          label417:
          k = i;
          localObject1 = localObject2;
          if (!localFaceData.jdField_e_of_type_Boolean)
          {
            k = i;
            localObject1 = localObject2;
            if (i == 0)
            {
              k = i;
              localObject1 = localObject2;
              if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(localFaceData.jdField_a_of_type_Int)))
              {
                localObject2 = (ObjectBaseData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(localFaceData.jdField_a_of_type_Int));
                k = i;
                localObject1 = localObject2;
                if (localObject2 != null)
                {
                  b((ObjectBaseData)localObject2);
                  this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(localFaceData.jdField_a_of_type_Int));
                  k = 1;
                  localObject1 = localObject2;
                }
              }
            }
          }
          if (k == 0)
          {
            localObject1 = new MainObjectScanningData(getContext());
            ((ObjectBaseData)localObject1).jdField_e_of_type_Boolean = localFaceData.jdField_e_of_type_Boolean;
            ((ObjectBaseData)localObject1).jdField_e_of_type_JavaLangString = localFaceData.jdField_a_of_type_JavaLangString;
            if (!localFaceData.jdField_e_of_type_Boolean)
            {
              ((ObjectBaseData)localObject1).jdField_a_of_type_Boolean = localFaceData.jdField_a_of_type_Boolean;
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("1=");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).jdField_a_of_type_Boolean);
                QLog.d("ObjectSurfaceView", 2, ((StringBuilder)localObject2).toString());
              }
              ((ObjectBaseData)localObject1).jdField_d_of_type_JavaLangString = localFaceData.jdField_b_of_type_JavaLangString;
              ((ObjectBaseData)localObject1).jdField_f_of_type_JavaLangString = localFaceData.jdField_a_of_type_JavaLangString;
              ((ObjectBaseData)localObject1).jdField_b_of_type_JavaLangString = localFaceData.jdField_f_of_type_JavaLangString;
              ((ObjectBaseData)localObject1).jdField_f_of_type_Boolean = localFaceData.jdField_b_of_type_Boolean;
              ((ObjectBaseData)localObject1).jdField_g_of_type_Boolean = localFaceData.jdField_c_of_type_Boolean;
              ((ObjectBaseData)localObject1).jdField_a_of_type_AndroidGraphicsRectF = ((RectF)localObject3);
              ((ObjectBaseData)localObject1).jdField_a_of_type_JavaLangString = localFaceData.jdField_h_of_type_JavaLangString;
              ((ObjectBaseData)localObject1).jdField_c_of_type_JavaLangString = localFaceData.jdField_g_of_type_JavaLangString;
              ((ObjectBaseData)localObject1).jdField_h_of_type_JavaLangString = localFaceData.jdField_d_of_type_JavaLangString;
              ((ObjectBaseData)localObject1).jdField_i_of_type_JavaLangString = localFaceData.jdField_e_of_type_JavaLangString;
              if ((!((ObjectBaseData)localObject1).jdField_d_of_type_Boolean) && (QLog.isColorLevel()))
              {
                ((ObjectBaseData)localObject1).jdField_d_of_type_Boolean = true;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("isMainFace = ");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).jdField_a_of_type_Boolean);
                ((StringBuilder)localObject2).append(", fNCH = ");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).jdField_f_of_type_JavaLangString);
                ((StringBuilder)localObject2).append(", faceID = ");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).jdField_e_of_type_JavaLangString);
                ((StringBuilder)localObject2).append(", isStar = ");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).jdField_f_of_type_Boolean);
                ((StringBuilder)localObject2).append(", isActivate = ");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).jdField_g_of_type_Boolean);
                ((StringBuilder)localObject2).append(", fCTitleText = ");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).jdField_h_of_type_JavaLangString);
                ((StringBuilder)localObject2).append(", fCContentText = ");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).jdField_i_of_type_JavaLangString);
                ((StringBuilder)localObject2).append(", url = ");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).jdField_b_of_type_JavaLangString);
                ((StringBuilder)localObject2).append(", imgUrl = ");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).jdField_a_of_type_JavaLangString);
                ((StringBuilder)localObject2).append(", wikiUrl = ");
                ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).jdField_c_of_type_JavaLangString);
                QLog.d("ObjectSurfaceView", 2, ((StringBuilder)localObject2).toString());
              }
            }
            b((ObjectBaseData)localObject1);
          }
          ((ObjectBaseData)localObject1).jdField_a_of_type_AndroidGraphicsRectF = ((RectF)localObject3);
          ((ObjectBaseData)localObject1).jdField_g_of_type_JavaLangString = localFaceData.jdField_c_of_type_JavaLangString;
          if (((ObjectBaseData)localObject1).jdField_a_of_type_Boolean)
          {
            i = 0;
            while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
            {
              localObject2 = (ObjectBaseData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
              if ((localObject2 != null) && (!((ObjectBaseData)localObject2).jdField_e_of_type_JavaLangString.equals(((ObjectBaseData)localObject1).jdField_e_of_type_JavaLangString)) && (!((ObjectBaseData)localObject2).jdField_f_of_type_Boolean) && (((ObjectBaseData)localObject2).jdField_a_of_type_Boolean)) {
                ((ObjectBaseData)localObject2).jdField_a_of_type_Boolean = false;
              }
              i += 1;
            }
          }
          if (localObject3 != null)
          {
            f1 = ((RectF)localObject3).centerX();
            float f2 = ((RectF)localObject3).centerY();
            if ((Math.abs(f1 - ((ObjectBaseData)localObject1).jdField_a_of_type_Float) > ObjectBaseData.Dip2PxCache.jdField_j_of_type_Int) || (Math.abs(f2 - ((ObjectBaseData)localObject1).jdField_b_of_type_Float) > ObjectBaseData.Dip2PxCache.jdField_j_of_type_Int))
            {
              ((ObjectBaseData)localObject1).jdField_a_of_type_Float = f1;
              ((ObjectBaseData)localObject1).jdField_b_of_type_Float = f2;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("centerX = ");
            ((StringBuilder)localObject2).append(f1);
            ((StringBuilder)localObject2).append(", centerY = ");
            ((StringBuilder)localObject2).append(f2);
            QLog.d("ObjectSurfaceView", 1, ((StringBuilder)localObject2).toString());
            f1 = (float)Math.sqrt(((RectF)localObject3).width() * ((RectF)localObject3).width() + ((RectF)localObject3).height() * ((RectF)localObject3).height());
            f1 = Math.min(((ObjectBaseData)localObject1).K, f1 / 2.0F);
            this.jdField_a_of_type_Float = 1.0F;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("scale = ");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_Float);
            ((StringBuilder)localObject2).append(",scanningData.scale = ");
            ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).jdField_c_of_type_Float);
            ((StringBuilder)localObject2).append(", trueRadius = ");
            ((StringBuilder)localObject2).append(f1);
            ((StringBuilder)localObject2).append(", iBCRadiusFix = ");
            ((StringBuilder)localObject2).append(((ObjectBaseData)localObject1).O);
            QLog.d("ObjectSurfaceView", 1, ((StringBuilder)localObject2).toString());
          }
          if (this.jdField_b_of_type_Boolean)
          {
            if (Math.abs(((ObjectBaseData)localObject1).jdField_c_of_type_Float - this.jdField_a_of_type_Float) >= 0.03D)
            {
              ((ObjectBaseData)localObject1).b();
              ((ObjectBaseData)localObject1).a(this.jdField_a_of_type_Float);
            }
          }
          else
          {
            ((ObjectBaseData)localObject1).b();
            ((ObjectBaseData)localObject1).a(this.jdField_a_of_type_Float);
          }
        }
        j += 1;
      }
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
      {
        localObject1 = (ObjectBaseData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
        j = 0;
        while (j < this.jdField_a_of_type_JavaUtilList.size())
        {
          localObject2 = (DrawView2.FaceData)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((localObject2 != null) && (localObject1 != null) && (((ObjectBaseData)localObject1).jdField_e_of_type_JavaLangString.equals(((DrawView2.FaceData)localObject2).jdField_a_of_type_JavaLangString)) && (((ObjectBaseData)localObject1).jdField_e_of_type_Boolean == ((DrawView2.FaceData)localObject2).jdField_e_of_type_Boolean))
          {
            j = 1;
            break label1521;
          }
          j += 1;
        }
        j = 0;
        label1521:
        if (j == 0)
        {
          a((ObjectBaseData)localObject1);
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(i);
          QLog.d("ckwkenvencai", 1, "remove2");
        }
        i += 1;
      }
      this.jdField_a_of_type_Boolean = false;
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0))
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0) {
        this.jdField_b_of_type_Boolean = false;
      }
    }
    else
    {
      b();
      QLog.e("ObjectSurfaceView", 1, "lost the face data.");
      this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.a.a();
      this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.a.a();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.a.a();
    this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.a.a();
    QLog.d("ObjectSurfaceView", 1, "clear the animation and face data.");
  }
  
  public void setFaceData(List<DrawView2.FaceData> paramList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ObjectSurfaceView
 * JD-Core Version:    0.7.0.1
 */