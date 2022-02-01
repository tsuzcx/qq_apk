package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;

public class ShapeEffect
{
  private static final int jdField_a_of_type_Int = UIUtils.a(BaseApplicationImpl.getContext(), 160.5F);
  private static final int jdField_b_of_type_Int = UIUtils.a(BaseApplicationImpl.getContext(), 53.5F);
  private static final int jdField_c_of_type_Int = UIUtils.a(BaseApplicationImpl.getContext(), 15.0F);
  private static final int jdField_d_of_type_Int = ViewConfiguration.get(BaseApplicationImpl.getContext()).getScaledTouchSlop();
  private static final int jdField_e_of_type_Int = ViewConfiguration.getLongPressTimeout();
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private ShapeEffect.ControlPoint jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$ControlPoint;
  private ShapeEffect.EndPoint jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$EndPoint;
  private ShapeEffect.InteractionListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$InteractionListener;
  private ShapeEffect.NonPoint jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$NonPoint;
  private ShapeEffect.ResizePoint jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$ResizePoint;
  private ShapeEffect.RotatePoint jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$RotatePoint;
  private ShapeEffect.StartPoint jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$StartPoint;
  private ShapeEffect.TipsControl jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$TipsControl;
  private ShapeOperator.Shape jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape;
  private Boolean jdField_a_of_type_JavaLangBoolean = null;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private Path jdField_b_of_type_AndroidGraphicsPath;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float;
  private Paint jdField_d_of_type_AndroidGraphicsPaint;
  private boolean jdField_d_of_type_Boolean = false;
  private float jdField_e_of_type_Float = 0.0F;
  private Paint jdField_e_of_type_AndroidGraphicsPaint = new Paint();
  private boolean jdField_e_of_type_Boolean;
  private float jdField_f_of_type_Float = 0.0F;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = true;
  private float jdField_g_of_type_Float = 1.0F;
  private int jdField_g_of_type_Int;
  private float jdField_h_of_type_Float;
  private int jdField_h_of_type_Int;
  private float i;
  private float j;
  private float k;
  private float l = 0.0F;
  private float m;
  
