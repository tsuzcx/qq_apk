import android.os.Message;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;

class attr
  extends aywb
{
  attr(attg paramattg) {}
  
  public void handleMessage(Message paramMessage)
  {
    ayqo localayqo = (ayqo)paramMessage.obj;
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
        } while (localayqo.b != 8);
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..mPicUploadHandler.handleMessage(), upload success. photo_id = " + aysv.a);
        }
      } while (attg.a(this.a) == null);
      attg.a(this.a).a = aysv.a;
      attg.a(this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..mPicUploadHandler.handleMessage(), upload fail.");
    }
    this.a.a.a();
    this.a.a.b(ajya.a(2131707323));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     attr
 * JD-Core Version:    0.7.0.1
 */