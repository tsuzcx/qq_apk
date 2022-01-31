import android.view.View;
import com.tencent.open.agent.OpenAuthorityAccountView;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.widget.AdapterView;
import java.util.Iterator;
import java.util.List;

public class bdbx
  implements bfpc
{
  public bdbx(OpenCardContainer paramOpenCardContainer) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = bdce.a(this.a.jdField_a_of_type_Bdce).iterator();
    while (paramAdapterView.hasNext()) {
      ((bdch)paramAdapterView.next()).a = false;
    }
    ((bdch)bdce.a(this.a.jdField_a_of_type_Bdce).get(paramInt)).a = true;
    this.a.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(false);
    this.a.jdField_a_of_type_Bdce.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdbx
 * JD-Core Version:    0.7.0.1
 */