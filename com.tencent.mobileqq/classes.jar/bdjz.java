import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnVideoPreparedListener;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer.7.1;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer.7.2;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer.7.3;
import org.json.JSONException;
import org.json.JSONObject;

public class bdjz
  implements VideoPlayerProxy.OnVideoPreparedListener
{
  public bdjz(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onVideoPrepared(VideoPlayerProxy paramVideoPlayerProxy)
  {
    boolean bool = true;
    if (!this.a.jdField_a_of_type_Boolean) {
      return;
    }
    if (!this.a.jdField_a_of_type_Bdcy.getClass().getName().equals("com.tencent.qqmini.sdk.runtime.core.service.AppBrandService")) {
      MiniAppVideoPlayer.a(this.a, "waiting");
    }
    for (;;)
    {
      MiniAppVideoPlayer.b(this.a, false);
      MiniAppVideoPlayer.b(this.a, false);
      this.a.jdField_a_of_type_Boolean = true;
      if (!MiniAppVideoPlayer.a(this.a)) {
        break;
      }
      if (MiniAppVideoPlayer.a(this.a).isPlaying()) {
        MiniAppVideoPlayer.a(this.a).pause();
      }
      bdew.c().post(new MiniAppVideoPlayer.7.1(this));
      MiniAppVideoPlayer.c(this.a, false);
      return;
      try
      {
        paramVideoPlayerProxy = new JSONObject();
        paramVideoPlayerProxy.put("videoId", this.a.jdField_a_of_type_Long);
        paramVideoPlayerProxy.put("data", this.a.jdField_a_of_type_JavaLangString);
        this.a.jdField_a_of_type_Bdcy.a("onVideoWaiting", paramVideoPlayerProxy.toString(), this.a.jdField_a_of_type_Int);
      }
      catch (JSONException paramVideoPlayerProxy)
      {
        paramVideoPlayerProxy.printStackTrace();
      }
    }
    MiniAppVideoPlayer.a(this.a).start();
    this.a.postDelayed(new MiniAppVideoPlayer.7.2(this), 200L);
    if (!this.a.jdField_a_of_type_Bdcy.getClass().getName().equals("com.tencent.qqmini.sdk.runtime.core.service.AppBrandService"))
    {
      MiniAppVideoPlayer.a(this.a, "play");
      MiniAppVideoPlayer.e(this.a);
      bdew.c().post(new MiniAppVideoPlayer.7.3(this));
      paramVideoPlayerProxy = new StringBuilder().append("onVideoPrepared: ").append(MiniAppVideoPlayer.a(this.a).getDuration()).append(" ").append(MiniAppVideoPlayer.a(this.a).getCurrentPostion()).append(" ");
      if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
        break label464;
      }
    }
    for (;;)
    {
      for (;;)
      {
        Log.i("MiniAppVideoPlayer", bool);
        MiniAppVideoPlayer.a(this.a, 200L);
        return;
        try
        {
          paramVideoPlayerProxy = new JSONObject();
          paramVideoPlayerProxy.put("videoId", this.a.jdField_a_of_type_Long);
          paramVideoPlayerProxy.put("data", this.a.jdField_a_of_type_JavaLangString);
          this.a.jdField_a_of_type_Bdcy.a("onVideoPlay", paramVideoPlayerProxy.toString(), this.a.jdField_a_of_type_Int);
          bdnw.a("MiniAppVideoPlayer", "OnVideoPreparedListener - onVideoPrepared evaluateSubcribeJS onVideoPlay = " + paramVideoPlayerProxy.toString());
        }
        catch (JSONException paramVideoPlayerProxy)
        {
          paramVideoPlayerProxy.printStackTrace();
        }
      }
      break;
      label464:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdjz
 * JD-Core Version:    0.7.0.1
 */