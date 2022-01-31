import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.MyAppApi.QQDownloadListener.1;
import com.tencent.open.downloadnew.MyAppApi.QQDownloadListener.2;
import com.tencent.tmassistantsdk.ITMAssistantCallBackListener;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import mqq.os.MqqHandler;

public class bfpj
  implements ITMAssistantCallBackListener
{
  protected bfpj(bfox parambfox) {}
  
  public void onDownloadTaskProgressChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, long paramLong1, long paramLong2)
  {
    bfox.a(this.a, true);
    bflp.b("MyAppApi", "onDownloadTaskProgressChanged  receiveDataLen:" + paramLong1 + ",totalDataLen:" + paramLong2);
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    bfok localbfok = bfok.a();
    DownloadInfo localDownloadInfo2 = localbfok.a(paramTMAssistantCallYYBParamStruct.SNGAppId);
    DownloadInfo localDownloadInfo1 = localDownloadInfo2;
    if (localDownloadInfo2 == null)
    {
      localDownloadInfo1 = this.a.a(paramTMAssistantCallYYBParamStruct, null);
      localbfok.e(localDownloadInfo1);
    }
    localDownloadInfo1.f = i;
    localDownloadInfo1.a(2);
    localbfok.a(2, localDownloadInfo1);
    bfkr.a().a(paramTMAssistantCallYYBParamStruct, i);
    bflp.a("MyAppApi", "onDownloadTaskProgressChanged info state=" + localDownloadInfo1.a() + " progress=" + localDownloadInfo1.f);
  }
  
  public void onDownloadTaskStateChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, int paramInt2, String paramString)
  {
    this.a.b = true;
    bfox.a(this.a, true);
    bflp.b("MyAppApi", "onDownloadTaskStateChanged");
    ThreadManager.getSubThreadHandler().post(new MyAppApi.QQDownloadListener.1(this, paramTMAssistantCallYYBParamStruct, paramInt1, paramInt2, paramString));
  }
  
  public void onQQDownloaderInvalid()
  {
    bflp.b("MyAppApi", alud.a(2131707437));
    ThreadManager.getSubThreadHandler().post(new MyAppApi.QQDownloadListener.2(this));
  }
  
  public void onServiceFree()
  {
    bflp.b("MyAppApi", "OnServiceFree");
    try
    {
      ((TMAssistantCallYYB_V2)this.a.a).releaseIPCConnected();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfpj
 * JD-Core Version:    0.7.0.1
 */