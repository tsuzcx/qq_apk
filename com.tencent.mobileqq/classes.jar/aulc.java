import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class aulc
  implements TVK_SDKMgr.InstallListener
{
  aulc(aula paramaula) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    aukz.b("installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    aukz.b("installSDK onInstalledSuccessed");
    aula.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aulc
 * JD-Core Version:    0.7.0.1
 */