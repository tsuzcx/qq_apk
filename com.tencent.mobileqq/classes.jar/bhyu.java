import MQQ.LhLogoInfo;
import MQQ.LhLogoResources;
import MQQ.VAResourcesRsp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class bhyu
{
  public static long a;
  private static Map<Integer, LhLogoResources> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  static int[] jdField_a_of_type_ArrayOfInt = { 37, 9, 35, 36, 38 };
  public static long b;
  
  static
  {
    jdField_a_of_type_Long = 1594224000L;
  }
  
  public static int a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("pretty_account_info", 0).getInt("lh_flag_" + a(), 0);
  }
  
  public static int a(Card paramCard)
  {
    if (paramCard == null) {}
    while ((paramCard.lUserFlag & 0x400) != 1024L) {
      return 0;
    }
    return 1;
  }
  
  public static LhLogoResources a(int paramInt)
  {
    LhLogoResources localLhLogoResources = (LhLogoResources)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("pretty_account exist:").append(paramInt).append(",");
      if (localLhLogoResources == null) {
        break label66;
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("PrettyAccountUtil", 2, bool);
      return localLhLogoResources;
    }
  }
  
  public static TextView a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    if ((!a()) || (1 != paramInt1)) {}
    do
    {
      return paramTextView;
      localObject1 = a(paramInt2);
    } while (localObject1 == null);
    Resources localResources = paramTextView.getContext().getResources();
    paramTextView.setGravity(16);
    paramTextView.setTextSize(14.0F);
    paramTextView.setTextColor(Color.parseColor(((LhLogoResources)localObject1).normalColor));
    paramTextView.setPadding(0, 0, 0, 0);
    Object localObject2 = new Rect();
    String str = paramTextView.getText().toString();
    paramTextView.getPaint().getTextBounds(str, 0, str.length(), (Rect)localObject2);
    paramInt1 = bhtq.a(26.0F);
    paramInt2 = ((Rect)localObject2).width();
    int i = bhtq.a(8.0F);
    int j = bhtq.a(23.0F);
    localObject2 = paramTextView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = (paramInt2 + paramInt1 + i);
    ((ViewGroup.LayoutParams)localObject2).height = j;
    paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramTextView.setBackgroundDrawable(VasApngUtil.getRegionUrlDrawable(((LhLogoResources)localObject1).backUrl, 320));
    Object localObject1 = VasApngUtil.getApngURLDrawable(((LhLogoResources)localObject1).apngUrl, jdField_a_of_type_ArrayOfInt, beyq.a);
    paramInt1 = agej.a(22.0F, localResources);
    ((URLDrawable)localObject1).setBounds(0, 0, paramInt1 * 26 / 22, paramInt1);
    paramTextView.setCompoundDrawables((Drawable)localObject1, null, null, null);
    return paramTextView;
  }
  
  public static CharSequence a(int paramInt1, int paramInt2, boolean paramBoolean, CharSequence paramCharSequence)
  {
    if (paramInt2 < 0) {}
    while ((!a()) || (1 != paramInt1) || (jdField_a_of_type_JavaUtilMap.isEmpty())) {
      return paramCharSequence;
    }
    String str = paramCharSequence.toString().replace("QQ：", "");
    paramCharSequence = str;
    try
    {
      if (str.contains("("))
      {
        paramCharSequence = str;
        if (str.contains(")"))
        {
          paramInt1 = str.indexOf("(");
          paramInt2 = str.indexOf(")");
          if (paramBoolean) {
            paramCharSequence = str.substring(0, paramInt1);
          } else {
            paramCharSequence = str.substring(paramInt1 + 1, paramInt2);
          }
        }
      }
    }
    catch (Exception localException)
    {
      paramCharSequence = str;
      if (QLog.isColorLevel())
      {
        QLog.d("PrettyAccountUtil", 2, "pretty_account handtxt error:" + localException);
        paramCharSequence = str;
      }
    }
    return paramCharSequence;
  }
  
  private static String a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("PrettyAccountUtil", 4, "getCurrentUin = " + localAppRuntime.getAccount());
      }
      return localAppRuntime.getAccount();
    }
    return null;
  }
  
  public static void a()
  {
    String str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str2 = bhyk.a("vipPersonalCardMaster");
    Intent localIntent = new Intent(BaseApplicationImpl.getApplication(), QQBrowserActivity.class);
    localIntent.putExtra("uin", str1);
    localIntent.putExtra("url", str2);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    BaseApplicationImpl.getApplication().startActivity(localIntent);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrettyAccountUtil", 2, "pretty_account update self:" + paramInt1 + "," + paramInt2);
    }
    if (paramInt2 == -1) {
      return;
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("pretty_account_info", 0).edit();
    localEditor.putInt("lh_flag_" + a(), paramInt1);
    localEditor.putInt("lh_level_" + a(), paramInt2);
    localEditor.commit();
  }
  
  public static void a(VAResourcesRsp paramVAResourcesRsp)
  {
    boolean bool = true;
    StringBuilder localStringBuilder;
    if (paramVAResourcesRsp.lhLogoInfo != null)
    {
      paramVAResourcesRsp = paramVAResourcesRsp.lhLogoInfo;
      if ((paramVAResourcesRsp.bUpdate == 1) && (paramVAResourcesRsp.lhLogoResources != null))
      {
        jdField_a_of_type_JavaUtilMap.clear();
        jdField_a_of_type_JavaUtilMap.putAll(paramVAResourcesRsp.lhLogoResources);
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("pretty_account update state:").append(paramVAResourcesRsp.bUpdate).append(",");
        if (paramVAResourcesRsp.lhLogoResources != null) {
          break label103;
        }
      }
    }
    for (;;)
    {
      QLog.d("PrettyAccountUtil", 2, bool);
      return;
      label103:
      bool = false;
    }
  }
  
  public static void a(TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean, CharSequence paramCharSequence)
  {
    paramTextView.setText(a(paramInt1, paramInt2, paramBoolean, paramCharSequence));
    a(paramTextView, paramInt1, paramInt2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, azxr paramazxr, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramazxr == null) || (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {}
    do
    {
      return;
      if (paramBoolean) {
        break;
      }
    } while (System.currentTimeMillis() - b < 1500L);
    b = System.currentTimeMillis();
    if (TextUtils.isEmpty(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d)) {
      if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(paramQQAppInterface.getCurrentAccountUin())) {
        if (paramBoolean) {
          paramQQAppInterface = "0X800B22E";
        }
      }
    }
    for (;;)
    {
      a(paramQQAppInterface, a(paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard), paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.lhLevel);
      return;
      paramQQAppInterface = "0X800B22D";
      continue;
      if (paramBoolean)
      {
        paramQQAppInterface = "0X800B230";
      }
      else
      {
        paramQQAppInterface = "0X800B22F";
        continue;
        if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(paramQQAppInterface.getCurrentAccountUin()))
        {
          if (paramBoolean) {
            paramQQAppInterface = "0X800B234";
          } else {
            paramQQAppInterface = "0X800B233";
          }
        }
        else if (paramBoolean) {
          paramQQAppInterface = "0X800B236";
        } else {
          paramQQAppInterface = "0X800B235";
        }
      }
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((!a()) || (1 != paramInt1)) {}
    AppRuntime localAppRuntime;
    do
    {
      return;
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localAppRuntime instanceof QQAppInterface));
    bdll.b((QQAppInterface)localAppRuntime, "dc00898", "", "", "", paramString, paramInt2, 0, "", "", "", "");
  }
  
  public static boolean a()
  {
    arnm localarnm = arnn.c();
    if (QLog.isColorLevel()) {
      QLog.d("PrettyAccountUtil", 2, "pretty_account manageOpen:" + localarnm.a);
    }
    return localarnm.a;
  }
  
  public static int b()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("pretty_account_info", 0).getInt("lh_level_" + a(), -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhyu
 * JD-Core Version:    0.7.0.1
 */