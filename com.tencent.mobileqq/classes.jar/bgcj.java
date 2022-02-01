import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import java.util.ArrayList;

class bgcj
  extends RecyclerView.OnScrollListener
{
  bgcj(bgch parambgch) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    int i = 0;
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (bgch.a(this.a) == null) {
      break label18;
    }
    for (;;)
    {
      label18:
      return;
      if ((paramInt == 0) || (paramInt == 1))
      {
        paramRecyclerView = bgch.a(this.a).getLayoutManager();
        if (!(paramRecyclerView instanceof LinearLayoutManager)) {
          break;
        }
        paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
        int k = paramRecyclerView.findFirstVisibleItemPosition();
        paramInt = paramRecyclerView.findLastVisibleItemPosition();
        if (paramInt == 0) {
          if (bgch.a(this.a) != null)
          {
            int j = bgch.a(this.a).size();
            paramInt = j;
            if (j > 6) {
              paramInt = 6;
            }
          }
        }
        while (i < paramInt - k)
        {
          if (bgch.a(this.a).getChildAt(i) != null)
          {
            paramRecyclerView = bgch.a(this.a).getChildAt(i);
            if ((paramRecyclerView.getTag() != null) && ((paramRecyclerView.getTag() instanceof bgba)))
            {
              paramRecyclerView = (bgba)paramRecyclerView.getTag();
              bgch.a(this.a).c(Long.valueOf(paramRecyclerView.a()), Long.valueOf(paramRecyclerView.b()));
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
 * Qualified Name:     bgcj
 * JD-Core Version:    0.7.0.1
 */