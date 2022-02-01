import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import java.util.List;

public class bmue
  extends QQUIEventReceiver<bmua, bnho>
{
  public bmue(@NonNull bmua parambmua)
  {
    super(parambmua);
  }
  
  public void a(@NonNull bmua parambmua, @NonNull bnho parambnho)
  {
    parambmua = parambmua.a;
    if (parambmua != null)
    {
      Object localObject = parambmua.a(parambnho.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id);
      if (!(localObject instanceof bnln))
      {
        xvv.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + parambnho.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id);
        return;
      }
      localObject = (bnln)localObject;
      if (parambnho.jdField_a_of_type_Int == 0)
      {
        if (parambnho.jdField_a_of_type_Boolean)
        {
          xvv.b(this.TAG, "notify ui we finish downloading");
          ((bnln)localObject).jdField_b_of_type_Boolean = false;
          ((bnln)localObject).g = parambnho.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
          ((bnln)localObject).c = 0;
          ((bnln)localObject).d = 0;
          parambmua.a((bnle)localObject);
          return;
        }
        xvv.b(this.TAG, "notify ui we new progress : " + parambnho.jdField_b_of_type_Long + " / " + parambnho.jdField_a_of_type_Long);
        ((bnln)localObject).jdField_b_of_type_Boolean = true;
        ((bnln)localObject).g = null;
        ((bnln)localObject).c = ((int)parambnho.jdField_a_of_type_Long);
        ((bnln)localObject).d = ((int)parambnho.jdField_b_of_type_Long);
        parambmua.a((bnle)localObject);
        return;
      }
      if (parambnho.jdField_b_of_type_Boolean)
      {
        bmua.a((bnln)localObject, parambnho.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem);
        ((bnln)localObject).a.clear();
        parambmua.a((bnle)localObject);
        return;
      }
      ((bnln)localObject).jdField_b_of_type_Boolean = false;
      ((bnln)localObject).g = null;
      ((bnln)localObject).c = 0;
      ((bnln)localObject).d = 0;
      parambmua.a((bnle)localObject);
      xvv.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + parambnho.jdField_a_of_type_Int);
      xwb.a("0X80076C9");
      xwb.b("0X80075DE");
      return;
    }
    xvv.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return bnho.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmue
 * JD-Core Version:    0.7.0.1
 */