package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.conditionsearch.data.AddressData;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import mqq.manager.Manager;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceRespInfo;
import yyc;
import yyd;
import yyf;
import yyg;
import yyi;

public class ConditionSearchManager
  implements Manager
{
  public static final int[] a;
  public static final String[] a;
  public static final int[] b;
  public static final String[] b;
  public static final String[] c;
  public static final String[] d;
  public static final String[] e;
  public int a;
  public long a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private ConditionSearchManager.IFirstLocationReqCancelListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IFirstLocationReqCancelListener;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new yyi(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AddressData jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData;
  public volatile Card a;
  public Object a;
  public String a;
  public LinkedList a;
  List jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  public boolean a;
  public int b;
  public long b;
  public String b;
  LinkedList b;
  public List b;
  public volatile boolean b;
  public int c;
  private volatile long jdField_c_of_type_Long = 0L;
  private final String jdField_c_of_type_JavaLangString = "condation_search_sp";
  public volatile boolean c;
  public int d;
  private volatile long d;
  public volatile boolean d;
  public int e;
  public boolean e;
  public int f;
  private boolean f;
  public String[] f;
  public int g;
  private boolean g;
  public String[] g;
  private volatile boolean jdField_h_of_type_Boolean;
  private String[] jdField_h_of_type_ArrayOfJavaLangString;
  private String[] i;
  private String[] j;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "不限", "男", "女" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "不限", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99" };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "不限", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };
    jdField_d_of_type_ArrayOfJavaLangString = new String[] { "不限", "计算机/互联网/通信", "生产/工艺/制造", "医疗/护理/制药", "金融/银行/投资/保险", "商业/服务业/个体经营", "文化/广告/传媒", "娱乐/艺术/表演", "律师/法务", "教育/培训", "公务员/行政/事业单位", "模特", "空姐", "学生", "其他职业" };
    jdField_e_of_type_ArrayOfJavaLangString = new String[] { "", "IT", "制造", "医疗", "金融", "商业", "文化", "艺术", "法律", "教育", "行政", "模特", "空姐", "学生", "" };
    jdField_a_of_type_ArrayOfInt = new int[] { 2130843037, 2130842265, 2130842265, 2130842265, 2130842837, 2130842837, 2130843053, 2130843053, 2130842655, 2130842655, 2130842655, 2130843037, 2130843037, 2130842891, 2130843037 };
    jdField_b_of_type_ArrayOfInt = new int[] { -16777216, -11362561, -11362561, -11362561, -274353, -274353, -893603, -893603, -7745469, -7745469, -7745469, -8291118, -8291118, -16723548, -16777216 };
  }
  
  public ConditionSearchManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqDataCard = null;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_f_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_g_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilLinkedList = null;
    this.jdField_b_of_type_JavaUtilLinkedList = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("condation_search_sp", 0);
    this.jdField_f_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_first_run" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
    this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_config_version", 0L);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_last_checkup_time", 0L);
    this.jdField_g_of_type_Boolean = c();
  }
  
  public static final int a(String paramString)
  {
    int k = 0;
    int n = 0;
    int m = n;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals("0")) {
        m = n;
      }
    }
    else {
      return m;
    }
    int i1 = paramString.length();
    m = 0;
    for (;;)
    {
      n = m;
      m = k;
      if (n >= i1) {
        break;
      }
      int i2 = paramString.charAt(n);
      m = n + 1;
      k = (i2 << (i1 - 1 - n) * 8) + k;
    }
  }
  
  public static final String a(long paramLong)
  {
    if (paramLong == 0L) {
      return "0";
    }
    StringBuilder localStringBuilder = new StringBuilder(6);
    while (paramLong != 0L) {
      try
      {
        localStringBuilder.append((char)(int)(paramLong % 256L));
        paramLong >>= 8;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ConditionSearch.Manager", 2, localOutOfMemoryError, new Object[0]);
        }
        return "0";
      }
    }
    return localOutOfMemoryError.reverse().toString();
  }
  
  public static String a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/condition_search/" + paramString;
  }
  
  private boolean c()
  {
    boolean bool = true;
    if (this.jdField_f_of_type_Boolean) {
      bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_frist_run_add_contact" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
    }
    while ((this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_frist_run_in_5_2" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true)) && (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_sex_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0) == 0) && (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_age_index_v2_1" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0) == 0) && (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_age_index_v2_2" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0) == 0) && (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_job_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0) == 0) && (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_xingzuo_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0) == 0) && (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_loc_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "0").equals("0")) && (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_home_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "0").equals("0"))) {
      return bool;
    }
    return false;
  }
  
  private int e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "updateLocal | isParsing = " + this.jdField_h_of_type_Boolean);
    }
    if (this.jdField_h_of_type_Boolean) {
      return 0;
    }
    File localFile = new File(a("admin_region_config"));
    if ((localFile == null) || (!localFile.exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "updateLocal | file is not exist");
      }
      this.jdField_c_of_type_Long = 0L;
      return 3;
    }
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new yyd(this, localFile));
    return 0;
  }
  
  public int a()
  {
    int k;
    if (this.jdField_c_of_type_Long == 0L) {
      k = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "checkUpdate | result = " + k);
      }
      return k;
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData == null) {
        k = 2;
      } else {
        k = 0;
      }
    }
  }
  
  public int a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "update, result=" + paramInt + ", downloadNow=" + paramBoolean);
    }
    if (paramInt == 1)
    {
      l = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("update | isCheckingUpdate = ").append(this.jdField_b_of_type_Boolean).append(" | interval is enough ");
        if (Math.abs(l - this.jdField_d_of_type_Long) >= 60000L)
        {
          bool = true;
          QLog.d("ConditionSearch.Manager", 2, bool + " | isNetAvaiable = " + NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()));
        }
      }
      else
      {
        if (!this.jdField_b_of_type_Boolean) {
          break label264;
        }
        if ((!paramBoolean) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
          break label246;
        }
        localObject = ((PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(192)).a(this.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ConditionSearch.Manager", 2, "update, find task=" + localObject);
        }
        if ((localObject != null) && ((localObject instanceof ConditionSearchManager.DownloadTask))) {
          ((ConditionSearchManager.DownloadTask)localObject).a();
        }
      }
    }
    label246:
    while (paramInt != 2)
    {
      long l;
      Object localObject;
      do
      {
        for (;;)
        {
          return 0;
          boolean bool = false;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ConditionSearch.Manager", 2, "update mUrl might be null");
      return 0;
      if (Math.abs(l - this.jdField_d_of_type_Long) < 60000L) {
        return 1;
      }
      if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
        return 2;
      }
      if ((this.jdField_a_of_type_Boolean) || (paramBoolean)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.jdField_a_of_type_Boolean = paramBoolean;
        localObject = (ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4);
        ((ConfigHandler)localObject).a(null, new GetResourceReqInfo[] { ((ConfigHandler)localObject).e() });
        return 0;
      }
    }
    label264:
    return e();
  }
  
  public final long a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_last_checkup_time", this.jdField_d_of_type_Long).commit();
      this.jdField_b_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "getConfigVersion | version = " + this.jdField_c_of_type_Long);
    }
    return this.jdField_c_of_type_Long;
  }
  
  public BaseAddress a(String paramString)
  {
    BaseAddress localBaseAddress = null;
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData != null) {
      localBaseAddress = (BaseAddress)this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a.get(paramString);
    }
    return localBaseAddress;
  }
  
  public String a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("location_string" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "不限");
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("home_string" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "不限");
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    if (((paramInt1 > paramInt2) && (paramInt2 != 0)) || (paramInt1 < 0) || (paramInt2 < 0)) {
      return jdField_b_of_type_ArrayOfJavaLangString[0];
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return jdField_b_of_type_ArrayOfJavaLangString[0];
    }
    if ((paramInt1 == 0) && (paramInt2 != 0)) {
      return jdField_b_of_type_ArrayOfJavaLangString[paramInt2] + "岁及以下";
    }
    if ((paramInt1 != 0) && (paramInt2 == 0)) {
      return jdField_b_of_type_ArrayOfJavaLangString[paramInt1] + "岁及以上";
    }
    if (paramInt1 == paramInt2) {
      return jdField_b_of_type_ArrayOfJavaLangString[paramInt1] + "岁";
    }
    return jdField_b_of_type_ArrayOfJavaLangString[paramInt1] + "-" + jdField_b_of_type_ArrayOfJavaLangString[paramInt2] + "岁";
  }
  
  public String a(String[] paramArrayOfString)
  {
    String str2 = b(paramArrayOfString);
    String str1 = str2;
    if ("1".equals(paramArrayOfString[0]))
    {
      str1 = str2;
      if (str2.split("-").length > 1) {
        str1 = str2.substring(str2.indexOf("-") + 1, str2.length());
      }
    }
    return str1;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData != null)
    {
      localArrayList = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a.size());
      localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a.values());
      Collections.sort(localArrayList, new yyc(this));
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IFirstLocationReqCancelListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IFirstLocationReqCancelListener.a();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_job_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt).commit();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_age_index_v2_1" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt1).commit();
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_age_index_v2_2" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt2).commit();
  }
  
  public void a(int paramInt, File paramFile, GetResourceRespInfo paramGetResourceRespInfo)
  {
    boolean bool3 = true;
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "onConfigFileDownloadSuccess, result=" + paramInt + ", file=" + paramFile + ", resp=" + paramGetResourceRespInfo);
    }
    boolean bool1;
    if (paramInt == 0)
    {
      File localFile = new File(a("admin_region_config"));
      if ((paramFile.renameTo(localFile)) || (paramFile.renameTo(localFile)) || (paramFile.renameTo(localFile)))
      {
        this.jdField_c_of_type_Long = paramGetResourceRespInfo.uiNewVer;
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_config_version", this.jdField_c_of_type_Long).commit();
        bool1 = true;
        bool2 = bool1;
        if (QLog.isColorLevel()) {
          QLog.d("ConditionSearch.Manager", 2, "onCheckupConfig | rename result = " + bool1);
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = true)
    {
      if ((paramInt == 0) && (bool2)) {}
      for (bool1 = bool3;; bool1 = false)
      {
        a(bool1);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("location_string" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString).commit();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("home_string" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString).commit();
  }
  
  public void a(ConditionSearchManager.IFirstLocationReqCancelListener paramIFirstLocationReqCancelListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IFirstLocationReqCancelListener = paramIFirstLocationReqCancelListener;
  }
  
  public void a(Card paramCard)
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
    a(this.jdField_a_of_type_JavaLangObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new yyg(this));
  }
  
  public void a(Object paramObject)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramObject))
      {
        this.jdField_a_of_type_JavaUtilList.add(paramObject);
        this.jdField_c_of_type_Boolean = true;
        a(a());
        if ((paramObject instanceof ConditionSearchFriendActivity))
        {
          this.jdField_f_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_first_run" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false).commit();
        }
      }
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public void a(GetResourceRespInfo paramGetResourceRespInfo)
  {
    Object localObject;
    int k;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onCheckupConfig | resp = ").append(paramGetResourceRespInfo).append(" | iResult = ");
      if (paramGetResourceRespInfo != null)
      {
        k = paramGetResourceRespInfo.iResult;
        QLog.d("ConditionSearch.Manager", 2, k + ", needDownloadNow=" + this.jdField_a_of_type_Boolean);
      }
    }
    else
    {
      if ((paramGetResourceRespInfo != null) && (paramGetResourceRespInfo.iResult == 0)) {
        break label93;
      }
      a(false);
    }
    label93:
    boolean bool;
    do
    {
      do
      {
        return;
        k = -1000;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ConditionSearch.Manager", 2, "onCheckupConfig | local version = " + this.jdField_c_of_type_Long + " | server version = " + paramGetResourceRespInfo.uiNewVer);
        }
      } while (this.jdField_c_of_type_Long == paramGetResourceRespInfo.uiNewVer);
      localObject = paramGetResourceRespInfo.strResURL_big;
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ConditionSearch.Manager", 2, "onCheckupConfig | url is null");
        }
        a(false);
        return;
      }
      File localFile = new File(a("temp_admin_regin_config"));
      paramGetResourceRespInfo = new ConditionSearchManager.DownloadTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, paramGetResourceRespInfo, localFile);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        paramGetResourceRespInfo.a();
        return;
      }
      bool = ((PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(192)).a(10023, "prd", (String)localObject, 0, (String)localObject, localFile.getAbsolutePath(), 2, 0, false, paramGetResourceRespInfo);
    } while (!QLog.isColorLevel());
    QLog.d("ConditionSearch.Manager", 2, "innerDownload, PreDownloadController.ret=" + bool);
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new yyf(this, paramBoolean));
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt4, int paramInt5, int paramInt6)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seachFriend | restart = ").append(paramBoolean).append(" | keyword = ").append(paramString).append(" | sexIndex = ").append(paramInt1).append(" | ageIndex1 = ").append(paramInt2).append(" | ageIndex2 = ").append(paramInt3).append(" | jobIndex = ").append(paramInt4).append(" | xingzuoIndex = ").append(paramInt5).append(" | searchFromMore = ").append(paramInt6);
      int k;
      if ((paramArrayOfString1 != null) && (paramArrayOfString1.length > 0))
      {
        localStringBuilder.append(" | locCodes = ");
        k = 0;
        while (k < paramArrayOfString1.length)
        {
          localStringBuilder.append(paramArrayOfString1[k]).append("、");
          k += 1;
        }
      }
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0))
      {
        localStringBuilder.append(" | homeCodes = ");
        k = 0;
        while (k < paramArrayOfString2.length)
        {
          localStringBuilder.append(paramArrayOfString2[k]).append("、");
          k += 1;
        }
      }
      QLog.d("ConditionSearch.Manager", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Long += 1L;
      this.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_c_of_type_Int = paramInt3;
      this.jdField_f_of_type_ArrayOfJavaLangString = paramArrayOfString1;
      this.jdField_g_of_type_ArrayOfJavaLangString = paramArrayOfString2;
      this.jdField_d_of_type_Int = paramInt4;
      this.jdField_e_of_type_Int = paramInt5;
      this.jdField_f_of_type_Int = -1;
      this.jdField_b_of_type_Long = 0L;
    }
    while (this.jdField_e_of_type_Boolean)
    {
      this.jdField_g_of_type_Int = 0;
      this.jdField_b_of_type_JavaUtilList = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(this.jdField_a_of_type_Long, this.jdField_f_of_type_Int + 1, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_f_of_type_ArrayOfJavaLangString, this.jdField_g_of_type_ArrayOfJavaLangString, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, paramInt6);
      return;
    }
    throw new RuntimeException("No more elements");
  }
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_b_of_type_JavaUtilLinkedList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedList.iterator();
      while (localIterator.hasNext()) {
        ((ConditionSearchManager.ISearchListener)localIterator.next()).a(paramBoolean1, paramList, paramBoolean2, paramInt);
      }
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    if (paramArrayOfString.length != 4) {
      throw new IllegalArgumentException("Error size " + paramArrayOfString.length);
    }
    this.jdField_h_of_type_ArrayOfJavaLangString = ((String[])paramArrayOfString.clone());
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("key_cur_loc_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_h_of_type_ArrayOfJavaLangString[0]).putString("key_cur_loc_prov_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_h_of_type_ArrayOfJavaLangString[1]).putString("key_cur_loc_city_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_h_of_type_ArrayOfJavaLangString[2]).putString("key_cur_loc_dist_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_h_of_type_ArrayOfJavaLangString[3]).commit();
  }
  
  public boolean a()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public int[] a()
  {
    Card localCard;
    int k;
    int m;
    if (this.jdField_g_of_type_Boolean)
    {
      localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (localCard == null) {
        break label357;
      }
      if ((localCard.age <= 5) || (localCard.age >= 60))
      {
        k = 0;
        m = 0;
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_age_index_v2_1" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), m).commit();
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_age_index_v2_2" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), k).commit();
      }
    }
    for (;;)
    {
      return new int[] { m, k };
      if ((localCard.age >= 6) && (localCard.age <= 11))
      {
        k = 11;
        m = 6;
        break;
      }
      if ((localCard.age >= 12) && (localCard.age <= 17))
      {
        k = 17;
        m = 12;
        break;
      }
      if ((localCard.age >= 18) && (localCard.age <= 21))
      {
        k = 21;
        m = 18;
        break;
      }
      if (localCard.shGender != 0)
      {
        m = localCard.age - 5;
        k = localCard.age + 10;
        break;
      }
      k = localCard.age + 5;
      m = 18;
      break;
      m = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_age_index_v2_1" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      k = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_age_index_v2_2" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      continue;
      label357:
      k = 0;
      m = 0;
    }
  }
  
  public String[] a()
  {
    if (this.jdField_h_of_type_ArrayOfJavaLangString == null)
    {
      this.jdField_h_of_type_ArrayOfJavaLangString = new String[4];
      this.jdField_h_of_type_ArrayOfJavaLangString[0] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_cur_loc_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "0");
      this.jdField_h_of_type_ArrayOfJavaLangString[1] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_cur_loc_prov_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "0");
      this.jdField_h_of_type_ArrayOfJavaLangString[2] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_cur_loc_city_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "0");
      this.jdField_h_of_type_ArrayOfJavaLangString[3] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_cur_loc_dist_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "0");
    }
    return this.jdField_h_of_type_ArrayOfJavaLangString;
  }
  
  public String[] a(String paramString)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "不限";
    arrayOfString[1] = "不限";
    if ((!TextUtils.isEmpty(paramString)) && (!"不限".equals(paramString)))
    {
      int k = paramString.indexOf("-");
      if (k != -1)
      {
        arrayOfString[0] = paramString.substring(0, k);
        arrayOfString[1] = paramString.substring(k + 1);
      }
    }
    else
    {
      return arrayOfString;
    }
    arrayOfString[0] = paramString;
    return arrayOfString;
  }
  
  public String[] a(String[] paramArrayOfString)
  {
    int k = 1;
    if ((paramArrayOfString == null) || (paramArrayOfString.length != 4) || ("-1".equals(paramArrayOfString[0]))) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData == null)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfString = new StringBuilder().append("praseCodeArrayToAddress addressData == null is ");
        if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData != null) {
          break label79;
        }
      }
      label79:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("ConditionSearch.Manager", 2, bool);
        return null;
      }
    }
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    arrayOfString[3] = "";
    if ("-1".equals(paramArrayOfString[0])) {
      return arrayOfString;
    }
    Object localObject1 = (BaseAddress)this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a.get(paramArrayOfString[0]);
    if (localObject1 == null) {
      return arrayOfString;
    }
    arrayOfString[0] = ((BaseAddress)localObject1).name;
    while (k < 4)
    {
      Object localObject2 = localObject1;
      if (!"0".equals(paramArrayOfString[k]))
      {
        localObject2 = (BaseAddress)((BaseAddress)localObject1).dataMap.get(paramArrayOfString[k]);
        if (localObject2 == null) {
          break;
        }
        arrayOfString[k] = ((BaseAddress)localObject2).name;
      }
      k += 1;
      localObject1 = localObject2;
    }
    return arrayOfString;
  }
  
  public int b()
  {
    int k = 0;
    if (!this.jdField_g_of_type_Boolean) {
      k = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_job_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    }
    return k;
  }
  
  public String b(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = "";
    }
    String str;
    do
    {
      for (;;)
      {
        return localObject;
        str = paramString;
        try
        {
          String[] arrayOfString = paramString.split("-");
          str = paramString;
          if (arrayOfString[0].equals("中国"))
          {
            str = paramString;
            if (arrayOfString.length > 2)
            {
              paramString = arrayOfString[2];
              localObject = paramString;
              str = paramString;
              if (arrayOfString.length > 3)
              {
                str = paramString;
                return paramString + "-" + arrayOfString[3];
              }
            }
            else
            {
              localObject = paramString;
              str = paramString;
              if (arrayOfString.length > 1) {
                return arrayOfString[1];
              }
            }
          }
          else
          {
            localObject = paramString;
            str = paramString;
            if (arrayOfString.length > 2)
            {
              str = paramString;
              paramString = arrayOfString[(arrayOfString.length - 2)] + "-" + arrayOfString[(arrayOfString.length - 1)];
              return paramString;
            }
          }
        }
        catch (Exception paramString)
        {
          localObject = str;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ConditionSearch.Manager", 2, "", paramString);
    return str;
  }
  
  public String b(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length != 4) || ("-1".equals(paramArrayOfString[0]))) {
      return "0";
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "praseCodeArrayToAddress addressData == null is");
      }
      return "不限";
    }
    if ("-1".equals(paramArrayOfString[0])) {
      return "不限";
    }
    if (((AddressData)localObject1).a != null) {}
    for (localObject1 = (BaseAddress)((AddressData)localObject1).a.get(paramArrayOfString[0]); localObject1 == null; localObject1 = null) {
      return "不限";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((BaseAddress)localObject1).name);
    int k = 1;
    while (k < 4)
    {
      Object localObject2 = localObject1;
      if (!"0".equals(paramArrayOfString[k]))
      {
        localObject2 = (BaseAddress)((BaseAddress)localObject1).dataMap.get(paramArrayOfString[k]);
        if (localObject2 == null) {
          break;
        }
        localStringBuilder.append("-").append(((BaseAddress)localObject2).name);
      }
      k += 1;
      localObject1 = localObject2;
    }
    return localStringBuilder.toString();
  }
  
  public void b()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_g_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_frist_run_in_5_2" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false).commit();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_frist_run_add_contact" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false).commit();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_xingzuo_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt).commit();
  }
  
  public void b(Object paramObject)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramObject);
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData = null;
      }
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public void b(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    if (paramArrayOfString.length != 4) {
      throw new IllegalArgumentException("Error size " + paramArrayOfString.length);
    }
    this.i = ((String[])paramArrayOfString.clone());
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("key_loc_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.i[0]).putString("key_loc_prov_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.i[1]).putString("key_loc_city_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.i[2]).putString("key_loc_dist_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.i[3]).commit();
  }
  
  public boolean b()
  {
    boolean bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_first_select_location" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
    if (bool) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_first_select_location" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false).commit();
    }
    return bool;
  }
  
  public String[] b()
  {
    if (this.i == null)
    {
      this.i = new String[4];
      this.i[0] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_loc_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "0");
      this.i[1] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_loc_prov_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "0");
      this.i[2] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_loc_city_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "0");
      this.i[3] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_loc_dist_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "0");
    }
    return this.i;
  }
  
  public int c()
  {
    int k = 0;
    if (!this.jdField_g_of_type_Boolean) {
      k = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_xingzuo_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    }
    return k;
  }
  
  public String c(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("中国"))
    {
      String[] arrayOfString = StringUtil.a(paramString, '-');
      str = paramString;
      if (arrayOfString.length >= 2)
      {
        paramString = new StringBuilder();
        int k = 1;
        while (k < arrayOfString.length)
        {
          paramString.append(arrayOfString[k]);
          if (k != arrayOfString.length - 1) {
            paramString.append("-");
          }
          k += 1;
        }
        str = paramString.toString();
      }
    }
    return str;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_sex_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt).commit();
  }
  
  public void c(Object paramObject)
  {
    if ((paramObject instanceof ConditionSearchManager.IConfigListener))
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList == null) {
        this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
      }
      if (this.jdField_a_of_type_JavaUtilLinkedList.contains(paramObject)) {}
    }
    do
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add((ConditionSearchManager.IConfigListener)paramObject);
      do
      {
        return;
      } while (!(paramObject instanceof ConditionSearchManager.ISearchListener));
      if (this.jdField_b_of_type_JavaUtilLinkedList == null) {
        this.jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
      }
    } while (this.jdField_b_of_type_JavaUtilLinkedList.contains(paramObject));
    this.jdField_b_of_type_JavaUtilLinkedList.add((ConditionSearchManager.ISearchListener)paramObject);
  }
  
  public void c(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    if (paramArrayOfString.length != 4) {
      throw new IllegalArgumentException("Error size " + paramArrayOfString.length);
    }
    this.j = ((String[])paramArrayOfString.clone());
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("key_home_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.j[0]).putString("key_home_prov_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.j[1]).putString("key_home_city_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.j[2]).putString("key_home_dist_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.j[3]).commit();
  }
  
  public String[] c()
  {
    if (this.j == null)
    {
      this.j = new String[4];
      this.j[0] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_home_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "0");
      this.j[1] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_home_prov_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "0");
      this.j[2] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_home_city_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "0");
      this.j[3] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_home_dist_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "0");
    }
    return this.j;
  }
  
  public int d()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      Card localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (localCard == null) {
        break label134;
      }
      if (localCard.shGender != 0) {
        break label129;
      }
    }
    label129:
    for (int k = 2;; k = 0)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_sex_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), k).commit();
      return k;
      return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_sex_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    }
    label134:
    return 0;
  }
  
  public void d(Object paramObject)
  {
    if ((paramObject instanceof ConditionSearchManager.IConfigListener)) {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null) {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(paramObject);
      }
    }
    while ((!(paramObject instanceof ConditionSearchManager.ISearchListener)) || (this.jdField_b_of_type_JavaUtilLinkedList == null)) {
      return;
    }
    this.jdField_b_of_type_JavaUtilLinkedList.remove(paramObject);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a();
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager
 * JD-Core Version:    0.7.0.1
 */