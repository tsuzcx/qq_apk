import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;

class aqxc
  implements aqvx
{
  aqxc(aqxa paramaqxa) {}
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    int i = this.a.jdField_a_of_type_Aqwy.e;
    String str3 = this.a.jdField_a_of_type_Aqwy.b;
    this.a.b(i, str3);
    ListenTogetherManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(i, str3, paramBoolean);
    if ((i == 2) && (!TextUtils.isEmpty(str3))) {
      awqx.b(null, "dc00899", "c2c_AIO", "", "music_tab", "close_tab", 0, 0, str3, "", "", "");
    }
    while ((i != 1) || (TextUtils.isEmpty(str3))) {
      return;
    }
    String str2 = "2";
    TroopInfo localTroopInfo = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(str3);
    String str1 = str2;
    if (localTroopInfo != null)
    {
      if (!localTroopInfo.isTroopOwner(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) {
        break label180;
      }
      str1 = "0";
    }
    for (;;)
    {
      awqx.b(null, "dc00899", "Grp_AIO", "", "music_tab", "close_tab", 0, 0, str3, "", str1, "");
      return;
      label180:
      str1 = str2;
      if (localTroopInfo.isAdmin()) {
        str1 = "1";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aqxc
 * JD-Core Version:    0.7.0.1
 */