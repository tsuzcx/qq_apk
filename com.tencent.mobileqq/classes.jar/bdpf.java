import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.confighandler.NormalConfigHandler.GetConfigListen;
import com.tencent.mobileqq.utils.confighandler.QAVFunCallConfig;
import com.tencent.mobileqq.utils.confighandler.QAVFunCallHandler;

public class bdpf
  implements NormalConfigHandler.GetConfigListen<QAVFunCallConfig>
{
  public bdpf(QAVFunCallHandler paramQAVFunCallHandler) {}
  
  public void a(AppInterface paramAppInterface, QAVFunCallConfig paramQAVFunCallConfig)
  {
    this.a.setConfig(paramQAVFunCallConfig);
    this.a.onGetConfig(paramAppInterface);
    QAVFunCallHandler.access$000(this.a, "onGetConfig", paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdpf
 * JD-Core Version:    0.7.0.1
 */