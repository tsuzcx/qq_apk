import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import mqq.app.MobileQQ;

public class bdka
{
  public static Handler.Callback a;
  public static Handler a;
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = aljq.aX + ".VasResourceCheck/temp.json";
    jdField_a_of_type_AndroidOsHandler$Callback = new bdkc();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (BubbleManager)paramQQAppInterface.getManager(44);
    if (localObject != null)
    {
      bdcs.a(((BubbleManager)localObject).a().getAbsolutePath(), false);
      ((BubbleManager)localObject).a();
    }
    localObject = (fx)paramQQAppInterface.getManager(42);
    if (localObject != null)
    {
      bdcs.a(((fx)localObject).a().getAbsolutePath(), false);
      ((fx)localObject).a();
    }
    localObject = (AvatarPendantManager)paramQQAppInterface.getManager(46);
    if (localObject != null)
    {
      bdcs.a(((AvatarPendantManager)localObject).a().getAbsolutePath(), false);
      ((AvatarPendantManager)localObject).a();
      bdcs.a(((AvatarPendantManager)localObject).b().getAbsolutePath(), false);
      ((AvatarPendantManager)localObject).b();
    }
    localObject = new File(bduw.a(aljq.aX + ".emotionsm"));
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    bdcs.a(((File)localObject).getAbsolutePath(), false);
    ((File)localObject).mkdirs();
    paramQQAppInterface = new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir().getParentFile(), "app_mobileqq_theme");
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    bdcs.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(aljq.bW);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    bdcs.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(aljq.cd + "resource");
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    bdcs.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(bdnu.jdField_a_of_type_JavaLangString);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    bdcs.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    QQToast.a(paramActivity, alpo.a(2131716432), 0).a();
    paramActivity.finish();
    if (jdField_a_of_type_AndroidOsHandler == null) {
      jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandler$Callback);
    }
    paramActivity = new bdvv(paramString, new File(jdField_a_of_type_JavaLangString));
    ((bdvx)paramQQAppInterface.getManager(47)).a(1).a(paramActivity, new bdkb(paramQQAppInterface), null);
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http://gxh.vip.qq.com")) && (paramString.endsWith("secret.json"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdka
 * JD-Core Version:    0.7.0.1
 */