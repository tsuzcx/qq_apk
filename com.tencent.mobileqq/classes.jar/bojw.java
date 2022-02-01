import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import java.util.List;

public class bojw
  extends QQUIEventReceiver<bojs, boxg>
{
  public bojw(@NonNull bojs parambojs)
  {
    super(parambojs);
  }
  
  public void a(@NonNull bojs parambojs, @NonNull boxg paramboxg)
  {
    parambojs = parambojs.a;
    if (parambojs != null)
    {
      Object localObject = parambojs.a(paramboxg.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id);
      if (!(localObject instanceof bpbf))
      {
        ykq.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + paramboxg.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id);
        return;
      }
      localObject = (bpbf)localObject;
      if (paramboxg.jdField_a_of_type_Int == 0)
      {
        if (paramboxg.jdField_a_of_type_Boolean)
        {
          ykq.b(this.TAG, "notify ui we finish downloading");
          ((bpbf)localObject).jdField_b_of_type_Boolean = false;
          ((bpbf)localObject).g = paramboxg.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
          ((bpbf)localObject).c = 0;
          ((bpbf)localObject).d = 0;
          parambojs.a((bpaw)localObject);
          return;
        }
        ykq.b(this.TAG, "notify ui we new progress : " + paramboxg.jdField_b_of_type_Long + " / " + paramboxg.jdField_a_of_type_Long);
        ((bpbf)localObject).jdField_b_of_type_Boolean = true;
        ((bpbf)localObject).g = null;
        ((bpbf)localObject).c = ((int)paramboxg.jdField_a_of_type_Long);
        ((bpbf)localObject).d = ((int)paramboxg.jdField_b_of_type_Long);
        parambojs.a((bpaw)localObject);
        return;
      }
      if (paramboxg.jdField_b_of_type_Boolean)
      {
        bojs.a((bpbf)localObject, paramboxg.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem);
        ((bpbf)localObject).a.clear();
        parambojs.a((bpaw)localObject);
        return;
      }
      ((bpbf)localObject).jdField_b_of_type_Boolean = false;
      ((bpbf)localObject).g = null;
      ((bpbf)localObject).c = 0;
      ((bpbf)localObject).d = 0;
      parambojs.a((bpaw)localObject);
      ykq.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + paramboxg.jdField_a_of_type_Int);
      ykw.a("0X80076C9");
      ykw.b("0X80075DE");
      return;
    }
    ykq.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return boxg.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bojw
 * JD-Core Version:    0.7.0.1
 */