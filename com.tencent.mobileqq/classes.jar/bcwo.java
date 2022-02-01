import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.15;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfo;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class bcwo
  implements INetEngine.INetEngineListener
{
  public bcwo(PtvTemplateManager.15 param15) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Doodle_Strokes_PtvTemplateManager", 2, "onResp url: " + this.a.a.doodleUrl + " resultcode: " + paramNetResp.mHttpCode);
    }
    this.a.a.doodleUsable = this.a.this$0.a(this.a.a, false);
    if (this.a.a.doodleUsable) {}
    try
    {
      nwp.a(new File(PtvTemplateManager.b, this.a.a.doodleName), PtvTemplateManager.c);
      if (paramNetResp.mResult == 0)
      {
        Object localObject = this.a.this$0.a();
        if (localObject != null)
        {
          localObject = (PreDownloadController)((QQAppInterface)localObject).getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
          if (((PreDownloadController)localObject).isEnable()) {
            ((PreDownloadController)localObject).preDownloadSuccess(this.a.a.doodleUrl, paramNetResp.mTotalFileLen);
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
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwo
 * JD-Core Version:    0.7.0.1
 */