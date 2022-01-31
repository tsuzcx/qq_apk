import MQQ.VipUserInfo;
import VIP.AIOSendRes;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class bbvz
{
  public static int a;
  private static bbvz jdField_a_of_type_Bbvz;
  public static String a;
  public static int b;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  public static String k;
  private List<String> jdField_a_of_type_JavaUtilList;
  private int c;
  private int d;
  private int e;
  private String l;
  private String m;
  private String n;
  private String o;
  
  static
  {
    jdField_a_of_type_JavaLangString = "aioVipDonateInfoSpFile_";
    jdField_b_of_type_JavaLangString = "lastCheckTime_";
    jdField_c_of_type_JavaLangString = "sendDisable";
    jdField_d_of_type_JavaLangString = "checkFreq";
    jdField_e_of_type_JavaLangString = "grayTail";
    f = "sendList";
    g = "popGraytips";
    h = "graytips";
    i = "hightLight";
    j = "jumpUrl";
    jdField_a_of_type_Int = 1;
    k = "";
    jdField_b_of_type_Int = 1;
  }
  
  public bbvz()
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
  }
  
  public static bbvz a()
  {
    if (jdField_a_of_type_Bbvz == null) {}
    try
    {
      if (jdField_a_of_type_Bbvz == null) {
        jdField_a_of_type_Bbvz = new bbvz();
      }
      return jdField_a_of_type_Bbvz;
    }
    finally {}
  }
  
  public long a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return -1L;
    }
    if (this.jdField_d_of_type_Int == -1) {
      this.jdField_d_of_type_Int = paramQQAppInterface.getApplication().getSharedPreferences(jdField_a_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin(), 0).getInt(jdField_d_of_type_JavaLangString, -1);
    }
    return this.jdField_d_of_type_Int * 60 * 1000;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    if (TextUtils.isEmpty(this.m)) {
      this.m = paramQQAppInterface.getApplication().getSharedPreferences(jdField_a_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin(), 0).getString(h, null);
    }
    return this.m;
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    this.jdField_e_of_type_Int = paramInt;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences(jdField_a_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putInt(g, paramInt);
    if (Build.VERSION.SDK_INT < 9)
    {
      paramQQAppInterface.commit();
      return;
    }
    paramQQAppInterface.apply();
  }
  
  @TargetApi(9)
  public void a(QQAppInterface paramQQAppInterface, VipUserInfo paramVipUserInfo)
  {
    int i2 = 0;
    if ((paramQQAppInterface == null) || (paramVipUserInfo == null)) {
      return;
    }
    Object localObject = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences(jdField_a_of_type_JavaLangString + (String)localObject, 0).edit();
    this.jdField_c_of_type_Int = paramVipUserInfo.iSendDisable;
    this.jdField_d_of_type_Int = paramVipUserInfo.iCheckFreq;
    if (!TextUtils.isEmpty(paramVipUserInfo.sGrayTail))
    {
      this.l = paramVipUserInfo.sGrayTail;
      paramQQAppInterface.putString(jdField_e_of_type_JavaLangString, paramVipUserInfo.sGrayTail);
    }
    if ((paramVipUserInfo.vSendList != null) && (paramVipUserInfo.vSendList.size() > 0))
    {
      localObject = new StringBuilder();
      int i1 = i2;
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        i1 = i2;
      }
      while (i1 < paramVipUserInfo.vSendList.size())
      {
        String str = String.valueOf(paramVipUserInfo.vSendList.get(i1));
        ((StringBuilder)localObject).append(str).append(",");
        this.jdField_a_of_type_JavaUtilList.add(str);
        i1 += 1;
      }
      paramQQAppInterface.putString(f, ((StringBuilder)localObject).toString());
    }
    paramQQAppInterface.putInt(jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Int);
    paramQQAppInterface.putInt(jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int);
    if (Build.VERSION.SDK_INT < 9)
    {
      paramQQAppInterface.commit();
      return;
    }
    paramQQAppInterface.apply();
  }
  
  @TargetApi(9)
  public void a(QQAppInterface paramQQAppInterface, AIOSendRes paramAIOSendRes)
  {
    if ((paramQQAppInterface == null) || (paramAIOSendRes == null)) {}
    label251:
    for (;;)
    {
      return;
      this.jdField_e_of_type_Int = paramAIOSendRes.iPopGrayStip;
      this.m = paramAIOSendRes.sGrayStipMsg;
      paramAIOSendRes = paramAIOSendRes.mHighLightMap;
      if ((paramAIOSendRes != null) && (paramAIOSendRes.size() > 0))
      {
        this.n = ((String)paramAIOSendRes.keySet().iterator().next());
        if (!TextUtils.isEmpty(this.n)) {
          this.o = ((String)paramAIOSendRes.get(this.n));
        }
      }
      paramAIOSendRes = paramQQAppInterface.getApplication().getSharedPreferences(jdField_a_of_type_JavaLangString, 0).edit();
      paramAIOSendRes.putInt(g, this.jdField_e_of_type_Int);
      if (!TextUtils.isEmpty(this.m)) {
        paramAIOSendRes.putString(h, this.m);
      }
      if (!TextUtils.isEmpty(this.n)) {
        paramAIOSendRes.putString(i, this.n);
      }
      if (!TextUtils.isEmpty(this.o)) {
        paramAIOSendRes.putString(j, this.o);
      }
      if (Build.VERSION.SDK_INT < 9) {
        paramAIOSendRes.commit();
      }
      for (;;)
      {
        if (this.jdField_e_of_type_Int != jdField_b_of_type_Int) {
          break label251;
        }
        paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
        if (paramQQAppInterface == null) {
          break;
        }
        paramQQAppInterface.sendMessage(paramQQAppInterface.obtainMessage(58));
        return;
        paramAIOSendRes.apply();
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return false;
      if (this.jdField_c_of_type_Int == -1) {
        this.jdField_c_of_type_Int = paramQQAppInterface.getApplication().getSharedPreferences(jdField_a_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin(), 0).getInt(jdField_c_of_type_JavaLangString, -1);
      }
    } while (this.jdField_c_of_type_Int != jdField_a_of_type_Int);
    return true;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return false;
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 1))
      {
        if (this.jdField_a_of_type_JavaUtilList == null) {
          this.jdField_a_of_type_JavaUtilList = new ArrayList();
        }
        paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences(jdField_a_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin(), 0).getString(f, null);
        if (!TextUtils.isEmpty(paramQQAppInterface))
        {
          paramQQAppInterface = paramQQAppInterface.split(",");
          int i1 = 0;
          while (i1 < paramQQAppInterface.length)
          {
            CharSequence localCharSequence = paramQQAppInterface[i1];
            if (!TextUtils.isEmpty(localCharSequence)) {
              this.jdField_a_of_type_JavaUtilList.add(localCharSequence.trim());
            }
            i1 += 1;
          }
        }
      }
    } while ((this.jdField_a_of_type_JavaUtilList == null) || (!this.jdField_a_of_type_JavaUtilList.contains(paramString)));
    return true;
  }
  
  public String b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    if (TextUtils.isEmpty(this.n)) {
      this.n = paramQQAppInterface.getApplication().getSharedPreferences(jdField_a_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin(), 0).getString(i, null);
    }
    return this.n;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return false;
      String str = paramQQAppInterface.getCurrentAccountUin();
      if (TextUtils.isEmpty(this.l)) {
        this.l = paramQQAppInterface.getApplication().getSharedPreferences(jdField_a_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin(), 0).getString(jdField_e_of_type_JavaLangString, null);
      }
      if (!TextUtils.isEmpty(this.l))
      {
        paramQQAppInterface = this.l.split(",");
        int i1 = 0;
        while (i1 < paramQQAppInterface.length)
        {
          CharSequence localCharSequence = paramQQAppInterface[i1];
          if ((!TextUtils.isEmpty(localCharSequence)) && (str.endsWith(localCharSequence.trim()))) {
            return true;
          }
          i1 += 1;
        }
      }
    }
  }
  
  public String c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    if (TextUtils.isEmpty(this.o)) {
      this.o = paramQQAppInterface.getApplication().getSharedPreferences(jdField_a_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin(), 0).getString(j, k);
    }
    return this.o;
  }
  
  public boolean c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return false;
      if (this.jdField_e_of_type_Int == -1) {
        this.jdField_e_of_type_Int = paramQQAppInterface.getApplication().getSharedPreferences(jdField_a_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin(), 0).getInt(g, 0);
      }
    } while (this.jdField_e_of_type_Int != jdField_b_of_type_Int);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbvz
 * JD-Core Version:    0.7.0.1
 */