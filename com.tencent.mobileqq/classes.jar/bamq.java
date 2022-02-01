import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.common.app.BaseApplicationImpl;

class bamq
  implements MediaPlayer.OnCompletionListener
{
  bamq(bamp parambamp, String paramString) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
    bamp.a(this.jdField_a_of_type_Bamp, null);
    if (bamp.a(this.jdField_a_of_type_Bamp) != null) {
      bamp.a(this.jdField_a_of_type_Bamp).b(this.jdField_a_of_type_JavaLangString);
    }
    bhcl.a(BaseApplicationImpl.getContext(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamq
 * JD-Core Version:    0.7.0.1
 */