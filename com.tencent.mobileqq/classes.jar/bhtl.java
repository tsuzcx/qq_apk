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

public class bhtl
{
  public static Handler.Callback a;
  public static Handler a;
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = antf.ba + ".VasResourceCheck/temp.json";
    jdField_a_of_type_AndroidOsHandler$Callback = new bhtn();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (BubbleManager)paramQQAppInterface.getManager(44);
    if (localObject != null)
    {
      bhmi.a(((BubbleManager)localObject).a().getAbsolutePath(), false);
      ((BubbleManager)localObject).a();
    }
    localObject = (gc)paramQQAppInterface.getManager(42);
    if (localObject != null)
    {
      bhmi.a(((gc)localObject).a().getAbsolutePath(), false);
      ((gc)localObject).a();
    }
    localObject = (AvatarPendantManager)paramQQAppInterface.getManager(46);
    if (localObject != null)
    {
      bhmi.a(((AvatarPendantManager)localObject).a().getAbsolutePath(), false);
      ((AvatarPendantManager)localObject).a();
      bhmi.a(((AvatarPendantManager)localObject).b().getAbsolutePath(), false);
      ((AvatarPendantManager)localObject).b();
    }
    localObject = new File(bigv.a(antf.ba + ".emotionsm"));
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    bhmi.a(((File)localObject).getAbsolutePath(), false);
    ((File)localObject).mkdirs();
    paramQQAppInterface = new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir().getParentFile(), "app_mobileqq_theme");
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    bhmi.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(antf.bZ);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    bhmi.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(antf.cg + "resource");
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    bhmi.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(bhxh.jdField_a_of_type_JavaLangString);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    bhmi.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    QQToast.a(paramActivity, anzj.a(2131714830), 0).a();
    paramActivity.finish();
    if (jdField_a_of_type_AndroidOsHandler == null) {
      jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandler$Callback);
    }
    paramActivity = new bihu(paramString, new File(jdField_a_of_type_JavaLangString));
    ((bihw)paramQQAppInterface.getManager(47)).a(1).a(paramActivity, new bhtm(paramQQAppInterface), null);
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://gxh.vip.qq.com")) && (paramString.endsWith("secret.json"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhtl
 * JD-Core Version:    0.7.0.1
 */