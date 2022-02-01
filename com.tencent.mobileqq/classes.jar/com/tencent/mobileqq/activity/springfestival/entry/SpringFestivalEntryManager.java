package com.tencent.mobileqq.activity.springfestival.entry;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.springfestival.Const;
import com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfigManager;
import com.tencent.mobileqq.activity.springfestival.entry.model.BaseActivityData;
import com.tencent.mobileqq.activity.springfestival.entry.model.BreathLightData;
import com.tencent.mobileqq.activity.springfestival.entry.model.CommonData;
import com.tencent.mobileqq.activity.springfestival.entry.model.EntryConfigBean;
import com.tencent.mobileqq.activity.springfestival.entry.model.MiniAppEntryData;
import com.tencent.mobileqq.activity.springfestival.entry.model.MsgTabBannerData;
import com.tencent.mobileqq.activity.springfestival.entry.model.PendantData;
import com.tencent.mobileqq.activity.springfestival.entry.model.PopBannerData;
import com.tencent.mobileqq.activity.springfestival.entry.model.RedPacketResultData;
import com.tencent.mobileqq.activity.springfestival.entry.model.TimeInfo;
import com.tencent.mobileqq.activity.springfestival.entry.model.UserData;
import com.tencent.mobileqq.activity.springfestival.entry.model.UserData.UserDataItem;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Event;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SpringFestivalEntryManager
  implements Handler.Callback, IPreloadRes, ITaskManager, IZipResCheck, IZipResCheck.OnZipResCheckCallback, Manager
{
  private static final boolean[] B = { 0, 0, 0, 0, 0 };
  private static final int[] C = { 2131230820, 2131230822, 2131230821, 2131230819, 2131230823 };
  static SimpleDateFormat b = new SimpleDateFormat("yyyy_MM_dd");
  private final int[] A = { 0, 0, 0, 0, 0 };
  private int D = 0;
  SpringFestivalRedpacketConfigManager a;
  int c = 4;
  SoundPool.OnLoadCompleteListener d = new SpringFestivalEntryManager.17(this);
  private QQAppInterface e;
  private volatile EntryConfigBean f;
  private volatile UserData g;
  private List<Party.PartyTask> h;
  private Handler i;
  private Handler j;
  private volatile int k = 0;
  private ITaskCallback l;
  private IPreloadRes m;
  private IZipResCheck n;
  private volatile PopBannerData o;
  private volatile MsgTabBannerData p;
  private volatile BaseActivityData q;
  private long r;
  private volatile boolean s;
  private volatile boolean t;
  private RedPacketResultData u;
  private long v;
  private long w;
  private int x = 1;
  private boolean y = false;
  private SoundPool z;
  
  public SpringFestivalEntryManager(QQAppInterface paramQQAppInterface)
  {
    this.e = paramQQAppInterface;
    this.h = Collections.synchronizedList(new LinkedList());
    this.j = new Handler(ThreadManagerV2.getUIHandlerV2().getLooper());
    this.i = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.m = new PreloadResHandler();
    this.n = new ZipResCheckHandler(this);
    this.a = ((SpringFestivalRedpacketConfigManager)paramQQAppInterface.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER));
    b(new SpringFestivalEntryManager.1(this));
  }
  
  private void a(int paramInt, long paramLong, Object paramObject)
  {
    if (paramInt == 4002)
    {
      if ((paramObject instanceof PopBannerData)) {
        paramObject = (PopBannerData)paramObject;
      } else {
        paramObject = this.o;
      }
      paramObject = new Party.PartyTask(paramInt, paramLong, paramObject);
    }
    else if (paramInt == 5002)
    {
      if ((paramObject instanceof MsgTabBannerData)) {
        paramObject = (MsgTabBannerData)paramObject;
      } else {
        paramObject = this.p;
      }
      paramObject = new Party.PartyTask(paramInt, paramLong, paramObject);
    }
    else
    {
      if ((paramObject instanceof BaseActivityData)) {
        paramObject = (BaseActivityData)paramObject;
      } else {
        paramObject = this.q;
      }
      paramObject = new Party.PartyTask(paramInt, paramLong, paramObject);
    }
    if (QLog.isColorLevel()) {
      QLog.i("shua2021_SpringFestivalEntryManager", 2, String.format("onTaskNeed2ExecuteForClear task=%s", new Object[] { Party.b(paramInt) }));
    }
    a(paramObject);
  }
  
  private void a(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleTaskMsg isSpeedUp: ");
    localStringBuilder.append(j());
    localStringBuilder.append(" currentTime is: ");
    localStringBuilder.append(TimeFormatterUtils.f(i()));
    QLog.i("shua2021_SpringFestivalEntryManager", 1, localStringBuilder.toString());
    if (paramMessage.arg1 != 1)
    {
      paramMessage = null;
      if (this.h.size() > 0)
      {
        paramMessage = (Party.PartyTask)this.h.remove(0);
        a(paramMessage);
      }
      QLog.i("shua2021_SpringFestivalEntryManager", 1, String.format("handleTaskMsg task is %s", new Object[] { paramMessage }));
    }
    else
    {
      QLog.i("shua2021_SpringFestivalEntryManager", 1, "handleTaskMsg just loop check. do nothing.");
    }
    if (!this.h.isEmpty())
    {
      t();
      return;
    }
    b(3);
  }
  
  private void a(Party.PartyTask paramPartyTask)
  {
    Object localObject1 = this.q;
    Object localObject2 = this.o;
    MsgTabBannerData localMsgTabBannerData = this.p;
    String str = "null";
    if (localObject1 == null) {
      localObject1 = "null";
    } else {
      localObject1 = ((BaseActivityData)localObject1).toSimpleString();
    }
    if (localObject2 == null) {
      localObject2 = "null";
    } else {
      localObject2 = ((PopBannerData)localObject2).toSimpleString();
    }
    if (localMsgTabBannerData != null) {
      str = localMsgTabBannerData.toSimpleString();
    }
    QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("onTaskNeed2Execute --> %s , \ncurBaseActivityData=%s, \ncurPopBannerData=%s, \ncurMsgTabBannerData=%s", new Object[] { paramPartyTask, localObject1, localObject2, str }));
    int i1 = paramPartyTask.a;
    if (i1 != 2001)
    {
      if (i1 != 2002)
      {
        if (i1 != 3001)
        {
          if (i1 != 3002)
          {
            if (i1 != 4001)
            {
              if (i1 != 4002)
              {
                if (i1 != 5001)
                {
                  if (i1 != 5002)
                  {
                    switch (i1)
                    {
                    default: 
                      return;
                    case 1004: 
                      a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.6(this, paramPartyTask)));
                      return;
                    case 1003: 
                      a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.5(this, paramPartyTask)));
                      return;
                    case 1002: 
                      a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.4(this, paramPartyTask)));
                      return;
                    }
                    a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.3(this, paramPartyTask)));
                    return;
                  }
                  a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.14(this, paramPartyTask)));
                  return;
                }
                a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.13(this, paramPartyTask)));
                return;
              }
              a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.12(this, paramPartyTask)));
              return;
            }
            a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.11(this, paramPartyTask)));
            return;
          }
          a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.10(this, paramPartyTask)));
          return;
        }
        a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.9(this, paramPartyTask)));
        return;
      }
      a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.8(this, paramPartyTask)));
      return;
    }
    a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.7(this, paramPartyTask)));
  }
  
  private void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportBrushAbnormalQuit activityID = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",leftCountDownDuration = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("shua2021_SpringFestivalEntryManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("active_id", paramString);
    ((Map)localObject).put("ext1", String.valueOf(paramLong / 1000L));
    SpringHbReporter.a(ReportConstant.Event.l, 0, 0, (Map)localObject, "abnormal_quit");
  }
  
  private boolean a(Object paramObject)
  {
    if ((paramObject instanceof BaseActivityData))
    {
      if (((BaseActivityData)paramObject).equals(this.q)) {
        return true;
      }
    }
    else if ((paramObject == null) && (this.q != null)) {
      return true;
    }
    return false;
  }
  
  private static boolean a(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  private long b(BaseActivityData paramBaseActivityData)
  {
    long l2 = paramBaseActivityData.getTaskTime().end - paramBaseActivityData.getTaskAboutToOverDuration() * 1000;
    long l1 = l2;
    if (l2 < paramBaseActivityData.getTaskTime().begin) {
      l1 = paramBaseActivityData.getTaskTime().begin;
    }
    return l1;
  }
  
  private void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updatePartyState ");
    localStringBuilder.append(Party.a(this.k));
    localStringBuilder.append(" ==> ");
    localStringBuilder.append(Party.a(paramInt));
    QLog.i("shua2021_SpringFestivalEntryManager", 1, localStringBuilder.toString());
    this.k = paramInt;
  }
  
  private void b(EntryConfigBean paramEntryConfigBean)
  {
    if (paramEntryConfigBean != null) {}
    try
    {
      int i1 = paramEntryConfigBean.activities.size();
      if (i1 > 0) {
        try
        {
          String str = g(i());
          Object localObject1 = f();
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("pendant_close_byday");
          ((StringBuilder)localObject2).append(str);
          boolean bool = ((SharedPreferences)localObject1).getBoolean(((StringBuilder)localObject2).toString(), false);
          QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("preHandleOnGrabActivitiesClosedToday today=%s isClosed=%b", new Object[] { str, Boolean.valueOf(bool) }));
          if (!bool) {
            return;
          }
          localObject2 = new ArrayList();
          ((List)localObject2).addAll(paramEntryConfigBean.activities);
          paramEntryConfigBean = BaseApplicationImpl.getApplication().getResources().getString(2131897349);
          i1 = ((List)localObject2).size() - 1;
          while (i1 >= 0)
          {
            BaseActivityData localBaseActivityData = (BaseActivityData)((List)localObject2).get(i1);
            localObject1 = paramEntryConfigBean;
            if (str.equals(g(localBaseActivityData.getConfigTime().begin))) {
              if ((localBaseActivityData.getType() == 2) && (!TextUtils.isEmpty(localBaseActivityData.getMiniEntryData().endWording)))
              {
                localObject1 = localBaseActivityData.getMiniEntryData().endWording;
              }
              else if (localBaseActivityData.getType() != 1)
              {
                localObject1 = paramEntryConfigBean;
                if (localBaseActivityData.getType() != 2) {}
              }
              else
              {
                localBaseActivityData.getMiniEntryData().endWording = paramEntryConfigBean;
                localBaseActivityData.getMiniEntryData().preWording = "";
                localObject1 = paramEntryConfigBean;
              }
            }
            i1 -= 1;
            paramEntryConfigBean = (EntryConfigBean)localObject1;
          }
          QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("preHandleOnGrabActivitiesClosedToday return", new Object[0]));
        }
        catch (Throwable paramEntryConfigBean)
        {
          SpringHbMonitorReporter.a(207, paramEntryConfigBean, new String[0]);
          QLog.d("shua2021_SpringFestivalEntryManager", 1, paramEntryConfigBean.getMessage(), paramEntryConfigBean);
          return;
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramEntryConfigBean;
    }
  }
  
  private boolean b(Object paramObject)
  {
    if ((paramObject instanceof PopBannerData))
    {
      if (((PopBannerData)paramObject).equals(this.o)) {
        return true;
      }
    }
    else if ((paramObject == null) && (this.o != null)) {
      return true;
    }
    return false;
  }
  
  private void c(EntryConfigBean paramEntryConfigBean)
  {
    if (paramEntryConfigBean != null) {}
    try
    {
      int i1 = paramEntryConfigBean.activities.size();
      if (i1 > 0) {
        try
        {
          long l1 = i();
          ArrayList localArrayList = new ArrayList();
          localArrayList.addAll(paramEntryConfigBean.activities);
          i1 = localArrayList.size() - 1;
          while (i1 >= 0)
          {
            paramEntryConfigBean = (BaseActivityData)localArrayList.get(i1);
            long l2 = paramEntryConfigBean.getConfigTime().end;
            if ((paramEntryConfigBean.getType() == 2) && (l1 > l2))
            {
              UserData.UserDataItem localUserDataItem = c(paramEntryConfigBean.id);
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("checkAndReportAbnormalQuitBrushActivitys ,act.id = ");
                localStringBuilder.append(paramEntryConfigBean.id);
                localStringBuilder.append(",isAbnormalQuit = ");
                localStringBuilder.append(localUserDataItem.isAbnormalQuit);
                localStringBuilder.append(",hasReportedAbnormalQuit = ");
                localStringBuilder.append(localUserDataItem.hasReportedAbnormalQuit);
                QLog.d("shua2021_SpringFestivalEntryManager", 2, localStringBuilder.toString());
              }
              if ((localUserDataItem.isAbnormalQuit) && (!localUserDataItem.hasReportedAbnormalQuit))
              {
                a(paramEntryConfigBean.id, localUserDataItem.leftCountDownDuration);
                localUserDataItem.hasReportedAbnormalQuit = true;
                b();
              }
            }
            i1 -= 1;
          }
          QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("checkAndReportAbnormalQuitBrushActivitys return", new Object[0]));
        }
        catch (Throwable paramEntryConfigBean)
        {
          QLog.d("shua2021_SpringFestivalEntryManager", 1, "checkAndReportAbnormalQuitBrushActivities exception", paramEntryConfigBean);
          return;
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramEntryConfigBean;
    }
  }
  
  private boolean c(Object paramObject)
  {
    if ((paramObject instanceof MsgTabBannerData))
    {
      if (((MsgTabBannerData)paramObject).equals(this.p)) {
        return true;
      }
    }
    else if ((paramObject == null) && (this.p != null)) {
      return true;
    }
    return false;
  }
  
  private void d(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("runCurrentTask. isPeedUp: ");
      ((StringBuilder)localObject1).append(j());
      ((StringBuilder)localObject1).append(" currentTime is: ");
      ((StringBuilder)localObject1).append(TimeFormatterUtils.f(paramLong));
      ((StringBuilder)localObject1).append(" taskSize:");
      ((StringBuilder)localObject1).append(this.h.size());
      QLog.i("shua2021_SpringFestivalEntryManager", 2, ((StringBuilder)localObject1).toString());
      localObject1 = this.h.iterator();
      int i1 = 0;
      while (((Iterator)localObject1).hasNext())
      {
        QLog.d("shua2021_SpringFestivalEntryManager", 2, String.format("before runCurrentTask [%d] task= %s", new Object[] { Integer.valueOf(i1), ((Party.PartyTask)((Iterator)localObject1).next()).toString() }));
        i1 += 1;
      }
    }
    if (a(this.h))
    {
      e(paramLong);
      if (QLog.isColorLevel()) {
        QLog.w("shua2021_SpringFestivalEntryManager", 2, "runCurrentTask, taskList is empty return");
      }
      return;
    }
    b(2);
    Object localObject2 = c(paramLong);
    String str = "null";
    if (localObject2 == null) {
      localObject1 = "null";
    } else {
      localObject1 = ((BaseActivityData)localObject2).toSimpleString();
    }
    QLog.i("shua2021_SpringFestivalEntryManager", 1, String.format("【findOnGoingActivity】 %s", new Object[] { localObject1 }));
    if (localObject2 == null)
    {
      a(2002, paramLong, null);
      a(3002, paramLong, null);
      a(1004, paramLong, null);
      if (QLog.isColorLevel()) {
        QLog.i("shua2021_SpringFestivalEntryManager", 2, "runCurrentTask. mCurrentActivityInfo is null,hide pendent and return.");
      }
    }
    else
    {
      localObject1 = this.q;
      if ((localObject1 != null) && (!((BaseActivityData)localObject1).equals(localObject2)))
      {
        QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("should close pre_activity %s", new Object[] { ((BaseActivityData)localObject1).toSimpleString() }));
        a(2002, paramLong, localObject1);
        a(3002, paramLong, localObject1);
        a(1004, paramLong, localObject1);
      }
      long l1 = 0L;
      boolean bool;
      if (((BaseActivityData)localObject2).getTaskAboutToOverDuration() > 0)
      {
        l1 = b((BaseActivityData)localObject2);
        bool = Const.b(new TimeInfo(l1, ((BaseActivityData)localObject2).getTaskTime().end), paramLong);
      }
      else
      {
        bool = false;
      }
      if (bool) {
        a(new Party.PartyTask(1003, l1, localObject2));
      } else if ((((BaseActivityData)localObject2).getPeakDelayMs() > 0) && (!((BaseActivityData)localObject2).scheduleTaskAfterPeak()))
      {
        if (paramLong < ((BaseActivityData)localObject2).getTaskTime().begin + ((BaseActivityData)localObject2).getPeakDelayMs()) {
          a(new Party.PartyTask(1001, ((BaseActivityData)localObject2).getTaskTime().begin, localObject2));
        } else {
          a(new Party.PartyTask(1002, ((BaseActivityData)localObject2).getTaskTime().begin + ((BaseActivityData)localObject2).getPeakDelayMs(), localObject2));
        }
      }
      else {
        a(new Party.PartyTask(1002, ((BaseActivityData)localObject2).getTaskTime().begin, localObject2));
      }
      if (((BaseActivityData)localObject2).schedulePendantNBreathLight())
      {
        if ((((BaseActivityData)localObject2).pendantData != null) && (Const.a(((BaseActivityData)localObject2).pendantData.getTaskTime(), paramLong))) {
          a(new Party.PartyTask(2001, ((BaseActivityData)localObject2).pendantData.getTaskTime().begin, localObject2));
        } else {
          a(2002, paramLong, localObject2);
        }
        if ((((BaseActivityData)localObject2).breathLightData != null) && (Const.a(((BaseActivityData)localObject2).breathLightData.getTaskTime(), paramLong))) {
          a(new Party.PartyTask(3001, ((BaseActivityData)localObject2).getTaskTime().begin, localObject2));
        } else {
          a(3002, paramLong, localObject2);
        }
      }
    }
    localObject2 = a(paramLong);
    if (localObject2 == null) {
      localObject1 = "null";
    } else {
      localObject1 = ((PopBannerData)localObject2).toSimpleString();
    }
    QLog.i("shua2021_SpringFestivalEntryManager", 1, String.format("【findOnGoingPopBanner】 %s", new Object[] { localObject1 }));
    if (localObject2 == null)
    {
      a(4002, paramLong, null);
    }
    else
    {
      localObject1 = this.o;
      if ((localObject1 != null) && (((PopBannerData)localObject1).getTaskTime().end == paramLong))
      {
        QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("should close pre popBanner id=%d", new Object[] { ((PopBannerData)localObject1).id }));
        a(4002, paramLong, localObject1);
      }
      a(new Party.PartyTask(4001, ((PopBannerData)localObject2).getTaskTime().begin, localObject2));
    }
    localObject2 = b(paramLong);
    if (localObject2 == null) {
      localObject1 = str;
    } else {
      localObject1 = ((MsgTabBannerData)localObject2).toSimpleString();
    }
    QLog.i("shua2021_SpringFestivalEntryManager", 1, String.format("【findOnGoingMsgTabBanner】 %s", new Object[] { localObject1 }));
    if (localObject2 == null)
    {
      a(5002, paramLong, null);
      return;
    }
    Object localObject1 = this.p;
    if ((localObject1 != null) && (((MsgTabBannerData)localObject1).getTaskTime().end == paramLong))
    {
      QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("should close pre msgTabBanner id=%d", new Object[] { ((MsgTabBannerData)localObject1).id }));
      a(5002, paramLong, localObject1);
    }
    a(new Party.PartyTask(5001, ((MsgTabBannerData)localObject2).getTaskTime().begin, localObject2));
  }
  
  private void d(String paramString)
  {
    try
    {
      if (this.g == null)
      {
        UserData localUserData = UserData.read(this.e.getCurrentUin());
        this.g = localUserData;
        QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("initLocalUserData by=%s UserData=%s", new Object[] { paramString, localUserData }));
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void e(long paramLong)
  {
    QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("clearAllTasks currentTime=%s", new Object[] { TimeFormatterUtils.f(paramLong) }));
    this.h.clear();
    this.i.removeMessages(1001);
    b(4);
    a(2002, paramLong, null);
    a(3002, paramLong, null);
    a(1004, paramLong, null);
    a(4002, paramLong, null);
    a(5002, paramLong, null);
  }
  
  public static SharedPreferences f()
  {
    try
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((QQAppInterface)localObject).getCurrentAccountUin());
      localStringBuilder.append("_2021_shuayishua_entrymanager");
      localObject = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      label51:
      break label51;
    }
    return null;
  }
  
  private void f(long paramLong)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearOutOfDataTask before:");
        localStringBuilder.append(this.h);
        QLog.i("shua2021_SpringFestivalEntryManager", 2, localStringBuilder.toString());
      }
      i1 = this.h.size() - 1;
    }
    finally
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        int i1;
        for (;;)
        {
          throw localObject;
        }
        i1 -= 1;
      }
    }
    if (i1 >= 0)
    {
      if (((Party.PartyTask)this.h.get(i1)).b <= paramLong) {
        this.h.remove(i1);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearOutOfDataTask end:");
        localStringBuilder.append(this.h);
        QLog.i("shua2021_SpringFestivalEntryManager", 2, localStringBuilder.toString());
      }
      return;
    }
  }
  
  @NotNull
  private String g(long paramLong)
  {
    try
    {
      String str = b.format(Long.valueOf(paramLong));
      if (str == null) {
        return "";
      }
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  private void q()
  {
    try
    {
      UserData localUserData = this.g;
      if (localUserData != null) {
        UserData.write(this.e.getCurrentUin(), localUserData);
      }
    }
    catch (Throwable localThrowable)
    {
      SpringHbMonitorReporter.a(201, localThrowable, new String[0]);
      QLog.d("shua2021_SpringFestivalEntryManager", 1, localThrowable.getMessage(), localThrowable);
    }
    if (QLog.isColorLevel()) {
      QLog.i("shua2021_SpringFestivalEntryManager", 2, "saveLocalUserData");
    }
  }
  
  private void r()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("generateTasksAndLaunch,");
    localStringBuilder.append(System.currentTimeMillis() - this.r);
    QLog.i("shua2021_SpringFestivalEntryManager", 1, localStringBuilder.toString());
    this.r = System.currentTimeMillis();
    this.s = false;
    b(new SpringFestivalEntryManager.2(this));
  }
  
  private void s()
  {
    label81:
    try
    {
      QLog.i("shua2021_SpringFestivalEntryManager", 1, String.format("checkAndScheduleTask isZipResCheckSuc=%b", new Object[] { Boolean.valueOf(this.t) }));
      bool = this.t;
      if (!bool) {
        return;
      }
      try
      {
        long l1 = i();
        d(l1);
        f(l1);
        t();
      }
      catch (Throwable localThrowable1) {}
    }
    finally {}
    try
    {
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break label203;
      }
      bool = true;
    }
    catch (Throwable localThrowable2)
    {
      break label146;
      bool = false;
      break label81;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isMainThread=");
    localStringBuilder.append(bool);
    localStringBuilder.append("stack=");
    localStringBuilder.append(Log.getStackTraceString(localThrowable1));
    SpringHbMonitorReporter.a(204, localThrowable1, new String[] { localStringBuilder.toString() });
    label146:
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkAndScheduleTask ex. ");
    localStringBuilder.append(localThrowable1.getMessage());
    QLog.e("shua2021_SpringFestivalEntryManager", 1, localStringBuilder.toString(), localThrowable1);
  }
  
  private void t()
  {
    try
    {
      QLog.i("shua2021_SpringFestivalEntryManager", 1, "scheduleNextTask.");
      this.i.removeMessages(1001);
      if ((this.h != null) && (!this.h.isEmpty()))
      {
        Object localObject1 = (Party.PartyTask)this.h.get(0);
        long l2 = ((Party.PartyTask)localObject1).b - i();
        if (l2 < -300000L)
        {
          s();
          QLog.i("shua2021_SpringFestivalEntryManager", 1, "scheduleNextTask. delay time < -5 minute, checkAndScheduleTask.");
        }
        else if (l2 < 86400000L)
        {
          Object localObject3 = Message.obtain(this.i, 1001);
          long l1 = l2;
          if (l2 > 300000L)
          {
            ((Message)localObject3).arg1 = 1;
            l1 = 300000L;
          }
          l2 = l1;
          if (j()) {
            l2 = l1 / this.x;
          }
          this.i.sendMessageDelayed((Message)localObject3, l2);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("scheduleNextTask. delay time is: ");
          ((StringBuilder)localObject3).append(l2);
          ((StringBuilder)localObject3).append(" next task is: ");
          ((StringBuilder)localObject3).append(((Party.PartyTask)localObject1).toString());
          QLog.i("shua2021_SpringFestivalEntryManager", 1, ((StringBuilder)localObject3).toString());
          if (QLog.isColorLevel())
          {
            localObject1 = this.h.iterator();
            int i1 = 0;
            while (((Iterator)localObject1).hasNext())
            {
              QLog.d("shua2021_SpringFestivalEntryManager", 2, String.format("scheduleNextTask [%d] task= %s", new Object[] { Integer.valueOf(i1), ((Party.PartyTask)((Iterator)localObject1).next()).toString() }));
              i1 += 1;
            }
          }
        }
        else
        {
          QLog.i("shua2021_SpringFestivalEntryManager", 1, "scheduleNextTask. delay time beyond 24 hour. do nothing.");
        }
        return;
      }
      QLog.i("shua2021_SpringFestivalEntryManager", 1, "scheduleNextTask. task list is empty. return.");
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  /* Error */
  private void u()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 656	com/tencent/mobileqq/activity/springfestival/entry/SpringFestivalEntryManager:g	Lcom/tencent/mobileqq/activity/springfestival/entry/model/UserData;
    //   6: ifnonnull +40 -> 46
    //   9: aload_0
    //   10: ldc_w 805
    //   13: invokespecial 807	com/tencent/mobileqq/activity/springfestival/entry/SpringFestivalEntryManager:d	(Ljava/lang/String;)V
    //   16: goto +30 -> 46
    //   19: astore_1
    //   20: goto +29 -> 49
    //   23: astore_1
    //   24: sipush 208
    //   27: aload_1
    //   28: iconst_0
    //   29: anewarray 223	java/lang/String
    //   32: invokestatic 507	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(ILjava/lang/Throwable;[Ljava/lang/String;)V
    //   35: ldc 214
    //   37: iconst_1
    //   38: aload_1
    //   39: invokevirtual 510	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   42: aload_1
    //   43: invokestatic 775	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	SpringFestivalEntryManager
    //   19	1	1	localObject	Object
    //   23	29	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	16	19	finally
    //   24	46	19	finally
    //   2	16	23	java/lang/Throwable
  }
  
  private void v()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        QLog.i("shua2021_SpringFestivalEntryManager", 2, String.format("initLocalCacheInfo speedUp=%b", new Object[] { Boolean.valueOf(j()) }));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      SpringHbMonitorReporter.a(209, localThrowable, new String[0]);
      QLog.i("shua2021_SpringFestivalEntryManager", 1, localThrowable.getMessage(), localThrowable);
    }
  }
  
  private void w()
  {
    try
    {
      if (this.f != null)
      {
        this.f.preHandleConfigs();
        b(this.f);
        c(this.f);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void x()
  {
    try
    {
      this.h.clear();
      if (this.f == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("shua2021_SpringFestivalEntryManager", 2, "buildAndSortPartyTaskQueue entryConfig=null return");
        }
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.f.activities.iterator();
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject2 = (BaseActivityData)localIterator.next();
        if ((((BaseActivityData)localObject2).getPeakDelayMs() > 0) && (!((BaseActivityData)localObject2).scheduleTaskAfterPeak()))
        {
          localLinkedList.add(new Party.PartyTask(1001, ((BaseActivityData)localObject2).getTaskTime().begin, localObject2));
          localLinkedList.add(new Party.PartyTask(1002, ((BaseActivityData)localObject2).getTaskTime().begin + ((BaseActivityData)localObject2).getPeakDelayMs(), localObject2));
        }
        else
        {
          localLinkedList.add(new Party.PartyTask(1002, ((BaseActivityData)localObject2).getTaskTime().begin, localObject2));
        }
        if (((BaseActivityData)localObject2).schedulePendantNBreathLight())
        {
          if (((BaseActivityData)localObject2).pendantData != null)
          {
            localLinkedList.add(new Party.PartyTask(2001, ((BaseActivityData)localObject2).pendantData.getTaskTime().begin, localObject2));
            localLinkedList.add(new Party.PartyTask(2002, ((BaseActivityData)localObject2).pendantData.getTaskTime().end, localObject2));
          }
          if (((BaseActivityData)localObject2).breathLightData != null)
          {
            localLinkedList.add(new Party.PartyTask(3001, ((BaseActivityData)localObject2).breathLightData.getTaskTime().begin, localObject2));
            localLinkedList.add(new Party.PartyTask(3002, ((BaseActivityData)localObject2).breathLightData.getTaskTime().end, localObject2));
          }
        }
        if (((BaseActivityData)localObject2).getTaskAboutToOverDuration() > 0) {
          localLinkedList.add(new Party.PartyTask(1003, b((BaseActivityData)localObject2), localObject2));
        }
        localLinkedList.add(new Party.PartyTask(1004, ((BaseActivityData)localObject2).getTaskTime().end, localObject2));
      }
      localIterator = this.f.popBanners.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (PopBannerData)localIterator.next();
        localLinkedList.add(new Party.PartyTask(4001, ((PopBannerData)localObject2).getTaskTime().begin, localObject2));
        localLinkedList.add(new Party.PartyTask(4002, ((PopBannerData)localObject2).getTaskTime().end, localObject2));
      }
      localIterator = this.f.msgTabBanners.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (MsgTabBannerData)localIterator.next();
        localLinkedList.add(new Party.PartyTask(5001, ((MsgTabBannerData)localObject2).getTaskTime().begin, localObject2));
        localLinkedList.add(new Party.PartyTask(5002, ((MsgTabBannerData)localObject2).getTaskTime().end, localObject2));
      }
      if (!a(localLinkedList))
      {
        Collections.sort(localLinkedList, new SpringFestivalEntryManager.15(this));
        this.h.addAll(localLinkedList);
      }
      QLog.i("shua2021_SpringFestivalEntryManager", 1, String.format("buildAndSortPartyTaskQueue list=%s", new Object[] { this.h }));
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  private boolean y()
  {
    int i1 = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i1 >= 30) {
      if ((!Build.MODEL.equalsIgnoreCase("M2004J7AC")) && (!Build.MODEL.equalsIgnoreCase("M2006J10C")))
      {
        bool1 = bool2;
        if (!Build.MODEL.equalsIgnoreCase("M2004J7BC")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @Nullable
  public Bitmap a(String paramString1, String paramString2)
  {
    return this.m.a(paramString1, paramString2);
  }
  
  @Nullable
  public Bitmap a(String paramString1, String paramString2, String paramString3)
  {
    return this.m.a(paramString1, paramString2, paramString3);
  }
  
  public PopBannerData a(long paramLong)
  {
    try
    {
      Object localObject1 = this.f;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = this.f.popBanners.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        PopBannerData localPopBannerData = (PopBannerData)((Iterator)localObject1).next();
        boolean bool = Const.b(localPopBannerData.getTaskTime(), paramLong);
        if (bool) {
          return localPopBannerData;
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  @NotNull
  public UserData a()
  {
    if (this.g == null) {
      d("getUserData");
    }
    return this.g;
  }
  
  @Nullable
  public String a(String paramString)
  {
    return this.m.a(paramString);
  }
  
  public void a(int paramInt)
  {
    if (y())
    {
      QLog.d("shua2021_SpringFestivalEntryManager", 1, "playSound return for special phone");
      return;
    }
    a(paramInt, false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder1;
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("playSound, ");
      localStringBuilder1.append(paramInt);
      localStringBuilder1.append(", ");
      localStringBuilder1.append(this.A[paramInt]);
      localStringBuilder1.append(", ");
      localStringBuilder1.append(B[paramInt]);
      localStringBuilder1.append(", mPlayCountDownStreamId=");
      localStringBuilder1.append(this.D);
      localStringBuilder1.append(", mPlayCountDownState=");
      localStringBuilder1.append(this.c);
      QLog.d("shua2021_SpringFestivalEntryManager", 2, localStringBuilder1.toString());
    }
    if (y())
    {
      QLog.d("shua2021_SpringFestivalEntryManager", 1, "playSound return for special phone");
      return;
    }
    try
    {
      if (this.z == null)
      {
        this.z = new SoundPool(10, 3, 0);
        this.z.setOnLoadCompleteListener(this.d);
      }
      if (paramInt == 2)
      {
        if ((this.c == 4) && (paramBoolean)) {
          return;
        }
        if ((this.c == 1) && (!paramBoolean)) {
          return;
        }
        this.c = 1;
      }
      int i3 = this.A[paramInt];
      if (i3 == 0)
      {
        i1 = this.z.load(this.e.getApp().getApplicationContext(), C[paramInt], 1);
        this.A[paramInt] = i1;
        return;
      }
      int i2 = -1;
      int i1 = i2;
      if (B[paramInt] != 0) {
        if (paramInt != 2)
        {
          i1 = this.z.play(i3, 1.0F, 1.0F, 1, 0, 1.0F);
        }
        else
        {
          i1 = i2;
          if (this.D == 0)
          {
            this.D = this.z.play(i3, 1.0F, 1.0F, 10, -1, 1.0F);
            i1 = i2;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("playSound, ");
        localStringBuilder1.append(paramInt);
        localStringBuilder1.append(", ");
        localStringBuilder1.append(this.A[paramInt]);
        localStringBuilder1.append(", ");
        localStringBuilder1.append(B[paramInt]);
        localStringBuilder1.append(", ");
        localStringBuilder1.append(i1);
        localStringBuilder1.append(", mPlayCountDownStreamId=");
        localStringBuilder1.append(this.D);
        QLog.d("shua2021_SpringFestivalEntryManager", 2, localStringBuilder1.toString());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      SpringHbMonitorReporter.a(210, localThrowable, new String[0]);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("playSound, throwable=");
        localStringBuilder2.append(localThrowable.getMessage());
        QLog.d("shua2021_SpringFestivalEntryManager", 2, localStringBuilder2.toString());
        localThrowable.printStackTrace();
      }
    }
    return;
  }
  
  public void a(IPreloadRes.OnDownloadCallback paramOnDownloadCallback)
  {
    try
    {
      this.m.a(paramOnDownloadCallback);
      return;
    }
    catch (Exception paramOnDownloadCallback)
    {
      QLog.e("shua2021_SpringFestivalEntryManager", 1, paramOnDownloadCallback.getMessage(), paramOnDownloadCallback);
    }
  }
  
  public void a(ITaskCallback paramITaskCallback)
  {
    if (paramITaskCallback != null) {}
    for (;;)
    {
      try
      {
        this.l = new WrapperTaskCallback(paramITaskCallback);
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
          bool = true;
          QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("setTaskCallback clearAllTasks on callback=null isMain=%b", new Object[] { Boolean.valueOf(bool) }));
          if ((this.k != 0) && (this.k != 3) && (this.k != 4)) {
            e(i());
          }
          this.l = null;
          QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("setTaskCallback hasHoldTaskQueue=%b callback=%s", new Object[] { Boolean.valueOf(this.s), paramITaskCallback }));
          if (paramITaskCallback == null) {
            return;
          }
          if (this.s) {
            r();
          }
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void a(EntryConfigBean paramEntryConfigBean)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEntryConfigReady config is: ");
        if (paramEntryConfigBean == null) {
          paramEntryConfigBean = "null";
        } else {
          paramEntryConfigBean = paramEntryConfigBean.toSimpleString();
        }
        localStringBuilder.append(paramEntryConfigBean);
        QLog.i("shua2021_SpringFestivalEntryManager", 2, localStringBuilder.toString());
      }
      QLog.i("shua2021_SpringFestivalEntryManager", 1, "onEntryConfigReady red_packet_2021_entry_close=true, return.");
      return;
    }
    finally {}
  }
  
  public void a(RedPacketResultData paramRedPacketResultData)
  {
    this.u = paramRedPacketResultData;
  }
  
  public void a(Runnable paramRunnable)
  {
    try
    {
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        paramRunnable.run();
        return;
      }
      this.j.post(paramRunnable);
      return;
    }
    catch (Exception paramRunnable)
    {
      QLog.e("shua2021_SpringFestivalEntryManager", 1, paramRunnable.getMessage(), paramRunnable);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = f();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("pendant_show_switch", paramBoolean).apply();
    }
    QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("changePendantShowSwitch %b", new Object[] { Boolean.valueOf(paramBoolean) }));
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    EntryConfigBean localEntryConfigBean = this.f;
    int i1;
    if (localEntryConfigBean != null) {
      i1 = localEntryConfigBean.version;
    } else {
      i1 = 0;
    }
    QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("onZipResCheckDone suc=%b cfgVer=%d thisCfgVer=%d isZipResCheckSuc=%b", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(i1), Boolean.valueOf(this.t) }));
    if ((paramBoolean) && (paramInt == i1) && (!this.t))
    {
      this.t = true;
      b(true);
    }
  }
  
  public boolean a(BaseActivityData paramBaseActivityData)
  {
    for (;;)
    {
      try
      {
        localObject1 = this.f;
        if ((paramBaseActivityData == null) || (localObject1 == null) || (((EntryConfigBean)localObject1).activities.size() <= 0)) {
          continue;
        }
        localObject2 = paramBaseActivityData.pendantData;
        if (localObject2 != null) {}
      }
      finally
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        Object localObject4;
        int i2;
        int i1;
        continue;
        throw paramBaseActivityData;
        continue;
        i1 -= 1;
        paramBaseActivityData = (BaseActivityData)localObject1;
        continue;
      }
      try
      {
        localObject2 = g(i());
        localObject3 = f().edit();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("pendant_close_byday");
        ((StringBuilder)localObject4).append((String)localObject2);
        ((SharedPreferences.Editor)localObject3).putBoolean(((StringBuilder)localObject4).toString(), true).apply();
        QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("notifyCloseAllOnGrabActivitiesToday today=%s", new Object[] { localObject2 }));
        i2 = paramBaseActivityData.pendantData.closeType;
        localObject3 = new ArrayList();
        ((List)localObject3).addAll(((EntryConfigBean)localObject1).activities);
        paramBaseActivityData = BaseApplicationImpl.getApplication().getResources().getString(2131897349);
        i1 = ((List)localObject3).size() - 1;
        if (i1 >= 0)
        {
          localObject4 = (BaseActivityData)((List)localObject3).get(i1);
          localObject1 = paramBaseActivityData;
          if (!((String)localObject2).equals(g(((BaseActivityData)localObject4).getConfigTime().begin))) {
            continue;
          }
          localObject1 = c(((BaseActivityData)localObject4).id);
          ((UserData.UserDataItem)localObject1).hasClickCloseBtn = true;
          ((UserData.UserDataItem)localObject1).pendantCloseType = i2;
          if ((((BaseActivityData)localObject4).getType() == 2) && (!TextUtils.isEmpty(((BaseActivityData)localObject4).getMiniEntryData().endWording)))
          {
            localObject1 = ((BaseActivityData)localObject4).getMiniEntryData().endWording;
            continue;
          }
          if (((BaseActivityData)localObject4).getType() != 1)
          {
            localObject1 = paramBaseActivityData;
            if (((BaseActivityData)localObject4).getType() != 2) {
              continue;
            }
          }
          ((BaseActivityData)localObject4).getMiniEntryData().endWording = paramBaseActivityData;
          ((BaseActivityData)localObject4).getMiniEntryData().preWording = "";
          localObject1 = paramBaseActivityData;
          continue;
        }
        b();
      }
      catch (Throwable paramBaseActivityData)
      {
        SpringHbMonitorReporter.a(206, paramBaseActivityData, new String[0]);
        QLog.d("shua2021_SpringFestivalEntryManager", 1, paramBaseActivityData.getMessage(), paramBaseActivityData);
      }
    }
    return true;
    QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("notifyCloseAllOnGrabActivitiesToday return", new Object[0]));
    return false;
  }
  
  public MsgTabBannerData b(long paramLong)
  {
    try
    {
      Object localObject1 = this.f;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = this.f.msgTabBanners.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        MsgTabBannerData localMsgTabBannerData = (MsgTabBannerData)((Iterator)localObject1).next();
        boolean bool = Const.b(localMsgTabBannerData.getTaskTime(), paramLong);
        if (bool) {
          return localMsgTabBannerData;
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  @Nullable
  public String b(String paramString)
  {
    return this.m.b(paramString);
  }
  
  public void b()
  {
    this.i.sendEmptyMessageDelayed(1002, 1000L);
  }
  
  public void b(IPreloadRes.OnDownloadCallback paramOnDownloadCallback)
  {
    try
    {
      this.m.b(paramOnDownloadCallback);
      return;
    }
    catch (Exception paramOnDownloadCallback)
    {
      QLog.e("shua2021_SpringFestivalEntryManager", 1, paramOnDownloadCallback.getMessage(), paramOnDownloadCallback);
    }
  }
  
  public void b(Runnable paramRunnable)
  {
    this.i.post(paramRunnable);
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshScheduleTask force=");
    ((StringBuilder)localObject).append(paramBoolean);
    localObject = ((StringBuilder)localObject).toString();
    int i2 = 1;
    QLog.d("shua2021_SpringFestivalEntryManager", 1, (String)localObject);
    int i1 = i2;
    if (this.k != 0)
    {
      i1 = i2;
      if (this.k != 3) {
        if (this.k == 4) {
          i1 = i2;
        } else {
          i1 = 0;
        }
      }
    }
    if (((!paramBoolean) && (i1 != 0)) || (this.f == null)) {
      return;
    }
    b(new SpringFestivalEntryManager.16(this));
  }
  
  public BaseActivityData c(long paramLong)
  {
    try
    {
      Object localObject1 = this.f;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = this.f.activities.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        BaseActivityData localBaseActivityData = (BaseActivityData)((Iterator)localObject1).next();
        boolean bool = Const.b(localBaseActivityData.getTaskTime(), paramLong);
        if (bool) {
          return localBaseActivityData;
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public RedPacketResultData c()
  {
    return this.u;
  }
  
  @NotNull
  public UserData.UserDataItem c(String paramString)
  {
    return a().getAndGenUserDataItem(paramString);
  }
  
  @Nullable
  public EntryConfigBean d()
  {
    return this.f;
  }
  
  public void e()
  {
    this.i.sendEmptyMessage(1002);
  }
  
  public boolean g()
  {
    Object localObject = c(i());
    if (localObject != null)
    {
      PendantData localPendantData = ((BaseActivityData)localObject).pendantData;
      boolean bool;
      if ((localPendantData != null) && (localPendantData.showPendantSwitch) && (Const.a(localPendantData.getTaskTime(), i()))) {
        bool = true;
      } else {
        bool = false;
      }
      String str = ((BaseActivityData)localObject).id;
      int i1 = ((BaseActivityData)localObject).type;
      if (localPendantData == null) {
        localObject = "null";
      } else {
        localObject = localPendantData.toSimpleString();
      }
      QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("isNeedShowPendantSwitchItem true actId=%s actType=%d pendant=%s", new Object[] { str, Integer.valueOf(i1), localObject }));
      return bool;
    }
    QLog.d("shua2021_SpringFestivalEntryManager", 1, "isNeedShowPendantSwitchItem false no activity");
    return false;
  }
  
  public boolean h()
  {
    SharedPreferences localSharedPreferences = f();
    boolean bool;
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("pendant_show_switch", true);
    } else {
      bool = true;
    }
    QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("isPendantShowSwitchOn %b", new Object[] { Boolean.valueOf(bool) }));
    return bool;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1001) {
      try
      {
        a(paramMessage);
        return false;
      }
      catch (Throwable paramMessage)
      {
        SpringHbMonitorReporter.a(203, paramMessage, new String[0]);
        QLog.i("shua2021_SpringFestivalEntryManager", 1, paramMessage.getMessage(), paramMessage);
        return false;
      }
    }
    if (paramMessage.what == 1002)
    {
      this.i.removeMessages(1002);
      q();
    }
    return false;
  }
  
  public long i()
  {
    long l1;
    if (j()) {
      l1 = (NetConnInfoCenter.getServerTimeMillis() - this.w) * this.x + this.v;
    } else {
      l1 = NetConnInfoCenter.getServerTimeMillis();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCurrentTime -->");
    localStringBuilder.append(TimeFormatterUtils.f(l1));
    QLog.i("shua2021_SpringFestivalEntryManager", 1, localStringBuilder.toString());
    return l1;
  }
  
  public boolean j()
  {
    return false;
  }
  
  public int k()
  {
    return this.x;
  }
  
  public boolean l()
  {
    try
    {
      Object localObject1 = this.f;
      boolean bool = false;
      if (localObject1 == null) {
        return false;
      }
      long l1 = i();
      long l2 = ((EntryConfigBean)localObject1).commonData.forbidRefreshBeforeTime * 1000;
      long l3 = ((EntryConfigBean)localObject1).commonData.forbidRefreshAfterTime * 1000;
      String str = null;
      Iterator localIterator = ((EntryConfigBean)localObject1).activities.iterator();
      TimeInfo localTimeInfo;
      do
      {
        localObject1 = str;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (BaseActivityData)localIterator.next();
        localTimeInfo = ((BaseActivityData)localObject1).calcForbidRefreshTimeInfo(l2, l3);
      } while ((((BaseActivityData)localObject1).getType() != 2) || (!Const.a(localTimeInfo, l1)));
      if (localObject1 == null) {
        str = "null";
      } else {
        str = ((BaseActivityData)localObject1).toSimpleString();
      }
      QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("isForbidRefreshTime [%d,%d] act=%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3), str }));
      if (localObject1 != null) {
        bool = true;
      }
      return bool;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void m()
  {
    b(false);
  }
  
  public void n()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopCountDownSound, mPlayCountDownStreamId=");
      localStringBuilder.append(this.D);
      localStringBuilder.append(", mPlayCountDownState=");
      localStringBuilder.append(this.c);
      QLog.d("shua2021_SpringFestivalEntryManager", 2, localStringBuilder.toString());
    }
    if (this.c == 4) {
      return;
    }
    int i1 = this.D;
    if (i1 != 0) {
      try
      {
        if (this.z != null) {
          this.z.pause(i1);
        }
      }
      catch (Throwable localThrowable)
      {
        SpringHbMonitorReporter.a(211, localThrowable, new String[0]);
      }
    }
    this.D = 0;
    this.c = 4;
  }
  
  public void o()
  {
    ((Vibrator)this.e.getApp().getSystemService("vibrator")).vibrate(300L);
  }
  
  public void onDestroy()
  {
    QLog.i("shua2021_SpringFestivalEntryManager", 2, "onDestroy.");
    try
    {
      if (this.i.hasMessages(1002)) {
        q();
      }
      this.i.removeCallbacksAndMessages(null);
      this.j.removeCallbacksAndMessages(null);
      this.m.onDestroy();
      this.n.onDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("shua2021_SpringFestivalEntryManager", 1, localThrowable.getMessage(), localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager
 * JD-Core Version:    0.7.0.1
 */