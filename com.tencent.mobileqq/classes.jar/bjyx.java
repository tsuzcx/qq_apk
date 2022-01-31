import android.app.Activity;
import android.content.Intent;
import android.os.MessageQueue.IdleHandler;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.linker.VipFrwrdLinkView;

class bjyx
  implements MessageQueue.IdleHandler
{
  bjyx(bjyw parambjyw) {}
  
  public boolean queueIdle()
  {
    bjyw.a(this.a, true);
    if ((this.a.jdField_a_of_type_Bjyv == null) || (this.a.jdField_a_of_type_Bjyv.getActivity() == null) || (this.a.jdField_a_of_type_Bjyv.getActivity().getIntent() == null) || (this.a.jdField_a_of_type_Bjyv.getActivity().getIntent().getExtras() == null)) {
      return false;
    }
    Object localObject = this.a.jdField_a_of_type_Bjxn.a;
    String str1 = ((EditVideoParams)localObject).a("vip_forward_uid");
    String str2 = ((EditVideoParams)localObject).a("vip_forward_vid");
    String str3 = ((EditVideoParams)localObject).a("vip_forward_feedid");
    String str4 = ((EditVideoParams)localObject).a("vip_forward_name");
    localObject = ((EditVideoParams)localObject).a("vip_forward_avatrname");
    bjyw.a(this.a, new teo());
    bjyw.a(this.a).jdField_a_of_type_Int = 5;
    bjyw.a(this.a).jdField_a_of_type_Tep = new tep();
    bjyw.a(this.a).jdField_a_of_type_Tep.a = str1;
    bjyw.a(this.a).jdField_a_of_type_Tep.c = str2;
    bjyw.a(this.a).jdField_a_of_type_Tep.b = str3;
    bjyw.a(this.a).jdField_a_of_type_Tep.f = str4;
    bjyw.a(this.a).jdField_a_of_type_Tep.g = ((String)localObject);
    this.a.d();
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerVipFrwrdLinkView.setLinkInfo(bjyw.a(this.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjyx
 * JD-Core Version:    0.7.0.1
 */