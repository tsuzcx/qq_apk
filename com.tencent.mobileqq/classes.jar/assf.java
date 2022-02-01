import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class assf
  implements DialogInterface.OnClickListener
{
  assf(assc paramassc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.jdField_a_of_type_AndroidContentContext.getString(2131718497);
    bhzu.a(null, this.a.jdField_a_of_type_AndroidContentContext, "mvip.g.a.bq_tz", 3, "1450000515", "CJCLUBT", paramDialogInterface, "", false, true);
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if (EmojiStickerManager.a().a != 0) {
        break label103;
      }
      paramInt = 1;
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.c(), "Stick", "ClickSVIPTip", String.valueOf(paramInt), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return;
      label103:
      if (EmojiStickerManager.a().a == 1) {
        paramInt = 2;
      } else if (EmojiStickerManager.a().a == 3000) {
        paramInt = 3;
      } else {
        paramInt = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assf
 * JD-Core Version:    0.7.0.1
 */