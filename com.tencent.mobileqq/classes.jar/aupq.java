import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;

public class aupq
  extends auow
{
  public aupq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(aupm paramaupm, HashMap<String, ArrayList<MessageRecord>> paramHashMap, auoz paramauoz)
  {
    super.a(paramaupm, paramHashMap, paramauoz);
    paramauoz.a(0, 4, paramaupm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aupq
 * JD-Core Version:    0.7.0.1
 */