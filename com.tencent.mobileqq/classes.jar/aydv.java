import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;

class aydv
  implements URLDrawable.URLDrawableListener
{
  aydv(aydu paramaydu, ImageView paramImageView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "download vote onLoadCanceled");
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "download vote onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "download vote onLoadProgressed");
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "download vote headImage success");
    }
    this.jdField_a_of_type_Aydu.a.a(this.jdField_a_of_type_AndroidWidgetImageView, paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydv
 * JD-Core Version:    0.7.0.1
 */