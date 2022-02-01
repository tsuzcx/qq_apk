import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.view.View.OnClickListener;

public class arry
  extends RecyclerView.LayoutManager
{
  private View.OnClickListener a;
  
  public arry(View.OnClickListener paramOnClickListener)
  {
    this.a = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    layoutDecorated(paramView, paramInt1 + localLayoutParams.leftMargin, paramInt2 + localLayoutParams.topMargin, paramInt3 - localLayoutParams.rightMargin, paramInt4 - localLayoutParams.bottomMargin);
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    detachAndScrapAttachedViews(paramRecycler);
    int i = getItemCount();
    int m;
    int j;
    int k;
    if (i > 3)
    {
      i = 3;
      if (i >= 0)
      {
        paramState = paramRecycler.getViewForPosition(i);
        addView(paramState);
        measureChildWithMargins(paramState, 0, 0);
        m = getWidth() - getDecoratedMeasuredWidth(paramState);
        j = getHeight() - getDecoratedMeasuredHeight(paramState);
        k = m / 2;
        m /= 2;
        a(paramState, k, j, getDecoratedMeasuredWidth(paramState) + m, getDecoratedMeasuredHeight(paramState) + j);
        if (i == 3)
        {
          paramState.setScaleX(1.0F - (i - 1) * 0.1F);
          paramState.setScaleY(1.0F - (i - 1) * 0.1F);
          paramState.setTranslationY((i - 1) * paramState.getMeasuredHeight() / -10);
          paramState.setAlpha(0.8F);
        }
        for (;;)
        {
          i -= 1;
          break;
          if (i > 0)
          {
            paramState.setScaleX(1.0F - i * 0.1F);
            paramState.setScaleY(1.0F - i * 0.1F);
            paramState.setTranslationY(paramState.getMeasuredHeight() * i / -10);
            paramState.setAlpha(0.6F);
          }
          else if (this.a != null)
          {
            paramState.setOnClickListener(this.a);
          }
        }
      }
    }
    else
    {
      i -= 1;
      if (i >= 0)
      {
        paramState = paramRecycler.getViewForPosition(i);
        addView(paramState);
        measureChildWithMargins(paramState, 0, 0);
        m = getWidth() - getDecoratedMeasuredWidth(paramState);
        j = getHeight() - getDecoratedMeasuredHeight(paramState);
        k = m / 2;
        m /= 2;
        a(paramState, k, j, getDecoratedMeasuredWidth(paramState) + m, getDecoratedMeasuredHeight(paramState) + j);
        if (i > 0)
        {
          paramState.setScaleX(1.0F - i * 0.1F);
          paramState.setScaleY(1.0F - i * 0.1F);
          paramState.setTranslationY(paramState.getMeasuredHeight() * i / -10);
        }
        for (;;)
        {
          i -= 1;
          break;
          if (this.a != null) {
            paramState.setOnClickListener(this.a);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arry
 * JD-Core Version:    0.7.0.1
 */