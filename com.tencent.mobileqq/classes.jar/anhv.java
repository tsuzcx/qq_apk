import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.HorizontalListView;
import java.util.List;

class anhv
  implements AdapterView.OnItemClickListener
{
  anhv(anhr paramanhr) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = anhr.a(this.a).getSelectedView();
    if (paramAdapterView != null) {
      paramAdapterView.setSelected(false);
    }
    anhr.a(this.a).setSelection(paramInt);
    paramAdapterView = anhr.a(this.a).getSelectedView();
    if (paramAdapterView != null) {
      paramAdapterView.setSelected(true);
    }
    anhr.a(this.a, paramInt);
    anhr.a(this.a, true);
    if ((anhr.a(this.a) != null) && (anhr.a(this.a).size() > 0) && (anhr.a(this.a).size() > anhr.a(this.a)))
    {
      paramAdapterView = (anis)anhr.a(this.a).get(anhr.a(this.a));
      if (paramAdapterView != null) {
        anjv.a(null, paramAdapterView.a, "AIOInputPannelTabClick", 0, 0, 0L, 0L, 0L, "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhv
 * JD-Core Version:    0.7.0.1
 */