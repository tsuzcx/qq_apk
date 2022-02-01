import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.VideoHeadInfo;

public class aqhy
{
  public int a;
  public String a;
  
  public static aqhy a(oidb_0x74b.VideoHeadInfo paramVideoHeadInfo)
  {
    Object localObject;
    if (paramVideoHeadInfo == null) {
      localObject = null;
    }
    aqhy localaqhy;
    do
    {
      return localObject;
      localaqhy = new aqhy();
      if (paramVideoHeadInfo.str_url.has()) {
        localaqhy.jdField_a_of_type_JavaLangString = paramVideoHeadInfo.str_url.get();
      }
      localObject = localaqhy;
    } while (!paramVideoHeadInfo.uint32_video_size.has());
    localaqhy.jdField_a_of_type_Int = paramVideoHeadInfo.uint32_video_size.get();
    return localaqhy;
  }
  
  public static ArrayList<aqhy> a(List<oidb_0x74b.VideoHeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aqhy localaqhy = a((oidb_0x74b.VideoHeadInfo)paramList.next());
      if (localaqhy != null) {
        localArrayList.add(localaqhy);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqhy
 * JD-Core Version:    0.7.0.1
 */