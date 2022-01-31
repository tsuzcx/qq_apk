import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend;
import com.tencent.qphone.base.util.QLog;

public class apjl
  implements apji
{
  public apjl(CameraEmoSingleSend paramCameraEmoSingleSend) {}
  
  public void a(int paramInt, CameraEmotionData paramCameraEmotionData)
  {
    boolean bool = true;
    QLog.d("CameraEmoSingleSend", 1, new Object[] { "onAddEmoFinish, result:", Integer.valueOf(paramInt), " emoId:", Integer.valueOf(paramCameraEmotionData.emoId), " originalId:", Integer.valueOf(CameraEmoSingleSend.a(this.a).emoId) });
    if (paramInt == 0) {}
    for (;;)
    {
      CameraEmoSingleSend.a(this.a, bool, paramInt);
      aube.c(String.valueOf(paramInt), 2);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apjl
 * JD-Core Version:    0.7.0.1
 */