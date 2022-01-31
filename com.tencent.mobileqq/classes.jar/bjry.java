import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import cooperation.qzone.video.QzoneVerticalVideoGpuProxyActivity;
import cooperation.qzone.video.QzoneVerticalVideoPluginProxyActivity;
import cooperation.qzone.video.QzoneVerticalVideoTransparentActivity;

public class bjry
{
  public static Class<? extends PluginProxyActivity> a(String paramString)
  {
    if (QzoneVerticalVideoPluginProxyActivity.a(QzoneVerticalVideoPluginProxyActivity.a(), paramString)) {
      return QzoneVerticalVideoTransparentActivity.class;
    }
    return QzoneVerticalVideoGpuProxyActivity.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjry
 * JD-Core Version:    0.7.0.1
 */