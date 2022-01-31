import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.HeadInfo;

public class anuc
{
  public int a;
  public String a;
  public ArrayList<anud> a;
  public int b;
  public int c;
  public int d;
  
  public static anuc a(oidb_0x74b.HeadInfo paramHeadInfo)
  {
    Object localObject;
    if (paramHeadInfo == null) {
      localObject = null;
    }
    anuc localanuc;
    do
    {
      return localObject;
      localanuc = new anuc();
      if (paramHeadInfo.uint32_id.has()) {
        localanuc.jdField_a_of_type_Int = paramHeadInfo.uint32_id.get();
      }
      if (paramHeadInfo.str_photohead.has()) {
        localanuc.jdField_a_of_type_JavaLangString = paramHeadInfo.str_photohead.get();
      }
      if (paramHeadInfo.uint32_invalid.has()) {
        localanuc.b = paramHeadInfo.uint32_invalid.get();
      }
      if (paramHeadInfo.uint32_timestamp.has()) {
        localanuc.c = paramHeadInfo.uint32_timestamp.get();
      }
      if (paramHeadInfo.uint32_type.has()) {
        localanuc.d = paramHeadInfo.uint32_type.get();
      }
      localObject = localanuc;
    } while (!paramHeadInfo.rpt_videoheadlist.has());
    localanuc.jdField_a_of_type_JavaUtilArrayList = anud.a(paramHeadInfo.rpt_videoheadlist.get());
    return localanuc;
  }
  
  public static ArrayList<anuc> a(List<oidb_0x74b.HeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      anuc localanuc = a((oidb_0x74b.HeadInfo)paramList.next());
      if (localanuc != null) {
        localArrayList.add(localanuc);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anuc
 * JD-Core Version:    0.7.0.1
 */