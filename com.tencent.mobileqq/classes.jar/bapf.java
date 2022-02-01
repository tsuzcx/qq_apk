import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class bapf
  implements AdapterView.OnItemClickListener
{
  public bapf(QCallDetailActivity paramQCallDetailActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ajca.a(((TextView)paramView.findViewById(2131374338)).getText().toString());
    this.a.a(this.a.getActivity(), paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapf
 * JD-Core Version:    0.7.0.1
 */