package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Iterator;

class DefaultItemAnimator$1
  implements Runnable
{
  DefaultItemAnimator$1(DefaultItemAnimator paramDefaultItemAnimator, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.val$moves.iterator();
    while (localIterator.hasNext())
    {
      DefaultItemAnimator.MoveInfo localMoveInfo = (DefaultItemAnimator.MoveInfo)localIterator.next();
      this.this$0.animateMoveImpl(localMoveInfo.holder, localMoveInfo.fromX, localMoveInfo.fromY, localMoveInfo.toX, localMoveInfo.toY);
    }
    this.val$moves.clear();
    this.this$0.mMovesList.remove(this.val$moves);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.DefaultItemAnimator.1
 * JD-Core Version:    0.7.0.1
 */