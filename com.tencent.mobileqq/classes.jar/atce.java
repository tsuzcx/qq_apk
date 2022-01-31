import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;

public class atce
  implements bfpt
{
  public atce(GameQuickWordsPanel paramGameQuickWordsPanel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramView = new aaog();
    paramView.c = bbfj.a(BaseApplication.getContext());
    paramView.a = System.currentTimeMillis();
    aanz.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramAdapterView, null, paramView);
    this.a.jdField_a_of_type_Aepe.aK();
    axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "send_default", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atce
 * JD-Core Version:    0.7.0.1
 */