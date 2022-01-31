import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class ardi
  implements TVK_SDKMgr.InstallListener
{
  ardi(ardg paramardg) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    ardf.b("installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    ardf.b("installSDK onInstalledSuccessed");
    ardg.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ardi
 * JD-Core Version:    0.7.0.1
 */