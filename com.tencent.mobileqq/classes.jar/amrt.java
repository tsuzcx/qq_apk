import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.apollo.debug.CmGameDebugView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amrt
  implements AdapterView.OnItemClickListener
{
  public amrt(CmGameDebugView paramCmGameDebugView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    CmGameDebugView.a(this.a, paramInt);
    this.a.a(paramInt);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrt
 * JD-Core Version:    0.7.0.1
 */