import android.app.Activity;
import android.content.Intent;
import android.os.MessageQueue.IdleHandler;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.linker.VipFrwrdLinkView;

class bmot
  implements MessageQueue.IdleHandler
{
  bmot(bmos parambmos) {}
  
  public boolean queueIdle()
  {
    bmos.a(this.a, true);
    if ((this.a.jdField_a_of_type_Bmor == null) || (this.a.jdField_a_of_type_Bmor.getActivity() == null) || (this.a.jdField_a_of_type_Bmor.getActivity().getIntent() == null) || (this.a.jdField_a_of_type_Bmor.getActivity().getIntent().getExtras() == null)) {
      return false;
    }
    Object localObject = this.a.jdField_a_of_type_Bmnj.a;
    String str1 = ((EditVideoParams)localObject).a("vip_forward_uid");
    String str2 = ((EditVideoParams)localObject).a("vip_forward_vid");
    String str3 = ((EditVideoParams)localObject).a("vip_forward_feedid");
    String str4 = ((EditVideoParams)localObject).a("vip_forward_name");
    localObject = ((EditVideoParams)localObject).a("vip_forward_avatrname");
    bmos.a(this.a, new uxp());
    bmos.a(this.a).jdField_a_of_type_Int = 5;
    bmos.a(this.a).jdField_a_of_type_Uxq = new uxq();
    bmos.a(this.a).jdField_a_of_type_Uxq.a = str1;
    bmos.a(this.a).jdField_a_of_type_Uxq.c = str2;
    bmos.a(this.a).jdField_a_of_type_Uxq.b = str3;
    bmos.a(this.a).jdField_a_of_type_Uxq.f = str4;
    bmos.a(this.a).jdField_a_of_type_Uxq.g = ((String)localObject);
    this.a.d();
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerVipFrwrdLinkView.setLinkInfo(bmos.a(this.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmot
 * JD-Core Version:    0.7.0.1
 */