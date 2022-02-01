import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import java.util.Iterator;
import java.util.List;

class avrp
  extends avru
{
  public BusinessInfoCheckUpdate.AppInfo a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((baif)paramQQAppInterface.getManager(36)).a(0, paramString);
    if ((RedTouch.a(paramQQAppInterface)) && (paramQQAppInterface.type.get() != 5) && (paramQQAppInterface.red_display_info.has()) && (paramQQAppInterface.red_display_info.get() != null) && (paramQQAppInterface.red_display_info.red_type_info.has()) && (paramQQAppInterface.red_display_info.red_type_info.get() != null))
    {
      paramString = paramQQAppInterface.red_display_info.red_type_info.get().iterator();
      while (paramString.hasNext())
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramString.next();
        if (localRedTypeInfo.red_type.get() == 11) {
          localRedTypeInfo.red_type.set(0);
        }
      }
    }
    return paramQQAppInterface;
  }
  
  public void a(RedTouch paramRedTouch, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    paramRedTouch.a(paramAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrp
 * JD-Core Version:    0.7.0.1
 */