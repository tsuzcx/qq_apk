import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class assk
  extends aqkl
{
  private assk(assg paramassg) {}
  
  protected void a(boolean paramBoolean, long paramLong, ArrayList<Long> paramArrayList)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("onGetIntimateGroupRecommendUinList ").append(paramBoolean).append(" ").append(paramLong).append(" ");
      if (paramArrayList == null) {
        break label200;
      }
      ??? = paramArrayList.toString();
    }
    for (;;)
    {
      QLog.d("MultiCardManager", 2, (String)???);
      if ((paramLong == assg.a(this.a)) && (assg.d(this.a) != null)) {
        if (paramArrayList != null) {
          synchronized (assg.a(this.a))
          {
            assg.a(this.a).put(Long.valueOf(paramLong), (ArrayList)paramArrayList.clone());
          }
        }
      }
      synchronized (assg.d(this.a))
      {
        localObject2 = (WeakReference)assg.d(this.a).get(Long.valueOf(paramLong));
        if (localObject2 != null)
        {
          ??? = (assj)((WeakReference)localObject2).get();
          if (??? != null)
          {
            if (paramBoolean) {
              break;
            }
            assg.a(this.a, paramLong, (assj)???);
          }
        }
        return;
        label200:
        ??? = "null";
        continue;
        paramArrayList = finally;
        throw paramArrayList;
      }
    }
    ((assj)???).a(paramLong, paramArrayList);
  }
  
  protected void a(boolean paramBoolean, HashMap<Long, IntimateInfo> paramHashMap, Object arg3)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder().append("onGetGroupIntimateInfos ").append(paramBoolean).append(" ");
      if (paramHashMap == null) {
        break label284;
      }
    }
    long l1;
    label284:
    for (paramHashMap = paramHashMap.size() + paramHashMap.toString();; paramHashMap = "null")
    {
      QLog.d("MultiCardManager", 2, paramHashMap);
      paramHashMap = new ArrayList(0);
      if (!(??? instanceof HashMap)) {
        break label393;
      }
      Object localObject2 = (HashMap)???;
      ??? = (ArrayList)((HashMap)localObject2).get("alreadyRequest");
      ??? = (ArrayList)((HashMap)localObject2).get("notRequest");
      localObject2 = (ArrayList)((HashMap)localObject2).get("groupUin");
      if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0)) {
        break label387;
      }
      l1 = ((Long)((ArrayList)localObject2).get(0)).longValue();
      if (??? != null) {
        paramHashMap.addAll((Collection)???);
      }
      l2 = l1;
      if (??? == null) {
        break label297;
      }
      paramHashMap.addAll(???);
      l2 = l1;
      if (paramBoolean) {
        break label297;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiCardManager", 2, "onGetGroupIntimateInfos false remove sendRequest  " + ???.toString());
      }
      synchronized (assg.e(this.a))
      {
        ??? = ???.iterator();
        if (!???.hasNext()) {
          break;
        }
        localObject2 = (Long)???.next();
        assg.e(this.a).remove(localObject2);
      }
    }
    label387:
    label393:
    for (long l2 = l1;; l2 = 0L)
    {
      label297:
      if ((l2 == assg.a(this.a)) && (assg.f(this.a) != null)) {}
      synchronized (assg.f(this.a))
      {
        ??? = (WeakReference)assg.f(this.a).get(Long.valueOf(l2));
        if (??? != null)
        {
          ??? = (assh)((WeakReference)???).get();
          if (??? != null) {
            assg.a(this.a, l2, paramHashMap, ???);
          }
        }
        return;
      }
      l1 = 0L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     assk
 * JD-Core Version:    0.7.0.1
 */