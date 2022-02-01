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
  private CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = null;
  public CommentLikeFeedItem a;
  private String jdField_a_of_type_JavaLangString;
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<StoryVideoItem> jdField_a_of_type_JavaUtilList = new ArrayList(0);
  private boolean jdField_a_of_type_Boolean = true;
  private CommentEntry jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry = null;
  private String jdField_b_of_type_JavaLangString;
  private HashSet<String> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private List<CommentEntry> jdField_b_of_type_JavaUtilList = new ArrayList(0);
  private boolean jdField_b_of_type_Boolean = true;
  private HashSet<String> jdField_c_of_type_JavaUtilHashSet = new HashSet();
  private List<LikeEntry> jdField_c_of_type_JavaUtilList = new ArrayList(0);
  private HashSet<String> jdField_d_of_type_JavaUtilHashSet = new HashSet();
  private List<CommentEntry> jdField_d_of_type_JavaUtilList = new ArrayList(0);
  private HashSet<String> jdField_e_of_type_JavaUtilHashSet = new HashSet();
  private List<LikeEntry> jdField_e_of_type_JavaUtilList = new ArrayList(0);
  private List<TagItem.TagInfoBase> f = new ArrayList();
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int i = -1;
    if (paramBoolean) {
      if (paramInt != -1) {
        i = paramInt + 1;
      }
    }
    while (paramInt <= 0)
    {
      return i;
      return 1;
    }
    return paramInt - 1;
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
  }
  
  public CommentEntry a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
    }
    return this.jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
  }
  
  public BannerFeedItem a()
  {
    if (g()) {
      return (BannerFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    }
    return null;
  }
  
  public GeneralFeedItem a()
  {
    if (d()) {
      return (GeneralFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    }
    return null;
  }
  
  public GeneralRecommendFeedItem a()
  {
    if (e()) {
      return (GeneralRecommendFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    }
    return null;
  }
  
  public ShareGroupFeedItem a()
  {
    if (f()) {
      return (ShareGroupFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    }
    return null;
  }
  
  public VideoListFeedItem a()
  {
    if (c()) {
      return (VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    }
    return null;
  }
  
  public String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public List<StoryVideoItem> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List<CommentEntry> a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_b_of_type_JavaUtilList;
    }
    return this.jdField_d_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    CommentEntry localCommentEntry;
    while (localIterator.hasNext())
    {
      localCommentEntry = (CommentEntry)localIterator.next();
      if (localCommentEntry.commentId == paramInt)
      {
        this.jdField_b_of_type_JavaUtilHashSet.remove(localCommentEntry.authorUnionId + localCommentEntry.fakeId);
        this.jdField_b_of_type_JavaUtilList.remove(localCommentEntry);
      }
    }
    localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localCommentEntry = (CommentEntry)localIterator.next();
      if (localCommentEntry.commentId == paramInt)
      {
        this.jdField_d_of_type_JavaUtilHashSet.remove(localCommentEntry.authorUnionId + localCommentEntry.fakeId);
        this.jdField_d_of_type_JavaUtilList.remove(localCommentEntry);
      }
    }
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_JavaUtilList.add(paramCommentEntry);
      this.jdField_b_of_type_JavaUtilHashSet.add(paramCommentEntry.authorUnionId + paramCommentEntry.fakeId);
      if (paramCommentEntry.type != 1)
      {
        if (!paramBoolean) {
          break label144;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount, true);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount, true);
      return;
      this.jdField_d_of_type_JavaUtilList.add(paramCommentEntry);
      this.jdField_d_of_type_JavaUtilHashSet.add(paramCommentEntry.authorUnionId + paramCommentEntry.fakeId);
      break;
      label144:
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount, true);
    }
  }
  
  public void a(LikeEntry paramLikeEntry, boolean paramBoolean)
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount = a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount = a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount, true);
      this.jdField_c_of_type_JavaUtilList.add(paramLikeEntry);
      this.jdField_c_of_type_JavaUtilHashSet.add(paramLikeEntry.unionId);
      this.jdField_e_of_type_JavaUtilList.add(paramLikeEntry);
      this.jdField_e_of_type_JavaUtilHashSet.add(paramLikeEntry.unionId);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount = a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount, true);
    }
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramStoryVideoItem);
    this.jdField_a_of_type_JavaUtilHashSet.remove(paramStoryVideoItem.mVid);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (paramInt < 0) {
      this.jdField_a_of_type_JavaUtilList.add(paramStoryVideoItem);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(paramStoryVideoItem.mVid);
      return;
      this.jdField_a_of_type_JavaUtilList.add(paramInt, paramStoryVideoItem);
    }
  }
  
  public void a(List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)((Iterator)localObject).next();
        if (localStoryVideoItem.isUploadSuc())
        {
          this.jdField_a_of_type_JavaUtilHashSet.remove(localStoryVideoItem.mVid);
          ((Iterator)localObject).remove();
        }
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (StoryVideoItem)paramList.next();
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(((StoryVideoItem)localObject).mVid))
      {
        this.jdField_a_of_type_JavaUtilHashSet.add(((StoryVideoItem)localObject).mVid);
        this.jdField_a_of_type_JavaUtilList.add(localObject);
      }
    }
  }
  
  public void a(List<CommentEntry> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    List localList = this.jdField_b_of_type_JavaUtilList;
    HashSet localHashSet = this.jdField_b_of_type_JavaUtilHashSet;
    if (!paramBoolean2)
    {
      localList = this.jdField_d_of_type_JavaUtilList;
      localHashSet = this.jdField_d_of_type_JavaUtilHashSet;
    }
    for (;;)
    {
      CommentEntry localCommentEntry;
      if (paramBoolean1)
      {
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localCommentEntry = (CommentEntry)localIterator.next();
          if (localCommentEntry.status == 0)
          {
            localHashSet.remove(localCommentEntry.authorUnionId + localCommentEntry.fakeId);
            localIterator.remove();
          }
        }
        SLog.a("Q.qqstory.detail.DetailFeedItem", "comment list's size is %d after clear.", Integer.valueOf(localList.size()));
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        localCommentEntry = (CommentEntry)localIterator.next();
        if (!localHashSet.contains(localCommentEntry.authorUnionId + localCommentEntry.fakeId))
        {
          localHashSet.add(localCommentEntry.authorUnionId + localCommentEntry.fakeId);
          localList.add(localCommentEntry);
        }
      }
      Collections.sort(localList, new DetailFeedItem.CommentComp(this));
      SLog.a("Q.qqstory.detail.DetailFeedItem", "comment list's size is %d after add %d comments.", Integer.valueOf(localList.size()), Integer.valueOf(paramList.size()));
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (a(paramBoolean) != null)
    {
      b(a(paramBoolean), paramBoolean);
      c(null, paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramInt;
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramInt;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_Boolean = paramBoolean2;
      return;
    }
    this.jdField_b_of_type_Boolean = paramBoolean2;
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() == null)) {}
    while (!(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem instanceof VideoListFeedItem)) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe();
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_a_of_type_Boolean;
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  public int b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount;
  }
  
  public List<TagItem.TagInfoBase> b()
  {
    return Collections.unmodifiableList(this.f);
  }
  
  public List<LikeEntry> b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_c_of_type_JavaUtilList;
    }
    return this.jdField_e_of_type_JavaUtilList;
  }
  
  public void b(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    Iterator localIterator;
    if (paramBoolean)
    {
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (((CommentEntry)localIterator.next()).equals(paramCommentEntry)) {
          localIterator.remove();
        }
      }
      this.jdField_b_of_type_JavaUtilHashSet.remove(paramCommentEntry.authorUnionId + paramCommentEntry.fakeId);
      if (paramCommentEntry.type != 1)
      {
        if (!paramBoolean) {
          break label210;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount, false);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount, false);
      return;
      localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (((CommentEntry)localIterator.next()).equals(paramCommentEntry)) {
          localIterator.remove();
        }
      }
      this.jdField_d_of_type_JavaUtilHashSet.remove(paramCommentEntry.authorUnionId + paramCommentEntry.fakeId);
      break;
      label210:
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount, false);
    }
  }
  
  public void b(LikeEntry paramLikeEntry, boolean paramBoolean)
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount = a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount = a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount, false);
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      LikeEntry localLikeEntry;
      while (localIterator.hasNext())
      {
        localLikeEntry = (LikeEntry)localIterator.next();
        if (localLikeEntry.unionId.equals(paramLikeEntry.unionId))
        {
          this.jdField_c_of_type_JavaUtilHashSet.remove(localLikeEntry.unionId);
          this.jdField_c_of_type_JavaUtilList.remove(localLikeEntry);
        }
      }
      localIterator = this.jdField_e_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localLikeEntry = (LikeEntry)localIterator.next();
        if (localLikeEntry.unionId.equals(paramLikeEntry.unionId))
        {
          this.jdField_e_of_type_JavaUtilHashSet.remove(localLikeEntry.unionId);
          this.jdField_e_of_type_JavaUtilList.remove(localLikeEntry);
        }
      }
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount = a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount, false);
    }
  }
  
  public void b(List<TagItem.TagInfoBase> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.f.clear();
    }
    this.f.addAll(paramList);
  }
  
  public void b(List<LikeEntry> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    List localList = this.jdField_c_of_type_JavaUtilList;
    HashSet localHashSet = this.jdField_c_of_type_JavaUtilHashSet;
    if (!paramBoolean2)
    {
      localList = this.jdField_e_of_type_JavaUtilList;
      localHashSet = this.jdField_e_of_type_JavaUtilHashSet;
    }
    for (;;)
    {
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
      return;
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount = paramInt;
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount = paramInt;
  }
  
  public boolean b()
  {
    if (!a()) {}
    label105:
    label106:
    for (;;)
    {
      return false;
      if (((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem).mHasPublicVideo) {
        return true;
      }
      int i;
      if (this.jdField_c_of_type_JavaUtilList.size() > 0)
      {
        i = 1;
        if ((i == 0) || (this.jdField_c_of_type_JavaUtilList.size() != 1) || (!QQStoryContext.a().a(((LikeEntry)this.jdField_c_of_type_JavaUtilList.get(0)).unionId))) {
          break label105;
        }
        i = 0;
      }
      for (;;)
      {
        if ((this.jdField_b_of_type_JavaUtilList.size() <= 0) && (i == 0)) {
          break label106;
        }
        return true;
        i = 0;
        break;
      }
    }
  }
  
  public void c(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
      return;
    }
    this.jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem instanceof VideoListFeedItem);
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem instanceof GeneralFeedItem);
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem instanceof GeneralRecommendFeedItem);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem instanceof ShareGroupFeedItem);
  }
  
  public boolean g()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem instanceof BannerFeedItem);
  }
  
  public String toString()
  {
    return "DetailFeedItem{mFeedBasicItem=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem + ", mVideoItemList=" + this.jdField_a_of_type_JavaUtilList.size() + ", mFeedCommentList=" + this.jdField_b_of_type_JavaUtilList.size() + ", mCommentCookie=" + this.jdField_a_of_type_JavaLangString + ", mCommentIsEnd=" + this.jdField_a_of_type_Boolean + ", mLikeEntryList=" + this.jdField_c_of_type_JavaUtilList.size() + ", mFriendCommentList=" + this.jdField_d_of_type_JavaUtilList.size() + ", mFriendCommentCookie=" + this.jdField_b_of_type_JavaLangString + ", mFriendCommentIsEnd=" + this.jdField_b_of_type_Boolean + ", mFriendLikeList=" + this.jdField_e_of_type_JavaUtilList.size() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem
 * JD-Core Version:    0.7.0.1
 */