package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.boundaries.StoryDepends.ShortVideoMultiSender;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.comment.FeedInfoChangeEvent;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TagManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoSpreadGroupList;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.network.request.BatchGetFeedCommentRequest;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesFeedListPageLoader;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.troop.model.TroopAssistantFeedListPageLoader;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.biz.qqstory.model.item.StoryVideoItem;>;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class HomeFeedPresenter
  implements FeedListPageLoaderBase.OnFeedItemPageLoadListener<HomeFeedData>, IEventReceiver
{
  private int a;
  private ArrayList<StoryHomeFeed> b = new ArrayList();
  protected AtomicBoolean c = new AtomicBoolean(false);
  private boolean d = true;
  private FeedListPageLoaderBase e;
  private HomeFeedPresenter.HomeFeedPresenterListener f;
  private HomeFeedPresenter.UploadStatusRec g;
  private HomeFeedPresenter.FeedCommentRec h;
  private HomeFeedPresenter.LikeListReceiver i;
  private HomeFeedPresenter.FeedVideoRec j;
  private HomeFeedPresenter.FeedVideoCookieRec k;
  private HomeFeedPresenter.FeedInteractiveRec l;
  private HomeFeedPresenter.VideoDeleteRec m;
  private HomeFeedPresenter.VideoNoInterestingRec n;
  private HomeFeedPresenter.OneFeedInfoUpdateRec o;
  private HomeFeedPresenter.OnTagListUpdateRec p;
  private HomeFeedPresenter.SendVidPollDataResultReceiver q;
  private HomeFeedPresenter.SendVidRateDataResultReceiver r;
  private HomeFeedPresenter.GamePKCommentReceiver s;
  private final Object t = new Object();
  private List<StoryVideoItem> u;
  private final QQStoryObserver v = new HomeFeedPresenter.6(this);
  
  public HomeFeedPresenter(int paramInt, @NonNull HomeFeedPresenter.HomeFeedPresenterListener paramHomeFeedPresenterListener, boolean paramBoolean)
  {
    this.a = paramInt;
    this.f = paramHomeFeedPresenterListener;
    AssertUtils.checkNotNull(this.f);
    paramInt = this.a;
    if ((paramInt != 10) && (paramInt != 11) && (paramInt != 12)) {
      AssertUtils.fail("feed type error for:%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  private GeneralHomeFeed a(List<StoryHomeFeed> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (StoryHomeFeed)paramList.next();
      if ((localObject instanceof GeneralHomeFeed))
      {
        localObject = (GeneralHomeFeed)localObject;
        if ((((GeneralFeedItem)((GeneralHomeFeed)localObject).f).isMyFeedItem()) && (TextUtils.equals(paramString, ((GeneralFeedItem)((GeneralHomeFeed)localObject).f).date)))
        {
          SLog.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private VideoListHomeFeed a(List<StoryHomeFeed> paramList, String paramString1, String paramString2)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (StoryHomeFeed)paramList.next();
      if ((localObject instanceof ShareGroupHomeFeed))
      {
        localObject = (VideoListHomeFeed)localObject;
        IFeedOwner localIFeedOwner = ((VideoListHomeFeed)localObject).f.getOwner();
        if ((localIFeedOwner != null) && (TextUtils.equals(paramString1, localIFeedOwner.getUnionId())) && (TextUtils.equals(paramString2, ((VideoListHomeFeed)localObject).f.date)))
        {
          SLog.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  public static String a(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<StoryHomeFeed> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (StoryHomeFeed)paramList.next();
      if ((localObject instanceof GeneralHomeFeed))
      {
        localObject = (GeneralHomeFeed)localObject;
        if (((GeneralFeedItem)((GeneralHomeFeed)localObject).f).isMyFeedItem()) {
          return b(paramStoryVideoItem, ((GeneralHomeFeed)localObject).a());
        }
      }
    }
    return null;
  }
  
  private void a(HomeFeedData paramHomeFeedData, List<StoryVideoItem> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    if (((UserManager)SuperManager.a(2)).c() == null) {
      return;
    }
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator1.next();
      Object localObject;
      if (localStoryVideoItem.isLocalAddShareGroupVideo())
      {
        if (!d(localStoryVideoItem.shareGroupId))
        {
          SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.a), localStoryVideoItem.shareGroupId });
        }
        else
        {
          localObject = a(paramHomeFeedData.f, localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
          paramList = (List<StoryVideoItem>)localObject;
          if (localObject == null)
          {
            paramList = FeedManager.c(localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
            if (paramList != null)
            {
              paramList = new ShareGroupHomeFeed(paramList);
              paramHomeFeedData.f.add(0, paramList);
              SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
            }
          }
          else
          {
            paramList.a(localStoryVideoItem, true);
          }
        }
      }
      else if (StoryVideoTaskInfo.b(localStoryVideoItem.mVid) != null)
      {
        paramList = localStoryVideoItem.mVideoSpreadGroupList;
        if ((paramList != null) && (paramList.d != null))
        {
          Iterator localIterator2 = paramList.d.iterator();
          while (localIterator2.hasNext())
          {
            String str = (String)localIterator2.next();
            if (!d(str))
            {
              SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.a), str });
            }
            else
            {
              localObject = a(paramHomeFeedData.f, str, localStoryVideoItem.mPublishDate);
              paramList = (List<StoryVideoItem>)localObject;
              if (localObject == null)
              {
                paramList = new ShareGroupHomeFeed(FeedManager.c(str, localStoryVideoItem.mPublishDate));
                paramHomeFeedData.f.add(0, paramList);
                SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
              }
              paramList.a(localStoryVideoItem, true);
            }
          }
        }
        paramList = a(localStoryVideoItem, paramHomeFeedData.f);
        if (paramList != null)
        {
          ((StoryManager)SuperManager.a(5)).j(localStoryVideoItem.mVid);
          SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { localStoryVideoItem.mVid, paramList });
        }
        else
        {
          a(localStoryVideoItem);
          localObject = a(paramHomeFeedData.f, localStoryVideoItem.mPublishDate);
          paramList = (List<StoryVideoItem>)localObject;
          if (localObject == null)
          {
            paramList = FeedManager.e(QQStoryContext.a().i(), localStoryVideoItem.mPublishDate);
            if (paramList != null)
            {
              paramList = new GeneralHomeFeed(paramList);
              paramHomeFeedData.f.add(0, paramList);
              SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
            }
            else
            {
              SLog.e("Q.qqstory.home.data.HomeFeedPresenter", "we found the union id = %s and get null generalFeed", new Object[] { QQStoryContext.a().i() });
              paramList = (List<StoryVideoItem>)localObject;
            }
          }
          paramList.a(localStoryVideoItem, true);
        }
      }
    }
    if (QLog.isDebugVersion()) {
      SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", paramHomeFeedData.f);
    }
    Collections.sort(paramHomeFeedData.f, GeneralHomeFeed.l);
    if (QLog.isDebugVersion()) {
      SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", paramHomeFeedData.f);
    }
  }
  
  private void a(ArrayList<StoryHomeFeed> paramArrayList)
  {
    Bosses.get().postLightWeightJob(new HomeFeedPresenter.3(this, paramArrayList), 10);
  }
  
  public static boolean a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    if (!TextUtils.isEmpty(paramStoryVideoItem.mLocalSpecialItemId)) {
      if (paramStoryVideoItem.mUploadStatus == 4)
      {
        if (Math.abs(paramStoryVideoItem.mCreateTime - NetConnInfoCenter.getServerTimeMillis()) > 600000L)
        {
          paramStoryVideoItem.mUploadStatus = 6;
          paramStoryVideoItem.copy(((StoryManager)SuperManager.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
          SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s createTime=%d is marked as SUBMIT FAIL", new Object[] { paramStoryVideoItem.mVid, Long.valueOf(paramStoryVideoItem.mCreateTime) });
          return false;
        }
      }
      else if ((paramStoryVideoItem.mUploadStatus == 1) && (!StoryDepends.ShortVideoMultiSender.a(paramStoryVideoItem.mVid)))
      {
        paramStoryVideoItem.mUploadStatus = 3;
        paramStoryVideoItem.copy(((StoryManager)SuperManager.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
        SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s is marked as UPLOAD FAIL", new Object[] { paramStoryVideoItem.mVid });
        return true;
      }
    }
    return false;
  }
  
  public static String b(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<StoryVideoItem> paramList)
  {
    if (!TextUtils.isEmpty(paramStoryVideoItem.mLocalSpecialItemId))
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
        if (TextUtils.equals(localStoryVideoItem.mLocalSpecialItemId, paramStoryVideoItem.mLocalSpecialItemId))
        {
          SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "FIND !! matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
          return localStoryVideoItem.mVid;
        }
      }
    }
    return null;
  }
  
  private static void b(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry)
  {
    FeedInfoChangeEvent localFeedInfoChangeEvent = new FeedInfoChangeEvent(0, paramCommentEntry.feedId, 1);
    localFeedInfoChangeEvent.e = paramCommentEntry.commentId;
    localFeedInfoChangeEvent.c = paramCommentLikeFeedItem;
    StoryDispatcher.a().dispatch(localFeedInfoChangeEvent);
    SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "notifyFeedInfoChange. event = %s, mCommentCount = %d, mFanCommentCount = %d, mFriendCommentCount = %d.", localFeedInfoChangeEvent, Integer.valueOf(localFeedInfoChangeEvent.c.mCommentCount), Integer.valueOf(localFeedInfoChangeEvent.c.mFanCommentCount), Integer.valueOf(localFeedInfoChangeEvent.c.mFriendCommentCount));
  }
  
  private void b(HomeFeedData paramHomeFeedData)
  {
    if ((!paramHomeFeedData.b) && ((!paramHomeFeedData.c) || (!paramHomeFeedData.g.isSuccess()))) {
      return;
    }
    List localList = ((StoryManager)SuperManager.a(5)).a(true);
    if (localList.size() == 0) {
      return;
    }
    a(paramHomeFeedData, localList);
  }
  
  private static boolean b(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    boolean bool3 = paramCommentLikeFeedItem instanceof VideoListFeedItem;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramCommentLikeFeedItem = (VideoListFeedItem)paramCommentLikeFeedItem;
      bool1 = bool2;
      if (paramCommentLikeFeedItem.getOwner().isMe())
      {
        bool1 = bool2;
        if (paramCommentLikeFeedItem.mHasPublicVideo) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void c(HomeFeedData paramHomeFeedData)
  {
    if (!paramHomeFeedData.g.isSuccess()) {
      return;
    }
    ??? = paramHomeFeedData.f.iterator();
    Object localObject2;
    while (((Iterator)???).hasNext())
    {
      localObject2 = (StoryHomeFeed)((Iterator)???).next();
      if (((localObject2 instanceof VideoListHomeFeed)) && (((VideoListHomeFeed)localObject2).a().size() == 0)) {
        ((Iterator)???).remove();
      }
    }
    synchronized (this.t)
    {
      if (paramHomeFeedData.c) {
        this.u = ((StoryManager)SuperManager.a(5)).a(true);
      }
      if ((this.u != null) && (!this.u.isEmpty()))
      {
        localObject2 = new ArrayList(0);
        boolean bool = paramHomeFeedData.a;
        long l1 = 0L;
        if ((!bool) && (paramHomeFeedData.f.size() > 0)) {
          l1 = ((StoryHomeFeed)paramHomeFeedData.f.get(paramHomeFeedData.f.size() - 1)).g().dateTimeMillis;
        }
        Iterator localIterator = this.u.iterator();
        for (;;)
        {
          bool = localIterator.hasNext();
          if (!bool) {
            break;
          }
          try
          {
            StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator.next();
            if (FeedManager.h().parse(localStoryVideoItem.mPublishDate).getTime() >= l1)
            {
              ((ArrayList)localObject2).add(localStoryVideoItem);
              localIterator.remove();
            }
          }
          catch (ParseException localParseException)
          {
            localParseException.printStackTrace();
          }
        }
        a(paramHomeFeedData, (List)localObject2);
        return;
      }
      return;
    }
    for (;;)
    {
      throw paramHomeFeedData;
    }
  }
  
  private static void c(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull String paramString)
  {
    Object localObject2 = paramHomeFeedPresenter.i().iterator();
    int i1 = -1;
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject1 = (StoryHomeFeed)((Iterator)localObject2).next();
      int i2 = i1 + 1;
      if (!(localObject1 instanceof VideoListHomeFeed))
      {
        i1 = i2;
      }
      else
      {
        localObject1 = (VideoListHomeFeed)localObject1;
        Iterator localIterator = ((VideoListHomeFeed)localObject1).a().iterator();
        StoryVideoItem localStoryVideoItem;
        do
        {
          i1 = i2;
          if (!localIterator.hasNext()) {
            break;
          }
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
        } while (!localStoryVideoItem.mVid.equals(paramString));
        ((VideoListHomeFeed)localObject1).a(localStoryVideoItem);
        paramString = (FeedVideoManager)SuperManager.a(12);
        localObject2 = paramString.a(((VideoListFeedItem)((VideoListHomeFeed)localObject1).f).feedId, ((VideoListFeedItem)((VideoListHomeFeed)localObject1).f).mVideoPullType);
        if (localObject2 != null)
        {
          ((FeedVideoInfo)localObject2).mVideoItemList.clear();
          ((FeedVideoInfo)localObject2).mVideoItemList.addAll(((VideoListHomeFeed)localObject1).a());
          paramString.a(0, (FeedVideoInfo)localObject2, true);
        }
        if (((VideoListHomeFeed)localObject1).a().size() == 0)
        {
          paramHomeFeedPresenter.b.remove(i2);
          FeedManager.f(((VideoListFeedItem)((VideoListHomeFeed)localObject1).f).feedId);
          paramHomeFeedPresenter.f.b(((VideoListFeedItem)((VideoListHomeFeed)localObject1).f).feedId);
        }
        else
        {
          paramHomeFeedPresenter.f.a((VideoListHomeFeed)localObject1);
        }
        paramString.a((FeedVideoInfo)localObject2);
        if (localStoryVideoItem.mTagInfoBase != null)
        {
          paramHomeFeedPresenter = (TagManager)SuperManager.a(27);
          paramString = new ArrayList();
          paramString.add(((VideoListHomeFeed)localObject1).i().feedId);
          paramHomeFeedPresenter.a(paramString);
          SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "delete video ,update tag list :%s", new Object[] { ((VideoListHomeFeed)localObject1).i().feedId });
        }
        if ((localStoryVideoItem.isPollVideo()) || (localStoryVideoItem.isInteractVideo()))
        {
          SLog.b("Q.qqstory.home.data.HomeFeedPresenter", "delete interact video, refresh comment.");
          ThreadManager.getUIHandler().postDelayed(new HomeFeedPresenter.4((VideoListHomeFeed)localObject1), 2000L);
        }
      }
    }
  }
  
  private static void c(VideoListHomeFeed paramVideoListHomeFeed)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(paramVideoListHomeFeed.f.feedId);
    localObject = new BatchGetFeedCommentRequest((List)localObject, true);
    CmdTaskManger.a().a((NetworkRequest)localObject, new HomeFeedPresenter.5(paramVideoListHomeFeed));
  }
  
  private boolean c()
  {
    return this.a != 11;
  }
  
  private void d(HomeFeedData paramHomeFeedData)
  {
    TagManager localTagManager = (TagManager)SuperManager.a(27);
    paramHomeFeedData = paramHomeFeedData.f;
    if (paramHomeFeedData != null)
    {
      paramHomeFeedData = paramHomeFeedData.iterator();
      while (paramHomeFeedData.hasNext())
      {
        Object localObject = (StoryHomeFeed)paramHomeFeedData.next();
        if ((localObject instanceof VideoListHomeFeed))
        {
          localObject = (VideoListHomeFeed)localObject;
          ((VideoListHomeFeed)localObject).j = localTagManager.a(((VideoListHomeFeed)localObject).i().feedId, ((VideoListHomeFeed)localObject).a());
          SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "update tag list , feed id = %s , tag size = %d", ((VideoListHomeFeed)localObject).i().feedId, Integer.valueOf(((VideoListHomeFeed)localObject).j.size()));
        }
      }
    }
  }
  
  private boolean d(String paramString)
  {
    if (this.a != 12)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      boolean bool = ShareGroupManager.b(((ShareGroupManager)SuperManager.a(7)).a(paramString));
      if ((this.a == 11) && (!bool))
      {
        SLog.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore share group item in troop assistant list");
        return false;
      }
      if ((this.a != 11) && (bool))
      {
        SLog.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore troop assistant only share group item not in troop assistant list");
        return false;
      }
      return true;
    }
    return false;
  }
  
  private void e(HomeFeedData paramHomeFeedData)
  {
    Object localObject = paramHomeFeedData.f;
    if (localObject == null) {
      return;
    }
    paramHomeFeedData = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)((Iterator)localObject).next();
      if (((localStoryHomeFeed instanceof GeneralHomeFeed)) && (!((GeneralFeedItem)localStoryHomeFeed.g()).mIsVideoEnd)) {
        paramHomeFeedData.add(localStoryHomeFeed.g().feedId);
      }
    }
    ((TagManager)SuperManager.a(27)).a(paramHomeFeedData);
  }
  
  public StoryHomeFeed a(String paramString)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)localIterator.next();
      if (localStoryHomeFeed.f.feedId.equals(paramString)) {
        return localStoryHomeFeed;
      }
    }
    return null;
  }
  
  public void a()
  {
    SLog.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter create");
    int i1 = this.a;
    if (i1 == 10) {
      this.e = new HomeFeedListPageLoader(this);
    } else if (i1 == 11) {
      this.e = new TroopAssistantFeedListPageLoader(this);
    } else if (i1 == 12) {
      this.e = new MemoriesFeedListPageLoader(this);
    }
    this.g = new HomeFeedPresenter.UploadStatusRec(this);
    StoryDispatcher.a().registerSubscriber(this.g);
    this.h = new HomeFeedPresenter.FeedCommentRec(this);
    StoryDispatcher.a().registerSubscriber(this.h);
    this.i = new HomeFeedPresenter.LikeListReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.i);
    this.j = new HomeFeedPresenter.FeedVideoRec(this);
    StoryDispatcher.a().registerSubscriber("HomeFeedPresenter", this.j);
    this.k = new HomeFeedPresenter.FeedVideoCookieRec(this);
    StoryDispatcher.a().registerSubscriber(this.k);
    this.l = new HomeFeedPresenter.FeedInteractiveRec(this);
    StoryDispatcher.a().registerSubscriber(this.l);
    this.m = new HomeFeedPresenter.VideoDeleteRec(this);
    StoryDispatcher.a().registerSubscriber(this.m);
    this.n = new HomeFeedPresenter.VideoNoInterestingRec(this);
    StoryDispatcher.a().registerSubscriber(this.n);
    this.o = new HomeFeedPresenter.OneFeedInfoUpdateRec(this);
    StoryDispatcher.a().registerSubscriber(this.o);
    this.q = new HomeFeedPresenter.SendVidPollDataResultReceiver(this, this);
    StoryDispatcher.a().registerSubscriber(this.q);
    this.r = new HomeFeedPresenter.SendVidRateDataResultReceiver(this, this);
    StoryDispatcher.a().registerSubscriber(this.r);
    this.p = new HomeFeedPresenter.OnTagListUpdateRec(this);
    StoryDispatcher.a().registerSubscriber(this.p);
    this.s = new HomeFeedPresenter.GamePKCommentReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.s);
    QQStoryContext.a();
    QQStoryContext.j().addObserver(this.v);
  }
  
  public void a(HomeFeedData paramHomeFeedData)
  {
    c(paramHomeFeedData);
    d(paramHomeFeedData);
    SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "on feed back:%s", new Object[] { paramHomeFeedData.b() });
    e(paramHomeFeedData);
    a(new ArrayList(paramHomeFeedData.f));
    ThreadManager.getUIHandler().post(new HomeFeedPresenter.2(this, paramHomeFeedData));
  }
  
  public void a(List<StoryHomeFeed> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)paramList.next();
      if (localHashSet.contains(localStoryHomeFeed.f.feedId))
      {
        paramList.remove();
        SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "have repeat feed %s", new Object[] { localStoryHomeFeed });
      }
      else
      {
        localHashSet.add(localStoryHomeFeed.f.feedId);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramBoolean)
    {
      FeedManager localFeedManager = (FeedManager)SuperManager.a(11);
      FeedListPageLoaderBase.FeedIdListCache localFeedIdListCache = localFeedManager.d;
      ArrayList localArrayList = localFeedManager.e;
      if ((this.a == 10) && (localArrayList != null) && (localArrayList.size() > 0) && (localFeedIdListCache != null))
      {
        localObject = new HomeFeedData(new ErrorMessage());
        ((HomeFeedData)localObject).f = localArrayList;
        paramBoolean = localFeedManager.f;
        this.d = paramBoolean;
        ((HomeFeedData)localObject).a = paramBoolean;
        ((HomeFeedData)localObject).b = true;
        ((HomeFeedData)localObject).h = true;
        this.e.b(localFeedIdListCache);
        SLog.d("Q.qqstory.home.position", "#use memory cache data size:", new Object[] { Integer.valueOf(((HomeFeedData)localObject).f.size()) });
      }
      else
      {
        localObject = (HomeFeedData)this.e.h();
        this.d = ((HomeFeedData)localObject).a;
        b((HomeFeedData)localObject);
        d((HomeFeedData)localObject);
      }
      a(new ArrayList(((HomeFeedData)localObject).f));
      this.b.clear();
      this.b.addAll(((HomeFeedData)localObject).f);
      long l2 = System.currentTimeMillis();
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "cache data size %d, take time:%d", new Object[] { Integer.valueOf(((HomeFeedData)localObject).f.size()), Long.valueOf(l2 - l1) });
      return;
    }
    Object localObject = (LbsManager)SuperManager.a(9);
    ((LbsManager)localObject).a(new HomeFeedPresenter.1(this, (LbsManager)localObject));
    ((LbsManager)localObject).a(1000);
    SLog.b("Q.qqstory.home.data.HomeFeedPresenter", "refresh network feed");
  }
  
  public boolean a(VideoListHomeFeed paramVideoListHomeFeed)
  {
    FeedVideoInfo localFeedVideoInfo = paramVideoListHomeFeed.i().getVideoInfo();
    VideoListPageLoader localVideoListPageLoader = new VideoListPageLoader(0, localFeedVideoInfo);
    localVideoListPageLoader.b("HomeFeedPresenter");
    localVideoListPageLoader.c();
    SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "load next page for %s, info:%s", paramVideoListHomeFeed.f.feedId, localFeedVideoInfo);
    return true;
  }
  
  public void b()
  {
    this.c.set(true);
    StoryDispatcher.a().unRegisterSubscriber(this.g);
    StoryDispatcher.a().unRegisterSubscriber(this.h);
    StoryDispatcher.a().unRegisterSubscriber(this.i);
    StoryDispatcher.a().unRegisterSubscriber(this.j);
    StoryDispatcher.a().unRegisterSubscriber(this.k);
    StoryDispatcher.a().unRegisterSubscriber(this.l);
    StoryDispatcher.a().unRegisterSubscriber(this.m);
    StoryDispatcher.a().unRegisterSubscriber(this.n);
    StoryDispatcher.a().unRegisterSubscriber(this.o);
    StoryDispatcher.a().unRegisterSubscriber(this.q);
    StoryDispatcher.a().unRegisterSubscriber(this.r);
    StoryDispatcher.a().unRegisterSubscriber(this.p);
    StoryDispatcher.a().unRegisterSubscriber(this.s);
    QQStoryContext.a();
    QQStoryContext.j().removeObserver(this.v);
    ((FeedManager)SuperManager.a(11)).h = null;
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = a(paramString);
    if (!(localObject instanceof CommentLikeHomeFeed)) {
      return;
    }
    localObject = (CommentLikeHomeFeed)localObject;
    if (((CommentLikeHomeFeed)localObject).c().mCommentIsEnd == 0)
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "push refresh, comment is not end :%s", new Object[] { paramString });
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new FeedCommentSync(paramString, 1, ((CommentLikeFeedItem)((CommentLikeHomeFeed)localObject).f).mCommentLastCookie));
    ((FeedManager)SuperManager.a(11)).f().a(localArrayList);
    SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push comment, feedId:%s", paramString);
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    new DetailLikeListLoader(paramString, false).a(true);
    SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push like, feedId:%s", paramString);
  }
  
  public void e()
  {
    if (this.a == 10)
    {
      FeedManager localFeedManager = (FeedManager)SuperManager.a(11);
      localFeedManager.e = new ArrayList(this.b);
      localFeedManager.d = new FeedListPageLoaderBase.FeedIdListCache(this.e.g());
      localFeedManager.f = g();
      SLog.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter pause, set feedList cache");
    }
  }
  
  public void f()
  {
    FeedManager localFeedManager = (FeedManager)SuperManager.a(11);
    localFeedManager.h = new FeedListPageLoaderBase.FeedIdListCache(this.e.g());
    List localList = localFeedManager.h.a;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (StoryHomeFeed)localIterator.next();
      if ((localObject instanceof VideoListHomeFeed))
      {
        VideoListHomeFeed localVideoListHomeFeed = (VideoListHomeFeed)localObject;
        int i1 = FeedIdListSeqInfo.a(localList, ((StoryHomeFeed)localObject).g().feedId);
        if (i1 >= 0)
        {
          localObject = (FeedIdListSeqInfo)localList.remove(i1);
          ((FeedIdListSeqInfo)localObject).h = localVideoListHomeFeed.i().mVideoPullType;
          localArrayList.add(localObject);
        }
        else if (VideoListFeedItem.isFakeFeedId(((StoryHomeFeed)localObject).g().feedId))
        {
          localArrayList.add(new FeedIdListSeqInfo(((StoryHomeFeed)localObject).g().feedId, 0, ((StoryHomeFeed)localObject).g().getOwner().getUnionId(), ((StoryHomeFeed)localObject).g().date));
        }
        else
        {
          localArrayList.add(new FeedIdListSeqInfo(((StoryHomeFeed)localObject).g().feedId, 0, ((StoryHomeFeed)localObject).g().getOwner().getUnionId(), ((StoryHomeFeed)localObject).g().date));
          SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed don't include %s", new Object[] { ((StoryHomeFeed)localObject).g().feedId });
        }
      }
    }
    localArrayList.addAll(localList);
    localFeedManager.h.a = localArrayList;
    SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "save data for play");
  }
  
  public boolean g()
  {
    return this.d;
  }
  
  public void h()
  {
    this.e.c();
    SLog.b("Q.qqstory.home.data.HomeFeedPresenter", "load network next feed");
  }
  
  public List<StoryHomeFeed> i()
  {
    return this.b;
  }
  
  public boolean isValidate()
  {
    return this.c.get() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter
 * JD-Core Version:    0.7.0.1
 */