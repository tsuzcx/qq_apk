package com.tencent.biz.pubaccount.readinjoy.handlers;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.PreDownloadController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.VideoPreDownloadParam;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.VideoPreloadStrategyConoller;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class VideoHandler$3
  implements VideoPreDownloadMgr.PreDownloadController
{
  VideoHandler$3(VideoHandler paramVideoHandler) {}
  
  private void a(List<VideoPreDownloadMgr.VideoPreDownloadParam> paramList, int paramInt, boolean paramBoolean)
  {
    if ((paramList == null) || (paramInt < 0) || (paramInt >= this.a.d())) {
      return;
    }
    int i;
    label45:
    int m;
    int j;
    label65:
    int k;
    if ((this.a.b() == 0) || (this.a.b() == 40677))
    {
      i = 0;
      m = VideoPreloadStrategyConoller.a().a("video_channel", paramInt);
      j = i + paramInt;
      i = 0;
      k = i;
      if (j >= this.a.d()) {
        break label298;
      }
      k = i;
      if (j >= paramInt + 10) {
        break label298;
      }
      k = this.a.a(j).intValue();
      if (a(k)) {
        break label132;
      }
    }
    label132:
    label298:
    label492:
    for (;;)
    {
      j += 1;
      break label65;
      i = 1;
      break label45;
      Object localObject = VideoHandler.a(this.a, j);
      if (localObject != null)
      {
        if ((k == 46) || (k == 70))
        {
          paramList.add(new VideoPreDownloadMgr.VideoPreDownloadParam(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
          paramList.add(new VideoPreDownloadMgr.VideoPreDownloadParam(((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).mVideoVid, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).innerUniqueID, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).busiType, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).getVideoDuration()));
          i += 2;
        }
        for (;;)
        {
          if (i < m) {
            break label492;
          }
          k = i;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("VideoHandler", 2, "scroll to next = " + paramBoolean + " preDownload to forward = " + k);
          return;
          paramList.add(new VideoPreDownloadMgr.VideoPreDownloadParam(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
          k = i + 1;
          i = k;
          if (((BaseArticleInfo)localObject).busiType == 5)
          {
            i = k;
            if ((localObject instanceof AdvertisementInfo))
            {
              i = k;
              if (((AdvertisementInfo)localObject).mImaxShowAdType == 1001)
              {
                String str = ((AdvertisementInfo)localObject).mImaxVideoUrl;
                i = k;
                if (!TextUtils.isEmpty(str))
                {
                  localObject = new VideoPreDownloadMgr.VideoPreDownloadParam(str, "", ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration());
                  ((VideoPreDownloadMgr.VideoPreDownloadParam)localObject).a = true;
                  paramList.add(localObject);
                  i = k + 1;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 6) || (paramInt == 66) || (paramInt == 115) || (paramInt == 46) || (paramInt == 70);
  }
  
  private void b(List<VideoPreDownloadMgr.VideoPreDownloadParam> paramList, int paramInt, boolean paramBoolean)
  {
    if ((paramList == null) || (paramInt < 0)) {
      return;
    }
    int m = VideoPreloadStrategyConoller.a().a();
    int k = paramInt - 1;
    int i = 0;
    int j = i;
    label86:
    BaseArticleInfo localBaseArticleInfo;
    if (k > 0)
    {
      j = i;
      if (k > paramInt - 10)
      {
        j = i;
        if (k < this.a.d())
        {
          j = this.a.a(k).intValue();
          if (!a(j)) {}
          do
          {
            k -= 1;
            break;
            localBaseArticleInfo = VideoHandler.a(this.a, k);
          } while (localBaseArticleInfo == null);
          if ((j != 46) && (j != 70)) {
            break label303;
          }
          paramList.add(new VideoPreDownloadMgr.VideoPreDownloadParam(localBaseArticleInfo.mVideoVid, localBaseArticleInfo.innerUniqueID, localBaseArticleInfo.busiType, localBaseArticleInfo.getVideoDuration()));
          paramList.add(new VideoPreDownloadMgr.VideoPreDownloadParam(((ArticleInfo)localBaseArticleInfo.mSubArtilceList.get(0)).mVideoVid, ((ArticleInfo)localBaseArticleInfo.mSubArtilceList.get(0)).innerUniqueID, ((ArticleInfo)localBaseArticleInfo.mSubArtilceList.get(0)).busiType, ((ArticleInfo)localBaseArticleInfo.mSubArtilceList.get(0)).getVideoDuration()));
        }
      }
    }
    for (j = i + 2;; j = i + 1)
    {
      i = j;
      if (j < m) {
        break label86;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VideoHandler", 2, "scroll to next = " + paramBoolean + " preDownload to backward = " + j);
      return;
      label303:
      paramList.add(new VideoPreDownloadMgr.VideoPreDownloadParam(localBaseArticleInfo.mVideoVid, localBaseArticleInfo.innerUniqueID, localBaseArticleInfo.busiType, localBaseArticleInfo.getVideoDuration()));
    }
  }
  
  public List<VideoPreDownloadMgr.VideoPreDownloadParam> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    a(localArrayList, paramInt, paramBoolean);
    b(localArrayList, paramInt, paramBoolean);
    return localArrayList;
  }
  
  public boolean a()
  {
    Object localObject = VideoHandler.a(this.a);
    if (localObject != null) {}
    for (localObject = ((VideoPlayManager.VideoPlayParam)localObject).a();; localObject = "") {
      return VideoPreloadStrategyConoller.a().a(this.a.a.a((String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.3
 * JD-Core Version:    0.7.0.1
 */