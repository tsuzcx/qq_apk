import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.OneUinHeadInfo;

public class apbh
{
  public int a;
  public long a;
  public ArrayList<apbi> a;
  public long b;
  
  public static apbh a(oidb_0x74b.OneUinHeadInfo paramOneUinHeadInfo)
  {
    Object localObject;
    if (paramOneUinHeadInfo == null) {
      localObject = null;
    }
    apbh localapbh;
    do
    {
      return localObject;
      localapbh = new apbh();
      if (paramOneUinHeadInfo.uint64_uin.has()) {
        localapbh.jdField_a_of_type_Long = paramOneUinHeadInfo.uint64_uin.get();
      }
      if (paramOneUinHeadInfo.uint64_tinyid.has()) {
        localapbh.b = paramOneUinHeadInfo.uint64_tinyid.get();
      }
      localapbh.jdField_a_of_type_Int = ((int)(System.currentTimeMillis() / 1000L));
      localObject = localapbh;
    } while (!paramOneUinHeadInfo.rpt_msg_head_list.has());
    localapbh.jdField_a_of_type_JavaUtilArrayList = apbi.a(paramOneUinHeadInfo.rpt_msg_head_list.get());
    return localapbh;
  }
  
  public static ArrayList<apbh> a(List<oidb_0x74b.OneUinHeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      apbh localapbh = a((oidb_0x74b.OneUinHeadInfo)paramList.next());
      if (localapbh != null) {
        localArrayList.add(localapbh);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbh
 * JD-Core Version:    0.7.0.1
 */