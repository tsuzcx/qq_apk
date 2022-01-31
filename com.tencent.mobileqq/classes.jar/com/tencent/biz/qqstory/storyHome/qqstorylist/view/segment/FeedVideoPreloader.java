package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.preload.DownloadTask;
import com.tencent.biz.qqstory.base.preload.IVideoPreloader;
import com.tencent.biz.qqstory.base.preload.VideoPreloader;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ofg;
import ofh;

public class FeedVideoPreloader
{
  public IVideoPreloader a;
  public StoryVideoItem a;
  public FeedVideoPreloader.CurrentVid a;
  public FeedVideoPreloader.OnVideoDownloadListener a;
  private Object a;
  public List a;
  public ofh a;
  protected List b = new ArrayList();
  
  public FeedVideoPreloader()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader = new VideoPreloader();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Ofh = new ofh(this);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(1);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(this.jdField_a_of_type_Ofh);
  }
  
  private void a(StoryVideoItem paramStoryVideoItem, List paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      DownloadTask localDownloadTask1 = DownloadTask.a(paramStoryVideoItem.mVid, 1);
      DownloadTask localDownloadTask2 = DownloadTask.a(paramStoryVideoItem.mVid, 0);
      paramStoryVideoItem = DownloadTask.a(paramStoryVideoItem.mVid, 2);
      localDownloadTask1.g = 0;
      localDownloadTask2.g = 0;
      paramStoryVideoItem.g = 1;
      localDownloadTask2.a.put("handleCallback", Boolean.valueOf(true));
      paramList.add(localDownloadTask1);
      paramList.add(localDownloadTask2);
      paramList.add(paramStoryVideoItem);
      return;
    }
    paramList.add(DownloadTask.a(paramStoryVideoItem.mVid, 2));
    paramList.add(DownloadTask.a(paramStoryVideoItem.mVid, 1));
    paramStoryVideoItem = DownloadTask.a(paramStoryVideoItem.mVid, 0);
    paramStoryVideoItem.a.put("handleCallback", Boolean.valueOf(true));
    paramList.add(paramStoryVideoItem);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$OnVideoDownloadListener = null;
  }
  
  public void a(StoryVideoItem paramStoryVideoItem, List paramList)
  {
    if (paramStoryVideoItem == null) {
      return;
    }
    paramList = new ArrayList(paramList);
    Bosses.get().postJob(new ofg(this, paramStoryVideoItem, paramList));
  }
  
  public void a(FeedVideoPreloader.OnVideoDownloadListener paramOnVideoDownloadListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$OnVideoDownloadListener = paramOnVideoDownloadListener;
  }
  
  public boolean a(String paramString)
  {
    return StoryVideoItem.isPlayable(paramString, false);
  }
  
  protected boolean a(List paramList1, List paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    int j = paramList1.size();
    int i = 0;
    while (i < j)
    {
      if (!((DownloadTask)paramList1.get(i)).equals(paramList2.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new ArrayList();
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        ((List)localObject1).addAll(this.jdField_a_of_type_JavaUtilList);
        if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
          break label327;
        }
        i = 0;
        if (i >= ((List)localObject1).size()) {
          break label322;
        }
        List localList2 = ((StoryHomeFeed)((List)localObject1).get(i)).d();
        if ((localList2.size() > 0) && (TextUtils.equals(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, ((StoryVideoItem)localList2.get(0)).mVid)))
        {
          j = 1;
          a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, localArrayList, true);
          if (j != 0) {
            break label319;
          }
          i = 0;
          j = i + 1;
          if (j < ((List)localObject1).size())
          {
            ??? = ((StoryHomeFeed)((List)localObject1).get(j)).d();
            if (((List)???).size() > 0) {
              a((StoryVideoItem)((List)???).get(0), localArrayList, false);
            }
          }
          i -= 1;
          if ((i >= 0) && (i < ((List)localObject1).size()))
          {
            localObject1 = ((StoryHomeFeed)((List)localObject1).get(i)).d();
            if (((List)localObject1).size() > 0) {
              a((StoryVideoItem)((List)localObject1).get(0), localArrayList, false);
            }
          }
          if (a(localArrayList, this.b)) {
            SLog.b("Q.qqstory.download.preload.FeedVideoPreloader", "download list equal , no need to set again");
          }
        }
        else
        {
          i += 1;
        }
      }
      SLog.a("Q.qqstory.download.preload.FeedVideoPreloader", "download list , size = %d", Integer.valueOf(localList1.size()));
      this.b = localList1;
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(localList1, 1, true);
      return;
      label319:
      continue;
      label322:
      int j = 0;
      continue;
      label327:
      j = 0;
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedVideoPreloader
 * JD-Core Version:    0.7.0.1
 */