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
import org.json.JSONObject;

public class bmmg
  extends bmmw
{
  public static String a;
  public int a;
  public bmqg a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "LineLayer";
  }
  
  public bmmg(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Bmqg = new bmqg();
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    }
    bmqy localbmqy;
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
        localbmqy = (bmqy)this.jdField_a_of_type_Bmqg.a(103);
      } while (localbmqy == null);
      localbmqy.a(104);
      localbmqy.b();
      return;
      this.jdField_a_of_type_Int = 6;
      localbmqy = (bmqy)this.jdField_a_of_type_Bmqg.a(103);
    } while (localbmqy == null);
    localbmqy.a(105);
    localbmqy.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.c, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.d);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_Bmqg.d(101);
    }
    while ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int != 4)) {
      return;
    }
    this.jdField_a_of_type_Bmqg.d(104);
  }
  
  public Bitmap a()
  {
    return ((bmqy)this.jdField_a_of_type_Bmqg.a(103)).b;
  }
  
  public bmqi a(int paramInt)
  {
    return this.jdField_a_of_type_Bmqg.a(paramInt);
  }
  
  public String a()
  {
    return "LineLayer";
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bmqg.i();
    wsv.b("LineLayer", "clear over.");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    bmqy localbmqy = (bmqy)this.jdField_a_of_type_Bmqg.a(103);
    if (localbmqy != null) {
      localbmqy.c(paramInt1, paramInt2);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_Bmqg.a(paramCanvas, this.jdField_a_of_type_Float);
    h();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    this.jdField_a_of_type_Bmqg.b(paramCanvas, paramFloat);
    if (this.jdField_a_of_type_Bmqg.a())
    {
      Bitmap localBitmap = this.jdField_a_of_type_Bmqg.a;
      if (localBitmap == null) {
        break label94;
      }
      PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
      Paint localPaint = new Paint(1);
      localPaint.setXfermode(localPorterDuffXfermode);
      paramCanvas.save();
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
      paramCanvas.restore();
      this.jdField_a_of_type_Bmqg.j();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bmqg.c();
      return;
      label94:
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "imgDoodle is null");
      }
    }
  }
  
  public void a(bmmh parambmmh)
  {
    Bitmap localBitmap = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b();
    bmqy localbmqy = (bmqy)this.jdField_a_of_type_Bmqg.a(103);
    if (localbmqy != null) {
      localbmqy.a(parambmmh, this.jdField_a_of_type_Float, localBitmap, this.jdField_a_of_type_AndroidGraphicsRect);
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    wsv.b("LineLayer", "switchImageMode.");
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Bmqg.a(paramAppInterface, paramInt2);
  }
  
  public void a(DoodleTextureView paramDoodleTextureView)
  {
    if (paramDoodleTextureView.getVisibility() == 0) {
      paramDoodleTextureView.setOpController(this.jdField_a_of_type_Bmqg);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bmqg.d();
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
      return this.jdField_a_of_type_Bmqg.a(102, paramMotionEvent);
      wtb.a("0X80076BE");
      wtb.b("0X80075CB");
    }
    if (this.jdField_a_of_type_Int == 1) {
      return this.jdField_a_of_type_Bmqg.a(101, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 3) {
      return this.jdField_a_of_type_Bmqg.a(103, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 4) {
      return this.jdField_a_of_type_Bmqg.a(104, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 6) {
      return this.jdField_a_of_type_Bmqg.a(105, paramMotionEvent);
    }
    return false;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    return this.jdField_a_of_type_Bmqg.a(paramJSONObject);
  }
  
  public byte[] a()
  {
    return ((bmqy)this.jdField_a_of_type_Bmqg.a(103)).a;
  }
  
  public int b()
  {
    int[] arrayOfInt = this.jdField_a_of_type_Bmqg.a();
    int i = arrayOfInt[0];
    return arrayOfInt[1] + i;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Bmqg != null) {
      this.jdField_a_of_type_Bmqg.b();
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
    ((bmqy)this.jdField_a_of_type_Bmqg.a(103)).c();
  }
  
  public void c(Canvas paramCanvas)
  {
    this.jdField_a_of_type_Bmqg.c(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 6);
  }
  
  public void d()
  {
    bmqy localbmqy = (bmqy)this.jdField_a_of_type_Bmqg.a(103);
    if (localbmqy != null) {
      localbmqy.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bmqg.c()) {
      super.k();
    }
  }
  
  public void f()
  {
    wsv.b("LineLayer", "switchMosaicMode.");
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())
    {
      b(4);
      return;
    }
    b(6);
  }
  
  public void g()
  {
    wsv.b("LineLayer", "switchNormalMode.");
    b(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmg
 * JD-Core Version:    0.7.0.1
 */