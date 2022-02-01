import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import java.util.List;

public class bpql
  extends QQUIEventReceiver<bpqh, bqlc>
{
  public bpql(@NonNull bpqh parambpqh)
  {
    super(parambpqh);
  }
  
  public void a(@NonNull bpqh parambpqh, @NonNull bqlc parambqlc)
  {
    parambpqh = parambpqh.a;
    if (parambpqh != null)
    {
      Object localObject = parambpqh.a(parambqlc.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id);
      if (!(localObject instanceof bqpg))
      {
        yuk.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + parambqlc.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id);
        return;
      }
      localObject = (bqpg)localObject;
      if (parambqlc.jdField_a_of_type_Int == 0)
      {
        if (parambqlc.jdField_a_of_type_Boolean)
        {
          yuk.b(this.TAG, "notify ui we finish downloading");
          ((bqpg)localObject).jdField_b_of_type_Boolean = false;
          ((bqpg)localObject).g = parambqlc.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
          ((bqpg)localObject).c = 0;
          ((bqpg)localObject).d = 0;
          parambpqh.a((bqow)localObject);
          return;
        }
        yuk.b(this.TAG, "notify ui we new progress : " + parambqlc.jdField_b_of_type_Long + " / " + parambqlc.jdField_a_of_type_Long);
        ((bqpg)localObject).jdField_b_of_type_Boolean = true;
        ((bqpg)localObject).g = null;
        ((bqpg)localObject).c = ((int)parambqlc.jdField_a_of_type_Long);
        ((bqpg)localObject).d = ((int)parambqlc.jdField_b_of_type_Long);
        parambpqh.a((bqow)localObject);
        return;
      }
      if (parambqlc.jdField_b_of_type_Boolean)
      {
        bpqh.a((bqpg)localObject, parambqlc.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem);
        ((bqpg)localObject).a.clear();
        parambpqh.a((bqow)localObject);
        return;
      }
      ((bqpg)localObject).jdField_b_of_type_Boolean = false;
      ((bqpg)localObject).g = null;
      ((bqpg)localObject).c = 0;
      ((bqpg)localObject).d = 0;
      parambpqh.a((bqow)localObject);
      yuk.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + parambqlc.jdField_a_of_type_Int);
      yuq.a("0X80076C9");
      yuq.b("0X80075DE");
      return;
    }
    yuk.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return bqlc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpql
 * JD-Core Version:    0.7.0.1
 */