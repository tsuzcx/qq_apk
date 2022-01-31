import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;

public class azla
  implements AdapterView.OnItemClickListener
{
  public azla(NewTroopContactView paramNewTroopContactView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((ResultRecord)paramView.getTag()).a;
    if (this.a.a(paramAdapterView))
    {
      NewTroopContactView.a(this.a, paramAdapterView);
      this.a.a.notifyDataSetChanged();
      this.a.b(false);
      NewTroopContactView.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azla
 * JD-Core Version:    0.7.0.1
 */