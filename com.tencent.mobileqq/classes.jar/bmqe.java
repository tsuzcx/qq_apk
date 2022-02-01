import android.os.Bundle;
import cooperation.qqreader.proxy.ReaderInterfacePluginProxy;

public class bmqe
{
  private static bmqe a;
  
  public static bmqe a()
  {
    try
    {
      if (a == null) {
        a = new bmqe();
      }
      bmqe localbmqe = a;
      return localbmqe;
    }
    finally {}
  }
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    if (!bmop.a().a())
    {
      bmqw.d("ReaderInterfacePlugin", "plugin is not Ready, launch it");
      bmop.a().a();
    }
    ReaderInterfacePluginProxy localReaderInterfacePluginProxy;
    do
    {
      return false;
      localReaderInterfacePluginProxy = bmop.a().a();
    } while (localReaderInterfacePluginProxy == null);
    return localReaderInterfacePluginProxy.handleEvent(paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqe
 * JD-Core Version:    0.7.0.1
 */