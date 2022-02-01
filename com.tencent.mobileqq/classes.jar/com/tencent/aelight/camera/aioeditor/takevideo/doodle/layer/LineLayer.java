package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleOpController;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleOperator;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleTextureView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.EraserOperator;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.MosaicOperator;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScaleGestureDetector;

public class LineLayer
  extends BaseLayer
{
  public int a;
  public final DoodleOpController a;
  private ScaleGestureDetector jdField_a_of_type_ComTencentWidgetScaleGestureDetector = new ScaleGestureDetector(this.jdField_a_of_type_AndroidContentContext, new LineLayer.ScaleDetectorListener(this, null));
  private boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[2];
  private int jdField_b_of_type_Int = -1;
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  private int c = 1;
  
  public LineLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController = new DoodleOpController(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_ComTencentWidgetScaleGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  private boolean e(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.jdField_b_of_type_Int = paramMotionEvent.getPointerId(0);
    }
    if (this.jdField_b_of_type_Int != paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())) {
      return false;
    }
    if (i == 0)
    {
      VideoEditReport.a("0X80076BE");
      VideoEditReport.b("0X80075CB");
    }
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    this.jdField_a_of_type_ArrayOfFloat[0] = paramMotionEvent.getX();
    this.jdField_a_of_type_ArrayOfFloat[1] = paramMotionEvent.getY();
    this.jdField_b_of_type_AndroidGraphicsMatrix.mapPoints(this.jdField_a_of_type_ArrayOfFloat);
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    localMotionEvent.setLocation(arrayOfFloat[0], arrayOfFloat[1]);
    if ((i == 6) && (this.jdField_b_of_type_Int == paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()))) {
      localMotionEvent.setAction(1);
    }
    boolean bool = f(localMotionEvent);
    localMotionEvent.recycle();
    return bool;
  }
  
  private boolean f(MotionEvent paramMotionEvent)
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 5) {
      return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a(102, paramMotionEvent);
    }
    if (i == 1) {
      return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a(101, paramMotionEvent);
    }
    if (i == 3) {
      return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a(103, paramMotionEvent);
    }
    if (i == 4) {
      return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a(104, paramMotionEvent);
    }
    if (i == 6) {
      return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a(105, paramMotionEvent);
    }
    if (i == 2) {
      return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a(111, paramMotionEvent);
    }
    return false;
  }
  
  private void h()
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.d(101);
      return;
    }
    if (i == 2)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a().a();
      return;
    }
    if (i == 4) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.d(104);
    }
  }
  
  public int a()
  {
    return -100;
  }
  
  public Bitmap a()
  {
    return ((MosaicOperator)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a(103)).b;
  }
  
  public DoodleOperator a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a(paramInt);
  }
  
  public String a()
  {
    return "LineLayer";
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.i();
    SLog.b("LineLayer", "clear over.");
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
    {
      Object localObject;
      if (paramInt != 4)
      {
        if (paramInt != 6)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setMode---invalid mode: ");
          ((StringBuilder)localObject).append(paramInt);
          AEQLog.d("LineLayer", ((StringBuilder)localObject).toString());
          return;
        }
        this.jdField_a_of_type_Int = 6;
        localObject = (MosaicOperator)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a(103);
        if (localObject != null)
        {
          ((MosaicOperator)localObject).a(105);
          ((MosaicOperator)localObject).a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.c, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.d);
        }
      }
      else
      {
        this.jdField_a_of_type_Int = 4;
        localObject = (MosaicOperator)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a(103);
        if (localObject != null)
        {
          ((MosaicOperator)localObject).a(104);
          ((MosaicOperator)localObject).b();
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    MosaicOperator localMosaicOperator = (MosaicOperator)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a(103);
    if (localMosaicOperator != null) {
      localMosaicOperator.c(paramInt1, paramInt2);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_AndroidGraphicsMatrix);
    int i;
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null);
      i = 1;
    }
    else
    {
      i = 0;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a(paramCanvas, this.jdField_a_of_type_Float);
    if (i != 0) {
      paramCanvas.restore();
    }
    paramCanvas.restore();
    h();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.b(paramCanvas, paramFloat);
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a())
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a;
      if (localBitmap != null)
      {
        PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
        Paint localPaint = new Paint(1);
        localPaint.setXfermode(localPorterDuffXfermode);
        paramCanvas.save();
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
        paramCanvas.restore();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.j();
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("LineLayer", 2, "imgDoodle is null");
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.c();
    }
  }
  
  public void a(Matrix paramMatrix)
  {
    super.a(paramMatrix);
    this.jdField_a_of_type_AndroidGraphicsMatrix.invert(this.jdField_b_of_type_AndroidGraphicsMatrix);
    paramMatrix = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController;
    if (paramMatrix != null) {
      paramMatrix.a(this.jdField_a_of_type_AndroidGraphicsMatrix);
    }
  }
  
  public void a(LineLayer.LayerEventListener paramLayerEventListener)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.b();
    MosaicOperator localMosaicOperator = (MosaicOperator)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a(103);
    if (localMosaicOperator != null) {
      localMosaicOperator.a(paramLayerEventListener, this.jdField_a_of_type_Float, localBitmap, this.jdField_a_of_type_AndroidGraphicsRect);
    }
  }
  
  public void a(DoodleTextureView paramDoodleTextureView)
  {
    if (paramDoodleTextureView.getVisibility() == 0) {
      paramDoodleTextureView.setOpController(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController);
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    SLog.b("LineLayer", "switchImageMode.");
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a(paramAppInterface, paramInt2);
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setIsPassiveActivation: ");
    localStringBuilder.append(paramBoolean);
    AEQLog.b("LineLayer", localStringBuilder.toString());
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.c();
  }
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a()))
    {
      int j = paramMotionEvent.getActionMasked();
      boolean bool2 = false;
      boolean bool1 = false;
      boolean bool3;
      if (j == 0)
      {
        this.c = 1;
        bool3 = e(paramMotionEvent);
        bool2 = c(paramMotionEvent);
        if ((bool3) || (bool2)) {
          bool1 = true;
        }
        return bool1;
      }
      if (this.c == 1)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        localMotionEvent.setAction(3);
        if (paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime() <= 100L) {
          i = 1;
        } else {
          i = 0;
        }
        if ((j == 5) && (i != 0))
        {
          AEQLog.b("LineLayer", "recognize this gesture as SCALE");
          this.c = 3;
          e(localMotionEvent);
        }
        else if (i == 0)
        {
          AEQLog.b("LineLayer", "recognize this gesture as DRAW");
          this.c = 2;
          c(localMotionEvent);
        }
        localMotionEvent.recycle();
      }
      int i = this.c;
      if (i == 3)
      {
        bool1 = c(paramMotionEvent);
      }
      else if (i == 2)
      {
        bool1 = e(paramMotionEvent);
      }
      else
      {
        bool1 = bool2;
        if (i == 1)
        {
          bool1 = e(paramMotionEvent);
          bool3 = c(paramMotionEvent);
          if (!bool1)
          {
            bool1 = bool2;
            if (!bool3) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
      if (j == 1) {
        this.c = 1;
      }
      return bool1;
    }
    return e(paramMotionEvent);
  }
  
  public byte[] a()
  {
    return ((MosaicOperator)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a(103)).a;
  }
  
  public int b()
  {
    int[] arrayOfInt = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a();
    return arrayOfInt[0] + arrayOfInt[1];
  }
  
  public void b()
  {
    super.b();
    DoodleOpController localDoodleOpController = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController;
    if (localDoodleOpController != null) {
      localDoodleOpController.b();
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void c(Canvas paramCanvas)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.c(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void d()
  {
    MosaicOperator localMosaicOperator = (MosaicOperator)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a(103);
    if (localMosaicOperator != null) {
      localMosaicOperator.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout);
    }
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.b()) {
      super.k();
    }
  }
  
  public boolean e()
  {
    int i = this.jdField_a_of_type_Int;
    return (i == 3) || (i == 4) || (i == 6);
  }
  
  public void f()
  {
    SLog.b("LineLayer", "switchMosaicMode.");
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a())
    {
      a(4);
      return;
    }
    a(6);
  }
  
  public void g()
  {
    SLog.b("LineLayer", "switchNormalMode.");
    a(1);
  }
  
  public void y_()
  {
    ((MosaicOperator)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController.a(103)).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.LineLayer
 * JD-Core Version:    0.7.0.1
 */