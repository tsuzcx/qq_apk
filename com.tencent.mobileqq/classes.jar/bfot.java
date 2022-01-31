import android.os.Bundle;
import android.text.TextUtils;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class bfot
  implements EIPCResultCallback
{
  bfot(bfos parambfos) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    bflp.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback...");
    if (paramEIPCResult == null) {
      return;
    }
    Object localObject1 = paramEIPCResult.data;
    if (localObject1 == null)
    {
      bflp.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback data is null...");
      return;
    }
    paramEIPCResult = ((Bundle)localObject1).getString("PackageName");
    int i = ((Bundle)localObject1).getInt("VersionCode");
    bfos.a(this.a).put(bfos.a(this.a, paramEIPCResult, i), Boolean.valueOf(false));
    String str1 = ((Bundle)localObject1).getString("Code");
    boolean bool = ((Bundle)localObject1).getBoolean("IsSuccess");
    bflp.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback pkgName|" + paramEIPCResult + " versionCode|" + i + " isSuc|" + bool + " code|" + str1);
    for (;;)
    {
      bfoa localbfoa;
      Bundle localBundle;
      try
      {
        localObject1 = bfos.a(this.a, paramEIPCResult, i);
        String str2 = (String)bfos.a(this.a).get(localObject1);
        Object localObject2 = (List)bfos.b(this.a).get(localObject1);
        if (localObject2 == null) {
          break label315;
        }
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localbfoa = (bfoa)((Iterator)localObject2).next();
        if (localbfoa == null) {
          continue;
        }
        localBundle = new Bundle();
        if (TextUtils.isEmpty(str2))
        {
          localbfoa.a(paramEIPCResult, i, str1, bool, localBundle);
          continue;
        }
        localBundle.putString(bfoh.a, str2);
      }
      finally {}
      localbfoa.a(paramEIPCResult, i, str1, bool, localBundle);
    }
    bfos.b(this.a).remove(localObject1);
    for (;;)
    {
      return;
      label315:
      bflp.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback getCodeListener is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfot
 * JD-Core Version:    0.7.0.1
 */