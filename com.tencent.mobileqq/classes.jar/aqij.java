import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQIdentiferActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame;
import com.tencent.youtufacetrack.YoutuFaceTracker;
import com.tencent.youtufacetrack.YoutuFaceTracker.FaceStatus;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public class aqij
  extends aqie
  implements YTPoseDetectInterface.PoseDetectOnFrame
{
  @RequiresApi(api=18)
  public aqij(Intent paramIntent, aqit paramaqit)
  {
    this.jdField_a_of_type_Aqit = paramaqit;
    this.jdField_a_of_type_Aqib = new aqir(paramIntent, paramaqit);
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
      int k = YTPoseDetectInterface.initModel("");
      i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      QLog.d("qq_Identification.Model", 1, "pose detect init result: " + k + ",pdCount:" + i);
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
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() == 0) {
      YTPoseDetectInterface.releaseModel();
    }
  }
  
  public void a(QQIdentiferActivity paramQQIdentiferActivity, Camera paramCamera, int paramInt)
  {
    try
    {
      YTPoseDetectInterface.start(paramQQIdentiferActivity, paramCamera, paramInt, new aqik(this));
      return;
    }
    catch (Exception paramQQIdentiferActivity)
    {
      QLog.d("qq_Identification.Model", 1, "startPoseDetect happened error:" + paramQQIdentiferActivity.getMessage());
    }
  }
  
  public void a(YoutuFaceTracker.FaceStatus paramFaceStatus, int paramInt, byte[] paramArrayOfByte, Camera paramCamera)
  {
    if ((YTPoseDetectInterface.isDetecting()) && (paramFaceStatus != null)) {
      YTPoseDetectInterface.poseDetect(paramFaceStatus.xys, paramInt, paramArrayOfByte, paramCamera, paramFaceStatus.pitch, paramFaceStatus.yaw, paramFaceStatus.roll, this);
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
  
  public void onFailed(int paramInt, String paramString1, String paramString2) {}
  
  public void onRecordingDone(byte[][] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qq_Identification.Model", 2, "onRecordingDone -收到视频上传通知，帧数：" + paramArrayOfByte.length + "*" + paramArrayOfByte[0].length + " 每帧width：" + paramInt1 + " 每帧height: " + paramInt2);
    }
    YTPoseDetectInterface.stop();
    int i = 1;
    if (this.jdField_a_of_type_Aqit != null)
    {
      i = this.jdField_a_of_type_Aqit.a().getInt("params_pose", 1);
      this.jdField_a_of_type_Aqit.a();
    }
    this.jdField_a_of_type_Aqib.a(paramArrayOfByte, paramInt1, paramInt2, i);
  }
  
  public void onSuccess(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqij
 * JD-Core Version:    0.7.0.1
 */