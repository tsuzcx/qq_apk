import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.4;
import java.io.File;
import java.io.IOException;

public class bnla
  implements bapx
{
  public bnla(QIMPtvTemplateManager.4 param4) {}
  
  public void onResp(baqw parambaqw)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "onResp url: " + this.a.a.resurl + " resultcode: " + parambaqw.c);
    }
    this.a.a.usable = this.a.this$0.a(this.a.a);
    if (this.a.a.usable) {}
    try
    {
      ndr.a(new File(bnkz.a(), this.a.a.name), bnkz.a);
      if (this.a.this$0.a() != null) {
        this.a.this$0.a().notifyObservers(blpe.class, 3, true, null);
      }
      return;
    }
    catch (IOException parambaqw)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          parambaqw.printStackTrace();
        }
      }
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnla
 * JD-Core Version:    0.7.0.1
 */