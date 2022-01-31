import android.os.Bundle;
import cooperation.qqreader.proxy.ReaderInterfacePluginProxy;

public class bjar
{
  private static bjar a;
  
  public static bjar a()
  {
    try
    {
      if (a == null) {
        a = new bjar();
      }
      bjar localbjar = a;
      return localbjar;
    }
    finally {}
  }
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    if (!bizc.a().a())
    {
      bjbl.d("ReaderInterfacePlugin", "plugin is not Ready, launch it");
      bizc.a().a();
    }
    ReaderInterfacePluginProxy localReaderInterfacePluginProxy;
    do
    {
      return false;
      localReaderInterfacePluginProxy = bizc.a().a();
    } while (localReaderInterfacePluginProxy == null);
    return localReaderInterfacePluginProxy.handleEvent(paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjar
 * JD-Core Version:    0.7.0.1
 */