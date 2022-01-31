package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

class DefaultItemAnimator$3
  implements Runnable
{
  DefaultItemAnimator$3(DefaultItemAnimator paramDefaultItemAnimator, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.val$additions.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localIterator.next();
      DefaultItemAnimator.access$400(this.this$0, localViewHolder);
    }
    this.val$additions.clear();
    DefaultItemAnimator.access$500(this.this$0).remove(this.val$additions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator.3
 * JD-Core Version:    0.7.0.1
 */