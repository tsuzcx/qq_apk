import cooperation.qzone.video.QzoneVerticalVideoGpuProxyActivity;
import cooperation.qzone.video.QzoneVerticalVideoPluginProxyActivity;
import cooperation.qzone.video.QzoneVerticalVideoTransparentActivity;

public class anbi
{
  public static Class a(String paramString)
  {
    if (QzoneVerticalVideoPluginProxyActivity.a(QzoneVerticalVideoPluginProxyActivity.a(), paramString)) {
      return QzoneVerticalVideoTransparentActivity.class;
    }
    return QzoneVerticalVideoGpuProxyActivity.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbi
 * JD-Core Version:    0.7.0.1
 */