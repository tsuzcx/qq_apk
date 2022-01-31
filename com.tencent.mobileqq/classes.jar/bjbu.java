import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.CaptureTemplateManager.2;

public class bjbu
  implements aysa
{
  public bjbu(CaptureTemplateManager.2 param2) {}
  
  public void onResp(aysx paramaysx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaptureTemplateManager", 2, "onResp url: " + this.a.c + " resultcode: " + paramaysx.c);
    }
    boolean bool = false;
    if (paramaysx.jdField_a_of_type_Int == 0)
    {
      bool = bjbt.a(this.a.this$0, this.a.a, this.a.b);
      if (bool)
      {
        ayxq localayxq = (ayxq)this.a.this$0.a().getManager(193);
        if (localayxq.a()) {
          localayxq.a(this.a.c, paramaysx.jdField_a_of_type_Long);
        }
      }
    }
    if (!bool) {
      bjbt.a(this.a.this$0, this.a.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CaptureTemplateManager", 2, "onResp url: " + this.a.c + " downloadSuccess " + bool);
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjbu
 * JD-Core Version:    0.7.0.1
 */