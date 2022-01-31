import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import java.util.List;

public class blvm
  extends QQUIEventReceiver<blvi, bmsb>
{
  public blvm(@NonNull blvi paramblvi)
  {
    super(paramblvi);
  }
  
  public void a(@NonNull blvi paramblvi, @NonNull bmsb parambmsb)
  {
    paramblvi = paramblvi.a;
    if (paramblvi != null)
    {
      Object localObject = paramblvi.a(parambmsb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id);
      if (!(localObject instanceof bmwf))
      {
        wxe.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + parambmsb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id);
        return;
      }
      localObject = (bmwf)localObject;
      if (parambmsb.jdField_a_of_type_Int == 0)
      {
        if (parambmsb.jdField_a_of_type_Boolean)
        {
          wxe.b(this.TAG, "notify ui we finish downloading");
          ((bmwf)localObject).jdField_b_of_type_Boolean = false;
          ((bmwf)localObject).g = parambmsb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
          ((bmwf)localObject).c = 0;
          ((bmwf)localObject).d = 0;
          paramblvi.a((bmvv)localObject);
          return;
        }
        wxe.b(this.TAG, "notify ui we new progress : " + parambmsb.jdField_b_of_type_Long + " / " + parambmsb.jdField_a_of_type_Long);
        ((bmwf)localObject).jdField_b_of_type_Boolean = true;
        ((bmwf)localObject).g = null;
        ((bmwf)localObject).c = ((int)parambmsb.jdField_a_of_type_Long);
        ((bmwf)localObject).d = ((int)parambmsb.jdField_b_of_type_Long);
        paramblvi.a((bmvv)localObject);
        return;
      }
      if (parambmsb.jdField_b_of_type_Boolean)
      {
        blvi.a((bmwf)localObject, parambmsb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem);
        ((bmwf)localObject).a.clear();
        paramblvi.a((bmvv)localObject);
        return;
      }
      ((bmwf)localObject).jdField_b_of_type_Boolean = false;
      ((bmwf)localObject).g = null;
      ((bmwf)localObject).c = 0;
      ((bmwf)localObject).d = 0;
      paramblvi.a((bmvv)localObject);
      wxe.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + parambmsb.jdField_a_of_type_Int);
      wxk.a("0X80076C9");
      wxk.b("0X80075DE");
      return;
    }
    wxe.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return bmsb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvm
 * JD-Core Version:    0.7.0.1
 */