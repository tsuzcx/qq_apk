import android.view.View;
import com.tencent.open.agent.OpenAuthorityAccountView;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.Iterator;
import java.util.List;

public class bhtk
  implements AdapterView.OnItemClickListener
{
  public bhtk(OpenCardContainer paramOpenCardContainer) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = bhtr.a(this.a.jdField_a_of_type_Bhtr).iterator();
    while (paramAdapterView.hasNext()) {
      ((bhtu)paramAdapterView.next()).a = false;
    }
    ((bhtu)bhtr.a(this.a.jdField_a_of_type_Bhtr).get(paramInt)).a = true;
    this.a.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(false);
    this.a.jdField_a_of_type_Bhtr.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhtk
 * JD-Core Version:    0.7.0.1
 */