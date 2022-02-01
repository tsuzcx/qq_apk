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
  static VideoListHomeFeed.HomeComp l = new VideoListHomeFeed.HomeComp(null);
  private boolean e;
  protected List<StoryVideoItem> h = new ArrayList(0);
  protected HashSet<String> i = new HashSet();
  public List<TagItem.TagInfoBase> j = new ArrayList();
  public boolean k = true;
  
  public VideoListHomeFeed(@NonNull T paramT)
  {
    super(paramT);
  }
  
  private boolean a(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    paramString = DateUtils.b(paramString);
    return (localCalendar.get(1) + 0 <= paramString[0]) && (localCalendar.get(2) + 1 <= paramString[1]) && (localCalendar.get(5) + 0 <= paramString[2]);
  }
  
  public List<StoryVideoItem> a()
  {
    return Collections.unmodifiableList(this.h);
  }
  
  public void a(int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    this.h.remove(paramInt);
    this.h.add(paramInt, paramStoryVideoItem);
    this.i.add(paramStoryVideoItem.mVid);
    paramStoryVideoItem = this.h.iterator();
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
    this.e = bool;
    SLog.d("Q.qqstory.home.data.VideoListHomeFeed", "feed id %s, fake video count:%d", new Object[] { ((VideoListFeedItem)this.f).feedId, Integer.valueOf(paramInt) });
    AssertUtils.mainThreadCheck();
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    this.h.remove(paramStoryVideoItem);
    this.i.remove(paramStoryVideoItem.mVid);
    AssertUtils.mainThreadCheck();
  }
  
  public void a(StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    if (this.i.contains(paramStoryVideoItem.mVid)) {
      this.h.remove(paramStoryVideoItem);
    }
    this.h.add(0, paramStoryVideoItem);
    this.i.add(paramStoryVideoItem.mVid);
    this.e = true;
    if (paramBoolean)
    {
      paramBoolean = a(i().date);
      SLog.b("Q.qqstory.home.data.VideoListHomeFeed", "sort today=%b before %s", Boolean.valueOf(paramBoolean), this.h);
      Collections.sort(this.h, new VideoListHomeFeed.StoryVideoListComp(paramBoolean ^ true));
      SLog.b("Q.qqstory.home.data.VideoListHomeFeed", "sort today=%b after %s", Boolean.valueOf(paramBoolean), this.h);
    }
  }
  
  public void b()
  {
    c(((StoryManager)SuperManager.a(5)).a(((VideoListFeedItem)this.f).feedId, 0, a(), true), true);
    ((FeedVideoManager)SuperManager.a(12)).a(0, ((VideoListFeedItem)this.f).feedId, ((VideoListFeedItem)this.f).mVideoSeq, a(), ((VideoListFeedItem)this.f).mVideoNextCookie, ((VideoListFeedItem)this.f).mIsVideoEnd, ((VideoListFeedItem)this.f).mVideoPullType, true);
  }
  
  public void c(List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.h.clear();
      this.i.clear();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
      if (this.i.contains(localStoryVideoItem.mVid)) {
        this.h.remove(localStoryVideoItem);
      } else {
        this.i.add(localStoryVideoItem.mVid);
      }
      this.h.add(localStoryVideoItem);
      if (StoryVideoItem.isFakeVid(localStoryVideoItem.mVid)) {
        this.e = true;
      }
    }
    paramBoolean = a(i().date);
    if ((!(i() instanceof TagFeedItem)) && (i().assignType() != 7)) {
      Collections.sort(this.h, new VideoListHomeFeed.StoryVideoListComp(paramBoolean ^ true));
    }
  }
  
  public void e()
  {
    super.e();
    c(((StoryManager)SuperManager.a(5)).d(((VideoListFeedItem)this.f).feedId), true);
  }
  
  public T i()
  {
    return (VideoListFeedItem)super.c();
  }
  
  public List<StoryVideoItem> j()
  {
    return Collections.unmodifiableList(this.h);
  }
  
  public boolean k()
  {
    try
    {
      Iterator localIterator = this.h.iterator();
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
    SLog.d("Q.qqstory.home.data.VideoListHomeFeed", "video item size:%d", new Object[] { Integer.valueOf(this.h.size()) });
    return false;
  }
  
  public boolean l()
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext()) {
      if (StoryVideoItem.isFakeVid(((StoryVideoItem)localIterator.next()).mVid)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hasFakeVideo=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(this.f);
    localStringBuilder.append(String.format("video=%d,like=%d,comment=%d", new Object[] { Integer.valueOf(this.h.size()), Integer.valueOf(this.c.size()), Integer.valueOf(this.a.size()) }));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.VideoListHomeFeed
 * JD-Core Version:    0.7.0.1
 */