import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.MyAppApi.QQDownloadListener.1;
import com.tencent.open.downloadnew.MyAppApi.QQDownloadListener.2;
import com.tencent.tmassistantsdk.ITMAssistantCallBackListener;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import mqq.os.MqqHandler;

public class bjxp
  implements ITMAssistantCallBackListener
{
  protected bjxp(bjxd parambjxd) {}
  
  public void onDownloadTaskProgressChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, long paramLong1, long paramLong2)
  {
    bjxd.a(this.a, true);
    bjtx.b("MyAppApi", "onDownloadTaskProgressChanged  receiveDataLen:" + paramLong1 + ",totalDataLen:" + paramLong2);
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    bjwq localbjwq = bjwq.a();
    DownloadInfo localDownloadInfo2 = localbjwq.a(paramTMAssistantCallYYBParamStruct.SNGAppId);
    DownloadInfo localDownloadInfo1 = localDownloadInfo2;
    if (localDownloadInfo2 == null)
    {
      localDownloadInfo1 = this.a.a(paramTMAssistantCallYYBParamStruct, null);
      localbjwq.e(localDownloadInfo1);
    }
    localDownloadInfo1.f = i;
    localDownloadInfo1.a(2);
    localbjwq.a(2, localDownloadInfo1);
    bjsz.a().a(paramTMAssistantCallYYBParamStruct, i);
    bjtx.a("MyAppApi", "onDownloadTaskProgressChanged info state=" + localDownloadInfo1.a() + " progress=" + localDownloadInfo1.f);
  }
  
  public void onDownloadTaskStateChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, int paramInt2, String paramString)
  {
    this.a.b = true;
    bjxd.a(this.a, true);
    bjtx.b("MyAppApi", "onDownloadTaskStateChanged");
    ThreadManager.getSubThreadHandler().post(new MyAppApi.QQDownloadListener.1(this, paramTMAssistantCallYYBParamStruct, paramInt1, paramInt2, paramString));
  }
  
  public void onQQDownloaderInvalid()
  {
    bjtx.b("MyAppApi", anzj.a(2131705935));
    ThreadManager.getSubThreadHandler().post(new MyAppApi.QQDownloadListener.2(this));
  }
  
  public void onServiceFree()
  {
    bjtx.b("MyAppApi", "OnServiceFree");
    try
    {
      ((TMAssistantCallYYB_V2)this.a.a).releaseIPCConnected();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxp
 * JD-Core Version:    0.7.0.1
 */