import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class asty
  implements TVK_SDKMgr.InstallListener
{
  asty(astw paramastw) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    astv.b("installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    astv.b("installSDK onInstalledSuccessed");
    astw.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asty
 * JD-Core Version:    0.7.0.1
 */