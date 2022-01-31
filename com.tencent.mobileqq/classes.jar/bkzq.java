import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.4;
import java.io.File;
import java.io.IOException;

public class bkzq
  implements aysc
{
  public bkzq(QIMPtvTemplateManager.4 param4) {}
  
  public void onResp(aysz paramaysz)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "onResp url: " + this.a.a.resurl + " resultcode: " + paramaysz.c);
    }
    this.a.a.usable = this.a.this$0.a(this.a.a);
    if (this.a.a.usable) {}
    try
    {
      nav.a(new File(bkzp.a(), this.a.a.name), bkzp.a);
      if (this.a.this$0.a() != null) {
        this.a.this$0.a().notifyObservers(bjdt.class, 3, true, null);
      }
      return;
    }
    catch (IOException paramaysz)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          paramaysz.printStackTrace();
        }
      }
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkzq
 * JD-Core Version:    0.7.0.1
 */