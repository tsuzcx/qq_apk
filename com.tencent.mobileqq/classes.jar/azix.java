import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class azix
  implements AdapterView.OnItemClickListener
{
  public azix(QCallDetailActivity paramQCallDetailActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = aihb.a(((TextView)paramView.findViewById(2131374104)).getText().toString());
    this.a.a(this.a.getActivity(), paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azix
 * JD-Core Version:    0.7.0.1
 */