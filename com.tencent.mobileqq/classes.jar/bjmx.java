import com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner;
import com.tencent.tmdatasourcesdk.internal.protocol.jce.AppSimpleDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

final class bjmx
  implements ITMAssistantExchangeURLListenner
{
  public void onExchangedURLSucceed(ArrayList arg1, boolean paramBoolean)
  {
    bjko.b(bjmu.jdField_a_of_type_JavaLangString, "onExchangedURLSucceed --- ");
    if ((paramBoolean) && (??? != null) && (???.size() > 0))
    {
      ??? = ???.iterator();
      while (???.hasNext())
      {
        Object localObject1 = ???.next();
        if ((localObject1 instanceof AppSimpleDetail))
        {
          int i = ((AppSimpleDetail)localObject1).versionCode;
          if (i > 0) {
            bjmu.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((AppSimpleDetail)localObject1).packageName, Integer.valueOf(i));
          }
        }
      }
    }
    synchronized (bjmu.jdField_a_of_type_JavaLangObject)
    {
      bjmu.jdField_a_of_type_JavaLangObject.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjmx
 * JD-Core Version:    0.7.0.1
 */