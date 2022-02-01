import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresApi;
import com.tencent.youtufacetrack.YoutuFaceTracker;

public class avxd
{
  static String[] a;
  static String[] b = { "libopencv_world.so", "libYTCommon.so", "libYTFaceTrackPro.so" };
  protected avwp a;
  public avxp a;
  public YoutuFaceTracker a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "libYTAGReflectLiveCheck.so", "libYTPoseDetect.so" };
  }
  
  @RequiresApi(api=18)
  public static avxd a(int paramInt, Intent paramIntent, avxp paramavxp)
  {
    return new avxk(paramIntent, paramavxp);
  }
  
  public int a(Context paramContext, String paramString)
  {
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Avwp != null) {
      this.jdField_a_of_type_Avwp.a();
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
 * Qualified Name:     avxd
 * JD-Core Version:    0.7.0.1
 */