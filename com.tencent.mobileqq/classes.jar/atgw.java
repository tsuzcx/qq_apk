import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;

class atgw
  extends atgx
{
  public BusinessInfoCheckUpdate.AppInfo a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((axho)paramQQAppInterface.getManager(36)).a(0, paramString);
    if ((RedTouch.a(paramQQAppInterface)) && (paramQQAppInterface.type.get() != 5)) {
      RedTouch.d(paramQQAppInterface);
    }
    return paramQQAppInterface;
  }
  
  public void a(RedTouch paramRedTouch, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    paramRedTouch.b(paramAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atgw
 * JD-Core Version:    0.7.0.1
 */