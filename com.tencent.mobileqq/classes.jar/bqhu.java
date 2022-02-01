import android.app.Activity;
import android.content.Intent;
import android.os.MessageQueue.IdleHandler;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.linker.VipFrwrdLinkView;

class bqhu
  implements MessageQueue.IdleHandler
{
  bqhu(bqht parambqht) {}
  
  public boolean queueIdle()
  {
    bqht.a(this.a, true);
    if ((this.a.jdField_a_of_type_Bqhs == null) || (this.a.jdField_a_of_type_Bqhs.getActivity() == null) || (this.a.jdField_a_of_type_Bqhs.getActivity().getIntent() == null) || (this.a.jdField_a_of_type_Bqhs.getActivity().getIntent().getExtras() == null)) {
      return false;
    }
    Object localObject = this.a.jdField_a_of_type_Bqgk.a;
    String str1 = ((EditVideoParams)localObject).a("vip_forward_uid");
    String str2 = ((EditVideoParams)localObject).a("vip_forward_vid");
    String str3 = ((EditVideoParams)localObject).a("vip_forward_feedid");
    String str4 = ((EditVideoParams)localObject).a("vip_forward_name");
    localObject = ((EditVideoParams)localObject).a("vip_forward_avatrname");
    bqht.a(this.a, new wuw());
    bqht.a(this.a).jdField_a_of_type_Int = 5;
    bqht.a(this.a).jdField_a_of_type_Wux = new wux();
    bqht.a(this.a).jdField_a_of_type_Wux.a = str1;
    bqht.a(this.a).jdField_a_of_type_Wux.c = str2;
    bqht.a(this.a).jdField_a_of_type_Wux.b = str3;
    bqht.a(this.a).jdField_a_of_type_Wux.f = str4;
    bqht.a(this.a).jdField_a_of_type_Wux.g = ((String)localObject);
    this.a.d();
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerVipFrwrdLinkView.setLinkInfo(bqht.a(this.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqhu
 * JD-Core Version:    0.7.0.1
 */