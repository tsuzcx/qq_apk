import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment.8;
import dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment.8.1.1;

public class bmht
  implements HttpEngineTask.IHttpEngineTask
{
  public bmht(AEEditorCommonEditFragment.8 param8) {}
  
  public void onPreDownloadStart(HttpEngineTask paramHttpEngineTask) {}
  
  public void onResp(NetResp paramNetResp)
  {
    ThreadManager.excute(new AEEditorCommonEditFragment.8.1.1(this, paramNetResp), 64, null, true);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmht
 * JD-Core Version:    0.7.0.1
 */