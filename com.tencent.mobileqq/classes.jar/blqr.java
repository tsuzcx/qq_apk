import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;

public class blqr
  extends QQUIEventReceiver<blqp, bmnp>
{
  public blqr(@NonNull blqp paramblqp)
  {
    super(paramblqp);
  }
  
  public void a(@NonNull blqp paramblqp, @NonNull bmnp parambmnp)
  {
    if (parambmnp.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id.equals(blqp.b(paramblqp)))
    {
      if (parambmnp.jdField_a_of_type_Int != 0) {
        break label296;
      }
      if (!parambmnp.jdField_a_of_type_Boolean) {
        break label155;
      }
      wsv.b(this.TAG, "notify ui we finish downloading");
      paramblqp.a.b = false;
      paramblqp.a.g = parambmnp.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
      paramblqp.a.c = 0;
      paramblqp.a.d = 0;
      paramblqp.d = 3;
      paramblqp.b();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "download finished id=" + blqp.b(paramblqp) + " name=" + blqp.a(paramblqp));
      }
      if (blqp.a(paramblqp) != null) {
        uht.a().unRegisterSubscriber(blqp.a(paramblqp));
      }
    }
    label155:
    label296:
    do
    {
      do
      {
        return;
        wsv.a(this.TAG, "notify ui we new progress : " + parambmnp.b + " / " + parambmnp.jdField_a_of_type_Long);
        paramblqp.a.b = true;
        paramblqp.a.g = null;
        paramblqp.a.c = ((int)parambmnp.jdField_a_of_type_Long);
        paramblqp.a.d = ((int)parambmnp.b);
        paramblqp.d = 1;
      } while (!QLog.isColorLevel());
      QLog.d(this.TAG, 2, "downloading=" + paramblqp.a.d + " max=" + paramblqp.a.c);
      return;
      paramblqp.a.b = false;
      paramblqp.a.g = null;
      paramblqp.a.c = 0;
      paramblqp.a.d = 0;
      wsv.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + parambmnp.jdField_a_of_type_Int);
      wtb.a("0X80076C9");
      wtb.b("0X80075DE");
      paramblqp.d = 2;
      paramblqp.a(parambmnp.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "download error id=" + blqp.b(paramblqp) + " name=" + blqp.a(paramblqp));
      }
    } while (blqp.a(paramblqp) == null);
    uht.a().unRegisterSubscriber(blqp.a(paramblqp));
  }
  
  public Class acceptEventClass()
  {
    return bmnp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqr
 * JD-Core Version:    0.7.0.1
 */