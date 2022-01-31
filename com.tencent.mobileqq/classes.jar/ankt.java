import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.IPSiteModel.Goods;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class ankt
  implements View.OnClickListener
{
  ankt(anks paramanks, IPSiteModel.Goods paramGoods) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(anks.a(this.jdField_a_of_type_Anks), QQBrowserActivity.class);
    paramView.putExtra("hide_operation_bar", true);
    VasWebviewUtil.openQQBrowserWithoutAD(anks.a(this.jdField_a_of_type_Anks), this.jdField_a_of_type_ComTencentMobileqqDataIPSiteModel$Goods.url, -1L, paramView, false, -1);
    VasWebviewUtil.reportCommercialDrainage(anks.a(this.jdField_a_of_type_Anks), "IP", "aio_productclk", "", 0, 0, 0, anks.b(this.jdField_a_of_type_Anks), anks.c(this.jdField_a_of_type_Anks), "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ankt
 * JD-Core Version:    0.7.0.1
 */