import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class aqid
{
  private int jdField_a_of_type_Int;
  aqii jdField_a_of_type_Aqii = new aqii();
  private String jdField_a_of_type_JavaLangString = "";
  boolean jdField_a_of_type_Boolean = true;
  aqii jdField_b_of_type_Aqii = new aqii();
  private String jdField_b_of_type_JavaLangString = "";
  aqii jdField_c_of_type_Aqii = new aqii();
  private String jdField_c_of_type_JavaLangString = "暂不";
  aqii d = new aqii();
  aqii e = new aqii();
  aqii f = new aqii();
  aqii g = new aqii();
  aqii h = new aqii();
  aqii i = new aqii();
  
  @NonNull
  public static aqid a()
  {
    return a("{\"enable\":1,\"cacheFlag\":\"20200403\",\"intructionPageUrl\":\"https://act.qzone.qq.com/vip/meteor/blockly/p/4136x48826\",\"fullSpaceMessage\":{\"nonVIP\":\"当前群文件容量已满，新上传文件仅保留10天，开通超级会员可延长至30天。\",\"VIP\":\"当前群文件容量已满，会员新上传的文件仅保留20天，开通超级会员可延长至30天。\",\"SVIP\":\"当前群文件容量已满，你已享受超级会员特权，新上传的文件可保留30天。\"},\"redSubString\":{\"nonVIP\":\"容量已满\",\"VIP\":\"容量已满\",\"SVIP\":\"容量已满\"},\"blueSubString\":{\"nonVIP\":\"开通超级会员\",\"VIP\":\"开通超级会员\",\"SVIP\":\"超级会员特权\"},\"blueActionUrl\":{\"nonVIP\":\"https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_list&month=&type=svip&isAskFriendPay=0\",\"VIP\":\"https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_list&month=&type=svip&isAskFriendPay=0\",\"SVIP\":\"https://act.qzone.qq.com/vip/meteor/blockly/p/4136x48826\"},\"fullAlertMessage\":{\"nonVIP\":\"当前群文件容量已满，新上传的文件仅保留10天，超级会员可延长至30天。\",\"VIP\":\"当前群文件容量已满，会员新上传的文件仅保留20天，超级会员可延长至30天。\",\"SVIP\":\"\"},\"bigFileAlertMessage\":{\"nonVIP\":\"临时文件有效期10天，开通超级会员可将保存时间延长至30天\",\"VIP\":\"会员上传的临时文件有效期20天，开通超级会员可将保存时间延长至30天。\",\"SVIP\":\"\"},\"alertButtonTitle\":{\"nonVIP\":\"开通超级会员\",\"VIP\":\"开通超级会员\",\"SVIP\":\"\"},\"buttonActionUrl\":{\"nonVIP\":\"https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_tf&month=&type=svip&isAskFriendPay=0\",\"VIP\":\"https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_tf&month=&type=svip&isAskFriendPay=0\",\"SVIP\":\"\"},\"AIObuttonActionUrl\":{\"nonVIP\":\"https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_aio&month=&type=svip&isAskFriendPay=0\",\"VIP\":\"https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_aio&month=&type=svip&isAskFriendPay=0\",\"SVIP\":\"\"}}");
  }
  
  @NonNull
  public static aqid a(@Nullable String paramString)
  {
    aqid localaqid = new aqid();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        localaqid.jdField_a_of_type_Int = paramString.optInt("enable", localaqid.jdField_a_of_type_Int);
        localaqid.jdField_a_of_type_JavaLangString = paramString.optString("cacheFlag", localaqid.jdField_a_of_type_JavaLangString);
        localaqid.jdField_b_of_type_JavaLangString = paramString.optString("intructionPageUrl", localaqid.jdField_b_of_type_JavaLangString);
        localaqid.jdField_a_of_type_Aqii = aqii.a(paramString.getJSONObject("fullSpaceMessage"));
        localaqid.jdField_b_of_type_Aqii = aqii.a(paramString.getJSONObject("redSubString"));
        localaqid.jdField_c_of_type_Aqii = aqii.a(paramString.getJSONObject("blueSubString"));
        localaqid.d = aqii.a(paramString.getJSONObject("blueActionUrl"));
        localaqid.e = aqii.a(paramString.getJSONObject("fullAlertMessage"));
        localaqid.f = aqii.a(paramString.getJSONObject("bigFileAlertMessage"));
        localaqid.g = aqii.a(paramString.getJSONObject("alertButtonTitle"));
        localaqid.h = aqii.a(paramString.getJSONObject("buttonActionUrl"));
        localaqid.i = aqii.a(paramString.getJSONObject("AIObuttonActionUrl"));
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.TROOP_FILE.ConfigProcessor", 1, " : " + localaqid.toString());
      }
      return localaqid;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("QVIP.TROOP_FILE.ConfigProcessor", 1, "json parse error:" + paramString);
      }
    }
  }
  
  private static void b(String paramString1, String paramString2, String paramString3)
  {
    int j;
    if ("normal".equals(paramString2)) {
      j = 1;
    }
    for (;;)
    {
      bcef.b(null, "dc00898", "", "", "qq_vip", paramString1, j, 1, 0, "", "", paramString3, "");
      return;
      if ("vip".equals(paramString2)) {
        j = 2;
      } else if ("svip".equals(paramString2)) {
        j = 3;
      } else {
        j = 0;
      }
    }
  }
  
  public SpannableString a(String paramString)
  {
    String str1 = this.jdField_a_of_type_Aqii.a(paramString);
    String str2 = this.jdField_b_of_type_Aqii.a(paramString);
    String str3 = this.jdField_c_of_type_Aqii.a(paramString);
    String str4 = this.d.a(paramString);
    SpannableString localSpannableString = new SpannableString(str1);
    int j = str1.indexOf(str2);
    if (j > -1) {
      localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF0000")), j, str2.length() + j, 33);
    }
    j = str1.indexOf(str3);
    if (j > -1) {
      localSpannableString.setSpan(new aqie(this, str4, paramString), j, str3.length() + j, 33);
    }
    b("0X800AE66", paramString, "");
    return localSpannableString;
  }
  
  void a(Context paramContext, String paramString1, String paramString2, Runnable paramRunnable, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = bfur.a(paramContext, 230, "", paramString1, this.jdField_c_of_type_JavaLangString, this.g.a(paramString2), new aqig(this, paramContext, paramBoolean1, paramString2, paramBoolean2), new aqih(this, paramRunnable, paramBoolean1, paramString2, paramBoolean2));
    paramContext.getTitleTextView().setVisibility(8);
    paramContext.show();
    if (paramBoolean1)
    {
      paramContext = "0X800AE69";
      if (!paramBoolean2) {
        break label136;
      }
      paramString1 = "size";
      label81:
      b(paramContext, paramString2, paramString1);
      paramString2 = MobileReportManager.getInstance();
      if (!paramBoolean1) {
        break label143;
      }
      paramContext = "2";
      label100:
      if (!paramBoolean1) {
        break label150;
      }
    }
    label136:
    label143:
    label150:
    for (paramString1 = "2";; paramString1 = "1")
    {
      paramString2.reportAction("", "", "platform898", paramContext, paramString1, 111, 1, System.currentTimeMillis());
      return;
      paramContext = "0X800AE63";
      break;
      paramString1 = "full";
      break label81;
      paramContext = "3";
      break label100;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean a(Context paramContext, Runnable paramRunnable, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    String str;
    int j;
    if (paramBoolean1)
    {
      str = this.f.a(paramString);
      if (TextUtils.isEmpty(str)) {
        break label47;
      }
      j = 1;
      label26:
      if (j != 0) {
        break label53;
      }
    }
    label47:
    label53:
    while (!b())
    {
      return false;
      str = this.e.a(paramString);
      break;
      j = 0;
      break label26;
    }
    a(paramContext, str, paramString, paramRunnable, paramBoolean2, paramBoolean1);
    return true;
  }
  
  public boolean a(@NonNull SpannableString paramSpannableString, @NonNull String paramString1, String paramString2)
  {
    int k = 0;
    Object localObject;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramSpannableString)))
    {
      localObject = Pattern.compile("[^0-9]").matcher(paramString1).replaceAll("").trim();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label47;
      }
    }
    for (;;)
    {
      return false;
      try
      {
        label47:
        int n = Integer.valueOf((String)localObject).intValue();
        if (paramSpannableString.toString().contains("\n")) {
          localObject = paramSpannableString.toString().replace("\n", "");
        }
        for (int j = 1;; j = 0)
        {
          int m = ((String)localObject).indexOf(paramString1);
          if ((n <= 10) || (m <= -1)) {
            break;
          }
          localObject = new aqif(this, paramString2);
          n = paramString1.length();
          if (j != 0) {
            k = 1;
          }
          paramSpannableString.setSpan(localObject, m, n + m + k, 33);
          b("0X800AE6C", paramString2, "");
          return true;
          localObject = paramSpannableString.toString();
        }
        return false;
      }
      catch (Exception paramSpannableString) {}
    }
  }
  
  boolean b()
  {
    boolean bool2;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool2 = false;
      return bool2;
    }
    this.jdField_a_of_type_Boolean = false;
    SharedPreferences localSharedPreferences = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getPreferences();
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, localSharedPreferences.getString("vas_guide_troop_file", null))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      localSharedPreferences.edit().putString("vas_guide_troop_file", this.jdField_a_of_type_JavaLangString).apply();
      return bool1;
    }
  }
  
  public String toString()
  {
    return "QVipTroopFileConfig{enable=" + this.jdField_a_of_type_Int + ", cacheFlag='" + this.jdField_a_of_type_JavaLangString + '\'' + ", intructionPageUrl='" + this.jdField_b_of_type_JavaLangString + '\'' + ", fullSpaceMessage=" + this.jdField_a_of_type_Aqii + ", redSubString=" + this.jdField_b_of_type_Aqii + ", blueSubString=" + this.jdField_c_of_type_Aqii + ", blueActionUrl=" + this.d + ", fullAlertMessage=" + this.e + ", bigFileAlertMessage=" + this.f + ", alertButtonTitle=" + this.g + ", buttonActionUrl=" + this.h + ", AIObuttonActionUrl=" + this.i + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqid
 * JD-Core Version:    0.7.0.1
 */