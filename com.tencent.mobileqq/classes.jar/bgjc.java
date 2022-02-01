import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileError.1;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class bgjc
{
  public static WeakReference<bgjg> a = new WeakReference(null);
  
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
    bgjd localbgjd = new bgjd(paramLong);
    bhdj.a(paramContext, 230, paramContext.getResources().getString(2131697354), paramContext.getResources().getString(2131697355), 2131697408, 2131697026, localbgjd, localbgjd).show();
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
      i = paramContext.getResources().getDimensionPixelSize(2131299080);
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
    QQToast.a(paramContext, paramInt, paramString, 0).b(i);
  }
  
  public static void a(bgje parambgje, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((parambgje == null) || (paramContext == null)) {
      return;
    }
    if (!TextUtils.isEmpty(parambgje.jdField_b_of_type_JavaLangString))
    {
      a(paramContext, parambgje.jdField_b_of_type_JavaLangString, 1);
      return;
    }
    String str = bgke.a(parambgje.jdField_a_of_type_JavaLangString);
    int i;
    switch (parambgje.jdField_a_of_type_Int)
    {
    default: 
      str = null;
      i = 0;
    }
    for (;;)
    {
      if ((parambgje.jdField_a_of_type_Int != 602) && (parambgje.jdField_a_of_type_Int != 604) && (parambgje.jdField_a_of_type_Int != 605)) {
        break label1264;
      }
      if (BaseActivity.sTopActivity == null) {
        break;
      }
      bmrr.a(paramQQAppInterface, BaseActivity.sTopActivity, BaseActivity.sTopActivity.getTitleBarHeight());
      return;
      str = a(paramQQAppInterface, 2131697432);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697356);
      i = 0;
      continue;
      a(paramContext, paramLong);
      str = null;
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697526, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697524, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697525);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697523);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697527);
      i = 2;
      continue;
      str = a(paramQQAppInterface, 2131697042, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697040);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697041);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697519);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697547);
      bdla.b(paramQQAppInterface, "P_CliOper", "Grp_files", "", "power", "nopower_upload", 0, 0, String.format("%d", new Object[] { Long.valueOf(paramLong) }), "2", "", "");
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697545, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697540, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697482, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697542, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697541, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697432);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697099);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697100);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697059);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697055);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697057, new Object[] { str });
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697058, new Object[] { str });
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697056, new Object[] { str });
      i = 0;
      continue;
      if (bfig.a(parambgje.jdField_b_of_type_Int))
      {
        str = a(paramQQAppInterface, 2131697539, new Object[] { str });
        i = 1;
      }
      else
      {
        str = a(paramQQAppInterface, 2131697054, new Object[] { str });
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131697519);
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131697113);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697114);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697117);
        i = 2;
        continue;
        str = a(paramQQAppInterface, 2131697118);
        i = 1;
        continue;
        str = parambgje.jdField_b_of_type_JavaLangString;
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697119);
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131697121);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697120);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697122);
        i = 1;
        continue;
        if (!TextUtils.isEmpty(parambgje.jdField_b_of_type_JavaLangString))
        {
          str = parambgje.jdField_b_of_type_JavaLangString;
          i = 0;
        }
        else
        {
          str = a(paramQQAppInterface, 2131697123);
          i = 0;
          continue;
          str = a(paramQQAppInterface, 2131697116);
          i = 2;
          continue;
          str = a(paramQQAppInterface, 2131697115);
          i = 0;
        }
      }
    }
    label1264:
    if ((parambgje.jdField_a_of_type_Int == 601) || (parambgje.jdField_a_of_type_Int == 605) || (parambgje.jdField_a_of_type_Int == 802) || (parambgje.jdField_a_of_type_Int == 604) || (parambgje.jdField_a_of_type_Int == 702))
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
      paramQQAppInterface = (anrb)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(new bgje(paramString, paramLong, paramInt1, paramInt2));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (bmqx.a())
    {
      if (bmqx.b()) {
        bmqx.a(paramQQAppInterface);
      }
    }
    else {
      return;
    }
    a(paramContext, paramString, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bgje parambgje)
  {
    if ((paramQQAppInterface == null) || (parambgje == null) || (parambgje.jdField_a_of_type_Int == 0)) {}
    do
    {
      return;
      paramQQAppInterface = (anrb)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(parambgje);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bgjg parambgjg)
  {
    if ((a != null) && (a.get() != null))
    {
      paramQQAppInterface.removeObserver((BusinessObserver)a.get());
      a = null;
    }
    a = new WeakReference(parambgjg);
    paramQQAppInterface.addObserver(parambgjg);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, bgjg parambgjg)
  {
    paramQQAppInterface.removeObserver(parambgjg);
    if ((a != null) && (a.get() == parambgjg)) {
      a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgjc
 * JD-Core Version:    0.7.0.1
 */