import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.view.VipProfileWZRYView;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class awsh
  implements View.OnClickListener
{
  public awsh(VipProfileWZRYView paramVipProfileWZRYView, awmk paramawmk) {}
  
  public void onClick(View paramView)
  {
    paramView = bdox.a("gameHonourAddHonour");
    VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipProfileWZRYView.a, paramView, -1L, null, false, -1);
    VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_into", "0", 1, 0, 0, ndd.a(), String.valueOf(this.jdField_a_of_type_Awmk.a.lCurrentBgId), String.valueOf(this.jdField_a_of_type_Awmk.a.lCurrentStyleId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awsh
 * JD-Core Version:    0.7.0.1
 */