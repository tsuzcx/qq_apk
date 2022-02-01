import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class amkv
  implements MediaPlayer.OnCompletionListener
{
  amkv(amkr paramamkr, int paramInt, String paramString) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    QLog.e("QVipSpecialSoundWebViewPlugin", 1, "play completed, soundId:" + this.jdField_a_of_type_Int);
    try
    {
      paramMediaPlayer = new JSONObject();
      paramMediaPlayer.put("code", 1);
      this.jdField_a_of_type_Amkr.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramMediaPlayer.toString() });
      return;
    }
    catch (JSONException paramMediaPlayer)
    {
      QLog.e("QVipSpecialSoundWebViewPlugin", 1, "onCompletion: " + this.jdField_a_of_type_Int, paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkv
 * JD-Core Version:    0.7.0.1
 */