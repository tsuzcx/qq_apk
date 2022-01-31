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

public class bblg
{
  public static Handler.Callback a;
  public static Handler a;
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajsd.aW + ".VasResourceCheck/temp.json";
    jdField_a_of_type_AndroidOsHandler$Callback = new bbli();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (BubbleManager)paramQQAppInterface.getManager(44);
    if (localObject != null)
    {
      bbdx.a(((BubbleManager)localObject).a().getAbsolutePath(), false);
      ((BubbleManager)localObject).a();
    }
    localObject = (ho)paramQQAppInterface.getManager(42);
    if (localObject != null)
    {
      bbdx.a(((ho)localObject).a().getAbsolutePath(), false);
      ((ho)localObject).a();
    }
    localObject = (AvatarPendantManager)paramQQAppInterface.getManager(46);
    if (localObject != null)
    {
      bbdx.a(((AvatarPendantManager)localObject).a().getAbsolutePath(), false);
      ((AvatarPendantManager)localObject).a();
      bbdx.a(((AvatarPendantManager)localObject).b().getAbsolutePath(), false);
      ((AvatarPendantManager)localObject).b();
    }
    localObject = new File(bbvj.a(ajsd.aW + ".emotionsm"));
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    bbdx.a(((File)localObject).getAbsolutePath(), false);
    ((File)localObject).mkdirs();
    paramQQAppInterface = new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir().getParentFile(), "app_mobileqq_theme");
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    bbdx.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(ajsd.bV);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    bbdx.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(ajsd.cc + "resource");
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    bbdx.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(bbpa.jdField_a_of_type_JavaLangString);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    bbdx.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    bcql.a(paramActivity, ajya.a(2131716060), 0).a();
    paramActivity.finish();
    if (jdField_a_of_type_AndroidOsHandler == null) {
      jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandler$Callback);
    }
    paramActivity = new bbwu(paramString, new File(jdField_a_of_type_JavaLangString));
    ((bbww)paramQQAppInterface.getManager(47)).a(1).a(paramActivity, new bblh(paramQQAppInterface), null);
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http://gxh.vip.qq.com")) && (paramString.endsWith("secret.json"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblg
 * JD-Core Version:    0.7.0.1
 */