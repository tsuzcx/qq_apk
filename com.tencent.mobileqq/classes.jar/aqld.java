import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

class aqld
  implements aqkr
{
  aqld(aqkz paramaqkz) {}
  
  public void a(List<aqll> paramList)
  {
    if (aqkz.a(this.a) == null) {}
    do
    {
      return;
      Object localObject = new HashMap(aqkz.a(this.a).a().d);
      ajpv localajpv = aqkz.a(this.a).a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        aqll localaqll = (aqll)paramList.next();
        long[] arrayOfLong = new long[localaqll.jdField_a_of_type_JavaUtilList.size()];
        int i = 0;
        while (i < arrayOfLong.length)
        {
          arrayOfLong[i] = ((Long)localaqll.jdField_a_of_type_JavaUtilList.get(i)).longValue();
          i += 1;
        }
        ((azlm)aqkz.a(this.a).getManager(164)).a(localaqll.jdField_a_of_type_Long);
        localajpv.a(1, String.valueOf(localaqll.jdField_a_of_type_Long), localaqll.jdField_a_of_type_Int, arrayOfLong, 14);
        ((Map)localObject).remove(String.valueOf(localaqll.jdField_a_of_type_Long));
      }
      paramList = ((Map)localObject).entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject = (Map.Entry)paramList.next();
        if (((Integer)((Map.Entry)localObject).getValue()).intValue() == 14) {
          localajpv.a(1, (String)((Map.Entry)localObject).getKey(), 0, null, 14);
        }
      }
      paramList = aqkz.a(this.a).getHandler(Conversation.class);
    } while (paramList == null);
    paramList.sendEmptyMessage(1009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqld
 * JD-Core Version:    0.7.0.1
 */