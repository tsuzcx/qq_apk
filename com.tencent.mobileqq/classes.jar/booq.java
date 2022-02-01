import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import java.util.List;

public class booq
  extends QQUIEventReceiver<boom, bpjh>
{
  public booq(@NonNull boom paramboom)
  {
    super(paramboom);
  }
  
  public void a(@NonNull boom paramboom, @NonNull bpjh parambpjh)
  {
    paramboom = paramboom.a;
    if (paramboom != null)
    {
      Object localObject = paramboom.a(parambpjh.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id);
      if (!(localObject instanceof bpnl))
      {
        yqp.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + parambpjh.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id);
        return;
      }
      localObject = (bpnl)localObject;
      if (parambpjh.jdField_a_of_type_Int == 0)
      {
        if (parambpjh.jdField_a_of_type_Boolean)
        {
          yqp.b(this.TAG, "notify ui we finish downloading");
          ((bpnl)localObject).jdField_b_of_type_Boolean = false;
          ((bpnl)localObject).g = parambpjh.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
          ((bpnl)localObject).c = 0;
          ((bpnl)localObject).d = 0;
          paramboom.a((bpnb)localObject);
          return;
        }
        yqp.b(this.TAG, "notify ui we new progress : " + parambpjh.jdField_b_of_type_Long + " / " + parambpjh.jdField_a_of_type_Long);
        ((bpnl)localObject).jdField_b_of_type_Boolean = true;
        ((bpnl)localObject).g = null;
        ((bpnl)localObject).c = ((int)parambpjh.jdField_a_of_type_Long);
        ((bpnl)localObject).d = ((int)parambpjh.jdField_b_of_type_Long);
        paramboom.a((bpnb)localObject);
        return;
      }
      if (parambpjh.jdField_b_of_type_Boolean)
      {
        boom.a((bpnl)localObject, parambpjh.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem);
        ((bpnl)localObject).a.clear();
        paramboom.a((bpnb)localObject);
        return;
      }
      ((bpnl)localObject).jdField_b_of_type_Boolean = false;
      ((bpnl)localObject).g = null;
      ((bpnl)localObject).c = 0;
      ((bpnl)localObject).d = 0;
      paramboom.a((bpnb)localObject);
      yqp.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + parambpjh.jdField_a_of_type_Int);
      yqv.a("0X80076C9");
      yqv.b("0X80075DE");
      return;
    }
    yqp.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return bpjh.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     booq
 * JD-Core Version:    0.7.0.1
 */