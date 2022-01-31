import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeRequest;
import com.tencent.qphone.base.util.QLog;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.tools.util;

public class awab
{
  protected static boolean a;
  protected static String b;
  protected Handler a;
  protected String a;
  protected HashMap<String, String> a;
  protected NewIntent a;
  protected Handler b;
  protected boolean b;
  
  static
  {
    jdField_b_of_type_JavaLangString = "";
  }
  
  public awab()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(String paramString)
  {
    int j = 0;
    if (paramString.contains("$OPID$")) {
      j = 1;
    }
    int i = j;
    if (paramString.contains("$AT$")) {
      i = j | 0x2;
    }
    j = i;
    if (paramString.contains("$PT$")) {
      j = i | 0x4;
    }
    i = j;
    if (paramString.contains("$PF$")) {
      i = j | 0x40;
    }
    j = i;
    if (paramString.contains("$ESK$")) {
      j = i | 0x80;
    }
    return j;
  }
  
  public static Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return localBundle;
      paramString = paramString.split("&");
    } while (paramString == null);
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      int k = localObject.indexOf('=');
      if (k != -1) {}
      try
      {
        localBundle.putString(localObject.substring(0, k), localObject.substring(k + 1));
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("AppLaucherHelper", 2, localException.getMessage(), localException);
        }
      }
    }
  }
  
  public static void a()
  {
    jdField_b_of_type_JavaLangString = "";
  }
  
  private void a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    localawaf = new awaf(this, System.currentTimeMillis(), paramString3, paramContext, paramInt);
    if (this.jdField_a_of_type_MqqAppNewIntent == null) {
      this.jdField_a_of_type_MqqAppNewIntent = new NewIntent(paramContext, mmi.class);
    }
    localAuthorizeRequest = new FastAuthorize.AuthorizeRequest();
    long l1 = 0L;
    try
    {
      l2 = Long.parseLong(paramAppInterface.getCurrentAccountUin());
      l1 = l2;
    }
    catch (Exception localException)
    {
      long l2;
      label64:
      break label64;
    }
    localAuthorizeRequest.uin.set(l1);
    l1 = 0L;
    try
    {
      l2 = Long.parseLong(paramString1);
      l1 = l2;
    }
    catch (Exception paramString1)
    {
      label87:
      int i;
      break label87;
    }
    localAuthorizeRequest.client_id.set(l1);
    localAuthorizeRequest.pf.set("");
    paramString1 = bcev.a(paramContext);
    localAuthorizeRequest.qqv.set(paramString1);
    localAuthorizeRequest.sdkp.set("a");
    paramString1 = Build.DISPLAY;
    localAuthorizeRequest.os.set(paramString1);
    localAuthorizeRequest.skey.set(paramString4);
    i = a(paramString2);
    if (i == 0)
    {
      bcev.a(paramContext, paramString3, a(this.jdField_a_of_type_JavaLangString), paramInt);
      jdField_a_of_type_Boolean = false;
      return;
    }
    localAuthorizeRequest.flags.set(i);
    paramString2 = "";
    paramString1 = paramString2;
    for (;;)
    {
      try
      {
        arrayOfSignature = paramContext.getPackageManager().getPackageInfo(paramString3, 64).signatures;
        paramString1 = paramString2;
        if (arrayOfSignature != null)
        {
          paramString4 = paramString2;
          paramString1 = paramString2;
        }
      }
      catch (Exception paramString2)
      {
        Signature[] arrayOfSignature;
        MessageDigest localMessageDigest;
        label302:
        continue;
        localAuthorizeRequest.apk_sign.set(paramString1);
        this.jdField_a_of_type_MqqAppNewIntent.putExtra("cmd", "ConnAuthSvr.fast_qq_login");
        try
        {
          this.jdField_a_of_type_MqqAppNewIntent.putExtra("data", localAuthorizeRequest.toByteArray());
          this.jdField_a_of_type_MqqAppNewIntent.setObserver(localawaf);
          paramAppInterface.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 2000L);
          return;
        }
        catch (Exception paramAppInterface)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(getClass().getSimpleName(), 2, paramAppInterface.getMessage());
          jdField_a_of_type_Boolean = false;
          return;
        }
      }
      try
      {
        localMessageDigest = MessageDigest.getInstance("MD5");
        paramString4 = paramString2;
        paramString1 = paramString2;
        localMessageDigest.update(arrayOfSignature[0].toByteArray());
        paramString4 = paramString2;
        paramString1 = paramString2;
        paramString2 = bach.a(localMessageDigest.digest());
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException1)
      {
        paramString2 = paramString4;
        paramString1 = paramString2;
        localNoSuchAlgorithmException1.printStackTrace();
        paramString1 = paramString2;
      }
    }
    try
    {
      paramString1 = paramString2.toLowerCase();
      paramString2 = paramString1;
      paramString4 = paramString2;
      paramString1 = paramString2;
      localMessageDigest.reset();
      paramString1 = paramString2;
    }
    catch (Exception paramString1)
    {
      paramString1 = paramString2;
      break label302;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
    {
      break label356;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(getClass().getSimpleName(), 2, "no sign");
      }
      jdField_a_of_type_Boolean = false;
      bcev.a(paramContext, paramString3, a(this.jdField_a_of_type_JavaLangString), paramInt);
      return;
    }
  }
  
  public boolean a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (jdField_a_of_type_Boolean) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, "lauchApp");
    }
    jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new awae(this, Looper.getMainLooper(), paramContext, paramString3, paramInt, paramAppInterface, paramString1, paramString2);
    }
    if (paramString2.startsWith("?")) {}
    for (this.jdField_a_of_type_JavaLangString = paramString2.substring(1);; this.jdField_a_of_type_JavaLangString = paramString2)
    {
      a(paramAppInterface, paramContext, paramString1, paramString2, paramString3, ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount()), paramInt);
      return true;
    }
  }
  
  public boolean a(String paramString1, Context paramContext, String paramString2, AppInterface paramAppInterface, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    if (jdField_a_of_type_Boolean) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, "launchAppWithWlogin");
    }
    if ((TextUtils.isEmpty(paramString2)) || (!mkw.a().h(paramString2))) {
      return false;
    }
    jdField_a_of_type_Boolean = true;
    if (this.jdField_b_of_type_AndroidOsHandler == null) {
      this.jdField_b_of_type_AndroidOsHandler = new awac(this);
    }
    Long localLong = Long.valueOf(0L);
    try
    {
      paramString2 = Long.valueOf(paramString3);
      long l1 = 1L;
      try
      {
        long l2 = Long.valueOf(paramString5).longValue();
        l1 = l2;
      }
      catch (Exception paramString3)
      {
        label99:
        break label99;
      }
      paramString3 = new WtloginHelper(paramAppInterface.getApplication().getApplicationContext());
      paramString5 = util.getPkgSigFromApkName(paramContext, paramString4);
      paramString3.GetA1WithA1(paramAppInterface.getAccount(), 16L, 16L, paramString4.getBytes(), 1L, paramString2.longValue(), l1, "5.2".getBytes(), paramString5, new WUserSigInfo(), new WFastLoginInfo());
      paramString3.SetListener(new awad(this, paramString1, paramString3, paramInt, paramContext));
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 10000L);
      return true;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2 = localLong;
        if (QLog.isColorLevel())
        {
          QLog.d("appcenter", 2, "parse appid error = " + paramString3);
          paramString2 = localLong;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awab
 * JD-Core Version:    0.7.0.1
 */