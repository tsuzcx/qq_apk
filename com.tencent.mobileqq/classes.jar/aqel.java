import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.OneUinHeadInfo;

public class aqel
{
  public int a;
  public long a;
  public ArrayList<aqem> a;
  public long b;
  
  public static aqel a(oidb_0x74b.OneUinHeadInfo paramOneUinHeadInfo)
  {
    Object localObject;
    if (paramOneUinHeadInfo == null) {
      localObject = null;
    }
    aqel localaqel;
    do
    {
      return localObject;
      localaqel = new aqel();
      if (paramOneUinHeadInfo.uint64_uin.has()) {
        localaqel.jdField_a_of_type_Long = paramOneUinHeadInfo.uint64_uin.get();
      }
      if (paramOneUinHeadInfo.uint64_tinyid.has()) {
        localaqel.b = paramOneUinHeadInfo.uint64_tinyid.get();
      }
      localaqel.jdField_a_of_type_Int = ((int)(System.currentTimeMillis() / 1000L));
      localObject = localaqel;
    } while (!paramOneUinHeadInfo.rpt_msg_head_list.has());
    localaqel.jdField_a_of_type_JavaUtilArrayList = aqem.a(paramOneUinHeadInfo.rpt_msg_head_list.get());
    return localaqel;
  }
  
  public static ArrayList<aqel> a(List<oidb_0x74b.OneUinHeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aqel localaqel = a((oidb_0x74b.OneUinHeadInfo)paramList.next());
      if (localaqel != null) {
        localArrayList.add(localaqel);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqel
 * JD-Core Version:    0.7.0.1
 */