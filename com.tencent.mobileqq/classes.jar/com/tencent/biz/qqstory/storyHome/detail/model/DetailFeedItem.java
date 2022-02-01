package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class DetailFeedItem
{
  public CommentLikeFeedItem a;
  private List<StoryVideoItem> b = new ArrayList(0);
  private HashSet<String> c = new HashSet();
  private List<CommentEntry> d = new ArrayList(0);
  private HashSet<String> e = new HashSet();
  private String f;
  private boolean g = true;
  private CommentEntry h = null;
  private List<LikeEntry> i = new ArrayList(0);
  private HashSet<String> j = new HashSet();
  private List<CommentEntry> k = new ArrayList(0);
  private HashSet<String> l = new HashSet();
  private String m;
  private boolean n = true;
  private CommentEntry o = null;
  private List<LikeEntry> p = new ArrayList(0);
  private HashSet<String> q = new HashSet();
  private List<TagItem.TagInfoBase> r = new ArrayList();
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int i1 = 1;
    if (paramBoolean)
    {
      if (paramInt != -1) {
        return 1 + paramInt;
      }
    }
    else
    {
      if (paramInt > 0) {
        return paramInt - 1;
      }
      i1 = -1;
    }
    return i1;
  }
  
  public List<StoryVideoItem> a()
  {
    return this.b;
  }
  
  public List<CommentEntry> a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.d;
    }
    return this.k;
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.d.iterator();
    CommentEntry localCommentEntry;
    StringBuilder localStringBuilder;
    while (((Iterator)localObject).hasNext())
    {
      localCommentEntry = (CommentEntry)((Iterator)localObject).next();
      if (localCommentEntry.commentId == paramInt)
      {
        localObject = this.e;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localCommentEntry.authorUnionId);
        localStringBuilder.append(localCommentEntry.fakeId);
        ((HashSet)localObject).remove(localStringBuilder.toString());
        this.d.remove(localCommentEntry);
      }
    }
    localObject = this.k.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localCommentEntry = (CommentEntry)((Iterator)localObject).next();
      if (localCommentEntry.commentId == paramInt)
      {
        localObject = this.l;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localCommentEntry.authorUnionId);
        localStringBuilder.append(localCommentEntry.fakeId);
        ((HashSet)localObject).remove(localStringBuilder.toString());
        this.k.remove(localCommentEntry);
      }
    }
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    HashSet localHashSet;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      this.d.add(paramCommentEntry);
      localHashSet = this.e;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramCommentEntry.authorUnionId);
      localStringBuilder.append(paramCommentEntry.fakeId);
      localHashSet.add(localStringBuilder.toString());
    }
    else
    {
      this.k.add(paramCommentEntry);
      localHashSet = this.l;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramCommentEntry.authorUnionId);
      localStringBuilder.append(paramCommentEntry.fakeId);
      localHashSet.add(localStringBuilder.toString());
    }
    if (paramCommentEntry.type != 1)
    {
      if (paramBoolean)
      {
        paramCommentEntry = this.a;
        paramCommentEntry.mFanCommentCount = a(paramCommentEntry.mFanCommentCount, true);
      }
      else
      {
        paramCommentEntry = this.a;
        paramCommentEntry.mFriendCommentCount = a(paramCommentEntry.mFriendCommentCount, true);
      }
      paramCommentEntry = this.a;
      paramCommentEntry.mCommentCount = a(paramCommentEntry.mCommentCount, true);
    }
  }
  
  public void a(LikeEntry paramLikeEntry, boolean paramBoolean)
  {
    if (b())
    {
      localCommentLikeFeedItem = this.a;
      localCommentLikeFeedItem.mFriendLikeCount = a(localCommentLikeFeedItem.mFriendLikeCount, true);
    }
    else
    {
      localCommentLikeFeedItem = this.a;
      localCommentLikeFeedItem.mFanLikeCount = a(localCommentLikeFeedItem.mFanLikeCount, true);
    }
    CommentLikeFeedItem localCommentLikeFeedItem = this.a;
    localCommentLikeFeedItem.mLikeCount = a(localCommentLikeFeedItem.mLikeCount, true);
    this.i.add(paramLikeEntry);
    this.j.add(paramLikeEntry.unionId);
    this.p.add(paramLikeEntry);
    this.q.add(paramLikeEntry.unionId);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    this.b.remove(paramStoryVideoItem);
    this.c.remove(paramStoryVideoItem.mVid);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (paramInt < 0) {
      this.b.add(paramStoryVideoItem);
    } else {
      this.b.add(paramInt, paramStoryVideoItem);
    }
    this.c.add(paramStoryVideoItem.mVid);
  }
  
  public void a(List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)((Iterator)localObject).next();
        if (localStoryVideoItem.isUploadSuc())
        {
          this.c.remove(localStoryVideoItem.mVid);
          ((Iterator)localObject).remove();
        }
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (StoryVideoItem)paramList.next();
      if (!this.c.contains(((StoryVideoItem)localObject).mVid))
      {
        this.c.add(((StoryVideoItem)localObject).mVid);
        this.b.add(localObject);
      }
    }
  }
  
  public void a(List<CommentEntry> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    List localList = this.d;
    HashSet localHashSet = this.e;
    if (!paramBoolean2)
    {
      localList = this.k;
      localHashSet = this.l;
    }
    CommentEntry localCommentEntry;
    StringBuilder localStringBuilder;
    if (paramBoolean1)
    {
      localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        localCommentEntry = (CommentEntry)localIterator.next();
        if (localCommentEntry.status == 0)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localCommentEntry.authorUnionId);
          localStringBuilder.append(localCommentEntry.fakeId);
          localHashSet.remove(localStringBuilder.toString());
          localIterator.remove();
        }
      }
      SLog.a("Q.qqstory.detail.DetailFeedItem", "comment list's size is %d after clear.", Integer.valueOf(localList.size()));
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localCommentEntry = (CommentEntry)localIterator.next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(localCommentEntry.authorUnionId);
      localStringBuilder.append(localCommentEntry.fakeId);
      if (!localHashSet.contains(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localCommentEntry.authorUnionId);
        localStringBuilder.append(localCommentEntry.fakeId);
        localHashSet.add(localStringBuilder.toString());
        localList.add(localCommentEntry);
      }
    }
    Collections.sort(localList, new DetailFeedItem.CommentComp(this));
    SLog.a("Q.qqstory.detail.DetailFeedItem", "comment list's size is %d after add %d comments.", Integer.valueOf(localList.size()), Integer.valueOf(paramList.size()));
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.a.mFanCommentCount = paramInt;
      return;
    }
    this.a.mFriendCommentCount = paramInt;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.f = paramString;
      return;
    }
    this.m = paramString;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.g = paramBoolean2;
      return;
    }
    this.n = paramBoolean2;
  }
  
  public void b(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      localObject = this.d.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((CommentEntry)((Iterator)localObject).next()).equals(paramCommentEntry)) {
          ((Iterator)localObject).remove();
        }
      }
      localObject = this.e;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramCommentEntry.authorUnionId);
      localStringBuilder.append(paramCommentEntry.fakeId);
      ((HashSet)localObject).remove(localStringBuilder.toString());
    }
    else
    {
      localObject = this.k.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((CommentEntry)((Iterator)localObject).next()).equals(paramCommentEntry)) {
          ((Iterator)localObject).remove();
        }
      }
      localObject = this.l;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramCommentEntry.authorUnionId);
      localStringBuilder.append(paramCommentEntry.fakeId);
      ((HashSet)localObject).remove(localStringBuilder.toString());
    }
    if (paramCommentEntry.type != 1)
    {
      if (paramBoolean)
      {
        paramCommentEntry = this.a;
        paramCommentEntry.mFanCommentCount = a(paramCommentEntry.mFanCommentCount, false);
      }
      else
      {
        paramCommentEntry = this.a;
        paramCommentEntry.mFriendCommentCount = a(paramCommentEntry.mFriendCommentCount, false);
      }
      paramCommentEntry = this.a;
      paramCommentEntry.mCommentCount = a(paramCommentEntry.mCommentCount, false);
    }
  }
  
  public void b(LikeEntry paramLikeEntry, boolean paramBoolean)
  {
    if (b())
    {
      localObject = this.a;
      ((CommentLikeFeedItem)localObject).mFriendLikeCount = a(((CommentLikeFeedItem)localObject).mFriendLikeCount, false);
    }
    else
    {
      localObject = this.a;
      ((CommentLikeFeedItem)localObject).mFanLikeCount = a(((CommentLikeFeedItem)localObject).mFanLikeCount, false);
    }
    Object localObject = this.a;
    ((CommentLikeFeedItem)localObject).mLikeCount = a(((CommentLikeFeedItem)localObject).mLikeCount, false);
    localObject = this.i.iterator();
    LikeEntry localLikeEntry;
    while (((Iterator)localObject).hasNext())
    {
      localLikeEntry = (LikeEntry)((Iterator)localObject).next();
      if (localLikeEntry.unionId.equals(paramLikeEntry.unionId))
      {
        this.j.remove(localLikeEntry.unionId);
        this.i.remove(localLikeEntry);
      }
    }
    localObject = this.p.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localLikeEntry = (LikeEntry)((Iterator)localObject).next();
      if (localLikeEntry.unionId.equals(paramLikeEntry.unionId))
      {
        this.q.remove(localLikeEntry.unionId);
        this.p.remove(localLikeEntry);
      }
    }
  }
  
  public void b(List<TagItem.TagInfoBase> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.r.clear();
    }
    this.r.addAll(paramList);
  }
  
  public void b(List<LikeEntry> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    List localList = this.i;
    HashSet localHashSet = this.j;
    if (!paramBoolean2)
    {
      localList = this.p;
      localHashSet = this.q;
    }
    if (paramBoolean1)
    {
      localList.clear();
      localHashSet.clear();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LikeEntry localLikeEntry = (LikeEntry)paramList.next();
      if (!localHashSet.contains(localLikeEntry.unionId))
      {
        localHashSet.add(localLikeEntry.unionId);
        localList.add(localLikeEntry);
      }
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.a.mFanLikeCount = paramInt;
      return;
    }
    this.a.mFriendLikeCount = paramInt;
  }
  
  public boolean b()
  {
    CommentLikeFeedItem localCommentLikeFeedItem = this.a;
    if (localCommentLikeFeedItem != null)
    {
      if (localCommentLikeFeedItem.getOwner() == null) {
        return false;
      }
      localCommentLikeFeedItem = this.a;
      if (!(localCommentLikeFeedItem instanceof VideoListFeedItem)) {
        return false;
      }
      return localCommentLikeFeedItem.getOwner().isMe();
    }
    return false;
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.g;
    }
    return this.n;
  }
  
  public String c(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.f;
    }
    return this.m;
  }
  
  public void c(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.h = paramCommentEntry;
      return;
    }
    this.o = paramCommentEntry;
  }
  
  public boolean c()
  {
    boolean bool2 = b();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (((VideoListFeedItem)this.a).mHasPublicVideo) {
      return true;
    }
    int i1;
    if (this.i.size() > 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = i1;
    if (i1 != 0)
    {
      i2 = i1;
      if (this.i.size() == 1)
      {
        i2 = i1;
        if (QQStoryContext.a().b(((LikeEntry)this.i.get(0)).unionId)) {
          i2 = 0;
        }
      }
    }
    if ((this.d.size() > 0) || (i2 != 0)) {
      bool1 = true;
    }
    return bool1;
  }
  
  public int d(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.a.mFanCommentCount;
    }
    return this.a.mFriendCommentCount;
  }
  
  public List<TagItem.TagInfoBase> d()
  {
    return Collections.unmodifiableList(this.r);
  }
  
  public List<LikeEntry> e(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.i;
    }
    return this.p;
  }
  
  public boolean e()
  {
    return (this.a instanceof VideoListFeedItem);
  }
  
  public int f(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.a.mFanLikeCount;
    }
    return this.a.mFriendLikeCount;
  }
  
  public VideoListFeedItem f()
  {
    if (e()) {
      return (VideoListFeedItem)this.a;
    }
    return null;
  }
  
  public void g(boolean paramBoolean)
  {
    if (h(paramBoolean) != null)
    {
      b(h(paramBoolean), paramBoolean);
      c(null, paramBoolean);
    }
  }
  
  public boolean g()
  {
    return (this.a instanceof GeneralFeedItem);
  }
  
  public CommentEntry h(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.h;
    }
    return this.o;
  }
  
  public GeneralFeedItem h()
  {
    if (g()) {
      return (GeneralFeedItem)this.a;
    }
    return null;
  }
  
  public boolean i()
  {
    return (this.a instanceof GeneralRecommendFeedItem);
  }
  
  public GeneralRecommendFeedItem j()
  {
    if (i()) {
      return (GeneralRecommendFeedItem)this.a;
    }
    return null;
  }
  
  public boolean k()
  {
    return (this.a instanceof ShareGroupFeedItem);
  }
  
  public ShareGroupFeedItem l()
  {
    if (k()) {
      return (ShareGroupFeedItem)this.a;
    }
    return null;
  }
  
  public boolean m()
  {
    return (this.a instanceof BannerFeedItem);
  }
  
  public BannerFeedItem n()
  {
    if (m()) {
      return (BannerFeedItem)this.a;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DetailFeedItem{mFeedBasicItem=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mVideoItemList=");
    localStringBuilder.append(this.b.size());
    localStringBuilder.append(", mFeedCommentList=");
    localStringBuilder.append(this.d.size());
    localStringBuilder.append(", mCommentCookie=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mCommentIsEnd=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mLikeEntryList=");
    localStringBuilder.append(this.i.size());
    localStringBuilder.append(", mFriendCommentList=");
    localStringBuilder.append(this.k.size());
    localStringBuilder.append(", mFriendCommentCookie=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", mFriendCommentIsEnd=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", mFriendLikeList=");
    localStringBuilder.append(this.p.size());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem
 * JD-Core Version:    0.7.0.1
 */