import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class anlu
  implements View.OnClickListener
{
  anlu(anlt paramanlt, aniz paramaniz) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    label41:
    String str2;
    if (this.jdField_a_of_type_Aniz.jdField_a_of_type_Boolean)
    {
      localIntent.putExtra("emoji_to_dressup", true);
      if (this.jdField_a_of_type_Anlt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        break label212;
      }
      paramView = "";
      str2 = this.jdField_a_of_type_Anlt.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId;
      if (!this.jdField_a_of_type_Aniz.jdField_a_of_type_Boolean) {
        break label226;
      }
    }
    label212:
    label226:
    for (String str1 = "1";; str1 = "2")
    {
      VasWebviewUtil.reportCommercialDrainage(paramView, "ep_mall", "0X8007192", null, 1, 0, 0, null, str2, str1);
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_Anlt.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Anlt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, String.valueOf(this.jdField_a_of_type_Anlt.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId), false, localIntent, true);
      awqx.b(this.jdField_a_of_type_Anlt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8007192", 0, 0, "", this.jdField_a_of_type_Anlt.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, "2", "");
      return;
      if ((this.jdField_a_of_type_Anlt.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.extraFlags & 0x1) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        localIntent.putExtra("emoji_is_original", bool);
        localIntent.putExtra("emoji_author_id", this.jdField_a_of_type_Aniz.jdField_a_of_type_Int);
        break;
      }
      paramView = this.jdField_a_of_type_Anlt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      break label41;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anlu
 * JD-Core Version:    0.7.0.1
 */