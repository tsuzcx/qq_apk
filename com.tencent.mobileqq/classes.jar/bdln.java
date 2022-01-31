import android.os.Bundle;
import android.text.TextUtils;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class bdln
  implements EIPCResultCallback
{
  bdln(bdlm parambdlm) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    bdii.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback...");
    if (paramEIPCResult == null) {
      return;
    }
    Object localObject1 = paramEIPCResult.data;
    if (localObject1 == null)
    {
      bdii.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback data is null...");
      return;
    }
    paramEIPCResult = ((Bundle)localObject1).getString("PackageName");
    int i = ((Bundle)localObject1).getInt("VersionCode");
    bdlm.a(this.a).put(bdlm.a(this.a, paramEIPCResult, i), Boolean.valueOf(false));
    String str1 = ((Bundle)localObject1).getString("Code");
    boolean bool = ((Bundle)localObject1).getBoolean("IsSuccess");
    bdii.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback pkgName|" + paramEIPCResult + " versionCode|" + i + " isSuc|" + bool + " code|" + str1);
    for (;;)
    {
      bdku localbdku;
      Bundle localBundle;
      try
      {
        localObject1 = bdlm.a(this.a, paramEIPCResult, i);
        String str2 = (String)bdlm.a(this.a).get(localObject1);
        Object localObject2 = (List)bdlm.b(this.a).get(localObject1);
        if (localObject2 == null) {
          break label315;
        }
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localbdku = (bdku)((Iterator)localObject2).next();
        if (localbdku == null) {
          continue;
        }
        localBundle = new Bundle();
        if (TextUtils.isEmpty(str2))
        {
          localbdku.a(paramEIPCResult, i, str1, bool, localBundle);
          continue;
        }
        localBundle.putString(bdlb.a, str2);
      }
      finally {}
      localbdku.a(paramEIPCResult, i, str1, bool, localBundle);
    }
    bdlm.b(this.a).remove(localObject1);
    for (;;)
    {
      return;
      label315:
      bdii.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback getCodeListener is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdln
 * JD-Core Version:    0.7.0.1
 */