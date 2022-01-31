import android.os.Bundle;
import android.text.TextUtils;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class bcgx
  implements EIPCResultCallback
{
  bcgx(bcgw parambcgw) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    bcds.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback...");
    if (paramEIPCResult == null) {
      return;
    }
    Object localObject1 = paramEIPCResult.data;
    if (localObject1 == null)
    {
      bcds.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback data is null...");
      return;
    }
    paramEIPCResult = ((Bundle)localObject1).getString("PackageName");
    int i = ((Bundle)localObject1).getInt("VersionCode");
    bcgw.a(this.a).put(bcgw.a(this.a, paramEIPCResult, i), Boolean.valueOf(false));
    String str1 = ((Bundle)localObject1).getString("Code");
    boolean bool = ((Bundle)localObject1).getBoolean("IsSuccess");
    bcds.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback pkgName|" + paramEIPCResult + " versionCode|" + i + " isSuc|" + bool + " code|" + str1);
    for (;;)
    {
      bcge localbcge;
      Bundle localBundle;
      try
      {
        localObject1 = bcgw.a(this.a, paramEIPCResult, i);
        String str2 = (String)bcgw.a(this.a).get(localObject1);
        Object localObject2 = (List)bcgw.b(this.a).get(localObject1);
        if (localObject2 == null) {
          break label315;
        }
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localbcge = (bcge)((Iterator)localObject2).next();
        if (localbcge == null) {
          continue;
        }
        localBundle = new Bundle();
        if (TextUtils.isEmpty(str2))
        {
          localbcge.a(paramEIPCResult, i, str1, bool, localBundle);
          continue;
        }
        localBundle.putString(bcgl.a, str2);
      }
      finally {}
      localbcge.a(paramEIPCResult, i, str1, bool, localBundle);
    }
    bcgw.b(this.a).remove(localObject1);
    for (;;)
    {
      return;
      label315:
      bcds.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback getCodeListener is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcgx
 * JD-Core Version:    0.7.0.1
 */