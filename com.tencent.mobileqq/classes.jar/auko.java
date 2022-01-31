import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class auko
  extends aukn
{
  public auko(QQAppInterface paramQQAppInterface)
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
          String str = alpo.a(2131692473) + localMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
          localArrayList.set(i, this.a.a().a().a(localMessageRecord, str, true));
        }
        i += 1;
      }
    }
  }
  
  public void a(auld paramauld, HashMap<String, ArrayList<MessageRecord>> paramHashMap, aukq paramaukq)
  {
    if (paramauld == null) {
      return;
    }
    if ((paramauld.b == 8) || (paramauld.b == 9)) {}
    for (paramauld = new aqyb(this.a, paramauld, paramHashMap, paramaukq);; paramauld = new aqxz(this.a, paramauld, paramHashMap, paramaukq))
    {
      this.a.a().a().a(paramauld, paramHashMap);
      return;
      if (paramauld.b == 2)
      {
        a(paramHashMap);
        paramaukq.a(0, 2, paramauld);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auko
 * JD-Core Version:    0.7.0.1
 */