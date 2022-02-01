import android.os.Message;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;

class ayhu
  extends TransProcessorHandler
{
  ayhu(ayhd paramayhd) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
    case 1003: 
      do
      {
        do
        {
          return;
        } while (localFileMsg.fileType != 8);
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..mPicUploadHandler.handleMessage(), upload success. photo_id = " + NearbyPeoplePhotoUploadProcessor.mPhotoId);
        }
      } while (ayhd.a(this.a) == null);
      ayhd.a(this.a).a = NearbyPeoplePhotoUploadProcessor.mPhotoId;
      ayhd.d(this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..mPicUploadHandler.handleMessage(), upload fail.");
    }
    this.a.a.b();
    this.a.a.b(anvx.a(2131706771));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayhu
 * JD-Core Version:    0.7.0.1
 */