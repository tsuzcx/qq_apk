import KQQ.PluginInfo;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.gamecenter.appointment.GameCenterCheck;
import com.tencent.gamecenter.appointment.GameCenterReceiver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.data.GameNoticeCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
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

public class aywz
  implements bket, Manager
{
  public static ConcurrentHashMap<String, Boolean> a;
  protected static byte[] a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private ashh jdField_a_of_type_Ashh;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private GameNoticeCenter jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Long, ayxb> jdField_a_of_type_JavaUtilHashMap;
  private HashMap<String, Integer> b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public aywz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("gamecenter_prefername", 0);
    d();
    a();
    this.jdField_a_of_type_Ashh = new ashh(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter = new GameNoticeCenter(paramQQAppInterface);
    bkeu.a().a(this);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.GameCenterManagerImp", 2, "loadGameCenterUnread.");
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
                ayxb localayxb = new ayxb(this);
                localayxb.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("gc_unread" + str1 + "_" + str2, 0L);
                localayxb.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("gc_newmsg" + str1 + "_" + str2, false);
                localayxb.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("gc_redpoint" + str1 + "_" + str2, false);
                localayxb.c = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("gc_tab" + str1 + "_" + str2, false);
                localayxb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("gc_text" + str1 + "_" + str2, "");
                localayxb.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("gc_icon" + str1 + "_" + str2, "");
                localayxb.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("gc_type" + str1 + "_" + str2, -1);
                this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
                this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), localayxb);
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
            ayxb localayxb = (ayxb)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l));
            localEditor.putLong("gc_unread" + str2 + "_" + l, localayxb.jdField_a_of_type_Long);
            localEditor.putBoolean("gc_newmsg" + str2 + "_" + l, localayxb.jdField_a_of_type_Boolean);
            localEditor.putBoolean("gc_redpoint" + str2 + "_" + l, localayxb.jdField_b_of_type_Boolean);
            localEditor.putBoolean("gc_tab" + str2 + "_" + l, localayxb.c);
            localEditor.putString("gc_text" + str2 + "_" + l, localayxb.jdField_a_of_type_JavaLangString);
            localEditor.putString("gc_icon" + str2 + "_" + l, localayxb.jdField_b_of_type_JavaLangString);
            localEditor.putInt("gc_type" + str2 + "_" + l, localayxb.jdField_a_of_type_Int);
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
  
  public ashh a()
  {
    return this.jdField_a_of_type_Ashh;
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
        QLog.d("Q.lebatab.GameCenterManagerImp", 2, "BusinessInfoCheckUpdateItem pb file does not exist,uin=" + (String)localObject1);
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
        jdField_a_of_type_ArrayOfByte = bdcs.a((File)localObject2);
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, Boolean.valueOf(true));
      }
      localObject2 = jdField_a_of_type_ArrayOfByte;
      if (localObject2 == null)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.lebatab.GameCenterManagerImp", 2, "Can not translate BusinessInfoCheckUpdateItem pb file to byte");
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
      localObject = (ayxb)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
      ((ayxb)localObject).jdField_a_of_type_Boolean = paramBoolean;
      ((ayxb)localObject).jdField_a_of_type_Long = paramLong2;
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong1), localObject);
      e();
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ayxc.class);
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
  
  public void a(JSONArray paramJSONArray)
  {
    for (;;)
    {
      int i;
      try
      {
        arrayOfString = aact.a("APPOINTMENT_HAS_DOWNLOAD_LIST").split("\\|");
        i = 0;
        if (i >= paramJSONArray.length()) {
          break label267;
        }
        JSONObject localJSONObject = new JSONObject((String)paramJSONArray.get(i));
        str1 = localJSONObject.optString("appid");
        String str2 = localJSONObject.optString("packageName");
        aact.a("APPID_PKGNAME_" + str1, str2);
        if (!localJSONObject.optBoolean("isRes")) {
          break label287;
        }
        aact.c(str1, "APPOINTMENT_RES_LIST");
        aact.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "426", "202238", str1, "42601", "1", "116");
      }
      catch (Exception paramJSONArray)
      {
        String[] arrayOfString;
        String str1;
        paramJSONArray.printStackTrace();
      }
      if (j < arrayOfString.length)
      {
        str1 = new JSONObject((String)paramJSONArray.get(i)).optString("appid");
        if ((!TextUtils.isEmpty(arrayOfString[j])) && (!TextUtils.isEmpty(str1)) && (arrayOfString[j].equals(str1)))
        {
          j = 1;
          if ((j == 0) && (!TextUtils.isEmpty(str1)))
          {
            aact.c(str1, "APPOINTMENT_LIST");
            aact.a(str1, paramJSONArray.get(i).toString(), "APPOINT_APPID_DETAIL_");
            aact.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "426", "202238", str1, "42601", "1", "116");
          }
        }
        else
        {
          label267:
          j += 1;
        }
      }
      else
      {
        j = 0;
        continue;
      }
      i += 1;
      continue;
      label287:
      int j = 0;
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
        QLog.d("Q.lebatab.GameCenterManagerImp", 2, "onReceivePushMsg cmd=" + i);
      }
      switch (i)
      {
      default: 
        return;
      case 1: 
        c();
        aact.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "426", "205581", "", "42601", "1", "116");
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
        bkeu.a().a(true, l1);
        return;
      }
      try
      {
        i = new JSONObject(paramMsgBody.bytes_data.get().toStringUtf8()).optInt("subCmd");
        paramMsgBody = new ayxa(this, i);
        if (i == 1)
        {
          aadi.a().a(paramMsgBody);
          return;
        }
      }
      catch (JSONException paramMsgBody)
      {
        QLog.e("Q.lebatab.GameCenterManagerImp", 1, "onReceivePushMsg screenshot push e=" + paramMsgBody.toString());
        return;
      }
      if (i == 2)
      {
        aadi.a().b(paramMsgBody);
        return;
      }
    } while (i != 3);
    aadi.a().c(paramMsgBody);
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong))) {
      return ((ayxb)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_Boolean;
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
        ayxb localayxb;
        boolean bool2;
        label296:
        do
        {
          m += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.GameCenterManagerImp", 2, "setNewUnread.i=" + m + ",plugin:" + localPluginInfo.toString());
          }
          localayxb = (ayxb)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(localPluginInfo.Id));
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.GameCenterManagerImp", 2, "setNewUnread.i=" + m + ",before unreaddata:" + localayxb.toString());
          }
          if (localPluginInfo.Count > 0L)
          {
            j = i;
            if (localayxb.jdField_a_of_type_Long != localPluginInfo.Count)
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
            localayxb.jdField_a_of_type_Long = localPluginInfo.Count;
            localayxb.jdField_a_of_type_JavaLangString = localPluginInfo.Text;
            localayxb.jdField_a_of_type_Boolean = false;
            localayxb.jdField_b_of_type_Boolean = false;
            if (TextUtils.isEmpty(localayxb.jdField_a_of_type_JavaLangString))
            {
              localayxb.jdField_a_of_type_Int = 1;
              localayxb.c = localPluginInfo.Tab;
              bool2 = bool1;
            }
          }
          do
          {
            bool3 = bool2;
            k = j;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.lebatab.GameCenterManagerImp", 2, "setNewUnread.i=" + m + ",unreaddata:" + localayxb.toString());
              k = j;
              bool3 = bool2;
            }
            bool1 = bool3;
            i = k;
            break;
            localayxb.jdField_a_of_type_Int = 4;
            break label296;
            if (localPluginInfo.Flag)
            {
              if (localayxb.jdField_a_of_type_Long > 0L) {
                break;
              }
              j = i;
              if (!localayxb.jdField_a_of_type_Boolean)
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
              localayxb.jdField_a_of_type_Boolean = localPluginInfo.Flag;
              localayxb.jdField_b_of_type_Boolean = false;
              localayxb.jdField_a_of_type_Long = 0L;
              localayxb.jdField_a_of_type_JavaLangString = localPluginInfo.Text;
              if (TextUtils.isEmpty(localayxb.jdField_a_of_type_JavaLangString)) {}
              for (localayxb.jdField_a_of_type_Int = 3;; localayxb.jdField_a_of_type_Int = 6)
              {
                localayxb.c = localPluginInfo.Tab;
                bool2 = bool1;
                break;
              }
            }
            bool2 = bool1;
            j = i;
          } while (!localPluginInfo.RedPoint);
        } while ((localayxb.jdField_a_of_type_Long > 0L) || ((localPluginInfo.Id == 769L) && (localayxb.jdField_a_of_type_Boolean)));
        j = i;
        if (!localayxb.jdField_b_of_type_Boolean)
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
        localayxb.jdField_b_of_type_Boolean = localPluginInfo.RedPoint;
        localayxb.jdField_a_of_type_Boolean = false;
        localayxb.jdField_a_of_type_Long = 0L;
        localayxb.jdField_a_of_type_JavaLangString = localPluginInfo.Text;
        localayxb.jdField_b_of_type_JavaLangString = localPluginInfo.PicUrl;
        if (TextUtils.isEmpty(localayxb.jdField_a_of_type_JavaLangString)) {
          if (TextUtils.isEmpty(localayxb.jdField_b_of_type_JavaLangString)) {
            localayxb.jdField_a_of_type_Int = 2;
          }
        }
        for (;;)
        {
          localayxb.c = localPluginInfo.Tab;
          bool2 = bool1;
          break;
          localayxb.jdField_a_of_type_Int = 7;
          continue;
          localayxb.jdField_a_of_type_Int = 5;
        }
      }
      e();
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.GameCenterManagerImp", 2, "setNewUnread.changeType=" + i + ",ischange:" + bool1);
      }
      if (i != -1)
      {
        paramList = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ayxc.class);
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
          paramList = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ayxc.class);
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
    bkeu.a().a();
    aact.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "426", "202238", "", "42601", "1", "116");
  }
  
  public HashSet<String> getFilterCmds()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("12933");
    localHashSet.add("12942");
    return null;
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.GameCenterManagerImp", 2, "onCmdRsp cmd=" + paramString + ",ret=" + paramLong + ",dataJson=" + paramJSONObject);
    }
    if ("12933".equals(paramString)) {
      if ((paramLong != 0L) || (paramJSONObject == null)) {}
    }
    while ((!"12942".equals(paramString)) || (paramLong != 0L) || (paramJSONObject == null)) {
      try
      {
        paramLong = paramJSONObject.optLong("load_gap");
        aact.a("APPOINTMENT_LOAD_GAP", paramLong);
        aact.a(paramJSONObject.optLong("res_valid") * 1000L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.GameCenterManagerImp", 2, "onGetAutoDownloadApk data=" + paramJSONObject.toString() + " loadgap=" + paramLong);
        }
        a(paramJSONObject.optJSONArray("pre_download_list"));
        if ((!TextUtils.isEmpty(aact.a("APPOINTMENT_LIST"))) || (!TextUtils.isEmpty(aact.a("APPOINTMENT_CHECKLIST"))) || (!TextUtils.isEmpty(aact.a("DELAY_LIST"))) || (!TextUtils.isEmpty(aact.a("APPOINTMENT_RES_LIST")))) {
          aacp.a();
        }
        GameCenterCheck.b();
        GameCenterCheck.c();
        return;
      }
      catch (Throwable paramIntent)
      {
        QLog.e("Q.lebatab.GameCenterManagerImp", 1, "onGetAutoDownloadApk error=" + paramIntent.toString());
        return;
      }
    }
    for (;;)
    {
      try
      {
        paramIntent = paramJSONObject.optJSONArray("pkg_list");
        if (paramIntent == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.GameCenterManagerImp", 2, "onGetAutoDownloadRes data=" + paramIntent.toString());
        }
        paramString = new JSONArray();
        if (i < paramIntent.length())
        {
          paramJSONObject = paramIntent.getJSONObject(i);
          if (!aact.e(paramJSONObject.optString("appid"), paramJSONObject.optString("resName")))
          {
            aact.a(paramJSONObject.toString(), false, 1);
            paramString.put(paramJSONObject.optString("resName"));
          }
        }
        else
        {
          if (paramString.length() <= 0) {
            break;
          }
          bkeu.a().a(null, paramString);
          return;
        }
      }
      catch (Throwable paramIntent)
      {
        QLog.e("Q.lebatab.GameCenterManagerImp", 1, "onGetAutoDownloadRes error =" + paramIntent.toString());
        return;
      }
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    bkeu.a().b(this);
    GameCenterReceiver.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywz
 * JD-Core Version:    0.7.0.1
 */