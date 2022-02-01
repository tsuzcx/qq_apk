import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class axpl
{
  public int a;
  public SessionInfo a;
  public MessageForStructing a;
  public AbsStructMsg a;
  private Object a = new Object();
  public HashMap<String, ArrayList<MessageRecord>> a;
  public List<ChatMessage> a;
  public Map<String, String> a;
  public boolean a;
  public int b;
  public List<MessageForStructing> b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  private int h;
  private int i;
  
  public int a()
  {
    synchronized (this.a)
    {
      int j = this.h;
      return j;
    }
  }
  
  public String a()
  {
    return String.valueOf(hashCode());
  }
  
  public void a(int paramInt)
  {
    synchronized (this.a)
    {
      this.h ^= paramInt;
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.a)
    {
      int j = this.i;
      if (paramInt1 == 0) {
        paramInt2 = 0;
      }
      this.i = (j + paramInt2);
      return;
    }
  }
  
  public int b()
  {
    synchronized (this.a)
    {
      int j = this.i;
      return j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axpl
 * JD-Core Version:    0.7.0.1
 */