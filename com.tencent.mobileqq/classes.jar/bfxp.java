import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.qg.qq.QGameApp.1;
import com.tencent.qg.qq.QGameApp.3;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.io.File;
import org.json.JSONObject;

public class bfxp
  extends auec
  implements IEventReceiver
{
  public static volatile boolean a;
  private bfxr a;
  
  public bfxp(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt)
  {
    super(paramMiniAppActivity, paramString, paramInt);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramContext.getCacheDir().getAbsolutePath();
    }
    return paramContext.getCacheDir().getAbsolutePath() + File.separator + paramString;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return a(paramContext, paramString1);
    }
    return a(paramContext, paramString1) + File.separator + paramString2;
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return "";
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    try
    {
      paramString = new JSONObject(bdhb.b(paramString)).optString("version");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString1;
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString1 + File.separator + paramString2;
    }
    paramString1 = str;
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1 = str + File.separator + paramString3;
    }
    return paramString1;
  }
  
  private void a(int paramInt)
  {
    QLog.e("QGameApp", 1, new Object[] { "dispatchAppInitFailed. errorCode=", Integer.valueOf(paramInt) });
    auee localauee = new auee();
    localauee.jdField_a_of_type_Int = 4;
    localauee.jdField_a_of_type_Auef = this.jdField_a_of_type_Auef;
    umc.a().dispatch("MiniAppManager", localauee);
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    ThreadManagerV2.excute(new QGameApp.3(this, paramBoolean, paramString), 64, null, true);
  }
  
  private boolean a(boolean paramBoolean, String paramString)
  {
    boolean bool = false;
    String str1;
    String str2;
    if (!paramBoolean)
    {
      str1 = a(a(this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity, "qgamelibs", "libsconfig.json"));
      str2 = a(a(paramString, "", "libsconfig.json"));
      if ((!TextUtils.isEmpty(str2)) && (str2.equals(str1))) {
        paramBoolean = true;
      }
    }
    do
    {
      return paramBoolean;
      str1 = a(paramString, "qgamelibs", "");
      str2 = a(this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity, "qgamelibs") + File.separator;
      bdhb.b(str2);
      paramBoolean = bool;
    } while (bdhb.a(str1, str2, false) < 0);
    return bdhb.d(a(paramString, "", "libsconfig.json"), a(this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity, "qgamelibs", "libsconfig.json"));
  }
  
  private String[] a()
  {
    String str3 = this.jdField_a_of_type_Auef.a.getString("unzipped_path");
    String str2 = a(this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity, "qgamelibs", "ejecta.js");
    String str1 = null;
    if (!TextUtils.isEmpty(str3)) {
      str1 = a(str3, this.jdField_a_of_type_Auef.h, "index.js");
    }
    return new String[] { str2, str1 };
  }
  
  @SuppressLint({"UnsafeDynamicallyLoadedCode"})
  private boolean b()
  {
    int i = 0;
    if (!jdField_a_of_type_Boolean)
    {
      Object localObject = new File(a(this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity, "qgamelibs"));
      if (!((File)localObject).isDirectory()) {}
      do
      {
        return false;
        localObject = ((File)localObject).listFiles(new bfxq(this));
      } while ((localObject == null) || (localObject.length == 0));
      int j = localObject.length;
      while (i < j)
      {
        System.load(localObject[i].getAbsolutePath());
        i += 1;
      }
      jdField_a_of_type_Boolean = true;
    }
    return true;
  }
  
  private void d()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new QGameApp.1(this), 1000L);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity != null)
    {
      this.jdField_a_of_type_Bfxr = new bfxr(this);
      umc.a().registerSubscriber(this.jdField_a_of_type_Bfxr);
      aued localaued = auek.a().a("ak:3214");
      if (localaued != null) {
        localaued.a("ak:3214", "QGameApp", this.jdField_a_of_type_Auef.h);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity != null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity.finish();
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Bfxr != null) {
      umc.a().unRegisterSubscriber(this.jdField_a_of_type_Bfxr);
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfxp
 * JD-Core Version:    0.7.0.1
 */