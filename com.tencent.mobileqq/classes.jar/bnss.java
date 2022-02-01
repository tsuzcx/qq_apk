import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.io.File;
import java.util.HashMap;

class bnss
  implements ITMAssistantDownloadClientListener
{
  bnss(bnsr parambnsr) {}
  
  public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2)
  {
    paramTMAssistantDownloadClient = (bnst)bnsr.a(this.a).get(paramString);
    if (paramTMAssistantDownloadClient != null) {
      paramTMAssistantDownloadClient.a(paramString, paramLong1, paramLong2);
    }
  }
  
  public void onDownloadSDKTaskStateChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    int j = 6;
    String str = "";
    Object localObject;
    int i;
    if (paramInt1 == 4)
    {
      str = (String)bnsr.b(this.a).get(paramString1);
      localObject = "";
      try
      {
        paramTMAssistantDownloadClient = paramTMAssistantDownloadClient.getDownloadTaskState(paramString1);
        if (paramTMAssistantDownloadClient != null) {
          break label153;
        }
        paramTMAssistantDownloadClient = null;
      }
      catch (Exception paramTMAssistantDownloadClient)
      {
        for (;;)
        {
          QLog.e(bnsr.a, 2, paramTMAssistantDownloadClient.toString());
          paramTMAssistantDownloadClient = (TMAssistantDownloadClient)localObject;
          continue;
          QLog.e(bnsr.a, 2, "file renameTo faild frompath:" + paramTMAssistantDownloadClient + " topath:" + str);
          i = 0;
        }
        QLog.e(bnsr.a, 2, "file not exist path:" + paramTMAssistantDownloadClient);
      }
      if (!TextUtils.isEmpty(paramTMAssistantDownloadClient))
      {
        localObject = new File(paramTMAssistantDownloadClient);
        if (((File)localObject).exists()) {
          if (((File)localObject).renameTo(new File(str)))
          {
            i = 1;
            if (i != 0) {
              break label265;
            }
            paramTMAssistantDownloadClient = (bnst)bnsr.a(this.a).get(paramString1);
            if (paramTMAssistantDownloadClient != null) {
              paramTMAssistantDownloadClient.a(paramString1, 6, 0, "", "");
            }
            bnsr.a(this.a).remove(paramString1);
            bnsr.b(this.a).remove(paramString1);
          }
        }
      }
    }
    label153:
    do
    {
      return;
      paramTMAssistantDownloadClient = paramTMAssistantDownloadClient.mSavePath;
      break;
      for (;;)
      {
        i = 0;
        break;
        QLog.e(bnsr.a, 2, "currentPath is null");
      }
      paramTMAssistantDownloadClient = (bnst)bnsr.a(this.a).get(paramString1);
    } while (paramTMAssistantDownloadClient == null);
    label265:
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
    }
    for (;;)
    {
      paramTMAssistantDownloadClient.a(paramString1, paramInt1, paramInt2, paramString2, str);
      return;
      paramInt1 = 2;
      continue;
      bnsr.a(this.a).remove(paramString1);
      bnsr.b(this.a).remove(paramString1);
      paramInt1 = j;
      continue;
      paramInt1 = 3;
      bnsr.a(this.a).remove(paramString1);
      bnsr.b(this.a).remove(paramString1);
      continue;
      paramInt1 = 4;
      continue;
      paramInt1 = 1;
      continue;
      paramInt1 = 5;
      bnsr.a(this.a).remove(paramString1);
      bnsr.b(this.a).remove(paramString1);
    }
  }
  
  public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient paramTMAssistantDownloadClient) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnss
 * JD-Core Version:    0.7.0.1
 */