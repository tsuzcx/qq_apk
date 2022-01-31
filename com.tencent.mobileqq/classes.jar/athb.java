import android.widget.TextView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import java.util.Iterator;
import java.util.List;

public class athb
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
    do
    {
      return 0;
      paramRedTouch = paramRedTouch.a();
    } while ((paramRedTouch == null) || (paramRedTouch.isEmpty()));
    paramRedTouch = paramRedTouch.iterator();
    while (paramRedTouch.hasNext())
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramRedTouch.next();
      if (localRedTypeInfo.red_type.get() == 0) {
        return 1;
      }
      if (localRedTypeInfo.red_type.get() == 5) {
        return 2;
      }
      if (localRedTypeInfo.red_type.get() == 11) {
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
  
  public static azov a(String paramString)
  {
    azov localazov = new azov();
    localazov.i = "trends_tab";
    localazov.j = "trends_plugin";
    localazov.k = paramString;
    return localazov;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     athb
 * JD-Core Version:    0.7.0.1
 */