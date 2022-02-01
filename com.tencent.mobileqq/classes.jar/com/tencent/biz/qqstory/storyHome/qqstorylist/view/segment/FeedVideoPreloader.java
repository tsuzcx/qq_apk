package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.preload.DownloadTask;
import com.tencent.biz.qqstory.base.preload.IVideoPreloader;
import com.tencent.biz.qqstory.base.preload.VideoPreloader;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FeedVideoPreloader
{
  public IVideoPreloader a;
  protected StoryVideoItem a;
  protected FeedVideoPreloader.CurrentVid a;
  public FeedVideoPreloader.OnFileDownloadListener a;
  protected FeedVideoPreloader.OnVideoDownloadListener a;
  private Object a;
  protected List<StoryHomeFeed> a;
  protected List<DownloadTask> b = new ArrayList();
  
  public FeedVideoPreloader()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader = new VideoPreloader();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = null;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$OnFileDownloadListener = new FeedVideoPreloader.OnFileDownloadListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(1);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$OnFileDownloadListener);
  }
  
  private void a(StoryVideoItem paramStoryVideoItem, List<DownloadTask> paramList, boolean paramBoolean)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    if (paramBoolean)
    {
      DownloadTask localDownloadTask1 = DownloadTask.a(paramStoryVideoItem.mVid, 1);
      DownloadTask localDownloadTask2 = DownloadTask.a(paramStoryVideoItem.mVid, 0);
      paramStoryVideoItem = DownloadTask.a(paramStoryVideoItem.mVid, 2);
      localDownloadTask1.g = 0;
      localDownloadTask2.g = 0;
      paramStoryVideoItem.g = 1;
      localDownloadTask2.a.put("handleCallback", localBoolean);
      paramList.add(localDownloadTask1);
      paramList.add(localDownloadTask2);
      paramList.add(paramStoryVideoItem);
      return;
    }
    paramList.add(DownloadTask.a(paramStoryVideoItem.mVid, 2));
    paramList.add(DownloadTask.a(paramStoryVideoItem.mVid, 1));
    paramStoryVideoItem = DownloadTask.a(paramStoryVideoItem.mVid, 0);
    paramStoryVideoItem.a.put("handleCallback", localBoolean);
    paramList.add(paramStoryVideoItem);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$OnVideoDownloadListener = null;
  }
  
  public void a(StoryVideoItem paramStoryVideoItem, List<StoryHomeFeed> paramList)
  {
    if (paramStoryVideoItem == null) {
      return;
    }
    paramList = new ArrayList(paramList);
    Bosses.get().postJob(new FeedVideoPreloader.1(this, "Q.qqstory.download.preload.FeedVideoPreloader", paramStoryVideoItem, paramList));
  }
  
  public void a(FeedVideoPreloader.OnVideoDownloadListener paramOnVideoDownloadListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$OnVideoDownloadListener = paramOnVideoDownloadListener;
  }
  
  protected boolean a(String paramString)
  {
    return StoryVideoItem.isPlayable(paramString, false);
  }
  
  protected void b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new ArrayList();
    int i;
    int j;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ((List)localObject2).addAll(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)
      {
        i = 0;
        if (i < ((List)localObject2).size())
        {
          List localList = ((StoryHomeFeed)((List)localObject2).get(i)).d();
          if ((localList.size() > 0) && (TextUtils.equals(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, ((StoryVideoItem)localList.get(0)).mVid)))
          {
            j = 1;
            a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, localArrayList, true);
            if (j == 0) {
              i = 0;
            }
            j = i + 1;
            if (j < ((List)localObject2).size())
            {
              ??? = ((StoryHomeFeed)((List)localObject2).get(j)).d();
              if (((List)???).size() > 0) {
                a((StoryVideoItem)((List)???).get(0), localArrayList, false);
              }
            }
            i -= 1;
            if ((i >= 0) && (i < ((List)localObject2).size()))
            {
              localObject2 = ((StoryHomeFeed)((List)localObject2).get(i)).d();
              if (((List)localObject2).size() > 0) {
                a((StoryVideoItem)((List)localObject2).get(0), localArrayList, false);
              }
            }
            this.b = localArrayList;
            this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(localArrayList, true);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedVideoPreloader
 * JD-Core Version:    0.7.0.1
 */