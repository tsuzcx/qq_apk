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

public class bcmp
{
  public static WeakReference<bcmt> a = new WeakReference(null);
  
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
    bcmq localbcmq = new bcmq(paramLong);
    bdgm.a(paramContext, 230, paramContext.getResources().getString(2131698040), paramContext.getResources().getString(2131698041), 2131698093, 2131697727, localbcmq, localbcmq).show();
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
      i = paramContext.getResources().getDimensionPixelSize(2131298914);
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
  
  public static void a(bcmr parambcmr, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((parambcmr == null) || (paramContext == null)) {
      return;
    }
    if (!TextUtils.isEmpty(parambcmr.jdField_b_of_type_JavaLangString))
    {
      a(paramContext, parambcmr.jdField_b_of_type_JavaLangString, 1);
      return;
    }
    String str = bcnt.a(parambcmr.jdField_a_of_type_JavaLangString);
    int i;
    switch (parambcmr.jdField_a_of_type_Int)
    {
    default: 
      str = null;
      i = 0;
    }
    for (;;)
    {
      if ((parambcmr.jdField_a_of_type_Int != 602) && (parambcmr.jdField_a_of_type_Int != 604) && (parambcmr.jdField_a_of_type_Int != 605)) {
        break label1264;
      }
      if (BaseActivity.sTopActivity == null) {
        break;
      }
      bkjy.a(paramQQAppInterface, BaseActivity.sTopActivity, BaseActivity.sTopActivity.getTitleBarHeight());
      return;
      str = a(paramQQAppInterface, 2131698117);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698042);
      i = 0;
      continue;
      a(paramContext, paramLong);
      str = null;
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698207, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698205, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698206);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698204);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131698208);
      i = 2;
      continue;
      str = a(paramQQAppInterface, 2131697743, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697741);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697742);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131698200);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131698228);
      azqs.b(paramQQAppInterface, "P_CliOper", "Grp_files", "", "power", "nopower_upload", 0, 0, String.format("%d", new Object[] { Long.valueOf(paramLong) }), "2", "", "");
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698226, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698221, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698164, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698223, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698222, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698117);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697799);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697800);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697760);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697756);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697758, new Object[] { str });
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697759, new Object[] { str });
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697757, new Object[] { str });
      i = 0;
      continue;
      if (bbsb.a(parambcmr.jdField_b_of_type_Int))
      {
        str = a(paramQQAppInterface, 2131698220, new Object[] { str });
        i = 1;
      }
      else
      {
        str = a(paramQQAppInterface, 2131697755, new Object[] { str });
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131698200);
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131697813);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697814);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697817);
        i = 2;
        continue;
        str = a(paramQQAppInterface, 2131697818);
        i = 1;
        continue;
        str = parambcmr.jdField_b_of_type_JavaLangString;
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697819);
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131697821);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697820);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697822);
        i = 1;
        continue;
        if (!TextUtils.isEmpty(parambcmr.jdField_b_of_type_JavaLangString))
        {
          str = parambcmr.jdField_b_of_type_JavaLangString;
          i = 0;
        }
        else
        {
          str = a(paramQQAppInterface, 2131697823);
          i = 0;
          continue;
          str = a(paramQQAppInterface, 2131697816);
          i = 2;
          continue;
          str = a(paramQQAppInterface, 2131697815);
          i = 0;
        }
      }
    }
    label1264:
    if ((parambcmr.jdField_a_of_type_Int == 601) || (parambcmr.jdField_a_of_type_Int == 605) || (parambcmr.jdField_a_of_type_Int == 802) || (parambcmr.jdField_a_of_type_Int == 604) || (parambcmr.jdField_a_of_type_Int == 702))
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
      paramQQAppInterface = (aloz)paramQQAppInterface.a(22);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(new bcmr(paramString, paramLong, paramInt1, paramInt2));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (bkjc.a())
    {
      if (bkjc.b()) {
        bkjc.a(paramQQAppInterface);
      }
    }
    else {
      return;
    }
    a(paramContext, paramString, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bcmr parambcmr)
  {
    if ((paramQQAppInterface == null) || (parambcmr == null) || (parambcmr.jdField_a_of_type_Int == 0)) {}
    do
    {
      return;
      paramQQAppInterface = (aloz)paramQQAppInterface.a(22);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(parambcmr);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bcmt parambcmt)
  {
    if ((a != null) && (a.get() != null))
    {
      paramQQAppInterface.removeObserver((alpg)a.get());
      a = null;
    }
    a = new WeakReference(parambcmt);
    paramQQAppInterface.addObserver(parambcmt);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, bcmt parambcmt)
  {
    paramQQAppInterface.removeObserver(parambcmt);
    if ((a != null) && (a.get() == parambcmt)) {
      a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmp
 * JD-Core Version:    0.7.0.1
 */