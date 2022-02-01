import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.List;

class aotn
  implements AdapterView.OnItemClickListener
{
  aotn(aotj paramaotj) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = aotj.a(this.a).getSelectedView();
    if (localObject != null) {
      ((View)localObject).setSelected(false);
    }
    aotj.a(this.a).setSelection(paramInt);
    localObject = aotj.a(this.a).getSelectedView();
    if (localObject != null) {
      ((View)localObject).setSelected(true);
    }
    aotj.a(this.a, paramInt);
    aotj.a(this.a, true);
    if ((aotj.a(this.a) != null) && (aotj.a(this.a).size() > 0) && (aotj.a(this.a).size() > aotj.a(this.a)))
    {
      localObject = (aouk)aotj.a(this.a).get(aotj.a(this.a));
      if (localObject != null) {
        aovl.a(null, ((aouk)localObject).a, "AIOInputPannelTabClick", 0, 0, 0L, 0L, 0L, "", "");
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aotn
 * JD-Core Version:    0.7.0.1
 */