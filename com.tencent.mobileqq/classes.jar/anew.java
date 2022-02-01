import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class anew
  implements DialogInterface.OnClickListener
{
  anew(anet paramanet, ApolloGameData paramApolloGameData) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = String.format("https://m.gamecenter.qq.com/directout/detail/%s?_wv=2147484679&_wwv=4&ADTAG=limixiuteam&autodownload=1&pf=invite&appid=%s&notShowPub=1&asyncMode=3&appType=1&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.gameAppid, this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.gameAppid });
    Intent localIntent = new Intent(this.jdField_a_of_type_Anet.a, QQBrowserActivity.class);
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    VasWebviewUtil.openQQBrowserActivity(this.jdField_a_of_type_Anet.a, paramDialogInterface, -1L, localIntent, false, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anew
 * JD-Core Version:    0.7.0.1
 */