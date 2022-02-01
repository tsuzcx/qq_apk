import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.4;
import java.io.File;
import java.io.IOException;

public class bqgd
  implements bdvw
{
  public bqgd(QIMPtvTemplateManager.4 param4) {}
  
  public void onResp(bdwt parambdwt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "onResp url: " + this.a.a.resurl + " resultcode: " + parambdwt.c);
    }
    this.a.a.usable = this.a.this$0.a(this.a.a);
    if (this.a.a.usable) {}
    try
    {
      nmk.a(new File(bqgc.a(), this.a.a.name), bqgc.a);
      if (this.a.this$0.a() != null) {
        this.a.this$0.a().notifyObservers(bomu.class, 3, true, null);
      }
      return;
    }
    catch (IOException parambdwt)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          parambdwt.printStackTrace();
        }
      }
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqgd
 * JD-Core Version:    0.7.0.1
 */