import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.List;

class apmk
  implements AdapterView.OnItemClickListener
{
  apmk(apmg paramapmg) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = apmg.a(this.a).getSelectedView();
    if (localObject != null) {
      ((View)localObject).setSelected(false);
    }
    apmg.a(this.a).setSelection(paramInt);
    localObject = apmg.a(this.a).getSelectedView();
    if (localObject != null) {
      ((View)localObject).setSelected(true);
    }
    apmg.a(this.a, paramInt);
    apmg.a(this.a, true);
    if ((apmg.a(this.a) != null) && (apmg.a(this.a).size() > 0) && (apmg.a(this.a).size() > apmg.a(this.a)))
    {
      localObject = (apnh)apmg.a(this.a).get(apmg.a(this.a));
      if (localObject != null) {
        apok.a(null, ((apnh)localObject).a, "AIOInputPannelTabClick", 0, 0, 0L, 0L, 0L, "", "");
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmk
 * JD-Core Version:    0.7.0.1
 */