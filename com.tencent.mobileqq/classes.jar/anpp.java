import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class anpp
  implements bapx
{
  anpp(anpo paramanpo) {}
  
  public void onResp(baqw arg1)
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
      localObject1 = ((baps)???.jdField_a_of_type_Baqv).jdField_a_of_type_JavaLangString;
      int i = ???.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "onResp reqUrl: " + (String)localObject1 + " mResult: " + i + ",httpCode:" + ???.c + ",errDesc:" + ???.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        synchronized (anpo.a(this.a))
        {
          if (anpo.a(this.a).isEmpty()) {
            break;
          }
          Iterator localIterator = anpo.a(this.a).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject3 = (WeakReference)localIterator.next();
          if ((localObject3 == null) || (((WeakReference)localObject3).get() == null)) {
            continue;
          }
          localObject3 = (anpq)((WeakReference)localObject3).get();
          if (i == 0)
          {
            bool = true;
            ((anpq)localObject3).a((String)localObject1, bool, false);
          }
        }
        bool = false;
      }
      anpo.a(this.a).remove(localObject2);
    } while ((!bdee.g(BaseApplicationImpl.getContext())) || (bdee.h(BaseApplicationImpl.getContext())));
    anpo.a(this.a);
  }
  
  public void onUpdateProgeress(baqv arg1, long paramLong1, long paramLong2)
  {
    if ((!anpo.a(this.a).isEmpty()) && ((??? instanceof baps))) {
      if (paramLong2 <= 0L) {
        break label148;
      }
    }
    label148:
    for (int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);; i = 0)
    {
      String str = ((baps)???).jdField_a_of_type_JavaLangString;
      synchronized (anpo.a(this.a))
      {
        if (!anpo.a(this.a).isEmpty())
        {
          Iterator localIterator = anpo.a(this.a).iterator();
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((anpq)localWeakReference.get()).a(str, i);
            }
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpp
 * JD-Core Version:    0.7.0.1
 */