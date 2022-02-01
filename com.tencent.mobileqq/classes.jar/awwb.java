import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class awwb
  extends awwa
{
  public awwb(QQAppInterface paramQQAppInterface)
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
          String str = anni.a(2131692058) + localMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
          localArrayList.set(i, this.a.a().a().a(localMessageRecord, str, true));
        }
        i += 1;
      }
    }
  }
  
  public void a(awws paramawws, HashMap<String, ArrayList<MessageRecord>> paramHashMap, awwd paramawwd)
  {
    if (paramawws == null) {
      return;
    }
    if ((paramawws.b == 8) || (paramawws.b == 9)) {}
    for (paramawws = new athu(this.a, paramawws, paramHashMap, paramawwd);; paramawws = new aths(this.a, paramawws, paramHashMap, paramawwd))
    {
      this.a.a().a().a(paramawws, paramHashMap);
      return;
      if (paramawws.b == 2)
      {
        a(paramHashMap);
        paramawwd.a(0, 2, paramawws);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awwb
 * JD-Core Version:    0.7.0.1
 */