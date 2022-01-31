import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQIdentiferActivity;
import com.tencent.mobileqq.identification.IdentificationReflect.1;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtufacetrack.YoutuFaceTracker;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public class aqil
  extends aqie
{
  private String a;
  
  public aqil(Intent paramIntent, aqit paramaqit)
  {
    this.jdField_a_of_type_Aqit = paramaqit;
    this.jdField_a_of_type_Aqib = new aqip(paramIntent, paramaqit);
    paramIntent = (FaceDetectForThirdPartyManager.AppConf)paramIntent.getSerializableExtra("FaceRecognition.AppConf");
    if (paramIntent != null) {
      this.jdField_a_of_type_JavaLangString = paramIntent.colorSequence;
    }
  }
  
  public int a(Context paramContext, String paramString)
  {
    int j = 1;
    YoutuFaceTracker.nativeInit();
    boolean bool = YoutuFaceTracker.GlobalInit(paramString);
    this.jdField_a_of_type_ComTencentYoutufacetrackYoutuFaceTracker = new YoutuFaceTracker();
    int i = j;
    if (bool)
    {
      int k = YTAGReflectLiveCheckInterface.initModel();
      i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      QLog.d("qq_Identification.Model", 1, "Reflect detect init result: " + k + ",pdCount:" + i);
      i = j;
      if (k == 0) {
        i = 0;
      }
    }
    return i;
  }
  
  public void a()
  {
    super.a();
    if (YTAGReflectLiveCheckInterface.getProcessState() == 2) {
      YTAGReflectLiveCheckInterface.cancel();
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() == 0) {
      YTAGReflectLiveCheckInterface.releaseModel();
    }
  }
  
  @RequiresApi(api=18)
  public void a(QQIdentiferActivity paramQQIdentiferActivity, Camera paramCamera, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qq_Identification.Model", 2, "YTAGReflectLiveCheckInterface startDetect");
    }
    YTAGReflectLiveCheckInterface.setRGBConfigRequest(new aqim(this));
    YTAGReflectLiveCheckInterface.setUploadVideoRequesterV2(new aqin(this));
    YTAGReflectLiveCheckInterface.setSafetyLevel(2);
    YTAGReflectLiveCheckInterface.start(paramQQIdentiferActivity.getApplicationContext(), paramCamera, paramInt, paramQQIdentiferActivity.a, new aqio(this));
  }
  
  public void a(boolean paramBoolean, Activity paramActivity)
  {
    super.a(paramBoolean, paramActivity);
    if (paramBoolean) {
      new Handler(Looper.getMainLooper()).post(new IdentificationReflect.1(this, paramActivity));
    }
  }
  
  public boolean a(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {}
    while (!new File(paramString).exists()) {
      return false;
    }
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    while (i < j)
    {
      String str = arrayOfString[i];
      System.load(paramString + str);
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqil
 * JD-Core Version:    0.7.0.1
 */