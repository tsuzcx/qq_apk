import KQQ.PluginInfo;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.gamecenter.appointment.GameCenterCheck;
import com.tencent.gamecenter.appointment.GameCenterReceiver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.data.GameNoticeCenter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.servlet.GameCenterManagerImp.1;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x11c.MsgBody;

public class bccg
  implements bmxp, Manager
{
  public static ConcurrentHashMap<String, Boolean> a;
  protected static byte[] a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private aurw jdField_a_of_type_Aurw;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private GameNoticeCenter jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Long, bcci> jdField_a_of_type_JavaUtilHashMap;
  private HashMap<String, Integer> b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public bccg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("gamecenter_prefername", 0);
    d();
    a();
    this.jdField_a_of_type_Aurw = new aurw(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter = new GameNoticeCenter(paramQQAppInterface);
    bmxq.a().a(this);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterManagerImp", 2, "loadGameCenterUnread.");
    }
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.b = new HashMap();
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    if (!TextUtils.isEmpty(str1))
    {
      Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("gc_pluginid" + str1, null);
      if (localObject != null)
      {
        localObject = ((String)localObject).split("&");
        if ((localObject != null) && (localObject.length > 0))
        {
          int i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              return;
            }
            String str2 = localObject[i];
            try
            {
              long l = Long.parseLong(str2);
              if (l > 0L)
              {
                bcci localbcci = new bcci(this);
                localbcci.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("gc_unread" + str1 + "_" + str2, 0L);
                localbcci.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("gc_newmsg" + str1 + "_" + str2, false);
                localbcci.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("gc_redpoint" + str1 + "_" + str2, false);
                localbcci.c = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("gc_tab" + str1 + "_" + str2, false);
                localbcci.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("gc_text" + str1 + "_" + str2, "");
                localbcci.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("gc_icon" + str1 + "_" + str2, "");
                localbcci.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("gc_type" + str1 + "_" + str2, -1);
                this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
                this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), localbcci);
              }
            }
            catch (Exception localException)
            {
              label501:
              break label501;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilHashMap != null))
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      String str1 = "";
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        long l = ((Long)localIterator.next()).longValue();
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(l)))
        {
          if (str1.length() > 0) {}
          for (str1 = str1 + "&" + l;; str1 = str1 + l)
          {
            bcci localbcci = (bcci)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l));
            localEditor.putLong("gc_unread" + str2 + "_" + l, localbcci.jdField_a_of_type_Long);
            localEditor.putBoolean("gc_newmsg" + str2 + "_" + l, localbcci.jdField_a_of_type_Boolean);
            localEditor.putBoolean("gc_redpoint" + str2 + "_" + l, localbcci.jdField_b_of_type_Boolean);
            localEditor.putBoolean("gc_tab" + str2 + "_" + l, localbcci.c);
            localEditor.putString("gc_text" + str2 + "_" + l, localbcci.jdField_a_of_type_JavaLangString);
            localEditor.putString("gc_icon" + str2 + "_" + l, localbcci.jdField_b_of_type_JavaLangString);
            localEditor.putInt("gc_type" + str2 + "_" + l, localbcci.jdField_a_of_type_Int);
            break;
          }
        }
      }
      localEditor.putString("gc_pluginid" + str2, str1);
      localEditor.commit();
    }
  }
  
  public int a(String paramString)
  {
    if (this.b.containsKey(paramString)) {
      return ((Integer)this.b.get(paramString)).intValue();
    }
    return -1;
  }
  
  public aurw a()
  {
    return this.jdField_a_of_type_Aurw;
  }
  
  public GameNoticeCenter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter;
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject2 = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + (String)localObject1);
    if ((!((File)localObject2).exists()) || (TextUtils.isEmpty((CharSequence)localObject1))) {
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterManagerImp", 2, "BusinessInfoCheckUpdateItem pb file does not exist,uin=" + (String)localObject1);
      }
    }
    for (;;)
    {
      return;
      Boolean localBoolean = (Boolean)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
      if ((localBoolean == null) || (!localBoolean.booleanValue()))
      {
        jdField_a_of_type_ArrayOfByte = null;
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        jdField_a_of_type_ArrayOfByte = bgmg.a((File)localObject2);
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, Boolean.valueOf(true));
      }
      localObject2 = jdField_a_of_type_ArrayOfByte;
      if (localObject2 == null)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GameCenterManagerImp", 2, "Can not translate BusinessInfoCheckUpdateItem pb file to byte");
        return;
      }
      this.b.clear();
      try
      {
        localObject1 = new BusinessInfoCheckUpdate.TimeRspBody();
        ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).mergeFrom((byte[])localObject2);
        int i = 0;
        while (i < ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.size())
        {
          localObject2 = (BusinessInfoCheckUpdate.AppInfo)((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.get(i);
          if (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() != 0) {
            this.b.put(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get(), Integer.valueOf(((BusinessInfoCheckUpdate.AppInfo)localObject2).type.get()));
          }
          i += 1;
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
  
  public void a(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong1)))
    {
      localObject = (bcci)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
      ((bcci)localObject).jdField_a_of_type_Boolean = paramBoolean;
      ((bcci)localObject).jdField_a_of_type_Long = paramLong2;
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong1), localObject);
      e();
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), bccj.class);
      ((NewIntent)localObject).setAction("gc_refresh_ui");
      if ((paramLong2 <= 0L) && (!paramBoolean)) {
        break label140;
      }
      if (paramLong2 <= 0L) {
        break label127;
      }
      ((NewIntent)localObject).putExtra("gc_notify_type", 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
      label127:
      ((NewIntent)localObject).putExtra("gc_notify_type", 1);
      continue;
      label140:
      ((NewIntent)localObject).putExtra("gc_notify_type", 3);
    }
  }
  
  public void a(String paramString)
  {
    if (this.b.containsKey(paramString)) {
      this.b.remove(paramString);
    }
  }
  
  public void a(String paramString, JSONArray paramJSONArray)
  {
    int j = 0;
    int i;
    if (paramJSONArray != null)
    {
      i = paramJSONArray.length();
      if (i >= 1) {
        break label23;
      }
    }
    label23:
    JSONArray localJSONArray;
    do
    {
      return;
      i = 0;
      break;
      localJSONArray = paramJSONArray;
      if ("APPOINTMENT_TGPA_LIST".equals(paramString))
      {
        localJSONArray = new JSONArray();
        while (j < i)
        {
          JSONObject localJSONObject = paramJSONArray.optJSONObject(j);
          if ((localJSONObject != null) && (localJSONObject.optInt("package_type") == 1)) {
            localJSONArray.put(localJSONObject);
          }
          j += 1;
        }
      }
    } while (localJSONArray.length() <= 0);
    aceh.a(paramString, localJSONArray.toString());
  }
  
  public void a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() < 1)) {
      return;
    }
    for (;;)
    {
      String[] arrayOfString;
      int i;
      String str1;
      try
      {
        arrayOfString = aceh.a("APPOINTMENT_DOWNLOAD_LIST").split("\\|");
        i = 0;
        if (i >= paramJSONArray.length()) {
          break;
        }
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject == null) {
          break label282;
        }
        str1 = localJSONObject.optString("appid");
        String str2 = localJSONObject.optString("packageName");
        boolean bool = localJSONObject.optBoolean("isRes");
        if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
          break label282;
        }
        aceh.a("APPID_PKGNAME_" + str1, str2);
        if (bool)
        {
          aceh.c(str1, "APPOINTMENT_RES_LIST");
          aceh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "426", "202238", str1, "42601", "1", "116");
        }
      }
      catch (Exception paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return;
      }
      int j = 0;
      if (j < arrayOfString.length) {
        if ((TextUtils.isEmpty(arrayOfString[j])) || (TextUtils.isEmpty(str1)) || (!arrayOfString[j].equals(str1))) {}
      }
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          break label282;
        }
        aceh.c(str1, "APPOINTMENT_LIST");
        aceh.a(str1, paramJSONArray.get(i).toString(), "APPOINT_APPID_DETAIL_");
        aceh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "426", "202238", str1, "42601", "1", "116");
        break label282;
        j += 1;
        break;
      }
      label282:
      i += 1;
    }
  }
  
  public void a(MsgBody paramMsgBody)
  {
    long l1 = -1L;
    if (paramMsgBody == null) {}
    int i;
    do
    {
      return;
      i = paramMsgBody.uint32_cmd.get();
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterManagerImp", 2, "onReceivePushMsg cmd=" + i);
      }
      switch (i)
      {
      default: 
        return;
      case 1: 
        c();
        aceh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "426", "205581", "", "42601", "1", "116");
        return;
      case 2: 
        try
        {
          long l2 = new JSONObject(paramMsgBody.bytes_data.get().toStringUtf8()).optLong("version", -1L);
          l1 = l2;
        }
        catch (JSONException paramMsgBody)
        {
          for (;;)
          {
            paramMsgBody.printStackTrace();
          }
        }
        bmxq.a().a(true, l1);
        return;
      }
      try
      {
        i = new JSONObject(paramMsgBody.bytes_data.get().toStringUtf8()).optInt("subCmd");
        paramMsgBody = new bcch(this, i);
        if (i == 1)
        {
          acex.a().a(paramMsgBody);
          return;
        }
      }
      catch (JSONException paramMsgBody)
      {
        QLog.e("GameCenterManagerImp", 1, "onReceivePushMsg screenshot push e=" + paramMsgBody.toString());
        return;
      }
      if (i == 2)
      {
        acex.a().b(paramMsgBody);
        return;
      }
    } while (i != 3);
    acex.a().c(paramMsgBody);
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong))) {
      return ((bcci)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public boolean a(List<PluginInfo> paramList)
  {
    boolean bool1;
    int i;
    int j;
    if ((paramList != null) && (paramList.size() > 0))
    {
      bool1 = false;
      i = -1;
      int m = 0;
      if (m < paramList.size())
      {
        PluginInfo localPluginInfo = (PluginInfo)paramList.get(m);
        boolean bool3 = bool1;
        int k = i;
        if (localPluginInfo != null) {
          if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(localPluginInfo.Id)) != null) {}
        }
        bcci localbcci;
        boolean bool2;
        label296:
        do
        {
          m += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("GameCenterManagerImp", 2, "setNewUnread.i=" + m + ",plugin:" + localPluginInfo.toString());
          }
          localbcci = (bcci)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(localPluginInfo.Id));
          if (QLog.isColorLevel()) {
            QLog.d("GameCenterManagerImp", 2, "setNewUnread.i=" + m + ",before unreaddata:" + localbcci.toString());
          }
          if (localPluginInfo.Count > 0L)
          {
            j = i;
            if (localbcci.jdField_a_of_type_Long != localPluginInfo.Count)
            {
              bool2 = true;
              bool1 = bool2;
              j = i;
              if (localPluginInfo.Tab)
              {
                j = 0;
                bool1 = bool2;
              }
            }
            localbcci.jdField_a_of_type_Long = localPluginInfo.Count;
            localbcci.jdField_a_of_type_JavaLangString = localPluginInfo.Text;
            localbcci.jdField_a_of_type_Boolean = false;
            localbcci.jdField_b_of_type_Boolean = false;
            if (TextUtils.isEmpty(localbcci.jdField_a_of_type_JavaLangString))
            {
              localbcci.jdField_a_of_type_Int = 1;
              localbcci.c = localPluginInfo.Tab;
              bool2 = bool1;
            }
          }
          do
          {
            bool3 = bool2;
            k = j;
            if (QLog.isColorLevel())
            {
              QLog.d("GameCenterManagerImp", 2, "setNewUnread.i=" + m + ",unreaddata:" + localbcci.toString());
              k = j;
              bool3 = bool2;
            }
            bool1 = bool3;
            i = k;
            break;
            localbcci.jdField_a_of_type_Int = 4;
            break label296;
            if (localPluginInfo.Flag)
            {
              if (localbcci.jdField_a_of_type_Long > 0L) {
                break;
              }
              j = i;
              if (!localbcci.jdField_a_of_type_Boolean)
              {
                bool2 = true;
                bool1 = bool2;
                j = i;
                if (localPluginInfo.Tab) {
                  if (i != -1)
                  {
                    bool1 = bool2;
                    j = i;
                    if (i != 4) {}
                  }
                  else
                  {
                    j = 1;
                    bool1 = bool2;
                  }
                }
              }
              localbcci.jdField_a_of_type_Boolean = localPluginInfo.Flag;
              localbcci.jdField_b_of_type_Boolean = false;
              localbcci.jdField_a_of_type_Long = 0L;
              localbcci.jdField_a_of_type_JavaLangString = localPluginInfo.Text;
              if (TextUtils.isEmpty(localbcci.jdField_a_of_type_JavaLangString)) {}
              for (localbcci.jdField_a_of_type_Int = 3;; localbcci.jdField_a_of_type_Int = 6)
              {
                localbcci.c = localPluginInfo.Tab;
                bool2 = bool1;
                break;
              }
            }
            bool2 = bool1;
            j = i;
          } while (!localPluginInfo.RedPoint);
        } while ((localbcci.jdField_a_of_type_Long > 0L) || ((localPluginInfo.Id == 769L) && (localbcci.jdField_a_of_type_Boolean)));
        j = i;
        if (!localbcci.jdField_b_of_type_Boolean)
        {
          bool2 = true;
          bool1 = bool2;
          j = i;
          if (i == -1)
          {
            bool1 = bool2;
            j = i;
            if (localPluginInfo.Tab)
            {
              j = 4;
              bool1 = bool2;
            }
          }
        }
        localbcci.jdField_b_of_type_Boolean = localPluginInfo.RedPoint;
        localbcci.jdField_a_of_type_Boolean = false;
        localbcci.jdField_a_of_type_Long = 0L;
        localbcci.jdField_a_of_type_JavaLangString = localPluginInfo.Text;
        localbcci.jdField_b_of_type_JavaLangString = localPluginInfo.PicUrl;
        if (TextUtils.isEmpty(localbcci.jdField_a_of_type_JavaLangString)) {
          if (TextUtils.isEmpty(localbcci.jdField_b_of_type_JavaLangString)) {
            localbcci.jdField_a_of_type_Int = 2;
          }
        }
        for (;;)
        {
          localbcci.c = localPluginInfo.Tab;
          bool2 = bool1;
          break;
          localbcci.jdField_a_of_type_Int = 7;
          continue;
          localbcci.jdField_a_of_type_Int = 5;
        }
      }
      e();
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterManagerImp", 2, "setNewUnread.changeType=" + i + ",ischange:" + bool1);
      }
      if (i != -1)
      {
        paramList = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), bccj.class);
        paramList.setAction("gc_refresh_ui");
        paramList.putExtra("gc_notify_type", i);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramList);
        j = i;
      }
    }
    for (;;)
    {
      if (j != -1)
      {
        return true;
        j = i;
        if (bool1)
        {
          paramList = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), bccj.class);
          paramList.setAction("gc_refresh_ui");
          paramList.putExtra("gc_notify_type", 3);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramList);
          j = i;
        }
      }
      else
      {
        return false;
        j = -1;
      }
    }
  }
  
  public void b()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0);
    int i = localSharedPreferences.getInt("businessinfo_check_update_interval_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 600);
    int j = localSharedPreferences.getInt("businessinfo_last_check_update_timestamp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    int k = (int)(System.currentTimeMillis() / 1000L);
    if ((k - j > i) || (k < j)) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(true, 2);
    }
  }
  
  public void c()
  {
    ThreadManager.excute(new GameCenterManagerImp.1(this), 192, null, false);
  }
  
  public HashSet<String> getFilterCmds()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("13625");
    localHashSet.add("12942");
    localHashSet.add("13629");
    return localHashSet;
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterManagerImp", 2, "onCmdRsp cmd=" + paramString + ",ret=" + paramLong + ",dataJson=" + paramJSONObject);
    }
    if ("13625".equals(paramString)) {
      if ((paramLong != 0L) || (paramJSONObject == null)) {}
    }
    do
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("GameCenterManagerImp", 2, "onGetAutoDownloadApk data=" + paramJSONObject.toString());
        }
        aceh.a("APPOINTMENT_LASTGET_TIME", NetConnInfoCenter.getServerTime());
        aceh.a("APPOINTMENT_LOAD_GAP", paramJSONObject.optLong("load_gap"));
        aceh.a(paramJSONObject.optLong("res_valid") * 1000L);
        a(paramJSONObject.optJSONArray("pre_download_list"));
        a("APPOINTMENT_UPDATE_LIST", paramJSONObject.optJSONArray("pre_update_list"));
        a("APPOINTMENT_TGPA_LIST", paramJSONObject.optJSONArray("tgpa_apk_list"));
        if (GameCenterCheck.a())
        {
          aced.a();
          GameCenterCheck.b();
          GameCenterCheck.a();
        }
        return;
      }
      catch (Throwable paramIntent)
      {
        QLog.e("GameCenterManagerImp", 1, "onGetAutoDownloadApk error=" + paramIntent.toString());
        return;
      }
      if (!"12942".equals(paramString)) {
        break;
      }
    } while ((paramLong != 0L) || (paramJSONObject == null));
    for (;;)
    {
      for (;;)
      {
        try
        {
          paramIntent = paramJSONObject.optJSONArray("pkg_list");
          if (paramIntent == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("GameCenterManagerImp", 2, "onGetAutoDownloadRes data=" + paramIntent.toString());
          }
          paramString = new JSONArray();
          if (i < paramIntent.length())
          {
            paramJSONObject = paramIntent.getJSONObject(i);
            if (aceh.a(0, paramJSONObject.optString("appid"), paramJSONObject.optString("resName"))) {
              break label547;
            }
            aceh.a(paramJSONObject.toString(), false, 1);
            paramString.put(paramJSONObject.optString("resName"));
            break label547;
          }
          if (paramString.length() <= 0) {
            break;
          }
          bmxq.a().a(null, paramString);
          return;
        }
        catch (Throwable paramIntent)
        {
          QLog.e("GameCenterManagerImp", 1, "onGetAutoDownloadRes error =" + paramIntent.toString());
          return;
        }
        if ((!"13629".equals(paramString)) || (paramLong != 0L) || (paramJSONObject == null)) {
          break;
        }
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("GameCenterManagerImp", 2, "onGetUnpackApk data=" + paramJSONObject.toString());
          }
          a("UNPACK_APK_LIST", paramJSONObject.optJSONArray("tgpa_unpack_list"));
          if (!GameCenterCheck.a()) {
            break;
          }
          aced.a();
          GameCenterCheck.a();
          return;
        }
        catch (Throwable paramIntent)
        {
          QLog.e("GameCenterManagerImp", 1, "onGetUnpackApk error=" + paramIntent.toString());
          return;
        }
      }
      label547:
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    bmxq.a().b(this);
    GameCenterReceiver.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bccg
 * JD-Core Version:    0.7.0.1
 */