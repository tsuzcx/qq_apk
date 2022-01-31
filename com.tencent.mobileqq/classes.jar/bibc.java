import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.XRecyclerView;

public class bibc
  extends RecyclerView.OnScrollListener
{
  public bibc(XRecyclerView paramXRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    int i = 0;
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (XRecyclerView.c(this.a) == 2)) {
      this.a.a();
    }
    int j = paramRecyclerView.getChildCount();
    boolean bool;
    if ((paramRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager))
    {
      paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.getLayoutManager();
      i = paramRecyclerView.getItemCount();
      paramRecyclerView = paramRecyclerView.findFirstVisibleItemPositions(null);
      int k = XRecyclerView.a(this.a).a();
      if (i - j <= paramRecyclerView[0] + k)
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("XRecyclerView", 2, new Object[] { "totalItemCount=%d, firstVisibleItem=%d, visibleThreshold=%d, isCloseToTheEnd=%b", Integer.valueOf(i), Integer.valueOf(paramRecyclerView[0]), Integer.valueOf(k), Boolean.valueOf(bool) });
        }
        if (bool) {
          XRecyclerView.a(this.a).b(true);
        }
      }
    }
    for (;;)
    {
      XRecyclerView.c(this.a, paramInt);
      return;
      bool = false;
      break;
      if ((paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
      {
        paramRecyclerView = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
        if (paramRecyclerView.getItemCount() - j <= paramRecyclerView.findFirstVisibleItemPosition() + XRecyclerView.a(this.a).a()) {
          i = 1;
        }
        if (i != 0) {
          XRecyclerView.a(this.a).b(true);
        }
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    XRecyclerView.a(this.a, XRecyclerView.a(this.a) + paramInt1);
    XRecyclerView.b(this.a, XRecyclerView.b(this.a) + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bibc
 * JD-Core Version:    0.7.0.1
 */