import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import cooperation.troop_homework.jsp.TroopHWFileDownloadManager;
import cooperation.troop_homework.jsp.TroopHWFileDownloadManager.OnDownloadStateListener;
import java.io.File;
import java.util.HashMap;

public class ampk
  implements ITMAssistantDownloadClientListener
{
  public ampk(TroopHWFileDownloadManager paramTroopHWFileDownloadManager) {}
  
  public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2)
  {
    paramTMAssistantDownloadClient = (TroopHWFileDownloadManager.OnDownloadStateListener)TroopHWFileDownloadManager.a(this.a).get(paramString);
    if (paramTMAssistantDownloadClient != null) {
      paramTMAssistantDownloadClient.a(paramString, paramLong1, paramLong2);
    }
  }
  
  public void onDownloadSDKTaskStateChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    int i = 4;
    paramTMAssistantDownloadClient = "";
    if (paramInt1 == 4)
    {
      paramTMAssistantDownloadClient = (String)TroopHWFileDownloadManager.b(this.a).get(paramString1);
      localObject = paramTMAssistantDownloadClient.substring(paramTMAssistantDownloadClient.lastIndexOf("/") + 1);
      localObject = new File(TroopHWFileDownloadManager.a(this.a) + (String)localObject);
      if (((File)localObject).exists()) {
        ((File)localObject).renameTo(new File(paramTMAssistantDownloadClient));
      }
      TroopHWFileDownloadManager.b(this.a).remove(paramString1);
    }
    Object localObject = (TroopHWFileDownloadManager.OnDownloadStateListener)TroopHWFileDownloadManager.a(this.a).get(paramString1);
    if (localObject != null) {
      switch (paramInt1)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      ((TroopHWFileDownloadManager.OnDownloadStateListener)localObject).a(paramString1, i, paramInt2, paramString2, paramTMAssistantDownloadClient);
      return;
      i = 2;
      continue;
      i = 6;
      continue;
      i = 3;
      TroopHWFileDownloadManager.a(this.a).remove(paramString1);
      continue;
      i = 1;
      continue;
      i = 5;
      TroopHWFileDownloadManager.a(this.a).remove(paramString1);
    }
  }
  
  public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient paramTMAssistantDownloadClient) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ampk
 * JD-Core Version:    0.7.0.1
 */