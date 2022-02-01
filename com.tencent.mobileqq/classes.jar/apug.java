import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.OneUinHeadInfo;

public class apug
{
  public int a;
  public long a;
  public ArrayList<apuh> a;
  public long b;
  
  public static apug a(oidb_0x74b.OneUinHeadInfo paramOneUinHeadInfo)
  {
    Object localObject;
    if (paramOneUinHeadInfo == null) {
      localObject = null;
    }
    apug localapug;
    do
    {
      return localObject;
      localapug = new apug();
      if (paramOneUinHeadInfo.uint64_uin.has()) {
        localapug.jdField_a_of_type_Long = paramOneUinHeadInfo.uint64_uin.get();
      }
      if (paramOneUinHeadInfo.uint64_tinyid.has()) {
        localapug.b = paramOneUinHeadInfo.uint64_tinyid.get();
      }
      localapug.jdField_a_of_type_Int = ((int)(System.currentTimeMillis() / 1000L));
      localObject = localapug;
    } while (!paramOneUinHeadInfo.rpt_msg_head_list.has());
    localapug.jdField_a_of_type_JavaUtilArrayList = apuh.a(paramOneUinHeadInfo.rpt_msg_head_list.get());
    return localapug;
  }
  
  public static ArrayList<apug> a(List<oidb_0x74b.OneUinHeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      apug localapug = a((oidb_0x74b.OneUinHeadInfo)paramList.next());
      if (localapug != null) {
        localArrayList.add(localapug);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apug
 * JD-Core Version:    0.7.0.1
 */