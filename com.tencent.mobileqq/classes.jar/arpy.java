import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;

class arpy
  extends arqd
{
  public BusinessInfoCheckUpdate.AppInfo a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((avps)paramQQAppInterface.getManager(36)).a(paramString);
  }
  
  public void a(RedTouch paramRedTouch, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    paramRedTouch.a(paramAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arpy
 * JD-Core Version:    0.7.0.1
 */