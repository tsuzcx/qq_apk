import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.CameraEmotionData;

public class amou
  implements BusinessObserver
{
  protected void doOnAddEmoResult(int paramInt, CameraEmotionData paramCameraEmotionData) {}
  
  protected void doOnDeleteEmoResult(int paramInt) {}
  
  protected void doOnGetEmoListResult(int paramInt) {}
  
  protected void onCameraEmoInsert() {}
  
  protected void onCameraEmoSend(boolean paramBoolean, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramObject = (Object[])paramObject;
      doOnAddEmoResult(((Integer)paramObject[0]).intValue(), (CameraEmotionData)paramObject[1]);
      return;
    case 2: 
      doOnGetEmoListResult(((Integer)paramObject).intValue());
      return;
    case 3: 
      doOnDeleteEmoResult(((Integer)paramObject).intValue());
      return;
    case 4: 
      onCameraEmoInsert();
      return;
    }
    onCameraEmoSend(paramBoolean, ((Integer)paramObject).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amou
 * JD-Core Version:    0.7.0.1
 */