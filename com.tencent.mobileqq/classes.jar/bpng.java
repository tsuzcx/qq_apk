import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.CaptureTemplateManager.2;

public class bpng
  implements beuq
{
  public bpng(CaptureTemplateManager.2 param2) {}
  
  public void onResp(bevm parambevm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaptureTemplateManager", 2, "onResp url: " + this.a.c + " resultcode: " + parambevm.c);
    }
    boolean bool = false;
    if (parambevm.jdField_a_of_type_Int == 0)
    {
      bool = bpnf.a(this.a.this$0, this.a.a, this.a.b);
      if (bool)
      {
        bezv localbezv = (bezv)this.a.this$0.a().getManager(193);
        if (localbezv.a()) {
          localbezv.a(this.a.c, parambevm.jdField_a_of_type_Long);
        }
      }
    }
    if (!bool) {
      bpnf.a(this.a.this$0, this.a.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CaptureTemplateManager", 2, "onResp url: " + this.a.c + " downloadSuccess " + bool);
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpng
 * JD-Core Version:    0.7.0.1
 */