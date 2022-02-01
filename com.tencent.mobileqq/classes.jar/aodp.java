import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aodp
{
  private static aodt jdField_a_of_type_Aodt;
  private static boolean jdField_a_of_type_Boolean;
  
  public static MovementMethod a()
  {
    if (jdField_a_of_type_Aodt == null) {
      jdField_a_of_type_Aodt = new aodt();
    }
    return jdField_a_of_type_Aodt;
  }
  
  public static bhpc a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, null, null);
  }
  
  public static bhpc a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    SpannableString localSpannableString = new SpannableString(paramContext.getString(2131698268));
    localSpannableString.setSpan(new aods(paramContext, paramString, "https://ti.qq.com/agreement/index.html"), 114, 120, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(-12541697), 114, 120, 17);
    localSpannableString.setSpan(new aods(paramContext, paramString, "https://ti.qq.com/agreement/privacy/index.html"), 121, 127, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(-12541697), 121, 127, 17);
    localSpannableString.setSpan(new aods(paramContext, paramString, "https://ti.qq.com/agreement/privateProtocal.html"), 128, 136, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(-12541697), 128, 136, 17);
    paramString = new aodq(paramOnClickListener1);
    paramOnClickListener1 = new aodr(paramOnClickListener2);
    paramContext = bhlq.a(paramContext, 0, paramContext.getString(2131698270), localSpannableString.toString(), 2131698269, 2131698267, paramOnClickListener1, paramString);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramString = (TextView)paramContext.findViewById(2131365519);
    paramString.setText(localSpannableString);
    paramString.setTextSize(1, 13.0F);
    paramString.setHighlightColor(0);
    paramString.setMovementMethod(a());
    ((TextView)paramContext.findViewById(2131365514)).setTextColor(Color.parseColor("#40A0FF"));
    paramContext.show();
    return paramContext;
  }
  
  public static String a()
  {
    String str2 = bhjc.a(BaseApplication.getContext(), "privacypolicy_state");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "0";
    }
    return str1;
  }
  
  public static void a()
  {
    a();
  }
  
  public static void a(RedTouch paramRedTouch)
  {
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    localRedTypeInfo.red_type.set(0);
    localRedTypeInfo.red_desc.set("");
    localRedTypeInfo.red_content.set("");
    localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
    localAppInfo.iNewFlag.set(1);
    paramRedTouch.a(localRedTypeInfo);
  }
  
  public static void a(String paramString)
  {
    bhjc.a(BaseApplication.getContext(), "privacypolicy_state", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("PrivacyPolicyHelper", 2, "setPrivacyPolicyStatus, state=" + paramString);
    }
  }
  
  public static boolean a()
  {
    if ((!jdField_a_of_type_Boolean) && (a().equals("1"))) {
      jdField_a_of_type_Boolean = true;
    }
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool3 = false;
    if (a().equals("0")) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2;
      if (paramInt == 0)
      {
        bool2 = bool1;
        if (bool1)
        {
          if (!b()) {
            break label100;
          }
          bool1 = bool3;
        }
      }
      label100:
      for (;;)
      {
        bool2 = bool1;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PrivacyPolicyHelper", 2, "needShowPrivacyPolicy, needShow=" + bool2 + ", from=" + paramInt);
          }
          return bool2;
          bool2 = bool1;
          if (paramInt == 1)
          {
            bool2 = bool1;
            if (bool1)
            {
              b("1");
              bool2 = bool1;
            }
          }
        }
      }
    }
  }
  
  public static String b()
  {
    String str2 = bhjc.a(BaseApplication.getContext(), "privacypolicy_show_reddot");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "0";
    }
    return str1;
  }
  
  public static void b(String paramString)
  {
    bhjc.a(BaseApplication.getContext(), "privacypolicy_show_reddot", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("PrivacyPolicyHelper", 2, "setHasShowRedDotState, state=" + paramString);
    }
  }
  
  public static boolean b()
  {
    boolean bool = false;
    if (b().equals("1")) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrivacyPolicyHelper", 2, "hasShowRedDotState, hasShow=" + bool);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aodp
 * JD-Core Version:    0.7.0.1
 */