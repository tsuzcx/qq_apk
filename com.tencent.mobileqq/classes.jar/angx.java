import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class angx
  implements View.OnClickListener
{
  angx(angw paramangw, aniz paramaniz) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    label80:
    String str1;
    label106:
    int i;
    if (this.jdField_a_of_type_Aniz.jdField_a_of_type_Boolean)
    {
      paramView.putExtra("emoji_to_dressup", true);
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_Angw.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Angw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, String.valueOf(this.jdField_a_of_type_Angw.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId), false, paramView, false);
      if (this.jdField_a_of_type_Angw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        break label243;
      }
      paramView = "";
      String str2 = this.jdField_a_of_type_Angw.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId;
      if (!this.jdField_a_of_type_Aniz.jdField_a_of_type_Boolean) {
        break label257;
      }
      str1 = "1";
      VasWebviewUtil.reportCommercialDrainage(paramView, "ep_mall", "0X8007192", null, 1, 0, 0, null, str2, str1);
      if ((this.jdField_a_of_type_Angw.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.extraFlags & 0x1) <= 0) {
        break label264;
      }
      i = 3;
    }
    for (;;)
    {
      awqx.b(this.jdField_a_of_type_Angw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8007192", 0, 0, "", this.jdField_a_of_type_Angw.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, i + "", "");
      return;
      if ((this.jdField_a_of_type_Angw.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.extraFlags & 0x1) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.putExtra("emoji_is_original", bool);
        paramView.putExtra("emoji_author_id", this.jdField_a_of_type_Aniz.jdField_a_of_type_Int);
        break;
      }
      label243:
      paramView = this.jdField_a_of_type_Angw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      break label80;
      label257:
      str1 = "2";
      break label106;
      label264:
      if (this.jdField_a_of_type_Angw.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.subType == 4) {
        i = 4;
      } else {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     angx
 * JD-Core Version:    0.7.0.1
 */