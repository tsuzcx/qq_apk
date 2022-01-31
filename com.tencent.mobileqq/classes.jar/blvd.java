import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;

public class blvd
  extends QQUIEventReceiver<blvb, bmsb>
{
  public blvd(@NonNull blvb paramblvb)
  {
    super(paramblvb);
  }
  
  public void a(@NonNull blvb paramblvb, @NonNull bmsb parambmsb)
  {
    if (parambmsb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id.equals(blvb.b(paramblvb)))
    {
      if (parambmsb.jdField_a_of_type_Int != 0) {
        break label296;
      }
      if (!parambmsb.jdField_a_of_type_Boolean) {
        break label155;
      }
      wxe.b(this.TAG, "notify ui we finish downloading");
      paramblvb.a.b = false;
      paramblvb.a.g = parambmsb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
      paramblvb.a.c = 0;
      paramblvb.a.d = 0;
      paramblvb.d = 3;
      paramblvb.b();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "download finished id=" + blvb.b(paramblvb) + " name=" + blvb.a(paramblvb));
      }
      if (blvb.a(paramblvb) != null) {
        umc.a().unRegisterSubscriber(blvb.a(paramblvb));
      }
    }
    label155:
    label296:
    do
    {
      do
      {
        return;
        wxe.a(this.TAG, "notify ui we new progress : " + parambmsb.b + " / " + parambmsb.jdField_a_of_type_Long);
        paramblvb.a.b = true;
        paramblvb.a.g = null;
        paramblvb.a.c = ((int)parambmsb.jdField_a_of_type_Long);
        paramblvb.a.d = ((int)parambmsb.b);
        paramblvb.d = 1;
      } while (!QLog.isColorLevel());
      QLog.d(this.TAG, 2, "downloading=" + paramblvb.a.d + " max=" + paramblvb.a.c);
      return;
      paramblvb.a.b = false;
      paramblvb.a.g = null;
      paramblvb.a.c = 0;
      paramblvb.a.d = 0;
      wxe.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + parambmsb.jdField_a_of_type_Int);
      wxk.a("0X80076C9");
      wxk.b("0X80075DE");
      paramblvb.d = 2;
      paramblvb.a(parambmsb.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "download error id=" + blvb.b(paramblvb) + " name=" + blvb.a(paramblvb));
      }
    } while (blvb.a(paramblvb) == null);
    umc.a().unRegisterSubscriber(blvb.a(paramblvb));
  }
  
  public Class acceptEventClass()
  {
    return bmsb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvd
 * JD-Core Version:    0.7.0.1
 */