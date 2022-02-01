package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.automator.BaseStep;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.video.videoconverter.VideoCompressTask;
import com.tencent.biz.pubaccount.util.MD5Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CompressVideoTaskStep
  extends BaseStep
{
  @Nullable
  private IPublishTaskCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskIPublishTaskCallback;
  @NotNull
  private PublishTaskAutomator jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskPublishTaskAutomator;
  @NotNull
  private RIJUgcVideoPublishManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager;
  @Nullable
  private VideoCompressTask jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoCompressTask;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private volatile boolean b = false;
  
  public CompressVideoTaskStep(@NotNull QQAppInterface paramQQAppInterface, @NotNull PublishTaskAutomator paramPublishTaskAutomator, @Nullable IPublishTaskCallback paramIPublishTaskCallback)
  {
    super(paramPublishTaskAutomator, true, "UploadCoverTaskStep");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager = ((RIJUgcVideoPublishManager)paramQQAppInterface.getManager(QQManagerFactory.RIJ_UGC_VIDEO_PUBLISH_MANAGER));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskPublishTaskAutomator = paramPublishTaskAutomator;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskIPublishTaskCallback = paramIPublishTaskCallback;
  }
  
  public void a()
  {
    super.a();
    this.b = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoCompressTask != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoCompressTask.a();
    }
    UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskPublishTaskAutomator.a();
    localUgcVideo.status = UgcVideo.STATUS_PAUSE;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager.d(localUgcVideo);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskIPublishTaskCallback != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskIPublishTaskCallback.a(1, true, false, null);
    }
  }
  
  public boolean a()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskPublishTaskAutomator.a();
    int j;
    label72:
    String str;
    label113:
    long l;
    if ((localUgcVideo.compressPath != null) && (!localUgcVideo.compressPath.isEmpty()) && (new File(localUgcVideo.compressPath).exists()))
    {
      i = 1;
      if (i != 0) {
        localUgcVideo.compressProgress = 100;
      }
      if (localUgcVideo.retryTime < UgcVideo.RETRY_TIME_LIMIT) {
        break label196;
      }
      j = 1;
      if (j != 0)
      {
        str = localUgcVideo.filePath;
        File localFile = new File(str);
        localUgcVideo.compressPath = str;
        str = MD5Utils.a(localFile);
        if (str == null) {
          break label201;
        }
        localUgcVideo.fileMd5 = str;
        if (!localFile.exists()) {
          break label208;
        }
        l = localFile.length();
        label134:
        localUgcVideo.fileSize = l;
      }
      if ((i != 0) || (localUgcVideo.status == UgcVideo.STATUS_PAUSE) || (j != 0)) {
        break label213;
      }
    }
    label196:
    label201:
    label208:
    label213:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.b = false;
        localUgcVideo.startCompressTime = System.currentTimeMillis();
      }
      if ((!super.a()) || (i == 0)) {
        break label218;
      }
      return true;
      i = 0;
      break;
      j = 0;
      break label72;
      str = "";
      break label113;
      l = 0L;
      break label134;
    }
    label218:
    return false;
  }
  
  public boolean b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskPublishTaskAutomator.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoCompressTask = new VideoCompressTask(BaseApplicationImpl.getContext(), new CompressVideoTaskStep.1(this, localUgcVideo));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoCompressTask.execute(new String[] { localUgcVideo.filePath });
      localUgcVideo.uploadVideoStatus = UgcVideo.SUBSTATUS_COMPRESS_VIDEO;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.CompressVideoTaskStep
 * JD-Core Version:    0.7.0.1
 */