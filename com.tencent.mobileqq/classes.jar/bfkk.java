import android.os.Bundle;
import android.text.TextUtils;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class bfkk
  implements EIPCResultCallback
{
  bfkk(bfkj parambfkj) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    bfhg.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback...");
    if (paramEIPCResult == null) {
      return;
    }
    Object localObject1 = paramEIPCResult.data;
    if (localObject1 == null)
    {
      bfhg.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback data is null...");
      return;
    }
    paramEIPCResult = ((Bundle)localObject1).getString("PackageName");
    int i = ((Bundle)localObject1).getInt("VersionCode");
    bfkj.a(this.a).put(bfkj.a(this.a, paramEIPCResult, i), Boolean.valueOf(false));
    String str1 = ((Bundle)localObject1).getString("Code");
    boolean bool = ((Bundle)localObject1).getBoolean("IsSuccess");
    bfhg.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback pkgName|" + paramEIPCResult + " versionCode|" + i + " isSuc|" + bool + " code|" + str1);
    for (;;)
    {
      bfjr localbfjr;
      Bundle localBundle;
      try
      {
        localObject1 = bfkj.a(this.a, paramEIPCResult, i);
        String str2 = (String)bfkj.a(this.a).get(localObject1);
        Object localObject2 = (List)bfkj.b(this.a).get(localObject1);
        if (localObject2 == null) {
          break label315;
        }
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localbfjr = (bfjr)((Iterator)localObject2).next();
        if (localbfjr == null) {
          continue;
        }
        localBundle = new Bundle();
        if (TextUtils.isEmpty(str2))
        {
          localbfjr.a(paramEIPCResult, i, str1, bool, localBundle);
          continue;
        }
        localBundle.putString(bfjy.a, str2);
      }
      finally {}
      localbfjr.a(paramEIPCResult, i, str1, bool, localBundle);
    }
    bfkj.b(this.a).remove(localObject1);
    for (;;)
    {
      return;
      label315:
      bfhg.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback getCodeListener is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfkk
 * JD-Core Version:    0.7.0.1
 */