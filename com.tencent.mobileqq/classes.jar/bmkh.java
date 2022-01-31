import android.app.Activity;
import android.content.Intent;
import android.os.MessageQueue.IdleHandler;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.linker.VipFrwrdLinkView;

class bmkh
  implements MessageQueue.IdleHandler
{
  bmkh(bmkg parambmkg) {}
  
  public boolean queueIdle()
  {
    bmkg.a(this.a, true);
    if ((this.a.jdField_a_of_type_Bmkf == null) || (this.a.jdField_a_of_type_Bmkf.getActivity() == null) || (this.a.jdField_a_of_type_Bmkf.getActivity().getIntent() == null) || (this.a.jdField_a_of_type_Bmkf.getActivity().getIntent().getExtras() == null)) {
      return false;
    }
    Object localObject = this.a.jdField_a_of_type_Bmix.a;
    String str1 = ((EditVideoParams)localObject).a("vip_forward_uid");
    String str2 = ((EditVideoParams)localObject).a("vip_forward_vid");
    String str3 = ((EditVideoParams)localObject).a("vip_forward_feedid");
    String str4 = ((EditVideoParams)localObject).a("vip_forward_name");
    localObject = ((EditVideoParams)localObject).a("vip_forward_avatrname");
    bmkg.a(this.a, new utg());
    bmkg.a(this.a).jdField_a_of_type_Int = 5;
    bmkg.a(this.a).jdField_a_of_type_Uth = new uth();
    bmkg.a(this.a).jdField_a_of_type_Uth.a = str1;
    bmkg.a(this.a).jdField_a_of_type_Uth.c = str2;
    bmkg.a(this.a).jdField_a_of_type_Uth.b = str3;
    bmkg.a(this.a).jdField_a_of_type_Uth.f = str4;
    bmkg.a(this.a).jdField_a_of_type_Uth.g = ((String)localObject);
    this.a.d();
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerVipFrwrdLinkView.setLinkInfo(bmkg.a(this.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkh
 * JD-Core Version:    0.7.0.1
 */