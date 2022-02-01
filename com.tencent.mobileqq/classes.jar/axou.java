import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.nearby.NearbyJsInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.QQCustomDialog;
import cooperation.troop.NearbyVideoChatProxyActivity;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;

class axou
  implements aaea
{
  axou(axot paramaxot, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("isOtherTypeChatting", false))
    {
      paramBundle = bhdj.a(this.jdField_a_of_type_Axot.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.mRuntime.a(), 230);
      paramBundle.setMessage(this.jdField_a_of_type_Axot.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.mRuntime.a().getString(2131695634));
      paramBundle.setNegativeButton(anvx.a(2131706667), new axov(this));
      paramBundle.show();
      return;
    }
    aady.a();
    paramBundle = new oidb_0x8dd.SelfInfo();
    paramBundle.uint32_gender.set(this.jdField_a_of_type_Axot.jdField_a_of_type_Int);
    paramBundle.uint32_charm_level.set(this.jdField_a_of_type_Axot.b);
    paramBundle.uint32_age.set(this.jdField_a_of_type_Axot.c);
    NearbyVideoChatProxyActivity.a(this.jdField_a_of_type_Axot.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.mRuntime.a(), this.jdField_a_of_type_Axot.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.mRuntime.a(), null, this.jdField_a_of_type_JavaLangString, paramBundle, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axou
 * JD-Core Version:    0.7.0.1
 */