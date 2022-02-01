package com.tencent.biz.qqstory.storyHome.detail.view;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.comment.FeedCommentDataProvider;
import com.tencent.biz.qqstory.comment.FeedCommentLego;
import com.tencent.biz.qqstory.comment.FeedInfoChangeEvent;
import com.tencent.biz.qqstory.comment.FeedLikeDataProvider;
import com.tencent.biz.qqstory.comment.StoryFailCommentCacher;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TagManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailEventCallback;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller.OnFeedItemPullListener;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper.CommentHelperCallback;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedCommentSync;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class StoryDetailPresenter
  implements DetailEventCallback, DetailFeedAllInfoPuller.OnFeedItemPullListener, DetailCommentHelper.CommentHelperCallback, IEventReceiver
{
  private final int jdField_a_of_type_Int;
  private CommentManager jdField_a_of_type_ComTencentBizQqstoryModelCommentManager;
  private LikeManager jdField_a_of_type_ComTencentBizQqstoryModelLikeManager;
  private CommentListPageLoader jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader;
  private DetailFeedAllInfoPuller jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller;
  private DetailFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem;
  private DetailLikeListLoader jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailLikeListLoader;
  private VideoListPageLoader jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader;
  private final StoryDetailFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment;
  private StoryDetailPresenter.CommentListReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$CommentListReceiver;
  protected StoryDetailPresenter.DetailFeedPushObserver a;
  private StoryDetailPresenter.FeedInfoUpdateReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$FeedInfoUpdateReceiver;
  private StoryDetailPresenter.FeedVideoCookieUpdate jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$FeedVideoCookieUpdate;
  private StoryDetailPresenter.FeedVideoListReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$FeedVideoListReceiver;
  private StoryDetailPresenter.GetFeedFeatureReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$GetFeedFeatureReceiver;
  private StoryDetailPresenter.GetTagInfoListReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$GetTagInfoListReceiver;
  private StoryDetailPresenter.GetUserInfoReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$GetUserInfoReceiver;
  private StoryDetailPresenter.LikeListReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$LikeListReceiver;
  private StoryDetailPresenter.TroopNickNameUpdateEventReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$TroopNickNameUpdateEventReceiver;
  private StoryDetailPresenter.UploadStatusReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$UploadStatusReceiver;
  private StoryDetailPresenter.VideoDeleteReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$VideoDeleteReceiver;
  private StoryDetailPresenter.VideoNoInterestingReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$VideoNoInterestingReceiver;
  private FeedManager jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager;
  private FeedVideoManager jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoManager;
  private final String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final int jdField_b_of_type_Int;
  private CommentListPageLoader jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader;
  private DetailLikeListLoader jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailLikeListLoader;
  private int c = -1;
  
  public StoryDetailPresenter(StoryDetailFragment paramStoryDetailFragment, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment = paramStoryDetailFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$DetailFeedPushObserver = new StoryDetailPresenter.DetailFeedPushObserver(this.jdField_a_of_type_JavaLangString, new StoryDetailPresenter.1(this));
  }
  
  private void a(int paramInt, CommentEntry paramCommentEntry)
  {
    FeedInfoChangeEvent localFeedInfoChangeEvent;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localFeedInfoChangeEvent = new FeedInfoChangeEvent(2, paramCommentEntry.feedId, paramInt);
      localFeedInfoChangeEvent.c = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localFeedInfoChangeEvent;; paramCommentEntry = new FeedInfoChangeEvent(2, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, paramInt, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a))
    {
      paramCommentEntry.a = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a;
      StoryDispatcher.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.b(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a = ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a));
    this.jdField_a_of_type_ComTencentBizQqstoryModelCommentManager.d(paramCommentEntry);
    StoryFailCommentCacher.a().a();
    QQToast.a(BaseApplication.getContext(), 2, HardCodeUtil.a(2131714286), 0).a();
    a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem, a());
    a(2, paramCommentEntry);
  }
  
  private void a(DetailFeedItem paramDetailFeedItem)
  {
    if (paramDetailFeedItem == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramDetailFeedItem.a()) {
          break label39;
        }
        if (!paramDetailFeedItem.b()) {
          break;
        }
      } while (this.c != -1);
      this.c = 1;
      return;
      this.c = 1;
      return;
    } while (this.c == -1);
    this.c = -1;
  }
  
  private void a(String paramString)
  {
    int i = StoryReportor.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner() instanceof ShareGroupItem)) {}
    for (String str = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().getUnionId();; str = "")
    {
      StoryReportor.a("home_page", paramString, StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a), 0, new String[] { String.valueOf(i), StoryReportor.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, str });
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = QQStoryContext.a().b();
    String str = PlayModeUtils.a().getCurrentUin();
    LikeEntry localLikeEntry = new LikeEntry();
    localLikeEntry.likeTime = System.currentTimeMillis();
    localLikeEntry.uin = str;
    localLikeEntry.unionId = ((String)localObject);
    localLikeEntry.feedId = this.jdField_a_of_type_JavaLangString;
    localObject = ((UserManager)SuperManager.a(2)).b((String)localObject);
    long l;
    if (localObject != null)
    {
      if (((QQUserUIItem)localObject).isVip)
      {
        l = 2L;
        localLikeEntry.role = l;
      }
    }
    else
    {
      if (!paramBoolean1) {
        break label260;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.mHadLike = 1;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a);
      this.jdField_a_of_type_ComTencentBizQqstoryModelLikeManager.a(localLikeEntry);
    }
    for (;;)
    {
      SLog.b("Q.qqstory.detail.StoryDetailPresenter", "update like data. mHadLike=%d, mLikeCount=%d, mFanLikeCount=%d, mLikeEntryList=%d, mFriendLikeCount=%d, mFriendLikeList=%d.", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.mHadLike), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.mLikeCount), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.b(true)), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.b(true).size()), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.b(false)), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.b(false).size()) });
      return;
      l = 0L;
      break;
      label260:
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.mHadLike = 0;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.b(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a);
      this.jdField_a_of_type_ComTencentBizQqstoryModelLikeManager.b(localLikeEntry);
    }
  }
  
  private boolean a()
  {
    return (this.c == -1) || (this.c == 2);
  }
  
  private void b(DetailFeedItem paramDetailFeedItem)
  {
    String str1 = "";
    int i;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      i = StoryReportor.a(paramDetailFeedItem.a);
      if (!paramDetailFeedItem.a.getOwner().isMe()) {
        break;
      }
    }
    for (String str2 = "1";; str2 = "2")
    {
      StoryReportor.a("home_page", "exp_detail", i, 0, new String[] { str2, str1, "", paramDetailFeedItem.a.feedId });
      return;
      str1 = "1";
      break;
      str1 = "2";
      break;
      str1 = "3";
      break;
      str1 = "4";
      break;
    }
  }
  
  private static void b(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull String paramString1, String paramString2)
  {
    if (paramStoryDetailPresenter.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem == null) {
      SLog.b(paramString2, "ignore this video delete event. %s.", paramString1);
    }
    for (;;)
    {
      return;
      SLog.a(paramString2, "receive video delete event. %s.", paramString1);
      Iterator localIterator = paramStoryDetailPresenter.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().iterator();
      StoryVideoItem localStoryVideoItem;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localStoryVideoItem = (StoryVideoItem)localIterator.next();
      } while (!localStoryVideoItem.mVid.equals(paramString1));
      paramStoryDetailPresenter.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().remove(localStoryVideoItem);
      SLog.a(paramString2, "video list's size is %d after delete video.", Integer.valueOf(paramStoryDetailPresenter.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().size()));
      if (paramStoryDetailPresenter.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().size() == 0) {
        paramStoryDetailPresenter.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
      }
      while (localStoryVideoItem.mTagInfoBase != null)
      {
        paramStoryDetailPresenter.k();
        return;
        paramStoryDetailPresenter.a();
      }
    }
    SLog.d(paramString2, "can't find the video that should be deleted. video list's size is %d.", new Object[] { Integer.valueOf(paramStoryDetailPresenter.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().size()) });
  }
  
  private void d(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailLikeListLoader != null);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailLikeListLoader = new DetailLikeListLoader(this.jdField_a_of_type_JavaLangString, true);
        return;
      } while (this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailLikeListLoader != null);
      this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailLikeListLoader = new DetailLikeListLoader(this.jdField_a_of_type_JavaLangString, true, 0);
      return;
    } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailLikeListLoader != null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailLikeListLoader = new DetailLikeListLoader(this.jdField_a_of_type_JavaLangString, true, 1);
  }
  
  private void e(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader != null);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader = new CommentListPageLoader(new FeedCommentSync(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(true)), "StoryDetailPresenter");
        return;
      } while (this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader != null);
      this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader = new CommentListPageLoader(new FeedCommentSync(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(false), 0), "StoryDetailPresenter");
      return;
    } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader != null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader = new CommentListPageLoader(new FeedCommentSync(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(true), 1), "StoryDetailPresenter");
  }
  
  private void i()
  {
    if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a())
    {
      d(-1);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailLikeListLoader.a(true);
      return;
    }
    d(1);
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailLikeListLoader.a(true);
    d(2);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailLikeListLoader.a(true);
  }
  
  private void j()
  {
    if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a()) {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(true))
      {
        e(-1);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader.c();
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(false))
      {
        e(1);
        this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader.c();
      }
    } while (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(true));
    e(2);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader.c();
  }
  
  private void k()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      SLog.e("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list error because feedId is null.");
      return;
    }
    SLog.b("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list.");
    TagManager localTagManager = (TagManager)SuperManager.a(27);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_JavaLangString);
    localTagManager.a(localArrayList);
  }
  
  private void l()
  {
    List localList = ((TagManager)SuperManager.a(27)).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.b(localList, true);
    SLog.b("Q.qqstory.detail.StoryDetailPresenter", "after merging tag list from db. mFeedItem.getTagList()=%s", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.b());
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(true));
    }
    if (this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader != null) {
      this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(false));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader != null)
    {
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.c()) {
        SLog.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
      }
    }
    else {
      return;
    }
    FeedVideoInfo localFeedVideoInfo = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getVideoInfo();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader.a(localFeedVideoInfo.mVideoPullType, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mVideoSeq);
  }
  
  public void L_()
  {
    SLog.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page comment.");
    e(this.c);
    if (a()) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader.c();
    }
    for (;;)
    {
      StoryReportor.a("home_page", "load_detail", 0, 0, new String[] { "", StoryReportor.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader.c();
    }
  }
  
  public void M_()
  {
    SLog.b("Q.qqstory.detail.StoryDetailPresenter", "on like button click.");
    if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131714285), 0).a();
      return;
    }
    if (((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner() instanceof ShareGroupItem)) && (!((ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner()).isPublic()) && (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().isSubscribe()))
    {
      QQToast.a(BaseApplication.getContext(), 1, StoryApi.a(2131699769), 0).a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.mHadLike == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = a();
      FeedLikeDataProvider.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a, bool1, -1, 0);
      a(bool1, bool2);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
      a(3, null);
      a("clk_like");
      return;
    }
  }
  
  public void N_()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.e();
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
  }
  
  public void a(int paramInt)
  {
    SLog.a("Q.qqstory.detail.StoryDetailPresenter", "on tab click. tabType = %d.", Integer.valueOf(paramInt));
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem, a());
    if (a()) {}
    for (paramInt = 2;; paramInt = 1)
    {
      StoryReportor.a("content_flow", "clk_detail_reply", 0, paramInt, new String[] { "", StoryReportor.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId });
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    SLog.a("Q.qqstory.detail.StoryDetailPresenter", "on nick click. unionId = %s.", paramString);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity() == null) {
      return;
    }
    StoryApi.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity(), 12, paramString);
    if (paramInt == 1) {}
    for (paramString = "clk_reply_nick";; paramString = "clk_like_name")
    {
      a(paramString);
      return;
    }
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    boolean bool = a();
    if ((!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(bool)) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(bool) == null))
    {
      CommentEntry localCommentEntry = DetailCommentHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(bool) - this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(bool).size());
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.c(localCommentEntry, bool);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(localCommentEntry, bool);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(paramCommentEntry, bool);
    SLog.b("Q.qqstory.detail.StoryDetailPresenter", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.mCommentCount), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.mFanCommentCount), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.mFriendCommentCount));
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131714289), 0).a();
        paramCommentEntry.status = 2;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
      N_();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a = ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a));
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a()) {
        break label269;
      }
      if (!bool) {
        break label256;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label233:
      this.jdField_a_of_type_ComTencentBizQqstoryModelCommentManager.a(paramCommentEntry);
    }
    for (;;)
    {
      if (i == 0) {
        b(paramCommentEntry);
      }
      return;
      i = 0;
      break;
      label256:
      paramCommentEntry.type = 3;
      paramCommentEntry.pbType = 0;
      break label233;
      label269:
      paramCommentEntry.pbType = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getCommentLikeType();
      this.jdField_a_of_type_ComTencentBizQqstoryModelCommentManager.b(paramCommentEntry);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper.a(paramCommentEntry, paramInt, a());
  }
  
  public void a(DetailFeedItem paramDetailFeedItem, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      SLog.e("Q.qqstory.detail.StoryDetailPresenter", "feed data back after activity destroy.");
      return;
    }
    a(paramDetailFeedItem);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem == null) && (paramErrorMessage.isSuccess())) {
      b(paramDetailFeedItem);
    }
    if (paramBoolean)
    {
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem = paramDetailFeedItem;
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem, a());
      }
      a(false);
      bool = paramErrorMessage.isSuccess();
      if (!paramErrorMessage.isSuccess()) {
        break label267;
      }
    }
    label267:
    for (paramDetailFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.toString();; paramDetailFeedItem = "null")
    {
      SLog.a("Q.qqstory.detail.StoryDetailPresenter", "on feed data back. result=%s, isLocal = %s, data = %s.", Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramDetailFeedItem);
      return;
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem = paramDetailFeedItem;
        l();
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.d()) && (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().mIsVideoEnd)) {
          k();
        }
        m();
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem, a());
      }
      for (;;)
      {
        if ((paramErrorMessage.isSuccess()) || (paramErrorMessage.errorCode == 2222)) {
          bool = true;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(bool, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramDetailFeedItem, a()));
        break;
        if (paramErrorMessage.errorCode == 2222) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
        } else if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem == null) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller.a();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller.b();
  }
  
  public void b()
  {
    SLog.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page video.");
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader == null)
    {
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.c())
      {
        SLog.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader = new VideoListPageLoader(2, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getVideoInfo());
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader.b("StoryDetailPresenter");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader.c();
  }
  
  public void b(int paramInt)
  {
    boolean bool = a();
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(bool).get(paramInt);
    if (localCommentEntry.status != 0)
    {
      a(localCommentEntry, bool);
      return;
    }
    if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131714288), 0).a();
      SLog.d("Q.qqstory.detail.StoryDetailPresenter", "delete comment failed. invalidate network.");
      return;
    }
    localCommentEntry.status = 1;
    FeedCommentDataProvider.a(localCommentEntry, new StoryDetailPresenter.3(this, localCommentEntry, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    FeedCommentLego.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a, paramCommentEntry, false, this.jdField_a_of_type_Int, new StoryDetailPresenter.2(this));
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a != null)) {
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().isMe()) {
        break label95;
      }
    }
    label95:
    for (String str = "2";; str = "1")
    {
      StoryReportor.a("home_page", "press_reply", 0, 0, new String[] { str, StoryReportor.a(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper.b(paramCommentEntry, paramInt, a());
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramBoolean, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem, a()));
  }
  
  public void c()
  {
    LoadingMoreHelper localLoadingMoreHelper = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localLoadingMoreHelper != null) {
      localLoadingMoreHelper.a(false);
    }
  }
  
  public void c(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 1) && (paramInt != -1))
    {
      SLog.e("Q.qqstory.detail.StoryDetailPresenter", "set tab type failed. invalidate type : %d.", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    SLog.a("Q.qqstory.detail.StoryDetailPresenter", "set tab type to %d.", Integer.valueOf(paramInt));
    this.c = paramInt;
  }
  
  public void d()
  {
    LoadingMoreHelper localLoadingMoreHelper = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localLoadingMoreHelper != null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(a())) {
        localLoadingMoreHelper.a(false);
      }
    }
    else {
      return;
    }
    localLoadingMoreHelper.a(true);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$FeedVideoListReceiver = new StoryDetailPresenter.FeedVideoListReceiver(this);
    StoryDispatcher.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$FeedVideoListReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$LikeListReceiver = new StoryDetailPresenter.LikeListReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$LikeListReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$CommentListReceiver = new StoryDetailPresenter.CommentListReceiver(this);
    StoryDispatcher.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$CommentListReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$FeedInfoUpdateReceiver = new StoryDetailPresenter.FeedInfoUpdateReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$FeedInfoUpdateReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$UploadStatusReceiver = new StoryDetailPresenter.UploadStatusReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$UploadStatusReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$VideoDeleteReceiver = new StoryDetailPresenter.VideoDeleteReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$VideoDeleteReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$VideoNoInterestingReceiver = new StoryDetailPresenter.VideoNoInterestingReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$VideoNoInterestingReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$GetFeedFeatureReceiver = new StoryDetailPresenter.GetFeedFeatureReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$GetFeedFeatureReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$FeedVideoCookieUpdate = new StoryDetailPresenter.FeedVideoCookieUpdate(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$FeedVideoCookieUpdate);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$GetUserInfoReceiver = new StoryDetailPresenter.GetUserInfoReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$GetUserInfoReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$TroopNickNameUpdateEventReceiver = new StoryDetailPresenter.TroopNickNameUpdateEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$TroopNickNameUpdateEventReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$GetTagInfoListReceiver = new StoryDetailPresenter.GetTagInfoListReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$GetTagInfoListReceiver);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$DetailFeedPushObserver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller = new DetailFeedAllInfoPuller(this.jdField_a_of_type_JavaLangString, this, true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager = ((FeedManager)SuperManager.a(11));
    this.jdField_a_of_type_ComTencentBizQqstoryModelLikeManager = ((LikeManager)SuperManager.a(15));
    this.jdField_a_of_type_ComTencentBizQqstoryModelCommentManager = ((CommentManager)SuperManager.a(17));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoManager = ((FeedVideoManager)SuperManager.a(12));
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper.a();
  }
  
  public void g()
  {
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$FeedVideoListReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$LikeListReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$CommentListReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$FeedInfoUpdateReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$UploadStatusReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$VideoDeleteReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$VideoNoInterestingReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$GetFeedFeatureReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$FeedVideoCookieUpdate);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$GetUserInfoReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$TroopNickNameUpdateEventReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$GetTagInfoListReceiver);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$DetailFeedPushObserver);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailLikeListLoader = null;
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailLikeListLoader = null;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller.c();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader.d();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader.d();
    }
    if (this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader != null) {
      this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader.d();
    }
  }
  
  public void h()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      GetFeedFeatureHandler.a(Collections.singletonList(this.jdField_a_of_type_JavaLangString));
    }
  }
  
  public void h_(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramInt);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter
 * JD-Core Version:    0.7.0.1
 */