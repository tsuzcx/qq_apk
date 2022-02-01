import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import java.util.List;

class bkcd
  implements bkbt
{
  bkcd(bkcc parambkcc) {}
  
  public void a(List<Pair<Integer, Byte>> paramList)
  {
    Message localMessage = bkcc.a(this.a).obtainMessage(2);
    localMessage.obj = paramList;
    bkcc.a(this.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkcd
 * JD-Core Version:    0.7.0.1
 */