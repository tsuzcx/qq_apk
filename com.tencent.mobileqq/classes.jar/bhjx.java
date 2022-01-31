import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;

public class bhjx
  extends QQUIEventReceiver<bhjv, bikt>
{
  public bhjx(@NonNull bhjv parambhjv)
  {
    super(parambhjv);
  }
  
  public void a(@NonNull bhjv parambhjv, @NonNull bikt parambikt)
  {
    if (parambikt.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id.equals(bhjv.b(parambhjv)))
    {
      if (parambikt.jdField_a_of_type_Int != 0) {
        break label296;
      }
      if (!parambikt.jdField_a_of_type_Boolean) {
        break label155;
      }
      urk.b(this.TAG, "notify ui we finish downloading");
      parambhjv.a.b = false;
      parambhjv.a.g = parambikt.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
      parambhjv.a.c = 0;
      parambhjv.a.d = 0;
      parambhjv.d = 3;
      parambhjv.b();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "download finished id=" + bhjv.b(parambhjv) + " name=" + bhjv.a(parambhjv));
      }
      if (bhjv.a(parambhjv) != null) {
        sgi.a().unRegisterSubscriber(bhjv.a(parambhjv));
      }
    }
    label155:
    label296:
    do
    {
      do
      {
        return;
        urk.a(this.TAG, "notify ui we new progress : " + parambikt.b + " / " + parambikt.jdField_a_of_type_Long);
        parambhjv.a.b = true;
        parambhjv.a.g = null;
        parambhjv.a.c = ((int)parambikt.jdField_a_of_type_Long);
        parambhjv.a.d = ((int)parambikt.b);
        parambhjv.d = 1;
      } while (!QLog.isColorLevel());
      QLog.d(this.TAG, 2, "downloading=" + parambhjv.a.d + " max=" + parambhjv.a.c);
      return;
      parambhjv.a.b = false;
      parambhjv.a.g = null;
      parambhjv.a.c = 0;
      parambhjv.a.d = 0;
      urk.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + parambikt.jdField_a_of_type_Int);
      urq.a("0X80076C9");
      urq.b("0X80075DE");
      parambhjv.d = 2;
      parambhjv.a(parambikt.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "download error id=" + bhjv.b(parambhjv) + " name=" + bhjv.a(parambhjv));
      }
    } while (bhjv.a(parambhjv) == null);
    sgi.a().unRegisterSubscriber(bhjv.a(parambhjv));
  }
  
  public Class acceptEventClass()
  {
    return bikt.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhjx
 * JD-Core Version:    0.7.0.1
 */