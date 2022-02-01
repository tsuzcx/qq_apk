package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class VideoUIManager$2
  implements VideoFullPlayController.RecommendDataAdapter
{
  VideoUIManager$2(VideoUIManager paramVideoUIManager) {}
  
  public List<BaseVideoPlayParam> a(List<VideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (VideoInfo)paramList.next();
        if (localObject != null)
        {
          localObject = FeedsChannelDataHelper.a((VideoInfo)localObject);
          if (localObject != null) {
            localArrayList.add(ReadInJoyBaseAdapter.a((BaseArticleInfo)localObject, true));
          }
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.2
 * JD-Core Version:    0.7.0.1
 */