package com.tencent.mobileqq.app.security;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.util.WeakReference;
import tencent.im.login.GatewayVerify.RspBody;
import tencent.im.login.GatewayVerify.RspLftInfo;
import tencent.im.login.GatewayVerify.RspTipsInfo;

public class FrozenNotifyDlgHelper
{
  private static volatile FrozenNotifyDlgHelper jdField_a_of_type_ComTencentMobileqqAppSecurityFrozenNotifyDlgHelper;
  private static final String jdField_a_of_type_JavaLangString = Patterns.c.pattern() + "|" + Patterns.d.pattern();
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("<TITLE=\"([^>]+)\",URL=\"([^<]+)\">");
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private FrozenNotifyDlgHelper()
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2));
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(4));
  }
  
  public static FrozenNotifyDlgHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppSecurityFrozenNotifyDlgHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppSecurityFrozenNotifyDlgHelper == null) {
        jdField_a_of_type_ComTencentMobileqqAppSecurityFrozenNotifyDlgHelper = new FrozenNotifyDlgHelper();
      }
      return jdField_a_of_type_ComTencentMobileqqAppSecurityFrozenNotifyDlgHelper;
    }
    finally {}
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    QLog.d("FrozenNotifyDlgHelper", 1, "reportFrozenDlgShow: " + paramInt + " isPwdLeaked: " + paramBoolean);
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        ReportController.a(paramQQAppInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      return;
      if (paramBoolean) {}
      for (str = "0X800B42B";; str = "0X800B435") {
        break;
      }
      str = "0X800B5E7";
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    QLog.d("FrozenNotifyDlgHelper", 1, "reportFrozenDlgActionClk: " + paramInt + " isPwdLeaked: " + paramBoolean);
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        ReportController.a(paramQQAppInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      return;
      if (paramBoolean) {}
      for (str = "0X800B42C";; str = "0X800B436") {
        break;
      }
      str = "0X800B5E8";
      continue;
      str = "0X800B5E9";
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    QLog.d("FrozenNotifyDlgHelper", 1, "reportFrozenDlgCancel: " + paramInt + " isPwdLeaked: " + paramBoolean);
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        ReportController.a(paramQQAppInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      return;
      if (paramBoolean) {}
      for (str = "0X800B42D";; str = "0X800B437") {
        break;
      }
      str = "0X800B5EA";
    }
  }
  
  private void d(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    QLog.d("FrozenNotifyDlgHelper", 1, "reportFrozenDlgCntActionClk: " + paramInt + " isPwdLeaked: " + paramBoolean);
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        ReportController.a(paramQQAppInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      return;
      if (paramBoolean) {}
      for (str = "0X800B432";; str = "0X800B43A") {
        break;
      }
      str = "0X800B5EB";
    }
  }
  
  private void e(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    QLog.d("FrozenNotifyDlgHelper", 1, "reportFrozenDlgCntCancel: " + paramInt + " isPwdLeaked: " + paramBoolean);
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        ReportController.a(paramQQAppInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      return;
      if (paramBoolean) {}
      for (str = "0X800B433";; str = "0X800B43B") {
        break;
      }
      str = "0X800B5EC";
    }
  }
  
  private void f(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    QLog.d("FrozenNotifyDlgHelper", 1, "reportFrozenDlgCntShow: " + paramInt + " isPwdLeaked: " + paramBoolean);
    String str = "";
    switch (paramInt)
    {
    default: 
      if (!TextUtils.isEmpty(str)) {
        ReportController.a(paramQQAppInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      return;
    }
    if (paramBoolean) {}
    for (str = "0X800B431";; str = "0X800B439") {
      break;
    }
  }
  
  public int a(int paramInt)
  {
    QLog.d("FrozenNotifyDlgHelper", 1, "getTipWithSceneId: " + paramInt);
    switch (paramInt)
    {
    default: 
      return 2131694615;
    case 2: 
      return 2131720395;
    case 3: 
      return 2131692680;
    }
    return 2131692681;
  }
  
  public int a(String paramString, int paramInt1, int paramInt2)
  {
    int i = 2;
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "getLinkTypeForReport error: msg empty");
      return -1;
    }
    QLog.d("FrozenNotifyDlgHelper", 1, "getLinkTypeForReport msg: " + paramString + " sceneId: " + paramInt1);
    switch (paramInt2)
    {
    default: 
      paramInt1 = -1;
    }
    for (;;)
    {
      return paramInt1;
      if (paramInt1 == 2)
      {
        paramInt1 = i;
        if (paramString.contains("已经泄露")) {
          continue;
        }
        paramInt1 = 6;
        continue;
        if (paramInt1 == 2)
        {
          if (paramString.contains("已经泄露"))
          {
            paramInt1 = 3;
            continue;
          }
          paramInt1 = 7;
          continue;
        }
        if ((paramInt1 == 3) || (paramInt1 == 4))
        {
          paramInt1 = 5;
          continue;
        }
      }
      paramInt1 = -1;
    }
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "getForbidScene: tlvData == null");
      return -1;
    }
    try
    {
      GatewayVerify.RspBody localRspBody = new GatewayVerify.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      int i = localRspBody.msg_rsp_tips_info.uint32_scene_id.get();
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "getForbidScene error: ", paramArrayOfByte);
    }
    return -1;
  }
  
  public CharSequence a(String paramString, BaseActivity paramBaseActivity, int paramInt)
  {
    if ((paramString == null) || (paramBaseActivity == null)) {
      QLog.e("FrozenNotifyDlgHelper", 1, "handleNotifyMsg error: params wrong");
    }
    while (!Patterns.b.matcher(paramString).find()) {
      return paramString;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("");
    Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    int j = 0;
    int i = 0;
    int m = 0;
    String str;
    Object localObject;
    int k;
    while (localMatcher.find())
    {
      m = 1;
      int n = localMatcher.start(0);
      j = localMatcher.end(0);
      str = paramString.substring(localMatcher.start(1), localMatcher.end(1));
      localObject = paramString.substring(localMatcher.start(2), localMatcher.end(2));
      k = i;
      if (i != n)
      {
        localSpannableStringBuilder.append(paramString.substring(i, n));
        k = j;
      }
      SpannableString localSpannableString = new SpannableString(str);
      localSpannableString.setSpan(new FrozenNotifyDlgHelper.ExpendClickableSpan((String)localObject, new WeakReference(paramBaseActivity), paramInt), 0, str.length(), 33);
      localSpannableString.setSpan(new ForegroundColorSpan(paramBaseActivity.getResources().getColor(2131165804)), 0, str.length(), 33);
      localSpannableStringBuilder.append(localSpannableString);
      i = k;
    }
    if (m != 0)
    {
      localSpannableStringBuilder.append(paramString.substring(j));
      return localSpannableStringBuilder;
    }
    localMatcher = Pattern.compile(jdField_a_of_type_JavaLangString, 2).matcher(paramString);
    j = 0;
    for (i = 0; localMatcher.find(); i = k)
    {
      m = localMatcher.start();
      j = localMatcher.end();
      str = paramString.substring(m, j);
      k = i;
      if (i != m)
      {
        localSpannableStringBuilder.append(paramString.substring(i, m));
        k = j;
      }
      localObject = new SpannableString(str);
      ((SpannableString)localObject).setSpan(new FrozenNotifyDlgHelper.ExpendClickableSpan(str, new WeakReference(paramBaseActivity), paramInt), 0, str.length(), 33);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramBaseActivity.getResources().getColor(2131165804)), 0, str.length(), 33);
      localSpannableStringBuilder.append((CharSequence)localObject);
    }
    localSpannableStringBuilder.append(paramString.substring(j));
    return localSpannableStringBuilder;
  }
  
  public String a(int paramInt)
  {
    QLog.d("FrozenNotifyDlgHelper", 1, "getAppendMsgWithSceneId: " + paramInt);
    switch (paramInt)
    {
    default: 
      return "";
    }
    return "你也可以对帐号进行<TITLE=\"资金管理\",URL=\"https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027\">。";
  }
  
  public String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "https://accounts.qq.com/007";
    }
    QLog.d("FrozenNotifyDlgHelper", 1, "loginFailed, before operate jump url is : " + str);
    localStringBuilder.append(str);
    if (!str.contains("?")) {
      localStringBuilder.append("?");
    }
    if (!str.endsWith("?")) {
      localStringBuilder.append("&");
    }
    for (;;)
    {
      localStringBuilder.append("from=andapp");
      if (!paramBoolean) {
        localStringBuilder.append("&account=").append(paramString2);
      }
      paramString1 = localStringBuilder.toString();
      QLog.d("FrozenNotifyDlgHelper", 1, "loginFailed, after operate jump url is : " + paramString1);
      return paramString1;
      if (str.indexOf("?") != str.lastIndexOf("?")) {
        localStringBuilder.append("&");
      }
    }
  }
  
  public void a(int paramInt)
  {
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        ReportController.a(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      return;
      str = "0X800B429";
      continue;
      str = "0X800B42E";
      continue;
      str = "0X800B434";
      continue;
      str = "0X800B5E5";
      continue;
      str = "0X800B5ED";
      continue;
      str = "0X800B438";
      continue;
      str = "0X800B43C";
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = true;
    QLog.d("FrozenNotifyDlgHelper", 1, "reportFrozenDlg: " + paramInt1 + " type: " + paramInt2 + " msg: " + paramString);
    if ((paramInt1 == 2) && (!TextUtils.isEmpty(paramString)) && (paramString.contains("已经泄露"))) {}
    for (;;)
    {
      switch (paramInt2)
      {
      default: 
        return;
      case 0: 
        a(paramQQAppInterface, paramInt1, bool);
        return;
      case 1: 
        b(paramQQAppInterface, paramInt1, bool);
        return;
      case 2: 
        c(paramQQAppInterface, paramInt1, bool);
        return;
      case 3: 
        d(paramQQAppInterface, paramInt1, bool);
        return;
      case 4: 
        e(paramQQAppInterface, paramInt1, bool);
        return;
      }
      f(paramQQAppInterface, paramInt1, bool);
      return;
      bool = false;
    }
  }
  
  public boolean a(BaseActivity paramBaseActivity, String paramString)
  {
    if ((paramBaseActivity == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "unBlockWithMiniAppFromCnt error: params empty");
      return false;
    }
    if (!paramString.startsWith("mqqapi://miniapp"))
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "unBlockWithMiniAppFromCnt: errorUrl is not miniapp url");
      return false;
    }
    if (MiniAppSecurityUtil.checkMiniAppForLogin(paramString))
    {
      QLog.d("FrozenNotifyDlgHelper", 1, "unBlockWithMiniAppFromCnt: startMiniApp");
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramBaseActivity, paramString, 2119, null);
    }
    for (;;)
    {
      return true;
      QLog.e("FrozenNotifyDlgHelper", 1, "MiniAppLauncher.startMiniApp error: fake app!");
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "isKickedForModifyPwd error: msg empty");
      return false;
    }
    boolean bool1 = bool2;
    if (paramString.contains("修改密码"))
    {
      bool1 = bool2;
      if (paramString.contains("资金管理")) {
        bool1 = true;
      }
    }
    QLog.d("FrozenNotifyDlgHelper", 1, "isKickedForModifyPwd kickedForMdfPwd: " + bool1);
    return bool1;
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    bool2 = false;
    if (paramArrayOfByte == null)
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "shouldHandleByDlgHelper: tlvData == null");
      return false;
    }
    try
    {
      GatewayVerify.RspBody localRspBody = new GatewayVerify.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      bool1 = bool2;
      if (localRspBody.msg_rsp_lft_info.uint32_lft_forbid_area.get() == 0)
      {
        boolean bool3 = this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(localRspBody.msg_rsp_tips_info.uint32_scene_id.get()));
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        QLog.e("FrozenNotifyDlgHelper", 1, "shouldHandleByDlgHelper error: ", paramArrayOfByte);
        boolean bool1 = bool2;
      }
    }
    QLog.d("FrozenNotifyDlgHelper", 1, "shouldHandleByDlgHelper: " + bool1);
    return bool1;
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = false;
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "isKickedForViolation error: msg empty");
      return false;
    }
    boolean bool1 = bool2;
    if (paramString.contains("冻结"))
    {
      bool1 = bool2;
      if (paramString.contains("资金管理")) {
        bool1 = true;
      }
    }
    QLog.d("FrozenNotifyDlgHelper", 1, "isKickedForViolation kickedForViolation: " + bool1);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.security.FrozenNotifyDlgHelper
 * JD-Core Version:    0.7.0.1
 */