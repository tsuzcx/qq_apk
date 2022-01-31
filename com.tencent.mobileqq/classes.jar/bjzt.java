import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class bjzt
{
  public static List<bkcg> a()
  {
    ArrayList localArrayList = new ArrayList();
    bkcg localbkcg = new bkcg();
    localbkcg.b = 1;
    localbkcg.jdField_a_of_type_Int = 339;
    localArrayList.add(localbkcg);
    localbkcg = new bkcg();
    localbkcg.b = 1;
    localbkcg.jdField_a_of_type_Int = 340;
    localArrayList.add(localbkcg);
    localbkcg = new bkcg();
    localbkcg.b = 1;
    localbkcg.jdField_a_of_type_Int = 341;
    localArrayList.add(localbkcg);
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    bkcj localbkcj = new bkcj();
    long l = System.currentTimeMillis() / 1000L;
    localbkcj.b = (String.valueOf(paramQQAppInterface.getCurrentAccountUin()) + '_' + l);
    localbkcj.d = paramInt;
    localbkcj.jdField_e_of_type_Int = 1;
    localbkcj.g = String.valueOf(paramString1);
    localbkcj.jdField_a_of_type_Long = l;
    localbkcj.jdField_a_of_type_Int = 1;
    localbkcj.jdField_e_of_type_JavaLangString = "tianshu.31";
    localbkcj.i = "";
    localbkcj.l = paramString2;
    bkci.a().a(localbkcj);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("TianshuAdUtils", 2, "url empty");
    }
    do
    {
      return;
      if (MiniAppLauncher.isMiniAppUrl(paramString))
      {
        MiniAppLauncher.startMiniApp(paramContext, paramString, paramInt, null);
        return;
      }
      if ((!paramString.startsWith("mqqapi://")) || (paramQQAppInterface == null)) {
        break;
      }
      paramQQAppInterface = bdds.a(paramQQAppInterface, paramContext, paramString);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.c();
    return;
    paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
    paramQQAppInterface.putExtra("url", paramString);
    paramContext.startActivity(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjzt
 * JD-Core Version:    0.7.0.1
 */