import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.VideoHeadInfo;

public class apbj
{
  public int a;
  public String a;
  
  public static apbj a(oidb_0x74b.VideoHeadInfo paramVideoHeadInfo)
  {
    Object localObject;
    if (paramVideoHeadInfo == null) {
      localObject = null;
    }
    apbj localapbj;
    do
    {
      return localObject;
      localapbj = new apbj();
      if (paramVideoHeadInfo.str_url.has()) {
        localapbj.jdField_a_of_type_JavaLangString = paramVideoHeadInfo.str_url.get();
      }
      localObject = localapbj;
    } while (!paramVideoHeadInfo.uint32_video_size.has());
    localapbj.jdField_a_of_type_Int = paramVideoHeadInfo.uint32_video_size.get();
    return localapbj;
  }
  
  public static ArrayList<apbj> a(List<oidb_0x74b.VideoHeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      apbj localapbj = a((oidb_0x74b.VideoHeadInfo)paramList.next());
      if (localapbj != null) {
        localArrayList.add(localapbj);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbj
 * JD-Core Version:    0.7.0.1
 */