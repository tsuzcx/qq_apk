import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import java.util.Iterator;
import java.util.List;

public class arqe
{
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
  
  public static axth a(String paramString)
  {
    axth localaxth = new axth();
    localaxth.i = "trends_tab";
    localaxth.j = "trends_plugin";
    localaxth.k = paramString;
    return localaxth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arqe
 * JD-Core Version:    0.7.0.1
 */