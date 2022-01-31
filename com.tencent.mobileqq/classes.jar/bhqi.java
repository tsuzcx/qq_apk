import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.video.QzoneLiveVideoInterface;

public final class bhqi
  implements bhkb
{
  public bhqi(String paramString) {}
  
  public void onQzonePluginClientReady(bhii parambhii)
  {
    if (parambhii == null) {
      bhjz.a(QzoneLiveVideoInterface.getContext(), this);
    }
    do
    {
      return;
      parambhii = parambhii.a(this.a);
    } while (parambhii == null);
    QzoneLiveVideoInterface.access$002(parambhii.ver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhqi
 * JD-Core Version:    0.7.0.1
 */