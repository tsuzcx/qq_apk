import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.List;

class aqaa
  implements AdapterView.OnItemClickListener
{
  aqaa(apzw paramapzw) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = apzw.a(this.a).getSelectedView();
    if (localObject != null) {
      ((View)localObject).setSelected(false);
    }
    apzw.a(this.a).setSelection(paramInt);
    localObject = apzw.a(this.a).getSelectedView();
    if (localObject != null) {
      ((View)localObject).setSelected(true);
    }
    apzw.a(this.a, paramInt);
    apzw.a(this.a, true);
    if ((apzw.a(this.a) != null) && (apzw.a(this.a).size() > 0) && (apzw.a(this.a).size() > apzw.a(this.a)))
    {
      localObject = (aqax)apzw.a(this.a).get(apzw.a(this.a));
      if (localObject != null) {
        aqca.a(null, ((aqax)localObject).a, "AIOInputPannelTabClick", 0, 0, 0L, 0L, 0L, "", "");
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqaa
 * JD-Core Version:    0.7.0.1
 */