import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.view.MotionEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleTextureView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bowb
  extends bown
{
  public static String a;
  public int a;
  public bozt a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "LineLayer";
  }
  
  public bowb(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Bozt = new bozt();
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    bpal localbpal;
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
        localbpal = (bpal)this.jdField_a_of_type_Bozt.a(103);
      } while (localbpal == null);
      localbpal.a(104);
      localbpal.b();
      return;
      this.jdField_a_of_type_Int = 6;
      localbpal = (bpal)this.jdField_a_of_type_Bozt.a(103);
    } while (localbpal == null);
    localbpal.a(105);
    localbpal.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.c, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.d);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_Bozt.d(101);
    }
    while ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int != 4)) {
      return;
    }
    this.jdField_a_of_type_Bozt.d(104);
  }
  
  public Bitmap a()
  {
    return ((bpal)this.jdField_a_of_type_Bozt.a(103)).b;
  }
  
  public bozv a(int paramInt)
  {
    return this.jdField_a_of_type_Bozt.a(paramInt);
  }
  
  public String a()
  {
    return "LineLayer";
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bozt.i();
    ykq.b("LineLayer", "clear over.");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    bpal localbpal = (bpal)this.jdField_a_of_type_Bozt.a(103);
    if (localbpal != null) {
      localbpal.c(paramInt1, paramInt2);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_Bozt.a(paramCanvas, this.jdField_a_of_type_Float);
    h();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    this.jdField_a_of_type_Bozt.b(paramCanvas, paramFloat);
    if (this.jdField_a_of_type_Bozt.a())
    {
      Bitmap localBitmap = this.jdField_a_of_type_Bozt.a;
      if (localBitmap == null) {
        break label94;
      }
      PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
      Paint localPaint = new Paint(1);
      localPaint.setXfermode(localPorterDuffXfermode);
      paramCanvas.save();
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
      paramCanvas.restore();
      this.jdField_a_of_type_Bozt.j();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bozt.c();
      return;
      label94:
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "imgDoodle is null");
      }
    }
  }
  
  public void a(bowc parambowc)
  {
    Bitmap localBitmap = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b();
    bpal localbpal = (bpal)this.jdField_a_of_type_Bozt.a(103);
    if (localbpal != null) {
      localbpal.a(parambowc, this.jdField_a_of_type_Float, localBitmap, this.jdField_a_of_type_AndroidGraphicsRect);
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    ykq.b("LineLayer", "switchImageMode.");
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Bozt.a(paramAppInterface, paramInt2);
  }
  
  public void a(DoodleTextureView paramDoodleTextureView)
  {
    if (paramDoodleTextureView.getVisibility() == 0) {
      paramDoodleTextureView.setOpController(this.jdField_a_of_type_Bozt);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bozt.c();
  }
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    while (this.jdField_a_of_type_Int == 5)
    {
      return this.jdField_a_of_type_Bozt.a(102, paramMotionEvent);
      ykw.a("0X80076BE");
      ykw.b("0X80075CB");
    }
    if (this.jdField_a_of_type_Int == 1) {
      return this.jdField_a_of_type_Bozt.a(101, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 3) {
      return this.jdField_a_of_type_Bozt.a(103, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 4) {
      return this.jdField_a_of_type_Bozt.a(104, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 6) {
      return this.jdField_a_of_type_Bozt.a(105, paramMotionEvent);
    }
    return false;
  }
  
  public byte[] a()
  {
    return ((bpal)this.jdField_a_of_type_Bozt.a(103)).a;
  }
  
  public int b()
  {
    int[] arrayOfInt = this.jdField_a_of_type_Bozt.a();
    int i = arrayOfInt[0];
    return arrayOfInt[1] + i;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Bozt != null) {
      this.jdField_a_of_type_Bozt.b();
    }
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
    ((bpal)this.jdField_a_of_type_Bozt.a(103)).c();
  }
  
  public void c(Canvas paramCanvas)
  {
    this.jdField_a_of_type_Bozt.c(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 6);
  }
  
  public void d()
  {
    bpal localbpal = (bpal)this.jdField_a_of_type_Bozt.a(103);
    if (localbpal != null) {
      localbpal.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bozt.b()) {
      super.k();
    }
  }
  
  public void f()
  {
    ykq.b("LineLayer", "switchMosaicMode.");
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())
    {
      a(4);
      return;
    }
    a(6);
  }
  
  public void g()
  {
    ykq.b("LineLayer", "switchNormalMode.");
    a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bowb
 * JD-Core Version:    0.7.0.1
 */