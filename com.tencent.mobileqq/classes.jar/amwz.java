import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import org.json.JSONObject;

class amwz
  implements MediaPlayer.OnPreparedListener
{
  amwz(amwv paramamwv, JSONObject paramJSONObject, amxv paramamxv) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.jdField_a_of_type_Amwv.a(3);
    if (amwv.a(this.jdField_a_of_type_Amwv)) {
      this.jdField_a_of_type_Amwv.b(this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Amxv);
    }
    if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
      amwv.a(this.jdField_a_of_type_Amwv, this.jdField_a_of_type_Amxv, this.jdField_a_of_type_OrgJsonJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwz
 * JD-Core Version:    0.7.0.1
 */