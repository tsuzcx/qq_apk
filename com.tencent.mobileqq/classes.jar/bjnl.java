import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.Map;

class bjnl
  extends QIPCModule
{
  bjnl(bjnk parambjnk, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    bjko.c("DownloaderWriteCodeIPC", "onCall action|" + paramString + " params|" + paramBundle + " callbackId|" + paramInt);
    Object localObject = bjnk.a(this.a);
    if (localObject == null) {
      bjko.c("DownloaderWriteCodeIPC", "onCall action but appInterface is null");
    }
    String str;
    int i;
    do
    {
      do
      {
        return null;
      } while ((!"DownloaderWriteCodeIPC_Action__GetCode".equals(paramString)) || (paramBundle == null));
      str = paramBundle.getString("PackageName");
      i = paramBundle.getInt("VersionCode");
      bjko.c("DownloaderWriteCodeIPC", "onCall action|" + paramString + " packageName|" + str + " versionCode|" + i);
    } while (str == null);
    ((QQAppInterface)localObject).addDefaultObservers(bjnk.a(this.a));
    paramString = (ansg)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
    localObject = str + "_" + i;
    paramBundle.putInt("CallbackId", paramInt);
    paramBundle = new Bundle(paramBundle);
    bjnk.a(this.a).put(localObject, paramBundle);
    paramString.a(str, i, (String)localObject);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjnl
 * JD-Core Version:    0.7.0.1
 */