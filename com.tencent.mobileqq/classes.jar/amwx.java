import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import org.json.JSONObject;

class amwx
  implements MediaPlayer.OnSeekCompleteListener
{
  amwx(amwv paramamwv, JSONObject paramJSONObject, amxv paramamxv) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
      amwv.a(this.jdField_a_of_type_Amwv, this.jdField_a_of_type_Amxv, this.jdField_a_of_type_OrgJsonJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwx
 * JD-Core Version:    0.7.0.1
 */