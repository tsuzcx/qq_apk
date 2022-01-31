import android.os.Message;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;

class aswn
  extends axvs
{
  aswn(asvw paramasvw) {}
  
  public void handleMessage(Message paramMessage)
  {
    axqf localaxqf = (axqf)paramMessage.obj;
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
        } while (localaxqf.b != 8);
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..mPicUploadHandler.handleMessage(), upload success. photo_id = " + axsm.a);
        }
      } while (asvw.a(this.a) == null);
      asvw.a(this.a).a = axsm.a;
      asvw.c(this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..mPicUploadHandler.handleMessage(), upload fail.");
    }
    this.a.a.a();
    this.a.a.b(ajjy.a(2131641511));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aswn
 * JD-Core Version:    0.7.0.1
 */