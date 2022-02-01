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
  private static boolean r = false;
  private final AVNotifyCenter.AvChatData A = new AVNotifyCenter.AvChatData(this, "default", 0L);
  private AVNotifyCenter.AvChatData B = this.A;
  private boolean C = false;
  private ArrayList<AVNotifyCenter.RandomInfo> D;
  private int E = 0;
  private int F = 0;
  private String G = null;
  private long H = 0L;
  private int I = 0;
  private String J = null;
  private Map<String, AVNotifyCenter.VideoRoomInfo> K = new HashMap();
  private Map<String, AVNotifyCenter.VideoRoomInfo_tips> L = new HashMap();
  private Map<String, AVNotifyCenter.VideoRoomInfo_tips> M = new HashMap();
  QQAppInterface a = null;
  String b = null;
  boolean c = true;
  Map d = new HashMap();
  Map e = new HashMap();
  MqqHandler f = null;
  public Map<String, String> g = new HashMap();
  public Map<String, Integer> h = new ConcurrentHashMap();
  ConcurrentHashMap<Long, AVNotifyCenter.AddFriendInfo> i = new ConcurrentHashMap();
  Runnable j = new AVNotifyCenter.2(this);
  HashMap<String, AVNotifyCenter.OtherTerChatingRoomInfo> k = new HashMap();
  Runnable l;
  long m = 0L;
  boolean n = true;
  int o = 0;
  private boolean p = false;
  private boolean q = false;
  private int s = 0;
  private PhoneStatusMonitor t;
  private boolean u = false;
  private ConcurrentHashMap<Long, AVNotifyCenter.GAudioRoomInfo> v = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, AVNotifyCenter.GAudioRoomInfo> w = new ConcurrentHashMap();
  private HashMap<Long, AVPhoneUserInfo> x = new HashMap();
  private long y = 0L;
  private HashMap<String, AVNotifyCenter.AvChatData> z = new HashMap();
  
  public AVNotifyCenter(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      this.a = paramQQAppInterface;
      this.b = paramQQAppInterface.getCurrentAccountUin();
      this.f = new AVNotifyCenter.GAudioHandler(Looper.getMainLooper(), this);
      this.a.setHandler(getClass(), this.f);
      this.a.runOnUiThread(new AVNotifyCenter.1(this));
      E();
    }
  }
  
  private void E()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("group_video_push_cfg_txt.");
      localStringBuilder.append(this.a.getAccount());
      localStringBuilder.append(".mutex");
      this.p = localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
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
      f(paramString);
      return;
    }
    Object localObject = b(paramString, true);
    if (localObject != null)
    {
      ((AVNotifyCenter.AvChatData)localObject).b = paramBoolean;
      ((AVNotifyCenter.AvChatData)localObject).c = paramInt3;
      try
      {
        ((AVNotifyCenter.AvChatData)localObject).h = Long.parseLong(paramString);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setSessionType, relationId[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.w("AVNotifyCenter", 1, localStringBuilder.toString(), localException);
      }
      ((AVNotifyCenter.AvChatData)localObject).i = paramInt2;
    }
  }
  
  private void a(String paramString, AVNotifyCenter.AvChatData paramAvChatData)
  {
    AVNotifyCenter.AvChatData localAvChatData = this.B;
    Object localObject;
    if (this.z.size() == 1)
    {
      localObject = null;
      paramAvChatData = this.z.keySet().iterator();
      while (paramAvChatData.hasNext())
      {
        localObject = (String)paramAvChatData.next();
        localObject = (AVNotifyCenter.AvChatData)this.z.get(localObject);
      }
      if (localObject != null) {
        this.B = ((AVNotifyCenter.AvChatData)localObject);
      } else {
        this.B = this.A;
      }
    }
    else if (this.z.size() == 0)
    {
      this.B = this.A;
      localObject = paramAvChatData;
    }
    else if (paramAvChatData == null)
    {
      localObject = this.z.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramAvChatData = (String)((Iterator)localObject).next();
        paramAvChatData = (AVNotifyCenter.AvChatData)this.z.get(paramAvChatData);
      }
      if (paramAvChatData != null)
      {
        this.B = paramAvChatData;
        localObject = paramAvChatData;
      }
      else
      {
        this.B = this.A;
        localObject = paramAvChatData;
      }
    }
    else if ((paramAvChatData.k) && (!this.B.k))
    {
      this.B = paramAvChatData;
      localObject = paramAvChatData;
    }
    else
    {
      localObject = paramAvChatData;
      if (this.B.h == 0L)
      {
        localObject = paramAvChatData;
        if (TextUtils.isEmpty(this.B.e))
        {
          this.B = paramAvChatData;
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
      paramAvChatData.append(this.B);
      paramAvChatData.append("]");
      QLog.i("AVNotifyCenter", 2, paramAvChatData.toString());
    }
  }
  
  public static boolean f()
  {
    return r;
  }
  
  public long A()
  {
    return this.m;
  }
  
  public int B()
  {
    return this.o;
  }
  
  public boolean C()
  {
    return this.C;
  }
  
  public boolean D()
  {
    return this.u;
  }
  
  public int a(long paramLong)
  {
    if (this.i.containsKey(Long.valueOf(paramLong))) {
      return ((AVNotifyCenter.AddFriendInfo)this.i.get(Long.valueOf(paramLong))).b;
    }
    return 3999;
  }
  
  public long a()
  {
    return this.y;
  }
  
  public AVNotifyCenter.VideoRoomInfo a(long paramLong, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.valueOf(paramLong));
    ((StringBuilder)localObject).append(String.valueOf(paramInt));
    localObject = ((StringBuilder)localObject).toString();
    return (AVNotifyCenter.VideoRoomInfo)this.K.get(localObject);
  }
  
  public void a(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.E = paramInt1;
    this.F = paramInt2;
    if (this.E == 0)
    {
      ArrayList localArrayList = this.D;
      if (localArrayList != null)
      {
        localArrayList.clear();
        this.D = null;
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
    int i1 = 0;
    paramInt1 = 0;
    Object localObject2;
    if (paramInt2 == 2)
    {
      if (this.v.containsKey(Long.valueOf(paramLong1))) {
        this.v.remove(Long.valueOf(paramLong1));
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
          ((AVNotifyCenter.UserInfo)localObject2).a = paramArrayOfLong[paramInt1];
          ((Vector)localObject1).add(localObject2);
          paramInt1 += 1;
        }
        paramArrayOfLong = new AVNotifyCenter.GAudioRoomInfo(this);
        paramArrayOfLong.a = paramLong2;
        paramArrayOfLong.b = ((Vector)localObject1);
        this.v.put(Long.valueOf(paramLong1), paramArrayOfLong);
        return;
      }
      return;
    }
    if (paramInt2 == 1)
    {
      if (this.w.containsKey(Long.valueOf(paramLong1))) {
        this.w.remove(Long.valueOf(paramLong1));
      }
      if (paramLong2 == 0L) {
        return;
      }
      localObject1 = new AVNotifyCenter.GAudioRoomInfo(this);
      ((AVNotifyCenter.GAudioRoomInfo)localObject1).a = paramLong2;
      ((AVNotifyCenter.GAudioRoomInfo)localObject1).b = null;
      if (paramArrayOfLong != null)
      {
        localObject2 = new Vector();
        paramInt1 = i1;
        while (paramInt1 < paramArrayOfLong.length)
        {
          AVNotifyCenter.UserInfo localUserInfo = new AVNotifyCenter.UserInfo(this);
          localUserInfo.a = paramArrayOfLong[paramInt1];
          ((Vector)localObject2).add(localUserInfo);
          paramInt1 += 1;
        }
        ((AVNotifyCenter.GAudioRoomInfo)localObject1).b = ((Vector)localObject2);
      }
      this.w.put(Long.valueOf(paramLong1), localObject1);
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
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    a(paramInt1, paramLong, paramInt2, paramInt3, paramInt4, -1, paramInt5, paramInt6);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).F(String.valueOf(paramLong)))
    {
      k(paramLong);
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
    ((AVNotifyCenter.VideoRoomInfo)localObject1).b = paramLong;
    ((AVNotifyCenter.VideoRoomInfo)localObject1).d = paramInt2;
    ((AVNotifyCenter.VideoRoomInfo)localObject1).h = paramInt6;
    ((AVNotifyCenter.VideoRoomInfo)localObject1).f = paramInt3;
    ((AVNotifyCenter.VideoRoomInfo)localObject1).g = paramInt4;
    ((AVNotifyCenter.VideoRoomInfo)localObject1).e = paramInt5;
    ((AVNotifyCenter.VideoRoomInfo)localObject1).c = paramInt7;
    ((AVNotifyCenter.VideoRoomInfo)localObject1).i = System.currentTimeMillis();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(String.valueOf(paramLong));
    ((StringBuilder)localObject2).append(String.valueOf(paramInt2));
    Object localObject3 = ((StringBuilder)localObject2).toString();
    localObject2 = (AVNotifyCenter.VideoRoomInfo)this.K.get(localObject3);
    this.K.put(localObject3, localObject1);
    if (AudioHelper.e())
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
      localConcurrentHashMap = this.v;
    }
    else
    {
      if (paramInt != 1) {
        return;
      }
      localConcurrentHashMap = this.w;
    }
    if (AudioHelper.e())
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
    int i2 = paramArrayOfLong.length;
    paramInt = 0;
    int i1 = 0;
    while (paramInt < i2)
    {
      AVNotifyCenter.UserInfo localUserInfo = new AVNotifyCenter.UserInfo(this);
      localUserInfo.a = paramArrayOfLong[paramInt];
      ((Vector)localObject).add(localUserInfo);
      i1 += 1;
      paramInt += 1;
    }
    paramArrayOfLong = new AVNotifyCenter.GAudioRoomInfo(this);
    paramArrayOfLong.a = i1;
    paramArrayOfLong.b = ((Vector)localObject);
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
    int i1;
    Object localObject2;
    if (paramInt == 2)
    {
      if (this.v.containsKey(Long.valueOf(paramLong1))) {
        this.v.remove(Long.valueOf(paramLong1));
      }
      if ((paramLong2 != 0L) && (paramArrayOfLong != null) && (paramArrayOfInt != null))
      {
        if (paramArrayOfLong.length != paramArrayOfInt.length) {
          return;
        }
        localObject1 = new Vector();
        i1 = paramArrayOfLong.length;
        localObject2 = new ArrayList();
        paramInt = 0;
        while (paramInt < i1)
        {
          AVNotifyCenter.UserInfo localUserInfo = new AVNotifyCenter.UserInfo(this);
          localUserInfo.a = paramArrayOfLong[paramInt];
          if (paramArrayOfInt[paramInt] == 1) {
            bool = true;
          } else {
            bool = false;
          }
          localUserInfo.b = bool;
          if ((localUserInfo.b) && (!this.x.containsKey(Long.valueOf(localUserInfo.a)))) {
            ((ArrayList)localObject2).add(Long.valueOf(localUserInfo.a));
          }
          ((Vector)localObject1).add(localUserInfo);
          paramInt += 1;
        }
        a((ArrayList)localObject2);
        paramArrayOfLong = new AVNotifyCenter.GAudioRoomInfo(this);
        paramArrayOfLong.a = paramLong2;
        paramArrayOfLong.b = ((Vector)localObject1);
        this.v.put(Long.valueOf(paramLong1), paramArrayOfLong);
        return;
      }
      return;
    }
    if (paramInt == 1)
    {
      if (this.w.containsKey(Long.valueOf(paramLong1))) {
        this.w.remove(Long.valueOf(paramLong1));
      }
      if (paramLong2 == 0L) {
        return;
      }
      localObject1 = new Vector();
      if (paramArrayOfLong != null)
      {
        i1 = paramArrayOfLong.length;
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject2 = new AVNotifyCenter.UserInfo(this);
          ((AVNotifyCenter.UserInfo)localObject2).a = paramArrayOfLong[paramInt];
          if (paramArrayOfInt[paramInt] == 1) {
            bool = true;
          } else {
            bool = false;
          }
          ((AVNotifyCenter.UserInfo)localObject2).b = bool;
          ((Vector)localObject1).add(localObject2);
          paramInt += 1;
        }
      }
      paramArrayOfLong = new AVNotifyCenter.GAudioRoomInfo(this);
      paramArrayOfLong.a = paramLong2;
      paramArrayOfLong.b = ((Vector)localObject1);
      this.w.put(Long.valueOf(paramLong1), paramArrayOfLong);
    }
  }
  
  public void a(int paramInt, Long paramLong, boolean paramBoolean)
  {
    if (AudioHelper.e())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setChating, relationType[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], relationId[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], isChating[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], mActiveChatData[");
      ((StringBuilder)localObject).append(this.B);
      ((StringBuilder)localObject).append("]");
      QLog.w("AVNotifyCenter", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = String.valueOf(paramLong);
    if (paramBoolean)
    {
      localObject = b((String)localObject, true);
      if (localObject == null)
      {
        if (AudioHelper.e()) {
          QLog.w("AVNotifyCenter", 1, "setChating, data is null");
        }
        return;
      }
      ((AVNotifyCenter.AvChatData)localObject).b = false;
      ((AVNotifyCenter.AvChatData)localObject).h = paramLong.longValue();
      ((AVNotifyCenter.AvChatData)localObject).i = paramInt;
      if (((AVNotifyCenter.AvChatData)localObject).i == 1) {
        ((AVNotifyCenter.AvChatData)localObject).d = 1;
      } else if (((AVNotifyCenter.AvChatData)localObject).i == 2) {
        ((AVNotifyCenter.AvChatData)localObject).d = 3000;
      } else if (((AVNotifyCenter.AvChatData)localObject).i == 3) {
        ((AVNotifyCenter.AvChatData)localObject).d = 0;
      }
      ((AVNotifyCenter.AvChatData)localObject).k = paramBoolean;
      if ((((AVNotifyCenter.AvChatData)localObject).k) && (this.B != localObject)) {
        a("setChating.1", (AVNotifyCenter.AvChatData)localObject);
      }
      if (AudioHelper.e())
      {
        paramLong = new StringBuilder();
        paramLong.append("setChating, end, data[");
        paramLong.append(localObject);
        paramLong.append("], mActiveChatData[");
        paramLong.append(this.B);
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
    AVNotifyCenter.AvChatData localAvChatData = b(paramString1, false);
    if (localAvChatData != null)
    {
      localAvChatData.b = true;
      localAvChatData.d = paramInt;
      localAvChatData.e = paramString1;
      localAvChatData.f = paramString2;
      localAvChatData.g = paramBoolean;
      localAvChatData.i = 0;
      localAvChatData.h = AVUtil.c(paramString1);
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
    localStringBuilder.append(this.B);
    localStringBuilder.append("]");
    QLog.w("AVNotifyCenter", 1, localStringBuilder.toString());
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AVNotifyCenter.AvChatData localAvChatData = b(paramString, false);
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
      localAvChatData.j = paramBoolean1;
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          localAvChatData.k = false;
        } else {
          localAvChatData.k = true;
        }
      }
      else {
        localAvChatData.k = true;
      }
      if ((localAvChatData.k) && (localAvChatData != this.B)) {
        a("setWaittingState", localAvChatData);
      }
      paramString = new StringBuilder();
      paramString.append("setWaittingState, end, AvChatData[");
      paramString.append(localAvChatData);
      paramString.append("]");
      QLog.w("AVNotifyCenter", 1, paramString.toString());
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject2 = (String)this.g.get(Long.valueOf(paramLong));
    String str = "0;0";
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "0;0";
    }
    Object localObject3 = str;
    if (paramInt2 > 0)
    {
      localObject2 = null;
      int i1 = 0;
      if (paramInt1 == 2) {}
      for (localObject2 = a(paramLong, 10);; localObject2 = a(paramLong, 2))
      {
        i1 = 1;
        break;
        if (paramInt1 != 10) {
          break;
        }
      }
      if (localObject2 != null)
      {
        localObject3 = str;
        if (((AVNotifyCenter.VideoRoomInfo)localObject2).c <= 0) {
          break label164;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("1;");
        ((StringBuilder)localObject1).append(((AVNotifyCenter.VideoRoomInfo)localObject2).c + paramInt2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else if (i1 != 0)
      {
        localObject3 = str;
        break label164;
      }
      localObject3 = localObject1;
    }
    label164:
    this.g.put(String.valueOf(paramLong), localObject3);
    if (AudioHelper.e())
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
      if (this.L.containsKey(Long.valueOf(paramLong))) {
        localObject = (AVNotifyCenter.VideoRoomInfo_tips)this.L.remove(Long.valueOf(paramLong));
      }
      localVideoRoomInfo_tips = new AVNotifyCenter.VideoRoomInfo_tips(this);
      localVideoRoomInfo_tips.a = paramLong;
      localVideoRoomInfo_tips.b = paramBoolean;
      this.L.put(String.valueOf(paramLong), localVideoRoomInfo_tips);
    }
    else if (paramInt1 == 1)
    {
      localObject = localStringBuilder;
      if (this.M.containsKey(Long.valueOf(paramLong))) {
        localObject = (AVNotifyCenter.VideoRoomInfo_tips)this.M.remove(Long.valueOf(paramLong));
      }
      localVideoRoomInfo_tips = new AVNotifyCenter.VideoRoomInfo_tips(this);
      localVideoRoomInfo_tips.a = paramLong;
      localVideoRoomInfo_tips.b = paramBoolean;
      localVideoRoomInfo_tips.c = paramInt2;
      this.M.put(String.valueOf(paramLong), localVideoRoomInfo_tips);
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
    if ((AudioHelper.e()) || (paramBoolean != this.q))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVideoRequestStatus, isVideoRequest[");
      localStringBuilder.append(this.q);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("AVNotifyCenter", 1, localStringBuilder.toString());
    }
    this.q = paramBoolean;
  }
  
  @TargetApi(11)
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 11) {
      return;
    }
    String str1 = String.valueOf(paramLong);
    Object localObject2 = new HashSet();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a.getApp());
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ADD_FRIEND_DIALOG");
    ((StringBuilder)localObject1).append(this.a.getCurrentAccountUin());
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
    if (this.i.containsKey(Long.valueOf(paramLong))) {
      this.i.remove(Long.valueOf(paramLong));
    }
    if (!paramBoolean)
    {
      ((Set)localObject1).add(str1);
      localSharedPreferences.edit().putStringSet(str2, (Set)localObject1).commit();
      return;
    }
    localObject1 = new AVNotifyCenter.AddFriendInfo();
    ((AVNotifyCenter.AddFriendInfo)localObject1).b = paramInt;
    ((AVNotifyCenter.AddFriendInfo)localObject1).a = paramLong;
    this.i.put(Long.valueOf(paramLong), localObject1);
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
              break label376;
            }
            this.p = bool;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("group_video_push_cfg_txt.");
            ((StringBuilder)localObject2).append(paramQQAppInterface.getAccount());
            ((StringBuilder)localObject2).append(".mutex");
            ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject2).toString(), this.p);
          }
          paramString = paramString.getJSONObject("noiseCtrl");
          if (paramString != null)
          {
            paramInt = paramString.getInt("level");
            int i1 = paramString.getInt("sendDura");
            int i2 = paramString.getInt("validDura");
            paramString = new StringBuilder();
            paramString.append("group_video_push_cfg_txt.");
            paramString.append(paramQQAppInterface.getAccount());
            paramString.append(".level");
            ((SharedPreferences.Editor)localObject1).putInt(paramString.toString(), paramInt);
            paramString = new StringBuilder();
            paramString.append("group_video_push_cfg_txt.");
            paramString.append(paramQQAppInterface.getAccount());
            paramString.append(".sendDura");
            ((SharedPreferences.Editor)localObject1).putInt(paramString.toString(), i1);
            paramString = new StringBuilder();
            paramString.append("group_video_push_cfg_txt.");
            paramString.append(paramQQAppInterface.getAccount());
            paramString.append(".validDura");
            ((SharedPreferences.Editor)localObject1).putInt(paramString.toString(), i2);
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
      label376:
      bool = true;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    this.h.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    synchronized (this.k)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addOtherTerminalAvChating peerUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",roomid = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",sessionType = ");
      localStringBuilder.append(paramInt);
      QLog.d("AVNotifyCenter", 1, localStringBuilder.toString());
      this.k.put(paramString, new AVNotifyCenter.OtherTerChatingRoomInfo(this, paramLong, paramInt));
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.D == null) {
      this.D = new ArrayList();
    }
    this.D.add(new AVNotifyCenter.RandomInfo(paramString1, paramString2, paramString3));
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
    paramString = b(paramString, false);
    if (paramString != null) {
      paramString.l = paramBoolean;
    }
  }
  
  void a(ArrayList<Long> paramArrayList)
  {
    NewIntent localNewIntent = new NewIntent(this.a.getApplication(), VideoConfigServlet.class);
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", paramArrayList);
    try
    {
      this.a.startServlet(localNewIntent);
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
    QQAppInterface localQQAppInterface = this.a;
    if (paramMsgBody != null)
    {
      if (localQQAppInterface == null) {
        return;
      }
      boolean bool2 = false;
      boolean bool1 = false;
      long l1 = paramMsgBody.uint64_msg_seq.get();
      int i1 = paramMsgBody.uint32_msg_type.get();
      Object localObject2 = null;
      Object localObject1 = "avChatRoom";
      if (i1 == 2)
      {
        if (paramMsgBody.str_msg_info.has()) {
          paramMsgBody = paramMsgBody.str_msg_info.get().toByteArray();
        } else {
          paramMsgBody = null;
        }
      }
      else if (i1 == 4)
      {
        if (paramMsgBody.bytes_ext_info.has()) {
          paramMsgBody = paramMsgBody.bytes_ext_info.get().toByteArray();
        } else {
          paramMsgBody = null;
        }
        localObject1 = "avWatchTogether";
      }
      else if (i1 == 5)
      {
        if (paramMsgBody.bytes_ext_info.has()) {
          paramMsgBody = paramMsgBody.str_msg_info.get().toByteArray();
        } else {
          paramMsgBody = null;
        }
        localObject1 = "avScreenShareAsk";
      }
      else if (i1 == 6)
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
          bool1 = ((QQServiceForAV)localObject2).a((String)localObject1, i1, paramMsgBody);
        }
        if (!bool1)
        {
          localObject2 = new Intent("tencent.video.q2v.avReceivePushMsg");
          ((Intent)localObject2).putExtra("msg_key", (String)localObject1);
          ((Intent)localObject2).putExtra("msg_seq", l1);
          ((Intent)localObject2).putExtra("msg_type", i1);
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
    r = paramBoolean;
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
  
  public boolean a(int paramInt, long paramLong)
  {
    return a(AudioHelper.c(), String.valueOf(paramLong));
  }
  
  public boolean a(int paramInt1, long paramLong, int paramInt2)
  {
    if (paramInt1 == 2) {
      return a(paramInt1, paramLong);
    }
    paramInt1 = e(paramLong);
    if (paramInt1 < 0) {
      return false;
    }
    AVNotifyCenter.AvChatData localAvChatData = b(String.valueOf(paramLong), false);
    if ((localAvChatData != null) && (paramInt2 == paramInt1)) {
      return localAvChatData.k;
    }
    return false;
  }
  
  public boolean a(long paramLong, String paramString)
  {
    AVNotifyCenter.AvChatData localAvChatData = b(paramString, false);
    if (AudioHelper.e())
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
      return localAvChatData.k;
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
    String str;
    if (!bool1)
    {
      str = AVBizModuleFactory.getModuleByName("音视频通话").checkAVFocus();
      bool2 = "true".equals(str) ^ true;
    }
    else
    {
      str = "";
      bool2 = false;
    }
    if (bool2)
    {
      int i1 = paramContext.getResources().getDimensionPixelSize(2131299920);
      QQToast.makeText(paramContext, String.format(paramContext.getString(2131887170), new Object[] { str }), 1).show(i1);
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
    int i2 = UITools.b(paramInt);
    long l1 = Long.parseLong(paramString);
    int i1 = -1;
    if (a(i2, l1)) {
      i1 = 0;
    }
    paramString = a(l1, 10);
    paramInt = i1;
    if (paramString != null)
    {
      paramInt = i1;
      if (paramString.c > 0) {
        paramInt = 0;
      }
    }
    i1 = paramInt;
    if (paramInt < 0)
    {
      AVNotifyCenter.VideoRoomInfo localVideoRoomInfo = a(l1, 2);
      paramString = localVideoRoomInfo;
      if (localVideoRoomInfo == null) {
        paramString = a(l1, 12);
      }
      i1 = paramInt;
      if (paramString != null)
      {
        i1 = paramInt;
        if (paramString.c > 0) {
          i1 = 2;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("checkBlockTroopAVChat, relationType[");
      paramString.append(i2);
      paramString.append("], relationId[");
      paramString.append(l1);
      paramString.append("], ret[");
      paramString.append(i1);
      paramString.append("]");
      QLog.i("AVNotifyCenter", 2, paramString.toString());
    }
    if (i1 > 0) {
      bool = true;
    }
    if (bool)
    {
      i2 = 2131893651;
      if (i1 == 1)
      {
        paramString = this.a;
        if (paramBoolean) {
          paramInt = 4;
        } else {
          paramInt = 3;
        }
        ReportController.b(paramString, "CliOper", "", "", "0X800AB81", "0X800AB81", paramInt, 0, "", "", "", "");
        paramInt = i2;
      }
      else
      {
        paramInt = i2;
        if (i1 == 2)
        {
          i1 = 2131893653;
          paramString = this.a;
          if (paramBoolean) {
            paramInt = 4;
          } else {
            paramInt = 3;
          }
          ReportController.b(paramString, "CliOper", "", "", "0X800AB83", "0X800AB83", paramInt, 0, "", "", "", "");
          paramInt = i1;
        }
      }
      QQToast.makeText(paramContext, paramInt, 1).show(paramContext.getResources().getDimensionPixelSize(2131299920));
    }
    return bool;
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    if (paramContext == null) {
      return false;
    }
    int i2 = -1;
    long l1;
    if (!TextUtils.isEmpty(paramString)) {
      l1 = UinUtils.b(paramString);
    } else {
      l1 = 0L;
    }
    if ((d()) || (this.a.isVideoChatting())) {
      i2 = 1;
    }
    int i1 = i2;
    if (i2 < 0)
    {
      i1 = i2;
      if (l1 != 0L)
      {
        AVNotifyCenter.VideoRoomInfo localVideoRoomInfo = a(l1, 2);
        Object localObject = localVideoRoomInfo;
        if (localVideoRoomInfo == null) {
          localObject = a(l1, 12);
        }
        if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).c > 0))
        {
          i1 = 0;
        }
        else
        {
          localObject = a(l1, 10);
          if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).c > 0))
          {
            i1 = 2;
          }
          else
          {
            localObject = (IAvGameManager)this.a.getRuntimeService(IAvGameManager.class);
            i1 = i2;
            if (localObject != null)
            {
              i1 = i2;
              if (((IAvGameManager)localObject).isAVGameOpen(paramString)) {
                i1 = 3;
              }
            }
          }
        }
      }
    }
    if (i1 == 1)
    {
      QQToast.makeText(paramContext, 2131893650, 1).show(paramContext.getResources().getDimensionPixelSize(2131299920));
      ReportController.b(this.a, "CliOper", "", "", "0X800AB80", "0X800AB80", 0, 0, "", "", "", "");
    }
    else if (i1 == 2)
    {
      QQToast.makeText(paramContext, 2131893652, 1).show(paramContext.getResources().getDimensionPixelSize(2131299920));
      ReportController.b(this.a, "CliOper", "", "", "0X800AB82", "0X800AB82", 0, 0, "", "", "", "");
    }
    else if (i1 == 3)
    {
      QQToast.makeText(paramContext, 2131887344, 1).show(paramContext.getResources().getDimensionPixelSize(2131299920));
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("checkForTroopVideo, ret[");
      paramContext.append(i1);
      paramContext.append("], groupId[");
      paramContext.append(paramString);
      paramContext.append("]");
      QLog.i("AVNotifyCenter", 2, paramContext.toString());
    }
    if (i1 > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(String paramString)
  {
    paramString = (String)this.g.get(paramString);
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
        if ((this.z.containsKey(localObject1)) && (!TextUtils.isEmpty(((AVNotifyCenter.AvChatData)this.z.get(localObject1)).e)) && (((AVNotifyCenter.AvChatData)this.z.get(localObject1)).e.equals(localObject1)) && (d()))
        {
          if (!QLog.isColorLevel()) {
            break label522;
          }
          QLog.i("AVNotifyCenter", 2, "Do not report qua, because this chatting is active!");
          return false;
        }
        long l1 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("start do qua report : peer uin = ");
          paramString2.append((String)localObject1);
          paramString2.append(" , timestamp = ");
          paramString2.append(l1);
          QLog.i("AVNotifyCenter", 2, paramString2.toString());
        }
        Object localObject2 = SharedPreferencesProxyManager.getInstance().getProxy(VideoConstants.c, 4);
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
          Object localObject3 = SharedPreferencesProxyManager.getInstance().getProxy(VideoConstants.d, 4).edit();
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
    label522:
    return false;
  }
  
  public AVNotifyCenter.AvChatData b(String paramString, boolean paramBoolean)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.equals(paramString, "0")))
      {
        if (this.z.containsKey(paramString))
        {
          paramString = (AVNotifyCenter.AvChatData)this.z.get(paramString);
          return paramString;
        }
        Object localObject;
        if (paramBoolean)
        {
          long l1 = AudioHelper.c();
          localObject = new AVNotifyCenter.AvChatData(this, "normal", l1);
          this.z.put(paramString, localObject);
          a("getChatSession", (AVNotifyCenter.AvChatData)localObject);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getChatSession, create sessionId[");
          localStringBuilder.append(paramString);
          localStringBuilder.append("], mAvChatDataMap[");
          localStringBuilder.append(this.z.size());
          localStringBuilder.append("], data[");
          localStringBuilder.append(localObject);
          localStringBuilder.append("], mActiveChatData[");
          localStringBuilder.append(this.B);
          localStringBuilder.append("], seq[");
          localStringBuilder.append(l1);
          localStringBuilder.append("]");
          QLog.w("AVNotifyCenter", 1, localStringBuilder.toString());
          paramString = (String)localObject;
          break label284;
        }
        if (AudioHelper.e())
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
      label284:
      return paramString;
    }
    finally {}
  }
  
  public AVNotifyCenter.VideoRoomInfo_tips b(long paramLong, int paramInt)
  {
    Object localObject = String.valueOf(paramLong);
    if (paramInt == 2) {
      localObject = (AVNotifyCenter.VideoRoomInfo_tips)this.L.get(localObject);
    } else if (paramInt == 1) {
      localObject = (AVNotifyCenter.VideoRoomInfo_tips)this.M.get(localObject);
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
  
  public void b()
  {
    PhoneStatusMonitor localPhoneStatusMonitor = this.t;
    if (localPhoneStatusMonitor != null)
    {
      localPhoneStatusMonitor.b();
      this.t = null;
    }
  }
  
  public void b(int paramInt, long paramLong)
  {
    if (this.a == null) {
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
      localObject1 = this.v;
    }
    else
    {
      if (paramInt != 1) {
        return;
      }
      localObject1 = this.w;
    }
    long l1 = Long.valueOf(this.a.getCurrentAccountUin()).longValue();
    Object localObject3 = (AVNotifyCenter.GAudioRoomInfo)((ConcurrentHashMap)localObject1).get(Long.valueOf(paramLong));
    Object localObject4;
    if (localObject3 != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("], containsKey[true");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject4 = ((AVNotifyCenter.GAudioRoomInfo)localObject3).b;
      boolean bool2 = false;
      paramInt = 0;
      boolean bool1 = bool2;
      if (localObject4 != null)
      {
        bool1 = bool2;
        if (((Vector)localObject4).size() > 0)
        {
          int i1 = ((Vector)localObject4).size();
          bool1 = false;
          while (paramInt < i1)
          {
            if (l1 == ((AVNotifyCenter.UserInfo)((Vector)localObject4).elementAt(paramInt)).a) {
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
          ((AVNotifyCenter.UserInfo)localObject1).a = l1;
          ((Vector)localObject4).add(localObject1);
          ((AVNotifyCenter.GAudioRoomInfo)localObject3).a += 1L;
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
      ((AVNotifyCenter.UserInfo)localObject3).a = l1;
      ((Vector)localObject4).add(localObject3);
      localObject3 = new AVNotifyCenter.GAudioRoomInfo(this);
      ((AVNotifyCenter.GAudioRoomInfo)localObject3).a = 1L;
      ((AVNotifyCenter.GAudioRoomInfo)localObject3).b = ((Vector)localObject4);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append("], cur[");
      ((StringBuilder)localObject4).append(localObject3);
      localObject2 = ((StringBuilder)localObject4).toString();
      ((ConcurrentHashMap)localObject1).put(Long.valueOf(paramLong), localObject3);
      localObject1 = localObject2;
    }
    this.y = System.currentTimeMillis();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("], timeRoomCreateTime[");
    ((StringBuilder)localObject2).append(this.y);
    ((StringBuilder)localObject2).append("]");
    QLog.w("AVNotifyCenter", 1, ((StringBuilder)localObject2).toString());
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2)
  {
    if (this.a == null) {
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
    int i1;
    if (paramInt1 == 2)
    {
      localObject2 = this.v;
      i1 = 3000;
    }
    else
    {
      if (paramInt1 != 1) {
        return;
      }
      localObject2 = this.w;
      i1 = 1;
    }
    String str2 = this.a.getCurrentAccountUin();
    long l1 = Long.valueOf(str2).longValue();
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
      localObject3 = ((AVNotifyCenter.GAudioRoomInfo)localObject1).b;
      ((AVNotifyCenter.GAudioRoomInfo)localObject1).a -= 1L;
      if (((AVNotifyCenter.GAudioRoomInfo)localObject1).a == 0L)
      {
        ((ConcurrentHashMap)localObject2).remove(Long.valueOf(paramLong));
        localObject1 = Long.toString(paramLong);
        if (paramInt1 == 2) {
          VideoMsgTools.a(this.a, i1, 14, false, (String)localObject1, str2, false, null, false, new Object[] { new Integer(paramInt2) });
        } else {
          VideoMsgTools.a(this.a, i1, 14, false, (String)localObject1, str2, false, null, false, paramInt2, new Object[] { new Integer(paramInt2) });
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
            if (l1 == ((AVNotifyCenter.UserInfo)((Vector)localObject3).elementAt(paramInt1)).a)
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
  
  public void b(long paramLong, boolean paramBoolean)
  {
    this.e.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean));
    if ((!paramBoolean) && (this.a != null))
    {
      Intent localIntent = new Intent("tencent.video.q2v.close_invite_msg_box");
      localIntent.putExtra("groupId", paramLong);
      this.a.getApp().sendBroadcast(localIntent);
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
      long l1 = localAVPhoneUserInfo.account;
      if (!this.x.containsKey(Long.valueOf(l1))) {
        this.x.put(Long.valueOf(l1), localAVPhoneUserInfo);
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
      if (!this.B.k) {
        this.m = 0L;
      }
      localObject1 = this.f;
      if (localObject1 != null)
      {
        localObject2 = this.l;
        if (localObject2 == null) {
          this.l = new AVNotifyCenter.UpdateChattingTime(this);
        } else {
          ((MqqHandler)localObject1).removeCallbacks((Runnable)localObject2);
        }
        this.f.postDelayed(this.l, 2000L);
      }
    }
    else if (!d())
    {
      localObject1 = this.l;
      if (localObject1 != null)
      {
        localObject2 = this.f;
        if (localObject2 != null)
        {
          ((MqqHandler)localObject2).removeCallbacks((Runnable)localObject1);
          this.l = null;
        }
      }
    }
  }
  
  @TargetApi(11)
  public boolean b(long paramLong)
  {
    if (Build.VERSION.SDK_INT < 11) {
      return false;
    }
    HashSet localHashSet = new HashSet();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a.getApp());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ADD_FRIEND_DIALOG");
    ((StringBuilder)localObject).append(this.a.getCurrentAccountUin());
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
    return this.i.containsKey(Long.valueOf(paramLong));
  }
  
  public boolean b(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return false;
    }
    boolean bool = true;
    int i1 = UITools.b(1);
    long l1 = Long.parseLong(paramString);
    paramString = a(l1, 2);
    paramContext = paramString;
    if (paramString == null) {
      paramContext = a(l1, 12);
    }
    if ((paramContext == null) || (paramContext.c <= 0)) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("checkisAvAlive, relationType[");
      paramContext.append(i1);
      paramContext.append("], relationId[");
      paramContext.append(l1);
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
    Object localObject = b(paramString, false);
    boolean bool1;
    if (localObject != null)
    {
      bool1 = ((AVNotifyCenter.AvChatData)localObject).l;
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
  
  public long c(int paramInt, long paramLong)
  {
    if (paramInt == 2)
    {
      if (this.v.containsKey(Long.valueOf(paramLong)))
      {
        localGAudioRoomInfo = (AVNotifyCenter.GAudioRoomInfo)this.v.get(Long.valueOf(paramLong));
        break label79;
      }
    }
    else if ((paramInt == 1) && (this.w.containsKey(Long.valueOf(paramLong))))
    {
      localGAudioRoomInfo = (AVNotifyCenter.GAudioRoomInfo)this.w.get(Long.valueOf(paramLong));
      break label79;
    }
    AVNotifyCenter.GAudioRoomInfo localGAudioRoomInfo = null;
    label79:
    if (AudioHelperUtil.b())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMultiRoomMemberNum, relationId[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], ");
      localStringBuilder.append(localGAudioRoomInfo);
      QLog.w("AVNotifyCenter", 1, localStringBuilder.toString());
    }
    if (localGAudioRoomInfo != null) {
      return localGAudioRoomInfo.a;
    }
    return 0L;
  }
  
  public String c(String paramString)
  {
    if ((this.D != null) && (!TextUtils.isEmpty(paramString)))
    {
      Iterator localIterator = this.D.iterator();
      while (localIterator.hasNext())
      {
        AVNotifyCenter.RandomInfo localRandomInfo = (AVNotifyCenter.RandomInfo)localIterator.next();
        if (paramString.equals(localRandomInfo.a)) {
          return localRandomInfo.b;
        }
      }
    }
    return "";
  }
  
  public void c(int paramInt1, long paramLong, int paramInt2)
  {
    long l1 = AudioHelper.c();
    if (AudioHelper.e())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setAvtype[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], groupid[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], type[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w("AVNotifyCenter", 1, localStringBuilder.toString());
    }
    if (paramInt2 == 0) {
      this.a.getAVNotifyCenter().a(l1, false);
    }
    this.d.put(Long.valueOf(paramLong), Integer.valueOf(paramInt2));
  }
  
  public void c(long paramLong, int paramInt)
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
      this.L.remove(localObject);
      return;
    }
    if (paramInt == 1) {
      this.M.remove(localObject);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject;
    if ((QLog.isColorLevel()) || (this.c != paramBoolean))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setNetworkState, mNetworkDown[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("->");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.w("AVNotifyCenter", 1, ((StringBuilder)localObject).toString());
    }
    if ((this.c != paramBoolean) && (!paramBoolean))
    {
      localObject = this.f;
      if (localObject != null)
      {
        ((MqqHandler)localObject).removeCallbacks(this.j);
        this.f.postDelayed(this.j, 5000L);
      }
    }
    if (paramBoolean)
    {
      localObject = this.f;
      if (localObject != null) {
        ((MqqHandler)localObject).removeCallbacks(this.j);
      }
    }
    this.c = paramBoolean;
  }
  
  public boolean c()
  {
    PhoneStatusMonitor localPhoneStatusMonitor = this.t;
    if (localPhoneStatusMonitor != null) {
      return localPhoneStatusMonitor.c();
    }
    return false;
  }
  
  public boolean c(long paramLong)
  {
    Boolean localBoolean = (Boolean)this.e.get(Long.valueOf(paramLong));
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    return false;
  }
  
  public AVNotifyCenter.UserInfo d(int paramInt, long paramLong)
  {
    if (paramInt == 2)
    {
      Object localObject = this.v;
      if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(Long.valueOf(paramLong))))
      {
        localObject = ((AVNotifyCenter.GAudioRoomInfo)this.v.get(Long.valueOf(paramLong))).b;
        if ((localObject != null) && (((Vector)localObject).size() > 0)) {
          return (AVNotifyCenter.UserInfo)((Vector)localObject).get(0);
        }
      }
    }
    return null;
  }
  
  public String d(String paramString)
  {
    if ((this.D != null) && (!TextUtils.isEmpty(paramString)))
    {
      Iterator localIterator = this.D.iterator();
      while (localIterator.hasNext())
      {
        AVNotifyCenter.RandomInfo localRandomInfo = (AVNotifyCenter.RandomInfo)localIterator.next();
        if (paramString.equals(localRandomInfo.a)) {
          return localRandomInfo.c;
        }
      }
    }
    return "";
  }
  
  public void d(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSmallScreenState, smallScreenState[");
    localStringBuilder.append(this.o);
    localStringBuilder.append("->");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("SmallScreen", 1, localStringBuilder.toString());
    this.o = paramInt;
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
    this.n = paramBoolean;
  }
  
  public boolean d()
  {
    if (this.B.c != 0) {
      return this.B.k;
    }
    return false;
  }
  
  public boolean d(long paramLong)
  {
    int i1 = this.a.getAVNotifyCenter().e(paramLong);
    boolean bool1 = true;
    AVNotifyCenter.VideoRoomInfo localVideoRoomInfo;
    if (i1 != 2) {
      if (i1 == 0)
      {
        localVideoRoomInfo = this.a.getAVNotifyCenter().a(paramLong, 2);
        if ((localVideoRoomInfo != null) && (localVideoRoomInfo.c > 0)) {}
      }
      else
      {
        bool1 = false;
      }
    }
    boolean bool2 = bool1;
    if (bool1)
    {
      localVideoRoomInfo = this.a.getAVNotifyCenter().a(paramLong, 10);
      bool2 = bool1;
      if (localVideoRoomInfo != null)
      {
        bool2 = bool1;
        if (localVideoRoomInfo.c > 0) {
          bool2 = false;
        }
      }
    }
    return bool2;
  }
  
  public int e(long paramLong)
  {
    Integer localInteger = (Integer)this.d.get(Long.valueOf(paramLong));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return 0;
  }
  
  String e(String paramString)
  {
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.a.getRuntimeService(IPhoneContactService.class, "");
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
  
  public Vector<AVNotifyCenter.UserInfo> e(int paramInt, long paramLong)
  {
    if (paramInt == 2)
    {
      Object localObject = this.v;
      if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(Long.valueOf(paramLong))))
      {
        localObject = ((AVNotifyCenter.GAudioRoomInfo)this.v.get(Long.valueOf(paramLong))).b;
        if ((localObject != null) && (((Vector)localObject).size() > 0)) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public void e(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public boolean e()
  {
    return this.q;
  }
  
  public AVNotifyCenter.VideoRoomInfo f(long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(String.valueOf(paramLong));
    ((StringBuilder)localObject1).append(String.valueOf(2));
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(String.valueOf(paramLong));
    ((StringBuilder)localObject2).append(String.valueOf(10));
    Object localObject3 = ((StringBuilder)localObject2).toString();
    localObject2 = (AVNotifyCenter.VideoRoomInfo)this.K.get(localObject1);
    localObject3 = (AVNotifyCenter.VideoRoomInfo)this.K.get(localObject3);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(String.valueOf(paramLong));
    ((StringBuilder)localObject1).append(String.valueOf(12));
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject1 = (AVNotifyCenter.VideoRoomInfo)this.K.get(localObject1);
    int i1 = e(paramLong);
    if ((i1 != 0) && (this.a.getAVNotifyCenter().a(1, paramLong)))
    {
      if (i1 != 12) {
        localObject1 = null;
      }
      if (i1 == 2) {
        localObject1 = localObject2;
      }
      if (i1 != 10) {
        break label280;
      }
    }
    else
    {
      if ((localObject1 == null) || (((AVNotifyCenter.VideoRoomInfo)localObject1).c <= 0)) {
        localObject1 = null;
      }
      if ((localObject2 == null) || (((AVNotifyCenter.VideoRoomInfo)localObject2).c <= 0)) {
        localObject2 = localObject1;
      }
      localObject1 = localObject2;
      if (localObject3 == null) {
        break label280;
      }
      localObject1 = localObject2;
      if (((AVNotifyCenter.VideoRoomInfo)localObject3).c <= 0) {
        break label280;
      }
    }
    localObject1 = localObject3;
    label280:
    if (AudioHelper.e())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getChoosedRoom, groupid[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("], avtype[");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append("], VideoRoomInfo[");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("]");
      QLog.w("AVNotifyCenter", 1, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public boolean f(int paramInt, long paramLong)
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
      if (this.v.size() == 0) {
        return false;
      }
      return this.v.containsKey(Long.valueOf(paramLong));
    }
    if (paramInt == 1)
    {
      if (this.w.size() == 0) {
        return false;
      }
      return this.w.containsKey(Long.valueOf(paramLong));
    }
    if (QLog.isColorLevel()) {
      QLog.e("AVNotifyCenter", 2, "hasMultiVideo --> RelationType is Wrong");
    }
    return false;
  }
  
  public boolean f(String paramString)
  {
    try
    {
      boolean bool = this.z.containsKey(paramString);
      if (AudioHelper.e())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("removeChatSession, sessionId[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("], exist[");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append("], mAvChatDataMap[");
        ((StringBuilder)localObject).append(this.z.size());
        ((StringBuilder)localObject).append("]");
        QLog.w("AVNotifyCenter", 1, ((StringBuilder)localObject).toString());
      }
      if (!bool) {
        return false;
      }
      this.z.remove(paramString);
      Object localObject = this.B;
      a("removeChatSession", null);
      if (this.z.isEmpty())
      {
        this.m = 0L;
        if ((this.l != null) && (this.f != null)) {
          this.f.removeCallbacks(this.l);
        }
      }
      if (AudioHelper.e())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeChatSession, end, sessionId[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], exist[");
        localStringBuilder.append(bool);
        localStringBuilder.append("], mAvChatDataMap[");
        localStringBuilder.append(this.z.size());
        localStringBuilder.append("], lastChatData[");
        localStringBuilder.append(localObject);
        localStringBuilder.append("], mActiveChatData[");
        localStringBuilder.append(this.B);
        localStringBuilder.append("]");
        QLog.w("AVNotifyCenter", 1, localStringBuilder.toString());
      }
      return true;
    }
    finally {}
  }
  
  public int g(String paramString)
  {
    paramString = b(paramString, false);
    if (paramString != null) {
      return paramString.c;
    }
    return 0;
  }
  
  public long g()
  {
    return this.B.h;
  }
  
  public String g(long paramLong)
  {
    if (this.x.containsKey(Long.valueOf(paramLong)))
    {
      String str1 = ((AVPhoneUserInfo)this.x.get(Long.valueOf(paramLong))).telInfo.mobile;
      String str2 = e(str1);
      if (str2 != null) {
        return str2;
      }
      return PstnUtils.a(str1, 4);
    }
    return null;
  }
  
  public int h()
  {
    return this.B.i;
  }
  
  public Vector<AVNotifyCenter.UserInfo> h(long paramLong)
  {
    Object localObject = this.w;
    if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(Long.valueOf(paramLong))))
    {
      localObject = (AVNotifyCenter.GAudioRoomInfo)this.w.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = ((AVNotifyCenter.GAudioRoomInfo)localObject).b;
        if (localObject != null) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public void h(String paramString)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("removeOtherTerminalAvChating peerUin = ");
    ((StringBuilder)???).append(paramString);
    QLog.d("AVNotifyCenter", 1, ((StringBuilder)???).toString());
    synchronized (this.k)
    {
      if (this.k.containsKey(paramString))
      {
        QLog.d("AVNotifyCenter", 1, "removeOtherTerminalAvChating remove true");
        this.k.remove(paramString);
      }
      return;
    }
  }
  
  public String i()
  {
    return this.G;
  }
  
  public String i(long paramLong)
  {
    synchronized (this.k)
    {
      Object localObject2 = this.k.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (((AVNotifyCenter.OtherTerChatingRoomInfo)this.k.get(str)).a == paramLong)
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
  
  public boolean i(String paramString)
  {
    synchronized (this.k)
    {
      if (this.k.containsKey(paramString))
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
  
  public int j()
  {
    return this.E;
  }
  
  public long j(String paramString)
  {
    synchronized (this.k)
    {
      if (this.k.containsKey(paramString))
      {
        AVNotifyCenter.OtherTerChatingRoomInfo localOtherTerChatingRoomInfo = (AVNotifyCenter.OtherTerChatingRoomInfo)this.k.get(paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getOtherTerminalAvChattingRoomId roomInfo.mRoomId=");
        localStringBuilder.append(localOtherTerChatingRoomInfo.a);
        localStringBuilder.append(", peerUin=");
        localStringBuilder.append(paramString);
        QLog.d("AVNotifyCenter", 1, localStringBuilder.toString());
        long l1 = localOtherTerChatingRoomInfo.a;
        return l1;
      }
      return 0L;
    }
  }
  
  public void j(long paramLong)
  {
    this.m = paramLong;
  }
  
  public int k()
  {
    return this.F;
  }
  
  public int k(String paramString)
  {
    synchronized (this.k)
    {
      if (this.k.containsKey(paramString))
      {
        AVNotifyCenter.OtherTerChatingRoomInfo localOtherTerChatingRoomInfo = (AVNotifyCenter.OtherTerChatingRoomInfo)this.k.get(paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getOtherTermianlAvChatingType roomInfo.mSessionType=");
        localStringBuilder.append(localOtherTerChatingRoomInfo.b);
        localStringBuilder.append(", peerUin=");
        localStringBuilder.append(paramString);
        QLog.d("AVNotifyCenter", 1, localStringBuilder.toString());
        int i1 = localOtherTerChatingRoomInfo.b;
        return i1;
      }
      return 0;
    }
  }
  
  public void k(long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(String.valueOf(paramLong));
    ((StringBuilder)localObject1).append(10);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(String.valueOf(paramLong));
    ((StringBuilder)localObject2).append(2);
    localObject2 = ((StringBuilder)localObject2).toString();
    Map localMap = this.K;
    if (localMap != null)
    {
      localMap.remove(localObject1);
      this.K.remove(localObject2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, String.format("removeVideoRoomInfo, groupid: %s", new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public long l()
  {
    return this.H;
  }
  
  public void l(String paramString)
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
  
  public int m()
  {
    return this.I;
  }
  
  public int m(String paramString)
  {
    paramString = (Integer)this.h.get(paramString);
    if (paramString == null) {
      return 2;
    }
    return paramString.intValue();
  }
  
  public String n()
  {
    return this.J;
  }
  
  public boolean o()
  {
    return this.l != null;
  }
  
  public boolean p()
  {
    return this.B.j;
  }
  
  public boolean q()
  {
    return this.B.g;
  }
  
  public boolean r()
  {
    return this.p;
  }
  
  public Map s()
  {
    return this.d;
  }
  
  public int t()
  {
    return this.B.c;
  }
  
  public int u()
  {
    int i2 = this.B.d;
    int i1 = i2;
    if (i2 == 21) {
      i1 = 1011;
    }
    return i1;
  }
  
  public String v()
  {
    return this.B.e;
  }
  
  public String w()
  {
    return this.B.f;
  }
  
  void x()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clearMultiRoomInfos, AvChatData[");
    ((StringBuilder)localObject).append(this.B);
    ((StringBuilder)localObject).append("]");
    QLog.d("AVNotifyCenter", 1, ((StringBuilder)localObject).toString());
    localObject = this.B;
    ((AVNotifyCenter.AvChatData)localObject).i = 0;
    ((AVNotifyCenter.AvChatData)localObject).h = 0L;
    ((AVNotifyCenter.AvChatData)localObject).k = false;
    this.v.clear();
    this.B = this.A;
  }
  
  boolean y()
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
  
  public String z()
  {
    return UITools.a(this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter
 * JD-Core Version:    0.7.0.1
 */