import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class bkea
{
  public static List<bkgn> a()
  {
    ArrayList localArrayList = new ArrayList();
    bkgn localbkgn = new bkgn();
    localbkgn.b = 1;
    localbkgn.jdField_a_of_type_Int = 339;
    localArrayList.add(localbkgn);
    localbkgn = new bkgn();
    localbkgn.b = 1;
    localbkgn.jdField_a_of_type_Int = 340;
    localArrayList.add(localbkgn);
    localbkgn = new bkgn();
    localbkgn.b = 1;
    localbkgn.jdField_a_of_type_Int = 341;
    localArrayList.add(localbkgn);
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    bkgq localbkgq = new bkgq();
    long l = System.currentTimeMillis() / 1000L;
    localbkgq.b = (String.valueOf(paramQQAppInterface.getCurrentAccountUin()) + '_' + l);
    localbkgq.d = paramInt;
    localbkgq.jdField_e_of_type_Int = 1;
    localbkgq.g = String.valueOf(paramString1);
    localbkgq.jdField_a_of_type_Long = l;
    localbkgq.jdField_a_of_type_Int = 1;
    localbkgq.jdField_e_of_type_JavaLangString = "tianshu.31";
    localbkgq.i = "";
    localbkgq.l = paramString2;
    bkgp.a().a(localbkgq);
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
      paramQQAppInterface = bdib.a(paramQQAppInterface, paramContext, paramString);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.c();
    return;
    paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
    paramQQAppInterface.putExtra("url", paramString);
    paramContext.startActivity(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkea
 * JD-Core Version:    0.7.0.1
 */