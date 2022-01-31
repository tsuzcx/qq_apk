import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;

public class autd
  implements bhqp
{
  public autd(GameQuickWordsPanel paramGameQuickWordsPanel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramView = new acfe();
    paramView.c = bdee.a(BaseApplication.getContext());
    paramView.a = System.currentTimeMillis();
    acex.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramAdapterView, null, paramView);
    this.a.jdField_a_of_type_Agmb.aM();
    azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "send_default", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     autd
 * JD-Core Version:    0.7.0.1
 */