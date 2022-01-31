import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import java.io.File;
import mqq.app.MobileQQ;

public class bajl
{
  public static Handler.Callback a;
  public static Handler a;
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajed.aU + ".VasResourceCheck/temp.json";
    jdField_a_of_type_AndroidOsHandler$Callback = new bajn();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (BubbleManager)paramQQAppInterface.getManager(44);
    if (localObject != null)
    {
      bace.a(((BubbleManager)localObject).a().getAbsolutePath(), false);
      ((BubbleManager)localObject).a();
    }
    localObject = (fv)paramQQAppInterface.getManager(42);
    if (localObject != null)
    {
      bace.a(((fv)localObject).a().getAbsolutePath(), false);
      ((fv)localObject).a();
    }
    localObject = (AvatarPendantManager)paramQQAppInterface.getManager(46);
    if (localObject != null)
    {
      bace.a(((AvatarPendantManager)localObject).a().getAbsolutePath(), false);
      ((AvatarPendantManager)localObject).a();
      bace.a(((AvatarPendantManager)localObject).b().getAbsolutePath(), false);
      ((AvatarPendantManager)localObject).b();
    }
    localObject = new File(ajed.aU + ".emotionsm");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    bace.a(((File)localObject).getAbsolutePath(), false);
    ((File)localObject).mkdirs();
    localObject = new File(ajed.aU + "theme_pkg");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    bace.a(((File)localObject).getAbsolutePath(), false);
    ((File)localObject).mkdirs();
    paramQQAppInterface = new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir().getParentFile(), "app_mobileqq_theme");
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    bace.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(ajed.bN);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    bace.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(ajed.aU + "sysyem_background/resource");
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    bace.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(ajed.aU + "rbt");
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    bace.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    bbmy.a(paramActivity, ajjy.a(2131650258), 0).a();
    paramActivity.finish();
    if (jdField_a_of_type_AndroidOsHandler == null) {
      jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandler$Callback);
    }
    paramActivity = new batm(paramString, new File(jdField_a_of_type_JavaLangString));
    ((bato)paramQQAppInterface.getManager(47)).a(1).a(paramActivity, new bajm(paramQQAppInterface), null);
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http://gxh.vip.qq.com")) && (paramString.endsWith("secret.json"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajl
 * JD-Core Version:    0.7.0.1
 */