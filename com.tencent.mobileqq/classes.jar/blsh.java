import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.CaptureTemplateManager.2;

public class blsh
  implements baug
{
  public blsh(CaptureTemplateManager.2 param2) {}
  
  public void onResp(bavf parambavf)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaptureTemplateManager", 2, "onResp url: " + this.a.c + " resultcode: " + parambavf.c);
    }
    boolean bool = false;
    if (parambavf.jdField_a_of_type_Int == 0)
    {
      bool = blsg.a(this.a.this$0, this.a.a, this.a.b);
      if (bool)
      {
        bbaa localbbaa = (bbaa)this.a.this$0.a().getManager(193);
        if (localbbaa.a()) {
          localbbaa.a(this.a.c, parambavf.jdField_a_of_type_Long);
        }
      }
    }
    if (!bool) {
      blsg.a(this.a.this$0, this.a.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CaptureTemplateManager", 2, "onResp url: " + this.a.c + " downloadSuccess " + bool);
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blsh
 * JD-Core Version:    0.7.0.1
 */