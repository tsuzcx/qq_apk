import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.CaptureTemplateManager.2;

public class bjcl
  implements aysc
{
  public bjcl(CaptureTemplateManager.2 param2) {}
  
  public void onResp(aysz paramaysz)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaptureTemplateManager", 2, "onResp url: " + this.a.c + " resultcode: " + paramaysz.c);
    }
    boolean bool = false;
    if (paramaysz.jdField_a_of_type_Int == 0)
    {
      bool = bjck.a(this.a.this$0, this.a.a, this.a.b);
      if (bool)
      {
        ayxs localayxs = (ayxs)this.a.this$0.a().getManager(193);
        if (localayxs.a()) {
          localayxs.a(this.a.c, paramaysz.jdField_a_of_type_Long);
        }
      }
    }
    if (!bool) {
      bjck.a(this.a.this$0, this.a.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CaptureTemplateManager", 2, "onResp url: " + this.a.c + " downloadSuccess " + bool);
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjcl
 * JD-Core Version:    0.7.0.1
 */