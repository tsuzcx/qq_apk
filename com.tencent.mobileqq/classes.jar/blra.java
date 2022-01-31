import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import java.util.List;

public class blra
  extends QQUIEventReceiver<blqw, bmnp>
{
  public blra(@NonNull blqw paramblqw)
  {
    super(paramblqw);
  }
  
  public void a(@NonNull blqw paramblqw, @NonNull bmnp parambmnp)
  {
    paramblqw = paramblqw.a;
    if (paramblqw != null)
    {
      Object localObject = paramblqw.a(parambmnp.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id);
      if (!(localObject instanceof bmrt))
      {
        wsv.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + parambmnp.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id);
        return;
      }
      localObject = (bmrt)localObject;
      if (parambmnp.jdField_a_of_type_Int == 0)
      {
        if (parambmnp.jdField_a_of_type_Boolean)
        {
          wsv.b(this.TAG, "notify ui we finish downloading");
          ((bmrt)localObject).jdField_b_of_type_Boolean = false;
          ((bmrt)localObject).g = parambmnp.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
          ((bmrt)localObject).c = 0;
          ((bmrt)localObject).d = 0;
          paramblqw.a((bmrj)localObject);
          return;
        }
        wsv.b(this.TAG, "notify ui we new progress : " + parambmnp.jdField_b_of_type_Long + " / " + parambmnp.jdField_a_of_type_Long);
        ((bmrt)localObject).jdField_b_of_type_Boolean = true;
        ((bmrt)localObject).g = null;
        ((bmrt)localObject).c = ((int)parambmnp.jdField_a_of_type_Long);
        ((bmrt)localObject).d = ((int)parambmnp.jdField_b_of_type_Long);
        paramblqw.a((bmrj)localObject);
        return;
      }
      if (parambmnp.jdField_b_of_type_Boolean)
      {
        blqw.a((bmrt)localObject, parambmnp.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem);
        ((bmrt)localObject).a.clear();
        paramblqw.a((bmrj)localObject);
        return;
      }
      ((bmrt)localObject).jdField_b_of_type_Boolean = false;
      ((bmrt)localObject).g = null;
      ((bmrt)localObject).c = 0;
      ((bmrt)localObject).d = 0;
      paramblqw.a((bmrj)localObject);
      wsv.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + parambmnp.jdField_a_of_type_Int);
      wtb.a("0X80076C9");
      wtb.b("0X80075DE");
      return;
    }
    wsv.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return bmnp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blra
 * JD-Core Version:    0.7.0.1
 */