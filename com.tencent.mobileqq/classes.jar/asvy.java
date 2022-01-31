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

class asvy
  implements asvm
{
  asvy(asvu paramasvu) {}
  
  public void a(List<aswg> paramList)
  {
    if (asvu.a(this.a) == null) {}
    do
    {
      return;
      Object localObject = new HashMap(asvu.a(this.a).a().d);
      alvt localalvt = asvu.a(this.a).a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        aswg localaswg = (aswg)paramList.next();
        long[] arrayOfLong = new long[localaswg.jdField_a_of_type_JavaUtilList.size()];
        int i = 0;
        while (i < arrayOfLong.length)
        {
          arrayOfLong[i] = ((Long)localaswg.jdField_a_of_type_JavaUtilList.get(i)).longValue();
          i += 1;
        }
        ((bclr)asvu.a(this.a).getManager(164)).a(localaswg.jdField_a_of_type_Long);
        localalvt.a(1, String.valueOf(localaswg.jdField_a_of_type_Long), localaswg.jdField_a_of_type_Int, arrayOfLong, 14, localaswg.c, localaswg.d, localaswg.e);
        ((Map)localObject).remove(String.valueOf(localaswg.jdField_a_of_type_Long));
      }
      paramList = ((Map)localObject).entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject = (Map.Entry)paramList.next();
        if (((Integer)((Map.Entry)localObject).getValue()).intValue() == 14) {
          localalvt.a(1, (String)((Map.Entry)localObject).getKey(), 0, null, 14, 0, 0, -1);
        }
      }
      paramList = asvu.a(this.a).getHandler(Conversation.class);
    } while (paramList == null);
    paramList.sendEmptyMessage(1009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvy
 * JD-Core Version:    0.7.0.1
 */