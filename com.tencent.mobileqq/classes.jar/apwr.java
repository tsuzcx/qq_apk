import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.List;

class apwr
  implements AdapterView.OnItemClickListener
{
  apwr(apwn paramapwn) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = apwn.a(this.a).getSelectedView();
    if (localObject != null) {
      ((View)localObject).setSelected(false);
    }
    apwn.a(this.a).setSelection(paramInt);
    localObject = apwn.a(this.a).getSelectedView();
    if (localObject != null) {
      ((View)localObject).setSelected(true);
    }
    apwn.a(this.a, paramInt);
    apwn.a(this.a, true);
    if ((apwn.a(this.a) != null) && (apwn.a(this.a).size() > 0) && (apwn.a(this.a).size() > apwn.a(this.a)))
    {
      localObject = (apxo)apwn.a(this.a).get(apwn.a(this.a));
      if (localObject != null) {
        apyp.a(null, ((apxo)localObject).a, "AIOInputPannelTabClick", 0, 0, 0L, 0L, 0L, "", "");
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apwr
 * JD-Core Version:    0.7.0.1
 */