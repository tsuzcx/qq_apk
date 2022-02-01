import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class arwi
  implements View.OnClickListener
{
  arwi(arwh paramarwh, arza paramarza) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent();
    label84:
    String str1;
    label110:
    int i;
    if (this.jdField_a_of_type_Arza.jdField_a_of_type_Boolean)
    {
      ((Intent)localObject).putExtra("emoji_to_dressup", true);
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_Arwh.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Arwh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, String.valueOf(this.jdField_a_of_type_Arwh.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId), false, (Intent)localObject, false);
      if (this.jdField_a_of_type_Arwh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        break label257;
      }
      localObject = "";
      String str2 = this.jdField_a_of_type_Arwh.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId;
      if (!this.jdField_a_of_type_Arza.jdField_a_of_type_Boolean) {
        break label272;
      }
      str1 = "1";
      VasWebviewUtil.reportCommercialDrainage((String)localObject, "ep_mall", "0X8007192", null, 1, 0, 0, null, str2, str1);
      if ((this.jdField_a_of_type_Arwh.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.extraFlags & 0x1) <= 0) {
        break label279;
      }
      i = 3;
    }
    for (;;)
    {
      bcst.b(this.jdField_a_of_type_Arwh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8007192", 0, 0, "", this.jdField_a_of_type_Arwh.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, i + "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Arwh.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.extraFlags & 0x1) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((Intent)localObject).putExtra("emoji_is_original", bool);
        ((Intent)localObject).putExtra("emoji_author_id", this.jdField_a_of_type_Arza.jdField_a_of_type_Int);
        break;
      }
      label257:
      localObject = this.jdField_a_of_type_Arwh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      break label84;
      label272:
      str1 = "2";
      break label110;
      label279:
      if (this.jdField_a_of_type_Arwh.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.subType == 4) {
        i = 4;
      } else {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwi
 * JD-Core Version:    0.7.0.1
 */