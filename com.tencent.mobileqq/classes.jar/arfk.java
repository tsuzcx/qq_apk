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

class arfk
  implements arey
{
  arfk(arfg paramarfg) {}
  
  public void a(List<arfs> paramList)
  {
    if (arfg.a(this.a) == null) {}
    do
    {
      return;
      Object localObject = new HashMap(arfg.a(this.a).a().d);
      akee localakee = arfg.a(this.a).a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        arfs localarfs = (arfs)paramList.next();
        long[] arrayOfLong = new long[localarfs.jdField_a_of_type_JavaUtilList.size()];
        int i = 0;
        while (i < arrayOfLong.length)
        {
          arrayOfLong[i] = ((Long)localarfs.jdField_a_of_type_JavaUtilList.get(i)).longValue();
          i += 1;
        }
        ((bane)arfg.a(this.a).getManager(164)).a(localarfs.jdField_a_of_type_Long);
        localakee.a(1, String.valueOf(localarfs.jdField_a_of_type_Long), localarfs.jdField_a_of_type_Int, arrayOfLong, 14, localarfs.c, localarfs.d);
        ((Map)localObject).remove(String.valueOf(localarfs.jdField_a_of_type_Long));
      }
      paramList = ((Map)localObject).entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject = (Map.Entry)paramList.next();
        if (((Integer)((Map.Entry)localObject).getValue()).intValue() == 14) {
          localakee.a(1, (String)((Map.Entry)localObject).getKey(), 0, null, 14, 0, 0);
        }
      }
      paramList = arfg.a(this.a).getHandler(Conversation.class);
    } while (paramList == null);
    paramList.sendEmptyMessage(1009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arfk
 * JD-Core Version:    0.7.0.1
 */