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

public class bkaw
  extends bkbm
{
  public static String a;
  public int a;
  public bkew a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "LineLayer";
  }
  
  public bkaw(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Bkew = new bkew();
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    }
    bkfo localbkfo;
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
        localbkfo = (bkfo)this.jdField_a_of_type_Bkew.a(103);
      } while (localbkfo == null);
      localbkfo.a(104);
      localbkfo.b();
      return;
      this.jdField_a_of_type_Int = 6;
      localbkfo = (bkfo)this.jdField_a_of_type_Bkew.a(103);
    } while (localbkfo == null);
    localbkfo.a(105);
    localbkfo.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.c, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.d);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_Bkew.d(101);
    }
    while ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int != 4)) {
      return;
    }
    this.jdField_a_of_type_Bkew.d(104);
  }
  
  public Bitmap a()
  {
    return ((bkfo)this.jdField_a_of_type_Bkew.a(103)).b;
  }
  
  public bkey a(int paramInt)
  {
    return this.jdField_a_of_type_Bkew.a(paramInt);
  }
  
  public String a()
  {
    return "LineLayer";
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bkew.i();
    ved.b("LineLayer", "clear over.");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    bkfo localbkfo = (bkfo)this.jdField_a_of_type_Bkew.a(103);
    if (localbkfo != null) {
      localbkfo.c(paramInt1, paramInt2);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_Bkew.a(paramCanvas, this.jdField_a_of_type_Float);
    h();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    this.jdField_a_of_type_Bkew.b(paramCanvas, paramFloat);
    if (this.jdField_a_of_type_Bkew.a())
    {
      Bitmap localBitmap = this.jdField_a_of_type_Bkew.a;
      if (localBitmap == null) {
        break label94;
      }
      PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
      Paint localPaint = new Paint(1);
      localPaint.setXfermode(localPorterDuffXfermode);
      paramCanvas.save();
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
      paramCanvas.restore();
      this.jdField_a_of_type_Bkew.j();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkew.c();
      return;
      label94:
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "imgDoodle is null");
      }
    }
  }
  
  public void a(bkax parambkax)
  {
    Bitmap localBitmap = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b();
    bkfo localbkfo = (bkfo)this.jdField_a_of_type_Bkew.a(103);
    if (localbkfo != null) {
      localbkfo.a(parambkax, this.jdField_a_of_type_Float, localBitmap, this.jdField_a_of_type_AndroidGraphicsRect);
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    ved.b("LineLayer", "switchImageMode.");
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Bkew.a(paramAppInterface, paramInt2);
  }
  
  public void a(DoodleTextureView paramDoodleTextureView)
  {
    if (paramDoodleTextureView.getVisibility() == 0) {
      paramDoodleTextureView.setOpController(this.jdField_a_of_type_Bkew);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bkew.d();
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
      return this.jdField_a_of_type_Bkew.a(102, paramMotionEvent);
      vej.a("0X80076BE");
      vej.b("0X80075CB");
    }
    if (this.jdField_a_of_type_Int == 1) {
      return this.jdField_a_of_type_Bkew.a(101, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 3) {
      return this.jdField_a_of_type_Bkew.a(103, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 4) {
      return this.jdField_a_of_type_Bkew.a(104, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 6) {
      return this.jdField_a_of_type_Bkew.a(105, paramMotionEvent);
    }
    return false;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    return this.jdField_a_of_type_Bkew.a(paramJSONObject);
  }
  
  public byte[] a()
  {
    return ((bkfo)this.jdField_a_of_type_Bkew.a(103)).a;
  }
  
  public int b()
  {
    int[] arrayOfInt = this.jdField_a_of_type_Bkew.a();
    int i = arrayOfInt[0];
    return arrayOfInt[1] + i;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Bkew != null) {
      this.jdField_a_of_type_Bkew.b();
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
    ((bkfo)this.jdField_a_of_type_Bkew.a(103)).c();
  }
  
  public void c(Canvas paramCanvas)
  {
    this.jdField_a_of_type_Bkew.c(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 6);
  }
  
  public void d()
  {
    bkfo localbkfo = (bkfo)this.jdField_a_of_type_Bkew.a(103);
    if (localbkfo != null) {
      localbkfo.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bkew.c()) {
      super.k();
    }
  }
  
  public void f()
  {
    ved.b("LineLayer", "switchMosaicMode.");
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())
    {
      b(4);
      return;
    }
    b(6);
  }
  
  public void g()
  {
    ved.b("LineLayer", "switchNormalMode.");
    b(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkaw
 * JD-Core Version:    0.7.0.1
 */