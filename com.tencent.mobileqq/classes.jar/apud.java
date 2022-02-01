import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class apud
  implements bdvw
{
  apud(apuc paramapuc) {}
  
  public void onResp(bdwt arg1)
  {
    Object localObject1;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("onResp reqUrl: resp is null: ");
      if (??? == null)
      {
        bool = true;
        QLog.i("Q.dynamicAvatar", 2, bool);
      }
    }
    else
    {
      if (??? != null) {
        break label51;
      }
    }
    label51:
    do
    {
      return;
      bool = false;
      break;
      localObject1 = ((bdvs)???.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString;
      int i = ???.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "onResp reqUrl: " + (String)localObject1 + " mResult: " + i + ",httpCode:" + ???.c + ",errDesc:" + ???.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        synchronized (apuc.a(this.a))
        {
          if (apuc.a(this.a).isEmpty()) {
            break;
          }
          Iterator localIterator = apuc.a(this.a).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject3 = (WeakReference)localIterator.next();
          if ((localObject3 == null) || (((WeakReference)localObject3).get() == null)) {
            continue;
          }
          localObject3 = (apue)((WeakReference)localObject3).get();
          if (i == 0)
          {
            bool = true;
            ((apue)localObject3).a((String)localObject1, bool, false);
          }
        }
        bool = false;
      }
      apuc.a(this.a).remove(localObject2);
    } while ((!bgnt.g(BaseApplicationImpl.getContext())) || (bgnt.h(BaseApplicationImpl.getContext())));
    apuc.a(this.a);
  }
  
  public void onUpdateProgeress(bdws arg1, long paramLong1, long paramLong2)
  {
    if ((!apuc.a(this.a).isEmpty()) && ((??? instanceof bdvs))) {
      if (paramLong2 <= 0L) {
        break label148;
      }
    }
    label148:
    for (int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);; i = 0)
    {
      String str = ((bdvs)???).jdField_a_of_type_JavaLangString;
      synchronized (apuc.a(this.a))
      {
        if (!apuc.a(this.a).isEmpty())
        {
          Iterator localIterator = apuc.a(this.a).iterator();
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((apue)localWeakReference.get()).a(str, i);
            }
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apud
 * JD-Core Version:    0.7.0.1
 */