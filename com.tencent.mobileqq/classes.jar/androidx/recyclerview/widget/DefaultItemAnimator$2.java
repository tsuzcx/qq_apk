package androidx.recyclerview.widget;

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
      this.this$0.animateChangeImpl(localChangeInfo);
    }
    this.val$changes.clear();
    this.this$0.mChangesList.remove(this.val$changes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.DefaultItemAnimator.2
 * JD-Core Version:    0.7.0.1
 */