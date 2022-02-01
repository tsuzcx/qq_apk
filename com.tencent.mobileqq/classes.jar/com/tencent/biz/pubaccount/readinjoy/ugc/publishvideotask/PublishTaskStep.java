package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.automator.BaseStep;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.PublishVideoHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PublishTaskStep
  extends BaseStep
{
  @Nullable
  private IPublishTaskCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskIPublishTaskCallback;
  @NotNull
  private PublishTaskAutomator jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskPublishTaskAutomator;
  
  public PublishTaskStep(@NotNull PublishTaskAutomator paramPublishTaskAutomator, @Nullable IPublishTaskCallback paramIPublishTaskCallback)
  {
    super(paramPublishTaskAutomator, true, "PublishTaskStep");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskPublishTaskAutomator = paramPublishTaskAutomator;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskIPublishTaskCallback = paramIPublishTaskCallback;
  }
  
  private void a(UgcVideo paramUgcVideo)
  {
    IPublishTaskCallback localIPublishTaskCallback;
    if ((paramUgcVideo.rowkey != null) && (!paramUgcVideo.rowkey.isEmpty()))
    {
      paramUgcVideo.status = UgcVideo.STATUS_FINISH;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskIPublishTaskCallback != null)
      {
        localIPublishTaskCallback = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskIPublishTaskCallback;
        if (paramUgcVideo.status != UgcVideo.STATUS_FINISH) {
          break label74;
        }
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      localIPublishTaskCallback.a(4, bool, true, "");
      d();
      return;
      paramUgcVideo.status = UgcVideo.STATUS_FAILED;
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskPublishTaskAutomator.a().status == UgcVideo.STATUS_UPLOADING;
  }
  
  public boolean b()
  {
    boolean bool = true;
    UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskPublishTaskAutomator.a();
    Object localObject = localUgcVideo.title;
    String str = localUgcVideo.url;
    QLog.i("RIJUGC.PublishTaskStep", 1, "onStep: title=" + (String)localObject);
    if ((localObject != null) && (!((String)localObject).isEmpty()))
    {
      localObject = new ArrayList();
      ((List)localObject).add(localUgcVideo);
      if (localUgcVideo.columnId == 0L) {
        break label98;
      }
    }
    for (;;)
    {
      PublishVideoHelper.a(bool, (List)localObject, new PublishTaskStep.1(this, localUgcVideo));
      return false;
      label98:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.PublishTaskStep
 * JD-Core Version:    0.7.0.1
 */