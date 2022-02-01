import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class aqhv
  extends QQLruCache<Integer, aqhi>
{
  public aqhv(BubbleManager paramBubbleManager, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public void a()
  {
    Map localMap = snapshot();
    if (localMap != null)
    {
      Iterator localIterator = localMap.values().iterator();
      while (localIterator.hasNext()) {
        ((aqhi)localIterator.next()).a();
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleManager", 2, "BubbleInfoLruCache cleared, size = " + localMap.size());
      }
    }
  }
  
  protected void a(boolean paramBoolean, Integer paramInteger, aqhi paramaqhi1, aqhi paramaqhi2)
  {
    super.entryRemoved(paramBoolean, paramInteger, paramaqhi1, paramaqhi2);
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 2, "entryRemoved key=" + paramInteger);
    }
    paramaqhi1.a();
  }
  
  public boolean a(int paramInt)
  {
    return get(Integer.valueOf(paramInt)) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqhv
 * JD-Core Version:    0.7.0.1
 */