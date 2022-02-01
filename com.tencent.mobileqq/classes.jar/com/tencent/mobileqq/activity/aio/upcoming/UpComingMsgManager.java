package com.tencent.mobileqq.activity.aio.upcoming;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.api.IColorNoteDataService;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.IColorNoteListener;
import com.tencent.mobileqq.colornote.smallscreen.UpComingMsgModel;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class UpComingMsgManager
  implements Manager
{
  protected ConcurrentHashMap<String, ColorNote> a = new ConcurrentHashMap();
  private final QQAppInterface b;
  private ConcurrentHashMap<String, Long> c = new ConcurrentHashMap();
  private final MqqHandler d = new MqqHandler(ThreadManager.getSubThreadLooper(), new UpComingMsgManager.1(this));
  private IColorNoteListener e = new UpComingMsgManager.2(this);
  
  public UpComingMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    ((IColorNoteDataService)this.b.getRuntimeService(IColorNoteDataService.class)).registerColorNoteListener(this.e);
  }
  
  private void a(Context paramContext, UpComingMsgModel paramUpComingMsgModel)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[handleClickFromMulti], model:");
      localStringBuilder.append(paramUpComingMsgModel);
      QLog.d("UpComingMsgLogic.UpComingMsgManager", 2, localStringBuilder.toString());
    }
    if (paramUpComingMsgModel.type == 1)
    {
      b(paramContext, paramUpComingMsgModel);
      ReportController.b(null, "dc00898", "", "", "0X800AE90", "0X800AE90", 1, 0, "", "", "", "");
      return;
    }
    if (paramUpComingMsgModel.type == 2) {
      c(paramContext, paramUpComingMsgModel);
    }
  }
  
  private void a(ColorNote paramColorNote, int paramInt)
  {
    if (paramColorNote != null)
    {
      if (paramInt != 1001)
      {
        if (paramInt != 1002) {
          return;
        }
        c(paramColorNote);
        this.c.remove(paramColorNote.getSubType());
        return;
      }
      long l2 = System.currentTimeMillis();
      for (long l1 = UpComingMsgUtil.a(paramColorNote); a(l1); l1 += 1L) {}
      this.c.put(paramColorNote.getSubType(), Long.valueOf(l1));
      boolean bool = ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).isNeedNowNotify(paramColorNote);
      Object localObject;
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("currentTime = ");
        ((StringBuilder)localObject).append(l2);
        ((StringBuilder)localObject).append(", mindTime = ");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(", needNowNotify = ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", note.ServiceType = ");
        ((StringBuilder)localObject).append(paramColorNote.getServiceType());
        QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, ((StringBuilder)localObject).toString());
      }
      if (((((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).isUpcomingColorNote(paramColorNote)) && (l2 < l1)) || (bool))
      {
        localObject = Message.obtain();
        ((Message)localObject).what = paramInt;
        ((Message)localObject).obj = paramColorNote;
        this.a.put(paramColorNote.getSubType(), paramColorNote);
        paramColorNote = this.d;
        if (l2 < l1) {
          l1 -= l2;
        } else {
          l1 = 0L;
        }
        paramColorNote.sendMessageDelayed((Message)localObject, l1);
        return;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, "handleListener() CALLED.currentTime higher mindTime.");
      }
    }
  }
  
  private boolean a()
  {
    return true;
  }
  
  private boolean a(long paramLong)
  {
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (((Long)((Map.Entry)localIterator.next()).getValue()).longValue() == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  private void b(Context paramContext, UpComingMsgModel paramUpComingMsgModel)
  {
    long l = ((Long)paramUpComingMsgModel.uniseq.get(0)).longValue();
    Intent localIntent = new Intent(paramContext, SplashActivity.class);
    AIOUtils.a(localIntent, new int[] { 2 });
    localIntent.putExtra("uin", paramUpComingMsgModel.frienduin);
    localIntent.putExtra("uintype", paramUpComingMsgModel.istroop);
    localIntent.putExtra("key_uniseq", l);
    localIntent.putExtra("troop_uin", paramUpComingMsgModel.troopUin);
    if (!TextUtils.isEmpty(paramUpComingMsgModel.nickName)) {
      localIntent.putExtra("uinname", paramUpComingMsgModel.nickName);
    }
    paramContext.startActivity(localIntent);
  }
  
  private void c(Context paramContext, UpComingMsgModel paramUpComingMsgModel)
  {
    if (paramUpComingMsgModel.uniseq.size() > 0)
    {
      Intent localIntent = new Intent(paramContext, ChatActivity.class);
      localIntent.putExtra("chat_subType", 4);
      localIntent.putExtra("uin", paramUpComingMsgModel.frienduin);
      localIntent.putExtra("uintype", paramUpComingMsgModel.istroop);
      if (!TextUtils.isEmpty(paramUpComingMsgModel.nickName)) {
        localIntent.putExtra("uinname", paramUpComingMsgModel.nickName);
      }
      localIntent.addFlags(268435456);
      localIntent.putExtra("key_uniseq", paramUpComingMsgModel.uniseq.toArray(new Long[0]));
      paramContext.startActivity(localIntent);
    }
  }
  
  private void c(ColorNote paramColorNote)
  {
    if (this.a.containsKey(paramColorNote.getSubType()))
    {
      this.d.removeMessages(1001, this.a.get(paramColorNote.getSubType()));
      this.a.remove(paramColorNote.getSubType());
    }
  }
  
  private void d(ColorNote paramColorNote)
  {
    if (this.b == null) {
      return;
    }
    Object localObject;
    if (!((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).checkPermission(BaseApplicationImpl.getContext()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("permission denied, stop notify: ");
      ((StringBuilder)localObject).append(paramColorNote.toString());
      QLog.e("UpComingMsgLogic.UpComingMsgManager", 1, ((StringBuilder)localObject).toString());
      return;
    }
    this.c.remove(paramColorNote.getSubType());
    if (a())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[notifyComing] is called. isBackground_Pause = ");
        ((StringBuilder)localObject).append(this.b.isBackgroundPause);
        ((StringBuilder)localObject).append(", isBackground_Stop = ");
        ((StringBuilder)localObject).append(this.b.isBackgroundStop);
        QLog.d("UpComingMsgLogic.UpComingMsgManager", 2, ((StringBuilder)localObject).toString());
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[notifyComing], colorNote:");
        ((StringBuilder)localObject).append(paramColorNote);
        QLog.d("UpComingMsgLogic.UpComingMsgManager", 2, ((StringBuilder)localObject).toString());
      }
      e(paramColorNote);
      if ((this.b.isBackgroundPause) || (this.b.isBackgroundStop))
      {
        b(paramColorNote);
        ReportController.b(null, "dc00898", "", "", "0X800AE83", "0X800AE83", 0, 0, "", "", "", "");
      }
      localObject = this.b.getApp().getApplicationContext();
      ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).notifyUpcoming((Context)localObject, paramColorNote);
    }
    ReportController.b(null, "dc00898", "", "", "0X800AE82", "0X800AE82", 0, 0, "", "", "", "");
  }
  
  private void e(ColorNote paramColorNote)
  {
    if (paramColorNote != null) {
      ((IColorNoteDataService)this.b.getRuntimeService(IColorNoteDataService.class)).setUpcomingColorNoteExtLong(paramColorNote);
    }
  }
  
  public void a(Context paramContext, ColorNote paramColorNote)
  {
    String str = new String(paramColorNote.getReserve());
    UpComingMsgModel localUpComingMsgModel = new UpComingMsgModel();
    localUpComingMsgModel.parseFromJson(str);
    a(paramContext, localUpComingMsgModel);
    int i;
    if (((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).isNeedNowNotify(paramColorNote)) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800AE8F", "0X800AE8F", i, localUpComingMsgModel.reportType, "", "", "", "");
  }
  
  public void a(Context paramContext, ChatMessage paramChatMessage, String paramString)
  {
    long l = paramChatMessage.uniseq;
    Intent localIntent = new Intent(paramContext, SplashActivity.class);
    AIOUtils.a(localIntent, new int[] { 2 });
    localIntent.putExtra("uin", paramChatMessage.frienduin);
    localIntent.putExtra("uintype", paramChatMessage.istroop);
    localIntent.putExtra("key_uniseq", l);
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("uinname", paramString);
    }
    paramContext.startActivity(localIntent);
    ReportController.b(null, "dc00898", "", "", "0X800AE90", "0X800AE90", 2, 0, "", "", "", "");
  }
  
  public void a(ColorNote paramColorNote)
  {
    if (this.a.containsKey(paramColorNote.getSubType()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, "onColorNoteLoadFromLocal() CALLED.has marked.");
      }
      return;
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onColorNoteLoadFromLocal() CALLED.colorNote = ");
      localStringBuilder.append(paramColorNote);
      QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, localStringBuilder.toString());
    }
    a(paramColorNote, 1001);
  }
  
  protected void b(ColorNote paramColorNote)
  {
    if (BaseApplicationImpl.getApplication().getRuntime().isLogin())
    {
      Object localObject1 = new Intent(BaseApplicationImpl.getContext(), SplashActivity.class);
      ((Intent)localObject1).putExtra("KEY_CMD_SHOW_LIST", 1);
      ((Intent)localObject1).putExtra("flag_open_up_coming_list", true);
      ((Intent)localObject1).putExtra("tab_index", FrameControllerUtil.a);
      ((Intent)localObject1).putExtra("fragment_id", 1);
      ((Intent)localObject1).addFlags(335544320);
      ((Intent)localObject1).setAction("com.tencent.mobileqq.action.MAINACTIVITY");
      ((Intent)localObject1).putExtra("param_notifyid", 3000529);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("showNotification intent = ");
        ((StringBuilder)localObject2).append(localObject1.hashCode());
        QLog.d("UpComingMsgLogic.UpComingMsgManager", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = PendingIntent.getActivity(BaseApplication.getContext(), 0, (Intent)localObject1, 134217728);
      Object localObject2 = NotificationFactory.createNotificationCompatBuilder("CHANNEL_ID_OTHER").setSmallIcon(2130842312).setAutoCancel(true).setOngoing(false).setWhen(System.currentTimeMillis());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("收到待办提醒: ");
      localStringBuilder.append(paramColorNote.getMainTitle());
      ((NotificationCompat.Builder)localObject2).setContentText(localStringBuilder.toString()).setContentIntent((PendingIntent)localObject1);
      paramColorNote = ((NotificationCompat.Builder)localObject2).build();
      QQNotificationManager.getInstance().notify("UpComingMsgLogic.UpComingMsgManager", 3000529, paramColorNote);
    }
  }
  
  public void onDestroy()
  {
    this.a.clear();
    this.c.clear();
    ((IColorNoteDataService)this.b.getRuntimeService(IColorNoteDataService.class)).unregisterColorNoteListener(this.e);
    this.d.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgManager
 * JD-Core Version:    0.7.0.1
 */