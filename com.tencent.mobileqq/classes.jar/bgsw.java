import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer.11.1;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bgsw
  implements VideoPlayerProxy.OnSeekCompleteListener
{
  public bgsw(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onSeekComplete(VideoPlayerProxy paramVideoPlayerProxy)
  {
    ThreadManager.c().post(new MiniAppVideoPlayer.11.1(this));
    try
    {
      paramVideoPlayerProxy = new JSONObject();
      paramVideoPlayerProxy.put("data", this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_Bglu.a("onVideoSeeked", paramVideoPlayerProxy.toString(), this.a.jdField_a_of_type_Int);
      QMLog.d("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoSeeked = " + paramVideoPlayerProxy.toString());
      return;
    }
    catch (JSONException paramVideoPlayerProxy)
    {
      paramVideoPlayerProxy.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgsw
 * JD-Core Version:    0.7.0.1
 */