import android.os.Bundle;
import cooperation.qqreader.proxy.ReaderInterfacePluginProxy;

public class bmfu
{
  private static bmfu a;
  
  public static bmfu a()
  {
    try
    {
      if (a == null) {
        a = new bmfu();
      }
      bmfu localbmfu = a;
      return localbmfu;
    }
    finally {}
  }
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    if (!bmef.a().a())
    {
      bmgm.d("ReaderInterfacePlugin", "plugin is not Ready, launch it");
      bmef.a().a();
    }
    ReaderInterfacePluginProxy localReaderInterfacePluginProxy;
    do
    {
      return false;
      localReaderInterfacePluginProxy = bmef.a().a();
    } while (localReaderInterfacePluginProxy == null);
    return localReaderInterfacePluginProxy.handleEvent(paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfu
 * JD-Core Version:    0.7.0.1
 */