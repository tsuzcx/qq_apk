import android.os.Bundle;
import cooperation.qqreader.proxy.ReaderInterfacePluginProxy;

public class blpc
{
  private static blpc a;
  
  public static blpc a()
  {
    try
    {
      if (a == null) {
        a = new blpc();
      }
      blpc localblpc = a;
      return localblpc;
    }
    finally {}
  }
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    if (!blnn.a().a())
    {
      blpu.d("ReaderInterfacePlugin", "plugin is not Ready, launch it");
      blnn.a().a();
    }
    ReaderInterfacePluginProxy localReaderInterfacePluginProxy;
    do
    {
      return false;
      localReaderInterfacePluginProxy = blnn.a().a();
    } while (localReaderInterfacePluginProxy == null);
    return localReaderInterfacePluginProxy.handleEvent(paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpc
 * JD-Core Version:    0.7.0.1
 */