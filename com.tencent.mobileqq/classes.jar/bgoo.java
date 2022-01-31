import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnInfoListener;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bgoo
  implements VideoPlayerProxy.OnInfoListener
{
  public bgoo(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public boolean onInfo(VideoPlayerProxy paramVideoPlayerProxy, int paramInt1, int paramInt2)
  {
    QMLog.i("MiniAppVideoPlayer", "onInfo: " + paramInt1 + " " + paramInt1);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return false;
      QMLog.d("MiniAppVideoPlayer", "video player PLAYER_INFO_START_BUFFERING--------------");
      try
      {
        paramVideoPlayerProxy = new JSONObject();
        paramVideoPlayerProxy.put("data", this.a.jdField_a_of_type_JavaLangString);
        this.a.jdField_a_of_type_Bghn.a("onVideoLoadStart", paramVideoPlayerProxy.toString(), this.a.jdField_a_of_type_Int);
        QMLog.d("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoLoadStart = " + paramVideoPlayerProxy.toString());
      }
      catch (JSONException paramVideoPlayerProxy)
      {
        paramVideoPlayerProxy.printStackTrace();
      }
      continue;
      QMLog.d("MiniAppVideoPlayer", "video player PLAYER_INFO_ENDOF_BUFFERING--------------");
      try
      {
        paramVideoPlayerProxy = new JSONObject();
        paramVideoPlayerProxy.put("data", this.a.jdField_a_of_type_JavaLangString);
        this.a.jdField_a_of_type_Bghn.a("onVideoLoadedData", paramVideoPlayerProxy.toString(), this.a.jdField_a_of_type_Int);
        QMLog.d("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoLoadedData = " + paramVideoPlayerProxy.toString());
      }
      catch (JSONException paramVideoPlayerProxy)
      {
        paramVideoPlayerProxy.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgoo
 * JD-Core Version:    0.7.0.1
 */