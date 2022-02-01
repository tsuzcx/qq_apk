import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

public class bmdu
{
  public int a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return 0;
    }
    if ((paramView instanceof ScrollView))
    {
      if (paramBoolean) {
        return paramView.getScrollY();
      }
      paramView = (ScrollView)paramView;
      return paramView.getChildAt(0).getBottom() - (paramView.getHeight() + paramView.getScrollY());
    }
    Object localObject;
    int i;
    int j;
    if (((paramView instanceof ListView)) && (((ListView)paramView).getChildCount() > 0))
    {
      paramView = (ListView)paramView;
      if (paramView.getAdapter() == null) {
        return 0;
      }
      if (paramBoolean)
      {
        localObject = paramView.getChildAt(0);
        return paramView.getFirstVisiblePosition() * ((View)localObject).getHeight() - ((View)localObject).getTop();
      }
      localObject = paramView.getChildAt(paramView.getChildCount() - 1);
      i = paramView.getAdapter().getCount();
      j = paramView.getLastVisiblePosition();
      int k = ((View)localObject).getHeight();
      return ((View)localObject).getBottom() + (i - j - 1) * k - paramView.getBottom();
    }
    if (((paramView instanceof RecyclerView)) && (((RecyclerView)paramView).getChildCount() > 0))
    {
      paramView = (RecyclerView)paramView;
      localObject = paramView.getLayoutManager();
      if (paramView.getAdapter() == null) {
        return 0;
      }
      if (paramBoolean)
      {
        localView = paramView.getChildAt(0);
        return paramView.getChildLayoutPosition(localView) * ((RecyclerView.LayoutManager)localObject).getDecoratedMeasuredHeight(localView) - ((RecyclerView.LayoutManager)localObject).getDecoratedTop(localView);
      }
      View localView = paramView.getChildAt(paramView.getChildCount() - 1);
      i = paramView.getAdapter().getItemCount();
      j = ((RecyclerView.LayoutManager)localObject).getDecoratedMeasuredHeight(localView);
      return ((RecyclerView.LayoutManager)localObject).getDecoratedBottom(localView) + (i - 1) * j - paramView.getBottom();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdu
 * JD-Core Version:    0.7.0.1
 */