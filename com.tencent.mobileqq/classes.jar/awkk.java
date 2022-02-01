import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;

class awkk
  extends awkl
{
  public BusinessInfoCheckUpdate.AppInfo a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (String.valueOf(1130).equals(paramString))) {
      paramQQAppInterface = null;
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        paramString = ((bbav)paramQQAppInterface.getManager(36)).a(0, paramString);
        paramQQAppInterface = paramString;
      } while (!RedTouch.a(paramString));
      paramQQAppInterface = paramString;
    } while (paramString.type.get() == 5);
    RedTouch.d(paramString);
    return paramString;
  }
  
  public void a(RedTouch paramRedTouch, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    paramRedTouch.b(paramAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awkk
 * JD-Core Version:    0.7.0.1
 */