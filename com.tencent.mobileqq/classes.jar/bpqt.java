import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.4;
import java.io.File;
import java.io.IOException;

public class bpqt
  implements INetEngine.INetEngineListener
{
  public bpqt(QIMPtvTemplateManager.4 param4) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "onResp url: " + this.a.a.resurl + " resultcode: " + paramNetResp.mHttpCode);
    }
    this.a.a.usable = this.a.this$0.a(this.a.a);
    if (this.a.a.usable) {}
    try
    {
      nwp.a(new File(bpqs.a(), this.a.a.name), bpqs.a);
      if (this.a.this$0.getApp() != null) {
        this.a.this$0.getApp().notifyObservers(boiu.class, 3, true, null);
      }
      return;
    }
    catch (IOException paramNetResp)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          paramNetResp.printStackTrace();
        }
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqt
 * JD-Core Version:    0.7.0.1
 */