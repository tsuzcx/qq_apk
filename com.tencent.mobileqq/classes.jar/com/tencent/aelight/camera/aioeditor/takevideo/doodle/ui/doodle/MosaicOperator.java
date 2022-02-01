package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.LineLayer.LayerEventListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DoodleUtil;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MosaicOperator
  implements DoodleOperator
{
  private static final int h = Color.parseColor("#FF000000");
  public float a;
  public int a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public BitmapShader a;
  Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  public Paint a;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  public LineLayer.LayerEventListener a;
  DoodleLayout jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
  DoodleLineListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener;
  public MosaicLinePath a;
  public boolean a;
  public byte[] a;
  public byte[][] a;
  public float b;
  public int b;
  public Bitmap b;
  private boolean b;
  float c;
  public int c;
  public float d;
  public int d;
  public float e;
  public int e;
  int f;
  int g;
  private int i = 103;
  private int j = 0;
  
  public MosaicOperator(DoodleLineListener paramDoodleLineListener)
  {
    this.jdField_a_of_type_Int = 10;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener = paramDoodleLineListener;
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("increaseMask:x=");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(",y=");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(",MosaicMaskWidth:");
    ((StringBuilder)localObject1).append(this.jdField_d_of_type_Int);
    ((StringBuilder)localObject1).append(",MosaicMaskHeight:");
    ((StringBuilder)localObject1).append(this.jdField_e_of_type_Int);
    SLog.b("MosaicOperator", ((StringBuilder)localObject1).toString());
    localObject1 = new int[5];
    int k = 0;
    localObject1[0] = paramInt1;
    localObject1[1] = (paramInt1 - 1);
    localObject1[2] = paramInt1;
    localObject1[3] = (paramInt1 + 1);
    localObject1[4] = paramInt1;
    int[] arrayOfInt = new int[5];
    arrayOfInt[0] = paramInt2;
    arrayOfInt[1] = paramInt2;
    arrayOfInt[2] = (paramInt2 - 1);
    arrayOfInt[3] = paramInt2;
    arrayOfInt[4] = (paramInt2 + 1);
    paramInt1 = k;
    while ((paramInt1 < localObject1.length) && (paramInt1 < arrayOfInt.length))
    {
      paramInt2 = localObject1[paramInt1];
      k = arrayOfInt[paramInt1];
      if ((paramInt2 >= 0) && (k >= 0))
      {
        int m = this.jdField_d_of_type_Int;
        if ((paramInt2 < m) && (k < this.jdField_e_of_type_Int))
        {
          m = m * k + paramInt2;
          Object localObject2 = this.jdField_a_of_type_ArrayOfByte;
          if (localObject2[m] != 127) {
            localObject2[m] = ((byte)(localObject2[m] + 1));
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localObject2 = this.jdField_a_of_type_Array2dOfByte;
            if (localObject2[k][paramInt2] < 127)
            {
              localObject2 = localObject2[k];
              localObject2[paramInt2] = ((byte)(localObject2[paramInt2] + 1));
            }
          }
        }
      }
      paramInt1 += 1;
    }
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("decreaseMask:x=");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(",y=");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(",MosaicMaskWidth:");
    ((StringBuilder)localObject1).append(this.jdField_d_of_type_Int);
    ((StringBuilder)localObject1).append(",MosaicMaskHeight:");
    ((StringBuilder)localObject1).append(this.jdField_e_of_type_Int);
    SLog.b("MosaicOperator", ((StringBuilder)localObject1).toString());
    localObject1 = new int[5];
    int k = 0;
    localObject1[0] = paramInt1;
    localObject1[1] = (paramInt1 - 1);
    localObject1[2] = paramInt1;
    localObject1[3] = (paramInt1 + 1);
    localObject1[4] = paramInt1;
    int[] arrayOfInt = new int[5];
    arrayOfInt[0] = paramInt2;
    arrayOfInt[1] = paramInt2;
    arrayOfInt[2] = (paramInt2 - 1);
    arrayOfInt[3] = paramInt2;
    arrayOfInt[4] = (paramInt2 + 1);
    paramInt1 = k;
    while ((paramInt1 < localObject1.length) && (paramInt1 < arrayOfInt.length))
    {
      paramInt2 = localObject1[paramInt1];
      k = arrayOfInt[paramInt1];
      if ((paramInt2 >= 0) && (k >= 0))
      {
        int m = this.jdField_d_of_type_Int;
        if ((paramInt2 < m) && (k < this.jdField_e_of_type_Int))
        {
          m = m * k + paramInt2;
          Object localObject2 = this.jdField_a_of_type_ArrayOfByte;
          if (localObject2[m] > 0) {
            localObject2[m] = ((byte)(localObject2[m] - 1));
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localObject2 = this.jdField_a_of_type_Array2dOfByte;
            if (localObject2[k][paramInt2] > 0)
            {
              localObject2 = localObject2[k];
              localObject2[paramInt2] = ((byte)(localObject2[paramInt2] - 1));
            }
          }
        }
      }
      paramInt1 += 1;
    }
  }
  
  private void f()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    SLog.b("MosaicOperator", "------------------------------------------------------------------------");
    StringBuilder localStringBuilder1 = new StringBuilder();
    int k = 0;
    while (k < this.jdField_a_of_type_Array2dOfByte.length)
    {
      int m = 0;
      while (m < this.jdField_a_of_type_Array2dOfByte[0].length)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(this.jdField_a_of_type_Array2dOfByte[k][m]);
        localStringBuilder2.append(" ");
        localStringBuilder1.append(localStringBuilder2.toString());
        m += 1;
      }
      SLog.b("MosaicOperator", localStringBuilder1.toString());
      localStringBuilder1.delete(0, localStringBuilder1.length());
      k += 1;
    }
  }
  
  public void a()
  {
    if (this.i == 105)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(h);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.j);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.j);
    BitmapShader localBitmapShader = this.jdField_a_of_type_AndroidGraphicsBitmapShader;
    if (localBitmapShader != null) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(localBitmapShader);
    }
  }
  
  public void a(float paramFloat)
  {
    if (this.i != 105)
    {
      this.j = ((int)paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
      return;
    }
    this.f = paramInt1;
    this.g = paramInt2;
    this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_b_of_type_AndroidGraphicsBitmap);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(Canvas paramCanvas, MosaicLinePath paramMosaicLinePath, float paramFloat)
  {
    if (paramMosaicLinePath.jdField_a_of_type_Int == 103) {
      return;
    }
    if (paramMosaicLinePath.jdField_a_of_type_Int == 104)
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmapShader == null) {
        b();
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(paramMosaicLinePath.jdField_c_of_type_Int);
      BitmapShader localBitmapShader = this.jdField_a_of_type_AndroidGraphicsBitmapShader;
      if (localBitmapShader != null) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setShader(localBitmapShader);
      }
      paramCanvas.drawPath(paramMosaicLinePath.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    if (paramMosaicLinePath.jdField_a_of_type_Int == 105)
    {
      paramCanvas = this.jdField_a_of_type_AndroidGraphicsCanvas;
      if (paramCanvas == null)
      {
        SLog.d("MosaicOperator", "do not init yet");
        return;
      }
      paramCanvas.save();
      this.jdField_a_of_type_AndroidGraphicsCanvas.scale(paramFloat, paramFloat);
      if (this.j == 0) {
        this.j = AIOUtils.b(16.0F, BaseApplicationImpl.getContext().getResources());
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.j);
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(h);
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawPath(paramMosaicLinePath.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsCanvas.restore();
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void a(LineLayer.LayerEventListener paramLayerEventListener, float paramFloat, Bitmap paramBitmap, Rect paramRect)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerLineLayer$LayerEventListener = paramLayerEventListener;
    this.jdField_c_of_type_Float = paramFloat;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
  }
  
  public void a(DoodleLayout paramDoodleLayout)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout = paramDoodleLayout;
  }
  
  public void a(MosaicLinePath paramMosaicLinePath)
  {
    if (paramMosaicLinePath.jdField_a_of_type_Int == 103)
    {
      DoodleLayout.a("delete_mosaics");
      VideoEditReport.a("0X80076C2");
      List localList = paramMosaicLinePath.jdField_a_of_type_JavaUtilList;
      paramMosaicLinePath = paramMosaicLinePath.b;
      int k = 0;
      while ((k < localList.size()) && (k < paramMosaicLinePath.size()))
      {
        e(((Integer)localList.get(k)).intValue(), ((Integer)paramMosaicLinePath.get(k)).intValue());
        k += 1;
      }
      c();
      return;
    }
    if (paramMosaicLinePath.jdField_a_of_type_Int == 104)
    {
      VideoEditReport.b("0X80075CF");
      return;
    }
    if (paramMosaicLinePath.jdField_a_of_type_Int == 105)
    {
      a(true);
      DoodleLayout.a("delete_mosaics");
      VideoEditReport.a("0X80076C2");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.i == 105) && (this.jdField_a_of_type_AndroidGraphicsCanvas != null))
    {
      SLog.a("MosaicOperator", "clearMp4MosaicCanvasAndDraw notify=%s", Boolean.valueOf(paramBoolean));
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(localPaint);
      this.jdField_b_of_type_Boolean = true;
      if (paramBoolean) {
        c();
      }
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int k = paramMotionEvent.getAction();
    int m;
    float f3;
    float f4;
    if (k != 0)
    {
      int i1;
      int n;
      if (k != 1)
      {
        if (k != 2) {
          return true;
        }
        k = this.i;
        if (k == 103)
        {
          k = ((Integer)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilList.size() - 1)).intValue();
          m = ((Integer)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.b.get(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.b.size() - 1)).intValue();
          f3 = this.jdField_b_of_type_Float;
          i1 = this.jdField_a_of_type_Int;
          n = (int)(f1 * f3 / i1);
          i1 = (int)(f2 * f3 / i1);
          if (((n != k) || (i1 != m)) && (n >= 0) && (i1 >= 0))
          {
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(n));
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.b.add(Integer.valueOf(i1));
            d(n, i1);
            c();
            return true;
          }
        }
        else
        {
          if (k == 104)
          {
            f3 = (this.jdField_d_of_type_Float + f1) / 2.0F;
            f4 = (this.jdField_e_of_type_Float + f2) / 2.0F;
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.jdField_d_of_type_Float, this.jdField_e_of_type_Float, f3, f4);
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilArrayList.add(new PointAction(PointAction.jdField_c_of_type_Int, this.jdField_d_of_type_Float, this.jdField_e_of_type_Float, f3, f4));
            this.jdField_d_of_type_Float = f1;
            this.jdField_e_of_type_Float = f2;
            return true;
          }
          if (k == 105)
          {
            f3 = (this.jdField_d_of_type_Float + f1) / 2.0F;
            f4 = (this.jdField_e_of_type_Float + f2) / 2.0F;
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.jdField_d_of_type_Float, this.jdField_e_of_type_Float, f3, f4);
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilArrayList.add(new PointAction(PointAction.jdField_c_of_type_Int, this.jdField_d_of_type_Float, this.jdField_e_of_type_Float, f3, f4));
            this.jdField_d_of_type_Float = f1;
            this.jdField_e_of_type_Float = f2;
            return true;
          }
        }
      }
      else if (this.i == 103)
      {
        k = ((Integer)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilList.size() - 1)).intValue();
        m = ((Integer)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.b.get(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.b.size() - 1)).intValue();
        f3 = this.jdField_b_of_type_Float;
        i1 = this.jdField_a_of_type_Int;
        n = (int)(f1 * f3 / i1);
        i1 = (int)(f2 * f3 / i1);
        if (((n != k) || (i1 != m)) && (n >= 0) && (i1 >= 0))
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(n));
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.b.add(Integer.valueOf(i1));
          d(n, i1);
          c();
          return true;
        }
      }
    }
    else
    {
      this.jdField_d_of_type_Float = f1;
      this.jdField_e_of_type_Float = f2;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath = new MosaicLinePath(this.i, this.j);
      paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener;
      if (paramMotionEvent != null) {
        paramMotionEvent.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath);
      }
      k = this.i;
      if (k == 103)
      {
        DoodleLayout.a("use_mosaics");
        VideoEditReport.a("0X80076C1");
        f3 = this.jdField_b_of_type_Float;
        m = this.jdField_a_of_type_Int;
        k = (int)(f1 * f3 / m);
        m = (int)(f2 * f3 / m);
        if ((k >= 0) && (m >= 0))
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(k));
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.b.add(Integer.valueOf(m));
          d(k, m);
          c();
          return true;
        }
      }
      else
      {
        if (k == 104)
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_AndroidGraphicsPath.reset();
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, f2);
          paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_AndroidGraphicsPath;
          f3 = f1 + 1.0F;
          f4 = 1.0F + f2;
          paramMotionEvent.lineTo(f3, f4);
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilArrayList.add(new PointAction(PointAction.jdField_a_of_type_Int, f1, f2));
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilArrayList.add(new PointAction(PointAction.jdField_b_of_type_Int, f3, f4));
          return true;
        }
        if (k == 105)
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_AndroidGraphicsPath.reset();
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, f2);
          paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_AndroidGraphicsPath;
          f3 = f1 + 1.0F;
          f4 = 1.0F + f2;
          paramMotionEvent.lineTo(f3, f4);
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilArrayList.add(new PointAction(PointAction.jdField_a_of_type_Int, f1, f2));
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilArrayList.add(new PointAction(PointAction.jdField_b_of_type_Int, f3, f4));
        }
      }
    }
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmapShader != null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
    if (localObject1 != null) {
      localObject1 = ((DoodleLayout)localObject1).b();
    } else {
      localObject1 = null;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a.a();
    int m = Math.min(this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height());
    int k = 8;
    if (m / 8 < 28) {
      k = 2;
    }
    try
    {
      localObject1 = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsRect.width() / k, this.jdField_a_of_type_AndroidGraphicsRect.height() / k, Bitmap.Config.RGB_565);
      float f1 = k;
      float f2 = 1.0F / f1;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("initMosaicPicMode -- contentBounds=");
      ((StringBuilder)localObject3).append(localObject2);
      SLog.c("MosaicOperator", ((StringBuilder)localObject3).toString());
      localObject3 = new RectF(0.0F, 0.0F, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      if (localObject2 != null)
      {
        localMatrix = new Matrix();
        localMatrix.postScale(f2, f2);
        localMatrix.mapRect((RectF)localObject3, (RectF)localObject2);
      }
      SLog.a("MosaicOperator", "init matrix. scale[%f, %f].", Float.valueOf(f2), Float.valueOf(f2));
      new Canvas((Bitmap)localObject1).drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, (RectF)localObject3, null);
      m = Math.min(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight()) / 28;
      k = m;
      if (m == 0) {
        k = 1;
      }
      DoodleUtil.a((Bitmap)localObject1, k);
      localObject2 = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height(), Bitmap.Config.RGB_565);
      if (localObject2 == null)
      {
        ((Bitmap)localObject1).recycle();
        if (QLog.isColorLevel()) {
          QLog.e("MosaicOperator", 2, "failed to create mosaic bitmap");
        }
        return;
      }
      localObject3 = new Canvas((Bitmap)localObject2);
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f1, f1);
      ((Canvas)localObject3).drawBitmap((Bitmap)localObject1, localMatrix, null);
      ((Bitmap)localObject1).recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmapShader = new BitmapShader((Bitmap)localObject2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      SLog.c("MosaicOperator", "initMosaicPicMode.", localIllegalArgumentException);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      SLog.c("MosaicOperator", "initMosaicPicMode.", localOutOfMemoryError);
    }
  }
  
  public void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set MosaicSize:");
    localStringBuilder.append(paramInt);
    SLog.b("MosaicOperator", localStringBuilder.toString());
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("standardWidth:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",standardHeight:");
    localStringBuilder.append(paramInt2);
    SLog.b("MosaicOperator", localStringBuilder.toString());
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
  }
  
  public void c()
  {
    LineLayer.LayerEventListener localLayerEventListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerLineLayer$LayerEventListener;
    if (localLayerEventListener != null) {
      if (this.i == 105) {
        localLayerEventListener.a(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_Boolean);
      } else {
        localLayerEventListener.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      }
    }
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Boolean) {
      f();
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    float f2 = this.jdField_b_of_type_Int;
    float f1 = paramInt1;
    this.jdField_a_of_type_Float = (f2 / f1);
    this.jdField_b_of_type_Float = (this.jdField_c_of_type_Int / paramInt2);
    if (this.jdField_b_of_type_Float <= 0.0F)
    {
      SLog.e("MosaicOperator", "mosaicHeightScale <= 0.");
      this.jdField_b_of_type_Float = this.jdField_c_of_type_Float;
    }
    f2 = this.jdField_b_of_type_Float;
    paramInt1 = this.jdField_a_of_type_Int;
    this.jdField_d_of_type_Int = ((int)(f1 * f2 / paramInt1));
    this.jdField_e_of_type_Int = ((int)(this.jdField_c_of_type_Int / paramInt1));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("create mosaic mask array, width:");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
    ((StringBuilder)localObject).append(",height:");
    ((StringBuilder)localObject).append(this.jdField_e_of_type_Int);
    ((StringBuilder)localObject).append(",array length:");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Int * this.jdField_e_of_type_Int);
    SLog.b("MosaicOperator", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_d_of_type_Int * this.jdField_e_of_type_Int];
    paramInt1 = 0;
    for (;;)
    {
      localObject = this.jdField_a_of_type_ArrayOfByte;
      if (paramInt1 >= localObject.length) {
        break;
      }
      localObject[paramInt1] = 0;
      paramInt1 += 1;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Array2dOfByte = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { this.jdField_e_of_type_Int, this.jdField_d_of_type_Int }));
      paramInt1 = 0;
      while (paramInt1 < this.jdField_e_of_type_Int)
      {
        paramInt2 = 0;
        while (paramInt2 < this.jdField_d_of_type_Int)
        {
          this.jdField_a_of_type_Array2dOfByte[paramInt1][paramInt2] = 0;
          paramInt2 += 1;
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicLinePath = new MosaicLinePath(this.i, this.j);
    int k = this.i;
    if (k == 104) {
      return;
    }
    if (k == 105)
    {
      a(true);
      return;
    }
    Object localObject;
    if (this.jdField_a_of_type_ArrayOfByte != null)
    {
      k = 0;
      for (;;)
      {
        localObject = this.jdField_a_of_type_ArrayOfByte;
        if (k >= localObject.length) {
          break;
        }
        localObject[k] = 0;
        k += 1;
      }
    }
    if (this.jdField_a_of_type_Boolean)
    {
      k = 0;
      while (k < this.jdField_a_of_type_Array2dOfByte.length)
      {
        int m = 0;
        for (;;)
        {
          localObject = this.jdField_a_of_type_Array2dOfByte;
          if (m >= localObject[0].length) {
            break;
          }
          localObject[k][m] = 0;
          m += 1;
        }
        k += 1;
      }
    }
    c();
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmapShader = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.MosaicOperator
 * JD-Core Version:    0.7.0.1
 */