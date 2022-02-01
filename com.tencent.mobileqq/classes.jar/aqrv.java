import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout;

public class aqrv
  implements aqrn
{
  public aqrv(SwipePostTableLayout paramSwipePostTableLayout) {}
  
  public void onServiceSyncSucc(boolean paramBoolean)
  {
    QLog.d("SwipePostTableLayout", 1, "result: " + paramBoolean);
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqrv
 * JD-Core Version:    0.7.0.1
 */