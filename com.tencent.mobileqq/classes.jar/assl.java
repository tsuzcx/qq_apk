import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class assl
  extends ajxl
{
  private assl(assg paramassg) {}
  
  protected void onAddFriend(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardManager", 2, "onAddFriend " + paramString);
    }
    ArrayList localArrayList;
    if ((!assg.a(this.a)) && (assg.a(this.a) != null))
    {
      localArrayList = (ArrayList)assg.a(this.a).get(Long.valueOf(assg.a(this.a)));
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
        localArrayList.add(Long.valueOf(assg.a(this.a)));
        HashMap localHashMap = new HashMap(5);
        localHashMap.put("notRequest", paramString);
        localHashMap.put("groupUin", localArrayList);
        ((aqkf)assg.a(this.a).a(153)).a(assg.a(this.a), paramString, localHashMap);
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
 * Qualified Name:     assl
 * JD-Core Version:    0.7.0.1
 */