package com.tencent.mobileqq.app.security;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqsec.api.ISecControllerInterface;
import com.tencent.mobileqq.qqsec.api.QQSecBlockInjectUtil;
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
  private static ISecControllerInterface a;
  private static volatile FrozenNotifyDlgHelper b;
  private static final String d;
  private static final Pattern e = Pattern.compile("<TITLE=\"([^>]+)\",URL=\"([^<]+)\">");
  private ArrayList<Integer> c = new ArrayList();
  
  static
  {
    try
    {
      if (QQSecBlockInjectUtil.a.size() > 0)
      {
        a = (ISecControllerInterface)((Class)QQSecBlockInjectUtil.a.get(0)).newInstance();
        QLog.d("FrozenNotifyDlgHelper", 1, "FrozenNotifyDlgHelper newInstance");
      }
    }
    catch (Exception localException)
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "FrozenNotifyDlgHelper static statement: ", localException);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Patterns.c.pattern());
    localStringBuilder.append("|");
    localStringBuilder.append(Patterns.d.pattern());
    d = localStringBuilder.toString();
  }
  
  private FrozenNotifyDlgHelper()
  {
    this.c.add(Integer.valueOf(2));
    this.c.add(Integer.valueOf(3));
    this.c.add(Integer.valueOf(4));
  }
  
  public static FrozenNotifyDlgHelper a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new FrozenNotifyDlgHelper();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportFrozenDlgShow: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" isPwdLeaked: ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("FrozenNotifyDlgHelper", 1, ((StringBuilder)localObject).toString());
    if (paramInt != 2) {
      if ((paramInt != 3) && (paramInt != 4)) {
        localObject = "";
      }
    }
    for (;;)
    {
      break;
      localObject = "0X800B5E7";
      continue;
      if (paramBoolean) {
        localObject = "0X800B42B";
      } else {
        localObject = "0X800B435";
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      ReportController.a(paramBaseQQAppInterface, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
    }
  }
  
  private void b(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportFrozenDlgActionClk: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" isPwdLeaked: ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("FrozenNotifyDlgHelper", 1, ((StringBuilder)localObject).toString());
    if (paramInt != 2) {
      if (paramInt != 3) {
        if (paramInt != 4) {
          localObject = "";
        }
      }
    }
    for (;;)
    {
      break;
      localObject = "0X800B5E9";
      continue;
      localObject = "0X800B5E8";
      continue;
      if (paramBoolean) {
        localObject = "0X800B42C";
      } else {
        localObject = "0X800B436";
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      ReportController.a(paramBaseQQAppInterface, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
    }
  }
  
  private void c(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportFrozenDlgCancel: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" isPwdLeaked: ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("FrozenNotifyDlgHelper", 1, ((StringBuilder)localObject).toString());
    if (paramInt != 2) {
      if ((paramInt != 3) && (paramInt != 4)) {
        localObject = "";
      }
    }
    for (;;)
    {
      break;
      localObject = "0X800B5EA";
      continue;
      if (paramBoolean) {
        localObject = "0X800B42D";
      } else {
        localObject = "0X800B437";
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      ReportController.a(paramBaseQQAppInterface, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
    }
  }
  
  private void d(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportFrozenDlgCntActionClk: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" isPwdLeaked: ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("FrozenNotifyDlgHelper", 1, ((StringBuilder)localObject).toString());
    if (paramInt != 2) {
      if ((paramInt != 3) && (paramInt != 4)) {
        localObject = "";
      }
    }
    for (;;)
    {
      break;
      localObject = "0X800B5EB";
      continue;
      if (paramBoolean) {
        localObject = "0X800B432";
      } else {
        localObject = "0X800B43A";
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      ReportController.a(paramBaseQQAppInterface, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
    }
  }
  
  private void e(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportFrozenDlgCntCancel: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" isPwdLeaked: ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("FrozenNotifyDlgHelper", 1, ((StringBuilder)localObject).toString());
    if (paramInt != 2) {
      if ((paramInt != 3) && (paramInt != 4)) {
        localObject = "";
      }
    }
    for (;;)
    {
      break;
      localObject = "0X800B5EC";
      continue;
      if (paramBoolean) {
        localObject = "0X800B433";
      } else {
        localObject = "0X800B43B";
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      ReportController.a(paramBaseQQAppInterface, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
    }
  }
  
  private void f(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportFrozenDlgCntShow: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" isPwdLeaked: ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("FrozenNotifyDlgHelper", 1, ((StringBuilder)localObject).toString());
    if (paramInt != 2) {
      localObject = "";
    }
    for (;;)
    {
      break;
      if (paramBoolean) {
        localObject = "0X800B431";
      } else {
        localObject = "0X800B439";
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      ReportController.a(paramBaseQQAppInterface, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
    }
  }
  
  public int a(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i = -1;
    if (bool)
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "getLinkTypeForReport error: msg empty");
      return -1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getLinkTypeForReport msg: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" sceneId: ");
    localStringBuilder.append(paramInt1);
    QLog.d("FrozenNotifyDlgHelper", 1, localStringBuilder.toString());
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1) {
        return -1;
      }
      if (paramInt1 == 2)
      {
        if (paramString.contains("已经泄露")) {
          return 3;
        }
        return 7;
      }
      if (paramInt1 != 3)
      {
        paramInt2 = i;
        if (paramInt1 != 4) {}
      }
      else
      {
        return 5;
      }
    }
    else
    {
      paramInt2 = i;
      if (paramInt1 == 2)
      {
        if (paramString.contains("已经泄露")) {
          return 2;
        }
        paramInt2 = 6;
      }
    }
    return paramInt2;
  }
  
  public CharSequence a(String paramString, QBaseActivity paramQBaseActivity, int paramInt)
  {
    if ((paramString != null) && (paramQBaseActivity != null))
    {
      if (!Patterns.b.matcher(paramString).find()) {
        return paramString;
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("");
      Matcher localMatcher = e.matcher(paramString);
      int m = 0;
      int i = 0;
      int j = 0;
      String str;
      Object localObject;
      while (localMatcher.find())
      {
        m = localMatcher.start(0);
        j = localMatcher.end(0);
        str = paramString.substring(localMatcher.start(1), localMatcher.end(1));
        localObject = paramString.substring(localMatcher.start(2), localMatcher.end(2));
        k = i;
        if (i != m)
        {
          localSpannableStringBuilder.append(paramString.substring(i, m));
          k = j;
        }
        SpannableString localSpannableString = new SpannableString(str);
        localSpannableString.setSpan(new FrozenNotifyDlgHelper.ExpendClickableSpan((String)localObject, new WeakReference(paramQBaseActivity), paramInt), 0, str.length(), 33);
        localSpannableString.setSpan(new ForegroundColorSpan(paramQBaseActivity.getResources().getColor(2131166411)), 0, str.length(), 33);
        localSpannableStringBuilder.append(localSpannableString);
        m = 1;
        i = k;
      }
      if (m != 0)
      {
        localSpannableStringBuilder.append(paramString.substring(j));
        return localSpannableStringBuilder;
      }
      localMatcher = Pattern.compile(d, 2).matcher(paramString);
      int k = 0;
      for (i = 0; localMatcher.find(); i = j)
      {
        m = localMatcher.start();
        k = localMatcher.end();
        str = paramString.substring(m, k);
        j = i;
        if (i != m)
        {
          localSpannableStringBuilder.append(paramString.substring(i, m));
          j = k;
        }
        localObject = new SpannableString(str);
        ((SpannableString)localObject).setSpan(new FrozenNotifyDlgHelper.ExpendClickableSpan(str, new WeakReference(paramQBaseActivity), paramInt), 0, str.length(), 33);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramQBaseActivity.getResources().getColor(2131166411)), 0, str.length(), 33);
        localSpannableStringBuilder.append((CharSequence)localObject);
      }
      localSpannableStringBuilder.append(paramString.substring(k));
      return localSpannableStringBuilder;
    }
    QLog.e("FrozenNotifyDlgHelper", 1, "handleNotifyMsg error: params wrong");
    return paramString;
  }
  
  public String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "https://accounts.qq.com/007";
    }
    paramString1 = new StringBuilder();
    paramString1.append("loginFailed, before operate jump url is : ");
    paramString1.append(str);
    QLog.d("FrozenNotifyDlgHelper", 1, paramString1.toString());
    localStringBuilder.append(str);
    if (!str.contains("?")) {
      localStringBuilder.append("?");
    }
    if (!str.endsWith("?")) {
      localStringBuilder.append("&");
    } else if (str.indexOf("?") != str.lastIndexOf("?")) {
      localStringBuilder.append("&");
    }
    localStringBuilder.append("from=andapp");
    if (!paramBoolean)
    {
      localStringBuilder.append("&account=");
      localStringBuilder.append(paramString2);
    }
    paramString1 = localStringBuilder.toString();
    paramString2 = new StringBuilder();
    paramString2.append("loginFailed, after operate jump url is : ");
    paramString2.append(paramString1);
    QLog.d("FrozenNotifyDlgHelper", 1, paramString2.toString());
    return paramString1;
  }
  
  public void a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "";
    }
    for (;;)
    {
      break;
      str = "0X800B43C";
      continue;
      str = "0X800B438";
      continue;
      str = "0X800B5ED";
      continue;
      str = "0X800B5E5";
      continue;
      str = "0X800B434";
      continue;
      str = "0X800B42E";
      continue;
      str = "0X800B429";
    }
    if (!TextUtils.isEmpty(str)) {
      ReportController.a(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }
  }
  
  public void a(Activity paramActivity)
  {
    QLog.d("FrozenNotifyDlgHelper", 1, "ssoLoginByIMBlock");
    Intent localIntent1 = paramActivity.getIntent();
    if (localIntent1 == null)
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "ssoLoginByIMBlock null == srcIntent");
      return;
    }
    Intent localIntent2 = new Intent();
    localIntent2.putExtra("appid", "0");
    localIntent2.putExtra("uin", localIntent1.getStringExtra("uin"));
    localIntent2.putExtra("passwd", localIntent1.getStringExtra("passwd"));
    localIntent2.putExtra("is_from_login", localIntent1.getBooleanExtra("is_from_login", false));
    localIntent2.putExtra("key_action", "action_sso_login_by_im_block");
    RouteUtils.a(paramActivity, localIntent2, "/base/connectAgent");
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt1, int paramInt2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportFrozenDlg: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" type: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" msg: ");
    localStringBuilder.append(paramString);
    QLog.d("FrozenNotifyDlgHelper", 1, localStringBuilder.toString());
    boolean bool;
    if ((paramInt1 == 2) && (!TextUtils.isEmpty(paramString)) && (paramString.contains("已经泄露"))) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 != 3)
          {
            if (paramInt2 != 4)
            {
              if (paramInt2 != 5) {
                return;
              }
              f(paramBaseQQAppInterface, paramInt1, bool);
              return;
            }
            e(paramBaseQQAppInterface, paramInt1, bool);
            return;
          }
          d(paramBaseQQAppInterface, paramInt1, bool);
          return;
        }
        c(paramBaseQQAppInterface, paramInt1, bool);
        return;
      }
      b(paramBaseQQAppInterface, paramInt1, bool);
      return;
    }
    a(paramBaseQQAppInterface, paramInt1, bool);
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, String paramString)
  {
    if ((paramQBaseActivity != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (!paramString.startsWith("mqqapi://miniapp"))
      {
        QLog.e("FrozenNotifyDlgHelper", 1, "unBlockWithMiniAppFromCnt: errorUrl is not miniapp url");
        return false;
      }
      if (MiniAppSecurityUtil.checkMiniAppForLogin(paramString))
      {
        QLog.d("FrozenNotifyDlgHelper", 1, "unBlockWithMiniAppFromCnt: startMiniApp");
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramQBaseActivity, paramString, 2119, null);
        return true;
      }
      QLog.e("FrozenNotifyDlgHelper", 1, "MiniAppLauncher.startMiniApp error: fake app!");
      return true;
    }
    QLog.e("FrozenNotifyDlgHelper", 1, "unBlockWithMiniAppFromCnt error: params empty");
    return false;
  }
  
  public boolean a(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1)
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "isKickedForModifyPwd error: msg empty");
      return false;
    }
    bool1 = bool2;
    if (paramString.contains("修改密码"))
    {
      bool1 = bool2;
      if (paramString.contains("资金管理")) {
        bool1 = true;
      }
    }
    paramString = new StringBuilder();
    paramString.append("isKickedForModifyPwd kickedForMdfPwd: ");
    paramString.append(bool1);
    QLog.d("FrozenNotifyDlgHelper", 1, paramString.toString());
    return bool1;
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    if (paramArrayOfByte == null)
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "shouldHandleByDlgHelper: tlvData == null");
      return false;
    }
    boolean bool1;
    try
    {
      GatewayVerify.RspBody localRspBody = new GatewayVerify.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      bool1 = bool2;
      if (localRspBody.msg_rsp_lft_info.uint32_lft_forbid_area.get() == 0)
      {
        boolean bool3 = this.c.contains(Integer.valueOf(localRspBody.msg_rsp_tips_info.uint32_scene_id.get()));
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "shouldHandleByDlgHelper error: ", paramArrayOfByte);
      bool1 = bool2;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("shouldHandleByDlgHelper: ");
    paramArrayOfByte.append(bool1);
    QLog.d("FrozenNotifyDlgHelper", 1, paramArrayOfByte.toString());
    return bool1;
  }
  
  public int b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTipWithSceneId: ");
    localStringBuilder.append(paramInt);
    QLog.d("FrozenNotifyDlgHelper", 1, localStringBuilder.toString());
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4) {
          return 2131892267;
        }
        return 2131889661;
      }
      return 2131889660;
    }
    return 2131917764;
  }
  
  public int b(byte[] paramArrayOfByte)
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
  
  public boolean b(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1)
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "isKickedForViolation error: msg empty");
      return false;
    }
    bool1 = bool2;
    if (paramString.contains("冻结"))
    {
      bool1 = bool2;
      if (paramString.contains("资金管理")) {
        bool1 = true;
      }
    }
    paramString = new StringBuilder();
    paramString.append("isKickedForViolation kickedForViolation: ");
    paramString.append(bool1);
    QLog.d("FrozenNotifyDlgHelper", 1, paramString.toString());
    return bool1;
  }
  
  public String c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAppendMsgWithSceneId: ");
    localStringBuilder.append(paramInt);
    QLog.d("FrozenNotifyDlgHelper", 1, localStringBuilder.toString());
    if ((paramInt != 2) && (paramInt != 3) && (paramInt != 4)) {
      return "";
    }
    return "你也可以对帐号进行<TITLE=\"资金管理\",URL=\"https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027\">。";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.security.FrozenNotifyDlgHelper
 * JD-Core Version:    0.7.0.1
 */