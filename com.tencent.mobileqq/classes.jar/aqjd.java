import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class aqjd
  implements TVK_SDKMgr.InstallListener
{
  aqjd(aqjb paramaqjb) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    aqja.b("installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    aqja.b("installSDK onInstalledSuccessed");
    aqjb.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqjd
 * JD-Core Version:    0.7.0.1
 */