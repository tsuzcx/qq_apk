import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.4;
import java.io.File;
import java.io.IOException;

public class bnpm
  implements baug
{
  public bnpm(QIMPtvTemplateManager.4 param4) {}
  
  public void onResp(bavf parambavf)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "onResp url: " + this.a.a.resurl + " resultcode: " + parambavf.c);
    }
    this.a.a.usable = this.a.this$0.a(this.a.a);
    if (this.a.a.usable) {}
    try
    {
      ndr.a(new File(bnpl.a(), this.a.a.name), bnpl.a);
      if (this.a.this$0.a() != null) {
        this.a.this$0.a().notifyObservers(bltq.class, 3, true, null);
      }
      return;
    }
    catch (IOException parambavf)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          parambavf.printStackTrace();
        }
      }
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpm
 * JD-Core Version:    0.7.0.1
 */