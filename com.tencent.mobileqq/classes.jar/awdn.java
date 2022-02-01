import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;

class awdn
  extends awdo
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
        paramString = ((bbbq)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(0, paramString);
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
 * Qualified Name:     awdn
 * JD-Core Version:    0.7.0.1
 */