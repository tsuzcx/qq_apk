import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;

final class anfr
  implements anmk
{
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp", 2, "ArkSafe.report onDisableReport");
    }
    anmg.a().a(null);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp", 2, new Object[] { "ArkSafe.report onReportUrlCheck content=", paramString });
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((ArkAppCenter)((QQAppInterface)localObject).getManager(121)).a();
        if (localObject != null) {
          ((anit)localObject).a(paramString);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfr
 * JD-Core Version:    0.7.0.1
 */