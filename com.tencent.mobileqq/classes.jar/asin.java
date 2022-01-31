import android.os.Message;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class asin
  extends axvs
{
  public asin(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    axqf localaxqf = (axqf)paramMessage.obj;
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1002: 
      if (localaxqf.a <= 0L) {
        break;
      }
    }
    for (int i = (int)(localaxqf.e * 100L / localaxqf.a); QLog.isColorLevel(); i = 0)
    {
      QLog.d("Q.nearby_people_card.upload_local_photo", 2, "NearbyGuideActivity .mPicUploadHandler.handleMessage, send process : " + i);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.upload_local_photo", 2, "NearbyGuideActivity.mPicUploadHandler.handleMessage(), upload success. photo_id = " + axsm.a);
      }
      i = axsm.a;
      if (i >= 0) {
        this.a.a.set(0, Integer.valueOf(i));
      }
      this.a.a(this.a.a);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.upload_local_photo", 2, "NearbyGuideActivity.mPicUploadHandler.handleMessage(), upload fail.");
      }
      this.a.l();
      this.a.c(ajjy.a(2131641398));
      this.a.a(true, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asin
 * JD-Core Version:    0.7.0.1
 */