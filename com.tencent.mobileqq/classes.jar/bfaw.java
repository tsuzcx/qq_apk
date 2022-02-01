import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileError.1;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class bfaw
{
  public static WeakReference<bfba> a = new WeakReference(null);
  
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
    bfax localbfax = new bfax(paramLong);
    bfur.a(paramContext, 230, paramContext.getResources().getString(2131697077), paramContext.getResources().getString(2131697078), 2131697131, 2131696759, localbfax, localbfax).show();
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
      i = paramContext.getResources().getDimensionPixelSize(2131299076);
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
  
  public static void a(bfay parambfay, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((parambfay == null) || (paramContext == null)) {
      return;
    }
    if (!TextUtils.isEmpty(parambfay.jdField_b_of_type_JavaLangString))
    {
      a(paramContext, parambfay.jdField_b_of_type_JavaLangString, 1);
      return;
    }
    String str = bfby.a(parambfay.jdField_a_of_type_JavaLangString);
    int i;
    switch (parambfay.jdField_a_of_type_Int)
    {
    default: 
      str = null;
      i = 0;
    }
    for (;;)
    {
      if ((parambfay.jdField_a_of_type_Int != 602) && (parambfay.jdField_a_of_type_Int != 604) && (parambfay.jdField_a_of_type_Int != 605)) {
        break label1264;
      }
      if (BaseActivity.sTopActivity == null) {
        break;
      }
      blfa.a(paramQQAppInterface, BaseActivity.sTopActivity, BaseActivity.sTopActivity.getTitleBarHeight());
      return;
      str = a(paramQQAppInterface, 2131697155);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697079);
      i = 0;
      continue;
      a(paramContext, paramLong);
      str = null;
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697249, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697247, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697248);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697246);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697250);
      i = 2;
      continue;
      str = a(paramQQAppInterface, 2131696775, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131696773);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131696774);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697242);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697270);
      bcef.b(paramQQAppInterface, "P_CliOper", "Grp_files", "", "power", "nopower_upload", 0, 0, String.format("%d", new Object[] { Long.valueOf(paramLong) }), "2", "", "");
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697268, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697263, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697205, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697265, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697264, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697155);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131696831);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131696832);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131696792);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131696788);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131696790, new Object[] { str });
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131696791, new Object[] { str });
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131696789, new Object[] { str });
      i = 0;
      continue;
      if (bebd.a(parambfay.jdField_b_of_type_Int))
      {
        str = a(paramQQAppInterface, 2131697262, new Object[] { str });
        i = 1;
      }
      else
      {
        str = a(paramQQAppInterface, 2131696787, new Object[] { str });
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131697242);
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131696845);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131696846);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131696849);
        i = 2;
        continue;
        str = a(paramQQAppInterface, 2131696850);
        i = 1;
        continue;
        str = parambfay.jdField_b_of_type_JavaLangString;
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131696851);
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131696853);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131696852);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131696854);
        i = 1;
        continue;
        if (!TextUtils.isEmpty(parambfay.jdField_b_of_type_JavaLangString))
        {
          str = parambfay.jdField_b_of_type_JavaLangString;
          i = 0;
        }
        else
        {
          str = a(paramQQAppInterface, 2131696855);
          i = 0;
          continue;
          str = a(paramQQAppInterface, 2131696848);
          i = 2;
          continue;
          str = a(paramQQAppInterface, 2131696847);
          i = 0;
        }
      }
    }
    label1264:
    if ((parambfay.jdField_a_of_type_Int == 601) || (parambfay.jdField_a_of_type_Int == 605) || (parambfay.jdField_a_of_type_Int == 802) || (parambfay.jdField_a_of_type_Int == 604) || (parambfay.jdField_a_of_type_Int == 702))
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
      paramQQAppInterface = (amoo)paramQQAppInterface.getBusinessHandler(22);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(new bfay(paramString, paramLong, paramInt1, paramInt2));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (bleg.a())
    {
      if (bleg.b()) {
        bleg.a(paramQQAppInterface);
      }
    }
    else {
      return;
    }
    a(paramContext, paramString, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bfay parambfay)
  {
    if ((paramQQAppInterface == null) || (parambfay == null) || (parambfay.jdField_a_of_type_Int == 0)) {}
    do
    {
      return;
      paramQQAppInterface = (amoo)paramQQAppInterface.getBusinessHandler(22);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(parambfay);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bfba parambfba)
  {
    if ((a != null) && (a.get() != null))
    {
      paramQQAppInterface.removeObserver((BusinessObserver)a.get());
      a = null;
    }
    a = new WeakReference(parambfba);
    paramQQAppInterface.addObserver(parambfba);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, bfba parambfba)
  {
    paramQQAppInterface.removeObserver(parambfba);
    if ((a != null) && (a.get() == parambfba)) {
      a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfaw
 * JD-Core Version:    0.7.0.1
 */