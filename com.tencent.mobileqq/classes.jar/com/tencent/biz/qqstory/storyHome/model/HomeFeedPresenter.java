package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.boundaries.StoryDepends.ShortVideoMultiSender;
import com.tencent.biz.qqstory.comment.FeedInfoChangeEvent;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TagManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoSpreadGroupList;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
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
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import odi;
import odj;
import odk;
import odl;
import odm;

public class HomeFeedPresenter
  implements FeedListPageLoaderBase.OnFeedItemPageLoadListener, IEventReceiver
{
  private int jdField_a_of_type_Int;
  private final QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new odl(this);
  private FeedListPageLoaderBase jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase;
  private HomeFeedPresenter.FeedCommentRec jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$FeedCommentRec;
  private HomeFeedPresenter.FeedInteractiveRec jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$FeedInteractiveRec;
  private HomeFeedPresenter.FeedVideoCookieRec jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$FeedVideoCookieRec;
  private HomeFeedPresenter.FeedVideoRec jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$FeedVideoRec;
  private HomeFeedPresenter.HomeFeedPresenterListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$HomeFeedPresenterListener;
  private HomeFeedPresenter.OnTagListUpdateRec jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$OnTagListUpdateRec;
  private HomeFeedPresenter.OneFeedInfoUpdateRec jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$OneFeedInfoUpdateRec;
  private HomeFeedPresenter.SendVidPollDataResultReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$SendVidPollDataResultReceiver;
  private HomeFeedPresenter.SendVidRateDataResultReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$SendVidRateDataResultReceiver;
  private HomeFeedPresenter.UploadStatusRec jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$UploadStatusRec;
  private HomeFeedPresenter.VideoDeleteRec jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$VideoDeleteRec;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List jdField_a_of_type_JavaUtilList;
  public AtomicBoolean a;
  private odm jdField_a_of_type_Odm;
  private boolean jdField_a_of_type_Boolean = true;
  
  public HomeFeedPresenter(int paramInt, @NonNull HomeFeedPresenter.HomeFeedPresenterListener paramHomeFeedPresenterListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$HomeFeedPresenterListener = paramHomeFeedPresenterListener;
    AssertUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$HomeFeedPresenterListener);
    if ((this.jdField_a_of_type_Int != 10) && (this.jdField_a_of_type_Int != 11) && (this.jdField_a_of_type_Int != 12)) {
      AssertUtils.a("feed type error for:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    }
  }
  
  private GeneralHomeFeed a(List paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (StoryHomeFeed)paramList.next();
      if ((localObject instanceof GeneralHomeFeed))
      {
        localObject = (GeneralHomeFeed)localObject;
        if ((((GeneralFeedItem)((GeneralHomeFeed)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).isMyFeedItem()) && (TextUtils.equals(paramString, ((GeneralFeedItem)((GeneralHomeFeed)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).date)))
        {
          SLog.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private VideoListHomeFeed a(List paramList, String paramString1, String paramString2)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (StoryHomeFeed)paramList.next();
      if ((localObject instanceof ShareGroupHomeFeed))
      {
        localObject = (VideoListHomeFeed)localObject;
        IFeedOwner localIFeedOwner = ((VideoListHomeFeed)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.getOwner();
        if ((localIFeedOwner != null) && (TextUtils.equals(paramString1, localIFeedOwner.getUnionId())) && (TextUtils.equals(paramString2, ((VideoListHomeFeed)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.date)))
        {
          SLog.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  public static String a(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (StoryHomeFeed)paramList.next();
      if ((localObject instanceof GeneralHomeFeed))
      {
        localObject = (GeneralHomeFeed)localObject;
        if (((GeneralFeedItem)((GeneralHomeFeed)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).isMyFeedItem()) {
          return b(paramStoryVideoItem, ((GeneralHomeFeed)localObject).a());
        }
      }
    }
    return null;
  }
  
  private void a(HomeFeedData paramHomeFeedData, List paramList)
  {
    if (paramList.size() == 0) {
      break label9;
    }
    label9:
    while (((UserManager)SuperManager.a(2)).a() == null) {
      return;
    }
    Iterator localIterator1 = paramList.iterator();
    label31:
    StoryVideoItem localStoryVideoItem;
    Object localObject;
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        localStoryVideoItem = (StoryVideoItem)localIterator1.next();
        if (localStoryVideoItem.isLocalAddShareGroupVideo())
        {
          if (!a(localStoryVideoItem.shareGroupId))
          {
            SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), localStoryVideoItem.shareGroupId });
          }
          else
          {
            localObject = a(paramHomeFeedData.jdField_b_of_type_JavaUtilList, localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
            paramList = (List)localObject;
            if (localObject == null)
            {
              paramList = FeedManager.a(localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
              if (paramList != null)
              {
                paramList = new ShareGroupHomeFeed(paramList);
                paramHomeFeedData.jdField_b_of_type_JavaUtilList.add(0, paramList);
                SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
              }
            }
            else
            {
              paramList.a(localStoryVideoItem, true);
            }
          }
        }
        else
        {
          localObject = StoryVideoTaskInfo.a(localStoryVideoItem.mVid);
          if (localObject != null)
          {
            paramList = localStoryVideoItem.mVideoSpreadGroupList;
            if ((paramList != null) && (paramList.jdField_b_of_type_JavaUtilList != null))
            {
              Iterator localIterator2 = paramList.jdField_b_of_type_JavaUtilList.iterator();
              label234:
              while (localIterator2.hasNext())
              {
                String str = (String)localIterator2.next();
                if (!a(str))
                {
                  SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), str });
                }
                else
                {
                  paramList = a(paramHomeFeedData.jdField_b_of_type_JavaUtilList, str, localStoryVideoItem.mPublishDate);
                  if (paramList != null) {
                    break label572;
                  }
                  paramList = new ShareGroupHomeFeed(FeedManager.a(str, localStoryVideoItem.mPublishDate));
                  paramHomeFeedData.jdField_b_of_type_JavaUtilList.add(0, paramList);
                  SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
                }
              }
            }
          }
        }
      }
    }
    label572:
    for (;;)
    {
      paramList.a(localStoryVideoItem, true);
      break label234;
      if ((((PublishVideoEntry)localObject).getBooleanExtra("ignorePersonalPublish", false)) || (!b())) {
        break label31;
      }
      paramList = a(localStoryVideoItem, paramHomeFeedData.jdField_b_of_type_JavaUtilList);
      if (paramList != null)
      {
        ((StoryManager)SuperManager.a(5)).a(localStoryVideoItem.mVid);
        SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { localStoryVideoItem.mVid, paramList });
        break label31;
      }
      a(localStoryVideoItem);
      localObject = a(paramHomeFeedData.jdField_b_of_type_JavaUtilList, localStoryVideoItem.mPublishDate);
      paramList = (List)localObject;
      if (localObject == null)
      {
        paramList = new GeneralHomeFeed(FeedManager.a(QQStoryContext.a().b(), localStoryVideoItem.mPublishDate));
        paramHomeFeedData.jdField_b_of_type_JavaUtilList.add(0, paramList);
        SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
      }
      paramList.a(localStoryVideoItem, true);
      break label31;
      if (QLog.isDebugVersion()) {
        SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", paramHomeFeedData.jdField_b_of_type_JavaUtilList);
      }
      Collections.sort(paramHomeFeedData.jdField_b_of_type_JavaUtilList, GeneralHomeFeed.jdField_a_of_type_Odq);
      if (!QLog.isDebugVersion()) {
        break;
      }
      SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", paramHomeFeedData.jdField_b_of_type_JavaUtilList);
      return;
    }
  }
  
  private void a(ArrayList paramArrayList)
  {
    Bosses.get().postLightWeightJob(new odk(this, paramArrayList), 10);
  }
  
  public static boolean a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    if (!TextUtils.isEmpty(paramStoryVideoItem.mLocalSpecialItemId))
    {
      if (paramStoryVideoItem.mUploadStatus != 4) {
        break label92;
      }
      if (Math.abs(paramStoryVideoItem.mCreateTime - NetConnInfoCenter.getServerTimeMillis()) > 600000L)
      {
        paramStoryVideoItem.mUploadStatus = 6;
        paramStoryVideoItem.copy(((StoryManager)SuperManager.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
        SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s createTime=%d is marked as SUBMIT FAIL", new Object[] { paramStoryVideoItem.mVid, Long.valueOf(paramStoryVideoItem.mCreateTime) });
      }
    }
    label92:
    while ((paramStoryVideoItem.mUploadStatus != 1) || (StoryDepends.ShortVideoMultiSender.a(paramStoryVideoItem.mVid))) {
      return false;
    }
    paramStoryVideoItem.mUploadStatus = 3;
    paramStoryVideoItem.copy(((StoryManager)SuperManager.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
    SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s is marked as UPLOAD FAIL", new Object[] { paramStoryVideoItem.mVid });
    return true;
  }
  
  private boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_Int == 12) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    boolean bool = ShareGroupManager.a(((ShareGroupManager)SuperManager.a(7)).a(paramString));
    if ((this.jdField_a_of_type_Int == 11) && (!bool))
    {
      SLog.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore share group item in troop assistant list");
      return false;
    }
    if ((this.jdField_a_of_type_Int != 11) && (bool))
    {
      SLog.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore troop assistant only share group item not in troop assistant list");
      return false;
    }
    return true;
  }
  
  public static String b(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List paramList)
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
    localFeedInfoChangeEvent.c = paramCommentEntry.commentId;
    localFeedInfoChangeEvent.a = paramCommentLikeFeedItem;
    Dispatchers.get().dispatch(localFeedInfoChangeEvent);
    SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "notifyFeedInfoChange. event = %s, mCommentCount = %d, mFanCommentCount = %d, mFriendCommentCount = %d.", localFeedInfoChangeEvent, Integer.valueOf(localFeedInfoChangeEvent.a.mCommentCount), Integer.valueOf(localFeedInfoChangeEvent.a.mFanCommentCount), Integer.valueOf(localFeedInfoChangeEvent.a.mFriendCommentCount));
  }
  
  private void b(HomeFeedData paramHomeFeedData)
  {
    List localList;
    if ((paramHomeFeedData.jdField_b_of_type_Boolean) || ((paramHomeFeedData.c) && (paramHomeFeedData.errorInfo.isSuccess())))
    {
      localList = ((StoryManager)SuperManager.a(5)).a(true);
      if (localList.size() != 0) {}
    }
    else
    {
      return;
    }
    a(paramHomeFeedData, localList);
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_Int != 11;
  }
  
  private static boolean b(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramCommentLikeFeedItem instanceof VideoListFeedItem))
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
    long l = 0L;
    if (!paramHomeFeedData.errorInfo.isSuccess()) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramHomeFeedData.c) {
        this.jdField_a_of_type_JavaUtilList = ((StoryManager)SuperManager.a(5)).a(true);
      }
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        return;
      }
    }
    ArrayList localArrayList = new ArrayList(0);
    if (paramHomeFeedData.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        boolean bool = localIterator.hasNext();
        if (!bool) {
          break;
        }
        try
        {
          StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator.next();
          if (FeedManager.a().parse(localStoryVideoItem.mPublishDate).getTime() >= l)
          {
            localArrayList.add(localStoryVideoItem);
            localIterator.remove();
          }
        }
        catch (ParseException localParseException)
        {
          localParseException.printStackTrace();
        }
      }
      if (paramHomeFeedData.jdField_b_of_type_JavaUtilList.size() > 0) {
        l = ((StoryHomeFeed)paramHomeFeedData.jdField_b_of_type_JavaUtilList.get(paramHomeFeedData.jdField_b_of_type_JavaUtilList.size() - 1)).a().dateTimeMillis;
      }
    }
    a(paramHomeFeedData, localArrayList);
  }
  
  private void d(HomeFeedData paramHomeFeedData)
  {
    TagManager localTagManager = (TagManager)SuperManager.a(27);
    paramHomeFeedData = paramHomeFeedData.jdField_b_of_type_JavaUtilList;
    if (paramHomeFeedData != null)
    {
      paramHomeFeedData = paramHomeFeedData.iterator();
      while (paramHomeFeedData.hasNext())
      {
        Object localObject = (StoryHomeFeed)paramHomeFeedData.next();
        if ((localObject instanceof VideoListHomeFeed))
        {
          localObject = (VideoListHomeFeed)localObject;
          ((VideoListHomeFeed)localObject).d = localTagManager.a(((VideoListHomeFeed)localObject).a().feedId, ((VideoListHomeFeed)localObject).a());
          SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "update tag list , feed id = %s , tag size = %d", ((VideoListHomeFeed)localObject).a().feedId, Integer.valueOf(((VideoListHomeFeed)localObject).d.size()));
        }
      }
    }
  }
  
  private void e(HomeFeedData paramHomeFeedData)
  {
    Object localObject = paramHomeFeedData.jdField_b_of_type_JavaUtilList;
    if (localObject == null) {
      return;
    }
    paramHomeFeedData = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)((Iterator)localObject).next();
      if (((localStoryHomeFeed instanceof GeneralHomeFeed)) && (!((GeneralFeedItem)localStoryHomeFeed.a()).mIsVideoEnd)) {
        paramHomeFeedData.add(localStoryHomeFeed.a().feedId);
      }
    }
    ((TagManager)SuperManager.a(27)).a(paramHomeFeedData);
  }
  
  public StoryHomeFeed a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)localIterator.next();
      if (localStoryHomeFeed.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId.equals(paramString)) {
        return localStoryHomeFeed;
      }
    }
    return null;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    SLog.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter create");
    if (this.jdField_a_of_type_Int == 10) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase = new HomeFeedListPageLoader(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$UploadStatusRec = new HomeFeedPresenter.UploadStatusRec(this);
      Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$UploadStatusRec);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$FeedCommentRec = new HomeFeedPresenter.FeedCommentRec(this);
      Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$FeedCommentRec);
      this.jdField_a_of_type_Odm = new odm(this);
      Dispatchers.get().registerSubscriber(this.jdField_a_of_type_Odm);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$FeedVideoRec = new HomeFeedPresenter.FeedVideoRec(this);
      Dispatchers.get().registerSubscriber("HomeFeedPresenter", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$FeedVideoRec);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$FeedVideoCookieRec = new HomeFeedPresenter.FeedVideoCookieRec(this);
      Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$FeedVideoCookieRec);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$FeedInteractiveRec = new HomeFeedPresenter.FeedInteractiveRec(this);
      Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$FeedInteractiveRec);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$VideoDeleteRec = new HomeFeedPresenter.VideoDeleteRec(this);
      Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$VideoDeleteRec);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$OneFeedInfoUpdateRec = new HomeFeedPresenter.OneFeedInfoUpdateRec(this);
      Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$OneFeedInfoUpdateRec);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$SendVidPollDataResultReceiver = new HomeFeedPresenter.SendVidPollDataResultReceiver(this, this);
      Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$SendVidPollDataResultReceiver);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$SendVidRateDataResultReceiver = new HomeFeedPresenter.SendVidRateDataResultReceiver(this, this);
      Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$SendVidRateDataResultReceiver);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$OnTagListUpdateRec = new HomeFeedPresenter.OnTagListUpdateRec(this);
      Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$OnTagListUpdateRec);
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
      return;
      if (this.jdField_a_of_type_Int == 11) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase = new TroopAssistantFeedListPageLoader(this);
      } else if (this.jdField_a_of_type_Int == 12) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase = new MemoriesFeedListPageLoader(this);
      }
    }
  }
  
  public void a(HomeFeedData paramHomeFeedData)
  {
    c(paramHomeFeedData);
    d(paramHomeFeedData);
    SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "on feed back:%s", new Object[] { paramHomeFeedData.a() });
    e(paramHomeFeedData);
    a(new ArrayList(paramHomeFeedData.jdField_b_of_type_JavaUtilList));
    ThreadManager.getUIHandler().post(new odj(this, paramHomeFeedData));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      localObject = a(paramString);
    } while (!(localObject instanceof CommentLikeHomeFeed));
    Object localObject = (CommentLikeHomeFeed)localObject;
    if (((CommentLikeHomeFeed)localObject).a().mCommentIsEnd == 0)
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "push refresh, comment is not end :%s", new Object[] { paramString });
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new FeedCommentSync(paramString, 1, ((CommentLikeFeedItem)((CommentLikeHomeFeed)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentLastCookie));
    ((FeedManager)SuperManager.a(11)).a().a(localArrayList);
    SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push comment, feedId:%s", paramString);
  }
  
  public void a(List paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)paramList.next();
      if (localHashSet.contains(localStoryHomeFeed.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId))
      {
        paramList.remove();
        SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "have repeat feed %s", new Object[] { localStoryHomeFeed });
      }
      else
      {
        localHashSet.add(localStoryHomeFeed.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramBoolean)
    {
      FeedManager localFeedManager = (FeedManager)SuperManager.a(11);
      FeedListPageLoaderBase.FeedIdListCache localFeedIdListCache = localFeedManager.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache;
      ArrayList localArrayList = localFeedManager.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_Int == 10) && (localArrayList != null) && (localArrayList.size() > 0) && (localFeedIdListCache != null))
      {
        localObject = new HomeFeedData(new ErrorMessage());
        ((HomeFeedData)localObject).jdField_b_of_type_JavaUtilList = localArrayList;
        paramBoolean = localFeedManager.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Boolean = paramBoolean;
        ((HomeFeedData)localObject).jdField_a_of_type_Boolean = paramBoolean;
        ((HomeFeedData)localObject).jdField_b_of_type_Boolean = true;
        ((HomeFeedData)localObject).e = true;
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase.a(localFeedIdListCache);
        SLog.d("Q.qqstory.home.position", "#use memory cache data size:", new Object[] { Integer.valueOf(((HomeFeedData)localObject).jdField_b_of_type_JavaUtilList.size()) });
      }
      for (;;)
      {
        a(new ArrayList(((HomeFeedData)localObject).jdField_b_of_type_JavaUtilList));
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(((HomeFeedData)localObject).jdField_b_of_type_JavaUtilList);
        long l2 = System.currentTimeMillis();
        SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "cache data size %d, take time:%d", new Object[] { Integer.valueOf(((HomeFeedData)localObject).jdField_b_of_type_JavaUtilList.size()), Long.valueOf(l2 - l1) });
        return;
        localObject = (HomeFeedData)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase.b();
        this.jdField_a_of_type_Boolean = ((HomeFeedData)localObject).jdField_a_of_type_Boolean;
        b((HomeFeedData)localObject);
        d((HomeFeedData)localObject);
      }
    }
    Object localObject = (LbsManager)SuperManager.a(9);
    ((LbsManager)localObject).a(new odi(this, (LbsManager)localObject));
    ((LbsManager)localObject).a(1000);
    SLog.b("Q.qqstory.home.data.HomeFeedPresenter", "refresh network feed");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(VideoListHomeFeed paramVideoListHomeFeed)
  {
    FeedVideoInfo localFeedVideoInfo = paramVideoListHomeFeed.a().getVideoInfo();
    VideoListPageLoader localVideoListPageLoader = new VideoListPageLoader(0, localFeedVideoInfo);
    localVideoListPageLoader.b("HomeFeedPresenter");
    localVideoListPageLoader.c();
    SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "load next page for %s, info:%s", paramVideoListHomeFeed.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, localFeedVideoInfo);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$UploadStatusRec);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$FeedCommentRec);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_Odm);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$FeedVideoRec);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$FeedVideoCookieRec);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$FeedInteractiveRec);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$VideoDeleteRec);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$OneFeedInfoUpdateRec);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$SendVidPollDataResultReceiver);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$SendVidRateDataResultReceiver);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter$OnTagListUpdateRec);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    ((FeedManager)SuperManager.a(11)).b = null;
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    new DetailLikeListLoader(paramString, false).a(true);
    SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push like, feedId:%s", paramString);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int == 10)
    {
      FeedManager localFeedManager = (FeedManager)SuperManager.a(11);
      localFeedManager.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      localFeedManager.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache = new FeedListPageLoaderBase.FeedIdListCache(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase.a());
      localFeedManager.jdField_a_of_type_Boolean = a();
      SLog.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter pause, set feedList cache");
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase.c();
    SLog.b("Q.qqstory.home.data.HomeFeedPresenter", "load network next feed");
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter
 * JD-Core Version:    0.7.0.1
 */