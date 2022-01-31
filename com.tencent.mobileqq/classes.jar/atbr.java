import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyUtils.1;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

public final class atbr
{
  public static String a(int paramInt)
  {
    String str = "4";
    if (paramInt == 14) {
      str = "1";
    }
    do
    {
      return str;
      if (paramInt == 15) {
        return "2";
      }
    } while (paramInt != 16);
    return "3";
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = Pattern.compile("\n").matcher(paramString).replaceAll("");
    paramString = Pattern.compile("^ +").matcher(paramString).replaceAll("");
    return Pattern.compile(" +$").matcher(paramString).replaceAll("");
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    int i = 0;
    boolean bool;
    switch (paramInt)
    {
    case 3: 
    default: 
      bool = false;
    }
    StringBuilder localStringBuilder;
    while (bool)
    {
      localStringBuilder = new StringBuilder(100);
      localStringBuilder.append(paramString2);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        int j = paramVarArgs.length;
        for (;;)
        {
          if (i < j)
          {
            paramString2 = paramVarArgs[i];
            localStringBuilder.append(",").append(paramString2);
            i += 1;
            continue;
            bool = QLog.isColorLevel();
            break;
            bool = QLog.isDevelopLevel();
            break;
          }
        }
      }
      if ((paramInt != 4) || (!QLog.isDevelopLevel())) {
        break label142;
      }
      QLog.i(paramString1, 4, localStringBuilder.toString());
    }
    label142:
    while ((paramInt != 2) || (!QLog.isColorLevel())) {
      return;
    }
    QLog.i(paramString1, 2, localStringBuilder.toString());
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, BindNumberActivity.class);
    localIntent.putExtra("kSrouce", 20);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(EditText paramEditText, int paramInt)
  {
    String str = paramEditText.getText().toString();
    if (str.getBytes().length > paramInt)
    {
      while (str.getBytes().length > paramInt) {
        str = str.substring(0, str.length() - 1);
      }
      paramEditText.setText(str);
    }
    try
    {
      paramEditText.setSelection(str.length());
      return;
    }
    catch (Exception paramEditText)
    {
      QLog.e("NearbyUtils", 1, " truncateEditText error", paramEditText);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyUtils", 2, "targetUin:" + paramString + "|type:" + paramInt);
    }
    ThreadManager.post(new NearbyUtils.1(paramString, paramInt, paramQQAppInterface), 8, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      paramString2 = "";
    }
    for (;;)
    {
      axqy.b(paramQQAppInterface, "dc00899", "grp_lbs", paramString2, "talk_safety_check", paramString1, 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("nearby.bindphone", 2, "report talk check: action=" + paramString1 + ", toUin=" + paramString2);
      }
      return;
    }
  }
  
  public static void a(NearbyAppInterface paramNearbyAppInterface, String paramString, int paramInt)
  {
    if (paramInt > 0) {}
    for (String str = String.valueOf(paramInt);; str = "")
    {
      paramInt = ((Integer)atbi.a(paramNearbyAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
      axqy.b(null, "dc00899", "grp_lbs", "", "home", paramString, 0, 0, str, String.valueOf(paramInt), "", "");
      if (QLog.isColorLevel()) {
        QLog.d("NearbyUtils", 2, "reportHomeEvent: actionName=" + paramString + ",d1[tabType]=" + str + ", d2[gender]=" + paramInt);
      }
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2).append(", [");
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramVarArgs[i]).append(",");
        i += 1;
      }
      localStringBuilder.append("]");
      QLog.i(paramString1, 4, localStringBuilder.toString());
    }
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString).append(", [");
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramVarArgs[i]).append(",");
        i += 1;
      }
      localStringBuilder.append("]");
      QLog.i("Q.nearby", 2, localStringBuilder.toString());
    }
  }
  
  public static boolean a()
  {
    return QLog.isDevelopLevel();
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 21) || (paramInt == 22) || (paramInt == 23) || (paramInt == 28) || (paramInt == 48);
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null) {
        return paramContext.isAvailable();
      }
    }
    return false;
  }
  
  public static boolean b()
  {
    return QLog.isColorLevel();
  }
  
  public static boolean c()
  {
    return BaseApplicationImpl.getApplication().waitAppRuntime(null).getAppRuntime("module_nearby") instanceof NearbyAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atbr
 * JD-Core Version:    0.7.0.1
 */