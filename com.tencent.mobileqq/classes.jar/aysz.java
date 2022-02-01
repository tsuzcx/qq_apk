import android.util.SparseIntArray;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;

public class aysz
{
  public static final SparseIntArray a = new SparseIntArray(4);
  public static final SparseIntArray b = new SparseIntArray(4);
  
  static
  {
    a.put(1, 0);
    a.put(2, 5);
    a.put(3, 3);
    a.put(4, 4);
    b.put(0, 1);
    b.put(5, 2);
    b.put(3, 3);
    b.put(4, 4);
  }
  
  public static int a(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 4)) {
      return a.get(paramInt);
    }
    return a.get(1);
  }
  
  public static void a(RedTouchItem paramRedTouchItem1, RedTouchItem paramRedTouchItem2)
  {
    paramRedTouchItem1.count = paramRedTouchItem2.count;
    paramRedTouchItem1.receiveTime = paramRedTouchItem2.receiveTime;
    paramRedTouchItem1.redtouchType = paramRedTouchItem2.redtouchType;
    paramRedTouchItem1.curSeq = paramRedTouchItem2.curSeq;
    paramRedTouchItem1.icon = paramRedTouchItem2.icon;
    paramRedTouchItem1.unReadFlag = paramRedTouchItem2.unReadFlag;
    paramRedTouchItem1.validTimeRemained = paramRedTouchItem2.validTimeRemained;
    paramRedTouchItem1.isClosed = paramRedTouchItem2.isClosed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysz
 * JD-Core Version:    0.7.0.1
 */