import android.os.Handler;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer.11.1;
import org.json.JSONException;
import org.json.JSONObject;

public class benv
  implements VideoPlayerProxy.OnSeekCompleteListener
{
  public benv(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onSeekComplete(VideoPlayerProxy paramVideoPlayerProxy)
  {
    beiw.c().post(new MiniAppVideoPlayer.11.1(this));
    try
    {
      paramVideoPlayerProxy = new JSONObject();
      paramVideoPlayerProxy.put("data", this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_Begy.a("onVideoSeeked", paramVideoPlayerProxy.toString(), this.a.jdField_a_of_type_Int);
      besl.a("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoSeeked = " + paramVideoPlayerProxy.toString());
      return;
    }
    catch (JSONException paramVideoPlayerProxy)
    {
      paramVideoPlayerProxy.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     benv
 * JD-Core Version:    0.7.0.1
 */