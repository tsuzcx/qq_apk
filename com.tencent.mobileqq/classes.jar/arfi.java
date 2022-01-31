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

class arfi
  implements arew
{
  arfi(arfe paramarfe) {}
  
  public void a(List<arfq> paramList)
  {
    if (arfe.a(this.a) == null) {}
    do
    {
      return;
      Object localObject = new HashMap(arfe.a(this.a).a().d);
      akef localakef = arfe.a(this.a).a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        arfq localarfq = (arfq)paramList.next();
        long[] arrayOfLong = new long[localarfq.jdField_a_of_type_JavaUtilList.size()];
        int i = 0;
        while (i < arrayOfLong.length)
        {
          arrayOfLong[i] = ((Long)localarfq.jdField_a_of_type_JavaUtilList.get(i)).longValue();
          i += 1;
        }
        ((bamq)arfe.a(this.a).getManager(164)).a(localarfq.jdField_a_of_type_Long);
        localakef.a(1, String.valueOf(localarfq.jdField_a_of_type_Long), localarfq.jdField_a_of_type_Int, arrayOfLong, 14, localarfq.c, localarfq.d);
        ((Map)localObject).remove(String.valueOf(localarfq.jdField_a_of_type_Long));
      }
      paramList = ((Map)localObject).entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject = (Map.Entry)paramList.next();
        if (((Integer)((Map.Entry)localObject).getValue()).intValue() == 14) {
          localakef.a(1, (String)((Map.Entry)localObject).getKey(), 0, null, 14, 0, 0);
        }
      }
      paramList = arfe.a(this.a).getHandler(Conversation.class);
    } while (paramList == null);
    paramList.sendEmptyMessage(1009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arfi
 * JD-Core Version:    0.7.0.1
 */