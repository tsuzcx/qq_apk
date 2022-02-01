import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class bejy
  extends anvi
{
  bejy(bejv parambejv) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    QLog.i("TogetherControlManager", 1, "onUpdateDelFriend isSuccess: " + paramBoolean + " object: " + paramObject);
    if (paramBoolean)
    {
      Iterator localIterator = bejv.a(this.a).entrySet().iterator();
      while (localIterator.hasNext()) {
        ((bekg)((Map.Entry)localIterator.next()).getValue()).a(paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bejy
 * JD-Core Version:    0.7.0.1
 */