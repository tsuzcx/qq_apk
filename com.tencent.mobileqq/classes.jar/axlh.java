import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.widget.ImageView;

class axlh
  extends RecyclerView.OnScrollListener
{
  axlh(axlg paramaxlg) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    axlg.a(this.a, paramInt);
    if (axlg.a(this.a) == 0)
    {
      if (axlg.a(this.a).a()) {
        axlg.a(this.a).b();
      }
      int i = axlg.a(this.a).getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramRecyclerView = axlg.a(this.a).getChildAt(paramInt);
        paramRecyclerView = (axlj)axlg.a(this.a).getChildViewHolder(paramRecyclerView);
        axlj.a(paramRecyclerView).setImageBitmap(axlg.a(this.a, axlj.a(paramRecyclerView)));
        paramInt += 1;
      }
    }
    axlg.a(this.a).a();
    axlg.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axlh
 * JD-Core Version:    0.7.0.1
 */