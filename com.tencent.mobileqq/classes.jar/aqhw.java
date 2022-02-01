import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.OneUinHeadInfo;

public class aqhw
{
  public int a;
  public long a;
  public ArrayList<aqhx> a;
  public long b;
  
  public static aqhw a(oidb_0x74b.OneUinHeadInfo paramOneUinHeadInfo)
  {
    Object localObject;
    if (paramOneUinHeadInfo == null) {
      localObject = null;
    }
    aqhw localaqhw;
    do
    {
      return localObject;
      localaqhw = new aqhw();
      if (paramOneUinHeadInfo.uint64_uin.has()) {
        localaqhw.jdField_a_of_type_Long = paramOneUinHeadInfo.uint64_uin.get();
      }
      if (paramOneUinHeadInfo.uint64_tinyid.has()) {
        localaqhw.b = paramOneUinHeadInfo.uint64_tinyid.get();
      }
      localaqhw.jdField_a_of_type_Int = ((int)(System.currentTimeMillis() / 1000L));
      localObject = localaqhw;
    } while (!paramOneUinHeadInfo.rpt_msg_head_list.has());
    localaqhw.jdField_a_of_type_JavaUtilArrayList = aqhx.a(paramOneUinHeadInfo.rpt_msg_head_list.get());
    return localaqhw;
  }
  
  public static ArrayList<aqhw> a(List<oidb_0x74b.OneUinHeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aqhw localaqhw = a((oidb_0x74b.OneUinHeadInfo)paramList.next());
      if (localaqhw != null) {
        localArrayList.add(localaqhw);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqhw
 * JD-Core Version:    0.7.0.1
 */