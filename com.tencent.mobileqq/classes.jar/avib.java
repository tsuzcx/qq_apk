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

class avib
  implements avhp
{
  avib(avhx paramavhx) {}
  
  public void a(List<avij> paramList)
  {
    if (avhx.a(this.a) == null) {}
    do
    {
      return;
      Object localObject = new HashMap(avhx.a(this.a).a().d);
      ansp localansp = avhx.a(this.a).a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        avij localavij = (avij)paramList.next();
        long[] arrayOfLong = new long[localavij.jdField_a_of_type_JavaUtilList.size()];
        int i = 0;
        while (i < arrayOfLong.length)
        {
          arrayOfLong[i] = ((Long)localavij.jdField_a_of_type_JavaUtilList.get(i)).longValue();
          i += 1;
        }
        ((bfus)avhx.a(this.a).getManager(164)).a(localavij.jdField_a_of_type_Long);
        localansp.a(1, String.valueOf(localavij.jdField_a_of_type_Long), localavij.jdField_a_of_type_Int, arrayOfLong, 14, localavij.c, localavij.d, localavij.e);
        ((Map)localObject).remove(String.valueOf(localavij.jdField_a_of_type_Long));
      }
      paramList = ((Map)localObject).entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject = (Map.Entry)paramList.next();
        if (((Integer)((Map.Entry)localObject).getValue()).intValue() == 14) {
          localansp.a(1, (String)((Map.Entry)localObject).getKey(), 0, null, 14, 0, 0, -1);
        }
      }
      paramList = avhx.a(this.a).getHandler(Conversation.class);
    } while (paramList == null);
    paramList.sendEmptyMessage(1009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avib
 * JD-Core Version:    0.7.0.1
 */