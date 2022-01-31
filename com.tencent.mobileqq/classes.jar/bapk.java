import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class bapk
  extends altm
{
  bapk(baph parambaph) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    QLog.i("TogetherControlManager", 1, "onUpdateDelFriend isSuccess: " + paramBoolean + " object: " + paramObject);
    if (paramBoolean)
    {
      Iterator localIterator = baph.a(this.a).entrySet().iterator();
      while (localIterator.hasNext()) {
        ((baps)((Map.Entry)localIterator.next()).getValue()).a(paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapk
 * JD-Core Version:    0.7.0.1
 */