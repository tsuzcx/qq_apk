import com.tencent.mobileqq.apollo.data.CmGamePushItem;
import java.util.Comparator;

class amrb
  implements Comparator<CmGamePushItem>
{
  amrb(amra paramamra) {}
  
  public int a(CmGamePushItem paramCmGamePushItem1, CmGamePushItem paramCmGamePushItem2)
  {
    if (paramCmGamePushItem1.start_ts == paramCmGamePushItem2.start_ts) {
      return paramCmGamePushItem2.send_time - paramCmGamePushItem1.send_time;
    }
    return paramCmGamePushItem2.start_ts - paramCmGamePushItem1.start_ts;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrb
 * JD-Core Version:    0.7.0.1
 */