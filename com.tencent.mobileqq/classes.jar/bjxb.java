import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.Map;

class bjxb
  extends QIPCModule
{
  bjxb(bjxa parambjxa, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    bjtx.c("DownloaderWriteCodeIPC", "onCall action|" + paramString + " params|" + paramBundle + " callbackId|" + paramInt);
    Object localObject = bjxa.a(this.a);
    if (localObject == null) {
      bjtx.c("DownloaderWriteCodeIPC", "onCall action but appInterface is null");
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
      bjtx.c("DownloaderWriteCodeIPC", "onCall action|" + paramString + " packageName|" + str + " versionCode|" + i);
    } while (str == null);
    ((QQAppInterface)localObject).a(bjxa.a(this.a));
    paramString = (anvl)((QQAppInterface)localObject).a(4);
    localObject = str + "_" + i;
    paramBundle.putInt("CallbackId", paramInt);
    paramBundle = new Bundle(paramBundle);
    bjxa.a(this.a).put(localObject, paramBundle);
    paramString.a(str, i, (String)localObject);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxb
 * JD-Core Version:    0.7.0.1
 */