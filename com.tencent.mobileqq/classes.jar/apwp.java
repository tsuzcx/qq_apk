import android.os.Handler;
import com.tencent.mobileqq.filemanager.util.UniformDownloaderAppBabySdk.4.1;
import com.tencent.mobileqq.filemanager.util.UniformDownloaderAppBabySdk.4.2;
import com.tencent.mobileqq.filemanager.util.UniformDownloaderAppBabySdk.4.3;
import com.tencent.mobileqq.filemanager.util.UniformDownloaderAppBabySdk.4.4;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class apwp
  implements ITMAssistantDownloadClientListener
{
  apwp(apwo paramapwo) {}
  
  public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2)
  {
    apwo.b(this.a);
    if (!apwo.a(this.a).post(new UniformDownloaderAppBabySdk.4.1(this, paramString, paramLong1, paramLong2))) {
      QLog.e(apwo.a, 1, "[UniformDL] OnDownloadSDKTaskProgressChanged. thread error!!");
    }
  }
  
  public void onDownloadSDKTaskStateChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    int i = 0;
    int j = 0;
    Object localObject2 = null;
    QLog.i(apwo.a, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[" + paramInt1 + "] errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
    String str = "";
    Object localObject1;
    if ((paramTMAssistantDownloadClient != null) && (4 == paramInt1))
    {
      try
      {
        localObject1 = paramTMAssistantDownloadClient.getDownloadTaskState(paramString1);
        i = 0;
        paramTMAssistantDownloadClient = str;
      }
      catch (Exception paramTMAssistantDownloadClient)
      {
        do
        {
          for (;;)
          {
            paramTMAssistantDownloadClient.printStackTrace();
            paramTMAssistantDownloadClient = apwh.a(22);
            localObject1 = null;
            j = 22;
            i = 1;
            continue;
            localObject1 = ((TMAssistantDownloadTaskInfo)localObject1).mSavePath;
          }
        } while ((apwo.a(this.a) == null) || (apwo.a(this.a).post(new UniformDownloaderAppBabySdk.4.3(this, paramString1, paramInt1, paramInt2, paramString2, (String)localObject1))));
        QLog.e(apwo.a, 1, "[UniformDL] OnDownloadSDKTaskProgressChanged. thread error!!");
        return;
      }
      if (localObject1 == null) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      apwo.b(this.a);
      if (i != 0)
      {
        if (!apwo.a(this.a).post(new UniformDownloaderAppBabySdk.4.2(this, paramString1, j, paramTMAssistantDownloadClient))) {
          QLog.e(apwo.a, 1, "[UniformDL] OnDownloadSDKTaskProgressChanged. haveErr and thread error!!");
        }
        return;
      }
      localObject1 = null;
      paramTMAssistantDownloadClient = "";
      j = 0;
    }
  }
  
  public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient paramTMAssistantDownloadClient)
  {
    QLog.e(apwo.a, 1, "[UniformDL] ABSdkdownload service invalid ");
    apwo.b(this.a);
    if (!apwo.a(this.a).post(new UniformDownloaderAppBabySdk.4.4(this))) {
      QLog.e(apwo.a, 1, "[UniformDL] OnDwonloadSDKServiceInvalid. thread error!!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apwp
 * JD-Core Version:    0.7.0.1
 */