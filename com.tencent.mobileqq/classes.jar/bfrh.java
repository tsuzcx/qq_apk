import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileError.1;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class bfrh
{
  public static WeakReference<bfrl> a = new WeakReference(null);
  
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
    bfri localbfri = new bfri(paramLong);
    bglp.a(paramContext, 230, paramContext.getResources().getString(2131696886), paramContext.getResources().getString(2131696887), 2131696940, 2131696569, localbfri, localbfri).show();
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
      i = paramContext.getResources().getDimensionPixelSize(2131298998);
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
  
  public static void a(bfrj parambfrj, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((parambfrj == null) || (paramContext == null)) {
      return;
    }
    if (!TextUtils.isEmpty(parambfrj.jdField_b_of_type_JavaLangString))
    {
      a(paramContext, parambfrj.jdField_b_of_type_JavaLangString, 1);
      return;
    }
    String str = bfsj.a(parambfrj.jdField_a_of_type_JavaLangString);
    int i;
    switch (parambfrj.jdField_a_of_type_Int)
    {
    default: 
      str = null;
      i = 0;
    }
    for (;;)
    {
      if ((parambfrj.jdField_a_of_type_Int != 602) && (parambfrj.jdField_a_of_type_Int != 604) && (parambfrj.jdField_a_of_type_Int != 605)) {
        break label1264;
      }
      if (BaseActivity.sTopActivity == null) {
        break;
      }
      bmyl.a(paramQQAppInterface, BaseActivity.sTopActivity, BaseActivity.sTopActivity.getTitleBarHeight());
      return;
      str = a(paramQQAppInterface, 2131696964);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131696888);
      i = 0;
      continue;
      a(paramContext, paramLong);
      str = null;
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697058, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697056, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697057);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697055);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697059);
      i = 2;
      continue;
      str = a(paramQQAppInterface, 2131696585, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131696583);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131696584);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697051);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697079);
      bcst.b(paramQQAppInterface, "P_CliOper", "Grp_files", "", "power", "nopower_upload", 0, 0, String.format("%d", new Object[] { Long.valueOf(paramLong) }), "2", "", "");
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697077, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697072, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697014, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697074, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697073, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131696964);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131696641);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131696642);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131696602);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131696598);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131696600, new Object[] { str });
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131696601, new Object[] { str });
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131696599, new Object[] { str });
      i = 0;
      continue;
      if (besm.a(parambfrj.jdField_b_of_type_Int))
      {
        str = a(paramQQAppInterface, 2131697071, new Object[] { str });
        i = 1;
      }
      else
      {
        str = a(paramQQAppInterface, 2131696597, new Object[] { str });
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131697051);
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131696655);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131696656);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131696659);
        i = 2;
        continue;
        str = a(paramQQAppInterface, 2131696660);
        i = 1;
        continue;
        str = parambfrj.jdField_b_of_type_JavaLangString;
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131696661);
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131696663);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131696662);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131696664);
        i = 1;
        continue;
        if (!TextUtils.isEmpty(parambfrj.jdField_b_of_type_JavaLangString))
        {
          str = parambfrj.jdField_b_of_type_JavaLangString;
          i = 0;
        }
        else
        {
          str = a(paramQQAppInterface, 2131696665);
          i = 0;
          continue;
          str = a(paramQQAppInterface, 2131696658);
          i = 2;
          continue;
          str = a(paramQQAppInterface, 2131696657);
          i = 0;
        }
      }
    }
    label1264:
    if ((parambfrj.jdField_a_of_type_Int == 601) || (parambfrj.jdField_a_of_type_Int == 605) || (parambfrj.jdField_a_of_type_Int == 802) || (parambfrj.jdField_a_of_type_Int == 604) || (parambfrj.jdField_a_of_type_Int == 702))
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
      paramQQAppInterface = (anie)paramQQAppInterface.a(22);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(new bfrj(paramString, paramLong, paramInt1, paramInt2));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (bmxr.a())
    {
      if (bmxr.b()) {
        bmxr.a(paramQQAppInterface);
      }
    }
    else {
      return;
    }
    a(paramContext, paramString, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bfrj parambfrj)
  {
    if ((paramQQAppInterface == null) || (parambfrj == null) || (parambfrj.jdField_a_of_type_Int == 0)) {}
    do
    {
      return;
      paramQQAppInterface = (anie)paramQQAppInterface.a(22);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(parambfrj);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bfrl parambfrl)
  {
    if ((a != null) && (a.get() != null))
    {
      paramQQAppInterface.removeObserver((anil)a.get());
      a = null;
    }
    a = new WeakReference(parambfrl);
    paramQQAppInterface.addObserver(parambfrl);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, bfrl parambfrl)
  {
    paramQQAppInterface.removeObserver(parambfrl);
    if ((a != null) && (a.get() == parambfrl)) {
      a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfrh
 * JD-Core Version:    0.7.0.1
 */