import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.widget.TCProgressBar;

public class blds
  extends bldr
{
  public int a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  boolean c;
  public boolean g;
  public boolean h = false;
  
  public blds(TCProgressBar paramTCProgressBar, boolean paramBoolean)
  {
    super(paramTCProgressBar);
    this.jdField_g_of_type_Boolean = false;
    this.c = paramBoolean;
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.c)
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b.left = this.jdField_f_of_type_Int;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b.right = (this.jdField_f_of_type_Int + this.jdField_g_of_type_Int);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_g_of_type_Int);
      paramCanvas.drawRect(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.h);
      super.a(paramCanvas);
      return;
    }
    int i;
    if (this.jdField_f_of_type_Boolean) {
      i = this.jdField_g_of_type_Int;
    }
    for (;;)
    {
      boolean bool = a(this.jdField_a_of_type_Int - 5);
      if (QLog.isColorLevel()) {
        QLog.d("TCProgressBar", 2, "ProgressBlock:hasMorePart=" + this.jdField_a_of_type_Boolean + " bounds=" + bool);
      }
      if ((!this.jdField_a_of_type_Boolean) || (!bool)) {
        break label392;
      }
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b.left = this.jdField_f_of_type_Int;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b.right = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.i);
      paramCanvas.drawRect(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b.left = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b.right = (i + this.jdField_f_of_type_Int);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.j);
      paramCanvas.drawRect(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a);
      break;
      i = this.jdField_g_of_type_Int - this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.l;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b.left = (this.jdField_f_of_type_Int + i);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b.right = (this.jdField_f_of_type_Int + this.jdField_g_of_type_Int);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.k);
      paramCanvas.drawRect(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a);
    }
    label392:
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b.left = this.jdField_f_of_type_Int;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b.right = (i + this.jdField_f_of_type_Int);
    if (this.b) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.j);
    }
    for (;;)
    {
      paramCanvas.drawRect(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a);
      break;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.i);
    }
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt > this.jdField_f_of_type_Int) && (paramInt < this.jdField_f_of_type_Int + this.jdField_g_of_type_Int - this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.l);
  }
  
  public boolean b(int paramInt)
  {
    return (paramInt < this.jdField_f_of_type_Int) || (a(paramInt));
  }
  
  public boolean c(int paramInt)
  {
    return (paramInt > this.jdField_f_of_type_Int + this.jdField_g_of_type_Int) || (a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     blds
 * JD-Core Version:    0.7.0.1
 */