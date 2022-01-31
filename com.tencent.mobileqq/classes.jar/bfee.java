import android.view.View;
import android.widget.EditText;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.OpenFrame;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import java.util.List;

public class bfee
  implements bhuw
{
  public bfee(FriendChooser paramFriendChooser) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (Friend)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    if ((paramAdapterView == null) || (this.a.jdField_a_of_type_Bfhr.a(paramAdapterView.a))) {
      return;
    }
    if (this.a.jdField_a_of_type_Bfhr.c() >= this.a.jdField_a_of_type_Int)
    {
      this.a.h();
      return;
    }
    paramView = (OpenFrame)this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView();
    this.a.b.add(paramAdapterView);
    this.a.jdField_a_of_type_Bfhr.a(paramAdapterView.a);
    this.a.e();
    paramView.g();
    this.a.b(false);
    this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfee
 * JD-Core Version:    0.7.0.1
 */