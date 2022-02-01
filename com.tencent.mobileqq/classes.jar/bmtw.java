import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;

public class bmtw
  extends QQUIEventReceiver<bmtu, bnho>
{
  public bmtw(@NonNull bmtu parambmtu)
  {
    super(parambmtu);
  }
  
  public void a(@NonNull bmtu parambmtu, @NonNull bnho parambnho)
  {
    if (parambnho.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id.equals(bmtu.b(parambmtu)))
    {
      if (parambnho.jdField_a_of_type_Int != 0) {
        break label296;
      }
      if (!parambnho.jdField_a_of_type_Boolean) {
        break label155;
      }
      xvv.b(this.TAG, "notify ui we finish downloading");
      parambmtu.a.b = false;
      parambmtu.a.g = parambnho.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
      parambmtu.a.c = 0;
      parambmtu.a.d = 0;
      parambmtu.d = 3;
      parambmtu.b();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "download finished id=" + bmtu.b(parambmtu) + " name=" + bmtu.a(parambmtu));
      }
      if (bmtu.a(parambmtu) != null) {
        vli.a().unRegisterSubscriber(bmtu.a(parambmtu));
      }
    }
    label155:
    label296:
    do
    {
      do
      {
        return;
        xvv.a(this.TAG, "notify ui we new progress : " + parambnho.b + " / " + parambnho.jdField_a_of_type_Long);
        parambmtu.a.b = true;
        parambmtu.a.g = null;
        parambmtu.a.c = ((int)parambnho.jdField_a_of_type_Long);
        parambmtu.a.d = ((int)parambnho.b);
        parambmtu.d = 1;
      } while (!QLog.isColorLevel());
      QLog.d(this.TAG, 2, "downloading=" + parambmtu.a.d + " max=" + parambmtu.a.c);
      return;
      parambmtu.a.b = false;
      parambmtu.a.g = null;
      parambmtu.a.c = 0;
      parambmtu.a.d = 0;
      xvv.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + parambnho.jdField_a_of_type_Int);
      xwb.a("0X80076C9");
      xwb.b("0X80075DE");
      parambmtu.d = 2;
      parambmtu.a(parambnho.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "download error id=" + bmtu.b(parambmtu) + " name=" + bmtu.a(parambmtu));
      }
    } while (bmtu.a(parambmtu) == null);
    vli.a().unRegisterSubscriber(bmtu.a(parambmtu));
  }
  
  public Class acceptEventClass()
  {
    return bnho.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmtw
 * JD-Core Version:    0.7.0.1
 */