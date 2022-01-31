package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

class DefaultItemAnimator$2
  implements Runnable
{
  DefaultItemAnimator$2(DefaultItemAnimator paramDefaultItemAnimator, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.val$changes.iterator();
    while (localIterator.hasNext())
    {
      DefaultItemAnimator.ChangeInfo localChangeInfo = (DefaultItemAnimator.ChangeInfo)localIterator.next();
      DefaultItemAnimator.access$200(this.this$0, localChangeInfo);
    }
    this.val$changes.clear();
    DefaultItemAnimator.access$300(this.this$0).remove(this.val$changes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator.2
 * JD-Core Version:    0.7.0.1
 */