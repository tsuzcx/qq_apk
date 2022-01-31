import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.IPSiteModel.Goods;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class apxp
  implements View.OnClickListener
{
  apxp(apxn paramapxn, IPSiteModel.Goods paramGoods) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(apxn.a(this.jdField_a_of_type_Apxn), QQBrowserActivity.class);
    paramView.putExtra("hide_operation_bar", true);
    VasWebviewUtil.openQQBrowserWithoutAD(apxn.a(this.jdField_a_of_type_Apxn), this.jdField_a_of_type_ComTencentMobileqqDataIPSiteModel$Goods.moreUrl, -1L, paramView, false, -1);
    VasWebviewUtil.reportCommercialDrainage(apxn.a(this.jdField_a_of_type_Apxn), "IP", "aio_productmore", "", 0, 0, 0, apxn.b(this.jdField_a_of_type_Apxn), apxn.c(this.jdField_a_of_type_Apxn), "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxp
 * JD-Core Version:    0.7.0.1
 */