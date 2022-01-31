import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class asyh
  implements TVK_SDKMgr.InstallListener
{
  asyh(asyf paramasyf) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    asye.b("installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    asye.b("installSDK onInstalledSuccessed");
    asyf.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyh
 * JD-Core Version:    0.7.0.1
 */