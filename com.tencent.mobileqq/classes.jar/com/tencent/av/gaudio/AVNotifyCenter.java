package com.tencent.av.gaudio;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.VideoConstants;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.app.QuaReportInfo;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.servlet.VideoConfigServlet;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import jik;
import jil;
import jim;
import jin;
import jio;
import jip;
import jiq;
import jir;
import jis;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class AVNotifyCenter
  extends Observable
{
  static boolean jdField_c_of_type_Boolean;
  private static String jdField_d_of_type_JavaLangString = "QAVPreSetting";
  public static int e;
  private static String jdField_e_of_type_JavaLangString = "BeautyFeature";
  private static String jdField_f_of_type_JavaLangString = "BeautyPopupGuide";
  private static String jdField_g_of_type_JavaLangString = "BeautyValue";
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  PstnSessionInfo jdField_a_of_type_ComTencentAvAppPstnSessionInfo = new PstnSessionInfo();
  public PhoneStatusMonitor a;
  public QQAppInterface a;
  Runnable jdField_a_of_type_JavaLangRunnable = new jil(this);
  String jdField_a_of_type_JavaLangString = null;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  Map jdField_a_of_type_JavaUtilMap = new HashMap();
  public ConcurrentHashMap a;
  final jin jdField_a_of_type_Jin = new jin(this, "default");
  public MqqHandler a;
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  Runnable jdField_b_of_type_JavaLangRunnable;
  String jdField_b_of_type_JavaLangString = null;
  HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  Map jdField_b_of_type_JavaUtilMap = new HashMap();
  public ConcurrentHashMap b;
  public jin b;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  public long c;
  String jdField_c_of_type_JavaLangString = null;
  HashMap jdField_c_of_type_JavaUtilHashMap = new HashMap();
  public Map c;
  ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  int jdField_d_of_type_Int = 0;
  HashMap jdField_d_of_type_JavaUtilHashMap = new HashMap();
  public Map d;
  boolean jdField_d_of_type_Boolean = false;
  private Map jdField_e_of_type_JavaUtilMap = new HashMap();
  public boolean e;
  int jdField_f_of_type_Int = 0;
  private Map jdField_f_of_type_JavaUtilMap = new HashMap();
  public boolean f;
  private Map jdField_g_of_type_JavaUtilMap = new HashMap();
  public boolean g;
  boolean h = false;
  public boolean i = true;
  private boolean j;
  
  static
  {
    jdField_e_of_type_Int = 30;
  }
  
  public AVNotifyCenter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_MqqOsMqqHandler = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_d_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_b_of_type_Jin = this.jdField_a_of_type_Jin;
    this.jdField_c_of_type_Long = 0L;
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_c_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
      this.jdField_a_of_type_MqqOsMqqHandler = new jio(Looper.getMainLooper(), this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new jik(this));
      b();
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
    do
    {
      return;
      paramString = a(paramString, true);
    } while (paramString == null);
    paramString.jdField_a_of_type_Boolean = paramBoolean;
    paramString.jdField_a_of_type_Int = paramInt3;
  }
  
  public static void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(jdField_d_of_type_JavaLangString, 0);
    paramString = jdField_g_of_type_JavaLangString + paramString;
    localSharedPreferences.edit().putInt(paramString, paramInt).commit();
  }
  
  public static int b(String paramString)
  {
    return BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(jdField_d_of_type_JavaLangString, 0).getInt(jdField_g_of_type_JavaLangString + paramString, -1);
  }
  
  private void b()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    if (localSharedPreferences != null) {
      this.j = localSharedPreferences.getBoolean("group_video_push_cfg_txt." + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + ".mutex", true);
    }
  }
  
  public static boolean c()
  {
    return jdField_c_of_type_Boolean;
  }
  
  public static boolean e(String paramString)
  {
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences(jdField_d_of_type_JavaLangString, 0);
    String str = jdField_e_of_type_JavaLangString;
    int m = paramString.getInt(str, -1);
    int k = m;
    if (m == -1) {
      if (!VcSystemInfo.e()) {
        break label67;
      }
    }
    label67:
    for (k = 1;; k = 0)
    {
      paramString.edit().putInt(str, k).commit();
      return k >= 1;
    }
  }
  
  public static boolean f(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(jdField_d_of_type_JavaLangString, 4);
    paramString = jdField_f_of_type_JavaLangString + paramString;
    boolean bool = localSharedPreferences.getBoolean(paramString, true);
    if (bool) {
      localSharedPreferences.edit().putBoolean(paramString, false).commit();
    }
    return bool;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Jin.jdField_c_of_type_Int;
  }
  
  public int a(long paramLong)
  {
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      return ((jim)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_Int;
    }
    return 3999;
  }
  
  public int a(String paramString)
  {
    synchronized (this.jdField_d_of_type_JavaUtilHashMap)
    {
      if (this.jdField_d_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        jiq localjiq = (jiq)this.jdField_d_of_type_JavaUtilHashMap.get(paramString);
        QLog.d("AVNotifyCenter", 1, "getOtherTermianlAvChatingType roomInfo.mSessionType=" + localjiq.jdField_a_of_type_Int + ", peerUin=" + paramString);
        int k = localjiq.jdField_a_of_type_Int;
        return k;
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
    jip localjip;
    if (paramInt == 2)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)))
      {
        localjip = (jip)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
        if (localjip != null) {
          return localjip.jdField_a_of_type_Long;
        }
      }
    }
    else if ((paramInt == 1) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))))
    {
      localjip = (jip)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localjip != null) {
        return localjip.jdField_a_of_type_Long;
      }
    }
    return 0L;
  }
  
  public long a(String paramString)
  {
    synchronized (this.jdField_d_of_type_JavaUtilHashMap)
    {
      if (this.jdField_d_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        jiq localjiq = (jiq)this.jdField_d_of_type_JavaUtilHashMap.get(paramString);
        QLog.d("AVNotifyCenter", 1, "getOtherTerminalAvChattingRoomId roomInfo.mRoomId=" + localjiq.jdField_a_of_type_Long + ", peerUin=" + paramString);
        long l = localjiq.jdField_a_of_type_Long;
        return l;
      }
      return 0L;
    }
  }
  
  public PstnSessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo;
  }
  
  public AVNotifyCenter.UserInfo a(int paramInt, long paramLong)
  {
    if ((paramInt == 2) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))))
    {
      Vector localVector = ((jip)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_JavaUtilVector;
      if ((localVector != null) && (localVector.size() > 0)) {
        return (AVNotifyCenter.UserInfo)localVector.get(0);
      }
    }
    return null;
  }
  
  public AVNotifyCenter.VideoRoomInfo a(long paramLong)
  {
    Object localObject1 = String.valueOf(paramLong) + String.valueOf(2);
    Object localObject2 = String.valueOf(paramLong) + String.valueOf(10);
    localObject1 = (AVNotifyCenter.VideoRoomInfo)this.jdField_e_of_type_JavaUtilMap.get(localObject1);
    localObject2 = (AVNotifyCenter.VideoRoomInfo)this.jdField_e_of_type_JavaUtilMap.get(localObject2);
    Object localObject3 = String.valueOf(paramLong) + String.valueOf(12);
    localObject3 = (AVNotifyCenter.VideoRoomInfo)this.jdField_e_of_type_JavaUtilMap.get(localObject3);
    int k = b(paramLong);
    if ((k != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1, paramLong))) {
      if (k != 12) {}
    }
    while ((localObject3 != null) && (((AVNotifyCenter.VideoRoomInfo)localObject3).jdField_a_of_type_Int > 0))
    {
      return localObject3;
      if (k == 2) {
        return localObject1;
      }
      if (k != 10) {
        break;
      }
      return localObject2;
    }
    if ((localObject1 != null) && (((AVNotifyCenter.VideoRoomInfo)localObject1).jdField_a_of_type_Int > 0)) {
      return localObject1;
    }
    if ((localObject2 != null) && (((AVNotifyCenter.VideoRoomInfo)localObject2).jdField_a_of_type_Int > 0)) {
      return localObject2;
    }
    return null;
  }
  
  public AVNotifyCenter.VideoRoomInfo a(long paramLong, int paramInt)
  {
    String str = String.valueOf(paramLong) + String.valueOf(paramInt);
    return (AVNotifyCenter.VideoRoomInfo)this.jdField_e_of_type_JavaUtilMap.get(str);
  }
  
  public AVNotifyCenter.VideoRoomInfo_tips a(long paramLong, int paramInt)
  {
    String str = String.valueOf(paramLong);
    AVNotifyCenter.VideoRoomInfo_tips localVideoRoomInfo_tips = null;
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "getTipsRoomInfo: " + paramLong + "relationType:" + paramInt);
    }
    if (paramInt == 2) {
      localVideoRoomInfo_tips = (AVNotifyCenter.VideoRoomInfo_tips)this.jdField_f_of_type_JavaUtilMap.get(str);
    }
    for (;;)
    {
      if ((localVideoRoomInfo_tips == null) && (QLog.isColorLevel())) {
        QLog.d("AVNotifyCenter", 2, "getTipsRoomInfo: infos is null!");
      }
      return localVideoRoomInfo_tips;
      if (paramInt == 1) {
        localVideoRoomInfo_tips = (AVNotifyCenter.VideoRoomInfo_tips)this.jdField_g_of_type_JavaUtilMap.get(str);
      }
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
      return PstnUtils.a(str1, 4);
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
        jir localjir = (jir)localIterator.next();
        if (paramString.equals(localjir.jdField_a_of_type_JavaLangString)) {
          return localjir.jdField_b_of_type_JavaLangString;
        }
      }
    }
    return "";
  }
  
  public HashMap a()
  {
    return this.jdField_b_of_type_JavaUtilHashMap;
  }
  
  public Vector a(long paramLong)
  {
    if ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))))
    {
      Object localObject = (jip)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = ((jip)localObject).jdField_a_of_type_JavaUtilVector;
        if (localObject != null) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public jin a(String paramString, boolean paramBoolean)
  {
    jin localjin2 = null;
    for (;;)
    {
      jin localjin1;
      try
      {
        if (this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          localjin1 = (jin)this.jdField_c_of_type_JavaUtilHashMap.get(paramString);
          return localjin1;
        }
        if (paramBoolean)
        {
          QLog.w("AVNotifyCenter", 1, "getChatSession, create sessionId[" + paramString + "], mAvChatDataMap[" + this.jdField_c_of_type_JavaUtilHashMap.size() + "], mActiveChatData[" + this.jdField_b_of_type_Jin + "]");
          localjin2 = new jin(this, "normal");
          this.jdField_c_of_type_JavaUtilHashMap.put(paramString, localjin2);
          localjin1 = localjin2;
          if (this.jdField_c_of_type_JavaUtilHashMap.size() != 1) {
            continue;
          }
          this.jdField_b_of_type_Jin = localjin2;
          localjin1 = localjin2;
          continue;
        }
        localjin1 = localjin2;
      }
      finally {}
      if (AudioHelper.e())
      {
        QLog.w("AVNotifyCenter", 1, "getChatSession, not exist, sessionId[" + paramString + "]");
        localjin1 = localjin2;
      }
    }
  }
  
  public void a()
  {
    QLog.d("AVNotifyCenter", 1, "clearMultiRoomInfos, AvChatData[" + this.jdField_b_of_type_Jin + "]");
    this.jdField_b_of_type_Jin.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Jin.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Jin.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
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
    int m = 0;
    int k = 0;
    Object localObject1 = new StringBuilder().append("setMultiRoomMember[").append(paramInt1).append("], relationType[").append(paramInt2).append("], relationId[").append(paramLong1).append("], memberList[");
    boolean bool;
    if (paramArrayOfLong != null)
    {
      bool = true;
      QLog.w("AVNotifyCenter", 1, bool + "], roomUserNum[" + paramLong2 + "]");
      if (paramInt2 != 2) {
        break label234;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
      }
      if ((paramLong2 != 0L) && (paramArrayOfLong != null)) {
        break label140;
      }
    }
    label140:
    Object localObject2;
    label234:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        localObject1 = new Vector();
        paramInt2 = paramArrayOfLong.length;
        paramInt1 = k;
        while (paramInt1 < paramInt2)
        {
          localObject2 = new AVNotifyCenter.UserInfo(this);
          ((AVNotifyCenter.UserInfo)localObject2).jdField_a_of_type_Long = paramArrayOfLong[paramInt1];
          ((Vector)localObject1).add(localObject2);
          paramInt1 += 1;
        }
        paramArrayOfLong = new jip(this);
        paramArrayOfLong.jdField_a_of_type_Long = paramLong2;
        paramArrayOfLong.jdField_a_of_type_JavaUtilVector = ((Vector)localObject1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), paramArrayOfLong);
        return;
      } while (paramInt2 != 1);
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
      }
    } while (paramLong2 == 0L);
    localObject1 = new jip(this);
    ((jip)localObject1).jdField_a_of_type_Long = paramLong2;
    ((jip)localObject1).jdField_a_of_type_JavaUtilVector = null;
    if (paramArrayOfLong != null)
    {
      localObject2 = new Vector();
      paramInt1 = m;
      while (paramInt1 < paramArrayOfLong.length)
      {
        AVNotifyCenter.UserInfo localUserInfo = new AVNotifyCenter.UserInfo(this);
        localUserInfo.jdField_a_of_type_Long = paramArrayOfLong[paramInt1];
        ((Vector)localObject2).add(localUserInfo);
        paramInt1 += 1;
      }
      ((jip)localObject1).jdField_a_of_type_JavaUtilVector = ((Vector)localObject2);
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
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "onSelfEnterRoom-->relationType==" + paramInt + " discussId" + paramLong);
    }
    Object localObject1;
    long l;
    Vector localVector;
    int k;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (paramInt != 2) {
        break label185;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
      if (!((ConcurrentHashMap)localObject1).containsKey(Long.valueOf(paramLong))) {
        break label292;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AVNotifyCenter", 2, "onSelfEnterRoom-->containsKey");
      }
      localObject1 = (jip)((ConcurrentHashMap)localObject1).get(Long.valueOf(paramLong));
      localVector = ((jip)localObject1).jdField_a_of_type_JavaUtilVector;
      if ((localVector == null) || (localVector.size() <= 0)) {
        break label206;
      }
      k = localVector.size();
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt >= k) {
        break label206;
      }
      if (l == ((AVNotifyCenter.UserInfo)localVector.elementAt(paramInt)).jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AVNotifyCenter", 2, "onSelfEnterRoom-->uin in uinlist");
        }
        label185:
        do
        {
          return;
        } while (paramInt != 1);
        localObject1 = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
        break;
      }
      paramInt += 1;
    }
    label206:
    Object localObject2;
    if (localVector != null)
    {
      localObject2 = new AVNotifyCenter.UserInfo(this);
      ((AVNotifyCenter.UserInfo)localObject2).jdField_a_of_type_Long = l;
      localVector.add(localObject2);
      ((jip)localObject1).jdField_a_of_type_Long += 1L;
      if (QLog.isColorLevel()) {
        QLog.d("AVNotifyCenter", 2, "onSelfEnterRoom-->infoRoomNum=" + ((jip)localObject1).jdField_a_of_type_Long);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      return;
      label292:
      if (QLog.isColorLevel()) {
        QLog.d("AVNotifyCenter", 2, "onSelfEnterRoom-->insert new uinlist");
      }
      localVector = new Vector();
      localObject2 = new AVNotifyCenter.UserInfo(this);
      ((AVNotifyCenter.UserInfo)localObject2).jdField_a_of_type_Long = l;
      localVector.add(localObject2);
      localObject2 = new jip(this);
      ((jip)localObject2).jdField_a_of_type_Long = 1L;
      ((jip)localObject2).jdField_a_of_type_JavaUtilVector = localVector;
      ((ConcurrentHashMap)localObject1).put(Long.valueOf(paramLong), localObject2);
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    if (AudioHelper.e()) {
      QLog.w("AVNotifyCenter", 1, "onSelfLeaveRoom, relationId[" + paramLong + "], relationType[" + paramInt1 + "], avtype[" + paramInt2 + "]");
    }
    Object localObject;
    int k;
    String str;
    long l;
    Vector localVector;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (paramInt1 != 2) {
        break label228;
      }
      localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      k = 3000;
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      l = Long.valueOf(str).longValue();
      label226:
      if (((ConcurrentHashMap)localObject).containsKey(Long.valueOf(paramLong)))
      {
        jip localjip = (jip)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong));
        localVector = localjip.jdField_a_of_type_JavaUtilVector;
        localjip.jdField_a_of_type_Long -= 1L;
        if (QLog.isColorLevel()) {
          QLog.d("shanezhai", 2, "onSelfLeaveRoom");
        }
        if (localjip.jdField_a_of_type_Long != 0L) {
          break label283;
        }
        ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong));
        localObject = Long.toString(paramLong);
        if (paramInt1 != 2) {
          break label245;
        }
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k, 14, false, (String)localObject, str, false, null, false, new Object[] { new Integer(paramInt2) });
      }
    }
    label283:
    for (;;)
    {
      return;
      label228:
      if (paramInt1 == 1)
      {
        localObject = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
        k = 1;
        break;
        label245:
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k, 14, false, (String)localObject, str, false, null, false, paramInt2, new Object[] { new Integer(paramInt2) });
        return;
        if ((localVector == null) || (localVector.size() <= 0)) {
          break label226;
        }
        paramInt2 = localVector.size();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          if (l == ((AVNotifyCenter.UserInfo)localVector.elementAt(paramInt1)).jdField_a_of_type_Long)
          {
            localVector.remove(paramInt1);
            return;
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    AVNotifyCenter.VideoRoomInfo localVideoRoomInfo1 = new AVNotifyCenter.VideoRoomInfo(this);
    localVideoRoomInfo1.jdField_b_of_type_Long = paramLong;
    localVideoRoomInfo1.jdField_b_of_type_Int = paramInt2;
    localVideoRoomInfo1.jdField_c_of_type_Int = paramInt3;
    localVideoRoomInfo1.jdField_a_of_type_Int = paramInt4;
    String str = String.valueOf(paramLong) + String.valueOf(paramInt2);
    AVNotifyCenter.VideoRoomInfo localVideoRoomInfo2 = (AVNotifyCenter.VideoRoomInfo)this.jdField_e_of_type_JavaUtilMap.get(str);
    this.jdField_e_of_type_JavaUtilMap.put(str, localVideoRoomInfo1);
    if (AudioHelper.e()) {
      QLog.w("AVNotifyCenter", 1, "setVideoRoomInfo[" + paramInt1 + "], \nOld[" + localVideoRoomInfo2 + "], \nNew[" + localVideoRoomInfo1 + "]");
    }
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, String.valueOf(paramLong), paramBoolean1, paramBoolean2);
  }
  
  public void a(int paramInt, long paramLong, long[] paramArrayOfLong)
  {
    int m = 0;
    if (paramInt == 2) {}
    Vector localVector;
    int k;
    for (ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;; localConcurrentHashMap = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      if (AudioHelper.e()) {
        QLog.w("AVNotifyCenter", 1, "setMultiRoomMember, relationType[" + paramInt + "], relationId[" + paramLong + "], roomInfos[" + localConcurrentHashMap.size() + "], memberList[" + paramArrayOfLong.length + "]");
      }
      if (localConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
        localConcurrentHashMap.remove(Long.valueOf(paramLong));
      }
      localVector = new Vector();
      int n = paramArrayOfLong.length;
      k = 0;
      paramInt = m;
      while (paramInt < n)
      {
        AVNotifyCenter.UserInfo localUserInfo = new AVNotifyCenter.UserInfo(this);
        localUserInfo.jdField_a_of_type_Long = paramArrayOfLong[paramInt];
        localVector.add(localUserInfo);
        k += 1;
        paramInt += 1;
      }
      if (paramInt != 1) {
        return;
      }
    }
    paramArrayOfLong = new jip(this);
    paramArrayOfLong.jdField_a_of_type_Long = k;
    paramArrayOfLong.jdField_a_of_type_JavaUtilVector = localVector;
    localConcurrentHashMap.put(Long.valueOf(paramLong), paramArrayOfLong);
  }
  
  public void a(int paramInt, long paramLong1, long[] paramArrayOfLong, int[] paramArrayOfInt, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.w("AVNotifyCenter", 1, "setMultiRoomMember, relationId[" + paramLong1 + "], relationType[" + paramInt + "], roomUserNum[" + paramLong2 + "]");
    }
    if (paramInt == 2)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
      }
      if ((paramLong2 != 0L) && (paramArrayOfLong != null) && (paramArrayOfInt != null) && (paramArrayOfLong.length == paramArrayOfInt.length)) {}
    }
    do
    {
      do
      {
        return;
        Vector localVector = new Vector();
        int k = paramArrayOfLong.length;
        ArrayList localArrayList = new ArrayList();
        paramInt = 0;
        if (paramInt < k)
        {
          AVNotifyCenter.UserInfo localUserInfo = new AVNotifyCenter.UserInfo(this);
          localUserInfo.jdField_a_of_type_Long = paramArrayOfLong[paramInt];
          if (paramArrayOfInt[paramInt] == 1) {}
          for (boolean bool = true;; bool = false)
          {
            localUserInfo.jdField_a_of_type_Boolean = bool;
            if ((localUserInfo.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(localUserInfo.jdField_a_of_type_Long)))) {
              localArrayList.add(Long.valueOf(localUserInfo.jdField_a_of_type_Long));
            }
            localVector.add(localUserInfo);
            paramInt += 1;
            break;
          }
        }
        a(localArrayList);
        paramArrayOfLong = new jip(this);
        paramArrayOfLong.jdField_a_of_type_Long = paramLong2;
        paramArrayOfLong.jdField_a_of_type_JavaUtilVector = localVector;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), paramArrayOfLong);
        return;
      } while (paramInt != 1);
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
      }
    } while (paramLong2 == 0L);
    paramArrayOfLong = new jip(this);
    paramArrayOfLong.jdField_a_of_type_Long = paramLong2;
    paramArrayOfLong.jdField_a_of_type_JavaUtilVector = null;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), paramArrayOfLong);
  }
  
  public void a(int paramInt, Long paramLong, boolean paramBoolean)
  {
    if (AudioHelper.e()) {
      QLog.w("AVNotifyCenter", 1, "setChating, relationType[" + paramInt + "], relationId[" + paramLong + "], isChating[" + paramBoolean + "], mActiveChatData[" + this.jdField_b_of_type_Jin + "]");
    }
    Object localObject = String.valueOf(paramLong);
    if (paramBoolean)
    {
      localObject = a((String)localObject, true);
      ((jin)localObject).jdField_a_of_type_Boolean = false;
      ((jin)localObject).jdField_a_of_type_Long = paramLong.longValue();
      ((jin)localObject).jdField_c_of_type_Int = paramInt;
      if (((jin)localObject).jdField_c_of_type_Int != 1) {
        break label182;
      }
      ((jin)localObject).jdField_b_of_type_Int = 1;
    }
    for (;;)
    {
      ((jin)localObject).jdField_d_of_type_Boolean = paramBoolean;
      if (AudioHelper.e()) {
        QLog.w("AVNotifyCenter", 1, "setChating, end, data[" + localObject + "], mActiveChatData[" + this.jdField_b_of_type_Jin + "]");
      }
      return;
      label182:
      if (((jin)localObject).jdField_c_of_type_Int == 2) {
        ((jin)localObject).jdField_b_of_type_Int = 3000;
      } else if (((jin)localObject).jdField_c_of_type_Int == 3) {
        ((jin)localObject).jdField_b_of_type_Int = 0;
      }
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a(paramInt1, 0, paramString, paramInt2, true);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    jin localjin = a(paramString1, true);
    localjin.jdField_a_of_type_Boolean = true;
    localjin.jdField_b_of_type_Int = paramInt;
    localjin.jdField_b_of_type_JavaLangString = paramString1;
    localjin.jdField_c_of_type_JavaLangString = paramString2;
    localjin.jdField_b_of_type_Boolean = paramBoolean;
    QLog.w("AVNotifyCenter", 1, "setChating, uinType[" + paramInt + "], peerUin[" + paramString1 + "], extraUin[" + paramString2 + "], isReceiver[" + paramBoolean + "], AvChatData[" + localjin + "], mActiveChatData[" + this.jdField_b_of_type_Jin + "]");
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    jin localjin = a(paramString, false);
    QLog.w("AVNotifyCenter", 1, "setWaittingState, sessionId[" + paramString + "], relationType[" + paramInt + "], IsWaitting[" + paramBoolean1 + "], isReceiver[" + paramBoolean2 + "], AvChatData[" + localjin + "]");
    if (localjin != null)
    {
      localjin.jdField_c_of_type_Boolean = paramBoolean1;
      if (!paramBoolean1) {
        break label149;
      }
      if (!paramBoolean2) {
        break label140;
      }
      localjin.jdField_d_of_type_Boolean = false;
    }
    for (;;)
    {
      QLog.w("AVNotifyCenter", 1, "setWaittingState, end, AvChatData[" + localjin + "]");
      return;
      label140:
      localjin.jdField_d_of_type_Boolean = true;
      continue;
      label149:
      if (!paramBoolean1) {
        localjin.jdField_d_of_type_Boolean = true;
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("AVNotifyCenter", 1, "setAvtype, groupid[" + paramLong + "], type[" + paramInt + "]");
    }
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false);
    }
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    int k = 1;
    Object localObject2 = (String)this.jdField_c_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "0;0";
    }
    if (paramInt2 > 0) {
      if (paramInt1 == 2)
      {
        localObject2 = a(paramLong, 10);
        paramInt1 = k;
      }
    }
    for (;;)
    {
      if (localObject2 != null) {
        if (((AVNotifyCenter.VideoRoomInfo)localObject2).jdField_a_of_type_Int > 0) {
          localObject1 = "1;" + (((AVNotifyCenter.VideoRoomInfo)localObject2).jdField_a_of_type_Int + paramInt2);
        }
      }
      for (;;)
      {
        this.jdField_c_of_type_JavaUtilMap.put(String.valueOf(paramLong), localObject1);
        return;
        if (paramInt1 != 10) {
          break label164;
        }
        localObject2 = a(paramLong, 2);
        paramInt1 = k;
        break;
        localObject1 = "0;0";
        continue;
        if (paramInt1 != 0)
        {
          localObject1 = "0;0";
          continue;
          localObject1 = "0;0";
        }
      }
      label164:
      paramInt1 = 0;
      localObject2 = null;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "setTipsRoomInfo relationId:" + paramLong + "relationType:" + paramInt1);
    }
    if (paramInt1 == 2)
    {
      if (this.jdField_f_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
        this.jdField_f_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      }
      localVideoRoomInfo_tips = new AVNotifyCenter.VideoRoomInfo_tips(this);
      localVideoRoomInfo_tips.jdField_a_of_type_Long = paramLong;
      localVideoRoomInfo_tips.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_f_of_type_JavaUtilMap.put(String.valueOf(paramLong), localVideoRoomInfo_tips);
    }
    while (paramInt1 != 1) {
      return;
    }
    if (this.jdField_g_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
      this.jdField_g_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
    }
    AVNotifyCenter.VideoRoomInfo_tips localVideoRoomInfo_tips = new AVNotifyCenter.VideoRoomInfo_tips(this);
    localVideoRoomInfo_tips.jdField_a_of_type_Long = paramLong;
    localVideoRoomInfo_tips.jdField_a_of_type_Boolean = paramBoolean;
    localVideoRoomInfo_tips.jdField_a_of_type_Int = paramInt2;
    this.jdField_g_of_type_JavaUtilMap.put(String.valueOf(paramLong), localVideoRoomInfo_tips);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilMap.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean));
    if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Intent localIntent = new Intent("tencent.video.q2v.close_invite_msg_box");
      localIntent.putExtra("groupId", paramLong);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
    }
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
    Object localObject = new jim();
    ((jim)localObject).jdField_a_of_type_Int = paramInt;
    ((jim)localObject).jdField_a_of_type_Long = paramLong;
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), localObject);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool = false;
    SharedPreUtils.b(paramQQAppInterface.getApplication(), paramInt, paramQQAppInterface.getAccount());
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
        this.j = bool;
        localEditor.putBoolean("group_video_push_cfg_txt." + paramQQAppInterface.getAccount() + ".mutex", this.j);
        paramString = paramString.getJSONObject("noiseCtrl");
        if (paramString != null)
        {
          paramInt = paramString.getInt("level");
          int k = paramString.getInt("sendDura");
          int m = paramString.getInt("validDura");
          localEditor.putInt("group_video_push_cfg_txt." + paramQQAppInterface.getAccount() + ".level", paramInt);
          localEditor.putInt("group_video_push_cfg_txt." + paramQQAppInterface.getAccount() + ".sendDura", k);
          localEditor.putInt("group_video_push_cfg_txt." + paramQQAppInterface.getAccount() + ".validDura", m);
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
    synchronized (this.jdField_d_of_type_JavaUtilHashMap)
    {
      QLog.d("AVNotifyCenter", 1, "addOtherTerminalAvChating peerUin = " + paramString + ",roomid = " + paramLong + ",sessionType = " + paramInt);
      this.jdField_d_of_type_JavaUtilHashMap.put(paramString, new jiq(this, paramLong, paramInt));
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new jir(this, paramString1, paramString2, paramString3));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "setDoubleVideoMeetingFlag-->isDoubleVideoMeeting = " + paramBoolean);
    }
    paramString = a(paramString, false);
    if (paramString != null) {
      paramString.e = paramBoolean;
    }
  }
  
  void a(ArrayList paramArrayList)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), VideoConfigServlet.class);
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
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
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
    if (this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor != null) {
      return this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor.a();
    }
    return false;
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    boolean bool = false;
    jin localjin = a(String.valueOf(paramLong), false);
    if (AudioHelper.e()) {
      QLog.w("AVNotifyCenter", 1, "isChating, " + localjin + "]");
    }
    if (localjin != null) {
      bool = localjin.jdField_d_of_type_Boolean;
    }
    return bool;
  }
  
  public boolean a(int paramInt1, long paramLong, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt1 == 2) {
      bool1 = a(paramInt1, paramLong);
    }
    jin localjin;
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
        localjin = a(String.valueOf(paramLong), false);
        bool1 = bool2;
      } while (localjin == null);
      bool1 = bool2;
    } while (paramInt2 != paramInt1);
    return localjin.jdField_d_of_type_Boolean;
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
      if ((this.jdField_c_of_type_JavaUtilHashMap.containsKey(str1)) && (!TextUtils.isEmpty(((jin)this.jdField_c_of_type_JavaUtilHashMap.get(str1)).jdField_b_of_type_JavaLangString)) && (((jin)this.jdField_c_of_type_JavaUtilHashMap.get(str1)).jdField_b_of_type_JavaLangString.equals(str1)) && (d()))
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
      localObject = SharedPreferencesProxyManager.getInstance().getProxy(VideoConstants.jdField_a_of_type_JavaLangString, 4);
      paramString2 = ((SharedPreferences)localObject).getAll();
      localObject = ((SharedPreferences)localObject).edit();
      if (paramString2.size() <= 0) {
        break label415;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AVNotifyCenter", 2, "Qua report map contains report buffer, move to exception map : size = " + paramString2.size());
      }
      SharedPreferences.Editor localEditor = SharedPreferencesProxyManager.getInstance().getProxy(VideoConstants.jdField_b_of_type_JavaLangString, 4).edit();
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
    return this.jdField_b_of_type_Jin.jdField_a_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String b(long paramLong)
  {
    synchronized (this.jdField_d_of_type_JavaUtilHashMap)
    {
      Iterator localIterator = this.jdField_d_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((jiq)this.jdField_d_of_type_JavaUtilHashMap.get(str)).jdField_a_of_type_Long == paramLong)
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
        jir localjir = (jir)localIterator.next();
        if (paramString.equals(localjir.jdField_a_of_type_JavaLangString)) {
          return localjir.jdField_c_of_type_JavaLangString;
        }
      }
    }
    return "";
  }
  
  public void b(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void b(long paramLong, int paramInt)
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
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void b(String paramString, int paramInt)
  {
    this.jdField_d_of_type_JavaUtilMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void b(ArrayList paramArrayList)
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
    jdField_c_of_type_Boolean = paramBoolean;
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
    jin localjin = a(paramString, false);
    boolean bool1;
    if (localjin != null) {
      bool1 = localjin.e;
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
  
  public int c(String paramString)
  {
    paramString = (Integer)this.jdField_d_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return 2;
    }
    return paramString.intValue();
  }
  
  public long c()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String c()
  {
    return this.jdField_b_of_type_Jin.jdField_b_of_type_JavaLangString;
  }
  
  String c(String paramString)
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (localPhoneContactManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVNotifyCenter", 2, "getPhoneNameByPhoneNum --> can not get PhoneContactManager");
      }
      return null;
    }
    paramString = localPhoneContactManager.b(paramString);
    if ((paramString == null) || (paramString.name == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVNotifyCenter", 2, "getPhoneNameByPhoneNum --> can not get phoneContact Or Name");
      }
      return null;
    }
    return paramString.name;
  }
  
  public void c(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void c(String paramString)
  {
    QLog.d("AVNotifyCenter", 1, "removeOtherTerminalAvChating peerUin = " + paramString);
    synchronized (this.jdField_d_of_type_JavaUtilHashMap)
    {
      if (this.jdField_d_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        QLog.d("AVNotifyCenter", 1, "removeOtherTerminalAvChating remove true");
        this.jdField_d_of_type_JavaUtilHashMap.remove(paramString);
      }
      return;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "startOrStopGAudioTimer start: " + paramBoolean);
    }
    if (paramBoolean)
    {
      if (!this.jdField_b_of_type_Jin.jdField_d_of_type_Boolean) {
        this.jdField_c_of_type_Long = 0L;
      }
      if (this.jdField_b_of_type_JavaLangRunnable == null) {
        this.jdField_b_of_type_JavaLangRunnable = new jis(this);
      }
    }
    while ((d()) || (this.jdField_b_of_type_JavaLangRunnable == null) || (this.jdField_a_of_type_MqqOsMqqHandler == null)) {
      for (;;)
      {
        if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
          this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1000L);
        }
        return;
        if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
          this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        }
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  public boolean c(long paramLong)
  {
    boolean bool = true;
    int k = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong);
    if (k == 2) {}
    while (bool)
    {
      AVNotifyCenter.VideoRoomInfo localVideoRoomInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, 10);
      if ((localVideoRoomInfo == null) || (localVideoRoomInfo.jdField_a_of_type_Int <= 0)) {
        break;
      }
      return false;
      if (k == 0)
      {
        localVideoRoomInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, 2);
        if ((localVideoRoomInfo != null) && (localVideoRoomInfo.jdField_a_of_type_Int > 0)) {}
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
        boolean bool = this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramString);
        if (AudioHelper.e()) {
          QLog.w("AVNotifyCenter", 1, "removeChatSession, sessionId[" + paramString + "], exist[" + bool + "], mAvChatDataMap[" + this.jdField_c_of_type_JavaUtilHashMap.size() + "]");
        }
        if (!bool)
        {
          bool = false;
          return bool;
        }
        this.jdField_c_of_type_JavaUtilHashMap.remove(paramString);
        jin localjin = this.jdField_b_of_type_Jin;
        if (this.jdField_c_of_type_JavaUtilHashMap.size() == 1)
        {
          Object localObject2 = this.jdField_c_of_type_JavaUtilHashMap.keySet();
          Object localObject1 = null;
          localObject2 = ((Set)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = (String)((Iterator)localObject2).next();
            localObject1 = (jin)this.jdField_c_of_type_JavaUtilHashMap.get(localObject1);
            continue;
          }
          this.jdField_b_of_type_Jin = ((jin)localObject1);
          if (AudioHelper.e()) {
            QLog.w("AVNotifyCenter", 1, "removeChatSession, end, sessionId[" + paramString + "], exist[" + bool + "], mAvChatDataMap[" + this.jdField_c_of_type_JavaUtilHashMap.size() + "], lastChatData[" + localjin + "], mActiveChatData[" + this.jdField_b_of_type_Jin + "]");
          }
        }
        else
        {
          if (!this.jdField_c_of_type_JavaUtilHashMap.isEmpty()) {
            continue;
          }
          this.jdField_b_of_type_Jin = this.jdField_a_of_type_Jin;
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
  
  public long d()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public String d()
  {
    return this.jdField_b_of_type_Jin.jdField_c_of_type_JavaLangString;
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
    long l = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.w("AVNotifyCenter", 1, "setNetworkState, networkDown[" + paramBoolean + "]");
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
    AVLog.d("AVNotifyCenter", "setNetworkState: End=" + (SystemClock.elapsedRealtime() - l));
  }
  
  public boolean d()
  {
    return (this.jdField_b_of_type_Jin.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Jin.jdField_d_of_type_Boolean);
  }
  
  public boolean d(String paramString)
  {
    synchronized (this.jdField_d_of_type_JavaUtilHashMap)
    {
      if (this.jdField_d_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        QLog.d("AVNotifyCenter", 1, "isOtherTerminalAvChatting contains " + paramString);
        return true;
      }
      return false;
    }
  }
  
  public int e()
  {
    return this.jdField_b_of_type_Jin.jdField_a_of_type_Int;
  }
  
  public String e()
  {
    return UITools.a(this.jdField_c_of_type_Long);
  }
  
  public void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "setNotifyUpdateTime-->bNotify" + paramBoolean);
    }
    this.i = paramBoolean;
  }
  
  public boolean e()
  {
    return this.jdField_b_of_type_Jin.jdField_c_of_type_Boolean;
  }
  
  public int f()
  {
    int m = this.jdField_b_of_type_Jin.jdField_b_of_type_Int;
    int k = m;
    if (m == 21) {
      k = 1011;
    }
    return k;
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_Jin.jdField_b_of_type_Boolean;
  }
  
  public int g()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public boolean g()
  {
    return this.j;
  }
  
  public boolean h()
  {
    if ((!VcSystemInfo.c()) || (!VcSystemInfo.d()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVNotifyCenter", 2, "device not surpport Sharp audio");
      }
      return false;
    }
    return true;
  }
  
  public boolean i()
  {
    return this.h;
  }
  
  public boolean j()
  {
    return this.jdField_d_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter
 * JD-Core Version:    0.7.0.1
 */