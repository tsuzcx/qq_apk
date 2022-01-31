package com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleOpController;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleOperator;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleTextureView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.MosaicOperator;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class LineLayer
  extends BaseLayer
{
  public int a;
  public DoodleOpController a;
  
  public LineLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController = new DoodleOpController();
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    MosaicOperator localMosaicOperator;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Int = 1;
        return;
        this.jdField_a_of_type_Int = 2;
        return;
        this.jdField_a_of_type_Int = 3;
        return;
        this.jdField_a_of_type_Int = 4;
        localMosaicOperator = (MosaicOperator)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(103);
      } while (localMosaicOperator == null);
      localMosaicOperator.a(104);
      localMosaicOperator.b();
      return;
      this.jdField_a_of_type_Int = 6;
      localMosaicOperator = (MosaicOperator)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(103);
    } while (localMosaicOperator == null);
    localMosaicOperator.a(105);
    localMosaicOperator.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.d(101);
    }
    while ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int != 4)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.d(104);
  }
  
  public int a()
  {
    int[] arrayOfInt = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a();
    int i = arrayOfInt[0];
    return arrayOfInt[1] + i;
  }
  
  public Bitmap a()
  {
    return ((MosaicOperator)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(103)).b;
  }
  
  public DoodleOperator a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(paramInt);
  }
  
  public String a()
  {
    return "LineLayer";
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.i();
    SLog.b("LineLayer", "clear over.");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    MosaicOperator localMosaicOperator = (MosaicOperator)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(103);
    if (localMosaicOperator != null) {
      localMosaicOperator.c(paramInt1, paramInt2);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(paramCanvas, this.jdField_a_of_type_Float);
    j();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.b(paramCanvas, paramFloat);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a())
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a;
      if (localBitmap == null) {
        break label94;
      }
      PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
      Paint localPaint = new Paint(1);
      localPaint.setXfermode(localPorterDuffXfermode);
      paramCanvas.save();
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
      paramCanvas.restore();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.j();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.c();
      return;
      label94:
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "imgDoodle is null");
      }
    }
  }
  
  public void a(LineLayer.LayerEventListener paramLayerEventListener)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b();
    MosaicOperator localMosaicOperator = (MosaicOperator)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(103);
    if (localMosaicOperator != null) {
      localMosaicOperator.a(paramLayerEventListener, this.jdField_a_of_type_Float, localBitmap, this.jdField_a_of_type_AndroidGraphicsRect);
    }
  }
  
  @TargetApi(14)
  public void a(DoodleTextureView paramDoodleTextureView, DoodleView paramDoodleView)
  {
    if (paramDoodleTextureView.getVisibility() == 0) {
      paramDoodleTextureView.setOpController(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController);
    }
    paramDoodleTextureView = (MosaicOperator)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(103);
    if (paramDoodleTextureView != null) {
      paramDoodleTextureView.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    SLog.b("LineLayer", "switchImageMode.");
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(paramAppInterface, paramInt2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.d();
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    while (this.jdField_a_of_type_Int == 5)
    {
      return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(102, paramMotionEvent);
      VideoEditReport.a("0X80076BE");
      VideoEditReport.b("0X80075CB");
    }
    if (this.jdField_a_of_type_Int == 1) {
      return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(101, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 3) {
      return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(103, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 4) {
      return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(104, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 6) {
      return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(105, paramMotionEvent);
    }
    return false;
  }
  
  public byte[] a()
  {
    return ((MosaicOperator)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(103)).a;
  }
  
  public void b()
  {
    ((MosaicOperator)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(103)).c();
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.c()) {
      super.g();
    }
  }
  
  public void c(Canvas paramCanvas)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.c(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 6);
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void d()
  {
    SLog.b("LineLayer", "switchMosaicMode.");
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a())
    {
      a(4);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.g())
    {
      a(6);
      return;
    }
    a(3);
  }
  
  public void e()
  {
    SLog.b("LineLayer", "switchNormalMode.");
    a(1);
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer
 * JD-Core Version:    0.7.0.1
 */