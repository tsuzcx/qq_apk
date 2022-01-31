import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresApi;
import com.tencent.youtufacetrack.YoutuFaceTracker;
import java.util.concurrent.atomic.AtomicInteger;

public class arcn
{
  protected arcf a;
  public arcx a;
  public YoutuFaceTracker a;
  public AtomicInteger a;
  protected String[] a;
  
  public arcn()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "libopencv_world.so", "libYTCommon.so", "libYTFaceTrackPro2.so", "libYTAGReflectLiveCheck.so", "libYTPoseDetect.so" };
  }
  
  @RequiresApi(api=18)
  public static arcn a(int paramInt, Intent paramIntent, arcx paramarcx)
  {
    return new arcs(paramIntent, paramarcx);
  }
  
  public int a(Context paramContext, String paramString)
  {
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Arcf != null) {
      this.jdField_a_of_type_Arcf.a();
    }
    if (this.jdField_a_of_type_ComTencentYoutufacetrackYoutuFaceTracker != null)
    {
      this.jdField_a_of_type_ComTencentYoutufacetrackYoutuFaceTracker.destroy();
      this.jdField_a_of_type_ComTencentYoutufacetrackYoutuFaceTracker = null;
      YoutuFaceTracker.GlobalRelease();
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity) {}
  
  public boolean a(String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arcn
 * JD-Core Version:    0.7.0.1
 */