package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.DateUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class VideoListHomeFeed<T extends VideoListFeedItem>
  extends CommentLikeHomeFeed<T>
{
  static VideoListHomeFeed.HomeComp jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListHomeFeed$HomeComp = new VideoListHomeFeed.HomeComp(null);
  private boolean jdField_a_of_type_Boolean;
  protected HashSet<String> c;
  protected List<StoryVideoItem> c;
  public boolean c;
  public List<TagItem.TagInfoBase> d = new ArrayList();
  
  public VideoListHomeFeed(@NonNull T paramT)
  {
    super(paramT);
    this.jdField_c_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_c_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_c_of_type_Boolean = true;
  }
  
  private boolean a(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    paramString = DateUtils.a(paramString);
    return (localCalendar.get(1) + 0 <= paramString[0]) && (localCalendar.get(2) + 1 <= paramString[1]) && (localCalendar.get(5) + 0 <= paramString[2]);
  }
  
  public T a()
  {
    return (VideoListFeedItem)super.a();
  }
  
  public List<StoryVideoItem> a()
  {
    return Collections.unmodifiableList(this.jdField_c_of_type_JavaUtilList);
  }
  
  public void a()
  {
    c(((StoryManager)SuperManager.a(5)).a(((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, 0, a(), true), true);
    ((FeedVideoManager)SuperManager.a(12)).a(0, ((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, ((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mVideoSeq, a(), ((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mVideoNextCookie, ((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mIsVideoEnd, ((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mVideoPullType, true);
  }
  
  public void a(int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_c_of_type_JavaUtilList.remove(paramInt);
    this.jdField_c_of_type_JavaUtilList.add(paramInt, paramStoryVideoItem);
    this.jdField_c_of_type_JavaUtilHashSet.add(paramStoryVideoItem.mVid);
    paramStoryVideoItem = this.jdField_c_of_type_JavaUtilList.iterator();
    paramInt = 0;
    while (paramStoryVideoItem.hasNext()) {
      if (StoryVideoItem.isFakeVid(((StoryVideoItem)paramStoryVideoItem.next()).mVid)) {
        paramInt += 1;
      }
    }
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    SLog.d("Q.qqstory.home.data.VideoListHomeFeed", "feed id %s, fake video count:%d", new Object[] { ((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, Integer.valueOf(paramInt) });
    AssertUtils.mainThreadCheck();
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_c_of_type_JavaUtilList.remove(paramStoryVideoItem);
    this.jdField_c_of_type_JavaUtilHashSet.remove(paramStoryVideoItem.mVid);
    AssertUtils.mainThreadCheck();
  }
  
  public void a(StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_JavaUtilHashSet.contains(paramStoryVideoItem.mVid)) {
      this.jdField_c_of_type_JavaUtilList.remove(paramStoryVideoItem);
    }
    this.jdField_c_of_type_JavaUtilList.add(0, paramStoryVideoItem);
    this.jdField_c_of_type_JavaUtilHashSet.add(paramStoryVideoItem.mVid);
    this.jdField_a_of_type_Boolean = true;
    if (paramBoolean)
    {
      paramBoolean = a(a().date);
      SLog.b("Q.qqstory.home.data.VideoListHomeFeed", "sort today=%b before %s", Boolean.valueOf(paramBoolean), this.jdField_c_of_type_JavaUtilList);
      Collections.sort(this.jdField_c_of_type_JavaUtilList, new VideoListHomeFeed.StoryVideoListComp(paramBoolean ^ true));
      SLog.b("Q.qqstory.home.data.VideoListHomeFeed", "sort today=%b after %s", Boolean.valueOf(paramBoolean), this.jdField_c_of_type_JavaUtilList);
    }
  }
  
  public boolean a()
  {
    try
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        boolean bool = ((StoryVideoItem)localIterator.next()).isUploadSuc();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (ConcurrentModificationException localConcurrentModificationException)
    {
      label40:
      break label40;
    }
    SLog.d("Q.qqstory.home.data.VideoListHomeFeed", "video item size:%d", new Object[] { Integer.valueOf(this.jdField_c_of_type_JavaUtilList.size()) });
    return false;
  }
  
  public void b()
  {
    super.b();
    c(((StoryManager)SuperManager.a(5)).a(((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId), true);
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (StoryVideoItem.isFakeVid(((StoryVideoItem)localIterator.next()).mVid)) {
        return true;
      }
    }
    return false;
  }
  
  public void c(List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_c_of_type_JavaUtilHashSet.clear();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
      if (this.jdField_c_of_type_JavaUtilHashSet.contains(localStoryVideoItem.mVid)) {
        this.jdField_c_of_type_JavaUtilList.remove(localStoryVideoItem);
      } else {
        this.jdField_c_of_type_JavaUtilHashSet.add(localStoryVideoItem.mVid);
      }
      this.jdField_c_of_type_JavaUtilList.add(localStoryVideoItem);
      if (StoryVideoItem.isFakeVid(localStoryVideoItem.mVid)) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    paramBoolean = a(a().date);
    if ((!(a() instanceof TagFeedItem)) && (a().assignType() != 7)) {
      Collections.sort(this.jdField_c_of_type_JavaUtilList, new VideoListHomeFeed.StoryVideoListComp(paramBoolean ^ true));
    }
  }
  
  public List<StoryVideoItem> d()
  {
    return Collections.unmodifiableList(this.jdField_c_of_type_JavaUtilList);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hasFakeVideo=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem);
    localStringBuilder.append(String.format("video=%d,like=%d,comment=%d", new Object[] { Integer.valueOf(this.jdField_c_of_type_JavaUtilList.size()), Integer.valueOf(this.b.size()), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) }));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.VideoListHomeFeed
 * JD-Core Version:    0.7.0.1
 */