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
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class aqyo
{
  private int jdField_a_of_type_Int;
  aqyt jdField_a_of_type_Aqyt = new aqyt();
  private String jdField_a_of_type_JavaLangString = "";
  boolean jdField_a_of_type_Boolean = true;
  aqyt jdField_b_of_type_Aqyt = new aqyt();
  private String jdField_b_of_type_JavaLangString = "";
  aqyt jdField_c_of_type_Aqyt = new aqyt();
  private String jdField_c_of_type_JavaLangString = "暂不";
  aqyt d = new aqyt();
  aqyt e = new aqyt();
  aqyt f = new aqyt();
  aqyt g = new aqyt();
  aqyt h = new aqyt();
  aqyt i = new aqyt();
  
  @NonNull
  public static aqyo a()
  {
    return a("{\"enable\":1,\"cacheFlag\":\"20200403\",\"intructionPageUrl\":\"https://act.qzone.qq.com/vip/meteor/blockly/p/4136x48826\",\"fullSpaceMessage\":{\"nonVIP\":\"当前群文件容量已满，新上传文件仅保留10天，开通超级会员可延长至30天。\",\"VIP\":\"当前群文件容量已满，会员新上传的文件仅保留20天，开通超级会员可延长至30天。\",\"SVIP\":\"当前群文件容量已满，你已享受超级会员特权，新上传的文件可保留30天。\"},\"redSubString\":{\"nonVIP\":\"容量已满\",\"VIP\":\"容量已满\",\"SVIP\":\"容量已满\"},\"blueSubString\":{\"nonVIP\":\"开通超级会员\",\"VIP\":\"开通超级会员\",\"SVIP\":\"超级会员特权\"},\"blueActionUrl\":{\"nonVIP\":\"https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_list&month=&type=svip&isAskFriendPay=0\",\"VIP\":\"https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_list&month=&type=svip&isAskFriendPay=0\",\"SVIP\":\"https://act.qzone.qq.com/vip/meteor/blockly/p/4136x48826\"},\"fullAlertMessage\":{\"nonVIP\":\"当前群文件容量已满，新上传的文件仅保留10天，超级会员可延长至30天。\",\"VIP\":\"当前群文件容量已满，会员新上传的文件仅保留20天，超级会员可延长至30天。\",\"SVIP\":\"\"},\"bigFileAlertMessage\":{\"nonVIP\":\"临时文件有效期10天，开通超级会员可将保存时间延长至30天\",\"VIP\":\"会员上传的临时文件有效期20天，开通超级会员可将保存时间延长至30天。\",\"SVIP\":\"\"},\"alertButtonTitle\":{\"nonVIP\":\"开通超级会员\",\"VIP\":\"开通超级会员\",\"SVIP\":\"\"},\"buttonActionUrl\":{\"nonVIP\":\"https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_tf&month=&type=svip&isAskFriendPay=0\",\"VIP\":\"https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_tf&month=&type=svip&isAskFriendPay=0\",\"SVIP\":\"\"},\"AIObuttonActionUrl\":{\"nonVIP\":\"https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_aio&month=&type=svip&isAskFriendPay=0\",\"VIP\":\"https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_aio&month=&type=svip&isAskFriendPay=0\",\"SVIP\":\"\"}}");
  }
  
  @NonNull
  public static aqyo a(@Nullable String paramString)
  {
    aqyo localaqyo = new aqyo();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        localaqyo.jdField_a_of_type_Int = paramString.optInt("enable", localaqyo.jdField_a_of_type_Int);
        localaqyo.jdField_a_of_type_JavaLangString = paramString.optString("cacheFlag", localaqyo.jdField_a_of_type_JavaLangString);
        localaqyo.jdField_b_of_type_JavaLangString = paramString.optString("intructionPageUrl", localaqyo.jdField_b_of_type_JavaLangString);
        localaqyo.jdField_a_of_type_Aqyt = aqyt.a(paramString.getJSONObject("fullSpaceMessage"));
        localaqyo.jdField_b_of_type_Aqyt = aqyt.a(paramString.getJSONObject("redSubString"));
        localaqyo.jdField_c_of_type_Aqyt = aqyt.a(paramString.getJSONObject("blueSubString"));
        localaqyo.d = aqyt.a(paramString.getJSONObject("blueActionUrl"));
        localaqyo.e = aqyt.a(paramString.getJSONObject("fullAlertMessage"));
        localaqyo.f = aqyt.a(paramString.getJSONObject("bigFileAlertMessage"));
        localaqyo.g = aqyt.a(paramString.getJSONObject("alertButtonTitle"));
        localaqyo.h = aqyt.a(paramString.getJSONObject("buttonActionUrl"));
        localaqyo.i = aqyt.a(paramString.getJSONObject("AIObuttonActionUrl"));
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.TROOP_FILE.ConfigProcessor", 1, " : " + localaqyo.toString());
      }
      return localaqyo;
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
      bcst.b(null, "dc00898", "", "", "qq_vip", paramString1, j, 1, 0, "", "", paramString3, "");
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
    String str1 = this.jdField_a_of_type_Aqyt.a(paramString);
    String str2 = this.jdField_b_of_type_Aqyt.a(paramString);
    String str3 = this.jdField_c_of_type_Aqyt.a(paramString);
    String str4 = this.d.a(paramString);
    SpannableString localSpannableString = new SpannableString(str1);
    int j = str1.indexOf(str2);
    if (j > -1) {
      localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF0000")), j, str2.length() + j, 33);
    }
    j = str1.indexOf(str3);
    if (j > -1) {
      localSpannableString.setSpan(new aqyp(this, str4, paramString), j, str3.length() + j, 33);
    }
    b("0X800AE66", paramString, "");
    return localSpannableString;
  }
  
  void a(Context paramContext, String paramString1, String paramString2, Runnable paramRunnable, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = bglp.a(paramContext, 230, "", paramString1, this.jdField_c_of_type_JavaLangString, this.g.a(paramString2), new aqyr(this, paramContext, paramBoolean1, paramString2, paramBoolean2), new aqys(this, paramRunnable, paramBoolean1, paramString2, paramBoolean2));
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
      paramString2 = blyl.a();
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
      paramString2.a("", "", "platform898", paramContext, paramString1, 111, 1, System.currentTimeMillis());
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
          localObject = new aqyq(this, paramString2);
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
    return "QVipTroopFileConfig{enable=" + this.jdField_a_of_type_Int + ", cacheFlag='" + this.jdField_a_of_type_JavaLangString + '\'' + ", intructionPageUrl='" + this.jdField_b_of_type_JavaLangString + '\'' + ", fullSpaceMessage=" + this.jdField_a_of_type_Aqyt + ", redSubString=" + this.jdField_b_of_type_Aqyt + ", blueSubString=" + this.jdField_c_of_type_Aqyt + ", blueActionUrl=" + this.d + ", fullAlertMessage=" + this.e + ", bigFileAlertMessage=" + this.f + ", alertButtonTitle=" + this.g + ", buttonActionUrl=" + this.h + ", AIObuttonActionUrl=" + this.i + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqyo
 * JD-Core Version:    0.7.0.1
 */