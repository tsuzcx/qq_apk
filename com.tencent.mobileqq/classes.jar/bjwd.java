import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import cooperation.qzone.video.QzoneLiveVideoGpuProxyActivity;
import cooperation.qzone.video.QzoneLiveVideoPluginProxyActivity;
import cooperation.qzone.video.QzoneLiveVideoTransparentActivity;

public class bjwd
{
  public static Class<? extends PluginProxyActivity> a(String paramString)
  {
    if (QzoneLiveVideoPluginProxyActivity.a(QzoneLiveVideoPluginProxyActivity.a(), paramString)) {
      return QzoneLiveVideoTransparentActivity.class;
    }
    return QzoneLiveVideoGpuProxyActivity.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjwd
 * JD-Core Version:    0.7.0.1
 */