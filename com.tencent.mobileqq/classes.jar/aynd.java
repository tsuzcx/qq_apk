import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class aynd
  extends ajxl
{
  aynd(ayna paramayna) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    QLog.i("TogetherControlManager", 1, "onUpdateDelFriend isSuccess: " + paramBoolean + " object: " + paramObject);
    if (paramBoolean)
    {
      Iterator localIterator = ayna.a(this.a).entrySet().iterator();
      while (localIterator.hasNext()) {
        ((aynl)((Map.Entry)localIterator.next()).getValue()).a(paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aynd
 * JD-Core Version:    0.7.0.1
 */