import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;

public class booh
  extends QQUIEventReceiver<boof, bpjh>
{
  public booh(@NonNull boof paramboof)
  {
    super(paramboof);
  }
  
  public void a(@NonNull boof paramboof, @NonNull bpjh parambpjh)
  {
    if (parambpjh.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id.equals(boof.b(paramboof)))
    {
      if (parambpjh.jdField_a_of_type_Int != 0) {
        break label296;
      }
      if (!parambpjh.jdField_a_of_type_Boolean) {
        break label155;
      }
      yqp.b(this.TAG, "notify ui we finish downloading");
      paramboof.a.b = false;
      paramboof.a.g = parambpjh.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
      paramboof.a.c = 0;
      paramboof.a.d = 0;
      paramboof.d = 3;
      paramboof.b();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "download finished id=" + boof.b(paramboof) + " name=" + boof.a(paramboof));
      }
      if (boof.a(paramboof) != null) {
        wfo.a().unRegisterSubscriber(boof.a(paramboof));
      }
    }
    label155:
    label296:
    do
    {
      do
      {
        return;
        yqp.a(this.TAG, "notify ui we new progress : " + parambpjh.b + " / " + parambpjh.jdField_a_of_type_Long);
        paramboof.a.b = true;
        paramboof.a.g = null;
        paramboof.a.c = ((int)parambpjh.jdField_a_of_type_Long);
        paramboof.a.d = ((int)parambpjh.b);
        paramboof.d = 1;
      } while (!QLog.isColorLevel());
      QLog.d(this.TAG, 2, "downloading=" + paramboof.a.d + " max=" + paramboof.a.c);
      return;
      paramboof.a.b = false;
      paramboof.a.g = null;
      paramboof.a.c = 0;
      paramboof.a.d = 0;
      yqp.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + parambpjh.jdField_a_of_type_Int);
      yqv.a("0X80076C9");
      yqv.b("0X80075DE");
      paramboof.d = 2;
      paramboof.a(parambpjh.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "download error id=" + boof.b(paramboof) + " name=" + boof.a(paramboof));
      }
    } while (boof.a(paramboof) == null);
    wfo.a().unRegisterSubscriber(boof.a(paramboof));
  }
  
  public Class acceptEventClass()
  {
    return bpjh.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     booh
 * JD-Core Version:    0.7.0.1
 */