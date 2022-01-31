import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.OneUinHeadInfo;

public class anub
{
  public int a;
  public long a;
  public ArrayList<anuc> a;
  public long b;
  
  public static anub a(oidb_0x74b.OneUinHeadInfo paramOneUinHeadInfo)
  {
    Object localObject;
    if (paramOneUinHeadInfo == null) {
      localObject = null;
    }
    anub localanub;
    do
    {
      return localObject;
      localanub = new anub();
      if (paramOneUinHeadInfo.uint64_uin.has()) {
        localanub.jdField_a_of_type_Long = paramOneUinHeadInfo.uint64_uin.get();
      }
      if (paramOneUinHeadInfo.uint64_tinyid.has()) {
        localanub.b = paramOneUinHeadInfo.uint64_tinyid.get();
      }
      localanub.jdField_a_of_type_Int = ((int)(System.currentTimeMillis() / 1000L));
      localObject = localanub;
    } while (!paramOneUinHeadInfo.rpt_msg_head_list.has());
    localanub.jdField_a_of_type_JavaUtilArrayList = anuc.a(paramOneUinHeadInfo.rpt_msg_head_list.get());
    return localanub;
  }
  
  public static ArrayList<anub> a(List<oidb_0x74b.OneUinHeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      anub localanub = a((oidb_0x74b.OneUinHeadInfo)paramList.next());
      if (localanub != null) {
        localArrayList.add(localanub);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anub
 * JD-Core Version:    0.7.0.1
 */