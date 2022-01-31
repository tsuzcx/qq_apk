import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Set;

class atew
  extends altm
{
  atew(ateu paramateu) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    QLog.i("FetchOpenIdManager", 1, "onUpdateDelFriend isSuccess: " + paramBoolean + " object: " + paramObject);
    if ((paramBoolean) && (paramObject != null))
    {
      long l = ((Long)paramObject).longValue();
      paramObject = ateu.a(this.a).keySet().toArray();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atew
 * JD-Core Version:    0.7.0.1
 */