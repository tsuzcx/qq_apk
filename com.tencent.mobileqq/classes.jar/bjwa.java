import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.video.QzoneLiveVideoInterface;

public final class bjwa
  implements bjpt
{
  public bjwa(String paramString) {}
  
  public void onQzonePluginClientReady(bjoa parambjoa)
  {
    if (parambjoa == null) {
      bjpr.a(QzoneLiveVideoInterface.getContext(), this);
    }
    do
    {
      return;
      parambjoa = parambjoa.a(this.a);
    } while (parambjoa == null);
    QzoneLiveVideoInterface.access$002(parambjoa.ver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjwa
 * JD-Core Version:    0.7.0.1
 */