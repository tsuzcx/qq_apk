import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnInfoListener;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer;
import org.json.JSONException;
import org.json.JSONObject;

public class beol
  implements VideoPlayerProxy.OnInfoListener
{
  public beol(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public boolean onInfo(VideoPlayerProxy paramVideoPlayerProxy, int paramInt1, int paramInt2)
  {
    betc.b("MiniAppVideoPlayer", "onInfo: " + paramInt1 + " " + paramInt1);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return false;
      betc.a("MiniAppVideoPlayer", "video player PLAYER_INFO_START_BUFFERING--------------");
      try
      {
        paramVideoPlayerProxy = new JSONObject();
        paramVideoPlayerProxy.put("data", this.a.jdField_a_of_type_JavaLangString);
        this.a.jdField_a_of_type_Behp.a("onVideoLoadStart", paramVideoPlayerProxy.toString(), this.a.jdField_a_of_type_Int);
        betc.a("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoLoadStart = " + paramVideoPlayerProxy.toString());
      }
      catch (JSONException paramVideoPlayerProxy)
      {
        paramVideoPlayerProxy.printStackTrace();
      }
      continue;
      betc.a("MiniAppVideoPlayer", "video player PLAYER_INFO_ENDOF_BUFFERING--------------");
      try
      {
        paramVideoPlayerProxy = new JSONObject();
        paramVideoPlayerProxy.put("data", this.a.jdField_a_of_type_JavaLangString);
        this.a.jdField_a_of_type_Behp.a("onVideoLoadedData", paramVideoPlayerProxy.toString(), this.a.jdField_a_of_type_Int);
        betc.a("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoLoadedData = " + paramVideoPlayerProxy.toString());
      }
      catch (JSONException paramVideoPlayerProxy)
      {
        paramVideoPlayerProxy.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beol
 * JD-Core Version:    0.7.0.1
 */