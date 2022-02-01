import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class avyc
  implements TVK_SDKMgr.InstallListener
{
  avyc(avya paramavya) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    avxz.b("installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    avxz.b("installSDK onInstalledSuccessed");
    avya.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avyc
 * JD-Core Version:    0.7.0.1
 */