import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import cooperation.qzone.video.QzoneVerticalVideoGpuProxyActivity;
import cooperation.qzone.video.QzoneVerticalVideoPluginProxyActivity;
import cooperation.qzone.video.QzoneVerticalVideoTransparentActivity;

public class bhqn
{
  public static Class<? extends PluginProxyActivity> a(String paramString)
  {
    if (QzoneVerticalVideoPluginProxyActivity.a(QzoneVerticalVideoPluginProxyActivity.a(), paramString)) {
      return QzoneVerticalVideoTransparentActivity.class;
    }
    return QzoneVerticalVideoGpuProxyActivity.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhqn
 * JD-Core Version:    0.7.0.1
 */