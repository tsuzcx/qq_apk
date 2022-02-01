import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileWZRYView;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class azra
  implements View.OnClickListener
{
  public azra(VasProfileWZRYView paramVasProfileWZRYView, azfe paramazfe) {}
  
  public void onClick(View paramView)
  {
    String str = bgyg.a("gameHonourAddHonour");
    VasWebviewUtil.openQQBrowserWithoutAD(VasProfileWZRYView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileWZRYView), str, -1L, null, false, -1);
    VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_into", "0", 1, 0, 0, nlw.a(), String.valueOf(this.jdField_a_of_type_Azfe.a.lCurrentBgId), String.valueOf(this.jdField_a_of_type_Azfe.a.lCurrentStyleId));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azra
 * JD-Core Version:    0.7.0.1
 */