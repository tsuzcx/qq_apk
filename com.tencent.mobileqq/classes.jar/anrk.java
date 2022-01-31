import android.widget.Toast;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;

public class anrk
  implements Runnable
{
  public anrk(RMVideoStateMgr paramRMVideoStateMgr, String paramString) {}
  
  public void run()
  {
    Toast.makeText(VideoEnvironment.a(), "" + this.jdField_a_of_type_JavaLangString, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anrk
 * JD-Core Version:    0.7.0.1
 */