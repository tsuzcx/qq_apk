import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class axou
  extends axot
{
  public axou(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(HashMap<String, ArrayList<MessageRecord>> paramHashMap)
  {
    if ((paramHashMap == null) || (paramHashMap.isEmpty())) {
      return;
    }
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      ArrayList localArrayList = (ArrayList)paramHashMap.get((String)localIterator.next());
      int i = 0;
      while (i < localArrayList.size())
      {
        MessageRecord localMessageRecord = (MessageRecord)localArrayList.get(i);
        if (((localMessageRecord instanceof MessageForFile)) || ((localMessageRecord instanceof MessageForTroopFile)))
        {
          String str = anzj.a(2131692063) + localMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
          localArrayList.set(i, this.a.a().a().a(localMessageRecord, str, true));
        }
        i += 1;
      }
    }
  }
  
  public void a(axpl paramaxpl, HashMap<String, ArrayList<MessageRecord>> paramHashMap, axow paramaxow)
  {
    if (paramaxpl == null) {
      return;
    }
    if ((paramaxpl.b == 8) || (paramaxpl.b == 9)) {}
    for (paramaxpl = new atzo(this.a, paramaxpl, paramHashMap, paramaxow);; paramaxpl = new atzm(this.a, paramaxpl, paramHashMap, paramaxow))
    {
      this.a.a().a().a(paramaxpl, paramHashMap);
      return;
      if (paramaxpl.b == 2)
      {
        a(paramHashMap);
        paramaxow.a(0, 2, paramaxpl);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axou
 * JD-Core Version:    0.7.0.1
 */