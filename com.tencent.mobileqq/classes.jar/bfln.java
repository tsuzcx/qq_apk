import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import java.util.ArrayList;

class bfln
  extends RecyclerView.OnScrollListener
{
  bfln(bfll parambfll) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    int i = 0;
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (bfll.a(this.a) == null) {
      break label18;
    }
    for (;;)
    {
      label18:
      return;
      if ((paramInt == 0) || (paramInt == 1))
      {
        paramRecyclerView = bfll.a(this.a).getLayoutManager();
        if (!(paramRecyclerView instanceof LinearLayoutManager)) {
          break;
        }
        paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
        int k = paramRecyclerView.findFirstVisibleItemPosition();
        paramInt = paramRecyclerView.findLastVisibleItemPosition();
        if (paramInt == 0) {
          if (bfll.a(this.a) != null)
          {
            int j = bfll.a(this.a).size();
            paramInt = j;
            if (j > 6) {
              paramInt = 6;
            }
          }
        }
        while (i < paramInt - k)
        {
          if (bfll.a(this.a).getChildAt(i) != null)
          {
            paramRecyclerView = bfll.a(this.a).getChildAt(i);
            if ((paramRecyclerView.getTag() != null) && ((paramRecyclerView.getTag() instanceof bfkl)))
            {
              paramRecyclerView = (bfkl)paramRecyclerView.getTag();
              bfll.a(this.a).c(Long.valueOf(paramRecyclerView.a()), Long.valueOf(paramRecyclerView.c()));
            }
          }
          i += 1;
          continue;
          paramInt = 0;
        }
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfln
 * JD-Core Version:    0.7.0.1
 */