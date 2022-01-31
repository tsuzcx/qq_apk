import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class bapj
  extends ameq
{
  bapj(baph parambaph) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlManager", 2, "onTroopManagerSuccess,reqType=" + paramInt1 + ", result=" + paramInt2 + ", troopUin=" + paramString);
    }
    if ((paramInt2 == 0) && ((paramInt1 == 9) || (paramInt1 == 2)))
    {
      Iterator localIterator = baph.a(this.a).entrySet().iterator();
      while (localIterator.hasNext()) {
        ((baps)((Map.Entry)localIterator.next()).getValue()).a(paramInt1, paramInt2, paramString);
      }
    }
  }
  
  protected void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlManager", 2, "onPassiveExit, troopUin=" + paramString + ", reason=" + paramInt);
    }
    Iterator localIterator = baph.a(this.a).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((baps)((Map.Entry)localIterator.next()).getValue()).a(paramString, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapj
 * JD-Core Version:    0.7.0.1
 */