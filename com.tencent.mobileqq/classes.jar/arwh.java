import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class arwh
  extends ajjh
{
  private arwh(arwc paramarwc) {}
  
  protected void onAddFriend(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardManager", 2, "onAddFriend " + paramString);
    }
    ArrayList localArrayList;
    if ((!arwc.a(this.a)) && (arwc.a(this.a) != null))
    {
      localArrayList = (ArrayList)arwc.a(this.a).get(Long.valueOf(arwc.a(this.a)));
      if (localArrayList == null) {}
    }
    try
    {
      long l = Long.parseLong(paramString);
      if (localArrayList.indexOf(Long.valueOf(l)) != -1)
      {
        paramString = new ArrayList(1);
        paramString.add(Long.valueOf(l));
        localArrayList = new ArrayList(1);
        localArrayList.add(Long.valueOf(arwc.a(this.a)));
        HashMap localHashMap = new HashMap(5);
        localHashMap.put("notRequest", paramString);
        localHashMap.put("groupUin", localArrayList);
        ((apqq)arwc.a(this.a).a(153)).a(arwc.a(this.a), paramString, localHashMap);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MultiCardManager", 2, "onAddFriend error " + paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arwh
 * JD-Core Version:    0.7.0.1
 */