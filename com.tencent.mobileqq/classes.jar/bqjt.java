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

public class bqjt
  extends bqkj
{
  public static String a;
  public int a;
  public bqnt a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "LineLayer";
  }
  
  public bqjt(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Bqnt = new bqnt();
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    }
    bqol localbqol;
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
        localbqol = (bqol)this.jdField_a_of_type_Bqnt.a(103);
      } while (localbqol == null);
      localbqol.a(104);
      localbqol.b();
      return;
      this.jdField_a_of_type_Int = 6;
      localbqol = (bqol)this.jdField_a_of_type_Bqnt.a(103);
    } while (localbqol == null);
    localbqol.a(105);
    localbqol.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.c, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.d);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_Bqnt.d(101);
    }
    while ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int != 4)) {
      return;
    }
    this.jdField_a_of_type_Bqnt.d(104);
  }
  
  public Bitmap a()
  {
    return ((bqol)this.jdField_a_of_type_Bqnt.a(103)).b;
  }
  
  public bqnv a(int paramInt)
  {
    return this.jdField_a_of_type_Bqnt.a(paramInt);
  }
  
  public String a()
  {
    return "LineLayer";
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bqnt.i();
    yuk.b("LineLayer", "clear over.");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    bqol localbqol = (bqol)this.jdField_a_of_type_Bqnt.a(103);
    if (localbqol != null) {
      localbqol.c(paramInt1, paramInt2);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_Bqnt.a(paramCanvas, this.jdField_a_of_type_Float);
    h();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    this.jdField_a_of_type_Bqnt.b(paramCanvas, paramFloat);
    if (this.jdField_a_of_type_Bqnt.a())
    {
      Bitmap localBitmap = this.jdField_a_of_type_Bqnt.a;
      if (localBitmap == null) {
        break label94;
      }
      PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
      Paint localPaint = new Paint(1);
      localPaint.setXfermode(localPorterDuffXfermode);
      paramCanvas.save();
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
      paramCanvas.restore();
      this.jdField_a_of_type_Bqnt.j();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bqnt.c();
      return;
      label94:
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "imgDoodle is null");
      }
    }
  }
  
  public void a(bqju parambqju)
  {
    Bitmap localBitmap = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b();
    bqol localbqol = (bqol)this.jdField_a_of_type_Bqnt.a(103);
    if (localbqol != null) {
      localbqol.a(parambqju, this.jdField_a_of_type_Float, localBitmap, this.jdField_a_of_type_AndroidGraphicsRect);
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    yuk.b("LineLayer", "switchImageMode.");
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Bqnt.a(paramAppInterface, paramInt2);
  }
  
  public void a(DoodleTextureView paramDoodleTextureView)
  {
    if (paramDoodleTextureView.getVisibility() == 0) {
      paramDoodleTextureView.setOpController(this.jdField_a_of_type_Bqnt);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bqnt.d();
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
      return this.jdField_a_of_type_Bqnt.a(102, paramMotionEvent);
      yuq.a("0X80076BE");
      yuq.b("0X80075CB");
    }
    if (this.jdField_a_of_type_Int == 1) {
      return this.jdField_a_of_type_Bqnt.a(101, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 3) {
      return this.jdField_a_of_type_Bqnt.a(103, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 4) {
      return this.jdField_a_of_type_Bqnt.a(104, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 6) {
      return this.jdField_a_of_type_Bqnt.a(105, paramMotionEvent);
    }
    return false;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    return this.jdField_a_of_type_Bqnt.a(paramJSONObject);
  }
  
  public byte[] a()
  {
    return ((bqol)this.jdField_a_of_type_Bqnt.a(103)).a;
  }
  
  public int b()
  {
    int[] arrayOfInt = this.jdField_a_of_type_Bqnt.a();
    int i = arrayOfInt[0];
    return arrayOfInt[1] + i;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Bqnt != null) {
      this.jdField_a_of_type_Bqnt.b();
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
    ((bqol)this.jdField_a_of_type_Bqnt.a(103)).c();
  }
  
  public void c(Canvas paramCanvas)
  {
    this.jdField_a_of_type_Bqnt.c(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 6);
  }
  
  public void d()
  {
    bqol localbqol = (bqol)this.jdField_a_of_type_Bqnt.a(103);
    if (localbqol != null) {
      localbqol.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bqnt.c()) {
      super.k();
    }
  }
  
  public void f()
  {
    yuk.b("LineLayer", "switchMosaicMode.");
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())
    {
      b(4);
      return;
    }
    b(6);
  }
  
  public void g()
  {
    yuk.b("LineLayer", "switchNormalMode.");
    b(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqjt
 * JD-Core Version:    0.7.0.1
 */