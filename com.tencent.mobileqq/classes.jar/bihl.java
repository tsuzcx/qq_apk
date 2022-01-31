import android.app.Activity;
import android.content.Intent;
import android.os.MessageQueue.IdleHandler;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.linker.VipFrwrdLinkView;

class bihl
  implements MessageQueue.IdleHandler
{
  bihl(bihk parambihk) {}
  
  public boolean queueIdle()
  {
    bihk.a(this.a, true);
    if ((this.a.jdField_a_of_type_Bihj == null) || (this.a.jdField_a_of_type_Bihj.getActivity() == null) || (this.a.jdField_a_of_type_Bihj.getActivity().getIntent() == null) || (this.a.jdField_a_of_type_Bihj.getActivity().getIntent().getExtras() == null)) {
      return false;
    }
    Object localObject = this.a.jdField_a_of_type_Bigb.a;
    String str1 = ((EditVideoParams)localObject).a("vip_forward_uid");
    String str2 = ((EditVideoParams)localObject).a("vip_forward_vid");
    String str3 = ((EditVideoParams)localObject).a("vip_forward_feedid");
    String str4 = ((EditVideoParams)localObject).a("vip_forward_name");
    localObject = ((EditVideoParams)localObject).a("vip_forward_avatrname");
    bihk.a(this.a, new srv());
    bihk.a(this.a).jdField_a_of_type_Int = 5;
    bihk.a(this.a).jdField_a_of_type_Srw = new srw();
    bihk.a(this.a).jdField_a_of_type_Srw.a = str1;
    bihk.a(this.a).jdField_a_of_type_Srw.c = str2;
    bihk.a(this.a).jdField_a_of_type_Srw.b = str3;
    bihk.a(this.a).jdField_a_of_type_Srw.f = str4;
    bihk.a(this.a).jdField_a_of_type_Srw.g = ((String)localObject);
    this.a.d();
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerVipFrwrdLinkView.setLinkInfo(bihk.a(this.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bihl
 * JD-Core Version:    0.7.0.1
 */