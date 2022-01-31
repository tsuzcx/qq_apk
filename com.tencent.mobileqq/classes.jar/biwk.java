import android.os.Bundle;
import cooperation.qqreader.proxy.ReaderInterfacePluginProxy;

public class biwk
{
  private static biwk a;
  
  public static biwk a()
  {
    try
    {
      if (a == null) {
        a = new biwk();
      }
      biwk localbiwk = a;
      return localbiwk;
    }
    finally {}
  }
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    if (!biuv.a().a())
    {
      bixe.d("ReaderInterfacePlugin", "plugin is not Ready, launch it");
      biuv.a().a();
    }
    ReaderInterfacePluginProxy localReaderInterfacePluginProxy;
    do
    {
      return false;
      localReaderInterfacePluginProxy = biuv.a().a();
    } while (localReaderInterfacePluginProxy == null);
    return localReaderInterfacePluginProxy.handleEvent(paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biwk
 * JD-Core Version:    0.7.0.1
 */