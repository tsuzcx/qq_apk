import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class astp
  extends asto
{
  public astp(QQAppInterface paramQQAppInterface)
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
          String str = ajyc.a(2131692397) + localMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
          localArrayList.set(i, this.a.a().a().a(localMessageRecord, str, true));
        }
        i += 1;
      }
    }
  }
  
  public void a(asue paramasue, HashMap<String, ArrayList<MessageRecord>> paramHashMap, astr paramastr)
  {
    if (paramasue == null) {
      return;
    }
    if ((paramasue.b == 8) || (paramasue.b == 9)) {}
    for (paramasue = new apez(this.a, paramasue, paramHashMap, paramastr);; paramasue = new apex(this.a, paramasue, paramHashMap, paramastr))
    {
      this.a.a().a().a(paramasue, paramHashMap);
      return;
      if (paramasue.b == 2)
      {
        a(paramHashMap);
        paramastr.a(0, 2, paramasue);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     astp
 * JD-Core Version:    0.7.0.1
 */