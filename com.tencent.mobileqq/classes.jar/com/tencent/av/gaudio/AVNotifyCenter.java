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
import com.tencent.av.VideoConstants;
import com.tencent.av.app.QuaReportInfo;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qcall.UinUtils;
import com.tencent.mobileqq.servlet.VideoConfigServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AudioHelperUtil;
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
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x126.submsgtype0x126.MsgBody;

public class AVNotifyCenter
  extends Observable
{
  private static boolean jdField_e_of_type_Boolean = false;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  private final AVNotifyCenter.AvChatData jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData = new AVNotifyCenter.AvChatData(this, "default", 0L);
  private PhoneStatusMonitor jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  Runnable jdField_a_of_type_JavaLangRunnable = new AVNotifyCenter.2(this);
  String jdField_a_of_type_JavaLangString = null;
  private ArrayList<AVNotifyCenter.RandomInfo> jdField_a_of_type_JavaUtilArrayList;
  HashMap<String, AVNotifyCenter.OtherTerChatingRoomInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  Map jdField_a_of_type_JavaUtilMap = new HashMap();
  ConcurrentHashMap<Long, AVNotifyCenter.AddFriendInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = null;
  boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  private AVNotifyCenter.AvChatData jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData = this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData;
  Runnable jdField_b_of_type_JavaLangRunnable;
  private String jdField_b_of_type_JavaLangString = null;
  private HashMap<Long, AVPhoneUserInfo> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  Map jdField_b_of_type_JavaUtilMap = new HashMap();
  private ConcurrentHashMap<Long, AVNotifyCenter.GAudioRoomInfo> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  private String jdField_c_of_type_JavaLangString = null;
  private HashMap<String, AVNotifyCenter.AvChatData> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  public Map<String, String> c;
  private ConcurrentHashMap<Long, AVNotifyCenter.GAudioRoomInfo> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  public Map<String, Integer> d;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private Map<String, AVNotifyCenter.VideoRoomInfo> jdField_e_of_type_JavaUtilMap = new HashMap();
  private Map<String, AVNotifyCenter.VideoRoomInfo_tips> jdField_f_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_f_of_type_Boolean = false;
  private Map<String, AVNotifyCenter.VideoRoomInfo_tips> jdField_g_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_g_of_type_Boolean = false;
  
  public AVNotifyCenter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_d_of_type_JavaUtilMap = new ConcurrentHashMap();
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
      this.jdField_a_of_type_MqqOsMqqHandler = new AVNotifyCenter.GAudioHandler(Looper.getMainLooper(), this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new AVNotifyCenter.1(this));
      c();
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setSessionType[");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("], relationId[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], relaitonType[");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("], sessionType[");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append("], isDouble[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.w("AVNotifyCenter", 1, ((StringBuilder)localObject).toString());
    }
    if (paramInt3 == 0)
    {
      c(paramString);
      return;
    }
    Object localObject = a(paramString, true);
    if (localObject != null)
    {
      ((AVNotifyCenter.AvChatData)localObject).jdField_a_of_type_Boolean = paramBoolean;
      ((AVNotifyCenter.AvChatData)localObject).jdField_a_of_type_Int = paramInt3;
      try
      {
        ((AVNotifyCenter.AvChatData)localObject).jdField_a_of_type_Long = Long.parseLong(paramString);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setSessionType, relationId[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.w("AVNotifyCenter", 1, localStringBuilder.toString(), localException);
      }
      ((AVNotifyCenter.AvChatData)localObject).jdField_c_of_type_Int = paramInt2;
    }
  }
  
  private void a(String paramString, AVNotifyCenter.AvChatData paramAvChatData)
  {
    AVNotifyCenter.AvChatData localAvChatData = this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData;
    Object localObject;
    if (this.jdField_c_of_type_JavaUtilHashMap.size() == 1)
    {
      localObject = null;
      paramAvChatData = this.jdField_c_of_type_JavaUtilHashMap.keySet().iterator();
      while (paramAvChatData.hasNext())
      {
        localObject = (String)paramAvChatData.next();
        localObject = (AVNotifyCenter.AvChatData)this.jdField_c_of_type_JavaUtilHashMap.get(localObject);
      }
      if (localObject != null) {
        this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData = ((AVNotifyCenter.AvChatData)localObject);
      } else {
        this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData = this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData;
      }
    }
    else if (this.jdField_c_of_type_JavaUtilHashMap.size() == 0)
    {
      this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData = this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData;
      localObject = paramAvChatData;
    }
    else if (paramAvChatData == null)
    {
      localObject = this.jdField_c_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramAvChatData = (String)((Iterator)localObject).next();
        paramAvChatData = (AVNotifyCenter.AvChatData)this.jdField_c_of_type_JavaUtilHashMap.get(paramAvChatData);
      }
      if (paramAvChatData != null)
      {
        this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData = paramAvChatData;
        localObject = paramAvChatData;
      }
      else
      {
        this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData = this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData;
        localObject = paramAvChatData;
      }
    }
    else if ((paramAvChatData.jdField_d_of_type_Boolean) && (!this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData.jdField_d_of_type_Boolean))
    {
      this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData = paramAvChatData;
      localObject = paramAvChatData;
    }
    else
    {
      localObject = paramAvChatData;
      if (this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData.jdField_a_of_type_Long == 0L)
      {
        localObject = paramAvChatData;
        if (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData.jdField_b_of_type_JavaLangString))
        {
          this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData = paramAvChatData;
          localObject = paramAvChatData;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramAvChatData = new StringBuilder();
      paramAvChatData.append("checkAndUpdateActive, from[");
      paramAvChatData.append(paramString);
      paramAvChatData.append("], data[");
      paramAvChatData.append(localObject);
      paramAvChatData.append("], last[");
      paramAvChatData.append(localAvChatData);
      paramAvChatData.append("], active[");
      paramAvChatData.append(this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData);
      paramAvChatData.append("]");
      QLog.i("AVNotifyCenter", 2, paramAvChatData.toString());
    }
  }
  
  private void c()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("group_video_push_cfg_txt.");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      localStringBuilder.append(".mutex");
      this.jdField_c_of_type_Boolean = localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
    }
  }
  
  public static boolean d()
  {
    return jdField_e_of_type_Boolean;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData.jdField_c_of_type_Int;
  }
  
  public int a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      return ((AVNotifyCenter.AddFriendInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_Int;
    }
    return 3999;
  }
  
  public int a(String paramString)
  {
    paramString = a(paramString, false);
    if (paramString != null) {
      return paramString.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public long a(int paramInt, long paramLong)
  {
    if (paramInt == 2)
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)))
      {
        localGAudioRoomInfo = (AVNotifyCenter.GAudioRoomInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
        break label79;
      }
    }
    else if ((paramInt == 1) && (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))))
    {
      localGAudioRoomInfo = (AVNotifyCenter.GAudioRoomInfo)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      break label79;
    }
    AVNotifyCenter.GAudioRoomInfo localGAudioRoomInfo = null;
    label79:
    if (AudioHelperUtil.a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMultiRoomMemberNum, relationId[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], ");
      localStringBuilder.append(localGAudioRoomInfo);
      QLog.w("AVNotifyCenter", 1, localStringBuilder.toString());
    }
    if (localGAudioRoomInfo != null) {
      return localGAudioRoomInfo.jdField_a_of_type_Long;
    }
    return 0L;
  }
  
  public long a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        AVNotifyCenter.OtherTerChatingRoomInfo localOtherTerChatingRoomInfo = (AVNotifyCenter.OtherTerChatingRoomInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getOtherTerminalAvChattingRoomId roomInfo.mRoomId=");
        localStringBuilder.append(localOtherTerChatingRoomInfo.jdField_a_of_type_Long);
        localStringBuilder.append(", peerUin=");
        localStringBuilder.append(paramString);
        QLog.d("AVNotifyCenter", 1, localStringBuilder.toString());
        long l = localOtherTerChatingRoomInfo.jdField_a_of_type_Long;
        return l;
      }
      return 0L;
    }
  }
  
  public AVNotifyCenter.AvChatData a(String paramString, boolean paramBoolean)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.equals(paramString, "0")))
      {
        if (this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          paramString = (AVNotifyCenter.AvChatData)this.jdField_c_of_type_JavaUtilHashMap.get(paramString);
          return paramString;
        }
        Object localObject;
        if (paramBoolean)
        {
          long l = AudioHelper.b();
          localObject = new AVNotifyCenter.AvChatData(this, "normal", l);
          this.jdField_c_of_type_JavaUtilHashMap.put(paramString, localObject);
          a("getChatSession", (AVNotifyCenter.AvChatData)localObject);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getChatSession, create sessionId[");
          localStringBuilder.append(paramString);
          localStringBuilder.append("], mAvChatDataMap[");
          localStringBuilder.append(this.jdField_c_of_type_JavaUtilHashMap.size());
          localStringBuilder.append("], data[");
          localStringBuilder.append(localObject);
          localStringBuilder.append("], mActiveChatData[");
          localStringBuilder.append(this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData);
          localStringBuilder.append("], seq[");
          localStringBuilder.append(l);
          localStringBuilder.append("]");
          QLog.w("AVNotifyCenter", 1, localStringBuilder.toString());
          paramString = (String)localObject;
          break label279;
        }
        if (AudioHelper.b())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getChatSession, not exist, sessionId[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("]");
          QLog.w("AVNotifyCenter", 1, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        QLog.i("AVNotifyCenter", 1, "getChatSession, illegal session id with zero.");
      }
      paramString = null;
      label279:
      return paramString;
    }
    finally {}
  }
  
  public AVNotifyCenter.UserInfo a(int paramInt, long paramLong)
  {
    if (paramInt == 2)
    {
      Object localObject = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
      if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(Long.valueOf(paramLong))))
      {
        localObject = ((AVNotifyCenter.GAudioRoomInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_JavaUtilVector;
        if ((localObject != null) && (((Vector)localObject).size() > 0)) {
          return (AVNotifyCenter.UserInfo)((Vector)localObject).get(0);
        }
      }
    }
    return null;
  }
  
  public AVNotifyCenter.VideoRoomInfo a(long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(String.valueOf(paramLong));
    ((StringBuilder)localObject1).append(String.valueOf(2));
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(String.valueOf(paramLong));
    ((StringBuilder)localObject2).append(String.valueOf(10));
    Object localObject3 = ((StringBuilder)localObject2).toString();
    localObject2 = (AVNotifyCenter.VideoRoomInfo)this.jdField_e_of_type_JavaUtilMap.get(localObject1);
    localObject3 = (AVNotifyCenter.VideoRoomInfo)this.jdField_e_of_type_JavaUtilMap.get(localObject3);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(String.valueOf(paramLong));
    ((StringBuilder)localObject1).append(String.valueOf(12));
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject1 = (AVNotifyCenter.VideoRoomInfo)this.jdField_e_of_type_JavaUtilMap.get(localObject1);
    int i = b(paramLong);
    if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(1, paramLong)))
    {
      if (i != 12) {
        localObject1 = null;
      }
      if (i == 2) {
        localObject1 = localObject2;
      }
      if (i != 10) {
        break label280;
      }
    }
    else
    {
      if ((localObject1 == null) || (((AVNotifyCenter.VideoRoomInfo)localObject1).jdField_a_of_type_Int <= 0)) {
        localObject1 = null;
      }
      if ((localObject2 == null) || (((AVNotifyCenter.VideoRoomInfo)localObject2).jdField_a_of_type_Int <= 0)) {
        localObject2 = localObject1;
      }
      localObject1 = localObject2;
      if (localObject3 == null) {
        break label280;
      }
      localObject1 = localObject2;
      if (((AVNotifyCenter.VideoRoomInfo)localObject3).jdField_a_of_type_Int <= 0) {
        break label280;
      }
    }
    localObject1 = localObject3;
    label280:
    if (AudioHelper.b())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getChoosedRoom, groupid[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("], avtype[");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("], VideoRoomInfo[");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("]");
      QLog.w("AVNotifyCenter", 1, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public AVNotifyCenter.VideoRoomInfo a(long paramLong, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.valueOf(paramLong));
    ((StringBuilder)localObject).append(String.valueOf(paramInt));
    localObject = ((StringBuilder)localObject).toString();
    return (AVNotifyCenter.VideoRoomInfo)this.jdField_e_of_type_JavaUtilMap.get(localObject);
  }
  
  public AVNotifyCenter.VideoRoomInfo_tips a(long paramLong, int paramInt)
  {
    Object localObject = String.valueOf(paramLong);
    if (paramInt == 2) {
      localObject = (AVNotifyCenter.VideoRoomInfo_tips)this.jdField_f_of_type_JavaUtilMap.get(localObject);
    } else if (paramInt == 1) {
      localObject = (AVNotifyCenter.VideoRoomInfo_tips)this.jdField_g_of_type_JavaUtilMap.get(localObject);
    } else {
      localObject = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTipsRoomInfo, relationId[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], relationType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], infos[");
      localStringBuilder.append(localObject);
      localStringBuilder.append("]");
      QLog.w("AVNotifyCenter", 1, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String a(long paramLong)
  {
    if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
    {
      String str1 = ((AVPhoneUserInfo)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong))).telInfo.mobile;
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
        AVNotifyCenter.RandomInfo localRandomInfo = (AVNotifyCenter.RandomInfo)localIterator.next();
        if (paramString.equals(localRandomInfo.jdField_a_of_type_JavaLangString)) {
          return localRandomInfo.jdField_b_of_type_JavaLangString;
        }
      }
    }
    return "";
  }
  
  public Map a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public Vector<AVNotifyCenter.UserInfo> a(int paramInt, long paramLong)
  {
    if (paramInt == 2)
    {
      Object localObject = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
      if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(Long.valueOf(paramLong))))
      {
        localObject = ((AVNotifyCenter.GAudioRoomInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_JavaUtilVector;
        if ((localObject != null) && (((Vector)localObject).size() > 0)) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public Vector<AVNotifyCenter.UserInfo> a(long paramLong)
  {
    Object localObject = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
    if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(Long.valueOf(paramLong))))
    {
      localObject = (AVNotifyCenter.GAudioRoomInfo)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = ((AVNotifyCenter.GAudioRoomInfo)localObject).jdField_a_of_type_JavaUtilVector;
        if (localObject != null) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    PhoneStatusMonitor localPhoneStatusMonitor = this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor;
    if (localPhoneStatusMonitor != null)
    {
      localPhoneStatusMonitor.b();
      this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    if (this.jdField_c_of_type_Int == 0)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (localArrayList != null)
      {
        localArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList = null;
      }
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setMultiRoomMember[");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append("], relationType[");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append("], relationId[");
    ((StringBuilder)localObject1).append(paramLong1);
    ((StringBuilder)localObject1).append("], memberList[");
    ((StringBuilder)localObject1).append(Arrays.toString(paramArrayOfLong));
    ((StringBuilder)localObject1).append("], roomUserNum[");
    ((StringBuilder)localObject1).append(paramLong2);
    ((StringBuilder)localObject1).append("]");
    QLog.w("AVNotifyCenter", 1, ((StringBuilder)localObject1).toString());
    int i = 0;
    paramInt1 = 0;
    Object localObject2;
    if (paramInt2 == 2)
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
      }
      if (paramLong2 != 0L)
      {
        if (paramArrayOfLong == null) {
          return;
        }
        localObject1 = new Vector();
        paramInt2 = paramArrayOfLong.length;
        while (paramInt1 < paramInt2)
        {
          localObject2 = new AVNotifyCenter.UserInfo(this);
          ((AVNotifyCenter.UserInfo)localObject2).jdField_a_of_type_Long = paramArrayOfLong[paramInt1];
          ((Vector)localObject1).add(localObject2);
          paramInt1 += 1;
        }
        paramArrayOfLong = new AVNotifyCenter.GAudioRoomInfo(this);
        paramArrayOfLong.jdField_a_of_type_Long = paramLong2;
        paramArrayOfLong.jdField_a_of_type_JavaUtilVector = ((Vector)localObject1);
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), paramArrayOfLong);
        return;
      }
      return;
    }
    if (paramInt2 == 1)
    {
      if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
      }
      if (paramLong2 == 0L) {
        return;
      }
      localObject1 = new AVNotifyCenter.GAudioRoomInfo(this);
      ((AVNotifyCenter.GAudioRoomInfo)localObject1).jdField_a_of_type_Long = paramLong2;
      ((AVNotifyCenter.GAudioRoomInfo)localObject1).jdField_a_of_type_JavaUtilVector = null;
      if (paramArrayOfLong != null)
      {
        localObject2 = new Vector();
        paramInt1 = i;
        while (paramInt1 < paramArrayOfLong.length)
        {
          AVNotifyCenter.UserInfo localUserInfo = new AVNotifyCenter.UserInfo(this);
          localUserInfo.jdField_a_of_type_Long = paramArrayOfLong[paramInt1];
          ((Vector)localObject2).add(localUserInfo);
          paramInt1 += 1;
        }
        ((AVNotifyCenter.GAudioRoomInfo)localObject1).jdField_a_of_type_JavaUtilVector = ((Vector)localObject2);
      }
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), localObject1);
    }
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onSelfEnterRoom, relationType[");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("], relationId[");
    ((StringBuilder)localObject1).append(paramLong);
    Object localObject2 = ((StringBuilder)localObject1).toString();
    if (paramInt == 2)
    {
      localObject1 = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
    }
    else
    {
      if (paramInt != 1) {
        return;
      }
      localObject1 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
    }
    long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
    Object localObject3 = (AVNotifyCenter.GAudioRoomInfo)((ConcurrentHashMap)localObject1).get(Long.valueOf(paramLong));
    Object localObject4;
    if (localObject3 != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("], containsKey[true");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject4 = ((AVNotifyCenter.GAudioRoomInfo)localObject3).jdField_a_of_type_JavaUtilVector;
      boolean bool2 = false;
      paramInt = 0;
      boolean bool1 = bool2;
      if (localObject4 != null)
      {
        bool1 = bool2;
        if (((Vector)localObject4).size() > 0)
        {
          int i = ((Vector)localObject4).size();
          bool1 = false;
          while (paramInt < i)
          {
            if (l == ((AVNotifyCenter.UserInfo)((Vector)localObject4).elementAt(paramInt)).jdField_a_of_type_Long) {
              bool1 = true;
            }
            paramInt += 1;
          }
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("], exist[");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append("], last[");
      ((StringBuilder)localObject2).append(localObject3);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = localObject2;
      if (localObject4 != null)
      {
        localObject1 = localObject2;
        if (!bool1)
        {
          localObject1 = new AVNotifyCenter.UserInfo(this);
          ((AVNotifyCenter.UserInfo)localObject1).jdField_a_of_type_Long = l;
          ((Vector)localObject4).add(localObject1);
          ((AVNotifyCenter.GAudioRoomInfo)localObject3).jdField_a_of_type_Long += 1L;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("], cur[");
          ((StringBuilder)localObject1).append(localObject3);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
    }
    else
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("], containsKey[false");
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject4 = new Vector();
      localObject3 = new AVNotifyCenter.UserInfo(this);
      ((AVNotifyCenter.UserInfo)localObject3).jdField_a_of_type_Long = l;
      ((Vector)localObject4).add(localObject3);
      localObject3 = new AVNotifyCenter.GAudioRoomInfo(this);
      ((AVNotifyCenter.GAudioRoomInfo)localObject3).jdField_a_of_type_Long = 1L;
      ((AVNotifyCenter.GAudioRoomInfo)localObject3).jdField_a_of_type_JavaUtilVector = ((Vector)localObject4);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append("], cur[");
      ((StringBuilder)localObject4).append(localObject3);
      localObject2 = ((StringBuilder)localObject4).toString();
      ((ConcurrentHashMap)localObject1).put(Long.valueOf(paramLong), localObject3);
      localObject1 = localObject2;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("], timeRoomCreateTime[");
    ((StringBuilder)localObject2).append(this.jdField_b_of_type_Long);
    ((StringBuilder)localObject2).append("]");
    QLog.w("AVNotifyCenter", 1, ((StringBuilder)localObject2).toString());
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onSelfLeaveRoom, relationId[");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append("], relationType[");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append("], avtype[");
    ((StringBuilder)localObject1).append(paramInt2);
    String str1 = ((StringBuilder)localObject1).toString();
    int i;
    if (paramInt1 == 2)
    {
      localObject2 = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
      i = 3000;
    }
    else
    {
      if (paramInt1 != 1) {
        return;
      }
      localObject2 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
      i = 1;
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    long l = Long.valueOf(str2).longValue();
    localObject1 = str1;
    if (((ConcurrentHashMap)localObject2).containsKey(Long.valueOf(paramLong)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append("], containsKey[true");
      str1 = ((StringBuilder)localObject1).toString();
      localObject1 = (AVNotifyCenter.GAudioRoomInfo)((ConcurrentHashMap)localObject2).get(Long.valueOf(paramLong));
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(str1);
      ((StringBuilder)localObject3).append("], last[");
      ((StringBuilder)localObject3).append(localObject1);
      str1 = ((StringBuilder)localObject3).toString();
      localObject3 = ((AVNotifyCenter.GAudioRoomInfo)localObject1).jdField_a_of_type_JavaUtilVector;
      ((AVNotifyCenter.GAudioRoomInfo)localObject1).jdField_a_of_type_Long -= 1L;
      if (((AVNotifyCenter.GAudioRoomInfo)localObject1).jdField_a_of_type_Long == 0L)
      {
        ((ConcurrentHashMap)localObject2).remove(Long.valueOf(paramLong));
        localObject1 = Long.toString(paramLong);
        if (paramInt1 == 2) {
          VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 14, false, (String)localObject1, str2, false, null, false, new Object[] { new Integer(paramInt2) });
        } else {
          VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 14, false, (String)localObject1, str2, false, null, false, paramInt2, new Object[] { new Integer(paramInt2) });
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append("], delete[true");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        if ((localObject3 != null) && (((Vector)localObject3).size() > 0))
        {
          paramInt2 = ((Vector)localObject3).size();
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            if (l == ((AVNotifyCenter.UserInfo)((Vector)localObject3).elementAt(paramInt1)).jdField_a_of_type_Long)
            {
              ((Vector)localObject3).remove(paramInt1);
              break;
            }
            paramInt1 += 1;
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append("], cur[");
        ((StringBuilder)localObject2).append(localObject1);
        localObject1 = ((StringBuilder)localObject2).toString();
      }
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    QLog.w("AVNotifyCenter", 1, ((StringBuilder)localObject2).toString());
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    a(paramInt1, paramLong, paramInt2, paramInt3, paramInt4, -1, paramInt5, paramInt6);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).g(String.valueOf(paramLong)))
    {
      b(paramLong);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setVideoRoomInfo, but group is exited, groupid: ");
        ((StringBuilder)localObject1).append(paramLong);
        QLog.d("AVNotifyCenter", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    Object localObject1 = new AVNotifyCenter.VideoRoomInfo(this);
    ((AVNotifyCenter.VideoRoomInfo)localObject1).jdField_b_of_type_Long = paramLong;
    ((AVNotifyCenter.VideoRoomInfo)localObject1).jdField_b_of_type_Int = paramInt2;
    ((AVNotifyCenter.VideoRoomInfo)localObject1).f = paramInt6;
    ((AVNotifyCenter.VideoRoomInfo)localObject1).jdField_d_of_type_Int = paramInt3;
    ((AVNotifyCenter.VideoRoomInfo)localObject1).jdField_e_of_type_Int = paramInt4;
    ((AVNotifyCenter.VideoRoomInfo)localObject1).jdField_c_of_type_Int = paramInt5;
    ((AVNotifyCenter.VideoRoomInfo)localObject1).jdField_a_of_type_Int = paramInt7;
    ((AVNotifyCenter.VideoRoomInfo)localObject1).jdField_c_of_type_Long = System.currentTimeMillis();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(String.valueOf(paramLong));
    ((StringBuilder)localObject2).append(String.valueOf(paramInt2));
    Object localObject3 = ((StringBuilder)localObject2).toString();
    localObject2 = (AVNotifyCenter.VideoRoomInfo)this.jdField_e_of_type_JavaUtilMap.get(localObject3);
    this.jdField_e_of_type_JavaUtilMap.put(localObject3, localObject1);
    if (AudioHelper.b())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("setVideoRoomInfo[");
      ((StringBuilder)localObject3).append(paramInt1);
      ((StringBuilder)localObject3).append("], \nOld[");
      ((StringBuilder)localObject3).append(localObject2);
      ((StringBuilder)localObject3).append("], \nNew[");
      ((StringBuilder)localObject3).append(localObject1);
      ((StringBuilder)localObject3).append("]");
      QLog.w("AVNotifyCenter", 1, ((StringBuilder)localObject3).toString());
    }
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, String.valueOf(paramLong), paramBoolean1, paramBoolean2);
  }
  
  public void a(int paramInt, long paramLong, long[] paramArrayOfLong)
  {
    ConcurrentHashMap localConcurrentHashMap;
    if (paramInt == 2)
    {
      localConcurrentHashMap = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
    }
    else
    {
      if (paramInt != 1) {
        return;
      }
      localConcurrentHashMap = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
    }
    if (AudioHelper.b())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setMultiRoomMember, relationType[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], relationId[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], roomInfos[");
      ((StringBuilder)localObject).append(localConcurrentHashMap.size());
      ((StringBuilder)localObject).append("], memberList[");
      ((StringBuilder)localObject).append(paramArrayOfLong.length);
      ((StringBuilder)localObject).append("]");
      QLog.w("AVNotifyCenter", 1, ((StringBuilder)localObject).toString());
    }
    if (localConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      localConcurrentHashMap.remove(Long.valueOf(paramLong));
    }
    Object localObject = new Vector();
    int j = paramArrayOfLong.length;
    paramInt = 0;
    int i = 0;
    while (paramInt < j)
    {
      AVNotifyCenter.UserInfo localUserInfo = new AVNotifyCenter.UserInfo(this);
      localUserInfo.jdField_a_of_type_Long = paramArrayOfLong[paramInt];
      ((Vector)localObject).add(localUserInfo);
      i += 1;
      paramInt += 1;
    }
    paramArrayOfLong = new AVNotifyCenter.GAudioRoomInfo(this);
    paramArrayOfLong.jdField_a_of_type_Long = i;
    paramArrayOfLong.jdField_a_of_type_JavaUtilVector = ((Vector)localObject);
    localConcurrentHashMap.put(Long.valueOf(paramLong), paramArrayOfLong);
  }
  
  public void a(int paramInt, long paramLong1, long[] paramArrayOfLong, int[] paramArrayOfInt, long paramLong2)
  {
    Object localObject1;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setMultiRoomMember, relationId[");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append("], relationType[");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("], states[");
      ((StringBuilder)localObject1).append(paramArrayOfInt);
      ((StringBuilder)localObject1).append("], roomUserNum[");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append("], memberList[");
      if (paramArrayOfLong != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append("]");
      QLog.w("AVNotifyCenter", 1, ((StringBuilder)localObject1).toString());
    }
    int i;
    Object localObject2;
    if (paramInt == 2)
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
      }
      if ((paramLong2 != 0L) && (paramArrayOfLong != null) && (paramArrayOfInt != null))
      {
        if (paramArrayOfLong.length != paramArrayOfInt.length) {
          return;
        }
        localObject1 = new Vector();
        i = paramArrayOfLong.length;
        localObject2 = new ArrayList();
        paramInt = 0;
        while (paramInt < i)
        {
          AVNotifyCenter.UserInfo localUserInfo = new AVNotifyCenter.UserInfo(this);
          localUserInfo.jdField_a_of_type_Long = paramArrayOfLong[paramInt];
          if (paramArrayOfInt[paramInt] == 1) {
            bool = true;
          } else {
            bool = false;
          }
          localUserInfo.jdField_a_of_type_Boolean = bool;
          if ((localUserInfo.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(Long.valueOf(localUserInfo.jdField_a_of_type_Long)))) {
            ((ArrayList)localObject2).add(Long.valueOf(localUserInfo.jdField_a_of_type_Long));
          }
          ((Vector)localObject1).add(localUserInfo);
          paramInt += 1;
        }
        a((ArrayList)localObject2);
        paramArrayOfLong = new AVNotifyCenter.GAudioRoomInfo(this);
        paramArrayOfLong.jdField_a_of_type_Long = paramLong2;
        paramArrayOfLong.jdField_a_of_type_JavaUtilVector = ((Vector)localObject1);
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), paramArrayOfLong);
        return;
      }
      return;
    }
    if (paramInt == 1)
    {
      if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
      }
      if (paramLong2 == 0L) {
        return;
      }
      localObject1 = new Vector();
      if (paramArrayOfLong != null)
      {
        i = paramArrayOfLong.length;
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = new AVNotifyCenter.UserInfo(this);
          ((AVNotifyCenter.UserInfo)localObject2).jdField_a_of_type_Long = paramArrayOfLong[paramInt];
          if (paramArrayOfInt[paramInt] == 1) {
            bool = true;
          } else {
            bool = false;
          }
          ((AVNotifyCenter.UserInfo)localObject2).jdField_a_of_type_Boolean = bool;
          ((Vector)localObject1).add(localObject2);
          paramInt += 1;
        }
      }
      paramArrayOfLong = new AVNotifyCenter.GAudioRoomInfo(this);
      paramArrayOfLong.jdField_a_of_type_Long = paramLong2;
      paramArrayOfLong.jdField_a_of_type_JavaUtilVector = ((Vector)localObject1);
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), paramArrayOfLong);
    }
  }
  
  public void a(int paramInt, Long paramLong, boolean paramBoolean)
  {
    if (AudioHelper.b())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setChating, relationType[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], relationId[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], isChating[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], mActiveChatData[");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData);
      ((StringBuilder)localObject).append("]");
      QLog.w("AVNotifyCenter", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = String.valueOf(paramLong);
    if (paramBoolean)
    {
      localObject = a((String)localObject, true);
      if (localObject == null)
      {
        if (AudioHelper.b()) {
          QLog.w("AVNotifyCenter", 1, "setChating, data is null");
        }
        return;
      }
      ((AVNotifyCenter.AvChatData)localObject).jdField_a_of_type_Boolean = false;
      ((AVNotifyCenter.AvChatData)localObject).jdField_a_of_type_Long = paramLong.longValue();
      ((AVNotifyCenter.AvChatData)localObject).jdField_c_of_type_Int = paramInt;
      if (((AVNotifyCenter.AvChatData)localObject).jdField_c_of_type_Int == 1) {
        ((AVNotifyCenter.AvChatData)localObject).jdField_b_of_type_Int = 1;
      } else if (((AVNotifyCenter.AvChatData)localObject).jdField_c_of_type_Int == 2) {
        ((AVNotifyCenter.AvChatData)localObject).jdField_b_of_type_Int = 3000;
      } else if (((AVNotifyCenter.AvChatData)localObject).jdField_c_of_type_Int == 3) {
        ((AVNotifyCenter.AvChatData)localObject).jdField_b_of_type_Int = 0;
      }
      ((AVNotifyCenter.AvChatData)localObject).jdField_d_of_type_Boolean = paramBoolean;
      if ((((AVNotifyCenter.AvChatData)localObject).jdField_d_of_type_Boolean) && (this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData != localObject)) {
        a("setChating.1", (AVNotifyCenter.AvChatData)localObject);
      }
      if (AudioHelper.b())
      {
        paramLong = new StringBuilder();
        paramLong.append("setChating, end, data[");
        paramLong.append(localObject);
        paramLong.append("], mActiveChatData[");
        paramLong.append(this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData);
        paramLong.append("]");
        QLog.w("AVNotifyCenter", 1, paramLong.toString());
      }
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a(paramInt1, 0, paramString, paramInt2, true);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    AVNotifyCenter.AvChatData localAvChatData = a(paramString1, false);
    if (localAvChatData != null)
    {
      localAvChatData.jdField_a_of_type_Boolean = true;
      localAvChatData.jdField_b_of_type_Int = paramInt;
      localAvChatData.jdField_b_of_type_JavaLangString = paramString1;
      localAvChatData.jdField_c_of_type_JavaLangString = paramString2;
      localAvChatData.jdField_b_of_type_Boolean = paramBoolean;
      localAvChatData.jdField_c_of_type_Int = 0;
      localAvChatData.jdField_a_of_type_Long = AVUtil.a(paramString1);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setChating, uinType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], peerUin[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("], extraUin[");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("], isReceiver[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], AvChatData[");
    localStringBuilder.append(localAvChatData);
    localStringBuilder.append("], mActiveChatData[");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData);
    localStringBuilder.append("]");
    QLog.w("AVNotifyCenter", 1, localStringBuilder.toString());
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AVNotifyCenter.AvChatData localAvChatData = a(paramString, false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setWaittingState, sessionId[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], relationType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], IsWaitting[");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("], isReceiver[");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append("], AvChatData[");
    localStringBuilder.append(localAvChatData);
    localStringBuilder.append("]");
    QLog.w("AVNotifyCenter", 1, localStringBuilder.toString());
    if (localAvChatData != null)
    {
      localAvChatData.jdField_c_of_type_Boolean = paramBoolean1;
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          localAvChatData.jdField_d_of_type_Boolean = false;
        } else {
          localAvChatData.jdField_d_of_type_Boolean = true;
        }
      }
      else {
        localAvChatData.jdField_d_of_type_Boolean = true;
      }
      if ((localAvChatData.jdField_d_of_type_Boolean) && (localAvChatData != this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData)) {
        a("setWaittingState", localAvChatData);
      }
      paramString = new StringBuilder();
      paramString.append("setWaittingState, end, AvChatData[");
      paramString.append(localAvChatData);
      paramString.append("]");
      QLog.w("AVNotifyCenter", 1, paramString.toString());
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeTipsInfo: ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("relationType:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AVNotifyCenter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = String.valueOf(paramLong);
    if (paramInt == 2)
    {
      this.jdField_f_of_type_JavaUtilMap.remove(localObject);
      return;
    }
    if (paramInt == 1) {
      this.jdField_g_of_type_JavaUtilMap.remove(localObject);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject2 = (String)this.jdField_c_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    String str = "0;0";
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "0;0";
    }
    Object localObject3 = str;
    if (paramInt2 > 0)
    {
      localObject2 = null;
      int i = 0;
      if (paramInt1 == 2) {}
      for (localObject2 = a(paramLong, 10);; localObject2 = a(paramLong, 2))
      {
        i = 1;
        break;
        if (paramInt1 != 10) {
          break;
        }
      }
      if (localObject2 != null)
      {
        localObject3 = str;
        if (((AVNotifyCenter.VideoRoomInfo)localObject2).jdField_a_of_type_Int <= 0) {
          break label164;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("1;");
        ((StringBuilder)localObject1).append(((AVNotifyCenter.VideoRoomInfo)localObject2).jdField_a_of_type_Int + paramInt2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else if (i != 0)
      {
        localObject3 = str;
        break label164;
      }
      localObject3 = localObject1;
    }
    label164:
    this.jdField_c_of_type_JavaUtilMap.put(String.valueOf(paramLong), localObject3);
    if (AudioHelper.b())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setMultiBarFlagInfo, groupId[");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append("], avtype[");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("], memberNum[");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append("], old[");
      ((StringBuilder)localObject1).append((String)localObject3);
      ((StringBuilder)localObject1).append("], new[");
      ((StringBuilder)localObject1).append((String)localObject3);
      ((StringBuilder)localObject1).append("]");
      QLog.w("AVNotifyCenter", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = null;
    Object localObject = null;
    AVNotifyCenter.VideoRoomInfo_tips localVideoRoomInfo_tips = null;
    if (paramInt1 == 2)
    {
      localObject = localVideoRoomInfo_tips;
      if (this.jdField_f_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
        localObject = (AVNotifyCenter.VideoRoomInfo_tips)this.jdField_f_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      }
      localVideoRoomInfo_tips = new AVNotifyCenter.VideoRoomInfo_tips(this);
      localVideoRoomInfo_tips.jdField_a_of_type_Long = paramLong;
      localVideoRoomInfo_tips.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_f_of_type_JavaUtilMap.put(String.valueOf(paramLong), localVideoRoomInfo_tips);
    }
    else if (paramInt1 == 1)
    {
      localObject = localStringBuilder;
      if (this.jdField_g_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
        localObject = (AVNotifyCenter.VideoRoomInfo_tips)this.jdField_g_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      }
      localVideoRoomInfo_tips = new AVNotifyCenter.VideoRoomInfo_tips(this);
      localVideoRoomInfo_tips.jdField_a_of_type_Long = paramLong;
      localVideoRoomInfo_tips.jdField_a_of_type_Boolean = paramBoolean;
      localVideoRoomInfo_tips.jdField_a_of_type_Int = paramInt2;
      this.jdField_g_of_type_JavaUtilMap.put(String.valueOf(paramLong), localVideoRoomInfo_tips);
    }
    else
    {
      localVideoRoomInfo_tips = null;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTipsRoomInfo, relationId[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], relationType[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], old[");
      localStringBuilder.append(localObject);
      localStringBuilder.append("], new[");
      localStringBuilder.append(localVideoRoomInfo_tips);
      localStringBuilder.append("]");
      QLog.w("AVNotifyCenter", 1, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setTipsRoomInfo relationId:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("relationType:");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("AVNotifyCenter", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if ((AudioHelper.b()) || (paramBoolean != this.jdField_d_of_type_Boolean))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVideoRequestStatus, isVideoRequest[");
      localStringBuilder.append(this.jdField_d_of_type_Boolean);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("AVNotifyCenter", 1, localStringBuilder.toString());
    }
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  @TargetApi(11)
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 11) {
      return;
    }
    String str1 = String.valueOf(paramLong);
    Object localObject2 = new HashSet();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ADD_FRIEND_DIALOG");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    String str2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (localSharedPreferences.contains(str2)) {
      localObject1 = localSharedPreferences.getStringSet(str2, (Set)localObject2);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setAddFriendNotifyMaps-->uin=");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append(" bNotify=");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(" srcId=");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" size=");
      ((StringBuilder)localObject2).append(((Set)localObject1).size());
      ((StringBuilder)localObject2).append(" info=");
      ((StringBuilder)localObject2).append(localObject1.toString());
      QLog.d("AVNotifyCenter", 2, ((StringBuilder)localObject2).toString());
    }
    if (((Set)localObject1).size() >= 3) {
      return;
    }
    if (((Set)localObject1).contains(str1)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
    }
    if (!paramBoolean)
    {
      ((Set)localObject1).add(str1);
      localSharedPreferences.edit().putStringSet(str2, (Set)localObject1).commit();
      return;
    }
    localObject1 = new AVNotifyCenter.AddFriendInfo();
    ((AVNotifyCenter.AddFriendInfo)localObject1).jdField_a_of_type_Int = paramInt;
    ((AVNotifyCenter.AddFriendInfo)localObject1).jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), localObject1);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    SharedPreUtils.b(paramQQAppInterface.getApplication(), paramInt, paramQQAppInterface.getAccount());
    Object localObject1 = BaseApplication.getContext();
    boolean bool = false;
    localObject1 = ((BaseApplication)localObject1).getSharedPreferences("mobileQQ", 0).edit();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("group_video_push_cfg_txt.");
    ((StringBuilder)localObject2).append(paramQQAppInterface.getAccount());
    ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject2).toString(), paramString).commit();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).getJSONObject("mav");
        if (paramString != null)
        {
          localObject2 = paramString.getJSONObject("relationType1");
          if (localObject2 != null)
          {
            if (((JSONObject)localObject2).getInt("mutex") != 0) {
              break label383;
            }
            this.jdField_c_of_type_Boolean = bool;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("group_video_push_cfg_txt.");
            ((StringBuilder)localObject2).append(paramQQAppInterface.getAccount());
            ((StringBuilder)localObject2).append(".mutex");
            ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject2).toString(), this.jdField_c_of_type_Boolean);
          }
          paramString = paramString.getJSONObject("noiseCtrl");
          if (paramString != null)
          {
            paramInt = paramString.getInt("level");
            int i = paramString.getInt("sendDura");
            int j = paramString.getInt("validDura");
            paramString = new StringBuilder();
            paramString.append("group_video_push_cfg_txt.");
            paramString.append(paramQQAppInterface.getAccount());
            paramString.append(".level");
            ((SharedPreferences.Editor)localObject1).putInt(paramString.toString(), paramInt);
            paramString = new StringBuilder();
            paramString.append("group_video_push_cfg_txt.");
            paramString.append(paramQQAppInterface.getAccount());
            paramString.append(".sendDura");
            ((SharedPreferences.Editor)localObject1).putInt(paramString.toString(), i);
            paramString = new StringBuilder();
            paramString.append("group_video_push_cfg_txt.");
            paramString.append(paramQQAppInterface.getAccount());
            paramString.append(".validDura");
            ((SharedPreferences.Editor)localObject1).putInt(paramString.toString(), j);
          }
          ((SharedPreferences.Editor)localObject1).commit();
          return;
        }
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      return;
      label383:
      bool = true;
    }
  }
  
  public void a(String paramString)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("removeOtherTerminalAvChating peerUin = ");
    ((StringBuilder)???).append(paramString);
    QLog.d("AVNotifyCenter", 1, ((StringBuilder)???).toString());
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        QLog.d("AVNotifyCenter", 1, "removeOtherTerminalAvChating remove true");
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      }
      return;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_d_of_type_JavaUtilMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addOtherTerminalAvChating peerUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",roomid = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",sessionType = ");
      localStringBuilder.append(paramInt);
      QLog.d("AVNotifyCenter", 1, localStringBuilder.toString());
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, new AVNotifyCenter.OtherTerChatingRoomInfo(this, paramLong, paramInt));
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new AVNotifyCenter.RandomInfo(paramString1, paramString2, paramString3));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDoubleVideoMeetingFlag-->isDoubleVideoMeeting = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("AVNotifyCenter", 2, localStringBuilder.toString());
    }
    paramString = a(paramString, false);
    if (paramString != null) {
      paramString.jdField_e_of_type_Boolean = paramBoolean;
    }
  }
  
  void a(ArrayList<Long> paramArrayList)
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
      label46:
      break label46;
    }
    QLog.e("AVNotifyCenter", 2, "getOpenIdFromTinyId --> StartServlet Error");
  }
  
  public void a(submsgtype0x126.MsgBody paramMsgBody)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramMsgBody != null)
    {
      if (localQQAppInterface == null) {
        return;
      }
      boolean bool2 = false;
      boolean bool1 = false;
      long l = paramMsgBody.uint64_msg_seq.get();
      int i = paramMsgBody.uint32_msg_type.get();
      Object localObject2 = null;
      Object localObject1 = "avChatRoom";
      if (i == 2)
      {
        if (paramMsgBody.str_msg_info.has()) {
          paramMsgBody = paramMsgBody.str_msg_info.get().toByteArray();
        } else {
          paramMsgBody = null;
        }
      }
      else if (i == 4)
      {
        if (paramMsgBody.bytes_ext_info.has()) {
          paramMsgBody = paramMsgBody.bytes_ext_info.get().toByteArray();
        } else {
          paramMsgBody = null;
        }
        localObject1 = "avWatchTogether";
      }
      else if (i == 5)
      {
        if (paramMsgBody.bytes_ext_info.has()) {
          paramMsgBody = paramMsgBody.str_msg_info.get().toByteArray();
        } else {
          paramMsgBody = null;
        }
        localObject1 = "avScreenShareAsk";
      }
      else if (i == 6)
      {
        if (paramMsgBody.bytes_ext_info.has()) {
          paramMsgBody = paramMsgBody.str_msg_info.get().toByteArray();
        } else {
          paramMsgBody = null;
        }
        localObject1 = "avScreenShareAnswer";
      }
      else
      {
        paramMsgBody = null;
        localObject1 = paramMsgBody;
      }
      if ((paramMsgBody != null) && (paramMsgBody.length > 0))
      {
        if (localQQAppInterface.mQQServiceRef != null) {
          localObject2 = (QQServiceForAV)localQQAppInterface.mQQServiceRef.get();
        }
        if (localObject2 != null) {
          bool1 = ((QQServiceForAV)localObject2).a((String)localObject1, i, paramMsgBody);
        }
        if (!bool1)
        {
          localObject2 = new Intent("tencent.video.q2v.avReceivePushMsg");
          ((Intent)localObject2).putExtra("msg_key", (String)localObject1);
          ((Intent)localObject2).putExtra("msg_seq", l);
          ((Intent)localObject2).putExtra("msg_type", i);
          ((Intent)localObject2).putExtra("msg_content", paramMsgBody);
          localQQAppInterface.getApp().sendBroadcast((Intent)localObject2);
          paramMsgBody = "useBroadcast";
        }
        else
        {
          paramMsgBody = "useQQServiceForAV";
        }
      }
      else
      {
        paramMsgBody = "";
        bool1 = bool2;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("processQavPush ret[");
        ((StringBuilder)localObject1).append(bool1);
        ((StringBuilder)localObject1).append("], tag[");
        ((StringBuilder)localObject1).append(paramMsgBody);
        ((StringBuilder)localObject1).append("]");
        QLog.i("AVNotifyCenter", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    jdField_e_of_type_Boolean = paramBoolean;
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
    PhoneStatusMonitor localPhoneStatusMonitor = this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor;
    if (localPhoneStatusMonitor != null) {
      return localPhoneStatusMonitor.a();
    }
    return false;
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return a(AudioHelper.b(), String.valueOf(paramLong));
  }
  
  public boolean a(int paramInt1, long paramLong, int paramInt2)
  {
    if (paramInt1 == 2) {
      return a(paramInt1, paramLong);
    }
    paramInt1 = b(paramLong);
    if (paramInt1 < 0) {
      return false;
    }
    AVNotifyCenter.AvChatData localAvChatData = a(String.valueOf(paramLong), false);
    if ((localAvChatData != null) && (paramInt2 == paramInt1)) {
      return localAvChatData.jdField_d_of_type_Boolean;
    }
    return false;
  }
  
  @TargetApi(11)
  public boolean a(long paramLong)
  {
    if (Build.VERSION.SDK_INT < 11) {
      return false;
    }
    HashSet localHashSet = new HashSet();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ADD_FRIEND_DIALOG");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    String str = ((StringBuilder)localObject).toString();
    localObject = localHashSet;
    if (localSharedPreferences.contains(str)) {
      localObject = localSharedPreferences.getStringSet(str, localHashSet);
    }
    if (((Set)localObject).size() >= 3) {
      return false;
    }
    if (((Set)localObject).contains(String.valueOf(paramLong))) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong));
  }
  
  public boolean a(long paramLong, String paramString)
  {
    AVNotifyCenter.AvChatData localAvChatData = a(paramString, false);
    if (AudioHelper.b())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isChating, discussId[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], AvChatData[");
      localStringBuilder.append(localAvChatData);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("AVNotifyCenter", 1, localStringBuilder.toString());
    }
    if (localAvChatData != null) {
      return localAvChatData.jdField_d_of_type_Boolean;
    }
    return false;
  }
  
  public boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    if (paramContext == null) {
      return false;
    }
    boolean bool1;
    boolean bool2;
    if (paramInt2 == 1)
    {
      bool1 = a(1L, paramString);
    }
    else if (paramInt2 == 3000)
    {
      bool1 = a(2L, paramString);
    }
    else
    {
      bool2 = a(3L, paramString);
      bool1 = bool2;
      if (!bool2) {
        bool1 = a(100L, paramString);
      }
    }
    if (!bool1) {
      bool2 = "一起派对".equals(AVBizModuleFactory.a("音视频通话").b());
    } else {
      bool2 = false;
    }
    if (bool2)
    {
      int i = paramContext.getResources().getDimensionPixelSize(2131299168);
      QQToast.a(paramContext, String.format(paramContext.getString(2131690259), new Object[] { "一起派对" }), 1).b(i);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("checkBlockAVChat, avEnterType[");
      paramContext.append(paramInt1);
      paramContext.append("], uinType[");
      paramContext.append(paramInt2);
      paramContext.append("], uin[");
      paramContext.append(paramString);
      paramContext.append("], isChatting[");
      paramContext.append(bool1);
      paramContext.append("], block[");
      paramContext.append(bool2);
      paramContext.append("]");
      QLog.i("AVNotifyCenter", 2, paramContext.toString());
    }
    return bool2;
  }
  
  public boolean a(Context paramContext, int paramInt, String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramContext == null) {
      return false;
    }
    int j = UITools.b(paramInt);
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
    i = paramInt;
    if (paramInt < 0)
    {
      AVNotifyCenter.VideoRoomInfo localVideoRoomInfo = a(l, 2);
      paramString = localVideoRoomInfo;
      if (localVideoRoomInfo == null) {
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
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("checkBlockTroopAVChat, relationType[");
      paramString.append(j);
      paramString.append("], relationId[");
      paramString.append(l);
      paramString.append("], ret[");
      paramString.append(i);
      paramString.append("]");
      QLog.i("AVNotifyCenter", 2, paramString.toString());
    }
    if (i > 0) {
      bool = true;
    }
    if (bool)
    {
      j = 2131695890;
      if (i == 1)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramBoolean) {
          paramInt = 4;
        } else {
          paramInt = 3;
        }
        ReportController.b(paramString, "CliOper", "", "", "0X800AB81", "0X800AB81", paramInt, 0, "", "", "", "");
        paramInt = j;
      }
      else
      {
        paramInt = j;
        if (i == 2)
        {
          i = 2131695892;
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (paramBoolean) {
            paramInt = 4;
          } else {
            paramInt = 3;
          }
          ReportController.b(paramString, "CliOper", "", "", "0X800AB83", "0X800AB83", paramInt, 0, "", "", "", "");
          paramInt = i;
        }
      }
      QQToast.a(paramContext, paramInt, 1).b(paramContext.getResources().getDimensionPixelSize(2131299168));
    }
    return bool;
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    if (paramContext == null) {
      return false;
    }
    int j = -1;
    long l;
    if (!TextUtils.isEmpty(paramString)) {
      l = UinUtils.b(paramString);
    } else {
      l = 0L;
    }
    if ((b()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())) {
      j = 1;
    }
    int i = j;
    if (j < 0)
    {
      i = j;
      if (l != 0L)
      {
        AVNotifyCenter.VideoRoomInfo localVideoRoomInfo = a(l, 2);
        Object localObject = localVideoRoomInfo;
        if (localVideoRoomInfo == null) {
          localObject = a(l, 12);
        }
        if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).jdField_a_of_type_Int > 0))
        {
          i = 0;
        }
        else
        {
          localObject = a(l, 10);
          if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).jdField_a_of_type_Int > 0))
          {
            i = 2;
          }
          else
          {
            localObject = (IAvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IAvGameManager.class);
            i = j;
            if (localObject != null)
            {
              i = j;
              if (((IAvGameManager)localObject).isAVGameOpen(paramString)) {
                i = 3;
              }
            }
          }
        }
      }
    }
    if (i == 1)
    {
      QQToast.a(paramContext, 2131695889, 1).b(paramContext.getResources().getDimensionPixelSize(2131299168));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800AB80", "0X800AB80", 0, 0, "", "", "", "");
    }
    else if (i == 2)
    {
      QQToast.a(paramContext, 2131695891, 1).b(paramContext.getResources().getDimensionPixelSize(2131299168));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800AB82", "0X800AB82", 0, 0, "", "", "", "");
    }
    else if (i == 3)
    {
      QQToast.a(paramContext, 2131690433, 1).b(paramContext.getResources().getDimensionPixelSize(2131299168));
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("checkForTroopVideo, ret[");
      paramContext.append(i);
      paramContext.append("], groupId[");
      paramContext.append(paramString);
      paramContext.append("]");
      QLog.i("AVNotifyCenter", 2, paramContext.toString());
    }
    if (i > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(String paramString)
  {
    paramString = (String)this.jdField_c_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.split(";")[0].equals("1");
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject1;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      localObject1 = paramString2;
      try
      {
        if (paramString2.startsWith("+")) {
          localObject1 = paramString2.substring(1);
        }
        if ((this.jdField_c_of_type_JavaUtilHashMap.containsKey(localObject1)) && (!TextUtils.isEmpty(((AVNotifyCenter.AvChatData)this.jdField_c_of_type_JavaUtilHashMap.get(localObject1)).jdField_b_of_type_JavaLangString)) && (((AVNotifyCenter.AvChatData)this.jdField_c_of_type_JavaUtilHashMap.get(localObject1)).jdField_b_of_type_JavaLangString.equals(localObject1)) && (b()))
        {
          if (!QLog.isColorLevel()) {
            break label517;
          }
          QLog.i("AVNotifyCenter", 2, "Do not report qua, because this chatting is active!");
          return false;
        }
        long l = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("start do qua report : peer uin = ");
          paramString2.append((String)localObject1);
          paramString2.append(" , timestamp = ");
          paramString2.append(l);
          QLog.i("AVNotifyCenter", 2, paramString2.toString());
        }
        Object localObject2 = SharedPreferencesProxyManager.getInstance().getProxy(VideoConstants.jdField_a_of_type_JavaLangString, 4);
        paramString2 = ((SharedPreferences)localObject2).getAll();
        localObject2 = ((SharedPreferences)localObject2).edit();
        if (paramString2.size() > 0)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("Qua report map contains report buffer, move to exception map : size = ");
            ((StringBuilder)localObject3).append(paramString2.size());
            QLog.i("AVNotifyCenter", 2, ((StringBuilder)localObject3).toString());
          }
          Object localObject3 = SharedPreferencesProxyManager.getInstance().getProxy(VideoConstants.jdField_b_of_type_JavaLangString, 4).edit();
          Iterator localIterator = paramString2.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            ((SharedPreferences.Editor)localObject3).putString(str, (String)paramString2.get(str));
          }
          ((SharedPreferences.Editor)localObject3).commit();
          ((SharedPreferences.Editor)localObject2).clear().commit();
        }
        paramString2 = new QuaReportInfo();
        paramString2.uintype = paramInt2;
        paramString2.busytype = paramInt1;
        paramString2.peerUin = ((String)localObject1);
        paramString2.selfUin = paramString1;
        ((SharedPreferences.Editor)localObject2).putString(String.valueOf(System.currentTimeMillis()), paramString2.toString());
        ((SharedPreferences.Editor)localObject2).commit();
        return true;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("do qua report error : ");
          paramString2.append(paramString1);
          QLog.e("AVNotifyCenter", 2, paramString2.toString());
        }
        return false;
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("do qua report error : selfuin = ");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(" , peeruin =");
        ((StringBuilder)localObject1).append(paramString2);
        QLog.e("AVNotifyCenter", 2, ((StringBuilder)localObject1).toString());
      }
      return false;
    }
    label517:
    return false;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int b(long paramLong)
  {
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return 0;
  }
  
  public int b(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        AVNotifyCenter.OtherTerChatingRoomInfo localOtherTerChatingRoomInfo = (AVNotifyCenter.OtherTerChatingRoomInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getOtherTermianlAvChatingType roomInfo.mSessionType=");
        localStringBuilder.append(localOtherTerChatingRoomInfo.jdField_a_of_type_Int);
        localStringBuilder.append(", peerUin=");
        localStringBuilder.append(paramString);
        QLog.d("AVNotifyCenter", 1, localStringBuilder.toString());
        int i = localOtherTerChatingRoomInfo.jdField_a_of_type_Int;
        return i;
      }
      return 0;
    }
  }
  
  public long b()
  {
    return this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData.jdField_a_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public String b(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      Object localObject2 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (((AVNotifyCenter.OtherTerChatingRoomInfo)this.jdField_a_of_type_JavaUtilHashMap.get(str)).jdField_a_of_type_Long == paramLong)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getOtherTerminalPeerUin true, roomId=");
          ((StringBuilder)localObject2).append(paramLong);
          ((StringBuilder)localObject2).append(", key=");
          ((StringBuilder)localObject2).append(str);
          QLog.d("AVNotifyCenter", 1, ((StringBuilder)localObject2).toString());
          return str;
        }
      }
      return "";
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public String b(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!TextUtils.isEmpty(paramString)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        AVNotifyCenter.RandomInfo localRandomInfo = (AVNotifyCenter.RandomInfo)localIterator.next();
        if (paramString.equals(localRandomInfo.jdField_a_of_type_JavaLangString)) {
          return localRandomInfo.jdField_c_of_type_JavaLangString;
        }
      }
    }
    return "";
  }
  
  void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clearMultiRoomInfos, AvChatData[");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData);
    ((StringBuilder)localObject).append("]");
    QLog.d("AVNotifyCenter", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData;
    ((AVNotifyCenter.AvChatData)localObject).jdField_c_of_type_Int = 0;
    ((AVNotifyCenter.AvChatData)localObject).jdField_a_of_type_Long = 0L;
    ((AVNotifyCenter.AvChatData)localObject).jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData = this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData;
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2)
  {
    long l = AudioHelper.b();
    if (AudioHelper.b())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setAvtype[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], groupid[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], type[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w("AVNotifyCenter", 1, localStringBuilder.toString());
    }
    if (paramInt2 == 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(l, false);
    }
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), Integer.valueOf(paramInt2));
  }
  
  public void b(long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(String.valueOf(paramLong));
    ((StringBuilder)localObject1).append(10);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(String.valueOf(paramLong));
    ((StringBuilder)localObject2).append(2);
    localObject2 = ((StringBuilder)localObject2).toString();
    Map localMap = this.jdField_e_of_type_JavaUtilMap;
    if (localMap != null)
    {
      localMap.remove(localObject1);
      this.jdField_e_of_type_JavaUtilMap.remove(localObject2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, String.format("removeVideoRoomInfo, groupid: %s", new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public void b(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSmallScreenState, smallScreenState[");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("->");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("SmallScreen", 1, localStringBuilder.toString());
    this.jdField_a_of_type_Int = paramInt;
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
  
  public void b(ArrayList<AVPhoneUserInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)paramArrayList.next();
      long l = localAVPhoneUserInfo.account;
      if (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(Long.valueOf(l))) {
        this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(l), localAVPhoneUserInfo);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startOrStopGAudioTimer start: ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("AVNotifyCenter", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    if (paramBoolean)
    {
      if (!this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_Long = 0L;
      }
      localObject1 = this.jdField_a_of_type_MqqOsMqqHandler;
      if (localObject1 != null)
      {
        localObject2 = this.jdField_b_of_type_JavaLangRunnable;
        if (localObject2 == null) {
          this.jdField_b_of_type_JavaLangRunnable = new AVNotifyCenter.UpdateChattingTime(this);
        } else {
          ((MqqHandler)localObject1).removeCallbacks((Runnable)localObject2);
        }
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2000L);
      }
    }
    else if (!b())
    {
      localObject1 = this.jdField_b_of_type_JavaLangRunnable;
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_MqqOsMqqHandler;
        if (localObject2 != null)
        {
          ((MqqHandler)localObject2).removeCallbacks((Runnable)localObject1);
          this.jdField_b_of_type_JavaLangRunnable = null;
        }
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData.jdField_a_of_type_Int != 0) {
      return this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData.jdField_d_of_type_Boolean;
    }
    return false;
  }
  
  public boolean b(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasMultiVideo --> RelationType = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ,RelationId = ");
      localStringBuilder.append(paramLong);
      QLog.d("AVNotifyCenter", 2, localStringBuilder.toString());
    }
    if (paramInt == 2)
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) {
        return false;
      }
      return this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong));
    }
    if (paramInt == 1)
    {
      if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) {
        return false;
      }
      return this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong));
    }
    if (QLog.isColorLevel()) {
      QLog.e("AVNotifyCenter", 2, "hasMultiVideo --> RelationType is Wrong");
    }
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
  
  public boolean b(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return false;
    }
    boolean bool = true;
    int i = UITools.b(1);
    long l = Long.parseLong(paramString);
    paramString = a(l, 2);
    paramContext = paramString;
    if (paramString == null) {
      paramContext = a(l, 12);
    }
    if ((paramContext == null) || (paramContext.jdField_a_of_type_Int <= 0)) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("checkisAvAlive, relationType[");
      paramContext.append(i);
      paramContext.append("], relationId[");
      paramContext.append(l);
      paramContext.append("], needBlock[");
      paramContext.append(bool);
      paramContext.append("]");
      QLog.i("AVNotifyCenter", 2, paramContext.toString());
    }
    return bool;
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = false;
    Object localObject = a(paramString, false);
    boolean bool1;
    if (localObject != null)
    {
      bool1 = ((AVNotifyCenter.AvChatData)localObject).jdField_e_of_type_Boolean;
    }
    else
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isDoubleVideoMeeting --> can not get data from uin --> peerUin = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("AVNotifyCenter", 2, ((StringBuilder)localObject).toString());
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isDoubleVideoMeeting --> isDoubleVideoMeeting = ");
      paramString.append(bool1);
      QLog.e("AVNotifyCenter", 2, paramString.toString());
    }
    return bool1;
  }
  
  public int c()
  {
    return this.jdField_d_of_type_Int;
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
    return this.jdField_c_of_type_Long;
  }
  
  public String c()
  {
    return this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData.jdField_b_of_type_JavaLangString;
  }
  
  String c(String paramString)
  {
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    if (localIPhoneContactService == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVNotifyCenter", 2, "getPhoneNameByPhoneNum --> can not get PhoneContactManager");
      }
      return null;
    }
    paramString = localIPhoneContactService.queryPhoneContactByMobile(paramString);
    if ((paramString != null) && (paramString.name != null)) {
      return paramString.name;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AVNotifyCenter", 2, "getPhoneNameByPhoneNum --> can not get phoneContact Or Name");
    }
    return null;
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject;
    if ((QLog.isColorLevel()) || (this.jdField_a_of_type_Boolean != paramBoolean))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setNetworkState, mNetworkDown[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append("->");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.w("AVNotifyCenter", 1, ((StringBuilder)localObject).toString());
    }
    if ((this.jdField_a_of_type_Boolean != paramBoolean) && (!paramBoolean))
    {
      localObject = this.jdField_a_of_type_MqqOsMqqHandler;
      if (localObject != null)
      {
        ((MqqHandler)localObject).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      }
    }
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_MqqOsMqqHandler;
      if (localObject != null) {
        ((MqqHandler)localObject).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean c(long paramLong)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(paramLong);
    boolean bool1 = true;
    AVNotifyCenter.VideoRoomInfo localVideoRoomInfo;
    if (i != 2) {
      if (i == 0)
      {
        localVideoRoomInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(paramLong, 2);
        if ((localVideoRoomInfo != null) && (localVideoRoomInfo.jdField_a_of_type_Int > 0)) {}
      }
      else
      {
        bool1 = false;
      }
    }
    boolean bool2 = bool1;
    if (bool1)
    {
      localVideoRoomInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(paramLong, 10);
      bool2 = bool1;
      if (localVideoRoomInfo != null)
      {
        bool2 = bool1;
        if (localVideoRoomInfo.jdField_a_of_type_Int > 0) {
          bool2 = false;
        }
      }
    }
    return bool2;
  }
  
  public boolean c(String paramString)
  {
    try
    {
      boolean bool = this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramString);
      if (AudioHelper.b())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("removeChatSession, sessionId[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("], exist[");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append("], mAvChatDataMap[");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaUtilHashMap.size());
        ((StringBuilder)localObject).append("]");
        QLog.w("AVNotifyCenter", 1, ((StringBuilder)localObject).toString());
      }
      if (!bool) {
        return false;
      }
      this.jdField_c_of_type_JavaUtilHashMap.remove(paramString);
      Object localObject = this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData;
      a("removeChatSession", null);
      if (this.jdField_c_of_type_JavaUtilHashMap.isEmpty())
      {
        this.jdField_a_of_type_Long = 0L;
        if ((this.jdField_b_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_MqqOsMqqHandler != null)) {
          this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        }
      }
      if (AudioHelper.b())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeChatSession, end, sessionId[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], exist[");
        localStringBuilder.append(bool);
        localStringBuilder.append("], mAvChatDataMap[");
        localStringBuilder.append(this.jdField_c_of_type_JavaUtilHashMap.size());
        localStringBuilder.append("], lastChatData[");
        localStringBuilder.append(localObject);
        localStringBuilder.append("], mActiveChatData[");
        localStringBuilder.append(this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData);
        localStringBuilder.append("]");
        QLog.w("AVNotifyCenter", 1, localStringBuilder.toString());
      }
      return true;
    }
    finally {}
  }
  
  public int d()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public long d()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String d()
  {
    return this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData.jdField_c_of_type_JavaLangString;
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNotifyUpdateTime-->bNotify");
      localStringBuilder.append(paramBoolean);
      QLog.d("AVNotifyCenter", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean d(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isOtherTerminalAvChatting contains ");
        localStringBuilder.append(paramString);
        QLog.d("AVNotifyCenter", 1, localStringBuilder.toString());
        return true;
      }
      return false;
    }
  }
  
  public int e()
  {
    return this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData.jdField_a_of_type_Int;
  }
  
  public String e()
  {
    return UITools.a(this.jdField_a_of_type_Long);
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public boolean e()
  {
    return this.jdField_b_of_type_JavaLangRunnable != null;
  }
  
  public int f()
  {
    int j = this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData.jdField_b_of_type_Int;
    int i = j;
    if (j == 21) {
      i = 1011;
    }
    return i;
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData.jdField_c_of_type_Boolean;
  }
  
  public int g()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean g()
  {
    return this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$AvChatData.jdField_b_of_type_Boolean;
  }
  
  public boolean h()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  boolean i()
  {
    if (!VcSystemInfo.isSupportSharpAudio())
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
    return this.jdField_g_of_type_Boolean;
  }
  
  public boolean k()
  {
    return this.jdField_f_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter
 * JD-Core Version:    0.7.0.1
 */