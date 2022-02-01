import android.view.View;
import com.tencent.open.agent.OpenAuthorityAccountView;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.widget.AdapterView;
import java.util.Iterator;
import java.util.List;

public class bjnw
  implements bljm
{
  public bjnw(OpenCardContainer paramOpenCardContainer) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = bjod.a(this.a.jdField_a_of_type_Bjod).iterator();
    while (paramAdapterView.hasNext()) {
      ((bjog)paramAdapterView.next()).a = false;
    }
    ((bjog)bjod.a(this.a.jdField_a_of_type_Bjod).get(paramInt)).a = true;
    this.a.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(false);
    this.a.jdField_a_of_type_Bjod.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjnw
 * JD-Core Version:    0.7.0.1
 */