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
    int i = 1;
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
      i = -1;
    }
    return i;
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
    Object localObject = this.jdField_b_of_type_JavaUtilList.iterator();
    CommentEntry localCommentEntry;
    StringBuilder localStringBuilder;
    while (((Iterator)localObject).hasNext())
    {
      localCommentEntry = (CommentEntry)((Iterator)localObject).next();
      if (localCommentEntry.commentId == paramInt)
      {
        localObject = this.jdField_b_of_type_JavaUtilHashSet;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localCommentEntry.authorUnionId);
        localStringBuilder.append(localCommentEntry.fakeId);
        ((HashSet)localObject).remove(localStringBuilder.toString());
        this.jdField_b_of_type_JavaUtilList.remove(localCommentEntry);
      }
    }
    localObject = this.jdField_d_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localCommentEntry = (CommentEntry)((Iterator)localObject).next();
      if (localCommentEntry.commentId == paramInt)
      {
        localObject = this.jdField_d_of_type_JavaUtilHashSet;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localCommentEntry.authorUnionId);
        localStringBuilder.append(localCommentEntry.fakeId);
        ((HashSet)localObject).remove(localStringBuilder.toString());
        this.jdField_d_of_type_JavaUtilList.remove(localCommentEntry);
      }
    }
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    HashSet localHashSet;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      this.jdField_b_of_type_JavaUtilList.add(paramCommentEntry);
      localHashSet = this.jdField_b_of_type_JavaUtilHashSet;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramCommentEntry.authorUnionId);
      localStringBuilder.append(paramCommentEntry.fakeId);
      localHashSet.add(localStringBuilder.toString());
    }
    else
    {
      this.jdField_d_of_type_JavaUtilList.add(paramCommentEntry);
      localHashSet = this.jdField_d_of_type_JavaUtilHashSet;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramCommentEntry.authorUnionId);
      localStringBuilder.append(paramCommentEntry.fakeId);
      localHashSet.add(localStringBuilder.toString());
    }
    if (paramCommentEntry.type != 1)
    {
      if (paramBoolean)
      {
        paramCommentEntry = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
        paramCommentEntry.mFanCommentCount = a(paramCommentEntry.mFanCommentCount, true);
      }
      else
      {
        paramCommentEntry = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
        paramCommentEntry.mFriendCommentCount = a(paramCommentEntry.mFriendCommentCount, true);
      }
      paramCommentEntry = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
      paramCommentEntry.mCommentCount = a(paramCommentEntry.mCommentCount, true);
    }
  }
  
  public void a(LikeEntry paramLikeEntry, boolean paramBoolean)
  {
    if (a())
    {
      localCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
      localCommentLikeFeedItem.mFriendLikeCount = a(localCommentLikeFeedItem.mFriendLikeCount, true);
    }
    else
    {
      localCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
      localCommentLikeFeedItem.mFanLikeCount = a(localCommentLikeFeedItem.mFanLikeCount, true);
    }
    CommentLikeFeedItem localCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    localCommentLikeFeedItem.mLikeCount = a(localCommentLikeFeedItem.mLikeCount, true);
    this.jdField_c_of_type_JavaUtilList.add(paramLikeEntry);
    this.jdField_c_of_type_JavaUtilHashSet.add(paramLikeEntry.unionId);
    this.jdField_e_of_type_JavaUtilList.add(paramLikeEntry);
    this.jdField_e_of_type_JavaUtilHashSet.add(paramLikeEntry.unionId);
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
    } else {
      this.jdField_a_of_type_JavaUtilList.add(paramInt, paramStoryVideoItem);
    }
    this.jdField_a_of_type_JavaUtilHashSet.add(paramStoryVideoItem.mVid);
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
    CommentLikeFeedItem localCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    if (localCommentLikeFeedItem != null)
    {
      if (localCommentLikeFeedItem.getOwner() == null) {
        return false;
      }
      localCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
      if (!(localCommentLikeFeedItem instanceof VideoListFeedItem)) {
        return false;
      }
      return localCommentLikeFeedItem.getOwner().isMe();
    }
    return false;
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
    Object localObject;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      localObject = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((CommentEntry)((Iterator)localObject).next()).equals(paramCommentEntry)) {
          ((Iterator)localObject).remove();
        }
      }
      localObject = this.jdField_b_of_type_JavaUtilHashSet;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramCommentEntry.authorUnionId);
      localStringBuilder.append(paramCommentEntry.fakeId);
      ((HashSet)localObject).remove(localStringBuilder.toString());
    }
    else
    {
      localObject = this.jdField_d_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((CommentEntry)((Iterator)localObject).next()).equals(paramCommentEntry)) {
          ((Iterator)localObject).remove();
        }
      }
      localObject = this.jdField_d_of_type_JavaUtilHashSet;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramCommentEntry.authorUnionId);
      localStringBuilder.append(paramCommentEntry.fakeId);
      ((HashSet)localObject).remove(localStringBuilder.toString());
    }
    if (paramCommentEntry.type != 1)
    {
      if (paramBoolean)
      {
        paramCommentEntry = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
        paramCommentEntry.mFanCommentCount = a(paramCommentEntry.mFanCommentCount, false);
      }
      else
      {
        paramCommentEntry = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
        paramCommentEntry.mFriendCommentCount = a(paramCommentEntry.mFriendCommentCount, false);
      }
      paramCommentEntry = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
      paramCommentEntry.mCommentCount = a(paramCommentEntry.mCommentCount, false);
    }
  }
  
  public void b(LikeEntry paramLikeEntry, boolean paramBoolean)
  {
    if (a())
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
      ((CommentLikeFeedItem)localObject).mFriendLikeCount = a(((CommentLikeFeedItem)localObject).mFriendLikeCount, false);
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
      ((CommentLikeFeedItem)localObject).mFanLikeCount = a(((CommentLikeFeedItem)localObject).mFanLikeCount, false);
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    ((CommentLikeFeedItem)localObject).mLikeCount = a(((CommentLikeFeedItem)localObject).mLikeCount, false);
    localObject = this.jdField_c_of_type_JavaUtilList.iterator();
    LikeEntry localLikeEntry;
    while (((Iterator)localObject).hasNext())
    {
      localLikeEntry = (LikeEntry)((Iterator)localObject).next();
      if (localLikeEntry.unionId.equals(paramLikeEntry.unionId))
      {
        this.jdField_c_of_type_JavaUtilHashSet.remove(localLikeEntry.unionId);
        this.jdField_c_of_type_JavaUtilList.remove(localLikeEntry);
      }
    }
    localObject = this.jdField_e_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localLikeEntry = (LikeEntry)((Iterator)localObject).next();
      if (localLikeEntry.unionId.equals(paramLikeEntry.unionId))
      {
        this.jdField_e_of_type_JavaUtilHashSet.remove(localLikeEntry.unionId);
        this.jdField_e_of_type_JavaUtilList.remove(localLikeEntry);
      }
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
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount = paramInt;
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount = paramInt;
  }
  
  public boolean b()
  {
    boolean bool2 = a();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem).mHasPublicVideo) {
      return true;
    }
    int i;
    if (this.jdField_c_of_type_JavaUtilList.size() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j = i;
    if (i != 0)
    {
      j = i;
      if (this.jdField_c_of_type_JavaUtilList.size() == 1)
      {
        j = i;
        if (QQStoryContext.a().a(((LikeEntry)this.jdField_c_of_type_JavaUtilList.get(0)).unionId)) {
          j = 0;
        }
      }
    }
    if ((this.jdField_b_of_type_JavaUtilList.size() > 0) || (j != 0)) {
      bool1 = true;
    }
    return bool1;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DetailFeedItem{mFeedBasicItem=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    localStringBuilder.append(", mVideoItemList=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
    localStringBuilder.append(", mFeedCommentList=");
    localStringBuilder.append(this.jdField_b_of_type_JavaUtilList.size());
    localStringBuilder.append(", mCommentCookie=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", mCommentIsEnd=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", mLikeEntryList=");
    localStringBuilder.append(this.jdField_c_of_type_JavaUtilList.size());
    localStringBuilder.append(", mFriendCommentList=");
    localStringBuilder.append(this.jdField_d_of_type_JavaUtilList.size());
    localStringBuilder.append(", mFriendCommentCookie=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", mFriendCommentIsEnd=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", mFriendLikeList=");
    localStringBuilder.append(this.jdField_e_of_type_JavaUtilList.size());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem
 * JD-Core Version:    0.7.0.1
 */