import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.CaptureTemplateManager.2;

public class boll
  implements bdvw
{
  public boll(CaptureTemplateManager.2 param2) {}
  
  public void onResp(bdwt parambdwt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaptureTemplateManager", 2, "onResp url: " + this.a.c + " resultcode: " + parambdwt.c);
    }
    boolean bool = false;
    if (parambdwt.jdField_a_of_type_Int == 0)
    {
      bool = bolk.a(this.a.this$0, this.a.a, this.a.b);
      if (bool)
      {
        beaw localbeaw = (beaw)this.a.this$0.a().getManager(193);
        if (localbeaw.a()) {
          localbeaw.a(this.a.c, parambdwt.jdField_a_of_type_Long);
        }
      }
    }
    if (!bool) {
      bolk.a(this.a.this$0, this.a.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CaptureTemplateManager", 2, "onResp url: " + this.a.c + " downloadSuccess " + bool);
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boll
 * JD-Core Version:    0.7.0.1
 */