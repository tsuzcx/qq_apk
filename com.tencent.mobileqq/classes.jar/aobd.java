import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.IPSiteModel.Goods;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class aobd
  implements View.OnClickListener
{
  aobd(aobc paramaobc, IPSiteModel.Goods paramGoods) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(aobc.a(this.jdField_a_of_type_Aobc), QQBrowserActivity.class);
    paramView.putExtra("hide_operation_bar", true);
    VasWebviewUtil.openQQBrowserWithoutAD(aobc.a(this.jdField_a_of_type_Aobc), this.jdField_a_of_type_ComTencentMobileqqDataIPSiteModel$Goods.url, -1L, paramView, false, -1);
    VasWebviewUtil.reportCommercialDrainage(aobc.a(this.jdField_a_of_type_Aobc), "IP", "aio_productclk", "", 0, 0, 0, aobc.b(this.jdField_a_of_type_Aobc), aobc.c(this.jdField_a_of_type_Aobc), "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aobd
 * JD-Core Version:    0.7.0.1
 */