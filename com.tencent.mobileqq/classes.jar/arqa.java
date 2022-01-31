import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;

class arqa
  extends arqb
{
  public BusinessInfoCheckUpdate.AppInfo a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((avpq)paramQQAppInterface.getManager(36)).a(paramString);
    if ((RedTouch.a(paramQQAppInterface)) && (paramQQAppInterface.type.get() != 5) && (paramQQAppInterface.red_display_info.has()) && (paramQQAppInterface.red_display_info.get() != null) && (paramQQAppInterface.red_display_info.red_type_info.has()) && (paramQQAppInterface.red_display_info.red_type_info.get() != null))
    {
      paramQQAppInterface.red_display_info.red_type_info.clear();
      paramString = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramString.red_type.set(0);
      paramQQAppInterface.red_display_info.red_type_info.add(paramString);
    }
    return paramQQAppInterface;
  }
  
  public void a(RedTouch paramRedTouch, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    paramRedTouch.b(paramAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arqa
 * JD-Core Version:    0.7.0.1
 */