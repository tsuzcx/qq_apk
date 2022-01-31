import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import cooperation.qqreader.QRBridgeUtil;

final class bflr
  extends OnPluginInstallListener.Stub
{
  bflr(QQAppInterface paramQQAppInterface) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    bfne.c("QReaderHelper", "installPlugin onInstallError, pluginId = " + paramString + ", errorCode = " + paramInt);
    bflp.a(this.a, paramInt);
  }
  
  public void onInstallFinish(String paramString)
  {
    bfne.d("QReaderHelper", "installPlugin onInstallFinish, pluginId = " + paramString);
    bflp.a(this.a, 0);
    QRBridgeUtil.loadReaderPluginModule(this.a.getApp());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflr
 * JD-Core Version:    0.7.0.1
 */