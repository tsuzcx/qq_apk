import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class avqx
  implements TVK_SDKMgr.InstallListener
{
  avqx(avqv paramavqv) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    avqu.b("installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    avqu.b("installSDK onInstalledSuccessed");
    avqv.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqx
 * JD-Core Version:    0.7.0.1
 */