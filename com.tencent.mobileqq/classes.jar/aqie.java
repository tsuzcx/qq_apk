import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.support.annotation.RequiresApi;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.QQIdentiferActivity;
import com.tencent.youtufacetrack.YoutuFaceTracker;
import com.tencent.youtufacetrack.YoutuFaceTracker.FaceStatus;
import java.util.concurrent.atomic.AtomicInteger;

public class aqie
{
  protected aqib a;
  protected aqit a;
  public YoutuFaceTracker a;
  public AtomicInteger a;
  protected String[] a;
  
  public aqie()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "libYTCommon.so", "libYTFaceTrackPro.so", "libYTNextCV.so", "libYTAGReflectLiveCheck.so", "libYTPoseDetect.so", "libfacetrackwrap.so" };
  }
  
  @RequiresApi(api=18)
  public static aqie a(int paramInt, Intent paramIntent, aqit paramaqit)
  {
    if (paramInt == 3) {
      return new aqij(paramIntent, paramaqit);
    }
    if (paramInt == 2) {
      return new aqil(paramIntent, paramaqit);
    }
    QLog.e("qq_Identification.Model", 0, "create IdentificationBaseModel error :" + paramInt);
    return null;
  }
  
  public int a(Context paramContext, String paramString)
  {
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aqib != null) {
      this.jdField_a_of_type_Aqib.a();
    }
    if (this.jdField_a_of_type_ComTencentYoutufacetrackYoutuFaceTracker != null)
    {
      this.jdField_a_of_type_ComTencentYoutufacetrackYoutuFaceTracker.destroy();
      this.jdField_a_of_type_ComTencentYoutufacetrackYoutuFaceTracker = null;
      YoutuFaceTracker.GlobalRelease();
    }
  }
  
  public void a(QQIdentiferActivity paramQQIdentiferActivity, Camera paramCamera, int paramInt) {}
  
  public void a(boolean paramBoolean, Activity paramActivity) {}
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  public YoutuFaceTracker.FaceStatus[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    YoutuFaceTracker.FaceStatus[] arrayOfFaceStatus = null;
    if (this.jdField_a_of_type_ComTencentYoutufacetrackYoutuFaceTracker != null) {
      arrayOfFaceStatus = this.jdField_a_of_type_ComTencentYoutufacetrackYoutuFaceTracker.DoDetectionProcessYUV(paramArrayOfByte, paramInt1, paramInt2);
    }
    return arrayOfFaceStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqie
 * JD-Core Version:    0.7.0.1
 */