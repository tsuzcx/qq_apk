import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.MyAppApi.QQDownloadListener.1;
import com.tencent.open.downloadnew.MyAppApi.QQDownloadListener.2;
import com.tencent.tmassistantsdk.ITMAssistantCallBackListener;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import mqq.os.MqqHandler;

public class bchn
  implements ITMAssistantCallBackListener
{
  protected bchn(bchb parambchb) {}
  
  public void onDownloadTaskProgressChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, long paramLong1, long paramLong2)
  {
    bchb.a(this.a, true);
    bcds.b("MyAppApi", "onDownloadTaskProgressChanged  receiveDataLen:" + paramLong1 + ",totalDataLen:" + paramLong2);
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    bcgo localbcgo = bcgo.a();
    DownloadInfo localDownloadInfo2 = localbcgo.a(paramTMAssistantCallYYBParamStruct.SNGAppId);
    DownloadInfo localDownloadInfo1 = localDownloadInfo2;
    if (localDownloadInfo2 == null)
    {
      localDownloadInfo1 = this.a.a(paramTMAssistantCallYYBParamStruct, null);
      localbcgo.e(localDownloadInfo1);
    }
    localDownloadInfo1.f = i;
    localDownloadInfo1.a(2);
    localbcgo.a(2, localDownloadInfo1);
    bccu.a().a(paramTMAssistantCallYYBParamStruct, i);
    bcds.a("MyAppApi", "onDownloadTaskProgressChanged info state=" + localDownloadInfo1.a() + " progress=" + localDownloadInfo1.f);
  }
  
  public void onDownloadTaskStateChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, int paramInt2, String paramString)
  {
    this.a.b = true;
    bchb.a(this.a, true);
    bcds.b("MyAppApi", "onDownloadTaskStateChanged");
    ThreadManager.getSubThreadHandler().post(new MyAppApi.QQDownloadListener.1(this, paramTMAssistantCallYYBParamStruct, paramInt1, paramInt2, paramString));
  }
  
  public void onQQDownloaderInvalid()
  {
    bcds.b("MyAppApi", ajjy.a(2131641257));
    ThreadManager.getSubThreadHandler().post(new MyAppApi.QQDownloadListener.2(this));
  }
  
  public void onServiceFree()
  {
    bcds.b("MyAppApi", "OnServiceFree");
    try
    {
      ((TMAssistantCallYYB_V2)this.a.a).releaseIPCConnected();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bchn
 * JD-Core Version:    0.7.0.1
 */