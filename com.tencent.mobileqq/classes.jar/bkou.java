import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;

public class bkou
  implements AdapterView.OnItemClickListener
{
  public bkou(HorizontalSelectColorLayout paramHorizontalSelectColorLayout) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    HorizontalSelectColorLayout.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkou
 * JD-Core Version:    0.7.0.1
 */