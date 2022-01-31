import android.os.Bundle;
import cooperation.qqreader.proxy.ReaderInterfacePluginProxy;

public class bguu
{
  private static bguu a;
  
  public static bguu a()
  {
    try
    {
      if (a == null) {
        a = new bguu();
      }
      bguu localbguu = a;
      return localbguu;
    }
    finally {}
  }
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    if (!bgtf.a().a())
    {
      bgvo.d("ReaderInterfacePlugin", "plugin is not Ready, launch it");
      bgtf.a().a();
    }
    ReaderInterfacePluginProxy localReaderInterfacePluginProxy;
    do
    {
      return false;
      localReaderInterfacePluginProxy = bgtf.a().a();
    } while (localReaderInterfacePluginProxy == null);
    return localReaderInterfacePluginProxy.handleEvent(paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bguu
 * JD-Core Version:    0.7.0.1
 */