import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class bkyw
{
  public static List<blbu> a()
  {
    ArrayList localArrayList = new ArrayList();
    blbu localblbu = new blbu();
    localblbu.b = 1;
    localblbu.jdField_a_of_type_Int = 339;
    localArrayList.add(localblbu);
    localblbu = new blbu();
    localblbu.b = 1;
    localblbu.jdField_a_of_type_Int = 340;
    localArrayList.add(localblbu);
    localblbu = new blbu();
    localblbu.b = 1;
    localblbu.jdField_a_of_type_Int = 341;
    localArrayList.add(localblbu);
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    blbx localblbx = new blbx();
    long l = System.currentTimeMillis() / 1000L;
    localblbx.b = (String.valueOf(paramQQAppInterface.getCurrentAccountUin()) + '_' + l);
    localblbx.d = paramInt;
    localblbx.jdField_e_of_type_Int = 1;
    localblbx.g = String.valueOf(paramString1);
    localblbx.jdField_a_of_type_Long = l;
    localblbx.jdField_a_of_type_Int = 1;
    localblbx.jdField_e_of_type_JavaLangString = "tianshu.31";
    localblbx.i = "";
    localblbx.l = paramString2;
    blbw.a().a(localblbx);
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
      paramQQAppInterface = bfwg.a(paramQQAppInterface, paramContext, paramString);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a();
    return;
    paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
    paramQQAppInterface.putExtra("url", paramString);
    paramContext.startActivity(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyw
 * JD-Core Version:    0.7.0.1
 */