import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresApi;
import com.tencent.youtufacetrack.YoutuFaceTracker;
import java.util.concurrent.atomic.AtomicInteger;

public class arcp
{
  protected arch a;
  public arcz a;
  public YoutuFaceTracker a;
  public AtomicInteger a;
  protected String[] a;
  
  public arcp()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "libopencv_world.so", "libYTCommon.so", "libYTFaceTrackPro2.so", "libYTAGReflectLiveCheck.so", "libYTPoseDetect.so" };
  }
  
  @RequiresApi(api=18)
  public static arcp a(int paramInt, Intent paramIntent, arcz paramarcz)
  {
    return new arcu(paramIntent, paramarcz);
  }
  
  public int a(Context paramContext, String paramString)
  {
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Arch != null) {
      this.jdField_a_of_type_Arch.a();
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
 * Qualified Name:     arcp
 * JD-Core Version:    0.7.0.1
 */