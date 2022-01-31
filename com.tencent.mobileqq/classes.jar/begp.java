import com.tencent.common.app.AppInterface;
import mqq.manager.TicketManager;

public class begp
{
  public static String a(AppInterface paramAppInterface)
  {
    return ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     begp
 * JD-Core Version:    0.7.0.1
 */