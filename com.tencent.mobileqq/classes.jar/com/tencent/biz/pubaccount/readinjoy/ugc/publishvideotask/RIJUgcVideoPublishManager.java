package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import android.support.annotation.UiThread;
import com.tencent.biz.pubaccount.readinjoy.automator.AsyncSteps;
import com.tencent.biz.pubaccount.readinjoy.automator.BaseStep;
import com.tencent.biz.pubaccount.readinjoy.automator.SyncSteps;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJPushNotification;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcVideoUploader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;

public class RIJUgcVideoPublishManager
  implements Manager
{
  private RIJUgcVideoPublishManager.RIJUgcVideoPublishManagerActivityLifecycleCallbacks jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager$RIJUgcVideoPublishManagerActivityLifecycleCallbacks = new RIJUgcVideoPublishManager.RIJUgcVideoPublishManagerActivityLifecycleCallbacks(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new RIJUgcVideoPublishManager.1(this);
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private final ArrayList<UgcVideo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final LinkedHashMap<String, PublishTaskAutomator> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<RIJUgcVideoPublishManager.IVideoPublishCallback> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private final ArrayList<RIJUgcVideoPublishManager.ILoadDBCallback> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private List<RIJUgcVideoPublishManager.IReleaseCallback> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  
  public RIJUgcVideoPublishManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    paramQQAppInterface.getApp().registerActivityLifecycleCallbacks(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager$RIJUgcVideoPublishManagerActivityLifecycleCallbacks);
  }
  
  public static RIJUgcVideoPublishManager a(QQAppInterface paramQQAppInterface)
  {
    return (RIJUgcVideoPublishManager)paramQQAppInterface.getManager(QQManagerFactory.RIJ_UGC_VIDEO_PUBLISH_MANAGER);
  }
  
  private List<UgcVideo> a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap.values();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PublishTaskAutomator localPublishTaskAutomator = (PublishTaskAutomator)((Iterator)localObject).next();
      if (localPublishTaskAutomator.a().status == UgcVideo.STATUS_UPLOADING) {
        localArrayList.add(localPublishTaskAutomator.a());
      }
    }
    return localArrayList;
  }
  
  private List<UgcVideo> a(long paramLong, List<UgcVideo> paramList)
  {
    if (paramLong == 0L) {
      return new ArrayList(paramList);
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      UgcVideo localUgcVideo = (UgcVideo)paramList.next();
      if (localUgcVideo.columnId == paramLong) {
        localArrayList.add(localUgcVideo);
      }
    }
    return localArrayList;
  }
  
  private void a(List<UgcVideo> paramList)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "handleChangeToMobileEvent is doing");
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    long l = RIJUgcUtils.a(paramList);
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((l > 0L) && (RIJPushNotification.c()) && (localBaseActivity != null))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager$RIJUgcVideoPublishManagerActivityLifecycleCallbacks.a())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager$RIJUgcVideoPublishManagerActivityLifecycleCallbacks.a(true);
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager$RIJUgcVideoPublishManagerActivityLifecycleCallbacks.a(false);
      RIJUgcUtils.a(localBaseActivity, l, new RIJUgcVideoPublishManager.12(this, paramList), new RIJUgcVideoPublishManager.13(this));
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private List<UgcVideo> b()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap.values();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PublishTaskAutomator localPublishTaskAutomator = (PublishTaskAutomator)((Iterator)localObject).next();
      if (localPublishTaskAutomator.a().status == UgcVideo.STATUS_PAUSE) {
        localArrayList.add(localPublishTaskAutomator.a());
      }
    }
    return localArrayList;
  }
  
  private void b()
  {
    ThreadManagerV2.excute(new RIJUgcVideoPublishManager.8(this), 32, null, false);
  }
  
  private void c()
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext()) {
      ((UgcVideo)localIterator.next()).canUploadInMobileNet = true;
    }
  }
  
  private void d()
  {
    if (CUKingCardHelper.a() == 1) {}
    List localList;
    int i;
    do
    {
      return;
      localList = a();
      if (localList.isEmpty())
      {
        QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "handleChangeToMobileEvent, ugcVideoList isEmpty");
        return;
      }
      Iterator localIterator = localList.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        UgcVideo localUgcVideo = (UgcVideo)localIterator.next();
        if (!localUgcVideo.canUploadInMobileNet)
        {
          localUgcVideo.pauseBySwitchNet = true;
          b(localUgcVideo);
          i = 1;
        }
        for (;;)
        {
          break;
          localUgcVideo.canUploadInMobileNet = false;
        }
      }
    } while (i == 0);
    a(localList);
  }
  
  private void e()
  {
    Object localObject = b();
    if (((List)localObject).isEmpty())
    {
      QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "handleChangeToWifiEvent, ugcVideoList isEmpty");
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      UgcVideo localUgcVideo = (UgcVideo)((Iterator)localObject).next();
      if (localUgcVideo.pauseBySwitchNet)
      {
        localUgcVideo.pauseBySwitchNet = false;
        a(localUgcVideo, true);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager$RIJUgcVideoPublishManagerActivityLifecycleCallbacks.a(false);
  }
  
  private void f()
  {
    List localList = b();
    if (localList.isEmpty())
    {
      QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "handleAppToFrontEventInMobileNet, ugcVideoList isEmpty");
      return;
    }
    a(localList);
  }
  
  private void f(UgcVideo paramUgcVideo)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((RIJUgcVideoPublishManager.IVideoPublishCallback)localIterator.next()).a(paramUgcVideo);
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      UgcVideo localUgcVideo = (UgcVideo)localIterator.next();
      if (localUgcVideo.status == UgcVideo.STATUS_UPLOADING) {
        b(localUgcVideo);
      }
    }
  }
  
  @UiThread
  public void a(long paramLong, @NotNull RIJUgcVideoPublishManager.IGetAllUploadStatusVideosCallback paramIGetAllUploadStatusVideosCallback)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramIGetAllUploadStatusVideosCallback.a(a(paramLong, this.jdField_a_of_type_JavaUtilArrayList));
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList.add(new RIJUgcVideoPublishManager.7(this, paramLong, paramIGetAllUploadStatusVideosCallback));
    b();
  }
  
  @UiThread
  public void a(UgcVideo paramUgcVideo)
  {
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "removeVideoTask, ugcVideo.seqId =" + paramUgcVideo.seqId);
    if (paramUgcVideo.status == UgcVideo.STATUS_UPLOADING) {
      b(paramUgcVideo);
    }
    paramUgcVideo.title = "";
    this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramUgcVideo.seqId);
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramUgcVideo);
    e(paramUgcVideo);
    ThreadManagerV2.excute(new RIJUgcVideoPublishManager.6(this, paramUgcVideo), 64, null, false);
  }
  
  @UiThread
  public final void a(@NotNull UgcVideo paramUgcVideo, boolean paramBoolean)
  {
    QLog.d("RIJUGC.RIJUgcVideoPublishManager", 1, "addVideoTask: ugcVideo.seqId = " + paramUgcVideo.seqId);
    PublishTaskAutomator localPublishTaskAutomator = (PublishTaskAutomator)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramUgcVideo.seqId);
    if (localPublishTaskAutomator == null)
    {
      localPublishTaskAutomator = new PublishTaskAutomator(paramUgcVideo);
      localPublishTaskAutomator.a(new RIJUgcVideoPublishManager.2(this));
      localPublishTaskAutomator.a(new RIJUgcVideoPublishManager.3(this));
      Object localObject1 = new RIJUgcVideoPublishManager.4(this, paramUgcVideo);
      Object localObject2 = new SyncSteps(localPublishTaskAutomator, new BaseStep[] { new CompressVideoTaskStep(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPublishTaskAutomator, (IPublishTaskCallback)localObject1), new UploadVideoTaskStep(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPublishTaskAutomator, (IPublishTaskCallback)localObject1, new RIJUgcVideoUploader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) });
      localObject2 = new AsyncSteps(localPublishTaskAutomator, new BaseStep[] { new UploadCoverTaskStep(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPublishTaskAutomator, (IPublishTaskCallback)localObject1), localObject2 });
      localObject1 = new PublishTaskStep(localPublishTaskAutomator, (IPublishTaskCallback)localObject1);
      localPublishTaskAutomator.a(new RIJUgcVideoPublishManager.5(this, paramUgcVideo));
      localPublishTaskAutomator.a(new BaseStep[] { localObject2, localObject1 }, paramBoolean);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramUgcVideo.seqId, localPublishTaskAutomator);
    }
    for (;;)
    {
      if (paramBoolean) {
        paramUgcVideo.status = UgcVideo.STATUS_UPLOADING;
      }
      if ((paramUgcVideo.title != null) && (!paramUgcVideo.title.isEmpty()))
      {
        if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramUgcVideo)) {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramUgcVideo);
        }
        c(paramUgcVideo);
      }
      return;
      localPublishTaskAutomator.a();
    }
  }
  
  public void a(@NotNull RIJUgcVideoPublishManager.IReleaseCallback paramIReleaseCallback)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramIReleaseCallback);
  }
  
  @UiThread
  public void a(@NotNull RIJUgcVideoPublishManager.IVideoPublishCallback paramIVideoPublishCallback)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramIVideoPublishCallback);
  }
  
  public void b(UgcVideo paramUgcVideo)
  {
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "pauseVideoTask, ugcVideo.seqId =" + paramUgcVideo.seqId);
    paramUgcVideo.status = UgcVideo.STATUS_PAUSE;
    PublishTaskAutomator localPublishTaskAutomator = (PublishTaskAutomator)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramUgcVideo.seqId);
    if (paramUgcVideo.startUploadingTime > 0L) {
      RIJUgcUtils.a("pause", paramUgcVideo);
    }
    if (localPublishTaskAutomator != null) {
      localPublishTaskAutomator.b();
    }
  }
  
  @UiThread
  public void b(@NotNull RIJUgcVideoPublishManager.IVideoPublishCallback paramIVideoPublishCallback)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramIVideoPublishCallback);
  }
  
  public void c(UgcVideo paramUgcVideo)
  {
    if ((paramUgcVideo.title != null) && (!paramUgcVideo.title.isEmpty()) && (this.jdField_a_of_type_JavaUtilArrayList.contains(paramUgcVideo))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ThreadManagerV2.excute(new RIJUgcVideoPublishManager.9(this, paramUgcVideo), 32, null, false);
      }
      return;
    }
  }
  
  public void d(UgcVideo paramUgcVideo)
  {
    ThreadManagerV2.excute(new RIJUgcVideoPublishManager.10(this, paramUgcVideo), 32, null, false);
  }
  
  public void e(UgcVideo paramUgcVideo)
  {
    ThreadManagerV2.excute(new RIJUgcVideoPublishManager.11(this, paramUgcVideo), 32, null, false);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Boolean = false;
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterActivityLifecycleCallbacks(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager$RIJUgcVideoPublishManagerActivityLifecycleCallbacks);
    a();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((RIJUgcVideoPublishManager.IReleaseCallback)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager
 * JD-Core Version:    0.7.0.1
 */