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
  private static PrivacyPolicyHelper.MyLinkMovementMethod a;
  private static boolean b;
  
  private static SpannableString a(Context paramContext, String paramString)
  {
    SpannableString localSpannableString = new SpannableString(paramContext.getString(2131897153));
    localSpannableString.setSpan(new PrivacyPolicyHelper.ClickSpan(paramContext, paramString, "https://ti.qq.com/agreement/index.html"), 114, 120, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(-12541697), 114, 120, 17);
    localSpannableString.setSpan(new PrivacyPolicyHelper.ClickSpan(paramContext, paramString, "https://ti.qq.com/agreement/privacy/index.html"), 121, 127, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(-12541697), 121, 127, 17);
    localSpannableString.setSpan(new PrivacyPolicyHelper.ClickSpan(paramContext, paramString, "https://ti.qq.com/agreement/privateProtocal.html"), 128, 136, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(-12541697), 128, 136, 17);
    return localSpannableString;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = a(paramContext, paramString);
    paramOnClickListener1 = new PrivacyPolicyHelper.1(paramOnClickListener1);
    paramOnClickListener2 = new PrivacyPolicyHelper.2(paramOnClickListener2);
    paramContext = DialogUtil.a(paramContext, 0, paramContext.getString(2131897158), paramString.toString(), 2131897156, 2131897152, paramOnClickListener2, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramOnClickListener1 = (TextView)paramContext.findViewById(2131431876);
    paramOnClickListener1.setText(paramString);
    paramOnClickListener1.setTextSize(1, 13.0F);
    paramOnClickListener1.setHighlightColor(0);
    paramOnClickListener1.setMovementMethod(f());
    ((TextView)paramContext.findViewById(2131431870)).setTextColor(Color.parseColor("#40A0FF"));
    paramContext.show();
    return paramContext;
  }
  
  public static void a()
  {
    b();
  }
  
  public static void a(String paramString)
  {
    SharePreferenceUtils.a(BaseApplication.getContext(), "privacypolicy_state", paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPrivacyPolicyStatus, state=");
    localStringBuilder.append(paramString);
    QLog.d("PrivacyPolicyHelper", 1, localStringBuilder.toString());
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = b().equals("0");
    boolean bool1;
    if (paramInt == 0)
    {
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (e()) {
          bool1 = false;
        }
      }
    }
    else
    {
      bool1 = bool2;
      if (paramInt == 1)
      {
        bool1 = bool2;
        if (bool2)
        {
          b("1");
          bool1 = bool2;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("needShowPrivacyPolicy, needShow=");
      localStringBuilder.append(bool1);
      localStringBuilder.append(", from=");
      localStringBuilder.append(paramInt);
      QLog.d("PrivacyPolicyHelper", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public static String b()
  {
    String str2 = SharePreferenceUtils.a(BaseApplication.getContext(), "privacypolicy_state");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "0";
    }
    return str1;
  }
  
  public static void b(String paramString)
  {
    SharePreferenceUtils.a(BaseApplication.getContext(), "privacypolicy_show_reddot", paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setHasShowRedDotState, state=");
      localStringBuilder.append(paramString);
      QLog.d("PrivacyPolicyHelper", 2, localStringBuilder.toString());
    }
  }
  
  public static String c()
  {
    String str2 = SharePreferenceUtils.a(BaseApplication.getContext(), "privacypolicy_show_reddot");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "0";
    }
    return str1;
  }
  
  public static boolean d()
  {
    if ((!b) && (b().equals("1"))) {
      b = true;
    }
    return b;
  }
  
  public static boolean e()
  {
    boolean bool = c().equals("1");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasShowRedDotState, hasShow=");
      localStringBuilder.append(bool);
      QLog.d("PrivacyPolicyHelper", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public static MovementMethod f()
  {
    if (a == null) {
      a = new PrivacyPolicyHelper.MyLinkMovementMethod();
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrivacyPolicyHelper
 * JD-Core Version:    0.7.0.1
 */