import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

class aune
  implements aums
{
  aune(auna paramauna) {}
  
  public void a(List<aunm> paramList)
  {
    if (auna.a(this.a) == null) {}
    do
    {
      return;
      Object localObject = new HashMap(auna.a(this.a).getAVNotifyCenter().d);
      amyp localamyp = auna.a(this.a).getGAudioHandler();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        aunm localaunm = (aunm)paramList.next();
        long[] arrayOfLong = new long[localaunm.jdField_a_of_type_JavaUtilList.size()];
        int i = 0;
        while (i < arrayOfLong.length)
        {
          arrayOfLong[i] = ((Long)localaunm.jdField_a_of_type_JavaUtilList.get(i)).longValue();
          i += 1;
        }
        ((bfee)auna.a(this.a).getManager(164)).a(localaunm.jdField_a_of_type_Long);
        localamyp.a(1, String.valueOf(localaunm.jdField_a_of_type_Long), localaunm.jdField_a_of_type_Int, arrayOfLong, 14, localaunm.c, localaunm.d, localaunm.e);
        ((Map)localObject).remove(String.valueOf(localaunm.jdField_a_of_type_Long));
      }
      paramList = ((Map)localObject).entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject = (Map.Entry)paramList.next();
        if (((Integer)((Map.Entry)localObject).getValue()).intValue() == 14) {
          localamyp.a(1, (String)((Map.Entry)localObject).getKey(), 0, null, 14, 0, 0, -1);
        }
      }
      paramList = auna.a(this.a).getHandler(Conversation.class);
    } while (paramList == null);
    paramList.sendEmptyMessage(1009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aune
 * JD-Core Version:    0.7.0.1
 */