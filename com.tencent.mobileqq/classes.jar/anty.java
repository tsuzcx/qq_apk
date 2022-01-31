import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class anty
  implements baug
{
  anty(antx paramantx) {}
  
  public void onResp(bavf arg1)
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
      localObject1 = ((baub)???.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString;
      int i = ???.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "onResp reqUrl: " + (String)localObject1 + " mResult: " + i + ",httpCode:" + ???.c + ",errDesc:" + ???.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        synchronized (antx.a(this.a))
        {
          if (antx.a(this.a).isEmpty()) {
            break;
          }
          Iterator localIterator = antx.a(this.a).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject3 = (WeakReference)localIterator.next();
          if ((localObject3 == null) || (((WeakReference)localObject3).get() == null)) {
            continue;
          }
          localObject3 = (antz)((WeakReference)localObject3).get();
          if (i == 0)
          {
            bool = true;
            ((antz)localObject3).a((String)localObject1, bool, false);
          }
        }
        bool = false;
      }
      antx.a(this.a).remove(localObject2);
    } while ((!bdin.g(BaseApplicationImpl.getContext())) || (bdin.h(BaseApplicationImpl.getContext())));
    antx.a(this.a);
  }
  
  public void onUpdateProgeress(bave arg1, long paramLong1, long paramLong2)
  {
    if ((!antx.a(this.a).isEmpty()) && ((??? instanceof baub))) {
      if (paramLong2 <= 0L) {
        break label148;
      }
    }
    label148:
    for (int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);; i = 0)
    {
      String str = ((baub)???).jdField_a_of_type_JavaLangString;
      synchronized (antx.a(this.a))
      {
        if (!antx.a(this.a).isEmpty())
        {
          Iterator localIterator = antx.a(this.a).iterator();
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((antz)localWeakReference.get()).a(str, i);
            }
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anty
 * JD-Core Version:    0.7.0.1
 */