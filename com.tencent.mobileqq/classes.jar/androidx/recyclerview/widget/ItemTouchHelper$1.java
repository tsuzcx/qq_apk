package androidx.recyclerview.widget;

import androidx.core.view.ViewCompat;

class ItemTouchHelper$1
  implements Runnable
{
  ItemTouchHelper$1(ItemTouchHelper paramItemTouchHelper) {}
  
  public void run()
  {
    if ((this.this$0.mSelected != null) && (this.this$0.scrollIfNecessary()))
    {
      if (this.this$0.mSelected != null)
      {
        ItemTouchHelper localItemTouchHelper = this.this$0;
        localItemTouchHelper.moveIfNecessary(localItemTouchHelper.mSelected);
      }
      this.this$0.mRecyclerView.removeCallbacks(this.this$0.mScrollRunnable);
      ViewCompat.postOnAnimation(this.this$0.mRecyclerView, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.ItemTouchHelper.1
 * JD-Core Version:    0.7.0.1
 */