import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessConfig.1;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import org.json.JSONObject;

public class amnj
{
  private static File jdField_a_of_type_JavaIoFile = new File(BaseApplicationImpl.getApplication().getFilesDir(), "confess_talk");
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final String f;
  public static final String g;
  public static final String h;
  public float a;
  public int a;
  public long a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final Random jdField_a_of_type_JavaUtilRandom;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  private long c;
  public int d;
  private long d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  private int m;
  public String m;
  private int n;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  private String t;
  private String u;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajya.a(2131702393);
    jdField_b_of_type_JavaLangString = ajya.a(2131702391);
    jdField_c_of_type_JavaLangString = ajya.a(2131702396);
    jdField_d_of_type_JavaLangString = ajya.a(2131702397);
    jdField_e_of_type_JavaLangString = ajya.a(2131702392);
    jdField_f_of_type_JavaLangString = ajya.a(2131702394);
    jdField_g_of_type_JavaLangString = ajya.a(2131702399);
    jdField_h_of_type_JavaLangString = ajya.a(2131702395);
  }
  
  public amnj(String paramString)
  {
    this.jdField_j_of_type_Int = 24;
    this.t = paramString;
    paramString = bbkb.a(this.t, "confess_config_sp");
    this.jdField_a_of_type_JavaUtilRandom = new Random(SystemClock.elapsedRealtime());
    this.jdField_b_of_type_Long = paramString.getLong("lLastVanishTime", 0L);
    this.jdField_m_of_type_Int = paramString.getInt("nContinuousVanishCount", 0);
    a(null, true);
    ThreadManager.postImmediately(new ConfessConfig.1(this), null, true);
  }
  
  public static int a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    int i1 = localCalendar1.get(6);
    int i4 = localCalendar1.get(1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    int i3 = localCalendar2.get(6);
    int i2 = localCalendar1.get(1);
    i1 -= i3;
    i3 = i1;
    if (i2 != i4)
    {
      i3 = i1;
      if (i2 < i4)
      {
        if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0)) {
          i1 += 366;
        }
        for (;;)
        {
          i2 += 1;
          break;
          i1 += 365;
        }
      }
    }
    return i3;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return 0L;
    }
    return bbkb.a(paramQQAppInterface.getAccount(), "confess_config_sp").getLong(paramString, 0L);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if ((paramAppInterface == null) || (paramContext == null)) {
      return;
    }
    paramAppInterface = ((amnn)paramAppInterface.getManager(269)).b();
    if (paramAppInterface == null)
    {
      paramAppInterface = "http://ti.qq.com/honest-say/holmes.html?_nav_alpha=0&_wwv=4&_qStyle=1";
      label30:
      if (TextUtils.isEmpty(paramAppInterface)) {
        break label195;
      }
      paramAppInterface = paramAppInterface + "&fromUin=" + atbp.a(paramString1);
      paramAppInterface = paramAppInterface + "&toUin=" + atbp.a(paramString2);
      paramString1 = paramAppInterface + "&topicId=" + paramInt;
      if (!paramBoolean) {
        break label197;
      }
    }
    label195:
    label197:
    for (paramAppInterface = "1";; paramAppInterface = "0")
    {
      paramAppInterface = paramString1 + "&isConfessor=" + paramAppInterface;
      paramString1 = new Intent(paramContext, QQBrowserActivity.class);
      paramString1.putExtra("hide_more_button", true);
      paramString1.putExtra("hide_operation_bar", true);
      paramString1.putExtra("url", paramAppInterface);
      paramContext.startActivity(paramString1);
      return;
      paramAppInterface = paramAppInterface.s;
      break label30;
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessConfig", 2, String.format("saveRedPointShow key:%s value:%d", new Object[] { paramString, Long.valueOf(paramLong) }));
    }
    bbkb.a(paramQQAppInterface.getAccount(), "confess_config_sp").edit().putLong(paramString, paramLong).apply();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.u = "";
    this.jdField_n_of_type_Int = 0;
    this.jdField_h_of_type_Int = 1;
    this.jdField_i_of_type_Int = 0;
    this.r = "";
    this.jdField_j_of_type_Int = 24;
    this.jdField_k_of_type_Int = 5;
    this.jdField_l_of_type_Int = 0;
    label322:
    Locale localLocale;
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
      this.jdField_c_of_type_Int = 0;
      this.jdField_d_of_type_Int = 0;
      this.jdField_e_of_type_Int = 0;
      this.jdField_f_of_type_Int = 0;
      this.jdField_a_of_type_Float = 5.0F;
      if (TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) {
        this.jdField_l_of_type_JavaLangString = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=contact_tab";
      }
      if (TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) {
        this.jdField_k_of_type_JavaLangString = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
      }
      if (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
        this.jdField_i_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
      }
      if (TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {
        this.jdField_j_of_type_JavaLangString = jdField_b_of_type_JavaLangString;
      }
      if (TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)) {
        this.jdField_m_of_type_JavaLangString = "https://ti.qq.com/honest-say/friends-received.html?_bid=3104&_wv=9191&_qStyle=1&adtag=message_box";
      }
      if (TextUtils.isEmpty(this.jdField_n_of_type_JavaLangString)) {
        this.jdField_n_of_type_JavaLangString = "https://ti.qq.com/honest-say/confess-detail.html?_bid=3104&_wv=9191&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&ADTAG=aio_card";
      }
      if (TextUtils.isEmpty(this.p)) {
        this.p = "https://ti.qq.com/honest-say/setting.html?_wv=9191&_wwv=4&_qStyle=1&adtag=message_box";
      }
      if (TextUtils.isEmpty(this.r)) {
        this.r = jdField_c_of_type_JavaLangString;
      }
      if (TextUtils.isEmpty(this.o)) {
        this.o = "https://ti.qq.com/honest-say/group-received.html?_bid=3104&_wv=9191&_qStyle=1";
      }
      if (TextUtils.isEmpty(this.q)) {
        this.q = "https://ti.qq.com/honest-say/rank.html?_wv=9191&_wwv=4&_qStyle=1";
      }
      if (TextUtils.isEmpty(this.s)) {
        this.s = "http://ti.qq.com/honest-say/holmes.html?_nav_alpha=0&_wwv=4&_qStyle=1";
      }
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramBoolean) {
        break label896;
      }
      this.jdField_a_of_type_Long = awzy.a();
      a((QQAppInterface)localObject, "rec_config_time", this.jdField_a_of_type_Long);
      if (QLog.isDevelopLevel())
      {
        localLocale = Locale.getDefault();
        if (!paramBoolean) {
          break label910;
        }
      }
    }
    label896:
    label910:
    String str;
    for (Object localObject = "local";; str = "server")
    {
      for (;;)
      {
        QLog.i("ConfessConfig", 4, String.format(localLocale, "parse %s config: %s", new Object[] { localObject, paramString }));
        return;
        try
        {
          localObject = new JSONObject(paramString);
          if (((JSONObject)localObject).has("min")) {
            this.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("min");
          }
          if (((JSONObject)localObject).has("max")) {
            this.jdField_c_of_type_Int = ((JSONObject)localObject).getInt("max");
          }
          if (((JSONObject)localObject).has("delta")) {
            this.jdField_d_of_type_Int = ((JSONObject)localObject).getInt("delta");
          }
          if (((JSONObject)localObject).has("X")) {
            this.jdField_e_of_type_Int = ((JSONObject)localObject).getInt("X");
          }
          if (((JSONObject)localObject).has("Y")) {
            this.jdField_f_of_type_Int = ((JSONObject)localObject).getInt("Y");
          }
          if (((JSONObject)localObject).has("contactEntryUrl")) {
            this.jdField_l_of_type_JavaLangString = ((JSONObject)localObject).getString("contactEntryUrl");
          }
          if (((JSONObject)localObject).has("boxEntryUrl")) {
            this.jdField_k_of_type_JavaLangString = ((JSONObject)localObject).getString("boxEntryUrl");
          }
          if (((JSONObject)localObject).has("title")) {
            this.jdField_i_of_type_JavaLangString = ((JSONObject)localObject).getString("title");
          }
          if (((JSONObject)localObject).has("subtitle")) {
            this.jdField_j_of_type_JavaLangString = ((JSONObject)localObject).getString("subtitle");
          }
          if (((JSONObject)localObject).has("changeInterval")) {
            this.jdField_a_of_type_Float = ((float)((JSONObject)localObject).getDouble("changeInterval"));
          }
          if (((JSONObject)localObject).has("frdRecUrl")) {
            this.jdField_m_of_type_JavaLangString = ((JSONObject)localObject).getString("frdRecUrl");
          }
          if (((JSONObject)localObject).has("frdRecMsgSwitch")) {
            this.jdField_n_of_type_Int = ((JSONObject)localObject).getInt("frdRecMsgSwitch");
          }
          if (((JSONObject)localObject).has("detailUrl")) {
            this.jdField_n_of_type_JavaLangString = ((JSONObject)localObject).getString("detailUrl");
          }
          if (((JSONObject)localObject).has("settingUrl")) {
            this.p = ((JSONObject)localObject).getString("settingUrl");
          }
          if (((JSONObject)localObject).has("entryBoxSwitch")) {
            this.jdField_h_of_type_Int = ((JSONObject)localObject).getInt("entryBoxSwitch");
          }
          if (((JSONObject)localObject).has("entryContactSwitch")) {
            this.jdField_i_of_type_Int = ((JSONObject)localObject).getInt("entryContactSwitch");
          }
          if (((JSONObject)localObject).has("redPointText")) {
            this.r = ((JSONObject)localObject).getString("redPointText");
          }
          if (((JSONObject)localObject).has("blockTime")) {
            this.jdField_j_of_type_Int = ((JSONObject)localObject).getInt("blockTime");
          }
          if (((JSONObject)localObject).has("groupCfsListUrl")) {
            this.o = ((JSONObject)localObject).getString("groupCfsListUrl");
          }
          if (((JSONObject)localObject).has("rankingSwitch")) {
            this.jdField_g_of_type_Int = ((JSONObject)localObject).getInt("rankingSwitch");
          }
          if (((JSONObject)localObject).has("rankingUrl")) {
            this.q = ((JSONObject)localObject).getString("rankingUrl");
          }
          if (((JSONObject)localObject).has("holmesCount")) {
            this.jdField_k_of_type_Int = ((JSONObject)localObject).optInt("holmesCount", 5);
          }
          if (((JSONObject)localObject).has("holmesUrl")) {
            this.s = ((JSONObject)localObject).optString("holmesUrl");
          }
          if (!((JSONObject)localObject).has("holmesSwitch")) {
            break;
          }
          this.jdField_l_of_type_Int = ((JSONObject)localObject).optInt("holmesSwitch", 0);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      break;
      this.jdField_a_of_type_Long = a(localException, "rec_config_time");
      break label322;
    }
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return false;
    }
    return ((amnn)paramAppInterface.getManager(269)).b().b();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {}
    while (bbkb.a(paramQQAppInterface.getAccount(), "confess_config_sp").getLong(paramString, 0L) <= 0L) {
      return false;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return bbkb.a(paramQQAppInterface.getAccount(), "confess_config_sp").edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  private String b()
  {
    Object localObject = "";
    try
    {
      String str = bbdx.b(new File(jdField_a_of_type_JavaIoFile, "confess_talk.cfg"));
      localObject = str;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.i("ConfessConfig", 1, "getConfigFromFile exception : " + QLog.getStackTraceString(localIOException));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessConfig", 2, "getConfigFromFile config is: " + (String)localObject);
    }
    return localObject;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return bbkb.a(paramQQAppInterface.getAccount(), "confess_config_sp").getBoolean(paramString, false);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessConfig", 2, "updateHolmesTipsNeedShow key:" + paramString + " value:" + paramBoolean);
    }
    return bbkb.a(paramQQAppInterface.getAccount(), "confess_config_sp").edit().putBoolean("holmes_tips_show_" + paramString, paramBoolean).commit();
  }
  
  public static boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessConfig", 2, "saveConfig2File config is: " + paramString);
    }
    String str2 = jdField_a_of_type_JavaIoFile.getPath() + File.separator;
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    boolean bool = bbdx.a(str2, "confess_talk.cfg", str1);
    QLog.i("ConfessConfig", 1, "saveConfig2File result : " + bool);
    return bool;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return bbkb.a(paramQQAppInterface.getAccount(), "confess_config_sp").getBoolean("holmes_tips_show_" + paramString, false);
  }
  
  public String a()
  {
    long l1 = SystemClock.elapsedRealtime();
    if ((!TextUtils.isEmpty(this.u)) && (Math.abs(l1 - this.jdField_d_of_type_Long) < (this.jdField_a_of_type_Float * 60000.0F))) {
      return this.u;
    }
    if (TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {
      this.u = "";
    }
    for (;;)
    {
      return this.u;
      if (!this.jdField_j_of_type_JavaLangString.contains("N"))
      {
        this.u = this.jdField_j_of_type_JavaLangString;
      }
      else if ((this.jdField_c_of_type_Int > 0) && (this.jdField_c_of_type_Int > this.jdField_b_of_type_Int))
      {
        int i1 = this.jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_c_of_type_Int);
        int i2 = this.jdField_c_of_type_Int;
        int i3 = this.jdField_b_of_type_Int;
        int i4 = this.jdField_b_of_type_Int;
        this.jdField_d_of_type_Long = l1;
        NumberFormat localNumberFormat = NumberFormat.getNumberInstance();
        this.u = this.jdField_j_of_type_JavaLangString.replace("N", localNumberFormat.format(i1 % (i2 - i3 + 1) + i4));
      }
      else
      {
        this.u = "";
      }
    }
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    if (a(paramQQAppInterface, "redpoint_leba_show"))
    {
      if (this.r == null) {
        return jdField_c_of_type_JavaLangString;
      }
      return this.r;
    }
    if (this.jdField_i_of_type_JavaLangString == null) {
      return jdField_a_of_type_JavaLangString;
    }
    return this.jdField_i_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    String str = b();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        a(str, true);
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
  }
  
  public boolean a()
  {
    boolean bool3 = true;
    long l1 = SystemClock.elapsedRealtime();
    if (Math.abs(l1 - this.jdField_c_of_type_Long) < 60000L) {
      return this.jdField_b_of_type_Boolean;
    }
    boolean bool1;
    if (this.jdField_i_of_type_Int >= 1)
    {
      bool1 = true;
      boolean bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) {
          bool2 = false;
        }
      }
      bool1 = bool2;
      if (bool2)
      {
        if (a(NetConnInfoCenter.getServerTimeMillis(), this.jdField_b_of_type_Long) == 0) {
          break label132;
        }
        bool1 = true;
      }
      label80:
      if ((!bool1) || (this.jdField_m_of_type_Int < this.jdField_e_of_type_Int)) {
        break label142;
      }
      if (a(NetConnInfoCenter.getServerTimeMillis(), this.jdField_b_of_type_Long) <= this.jdField_f_of_type_Int) {
        break label137;
      }
      bool1 = bool3;
    }
    label132:
    label137:
    label142:
    for (;;)
    {
      this.jdField_c_of_type_Long = l1;
      this.jdField_b_of_type_Boolean = bool1;
      return bool1;
      bool1 = false;
      break;
      bool1 = false;
      break label80;
      bool1 = false;
    }
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessConfig", 2, "onGetConfigFromServer config :" + paramString);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      a(paramString, false);
      return b(paramString);
    }
  }
  
  public boolean b()
  {
    return this.jdField_l_of_type_Int == 1;
  }
  
  public boolean c()
  {
    return this.jdField_n_of_type_Int == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(140);
    localStringBuilder.append("HonestSayConfig{").append("nSwitch: ").append(this.jdField_a_of_type_Int).append(", frdRecMsgSwitch: ").append(this.jdField_n_of_type_Int).append(", nMin: ").append(this.jdField_b_of_type_Int).append(", nMax: ").append(this.jdField_c_of_type_Int).append(", nDelta: ").append(this.jdField_d_of_type_Int).append(", nX: ").append(this.jdField_e_of_type_Int).append(", nY: ").append(this.jdField_f_of_type_Int).append(", fChangeInterval: ").append(this.jdField_a_of_type_Float).append(", title: ").append(this.jdField_i_of_type_JavaLangString).append(", subtitle: ").append(this.jdField_j_of_type_JavaLangString).append(", contactEntryUrl: ").append(this.jdField_l_of_type_JavaLangString).append(", boxEntryUrl: ").append(this.jdField_k_of_type_JavaLangString).append(", detailUrl: ").append(this.jdField_n_of_type_JavaLangString).append(", settingUrl: ").append(this.p).append(", lLastVanishTime: ").append(this.jdField_b_of_type_Long).append(", nContinuousVanishCount: ").append(this.jdField_m_of_type_Int).append(", rankingUrl: ").append(this.q).append(", rankSwitch: ").append(this.jdField_g_of_type_Int).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amnj
 * JD-Core Version:    0.7.0.1
 */