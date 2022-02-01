import android.app.Activity;
import android.content.Intent;
import android.os.MessageQueue.IdleHandler;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.linker.VipFrwrdLinkView;

class bpfz
  implements MessageQueue.IdleHandler
{
  bpfz(bpfy parambpfy) {}
  
  public boolean queueIdle()
  {
    bpfy.a(this.a, true);
    if ((this.a.jdField_a_of_type_Bpfx == null) || (this.a.jdField_a_of_type_Bpfx.getActivity() == null) || (this.a.jdField_a_of_type_Bpfx.getActivity().getIntent() == null) || (this.a.jdField_a_of_type_Bpfx.getActivity().getIntent().getExtras() == null)) {
      return false;
    }
    Object localObject = this.a.jdField_a_of_type_Bpep.a;
    String str1 = ((EditVideoParams)localObject).a("vip_forward_uid");
    String str2 = ((EditVideoParams)localObject).a("vip_forward_vid");
    String str3 = ((EditVideoParams)localObject).a("vip_forward_feedid");
    String str4 = ((EditVideoParams)localObject).a("vip_forward_name");
    localObject = ((EditVideoParams)localObject).a("vip_forward_avatrname");
    bpfy.a(this.a, new wrb());
    bpfy.a(this.a).jdField_a_of_type_Int = 5;
    bpfy.a(this.a).jdField_a_of_type_Wrc = new wrc();
    bpfy.a(this.a).jdField_a_of_type_Wrc.a = str1;
    bpfy.a(this.a).jdField_a_of_type_Wrc.c = str2;
    bpfy.a(this.a).jdField_a_of_type_Wrc.b = str3;
    bpfy.a(this.a).jdField_a_of_type_Wrc.f = str4;
    bpfy.a(this.a).jdField_a_of_type_Wrc.g = ((String)localObject);
    this.a.d();
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerVipFrwrdLinkView.setLinkInfo(bpfy.a(this.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpfz
 * JD-Core Version:    0.7.0.1
 */