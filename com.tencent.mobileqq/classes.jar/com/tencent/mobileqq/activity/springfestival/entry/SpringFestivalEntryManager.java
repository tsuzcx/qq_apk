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
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy_MM_dd");
  private static final boolean[] jdField_a_of_type_ArrayOfBoolean = { 0, 0, 0, 0, 0 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2131230752, 2131230754, 2131230753, 2131230751, 2131230755 };
  int jdField_a_of_type_Int = 4;
  private long jdField_a_of_type_Long;
  SoundPool.OnLoadCompleteListener jdField_a_of_type_AndroidMediaSoundPool$OnLoadCompleteListener = new SpringFestivalEntryManager.17(this);
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool;
  private Handler jdField_a_of_type_AndroidOsHandler;
  SpringFestivalRedpacketConfigManager jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfigManager;
  private IPreloadRes jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryIPreloadRes;
  private ITaskCallback jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryITaskCallback;
  private IZipResCheck jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryIZipResCheck;
  private volatile BaseActivityData jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData;
  private volatile EntryConfigBean jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean;
  private volatile MsgTabBannerData jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelMsgTabBannerData;
  private volatile PopBannerData jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelPopBannerData;
  private RedPacketResultData jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelRedPacketResultData;
  private volatile UserData jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelUserData;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<Party.PartyTask> jdField_a_of_type_JavaUtilList;
  private volatile boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = { 0, 0, 0, 0, 0 };
  private volatile int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 1;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean = false;
  private int d = 0;
  
  public SpringFestivalEntryManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getUIHandlerV2().getLooper());
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryIPreloadRes = new PreloadResHandler();
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryIZipResCheck = new ZipResCheckHandler(this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfigManager = ((SpringFestivalRedpacketConfigManager)paramQQAppInterface.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER));
    b(new SpringFestivalEntryManager.1(this));
  }
  
  private long a(BaseActivityData paramBaseActivityData)
  {
    long l2 = paramBaseActivityData.getTaskTime().end - paramBaseActivityData.getTaskAboutToOverDuration() * 1000;
    long l1 = l2;
    if (l2 < paramBaseActivityData.getTaskTime().begin) {
      l1 = paramBaseActivityData.getTaskTime().begin;
    }
    return l1;
  }
  
  public static SharedPreferences a()
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
      label50:
      break label50;
    }
    return null;
  }
  
  @NotNull
  private String a(long paramLong)
  {
    try
    {
      String str = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(paramLong));
      if (str == null) {
        return "";
      }
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  private void a(int paramInt, long paramLong, Object paramObject)
  {
    if (paramInt == 4002)
    {
      if ((paramObject instanceof PopBannerData)) {
        paramObject = (PopBannerData)paramObject;
      } else {
        paramObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelPopBannerData;
      }
      paramObject = new Party.PartyTask(paramInt, paramLong, paramObject);
    }
    else if (paramInt == 5002)
    {
      if ((paramObject instanceof MsgTabBannerData)) {
        paramObject = (MsgTabBannerData)paramObject;
      } else {
        paramObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelMsgTabBannerData;
      }
      paramObject = new Party.PartyTask(paramInt, paramLong, paramObject);
    }
    else
    {
      if ((paramObject instanceof BaseActivityData)) {
        paramObject = (BaseActivityData)paramObject;
      } else {
        paramObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData;
      }
      paramObject = new Party.PartyTask(paramInt, paramLong, paramObject);
    }
    if (QLog.isColorLevel()) {
      QLog.i("shua2021_SpringFestivalEntryManager", 2, String.format("onTaskNeed2ExecuteForClear task=%s", new Object[] { Party.b(paramInt) }));
    }
    a(paramObject);
  }
  
  private void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("runCurrentTask. isPeedUp: ");
      ((StringBuilder)localObject1).append(c());
      ((StringBuilder)localObject1).append(" currentTime is: ");
      ((StringBuilder)localObject1).append(TimeFormatterUtils.b(paramLong));
      ((StringBuilder)localObject1).append(" taskSize:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.i("shua2021_SpringFestivalEntryManager", 2, ((StringBuilder)localObject1).toString());
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        QLog.d("shua2021_SpringFestivalEntryManager", 2, String.format("before runCurrentTask [%d] task= %s", new Object[] { Integer.valueOf(i), ((Party.PartyTask)((Iterator)localObject1).next()).toString() }));
        i += 1;
      }
    }
    if (a(this.jdField_a_of_type_JavaUtilList))
    {
      b(paramLong);
      if (QLog.isColorLevel()) {
        QLog.w("shua2021_SpringFestivalEntryManager", 2, "runCurrentTask, taskList is empty return");
      }
      return;
    }
    b(2);
    Object localObject2 = a(paramLong);
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
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData;
      if ((localObject1 != null) && (!((BaseActivityData)localObject1).equals(localObject2)))
      {
        QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("should close pre_activity %s", new Object[] { ((BaseActivityData)localObject1).toSimpleString() }));
        a(2002, paramLong, localObject1);
        a(3002, paramLong, localObject1);
        a(1004, paramLong, localObject1);
      }
      long l = 0L;
      boolean bool;
      if (((BaseActivityData)localObject2).getTaskAboutToOverDuration() > 0)
      {
        l = a((BaseActivityData)localObject2);
        bool = Const.b(new TimeInfo(l, ((BaseActivityData)localObject2).getTaskTime().end), paramLong);
      }
      else
      {
        bool = false;
      }
      if (bool) {
        a(new Party.PartyTask(1003, l, localObject2));
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
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelPopBannerData;
      if ((localObject1 != null) && (((PopBannerData)localObject1).getTaskTime().end == paramLong))
      {
        QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("should close pre popBanner id=%d", new Object[] { ((PopBannerData)localObject1).id }));
        a(4002, paramLong, localObject1);
      }
      a(new Party.PartyTask(4001, ((PopBannerData)localObject2).getTaskTime().begin, localObject2));
    }
    localObject2 = a(paramLong);
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelMsgTabBannerData;
    if ((localObject1 != null) && (((MsgTabBannerData)localObject1).getTaskTime().end == paramLong))
    {
      QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("should close pre msgTabBanner id=%d", new Object[] { ((MsgTabBannerData)localObject1).id }));
      a(5002, paramLong, localObject1);
    }
    a(new Party.PartyTask(5001, ((MsgTabBannerData)localObject2).getTaskTime().begin, localObject2));
  }
  
  private void a(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleTaskMsg isSpeedUp: ");
    localStringBuilder.append(c());
    localStringBuilder.append(" currentTime is: ");
    localStringBuilder.append(TimeFormatterUtils.b(a()));
    QLog.i("shua2021_SpringFestivalEntryManager", 1, localStringBuilder.toString());
    if (paramMessage.arg1 != 1)
    {
      paramMessage = null;
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        paramMessage = (Party.PartyTask)this.jdField_a_of_type_JavaUtilList.remove(0);
        a(paramMessage);
      }
      QLog.i("shua2021_SpringFestivalEntryManager", 1, String.format("handleTaskMsg task is %s", new Object[] { paramMessage }));
    }
    else
    {
      QLog.i("shua2021_SpringFestivalEntryManager", 1, "handleTaskMsg just loop check. do nothing.");
    }
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      i();
      return;
    }
    b(3);
  }
  
  private void a(Party.PartyTask paramPartyTask)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelPopBannerData;
    MsgTabBannerData localMsgTabBannerData = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelMsgTabBannerData;
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
    int i = paramPartyTask.jdField_a_of_type_Int;
    if (i != 2001)
    {
      if (i != 2002)
      {
        if (i != 3001)
        {
          if (i != 3002)
          {
            if (i != 4001)
            {
              if (i != 4002)
              {
                if (i != 5001)
                {
                  if (i != 5002)
                  {
                    switch (i)
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
  
  private void a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelUserData == null)
      {
        UserData localUserData = UserData.read(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelUserData = localUserData;
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
      if (((BaseActivityData)paramObject).equals(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData)) {
        return true;
      }
    }
    else if ((paramObject == null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData != null)) {
      return true;
    }
    return false;
  }
  
  private static boolean a(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  private void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updatePartyState ");
    localStringBuilder.append(Party.a(this.jdField_b_of_type_Int));
    localStringBuilder.append(" ==> ");
    localStringBuilder.append(Party.a(paramInt));
    QLog.i("shua2021_SpringFestivalEntryManager", 1, localStringBuilder.toString());
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void b(long paramLong)
  {
    QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("clearAllTasks currentTime=%s", new Object[] { TimeFormatterUtils.b(paramLong) }));
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    b(4);
    a(2002, paramLong, null);
    a(3002, paramLong, null);
    a(1004, paramLong, null);
    a(4002, paramLong, null);
    a(5002, paramLong, null);
  }
  
  private void b(EntryConfigBean paramEntryConfigBean)
  {
    if (paramEntryConfigBean != null) {}
    try
    {
      int i = paramEntryConfigBean.activities.size();
      if (i > 0) {
        try
        {
          String str = a(a());
          Object localObject1 = a();
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
          paramEntryConfigBean = BaseApplicationImpl.getApplication().getResources().getString(2131699332);
          i = ((List)localObject2).size() - 1;
          while (i >= 0)
          {
            BaseActivityData localBaseActivityData = (BaseActivityData)((List)localObject2).get(i);
            localObject1 = paramEntryConfigBean;
            if (str.equals(a(localBaseActivityData.getConfigTime().begin))) {
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
            i -= 1;
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
      if (((PopBannerData)paramObject).equals(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelPopBannerData)) {
        return true;
      }
    }
    else if ((paramObject == null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelPopBannerData != null)) {
      return true;
    }
    return false;
  }
  
  private void c(long paramLong)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearOutOfDataTask before:");
        localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
        QLog.i("shua2021_SpringFestivalEntryManager", 2, localStringBuilder.toString());
      }
      i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    }
    finally
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        int i;
        for (;;)
        {
          throw localObject;
        }
        i -= 1;
      }
    }
    if (i >= 0)
    {
      if (((Party.PartyTask)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Long <= paramLong) {
        this.jdField_a_of_type_JavaUtilList.remove(i);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearOutOfDataTask end:");
        localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
        QLog.i("shua2021_SpringFestivalEntryManager", 2, localStringBuilder.toString());
      }
      return;
    }
  }
  
  private void c(EntryConfigBean paramEntryConfigBean)
  {
    if (paramEntryConfigBean != null) {}
    try
    {
      int i = paramEntryConfigBean.activities.size();
      if (i > 0) {
        try
        {
          long l1 = a();
          ArrayList localArrayList = new ArrayList();
          localArrayList.addAll(paramEntryConfigBean.activities);
          i = localArrayList.size() - 1;
          while (i >= 0)
          {
            paramEntryConfigBean = (BaseActivityData)localArrayList.get(i);
            long l2 = paramEntryConfigBean.getConfigTime().end;
            if ((paramEntryConfigBean.getType() == 2) && (l1 > l2))
            {
              UserData.UserDataItem localUserDataItem = a(paramEntryConfigBean.id);
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
                a();
              }
            }
            i -= 1;
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
      if (((MsgTabBannerData)paramObject).equals(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelMsgTabBannerData)) {
        return true;
      }
    }
    else if ((paramObject == null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelMsgTabBannerData != null)) {
      return true;
    }
    return false;
  }
  
  private boolean e()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i >= 30) {
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
  
  private void f()
  {
    try
    {
      UserData localUserData = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelUserData;
      if (localUserData != null) {
        UserData.write(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), localUserData);
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
  
  private void g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("generateTasksAndLaunch,");
    localStringBuilder.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    QLog.i("shua2021_SpringFestivalEntryManager", 1, localStringBuilder.toString());
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = false;
    b(new SpringFestivalEntryManager.2(this));
  }
  
  private void h()
  {
    label82:
    try
    {
      QLog.i("shua2021_SpringFestivalEntryManager", 1, String.format("checkAndScheduleTask isZipResCheckSuc=%b", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
      bool = this.jdField_b_of_type_Boolean;
      if (!bool) {
        return;
      }
      try
      {
        long l = a();
        a(l);
        c(l);
        i();
      }
      catch (Throwable localThrowable1) {}
    }
    finally {}
    try
    {
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break label205;
      }
      bool = true;
    }
    catch (Throwable localThrowable2)
    {
      break label147;
      bool = false;
      break label82;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isMainThread=");
    localStringBuilder.append(bool);
    localStringBuilder.append("stack=");
    localStringBuilder.append(Log.getStackTraceString(localThrowable1));
    SpringHbMonitorReporter.a(204, localThrowable1, new String[] { localStringBuilder.toString() });
    label147:
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkAndScheduleTask ex. ");
    localStringBuilder.append(localThrowable1.getMessage());
    QLog.e("shua2021_SpringFestivalEntryManager", 1, localStringBuilder.toString(), localThrowable1);
  }
  
  private void i()
  {
    try
    {
      QLog.i("shua2021_SpringFestivalEntryManager", 1, "scheduleNextTask.");
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        Object localObject1 = (Party.PartyTask)this.jdField_a_of_type_JavaUtilList.get(0);
        long l2 = ((Party.PartyTask)localObject1).jdField_a_of_type_Long - a();
        if (l2 < -300000L)
        {
          h();
          QLog.i("shua2021_SpringFestivalEntryManager", 1, "scheduleNextTask. delay time < -5 minute, checkAndScheduleTask.");
        }
        else if (l2 < 86400000L)
        {
          Object localObject3 = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1001);
          long l1 = l2;
          if (l2 > 300000L)
          {
            ((Message)localObject3).arg1 = 1;
            l1 = 300000L;
          }
          l2 = l1;
          if (c()) {
            l2 = l1 / this.jdField_c_of_type_Int;
          }
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject3, l2);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("scheduleNextTask. delay time is: ");
          ((StringBuilder)localObject3).append(l2);
          ((StringBuilder)localObject3).append(" next task is: ");
          ((StringBuilder)localObject3).append(((Party.PartyTask)localObject1).toString());
          QLog.i("shua2021_SpringFestivalEntryManager", 1, ((StringBuilder)localObject3).toString());
          if (QLog.isColorLevel())
          {
            localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
            int i = 0;
            while (((Iterator)localObject1).hasNext())
            {
              QLog.d("shua2021_SpringFestivalEntryManager", 2, String.format("scheduleNextTask [%d] task= %s", new Object[] { Integer.valueOf(i), ((Party.PartyTask)((Iterator)localObject1).next()).toString() }));
              i += 1;
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
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 495	com/tencent/mobileqq/activity/springfestival/entry/SpringFestivalEntryManager:jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelUserData	Lcom/tencent/mobileqq/activity/springfestival/entry/model/UserData;
    //   6: ifnonnull +41 -> 47
    //   9: aload_0
    //   10: ldc_w 807
    //   13: invokespecial 809	com/tencent/mobileqq/activity/springfestival/entry/SpringFestivalEntryManager:a	(Ljava/lang/String;)V
    //   16: goto +31 -> 47
    //   19: astore_1
    //   20: goto +30 -> 50
    //   23: astore_1
    //   24: sipush 208
    //   27: aload_1
    //   28: iconst_0
    //   29: anewarray 269	java/lang/String
    //   32: invokestatic 639	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(ILjava/lang/Throwable;[Ljava/lang/String;)V
    //   35: ldc_w 260
    //   38: iconst_1
    //   39: aload_1
    //   40: invokevirtual 642	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   43: aload_1
    //   44: invokestatic 777	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	SpringFestivalEntryManager
    //   19	1	1	localObject	Object
    //   23	30	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	16	19	finally
    //   24	47	19	finally
    //   2	16	23	java/lang/Throwable
  }
  
  private void k()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        QLog.i("shua2021_SpringFestivalEntryManager", 2, String.format("initLocalCacheInfo speedUp=%b", new Object[] { Boolean.valueOf(c()) }));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      SpringHbMonitorReporter.a(209, localThrowable, new String[0]);
      QLog.i("shua2021_SpringFestivalEntryManager", 1, localThrowable.getMessage(), localThrowable);
    }
  }
  
  private void l()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean.preHandleConfigs();
        b(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean);
        c(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void m()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("shua2021_SpringFestivalEntryManager", 2, "buildAndSortPartyTaskQueue entryConfig=null return");
        }
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean.activities.iterator();
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
          localLinkedList.add(new Party.PartyTask(1003, a((BaseActivityData)localObject2), localObject2));
        }
        localLinkedList.add(new Party.PartyTask(1004, ((BaseActivityData)localObject2).getTaskTime().end, localObject2));
      }
      localIterator = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean.popBanners.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (PopBannerData)localIterator.next();
        localLinkedList.add(new Party.PartyTask(4001, ((PopBannerData)localObject2).getTaskTime().begin, localObject2));
        localLinkedList.add(new Party.PartyTask(4002, ((PopBannerData)localObject2).getTaskTime().end, localObject2));
      }
      localIterator = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean.msgTabBanners.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (MsgTabBannerData)localIterator.next();
        localLinkedList.add(new Party.PartyTask(5001, ((MsgTabBannerData)localObject2).getTaskTime().begin, localObject2));
        localLinkedList.add(new Party.PartyTask(5002, ((MsgTabBannerData)localObject2).getTaskTime().end, localObject2));
      }
      if (!a(localLinkedList))
      {
        Collections.sort(localLinkedList, new SpringFestivalEntryManager.15(this));
        this.jdField_a_of_type_JavaUtilList.addAll(localLinkedList);
      }
      QLog.i("shua2021_SpringFestivalEntryManager", 1, String.format("buildAndSortPartyTaskQueue list=%s", new Object[] { this.jdField_a_of_type_JavaUtilList }));
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long a()
  {
    long l;
    if (c()) {
      l = (NetConnInfoCenter.getServerTimeMillis() - this.jdField_c_of_type_Long) * this.jdField_c_of_type_Int + this.jdField_b_of_type_Long;
    } else {
      l = NetConnInfoCenter.getServerTimeMillis();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCurrentTime -->");
    localStringBuilder.append(TimeFormatterUtils.b(l));
    QLog.i("shua2021_SpringFestivalEntryManager", 1, localStringBuilder.toString());
    return l;
  }
  
  @Nullable
  public Bitmap a(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryIPreloadRes.a(paramString1, paramString2);
  }
  
  @Nullable
  public Bitmap a(String paramString1, String paramString2, String paramString3)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryIPreloadRes.a(paramString1, paramString2, paramString3);
  }
  
  public BaseActivityData a(long paramLong)
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean.activities.iterator();
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
  
  @Nullable
  public EntryConfigBean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean;
  }
  
  public MsgTabBannerData a(long paramLong)
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean.msgTabBanners.iterator();
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
  
  public PopBannerData a(long paramLong)
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean.popBanners.iterator();
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
  
  public RedPacketResultData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelRedPacketResultData;
  }
  
  @NotNull
  public UserData.UserDataItem a(String paramString)
  {
    return a().getAndGenUserDataItem(paramString);
  }
  
  @NotNull
  public UserData a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelUserData == null) {
      a("getUserData");
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelUserData;
  }
  
  @Nullable
  public String a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryIPreloadRes.a(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1002, 1000L);
  }
  
  public void a(int paramInt)
  {
    if (e())
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
      localStringBuilder1.append(this.jdField_a_of_type_ArrayOfInt[paramInt]);
      localStringBuilder1.append(", ");
      localStringBuilder1.append(jdField_a_of_type_ArrayOfBoolean[paramInt]);
      localStringBuilder1.append(", mPlayCountDownStreamId=");
      localStringBuilder1.append(this.d);
      localStringBuilder1.append(", mPlayCountDownState=");
      localStringBuilder1.append(this.jdField_a_of_type_Int);
      QLog.d("shua2021_SpringFestivalEntryManager", 2, localStringBuilder1.toString());
    }
    if (e())
    {
      QLog.d("shua2021_SpringFestivalEntryManager", 1, "playSound return for special phone");
      return;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidMediaSoundPool == null)
      {
        this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(10, 3, 0);
        this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(this.jdField_a_of_type_AndroidMediaSoundPool$OnLoadCompleteListener);
      }
      if (paramInt == 2)
      {
        if ((this.jdField_a_of_type_Int == 4) && (paramBoolean)) {
          return;
        }
        if ((this.jdField_a_of_type_Int == 1) && (!paramBoolean)) {
          return;
        }
        this.jdField_a_of_type_Int = 1;
      }
      int k = this.jdField_a_of_type_ArrayOfInt[paramInt];
      if (k == 0)
      {
        i = this.jdField_a_of_type_AndroidMediaSoundPool.load(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), jdField_b_of_type_ArrayOfInt[paramInt], 1);
        this.jdField_a_of_type_ArrayOfInt[paramInt] = i;
        return;
      }
      int j = -1;
      int i = j;
      if (jdField_a_of_type_ArrayOfBoolean[paramInt] != 0) {
        if (paramInt != 2)
        {
          i = this.jdField_a_of_type_AndroidMediaSoundPool.play(k, 1.0F, 1.0F, 1, 0, 1.0F);
        }
        else
        {
          i = j;
          if (this.d == 0)
          {
            this.d = this.jdField_a_of_type_AndroidMediaSoundPool.play(k, 1.0F, 1.0F, 10, -1, 1.0F);
            i = j;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("playSound, ");
        localStringBuilder1.append(paramInt);
        localStringBuilder1.append(", ");
        localStringBuilder1.append(this.jdField_a_of_type_ArrayOfInt[paramInt]);
        localStringBuilder1.append(", ");
        localStringBuilder1.append(jdField_a_of_type_ArrayOfBoolean[paramInt]);
        localStringBuilder1.append(", ");
        localStringBuilder1.append(i);
        localStringBuilder1.append(", mPlayCountDownStreamId=");
        localStringBuilder1.append(this.d);
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
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryIPreloadRes.a(paramOnDownloadCallback);
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
        this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryITaskCallback = new WrapperTaskCallback(paramITaskCallback);
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
          bool = true;
          QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("setTaskCallback clearAllTasks on callback=null isMain=%b", new Object[] { Boolean.valueOf(bool) }));
          if ((this.jdField_b_of_type_Int != 0) && (this.jdField_b_of_type_Int != 3) && (this.jdField_b_of_type_Int != 4)) {
            b(a());
          }
          this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryITaskCallback = null;
          QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("setTaskCallback hasHoldTaskQueue=%b callback=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), paramITaskCallback }));
          if (paramITaskCallback == null) {
            return;
          }
          if (this.jdField_a_of_type_Boolean) {
            g();
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
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelRedPacketResultData = paramRedPacketResultData;
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
      this.jdField_b_of_type_AndroidOsHandler.post(paramRunnable);
      return;
    }
    catch (Exception paramRunnable)
    {
      QLog.e("shua2021_SpringFestivalEntryManager", 1, paramRunnable.getMessage(), paramRunnable);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("pendant_show_switch", paramBoolean).apply();
    }
    QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("changePendantShowSwitch %b", new Object[] { Boolean.valueOf(paramBoolean) }));
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    EntryConfigBean localEntryConfigBean = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean;
    int i;
    if (localEntryConfigBean != null) {
      i = localEntryConfigBean.version;
    } else {
      i = 0;
    }
    QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("onZipResCheckDone suc=%b cfgVer=%d thisCfgVer=%d isZipResCheckSuc=%b", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
    if ((paramBoolean) && (paramInt == i) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = true;
      b(true);
    }
  }
  
  public boolean a()
  {
    Object localObject = a(a());
    if (localObject != null)
    {
      PendantData localPendantData = ((BaseActivityData)localObject).pendantData;
      boolean bool;
      if ((localPendantData != null) && (localPendantData.showPendantSwitch) && (Const.a(localPendantData.getTaskTime(), a()))) {
        bool = true;
      } else {
        bool = false;
      }
      String str = ((BaseActivityData)localObject).id;
      int i = ((BaseActivityData)localObject).type;
      if (localPendantData == null) {
        localObject = "null";
      } else {
        localObject = localPendantData.toSimpleString();
      }
      QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("isNeedShowPendantSwitchItem true actId=%s actType=%d pendant=%s", new Object[] { str, Integer.valueOf(i), localObject }));
      return bool;
    }
    QLog.d("shua2021_SpringFestivalEntryManager", 1, "isNeedShowPendantSwitchItem false no activity");
    return false;
  }
  
  public boolean a(BaseActivityData paramBaseActivityData)
  {
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean;
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
        int j;
        int i;
        continue;
        throw paramBaseActivityData;
        continue;
        i -= 1;
        paramBaseActivityData = (BaseActivityData)localObject1;
        continue;
      }
      try
      {
        localObject2 = a(a());
        localObject3 = a().edit();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("pendant_close_byday");
        ((StringBuilder)localObject4).append((String)localObject2);
        ((SharedPreferences.Editor)localObject3).putBoolean(((StringBuilder)localObject4).toString(), true).apply();
        QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("notifyCloseAllOnGrabActivitiesToday today=%s", new Object[] { localObject2 }));
        j = paramBaseActivityData.pendantData.closeType;
        localObject3 = new ArrayList();
        ((List)localObject3).addAll(((EntryConfigBean)localObject1).activities);
        paramBaseActivityData = BaseApplicationImpl.getApplication().getResources().getString(2131699332);
        i = ((List)localObject3).size() - 1;
        if (i >= 0)
        {
          localObject4 = (BaseActivityData)((List)localObject3).get(i);
          localObject1 = paramBaseActivityData;
          if (!((String)localObject2).equals(a(((BaseActivityData)localObject4).getConfigTime().begin))) {
            continue;
          }
          localObject1 = a(((BaseActivityData)localObject4).id);
          ((UserData.UserDataItem)localObject1).hasClickCloseBtn = true;
          ((UserData.UserDataItem)localObject1).pendantCloseType = j;
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
        a();
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
  
  @Nullable
  public String b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryIPreloadRes.b(paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1002);
  }
  
  public void b(IPreloadRes.OnDownloadCallback paramOnDownloadCallback)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryIPreloadRes.b(paramOnDownloadCallback);
      return;
    }
    catch (Exception paramOnDownloadCallback)
    {
      QLog.e("shua2021_SpringFestivalEntryManager", 1, paramOnDownloadCallback.getMessage(), paramOnDownloadCallback);
    }
  }
  
  public void b(Runnable paramRunnable)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshScheduleTask force=");
    ((StringBuilder)localObject).append(paramBoolean);
    localObject = ((StringBuilder)localObject).toString();
    int j = 1;
    QLog.d("shua2021_SpringFestivalEntryManager", 1, (String)localObject);
    int i = j;
    if (this.jdField_b_of_type_Int != 0)
    {
      i = j;
      if (this.jdField_b_of_type_Int != 3) {
        if (this.jdField_b_of_type_Int == 4) {
          i = j;
        } else {
          i = 0;
        }
      }
    }
    if (((!paramBoolean) && (i != 0)) || (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean == null)) {
      return;
    }
    b(new SpringFestivalEntryManager.16(this));
  }
  
  public boolean b()
  {
    SharedPreferences localSharedPreferences = a();
    boolean bool;
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("pendant_show_switch", true);
    } else {
      bool = true;
    }
    QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("isPendantShowSwitchOn %b", new Object[] { Boolean.valueOf(bool) }));
    return bool;
  }
  
  public void c()
  {
    b(false);
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopCountDownSound, mPlayCountDownStreamId=");
      localStringBuilder.append(this.d);
      localStringBuilder.append(", mPlayCountDownState=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("shua2021_SpringFestivalEntryManager", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Int == 4) {
      return;
    }
    int i = this.d;
    if (i != 0) {
      try
      {
        if (this.jdField_a_of_type_AndroidMediaSoundPool != null) {
          this.jdField_a_of_type_AndroidMediaSoundPool.pause(i);
        }
      }
      catch (Throwable localThrowable)
      {
        SpringHbMonitorReporter.a(211, localThrowable, new String[0]);
      }
    }
    this.d = 0;
    this.jdField_a_of_type_Int = 4;
  }
  
  public boolean d()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean;
      boolean bool = false;
      if (localObject1 == null) {
        return false;
      }
      long l1 = a();
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
  
  public void e()
  {
    ((Vibrator)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSystemService("vibrator")).vibrate(300L);
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
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1002);
      f();
    }
    return false;
  }
  
  public void onDestroy()
  {
    QLog.i("shua2021_SpringFestivalEntryManager", 2, "onDestroy.");
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1002)) {
        f();
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryIPreloadRes.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryIZipResCheck.onDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("shua2021_SpringFestivalEntryManager", 1, localThrowable.getMessage(), localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager
 * JD-Core Version:    0.7.0.1
 */