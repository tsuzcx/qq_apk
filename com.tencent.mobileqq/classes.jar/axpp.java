import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;

public class axpp
  extends axot
{
  public axpp(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(axpl paramaxpl, HashMap<String, ArrayList<MessageRecord>> paramHashMap, axow paramaxow)
  {
    super.a(paramaxpl, paramHashMap, paramaxow);
    paramaxow.a(0, 4, paramaxpl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axpp
 * JD-Core Version:    0.7.0.1
 */