import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import java.util.Iterator;
import java.util.List;

class auxk
  extends auxp
{
  public BusinessInfoCheckUpdate.AppInfo a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (String.valueOf(1130).equals(paramString))) {
      return null;
    }
    paramQQAppInterface = ((azvi)paramQQAppInterface.getManager(36)).a(0, paramString);
    if ((RedTouch.a(paramQQAppInterface)) && (paramQQAppInterface.type.get() != 5) && (paramQQAppInterface.red_display_info.has()) && (paramQQAppInterface.red_display_info.get() != null) && (paramQQAppInterface.red_display_info.red_type_info.has()) && (paramQQAppInterface.red_display_info.red_type_info.get() != null))
    {
      paramString = paramQQAppInterface.red_display_info.red_type_info.get().iterator();
      while (paramString.hasNext())
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramString.next();
        int i = localRedTypeInfo.red_type.get();
        if ((i == 11) || (i == 17) || (i == 16)) {
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
 * Qualified Name:     auxk
 * JD-Core Version:    0.7.0.1
 */