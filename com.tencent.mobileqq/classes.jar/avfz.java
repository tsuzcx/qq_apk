import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class avfz
  implements TVK_SDKMgr.InstallListener
{
  avfz(avfx paramavfx) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    avfw.b("installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    avfw.b("installSDK onInstalledSuccessed");
    avfx.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avfz
 * JD-Core Version:    0.7.0.1
 */