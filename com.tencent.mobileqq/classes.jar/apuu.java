import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.pic.AIOFilePicData;
import java.util.Locale;

class apuu
  implements MessageQueue.IdleHandler
{
  apuu(apur paramapur) {}
  
  public boolean queueIdle()
  {
    Object localObject = this.a.jdField_a_of_type_Aptg.a();
    if ((localObject != null) && (((apsr)localObject).a != null) && (((apsr)localObject).a.a() == 3))
    {
      localObject = (AIOFilePicData)((apsr)localObject).a;
      apsy localapsy = new apsy();
      if ((localObject != null) && (localapsy.a((AIOFilePicData)localObject, 20)) && (localapsy.a((AIOFilePicData)localObject, 20) == null))
      {
        if ((!((AIOFilePicData)localObject).g) || (!bado.a(((AIOFilePicData)localObject).d))) {
          break label146;
        }
        this.a.e(true);
        this.a.j();
      }
    }
    for (;;)
    {
      this.a.a(String.format(Locale.CHINA, this.a.jdField_a_of_type_AndroidAppActivity.getString(2131629660), new Object[] { apdh.a(((AIOFilePicData)localObject).e) }));
      return false;
      label146:
      if (((AIOFilePicData)localObject).h) {
        this.a.e(false);
      } else {
        this.a.e(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apuu
 * JD-Core Version:    0.7.0.1
 */