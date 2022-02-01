import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileWZRYView;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class baes
  implements View.OnClickListener
{
  public baes(VasProfileWZRYView paramVasProfileWZRYView, azrb paramazrb) {}
  
  public void onClick(View paramView)
  {
    String str = bhnp.a("gameHonourAddHonour");
    VasWebviewUtil.openQQBrowserWithoutAD(VasProfileWZRYView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileWZRYView), str, -1L, null, false, -1);
    VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_into", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(this.jdField_a_of_type_Azrb.a.lCurrentBgId), String.valueOf(this.jdField_a_of_type_Azrb.a.lCurrentStyleId));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baes
 * JD-Core Version:    0.7.0.1
 */