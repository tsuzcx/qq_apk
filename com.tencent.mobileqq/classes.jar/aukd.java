import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresApi;
import com.tencent.youtufacetrack.YoutuFaceTracker;

public class aukd
{
  static String[] a;
  static String[] b = { "libopencv_world.so", "libYTCommon.so", "libYTFaceTrackPro.so" };
  protected aujp a;
  public aukp a;
  public YoutuFaceTracker a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "libYTAGReflectLiveCheck.so", "libYTPoseDetect.so" };
  }
  
  @RequiresApi(api=18)
  public static aukd a(int paramInt, Intent paramIntent, aukp paramaukp)
  {
    return new aukk(paramIntent, paramaukp);
  }
  
  public int a(Context paramContext, String paramString)
  {
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aujp != null) {
      this.jdField_a_of_type_Aujp.a();
    }
    if (this.jdField_a_of_type_ComTencentYoutufacetrackYoutuFaceTracker != null)
    {
      this.jdField_a_of_type_ComTencentYoutufacetrackYoutuFaceTracker.destroy();
      this.jdField_a_of_type_ComTencentYoutufacetrackYoutuFaceTracker = null;
      YoutuFaceTracker.GlobalRelease();
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity) {}
  
  public boolean a(String paramString, String[] paramArrayOfString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aukd
 * JD-Core Version:    0.7.0.1
 */