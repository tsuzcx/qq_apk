import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.IPSiteModel.Goods;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class aobj
  implements View.OnClickListener
{
  aobj(aobh paramaobh, IPSiteModel.Goods paramGoods) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(aobh.a(this.jdField_a_of_type_Aobh), QQBrowserActivity.class);
    paramView.putExtra("hide_operation_bar", true);
    VasWebviewUtil.openQQBrowserWithoutAD(aobh.a(this.jdField_a_of_type_Aobh), this.jdField_a_of_type_ComTencentMobileqqDataIPSiteModel$Goods.moreUrl, -1L, paramView, false, -1);
    VasWebviewUtil.reportCommercialDrainage(aobh.a(this.jdField_a_of_type_Aobh), "IP", "aio_productmore", "", 0, 0, 0, aobh.b(this.jdField_a_of_type_Aobh), aobh.c(this.jdField_a_of_type_Aobh), "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aobj
 * JD-Core Version:    0.7.0.1
 */