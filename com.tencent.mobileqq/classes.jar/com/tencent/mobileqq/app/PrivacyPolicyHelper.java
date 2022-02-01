package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class PrivacyPolicyHelper
{
  private static PrivacyPolicyHelper.MyLinkMovementMethod jdField_a_of_type_ComTencentMobileqqAppPrivacyPolicyHelper$MyLinkMovementMethod;
  private static boolean jdField_a_of_type_Boolean;
  
  private static SpannableString a(Context paramContext, String paramString)
  {
    SpannableString localSpannableString = new SpannableString(paramContext.getString(2131699033));
    localSpannableString.setSpan(new PrivacyPolicyHelper.ClickSpan(paramContext, paramString, "https://ti.qq.com/agreement/index.html"), 114, 120, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(-12541697), 114, 120, 17);
    localSpannableString.setSpan(new PrivacyPolicyHelper.ClickSpan(paramContext, paramString, "https://ti.qq.com/agreement/privacy/index.html"), 121, 127, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(-12541697), 121, 127, 17);
    localSpannableString.setSpan(new PrivacyPolicyHelper.ClickSpan(paramContext, paramString, "https://ti.qq.com/agreement/privateProtocal.html"), 128, 136, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(-12541697), 128, 136, 17);
    return localSpannableString;
  }
  
  public static MovementMethod a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppPrivacyPolicyHelper$MyLinkMovementMethod == null) {
      jdField_a_of_type_ComTencentMobileqqAppPrivacyPolicyHelper$MyLinkMovementMethod = new PrivacyPolicyHelper.MyLinkMovementMethod();
    }
    return jdField_a_of_type_ComTencentMobileqqAppPrivacyPolicyHelper$MyLinkMovementMethod;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = a(paramContext, paramString);
    paramOnClickListener1 = new PrivacyPolicyHelper.1(paramOnClickListener1);
    paramOnClickListener2 = new PrivacyPolicyHelper.2(paramOnClickListener2);
    paramContext = DialogUtil.a(paramContext, 0, paramContext.getString(2131699038), paramString.toString(), 2131699036, 2131699032, paramOnClickListener2, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramOnClickListener1 = (TextView)paramContext.findViewById(2131365807);
    paramOnClickListener1.setText(paramString);
    paramOnClickListener1.setTextSize(1, 13.0F);
    paramOnClickListener1.setHighlightColor(0);
    paramOnClickListener1.setMovementMethod(a());
    ((TextView)paramContext.findViewById(2131365802)).setTextColor(Color.parseColor("#40A0FF"));
    paramContext.show();
    return paramContext;
  }
  
  public static String a()
  {
    String str2 = SharePreferenceUtils.a(BaseApplication.getContext(), "privacypolicy_state");
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
  
  public static void a(String paramString)
  {
    SharePreferenceUtils.a(BaseApplication.getContext(), "privacypolicy_state", paramString);
    QLog.d("PrivacyPolicyHelper", 1, "setPrivacyPolicyStatus, state=" + paramString);
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
    String str2 = SharePreferenceUtils.a(BaseApplication.getContext(), "privacypolicy_show_reddot");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "0";
    }
    return str1;
  }
  
  public static void b(String paramString)
  {
    SharePreferenceUtils.a(BaseApplication.getContext(), "privacypolicy_show_reddot", paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrivacyPolicyHelper
 * JD-Core Version:    0.7.0.1
 */