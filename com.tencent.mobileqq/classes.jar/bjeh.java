import android.view.View;
import com.tencent.open.agent.OpenAuthorityAccountView;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.Iterator;
import java.util.List;

public class bjeh
  implements AdapterView.OnItemClickListener
{
  public bjeh(OpenCardContainer paramOpenCardContainer) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = bjeo.a(this.a.jdField_a_of_type_Bjeo).iterator();
    while (paramAdapterView.hasNext()) {
      ((bjer)paramAdapterView.next()).a = false;
    }
    ((bjer)bjeo.a(this.a.jdField_a_of_type_Bjeo).get(paramInt)).a = true;
    this.a.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(false);
    this.a.jdField_a_of_type_Bjeo.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjeh
 * JD-Core Version:    0.7.0.1
 */