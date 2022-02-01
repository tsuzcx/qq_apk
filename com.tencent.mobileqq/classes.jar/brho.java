import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.4;
import java.io.File;
import java.io.IOException;

public class brho
  implements beuq
{
  public brho(QIMPtvTemplateManager.4 param4) {}
  
  public void onResp(bevm parambevm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "onResp url: " + this.a.a.resurl + " resultcode: " + parambevm.c);
    }
    this.a.a.usable = this.a.this$0.a(this.a.a);
    if (this.a.a.usable) {}
    try
    {
      nof.a(new File(brhn.a(), this.a.a.name), brhn.a);
      if (this.a.this$0.a() != null) {
        this.a.this$0.a().notifyObservers(bpop.class, 3, true, null);
      }
      return;
    }
    catch (IOException parambevm)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          parambevm.printStackTrace();
        }
      }
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brho
 * JD-Core Version:    0.7.0.1
 */