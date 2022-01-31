import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VipGrayConfigHelper.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class bapw
{
  private static bapw jdField_a_of_type_Bapw;
  private static final Runnable jdField_a_of_type_JavaLangRunnable = new VipGrayConfigHelper.1();
  private static final List<String> jdField_a_of_type_JavaUtilList;
  private static final Map<String, AtomicInteger> jdField_a_of_type_JavaUtilMap;
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private static final Map<String, AtomicInteger> jdField_b_of_type_JavaUtilMap;
  private static final Map<String, AtomicReference<Intent>> c;
  private static final Map<String, AtomicLong> d;
  private int jdField_a_of_type_Int = 1;
  public String a;
  public String b;
  private List<bapy> jdField_b_of_type_JavaUtilList = new ArrayList();
  public String c;
  public String d;
  private String e = "http://imgcache.gtimg.cn/club/mqgame/";
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_JavaUtilMap = new HashMap();
    jdField_c_of_type_JavaUtilMap = new HashMap();
    jdField_d_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public bapw()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
  }
  
  public static bapw a()
  {
    if (jdField_a_of_type_Bapw == null) {
      jdField_a_of_type_Bapw = new bapw();
    }
    return jdField_a_of_type_Bapw;
  }
  
  public static void a()
  {
    int i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if ((i < 0) || (i >= jdField_a_of_type_JavaUtilList.size())) {}
    Object localObject;
    do
    {
      return;
      localObject = (String)jdField_a_of_type_JavaUtilList.get(i);
      localObject = (AtomicLong)jdField_d_of_type_JavaUtilMap.get(localObject);
    } while (localObject == null);
    ThreadManager.getSubThreadHandler().removeCallbacks(jdField_a_of_type_JavaLangRunnable);
    ThreadManager.getSubThreadHandler().postDelayed(jdField_a_of_type_JavaLangRunnable, ((AtomicLong)localObject).get());
  }
  
  private void a(AppRuntime paramAppRuntime, JSONArray paramJSONArray, boolean paramBoolean)
  {
    if ((paramAppRuntime == null) || (paramJSONArray == null) || (paramJSONArray.length() < 0))
    {
      QLog.e("VipGrayConfigHelper", 1, "parseVipGrayConfig app = null or configList = null or len < 0");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipGrayConfigHelper", 2, "parseVipGrayConfig begin config = " + paramJSONArray.toString());
    }
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("vipGrayConfigSp", 0);
    if (paramBoolean)
    {
      jdField_a_of_type_JavaUtilList.clear();
      jdField_a_of_type_JavaUtilMap.clear();
      jdField_b_of_type_JavaUtilMap.clear();
      jdField_d_of_type_JavaUtilMap.clear();
      jdField_c_of_type_JavaUtilMap.clear();
      ((SharedPreferences)localObject).edit().clear().apply();
      if (paramBoolean) {
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      }
    }
    for (;;)
    {
      try
      {
        int j = paramJSONArray.length();
        int i = 0;
        String str;
        if (i < j)
        {
          localObject = paramJSONArray.getJSONObject(i);
          str = ((JSONObject)localObject).optString("business");
          if ("vipEnterText".equals(str))
          {
            if (a(paramAppRuntime, (JSONObject)localObject))
            {
              this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("notVip");
              this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("outdatedVip");
              this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("vip");
              this.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("svip");
              if (QLog.isColorLevel()) {
                QLog.d("VipGrayConfigHelper", 2, "parse vipEnterText notvip = " + this.jdField_a_of_type_JavaLangString + ", outdatevip = " + this.jdField_c_of_type_JavaLangString + ", vipstr= " + this.jdField_b_of_type_JavaLangString + ", svip = " + this.jdField_d_of_type_JavaLangString);
              }
            }
            i += 1;
            continue;
            if (!jdField_a_of_type_JavaUtilList.isEmpty()) {
              break;
            }
            paramBoolean = true;
            break;
          }
          if (("backgroundWebView".equals(str)) && (paramBoolean)) {
            continue;
          }
          if (!"gameIcon".equals(str)) {
            break label455;
          }
          if (!a(paramAppRuntime, (JSONObject)localObject)) {
            continue;
          }
          this.e = ((JSONObject)localObject).optString("baseUrl", "");
          this.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("expireDay", 0);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("VipGrayConfigHelper", 2, "king info, url = " + this.e + ",expireDay = " + this.jdField_a_of_type_Int);
          continue;
        }
        if (!"ipStackConfigDic".equals(str)) {
          continue;
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("VipGrayConfigHelper", 1, "parseVipGrayConfig exception", paramAppRuntime);
        a();
        return;
      }
      label455:
      if (a(paramAppRuntime, (JSONObject)localObject))
      {
        long l = ((JSONObject)localObject).optLong("ipStackTimeInterval");
        ((arny)paramAppRuntime.getManager(200)).a(l);
        if (QLog.isColorLevel()) {
          QLog.d("VipGrayConfigHelper", 2, "ipsite interval = " + l);
        }
      }
    }
  }
  
  private void b()
  {
    try
    {
      int j = this.jdField_b_of_type_JavaUtilList.size();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          ((bapy)this.jdField_b_of_type_JavaUtilList.get(i)).a();
          i += 1;
        }
      }
      return;
    }
    finally {}
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.e = "http://imgcache.gtimg.cn/club/mqgame/";
    this.jdField_a_of_type_Int = 1;
  }
  
  public String a(String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    return a(paramString, paramLong, paramInt, paramBoolean, false);
  }
  
  public String a(String paramString, long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.i("VipGrayConfigHelper", 2, "getNamePlateOfKingUrl, gameAppId = " + paramLong + " dan = " + paramInt + " danSwitch = " + paramBoolean1 + " isSetting = " + paramBoolean2);
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    int j;
    SharedPreferences localSharedPreferences;
    int i;
    if ((!TextUtils.isEmpty(this.e)) && (paramLong != 0L))
    {
      j = 1;
      if (!(localObject instanceof QQAppInterface)) {
        break label385;
      }
      localObject = (QQAppInterface)localObject;
      localSharedPreferences = ((QQAppInterface)localObject).getApp().getSharedPreferences("sp_plate_of_king", 0);
      if ((TextUtils.isEmpty(paramString)) || (!((QQAppInterface)localObject).c().equals(paramString))) {
        break label255;
      }
      i = 1;
    }
    label146:
    for (boolean bool = localSharedPreferences.getBoolean("plate_of_king_display_switch_" + ((QQAppInterface)localObject).c(), true);; bool = true)
    {
      if (i != 0)
      {
        i = k;
        if (j != 0) {
          if (!bool)
          {
            i = k;
            if (!paramBoolean2) {}
          }
          else
          {
            i = 1;
          }
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          if (paramInt == 0)
          {
            return this.e + paramLong + ".png";
            j = 0;
            break;
            label255:
            i = 0;
            break label146;
            i = k;
            if (j == 0) {
              continue;
            }
            i = k;
            if (!paramBoolean1) {
              continue;
            }
            i = 1;
            continue;
          }
          return this.e + paramLong + "_" + paramInt + ".png";
        }
      }
      QLog.e("VipGrayConfigHelper", 1, "getNamePlateOfKingUrl namePlateOfKingUrl = null gameAppId= " + paramLong + " dan= " + paramInt + " danSwitch= " + paramBoolean1 + " localSwitch = " + bool);
      return null;
      i = 0;
    }
  }
  
  public void a(bapy parambapy)
  {
    if (parambapy != null) {}
    try
    {
      if (!this.jdField_b_of_type_JavaUtilList.contains(parambapy)) {
        this.jdField_b_of_type_JavaUtilList.add(parambapy);
      }
      return;
    }
    finally
    {
      parambapy = finally;
      throw parambapy;
    }
  }
  
  public void a(URLImageView paramURLImageView, boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean2, String paramString)
  {
    if (paramURLImageView == null) {}
    do
    {
      return;
      paramURLImageView.setVisibility(8);
    } while (!a(paramBoolean1, paramLong1));
    paramURLImageView.setVisibility(0);
    paramString = a(paramString, paramLong2, paramInt, paramBoolean2);
    if (TextUtils.isEmpty(paramString))
    {
      paramURLImageView.setVisibility(8);
      return;
    }
    URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, new ColorDrawable(), new ColorDrawable());
    if (localURLDrawable.getStatus() != 1) {
      localURLDrawable.restartDownload();
    }
    paramURLImageView.setBackgroundDrawable(localURLDrawable);
    paramURLImageView.setURLDrawableDownListener(new bapx(this, paramString, paramURLImageView));
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    a(paramAppRuntime, false);
  }
  
  public void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (paramAppRuntime == null) {
      QLog.e("VipGrayConfigHelper", 1, "parsejson error, app = null");
    }
    Object localObject;
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VipGrayConfigHelper", 2, "parsejson, begin");
      }
      c();
      try
      {
        localObject = VasQuickUpdateManager.getJSONFromLocal(paramAppRuntime, "vip_personal_card.json", true, null);
        if (localObject == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("VipGrayConfigHelper", 2, "parsejson file not exists");
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("VipGrayConfigHelper", 1, "parseJson exception", paramAppRuntime);
      }
    }
    for (;;)
    {
      b();
      return;
      localObject = ((JSONObject)localObject).optJSONArray("vipGrayConfig");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
        a(paramAppRuntime, (JSONArray)localObject, paramBoolean);
      } else {
        QLog.e("VipGrayConfigHelper", 1, "parsejson configList = null or len < 0");
      }
    }
  }
  
  public boolean a(AppRuntime paramAppRuntime, JSONObject paramJSONObject)
  {
    bool3 = false;
    bool1 = false;
    boolean bool2 = true;
    if ((paramAppRuntime == null) || (paramJSONObject == null))
    {
      QLog.e("VipGrayConfigHelper", 1, "isConfigValid app = null || config = null");
      bool2 = bool1;
      return bool2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipGrayConfigHelper", 2, "isConfigValid config = " + paramJSONObject.toString());
    }
    try
    {
      i = paramJSONObject.optInt("platformId");
      if (i != 0)
      {
        bool1 = bool3;
        if (i != 2) {
          break label300;
        }
      }
      if (!paramJSONObject.has("minVersion")) {
        break label434;
      }
      str = paramJSONObject.getString("minVersion");
      if ((TextUtils.isEmpty(str)) || (banq.a(str, "8.2.6.4370"))) {
        break label434;
      }
      i = 0;
    }
    catch (Exception paramAppRuntime)
    {
      for (;;)
      {
        String str;
        int j;
        int k;
        long l1;
        long l2;
        long l3;
        label300:
        label340:
        label383:
        QLog.e("VipGrayConfigHelper", 1, "isConfigValid exception", paramAppRuntime);
        bool1 = bool3;
        continue;
        int i = 1;
        continue;
        bool1 = false;
      }
    }
    j = i;
    if (i != 0)
    {
      j = i;
      if (paramJSONObject.has("maxVersion"))
      {
        str = paramJSONObject.getString("maxVersion");
        j = i;
        if (!TextUtils.isEmpty(str))
        {
          j = i;
          if (!banq.a("8.2.6.4370", str)) {
            j = 0;
          }
        }
      }
    }
    bool1 = bool3;
    if (j != 0)
    {
      paramAppRuntime = paramAppRuntime.getAccount();
      i = paramJSONObject.optInt("startIndex");
      j = paramJSONObject.optInt("endIndex");
      if (i < j) {
        break label383;
      }
      k = paramAppRuntime.length();
      if ((k < i) || (k < j)) {
        break label340;
      }
      l1 = Long.parseLong(paramAppRuntime.substring(k - i, k - j + 1));
      l2 = paramJSONObject.optLong("min");
      l3 = paramJSONObject.optLong("max");
      if ((l1 < l2) || (l1 > l3)) {
        break label439;
      }
    }
    for (bool1 = bool2;; bool1 = bool3)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VipGrayConfigHelper", 2, "isConfigValid valid = " + bool1);
      return bool1;
      QLog.e("VipGrayConfigHelper", 1, "parseJson, index config error, uin length=" + k + ", config=" + paramJSONObject.toString());
      break label439;
      QLog.e("VipGrayConfigHelper", 1, "parseJson, startIndex < endIndex, element=" + paramJSONObject);
    }
  }
  
  public boolean a(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipGrayConfigHelper", 2, "showNamePlateOfKing, isSuperVip = " + paramBoolean + ", lastLoginTime = " + paramLong);
    }
    if (!paramBoolean) {
      return false;
    }
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    paramLong = NetConnInfoCenter.getServerTime();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong * 1000L);
    int i = localCalendar.get(6);
    localCalendar.setTimeInMillis(l * 1000L);
    return i - localCalendar.get(6) <= this.jdField_a_of_type_Int;
  }
  
  public void b(bapy parambapy)
  {
    if (parambapy != null) {}
    try
    {
      if (this.jdField_b_of_type_JavaUtilList.contains(parambapy)) {
        this.jdField_b_of_type_JavaUtilList.remove(parambapy);
      }
      return;
    }
    finally
    {
      parambapy = finally;
      throw parambapy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bapw
 * JD-Core Version:    0.7.0.1
 */