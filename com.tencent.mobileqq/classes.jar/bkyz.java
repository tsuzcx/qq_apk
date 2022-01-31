import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.4;
import java.io.File;
import java.io.IOException;

public class bkyz
  implements aysa
{
  public bkyz(QIMPtvTemplateManager.4 param4) {}
  
  public void onResp(aysx paramaysx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "onResp url: " + this.a.a.resurl + " resultcode: " + paramaysx.c);
    }
    this.a.a.usable = this.a.this$0.a(this.a.a);
    if (this.a.a.usable) {}
    try
    {
      nay.a(new File(bkyy.a(), this.a.a.name), bkyy.a);
      if (this.a.this$0.a() != null) {
        this.a.this$0.a().notifyObservers(bjdc.class, 3, true, null);
      }
      return;
    }
    catch (IOException paramaysx)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          paramaysx.printStackTrace();
        }
      }
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkyz
 * JD-Core Version:    0.7.0.1
 */