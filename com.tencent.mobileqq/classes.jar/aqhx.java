import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.HeadInfo;

public class aqhx
{
  public int a;
  public String a;
  public ArrayList<aqhy> a;
  public int b;
  public int c;
  public int d;
  
  public static aqhx a(oidb_0x74b.HeadInfo paramHeadInfo)
  {
    Object localObject;
    if (paramHeadInfo == null) {
      localObject = null;
    }
    aqhx localaqhx;
    do
    {
      return localObject;
      localaqhx = new aqhx();
      if (paramHeadInfo.uint32_id.has()) {
        localaqhx.jdField_a_of_type_Int = paramHeadInfo.uint32_id.get();
      }
      if (paramHeadInfo.str_photohead.has()) {
        localaqhx.jdField_a_of_type_JavaLangString = paramHeadInfo.str_photohead.get();
      }
      if (paramHeadInfo.uint32_invalid.has()) {
        localaqhx.b = paramHeadInfo.uint32_invalid.get();
      }
      if (paramHeadInfo.uint32_timestamp.has()) {
        localaqhx.c = paramHeadInfo.uint32_timestamp.get();
      }
      if (paramHeadInfo.uint32_type.has()) {
        localaqhx.d = paramHeadInfo.uint32_type.get();
      }
      localObject = localaqhx;
    } while (!paramHeadInfo.rpt_videoheadlist.has());
    localaqhx.jdField_a_of_type_JavaUtilArrayList = aqhy.a(paramHeadInfo.rpt_videoheadlist.get());
    return localaqhx;
  }
  
  public static ArrayList<aqhx> a(List<oidb_0x74b.HeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aqhx localaqhx = a((oidb_0x74b.HeadInfo)paramList.next());
      if (localaqhx != null) {
        localArrayList.add(localaqhx);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqhx
 * JD-Core Version:    0.7.0.1
 */