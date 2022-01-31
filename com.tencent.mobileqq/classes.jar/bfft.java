import android.view.View;
import com.tencent.open.agent.OpenAuthorityAccountView;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.widget.AdapterView;
import java.util.Iterator;
import java.util.List;

public class bfft
  implements bhuw
{
  public bfft(OpenCardContainer paramOpenCardContainer) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = bfga.a(this.a.jdField_a_of_type_Bfga).iterator();
    while (paramAdapterView.hasNext()) {
      ((bfgd)paramAdapterView.next()).a = false;
    }
    ((bfgd)bfga.a(this.a.jdField_a_of_type_Bfga).get(paramInt)).a = true;
    this.a.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(false);
    this.a.jdField_a_of_type_Bfga.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfft
 * JD-Core Version:    0.7.0.1
 */