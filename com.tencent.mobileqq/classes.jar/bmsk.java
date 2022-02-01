import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class bmsk
{
  public static List<bmvg> a()
  {
    ArrayList localArrayList = new ArrayList();
    bmvg localbmvg = new bmvg();
    localbmvg.b = 1;
    localbmvg.jdField_a_of_type_Int = 339;
    localArrayList.add(localbmvg);
    localbmvg = new bmvg();
    localbmvg.b = 1;
    localbmvg.jdField_a_of_type_Int = 340;
    localArrayList.add(localbmvg);
    localbmvg = new bmvg();
    localbmvg.b = 1;
    localbmvg.jdField_a_of_type_Int = 341;
    localArrayList.add(localbmvg);
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    bmvj localbmvj = new bmvj();
    long l = System.currentTimeMillis() / 1000L;
    localbmvj.b = (String.valueOf(paramQQAppInterface.getCurrentAccountUin()) + '_' + l);
    localbmvj.d = paramInt;
    localbmvj.jdField_e_of_type_Int = 1;
    localbmvj.g = String.valueOf(paramString1);
    localbmvj.jdField_a_of_type_Long = l;
    localbmvj.jdField_a_of_type_Int = 1;
    localbmvj.jdField_e_of_type_JavaLangString = "tianshu.31";
    localbmvj.i = "";
    localbmvj.l = paramString2;
    bmvi.a().a(localbmvj);
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
      paramQQAppInterface = bgng.a(paramQQAppInterface, paramContext, paramString);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a();
    return;
    paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
    paramQQAppInterface.putExtra("url", paramString);
    paramContext.startActivity(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmsk
 * JD-Core Version:    0.7.0.1
 */