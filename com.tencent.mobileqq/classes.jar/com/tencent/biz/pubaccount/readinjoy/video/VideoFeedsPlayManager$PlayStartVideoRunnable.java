package com.tencent.biz.pubaccount.readinjoy.video;

import acvz;
import android.text.TextUtils;
import android.view.View;
import axdq;
import axei;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import onu;
import qqi;
import qqj;
import qqk;
import qql;
import qty;

public class VideoFeedsPlayManager$PlayStartVideoRunnable
  implements Runnable
{
  private qql jdField_a_of_type_Qql;
  private qty jdField_a_of_type_Qty;
  private boolean jdField_a_of_type_Boolean;
  
  public VideoFeedsPlayManager$PlayStartVideoRunnable(VideoFeedsPlayManager paramVideoFeedsPlayManager, qql paramqql, qty paramqty, boolean paramBoolean)
  {
    this.jdField_a_of_type_Qql = paramqql;
    this.jdField_a_of_type_Qty = paramqty;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo post thread");
    }
    if ((!this.jdField_a_of_type_Boolean) && (!VideoFeedsPlayManager.a(this.this$0, this.jdField_a_of_type_Qty))) {}
    label35:
    long l;
    label427:
    label563:
    do
    {
      do
      {
        do
        {
          Object localObject2;
          do
          {
            do
            {
              do
              {
                break label35;
                break label35;
                break label35;
                break label35;
                do
                {
                  return;
                } while ((this.jdField_a_of_type_Qql == null) || (this.jdField_a_of_type_Qty == null) || (VideoFeedsPlayManager.e(this.this$0)));
                if (!this.jdField_a_of_type_Boolean) {
                  VideoFeedsPlayManager.a(this.this$0, true);
                }
                l = this.jdField_a_of_type_Qql.jdField_a_of_type_Long;
                if (l > 0L) {
                  VideoFeedsPlayManager.f(this.this$0, true);
                }
                if (this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0) {
                  break label563;
                }
                localObject1 = this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
                if (localObject1 != null) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.e("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "PlayStartVideoRunnable Error : busiType = 0, msg = null, vid=" + this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
                }
              } while (VideoFeedsPlayManager.a(this.this$0) == null);
              VideoFeedsPlayManager.a(this.this$0).a(this.jdField_a_of_type_Qty, 123, 108, 0, "busiType = 0, msg = null, vid=" + this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, null);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "Message For Short Video: " + ((MessageForShortVideo)localObject1).toLogString());
              }
              boolean bool = true;
              localObject2 = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
              File localFile = new File((String)localObject2);
              if (localFile.exists()) {
                if (localFile.length() >= ((MessageForShortVideo)localObject1).videoFileSize) {
                  break label427;
                }
              }
              for (bool = true;; bool = false)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "ShortVideo file.exists()=" + localFile.exists() + ", msg.videoFileStatus=" + ((MessageForShortVideo)localObject1).videoFileStatus + ", transferredSize=" + localFile.length() + ", msg.videoFileSize=" + ((MessageForShortVideo)localObject1).videoFileSize + ", needDownload=" + bool);
                }
                if (bool) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "play short video from local");
                }
                this.jdField_a_of_type_Qty.a(null, (String)localObject2, 4, l, 0L, 0);
                return;
              }
            } while (VideoFeedsPlayManager.a(this.this$0) == null);
            localObject2 = acvz.a(VideoFeedsPlayManager.a(this.this$0));
            if (localObject2 != null)
            {
              if (VideoFeedsPlayManager.a(this.this$0) == null) {
                VideoFeedsPlayManager.a(this.this$0, new View(BaseApplicationImpl.getContext()));
              }
              VideoFeedsPlayManager.a(this.this$0, new qqj(this, (MessageForShortVideo)localObject1));
              ((acvz)localObject2).a(VideoFeedsPlayManager.a(this.this$0), VideoFeedsPlayManager.a(this.this$0));
            }
            ((MessageForShortVideo)localObject1).busiType = 0;
            localObject1 = axdq.a(VideoFeedsPlayManager.a(this.this$0), (MessageForShortVideo)localObject1, 1);
          } while (localObject1 == null);
          axdq.a((axei)localObject1, VideoFeedsPlayManager.a(this.this$0));
          return;
          if ((this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 7))
          {
            if (VideoFeedsPlayManager.a(this.this$0) != null)
            {
              localObject1 = VideoFeedsPlayManager.a(this.this$0);
              localObject2 = ((VideoPreDownloadMgr)localObject1).a;
              this.jdField_a_of_type_Qty.b = ((VideoPreDownloadMgr)localObject1).a(null, this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
              ((VideoPreDownloadMgr)localObject1).a(this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Qty.b);
            }
            this.jdField_a_of_type_Qty.a(this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 2, l, this.jdField_a_of_type_Qql.jdField_a_of_type_Boolean);
            return;
          }
          if ((this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 2) && ((this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString)))) {
            break;
          }
        } while (this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString == null);
        localObject1 = onu.a();
        ((onu)localObject1).a(this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, "PubAccountArticleCenter.GetUrlByVid", new qqk(this, l, (onu)localObject1));
        return;
        if (this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 5) {
          break;
        }
      } while (this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString == null);
      Object localObject1 = VideoFeedsPlayManager.a(this.this$0);
      if (localObject1 != null)
      {
        this.jdField_a_of_type_Qty.b = ((VideoPreDownloadMgr)localObject1).a(this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "广告视频预下载: url:" + this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString + " ;isPreDownloadHit: " + this.jdField_a_of_type_Qty.b);
        }
        ((VideoPreDownloadMgr)localObject1).a(this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Qty.b);
      }
      this.jdField_a_of_type_Qty.a("", this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 2, l, 0L, this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, true, false, this.jdField_a_of_type_Qql.jdField_a_of_type_Boolean);
      return;
    } while ((this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.G)));
    this.jdField_a_of_type_Qty.a("", this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.G, 2, l, 0L, this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, true, true, this.jdField_a_of_type_Qql.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */