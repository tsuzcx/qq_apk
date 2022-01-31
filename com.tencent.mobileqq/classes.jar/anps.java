import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.OneUinHeadInfo;

public class anps
{
  public int a;
  public long a;
  public ArrayList<anpt> a;
  public long b;
  
  public static anps a(oidb_0x74b.OneUinHeadInfo paramOneUinHeadInfo)
  {
    Object localObject;
    if (paramOneUinHeadInfo == null) {
      localObject = null;
    }
    anps localanps;
    do
    {
      return localObject;
      localanps = new anps();
      if (paramOneUinHeadInfo.uint64_uin.has()) {
        localanps.jdField_a_of_type_Long = paramOneUinHeadInfo.uint64_uin.get();
      }
      if (paramOneUinHeadInfo.uint64_tinyid.has()) {
        localanps.b = paramOneUinHeadInfo.uint64_tinyid.get();
      }
      localanps.jdField_a_of_type_Int = ((int)(System.currentTimeMillis() / 1000L));
      localObject = localanps;
    } while (!paramOneUinHeadInfo.rpt_msg_head_list.has());
    localanps.jdField_a_of_type_JavaUtilArrayList = anpt.a(paramOneUinHeadInfo.rpt_msg_head_list.get());
    return localanps;
  }
  
  public static ArrayList<anps> a(List<oidb_0x74b.OneUinHeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      anps localanps = a((oidb_0x74b.OneUinHeadInfo)paramList.next());
      if (localanps != null) {
        localArrayList.add(localanps);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anps
 * JD-Core Version:    0.7.0.1
 */