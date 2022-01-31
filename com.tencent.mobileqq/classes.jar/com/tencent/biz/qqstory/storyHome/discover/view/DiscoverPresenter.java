package com.tencent.biz.qqstory.storyHome.discover.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.DiscoverManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.HotTopicInfoItem;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetHotTopicInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetHotTopicInfo;
import com.tencent.biz.qqstory.network.request.CommonRequest;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.ActivityCardInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.CardVideoInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.DiscoverPagerLoader;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import nuj;
import nuk;
import num;
import nun;
import nuo;
import nup;
import nuq;

public class DiscoverPresenter
  implements IEventReceiver
{
  public static ArrayList a;
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private final CardItem.ActivityCardInfo jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$ActivityCardInfo;
  private CardItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem;
  private DiscoverPagerLoader jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelDiscoverPagerLoader;
  private DiscoverPresenter.FeedInteractiveRec jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewDiscoverPresenter$FeedInteractiveRec;
  private DiscoverPresenter.GetFeedFeatureReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewDiscoverPresenter$GetFeedFeatureReceiver;
  private final IDiscoverView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewIDiscoverView;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private nuo jdField_a_of_type_Nuo;
  public nup a;
  private nuq jdField_a_of_type_Nuq;
  private ArrayList b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public DiscoverPresenter(int paramInt, long paramLong, CardItem.ActivityCardInfo paramActivityCardInfo, @Nullable CardItem paramCardItem, @NonNull IDiscoverView paramIDiscoverView)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$ActivityCardInfo = paramActivityCardInfo;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewIDiscoverView = paramIDiscoverView;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem = paramCardItem;
  }
  
  private List a(List paramList, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    Object localObject;
    label51:
    CardItem localCardItem;
    if (paramBoolean)
    {
      this.b.clear();
      this.b.addAll(paramList);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem;
      if (localObject == null) {
        break label166;
      }
      String str = ((CardItem)localObject).getFeedId();
      Iterator localIterator = this.b.iterator();
      if (!localIterator.hasNext()) {
        break label156;
      }
      localCardItem = (CardItem)localIterator.next();
      if (!TextUtils.equals(str, localCardItem.getFeedId())) {
        break label209;
      }
      localIterator.remove();
      localObject = localCardItem;
    }
    label156:
    label166:
    label209:
    for (;;)
    {
      break label51;
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localCardItem = (CardItem)((Iterator)localObject).next();
        if (this.b.indexOf(localCardItem) == -1) {
          this.b.add(localCardItem);
        }
      }
      break;
      this.b.add(0, localObject);
      long l2 = System.currentTimeMillis();
      SLog.a("Q.qqstory.discover.DiscoverPresenter", "add data %d take time %d, data count %d", Integer.valueOf(paramList.size()), Long.valueOf(l2 - l1), Integer.valueOf(this.b.size()));
      return this.b;
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      CardItem localCardItem = (CardItem)localIterator.next();
      CardItem.CardVideoInfo localCardVideoInfo = localCardItem.getCardVideoInfo();
      if ((localCardVideoInfo != null) && (localCardVideoInfo.c().equals(paramString)))
      {
        localCardVideoInfo.a(paramInt);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewIDiscoverView.a(localCardItem);
        if (!"share_to_discover_fake_item".equals(localCardItem.cardId)) {
          ((DiscoverManager)SuperManager.a(22)).a(localCardItem);
        }
        SLog.b("Q.qqstory.discover.DiscoverPresenter", "updateVideoLikeCountByFeedId feed %s like %d", paramString, Integer.valueOf(paramInt));
      }
    }
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      CardItem localCardItem = (CardItem)localIterator.next();
      CardItem.CardVideoInfo localCardVideoInfo = localCardItem.getCardVideoInfo();
      if ((localCardVideoInfo != null) && (localCardVideoInfo.c().equals(paramString)))
      {
        localCardVideoInfo.a(paramLong);
        localCardVideoInfo.a(paramInt);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewIDiscoverView.a(localCardItem);
        if (!"share_to_discover_fake_item".equals(localCardItem.cardId)) {
          ((DiscoverManager)SuperManager.a(22)).a(localCardItem);
        }
        SLog.b("Q.qqstory.discover.DiscoverPresenter", "update feed %s watch %d", paramString, Long.valueOf(paramLong));
        SLog.b("Q.qqstory.discover.DiscoverPresenter", "update feed %s like %d", paramString, Integer.valueOf(paramInt));
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_service.RspGetHotTopicInfo();
    try
    {
      ((qqstory_service.RspGetHotTopicInfo)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = new HotTopicInfoItem(this.jdField_a_of_type_Long, (qqstory_service.RspGetHotTopicInfo)localObject);
      ThreadManager.getUIHandler().post(new nun(this, paramArrayOfByte));
      localObject = new DiscoverPresenter.TopicInfoUpdateEvent();
      ((DiscoverPresenter.TopicInfoUpdateEvent)localObject).a = paramArrayOfByte;
      Dispatchers.get().dispatch((Dispatcher.Dispatchable)localObject);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        SLog.e("Q.qqstory.discover.DiscoverPresenter", "StorySvc.get_hot_topic_info response parse fail! %s", new Object[] { paramArrayOfByte.toString() });
      }
    }
  }
  
  private void d()
  {
    String str = StoryApi.a("StorySvc.get_hot_topic_info");
    qqstory_service.ReqGetHotTopicInfo localReqGetHotTopicInfo = new qqstory_service.ReqGetHotTopicInfo();
    localReqGetHotTopicInfo.topic_id.set(this.jdField_a_of_type_Long);
    CmdTaskManger.a().a(new CommonRequest(str, localReqGetHotTopicInfo, null), new num(this));
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewDiscoverPresenter$FeedInteractiveRec = new DiscoverPresenter.FeedInteractiveRec(this);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewDiscoverPresenter$FeedInteractiveRec);
    this.jdField_a_of_type_Nuo = new nuo(this);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_Nuo);
    this.jdField_a_of_type_Nup = new nup(this);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_Nup);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Nuq = new nuq(this);
      Dispatchers.get().registerSubscriber(this.jdField_a_of_type_Nuq);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewDiscoverPresenter$GetFeedFeatureReceiver = new DiscoverPresenter.GetFeedFeatureReceiver(this);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewDiscoverPresenter$GetFeedFeatureReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelDiscoverPagerLoader = new DiscoverPagerLoader(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
    jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(this));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem = null;
    }
    Object localObject;
    if (paramBoolean1) {
      if (this.jdField_a_of_type_Int == 2) {
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$ActivityCardInfo != null)
        {
          localObject = new HotTopicInfoItem(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$ActivityCardInfo);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewIDiscoverView.a((HotTopicInfoItem)localObject);
          SLog.b("Q.qqstory.discover.DiscoverPresenter", "topic %d info %s", Long.valueOf(this.jdField_a_of_type_Long), localObject);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelDiscoverPagerLoader.a();
        }
      }
    }
    for (;;)
    {
      return;
      Bosses.get().postLightWeightJob(new nuj(this), 0);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelDiscoverPagerLoader.a();
      return;
      if (this.jdField_a_of_type_Int == 0)
      {
        localObject = (LbsManager)SuperManager.a(9);
        ((LbsManager)localObject).a(new nuk(this, (LbsManager)localObject));
        ((LbsManager)localObject).a(1000);
      }
      while (this.jdField_a_of_type_Int == 2)
      {
        d();
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelDiscoverPagerLoader.a(null, 0);
      }
    }
  }
  
  public void b()
  {
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewDiscoverPresenter$FeedInteractiveRec);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_Nuo);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_Nup);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewDiscoverPresenter$GetFeedFeatureReceiver);
    ((QQStoryDiscoverFragment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewIDiscoverView).getActivity();
    if (this.jdField_a_of_type_Int == 0) {
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_Nuq);
    }
    UIUtils.a(false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelDiscoverPagerLoader.d();
    if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
      if (i < 0) {
        break label178;
      }
      DiscoverPresenter localDiscoverPresenter = (DiscoverPresenter)((WeakReference)jdField_a_of_type_JavaUtilArrayList.get(i)).get();
      if ((localDiscoverPresenter != null) && (localDiscoverPresenter == this)) {
        jdField_a_of_type_JavaUtilArrayList.remove(i);
      }
    }
    label178:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        throw new IllegalStateException("Create() Destroy() Order Error!!");
        i -= 1;
        break;
      }
      return;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelDiscoverPagerLoader.c();
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.view.DiscoverPresenter
 * JD-Core Version:    0.7.0.1
 */