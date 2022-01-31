import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class ardk
  implements TVK_SDKMgr.InstallListener
{
  ardk(ardi paramardi) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    ardh.b("installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    ardh.b("installSDK onInstalledSuccessed");
    ardi.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ardk
 * JD-Core Version:    0.7.0.1
 */