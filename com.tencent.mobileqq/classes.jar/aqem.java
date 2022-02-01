import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.HeadInfo;

public class aqem
{
  public int a;
  public String a;
  public ArrayList<aqen> a;
  public int b;
  public int c;
  public int d;
  
  public static aqem a(oidb_0x74b.HeadInfo paramHeadInfo)
  {
    Object localObject;
    if (paramHeadInfo == null) {
      localObject = null;
    }
    aqem localaqem;
    do
    {
      return localObject;
      localaqem = new aqem();
      if (paramHeadInfo.uint32_id.has()) {
        localaqem.jdField_a_of_type_Int = paramHeadInfo.uint32_id.get();
      }
      if (paramHeadInfo.str_photohead.has()) {
        localaqem.jdField_a_of_type_JavaLangString = paramHeadInfo.str_photohead.get();
      }
      if (paramHeadInfo.uint32_invalid.has()) {
        localaqem.b = paramHeadInfo.uint32_invalid.get();
      }
      if (paramHeadInfo.uint32_timestamp.has()) {
        localaqem.c = paramHeadInfo.uint32_timestamp.get();
      }
      if (paramHeadInfo.uint32_type.has()) {
        localaqem.d = paramHeadInfo.uint32_type.get();
      }
      localObject = localaqem;
    } while (!paramHeadInfo.rpt_videoheadlist.has());
    localaqem.jdField_a_of_type_JavaUtilArrayList = aqen.a(paramHeadInfo.rpt_videoheadlist.get());
    return localaqem;
  }
  
  public static ArrayList<aqem> a(List<oidb_0x74b.HeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aqem localaqem = a((oidb_0x74b.HeadInfo)paramList.next());
      if (localaqem != null) {
        localArrayList.add(localaqem);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqem
 * JD-Core Version:    0.7.0.1
 */