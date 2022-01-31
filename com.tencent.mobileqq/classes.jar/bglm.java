import com.tencent.common.app.AppInterface;
import mqq.manager.TicketManager;

public class bglm
{
  public static String a(AppInterface paramAppInterface)
  {
    return ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bglm
 * JD-Core Version:    0.7.0.1
 */