import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.io.File;
import java.util.HashMap;

class bgoa
  implements ITMAssistantDownloadClientListener
{
  bgoa(bgnz parambgnz) {}
  
  public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2)
  {
    paramTMAssistantDownloadClient = (bgob)bgnz.a(this.a).get(paramString);
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
      paramTMAssistantDownloadClient = (String)bgnz.b(this.a).get(paramString1);
      localObject = paramTMAssistantDownloadClient.substring(paramTMAssistantDownloadClient.lastIndexOf("/") + 1);
      localObject = new File(bgnz.a(this.a) + (String)localObject);
      if (((File)localObject).exists()) {
        ((File)localObject).renameTo(new File(paramTMAssistantDownloadClient));
      }
      bgnz.b(this.a).remove(paramString1);
    }
    Object localObject = (bgob)bgnz.a(this.a).get(paramString1);
    if (localObject != null) {
      switch (paramInt1)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      ((bgob)localObject).a(paramString1, i, paramInt2, paramString2, paramTMAssistantDownloadClient);
      return;
      i = 2;
      continue;
      i = 6;
      continue;
      i = 3;
      bgnz.a(this.a).remove(paramString1);
      continue;
      i = 1;
      continue;
      i = 5;
      bgnz.a(this.a).remove(paramString1);
    }
  }
  
  public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient paramTMAssistantDownloadClient) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgoa
 * JD-Core Version:    0.7.0.1
 */