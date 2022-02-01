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
  public static final String[] i = { "不限", "男", "女" };
  public static final String[] j = { "不限", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99" };
  public static final String[] k = { "不限", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };
  public static final String[] l = { "不限", "计算机/互联网/通信", "生产/工艺/制造", "医疗/护理/制药", "金融/银行/投资/保险", "商业/服务业/个体经营", "文化/广告/传媒", "娱乐/艺术/表演", "律师/法务", "教育/培训", "公务员/行政/事业单位", "模特", "空姐", "学生", "其他职业" };
  public static final String[] m = { "", "IT", "制造", "医疗", "金融", "商业", "文化", "艺术", "法律", "教育", "行政", "模特", "空姐", "学生", "" };
  public static final int[] n = { 2130847552, 2130846359, 2130846359, 2130846359, 2130847279, 2130847279, 2130847570, 2130847570, 2130847057, 2130847057, 2130847057, 2130847552, 2130847552, 2130847343, 2130847552 };
  public static final int[] o = { -16777216, -11362561, -11362561, -11362561, -274353, -274353, -893603, -893603, -7745469, -7745469, -7745469, -8291118, -8291118, -16723548, -16777216 };
  public static final int[] p = { 11, 12 };
  long A = 0L;
  byte[] B;
  int C = 0;
  List<CondFitUser> D;
  boolean E = false;
  LinkedList<ConditionSearchManager.IConfigListener> F = null;
  LinkedList<ConditionSearchManager.ISearchListener> G = null;
  private QQAppInterface H;
  private boolean I = false;
  private boolean J = false;
  private AddressData K = null;
  private final String L = "condation_search_sp";
  private SharedPreferences M;
  private volatile long N = 0L;
  private volatile long O;
  private ConditionSearchManager.IFirstLocationReqCancelListener P;
  private volatile boolean Q = false;
  private String[] R;
  private String[] S;
  private String[] T;
  private FriendListObserver U = new ConditionSearchManager.5(this);
  public String a = null;
  public boolean b = false;
  volatile boolean c = false;
  volatile boolean d = false;
  List<Object> e = Collections.synchronizedList(new LinkedList());
  volatile boolean f = false;
  volatile Card g = null;
  Object h = new Object();
  long q = 0L;
  String r;
  int s;
  int t;
  int u;
  int v;
  int w;
  String[] x;
  String[] y;
  int z = 0;
  
  public ConditionSearchManager(QQAppInterface paramQQAppInterface)
  {
    this.H = paramQQAppInterface;
    this.M = this.H.getApp().getSharedPreferences("condation_search_sp", 0);
    paramQQAppInterface = this.M;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_first_run");
    localStringBuilder.append(this.H.getCurrentAccountUin());
    this.I = paramQQAppInterface.getBoolean(localStringBuilder.toString(), true);
    this.N = this.M.getLong("key_config_version", 0L);
    this.O = this.M.getLong("key_last_checkup_time", 0L);
    this.J = n();
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
              int i1 = paramRspBody.optInt("gender");
              int i2 = paramRspBody.optInt("age");
              int i3 = paramRspBody.optInt("occupationID");
              localCondFitUser.cSex = ((byte)i1);
              localCondFitUser.dwAge = i2;
              localCondFitUser.iOccupationId = i3;
              i1 = paramRspBody.optInt("countryID");
              i2 = paramRspBody.optInt("provinceID");
              i3 = paramRspBody.optInt("cityID");
              int i4 = paramRspBody.optInt("constellationID");
              localCondFitUser.dwCountry = i1;
              localCondFitUser.dwProvince = i2;
              localCondFitUser.dwCity = i3;
              localCondFitUser.cConstellationId = ((byte)i4);
              localObject1 = a(localCondFitUser.dwCountry);
              localObject2 = a(localCondFitUser.dwProvince);
              String str = a(localCondFitUser.dwCity);
              localCondFitUser.locDesc = ((ConditionSearchManager)this.H.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).e(new String[] { localObject1, localObject2, str, "0" });
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
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir());
    localStringBuilder.append("/pddata/prd/condition_search/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, String.format("notifyRemoteUpdateResult isSuccess=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    this.H.runOnUiThread(new ConditionSearchManager.3(this, paramBoolean));
  }
  
  public static final int f(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i1 = 0;
    if (!bool)
    {
      if (paramString.equals("0")) {
        return 0;
      }
      int i3 = paramString.length();
      int i2 = 0;
      while (i1 < i3)
      {
        i2 += (paramString.charAt(i1) << (i3 - 1 - i1) * 8);
        i1 += 1;
      }
      return i2;
    }
    return 0;
  }
  
  private boolean n()
  {
    if (this.I)
    {
      localSharedPreferences = this.M;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_frist_run_add_contact");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      return localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
    }
    SharedPreferences localSharedPreferences = this.M;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_frist_run_in_5_2");
    localStringBuilder.append(this.H.getCurrentAccountUin());
    if (localSharedPreferences.getBoolean(localStringBuilder.toString(), true))
    {
      localSharedPreferences = this.M;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_sex_index");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      if (localSharedPreferences.getInt(localStringBuilder.toString(), 0) == 0)
      {
        localSharedPreferences = this.M;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("key_age_index_v2_1");
        localStringBuilder.append(this.H.getCurrentAccountUin());
        if (localSharedPreferences.getInt(localStringBuilder.toString(), 0) == 0)
        {
          localSharedPreferences = this.M;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("key_age_index_v2_2");
          localStringBuilder.append(this.H.getCurrentAccountUin());
          if (localSharedPreferences.getInt(localStringBuilder.toString(), 0) == 0)
          {
            localSharedPreferences = this.M;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("key_job_index");
            localStringBuilder.append(this.H.getCurrentAccountUin());
            if (localSharedPreferences.getInt(localStringBuilder.toString(), 0) == 0)
            {
              localSharedPreferences = this.M;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("key_xingzuo_index");
              localStringBuilder.append(this.H.getCurrentAccountUin());
              if (localSharedPreferences.getInt(localStringBuilder.toString(), 0) == 0)
              {
                localSharedPreferences = this.M;
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("key_loc_country_code");
                localStringBuilder.append(this.H.getCurrentAccountUin());
                if (localSharedPreferences.getString(localStringBuilder.toString(), "0").equals("0"))
                {
                  localSharedPreferences = this.M;
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append("key_home_country_code");
                  localStringBuilder.append(this.H.getCurrentAccountUin());
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
  
  private int o()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateLocal | isParsing = ");
      ((StringBuilder)localObject).append(this.Q);
      QLog.d("ConditionSearch.Manager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.Q) {
      return 0;
    }
    Object localObject = new File(b("admin_region_config"));
    if (!((File)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "updateLocal | file is not exist");
      }
      this.N = 0L;
      return 3;
    }
    this.Q = true;
    ThreadManagerV2.excute(new ConditionSearchManager.2(this, (File)localObject), 128, null, true);
    return 0;
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
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update | isCheckingUpdate = ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" | interval is enough ");
        boolean bool;
        if (Math.abs(l1 - this.O) >= 60000L) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(" | isNetAvaiable = ");
        ((StringBuilder)localObject).append(NetworkUtil.isNetSupport(this.H.getApp()));
        QLog.d("ConditionSearch.Manager", 2, ((StringBuilder)localObject).toString());
      }
      if (this.c)
      {
        if ((paramBoolean) && (!TextUtils.isEmpty(this.a)))
        {
          localObject = ((IPreDownloadController)this.H.getRuntimeService(IPreDownloadController.class)).cancelPreDownload(this.a);
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
      if (Math.abs(l1 - this.O) < 60000L) {
        return 1;
      }
      if (!NetworkUtil.isNetSupport(this.H.getApp())) {
        return 2;
      }
      if ((!this.b) && (!paramBoolean)) {
        paramBoolean = false;
      } else {
        paramBoolean = true;
      }
      this.b = paramBoolean;
      localObject = (ConfigHandler)this.H.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
      ((ConfigHandler)localObject).a(null, new GetResourceReqInfo[] { ((ConfigHandler)localObject).k() });
      return 0;
    }
    if (paramInt == 2) {
      return o();
    }
    return 0;
  }
  
  public final long a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.O = System.currentTimeMillis();
      this.M.edit().putLong("key_last_checkup_time", this.O).commit();
      this.c = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConfigVersion | version = ");
      localStringBuilder.append(this.N);
      QLog.d("ConditionSearch.Manager", 2, localStringBuilder.toString());
    }
    return this.N;
  }
  
  public BaseAddress a(String paramString)
  {
    AddressData localAddressData = this.K;
    if (localAddressData != null) {
      return (BaseAddress)localAddressData.b.get(paramString);
    }
    return null;
  }
  
  public void a()
  {
    ConditionSearchManager.IFirstLocationReqCancelListener localIFirstLocationReqCancelListener = this.P;
    if (localIFirstLocationReqCancelListener != null) {
      localIFirstLocationReqCancelListener.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = this.M.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_age_index_v2_1");
    localStringBuilder.append(this.H.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), paramInt1).commit();
    localEditor = this.M.edit();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_age_index_v2_2");
    localStringBuilder.append(this.H.getCurrentAccountUin());
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
      localObject = new File(b("admin_region_config"));
      if ((!paramFile.renameTo((File)localObject)) && (!paramFile.renameTo((File)localObject)) && (!paramFile.renameTo((File)localObject)))
      {
        bool1 = false;
      }
      else
      {
        this.N = paramGetResourceRespInfo.uiNewVer;
        this.M.edit().putLong("key_config_version", this.N).commit();
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
    b(bool1);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      localEditor = this.M.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("location_string");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      localEditor.putString(localStringBuilder.toString(), paramString).commit();
      return;
    }
    SharedPreferences.Editor localEditor = this.M.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("home_string");
    localStringBuilder.append(this.H.getCurrentAccountUin());
    localEditor.putString(localStringBuilder.toString(), paramString).commit();
  }
  
  public void a(ConditionSearchManager.IFirstLocationReqCancelListener paramIFirstLocationReqCancelListener)
  {
    this.P = paramIFirstLocationReqCancelListener;
  }
  
  public void a(Card paramCard)
  {
    this.f = true;
    this.g = paramCard;
    a(this.h);
    this.H.runOnUiThread(new ConditionSearchManager.4(this));
  }
  
  public void a(Object paramObject)
  {
    try
    {
      if (!this.e.contains(paramObject))
      {
        this.e.add(paramObject);
        this.d = true;
        a(d());
        if ((paramObject instanceof ConditionSearchFriendActivity))
        {
          this.I = false;
          paramObject = this.M.edit();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("key_first_run");
          localStringBuilder.append(this.H.getCurrentAccountUin());
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
      int i1;
      if (paramGetResourceRespInfo != null) {
        i1 = paramGetResourceRespInfo.iResult;
      } else {
        i1 = -1000;
      }
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(", needDownloadNow=");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("ConditionSearch.Manager", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramGetResourceRespInfo != null) && (paramGetResourceRespInfo.iResult == 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onCheckupConfig | local version = ");
        ((StringBuilder)localObject).append(this.N);
        ((StringBuilder)localObject).append(" | server version = ");
        ((StringBuilder)localObject).append(paramGetResourceRespInfo.uiNewVer);
        QLog.d("ConditionSearch.Manager", 2, ((StringBuilder)localObject).toString());
      }
      if (this.N != paramGetResourceRespInfo.uiNewVer)
      {
        localObject = paramGetResourceRespInfo.strResURL_big;
        this.a = ((String)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ConditionSearch.Manager", 2, "onCheckupConfig | url is null");
          }
          b(false);
          return;
        }
        File localFile = new File(b("temp_admin_regin_config"));
        paramGetResourceRespInfo = new ConditionSearchManager.DownloadTask(this.H, (String)localObject, paramGetResourceRespInfo, localFile);
        if (this.b)
        {
          this.b = false;
          paramGetResourceRespInfo.realStart();
          return;
        }
        boolean bool = ((IPreDownloadController)this.H.getRuntimeService(IPreDownloadController.class)).requestPreDownload(10023, "prd", (String)localObject, 0, (String)localObject, localFile.getAbsolutePath(), 2, 0, false, paramGetResourceRespInfo);
        if (QLog.isColorLevel())
        {
          paramGetResourceRespInfo = new StringBuilder();
          paramGetResourceRespInfo.append("innerDownload, IPreDownloadController.ret=");
          paramGetResourceRespInfo.append(bool);
          QLog.d("ConditionSearch.Manager", 2, paramGetResourceRespInfo.toString());
        }
        if (!bool) {
          b(false);
        }
      }
      return;
    }
    b(false);
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
      int i1;
      if ((paramArrayOfString1 != null) && (paramArrayOfString1.length > 0))
      {
        localStringBuilder.append(" | locCodes = ");
        i1 = 0;
        while (i1 < paramArrayOfString1.length)
        {
          localStringBuilder.append(paramArrayOfString1[i1]);
          localStringBuilder.append("、");
          i1 += 1;
        }
      }
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0))
      {
        localStringBuilder.append(" | homeCodes = ");
        i1 = 0;
        while (i1 < paramArrayOfString2.length)
        {
          localStringBuilder.append(paramArrayOfString2[i1]);
          localStringBuilder.append("、");
          i1 += 1;
        }
      }
      QLog.d("ConditionSearch.Manager", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      this.q += 1L;
      this.r = paramString;
      this.s = paramInt1;
      this.t = paramInt2;
      this.u = paramInt3;
      this.x = paramArrayOfString1;
      this.y = paramArrayOfString2;
      this.v = paramInt4;
      this.w = paramInt5;
      this.z = -1;
      this.A = 0L;
      this.B = null;
    }
    else
    {
      if (!this.E) {
        break label454;
      }
    }
    this.C = 0;
    this.D = null;
    this.H.addObserver(this.U);
    ((FriendListHandler)this.H.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).condtionalSearchFriendBy0x972(this.q, this.z + 1, this.B, this.r, this.s, this.t, this.u, this.x, this.y, this.v, this.w, paramInt6);
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
    this.H.removeObserver(this.U);
    if (this.G != null)
    {
      Object localObject = new LinkedList();
      ((LinkedList)localObject).addAll(this.G);
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
      this.R = ((String[])paramArrayOfString.clone());
      paramArrayOfString = this.M.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_cur_loc_country_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      paramArrayOfString = paramArrayOfString.putString(localStringBuilder.toString(), this.R[0]);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_cur_loc_prov_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      paramArrayOfString = paramArrayOfString.putString(localStringBuilder.toString(), this.R[1]);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_cur_loc_city_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      paramArrayOfString = paramArrayOfString.putString(localStringBuilder.toString(), this.R[2]);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_cur_loc_dist_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      paramArrayOfString.putString(localStringBuilder.toString(), this.R[3]).commit();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Error size ");
    localStringBuilder.append(paramArrayOfString.length);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public String b(int paramInt1, int paramInt2)
  {
    if (((paramInt1 <= paramInt2) || (paramInt2 == 0)) && (paramInt1 >= 0) && (paramInt2 >= 0))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        return j[0];
      }
      if ((paramInt1 == 0) && (paramInt2 != 0))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(j[paramInt2]);
        localStringBuilder.append("岁及以下");
        return localStringBuilder.toString();
      }
      if ((paramInt1 != 0) && (paramInt2 == 0))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(j[paramInt1]);
        localStringBuilder.append("岁及以上");
        return localStringBuilder.toString();
      }
      if (paramInt1 == paramInt2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(j[paramInt1]);
        localStringBuilder.append("岁");
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(j[paramInt1]);
      localStringBuilder.append("-");
      localStringBuilder.append(j[paramInt2]);
      localStringBuilder.append("岁");
      return localStringBuilder.toString();
    }
    return j[0];
  }
  
  public void b(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.M.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_job_index");
    localStringBuilder.append(this.H.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), paramInt).commit();
  }
  
  public void b(Object paramObject)
  {
    try
    {
      this.e.remove(paramObject);
      if (this.e.size() == 0)
      {
        this.d = false;
        this.K = null;
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
      this.S = ((String[])paramArrayOfString.clone());
      paramArrayOfString = this.M.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_loc_country_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      paramArrayOfString = paramArrayOfString.putString(localStringBuilder.toString(), this.S[0]);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_loc_prov_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      paramArrayOfString = paramArrayOfString.putString(localStringBuilder.toString(), this.S[1]);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_loc_city_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      paramArrayOfString = paramArrayOfString.putString(localStringBuilder.toString(), this.S[2]);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_loc_dist_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      paramArrayOfString.putString(localStringBuilder.toString(), this.S[3]).commit();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Error size ");
    localStringBuilder.append(paramArrayOfString.length);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public boolean b()
  {
    return this.J;
  }
  
  public String c(String paramString)
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
  
  public List<BaseAddress> c()
  {
    ArrayList localArrayList = new ArrayList();
    AddressData localAddressData = this.K;
    if (localAddressData != null)
    {
      localArrayList = new ArrayList(localAddressData.b.size());
      localArrayList.addAll(this.K.b.values());
      Collections.sort(localArrayList, new ConditionSearchManager.1(this));
    }
    return localArrayList;
  }
  
  public void c(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.M.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_xingzuo_index");
    localStringBuilder.append(this.H.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), paramInt).commit();
  }
  
  public void c(Object paramObject)
  {
    if ((paramObject instanceof ConditionSearchManager.IConfigListener))
    {
      if (this.F == null) {
        this.F = new LinkedList();
      }
      if (!this.F.contains(paramObject)) {
        this.F.add((ConditionSearchManager.IConfigListener)paramObject);
      }
    }
    else if ((paramObject instanceof ConditionSearchManager.ISearchListener))
    {
      if (this.G == null) {
        this.G = new LinkedList();
      }
      if (!this.G.contains(paramObject)) {
        this.G.add((ConditionSearchManager.ISearchListener)paramObject);
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
      this.T = ((String[])paramArrayOfString.clone());
      paramArrayOfString = this.M.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_home_country_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      paramArrayOfString = paramArrayOfString.putString(localStringBuilder.toString(), this.T[0]);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_home_prov_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      paramArrayOfString = paramArrayOfString.putString(localStringBuilder.toString(), this.T[1]);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_home_city_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      paramArrayOfString = paramArrayOfString.putString(localStringBuilder.toString(), this.T[2]);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_home_dist_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      paramArrayOfString.putString(localStringBuilder.toString(), this.T[3]).commit();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Error size ");
    localStringBuilder.append(paramArrayOfString.length);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int d()
  {
    int i1;
    if (this.N == 0L) {
      i1 = 1;
    } else if (this.K == null) {
      i1 = 2;
    } else {
      i1 = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkUpdate | result = ");
      localStringBuilder.append(i1);
      QLog.d("ConditionSearch.Manager", 2, localStringBuilder.toString());
    }
    return i1;
  }
  
  public String d(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("中国"))
    {
      String[] arrayOfString = StringUtil.split(paramString, '-');
      str = paramString;
      if (arrayOfString.length >= 2)
      {
        paramString = new StringBuilder();
        int i1 = 1;
        while (i1 < arrayOfString.length)
        {
          paramString.append(arrayOfString[i1]);
          if (i1 != arrayOfString.length - 1) {
            paramString.append("-");
          }
          i1 += 1;
        }
        str = paramString.toString();
      }
    }
    return str;
  }
  
  public String d(String[] paramArrayOfString)
  {
    String str2 = e(paramArrayOfString);
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
  
  public void d(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.M.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_sex_index");
    localStringBuilder.append(this.H.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), paramInt).commit();
  }
  
  public void d(Object paramObject)
  {
    LinkedList localLinkedList;
    if ((paramObject instanceof ConditionSearchManager.IConfigListener))
    {
      localLinkedList = this.F;
      if (localLinkedList != null) {
        localLinkedList.remove(paramObject);
      }
    }
    else if ((paramObject instanceof ConditionSearchManager.ISearchListener))
    {
      localLinkedList = this.G;
      if (localLinkedList != null) {
        localLinkedList.remove(paramObject);
      }
    }
  }
  
  public String e(int paramInt)
  {
    if (paramInt == 0)
    {
      localSharedPreferences = this.M;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("location_string");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      return localSharedPreferences.getString(localStringBuilder.toString(), "不限");
    }
    SharedPreferences localSharedPreferences = this.M;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("home_string");
    localStringBuilder.append(this.H.getCurrentAccountUin());
    return localSharedPreferences.getString(localStringBuilder.toString(), "不限");
  }
  
  public String e(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length == 4))
    {
      if ("-1".equals(paramArrayOfString[0])) {
        return "0";
      }
      Object localObject1 = this.K;
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
      if (((AddressData)localObject1).b != null) {
        localObject1 = (BaseAddress)((AddressData)localObject1).b.get(paramArrayOfString[0]);
      } else {
        localObject1 = null;
      }
      if (localObject1 == null) {
        return "不限";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((BaseAddress)localObject1).name);
      int i1 = 1;
      while (i1 < 4)
      {
        Object localObject2 = localObject1;
        if (!"0".equals(paramArrayOfString[i1]))
        {
          localObject2 = (BaseAddress)((BaseAddress)localObject1).dataMap.get(paramArrayOfString[i1]);
          if (localObject2 == null) {
            break;
          }
          localStringBuilder.append("-");
          localStringBuilder.append(((BaseAddress)localObject2).name);
        }
        i1 += 1;
        localObject1 = localObject2;
      }
      return localStringBuilder.toString();
    }
    return "0";
  }
  
  public void e()
  {
    if (this.J)
    {
      this.J = false;
      SharedPreferences.Editor localEditor = this.M.edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_frist_run_in_5_2");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      localEditor.putBoolean(localStringBuilder.toString(), false).commit();
      localEditor = this.M.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_frist_run_add_contact");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      localEditor.putBoolean(localStringBuilder.toString(), false).commit();
    }
  }
  
  public String[] e(String paramString)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "不限";
    arrayOfString[1] = "不限";
    if ((!TextUtils.isEmpty(paramString)) && (!"不限".equals(paramString)))
    {
      int i1 = paramString.indexOf("-");
      if (i1 != -1)
      {
        arrayOfString[0] = paramString.substring(0, i1);
        arrayOfString[1] = paramString.substring(i1 + 1);
        return arrayOfString;
      }
      arrayOfString[0] = paramString;
    }
    return arrayOfString;
  }
  
  public int f()
  {
    boolean bool = this.J;
    int i1 = 0;
    if (!bool)
    {
      SharedPreferences localSharedPreferences = this.M;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_job_index");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      i1 = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    }
    return i1;
  }
  
  public String[] f(String[] paramArrayOfString)
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
        localObject1 = this.K;
        int i1 = 1;
        if (localObject1 == null)
        {
          if (QLog.isColorLevel())
          {
            paramArrayOfString = new StringBuilder();
            paramArrayOfString.append("praseCodeArrayToAddress addressData == null is ");
            if (this.K == null) {
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
        localObject2 = (BaseAddress)this.K.b.get(paramArrayOfString[0]);
        if (localObject2 == null) {
          return arrayOfString;
        }
        arrayOfString[0] = ((BaseAddress)localObject2).name;
        for (;;)
        {
          localObject1 = arrayOfString;
          if (i1 >= 4) {
            break;
          }
          localObject1 = localObject2;
          if (!"0".equals(paramArrayOfString[i1]))
          {
            localObject2 = (BaseAddress)((BaseAddress)localObject2).dataMap.get(paramArrayOfString[i1]);
            localObject1 = arrayOfString;
            if (localObject2 == null) {
              break;
            }
            arrayOfString[i1] = ((BaseAddress)localObject2).name;
            localObject1 = localObject2;
          }
          i1 += 1;
          localObject2 = localObject1;
        }
      }
    }
    return localObject1;
  }
  
  public int g()
  {
    boolean bool = this.J;
    int i1 = 0;
    if (!bool)
    {
      SharedPreferences localSharedPreferences = this.M;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_xingzuo_index");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      i1 = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    }
    return i1;
  }
  
  public int h()
  {
    boolean bool = this.J;
    int i1 = 0;
    int i2 = 0;
    Object localObject;
    StringBuilder localStringBuilder;
    if (bool)
    {
      localObject = ((FriendsManager)this.H.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.H.getCurrentAccountUin());
      if (localObject != null)
      {
        i1 = i2;
        if (((Card)localObject).shGender == 0) {
          i1 = 2;
        }
        localObject = this.M.edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("key_sex_index");
        localStringBuilder.append(this.H.getCurrentAccountUin());
        ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), i1).commit();
        return i1;
      }
    }
    else
    {
      localObject = this.M;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_sex_index");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      i1 = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
    }
    return i1;
  }
  
  public int[] i()
  {
    Object localObject;
    int i1;
    int i2;
    StringBuilder localStringBuilder;
    if (this.J)
    {
      localObject = ((FriendsManager)this.H.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.H.getCurrentAccountUin());
      if (localObject != null)
      {
        i1 = ((Card)localObject).age;
        i2 = 18;
        if ((i1 > 5) && (((Card)localObject).age < 60))
        {
          if ((((Card)localObject).age >= 6) && (((Card)localObject).age <= 11))
          {
            i1 = 11;
            i2 = 6;
          }
          else if ((((Card)localObject).age >= 12) && (((Card)localObject).age <= 17))
          {
            i1 = 17;
            i2 = 12;
          }
          else if ((((Card)localObject).age >= 18) && (((Card)localObject).age <= 21))
          {
            i1 = 21;
          }
          else if (((Card)localObject).shGender != 0)
          {
            i2 = ((Card)localObject).age;
            i1 = ((Card)localObject).age + 10;
            i2 -= 5;
          }
          else
          {
            i1 = ((Card)localObject).age + 5;
          }
        }
        else
        {
          i1 = 0;
          i2 = 0;
        }
        localObject = this.M.edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("key_age_index_v2_1");
        localStringBuilder.append(this.H.getCurrentAccountUin());
        ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), i2).commit();
        localObject = this.M.edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("key_age_index_v2_2");
        localStringBuilder.append(this.H.getCurrentAccountUin());
        ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), i1).commit();
      }
      else
      {
        i1 = 0;
        i2 = 0;
      }
    }
    else
    {
      localObject = this.M;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_age_index_v2_1");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      i2 = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
      localObject = this.M;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_age_index_v2_2");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      i1 = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
    }
    return new int[] { i2, i1 };
  }
  
  public String[] j()
  {
    if (this.R == null)
    {
      this.R = new String[4];
      String[] arrayOfString = this.R;
      SharedPreferences localSharedPreferences = this.M;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_cur_loc_country_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      arrayOfString[0] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
      arrayOfString = this.R;
      localSharedPreferences = this.M;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_cur_loc_prov_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      arrayOfString[1] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
      arrayOfString = this.R;
      localSharedPreferences = this.M;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_cur_loc_city_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      arrayOfString[2] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
      arrayOfString = this.R;
      localSharedPreferences = this.M;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_cur_loc_dist_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      arrayOfString[3] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
    }
    return this.R;
  }
  
  public String[] k()
  {
    if (this.S == null)
    {
      this.S = new String[4];
      String[] arrayOfString = this.S;
      SharedPreferences localSharedPreferences = this.M;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_loc_country_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      arrayOfString[0] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
      arrayOfString = this.S;
      localSharedPreferences = this.M;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_loc_prov_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      arrayOfString[1] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
      arrayOfString = this.S;
      localSharedPreferences = this.M;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_loc_city_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      arrayOfString[2] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
      arrayOfString = this.S;
      localSharedPreferences = this.M;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_loc_dist_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      arrayOfString[3] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
    }
    return this.S;
  }
  
  public String[] l()
  {
    if (this.T == null)
    {
      this.T = new String[4];
      String[] arrayOfString = this.T;
      SharedPreferences localSharedPreferences = this.M;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_home_country_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      arrayOfString[0] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
      arrayOfString = this.T;
      localSharedPreferences = this.M;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_home_prov_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      arrayOfString[1] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
      arrayOfString = this.T;
      localSharedPreferences = this.M;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_home_city_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      arrayOfString[2] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
      arrayOfString = this.T;
      localSharedPreferences = this.M;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_home_dist_code");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      arrayOfString[3] = localSharedPreferences.getString(localStringBuilder.toString(), "0");
    }
    return this.T;
  }
  
  public boolean m()
  {
    Object localObject = this.M;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_first_select_location");
    localStringBuilder.append(this.H.getCurrentAccountUin());
    boolean bool = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), true);
    if (bool)
    {
      localObject = this.M.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_first_select_location");
      localStringBuilder.append(this.H.getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), false).commit();
    }
    return bool;
  }
  
  public void onDestroy()
  {
    AddressData localAddressData = this.K;
    if (localAddressData != null)
    {
      localAddressData.a();
      this.K = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager
 * JD-Core Version:    0.7.0.1
 */