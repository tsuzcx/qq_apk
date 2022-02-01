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
import com.tencent.common.config.AppSetting;
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
import com.tencent.mobileqq.activity.springfestival.entry.model.ZipRes;
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
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2131230748, 2131230750, 2131230749, 2131230747, 2131230751 };
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
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences(((QQAppInterface)localObject).getCurrentAccountUin() + "_2021_shuayishua_entrymanager", 0);
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  @NotNull
  private String a(long paramLong)
  {
    try
    {
      String str2 = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(paramLong));
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      return str1;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  private void a(int paramInt, long paramLong, Object paramObject)
  {
    if (paramInt == 4002)
    {
      if ((paramObject instanceof PopBannerData)) {}
      for (paramObject = (PopBannerData)paramObject;; paramObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelPopBannerData)
      {
        paramObject = new Party.PartyTask(paramInt, paramLong, paramObject);
        if (QLog.isColorLevel()) {
          QLog.i("shua2021_SpringFestivalEntryManager", 2, String.format("onTaskNeed2ExecuteForClear task=%s", new Object[] { Party.b(paramInt) }));
        }
        a(paramObject);
        return;
      }
    }
    if (paramInt == 5002)
    {
      if ((paramObject instanceof MsgTabBannerData)) {}
      for (paramObject = (MsgTabBannerData)paramObject;; paramObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelMsgTabBannerData)
      {
        paramObject = new Party.PartyTask(paramInt, paramLong, paramObject);
        break;
      }
    }
    if ((paramObject instanceof BaseActivityData)) {}
    for (paramObject = (BaseActivityData)paramObject;; paramObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData)
    {
      paramObject = new Party.PartyTask(paramInt, paramLong, paramObject);
      break;
    }
  }
  
  private void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("shua2021_SpringFestivalEntryManager", 2, "runCurrentTask. isPeedUp: " + c() + " currentTime is: " + TimeFormatterUtils.b(paramLong) + " taskSize:" + this.jdField_a_of_type_JavaUtilList.size());
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
    if (localObject2 == null) {}
    for (Object localObject1 = "null";; localObject1 = ((BaseActivityData)localObject2).toSimpleString())
    {
      QLog.i("shua2021_SpringFestivalEntryManager", 1, String.format("【findOnGoingActivity】 %s", new Object[] { localObject1 }));
      if (localObject2 != null) {
        break;
      }
      a(2002, paramLong, null);
      a(3002, paramLong, null);
      a(1004, paramLong, null);
      if (QLog.isColorLevel()) {
        QLog.i("shua2021_SpringFestivalEntryManager", 2, "runCurrentTask. mCurrentActivityInfo is null,hide pendent and return.");
      }
      localObject2 = a(paramLong);
      if (localObject2 != null) {
        break label777;
      }
      localObject1 = "null";
      label278:
      QLog.i("shua2021_SpringFestivalEntryManager", 1, String.format("【findOnGoingPopBanner】 %s", new Object[] { localObject1 }));
      if (localObject2 != null) {
        break label787;
      }
      a(4002, paramLong, null);
      label314:
      localObject2 = a(paramLong);
      if (localObject2 != null) {
        break label873;
      }
      localObject1 = "null";
      label331:
      QLog.i("shua2021_SpringFestivalEntryManager", 1, String.format("【findOnGoingMsgTabBanner】 %s", new Object[] { localObject1 }));
      if (localObject2 != null) {
        break label883;
      }
      a(5002, paramLong, null);
      return;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData;
    if ((localObject1 != null) && (!((BaseActivityData)localObject1).equals(localObject2)))
    {
      QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("should close pre_activity %s", new Object[] { ((BaseActivityData)localObject1).toSimpleString() }));
      a(2002, paramLong, localObject1);
      a(3002, paramLong, localObject1);
      a(1004, paramLong, localObject1);
    }
    long l = 0L;
    if (((BaseActivityData)localObject2).getTaskAboutToOverDuration() > 0) {
      l = a((BaseActivityData)localObject2);
    }
    for (boolean bool = Const.b(new TimeInfo(l, ((BaseActivityData)localObject2).getTaskTime().end), paramLong);; bool = false)
    {
      if (bool)
      {
        a(new Party.PartyTask(1003, l, localObject2));
        label519:
        if (!((BaseActivityData)localObject2).schedulePendantNBreathLight()) {
          break label749;
        }
        if ((((BaseActivityData)localObject2).pendantData == null) || (!Const.a(((BaseActivityData)localObject2).pendantData.getTaskTime(), paramLong))) {
          break label751;
        }
        a(new Party.PartyTask(2001, ((BaseActivityData)localObject2).pendantData.getTaskTime().begin, localObject2));
      }
      for (;;)
      {
        if ((((BaseActivityData)localObject2).breathLightData == null) || (!Const.a(((BaseActivityData)localObject2).breathLightData.getTaskTime(), paramLong))) {
          break label764;
        }
        a(new Party.PartyTask(3001, ((BaseActivityData)localObject2).getTaskTime().begin, localObject2));
        break;
        if ((((BaseActivityData)localObject2).getPeakDelayMs() > 0) && (!((BaseActivityData)localObject2).scheduleTaskAfterPeak()))
        {
          if (paramLong < ((BaseActivityData)localObject2).getTaskTime().begin + ((BaseActivityData)localObject2).getPeakDelayMs())
          {
            a(new Party.PartyTask(1001, ((BaseActivityData)localObject2).getTaskTime().begin, localObject2));
            break label519;
          }
          a(new Party.PartyTask(1002, ((BaseActivityData)localObject2).getTaskTime().begin + ((BaseActivityData)localObject2).getPeakDelayMs(), localObject2));
          break label519;
        }
        a(new Party.PartyTask(1002, ((BaseActivityData)localObject2).getTaskTime().begin, localObject2));
        break label519;
        label749:
        break;
        label751:
        a(2002, paramLong, localObject2);
      }
      label764:
      a(3002, paramLong, localObject2);
      break;
      label777:
      localObject1 = ((PopBannerData)localObject2).toSimpleString();
      break label278;
      label787:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelPopBannerData;
      if ((localObject1 != null) && (((PopBannerData)localObject1).getTaskTime().end == paramLong))
      {
        QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("should close pre popBanner id=%d", new Object[] { ((PopBannerData)localObject1).id }));
        a(4002, paramLong, localObject1);
      }
      a(new Party.PartyTask(4001, ((PopBannerData)localObject2).getTaskTime().begin, localObject2));
      break label314;
      label873:
      localObject1 = ((MsgTabBannerData)localObject2).toSimpleString();
      break label331;
      label883:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelMsgTabBannerData;
      if ((localObject1 != null) && (((MsgTabBannerData)localObject1).getTaskTime().end == paramLong))
      {
        QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("should close pre msgTabBanner id=%d", new Object[] { ((MsgTabBannerData)localObject1).id }));
        a(5002, paramLong, localObject1);
      }
      a(new Party.PartyTask(5001, ((MsgTabBannerData)localObject2).getTaskTime().begin, localObject2));
      return;
    }
  }
  
  private void a(Message paramMessage)
  {
    QLog.i("shua2021_SpringFestivalEntryManager", 1, "handleTaskMsg isSpeedUp: " + c() + " currentTime is: " + TimeFormatterUtils.b(a()));
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
    while (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      i();
      return;
      QLog.i("shua2021_SpringFestivalEntryManager", 1, "handleTaskMsg just loop check. do nothing.");
    }
    b(3);
  }
  
  private void a(Party.PartyTask paramPartyTask)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelPopBannerData;
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelMsgTabBannerData;
    if (localObject1 == null)
    {
      localObject1 = "null";
      label24:
      if (localObject2 != null) {
        break label197;
      }
      localObject2 = "null";
      label32:
      if (localObject3 != null) {
        break label205;
      }
    }
    label197:
    label205:
    for (localObject3 = "null";; localObject3 = ((MsgTabBannerData)localObject3).toSimpleString())
    {
      QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("onTaskNeed2Execute --> %s , \ncurBaseActivityData=%s, \ncurPopBannerData=%s, \ncurMsgTabBannerData=%s", new Object[] { paramPartyTask, localObject1, localObject2, localObject3 }));
      switch (paramPartyTask.jdField_a_of_type_Int)
      {
      default: 
        return;
        localObject1 = ((BaseActivityData)localObject1).toSimpleString();
        break label24;
        localObject2 = ((PopBannerData)localObject2).toSimpleString();
        break label32;
      }
    }
    a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.3(this, paramPartyTask)));
    return;
    a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.4(this, paramPartyTask)));
    return;
    a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.5(this, paramPartyTask)));
    return;
    a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.6(this, paramPartyTask)));
    return;
    a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.7(this, paramPartyTask)));
    return;
    a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.8(this, paramPartyTask)));
    return;
    a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.9(this, paramPartyTask)));
    return;
    a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.10(this, paramPartyTask)));
    return;
    a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.11(this, paramPartyTask)));
    return;
    a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.12(this, paramPartyTask)));
    return;
    a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.13(this, paramPartyTask)));
    return;
    a(new SpringFestivalEntryManager.TaskCallbackNotNullWrapper(this, new SpringFestivalEntryManager.14(this, paramPartyTask)));
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
    if (QLog.isColorLevel()) {
      QLog.d("shua2021_SpringFestivalEntryManager", 2, "reportBrushAbnormalQuit activityID = " + paramString + ",leftCountDownDuration = " + paramLong);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("active_id", paramString);
    localHashMap.put("ext1", String.valueOf(paramLong / 1000L));
    SpringHbReporter.a(ReportConstant.Event.l, 0, 0, localHashMap, "abnormal_quit");
  }
  
  private boolean a(Object paramObject)
  {
    if ((paramObject instanceof BaseActivityData))
    {
      if (!((BaseActivityData)paramObject).equals(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData)) {}
    }
    else {
      while ((paramObject == null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData != null)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  private void b(int paramInt)
  {
    QLog.i("shua2021_SpringFestivalEntryManager", 1, "updatePartyState " + Party.a(this.jdField_b_of_type_Int) + " ==> " + Party.a(paramInt));
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
    for (;;)
    {
      try
      {
        if (paramEntryConfigBean.activities.size() <= 0)
        {
          QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("preHandleOnGrabActivitiesClosedToday return", new Object[0]));
          return;
        }
        int i;
        try
        {
          String str = a(a());
          boolean bool = a().getBoolean("pendant_close_byday" + str, false);
          QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("preHandleOnGrabActivitiesClosedToday today=%s isClosed=%b", new Object[] { str, Boolean.valueOf(bool) }));
          if (!bool) {
            continue;
          }
          ArrayList localArrayList = new ArrayList();
          localArrayList.addAll(paramEntryConfigBean.activities);
          paramEntryConfigBean = BaseApplicationImpl.getApplication().getResources().getString(2131699228);
          i = localArrayList.size() - 1;
          if (i < 0) {
            continue;
          }
          BaseActivityData localBaseActivityData = (BaseActivityData)localArrayList.get(i);
          if (str.equals(a(localBaseActivityData.getConfigTime().begin))) {
            if ((localBaseActivityData.getType() == 2) && (!TextUtils.isEmpty(localBaseActivityData.getMiniEntryData().endWording)))
            {
              paramEntryConfigBean = localBaseActivityData.getMiniEntryData().endWording;
            }
            else if ((localBaseActivityData.getType() == 1) || (localBaseActivityData.getType() == 2))
            {
              localBaseActivityData.getMiniEntryData().endWording = paramEntryConfigBean;
              localBaseActivityData.getMiniEntryData().preWording = "";
            }
          }
        }
        catch (Throwable paramEntryConfigBean)
        {
          SpringHbMonitorReporter.a(207, paramEntryConfigBean, new String[0]);
          QLog.d("shua2021_SpringFestivalEntryManager", 1, paramEntryConfigBean.getMessage(), paramEntryConfigBean);
        }
        continue;
        i -= 1;
      }
      finally {}
    }
  }
  
  private boolean b(Object paramObject)
  {
    if ((paramObject instanceof PopBannerData))
    {
      if (!((PopBannerData)paramObject).equals(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelPopBannerData)) {}
    }
    else {
      while ((paramObject == null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelPopBannerData != null)) {
        return true;
      }
    }
    return false;
  }
  
  private void c(long paramLong)
  {
    for (;;)
    {
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("shua2021_SpringFestivalEntryManager", 2, "clearOutOfDataTask before:" + this.jdField_a_of_type_JavaUtilList);
        }
        i = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i >= 0)
        {
          if (((Party.PartyTask)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Long <= paramLong) {
            this.jdField_a_of_type_JavaUtilList.remove(i);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("shua2021_SpringFestivalEntryManager", 2, "clearOutOfDataTask end:" + this.jdField_a_of_type_JavaUtilList);
          }
          return;
        }
      }
      finally {}
      i -= 1;
    }
  }
  
  /* Error */
  private void c(EntryConfigBean paramEntryConfigBean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +15 -> 18
    //   6: aload_1
    //   7: getfield 571	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:activities	Ljava/util/List;
    //   10: invokeinterface 300 1 0
    //   15: ifgt +23 -> 38
    //   18: ldc_w 258
    //   21: iconst_1
    //   22: ldc_w 663
    //   25: iconst_0
    //   26: anewarray 4	java/lang/Object
    //   29: invokestatic 270	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   32: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: invokevirtual 423	com/tencent/mobileqq/activity/springfestival/entry/SpringFestivalEntryManager:a	()J
    //   42: lstore_3
    //   43: new 594	java/util/ArrayList
    //   46: dup
    //   47: invokespecial 595	java/util/ArrayList:<init>	()V
    //   50: astore 7
    //   52: aload 7
    //   54: aload_1
    //   55: getfield 571	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:activities	Ljava/util/List;
    //   58: invokeinterface 599 2 0
    //   63: pop
    //   64: aload 7
    //   66: invokeinterface 300 1 0
    //   71: iconst_1
    //   72: isub
    //   73: istore_2
    //   74: iload_2
    //   75: iflt -40 -> 35
    //   78: aload 7
    //   80: iload_2
    //   81: invokeinterface 612 2 0
    //   86: checkcast 164	com/tencent/mobileqq/activity/springfestival/entry/model/BaseActivityData
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 615	com/tencent/mobileqq/activity/springfestival/entry/model/BaseActivityData:getConfigTime	()Lcom/tencent/mobileqq/activity/springfestival/entry/model/TimeInfo;
    //   94: getfield 173	com/tencent/mobileqq/activity/springfestival/entry/model/TimeInfo:end	J
    //   97: lstore 5
    //   99: aload_1
    //   100: invokevirtual 619	com/tencent/mobileqq/activity/springfestival/entry/model/BaseActivityData:getType	()I
    //   103: iconst_2
    //   104: if_icmpne +123 -> 227
    //   107: lload_3
    //   108: lload 5
    //   110: lcmp
    //   111: ifle +116 -> 227
    //   114: aload_0
    //   115: aload_1
    //   116: getfield 664	com/tencent/mobileqq/activity/springfestival/entry/model/BaseActivityData:id	Ljava/lang/String;
    //   119: invokevirtual 667	com/tencent/mobileqq/activity/springfestival/entry/SpringFestivalEntryManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/activity/springfestival/entry/model/UserData$UserDataItem;
    //   122: astore 8
    //   124: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +61 -> 188
    //   130: ldc_w 258
    //   133: iconst_2
    //   134: new 195	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 669
    //   144: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_1
    //   148: getfield 664	com/tencent/mobileqq/activity/springfestival/entry/model/BaseActivityData:id	Ljava/lang/String;
    //   151: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc_w 671
    //   157: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 8
    //   162: getfield 676	com/tencent/mobileqq/activity/springfestival/entry/model/UserData$UserDataItem:isAbnormalQuit	Z
    //   165: invokevirtual 287	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   168: ldc_w 678
    //   171: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload 8
    //   176: getfield 681	com/tencent/mobileqq/activity/springfestival/entry/model/UserData$UserDataItem:hasReportedAbnormalQuit	Z
    //   179: invokevirtual 287	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   182: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: aload 8
    //   190: getfield 676	com/tencent/mobileqq/activity/springfestival/entry/model/UserData$UserDataItem:isAbnormalQuit	Z
    //   193: ifeq +34 -> 227
    //   196: aload 8
    //   198: getfield 681	com/tencent/mobileqq/activity/springfestival/entry/model/UserData$UserDataItem:hasReportedAbnormalQuit	Z
    //   201: ifne +26 -> 227
    //   204: aload_0
    //   205: aload_1
    //   206: getfield 664	com/tencent/mobileqq/activity/springfestival/entry/model/BaseActivityData:id	Ljava/lang/String;
    //   209: aload 8
    //   211: getfield 684	com/tencent/mobileqq/activity/springfestival/entry/model/UserData$UserDataItem:leftCountDownDuration	J
    //   214: invokespecial 686	com/tencent/mobileqq/activity/springfestival/entry/SpringFestivalEntryManager:a	(Ljava/lang/String;J)V
    //   217: aload 8
    //   219: iconst_1
    //   220: putfield 681	com/tencent/mobileqq/activity/springfestival/entry/model/UserData$UserDataItem:hasReportedAbnormalQuit	Z
    //   223: aload_0
    //   224: invokevirtual 688	com/tencent/mobileqq/activity/springfestival/entry/SpringFestivalEntryManager:a	()V
    //   227: iload_2
    //   228: iconst_1
    //   229: isub
    //   230: istore_2
    //   231: goto -157 -> 74
    //   234: astore_1
    //   235: ldc_w 258
    //   238: iconst_1
    //   239: ldc_w 690
    //   242: aload_1
    //   243: invokestatic 647	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   246: goto -211 -> 35
    //   249: astore_1
    //   250: aload_0
    //   251: monitorexit
    //   252: aload_1
    //   253: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	SpringFestivalEntryManager
    //   0	254	1	paramEntryConfigBean	EntryConfigBean
    //   73	158	2	i	int
    //   42	66	3	l1	long
    //   97	12	5	l2	long
    //   50	29	7	localArrayList	ArrayList
    //   122	96	8	localUserDataItem	UserData.UserDataItem
    // Exception table:
    //   from	to	target	type
    //   38	74	234	java/lang/Throwable
    //   78	107	234	java/lang/Throwable
    //   114	188	234	java/lang/Throwable
    //   188	227	234	java/lang/Throwable
    //   6	18	249	finally
    //   18	35	249	finally
    //   38	74	249	finally
    //   78	107	249	finally
    //   114	188	249	finally
    //   188	227	249	finally
    //   235	246	249	finally
  }
  
  private boolean c(Object paramObject)
  {
    if ((paramObject instanceof MsgTabBannerData))
    {
      if (!((MsgTabBannerData)paramObject).equals(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelMsgTabBannerData)) {}
    }
    else {
      while ((paramObject == null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelMsgTabBannerData != null)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 30) {
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
      for (;;)
      {
        SpringHbMonitorReporter.a(201, localThrowable, new String[0]);
        QLog.d("shua2021_SpringFestivalEntryManager", 1, localThrowable.getMessage(), localThrowable);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("shua2021_SpringFestivalEntryManager", 2, "saveLocalUserData");
    }
  }
  
  private void g()
  {
    QLog.i("shua2021_SpringFestivalEntryManager", 1, "generateTasksAndLaunch," + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = false;
    b(new SpringFestivalEntryManager.2(this));
  }
  
  private void h()
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        QLog.i("shua2021_SpringFestivalEntryManager", 1, String.format("checkAndScheduleTask isZipResCheckSuc=%b", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
        boolean bool2 = this.jdField_b_of_type_Boolean;
        if (!bool2) {
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
          break label171;
        }
        SpringHbMonitorReporter.a(204, localThrowable1, new String[] { "isMainThread=" + bool1 + "stack=" + Log.getStackTraceString(localThrowable1) });
      }
      catch (Throwable localThrowable2)
      {
        continue;
      }
      QLog.e("shua2021_SpringFestivalEntryManager", 1, "checkAndScheduleTask ex. " + localThrowable1.getMessage(), localThrowable1);
      continue;
      label171:
      bool1 = false;
    }
  }
  
  private void i()
  {
    long l1 = 300000L;
    int i = 0;
    long l2;
    try
    {
      QLog.i("shua2021_SpringFestivalEntryManager", 1, "scheduleNextTask.");
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        QLog.i("shua2021_SpringFestivalEntryManager", 1, "scheduleNextTask. task list is empty. return.");
      }
      for (;;)
      {
        return;
        Party.PartyTask localPartyTask = (Party.PartyTask)this.jdField_a_of_type_JavaUtilList.get(0);
        l2 = localPartyTask.jdField_a_of_type_Long - a();
        if (l2 >= -300000L) {
          break;
        }
        h();
        QLog.i("shua2021_SpringFestivalEntryManager", 1, "scheduleNextTask. delay time < -5 minute, checkAndScheduleTask.");
      }
      if (l2 >= 86400000L) {
        break label303;
      }
    }
    finally {}
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1001);
    if (l2 > 300000L) {
      localMessage.arg1 = 1;
    }
    for (;;)
    {
      l2 = l1;
      if (c()) {
        l2 = l1 / this.jdField_c_of_type_Int;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, l2);
      QLog.i("shua2021_SpringFestivalEntryManager", 1, "scheduleNextTask. delay time is: " + l2 + " next task is: " + localObject.toString());
      if (!QLog.isColorLevel()) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        QLog.d("shua2021_SpringFestivalEntryManager", 2, String.format("scheduleNextTask [%d] task= %s", new Object[] { Integer.valueOf(i), ((Party.PartyTask)localIterator.next()).toString() }));
        i += 1;
      }
      break;
      label303:
      QLog.i("shua2021_SpringFestivalEntryManager", 1, "scheduleNextTask. delay time beyond 24 hour. do nothing.");
      break;
      l1 = l2;
    }
  }
  
  private void j()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelUserData == null) {
        a("prepareActivityOnInit");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        SpringHbMonitorReporter.a(208, localThrowable, new String[0]);
        QLog.e("shua2021_SpringFestivalEntryManager", 1, localThrowable.getMessage(), localThrowable);
      }
    }
    finally {}
  }
  
  private void k()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("shua2021_SpringFestivalEntryManager", 2, String.format("initLocalCacheInfo speedUp=%b", new Object[] { Boolean.valueOf(c()) }));
      }
      return;
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
    for (;;)
    {
      Object localObject;
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
        localIterator = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean.activities.iterator();
        if (!localIterator.hasNext()) {
          break label371;
        }
        localObject = (BaseActivityData)localIterator.next();
        if ((((BaseActivityData)localObject).getPeakDelayMs() > 0) && (!((BaseActivityData)localObject).scheduleTaskAfterPeak()))
        {
          localLinkedList.add(new Party.PartyTask(1001, ((BaseActivityData)localObject).getTaskTime().begin, localObject));
          localLinkedList.add(new Party.PartyTask(1002, ((BaseActivityData)localObject).getTaskTime().begin + ((BaseActivityData)localObject).getPeakDelayMs(), localObject));
          if (((BaseActivityData)localObject).schedulePendantNBreathLight())
          {
            if (((BaseActivityData)localObject).pendantData != null)
            {
              localLinkedList.add(new Party.PartyTask(2001, ((BaseActivityData)localObject).pendantData.getTaskTime().begin, localObject));
              localLinkedList.add(new Party.PartyTask(2002, ((BaseActivityData)localObject).pendantData.getTaskTime().end, localObject));
            }
            if (((BaseActivityData)localObject).breathLightData != null)
            {
              localLinkedList.add(new Party.PartyTask(3001, ((BaseActivityData)localObject).breathLightData.getTaskTime().begin, localObject));
              localLinkedList.add(new Party.PartyTask(3002, ((BaseActivityData)localObject).breathLightData.getTaskTime().end, localObject));
            }
          }
          if (((BaseActivityData)localObject).getTaskAboutToOverDuration() > 0) {
            localLinkedList.add(new Party.PartyTask(1003, a((BaseActivityData)localObject), localObject));
          }
          localLinkedList.add(new Party.PartyTask(1004, ((BaseActivityData)localObject).getTaskTime().end, localObject));
          continue;
        }
        localList.add(new Party.PartyTask(1002, ((BaseActivityData)localObject).getTaskTime().begin, localObject));
      }
      finally {}
      continue;
      label371:
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean.popBanners.iterator();
      while (localIterator.hasNext())
      {
        localObject = (PopBannerData)localIterator.next();
        localList.add(new Party.PartyTask(4001, ((PopBannerData)localObject).getTaskTime().begin, localObject));
        localList.add(new Party.PartyTask(4002, ((PopBannerData)localObject).getTaskTime().end, localObject));
      }
      localIterator = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean.msgTabBanners.iterator();
      while (localIterator.hasNext())
      {
        localObject = (MsgTabBannerData)localIterator.next();
        localList.add(new Party.PartyTask(5001, ((MsgTabBannerData)localObject).getTaskTime().begin, localObject));
        localList.add(new Party.PartyTask(5002, ((MsgTabBannerData)localObject).getTaskTime().end, localObject));
      }
      if (!a(localList))
      {
        Collections.sort(localList, new SpringFestivalEntryManager.15(this));
        this.jdField_a_of_type_JavaUtilList.addAll(localList);
      }
      QLog.i("shua2021_SpringFestivalEntryManager", 1, String.format("buildAndSortPartyTaskQueue list=%s", new Object[] { this.jdField_a_of_type_JavaUtilList }));
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long a()
  {
    if (c()) {}
    for (long l = (NetConnInfoCenter.getServerTimeMillis() - this.jdField_c_of_type_Long) * this.jdField_c_of_type_Int + this.jdField_b_of_type_Long;; l = NetConnInfoCenter.getServerTimeMillis())
    {
      QLog.i("shua2021_SpringFestivalEntryManager", 1, "getCurrentTime -->" + TimeFormatterUtils.b(l));
      return l;
    }
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
  
  /* Error */
  public BaseActivityData a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 815	com/tencent/mobileqq/activity/springfestival/entry/SpringFestivalEntryManager:jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean	Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnonnull +11 -> 21
    //   13: aconst_null
    //   14: astore 4
    //   16: aload_0
    //   17: monitorexit
    //   18: aload 4
    //   20: areturn
    //   21: aload_0
    //   22: getfield 815	com/tencent/mobileqq/activity/springfestival/entry/SpringFestivalEntryManager:jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean	Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;
    //   25: getfield 571	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:activities	Ljava/util/List;
    //   28: invokeinterface 307 1 0
    //   33: astore 5
    //   35: aload 5
    //   37: invokeinterface 312 1 0
    //   42: ifeq +32 -> 74
    //   45: aload 5
    //   47: invokeinterface 323 1 0
    //   52: checkcast 164	com/tencent/mobileqq/activity/springfestival/entry/model/BaseActivityData
    //   55: astore 4
    //   57: aload 4
    //   59: invokevirtual 168	com/tencent/mobileqq/activity/springfestival/entry/model/BaseActivityData:getTaskTime	()Lcom/tencent/mobileqq/activity/springfestival/entry/model/TimeInfo;
    //   62: lload_1
    //   63: invokestatic 379	com/tencent/mobileqq/activity/springfestival/Const:b	(Lcom/tencent/mobileqq/activity/springfestival/entry/model/TimeInfo;J)Z
    //   66: istore_3
    //   67: iload_3
    //   68: ifeq -33 -> 35
    //   71: goto -55 -> 16
    //   74: aconst_null
    //   75: astore 4
    //   77: goto -61 -> 16
    //   80: astore 4
    //   82: aload_0
    //   83: monitorexit
    //   84: aload 4
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	SpringFestivalEntryManager
    //   0	87	1	paramLong	long
    //   66	2	3	bool	boolean
    //   6	70	4	localObject1	Object
    //   80	5	4	localObject2	Object
    //   33	13	5	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	8	80	finally
    //   21	35	80	finally
    //   35	67	80	finally
  }
  
  @Nullable
  public EntryConfigBean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean;
  }
  
  /* Error */
  public MsgTabBannerData a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 815	com/tencent/mobileqq/activity/springfestival/entry/SpringFestivalEntryManager:jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean	Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnonnull +11 -> 21
    //   13: aconst_null
    //   14: astore 4
    //   16: aload_0
    //   17: monitorexit
    //   18: aload 4
    //   20: areturn
    //   21: aload_0
    //   22: getfield 815	com/tencent/mobileqq/activity/springfestival/entry/SpringFestivalEntryManager:jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean	Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;
    //   25: getfield 833	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:msgTabBanners	Ljava/util/List;
    //   28: invokeinterface 307 1 0
    //   33: astore 5
    //   35: aload 5
    //   37: invokeinterface 312 1 0
    //   42: ifeq +32 -> 74
    //   45: aload 5
    //   47: invokeinterface 323 1 0
    //   52: checkcast 279	com/tencent/mobileqq/activity/springfestival/entry/model/MsgTabBannerData
    //   55: astore 4
    //   57: aload 4
    //   59: invokevirtual 414	com/tencent/mobileqq/activity/springfestival/entry/model/MsgTabBannerData:getTaskTime	()Lcom/tencent/mobileqq/activity/springfestival/entry/model/TimeInfo;
    //   62: lload_1
    //   63: invokestatic 379	com/tencent/mobileqq/activity/springfestival/Const:b	(Lcom/tencent/mobileqq/activity/springfestival/entry/model/TimeInfo;J)Z
    //   66: istore_3
    //   67: iload_3
    //   68: ifeq -33 -> 35
    //   71: goto -55 -> 16
    //   74: aconst_null
    //   75: astore 4
    //   77: goto -61 -> 16
    //   80: astore 4
    //   82: aload_0
    //   83: monitorexit
    //   84: aload 4
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	SpringFestivalEntryManager
    //   0	87	1	paramLong	long
    //   66	2	3	bool	boolean
    //   6	70	4	localObject1	Object
    //   80	5	4	localObject2	Object
    //   33	13	5	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	8	80	finally
    //   21	35	80	finally
    //   35	67	80	finally
  }
  
  /* Error */
  public PopBannerData a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 815	com/tencent/mobileqq/activity/springfestival/entry/SpringFestivalEntryManager:jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean	Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnonnull +11 -> 21
    //   13: aconst_null
    //   14: astore 4
    //   16: aload_0
    //   17: monitorexit
    //   18: aload 4
    //   20: areturn
    //   21: aload_0
    //   22: getfield 815	com/tencent/mobileqq/activity/springfestival/entry/SpringFestivalEntryManager:jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean	Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;
    //   25: getfield 830	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:popBanners	Ljava/util/List;
    //   28: invokeinterface 307 1 0
    //   33: astore 5
    //   35: aload 5
    //   37: invokeinterface 312 1 0
    //   42: ifeq +32 -> 74
    //   45: aload 5
    //   47: invokeinterface 323 1 0
    //   52: checkcast 246	com/tencent/mobileqq/activity/springfestival/entry/model/PopBannerData
    //   55: astore 4
    //   57: aload 4
    //   59: invokevirtual 406	com/tencent/mobileqq/activity/springfestival/entry/model/PopBannerData:getTaskTime	()Lcom/tencent/mobileqq/activity/springfestival/entry/model/TimeInfo;
    //   62: lload_1
    //   63: invokestatic 379	com/tencent/mobileqq/activity/springfestival/Const:b	(Lcom/tencent/mobileqq/activity/springfestival/entry/model/TimeInfo;J)Z
    //   66: istore_3
    //   67: iload_3
    //   68: ifeq -33 -> 35
    //   71: goto -55 -> 16
    //   74: aconst_null
    //   75: astore 4
    //   77: goto -61 -> 16
    //   80: astore 4
    //   82: aload_0
    //   83: monitorexit
    //   84: aload 4
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	SpringFestivalEntryManager
    //   0	87	1	paramLong	long
    //   66	2	3	bool	boolean
    //   6	70	4	localObject1	Object
    //   80	5	4	localObject2	Object
    //   33	13	5	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	8	80	finally
    //   21	35	80	finally
    //   35	67	80	finally
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
    if (QLog.isColorLevel()) {
      QLog.d("shua2021_SpringFestivalEntryManager", 2, "playSound, " + paramInt + ", " + this.jdField_a_of_type_ArrayOfInt[paramInt] + ", " + jdField_a_of_type_ArrayOfBoolean[paramInt] + ", mPlayCountDownStreamId=" + this.d + ", mPlayCountDownState=" + this.jdField_a_of_type_Int);
    }
    if (e()) {
      QLog.d("shua2021_SpringFestivalEntryManager", 1, "playSound return for special phone");
    }
    for (;;)
    {
      return;
      int i;
      try
      {
        if (this.jdField_a_of_type_AndroidMediaSoundPool == null)
        {
          this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(10, 3, 0);
          this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(this.jdField_a_of_type_AndroidMediaSoundPool$OnLoadCompleteListener);
        }
        if (paramInt == 2)
        {
          if (((this.jdField_a_of_type_Int == 4) && (paramBoolean)) || ((this.jdField_a_of_type_Int == 1) && (!paramBoolean))) {
            continue;
          }
          this.jdField_a_of_type_Int = 1;
        }
        i = this.jdField_a_of_type_ArrayOfInt[paramInt];
        if (i != 0) {
          break label273;
        }
        i = this.jdField_a_of_type_AndroidMediaSoundPool.load(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), jdField_b_of_type_ArrayOfInt[paramInt], 1);
        this.jdField_a_of_type_ArrayOfInt[paramInt] = i;
        return;
      }
      catch (Throwable localThrowable)
      {
        SpringHbMonitorReporter.a(210, localThrowable, new String[0]);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("shua2021_SpringFestivalEntryManager", 2, "playSound, throwable=" + localThrowable.getMessage());
        localThrowable.printStackTrace();
        return;
        label273:
        if (jdField_a_of_type_ArrayOfBoolean[paramInt] != 0) {
          if (paramInt == 2) {}
        }
        for (i = this.jdField_a_of_type_AndroidMediaSoundPool.play(i, 1.0F, 1.0F, 1, 0, 1.0F); QLog.isColorLevel(); i = -1)
        {
          QLog.d("shua2021_SpringFestivalEntryManager", 2, "playSound, " + paramInt + ", " + this.jdField_a_of_type_ArrayOfInt[paramInt] + ", " + jdField_a_of_type_ArrayOfBoolean[paramInt] + ", " + i + ", mPlayCountDownStreamId=" + this.d);
          return;
          if (this.d == 0) {
            this.d = this.jdField_a_of_type_AndroidMediaSoundPool.play(i, 1.0F, 1.0F, 10, -1, 1.0F);
          }
        }
      }
    }
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
    boolean bool = true;
    if (paramITaskCallback != null) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryITaskCallback = new WrapperTaskCallback(paramITaskCallback);
        QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("setTaskCallback hasHoldTaskQueue=%b callback=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), paramITaskCallback }));
        if (paramITaskCallback != null) {
          break label143;
        }
        return;
      }
      finally {}
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("setTaskCallback clearAllTasks on callback=null isMain=%b", new Object[] { Boolean.valueOf(bool) }));
        if ((this.jdField_b_of_type_Int != 0) && (this.jdField_b_of_type_Int != 3) && (this.jdField_b_of_type_Int != 4)) {
          b(a());
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryITaskCallback = null;
      }
      else
      {
        bool = false;
        continue;
        label143:
        if (this.jdField_a_of_type_Boolean) {
          g();
        }
      }
    }
  }
  
  public void a(EntryConfigBean paramEntryConfigBean)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("onEntryConfigReady config is: ");
          if (paramEntryConfigBean == null)
          {
            localObject = "null";
            QLog.i("shua2021_SpringFestivalEntryManager", 2, (String)localObject);
          }
        }
        else
        {
          if (!AppSetting.d) {
            continue;
          }
          QLog.i("shua2021_SpringFestivalEntryManager", 1, "onEntryConfigReady enableTalkBack, return.");
          return;
        }
        Object localObject = paramEntryConfigBean.toSimpleString();
        continue;
        localObject = paramEntryConfigBean;
        if (paramEntryConfigBean == null)
        {
          localObject = new EntryConfigBean();
          QLog.d("shua2021_SpringFestivalEntryManager", 1, "onEntryConfigReady use empty entryConfig!!!!!!");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelUserData == null) {
          a("onEntryConfigReady");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelUserData.onGetEntryConfig((EntryConfigBean)localObject)) {
          a();
        }
        if (!a(((EntryConfigBean)localObject).commonData.zipResList, ((EntryConfigBean)localObject).version))
        {
          this.jdField_b_of_type_Boolean = bool;
          this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean = ((EntryConfigBean)localObject);
          if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryITaskCallback != null) {
            break label192;
          }
          this.jdField_a_of_type_Boolean = true;
          QLog.i("shua2021_SpringFestivalEntryManager", 1, "onEntryConfigReady earlier than setTaskCallback，hold taskQueue");
          continue;
        }
        bool = false;
      }
      finally {}
      continue;
      label192:
      g();
    }
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
    if (localEntryConfigBean != null) {}
    for (int i = localEntryConfigBean.version;; i = 0)
    {
      QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("onZipResCheckDone suc=%b cfgVer=%d thisCfgVer=%d isZipResCheckSuc=%b", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
      if ((paramBoolean) && (paramInt == i) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_b_of_type_Boolean = true;
        b(true);
      }
      return;
    }
  }
  
  public boolean a()
  {
    Object localObject = a(a());
    if (localObject != null)
    {
      PendantData localPendantData = ((BaseActivityData)localObject).pendantData;
      boolean bool;
      String str;
      int i;
      if ((localPendantData != null) && (localPendantData.showPendantSwitch) && (Const.a(localPendantData.getTaskTime(), a())))
      {
        bool = true;
        str = ((BaseActivityData)localObject).id;
        i = ((BaseActivityData)localObject).type;
        if (localPendantData != null) {
          break label109;
        }
      }
      label109:
      for (localObject = "null";; localObject = localPendantData.toSimpleString())
      {
        QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("isNeedShowPendantSwitchItem true actId=%s actType=%d pendant=%s", new Object[] { str, Integer.valueOf(i), localObject }));
        return bool;
        bool = false;
        break;
      }
    }
    QLog.d("shua2021_SpringFestivalEntryManager", 1, "isNeedShowPendantSwitchItem false no activity");
    return false;
  }
  
  public boolean a(BaseActivityData paramBaseActivityData)
  {
    boolean bool = false;
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean;
      if ((paramBaseActivityData == null) || (localObject == null) || (((EntryConfigBean)localObject).activities.size() <= 0) || (paramBaseActivityData.pendantData == null)) {
        QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("notifyCloseAllOnGrabActivitiesToday return", new Object[0]));
      }
      int i;
      for (;;)
      {
        return bool;
        try
        {
          String str = a(a());
          a().edit().putBoolean("pendant_close_byday" + str, true).apply();
          QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("notifyCloseAllOnGrabActivitiesToday today=%s", new Object[] { str }));
          int j = paramBaseActivityData.pendantData.closeType;
          ArrayList localArrayList = new ArrayList();
          localArrayList.addAll(((EntryConfigBean)localObject).activities);
          paramBaseActivityData = BaseApplicationImpl.getApplication().getResources().getString(2131699228);
          i = localArrayList.size() - 1;
          if (i >= 0)
          {
            localObject = (BaseActivityData)localArrayList.get(i);
            if (!str.equals(a(((BaseActivityData)localObject).getConfigTime().begin))) {
              break label371;
            }
            UserData.UserDataItem localUserDataItem = a(((BaseActivityData)localObject).id);
            localUserDataItem.hasClickCloseBtn = true;
            localUserDataItem.pendantCloseType = j;
            if ((((BaseActivityData)localObject).getType() == 2) && (!TextUtils.isEmpty(((BaseActivityData)localObject).getMiniEntryData().endWording)))
            {
              paramBaseActivityData = ((BaseActivityData)localObject).getMiniEntryData().endWording;
              break;
            }
            if ((((BaseActivityData)localObject).getType() != 1) && (((BaseActivityData)localObject).getType() != 2)) {
              break label371;
            }
            ((BaseActivityData)localObject).getMiniEntryData().endWording = paramBaseActivityData;
            ((BaseActivityData)localObject).getMiniEntryData().preWording = "";
            break label371;
          }
          a();
        }
        catch (Throwable paramBaseActivityData)
        {
          for (;;)
          {
            SpringHbMonitorReporter.a(206, paramBaseActivityData, new String[0]);
            QLog.d("shua2021_SpringFestivalEntryManager", 1, paramBaseActivityData.getMessage(), paramBaseActivityData);
          }
        }
        bool = true;
      }
      i -= 1;
    }
    finally {}
    label371:
    for (;;)
    {
      break;
    }
  }
  
  public boolean a(List<ZipRes> paramList, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryIPreloadRes.a(paramList, paramInt);
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryIZipResCheck.a(paramList, paramInt);
      return bool;
    }
    catch (Exception paramList)
    {
      SpringHbMonitorReporter.a(205, paramList, new String[0]);
      QLog.e("shua2021_SpringFestivalEntryManager", 1, paramList.getMessage(), paramList);
    }
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
    int j = 1;
    QLog.d("shua2021_SpringFestivalEntryManager", 1, "refreshScheduleTask force=" + paramBoolean);
    int i = j;
    if (this.jdField_b_of_type_Int != 0)
    {
      i = j;
      if (this.jdField_b_of_type_Int != 3) {
        if (this.jdField_b_of_type_Int != 4) {
          break label74;
        }
      }
    }
    label74:
    for (i = j; ((!paramBoolean) && (i != 0)) || (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean == null); i = 0) {
      return;
    }
    b(new SpringFestivalEntryManager.16(this));
  }
  
  public boolean b()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {}
    for (boolean bool = localSharedPreferences.getBoolean("pendant_show_switch", true);; bool = true)
    {
      QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("isPendantShowSwitchOn %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("shua2021_SpringFestivalEntryManager", 2, "stopCountDownSound, mPlayCountDownStreamId=" + this.d + ", mPlayCountDownState=" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Int == 4) {
      return;
    }
    if (this.d != 0) {}
    try
    {
      if (this.jdField_a_of_type_AndroidMediaSoundPool != null) {
        this.jdField_a_of_type_AndroidMediaSoundPool.pause(this.d);
      }
      this.d = 0;
      this.jdField_a_of_type_Int = 4;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        SpringHbMonitorReporter.a(211, localThrowable, new String[0]);
      }
    }
  }
  
  public boolean d()
  {
    boolean bool = false;
    label204:
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean;
        if (localObject1 == null) {
          return bool;
        }
        long l1 = a();
        long l2 = ((EntryConfigBean)localObject1).commonData.forbidRefreshBeforeTime * 1000;
        long l3 = ((EntryConfigBean)localObject1).commonData.forbidRefreshAfterTime * 1000;
        String str = null;
        Iterator localIterator = ((EntryConfigBean)localObject1).activities.iterator();
        localObject1 = str;
        if (localIterator.hasNext())
        {
          localObject1 = (BaseActivityData)localIterator.next();
          TimeInfo localTimeInfo = ((BaseActivityData)localObject1).calcForbidRefreshTimeInfo(l2, l3);
          if ((((BaseActivityData)localObject1).getType() != 2) || (!Const.a(localTimeInfo, l1))) {}
        }
        else
        {
          if (localObject1 == null)
          {
            str = "null";
            QLog.d("shua2021_SpringFestivalEntryManager", 1, String.format("isForbidRefreshTime [%d,%d] act=%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3), str }));
            if (localObject1 != null)
            {
              bool = true;
              break label204;
            }
          }
          else
          {
            str = ((BaseActivityData)localObject1).toSimpleString();
            continue;
          }
          bool = false;
        }
      }
      finally {}
    }
  }
  
  public void e()
  {
    ((Vibrator)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSystemService("vibrator")).vibrate(300L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1001) {}
    while (paramMessage.what != 1002) {
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
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1002);
    f();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager
 * JD-Core Version:    0.7.0.1
 */