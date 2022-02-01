package androidx.viewpager2.widget;

import androidx.recyclerview.widget.RecyclerView;

class ViewPager2$SmoothScrollToPosition
  implements Runnable
{
  private final int mPosition;
  private final RecyclerView mRecyclerView;
  
  ViewPager2$SmoothScrollToPosition(int paramInt, RecyclerView paramRecyclerView)
  {
    this.mPosition = paramInt;
    this.mRecyclerView = paramRecyclerView;
  }
  
  public void run()
  {
    this.mRecyclerView.smoothScrollToPosition(this.mPosition);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.viewpager2.widget.ViewPager2.SmoothScrollToPosition
 * JD-Core Version:    0.7.0.1
 */