import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;

public class bqxs
  implements AdapterView.OnItemSelectedListener
{
  public bqxs(HorizontalSelectColorLayout paramHorizontalSelectColorLayout) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    HorizontalSelectColorLayout.a(this.a, paramInt);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqxs
 * JD-Core Version:    0.7.0.1
 */