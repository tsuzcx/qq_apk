import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;

final class apui
  implements aqbe
{
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkCommonUtil", 2, "ArkSafe.report onDisableReport");
    }
    aqba.a().a(null);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkCommonUtil", 2, new Object[] { "ArkSafe.report onReportUrlCheck content=", paramString });
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((ArkAppCenter)((QQAppInterface)localObject).getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER)).a();
        if (localObject != null) {
          ((apxp)localObject).a(paramString);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apui
 * JD-Core Version:    0.7.0.1
 */