import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileError.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class azic
{
  public static WeakReference<azig> a = new WeakReference(null);
  
  private static String a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return paramQQAppInterface.getApplication().getResources().getString(paramInt);
  }
  
  private static String a(QQAppInterface paramQQAppInterface, int paramInt, Object... paramVarArgs)
  {
    return String.format(a(paramQQAppInterface, paramInt), paramVarArgs);
  }
  
  private static void a(Context paramContext, long paramLong)
  {
    azid localazid = new azid(paramLong);
    babr.a(paramContext, 230, paramContext.getResources().getString(2131632131), paramContext.getResources().getString(2131632132), 2131632179, 2131631837, localazid, localazid).show();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, paramString, 0);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i;
    try
    {
      i = paramContext.getResources().getDimensionPixelSize(2131167766);
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        new Handler(Looper.getMainLooper()).post(new TroopFileError.1(paramContext, paramInt, paramString, i));
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("TroopFileError", 1, "showTipsToast error!", paramContext);
      return;
    }
    bbmy.a(paramContext, paramInt, paramString, 0).b(i);
  }
  
  public static void a(azie paramazie, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramazie == null) || (paramContext == null)) {
      return;
    }
    if (!TextUtils.isEmpty(paramazie.jdField_b_of_type_JavaLangString))
    {
      a(paramContext, paramazie.jdField_b_of_type_JavaLangString, 1);
      return;
    }
    String str = azjg.a(paramazie.jdField_a_of_type_JavaLangString);
    int i;
    switch (paramazie.jdField_a_of_type_Int)
    {
    default: 
      str = null;
      i = 0;
    }
    for (;;)
    {
      if ((paramazie.jdField_a_of_type_Int != 602) && (paramazie.jdField_a_of_type_Int != 604) && (paramazie.jdField_a_of_type_Int != 605)) {
        break label1264;
      }
      if (BaseActivity.sTopActivity == null) {
        break;
      }
      bguc.a(paramQQAppInterface, BaseActivity.sTopActivity, BaseActivity.sTopActivity.getTitleBarHeight());
      return;
      str = a(paramQQAppInterface, 2131632203);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131632133);
      i = 0;
      continue;
      a(paramContext, paramLong);
      str = null;
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131632293, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131632291, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131632292);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131632290);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131632294);
      i = 2;
      continue;
      str = a(paramQQAppInterface, 2131631851, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131631849);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131631850);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131632286);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131632313);
      awqx.b(paramQQAppInterface, "P_CliOper", "Grp_files", "", "power", "nopower_upload", 0, 0, String.format("%d", new Object[] { Long.valueOf(paramLong) }), "2", "", "");
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131632311, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131632306, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131632250, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131632308, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131632307, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131632203);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131631907);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131631908);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131631868);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131631864);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131631866, new Object[] { str });
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131631867, new Object[] { str });
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131631865, new Object[] { str });
      i = 0;
      continue;
      if (ayor.a(paramazie.jdField_b_of_type_Int))
      {
        str = a(paramQQAppInterface, 2131632305, new Object[] { str });
        i = 1;
      }
      else
      {
        str = a(paramQQAppInterface, 2131631863, new Object[] { str });
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131632286);
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131631921);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131631922);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131631925);
        i = 2;
        continue;
        str = a(paramQQAppInterface, 2131631926);
        i = 1;
        continue;
        str = paramazie.jdField_b_of_type_JavaLangString;
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131631927);
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131631929);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131631928);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131631930);
        i = 1;
        continue;
        if (!TextUtils.isEmpty(paramazie.jdField_b_of_type_JavaLangString))
        {
          str = paramazie.jdField_b_of_type_JavaLangString;
          i = 0;
        }
        else
        {
          str = a(paramQQAppInterface, 2131631931);
          i = 0;
          continue;
          str = a(paramQQAppInterface, 2131631924);
          i = 2;
          continue;
          str = a(paramQQAppInterface, 2131631923);
          i = 0;
        }
      }
    }
    label1264:
    if ((paramazie.jdField_a_of_type_Int == 601) || (paramazie.jdField_a_of_type_Int == 605) || (paramazie.jdField_a_of_type_Int == 802) || (paramazie.jdField_a_of_type_Int == 604) || (paramazie.jdField_a_of_type_Int == 702))
    {
      a(paramQQAppInterface, paramContext, str, i);
      return;
    }
    a(paramContext, str, i);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    a(paramQQAppInterface, paramLong, 7, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, paramLong, null, paramInt1, paramInt2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramQQAppInterface == null) || (paramInt2 == 0)) {}
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("reportSimpleError==> troopUin:");
        localStringBuilder.append(paramLong).append(",filename:").append(paramString).append(",status:").append(paramInt1).append(",errorCode:").append(paramInt2);
        QLog.e("TroopFileError", 2, localStringBuilder.toString());
      }
      paramQQAppInterface = (ajex)paramQQAppInterface.a(22);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(new azie(paramString, paramLong, paramInt1, paramInt2));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (bgtg.a())
    {
      if (bgtg.b()) {
        bgtg.a(paramQQAppInterface);
      }
    }
    else {
      return;
    }
    a(paramContext, paramString, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, azie paramazie)
  {
    if ((paramQQAppInterface == null) || (paramazie == null) || (paramazie.jdField_a_of_type_Int == 0)) {}
    do
    {
      return;
      paramQQAppInterface = (ajex)paramQQAppInterface.a(22);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(paramazie);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, azig paramazig)
  {
    if ((a != null) && (a.get() != null))
    {
      paramQQAppInterface.removeObserver((ajfe)a.get());
      a = null;
    }
    a = new WeakReference(paramazig);
    paramQQAppInterface.addObserver(paramazig);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, azig paramazig)
  {
    paramQQAppInterface.removeObserver(paramazig);
    if ((a != null) && (a.get() == paramazig)) {
      a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azic
 * JD-Core Version:    0.7.0.1
 */