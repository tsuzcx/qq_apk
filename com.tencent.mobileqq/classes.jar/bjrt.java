import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.video.QzoneLiveVideoInterface;

public final class bjrt
  implements bjlm
{
  public bjrt(String paramString) {}
  
  public void onQzonePluginClientReady(bjjt parambjjt)
  {
    if (parambjjt == null) {
      bjlk.a(QzoneLiveVideoInterface.getContext(), this);
    }
    do
    {
      return;
      parambjjt = parambjjt.a(this.a);
    } while (parambjjt == null);
    QzoneLiveVideoInterface.access$002(parambjjt.ver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjrt
 * JD-Core Version:    0.7.0.1
 */