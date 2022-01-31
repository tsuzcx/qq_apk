import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.IPSiteModel.Goods;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class aptf
  implements View.OnClickListener
{
  aptf(apte paramapte, IPSiteModel.Goods paramGoods) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(apte.a(this.jdField_a_of_type_Apte), QQBrowserActivity.class);
    paramView.putExtra("hide_operation_bar", true);
    VasWebviewUtil.openQQBrowserWithoutAD(apte.a(this.jdField_a_of_type_Apte), this.jdField_a_of_type_ComTencentMobileqqDataIPSiteModel$Goods.url, -1L, paramView, false, -1);
    VasWebviewUtil.reportCommercialDrainage(apte.a(this.jdField_a_of_type_Apte), "IP", "aio_productclk", "", 0, 0, 0, apte.b(this.jdField_a_of_type_Apte), apte.c(this.jdField_a_of_type_Apte), "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aptf
 * JD-Core Version:    0.7.0.1
 */