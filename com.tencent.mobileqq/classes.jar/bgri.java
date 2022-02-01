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

public class bgri
{
  public static WeakReference<bgrm> a = new WeakReference(null);
  
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
    bgrj localbgrj = new bgrj(paramLong);
    bhlq.a(paramContext, 230, paramContext.getResources().getString(2131696935), paramContext.getResources().getString(2131696936), 2131696989, 2131696618, localbgrj, localbgrj).show();
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
      i = paramContext.getResources().getDimensionPixelSize(2131299011);
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
  
  public static void a(bgrk parambgrk, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((parambgrk == null) || (paramContext == null)) {
      return;
    }
    if (!TextUtils.isEmpty(parambgrk.jdField_b_of_type_JavaLangString))
    {
      a(paramContext, parambgrk.jdField_b_of_type_JavaLangString, 1);
      return;
    }
    String str = bgsk.a(parambgrk.jdField_a_of_type_JavaLangString);
    int i;
    switch (parambgrk.jdField_a_of_type_Int)
    {
    default: 
      str = null;
      i = 0;
    }
    for (;;)
    {
      if ((parambgrk.jdField_a_of_type_Int != 602) && (parambgrk.jdField_a_of_type_Int != 604) && (parambgrk.jdField_a_of_type_Int != 605)) {
        break label1264;
      }
      if (BaseActivity.sTopActivity == null) {
        break;
      }
      bnzt.a(paramQQAppInterface, BaseActivity.sTopActivity, BaseActivity.sTopActivity.getTitleBarHeight());
      return;
      str = a(paramQQAppInterface, 2131697013);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131696937);
      i = 0;
      continue;
      a(paramContext, paramLong);
      str = null;
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697107, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697105, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697106);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697104);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697108);
      i = 2;
      continue;
      str = a(paramQQAppInterface, 2131696634, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131696632);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131696633);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697100);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697128);
      bdll.b(paramQQAppInterface, "P_CliOper", "Grp_files", "", "power", "nopower_upload", 0, 0, String.format("%d", new Object[] { Long.valueOf(paramLong) }), "2", "", "");
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697126, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697121, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697063, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697123, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697122, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697013);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131696690);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131696691);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131696651);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131696647);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131696649, new Object[] { str });
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131696650, new Object[] { str });
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131696648, new Object[] { str });
      i = 0;
      continue;
      if (bfrt.a(parambgrk.jdField_b_of_type_Int))
      {
        str = a(paramQQAppInterface, 2131697120, new Object[] { str });
        i = 1;
      }
      else
      {
        str = a(paramQQAppInterface, 2131696646, new Object[] { str });
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131697100);
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131696704);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131696705);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131696708);
        i = 2;
        continue;
        str = a(paramQQAppInterface, 2131696709);
        i = 1;
        continue;
        str = parambgrk.jdField_b_of_type_JavaLangString;
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131696710);
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131696712);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131696711);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131696713);
        i = 1;
        continue;
        if (!TextUtils.isEmpty(parambgrk.jdField_b_of_type_JavaLangString))
        {
          str = parambgrk.jdField_b_of_type_JavaLangString;
          i = 0;
        }
        else
        {
          str = a(paramQQAppInterface, 2131696714);
          i = 0;
          continue;
          str = a(paramQQAppInterface, 2131696707);
          i = 2;
          continue;
          str = a(paramQQAppInterface, 2131696706);
          i = 0;
        }
      }
    }
    label1264:
    if ((parambgrk.jdField_a_of_type_Int == 601) || (parambgrk.jdField_a_of_type_Int == 605) || (parambgrk.jdField_a_of_type_Int == 802) || (parambgrk.jdField_a_of_type_Int == 604) || (parambgrk.jdField_a_of_type_Int == 702))
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
      paramQQAppInterface = (antz)paramQQAppInterface.a(22);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(new bgrk(paramString, paramLong, paramInt1, paramInt2));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (bnyz.a())
    {
      if (bnyz.b()) {
        bnyz.a(paramQQAppInterface);
      }
    }
    else {
      return;
    }
    a(paramContext, paramString, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bgrk parambgrk)
  {
    if ((paramQQAppInterface == null) || (parambgrk == null) || (parambgrk.jdField_a_of_type_Int == 0)) {}
    do
    {
      return;
      paramQQAppInterface = (antz)paramQQAppInterface.a(22);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(parambgrk);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bgrm parambgrm)
  {
    if ((a != null) && (a.get() != null))
    {
      paramQQAppInterface.removeObserver((anui)a.get());
      a = null;
    }
    a = new WeakReference(parambgrm);
    paramQQAppInterface.addObserver(parambgrm);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, bgrm parambgrm)
  {
    paramQQAppInterface.removeObserver(parambgrm);
    if ((a != null) && (a.get() == parambgrm)) {
      a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgri
 * JD-Core Version:    0.7.0.1
 */