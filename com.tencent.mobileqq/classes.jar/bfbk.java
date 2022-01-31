import android.view.View;
import com.tencent.open.agent.OpenAuthorityAccountView;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.widget.AdapterView;
import java.util.Iterator;
import java.util.List;

public class bfbk
  implements bhqp
{
  public bfbk(OpenCardContainer paramOpenCardContainer) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = bfbr.a(this.a.jdField_a_of_type_Bfbr).iterator();
    while (paramAdapterView.hasNext()) {
      ((bfbu)paramAdapterView.next()).a = false;
    }
    ((bfbu)bfbr.a(this.a.jdField_a_of_type_Bfbr).get(paramInt)).a = true;
    this.a.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(false);
    this.a.jdField_a_of_type_Bfbr.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfbk
 * JD-Core Version:    0.7.0.1
 */