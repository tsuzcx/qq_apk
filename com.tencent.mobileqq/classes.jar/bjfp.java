import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import java.util.List;

public class bjfp
  extends QQUIEventReceiver<bjfl, bkcf>
{
  public bjfp(@NonNull bjfl parambjfl)
  {
    super(parambjfl);
  }
  
  public void a(@NonNull bjfl parambjfl, @NonNull bkcf parambkcf)
  {
    parambjfl = parambjfl.a;
    if (parambjfl != null)
    {
      Object localObject = parambjfl.a(parambkcf.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id);
      if (!(localObject instanceof bkgj))
      {
        ved.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + parambkcf.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id);
        return;
      }
      localObject = (bkgj)localObject;
      if (parambkcf.jdField_a_of_type_Int == 0)
      {
        if (parambkcf.jdField_a_of_type_Boolean)
        {
          ved.b(this.TAG, "notify ui we finish downloading");
          ((bkgj)localObject).jdField_b_of_type_Boolean = false;
          ((bkgj)localObject).g = parambkcf.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
          ((bkgj)localObject).c = 0;
          ((bkgj)localObject).d = 0;
          parambjfl.a((bkfz)localObject);
          return;
        }
        ved.b(this.TAG, "notify ui we new progress : " + parambkcf.jdField_b_of_type_Long + " / " + parambkcf.jdField_a_of_type_Long);
        ((bkgj)localObject).jdField_b_of_type_Boolean = true;
        ((bkgj)localObject).g = null;
        ((bkgj)localObject).c = ((int)parambkcf.jdField_a_of_type_Long);
        ((bkgj)localObject).d = ((int)parambkcf.jdField_b_of_type_Long);
        parambjfl.a((bkfz)localObject);
        return;
      }
      if (parambkcf.jdField_b_of_type_Boolean)
      {
        bjfl.a((bkgj)localObject, parambkcf.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem);
        ((bkgj)localObject).a.clear();
        parambjfl.a((bkfz)localObject);
        return;
      }
      ((bkgj)localObject).jdField_b_of_type_Boolean = false;
      ((bkgj)localObject).g = null;
      ((bkgj)localObject).c = 0;
      ((bkgj)localObject).d = 0;
      parambjfl.a((bkfz)localObject);
      ved.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + parambkcf.jdField_a_of_type_Int);
      vej.a("0X80076C9");
      vej.b("0X80075DE");
      return;
    }
    ved.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return bkcf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjfp
 * JD-Core Version:    0.7.0.1
 */