package com.tencent.mobileqq.app;

import SummaryCard.CondFitUser;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.conditionsearch.data.AddressData;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
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
import org.json.JSONException;
import org.json.JSONObject;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceRespInfo;
import tencent.im.oidb.cmd0x972.oidb_0x972.ResultItem;
import tencent.im.oidb.cmd0x972.oidb_0x972.ResultItemGroup;
import tencent.im.oidb.cmd0x972.oidb_0x972.RspBody;

public class ConditionSearchManager
  implements Manager
{
  public static final int[] a;
  public static final String[] a;
  public static final int[] b;
  public static final String[] b;
  public static final int[] c;
  public static final String[] c;
  public static final String[] d;
  public static final String[] e;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private ConditionSearchManager.IFirstLocationReqCancelListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IFirstLocationReqCancelListener;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ConditionSearchManager.5(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AddressData jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData = null;
  volatile Card jdField_a_of_type_ComTencentMobileqqDataCard = null;
  Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  LinkedList<ConditionSearchManager.IConfigListener> jdField_a_of_type_JavaUtilLinkedList = null;
  List<Object> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  public boolean a;
  byte[] jdField_a_of_type_ArrayOfByte;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString;
  LinkedList<ConditionSearchManager.ISearchListener> jdField_b_of_type_JavaUtilLinkedList = null;
  List<CondFitUser> jdField_b_of_type_JavaUtilList;
  volatile boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  private volatile long jdField_c_of_type_Long = 0L;
  private final String jdField_c_of_type_JavaLangString = "condation_search_sp";
  volatile boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int;
  private volatile long jdField_d_of_type_Long;
  volatile boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean = false;
  int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean = false;
  String[] jdField_f_of_type_ArrayOfJavaLangString;
  int jdField_g_of_type_Int = 0;
  private boolean jdField_g_of_type_Boolean = false;
  String[] jdField_g_of_type_ArrayOfJavaLangString;
  private volatile boolean jdField_h_of_type_Boolean = false;
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
    jdField_a_of_type_ArrayOfInt = new int[] { 2130846082, 2130844925, 2130844925, 2130844925, 2130845809, 2130845809, 2130846100, 2130846100, 2130845593, 2130845593, 2130845593, 2130846082, 2130846082, 2130845873, 2130846082 };
    jdField_b_of_type_ArrayOfInt = new int[] { -16777216, -11362561, -11362561, -11362561, -274353, -274353, -893603, -893603, -7745469, -7745469, -7745469, -8291118, -8291118, -16723548, -16777216 };
    jdField_c_of_type_ArrayOfInt = new int[] { 11, 12 };
  }
  
  public ConditionSearchManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("condation_search_sp", 0);
    paramQQAppInterface = this.jdField_a_of_type_AndroidContentSharedPreferences;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_first_run");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.jdField_f_of_type_Boolean = paramQQAppInterface.getBoolean(localStringBuilder.toString(), true);
    this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_config_version", 0L);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_last_checkup_time", 0L);
    this.jdField_g_of_type_Boolean = c();
  }
  
  public static final int a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int k = 0;
    if (!bool)
    {
      if (paramString.equals("0")) {
        return 0;
      }
      int n = paramString.length();
      int m = 0;
      while (k < n)
      {
        m += (paramString.charAt(k) << (n - 1 - k) * 8);
        k += 1;
      }
      return m;
    }
    return 0;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir());
    localStringBuilder.append("/pddata/prd/condition_search/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private List<CondFitUser> a(oidb_0x972.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "convert0x972ResultToCondFitUserList");
    }
    ArrayList localArrayList = new ArrayList();
    if (paramRspBody.item_groups.has()) {
      paramRspBody = paramRspBody.item_groups.get();
    } else {
      paramRspBody = null;
    }
    if (paramRspBody != null)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("convert0x972ResultToCondFitUserList group count = ");
        ((StringBuilder)localObject1).append(paramRspBody.size());
        QLog.d("ConditionSearch.Manager", 2, ((StringBuilder)localObject1).toString());
      }
      Iterator localIterator1 = paramRspBody.iterator();
      while (localIterator1.hasNext())
      {
        paramRspBody = (oidb_0x972.ResultItemGroup)localIterator1.next();
        if (paramRspBody.result_items.has()) {
          paramRspBody = paramRspBody.result_items.get();
        } else {
          paramRspBody = null;
        }
        if (paramRspBody != null)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("convert0x972ResultToCondFitUserList curGroupItemcount = ");
            ((StringBuilder)localObject1).append(paramRspBody.size());
            QLog.d("ConditionSearch.Manager", 2, ((StringBuilder)localObject1).toString());
          }
          Iterator localIterator2 = paramRspBody.iterator();
          while (localIterator2.hasNext())
          {
            Object localObject2 = (oidb_0x972.ResultItem)localIterator2.next();
            CondFitUser localCondFitUser = new CondFitUser();
            if (((oidb_0x972.ResultItem)localObject2).result_id.has()) {
              paramRspBody = ((oidb_0x972.ResultItem)localObject2).result_id.get().toStringUtf8();
            } else {
              paramRspBody = "0";
            }
            try
            {
              localCondFitUser.lUIN = Long.parseLong(paramRspBody);
            }
            catch (NumberFormatException paramRspBody)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ConditionSearch.Manager", 2, "convert0x972ResultToCondFitUserList NumberFormatException", paramRspBody);
              }
            }
            boolean bool = ((oidb_0x972.ResultItem)localObject2).name.has();
            localObject1 = "";
            if (bool) {
              paramRspBody = ((oidb_0x972.ResultItem)localObject2).name.get().toStringUtf8();
            } else {
              paramRspBody = "";
            }
            localCondFitUser.strNick = paramRspBody;
            paramRspBody = (oidb_0x972.RspBody)localObject1;
            if (((oidb_0x972.ResultItem)localObject2).extension.has()) {
              paramRspBody = ((oidb_0x972.ResultItem)localObject2).extension.get().toStringUtf8();
            }
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("convert0x972ResultToCondFitUserList extensionString = ");
              ((StringBuilder)localObject1).append(paramRspBody);
              QLog.d("ConditionSearch.Manager", 2, ((StringBuilder)localObject1).toString());
            }
            try
            {
              paramRspBody = new JSONObject(paramRspBody);
              int k = paramRspBody.optInt("gender");
              int m = paramRspBody.optInt("age");
              int n = paramRspBody.optInt("occupationID");
              localCondFitUser.cSex = ((byte)k);
              localCondFitUser.dwAge = m;
              localCondFitUser.iOccupationId = n;
              k = paramRspBody.optInt("countryID");
              m = paramRspBody.optInt("provinceID");
              n = paramRspBody.optInt("cityID");
              int i1 = paramRspBody.optInt("constellationID");
              localCondFitUser.dwCountry = k;
              localCondFitUser.dwProvince = m;
              localCondFitUser.dwCity = n;
              localCondFitUser.cConstellationId = ((byte)i1);
              localObject1 = a(localCondFitUser.dwCountry);
              localObject2 = a(localCondFitUser.dwProvince);
              String str = a(localCondFitUser.dwCity);
              localCondFitUser.locDesc = ((ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).b(new String[] { localObject1, localObject2, str, "0" });
              localCondFitUser.personalSignature = paramRspBody.optString("longnick");
            }
            catch (JSONException paramRspBody)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ConditionSearch.Manager", 2, "convert0x972ResultToCondFitUserList JSONException", paramRspBody);
              }
            }
            localArrayList.add(localCondFitUser);
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, String.format("notifyRemoteUpdateResult isSuccess=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new ConditionSearchManager.3(this, paramBoolean));
  }
  
  private boolean c()
  {
    if (this.jdField_f_of_type_Boolean)
    {
      localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_frist_run_add_contact");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_frist_run_in_5_2");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (localSharedPreferences.getBoolean(localStringBuilder.toString(), true))
    {
      localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_sex_index");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (localSharedPreferences.getInt(localStringBuilder.toString(), 0) == 0)
      {
        localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("key_age_index_v2_1");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (localSharedPreferences.getInt(localStringBuilder.toString(), 0) == 0)
        {
          localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("key_age_index_v2_2");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          if (localSharedPreferences.getInt(localStringBuilder.toString(), 0) == 0)
          {
            localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("key_job_index");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            if (localSharedPreferences.getInt(localStringBuilder.toString(), 0) == 0)
            {
              localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("key_xingzuo_index");
              localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
              if (localSharedPreferences.getInt(localStringBuilder.toString(), 0) == 0)
              {
                localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("key_loc_country_code");
                localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                if (localSharedPreferences.getString(localStringBuilder.toString(), "0").equals("0"))
                {
                  localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append("key_home_country_code");
                  localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                  if (localSharedPreferences.getString(localStringBuilder.toString(), "0").equals("0")) {
                    return true;
                  }
                }
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  private int e()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateLocal | isParsing = ");
      ((StringBuilder)localObject).append(this.jdField_h_of_type_Boolean);
      QLog.d("ConditionSearch.Manager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_h_of_type_Boolean) {
      return 0;
    }
    Object localObject = new File(a("admin_region_config"));
    if (!((File)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "updateLocal | file is not exist");
      }
      this.jdField_c_of_type_Long = 0L;
      return 3;
    }
    this.jdField_h_of_type_Boolean = true;
    ThreadManagerV2.excute(new ConditionSearchManager.2(this, (File)localObject), 128, null, true);
    return 0;
  }
  
  public int a()
  {
    int k;
    if (this.jdField_c_of_type_Long == 0L) {
      k = 1;
    } else if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData == null) {
      k = 2;
    } else {
      k = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkUpdate | result = ");
      localStringBuilder.append(k);
      QLog.d("ConditionSearch.Manager", 2, localStringBuilder.toString());
    }
    return k;
  }
  
  public int a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update, result=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", downloadNow=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ConditionSearch.Manager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 1)
    {
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update | isCheckingUpdate = ");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
        ((StringBuilder)localObject).append(" | interval is enough ");
        boolean bool;
        if (Math.abs(l - this.jdField_d_of_type_Long) >= 60000L) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(" | isNetAvaiable = ");
        ((StringBuilder)localObject).append(NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()));
        QLog.d("ConditionSearch.Manager", 2, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_b_of_type_Boolean)
      {
        if ((paramBoolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
        {
          localObject = ((IPreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPreDownloadController.class)).cancelPreDownload(this.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("update, find task=");
            localStringBuilder.append(localObject);
            QLog.d("ConditionSearch.Manager", 2, localStringBuilder.toString());
          }
          if ((localObject != null) && ((localObject instanceof ConditionSearchManager.DownloadTask)))
          {
            ((ConditionSearchManager.DownloadTask)localObject).realStart();
            return 0;
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("ConditionSearch.Manager", 2, "update mUrl might be null");
        }
        return 0;
      }
      if (Math.abs(l - this.jdField_d_of_type_Long) < 60000L) {
        return 1;
      }
      if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
        return 2;
      }
      if ((!this.jdField_a_of_type_Boolean) && (!paramBoolean)) {
        paramBoolean = false;
      } else {
        paramBoolean = true;
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      localObject = (ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
      ((ConfigHandler)localObject).a(null, new GetResourceReqInfo[] { ((ConfigHandler)localObject).e() });
      return 0;
    }
    if (paramInt == 2) {
      return e();
    }
    return 0;
  }
  
  public final long a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_last_checkup_time", this.jdField_d_of_type_Long).commit();
      this.jdField_b_of_type_Boolean = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConfigVersion | version = ");
      localStringBuilder.append(this.jdField_c_of_type_Long);
      QLog.d("ConditionSearch.Manager", 2, localStringBuilder.toString());
    }
    return this.jdField_c_of_type_Long;
  }
  
  public BaseAddress a(String paramString)
  {
    AddressData localAddressData = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData;
    if (localAddressData != null) {
      return (BaseAddress)localAddressData.a.get(paramString);
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    if (paramInt == 0)
    {
      localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("location_string");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return localSharedPreferences.getString(localStringBuilder.toString(), "不限");
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("home_string");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getString(localStringBuilder.toString(), "不限");
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    if (((paramInt1 <= paramInt2) || (paramInt2 == 0)) && (paramInt1 >= 0) && (paramInt2 >= 0))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        return jdField_b_of_type_ArrayOfJavaLangString[0];
      }
      if ((paramInt1 == 0) && (paramInt2 != 0))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(jdField_b_of_type_ArrayOfJavaLangString[paramInt2]);
        localStringBuilder.append("岁及以下");
        return localStringBuilder.toString();
      }
      if ((paramInt1 != 0) && (paramInt2 == 0))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(jdField_b_of_type_ArrayOfJavaLangString[paramInt1]);
        localStringBuilder.append("岁及以上");
        return localStringBuilder.toString();
      }
      if (paramInt1 == paramInt2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(jdField_b_of_type_ArrayOfJavaLangString[paramInt1]);
        localStringBuilder.append("岁");
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_b_of_type_ArrayOfJavaLangString[paramInt1]);
      localStringBuilder.append("-");
      localStringBuilder.append(jdField_b_of_type_ArrayOfJavaLangString[paramInt2]);
      localStringBuilder.append("岁");
      return localStringBuilder.toString();
    }
    return jdField_b_of_type_ArrayOfJavaLangString[0];
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
  
  public List<BaseAddress> a()
  {
    ArrayList localArrayList = new ArrayList();
    AddressData localAddressData = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData;
    if (localAddressData != null)
    {
      localArrayList = new ArrayList(localAddressData.a.size());
      localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a.values());
      Collections.sort(localArrayList, new ConditionSearchManager.1(this));
    }
    return localArrayList;
  }
  
  public void a()
  {
    ConditionSearchManager.IFirstLocationReqCancelListener localIFirstLocationReqCancelListener = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IFirstLocationReqCancelListener;
    if (localIFirstLocationReqCancelListener != null) {
      localIFirstLocationReqCancelListener.a();
    }
  }
  
  public void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_job_index");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), paramInt).commit();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_age_index_v2_1");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), paramInt1).commit();
    localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_age_index_v2_2");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), paramInt2).commit();
  }
  
  public void a(int paramInt, File paramFile, GetResourceRespInfo paramGetResourceRespInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onConfigFileDownloadSuccess, result=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", file=");
      ((StringBuilder)localObject).append(paramFile);
      ((StringBuilder)localObject).append(", resp=");
      ((StringBuilder)localObject).append(paramGetResourceRespInfo);
      QLog.d("ConditionSearch.Manager", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool3 = false;
    boolean bool2;
    if (paramInt == 0)
    {
      localObject = new File(a("admin_region_config"));
      if ((!paramFile.renameTo((File)localObject)) && (!paramFile.renameTo((File)localObject)) && (!paramFile.renameTo((File)localObject)))
      {
        bool1 = false;
      }
      else
      {
        this.jdField_c_of_type_Long = paramGetResourceRespInfo.uiNewVer;
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_config_version", this.jdField_c_of_type_Long).commit();
        bool1 = true;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        paramFile = new StringBuilder();
        paramFile.append("onCheckupConfig | rename result = ");
        paramFile.append(bool1);
        QLog.d("ConditionSearch.Manager", 2, paramFile.toString());
        bool2 = bool1;
      }
    }
    else
    {
      bool2 = true;
    }
    boolean bool1 = bool3;
    if (paramInt == 0)
    {
      bool1 = bool3;
      if (bool2) {
        bool1 = true;
      }
    }
    a(bool1);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("location_string");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localEditor.putString(localStringBuilder.toString(), paramString).commit();
      return;
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("home_string");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localEditor.putString(localStringBuilder.toString(), paramString).commit();
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new ConditionSearchManager.4(this));
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
          paramObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("key_first_run");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          paramObject.putBoolean(localStringBuilder.toString(), false).commit();
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCheckupConfig | resp = ");
      ((StringBuilder)localObject).append(paramGetResourceRespInfo);
      ((StringBuilder)localObject).append(" | iResult = ");
      int k;
      if (paramGetResourceRespInfo != null) {
        k = paramGetResourceRespInfo.iResult;
      } else {
        k = -1000;
      }
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(", needDownloadNow=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.d("ConditionSearch.Manager", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramGetResourceRespInfo != null) && (paramGetResourceRespInfo.iResult == 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onCheckupConfig | local version = ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
        ((StringBuilder)localObject).append(" | server version = ");
        ((StringBuilder)localObject).append(paramGetResourceRespInfo.uiNewVer);
        QLog.d("ConditionSearch.Manager", 2, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_c_of_type_Long != paramGetResourceRespInfo.uiNewVer)
      {
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
          paramGetResourceRespInfo.realStart();
          return;
        }
        boolean bool = ((IPreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPreDownloadController.class)).requestPreDownload(10023, "prd", (String)localObject, 0, (String)localObject, localFile.getAbsolutePath(), 2, 0, false, paramGetResourceRespInfo);
        if (QLog.isColorLevel())
        {
          paramGetResourceRespInfo = new StringBuilder();
          paramGetResourceRespInfo.append("innerDownload, IPreDownloadController.ret=");
          paramGetResourceRespInfo.append(bool);
          QLog.d("ConditionSearch.Manager", 2, paramGetResourceRespInfo.toString());
        }
        if (!bool) {
          a(false);
        }
      }
      return;
    }
    a(false);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt4, int paramInt5, int paramInt6)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seachFriend | restart = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" | keyword = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" | sexIndex = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" | ageIndex1 = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" | ageIndex2 = ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" | jobIndex = ");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append(" | xingzuoIndex = ");
      localStringBuilder.append(paramInt5);
      localStringBuilder.append(" | searchFromMore = ");
      localStringBuilder.append(paramInt6);
      int k;
      if ((paramArrayOfString1 != null) && (paramArrayOfString1.length > 0))
      {
        localStringBuilder.append(" | locCodes = ");
        k = 0;
        while (k < paramArrayOfString1.length)
        {
          localStringBuilder.append(paramArrayOfString1[k]);
          localStringBuilder.append("、");
          k += 1;
        }
      }
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0))
      {
        localStringBuilder.append(" | homeCodes = ");
        k = 0;
        while (k < paramArrayOfString2.length)
        {
          localStringBuilder.append(paramArrayOfString2[k]);
          localStringBuilder.append("、");
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
      this.jdField_a_of_type_ArrayOfByte = null;
    }
    else
    {
      if (!this.jdField_e_of_type_Boolean) {
        break label454;
      }
    }
    this.jdField_g_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).condtionalSearchFriendBy0x972(this.jdField_a_of_type_Long, this.jdField_f_of_type_Int + 1, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_f_of_type_ArrayOfJavaLangString, this.jdField_g_of_type_ArrayOfJavaLangString, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, paramInt6);
    return;
    label454:
    paramString = new RuntimeException("No more elements");
    for (;;)
    {
      throw paramString;
    }
  }
  
  void a(boolean paramBoolean1, List<CondFitUser> paramList, boolean paramBoolean2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_b_of_type_JavaUtilLinkedList != null)
    {
      Object localObject = new LinkedList();
      ((LinkedList)localObject).addAll(this.jdField_b_of_type_JavaUtilLinkedList);
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ConditionSearchManager.ISearchListener)((Iterator)localObject).next()).a(paramBoolean1, paramList, paramBoolean2, paramInt);
      }
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    if (paramArrayOfString.length == 4)
    {
      this.jdField_h_of_type_ArrayOfJavaLangString = ((String[])paramArrayOfString.clone());
      paramArrayOfString = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_cur_loc_country_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramArrayOfString = paramArrayOfString.putString(localStringBuilder.toString(), this.jdField_h_of_type_ArrayOfJavaLangString[0]);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_cur_loc_prov_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramArrayOfString = paramArrayOfString.putString(localStringBuilder.toString(), this.jdField_h_of_type_ArrayOfJavaLangString[1]);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_cur_loc_city_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramArrayOfString = paramArrayOfString.putString(localStringBuilder.toString(), this.jdField_h_of_type_ArrayOfJavaLangString[2]);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_cur_loc_dist_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramArrayOfString.putString(localStringBuilder.toString(), this.jdField_h_of_type_ArrayOfJavaLangString[3]).commit();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Error size ");
    localStringBuilder.append(paramArrayOfString.length);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public boolean a()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public int[] a()
  {
    Object localObject;
    int k;
    int m;
    StringBuilder localStringBuilder;
    if (this.jdField_g_of_type_Boolean)
    {
      localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (localObject != null)
      {
        k = ((Card)localObject).age;
        m = 18;
        if ((k > 5) && (((Card)localObject).age < 60))
        {
          if ((((Card)localObject).age >= 6) && (((Card)localObject).age <= 11))
          {
            k = 11;
            m = 6;
          }
          else if ((((Card)localObject).age >= 12) && (((Card)localObject).age <= 17))
          {
            k = 17;
            m = 12;
          }
          else if ((((Card)localObject).age >= 18) && (((Card)localObject).age <= 21))
          {
            k = 21;
          }
          else if (((Card)localObject).shGender != 0)
          {
            m = ((Card)localObject).age;
            k = ((Card)localObject).age + 10;
            m -= 5;
          }
          else
          {
            k = ((Card)localObject).age + 5;
          }
        }
        else
        {
          k = 0;
          m = 0;
        }
        localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("key_age_index_v2_1");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), m).commit();
        localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("key_age_index_v2_2");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), k).commit();
      }
      else
      {
        k = 0;
        m = 0;
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_age_index_v2_1");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      m = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_age_index_v2_2");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      k = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
    }
    return new int[] { m, k };
  }
  
  public String[] a()
  {
    if (this.jdField_h_of_type_ArrayOfJavaLangString == null)
    {
      this.jdField_h_of_type_ArrayOfJavaLangString = new String[4];
      String[] arrayOfString = this.jdField_h_of_type_ArrayOfJavaLangString;
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_cur_loc_country_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      arrayOfString[0] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
      arrayOfString = this.jdField_h_of_type_ArrayOfJavaLangString;
      localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_cur_loc_prov_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      arrayOfString[1] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
      arrayOfString = this.jdField_h_of_type_ArrayOfJavaLangString;
      localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_cur_loc_city_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      arrayOfString[2] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
      arrayOfString = this.jdField_h_of_type_ArrayOfJavaLangString;
      localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_cur_loc_dist_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      arrayOfString[3] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
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
        return arrayOfString;
      }
      arrayOfString[0] = paramString;
    }
    return arrayOfString;
  }
  
  public String[] a(String[] paramArrayOfString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfString != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfString.length == 4)
      {
        boolean bool = false;
        if ("-1".equals(paramArrayOfString[0])) {
          return null;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData;
        int k = 1;
        if (localObject1 == null)
        {
          if (QLog.isColorLevel())
          {
            paramArrayOfString = new StringBuilder();
            paramArrayOfString.append("praseCodeArrayToAddress addressData == null is ");
            if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData == null) {
              bool = true;
            }
            paramArrayOfString.append(bool);
            QLog.d("ConditionSearch.Manager", 2, paramArrayOfString.toString());
          }
          return null;
        }
        String[] arrayOfString = new String[4];
        arrayOfString[0] = "";
        arrayOfString[1] = "";
        arrayOfString[2] = "";
        arrayOfString[3] = "";
        if ("-1".equals(paramArrayOfString[0])) {
          return arrayOfString;
        }
        localObject2 = (BaseAddress)this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a.get(paramArrayOfString[0]);
        if (localObject2 == null) {
          return arrayOfString;
        }
        arrayOfString[0] = ((BaseAddress)localObject2).name;
        for (;;)
        {
          localObject1 = arrayOfString;
          if (k >= 4) {
            break;
          }
          localObject1 = localObject2;
          if (!"0".equals(paramArrayOfString[k]))
          {
            localObject2 = (BaseAddress)((BaseAddress)localObject2).dataMap.get(paramArrayOfString[k]);
            localObject1 = arrayOfString;
            if (localObject2 == null) {
              break;
            }
            arrayOfString[k] = ((BaseAddress)localObject2).name;
            localObject1 = localObject2;
          }
          k += 1;
          localObject2 = localObject1;
        }
      }
    }
    return localObject1;
  }
  
  public int b()
  {
    boolean bool = this.jdField_g_of_type_Boolean;
    int k = 0;
    if (!bool)
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_job_index");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      k = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    }
    return k;
  }
  
  public String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = paramString;
    Object localObject;
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
          str = paramString;
          localObject = paramString;
          if (arrayOfString.length > 3)
          {
            str = paramString;
            localObject = new StringBuilder();
            str = paramString;
            ((StringBuilder)localObject).append(paramString);
            str = paramString;
            ((StringBuilder)localObject).append("-");
            str = paramString;
            ((StringBuilder)localObject).append(arrayOfString[3]);
            str = paramString;
            return ((StringBuilder)localObject).toString();
          }
        }
        else
        {
          str = paramString;
          localObject = paramString;
          if (arrayOfString.length > 1) {
            return arrayOfString[1];
          }
        }
      }
      else
      {
        str = paramString;
        localObject = paramString;
        if (arrayOfString.length > 2)
        {
          str = paramString;
          localObject = new StringBuilder();
          str = paramString;
          ((StringBuilder)localObject).append(arrayOfString[(arrayOfString.length - 2)]);
          str = paramString;
          ((StringBuilder)localObject).append("-");
          str = paramString;
          ((StringBuilder)localObject).append(arrayOfString[(arrayOfString.length - 1)]);
          str = paramString;
          paramString = ((StringBuilder)localObject).toString();
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      localObject = str;
      if (QLog.isColorLevel())
      {
        QLog.d("ConditionSearch.Manager", 2, "", paramString);
        localObject = str;
      }
    }
    return localObject;
  }
  
  public String b(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length == 4))
    {
      if ("-1".equals(paramArrayOfString[0])) {
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
      if (((AddressData)localObject1).a != null) {
        localObject1 = (BaseAddress)((AddressData)localObject1).a.get(paramArrayOfString[0]);
      } else {
        localObject1 = null;
      }
      if (localObject1 == null) {
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
          localStringBuilder.append("-");
          localStringBuilder.append(((BaseAddress)localObject2).name);
        }
        k += 1;
        localObject1 = localObject2;
      }
      return localStringBuilder.toString();
    }
    return "0";
  }
  
  public void b()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_g_of_type_Boolean = false;
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_frist_run_in_5_2");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localEditor.putBoolean(localStringBuilder.toString(), false).commit();
      localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_frist_run_add_contact");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localEditor.putBoolean(localStringBuilder.toString(), false).commit();
    }
  }
  
  public void b(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_xingzuo_index");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), paramInt).commit();
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
    if (paramArrayOfString.length == 4)
    {
      this.i = ((String[])paramArrayOfString.clone());
      paramArrayOfString = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_loc_country_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramArrayOfString = paramArrayOfString.putString(localStringBuilder.toString(), this.i[0]);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_loc_prov_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramArrayOfString = paramArrayOfString.putString(localStringBuilder.toString(), this.i[1]);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_loc_city_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramArrayOfString = paramArrayOfString.putString(localStringBuilder.toString(), this.i[2]);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_loc_dist_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramArrayOfString.putString(localStringBuilder.toString(), this.i[3]).commit();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Error size ");
    localStringBuilder.append(paramArrayOfString.length);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public boolean b()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_first_select_location");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    boolean bool = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), true);
    if (bool)
    {
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_first_select_location");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), false).commit();
    }
    return bool;
  }
  
  public String[] b()
  {
    if (this.i == null)
    {
      this.i = new String[4];
      String[] arrayOfString = this.i;
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_loc_country_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      arrayOfString[0] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
      arrayOfString = this.i;
      localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_loc_prov_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      arrayOfString[1] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
      arrayOfString = this.i;
      localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_loc_city_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      arrayOfString[2] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
      arrayOfString = this.i;
      localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_loc_dist_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      arrayOfString[3] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
    }
    return this.i;
  }
  
  public int c()
  {
    boolean bool = this.jdField_g_of_type_Boolean;
    int k = 0;
    if (!bool)
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_xingzuo_index");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      k = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
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
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_sex_index");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), paramInt).commit();
  }
  
  public void c(Object paramObject)
  {
    if ((paramObject instanceof ConditionSearchManager.IConfigListener))
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList == null) {
        this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
      }
      if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramObject)) {
        this.jdField_a_of_type_JavaUtilLinkedList.add((ConditionSearchManager.IConfigListener)paramObject);
      }
    }
    else if ((paramObject instanceof ConditionSearchManager.ISearchListener))
    {
      if (this.jdField_b_of_type_JavaUtilLinkedList == null) {
        this.jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
      }
      if (!this.jdField_b_of_type_JavaUtilLinkedList.contains(paramObject)) {
        this.jdField_b_of_type_JavaUtilLinkedList.add((ConditionSearchManager.ISearchListener)paramObject);
      }
    }
  }
  
  public void c(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    if (paramArrayOfString.length == 4)
    {
      this.j = ((String[])paramArrayOfString.clone());
      paramArrayOfString = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_home_country_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramArrayOfString = paramArrayOfString.putString(localStringBuilder.toString(), this.j[0]);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_home_prov_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramArrayOfString = paramArrayOfString.putString(localStringBuilder.toString(), this.j[1]);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_home_city_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramArrayOfString = paramArrayOfString.putString(localStringBuilder.toString(), this.j[2]);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_home_dist_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramArrayOfString.putString(localStringBuilder.toString(), this.j[3]).commit();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Error size ");
    localStringBuilder.append(paramArrayOfString.length);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public String[] c()
  {
    if (this.j == null)
    {
      this.j = new String[4];
      String[] arrayOfString = this.j;
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_home_country_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      arrayOfString[0] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
      arrayOfString = this.j;
      localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_home_prov_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      arrayOfString[1] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
      arrayOfString = this.j;
      localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_home_city_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      arrayOfString[2] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
      arrayOfString = this.j;
      localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_home_dist_code");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      arrayOfString[3] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
    }
    return this.j;
  }
  
  public int d()
  {
    boolean bool = this.jdField_g_of_type_Boolean;
    int k = 0;
    int m = 0;
    Object localObject;
    StringBuilder localStringBuilder;
    if (bool)
    {
      localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (localObject != null)
      {
        k = m;
        if (((Card)localObject).shGender == 0) {
          k = 2;
        }
        localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("key_sex_index");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), k).commit();
        return k;
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_sex_index");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      k = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
    }
    return k;
  }
  
  public void d(Object paramObject)
  {
    LinkedList localLinkedList;
    if ((paramObject instanceof ConditionSearchManager.IConfigListener))
    {
      localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
      if (localLinkedList != null) {
        localLinkedList.remove(paramObject);
      }
    }
    else if ((paramObject instanceof ConditionSearchManager.ISearchListener))
    {
      localLinkedList = this.jdField_b_of_type_JavaUtilLinkedList;
      if (localLinkedList != null) {
        localLinkedList.remove(paramObject);
      }
    }
  }
  
  public void onDestroy()
  {
    AddressData localAddressData = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData;
    if (localAddressData != null)
    {
      localAddressData.a();
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager
 * JD-Core Version:    0.7.0.1
 */