package androidx.recyclerview.widget;

class GapWorker$Task
{
  public int distanceToItem;
  public boolean immediate;
  public int position;
  public RecyclerView view;
  public int viewVelocity;
  
  public void clear()
  {
    this.immediate = false;
    this.viewVelocity = 0;
    this.distanceToItem = 0;
    this.view = null;
    this.position = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.GapWorker.Task
 * JD-Core Version:    0.7.0.1
 */