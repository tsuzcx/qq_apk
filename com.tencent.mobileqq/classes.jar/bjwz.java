import android.os.Bundle;
import android.text.TextUtils;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class bjwz
  implements EIPCResultCallback
{
  bjwz(bjwy parambjwy) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    bjtx.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback...");
    if (paramEIPCResult == null) {
      return;
    }
    Object localObject1 = paramEIPCResult.data;
    if (localObject1 == null)
    {
      bjtx.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback data is null...");
      return;
    }
    paramEIPCResult = ((Bundle)localObject1).getString("PackageName");
    int i = ((Bundle)localObject1).getInt("VersionCode");
    bjwy.a(this.a).put(bjwy.a(this.a, paramEIPCResult, i), Boolean.valueOf(false));
    String str1 = ((Bundle)localObject1).getString("Code");
    boolean bool = ((Bundle)localObject1).getBoolean("IsSuccess");
    bjtx.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback pkgName|" + paramEIPCResult + " versionCode|" + i + " isSuc|" + bool + " code|" + str1);
    for (;;)
    {
      bjwh localbjwh;
      Bundle localBundle;
      try
      {
        localObject1 = bjwy.a(this.a, paramEIPCResult, i);
        String str2 = (String)bjwy.a(this.a).get(localObject1);
        Object localObject2 = (List)bjwy.b(this.a).get(localObject1);
        if (localObject2 == null) {
          break label315;
        }
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localbjwh = (bjwh)((Iterator)localObject2).next();
        if (localbjwh == null) {
          continue;
        }
        localBundle = new Bundle();
        if (TextUtils.isEmpty(str2))
        {
          localbjwh.a(paramEIPCResult, i, str1, bool, localBundle);
          continue;
        }
        localBundle.putString(bjwo.a, str2);
      }
      finally {}
      localbjwh.a(paramEIPCResult, i, str1, bool, localBundle);
    }
    bjwy.b(this.a).remove(localObject1);
    for (;;)
    {
      return;
      label315:
      bjtx.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback getCodeListener is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjwz
 * JD-Core Version:    0.7.0.1
 */