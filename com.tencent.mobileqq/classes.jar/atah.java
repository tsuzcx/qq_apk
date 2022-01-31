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

class atah
  implements aszv
{
  atah(atad paramatad) {}
  
  public void a(List<atap> paramList)
  {
    if (atad.a(this.a) == null) {}
    do
    {
      return;
      Object localObject = new HashMap(atad.a(this.a).a().d);
      amai localamai = atad.a(this.a).a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        atap localatap = (atap)paramList.next();
        long[] arrayOfLong = new long[localatap.jdField_a_of_type_JavaUtilList.size()];
        int i = 0;
        while (i < arrayOfLong.length)
        {
          arrayOfLong[i] = ((Long)localatap.jdField_a_of_type_JavaUtilList.get(i)).longValue();
          i += 1;
        }
        ((bcqa)atad.a(this.a).getManager(164)).a(localatap.jdField_a_of_type_Long);
        localamai.a(1, String.valueOf(localatap.jdField_a_of_type_Long), localatap.jdField_a_of_type_Int, arrayOfLong, 14, localatap.c, localatap.d, localatap.e);
        ((Map)localObject).remove(String.valueOf(localatap.jdField_a_of_type_Long));
      }
      paramList = ((Map)localObject).entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject = (Map.Entry)paramList.next();
        if (((Integer)((Map.Entry)localObject).getValue()).intValue() == 14) {
          localamai.a(1, (String)((Map.Entry)localObject).getKey(), 0, null, 14, 0, 0, -1);
        }
      }
      paramList = atad.a(this.a).getHandler(Conversation.class);
    } while (paramList == null);
    paramList.sendEmptyMessage(1009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atah
 * JD-Core Version:    0.7.0.1
 */