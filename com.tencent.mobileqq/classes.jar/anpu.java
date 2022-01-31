import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.VideoHeadInfo;

public class anpu
{
  public int a;
  public String a;
  
  public static anpu a(oidb_0x74b.VideoHeadInfo paramVideoHeadInfo)
  {
    Object localObject;
    if (paramVideoHeadInfo == null) {
      localObject = null;
    }
    anpu localanpu;
    do
    {
      return localObject;
      localanpu = new anpu();
      if (paramVideoHeadInfo.str_url.has()) {
        localanpu.jdField_a_of_type_JavaLangString = paramVideoHeadInfo.str_url.get();
      }
      localObject = localanpu;
    } while (!paramVideoHeadInfo.uint32_video_size.has());
    localanpu.jdField_a_of_type_Int = paramVideoHeadInfo.uint32_video_size.get();
    return localanpu;
  }
  
  public static ArrayList<anpu> a(List<oidb_0x74b.VideoHeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      anpu localanpu = a((oidb_0x74b.VideoHeadInfo)paramList.next());
      if (localanpu != null) {
        localArrayList.add(localanpu);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpu
 * JD-Core Version:    0.7.0.1
 */