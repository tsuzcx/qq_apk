package com.tencent.aelight.camera.aioeditor.takevideo.doodle.util;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.qphone.base.util.QLog;

public class GestureHelper
{
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int = 0;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private GestureHelper.ZoomItem jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int = 1;
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int = 2;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private final int jdField_d_of_type_Int = 3;
  private float jdField_e_of_type_Float;
  private final int jdField_e_of_type_Int = 4;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int = 0;
  private float jdField_g_of_type_Float;
  private int jdField_g_of_type_Int = -1;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m = 2.147484E+009F;
  private float n = 0.0F;
  
  private void a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem;
    paramMotionEvent.g = false;
    paramMotionEvent.h = false;
    this.jdField_f_of_type_Int = 0;
    a();
  }
  
  private void b(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_f_of_type_Int = 1;
    float f2 = paramMotionEvent.getX(0);
    float f1 = paramMotionEvent.getY(0);
    this.jdField_a_of_type_Float = f2;
    this.jdField_b_of_type_Float = f1;
    this.i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.l;
    this.j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.m;
    paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem;
    paramMotionEvent.g = false;
    paramMotionEvent.h = false;
    if ((b(paramMotionEvent, f2, f1)) && (paramBoolean))
    {
      this.jdField_f_of_type_Int = 3;
      this.k = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.j;
      this.l = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.k;
      f2 = (f2 - this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.l) / this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.a();
      f1 = (f1 - this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.m) / this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.a();
      this.jdField_c_of_type_Float = GestureUtil.a(f2, f1);
      this.jdField_d_of_type_Float = GestureUtil.b(f2, f1);
      this.jdField_e_of_type_Float = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_a_of_type_AndroidGraphicsPointF.x;
      this.jdField_f_of_type_Float = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_a_of_type_AndroidGraphicsPointF.y;
    }
  }
  
  private void c(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      b(paramMotionEvent, paramBoolean);
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.g = true;
    paramMotionEvent.getPointerCount();
    int i1 = this.jdField_f_of_type_Int;
    float f1;
    float f2;
    float f3;
    if (i1 == 1)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Float = paramMotionEvent.getX(0);
        this.jdField_b_of_type_Float = paramMotionEvent.getY(0);
        this.i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.l;
        this.j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.m;
        return;
      }
      f1 = paramMotionEvent.getX(0);
      f2 = this.jdField_a_of_type_Float;
      f3 = paramMotionEvent.getY(0);
      float f4 = this.jdField_b_of_type_Float;
      paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem;
      paramMotionEvent.l = (this.i + (f1 - f2) / paramMotionEvent.a());
      paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem;
      paramMotionEvent.m = (this.j + (f3 - f4) / paramMotionEvent.a());
      return;
    }
    if ((i1 == 3) && (paramBoolean))
    {
      f2 = (paramMotionEvent.getX() - this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.l) / this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.a();
      f3 = (paramMotionEvent.getY() - this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.m) / this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.a();
      f1 = GestureUtil.a(f2, f3);
      f2 = GestureUtil.b(f2, f3);
      paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem;
      paramMotionEvent.j = (this.k * (f1 / this.jdField_c_of_type_Float));
      paramMotionEvent.k = ((this.l + (f2 - this.jdField_d_of_type_Float)) % 360.0F);
      if (paramMotionEvent.d)
      {
        f1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.j;
        f2 = this.m;
        if (f1 > f2) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.j = f2;
        }
        f1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.j;
        f2 = this.n;
        if (f1 < f2) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.j = f2;
        }
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.k < 0.0F)
        {
          paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem;
          paramMotionEvent.k += 360.0F;
        }
      }
      else
      {
        paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem;
        paramMotionEvent.j = this.k;
        paramMotionEvent.k = this.l;
      }
    }
  }
  
  public float a(GestureHelper.ZoomItem paramZoomItem)
  {
    return a(paramZoomItem, true);
  }
  
  public float a(GestureHelper.ZoomItem paramZoomItem, boolean paramBoolean)
  {
    float f1;
    if (paramZoomItem != null) {
      f1 = paramZoomItem.j * paramZoomItem.p;
    } else {
      f1 = 1.0F;
    }
    float f2 = f1;
    if (paramBoolean) {
      f2 = f1 * paramZoomItem.a();
    }
    return f2;
  }
  
  public int a(TextLayer.TextItem paramTextItem, float paramFloat1, float paramFloat2)
  {
    if (paramTextItem == null) {
      return -1;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(paramTextItem).mapPoints(arrayOfFloat);
    float f1 = paramTextItem.n;
    float f3 = paramTextItem.o;
    float f2 = f3;
    paramFloat2 = f1;
    if (this.jdField_c_of_type_Boolean)
    {
      paramFloat1 = f1;
      if (paramTextItem.j * f1 < 200.0F) {
        paramFloat1 = 200.0F / paramTextItem.j;
      }
      f2 = f3;
      paramFloat2 = paramFloat1;
      if (paramTextItem.j * f3 < 200.0F)
      {
        f2 = 200.0F / paramTextItem.j;
        paramFloat2 = paramFloat1;
      }
    }
    return paramTextItem.a.a(paramFloat2, f2, arrayOfFloat[0], arrayOfFloat[1]);
  }
  
  public Matrix a(GestureHelper.ZoomItem paramZoomItem)
  {
    return a(paramZoomItem, true);
  }
  
  public Matrix a(GestureHelper.ZoomItem paramZoomItem, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    if (paramZoomItem == null) {
      return this.jdField_a_of_type_AndroidGraphicsMatrix;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(paramZoomItem.k);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(a(paramZoomItem, false), a(paramZoomItem, false));
    if (paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF != null) {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.x, paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.y);
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(paramZoomItem.l, paramZoomItem.m);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postConcat(paramZoomItem.jdField_a_of_type_AndroidGraphicsMatrix);
    }
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem = null;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_d_of_type_Float = 0.0F;
    this.jdField_e_of_type_Float = 0.0F;
    this.jdField_f_of_type_Float = 0.0F;
    this.i = 0.0F;
    this.j = 0.0F;
    this.k = 0.0F;
    this.l = 0.0F;
    this.jdField_g_of_type_Float = 0.0F;
    this.h = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat >= 0.0F) {
      this.m = paramFloat;
    }
  }
  
  public void a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem == null) {
      return;
    }
    if (paramMotionEvent.getActionMasked() == 0) {
      this.jdField_g_of_type_Int = paramMotionEvent.getPointerId(0);
    }
    if (this.jdField_g_of_type_Int != paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())) {
      return;
    }
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 == 6) {}
        }
        else
        {
          c(paramMotionEvent, paramBoolean);
          return;
        }
      }
      a(paramMotionEvent);
      return;
    }
    b(paramMotionEvent, paramBoolean);
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem)
  {
    a();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem = paramZoomItem;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(GestureHelper.ZoomItem paramZoomItem, float paramFloat1, float paramFloat2)
  {
    if (paramZoomItem == null) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(paramZoomItem).mapPoints(arrayOfFloat);
    paramFloat1 = a(paramZoomItem);
    paramFloat2 = paramZoomItem.n;
    float f3 = paramZoomItem.i / paramFloat1;
    float f1 = paramZoomItem.o;
    float f2 = paramZoomItem.i / paramFloat1;
    paramFloat2 = (paramFloat2 + f3 * 2.0F) / 2.0F;
    f1 = (f1 + f2 * 2.0F) / 2.0F;
    paramFloat1 = DisplayUtil.a() / paramFloat1 / 2.0F;
    f2 = arrayOfFloat[0];
    paramFloat2 = -paramFloat2;
    if ((f2 >= paramFloat2 - paramFloat1 - 10.0F) && (arrayOfFloat[0] <= paramFloat2 + paramFloat1 + 10.0F))
    {
      paramFloat2 = arrayOfFloat[1];
      f1 = -f1;
      if ((paramFloat2 >= f1 - paramFloat1 - 10.0F) && (arrayOfFloat[1] <= f1 + paramFloat1 + 10.0F)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(GestureHelper.ZoomItem paramZoomItem, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramZoomItem == null) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(paramZoomItem).mapPoints(arrayOfFloat);
    float f3 = a(paramZoomItem);
    float f2 = paramZoomItem.n;
    float f1 = paramZoomItem.o;
    paramFloat1 = f2;
    paramFloat2 = f1;
    if (paramBoolean)
    {
      paramFloat1 = f2 + paramZoomItem.i / f3 * 2.0F;
      paramFloat2 = f1 + paramZoomItem.i / f3 * 2.0F;
    }
    f3 = paramFloat1;
    f2 = paramFloat2;
    if (this.jdField_c_of_type_Boolean)
    {
      f1 = paramFloat1;
      if (paramZoomItem.j * paramFloat1 < 200.0F) {
        f1 = 200.0F / paramZoomItem.j;
      }
      f3 = f1;
      f2 = paramFloat2;
      if (paramZoomItem.j * paramFloat2 < 200.0F)
      {
        f2 = 200.0F / paramZoomItem.j;
        f3 = f1;
      }
    }
    paramFloat1 = f3 / 2.0F;
    paramFloat2 = f2 / 2.0F;
    float f4 = -paramFloat1;
    f1 = -paramFloat2;
    f2 = DisplayUtil.a() / a(paramZoomItem) / 2.0F;
    if ((arrayOfFloat[0] >= f4) && (arrayOfFloat[0] <= paramFloat1) && (arrayOfFloat[1] >= f1) && (arrayOfFloat[1] <= paramFloat2)) {
      return true;
    }
    float f5 = arrayOfFloat[0];
    f3 = f4 - f2;
    if ((f5 >= f3 - 10.0F) && (arrayOfFloat[0] <= f4 + f2 + 10.0F) && (arrayOfFloat[1] >= f1 - f2 - 10.0F) && (arrayOfFloat[1] <= f1 + f2 + 10.0F)) {
      return true;
    }
    f4 = arrayOfFloat[0];
    f5 = paramFloat1 - f2 - 10.0F;
    if ((f4 >= f5) && (arrayOfFloat[0] <= paramFloat1 + f2 + 10.0F) && (arrayOfFloat[1] >= f1 - f2 - 10.0F) && (arrayOfFloat[1] <= f1 + f2 + 10.0F)) {
      return true;
    }
    if ((arrayOfFloat[0] >= f5) && (arrayOfFloat[0] <= paramFloat1 + f2 + 10.0F) && (arrayOfFloat[1] >= paramFloat2 - f2 - 10.0F) && (arrayOfFloat[1] <= paramFloat2 + f2 + 10.0F)) {
      return true;
    }
    if ((arrayOfFloat[0] >= f3) && (arrayOfFloat[0] <= paramFloat1 + f2) && (arrayOfFloat[1] >= f1 - f2) && (arrayOfFloat[1] > paramFloat2 + f2)) {}
    return false;
  }
  
  public boolean a(GestureHelper.ZoomItem paramZoomItem, float paramFloat, boolean paramBoolean)
  {
    if (paramZoomItem == null) {
      return false;
    }
    float f2 = paramZoomItem.n;
    float f1 = paramZoomItem.o / 2.0F;
    f2 /= 2.0F;
    float[] arrayOfFloat1 = new float[2];
    float f3 = -f2;
    arrayOfFloat1[0] = f3;
    float f4 = -f1;
    arrayOfFloat1[1] = f4;
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = f2;
    arrayOfFloat2[1] = f4;
    float[] arrayOfFloat3 = new float[2];
    arrayOfFloat3[0] = f3;
    arrayOfFloat3[1] = f1;
    float[] arrayOfFloat4 = new float[2];
    arrayOfFloat4[0] = f2;
    arrayOfFloat4[1] = f1;
    paramZoomItem = a(paramZoomItem);
    this.jdField_a_of_type_AndroidGraphicsMatrix = paramZoomItem;
    paramZoomItem.mapPoints(arrayOfFloat1);
    paramZoomItem.mapPoints(arrayOfFloat2);
    paramZoomItem.mapPoints(arrayOfFloat3);
    paramZoomItem.mapPoints(arrayOfFloat4);
    if (QLog.isColorLevel())
    {
      paramZoomItem = new StringBuilder();
      paramZoomItem.append("isCloseToXLine x=");
      paramZoomItem.append(paramFloat);
      paramZoomItem.append(" leftReach=");
      paramZoomItem.append(paramBoolean);
      paramZoomItem.append("\n");
      paramZoomItem.append("f[");
      paramZoomItem.append(arrayOfFloat1[0]);
      paramZoomItem.append(",");
      paramZoomItem.append(arrayOfFloat1[1]);
      paramZoomItem.append("]\n");
      paramZoomItem.append("f1[");
      paramZoomItem.append(arrayOfFloat2[0]);
      paramZoomItem.append(",");
      paramZoomItem.append(arrayOfFloat2[1]);
      paramZoomItem.append("]\n");
      paramZoomItem.append("f2[");
      paramZoomItem.append(arrayOfFloat3[0]);
      paramZoomItem.append(",");
      paramZoomItem.append(arrayOfFloat3[1]);
      paramZoomItem.append("]\n");
      paramZoomItem.append("f3[");
      paramZoomItem.append(arrayOfFloat4[0]);
      paramZoomItem.append(",");
      paramZoomItem.append(arrayOfFloat4[1]);
      paramZoomItem.append("]\n");
      QLog.d("GestureHelper", 2, paramZoomItem.toString());
    }
    if (paramBoolean)
    {
      if ((arrayOfFloat1[0] <= paramFloat) || (arrayOfFloat2[0] <= paramFloat) || (arrayOfFloat3[0] <= paramFloat) || (arrayOfFloat4[0] <= paramFloat)) {
        return true;
      }
    }
    else
    {
      if ((arrayOfFloat1[0] >= paramFloat) || (arrayOfFloat2[0] >= paramFloat) || (arrayOfFloat3[0] >= paramFloat)) {
        break label448;
      }
      if (arrayOfFloat4[0] >= paramFloat) {
        return true;
      }
    }
    return false;
    label448:
    return true;
  }
  
  public Matrix b(GestureHelper.ZoomItem paramZoomItem)
  {
    return b(paramZoomItem, true);
  }
  
  public Matrix b(GestureHelper.ZoomItem paramZoomItem, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    if (paramZoomItem == null) {
      return this.jdField_a_of_type_AndroidGraphicsMatrix;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(paramZoomItem.k);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.x, paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.y);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(paramZoomItem.l, paramZoomItem.m);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postConcat(paramZoomItem.jdField_a_of_type_AndroidGraphicsMatrix);
    }
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
  
  public void b(float paramFloat)
  {
    if (paramFloat >= 0.0F) {
      this.n = paramFloat;
    }
  }
  
  public boolean b(GestureHelper.ZoomItem paramZoomItem, float paramFloat1, float paramFloat2)
  {
    if (paramZoomItem == null) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(paramZoomItem).mapPoints(arrayOfFloat);
    paramFloat1 = a(paramZoomItem);
    float f2 = paramZoomItem.n;
    float f3 = paramZoomItem.i / paramFloat1;
    paramFloat2 = paramZoomItem.o;
    float f1 = paramZoomItem.i / paramFloat1;
    f2 = (f2 + f3 * 2.0F) / 2.0F;
    paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
    paramFloat1 = DisplayUtil.a() / paramFloat1 / 2.0F;
    return (arrayOfFloat[0] >= f2 - paramFloat1 - 10.0F) && (arrayOfFloat[0] <= f2 + paramFloat1 + 10.0F) && (arrayOfFloat[1] >= paramFloat2 - paramFloat1 - 10.0F) && (arrayOfFloat[1] <= paramFloat2 + paramFloat1 + 10.0F);
  }
  
  public boolean b(GestureHelper.ZoomItem paramZoomItem, float paramFloat, boolean paramBoolean)
  {
    if (paramZoomItem == null) {
      return false;
    }
    float f2 = paramZoomItem.n;
    float f1 = paramZoomItem.o / 2.0F;
    f2 /= 2.0F;
    float[] arrayOfFloat1 = new float[2];
    float f3 = -f2;
    arrayOfFloat1[0] = f3;
    float f4 = -f1;
    arrayOfFloat1[1] = f4;
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = f2;
    arrayOfFloat2[1] = f4;
    float[] arrayOfFloat3 = new float[2];
    arrayOfFloat3[0] = f3;
    arrayOfFloat3[1] = f1;
    float[] arrayOfFloat4 = new float[2];
    arrayOfFloat4[0] = f2;
    arrayOfFloat4[1] = f1;
    paramZoomItem = a(paramZoomItem);
    this.jdField_a_of_type_AndroidGraphicsMatrix = paramZoomItem;
    paramZoomItem.mapPoints(arrayOfFloat1);
    paramZoomItem.mapPoints(arrayOfFloat2);
    paramZoomItem.mapPoints(arrayOfFloat3);
    paramZoomItem.mapPoints(arrayOfFloat4);
    if (QLog.isColorLevel())
    {
      paramZoomItem = new StringBuilder();
      paramZoomItem.append("isCloseToYLine y=");
      paramZoomItem.append(paramFloat);
      paramZoomItem.append(" topReach=");
      paramZoomItem.append(paramBoolean);
      paramZoomItem.append("\n");
      paramZoomItem.append("f[");
      paramZoomItem.append(arrayOfFloat1[0]);
      paramZoomItem.append(",");
      paramZoomItem.append(arrayOfFloat1[1]);
      paramZoomItem.append("]\n");
      paramZoomItem.append("f1[");
      paramZoomItem.append(arrayOfFloat2[0]);
      paramZoomItem.append(",");
      paramZoomItem.append(arrayOfFloat2[1]);
      paramZoomItem.append("]\n");
      paramZoomItem.append("f2[");
      paramZoomItem.append(arrayOfFloat3[0]);
      paramZoomItem.append(",");
      paramZoomItem.append(arrayOfFloat3[1]);
      paramZoomItem.append("]\n");
      paramZoomItem.append("f3[");
      paramZoomItem.append(arrayOfFloat4[0]);
      paramZoomItem.append(",");
      paramZoomItem.append(arrayOfFloat4[1]);
      paramZoomItem.append("]\n");
      QLog.d("GestureHelper", 2, paramZoomItem.toString());
    }
    if (paramBoolean)
    {
      if ((arrayOfFloat1[1] <= paramFloat) || (arrayOfFloat2[1] <= paramFloat) || (arrayOfFloat3[1] <= paramFloat) || (arrayOfFloat4[1] <= paramFloat)) {
        return true;
      }
    }
    else
    {
      if ((arrayOfFloat1[1] >= paramFloat) || (arrayOfFloat2[1] >= paramFloat) || (arrayOfFloat3[1] >= paramFloat)) {
        break label450;
      }
      if (arrayOfFloat4[1] >= paramFloat) {
        return true;
      }
    }
    return false;
    label450:
    return true;
  }
  
  public Matrix c(GestureHelper.ZoomItem paramZoomItem)
  {
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
    if (paramZoomItem == null) {
      return this.jdField_b_of_type_AndroidGraphicsMatrix;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix = a(paramZoomItem);
    this.jdField_a_of_type_AndroidGraphicsMatrix.invert(this.jdField_b_of_type_AndroidGraphicsMatrix);
    return this.jdField_b_of_type_AndroidGraphicsMatrix;
  }
  
  public boolean c(GestureHelper.ZoomItem paramZoomItem, float paramFloat1, float paramFloat2)
  {
    if (paramZoomItem == null) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(paramZoomItem).mapPoints(arrayOfFloat);
    paramFloat1 = a(paramZoomItem);
    float f2 = paramZoomItem.n;
    float f3 = paramZoomItem.i / paramFloat1;
    paramFloat2 = paramZoomItem.o;
    float f1 = paramZoomItem.i / paramFloat1;
    f2 = (f2 + f3 * 2.0F) / 2.0F;
    paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
    paramFloat1 = DisplayUtil.a() / paramFloat1 / 2.0F;
    if ((arrayOfFloat[0] >= f2 - paramFloat1 - 10.0F) && (arrayOfFloat[0] <= f2 + paramFloat1 + 10.0F))
    {
      f1 = arrayOfFloat[1];
      paramFloat2 = -paramFloat2;
      if ((f1 >= paramFloat2 - paramFloat1 - 10.0F) && (arrayOfFloat[1] <= paramFloat2 + paramFloat1 + 10.0F)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper
 * JD-Core Version:    0.7.0.1
 */