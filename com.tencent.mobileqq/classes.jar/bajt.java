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

public class bajt
{
  public static WeakReference<bajx> a = new WeakReference(null);
  
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
    baju localbaju = new baju(paramLong);
    bbdj.a(paramContext, 230, paramContext.getResources().getString(2131697861), paramContext.getResources().getString(2131697862), 2131697914, 2131697550, localbaju, localbaju).show();
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
      i = paramContext.getResources().getDimensionPixelSize(2131298865);
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
    bcql.a(paramContext, paramInt, paramString, 0).b(i);
  }
  
  public static void a(bajv parambajv, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((parambajv == null) || (paramContext == null)) {
      return;
    }
    if (!TextUtils.isEmpty(parambajv.jdField_b_of_type_JavaLangString))
    {
      a(paramContext, parambajv.jdField_b_of_type_JavaLangString, 1);
      return;
    }
    String str = bakx.a(parambajv.jdField_a_of_type_JavaLangString);
    int i;
    switch (parambajv.jdField_a_of_type_Int)
    {
    default: 
      str = null;
      i = 0;
    }
    for (;;)
    {
      if ((parambajv.jdField_a_of_type_Int != 602) && (parambajv.jdField_a_of_type_Int != 604) && (parambajv.jdField_a_of_type_Int != 605)) {
        break label1264;
      }
      if (BaseActivity.sTopActivity == null) {
        break;
      }
      bidv.a(paramQQAppInterface, BaseActivity.sTopActivity, BaseActivity.sTopActivity.getTitleBarHeight());
      return;
      str = a(paramQQAppInterface, 2131697938);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697863);
      i = 0;
      continue;
      a(paramContext, paramLong);
      str = null;
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698028, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698026, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698027);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698025);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131698029);
      i = 2;
      continue;
      str = a(paramQQAppInterface, 2131697566, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697564);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697565);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131698021);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131698049);
      axqy.b(paramQQAppInterface, "P_CliOper", "Grp_files", "", "power", "nopower_upload", 0, 0, String.format("%d", new Object[] { Long.valueOf(paramLong) }), "2", "", "");
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698047, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698042, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697985, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698044, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698043, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697938);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697622);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697623);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697583);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697579);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697581, new Object[] { str });
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697582, new Object[] { str });
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697580, new Object[] { str });
      i = 0;
      continue;
      if (azpj.a(parambajv.jdField_b_of_type_Int))
      {
        str = a(paramQQAppInterface, 2131698041, new Object[] { str });
        i = 1;
      }
      else
      {
        str = a(paramQQAppInterface, 2131697578, new Object[] { str });
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131698021);
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131697636);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697637);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697640);
        i = 2;
        continue;
        str = a(paramQQAppInterface, 2131697641);
        i = 1;
        continue;
        str = parambajv.jdField_b_of_type_JavaLangString;
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697642);
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131697644);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697643);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697645);
        i = 1;
        continue;
        if (!TextUtils.isEmpty(parambajv.jdField_b_of_type_JavaLangString))
        {
          str = parambajv.jdField_b_of_type_JavaLangString;
          i = 0;
        }
        else
        {
          str = a(paramQQAppInterface, 2131697646);
          i = 0;
          continue;
          str = a(paramQQAppInterface, 2131697639);
          i = 2;
          continue;
          str = a(paramQQAppInterface, 2131697638);
          i = 0;
        }
      }
    }
    label1264:
    if ((parambajv.jdField_a_of_type_Int == 601) || (parambajv.jdField_a_of_type_Int == 605) || (parambajv.jdField_a_of_type_Int == 802) || (parambajv.jdField_a_of_type_Int == 604) || (parambajv.jdField_a_of_type_Int == 702))
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
      paramQQAppInterface = (ajsx)paramQQAppInterface.a(22);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(new bajv(paramString, paramLong, paramInt1, paramInt2));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (bicz.a())
    {
      if (bicz.b()) {
        bicz.a(paramQQAppInterface);
      }
    }
    else {
      return;
    }
    a(paramContext, paramString, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bajv parambajv)
  {
    if ((paramQQAppInterface == null) || (parambajv == null) || (parambajv.jdField_a_of_type_Int == 0)) {}
    do
    {
      return;
      paramQQAppInterface = (ajsx)paramQQAppInterface.a(22);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(parambajv);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bajx parambajx)
  {
    if ((a != null) && (a.get() != null))
    {
      paramQQAppInterface.removeObserver((ajte)a.get());
      a = null;
    }
    a = new WeakReference(parambajx);
    paramQQAppInterface.addObserver(parambajx);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, bajx parambajx)
  {
    paramQQAppInterface.removeObserver(parambajx);
    if ((a != null) && (a.get() == parambajx)) {
      a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bajt
 * JD-Core Version:    0.7.0.1
 */