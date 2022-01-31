package com.tencent.av.gaudio;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import askn;
import avfb;
import axcw;
import axqy;
import bbkb;
import bcql;
import com.tencent.av.app.QuaReportInfo;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import ldd;
import llw;
import lnf;
import lng;
import lnh;
import lni;
import lnj;
import lnk;
import lnl;
import lnm;
import lnn;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import msb;
import msm;
import muc;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x126.submsgtype0x126.MsgBody;

public class AVNotifyCenter
  extends Observable
{
  static boolean jdField_c_of_type_Boolean;
  private static String jdField_d_of_type_JavaLangString = "QAVPreSetting";
  private static String jdField_e_of_type_JavaLangString = "BeautyFeature";
  private static String jdField_f_of_type_JavaLangString = "BeautyValue";
  private static String jdField_g_of_type_JavaLangString = "BeautyConfig";
  private static String h = "BeautyResetGuide";
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  public QQAppInterface a;
  Runnable jdField_a_of_type_JavaLangRunnable = new AVNotifyCenter.2(this);
  String jdField_a_of_type_JavaLangString = null;
  ArrayList<lnk> jdField_a_of_type_JavaUtilArrayList;
  HashMap<Long, AVPhoneUserInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  Map jdField_a_of_type_JavaUtilMap = new HashMap();
  ConcurrentHashMap<Long, lni> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  final lng jdField_a_of_type_Lng = new lng(this, "default", 0L);
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = null;
  msb jdField_a_of_type_Msb;
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  Runnable jdField_b_of_type_JavaLangRunnable;
  String jdField_b_of_type_JavaLangString = null;
  HashMap<String, lng> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  Map jdField_b_of_type_JavaUtilMap = new HashMap();
  ConcurrentHashMap<Long, lni> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  lng jdField_b_of_type_Lng = this.jdField_a_of_type_Lng;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  long jdField_c_of_type_Long = 0L;
  String jdField_c_of_type_JavaLangString = null;
  HashMap<String, lnj> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  public Map<String, String> c;
  ConcurrentHashMap<Long, lnf> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  int jdField_d_of_type_Int = 0;
  public Map<String, Integer> d;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = 0;
  private Map<String, lnm> jdField_e_of_type_JavaUtilMap = new HashMap();
  boolean jdField_e_of_type_Boolean = false;
  private Map<String, lnn> jdField_f_of_type_JavaUtilMap = new HashMap();
  boolean jdField_f_of_type_Boolean = true;
  private Map<String, lnn> jdField_g_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_g_of_type_Boolean;
  
  public AVNotifyCenter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_d_of_type_JavaUtilMap = new ConcurrentHashMap();
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_c_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
      this.jdField_a_of_type_MqqOsMqqHandler = new lnh(Looper.getMainLooper(), this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new AVNotifyCenter.1(this));
      c();
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w("AVNotifyCenter", 1, "setSessionType[" + paramInt1 + "], relationId[" + paramString + "], relaitonType[" + paramInt2 + "], sessionType[" + paramInt3 + "], isDouble[" + paramBoolean + "]");
    }
    if (paramInt3 == 0) {
      c(paramString);
    }
    lng locallng;
    do
    {
      return;
      locallng = a(paramString, true);
    } while (locallng == null);
    locallng.jdField_a_of_type_Boolean = paramBoolean;
    locallng.jdField_a_of_type_Int = paramInt3;
    try
    {
      locallng.jdField_a_of_type_Long = Long.parseLong(paramString);
      locallng.jdField_c_of_type_Int = paramInt2;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("AVNotifyCenter", 1, "setSessionType, relationId[" + paramString + "]", localException);
      }
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(jdField_d_of_type_JavaLangString, 0);
    paramString = h + paramString;
    localSharedPreferences.edit().putInt(paramString, paramInt).apply();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(jdField_d_of_type_JavaLangString, 0);
    paramString1 = jdField_g_of_type_JavaLangString + paramString1;
    localSharedPreferences.edit().putString(paramString1, paramString2).apply();
  }
  
  public static int b(String paramString)
  {
    return BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(jdField_d_of_type_JavaLangString, 0).getInt(jdField_f_of_type_JavaLangString + paramString, -1);
  }
  
  public static int c(String paramString)
  {
    return BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(jdField_d_of_type_JavaLangString, 0).getInt(h + paramString, 0);
  }
  
  private void c()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    if (localSharedPreferences != null) {
      this.jdField_g_of_type_Boolean = localSharedPreferences.getBoolean("group_video_push_cfg_txt." + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + ".mutex", true);
    }
  }
  
  public static boolean c()
  {
    return jdField_c_of_type_Boolean;
  }
  
  public static String d(String paramString)
  {
    return BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(jdField_d_of_type_JavaLangString, 0).getString(jdField_g_of_type_JavaLangString + paramString, "");
  }
  
  public static boolean e(String paramString)
  {
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences(jdField_d_of_type_JavaLangString, 0);
    String str = jdField_e_of_type_JavaLangString;
    int j = paramString.getInt(str, -1);
    int i = j;
    if (j == -1) {
      if (!llw.e()) {
        break label67;
      }
    }
    label67:
    for (i = 1;; i = 0)
    {
      paramString.edit().putInt(str, i).commit();
      return i >= 1;
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Lng.jdField_c_of_type_Int;
  }
  
  public int a(long paramLong)
  {
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      return ((lnf)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_Int;
    }
    return 3999;
  }
  
  public int a(String paramString)
  {
    synchronized (this.jdField_c_of_type_JavaUtilHashMap)
    {
      if (this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        lnj locallnj = (lnj)this.jdField_c_of_type_JavaUtilHashMap.get(paramString);
        QLog.d("AVNotifyCenter", 1, "getOtherTermianlAvChatingType roomInfo.mSessionType=" + locallnj.jdField_a_of_type_Int + ", peerUin=" + paramString);
        int i = locallnj.jdField_a_of_type_Int;
        return i;
      }
      return 0;
    }
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public long a(int paramInt, long paramLong)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramInt == 2)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
        localObject1 = (lni)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      }
    }
    for (;;)
    {
      if (AudioHelper.e()) {
        QLog.w("AVNotifyCenter", 1, "getMultiRoomMemberNum, relationId[" + paramLong + "], " + localObject1);
      }
      if (localObject1 == null) {
        break;
      }
      return ((lni)localObject1).jdField_a_of_type_Long;
      localObject1 = localObject2;
      if (paramInt == 1)
      {
        localObject1 = localObject2;
        if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
          localObject1 = (lni)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
        }
      }
    }
    return 0L;
  }
  
  public long a(String paramString)
  {
    synchronized (this.jdField_c_of_type_JavaUtilHashMap)
    {
      if (this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        lnj locallnj = (lnj)this.jdField_c_of_type_JavaUtilHashMap.get(paramString);
        QLog.d("AVNotifyCenter", 1, "getOtherTerminalAvChattingRoomId roomInfo.mRoomId=" + locallnj.jdField_a_of_type_Long + ", peerUin=" + paramString);
        long l = locallnj.jdField_a_of_type_Long;
        return l;
      }
      return 0L;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
    {
      String str1 = ((AVPhoneUserInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong))).telInfo.mobile;
      String str2 = c(str1);
      if (str2 != null) {
        return str2;
      }
      return msm.a(str1, 4);
    }
    return null;
  }
  
  public String a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!TextUtils.isEmpty(paramString)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        lnk locallnk = (lnk)localIterator.next();
        if (paramString.equals(locallnk.jdField_a_of_type_JavaLangString)) {
          return locallnk.jdField_b_of_type_JavaLangString;
        }
      }
    }
    return "";
  }
  
  public Vector<lnl> a(int paramInt, long paramLong)
  {
    if ((paramInt == 2) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))))
    {
      Vector localVector = ((lni)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_JavaUtilVector;
      if ((localVector != null) && (localVector.size() > 0)) {
        return localVector;
      }
    }
    return null;
  }
  
  public Vector<lnl> a(long paramLong)
  {
    if ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))))
    {
      Object localObject = (lni)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = ((lni)localObject).jdField_a_of_type_JavaUtilVector;
        if (localObject != null) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public lng a(String paramString, boolean paramBoolean)
  {
    lng locallng2 = null;
    for (;;)
    {
      lng locallng1;
      try
      {
        if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          locallng1 = (lng)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
          return locallng1;
        }
        if (paramBoolean)
        {
          long l = AudioHelper.b();
          QLog.w("AVNotifyCenter", 1, "getChatSession, create sessionId[" + paramString + "], mAvChatDataMap[" + this.jdField_b_of_type_JavaUtilHashMap.size() + "], mActiveChatData[" + this.jdField_b_of_type_Lng + "], seq[" + l + "]");
          locallng2 = new lng(this, "normal", l);
          this.jdField_b_of_type_JavaUtilHashMap.put(paramString, locallng2);
          locallng1 = locallng2;
          if (this.jdField_b_of_type_JavaUtilHashMap.size() != 1) {
            continue;
          }
          this.jdField_b_of_type_Lng = locallng2;
          locallng1 = locallng2;
          continue;
        }
        locallng1 = locallng2;
      }
      finally {}
      if (AudioHelper.e())
      {
        QLog.w("AVNotifyCenter", 1, "getChatSession, not exist, sessionId[" + paramString + "]");
        locallng1 = locallng2;
      }
    }
  }
  
  public lnl a(int paramInt, long paramLong)
  {
    if ((paramInt == 2) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))))
    {
      Vector localVector = ((lni)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_JavaUtilVector;
      if ((localVector != null) && (localVector.size() > 0)) {
        return (lnl)localVector.get(0);
      }
    }
    return null;
  }
  
  public lnm a(long paramLong)
  {
    Object localObject2 = String.valueOf(paramLong) + String.valueOf(2);
    Object localObject1 = String.valueOf(paramLong) + String.valueOf(10);
    localObject2 = (lnm)this.jdField_e_of_type_JavaUtilMap.get(localObject2);
    lnm locallnm = (lnm)this.jdField_e_of_type_JavaUtilMap.get(localObject1);
    localObject1 = String.valueOf(paramLong) + String.valueOf(12);
    localObject1 = (lnm)this.jdField_e_of_type_JavaUtilMap.get(localObject1);
    int i = b(paramLong);
    if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1, paramLong))) {
      if (i != 12) {
        break label309;
      }
    }
    for (;;)
    {
      if (i == 2) {}
      for (;;)
      {
        if (i == 10)
        {
          localObject2 = locallnm;
          if (AudioHelper.e()) {
            QLog.w("AVNotifyCenter", 1, "getChoosedRoom, groupid[" + paramLong + "], avtype[" + i + "], VideoRoomInfo[" + localObject2 + "]");
          }
          return localObject2;
          if ((localObject1 == null) || (((lnm)localObject1).jdField_a_of_type_Int <= 0)) {
            break label296;
          }
        }
        for (;;)
        {
          if ((localObject2 != null) && (((lnm)localObject2).jdField_a_of_type_Int > 0)) {
            localObject1 = localObject2;
          }
          for (;;)
          {
            localObject2 = localObject1;
            if (locallnm != null)
            {
              localObject2 = locallnm;
              if (locallnm.jdField_a_of_type_Int > 0) {
                break;
              }
              localObject2 = localObject1;
            }
            break;
          }
          label296:
          localObject1 = null;
        }
        localObject2 = localObject1;
      }
      label309:
      localObject1 = null;
    }
  }
  
  public lnm a(long paramLong, int paramInt)
  {
    String str = String.valueOf(paramLong) + String.valueOf(paramInt);
    return (lnm)this.jdField_e_of_type_JavaUtilMap.get(str);
  }
  
  public lnn a(long paramLong, int paramInt)
  {
    String str = String.valueOf(paramLong);
    lnn locallnn = null;
    if (paramInt == 2) {
      locallnn = (lnn)this.jdField_f_of_type_JavaUtilMap.get(str);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AVNotifyCenter", 1, "getTipsRoomInfo, relationId[" + paramLong + "], relationType[" + paramInt + "], infos[" + locallnn + "]");
      }
      return locallnn;
      if (paramInt == 1) {
        locallnn = (lnn)this.jdField_g_of_type_JavaUtilMap.get(str);
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Msb != null)
    {
      this.jdField_a_of_type_Msb.b();
      this.jdField_a_of_type_Msb = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_JavaUtilArrayList != null))
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    a(paramInt1, paramInt2, String.valueOf(paramLong), paramInt3, false);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt3) });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString });
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long[] paramArrayOfLong, long paramLong2)
  {
    int j = 0;
    int i = 0;
    QLog.w("AVNotifyCenter", 1, "setMultiRoomMember[" + paramInt1 + "], relationType[" + paramInt2 + "], relationId[" + paramLong1 + "], memberList[" + Arrays.toString(paramArrayOfLong) + "], roomUserNum[" + paramLong2 + "]");
    if (paramInt2 == 2)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
      }
      if ((paramLong2 != 0L) && (paramArrayOfLong != null)) {}
    }
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = new Vector();
        paramInt2 = paramArrayOfLong.length;
        paramInt1 = i;
        while (paramInt1 < paramInt2)
        {
          localObject2 = new lnl(this);
          ((lnl)localObject2).jdField_a_of_type_Long = paramArrayOfLong[paramInt1];
          ((Vector)localObject1).add(localObject2);
          paramInt1 += 1;
        }
        paramArrayOfLong = new lni(this);
        paramArrayOfLong.jdField_a_of_type_Long = paramLong2;
        paramArrayOfLong.jdField_a_of_type_JavaUtilVector = ((Vector)localObject1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), paramArrayOfLong);
        return;
      } while (paramInt2 != 1);
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
      }
    } while (paramLong2 == 0L);
    Object localObject1 = new lni(this);
    ((lni)localObject1).jdField_a_of_type_Long = paramLong2;
    ((lni)localObject1).jdField_a_of_type_JavaUtilVector = null;
    if (paramArrayOfLong != null)
    {
      localObject2 = new Vector();
      paramInt1 = j;
      while (paramInt1 < paramArrayOfLong.length)
      {
        lnl locallnl = new lnl(this);
        locallnl.jdField_a_of_type_Long = paramArrayOfLong[paramInt1];
        ((Vector)localObject2).add(locallnl);
        paramInt1 += 1;
      }
      ((lni)localObject1).jdField_a_of_type_JavaUtilVector = ((Vector)localObject2);
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), localObject1);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    Object localObject3 = "onSelfEnterRoom, relationType[" + paramInt + "], relationId[" + paramLong;
    Object localObject1;
    label50:
    long l;
    Object localObject2;
    boolean bool2;
    if (paramInt == 2)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
      localObject2 = (lni)((ConcurrentHashMap)localObject1).get(Long.valueOf(paramLong));
      if (localObject2 == null) {
        break label363;
      }
      localObject1 = (String)localObject3 + "], containsKey[true";
      boolean bool3 = false;
      boolean bool1 = false;
      localObject3 = ((lni)localObject2).jdField_a_of_type_JavaUtilVector;
      bool2 = bool3;
      if (localObject3 == null) {
        break label202;
      }
      bool2 = bool3;
      if (((Vector)localObject3).size() <= 0) {
        break label202;
      }
      int i = ((Vector)localObject3).size();
      paramInt = 0;
      label150:
      bool2 = bool1;
      if (paramInt >= i) {
        break label202;
      }
      if (l != ((lnl)((Vector)localObject3).elementAt(paramInt)).jdField_a_of_type_Long) {
        break label493;
      }
      bool1 = true;
    }
    label202:
    label363:
    label493:
    for (;;)
    {
      paramInt += 1;
      break label150;
      if (paramInt != 1) {
        break;
      }
      localObject1 = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
      break label50;
      localObject1 = (String)localObject1 + "], exist[" + bool2 + "], last[" + localObject2;
      Object localObject4;
      if ((localObject3 != null) && (!bool2))
      {
        localObject4 = new lnl(this);
        ((lnl)localObject4).jdField_a_of_type_Long = l;
        ((Vector)localObject3).add(localObject4);
        ((lni)localObject2).jdField_a_of_type_Long += 1L;
        localObject1 = (String)localObject1 + "], cur[" + localObject2;
      }
      for (;;)
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        QLog.w("AVNotifyCenter", 1, (String)localObject1 + "], timeRoomCreateTime[" + this.jdField_b_of_type_Long + "]");
        return;
        localObject2 = (String)localObject3 + "], containsKey[false";
        localObject3 = new Vector();
        localObject4 = new lnl(this);
        ((lnl)localObject4).jdField_a_of_type_Long = l;
        ((Vector)localObject3).add(localObject4);
        localObject4 = new lni(this);
        ((lni)localObject4).jdField_a_of_type_Long = 1L;
        ((lni)localObject4).jdField_a_of_type_JavaUtilVector = ((Vector)localObject3);
        localObject2 = (String)localObject2 + "], cur[" + localObject4;
        ((ConcurrentHashMap)localObject1).put(Long.valueOf(paramLong), localObject4);
        localObject1 = localObject2;
      }
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    Object localObject2 = "onSelfLeaveRoom, relationId[" + paramLong + "], relationType[" + paramInt1 + "], avtype[" + paramInt2;
    Object localObject1;
    int i;
    label67:
    String str1;
    long l;
    String str2;
    Vector localVector;
    if (paramInt1 == 2)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      i = 3000;
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      l = Long.valueOf(str1).longValue();
      if (!((ConcurrentHashMap)localObject1).containsKey(Long.valueOf(paramLong))) {
        break label446;
      }
      str2 = (String)localObject2 + "], containsKey[true";
      localObject2 = (lni)((ConcurrentHashMap)localObject1).get(Long.valueOf(paramLong));
      str2 = str2 + "], last[" + localObject2;
      localVector = ((lni)localObject2).jdField_a_of_type_JavaUtilVector;
      ((lni)localObject2).jdField_a_of_type_Long -= 1L;
      if (((lni)localObject2).jdField_a_of_type_Long != 0L) {
        break label355;
      }
      ((ConcurrentHashMap)localObject1).remove(Long.valueOf(paramLong));
      localObject1 = Long.toString(paramLong);
      if (paramInt1 != 2) {
        break label315;
      }
      VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 14, false, (String)localObject1, str1, false, null, false, new Object[] { new Integer(paramInt2) });
      label248:
      localObject1 = str2 + "], delete[true";
    }
    for (;;)
    {
      QLog.w("AVNotifyCenter", 1, (String)localObject1 + "]");
      return;
      if (paramInt1 != 1) {
        break;
      }
      localObject1 = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
      i = 1;
      break label67;
      label315:
      VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 14, false, (String)localObject1, str1, false, null, false, paramInt2, new Object[] { new Integer(paramInt2) });
      break label248;
      label355:
      if ((localVector != null) && (localVector.size() > 0))
      {
        paramInt2 = localVector.size();
        paramInt1 = 0;
      }
      for (;;)
      {
        if (paramInt1 < paramInt2)
        {
          if (l == ((lnl)localVector.elementAt(paramInt1)).jdField_a_of_type_Long) {
            localVector.remove(paramInt1);
          }
        }
        else
        {
          localObject1 = str2 + "], cur[" + localObject2;
          break;
        }
        paramInt1 += 1;
      }
      label446:
      localObject1 = localObject2;
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).h(String.valueOf(paramLong)))
    {
      c(paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("AVNotifyCenter", 2, "setVideoRoomInfo, but group is exited, groupid: " + paramLong);
      }
    }
    lnm locallnm1;
    lnm locallnm2;
    do
    {
      return;
      locallnm1 = new lnm(this);
      locallnm1.jdField_b_of_type_Long = paramLong;
      locallnm1.jdField_b_of_type_Int = paramInt2;
      locallnm1.jdField_e_of_type_Int = paramInt5;
      locallnm1.jdField_c_of_type_Int = paramInt3;
      locallnm1.jdField_d_of_type_Int = paramInt4;
      locallnm1.jdField_a_of_type_Int = paramInt6;
      locallnm1.jdField_c_of_type_Long = System.currentTimeMillis();
      String str = String.valueOf(paramLong) + String.valueOf(paramInt2);
      locallnm2 = (lnm)this.jdField_e_of_type_JavaUtilMap.get(str);
      this.jdField_e_of_type_JavaUtilMap.put(str, locallnm1);
    } while (!AudioHelper.e());
    QLog.w("AVNotifyCenter", 1, "setVideoRoomInfo[" + paramInt1 + "], \nOld[" + locallnm2 + "], \nNew[" + locallnm1 + "]");
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, String.valueOf(paramLong), paramBoolean1, paramBoolean2);
  }
  
  public void a(int paramInt, long paramLong, long[] paramArrayOfLong)
  {
    int j = 0;
    if (paramInt == 2) {}
    Vector localVector;
    int i;
    for (ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;; localConcurrentHashMap = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      if (AudioHelper.e()) {
        QLog.w("AVNotifyCenter", 1, "setMultiRoomMember, relationType[" + paramInt + "], relationId[" + paramLong + "], roomInfos[" + localConcurrentHashMap.size() + "], memberList[" + paramArrayOfLong.length + "]");
      }
      if (localConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
        localConcurrentHashMap.remove(Long.valueOf(paramLong));
      }
      localVector = new Vector();
      int k = paramArrayOfLong.length;
      i = 0;
      paramInt = j;
      while (paramInt < k)
      {
        lnl locallnl = new lnl(this);
        locallnl.jdField_a_of_type_Long = paramArrayOfLong[paramInt];
        localVector.add(locallnl);
        i += 1;
        paramInt += 1;
      }
      if (paramInt != 1) {
        return;
      }
    }
    paramArrayOfLong = new lni(this);
    paramArrayOfLong.jdField_a_of_type_Long = i;
    paramArrayOfLong.jdField_a_of_type_JavaUtilVector = localVector;
    localConcurrentHashMap.put(Long.valueOf(paramLong), paramArrayOfLong);
  }
  
  public void a(int paramInt, long paramLong1, long[] paramArrayOfLong, int[] paramArrayOfInt, long paramLong2)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("setMultiRoomMember, relationId[").append(paramLong1).append("], relationType[").append(paramInt).append("], states[").append(paramArrayOfInt).append("], roomUserNum[").append(paramLong2).append("], memberList[");
      if (paramArrayOfLong != null)
      {
        bool = true;
        QLog.w("AVNotifyCenter", 1, bool + "]");
      }
    }
    else
    {
      if (paramInt != 2) {
        break label330;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
      }
      if ((paramLong2 != 0L) && (paramArrayOfLong != null) && (paramArrayOfInt != null) && (paramArrayOfLong.length == paramArrayOfInt.length)) {
        break label156;
      }
    }
    label156:
    int i;
    Object localObject2;
    label330:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        localObject1 = new Vector();
        i = paramArrayOfLong.length;
        localObject2 = new ArrayList();
        paramInt = 0;
        if (paramInt < i)
        {
          lnl locallnl = new lnl(this);
          locallnl.jdField_a_of_type_Long = paramArrayOfLong[paramInt];
          if (paramArrayOfInt[paramInt] == 1) {}
          for (bool = true;; bool = false)
          {
            locallnl.jdField_a_of_type_Boolean = bool;
            if ((locallnl.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(locallnl.jdField_a_of_type_Long)))) {
              ((ArrayList)localObject2).add(Long.valueOf(locallnl.jdField_a_of_type_Long));
            }
            ((Vector)localObject1).add(locallnl);
            paramInt += 1;
            break;
          }
        }
        a((ArrayList)localObject2);
        paramArrayOfLong = new lni(this);
        paramArrayOfLong.jdField_a_of_type_Long = paramLong2;
        paramArrayOfLong.jdField_a_of_type_JavaUtilVector = ((Vector)localObject1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), paramArrayOfLong);
        return;
      } while (paramInt != 1);
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
      }
    } while (paramLong2 == 0L);
    Object localObject1 = new Vector();
    if (paramArrayOfLong != null)
    {
      i = paramArrayOfLong.length;
      paramInt = 0;
      if (paramInt < i)
      {
        localObject2 = new lnl(this);
        ((lnl)localObject2).jdField_a_of_type_Long = paramArrayOfLong[paramInt];
        if (paramArrayOfInt[paramInt] == 1) {}
        for (bool = true;; bool = false)
        {
          ((lnl)localObject2).jdField_a_of_type_Boolean = bool;
          ((Vector)localObject1).add(localObject2);
          paramInt += 1;
          break;
        }
      }
    }
    paramArrayOfLong = new lni(this);
    paramArrayOfLong.jdField_a_of_type_Long = paramLong2;
    paramArrayOfLong.jdField_a_of_type_JavaUtilVector = ((Vector)localObject1);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), paramArrayOfLong);
  }
  
  public void a(int paramInt, Long paramLong, boolean paramBoolean)
  {
    if (AudioHelper.e()) {
      QLog.w("AVNotifyCenter", 1, "setChating, relationType[" + paramInt + "], relationId[" + paramLong + "], isChating[" + paramBoolean + "], mActiveChatData[" + this.jdField_b_of_type_Lng + "]");
    }
    Object localObject = String.valueOf(paramLong);
    if (paramBoolean)
    {
      localObject = a((String)localObject, true);
      ((lng)localObject).jdField_a_of_type_Boolean = false;
      ((lng)localObject).jdField_a_of_type_Long = paramLong.longValue();
      ((lng)localObject).jdField_c_of_type_Int = paramInt;
      if (((lng)localObject).jdField_c_of_type_Int != 1) {
        break label182;
      }
      ((lng)localObject).jdField_b_of_type_Int = 1;
    }
    for (;;)
    {
      ((lng)localObject).jdField_d_of_type_Boolean = paramBoolean;
      if (AudioHelper.e()) {
        QLog.w("AVNotifyCenter", 1, "setChating, end, data[" + localObject + "], mActiveChatData[" + this.jdField_b_of_type_Lng + "]");
      }
      return;
      label182:
      if (((lng)localObject).jdField_c_of_type_Int == 2) {
        ((lng)localObject).jdField_b_of_type_Int = 3000;
      } else if (((lng)localObject).jdField_c_of_type_Int == 3) {
        ((lng)localObject).jdField_b_of_type_Int = 0;
      }
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a(paramInt1, 0, paramString, paramInt2, true);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    lng locallng = a(paramString1, true);
    locallng.jdField_a_of_type_Boolean = true;
    locallng.jdField_b_of_type_Int = paramInt;
    locallng.jdField_b_of_type_JavaLangString = paramString1;
    locallng.jdField_c_of_type_JavaLangString = paramString2;
    locallng.jdField_b_of_type_Boolean = paramBoolean;
    QLog.w("AVNotifyCenter", 1, "setChating, uinType[" + paramInt + "], peerUin[" + paramString1 + "], extraUin[" + paramString2 + "], isReceiver[" + paramBoolean + "], AvChatData[" + locallng + "], mActiveChatData[" + this.jdField_b_of_type_Lng + "]");
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    lng locallng = a(paramString, false);
    QLog.w("AVNotifyCenter", 1, "setWaittingState, sessionId[" + paramString + "], relationType[" + paramInt + "], IsWaitting[" + paramBoolean1 + "], isReceiver[" + paramBoolean2 + "], AvChatData[" + locallng + "]");
    if (locallng != null)
    {
      locallng.jdField_c_of_type_Boolean = paramBoolean1;
      if (!paramBoolean1) {
        break label149;
      }
      if (!paramBoolean2) {
        break label140;
      }
      locallng.jdField_d_of_type_Boolean = false;
    }
    for (;;)
    {
      QLog.w("AVNotifyCenter", 1, "setWaittingState, end, AvChatData[" + locallng + "]");
      return;
      label140:
      locallng.jdField_d_of_type_Boolean = true;
      continue;
      label149:
      if (!paramBoolean1) {
        locallng.jdField_d_of_type_Boolean = true;
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "removeTipsInfo: " + paramLong + "relationType:" + paramInt);
    }
    String str = String.valueOf(paramLong);
    if (paramInt == 2) {
      this.jdField_f_of_type_JavaUtilMap.remove(str);
    }
    while (paramInt != 1) {
      return;
    }
    this.jdField_g_of_type_JavaUtilMap.remove(str);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject2 = (String)this.jdField_c_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "0;0";
    }
    int i;
    if (paramInt2 > 0)
    {
      localObject2 = null;
      i = 0;
      if (paramInt1 == 2)
      {
        localObject2 = a(paramLong, 10);
        i = 1;
        if (localObject2 == null) {
          break label227;
        }
        if (((lnm)localObject2).jdField_a_of_type_Int <= 0) {
          break label219;
        }
        localObject1 = "1;" + (((lnm)localObject2).jdField_a_of_type_Int + paramInt2);
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_JavaUtilMap.put(String.valueOf(paramLong), localObject1);
      if (AudioHelper.e()) {
        QLog.w("AVNotifyCenter", 1, "setMultiBarFlagInfo, groupId[" + paramLong + "], avtype[" + paramInt1 + "], memberNum[" + paramInt2 + "], old[" + (String)localObject1 + "], new[" + (String)localObject1 + "]");
      }
      return;
      if (paramInt1 != 10) {
        break;
      }
      localObject2 = a(paramLong, 2);
      i = 1;
      break;
      label219:
      localObject1 = "0;0";
      continue;
      label227:
      if (i != 0)
      {
        localObject1 = "0;0";
        continue;
        localObject1 = "0;0";
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = null;
    lnn locallnn = null;
    Object localObject2 = null;
    if (paramInt1 == 2)
    {
      localObject1 = localObject2;
      if (this.jdField_f_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
        localObject1 = (lnn)this.jdField_f_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      }
      locallnn = new lnn(this);
      locallnn.jdField_a_of_type_Long = paramLong;
      locallnn.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_f_of_type_JavaUtilMap.put(String.valueOf(paramLong), locallnn);
      localObject2 = localObject1;
      localObject1 = locallnn;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.w("AVNotifyCenter", 1, "setTipsRoomInfo, relationId[" + paramLong + "], relationType[" + paramInt1 + "], old[" + localObject2 + "], new[" + localObject1 + "]");
        QLog.d("AVNotifyCenter", 2, "setTipsRoomInfo relationId:" + paramLong + "relationType:" + paramInt1);
      }
      return;
      if (paramInt1 == 1)
      {
        localObject1 = locallnn;
        if (this.jdField_g_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
          localObject1 = (lnn)this.jdField_g_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
        }
        locallnn = new lnn(this);
        locallnn.jdField_a_of_type_Long = paramLong;
        locallnn.jdField_a_of_type_Boolean = paramBoolean;
        locallnn.jdField_a_of_type_Int = paramInt2;
        this.jdField_g_of_type_JavaUtilMap.put(String.valueOf(paramLong), locallnn);
        localObject2 = localObject1;
        localObject1 = locallnn;
      }
      else
      {
        localObject2 = null;
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if ((AudioHelper.e()) || (paramBoolean != this.jdField_b_of_type_Boolean)) {
      QLog.w("AVNotifyCenter", 1, "setVideoRequestStatus, isVideoRequest[" + this.jdField_b_of_type_Boolean + "->" + paramBoolean + "], seq[" + paramLong + "]");
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  @TargetApi(11)
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 11) {}
    String str1;
    SharedPreferences localSharedPreferences;
    String str2;
    do
    {
      return;
      str1 = String.valueOf(paramLong);
      HashSet localHashSet = new HashSet();
      localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      str2 = "ADD_FRIEND_DIALOG" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject = localHashSet;
      if (localSharedPreferences.contains(str2)) {
        localObject = localSharedPreferences.getStringSet(str2, localHashSet);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AVNotifyCenter", 2, "setAddFriendNotifyMaps-->uin=" + paramLong + " bNotify=" + paramBoolean + " srcId=" + paramInt + " size=" + ((Set)localObject).size() + " info=" + localObject.toString());
      }
    } while ((((Set)localObject).size() >= 3) || (((Set)localObject).contains(str1)));
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
    }
    if (!paramBoolean)
    {
      ((Set)localObject).add(str1);
      localSharedPreferences.edit().putStringSet(str2, (Set)localObject).commit();
      return;
    }
    Object localObject = new lnf();
    ((lnf)localObject).jdField_a_of_type_Int = paramInt;
    ((lnf)localObject).jdField_a_of_type_Long = paramLong;
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), localObject);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool = false;
    bbkb.b(paramQQAppInterface.getApplication(), paramInt, paramQQAppInterface.getAccount());
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit();
    localEditor.putString("group_video_push_cfg_txt." + paramQQAppInterface.getAccount(), paramString).commit();
    try
    {
      paramString = new JSONObject(paramString).getJSONObject("mav");
      if (paramString != null)
      {
        JSONObject localJSONObject = paramString.getJSONObject("relationType1");
        if (localJSONObject != null) {
          if (localJSONObject.getInt("mutex") != 0) {
            break label323;
          }
        }
      }
      for (;;)
      {
        this.jdField_g_of_type_Boolean = bool;
        localEditor.putBoolean("group_video_push_cfg_txt." + paramQQAppInterface.getAccount() + ".mutex", this.jdField_g_of_type_Boolean);
        paramString = paramString.getJSONObject("noiseCtrl");
        if (paramString != null)
        {
          paramInt = paramString.getInt("level");
          int i = paramString.getInt("sendDura");
          int j = paramString.getInt("validDura");
          localEditor.putInt("group_video_push_cfg_txt." + paramQQAppInterface.getAccount() + ".level", paramInt);
          localEditor.putInt("group_video_push_cfg_txt." + paramQQAppInterface.getAccount() + ".sendDura", i);
          localEditor.putInt("group_video_push_cfg_txt." + paramQQAppInterface.getAccount() + ".validDura", j);
        }
        localEditor.commit();
        return;
        label323:
        bool = true;
      }
      return;
    }
    catch (JSONException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    synchronized (this.jdField_c_of_type_JavaUtilHashMap)
    {
      QLog.d("AVNotifyCenter", 1, "addOtherTerminalAvChating peerUin = " + paramString + ",roomid = " + paramLong + ",sessionType = " + paramInt);
      this.jdField_c_of_type_JavaUtilHashMap.put(paramString, new lnj(this, paramLong, paramInt));
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new lnk(this, paramString1, paramString2, paramString3));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "setDoubleVideoMeetingFlag-->isDoubleVideoMeeting = " + paramBoolean);
    }
    paramString = a(paramString, false);
    if (paramString != null) {
      paramString.jdField_e_of_type_Boolean = paramBoolean;
    }
  }
  
  void a(ArrayList<Long> paramArrayList)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), axcw.class);
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", paramArrayList);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return;
    }
    catch (Exception paramArrayList)
    {
      QLog.e("AVNotifyCenter", 2, "getOpenIdFromTinyId --> StartServlet Error");
    }
  }
  
  public void a(submsgtype0x126.MsgBody paramMsgBody)
  {
    Object localObject2 = null;
    if (paramMsgBody == null) {
      return;
    }
    int i = paramMsgBody.uint32_msg_type.get();
    if (paramMsgBody.str_msg_info.has()) {}
    for (paramMsgBody = paramMsgBody.str_msg_info.get().toByteArray();; paramMsgBody = null)
    {
      Object localObject1 = "";
      boolean bool;
      if ((paramMsgBody != null) && (paramMsgBody.length > 0))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a != null) {
            localObject1 = (QQServiceForAV)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.get();
          }
        }
        if (localObject1 != null)
        {
          bool = ((QQServiceForAV)localObject1).a("avChatRoom", i, paramMsgBody);
          if (!bool)
          {
            localObject1 = new Intent("tencent.video.q2v.avReceivePushMsg");
            ((Intent)localObject1).putExtra("key", "avChatRoom");
            ((Intent)localObject1).putExtra("msg_type", i);
            ((Intent)localObject1).putExtra("msg_content", paramMsgBody);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast((Intent)localObject1);
            paramMsgBody = "useBroadcast";
          }
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label237;
        }
        QLog.i("AVNotifyCenter", 2, "processAVChatRoomMsgPush ret[" + bool + "], tag[" + paramMsgBody + "]");
        return;
        paramMsgBody = "useQQServiceForAV";
        continue;
        bool = false;
        break;
        bool = false;
        paramMsgBody = (submsgtype0x126.MsgBody)localObject1;
      }
      label237:
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(408), Boolean.valueOf(paramBoolean), paramString });
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Msb != null) {
      return this.jdField_a_of_type_Msb.a();
    }
    return false;
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return a(AudioHelper.b(), String.valueOf(paramLong));
  }
  
  public boolean a(int paramInt1, long paramLong, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt1 == 2) {
      bool1 = a(paramInt1, paramLong);
    }
    lng locallng;
    do
    {
      do
      {
        do
        {
          return bool1;
          paramInt1 = b(paramLong);
          bool1 = bool2;
        } while (paramInt1 < 0);
        locallng = a(String.valueOf(paramLong), false);
        bool1 = bool2;
      } while (locallng == null);
      bool1 = bool2;
    } while (paramInt2 != paramInt1);
    return locallng.jdField_d_of_type_Boolean;
  }
  
  @TargetApi(11)
  public boolean a(long paramLong)
  {
    if (Build.VERSION.SDK_INT < 11) {
      return false;
    }
    HashSet localHashSet = new HashSet();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    String str = "ADD_FRIEND_DIALOG" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject = localHashSet;
    if (localSharedPreferences.contains(str)) {
      localObject = localSharedPreferences.getStringSet(str, localHashSet);
    }
    if (((Set)localObject).size() >= 3) {
      return false;
    }
    if (((Set)localObject).contains(String.valueOf(paramLong))) {
      return false;
    }
    return this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong));
  }
  
  public boolean a(long paramLong, String paramString)
  {
    boolean bool = false;
    lng locallng = a(paramString, false);
    if (AudioHelper.e()) {
      QLog.w("AVNotifyCenter", 1, "isChating, discussId[" + paramString + "], AvChatData[" + locallng + "], seq[" + paramLong + "]");
    }
    if (locallng != null) {
      bool = locallng.jdField_d_of_type_Boolean;
    }
    return bool;
  }
  
  public boolean a(Context paramContext, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramContext == null) {
      return false;
    }
    int j = muc.b(paramInt);
    long l = Long.parseLong(paramString);
    int i = -1;
    if (a(j, l)) {
      i = 0;
    }
    paramString = a(l, 10);
    paramInt = i;
    if (paramString != null)
    {
      paramInt = i;
      if (paramString.jdField_a_of_type_Int > 0) {
        paramInt = 0;
      }
    }
    if (paramInt < 0) {}
    i = paramInt;
    if (paramInt < 0)
    {
      lnm locallnm = a(l, 2);
      paramString = locallnm;
      if (locallnm == null) {
        paramString = a(l, 12);
      }
      i = paramInt;
      if (paramString != null)
      {
        i = paramInt;
        if (paramString.jdField_a_of_type_Int > 0) {
          i = 2;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVNotifyCenter", 2, "checkBlockTroopAVChat, relationType[" + j + "], relationId[" + l + "], ret[" + i + "]");
    }
    boolean bool;
    if (i > 0)
    {
      bool = true;
      if (bool)
      {
        if (i != 1) {
          break label281;
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!paramBoolean) {
          break label276;
        }
        paramInt = 4;
        label210:
        axqy.b(paramString, "CliOper", "", "", "0X800AB81", "0X800AB81", paramInt, 0, "", "", "", "");
        paramInt = 2131696183;
      }
    }
    for (;;)
    {
      bcql.a(paramContext, paramInt, 1).b(paramContext.getResources().getDimensionPixelSize(2131298865));
      return bool;
      bool = false;
      break;
      label276:
      paramInt = 3;
      break label210;
      label281:
      if (i == 2)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramBoolean) {}
        for (paramInt = 4;; paramInt = 3)
        {
          axqy.b(paramString, "CliOper", "", "", "0X800AB83", "0X800AB83", paramInt, 0, "", "", "", "");
          paramInt = 2131696185;
          break;
        }
      }
      paramInt = 2131696183;
    }
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return false;
    }
    int i = -1;
    long l = 0L;
    if (!TextUtils.isEmpty(paramString)) {
      l = avfb.b(paramString);
    }
    if ((d()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) {
      i = 1;
    }
    lnm locallnm1;
    if ((i < 0) && (l != 0L))
    {
      lnm locallnm2 = a(l, 2);
      locallnm1 = locallnm2;
      if (locallnm2 == null) {
        locallnm1 = a(l, 12);
      }
      if ((locallnm1 != null) && (locallnm1.jdField_a_of_type_Int > 0)) {
        i = 0;
      }
    }
    label307:
    label309:
    for (;;)
    {
      if (i == 1)
      {
        bcql.a(paramContext, 2131696182, 1).b(paramContext.getResources().getDimensionPixelSize(2131298865));
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800AB80", "0X800AB80", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AVNotifyCenter", 2, "checkForTroopVideo, ret[" + i + "], groupId[" + paramString + "]");
        }
        if (i <= 0) {
          break label307;
        }
        return true;
        locallnm1 = a(l, 10);
        if ((locallnm1 == null) || (locallnm1.jdField_a_of_type_Int <= 0)) {
          break label309;
        }
        i = 2;
        break;
        if (i == 2)
        {
          bcql.a(paramContext, 2131696184, 1).b(paramContext.getResources().getDimensionPixelSize(2131298865));
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800AB82", "0X800AB82", 0, 0, "", "", "", "");
        }
      }
      return false;
    }
  }
  
  public boolean a(String paramString)
  {
    paramString = (String)this.jdField_c_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return false;
    }
    if (paramString.split(";")[0].equals("1")) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVNotifyCenter", 2, "do qua report error : selfuin = " + paramString1 + " , peeruin =" + paramString2);
      }
      return false;
    }
    String str1 = paramString2;
    Object localObject;
    try
    {
      if (paramString2.startsWith("+")) {
        str1 = paramString2.substring(1);
      }
      if ((this.jdField_b_of_type_JavaUtilHashMap.containsKey(str1)) && (!TextUtils.isEmpty(((lng)this.jdField_b_of_type_JavaUtilHashMap.get(str1)).jdField_b_of_type_JavaLangString)) && (((lng)this.jdField_b_of_type_JavaUtilHashMap.get(str1)).jdField_b_of_type_JavaLangString.equals(str1)) && (d()))
      {
        if (!QLog.isColorLevel()) {
          break label473;
        }
        QLog.i("AVNotifyCenter", 2, "Do not report qua, because this chatting is active!");
        break label473;
      }
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("AVNotifyCenter", 2, "start do qua report : peer uin = " + str1 + " , timestamp = " + l);
      }
      localObject = SharedPreferencesProxyManager.getInstance().getProxy(ldd.jdField_a_of_type_JavaLangString, 4);
      paramString2 = ((SharedPreferences)localObject).getAll();
      localObject = ((SharedPreferences)localObject).edit();
      if (paramString2.size() <= 0) {
        break label415;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AVNotifyCenter", 2, "Qua report map contains report buffer, move to exception map : size = " + paramString2.size());
      }
      SharedPreferences.Editor localEditor = SharedPreferencesProxyManager.getInstance().getProxy(ldd.jdField_b_of_type_JavaLangString, 4).edit();
      Iterator localIterator = paramString2.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        localEditor.putString(str2, (String)paramString2.get(str2));
      }
      localEditor.commit();
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVNotifyCenter", 2, "do qua report error : " + paramString1);
      }
      return false;
    }
    ((SharedPreferences.Editor)localObject).clear().commit();
    label415:
    paramString2 = new QuaReportInfo();
    paramString2.uintype = paramInt2;
    paramString2.busytype = paramInt1;
    paramString2.peerUin = str1;
    paramString2.selfUin = paramString1;
    ((SharedPreferences.Editor)localObject).putString(String.valueOf(System.currentTimeMillis()), paramString2.toString());
    ((SharedPreferences.Editor)localObject).commit();
    return true;
    label473:
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int b(long paramLong)
  {
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return 0;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Lng.jdField_a_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String b(long paramLong)
  {
    synchronized (this.jdField_c_of_type_JavaUtilHashMap)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((lnj)this.jdField_c_of_type_JavaUtilHashMap.get(str)).jdField_a_of_type_Long == paramLong)
        {
          QLog.d("AVNotifyCenter", 1, "getOtherTerminalPeerUin true, roomId=" + paramLong + ", key=" + str);
          return str;
        }
      }
      return "";
    }
  }
  
  public String b(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!TextUtils.isEmpty(paramString)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        lnk locallnk = (lnk)localIterator.next();
        if (paramString.equals(locallnk.jdField_a_of_type_JavaLangString)) {
          return locallnk.jdField_c_of_type_JavaLangString;
        }
      }
    }
    return "";
  }
  
  public void b()
  {
    QLog.d("AVNotifyCenter", 1, "clearMultiRoomInfos, AvChatData[" + this.jdField_b_of_type_Lng + "]");
    this.jdField_b_of_type_Lng.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Lng.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Lng.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2)
  {
    long l = AudioHelper.b();
    if (AudioHelper.e()) {
      QLog.w("AVNotifyCenter", 1, "setAvtype[" + paramInt1 + "], groupid[" + paramLong + "], type[" + paramInt2 + "], seq[" + l + "]");
    }
    if (paramInt2 == 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l, false);
    }
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), Integer.valueOf(paramInt2));
  }
  
  public void b(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void b(long paramLong, int paramInt)
  {
    QLog.w("AVNotifyCenter", 1, "setSmallScreenState, smallScreenState[" + this.jdField_e_of_type_Int + "->" + paramInt + "], seq[" + paramLong + "]");
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilMap.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean));
    if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Intent localIntent = new Intent("tencent.video.q2v.close_invite_msg_box");
      localIntent.putExtra("groupId", paramLong);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void b(String paramString, int paramInt)
  {
    this.jdField_d_of_type_JavaUtilMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void b(ArrayList<AVPhoneUserInfo> paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)paramArrayList.next();
        long l = localAVPhoneUserInfo.account;
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(l))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), localAVPhoneUserInfo);
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "startOrStopGAudioTimer start: " + paramBoolean);
    }
    if (paramBoolean)
    {
      if (!this.jdField_b_of_type_Lng.jdField_d_of_type_Boolean) {
        this.jdField_c_of_type_Long = 0L;
      }
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        if (this.jdField_b_of_type_JavaLangRunnable != null) {
          break label93;
        }
        this.jdField_b_of_type_JavaLangRunnable = new AVNotifyCenter.UpdateChattingTime(this);
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2000L);
      }
    }
    label93:
    while ((d()) || (this.jdField_b_of_type_JavaLangRunnable == null) || (this.jdField_a_of_type_MqqOsMqqHandler == null)) {
      for (;;)
      {
        return;
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_b_of_type_JavaLangRunnable = null;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean b(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "hasMultiVideo --> RelationType = " + paramInt + " ,RelationId = " + paramLong);
    }
    if (paramInt == 2) {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() != 0) {}
    }
    do
    {
      do
      {
        do
        {
          return false;
        } while (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)));
        return true;
        if (paramInt != 1) {
          break;
        }
      } while ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) || (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))));
      return true;
    } while (!QLog.isColorLevel());
    QLog.e("AVNotifyCenter", 2, "hasMultiVideo --> RelationType is Wrong");
    return false;
  }
  
  public boolean b(long paramLong)
  {
    Boolean localBoolean = (Boolean)this.jdField_b_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = false;
    lng locallng = a(paramString, false);
    boolean bool1;
    if (locallng != null) {
      bool1 = locallng.jdField_e_of_type_Boolean;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVNotifyCenter", 2, "isDoubleVideoMeeting --> isDoubleVideoMeeting = " + bool1);
      }
      return bool1;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.e("AVNotifyCenter", 2, "isDoubleVideoMeeting --> can not get data from uin --> peerUin = " + paramString);
        bool1 = bool2;
      }
    }
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String c()
  {
    return this.jdField_b_of_type_Lng.jdField_b_of_type_JavaLangString;
  }
  
  String c(String paramString)
  {
    askn localaskn = (askn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (localaskn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVNotifyCenter", 2, "getPhoneNameByPhoneNum --> can not get PhoneContactManager");
      }
      return null;
    }
    paramString = localaskn.b(paramString);
    if ((paramString == null) || (paramString.name == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVNotifyCenter", 2, "getPhoneNameByPhoneNum --> can not get phoneContact Or Name");
      }
      return null;
    }
    return paramString.name;
  }
  
  public void c(long paramLong)
  {
    String str1 = String.valueOf(paramLong) + 10;
    String str2 = String.valueOf(paramLong) + 2;
    if (this.jdField_e_of_type_JavaUtilMap != null)
    {
      this.jdField_e_of_type_JavaUtilMap.remove(str1);
      this.jdField_e_of_type_JavaUtilMap.remove(str2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, String.format("removeVideoRoomInfo, groupid: %s", new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public void c(String paramString)
  {
    QLog.d("AVNotifyCenter", 1, "removeOtherTerminalAvChating peerUin = " + paramString);
    synchronized (this.jdField_c_of_type_JavaUtilHashMap)
    {
      if (this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        QLog.d("AVNotifyCenter", 1, "removeOtherTerminalAvChating remove true");
        this.jdField_c_of_type_JavaUtilHashMap.remove(paramString);
      }
      return;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((QLog.isColorLevel()) || (this.jdField_a_of_type_Boolean != paramBoolean)) {
      QLog.w("AVNotifyCenter", 1, "setNetworkState, mNetworkDown[" + this.jdField_a_of_type_Boolean + "->" + paramBoolean + "]");
    }
    if ((this.jdField_a_of_type_Boolean != paramBoolean) && (!paramBoolean) && (this.jdField_a_of_type_MqqOsMqqHandler != null))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_MqqOsMqqHandler != null)) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean c(long paramLong)
  {
    boolean bool = true;
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong);
    if (i == 2) {}
    while (bool)
    {
      lnm locallnm = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, 10);
      if ((locallnm == null) || (locallnm.jdField_a_of_type_Int <= 0)) {
        break;
      }
      return false;
      if (i == 0)
      {
        locallnm = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, 2);
        if ((locallnm != null) && (locallnm.jdField_a_of_type_Int > 0)) {}
      }
      else
      {
        bool = false;
      }
    }
    return bool;
  }
  
  public boolean c(String paramString)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString);
        if (AudioHelper.e()) {
          QLog.w("AVNotifyCenter", 1, "removeChatSession, sessionId[" + paramString + "], exist[" + bool + "], mAvChatDataMap[" + this.jdField_b_of_type_JavaUtilHashMap.size() + "]");
        }
        if (!bool)
        {
          bool = false;
          return bool;
        }
        this.jdField_b_of_type_JavaUtilHashMap.remove(paramString);
        lng locallng = this.jdField_b_of_type_Lng;
        if (this.jdField_b_of_type_JavaUtilHashMap.size() == 1)
        {
          Object localObject2 = this.jdField_b_of_type_JavaUtilHashMap.keySet();
          Object localObject1 = null;
          localObject2 = ((Set)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = (String)((Iterator)localObject2).next();
            localObject1 = (lng)this.jdField_b_of_type_JavaUtilHashMap.get(localObject1);
            continue;
          }
          this.jdField_b_of_type_Lng = ((lng)localObject1);
          if (AudioHelper.e()) {
            QLog.w("AVNotifyCenter", 1, "removeChatSession, end, sessionId[" + paramString + "], exist[" + bool + "], mAvChatDataMap[" + this.jdField_b_of_type_JavaUtilHashMap.size() + "], lastChatData[" + locallng + "], mActiveChatData[" + this.jdField_b_of_type_Lng + "]");
          }
        }
        else
        {
          if (!this.jdField_b_of_type_JavaUtilHashMap.isEmpty()) {
            continue;
          }
          this.jdField_b_of_type_Lng = this.jdField_a_of_type_Lng;
          this.jdField_c_of_type_Long = 0L;
          if ((this.jdField_b_of_type_JavaLangRunnable == null) || (this.jdField_a_of_type_MqqOsMqqHandler == null)) {
            continue;
          }
          this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
          continue;
        }
        bool = true;
      }
      finally {}
    }
  }
  
  public int d()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int d(String paramString)
  {
    paramString = (Integer)this.jdField_d_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return 2;
    }
    return paramString.intValue();
  }
  
  public long d()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public String d()
  {
    return this.jdField_b_of_type_Lng.jdField_c_of_type_JavaLangString;
  }
  
  public void d(String paramString)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(800), paramString });
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "setNotifyUpdateTime-->bNotify" + paramBoolean);
    }
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    return (this.jdField_b_of_type_Lng.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Lng.jdField_d_of_type_Boolean);
  }
  
  public boolean d(String paramString)
  {
    synchronized (this.jdField_c_of_type_JavaUtilHashMap)
    {
      if (this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        QLog.d("AVNotifyCenter", 1, "isOtherTerminalAvChatting contains " + paramString);
        return true;
      }
      return false;
    }
  }
  
  public int e()
  {
    return this.jdField_b_of_type_Lng.jdField_a_of_type_Int;
  }
  
  public String e()
  {
    return muc.a(this.jdField_c_of_type_Long);
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean e()
  {
    return this.jdField_b_of_type_JavaLangRunnable != null;
  }
  
  public int f()
  {
    int j = this.jdField_b_of_type_Lng.jdField_b_of_type_Int;
    int i = j;
    if (j == 21) {
      i = 1011;
    }
    return i;
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_Lng.jdField_c_of_type_Boolean;
  }
  
  public int g()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public boolean g()
  {
    return this.jdField_b_of_type_Lng.jdField_b_of_type_Boolean;
  }
  
  public boolean h()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public boolean i()
  {
    if ((!llw.c()) || (!llw.d()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVNotifyCenter", 2, "device not surpport Sharp audio");
      }
      return false;
    }
    return true;
  }
  
  public boolean j()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public boolean k()
  {
    return this.jdField_d_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter
 * JD-Core Version:    0.7.0.1
 */