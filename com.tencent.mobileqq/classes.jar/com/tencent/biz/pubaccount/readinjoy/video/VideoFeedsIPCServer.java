package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureSoManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.qipc.QIPCModule;
import mbg;

public class VideoFeedsIPCServer
{
  private static VideoFeedsIPCServer jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCServer;
  private View jdField_a_of_type_AndroidViewView;
  private ReadInJoyCameraCaptureSoManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraCaptureSoManager;
  private FileTransferManager.Callback jdField_a_of_type_ComTencentMobileqqActivityAioFileTransferManager$Callback;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new mbg(this, "Module_VideoFeedsIPCServer");
  
  public static VideoFeedsIPCServer a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCServer == null) {}
    try
    {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCServer = new VideoFeedsIPCServer();
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCServer;
    }
    finally {}
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCServer
 * JD-Core Version:    0.7.0.1
 */