package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.List;
import java.util.Vector;
import mcj;

public class VideoFeedsIPCClient
{
  private static VideoFeedsIPCClient jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new mcj(this, "Module_VideoFeedsIPCServer");
  private List jdField_a_of_type_JavaUtilList = new Vector();
  
  private VideoFeedsIPCClient()
  {
    QIPCClientHelper.getInstance().register(this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule);
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
  
  public Bundle a(String paramString, Bundle paramBundle)
  {
    if ("CMD_SHORTVIDEO_REQUEST_MANUAL_DOWNLOAD".equals(paramString)) {
      QIPCClientHelper.getInstance().callServer("Module_VideoFeedsIPCServer", "CMD_SHORTVIDEO_REQUEST_MANUAL_DOWNLOAD", paramBundle, null);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                return null;
                                if ("CMD_SHORTVIDEO_REQUEST_CLEAR".equals(paramString))
                                {
                                  QIPCClientHelper.getInstance().callServer("Module_VideoFeedsIPCServer", "CMD_SHORTVIDEO_REQUEST_CLEAR", paramBundle, null);
                                  return null;
                                }
                                if ("CMD_SHORTVIDEO_UPDATE_MSG_BY_UNISEQ".equals(paramString))
                                {
                                  QIPCClientHelper.getInstance().callServer("Module_VideoFeedsIPCServer", "CMD_SHORTVIDEO_UPDATE_MSG_BY_UNISEQ", paramBundle, null);
                                  return null;
                                }
                                if ("CMD_HANDLE_FORWARD_DATA".equals(paramString))
                                {
                                  QIPCClientHelper.getInstance().callServer("Module_VideoFeedsIPCServer", "CMD_HANDLE_FORWARD_DATA", paramBundle, null);
                                  return null;
                                }
                                if ("CMD_INIT_READINJOY_MANAGER".equals(paramString))
                                {
                                  QIPCClientHelper.getInstance().callServer("Module_VideoFeedsIPCServer", "CMD_INIT_READINJOY_MANAGER", paramBundle, null);
                                  return null;
                                }
                                if (!"CMD_PUB_ACCOUNT_CHECK_IS_FOLLOWED".equals(paramString)) {
                                  break;
                                }
                                paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", "CMD_PUB_ACCOUNT_CHECK_IS_FOLLOWED", paramBundle);
                              } while ((paramString == null) || (!paramString.isSuccess()));
                              return paramString.data;
                              if ("CMD_FOLLOW_PUB_ACCOUNT".equals(paramString))
                              {
                                QIPCClientHelper.getInstance().callServer("Module_VideoFeedsIPCServer", "CMD_FOLLOW_PUB_ACCOUNT", paramBundle, null);
                                return null;
                              }
                              if (!"CMD_VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS_GET".equals(paramString)) {
                                break;
                              }
                              paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", "CMD_VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS_GET", paramBundle);
                            } while ((paramString == null) || (!paramString.isSuccess()));
                            return paramString.data;
                            if ("CMD_VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS_SET".equals(paramString))
                            {
                              QIPCClientHelper.getInstance().callServer("Module_VideoFeedsIPCServer", "CMD_VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS_SET", paramBundle, null);
                              return null;
                            }
                            if (!"CMD_IS_VIDEO_PLAY_NEED_ALERT_IN_XG".equals(paramString)) {
                              break;
                            }
                            paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", "CMD_IS_VIDEO_PLAY_NEED_ALERT_IN_XG", paramBundle);
                          } while ((paramString == null) || (!paramString.isSuccess()));
                          return paramString.data;
                          if ("CMD_COMFIRM_VIDEO_PLAY_NEED_ALERT_IN_XG".equals(paramString))
                          {
                            QIPCClientHelper.getInstance().callServer("Module_VideoFeedsIPCServer", "CMD_COMFIRM_VIDEO_PLAY_NEED_ALERT_IN_XG", paramBundle, null);
                            return null;
                          }
                          if ("CMD_NETWORK_CHANGE".equals(paramString))
                          {
                            QIPCClientHelper.getInstance().callServer("Module_VideoFeedsIPCServer", "CMD_NETWORK_CHANGE", paramBundle, null);
                            return null;
                          }
                          if (!"CMD_IS_VIDEO_CHATTING".equals(paramString)) {
                            break;
                          }
                          paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", "CMD_IS_VIDEO_CHATTING", null);
                        } while ((paramString == null) || (!paramString.isSuccess()));
                        return paramString.data;
                        if ("CMD_IGNORE_VOLUME_CHANGE".equals(paramString))
                        {
                          QIPCClientHelper.getInstance().callServer("Module_VideoFeedsIPCServer", "CMD_IGNORE_VOLUME_CHANGE", paramBundle, null);
                          return null;
                        }
                        if ("CMD_CANCEL_IGNORE_VOLUME_CHANGE".equals(paramString))
                        {
                          QIPCClientHelper.getInstance().callServer("Module_VideoFeedsIPCServer", "CMD_CANCEL_IGNORE_VOLUME_CHANGE", paramBundle, null);
                          return null;
                        }
                        if (!"CMD_GET_CURRENT_NICK_NAME".equals(paramString)) {
                          break;
                        }
                        paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", "CMD_GET_CURRENT_NICK_NAME", paramBundle);
                      } while ((paramString == null) || (!paramString.isSuccess()));
                      return paramString.data;
                      if (!"CMD_CAMERA_CAPTURE_CHECK_SO_READY".equals(paramString)) {
                        break;
                      }
                      paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", "CMD_CAMERA_CAPTURE_CHECK_SO_READY", paramBundle);
                    } while ((paramString == null) || (!paramString.isSuccess()));
                    return paramString.data;
                    if ("CMD_CAMERA_CAPTURE_SO_DOWNLOAD".equals(paramString))
                    {
                      QIPCClientHelper.getInstance().callServer("Module_VideoFeedsIPCServer", "CMD_CAMERA_CAPTURE_SO_DOWNLOAD", paramBundle, null);
                      return null;
                    }
                    if (!"CMD_GET_NICK_NAME_BY_UIN".equals(paramString)) {
                      break;
                    }
                    paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", "CMD_GET_NICK_NAME_BY_UIN", paramBundle);
                  } while ((paramString == null) || (!paramString.isSuccess()));
                  return paramString.data;
                  if ("CMD_GET_NICK_NAME_BY_UIN_CANCLE".equals(paramString))
                  {
                    QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", "CMD_GET_NICK_NAME_BY_UIN_CANCLE", paramBundle);
                    return null;
                  }
                  if ("CMD_REPORT_START_TIME".equals(paramString))
                  {
                    QIPCClientHelper.getInstance().callServer("Module_VideoFeedsIPCServer", "CMD_REPORT_START_TIME", paramBundle, null);
                    return null;
                  }
                  if (!"CMD_GET_CLICK_COMMENT_ACTICLEINFO".equals(paramString)) {
                    break;
                  }
                  paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", "CMD_GET_CLICK_COMMENT_ACTICLEINFO", paramBundle);
                } while ((paramString == null) || (!paramString.isSuccess()));
                return paramString.data;
                if (!"CMD_GET_UNREAD_MESSAGE_BOX_DATA".equals(paramString)) {
                  break;
                }
                paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", "CMD_GET_UNREAD_MESSAGE_BOX_DATA", paramBundle);
              } while ((paramString == null) || (!paramString.isSuccess()));
              return paramString.data;
              if (!"CMD_GET_VIDEO_LATEST_BRIGHTNESS".equals(paramString)) {
                break;
              }
              paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", "CMD_GET_VIDEO_LATEST_BRIGHTNESS", paramBundle);
            } while ((paramString == null) || (!paramString.isSuccess()));
            return paramString.data;
            if ("CMD_SET_VIDEO_LATEST_BRIGHTNESS".equals(paramString))
            {
              QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", "CMD_SET_VIDEO_LATEST_BRIGHTNESS", paramBundle);
              return null;
            }
            if (!"CMD_GET_WEB_RENDER_DATA".equals(paramString)) {
              break;
            }
            paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", "CMD_GET_WEB_RENDER_DATA", paramBundle);
          } while ((paramString == null) || (!paramString.isSuccess()));
          return paramString.data;
          if (!"CMD_GET_REPORT_KANDIAN_MODE".equals(paramString)) {
            break;
          }
          paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", "CMD_GET_REPORT_KANDIAN_MODE", paramBundle);
        } while ((paramString == null) || (!paramString.isSuccess()));
        return paramString.data;
      } while (!"CMD_GET_REPORT_KANDIAN_MODE_NEW".equals(paramString));
      paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", "CMD_GET_REPORT_KANDIAN_MODE_NEW", paramBundle);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCClient
 * JD-Core Version:    0.7.0.1
 */