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
  private static WSFallKeyPicMonitor jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWsappWSFallKeyPicMonitor;
  private static boolean jdField_c_of_type_Boolean;
  private volatile int jdField_a_of_type_Int = 0;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private WSFallKeyPicMonitor.DownloadHandler jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWsappWSFallKeyPicMonitor$DownloadHandler;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private volatile int jdField_b_of_type_Int = 0;
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private final Object jdField_c_of_type_JavaLangObject = new Object();
  private int d = 99;
  
  @NonNull
  private WSDownloadParams a()
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = this.jdField_c_of_type_Int;
    localWSDownloadParams.mEventId = this.d;
    localWSDownloadParams.mTestId = WSReportDc00898.b();
    localWSDownloadParams.mScheme = this.jdField_a_of_type_JavaLangString;
    return localWSDownloadParams;
  }
  
  public static WSFallKeyPicMonitor a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWsappWSFallKeyPicMonitor == null) {
      try
      {
        if (jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWsappWSFallKeyPicMonitor == null) {
          jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWsappWSFallKeyPicMonitor = new WSFallKeyPicMonitor();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWsappWSFallKeyPicMonitor;
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
    if (jdField_c_of_type_Boolean)
    {
      WSLog.b("WSFallKeyPicMonitor", "sendStartEvent");
      SimpleEventBus.getInstance().dispatchEvent(new WSPicMonitorEvent(paramInt, 1, ""));
    }
  }
  
  public static <T> void a(int paramInt, T paramT)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendStartEvent sRunning:");
    localStringBuilder.append(jdField_c_of_type_Boolean);
    WSLog.b("WSFallKeyPicMonitor", localStringBuilder.toString());
    if (jdField_c_of_type_Boolean) {
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
    if (jdField_c_of_type_Boolean)
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
    if (jdField_c_of_type_Boolean) {
      SimpleEventBus.getInstance().dispatchEvent(new WSPicMonitorEvent(paramInt, -1, paramT));
    }
  }
  
  public static void b(SimpleEventReceiver paramSimpleEventReceiver)
  {
    WSLog.b("WSFallKeyPicMonitor", "unRegisterReceiver");
    SimpleEventBus.getInstance().unRegisterReceiver(paramSimpleEventReceiver);
  }
  
  private void c()
  {
    if (jdField_c_of_type_Boolean)
    {
      jdField_c_of_type_Boolean = false;
      WSLog.b("WSFallKeyPicMonitor", "release");
      WSFallKeyPicMonitor.DownloadHandler localDownloadHandler = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWsappWSFallKeyPicMonitor$DownloadHandler;
      if (localDownloadHandler != null) {
        localDownloadHandler.removeMessages(1);
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      b(this);
    }
  }
  
  private void d()
  {
    WSLog.b("WSFallKeyPicMonitor", "startPreDownLoadWeiShi");
    WSDownloadParams localWSDownloadParams = a();
    WeishiDownloadUtil.a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localWSDownloadParams);
  }
  
  private void e()
  {
    WSLog.b("WSFallKeyPicMonitor", "performSilentDownload");
    WSDownloadParams localWSDownloadParams = a();
    WeishiDownloadUtil.a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localWSDownloadParams, true, 2);
    WSReportDc00898.a(115, Integer.valueOf(4));
    a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, this.jdField_c_of_type_Int, this.d);
  }
  
  public void a()
  {
    WSLog.b("WSFallKeyPicMonitor", "immediatelyPreload");
    WSFallKeyPicMonitor.DownloadHandler localDownloadHandler = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWsappWSFallKeyPicMonitor$DownloadHandler;
    if (localDownloadHandler != null)
    {
      localDownloadHandler.removeMessages(1);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWsappWSFallKeyPicMonitor$DownloadHandler.sendEmptyMessage(1);
    }
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
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = paramstSimpleMetaFeed;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = a(paramstSimpleMetaFeed);
    if (paramInt == 4) {
      paramInt = 300;
    } else {
      paramInt = 99;
    }
    this.d = paramInt;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWsappWSFallKeyPicMonitor$DownloadHandler == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWsappWSFallKeyPicMonitor$DownloadHandler = new WSFallKeyPicMonitor.DownloadHandler(this, this);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWsappWSFallKeyPicMonitor$DownloadHandler.sendEmptyMessageDelayed(1, 3000L);
    }
  }
  
  public void a(Context paramContext)
  {
    if (WeishiGuideUtils.a(paramContext))
    {
      WSLog.d("WSFallKeyPicMonitor", "本地已经安装微视app");
      return;
    }
    if (!jdField_c_of_type_Boolean)
    {
      jdField_c_of_type_Boolean = true;
      a(this);
    }
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSFallKeyPicMonitor.java][release] sRunning:");
    localStringBuilder.append(jdField_c_of_type_Boolean);
    WSLog.b("WSFallKeyPicMonitor", localStringBuilder.toString());
    if (jdField_c_of_type_Boolean)
    {
      WsBeaconReportPresenter.a().a(WSInitializeHelper.a().a());
      c();
    }
    jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWsappWSFallKeyPicMonitor = null;
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
      int i = paramSimpleBaseEvent.getType();
      int j = 1;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            break label180;
          }
          synchronized (this.jdField_c_of_type_JavaLangObject)
          {
            this.jdField_a_of_type_Int += paramSimpleBaseEvent.getOperateType();
          }
        }
        this.jdField_b_of_type_Boolean = true;
        synchronized (this.jdField_b_of_type_JavaLangObject)
        {
          this.jdField_b_of_type_Int += paramSimpleBaseEvent.getOperateType();
        }
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (paramSimpleBaseEvent.getOperateType() == 1)
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaUtilList.add(paramSimpleBaseEvent.getContent());
        }
        else if (!this.jdField_a_of_type_JavaUtilList.remove(paramSimpleBaseEvent.getContent()))
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
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
          i = 1;
        } else {
          i = 0;
        }
        if ((!this.jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Int > 0)) {
          j = 0;
        }
        if ((i != 0) && (j != 0) && (this.jdField_a_of_type_Int <= 0))
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_b_of_type_Boolean = false;
          a();
          WSLog.b("WSFallKeyPicMonitor", "非超时触发下载");
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor
 * JD-Core Version:    0.7.0.1
 */