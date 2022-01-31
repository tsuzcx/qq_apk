import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.CaptureTemplateManager.2;

public class bhhc
  implements axrt
{
  public bhhc(CaptureTemplateManager.2 param2) {}
  
  public void onResp(axsq paramaxsq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaptureTemplateManager", 2, "onResp url: " + this.a.c + " resultcode: " + paramaxsq.c);
    }
    boolean bool = false;
    if (paramaxsq.jdField_a_of_type_Int == 0)
    {
      bool = bhhb.a(this.a.this$0, this.a.a, this.a.b);
      if (bool)
      {
        axxj localaxxj = (axxj)this.a.this$0.a().getManager(193);
        if (localaxxj.a()) {
          localaxxj.a(this.a.c, paramaxsq.jdField_a_of_type_Long);
        }
      }
    }
    if (!bool) {
      bhhb.a(this.a.this$0, this.a.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CaptureTemplateManager", 2, "onResp url: " + this.a.c + " downloadSuccess " + bool);
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhhc
 * JD-Core Version:    0.7.0.1
 */