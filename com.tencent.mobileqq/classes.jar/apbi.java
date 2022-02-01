import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.HeadInfo;

public class apbi
{
  public int a;
  public String a;
  public ArrayList<apbj> a;
  public int b;
  public int c;
  public int d;
  
  public static apbi a(oidb_0x74b.HeadInfo paramHeadInfo)
  {
    Object localObject;
    if (paramHeadInfo == null) {
      localObject = null;
    }
    apbi localapbi;
    do
    {
      return localObject;
      localapbi = new apbi();
      if (paramHeadInfo.uint32_id.has()) {
        localapbi.jdField_a_of_type_Int = paramHeadInfo.uint32_id.get();
      }
      if (paramHeadInfo.str_photohead.has()) {
        localapbi.jdField_a_of_type_JavaLangString = paramHeadInfo.str_photohead.get();
      }
      if (paramHeadInfo.uint32_invalid.has()) {
        localapbi.b = paramHeadInfo.uint32_invalid.get();
      }
      if (paramHeadInfo.uint32_timestamp.has()) {
        localapbi.c = paramHeadInfo.uint32_timestamp.get();
      }
      if (paramHeadInfo.uint32_type.has()) {
        localapbi.d = paramHeadInfo.uint32_type.get();
      }
      localObject = localapbi;
    } while (!paramHeadInfo.rpt_videoheadlist.has());
    localapbi.jdField_a_of_type_JavaUtilArrayList = apbj.a(paramHeadInfo.rpt_videoheadlist.get());
    return localapbi;
  }
  
  public static ArrayList<apbi> a(List<oidb_0x74b.HeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      apbi localapbi = a((oidb_0x74b.HeadInfo)paramList.next());
      if (localapbi != null) {
        localArrayList.add(localapbi);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbi
 * JD-Core Version:    0.7.0.1
 */