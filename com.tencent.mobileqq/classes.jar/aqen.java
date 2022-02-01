import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.VideoHeadInfo;

public class aqen
{
  public int a;
  public String a;
  
  public static aqen a(oidb_0x74b.VideoHeadInfo paramVideoHeadInfo)
  {
    Object localObject;
    if (paramVideoHeadInfo == null) {
      localObject = null;
    }
    aqen localaqen;
    do
    {
      return localObject;
      localaqen = new aqen();
      if (paramVideoHeadInfo.str_url.has()) {
        localaqen.jdField_a_of_type_JavaLangString = paramVideoHeadInfo.str_url.get();
      }
      localObject = localaqen;
    } while (!paramVideoHeadInfo.uint32_video_size.has());
    localaqen.jdField_a_of_type_Int = paramVideoHeadInfo.uint32_video_size.get();
    return localaqen;
  }
  
  public static ArrayList<aqen> a(List<oidb_0x74b.VideoHeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aqen localaqen = a((oidb_0x74b.VideoHeadInfo)paramList.next());
      if (localaqen != null) {
        localArrayList.add(localaqen);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqen
 * JD-Core Version:    0.7.0.1
 */