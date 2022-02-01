package com.tencent.biz.pubaccount.weishi_new.download.wsapp;

import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class WSFallKeyPicMonitor
  implements SimpleEventReceiver<WSPicMonitorEvent>
{
  private static WSFallKeyPicMonitor a;
  private static boolean p;
  private boolean b = false;
  private boolean c = false;
  private volatile int d = 0;
  private volatile int e = 0;
  private List<Object> f = new ArrayList();
  private final Object g = new Object();
  private final Object h = new Object();
  private final Object i = new Object();
  private WeakReference<Activity> j;
  private int k = 0;
  private String l;
  private int m = 99;
  private stSimpleMetaFeed n;
  private WSFallKeyPicMonitor.DownloadHandler o;
  
  public static WSFallKeyPicMonitor a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new WSFallKeyPicMonitor();
        }
      }
      finally {}
    }
    return a;
  }
  
  private String a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("weishi://feed?feed_id=");
      ((StringBuilder)localObject).append(paramstSimpleMetaFeed.id);
      localObject = ((StringBuilder)localObject).toString();
      if (!TextUtils.isEmpty(paramstSimpleMetaFeed.weishi_jump_url)) {
        localObject = paramstSimpleMetaFeed.weishi_jump_url;
      }
      return localObject;
    }
    return null;
  }
  
  public static void a(int paramInt)
  {
    if (p)
    {
      WSLog.b("WSFallKeyPicMonitor", "sendStartEvent");
      SimpleEventBus.getInstance().dispatchEvent(new WSPicMonitorEvent(paramInt, 1, ""));
    }
  }
  
  public static <T> void a(int paramInt, T paramT)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendStartEvent sRunning:");
    localStringBuilder.append(p);
    WSLog.b("WSFallKeyPicMonitor", localStringBuilder.toString());
    if (p) {
      SimpleEventBus.getInstance().dispatchEvent(new WSPicMonitorEvent(paramInt, 1, paramT));
    }
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt1, int paramInt2)
  {
    if (paramstSimpleMetaFeed != null)
    {
      WSLog.b("WSFallKeyPicMonitor", "recommendReportForDlOpenWeiShi");
      UserActionReportPresenter.a(1, 115, 0, paramstSimpleMetaFeed, WeishiDownloadUtil.a(1, paramInt1, paramInt2));
      return;
    }
    WSLog.b("WSFallKeyPicMonitor", "recommendReportForDlOpenWeiShi failure : feed == null");
  }
  
  public static void a(SimpleEventReceiver paramSimpleEventReceiver)
  {
    WSLog.b("WSFallKeyPicMonitor", "registerReceiver");
    SimpleEventBus.getInstance().registerReceiver(paramSimpleEventReceiver);
  }
  
  public static void b(int paramInt)
  {
    if (p)
    {
      WSLog.b("WSFallKeyPicMonitor", "sendFinishEvent");
      SimpleEventBus.getInstance().dispatchEvent(new WSPicMonitorEvent(paramInt, -1, ""));
    }
  }
  
  public static <T> void b(int paramInt, T paramT)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendFinishEvent url:");
    localStringBuilder.append(paramT);
    WSLog.b("WSFallKeyPicMonitor", localStringBuilder.toString());
    if (p) {
      SimpleEventBus.getInstance().dispatchEvent(new WSPicMonitorEvent(paramInt, -1, paramT));
    }
  }
  
  public static void b(SimpleEventReceiver paramSimpleEventReceiver)
  {
    WSLog.b("WSFallKeyPicMonitor", "unRegisterReceiver");
    SimpleEventBus.getInstance().unRegisterReceiver(paramSimpleEventReceiver);
  }
  
  private void d()
  {
    if (p)
    {
      p = false;
      WSLog.b("WSFallKeyPicMonitor", "release");
      WSFallKeyPicMonitor.DownloadHandler localDownloadHandler = this.o;
      if (localDownloadHandler != null) {
        localDownloadHandler.removeMessages(1);
      }
      this.f.clear();
      b(this);
    }
  }
  
  private void e()
  {
    WSLog.b("WSFallKeyPicMonitor", "startPreDownLoadWeiShi");
    WSDownloadParams localWSDownloadParams = g();
    WeishiDownloadUtil.a((Activity)this.j.get(), localWSDownloadParams);
  }
  
  private void f()
  {
    WSLog.b("WSFallKeyPicMonitor", "performSilentDownload");
    WSDownloadParams localWSDownloadParams = g();
    WeishiDownloadUtil.a((Activity)this.j.get(), localWSDownloadParams, true, 2);
    WSReportDc00898.a(115, Integer.valueOf(4));
    a(this.n, this.k, this.m);
  }
  
  @NonNull
  private WSDownloadParams g()
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = this.k;
    localWSDownloadParams.mEventId = this.m;
    localWSDownloadParams.mTestId = WSReportDc00898.b();
    localWSDownloadParams.mScheme = this.l;
    return localWSDownloadParams;
  }
  
  public void a(Activity paramActivity, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (WeishiGuideUtils.a(paramActivity)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init , linkType = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("; feed = ");
    localStringBuilder.append(paramstSimpleMetaFeed);
    WSLog.b("WSFallKeyPicMonitor", localStringBuilder.toString());
    this.j = new WeakReference(paramActivity);
    this.n = paramstSimpleMetaFeed;
    this.k = paramInt;
    this.l = a(paramstSimpleMetaFeed);
    if (paramInt == 4) {
      paramInt = 300;
    } else {
      paramInt = 99;
    }
    this.m = paramInt;
    if (this.o == null)
    {
      this.o = new WSFallKeyPicMonitor.DownloadHandler(this, this);
      this.o.sendEmptyMessageDelayed(1, 3000L);
    }
  }
  
  public void a(Context paramContext)
  {
    if (WeishiGuideUtils.a(paramContext))
    {
      WSLog.d("WSFallKeyPicMonitor", "本地已经安装微视app");
      return;
    }
    if (!p)
    {
      p = true;
      a(this);
    }
  }
  
  public void b()
  {
    WSLog.b("WSFallKeyPicMonitor", "immediatelyPreload");
    WSFallKeyPicMonitor.DownloadHandler localDownloadHandler = this.o;
    if (localDownloadHandler != null)
    {
      localDownloadHandler.removeMessages(1);
      this.o.sendEmptyMessage(1);
    }
  }
  
  public void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSFallKeyPicMonitor.java][release] sRunning:");
    localStringBuilder.append(p);
    WSLog.b("WSFallKeyPicMonitor", localStringBuilder.toString());
    if (p)
    {
      WsBeaconReportPresenter.a().a(WSInitializeHelper.a().h());
      d();
    }
    a = null;
  }
  
  public ArrayList<Class<WSPicMonitorEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSPicMonitorEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    WSLog.b("WSFallKeyPicMonitor", "onReceiveEvent");
    if ((paramSimpleBaseEvent instanceof WSPicMonitorEvent))
    {
      paramSimpleBaseEvent = (WSPicMonitorEvent)paramSimpleBaseEvent;
      int i1 = paramSimpleBaseEvent.getType();
      int i2 = 1;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            break label180;
          }
          synchronized (this.i)
          {
            this.d += paramSimpleBaseEvent.getOperateType();
          }
        }
        this.c = true;
        synchronized (this.h)
        {
          this.e += paramSimpleBaseEvent.getOperateType();
        }
      }
      synchronized (this.g)
      {
        if (paramSimpleBaseEvent.getOperateType() == 1)
        {
          this.b = true;
          this.f.add(paramSimpleBaseEvent.getContent());
        }
        else if (!this.f.remove(paramSimpleBaseEvent.getContent()))
        {
          return;
        }
        label180:
        ??? = new StringBuilder();
        ((StringBuilder)???).append("type = ");
        ((StringBuilder)???).append(paramSimpleBaseEvent.getType());
        ((StringBuilder)???).append("; OperateType = ");
        ((StringBuilder)???).append(paramSimpleBaseEvent.getOperateType());
        ((StringBuilder)???).append(", content = ");
        ((StringBuilder)???).append(paramSimpleBaseEvent.getContent());
        WSLog.b("WSFallKeyPicMonitor", ((StringBuilder)???).toString());
        if ((this.b) && (this.f.size() == 0)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if ((!this.c) || (this.e > 0)) {
          i2 = 0;
        }
        if ((i1 != 0) && (i2 != 0) && (this.d <= 0))
        {
          this.b = false;
          this.c = false;
          b();
          WSLog.b("WSFallKeyPicMonitor", "非超时触发下载");
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor
 * JD-Core Version:    0.7.0.1
 */