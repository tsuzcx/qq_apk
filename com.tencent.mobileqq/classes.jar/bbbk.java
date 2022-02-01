import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgBusi;
import java.util.List;

public abstract class bbbk
{
  private static int b;
  public int a;
  
  public bbbk()
  {
    int i = b;
    b = i + 1;
    this.a = i;
  }
  
  public abstract void a(String paramString, List<NumRedMsg.NumMsgBusi> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbk
 * JD-Core Version:    0.7.0.1
 */