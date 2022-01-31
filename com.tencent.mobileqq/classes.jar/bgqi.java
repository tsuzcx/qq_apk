import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class bgqi
{
  public static void a(AppRuntime paramAppRuntime, int paramInt)
  {
    a(paramAppRuntime, "User_NewFav", paramInt, 0, 0);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2)
  {
    a(paramAppRuntime, "User_AddFav", paramInt2, 0, paramInt1);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("qqfavReport", 2, "subAction= 0X800AA51, actionName = 0X800AA51, fromType = " + paramInt1 + ", actionResult = " + paramInt2 + ", ext2 = " + paramInt3);
    }
    axqy.b(null, "dc00898", "", "", "0X800AA51", "0X800AA51", paramInt1, paramInt2, "" + paramInt3, "", "", "");
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramAppRuntime, paramString, paramInt1, paramInt2, paramInt3, 0, "", "");
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = null;
    if ((paramAppRuntime instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)paramAppRuntime;
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqfavReport", 2, "actionName = " + paramString1 + ", fromType = " + paramInt1 + ", actionResult = " + paramInt2 + ", ext2 =" + paramInt3 + ", ext3 =" + paramInt4 + ", ext4 =" + paramString2 + ", ext5 =" + paramString3);
    }
    String str1 = "" + paramInt3;
    String str2 = "" + paramInt4;
    if (paramString2 == null)
    {
      paramAppRuntime = "";
      if (paramString3 != null) {
        break label196;
      }
    }
    label196:
    for (paramString2 = "";; paramString2 = paramString3)
    {
      axqy.b(localQQAppInterface, "CliOper", "", "", "Favorite", paramString1, paramInt1, paramInt2, str1, str2, paramAppRuntime, paramString2);
      return;
      paramAppRuntime = paramString2;
      break;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong)
  {
    Object localObject = new String[3];
    int i = bbfj.a(paramAppRuntime.getApplication().getApplicationContext());
    if (i == 1) {
      if (paramBoolean)
      {
        localObject[0] = "param_WIFIFavoritesUploadFlow";
        localObject[1] = "param_WIFIFlow";
        localObject[2] = "param_Flow";
        paramAppRuntime.sendAppDataIncermentMsg(paramAppRuntime.getAccount(), (String[])localObject, paramLong);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("addFlowCount ").append(paramLong).append(" for ");
          if (!paramBoolean) {
            break label156;
          }
        }
      }
    }
    label156:
    for (paramAppRuntime = "upload";; paramAppRuntime = "download")
    {
      QLog.d("qqfav", 2, paramAppRuntime + ", netType is " + i);
      return;
      localObject[0] = "param_WIFIFavoritesDownloadFlow";
      break;
      if (paramBoolean) {
        localObject[0] = "param_XGFavoritesUploadFlow";
      }
      for (;;)
      {
        localObject[1] = "param_XGFlow";
        break;
        localObject[0] = "param_XGFavoritesDownloadFlow";
      }
    }
  }
  
  public static void b(AppRuntime paramAppRuntime, int paramInt)
  {
    a(paramAppRuntime, "User_DelFav", 0, 0, paramInt);
  }
  
  public static void b(AppRuntime paramAppRuntime, int paramInt1, int paramInt2)
  {
    a(paramAppRuntime, "User_OpenFavPage", paramInt2, 0, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgqi
 * JD-Core Version:    0.7.0.1
 */