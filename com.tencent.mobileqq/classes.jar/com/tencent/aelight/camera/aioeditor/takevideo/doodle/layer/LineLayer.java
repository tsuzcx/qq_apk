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
  public int a = 1;
  public final DoodleOpController b = new DoodleOpController(this.y);
  private boolean c = false;
  private Matrix d = new Matrix();
  private float[] e = new float[2];
  private ScaleGestureDetector f = new ScaleGestureDetector(this.y, new LineLayer.ScaleDetectorListener(this, null));
  private int g = -1;
  private int h = 1;
  
  public LineLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    return this.f.onTouchEvent(paramMotionEvent);
  }
  
  private boolean e(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.g = paramMotionEvent.getPointerId(0);
    }
    if (this.g != paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())) {
      return false;
    }
    if (i == 0)
    {
      VideoEditReport.a("0X80076BE");
      VideoEditReport.b("0X80075CB");
    }
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    this.e[0] = paramMotionEvent.getX();
    this.e[1] = paramMotionEvent.getY();
    this.d.mapPoints(this.e);
    float[] arrayOfFloat = this.e;
    localMotionEvent.setLocation(arrayOfFloat[0], arrayOfFloat[1]);
    if ((i == 6) && (this.g == paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()))) {
      localMotionEvent.setAction(1);
    }
    boolean bool = f(localMotionEvent);
    localMotionEvent.recycle();
    return bool;
  }
  
  private boolean f(MotionEvent paramMotionEvent)
  {
    int i = this.a;
    if (i == 5) {
      return this.b.a(102, paramMotionEvent);
    }
    if (i == 1) {
      return this.b.a(101, paramMotionEvent);
    }
    if (i == 3) {
      return this.b.a(103, paramMotionEvent);
    }
    if (i == 4) {
      return this.b.a(104, paramMotionEvent);
    }
    if (i == 6) {
      return this.b.a(105, paramMotionEvent);
    }
    if (i == 2) {
      return this.b.a(111, paramMotionEvent);
    }
    return false;
  }
  
  private void r()
  {
    int i = this.a;
    if (i == 1)
    {
      this.b.e(101);
      return;
    }
    if (i == 2)
    {
      this.b.h().c();
      return;
    }
    if (i == 4) {
      this.b.e(104);
    }
  }
  
  public String a()
  {
    return "LineLayer";
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
        this.a = 6;
        localObject = (MosaicOperator)this.b.a(103);
        if (localObject != null)
        {
          ((MosaicOperator)localObject).a(105);
          ((MosaicOperator)localObject).a(this.z.e, this.z.f);
        }
      }
      else
      {
        this.a = 4;
        localObject = (MosaicOperator)this.b.a(103);
        if (localObject != null)
        {
          ((MosaicOperator)localObject).a(104);
          ((MosaicOperator)localObject).b();
        }
      }
    }
    else
    {
      this.a = paramInt;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    MosaicOperator localMosaicOperator = (MosaicOperator)this.b.a(103);
    if (localMosaicOperator != null) {
      localMosaicOperator.c(paramInt1, paramInt2);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.concat(this.L);
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
    this.b.a(paramCanvas, this.J);
    if (i != 0) {
      paramCanvas.restore();
    }
    paramCanvas.restore();
    r();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    this.b.b(paramCanvas, paramFloat);
    if (this.b.g())
    {
      Bitmap localBitmap = this.b.a;
      if (localBitmap != null)
      {
        PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
        Paint localPaint = new Paint(1);
        localPaint.setXfermode(localPorterDuffXfermode);
        paramCanvas.save();
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
        paramCanvas.restore();
        this.b.s();
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("LineLayer", 2, "imgDoodle is null");
      }
      this.b.e();
    }
  }
  
  public void a(Matrix paramMatrix)
  {
    super.a(paramMatrix);
    this.L.invert(this.d);
    paramMatrix = this.b;
    if (paramMatrix != null) {
      paramMatrix.a(this.L);
    }
  }
  
  public void a(LineLayer.LayerEventListener paramLayerEventListener)
  {
    Bitmap localBitmap = this.z.l.getEditPicRawImageBitmap();
    MosaicOperator localMosaicOperator = (MosaicOperator)this.b.a(103);
    if (localMosaicOperator != null) {
      localMosaicOperator.a(paramLayerEventListener, this.J, localBitmap, this.B);
    }
  }
  
  public void a(DoodleTextureView paramDoodleTextureView)
  {
    if (paramDoodleTextureView.getVisibility() == 0) {
      paramDoodleTextureView.setOpController(this.b);
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    SLog.b("LineLayer", "switchImageMode.");
    this.a = 5;
    this.b.a(paramAppInterface, paramInt2);
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setIsPassiveActivation: ");
    localStringBuilder.append(paramBoolean);
    AEQLog.b("LineLayer", localStringBuilder.toString());
    this.c = paramBoolean;
  }
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((this.z != null) && (this.z.l.e()))
    {
      int j = paramMotionEvent.getActionMasked();
      boolean bool2 = false;
      boolean bool1 = false;
      boolean bool3;
      if (j == 0)
      {
        this.h = 1;
        bool3 = e(paramMotionEvent);
        bool2 = c(paramMotionEvent);
        if ((bool3) || (bool2)) {
          bool1 = true;
        }
        return bool1;
      }
      if (this.h == 1)
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
          this.h = 3;
          e(localMotionEvent);
        }
        else if (i == 0)
        {
          AEQLog.b("LineLayer", "recognize this gesture as DRAW");
          this.h = 2;
          c(localMotionEvent);
        }
        localMotionEvent.recycle();
      }
      int i = this.h;
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
        this.h = 1;
      }
      return bool1;
    }
    return e(paramMotionEvent);
  }
  
  public DoodleOperator b(int paramInt)
  {
    return this.b.a(paramInt);
  }
  
  public void b()
  {
    this.b.o();
    SLog.b("LineLayer", "clear over.");
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.J);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void c(Canvas paramCanvas)
  {
    this.b.c(paramCanvas, this.J);
  }
  
  public boolean c()
  {
    return this.b.p();
  }
  
  public boolean d()
  {
    return false;
  }
  
  public int e()
  {
    return -100;
  }
  
  public void f()
  {
    super.f();
    DoodleOpController localDoodleOpController = this.b;
    if (localDoodleOpController != null) {
      localDoodleOpController.d();
    }
  }
  
  public void g()
  {
    ((MosaicOperator)this.b.a(103)).c();
  }
  
  public void h()
  {
    MosaicOperator localMosaicOperator = (MosaicOperator)this.b.a(103);
    if (localMosaicOperator != null) {
      localMosaicOperator.a(this.z.l);
    }
  }
  
  public boolean i()
  {
    return this.c;
  }
  
  public void j()
  {
    if (this.b.m()) {
      super.u();
    }
  }
  
  public void k()
  {
    SLog.b("LineLayer", "switchMosaicMode.");
    if (this.z.h.b())
    {
      a(4);
      return;
    }
    a(6);
  }
  
  public void l()
  {
    SLog.b("LineLayer", "switchNormalMode.");
    a(1);
  }
  
  public boolean m()
  {
    return this.a == 1;
  }
  
  public boolean n()
  {
    int i = this.a;
    return (i == 3) || (i == 4) || (i == 6);
  }
  
  public int o()
  {
    int[] arrayOfInt = this.b.q();
    return arrayOfInt[0] + arrayOfInt[1];
  }
  
  public byte[] p()
  {
    return ((MosaicOperator)this.b.a(103)).a;
  }
  
  public Bitmap q()
  {
    return ((MosaicOperator)this.b.a(103)).v;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.LineLayer
 * JD-Core Version:    0.7.0.1
 */