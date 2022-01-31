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

public class bcig
{
  public static WeakReference<bcik> a = new WeakReference(null);
  
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
    bcih localbcih = new bcih(paramLong);
    bdcd.a(paramContext, 230, paramContext.getResources().getString(2131698038), paramContext.getResources().getString(2131698039), 2131698091, 2131697725, localbcih, localbcih).show();
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
  
  public static void a(bcii parambcii, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((parambcii == null) || (paramContext == null)) {
      return;
    }
    if (!TextUtils.isEmpty(parambcii.jdField_b_of_type_JavaLangString))
    {
      a(paramContext, parambcii.jdField_b_of_type_JavaLangString, 1);
      return;
    }
    String str = bcjk.a(parambcii.jdField_a_of_type_JavaLangString);
    int i;
    switch (parambcii.jdField_a_of_type_Int)
    {
    default: 
      str = null;
      i = 0;
    }
    for (;;)
    {
      if ((parambcii.jdField_a_of_type_Int != 602) && (parambcii.jdField_a_of_type_Int != 604) && (parambcii.jdField_a_of_type_Int != 605)) {
        break label1264;
      }
      if (BaseActivity.sTopActivity == null) {
        break;
      }
      bkfr.a(paramQQAppInterface, BaseActivity.sTopActivity, BaseActivity.sTopActivity.getTitleBarHeight());
      return;
      str = a(paramQQAppInterface, 2131698115);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698040);
      i = 0;
      continue;
      a(paramContext, paramLong);
      str = null;
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698205, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698203, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698204);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698202);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131698206);
      i = 2;
      continue;
      str = a(paramQQAppInterface, 2131697741, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697739);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697740);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131698198);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131698226);
      azmj.b(paramQQAppInterface, "P_CliOper", "Grp_files", "", "power", "nopower_upload", 0, 0, String.format("%d", new Object[] { Long.valueOf(paramLong) }), "2", "", "");
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698224, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698219, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698162, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698221, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698220, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131698115);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697797);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697798);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697758);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697754);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697756, new Object[] { str });
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697757, new Object[] { str });
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697755, new Object[] { str });
      i = 0;
      continue;
      if (bbns.a(parambcii.jdField_b_of_type_Int))
      {
        str = a(paramQQAppInterface, 2131698218, new Object[] { str });
        i = 1;
      }
      else
      {
        str = a(paramQQAppInterface, 2131697753, new Object[] { str });
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131698198);
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131697811);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697812);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697815);
        i = 2;
        continue;
        str = a(paramQQAppInterface, 2131697816);
        i = 1;
        continue;
        str = parambcii.jdField_b_of_type_JavaLangString;
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697817);
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131697819);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697818);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697820);
        i = 1;
        continue;
        if (!TextUtils.isEmpty(parambcii.jdField_b_of_type_JavaLangString))
        {
          str = parambcii.jdField_b_of_type_JavaLangString;
          i = 0;
        }
        else
        {
          str = a(paramQQAppInterface, 2131697821);
          i = 0;
          continue;
          str = a(paramQQAppInterface, 2131697814);
          i = 2;
          continue;
          str = a(paramQQAppInterface, 2131697813);
          i = 0;
        }
      }
    }
    label1264:
    if ((parambcii.jdField_a_of_type_Int == 601) || (parambcii.jdField_a_of_type_Int == 605) || (parambcii.jdField_a_of_type_Int == 802) || (parambcii.jdField_a_of_type_Int == 604) || (parambcii.jdField_a_of_type_Int == 702))
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
      paramQQAppInterface = (alkk)paramQQAppInterface.a(22);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(new bcii(paramString, paramLong, paramInt1, paramInt2));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (bkev.a())
    {
      if (bkev.b()) {
        bkev.a(paramQQAppInterface);
      }
    }
    else {
      return;
    }
    a(paramContext, paramString, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bcii parambcii)
  {
    if ((paramQQAppInterface == null) || (parambcii == null) || (parambcii.jdField_a_of_type_Int == 0)) {}
    do
    {
      return;
      paramQQAppInterface = (alkk)paramQQAppInterface.a(22);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(parambcii);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bcik parambcik)
  {
    if ((a != null) && (a.get() != null))
    {
      paramQQAppInterface.removeObserver((alkr)a.get());
      a = null;
    }
    a = new WeakReference(parambcik);
    paramQQAppInterface.addObserver(parambcik);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, bcik parambcik)
  {
    paramQQAppInterface.removeObserver(parambcik);
    if ((a != null) && (a.get() == parambcik)) {
      a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcig
 * JD-Core Version:    0.7.0.1
 */