import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.IPSiteModel.Goods;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asbk
  implements View.OnClickListener
{
  asbk(asbi paramasbi, IPSiteModel.Goods paramGoods) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(asbi.a(this.jdField_a_of_type_Asbi), QQBrowserActivity.class);
    localIntent.putExtra("hide_operation_bar", true);
    VasWebviewUtil.openQQBrowserWithoutAD(asbi.a(this.jdField_a_of_type_Asbi), this.jdField_a_of_type_ComTencentMobileqqDataIPSiteModel$Goods.moreUrl, -1L, localIntent, false, -1);
    VasWebviewUtil.reportCommercialDrainage(asbi.a(this.jdField_a_of_type_Asbi), "IP", "aio_productmore", "", 0, 0, 0, asbi.b(this.jdField_a_of_type_Asbi), asbi.c(this.jdField_a_of_type_Asbi), "", "", "", "", "", 0, 0, 0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbk
 * JD-Core Version:    0.7.0.1
 */