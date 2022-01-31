import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnInfoListener;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer;
import org.json.JSONException;
import org.json.JSONObject;

public class benu
  implements VideoPlayerProxy.OnInfoListener
{
  public benu(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public boolean onInfo(VideoPlayerProxy paramVideoPlayerProxy, int paramInt1, int paramInt2)
  {
    besl.b("MiniAppVideoPlayer", "onInfo: " + paramInt1 + " " + paramInt1);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return false;
      besl.a("MiniAppVideoPlayer", "video player PLAYER_INFO_START_BUFFERING--------------");
      try
      {
        paramVideoPlayerProxy = new JSONObject();
        paramVideoPlayerProxy.put("data", this.a.jdField_a_of_type_JavaLangString);
        this.a.jdField_a_of_type_Begy.a("onVideoLoadStart", paramVideoPlayerProxy.toString(), this.a.jdField_a_of_type_Int);
        besl.a("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoLoadStart = " + paramVideoPlayerProxy.toString());
      }
      catch (JSONException paramVideoPlayerProxy)
      {
        paramVideoPlayerProxy.printStackTrace();
      }
      continue;
      besl.a("MiniAppVideoPlayer", "video player PLAYER_INFO_ENDOF_BUFFERING--------------");
      try
      {
        paramVideoPlayerProxy = new JSONObject();
        paramVideoPlayerProxy.put("data", this.a.jdField_a_of_type_JavaLangString);
        this.a.jdField_a_of_type_Begy.a("onVideoLoadedData", paramVideoPlayerProxy.toString(), this.a.jdField_a_of_type_Int);
        besl.a("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoLoadedData = " + paramVideoPlayerProxy.toString());
      }
      catch (JSONException paramVideoPlayerProxy)
      {
        paramVideoPlayerProxy.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     benu
 * JD-Core Version:    0.7.0.1
 */