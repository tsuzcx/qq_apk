import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class auox
  extends auow
{
  public auox(QQAppInterface paramQQAppInterface)
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
          String str = alud.a(2131692474) + localMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
          localArrayList.set(i, this.a.a().a().a(localMessageRecord, str, true));
        }
        i += 1;
      }
    }
  }
  
  public void a(aupm paramaupm, HashMap<String, ArrayList<MessageRecord>> paramHashMap, auoz paramauoz)
  {
    if (paramaupm == null) {
      return;
    }
    if ((paramaupm.b == 8) || (paramaupm.b == 9)) {}
    for (paramaupm = new arck(this.a, paramaupm, paramHashMap, paramauoz);; paramaupm = new arci(this.a, paramaupm, paramHashMap, paramauoz))
    {
      this.a.a().a().a(paramaupm, paramHashMap);
      return;
      if (paramaupm.b == 2)
      {
        a(paramHashMap);
        paramauoz.a(0, 2, paramaupm);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auox
 * JD-Core Version:    0.7.0.1
 */