import android.widget.TextView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import java.util.Iterator;
import java.util.List;

public class awds
{
  public static int a(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    return 2;
  }
  
  public static int a(RedTouch paramRedTouch)
  {
    if ((paramRedTouch == null) || (!paramRedTouch.a())) {}
    List localList;
    do
    {
      return 0;
      localList = paramRedTouch.a();
    } while ((localList == null) || (localList.isEmpty()));
    int i = paramRedTouch.a();
    if (i == 16) {
      return 9;
    }
    if (i == 17) {
      return 10;
    }
    paramRedTouch = localList.iterator();
    while (paramRedTouch.hasNext())
    {
      i = ((BusinessInfoCheckUpdate.RedTypeInfo)paramRedTouch.next()).red_type.get();
      if (i == 0) {
        return 1;
      }
      if (i == 5) {
        return 2;
      }
      if (i == 11) {
        return 3;
      }
    }
    return 3;
  }
  
  public static int a(boolean paramBoolean, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if ((!paramBoolean) || (paramRedTypeInfo == null)) {
      return 0;
    }
    if (paramRedTypeInfo.red_type.get() == 0) {
      return 1;
    }
    if (paramRedTypeInfo.red_type.get() == 5) {
      return 2;
    }
    return 3;
  }
  
  public static bdmn a(String paramString)
  {
    bdmn localbdmn = new bdmn();
    localbdmn.i = "trends_tab";
    localbdmn.j = "trends_plugin";
    localbdmn.k = paramString;
    return localbdmn;
  }
  
  public static int b(RedTouch paramRedTouch)
  {
    if (paramRedTouch == null) {}
    while ((paramRedTouch.a == null) || (paramRedTouch.a.getVisibility() != 0)) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awds
 * JD-Core Version:    0.7.0.1
 */