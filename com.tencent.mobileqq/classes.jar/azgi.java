import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.common.app.BaseApplicationImpl;

class azgi
  implements MediaPlayer.OnCompletionListener
{
  azgi(azgh paramazgh, String paramString) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
    azgh.a(this.jdField_a_of_type_Azgh, null);
    if (azgh.a(this.jdField_a_of_type_Azgh) != null) {
      azgh.a(this.jdField_a_of_type_Azgh).b(this.jdField_a_of_type_JavaLangString);
    }
    bftt.a(BaseApplicationImpl.getContext(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgi
 * JD-Core Version:    0.7.0.1
 */