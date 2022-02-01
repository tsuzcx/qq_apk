package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class VideoFeedsIPCClient
{
  private static VideoFeedsIPCClient jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new VideoFeedsIPCClient.1(this, "Module_VideoFeedsIPCServer");
  private List<VideoFeedsIPCClient.Observer> jdField_a_of_type_JavaUtilList = new Vector();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  private VideoFeedsIPCClient()
  {
    QIPCClientHelper.getInstance().register(this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule);
    a();
  }
  
  public static VideoFeedsIPCClient a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient == null) {}
    try
    {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient = new VideoFeedsIPCClient();
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilSet.add("CMD_SHORTVIDEO_REQUEST_MANUAL_DOWNLOAD");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_SHORTVIDEO_REQUEST_CLEAR");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_SHORTVIDEO_UPDATE_MSG_BY_UNISEQ");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_HANDLE_FORWARD_DATA");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_INIT_READINJOY_MANAGER");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_FOLLOW_PUB_ACCOUNT");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS_SET");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_COMFIRM_VIDEO_PLAY_NEED_ALERT_IN_XG");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_NETWORK_CHANGE");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_IGNORE_VOLUME_CHANGE");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_CANCEL_IGNORE_VOLUME_CHANGE");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_CAMERA_CAPTURE_SO_DOWNLOAD");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_GET_NICK_NAME_BY_UIN_CANCLE");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_REPORT_START_TIME");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_SET_VIDEO_LATEST_BRIGHTNESS");
  }
  
  public Bundle a(String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramString)) {
      QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", paramString, paramBundle, null);
    }
    do
    {
      return null;
      paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", paramString, paramBundle);
    } while ((paramString == null) || (!paramString.isSuccess()));
    return paramString.data;
  }
  
  public void a(VideoFeedsIPCClient.Observer paramObserver)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramObserver);
      return;
    }
  }
  
  public void b(VideoFeedsIPCClient.Observer paramObserver)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramObserver);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCClient
 * JD-Core Version:    0.7.0.1
 */