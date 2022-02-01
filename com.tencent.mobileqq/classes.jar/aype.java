import android.os.Message;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;

class aype
  extends beyf
{
  aype(ayot paramayot) {}
  
  public void handleMessage(Message paramMessage)
  {
    bete localbete = (bete)paramMessage.obj;
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
        } while (localbete.b != 8);
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..mPicUploadHandler.handleMessage(), upload success. photo_id = " + bevi.a);
        }
      } while (ayot.a(this.a) == null);
      ayot.a(this.a).a = bevi.a;
      ayot.a(this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..mPicUploadHandler.handleMessage(), upload fail.");
    }
    this.a.a.a();
    this.a.a.b(anzj.a(2131706205));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aype
 * JD-Core Version:    0.7.0.1
 */