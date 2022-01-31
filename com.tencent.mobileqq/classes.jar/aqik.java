import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult;

class aqik
  implements YTPoseDetectInterface.PoseDetectResult
{
  aqik(aqij paramaqij) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qq_Identification.Model", 2, "pose detect start failed: " + paramInt + " reson: " + paramString1 + " do more: " + paramString2);
    }
  }
  
  public void onSuccess() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqik
 * JD-Core Version:    0.7.0.1
 */