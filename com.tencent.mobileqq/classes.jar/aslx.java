import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aslx
  implements View.OnClickListener
{
  aslx(aslv paramaslv, VipIPSiteInfo paramVipIPSiteInfo, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_Aslv.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("hide_operation_bar", true);
    VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_Aslv.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataVipIPSiteInfo.ipUrl, -1L, localIntent, false, -1);
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_Aslv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "IP", "aio_enterclk", "", 0, 0, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "", "", "", "", 0, 0, 0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslx
 * JD-Core Version:    0.7.0.1
 */