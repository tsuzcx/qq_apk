import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.CaptureTemplateManager.2;

public class blnv
  implements bapx
{
  public blnv(CaptureTemplateManager.2 param2) {}
  
  public void onResp(baqw parambaqw)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaptureTemplateManager", 2, "onResp url: " + this.a.c + " resultcode: " + parambaqw.c);
    }
    boolean bool = false;
    if (parambaqw.jdField_a_of_type_Int == 0)
    {
      bool = blnu.a(this.a.this$0, this.a.a, this.a.b);
      if (bool)
      {
        bavr localbavr = (bavr)this.a.this$0.a().getManager(193);
        if (localbavr.a()) {
          localbavr.a(this.a.c, parambaqw.jdField_a_of_type_Long);
        }
      }
    }
    if (!bool) {
      blnu.a(this.a.this$0, this.a.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CaptureTemplateManager", 2, "onResp url: " + this.a.c + " downloadSuccess " + bool);
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blnv
 * JD-Core Version:    0.7.0.1
 */