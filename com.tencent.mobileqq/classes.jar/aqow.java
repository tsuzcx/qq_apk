import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.pic.AIOFilePicData;
import java.util.Locale;

class aqow
  implements MessageQueue.IdleHandler
{
  aqow(aqot paramaqot) {}
  
  public boolean queueIdle()
  {
    Object localObject = this.a.jdField_a_of_type_Aqnh.a();
    if ((localObject != null) && (((aqmi)localObject).a != null) && (((aqmi)localObject).a.a() == 3))
    {
      localObject = (AIOFilePicData)((aqmi)localObject).a;
      aqmp localaqmp = new aqmp();
      if ((localObject != null) && (localaqmp.a((AIOFilePicData)localObject, 20)) && (localaqmp.a((AIOFilePicData)localObject, 20) == null))
      {
        if ((!((AIOFilePicData)localObject).g) || (!bbfh.a(((AIOFilePicData)localObject).d))) {
          break label146;
        }
        this.a.e(true);
        this.a.j();
      }
    }
    for (;;)
    {
      this.a.a(String.format(Locale.CHINA, this.a.jdField_a_of_type_AndroidAppActivity.getString(2131695342), new Object[] { apvd.a(((AIOFilePicData)localObject).e) }));
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
 * Qualified Name:     aqow
 * JD-Core Version:    0.7.0.1
 */