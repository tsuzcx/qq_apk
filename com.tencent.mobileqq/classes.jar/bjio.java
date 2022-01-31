import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.4;
import java.io.File;
import java.io.IOException;

public class bjio
  implements axrt
{
  public bjio(QIMPtvTemplateManager.4 param4) {}
  
  public void onResp(axsq paramaxsq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "onResp url: " + this.a.a.resurl + " resultcode: " + paramaxsq.c);
    }
    this.a.a.usable = this.a.this$0.a(this.a.a);
    if (this.a.a.usable) {}
    try
    {
      mpx.a(new File(bjin.a(), this.a.a.name), bjin.a);
      if (this.a.this$0.a() != null) {
        this.a.this$0.a().notifyObservers(bhik.class, 3, true, null);
      }
      return;
    }
    catch (IOException paramaxsq)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          paramaxsq.printStackTrace();
        }
      }
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjio
 * JD-Core Version:    0.7.0.1
 */