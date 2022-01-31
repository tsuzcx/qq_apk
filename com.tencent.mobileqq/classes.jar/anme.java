import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.HorizontalListView;
import java.util.List;

class anme
  implements AdapterView.OnItemClickListener
{
  anme(anma paramanma) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = anma.a(this.a).getSelectedView();
    if (paramAdapterView != null) {
      paramAdapterView.setSelected(false);
    }
    anma.a(this.a).setSelection(paramInt);
    paramAdapterView = anma.a(this.a).getSelectedView();
    if (paramAdapterView != null) {
      paramAdapterView.setSelected(true);
    }
    anma.a(this.a, paramInt);
    anma.a(this.a, true);
    if ((anma.a(this.a) != null) && (anma.a(this.a).size() > 0) && (anma.a(this.a).size() > anma.a(this.a)))
    {
      paramAdapterView = (annb)anma.a(this.a).get(anma.a(this.a));
      if (paramAdapterView != null) {
        anoe.a(null, paramAdapterView.a, "AIOInputPannelTabClick", 0, 0, 0L, 0L, 0L, "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anme
 * JD-Core Version:    0.7.0.1
 */