import android.os.Bundle;
import cooperation.qqreader.proxy.ReaderInterfacePluginProxy;

public class bgvl
{
  private static bgvl a;
  
  public static bgvl a()
  {
    try
    {
      if (a == null) {
        a = new bgvl();
      }
      bgvl localbgvl = a;
      return localbgvl;
    }
    finally {}
  }
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    if (!bgtw.a().a())
    {
      bgwf.d("ReaderInterfacePlugin", "plugin is not Ready, launch it");
      bgtw.a().a();
    }
    ReaderInterfacePluginProxy localReaderInterfacePluginProxy;
    do
    {
      return false;
      localReaderInterfacePluginProxy = bgtw.a().a();
    } while (localReaderInterfacePluginProxy == null);
    return localReaderInterfacePluginProxy.handleEvent(paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvl
 * JD-Core Version:    0.7.0.1
 */