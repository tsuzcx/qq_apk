import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IPSiteModel.Video;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class appc
  implements View.OnClickListener
{
  appc(apox paramapox, IPSiteModel.Video paramVideo, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_Apox.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramView.putExtra("hide_operation_bar", true);
    VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_Apox.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataIPSiteModel$Video.redirectUrl, -1L, paramView, false, -1);
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_Apox.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "IP", "aio_movieclk", "", 0, 0, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appc
 * JD-Core Version:    0.7.0.1
 */