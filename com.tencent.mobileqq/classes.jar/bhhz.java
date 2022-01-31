import android.content.Context;
import android.view.Surface;
import android.view.View;
import com.qflutter.video.QflutterVideoViewSource.Provider;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.flutter.FlutterVideoViewContainer;
import java.util.Map;

public class bhhz
  implements QflutterVideoViewSource.Provider
{
  public View getView(Context paramContext, int paramInt, Surface paramSurface, Map<String, Object> paramMap)
  {
    if ("getView" + paramMap != null) {}
    for (paramSurface = paramMap.toString();; paramSurface = "")
    {
      QMLog.e("QFVideoView", paramSurface);
      paramMap.get("videoPlayerId");
      paramMap.put("autoplay", Boolean.valueOf(true));
      return new FlutterVideoViewContainer(paramContext, paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhhz
 * JD-Core Version:    0.7.0.1
 */