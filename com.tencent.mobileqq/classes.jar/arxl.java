import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class arxl
  extends arxk
{
  public arxl(QQAppInterface paramQQAppInterface)
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
          String str = ajjy.a(2131626795) + localMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
          localArrayList.set(i, this.a.a().a().a(localMessageRecord, str, true));
        }
        i += 1;
      }
    }
  }
  
  public void a(arya paramarya, HashMap<String, ArrayList<MessageRecord>> paramHashMap, arxn paramarxn)
  {
    if (paramarya == null) {
      return;
    }
    if ((paramarya.b == 8) || (paramarya.b == 9)) {}
    for (paramarya = new aooe(this.a, paramarya, paramHashMap, paramarxn);; paramarya = new aooc(this.a, paramarya, paramHashMap, paramarxn))
    {
      this.a.a().a().a(paramarya, paramHashMap);
      return;
      if (paramarya.b == 2)
      {
        a(paramHashMap);
        paramarxn.a(0, 2, paramarya);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     arxl
 * JD-Core Version:    0.7.0.1
 */