  public ShapeEffect(Context paramContext, ShapeOperator.Shape paramShape, float paramFloat, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape = paramShape;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_f_of_type_Int = UIUtils.a(paramContext, 5.0F);
    this.jdField_g_of_type_Int = UIUtils.a(paramContext, 7.0F);
    this.jdField_h_of_type_Int = UIUtils.a(paramContext, 20.0F);
    this.m = UIUtils.a(paramContext, 6.0F);
    this.jdField_b_of_type_Float = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    this.jdField_c_of_type_Float = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    this.jdField_d_of_type_Float = Math.max(this.jdField_c_of_type_Float, jdField_c_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130837740);
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130837739);
    a();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(a(paramFloat));
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape == ShapeOperator.Shape.OVAL) || (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape == ShapeOperator.Shape.RECT)) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    }
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape == ShapeOperator.Shape.ARROW) || (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape == ShapeOperator.Shape.LINE))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-789517);
    }
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint(this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private double a(double paramDouble)
  {
    if (paramDouble > jdField_a_of_type_Int) {
      paramDouble = jdField_b_of_type_Int;
    } else {
      paramDouble /= 3.0D;
    }
    double d1 = this.jdField_a_of_type_AndroidGraphicsPaint.getStrokeWidth();
    Double.isNaN(d1);
    paramDouble = Math.min(d1 * 1.4D + 8.800000000000001D, paramDouble);
    return Math.sqrt(paramDouble * paramDouble * 2.0D);
  }
  
  private float a(float paramFloat)
  {
    return DoodleLayout.a(paramFloat);
  }
  
  private Path a()
  {
    float f1 = this.jdField_h_of_type_Float - this.j;
    float f2 = this.i - this.k;
    double d1 = a(Math.sqrt(f1 * f1 + f2 * f2));
    Path localPath = new Path();
    localPath.moveTo(this.jdField_h_of_type_Float, this.i);
    localPath.lineTo(this.j, this.k);
    double[] arrayOfDouble = a(f1, f2, -0.7853981633974483D, d1);
    localPath.lineTo(this.j + (float)arrayOfDouble[0], this.k + (float)arrayOfDouble[1]);
    localPath.lineTo(this.j, this.k);
    arrayOfDouble = a(f1, f2, 0.7853981633974483D, d1);
    localPath.lineTo(this.j + (float)arrayOfDouble[0], this.k + (float)arrayOfDouble[1]);
    localPath.lineTo(this.j, this.k);
    localPath.close();
    return localPath;
  }
  
  private ShapeEffect.ControlPoint a(float paramFloat1, float paramFloat2)
  {
    if (b(paramFloat1, paramFloat2))
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$TipsControl == null) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$TipsControl = new ShapeEffect.TipsControl(this, this.jdField_a_of_type_AndroidContentContext, null);
      }
      return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$TipsControl;
    }
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape != ShapeOperator.Shape.LINE) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape != ShapeOperator.Shape.ARROW))
    {
      if (d(paramFloat1, paramFloat2))
      {
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$RotatePoint == null) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$RotatePoint = new ShapeEffect.RotatePoint(this, null);
        }
        return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$RotatePoint;
      }
      if (c(paramFloat1, paramFloat2))
      {
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$ResizePoint == null) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$ResizePoint = new ShapeEffect.ResizePoint(this, null);
        }
        return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$ResizePoint;
      }
    }
    else
    {
      if (e(paramFloat1, paramFloat2))
      {
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$StartPoint == null) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$StartPoint = new ShapeEffect.StartPoint(this, null);
        }
        return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$StartPoint;
      }
      if (f(paramFloat1, paramFloat2))
      {
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$EndPoint == null) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$EndPoint = new ShapeEffect.EndPoint(this, null);
        }
        return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$EndPoint;
      }
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$NonPoint == null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$NonPoint = new ShapeEffect.NonPoint(this, null);
    }
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$NonPoint;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 1.0F));
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
    this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 2.0F), 0.0F, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 1.0F), 687865856);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_e_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_e_of_type_AndroidGraphicsPaint.setColor(687865856);
    this.jdField_e_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int i1 = (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText("点击输入文字");
    int n = (int)Math.ceil(this.jdField_a_of_type_AndroidTextTextPaint.descent() - this.jdField_a_of_type_AndroidTextTextPaint.ascent());
    if (paramBoolean) {
      paramFloat2 = paramFloat2 + n / 2.0F + this.jdField_h_of_type_Int;
    } else {
      paramFloat2 = paramFloat2 - n / 2.0F - this.jdField_h_of_type_Int;
    }
    RectF localRectF = this.jdField_c_of_type_AndroidGraphicsRectF;
    int i2 = this.jdField_g_of_type_Int;
    localRectF.left = (paramFloat1 - (i2 * 2 + i1) / 2.0F);
    localRectF.right = ((i1 + i2 * 2) / 2.0F + paramFloat1);
    i1 = this.jdField_f_of_type_Int;
    localRectF.top = (paramFloat2 - (i1 * 2 + n) / 2.0F);
    localRectF.bottom = ((n + i1 * 2) / 2.0F + paramFloat2);
    float f1 = this.m;
    paramCanvas.drawRoundRect(localRectF, f1, f1, this.jdField_e_of_type_AndroidGraphicsPaint);
    paramCanvas.drawText("点击输入文字", paramFloat1, paramFloat2 - (this.jdField_a_of_type_AndroidTextTextPaint.descent() + this.jdField_a_of_type_AndroidTextTextPaint.ascent()) / 2.0F, this.jdField_a_of_type_AndroidTextTextPaint);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f2 = this.j;
    float f1 = this.jdField_h_of_type_Float;
    f2 -= f1;
    float f4 = this.k;
    float f3 = this.i;
    f4 -= f3;
    double d1 = Math.sqrt(f2 * f2 + f4 * f4);
    double d2 = Math.abs(f2 * (paramFloat2 - f3) - f4 * (paramFloat1 - f1));
    Double.isNaN(d2);
    d2 /= d1;
    f1 = this.jdField_h_of_type_Float;
    f2 = this.i;
    double d3 = Math.sqrt((paramFloat1 - f1) * (paramFloat1 - f1) + (paramFloat2 - f2) * (paramFloat2 - f2));
    f1 = this.j;
    f2 = this.k;
    double d4 = Math.sqrt((paramFloat1 - f1) * (paramFloat1 - f1) + (paramFloat2 - f2) * (paramFloat2 - f2));
    double d5 = paramFloat3;
    return (d3 < d5) || (d4 < d5) || ((d2 < d5) && (d3 < d1) && (d4 < d1));
  }
  
  private double[] a(float paramFloat1, float paramFloat2, double paramDouble1, double paramDouble2)
  {
    double d1 = paramFloat1;
    double d3 = Math.cos(paramDouble1);
    Double.isNaN(d1);
    double d2 = paramFloat2;
    double d4 = Math.sin(paramDouble1);
    Double.isNaN(d2);
    d3 = d3 * d1 - d4 * d2;
    d4 = Math.sin(paramDouble1);
    Double.isNaN(d1);
    paramDouble1 = Math.cos(paramDouble1);
    Double.isNaN(d2);
    paramDouble1 = d1 * d4 + d2 * paramDouble1;
    d1 = Math.sqrt(d3 * d3 + paramDouble1 * paramDouble1);
    return new double[] { d3 / d1 * paramDouble2, paramDouble1 / d1 * paramDouble2 };
  }
  
  private Path b()
  {
    float f2 = this.jdField_a_of_type_AndroidGraphicsPaint.getStrokeWidth() / 2.0F;
    int n = jdField_c_of_type_Int;
    float f1 = f2;
    if (f2 < n) {
      f1 = n;
    }
    Path localPath = new Path();
    float f4 = this.j - this.jdField_h_of_type_Float;
    f2 = this.k - this.i;
    double d1 = a(Math.sqrt(f4 * f4 + f2 * f2));
    double d2 = f1;
    double[] arrayOfDouble = a(f4, f2, 0.0D, d2);
    float f5 = this.jdField_h_of_type_Float - (float)arrayOfDouble[0];
    float f6 = this.i - (float)arrayOfDouble[1];
    f1 = this.j + (float)arrayOfDouble[0];
    float f3 = this.k + (float)arrayOfDouble[1];
    arrayOfDouble = a(f4, f2, 1.570796326794897D, d2);
    localPath.moveTo(f5 + (float)arrayOfDouble[0], f6 + (float)arrayOfDouble[1]);
    localPath.lineTo(f5 - (float)arrayOfDouble[0], f6 - (float)arrayOfDouble[1]);
    f4 = -f4;
    f2 = -f2;
    Double.isNaN(d2);
    d1 += d2;
    arrayOfDouble = a(f4, f2, 0.7853981633974483D, d1);
    localPath.lineTo(f1 + (float)arrayOfDouble[0], f3 + (float)arrayOfDouble[1]);
    localPath.lineTo(f1, f3);
    arrayOfDouble = a(f4, f2, -0.7853981633974483D, d1);
    localPath.lineTo(f1 + (float)arrayOfDouble[0], f3 + (float)arrayOfDouble[1]);
    localPath.close();
    return localPath;
  }
  
  private void b()
  {
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = this.jdField_a_of_type_AndroidGraphicsRectF.centerX();
    arrayOfFloat1[1] = this.jdField_a_of_type_AndroidGraphicsRectF.centerY();
    float[] arrayOfFloat2 = new float[2];
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(-this.l, this.jdField_h_of_type_Float, this.i);
    localMatrix.mapPoints(arrayOfFloat2, arrayOfFloat1);
    float f1 = arrayOfFloat2[0];
    float f2 = arrayOfFloat1[0];
    float f3 = arrayOfFloat2[1];
    float f4 = arrayOfFloat1[1];
    arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = (f1 - f2);
    arrayOfFloat1[1] = (f3 - f4);
    localMatrix.setRotate(this.l);
    localMatrix.mapPoints(arrayOfFloat1);
    a(arrayOfFloat1[0], arrayOfFloat1[1]);
  }
  
  private boolean b()
  {
    return (this.jdField_e_of_type_Boolean) && (!this.jdField_c_of_type_Boolean);
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    int n = paramMotionEvent.getAction();
    Object localObject;
    if (n != 0)
    {
      if (n != 1) {
        if (n != 2)
        {
          if (n != 3) {
            return false;
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$ControlPoint;
          if (localObject != null) {
            return ((ShapeEffect.ControlPoint)localObject).a(paramMotionEvent);
          }
          return false;
        }
      }
      this.jdField_c_of_type_Boolean = false;
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$ControlPoint;
      if (localObject != null)
      {
        boolean bool = ((ShapeEffect.ControlPoint)localObject).a(paramMotionEvent);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$ControlPoint = null;
        return bool;
      }
      return false;
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$ControlPoint = a((paramMotionEvent.getX() - this.jdField_e_of_type_Float) / this.jdField_g_of_type_Float, (paramMotionEvent.getY() - this.jdField_f_of_type_Float) / this.jdField_g_of_type_Float);
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$ControlPoint != null)
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$InteractionListener;
      if (localObject != null) {
        ((ShapeEffect.InteractionListener)localObject).a(this);
      }
      return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$ControlPoint.a(paramMotionEvent);
    }
    return false;
  }
  
  private void c()
  {
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = this.jdField_a_of_type_AndroidGraphicsRectF.centerX();
    arrayOfFloat1[1] = this.jdField_a_of_type_AndroidGraphicsRectF.centerY();
    float[] arrayOfFloat2 = new float[2];
    Matrix localMatrix = new Matrix();
    localMatrix.setScale(1.0F, 1.0F);
    localMatrix.postRotate(this.l, this.jdField_h_of_type_Float, this.i);
    localMatrix.mapPoints(arrayOfFloat2, arrayOfFloat1);
    a(arrayOfFloat2[0] - arrayOfFloat1[0], arrayOfFloat2[1] - arrayOfFloat1[1]);
  }
  
  private void c(float paramFloat1, float paramFloat2)
  {
    this.jdField_h_of_type_Float += paramFloat1;
    this.i += paramFloat2;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape == ShapeOperator.Shape.ARROW)
    {
      this.jdField_a_of_type_AndroidGraphicsPath = a();
      this.jdField_b_of_type_AndroidGraphicsPath = b();
    }
  }
  
  private boolean c(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_AndroidGraphicsPath = b();
    RectF localRectF = new RectF();
    this.jdField_b_of_type_AndroidGraphicsPath.computeBounds(localRectF, true);
    Region localRegion = new Region();
    localRegion.setPath(this.jdField_b_of_type_AndroidGraphicsPath, new Region((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom));
    return localRegion.contains(paramInt1, paramInt2);
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    float f1 = (paramMotionEvent.getX() - this.jdField_e_of_type_Float) / this.jdField_g_of_type_Float;
    float f2 = (paramMotionEvent.getY() - this.jdField_f_of_type_Float) / this.jdField_g_of_type_Float;
    int n = paramMotionEvent.getAction();
    if (n != 0)
    {
      boolean bool2 = false;
      if (n != 1)
      {
        if (n != 2) {
          return n == 3;
        }
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 150L) {
          this.jdField_f_of_type_Boolean = false;
        }
        this.j = f1;
        this.k = f2;
        if (!this.jdField_f_of_type_Boolean)
        {
          if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape == ShapeOperator.Shape.ARROW)
          {
            this.jdField_a_of_type_AndroidGraphicsPath = a();
            return true;
          }
          d();
          e();
        }
        return true;
      }
      this.j = f1;
      this.k = f2;
      f1 = this.j - this.jdField_h_of_type_Float;
      f2 = this.k - this.i;
      long l1 = paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime();
      boolean bool1;
      if (l1 <= jdField_e_of_type_Int) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      double d1 = f1 * f1 + f2 * f2;
      if (Math.sqrt(d1) <= jdField_d_of_type_Int) {
        bool2 = true;
      }
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("handleTouchWhenDrawing--UP--elapse=");
      paramMotionEvent.append(l1);
      paramMotionEvent.append(", inTapTime=");
      paramMotionEvent.append(bool1);
      paramMotionEvent.append(", inTapDis=");
      paramMotionEvent.append(bool2);
      AEQLog.a("ShapeEffect", paramMotionEvent.toString());
      if ((bool1) && (bool2))
      {
        paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$InteractionListener;
        if (paramMotionEvent != null) {
          paramMotionEvent.a();
        }
      }
      if ((!this.jdField_f_of_type_Boolean) && (Math.sqrt(d1) > UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F)))
      {
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape == ShapeOperator.Shape.ARROW)
        {
          this.jdField_a_of_type_AndroidGraphicsPath = a();
          this.jdField_b_of_type_AndroidGraphicsPath = b();
        }
        else
        {
          d();
          e();
        }
        this.jdField_a_of_type_Boolean = true;
      }
      return true;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_h_of_type_Float = f1;
    this.i = f2;
    this.j = this.jdField_h_of_type_Float;
    this.k = this.i;
    return true;
  }
  
  private void d()
  {
    float f1 = this.jdField_h_of_type_Float;
    float f2 = this.j;
    if (f1 < f2)
    {
      localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      localRectF.left = f1;
      localRectF.right = f2;
    }
    else
    {
      localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      localRectF.left = f2;
      localRectF.right = f1;
    }
    f1 = this.i;
    f2 = this.k;
    if (f1 < f2)
    {
      localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      localRectF.top = f1;
      localRectF.bottom = f2;
      return;
    }
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    localRectF.top = f2;
    localRectF.bottom = f1;
  }
  
  private void d(float paramFloat1, float paramFloat2)
  {
    this.j += paramFloat1;
    this.k += paramFloat2;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape == ShapeOperator.Shape.ARROW)
    {
      this.jdField_a_of_type_AndroidGraphicsPath = a();
      this.jdField_b_of_type_AndroidGraphicsPath = b();
    }
  }
  
  private void e()
  {
    float f1 = this.jdField_d_of_type_AndroidGraphicsPaint.getStrokeWidth() / 2.0F;
    int n = ShapeEffect.1.a[this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape.ordinal()];
    if ((n != 1) && (n != 2) && (n != 3) && (n != 4)) {
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsRectF.left = (this.jdField_a_of_type_AndroidGraphicsRectF.left - f1);
    this.jdField_b_of_type_AndroidGraphicsRectF.top = (this.jdField_a_of_type_AndroidGraphicsRectF.top - f1);
    this.jdField_b_of_type_AndroidGraphicsRectF.right = (this.jdField_a_of_type_AndroidGraphicsRectF.right + f1);
    this.jdField_b_of_type_AndroidGraphicsRectF.bottom = (this.jdField_a_of_type_AndroidGraphicsRectF.bottom + f1);
  }
  
  private boolean e(float paramFloat1, float paramFloat2)
  {
    paramFloat1 -= this.jdField_h_of_type_Float;
    paramFloat2 -= this.i;
    return Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2) < this.jdField_d_of_type_Float;
  }
  
  private void f()
  {
    ShapeEffect.InteractionListener localInteractionListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$InteractionListener;
    if (localInteractionListener != null) {
      localInteractionListener.a(this, new RectF(this.jdField_c_of_type_AndroidGraphicsRectF));
    }
  }
  
  private boolean f(float paramFloat1, float paramFloat2)
  {
    paramFloat1 -= this.j;
    paramFloat2 -= this.k;
    return Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2) < this.jdField_d_of_type_Float;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidGraphicsPaint.getColor();
  }
  
  public PointF a()
  {
    return new PointF(this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY());
  }
  
  public ShapeOperator.Shape a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape;
  }
  
  public void a(float paramFloat)
  {
    this.l += paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_h_of_type_Float += paramFloat1;
    this.i += paramFloat2;
    this.j += paramFloat1;
    this.k += paramFloat2;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape == ShapeOperator.Shape.ARROW)
    {
      this.jdField_a_of_type_AndroidGraphicsPath = a();
      this.jdField_b_of_type_AndroidGraphicsPath = b();
      return;
    }
    d();
    e();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
  
  public void a(Canvas paramCanvas)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape;
    Object localObject2 = ShapeOperator.Shape.LINE;
    boolean bool2 = false;
    boolean bool1 = false;
    float f1;
    float f2;
    float f3;
    if (localObject1 == localObject2)
    {
      paramCanvas.drawLine(this.jdField_h_of_type_Float, this.i, this.j, this.k, this.jdField_d_of_type_AndroidGraphicsPaint);
      if (this.jdField_b_of_type_Boolean)
      {
        paramCanvas.drawLine(this.jdField_h_of_type_Float, this.i, this.j, this.k, this.jdField_b_of_type_AndroidGraphicsPaint);
        localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
        f1 = this.jdField_h_of_type_Float;
        f2 = this.jdField_c_of_type_Float;
        f3 = this.i;
        paramCanvas.drawBitmap((Bitmap)localObject1, null, new RectF(f1 - f2, f3 - f2, f1 + f2, f3 + f2), null);
        localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
        f1 = this.j;
        f2 = this.jdField_c_of_type_Float;
        f3 = this.k;
        paramCanvas.drawBitmap((Bitmap)localObject1, null, new RectF(f1 - f2, f3 - f2, f1 + f2, f3 + f2), null);
      }
      if (b())
      {
        f1 = this.jdField_h_of_type_Float;
        f2 = this.i;
        if (f2 >= this.k) {
          bool1 = true;
        }
        a(paramCanvas, f1, f2, bool1);
      }
    }
    else if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape == ShapeOperator.Shape.ARROW)
    {
      localObject1 = this.jdField_a_of_type_AndroidGraphicsPath;
      if (localObject1 != null)
      {
        paramCanvas.drawPath((Path)localObject1, this.jdField_a_of_type_AndroidGraphicsPaint);
        if (this.jdField_b_of_type_Boolean)
        {
          paramCanvas.drawLine(this.jdField_h_of_type_Float, this.i, this.j, this.k, this.jdField_b_of_type_AndroidGraphicsPaint);
          localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
          f1 = this.jdField_h_of_type_Float;
          f2 = this.jdField_c_of_type_Float;
          f3 = this.i;
          paramCanvas.drawBitmap((Bitmap)localObject1, null, new RectF(f1 - f2, f3 - f2, f1 + f2, f3 + f2), null);
          localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
          f1 = this.j;
          f2 = this.jdField_c_of_type_Float;
          f3 = this.k;
          paramCanvas.drawBitmap((Bitmap)localObject1, null, new RectF(f1 - f2, f3 - f2, f1 + f2, f3 + f2), null);
        }
        if (b())
        {
          f1 = this.jdField_h_of_type_Float;
          f2 = this.i;
          bool1 = bool2;
          if (f2 >= this.k) {
            bool1 = true;
          }
          a(paramCanvas, f1, f2, bool1);
        }
      }
    }
    else
    {
      paramCanvas.save();
      if (this.jdField_d_of_type_Boolean) {
        paramCanvas.rotate(this.l, this.jdField_h_of_type_Float, this.i);
      } else {
        paramCanvas.rotate(this.l, this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY());
      }
      int n = ShapeEffect.1.a[this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape.ordinal()];
      if (n != 1)
      {
        if (n != 2)
        {
          if ((n == 3) || (n == 4))
          {
            paramCanvas.drawOval(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_d_of_type_AndroidGraphicsPaint);
            if (this.jdField_b_of_type_Boolean)
            {
              paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsPaint);
              paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, new RectF(this.jdField_b_of_type_AndroidGraphicsRectF.right - this.jdField_c_of_type_Float, this.jdField_b_of_type_AndroidGraphicsRectF.bottom - this.jdField_c_of_type_Float, this.jdField_b_of_type_AndroidGraphicsRectF.right + this.jdField_c_of_type_Float, this.jdField_b_of_type_AndroidGraphicsRectF.bottom + this.jdField_c_of_type_Float), null);
              paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, null, new RectF(this.jdField_b_of_type_AndroidGraphicsRectF.left - this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidGraphicsRectF.top - this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidGraphicsRectF.left + this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidGraphicsRectF.top + this.jdField_b_of_type_Float), null);
            }
          }
        }
        else
        {
          paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_d_of_type_AndroidGraphicsPaint);
          if (this.jdField_b_of_type_Boolean)
          {
            paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsPaint);
            paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, new RectF(this.jdField_a_of_type_AndroidGraphicsRectF.right - this.jdField_c_of_type_Float, this.jdField_a_of_type_AndroidGraphicsRectF.bottom - this.jdField_c_of_type_Float, this.jdField_a_of_type_AndroidGraphicsRectF.right + this.jdField_c_of_type_Float, this.jdField_a_of_type_AndroidGraphicsRectF.bottom + this.jdField_c_of_type_Float), null);
            paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, null, new RectF(this.jdField_a_of_type_AndroidGraphicsRectF.left - this.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsRectF.top - this.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsRectF.left + this.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsRectF.top + this.jdField_b_of_type_Float), null);
          }
        }
      }
      else
      {
        paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_d_of_type_AndroidGraphicsPaint);
        if (this.jdField_b_of_type_Boolean)
        {
          paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsPaint);
          paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, new RectF(this.jdField_b_of_type_AndroidGraphicsRectF.right - this.jdField_c_of_type_Float, this.jdField_b_of_type_AndroidGraphicsRectF.bottom - this.jdField_c_of_type_Float, this.jdField_b_of_type_AndroidGraphicsRectF.right + this.jdField_c_of_type_Float, this.jdField_b_of_type_AndroidGraphicsRectF.bottom + this.jdField_c_of_type_Float), null);
          paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, null, new RectF(this.jdField_b_of_type_AndroidGraphicsRectF.left - this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidGraphicsRectF.top - this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidGraphicsRectF.left + this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidGraphicsRectF.top + this.jdField_b_of_type_Float), null);
        }
      }
      paramCanvas.restore();
      localObject1 = new RectF();
      if (!this.jdField_d_of_type_Boolean)
      {
        localObject2 = new Matrix();
        ((Matrix)localObject2).setRotate(this.l, this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY());
        ((Matrix)localObject2).mapRect((RectF)localObject1, this.jdField_b_of_type_AndroidGraphicsRectF);
      }
      else
      {
        localObject2 = new Matrix();
        ((Matrix)localObject2).postRotate(this.l, this.jdField_h_of_type_Float, this.i);
        ((Matrix)localObject2).mapRect((RectF)localObject1, this.jdField_b_of_type_AndroidGraphicsRectF);
      }
      f1 = ((RectF)localObject1).centerX();
      f2 = ((RectF)localObject1).bottom;
      if (b()) {
        a(paramCanvas, f1, f2, true);
      }
    }
  }
  
  public void a(ShapeEffect.InteractionListener paramInteractionListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$InteractionListener = paramInteractionListener;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaLangBoolean == null) {
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      }
    }
    else if (Boolean.TRUE.equals(this.jdField_a_of_type_JavaLangBoolean)) {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    float f1 = this.j - this.jdField_h_of_type_Float;
    float f2 = this.k - this.i;
    return Math.sqrt(f1 * f1 + f2 * f2) > UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape != ShapeOperator.Shape.LINE) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape != ShapeOperator.Shape.ARROW))
    {
      if ((d(paramFloat1, paramFloat2)) || (c(paramFloat1, paramFloat2))) {
        return true;
      }
    }
    else
    {
      if (e(paramFloat1, paramFloat2)) {
        break label65;
      }
      if (f(paramFloat1, paramFloat2)) {
        return true;
      }
    }
    return false;
    label65:
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape == ShapeOperator.Shape.ARROW) {
      return c(paramInt1, paramInt2);
    }
    float f2 = this.jdField_d_of_type_AndroidGraphicsPaint.getStrokeWidth() / 2.0F;
    int n = jdField_c_of_type_Int;
    float f1 = f2;
    if (f2 < n) {
      f1 = n;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape == ShapeOperator.Shape.LINE) {
      return a(paramInt1, paramInt2, f1);
    }
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(-this.l, this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY());
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramInt1;
    arrayOfFloat[1] = paramInt2;
    localMatrix.mapPoints(arrayOfFloat);
    float f6 = this.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F;
    float f7 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / 2.0F;
    float f4 = arrayOfFloat[0] - this.jdField_a_of_type_AndroidGraphicsRectF.centerX();
    f2 = arrayOfFloat[1] - this.jdField_a_of_type_AndroidGraphicsRectF.centerY();
    paramInt1 = ShapeEffect.1.a[this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape.ordinal()];
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        float f3;
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4) {
            return false;
          }
          f3 = f6 + f1;
          f1 = f7 + f1;
          f3 *= f3;
          if (f4 * f4 + f2 * f2 * f3 / (f1 * f1) < f3) {
            return true;
          }
        }
        else
        {
          float f5 = f6 - f1;
          f3 = f7 - f1;
          f6 += f1;
          f1 = f7 + f1;
          f4 *= f4;
          f2 *= f2;
          f6 *= f6;
          if (f2 * f6 / (f1 * f1) + f4 < f6)
          {
            f1 = f5 * f5;
            if (f4 + f2 * f1 / (f3 * f3) > f1) {
              return true;
            }
          }
        }
      }
      else if ((arrayOfFloat[0] > this.jdField_b_of_type_AndroidGraphicsRectF.left - f1) && (arrayOfFloat[0] < this.jdField_b_of_type_AndroidGraphicsRectF.right + f1) && (arrayOfFloat[1] > this.jdField_b_of_type_AndroidGraphicsRectF.top - f1) && (arrayOfFloat[1] < this.jdField_b_of_type_AndroidGraphicsRectF.bottom + f1))
      {
        return true;
      }
    }
    else if ((arrayOfFloat[0] > this.jdField_a_of_type_AndroidGraphicsRectF.left - f1) && (arrayOfFloat[0] < this.jdField_a_of_type_AndroidGraphicsRectF.right + f1) && (arrayOfFloat[1] > this.jdField_a_of_type_AndroidGraphicsRectF.top - f1) && (arrayOfFloat[1] < this.jdField_a_of_type_AndroidGraphicsRectF.bottom + f1) && ((arrayOfFloat[0] <= this.jdField_a_of_type_AndroidGraphicsRectF.left + f1) || (arrayOfFloat[0] >= this.jdField_a_of_type_AndroidGraphicsRectF.right - f1) || (arrayOfFloat[1] <= this.jdField_a_of_type_AndroidGraphicsRectF.top + f1) || (arrayOfFloat[1] >= this.jdField_a_of_type_AndroidGraphicsRectF.bottom - f1))) {
      return true;
    }
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return c(paramMotionEvent);
    }
    return b(paramMotionEvent);
  }
  
  public void b(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    paramFloat = a(paramFloat);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(paramFloat);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth(paramFloat);
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape == ShapeOperator.Shape.ARROW)
    {
      this.jdField_a_of_type_AndroidGraphicsPath = a();
      this.jdField_b_of_type_AndroidGraphicsPath = b();
      return;
    }
    e();
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(-this.l);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    localMatrix.mapPoints(arrayOfFloat);
    this.j += arrayOfFloat[0];
    this.k += arrayOfFloat[1];
    d();
    e();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean b(float paramFloat1, float paramFloat2)
  {
    return (this.jdField_e_of_type_Boolean) && (this.jdField_c_of_type_AndroidGraphicsRectF.contains(paramFloat1, paramFloat2));
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    switch (ShapeEffect.1.a[this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape.ordinal()])
    {
    default: 
      return false;
    case 5: 
    case 6: 
      return a(paramInt1, paramInt2);
    }
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(-this.l, this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY());
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramInt1;
    arrayOfFloat[1] = paramInt2;
    localMatrix.mapPoints(arrayOfFloat);
    return (arrayOfFloat[0] > this.jdField_b_of_type_AndroidGraphicsRectF.left) && (arrayOfFloat[0] < this.jdField_b_of_type_AndroidGraphicsRectF.right) && (arrayOfFloat[1] > this.jdField_b_of_type_AndroidGraphicsRectF.top) && (arrayOfFloat[1] < this.jdField_b_of_type_AndroidGraphicsRectF.bottom);
  }
  
  public boolean c(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(-this.l, this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY());
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    localMatrix.mapPoints(arrayOfFloat);
    paramFloat1 = arrayOfFloat[0] - this.jdField_b_of_type_AndroidGraphicsRectF.right;
    paramFloat2 = arrayOfFloat[1] - this.jdField_b_of_type_AndroidGraphicsRectF.bottom;
    return Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2) < this.jdField_d_of_type_Float;
  }
  
  public boolean d(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(-this.l, this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY());
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    localMatrix.mapPoints(arrayOfFloat);
    paramFloat1 = arrayOfFloat[0] - this.jdField_b_of_type_AndroidGraphicsRectF.left;
    paramFloat2 = arrayOfFloat[1] - this.jdField_b_of_type_AndroidGraphicsRectF.top;
    return Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2) < this.jdField_b_of_type_Float;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeEffect
 * JD-Core Version:    0.7.0.1
 */