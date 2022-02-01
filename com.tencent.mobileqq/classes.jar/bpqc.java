import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;

public class bpqc
  extends QQUIEventReceiver<bpqa, bqlc>
{
  public bpqc(@NonNull bpqa parambpqa)
  {
    super(parambpqa);
  }
  
  public void a(@NonNull bpqa parambpqa, @NonNull bqlc parambqlc)
  {
    if (parambqlc.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id.equals(bpqa.b(parambpqa)))
    {
      if (parambqlc.jdField_a_of_type_Int != 0) {
        break label296;
      }
      if (!parambqlc.jdField_a_of_type_Boolean) {
        break label155;
      }
      yuk.b(this.TAG, "notify ui we finish downloading");
      parambpqa.a.b = false;
      parambpqa.a.g = parambqlc.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
      parambpqa.a.c = 0;
      parambpqa.a.d = 0;
      parambpqa.d = 3;
      parambpqa.b();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "download finished id=" + bpqa.b(parambpqa) + " name=" + bpqa.a(parambpqa));
      }
      if (bpqa.a(parambpqa) != null) {
        wjj.a().unRegisterSubscriber(bpqa.a(parambpqa));
      }
    }
    label155:
    label296:
    do
    {
      do
      {
        return;
        yuk.a(this.TAG, "notify ui we new progress : " + parambqlc.b + " / " + parambqlc.jdField_a_of_type_Long);
        parambpqa.a.b = true;
        parambpqa.a.g = null;
        parambpqa.a.c = ((int)parambqlc.jdField_a_of_type_Long);
        parambpqa.a.d = ((int)parambqlc.b);
        parambpqa.d = 1;
      } while (!QLog.isColorLevel());
      QLog.d(this.TAG, 2, "downloading=" + parambpqa.a.d + " max=" + parambpqa.a.c);
      return;
      parambpqa.a.b = false;
      parambpqa.a.g = null;
      parambpqa.a.c = 0;
      parambpqa.a.d = 0;
      yuk.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + parambqlc.jdField_a_of_type_Int);
      yuq.a("0X80076C9");
      yuq.b("0X80075DE");
      parambpqa.d = 2;
      parambpqa.a(parambqlc.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "download error id=" + bpqa.b(parambpqa) + " name=" + bpqa.a(parambpqa));
      }
    } while (bpqa.a(parambpqa) == null);
    wjj.a().unRegisterSubscriber(bpqa.a(parambpqa));
  }
  
  public Class acceptEventClass()
  {
    return bqlc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqc
 * JD-Core Version:    0.7.0.1
 */