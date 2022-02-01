package com.tencent.biz.pubaccount.Advertisement.fragment;

import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

class VideoCoverFragment$3
  implements TVK_IMediaPlayer.OnCompletionListener
{
  VideoCoverFragment$3(VideoCoverFragment paramVideoCoverFragment) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    VideoCoverFragment.a(this.a);
    int i = this.a.a();
    if ((i > 1) && (VideoCoverFragment.a(this.a) != null)) {
      if (VideoCoverFragment.a(this.a) == i - 1) {
        ThreadManager.getUIHandler().post(new VideoCoverFragment.3.1(this));
      } else {
        ThreadManager.getUIHandler().post(new VideoCoverFragment.3.2(this));
      }
    }
    paramTVK_IMediaPlayer = ((VideoCoverItem)VideoCoverFragment.a(this.a).jdField_a_of_type_JavaUtilArrayList.get(VideoCoverFragment.a(this.a))).b;
    ReportController.a(null, "dc00898", "", VideoCoverFragment.a(this.a).jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.a, "0X8008F65", "0X8008F65", 0, 0, VideoCoverFragment.a(this.a).jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.c, "", paramTVK_IMediaPlayer, VideoCoverFragment.a(this.a).jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.b);
    Integer localInteger = (Integer)PublicAccountAdvertisementActivity.a.get(paramTVK_IMediaPlayer);
    i = (int)(((VideoCoverView)((VideoCoverItem)VideoCoverFragment.a(this.a).jdField_a_of_type_JavaUtilArrayList.get(VideoCoverFragment.a(this.a))).a).a / 1000L);
    if (localInteger != null)
    {
      PublicAccountAdvertisementActivity.a.put(paramTVK_IMediaPlayer, Integer.valueOf(localInteger.intValue() + i));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverFragment", 2, "current time = null");
    }
    PublicAccountAdvertisementActivity.a.put(paramTVK_IMediaPlayer, Integer.valueOf(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.3
 * JD-Core Version:    0.7.0.1
 */