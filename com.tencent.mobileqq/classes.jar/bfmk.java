import android.os.Bundle;
import cooperation.qqreader.QRBridgeUtil;
import cooperation.qqreader.proxy.ReaderInterfacePluginProxy;

public class bfmk
{
  private ReaderInterfacePluginProxy a = QRBridgeUtil.getReaderInterfacePlugin();
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    if (!QRBridgeUtil.isPluginReady()) {
      bfne.c("ReaderInterfacePlugin", "plugin is not Ready");
    }
    while (this.a == null) {
      return false;
    }
    return this.a.handleEvent(paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmk
 * JD-Core Version:    0.7.0.1
 */