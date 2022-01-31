import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.OpenFrame;
import com.tencent.open.agent.datamodel.Friend;
import java.util.ArrayList;

public class bezt
  implements AdapterView.OnItemClickListener
{
  public bezt(FriendChooser paramFriendChooser) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (Friend)this.a.jdField_a_of_type_Bezx.getItem(paramInt);
    if ((paramAdapterView != null) && (this.a.jdField_a_of_type_Bfdi.a(paramAdapterView.a)))
    {
      this.a.jdField_a_of_type_Bfdi.b(paramAdapterView.a);
      this.a.b.remove(paramAdapterView);
      this.a.e();
      ((OpenFrame)this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).g();
      this.a.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bezt
 * JD-Core Version:    0.7.0.1
 */