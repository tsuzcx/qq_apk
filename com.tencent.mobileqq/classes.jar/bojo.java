import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;

public class bojo
  extends QQUIEventReceiver<bojm, boxg>
{
  public bojo(@NonNull bojm parambojm)
  {
    super(parambojm);
  }
  
  public void a(@NonNull bojm parambojm, @NonNull boxg paramboxg)
  {
    if (paramboxg.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id.equals(bojm.b(parambojm)))
    {
      if (paramboxg.jdField_a_of_type_Int != 0) {
        break label296;
      }
      if (!paramboxg.jdField_a_of_type_Boolean) {
        break label155;
      }
      ykq.b(this.TAG, "notify ui we finish downloading");
      parambojm.a.b = false;
      parambojm.a.g = paramboxg.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
      parambojm.a.c = 0;
      parambojm.a.d = 0;
      parambojm.d = 3;
      parambojm.b();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "download finished id=" + bojm.b(parambojm) + " name=" + bojm.a(parambojm));
      }
      if (bojm.a(parambojm) != null) {
        wad.a().unRegisterSubscriber(bojm.a(parambojm));
      }
    }
    label155:
    label296:
    do
    {
      do
      {
        return;
        ykq.a(this.TAG, "notify ui we new progress : " + paramboxg.b + " / " + paramboxg.jdField_a_of_type_Long);
        parambojm.a.b = true;
        parambojm.a.g = null;
        parambojm.a.c = ((int)paramboxg.jdField_a_of_type_Long);
        parambojm.a.d = ((int)paramboxg.b);
        parambojm.d = 1;
      } while (!QLog.isColorLevel());
      QLog.d(this.TAG, 2, "downloading=" + parambojm.a.d + " max=" + parambojm.a.c);
      return;
      parambojm.a.b = false;
      parambojm.a.g = null;
      parambojm.a.c = 0;
      parambojm.a.d = 0;
      ykq.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + paramboxg.jdField_a_of_type_Int);
      ykw.a("0X80076C9");
      ykw.b("0X80075DE");
      parambojm.d = 2;
      parambojm.a(paramboxg.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "download error id=" + bojm.b(parambojm) + " name=" + bojm.a(parambojm));
      }
    } while (bojm.a(parambojm) == null);
    wad.a().unRegisterSubscriber(bojm.a(parambojm));
  }
  
  public Class acceptEventClass()
  {
    return boxg.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bojo
 * JD-Core Version:    0.7.0.1
 */