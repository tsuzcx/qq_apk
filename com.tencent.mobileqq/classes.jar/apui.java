import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.VideoHeadInfo;

public class apui
{
  public int a;
  public String a;
  
  public static apui a(oidb_0x74b.VideoHeadInfo paramVideoHeadInfo)
  {
    Object localObject;
    if (paramVideoHeadInfo == null) {
      localObject = null;
    }
    apui localapui;
    do
    {
      return localObject;
      localapui = new apui();
      if (paramVideoHeadInfo.str_url.has()) {
        localapui.jdField_a_of_type_JavaLangString = paramVideoHeadInfo.str_url.get();
      }
      localObject = localapui;
    } while (!paramVideoHeadInfo.uint32_video_size.has());
    localapui.jdField_a_of_type_Int = paramVideoHeadInfo.uint32_video_size.get();
    return localapui;
  }
  
  public static ArrayList<apui> a(List<oidb_0x74b.VideoHeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      apui localapui = a((oidb_0x74b.VideoHeadInfo)paramList.next());
      if (localapui != null) {
        localArrayList.add(localapui);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apui
 * JD-Core Version:    0.7.0.1
 */