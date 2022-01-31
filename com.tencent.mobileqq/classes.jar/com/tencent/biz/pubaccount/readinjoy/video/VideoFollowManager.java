package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qcn;
import qkw;

public class VideoFollowManager
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private qkw jdField_a_of_type_Qkw;
  
  public VideoFollowManager(Activity paramActivity, QQAppInterface paramQQAppInterface, qkw paramqkw, VideoFeedsPlayManager paramVideoFeedsPlayManager, List<VideoInfo> paramList, int paramInt)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Qkw = paramqkw;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFollowHelper", 2, "followPubAccount() uin=" + paramString);
    }
    if ((paramString == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      return;
      qcn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramBoolean);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      paramBoolean = false;
      while (localIterator.hasNext())
      {
        Object localObject = (VideoInfo)localIterator.next();
        boolean bool = paramBoolean | a((VideoInfo)localObject, paramString);
        paramBoolean = bool;
        if (((VideoInfo)localObject).d != null)
        {
          localObject = ((VideoInfo)localObject).d.iterator();
          for (;;)
          {
            paramBoolean = bool;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            bool = a((VideoInfo)((Iterator)localObject).next(), paramString) | bool;
          }
        }
      }
      if (paramBoolean) {
        this.jdField_a_of_type_Qkw.a(paramString);
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoFollowHelper", 2, "followPubAccount() isDataChanged=" + paramBoolean);
  }
  
  private boolean a(VideoInfo paramVideoInfo, String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramVideoInfo.j != null)
    {
      bool1 = bool3;
      if (paramVideoInfo.j.equals(paramString))
      {
        bool1 = bool2;
        if (!paramVideoInfo.jdField_k_of_type_Boolean) {
          bool1 = true;
        }
        paramVideoInfo.jdField_k_of_type_Boolean = true;
      }
    }
    return bool1;
  }
  
  private void c(VideoInfo paramVideoInfo)
  {
    int i = paramVideoInfo.a.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("VideoFollowHelper", 2, "innerSubscribeColume() columeid=" + i);
    }
    qcn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i);
    paramVideoInfo = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramVideoInfo.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)paramVideoInfo.next();
      if ((localVideoInfo.e()) && (localVideoInfo.a.jdField_a_of_type_Int == i))
      {
        localVideoInfo.a.jdField_a_of_type_Boolean = true;
        VideoColumnInfo localVideoColumnInfo = localVideoInfo.a;
        localVideoColumnInfo.jdField_c_of_type_Int += 1;
        this.jdField_a_of_type_Qkw.b(localVideoInfo);
      }
    }
    this.jdField_a_of_type_Qkw.b(i);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.e()) {
      if (!paramVideoInfo.a.jdField_a_of_type_Boolean) {}
    }
    while (paramVideoInfo.jdField_k_of_type_Boolean)
    {
      return;
      c(paramVideoInfo);
      qcn.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo.a.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFollowHelper", 2, "followPubAccount onClick() puin=" + paramVideoInfo.j + ", isFollowed=" + paramVideoInfo.jdField_k_of_type_Boolean + ", pname=" + paramVideoInfo.jdField_k_of_type_JavaLangString);
    }
    a(paramVideoInfo.j, paramVideoInfo.b);
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    if ((TextUtils.isEmpty(paramVideoInfo.j)) || (paramVideoInfo.b)) {
      return;
    }
    ThreadManager.post(new VideoFollowManager.CheckAccountFollowedRunnable(this, paramVideoInfo), 1, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFollowManager
 * JD-Core Version:    0.7.0.1
 */