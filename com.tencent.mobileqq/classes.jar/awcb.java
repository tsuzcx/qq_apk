import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class awcb
  extends awca
{
  public awcb(QQAppInterface paramQQAppInterface)
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
          String str = amtj.a(2131692111) + localMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
          localArrayList.set(i, this.a.getProxyManager().a().a(localMessageRecord, str, true));
        }
        i += 1;
      }
    }
  }
  
  public void a(awcs paramawcs, HashMap<String, ArrayList<MessageRecord>> paramHashMap, awcd paramawcd)
  {
    if (paramawcs == null) {
      return;
    }
    if ((paramawcs.b == 8) || (paramawcs.b == 9)) {}
    for (paramawcs = new asly(this.a, paramawcs, paramHashMap, paramawcd);; paramawcs = new aslw(this.a, paramawcs, paramHashMap, paramawcd))
    {
      this.a.getFileManagerEngine().a().a(paramawcs, paramHashMap);
      return;
      if (paramawcs.b == 2)
      {
        a(paramHashMap);
        paramawcd.a(0, 2, paramawcs);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awcb
 * JD-Core Version:    0.7.0.1
 */