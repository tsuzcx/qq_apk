import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.Map;

class bfkm
  extends QIPCModule
{
  bfkm(bfkl parambfkl, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    bfhg.c("DownloaderWriteCodeIPC", "onCall action|" + paramString + " params|" + paramBundle + " callbackId|" + paramInt);
    Object localObject = bfkl.a(this.a);
    if (localObject == null) {
      bfhg.c("DownloaderWriteCodeIPC", "onCall action but appInterface is null");
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
      bfhg.c("DownloaderWriteCodeIPC", "onCall action|" + paramString + " packageName|" + str + " versionCode|" + i);
    } while (str == null);
    ((QQAppInterface)localObject).a(bfkl.a(this.a));
    paramString = (allq)((QQAppInterface)localObject).a(4);
    localObject = str + "_" + i;
    paramBundle.putInt("CallbackId", paramInt);
    paramBundle = new Bundle(paramBundle);
    bfkl.a(this.a).put(localObject, paramBundle);
    paramString.a(str, i, (String)localObject);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfkm
 * JD-Core Version:    0.7.0.1
 */