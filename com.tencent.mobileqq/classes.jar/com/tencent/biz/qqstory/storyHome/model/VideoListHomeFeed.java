package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import nxp;
import nxq;

public abstract class VideoListHomeFeed
  extends CommentLikeHomeFeed
{
  public static nxp a;
  private boolean a;
  protected HashSet c;
  protected List c;
  public boolean c;
  public List d = new ArrayList();
  
  static
  {
    jdField_a_of_type_Nxp = new nxp(null);
  }
  
  public VideoListHomeFeed(@NonNull VideoListFeedItem paramVideoListFeedItem)
  {
    super(paramVideoListFeedItem);
    this.jdField_c_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_c_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_c_of_type_Boolean = true;
  }
  
  private boolean a(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    paramString = UIUtils.a(paramString);
    return (localCalendar.get(1) + 0 <= paramString[0]) && (localCalendar.get(2) + 1 <= paramString[1]) && (localCalendar.get(5) + 0 <= paramString[2]);
  }
  
  public VideoListFeedItem a()
  {
    return (VideoListFeedItem)super.a();
  }
  
  public List a()
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
    if (paramStoryVideoItem.hasNext())
    {
      if (!StoryVideoItem.isFakeVid(((StoryVideoItem)paramStoryVideoItem.next()).mVid)) {
        break label131;
      }
      paramInt += 1;
    }
    label131:
    for (;;)
    {
      break;
      if (paramInt != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        SLog.d("Q.qqstory.home.data.VideoListHomeFeed", "feed id %s, fake video count:%d", new Object[] { ((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, Integer.valueOf(paramInt) });
        AssertUtils.a();
        return;
      }
    }
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_c_of_type_JavaUtilList.remove(paramStoryVideoItem);
    this.jdField_c_of_type_JavaUtilHashSet.remove(paramStoryVideoItem.mVid);
    AssertUtils.a();
  }
  
  public void a(StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    boolean bool = true;
    if (this.jdField_c_of_type_JavaUtilHashSet.contains(paramStoryVideoItem.mVid)) {
      this.jdField_c_of_type_JavaUtilList.remove(paramStoryVideoItem);
    }
    this.jdField_c_of_type_JavaUtilList.add(0, paramStoryVideoItem);
    this.jdField_c_of_type_JavaUtilHashSet.add(paramStoryVideoItem.mVid);
    this.jdField_a_of_type_Boolean = true;
    if (paramBoolean)
    {
      paramBoolean = a(a().date);
      paramStoryVideoItem = this.jdField_c_of_type_JavaUtilList;
      if (paramBoolean) {
        break label95;
      }
    }
    label95:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      Collections.sort(paramStoryVideoItem, new nxq(paramBoolean));
      return;
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
      SLog.d("Q.qqstory.home.data.VideoListHomeFeed", "video item size:%d", new Object[] { Integer.valueOf(this.jdField_c_of_type_JavaUtilList.size()) });
    }
    return false;
  }
  
  public void b()
  {
    super.b();
    c(((StoryManager)SuperManager.a(5)).b(((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId), true);
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
  
  public void c(List paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_c_of_type_JavaUtilHashSet.clear();
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
      if (this.jdField_c_of_type_JavaUtilHashSet.contains(localStoryVideoItem.mVid)) {
        this.jdField_c_of_type_JavaUtilList.remove(localStoryVideoItem);
      }
      for (;;)
      {
        this.jdField_c_of_type_JavaUtilList.add(localStoryVideoItem);
        if (!StoryVideoItem.isFakeVid(localStoryVideoItem.mVid)) {
          break;
        }
        this.jdField_a_of_type_Boolean = true;
        break;
        this.jdField_c_of_type_JavaUtilHashSet.add(localStoryVideoItem.mVid);
      }
    }
    paramBoolean = a(a().date);
    if (!(a() instanceof TagFeedItem))
    {
      paramList = this.jdField_c_of_type_JavaUtilList;
      if (paramBoolean) {
        break label161;
      }
    }
    label161:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Collections.sort(paramList, new nxq(paramBoolean));
      return;
    }
  }
  
  public List d()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public String toString()
  {
    return "hasFakeVideo=" + this.jdField_a_of_type_Boolean + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem + String.format("video=%d,like=%d,comment=%d", new Object[] { Integer.valueOf(this.jdField_c_of_type_JavaUtilList.size()), Integer.valueOf(this.b.size()), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.VideoListHomeFeed
 * JD-Core Version:    0.7.0.1
 */