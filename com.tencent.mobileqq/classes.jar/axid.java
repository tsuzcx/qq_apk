import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class axid
  extends axic
{
  public axid(QQAppInterface paramQQAppInterface)
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
          String str = anvx.a(2131692201) + localMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
          localArrayList.set(i, this.a.getProxyManager().a().a(localMessageRecord, str, true));
        }
        i += 1;
      }
    }
  }
  
  public void a(axiu paramaxiu, HashMap<String, ArrayList<MessageRecord>> paramHashMap, axif paramaxif)
  {
    if (paramaxiu == null) {
      return;
    }
    if ((paramaxiu.b == 8) || (paramaxiu.b == 9)) {}
    for (paramaxiu = new atqe(this.a, paramaxiu, paramHashMap, paramaxif);; paramaxiu = new atqc(this.a, paramaxiu, paramHashMap, paramaxif))
    {
      this.a.getFileManagerEngine().a().a(paramaxiu, paramHashMap);
      return;
      if (paramaxiu.b == 2)
      {
        a(paramHashMap);
        paramaxif.a(0, 2, paramaxiu);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axid
 * JD-Core Version:    0.7.0.1
 */