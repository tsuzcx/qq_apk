import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Set;

class aqps
  extends ajjh
{
  aqps(aqpq paramaqpq) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    QLog.i("FetchOpenIdManager", 1, "onUpdateDelFriend isSuccess: " + paramBoolean + " object: " + paramObject);
    if ((paramBoolean) && (paramObject != null))
    {
      long l = ((Long)paramObject).longValue();
      paramObject = aqpq.a(this.a).keySet().toArray();
      int i = paramObject.length - 1;
      while (i >= 0)
      {
        Long localLong = (Long)paramObject[i];
        this.a.a(localLong.longValue(), l);
        i -= 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqps
 * JD-Core Version:    0.7.0.1
 */