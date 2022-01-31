import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresApi;
import com.tencent.youtufacetrack.YoutuFaceTracker;
import java.util.concurrent.atomic.AtomicInteger;

public class astd
{
  protected assv a;
  public astn a;
  public YoutuFaceTracker a;
  public AtomicInteger a;
  protected String[] a;
  
  public astd()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "libopencv_world.so", "libYTCommon.so", "libYTFaceTrackPro2.so", "libYTAGReflectLiveCheck.so", "libYTPoseDetect.so" };
  }
  
  @RequiresApi(api=18)
  public static astd a(int paramInt, Intent paramIntent, astn paramastn)
  {
    return new asti(paramIntent, paramastn);
  }
  
  public int a(Context paramContext, String paramString)
  {
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Assv != null) {
      this.jdField_a_of_type_Assv.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astd
 * JD-Core Version:    0.7.0.1
 */