package androidx.recyclerview.widget;

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
      this.this$0.animateAddImpl(localViewHolder);
    }
    this.val$additions.clear();
    this.this$0.mAdditionsList.remove(this.val$additions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.DefaultItemAnimator.3
 * JD-Core Version:    0.7.0.1
 */