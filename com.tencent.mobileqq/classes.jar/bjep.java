import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;

public class bjep
  extends QQUIEventReceiver<bjen, bkbo>
{
  public bjep(@NonNull bjen parambjen)
  {
    super(parambjen);
  }
  
  public void a(@NonNull bjen parambjen, @NonNull bkbo parambkbo)
  {
    if (parambkbo.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id.equals(bjen.b(parambjen)))
    {
      if (parambkbo.jdField_a_of_type_Int != 0) {
        break label296;
      }
      if (!parambkbo.jdField_a_of_type_Boolean) {
        break label155;
      }
      veg.b(this.TAG, "notify ui we finish downloading");
      parambjen.a.b = false;
      parambjen.a.g = parambkbo.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
      parambjen.a.c = 0;
      parambjen.a.d = 0;
      parambjen.d = 3;
      parambjen.b();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "download finished id=" + bjen.b(parambjen) + " name=" + bjen.a(parambjen));
      }
      if (bjen.a(parambjen) != null) {
        ste.a().unRegisterSubscriber(bjen.a(parambjen));
      }
    }
    label155:
    label296:
    do
    {
      do
      {
        return;
        veg.a(this.TAG, "notify ui we new progress : " + parambkbo.b + " / " + parambkbo.jdField_a_of_type_Long);
        parambjen.a.b = true;
        parambjen.a.g = null;
        parambjen.a.c = ((int)parambkbo.jdField_a_of_type_Long);
        parambjen.a.d = ((int)parambkbo.b);
        parambjen.d = 1;
      } while (!QLog.isColorLevel());
      QLog.d(this.TAG, 2, "downloading=" + parambjen.a.d + " max=" + parambjen.a.c);
      return;
      parambjen.a.b = false;
      parambjen.a.g = null;
      parambjen.a.c = 0;
      parambjen.a.d = 0;
      veg.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + parambkbo.jdField_a_of_type_Int);
      vem.a("0X80076C9");
      vem.b("0X80075DE");
      parambjen.d = 2;
      parambjen.a(parambkbo.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "download error id=" + bjen.b(parambjen) + " name=" + bjen.a(parambjen));
      }
    } while (bjen.a(parambjen) == null);
    ste.a().unRegisterSubscriber(bjen.a(parambjen));
  }
  
  public Class acceptEventClass()
  {
    return bkbo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjep
 * JD-Core Version:    0.7.0.1
 */