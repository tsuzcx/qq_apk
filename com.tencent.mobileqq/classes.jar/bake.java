import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.confighandler.NormalConfigHandler.GetConfigListen;
import com.tencent.mobileqq.utils.confighandler.QAVFunCallConfig;
import com.tencent.mobileqq.utils.confighandler.QAVFunCallHandler;

public class bake
  implements NormalConfigHandler.GetConfigListen<QAVFunCallConfig>
{
  public bake(QAVFunCallHandler paramQAVFunCallHandler) {}
  
  public void a(AppInterface paramAppInterface, QAVFunCallConfig paramQAVFunCallConfig)
  {
    this.a.setConfig(paramQAVFunCallConfig);
    this.a.onGetConfig(paramAppInterface);
    this.a.requestPreDownload("onGetConfig", paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bake
 * JD-Core Version:    0.7.0.1
 */