import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnErrorListener;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bgtf
  implements VideoPlayerProxy.OnErrorListener
{
  public bgtf(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public boolean onError(VideoPlayerProxy paramVideoPlayerProxy, int paramInt1, int paramInt2)
  {
    QMLog.e("MiniAppVideoPlayer", "video onError: m what=" + paramInt1 + " extra=" + paramInt2);
    if (!this.a.jdField_a_of_type_Bglu.getClass().getName().equals("com.tencent.qqmini.sdk.runtime.core.service.AppBrandService")) {
      MiniAppVideoPlayer.a(this.a, "error");
    }
    for (;;)
    {
      return true;
      try
      {
        paramVideoPlayerProxy = new JSONObject();
        paramVideoPlayerProxy.put("videoId", this.a.jdField_a_of_type_Long);
        paramVideoPlayerProxy.put("data", this.a.jdField_a_of_type_JavaLangString);
        this.a.jdField_a_of_type_Bglu.a("onVideoError", paramVideoPlayerProxy.toString(), this.a.jdField_a_of_type_Int);
        QMLog.d("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoError = " + paramVideoPlayerProxy.toString());
      }
      catch (JSONException paramVideoPlayerProxy)
      {
        paramVideoPlayerProxy.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgtf
 * JD-Core Version:    0.7.0.1
 */