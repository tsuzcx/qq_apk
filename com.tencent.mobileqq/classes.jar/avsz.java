import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

class avsz
  implements avsn
{
  avsz(avsv paramavsv) {}
  
  public void a(List<avth> paramList)
  {
    if (avsv.a(this.a) == null) {}
    do
    {
      return;
      Object localObject = new HashMap(avsv.a(this.a).getAVNotifyCenter().d);
      aobd localaobd = avsv.a(this.a).getGAudioHandler();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        avth localavth = (avth)paramList.next();
        long[] arrayOfLong = new long[localavth.jdField_a_of_type_JavaUtilList.size()];
        int i = 0;
        while (i < arrayOfLong.length)
        {
          arrayOfLong[i] = ((Long)localavth.jdField_a_of_type_JavaUtilList.get(i)).longValue();
          i += 1;
        }
        ((bgmk)avsv.a(this.a).getManager(QQManagerFactory.TROOP_VIDEO_MANAGER)).a(localavth.jdField_a_of_type_Long);
        localaobd.a(1, String.valueOf(localavth.jdField_a_of_type_Long), localavth.jdField_a_of_type_Int, arrayOfLong, 14, localavth.c, localavth.d, localavth.e);
        ((Map)localObject).remove(String.valueOf(localavth.jdField_a_of_type_Long));
      }
      paramList = ((Map)localObject).entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject = (Map.Entry)paramList.next();
        if (((Integer)((Map.Entry)localObject).getValue()).intValue() == 14) {
          localaobd.a(1, (String)((Map.Entry)localObject).getKey(), 0, null, 14, 0, 0, -1);
        }
      }
      paramList = avsv.a(this.a).getHandler(Conversation.class);
    } while (paramList == null);
    paramList.sendEmptyMessage(1009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avsz
 * JD-Core Version:    0.7.0.1
 */