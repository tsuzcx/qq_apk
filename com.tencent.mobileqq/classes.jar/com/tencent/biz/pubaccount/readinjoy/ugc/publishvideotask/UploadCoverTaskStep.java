package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.automator.BaseStep;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.upload.IImageUploadListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.upload.IImageUploader;
import com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcImageUploader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class UploadCoverTaskStep
  extends BaseStep
{
  @Nullable
  private IPublishTaskCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskIPublishTaskCallback;
  @NotNull
  private PublishTaskAutomator jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskPublishTaskAutomator;
  @NotNull
  private RIJUgcVideoPublishManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager;
  private IImageUploader jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcUploadIImageUploader;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public UploadCoverTaskStep(@NotNull QQAppInterface paramQQAppInterface, @NotNull PublishTaskAutomator paramPublishTaskAutomator, @Nullable IPublishTaskCallback paramIPublishTaskCallback)
  {
    super(paramPublishTaskAutomator, true, "UploadCoverTaskStep");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager = ((RIJUgcVideoPublishManager)paramQQAppInterface.getManager(QQManagerFactory.RIJ_UGC_VIDEO_PUBLISH_MANAGER));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskPublishTaskAutomator = paramPublishTaskAutomator;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskIPublishTaskCallback = paramIPublishTaskCallback;
  }
  
  public void a()
  {
    super.a();
    UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskPublishTaskAutomator.a();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcUploadIImageUploader != null) && (localUgcVideo.status == UgcVideo.STATUS_UPLOADING)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcUploadIImageUploader.b();
    }
  }
  
  public boolean a()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskPublishTaskAutomator.a();
    if (!TextUtils.isEmpty(localUgcVideo.coverUrl))
    {
      i = 1;
      if (i != 0) {
        localUgcVideo.coverProgress = 100;
      }
      if ((i != 0) || (localUgcVideo.status == UgcVideo.STATUS_PAUSE)) {
        break label64;
      }
    }
    label64:
    for (int i = 1;; i = 0)
    {
      if ((!super.a()) || (i == 0)) {
        break label69;
      }
      return true;
      i = 0;
      break;
    }
    label69:
    return false;
  }
  
  public boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskPublishTaskAutomator.a();
    if (((UgcVideo)localObject).coverPath != null) {}
    for (String str = ((UgcVideo)localObject).coverPath;; str = "")
    {
      if ((!this.jdField_a_of_type_Boolean) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, str)))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangString = str;
        QLog.i("RIJUGC.UploadCoverTaskStep", 1, "onStep begin upload cover:" + str);
        localObject = new UploadCoverTaskStep.1(this, (UgcVideo)localObject);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcUploadIImageUploader != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcUploadIImageUploader.b();
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcUploadIImageUploader = new RIJUgcImageUploader(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcUploadIImageUploader.a((IImageUploadListener)localObject);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcUploadIImageUploader.a();
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.UploadCoverTaskStep
 * JD-Core Version:    0.7.0.1
 */