import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mfsdk.collector.DropFrameMonitor;

class blls
  extends RecyclerView.OnScrollListener
{
  blls(bllr parambllr) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      DropFrameMonitor.getInstance().stopMonitorScene("list_photo", false);
      return;
    }
    DropFrameMonitor.getInstance().startMonitorScene("list_photo");
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blls
 * JD-Core Version:    0.7.0.1
 */