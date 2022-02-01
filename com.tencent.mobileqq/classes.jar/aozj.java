import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.util.WeakReference;
import tencent.im.login.GatewayVerify.RspBody;
import tencent.im.login.GatewayVerify.RspLftInfo;
import tencent.im.login.GatewayVerify.RspTipsInfo;

public class aozj
{
  private static volatile aozj jdField_a_of_type_Aozj;
  private static final String jdField_a_of_type_JavaLangString = bhfp.c.pattern() + "|" + bhfp.d.pattern();
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("<TITLE=\"([^>]+)\",URL=\"([^<]+)\">");
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private aozj()
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(42));
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(60));
  }
  
  public static aozj a()
  {
    if (jdField_a_of_type_Aozj == null) {}
    try
    {
      if (jdField_a_of_type_Aozj == null) {
        jdField_a_of_type_Aozj = new aozj();
      }
      return jdField_a_of_type_Aozj;
    }
    finally {}
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
    while (!bhfp.b.matcher(paramString).find()) {
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
      localSpannableString.setSpan(new aozk((String)localObject, new WeakReference(paramBaseActivity), paramInt), 0, str.length(), 33);
      localSpannableString.setSpan(new ForegroundColorSpan(paramBaseActivity.getResources().getColor(2131165802)), 0, str.length(), 33);
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
      ((SpannableString)localObject).setSpan(new aozk(str, new WeakReference(paramBaseActivity), paramInt), 0, str.length(), 33);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramBaseActivity.getResources().getColor(2131165802)), 0, str.length(), 33);
      localSpannableStringBuilder.append((CharSequence)localObject);
    }
    localSpannableStringBuilder.append(paramString.substring(j));
    return localSpannableStringBuilder;
  }
  
  public String a(String paramString1, String paramString2)
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
      localStringBuilder.append("from=andapp&account=").append(paramString2);
      paramString1 = localStringBuilder.toString();
      QLog.d("FrozenNotifyDlgHelper", 1, "loginFailed, after operate jump url is : " + paramString1);
      return paramString1;
      if (str.indexOf("?") != str.lastIndexOf("?")) {
        localStringBuilder.append("&");
      }
    }
  }
  
  public void a(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    if ((paramBaseActivity == null) || (paramBaseActivity.isFinishing()) || (paramBundle == null))
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "launchNotifyActFrozenDlg error: params wrong");
      return;
    }
    int i = paramBundle.getInt("loginret");
    String str1 = paramBundle.getString("loginalias");
    String str2 = paramBundle.getString("msg");
    int j = paramBundle.getInt("errorver");
    byte[] arrayOfByte = paramBundle.getByteArray("tlverror");
    String str3 = paramBundle.getString("errortitle");
    paramBundle = paramBundle.getString("errorUrl");
    Intent localIntent = new Intent(paramBaseActivity, NotificationActivity.class);
    localIntent.putExtra("type", 8);
    localIntent.putExtra("msg", str2);
    localIntent.putExtra("errorver", j);
    localIntent.putExtra("tlverror", arrayOfByte);
    localIntent.putExtra("errortitle", str3);
    localIntent.putExtra("loginalias", str1);
    localIntent.putExtra("loginret", i);
    localIntent.putExtra("errorUrl", paramBundle);
    QLog.d("FrozenNotifyDlgHelper", 1, "launchNotifyActFrozenDlg, errorMsg: " + str2 + " errorVer: " + j + " errorTitle: " + str3 + " errorURL: " + paramBundle);
    paramBaseActivity.startActivity(localIntent);
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
        int i = localRspBody.msg_rsp_tips_info.uint32_scene_id.get();
        bool1 = bool2;
        if (i == 2) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aozj
 * JD-Core Version:    0.7.0.1
 */