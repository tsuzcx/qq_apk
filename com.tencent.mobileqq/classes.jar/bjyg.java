import android.app.Activity;
import android.content.Intent;
import android.os.MessageQueue.IdleHandler;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.linker.VipFrwrdLinkView;

class bjyg
  implements MessageQueue.IdleHandler
{
  bjyg(bjyf parambjyf) {}
  
  public boolean queueIdle()
  {
    bjyf.a(this.a, true);
    if ((this.a.jdField_a_of_type_Bjye == null) || (this.a.jdField_a_of_type_Bjye.getActivity() == null) || (this.a.jdField_a_of_type_Bjye.getActivity().getIntent() == null) || (this.a.jdField_a_of_type_Bjye.getActivity().getIntent().getExtras() == null)) {
      return false;
    }
    Object localObject = this.a.jdField_a_of_type_Bjww.a;
    String str1 = ((EditVideoParams)localObject).a("vip_forward_uid");
    String str2 = ((EditVideoParams)localObject).a("vip_forward_vid");
    String str3 = ((EditVideoParams)localObject).a("vip_forward_feedid");
    String str4 = ((EditVideoParams)localObject).a("vip_forward_name");
    localObject = ((EditVideoParams)localObject).a("vip_forward_avatrname");
    bjyf.a(this.a, new ter());
    bjyf.a(this.a).jdField_a_of_type_Int = 5;
    bjyf.a(this.a).jdField_a_of_type_Tes = new tes();
    bjyf.a(this.a).jdField_a_of_type_Tes.a = str1;
    bjyf.a(this.a).jdField_a_of_type_Tes.c = str2;
    bjyf.a(this.a).jdField_a_of_type_Tes.b = str3;
    bjyf.a(this.a).jdField_a_of_type_Tes.f = str4;
    bjyf.a(this.a).jdField_a_of_type_Tes.g = ((String)localObject);
    this.a.d();
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerVipFrwrdLinkView.setLinkInfo(bjyf.a(this.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjyg
 * JD-Core Version:    0.7.0.1
 */