import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;

public class bjfg
  extends QQUIEventReceiver<bjfe, bkcf>
{
  public bjfg(@NonNull bjfe parambjfe)
  {
    super(parambjfe);
  }
  
  public void a(@NonNull bjfe parambjfe, @NonNull bkcf parambkcf)
  {
    if (parambkcf.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id.equals(bjfe.b(parambjfe)))
    {
      if (parambkcf.jdField_a_of_type_Int != 0) {
        break label296;
      }
      if (!parambkcf.jdField_a_of_type_Boolean) {
        break label155;
      }
      ved.b(this.TAG, "notify ui we finish downloading");
      parambjfe.a.b = false;
      parambjfe.a.g = parambkcf.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
      parambjfe.a.c = 0;
      parambjfe.a.d = 0;
      parambjfe.d = 3;
      parambjfe.b();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "download finished id=" + bjfe.b(parambjfe) + " name=" + bjfe.a(parambjfe));
      }
      if (bjfe.a(parambjfe) != null) {
        stb.a().unRegisterSubscriber(bjfe.a(parambjfe));
      }
    }
    label155:
    label296:
    do
    {
      do
      {
        return;
        ved.a(this.TAG, "notify ui we new progress : " + parambkcf.b + " / " + parambkcf.jdField_a_of_type_Long);
        parambjfe.a.b = true;
        parambjfe.a.g = null;
        parambjfe.a.c = ((int)parambkcf.jdField_a_of_type_Long);
        parambjfe.a.d = ((int)parambkcf.b);
        parambjfe.d = 1;
      } while (!QLog.isColorLevel());
      QLog.d(this.TAG, 2, "downloading=" + parambjfe.a.d + " max=" + parambjfe.a.c);
      return;
      parambjfe.a.b = false;
      parambjfe.a.g = null;
      parambjfe.a.c = 0;
      parambjfe.a.d = 0;
      ved.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + parambkcf.jdField_a_of_type_Int);
      vej.a("0X80076C9");
      vej.b("0X80075DE");
      parambjfe.d = 2;
      parambjfe.a(parambkcf.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "download error id=" + bjfe.b(parambjfe) + " name=" + bjfe.a(parambjfe));
      }
    } while (bjfe.a(parambjfe) == null);
    stb.a().unRegisterSubscriber(bjfe.a(parambjfe));
  }
  
  public Class acceptEventClass()
  {
    return bkcf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjfg
 * JD-Core Version:    0.7.0.1
 */