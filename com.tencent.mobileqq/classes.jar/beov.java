import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnErrorListener;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer;
import org.json.JSONException;
import org.json.JSONObject;

public class beov
  implements VideoPlayerProxy.OnErrorListener
{
  public beov(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public boolean onError(VideoPlayerProxy paramVideoPlayerProxy, int paramInt1, int paramInt2)
  {
    betc.d("MiniAppVideoPlayer", "video onError: m what=" + paramInt1 + " extra=" + paramInt2);
    if (!this.a.jdField_a_of_type_Behp.getClass().getName().equals("com.tencent.qqmini.sdk.runtime.core.service.AppBrandService")) {
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
        this.a.jdField_a_of_type_Behp.a("onVideoError", paramVideoPlayerProxy.toString(), this.a.jdField_a_of_type_Int);
        betc.a("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoError = " + paramVideoPlayerProxy.toString());
      }
      catch (JSONException paramVideoPlayerProxy)
      {
        paramVideoPlayerProxy.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beov
 * JD-Core Version:    0.7.0.1
 */