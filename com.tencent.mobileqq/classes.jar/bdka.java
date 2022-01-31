import android.os.Handler;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnCompletionListener;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer.8.1;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer.8.2;
import org.json.JSONObject;

public class bdka
  implements VideoPlayerProxy.OnCompletionListener
{
  public bdka(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onCompletion(VideoPlayerProxy paramVideoPlayerProxy)
  {
    if (this.a.c) {
      bdew.c().post(new MiniAppVideoPlayer.8.1(this));
    }
    if (!this.a.jdField_a_of_type_Bdcy.getClass().getName().equals("com.tencent.qqmini.sdk.runtime.core.service.AppBrandService")) {
      MiniAppVideoPlayer.a(this.a, "ended");
    }
    for (;;)
    {
      bdew.c().post(new MiniAppVideoPlayer.8.2(this));
      return;
      try
      {
        paramVideoPlayerProxy = new JSONObject();
        paramVideoPlayerProxy.put("data", this.a.jdField_a_of_type_JavaLangString);
        paramVideoPlayerProxy.put("videoId", this.a.jdField_a_of_type_Long);
        this.a.jdField_a_of_type_Bdcy.a("onVideoEnded", paramVideoPlayerProxy.toString(), this.a.jdField_a_of_type_Int);
        bdnw.a("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoEnded = " + paramVideoPlayerProxy.toString());
      }
      catch (Exception paramVideoPlayerProxy)
      {
        paramVideoPlayerProxy.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdka
 * JD-Core Version:    0.7.0.1
 */