import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgBusi;
import java.util.List;

public abstract class axlr
{
  private static int b;
  public int a;
  
  public axlr()
  {
    int i = b;
    b = i + 1;
    this.a = i;
  }
  
  public abstract void a(String paramString, List<NumRedMsg.NumMsgBusi> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axlr
 * JD-Core Version:    0.7.0.1
 */