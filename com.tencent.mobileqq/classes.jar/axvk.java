import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.nearby.NearbyJsInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.troop.NearbyVideoChatProxyActivity;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;

class axvk
  implements aasd
{
  axvk(axvj paramaxvj, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("isOtherTypeChatting", false))
    {
      paramBundle = bhlq.a(this.jdField_a_of_type_Axvj.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.mRuntime.a(), 230);
      paramBundle.setMessage(this.jdField_a_of_type_Axvj.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.mRuntime.a().getString(2131695278));
      paramBundle.setNegativeButton(anzj.a(2131706085), new axvl(this));
      paramBundle.show();
      return;
    }
    aasb.a();
    paramBundle = new oidb_0x8dd.SelfInfo();
    paramBundle.uint32_gender.set(this.jdField_a_of_type_Axvj.jdField_a_of_type_Int);
    paramBundle.uint32_charm_level.set(this.jdField_a_of_type_Axvj.b);
    paramBundle.uint32_age.set(this.jdField_a_of_type_Axvj.c);
    NearbyVideoChatProxyActivity.a(this.jdField_a_of_type_Axvj.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.mRuntime.a(), this.jdField_a_of_type_Axvj.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.mRuntime.a(), null, this.jdField_a_of_type_JavaLangString, paramBundle, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvk
 * JD-Core Version:    0.7.0.1
 */