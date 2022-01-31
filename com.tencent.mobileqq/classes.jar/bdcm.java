import android.view.View;
import com.tencent.open.agent.OpenAuthorityAccountView;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.widget.AdapterView;
import java.util.Iterator;
import java.util.List;

public class bdcm
  implements bfpt
{
  public bdcm(OpenCardContainer paramOpenCardContainer) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = bdct.a(this.a.jdField_a_of_type_Bdct).iterator();
    while (paramAdapterView.hasNext()) {
      ((bdcw)paramAdapterView.next()).a = false;
    }
    ((bdcw)bdct.a(this.a.jdField_a_of_type_Bdct).get(paramInt)).a = true;
    this.a.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(false);
    this.a.jdField_a_of_type_Bdct.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdcm
 * JD-Core Version:    0.7.0.1
 */