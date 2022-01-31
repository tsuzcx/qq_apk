import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import java.util.List;

public class bjey
  extends QQUIEventReceiver<bjeu, bkbo>
{
  public bjey(@NonNull bjeu parambjeu)
  {
    super(parambjeu);
  }
  
  public void a(@NonNull bjeu parambjeu, @NonNull bkbo parambkbo)
  {
    parambjeu = parambjeu.a;
    if (parambjeu != null)
    {
      Object localObject = parambjeu.a(parambkbo.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id);
      if (!(localObject instanceof bkfs))
      {
        veg.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + parambkbo.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id);
        return;
      }
      localObject = (bkfs)localObject;
      if (parambkbo.jdField_a_of_type_Int == 0)
      {
        if (parambkbo.jdField_a_of_type_Boolean)
        {
          veg.b(this.TAG, "notify ui we finish downloading");
          ((bkfs)localObject).jdField_b_of_type_Boolean = false;
          ((bkfs)localObject).g = parambkbo.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
          ((bkfs)localObject).c = 0;
          ((bkfs)localObject).d = 0;
          parambjeu.a((bkfi)localObject);
          return;
        }
        veg.b(this.TAG, "notify ui we new progress : " + parambkbo.jdField_b_of_type_Long + " / " + parambkbo.jdField_a_of_type_Long);
        ((bkfs)localObject).jdField_b_of_type_Boolean = true;
        ((bkfs)localObject).g = null;
        ((bkfs)localObject).c = ((int)parambkbo.jdField_a_of_type_Long);
        ((bkfs)localObject).d = ((int)parambkbo.jdField_b_of_type_Long);
        parambjeu.a((bkfi)localObject);
        return;
      }
      if (parambkbo.jdField_b_of_type_Boolean)
      {
        bjeu.a((bkfs)localObject, parambkbo.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem);
        ((bkfs)localObject).a.clear();
        parambjeu.a((bkfi)localObject);
        return;
      }
      ((bkfs)localObject).jdField_b_of_type_Boolean = false;
      ((bkfs)localObject).g = null;
      ((bkfs)localObject).c = 0;
      ((bkfs)localObject).d = 0;
      parambjeu.a((bkfi)localObject);
      veg.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + parambkbo.jdField_a_of_type_Int);
      vem.a("0X80076C9");
      vem.b("0X80075DE");
      return;
    }
    veg.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return bkbo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjey
 * JD-Core Version:    0.7.0.1
 */