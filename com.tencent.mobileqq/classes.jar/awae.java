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

class awae
  implements avzs
{
  awae(awaa paramawaa) {}
  
  public void a(List<awam> paramList)
  {
    if (awaa.a(this.a) == null) {}
    do
    {
      return;
      Object localObject = new HashMap(awaa.a(this.a).a().d);
      aoex localaoex = awaa.a(this.a).a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        awam localawam = (awam)paramList.next();
        long[] arrayOfLong = new long[localawam.jdField_a_of_type_JavaUtilList.size()];
        int i = 0;
        while (i < arrayOfLong.length)
        {
          arrayOfLong[i] = ((Long)localawam.jdField_a_of_type_JavaUtilList.get(i)).longValue();
          i += 1;
        }
        ((bgut)awaa.a(this.a).getManager(164)).a(localawam.jdField_a_of_type_Long);
        localaoex.a(1, String.valueOf(localawam.jdField_a_of_type_Long), localawam.jdField_a_of_type_Int, arrayOfLong, 14, localawam.c, localawam.d, localawam.e);
        ((Map)localObject).remove(String.valueOf(localawam.jdField_a_of_type_Long));
      }
      paramList = ((Map)localObject).entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject = (Map.Entry)paramList.next();
        if (((Integer)((Map.Entry)localObject).getValue()).intValue() == 14) {
          localaoex.a(1, (String)((Map.Entry)localObject).getKey(), 0, null, 14, 0, 0, -1);
        }
      }
      paramList = awaa.a(this.a).getHandler(Conversation.class);
    } while (paramList == null);
    paramList.sendEmptyMessage(1009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awae
 * JD-Core Version:    0.7.0.1
 */