import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.IPSiteModel.Goods;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asqx
  implements View.OnClickListener
{
  asqx(asqw paramasqw, IPSiteModel.Goods paramGoods) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(asqw.a(this.jdField_a_of_type_Asqw), QQBrowserActivity.class);
    localIntent.putExtra("hide_operation_bar", true);
    VasWebviewUtil.openQQBrowserWithoutAD(asqw.a(this.jdField_a_of_type_Asqw), this.jdField_a_of_type_ComTencentMobileqqDataIPSiteModel$Goods.url, -1L, localIntent, false, -1);
    VasWebviewUtil.reportCommercialDrainage(asqw.a(this.jdField_a_of_type_Asqw), "IP", "aio_productclk", "", 0, 0, 0, asqw.b(this.jdField_a_of_type_Asqw), asqw.c(this.jdField_a_of_type_Asqw), "", "", "", "", "", 0, 0, 0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqx
 * JD-Core Version:    0.7.0.1
 */