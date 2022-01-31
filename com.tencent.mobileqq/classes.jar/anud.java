import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.VideoHeadInfo;

public class anud
{
  public int a;
  public String a;
  
  public static anud a(oidb_0x74b.VideoHeadInfo paramVideoHeadInfo)
  {
    Object localObject;
    if (paramVideoHeadInfo == null) {
      localObject = null;
    }
    anud localanud;
    do
    {
      return localObject;
      localanud = new anud();
      if (paramVideoHeadInfo.str_url.has()) {
        localanud.jdField_a_of_type_JavaLangString = paramVideoHeadInfo.str_url.get();
      }
      localObject = localanud;
    } while (!paramVideoHeadInfo.uint32_video_size.has());
    localanud.jdField_a_of_type_Int = paramVideoHeadInfo.uint32_video_size.get();
    return localanud;
  }
  
  public static ArrayList<anud> a(List<oidb_0x74b.VideoHeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      anud localanud = a((oidb_0x74b.VideoHeadInfo)paramList.next());
      if (localanud != null) {
        localArrayList.add(localanud);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anud
 * JD-Core Version:    0.7.0.1
 */