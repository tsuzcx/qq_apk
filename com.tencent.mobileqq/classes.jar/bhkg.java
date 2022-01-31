import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import java.util.List;

public class bhkg
  extends QQUIEventReceiver<bhkc, bikt>
{
  public bhkg(@NonNull bhkc parambhkc)
  {
    super(parambhkc);
  }
  
  public void a(@NonNull bhkc parambhkc, @NonNull bikt parambikt)
  {
    parambhkc = parambhkc.a;
    if (parambhkc != null)
    {
      Object localObject = parambhkc.a(parambikt.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id);
      if (!(localObject instanceof biox))
      {
        urk.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + parambikt.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id);
        return;
      }
      localObject = (biox)localObject;
      if (parambikt.jdField_a_of_type_Int == 0)
      {
        if (parambikt.jdField_a_of_type_Boolean)
        {
          urk.b(this.TAG, "notify ui we finish downloading");
          ((biox)localObject).jdField_b_of_type_Boolean = false;
          ((biox)localObject).g = parambikt.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
          ((biox)localObject).c = 0;
          ((biox)localObject).d = 0;
          parambhkc.a((bion)localObject);
          return;
        }
        urk.b(this.TAG, "notify ui we new progress : " + parambikt.jdField_b_of_type_Long + " / " + parambikt.jdField_a_of_type_Long);
        ((biox)localObject).jdField_b_of_type_Boolean = true;
        ((biox)localObject).g = null;
        ((biox)localObject).c = ((int)parambikt.jdField_a_of_type_Long);
        ((biox)localObject).d = ((int)parambikt.jdField_b_of_type_Long);
        parambhkc.a((bion)localObject);
        return;
      }
      if (parambikt.jdField_b_of_type_Boolean)
      {
        bhkc.a((biox)localObject, parambikt.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem);
        ((biox)localObject).a.clear();
        parambhkc.a((bion)localObject);
        return;
      }
      ((biox)localObject).jdField_b_of_type_Boolean = false;
      ((biox)localObject).g = null;
      ((biox)localObject).c = 0;
      ((biox)localObject).d = 0;
      parambhkc.a((bion)localObject);
      urk.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + parambikt.jdField_a_of_type_Int);
      urq.a("0X80076C9");
      urq.b("0X80075DE");
      return;
    }
    urk.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return bikt.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhkg
 * JD-Core Version:    0.7.0.1
 */