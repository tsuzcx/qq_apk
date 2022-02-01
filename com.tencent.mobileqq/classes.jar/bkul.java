import android.os.Bundle;
import cooperation.qqreader.proxy.ReaderInterfacePluginProxy;

public class bkul
{
  private static bkul a;
  
  public static bkul a()
  {
    try
    {
      if (a == null) {
        a = new bkul();
      }
      bkul localbkul = a;
      return localbkul;
    }
    finally {}
  }
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    if (!bksw.a().a())
    {
      bkvd.d("ReaderInterfacePlugin", "plugin is not Ready, launch it");
      bksw.a().a();
    }
    ReaderInterfacePluginProxy localReaderInterfacePluginProxy;
    do
    {
      return false;
      localReaderInterfacePluginProxy = bksw.a().a();
    } while (localReaderInterfacePluginProxy == null);
    return localReaderInterfacePluginProxy.handleEvent(paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkul
 * JD-Core Version:    0.7.0.1
 */