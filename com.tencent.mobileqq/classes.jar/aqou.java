import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.pic.AIOFilePicData;
import java.util.Locale;

class aqou
  implements MessageQueue.IdleHandler
{
  aqou(aqor paramaqor) {}
  
  public boolean queueIdle()
  {
    Object localObject = this.a.jdField_a_of_type_Aqnf.a();
    if ((localObject != null) && (((aqmg)localObject).a != null) && (((aqmg)localObject).a.a() == 3))
    {
      localObject = (AIOFilePicData)((aqmg)localObject).a;
      aqmn localaqmn = new aqmn();
      if ((localObject != null) && (localaqmn.a((AIOFilePicData)localObject, 20)) && (localaqmn.a((AIOFilePicData)localObject, 20) == null))
      {
        if ((!((AIOFilePicData)localObject).g) || (!bbet.a(((AIOFilePicData)localObject).d))) {
          break label146;
        }
        this.a.e(true);
        this.a.j();
      }
    }
    for (;;)
    {
      this.a.a(String.format(Locale.CHINA, this.a.jdField_a_of_type_AndroidAppActivity.getString(2131695341), new Object[] { apvb.a(((AIOFilePicData)localObject).e) }));
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
 * Qualified Name:     aqou
 * JD-Core Version:    0.7.0.1
 */