import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class astr
  extends astq
{
  public astr(QQAppInterface paramQQAppInterface)
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
          String str = ajya.a(2131692397) + localMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
          localArrayList.set(i, this.a.a().a().a(localMessageRecord, str, true));
        }
        i += 1;
      }
    }
  }
  
  public void a(asug paramasug, HashMap<String, ArrayList<MessageRecord>> paramHashMap, astt paramastt)
  {
    if (paramasug == null) {
      return;
    }
    if ((paramasug.b == 8) || (paramasug.b == 9)) {}
    for (paramasug = new apfd(this.a, paramasug, paramHashMap, paramastt);; paramasug = new apfb(this.a, paramasug, paramHashMap, paramastt))
    {
      this.a.a().a().a(paramasug, paramHashMap);
      return;
      if (paramasug.b == 2)
      {
        a(paramHashMap);
        paramastt.a(0, 2, paramasug);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     astr
 * JD-Core Version:    0.7.0.1
 */