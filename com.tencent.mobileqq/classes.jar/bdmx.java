import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.WtloginReporter.1;

public class bdmx
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManagerV2.executeOnFileThread(new WtloginReporter.1(paramQQAppInterface.getCurrentAccountUin()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdmx
 * JD-Core Version:    0.7.0.1
 */