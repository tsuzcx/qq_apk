import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.15;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class bcwj
  implements beuq
{
  public bcwj(PtvTemplateManager.15 param15) {}
  
  public void onResp(bevm parambevm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Doodle_Strokes_PtvTemplateManager", 2, "onResp url: " + this.a.a.doodleUrl + " resultcode: " + parambevm.c);
    }
    this.a.a.doodleUsable = this.a.this$0.a(this.a.a, false);
    if (this.a.a.doodleUsable) {}
    try
    {
      nof.a(new File(PtvTemplateManager.b, this.a.a.doodleName), PtvTemplateManager.c);
      if (parambevm.jdField_a_of_type_Int == 0)
      {
        Object localObject = this.a.this$0.a();
        if (localObject != null)
        {
          localObject = (bezv)((QQAppInterface)localObject).getManager(193);
          if (((bezv)localObject).a()) {
            ((bezv)localObject).a(this.a.a.doodleUrl, parambevm.jdField_a_of_type_Long);
          }
        }
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localIOException.printStackTrace();
        }
      }
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwj
 * JD-Core Version:    0.7.0.1
 */