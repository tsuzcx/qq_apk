package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.GetTroopAssistantFeedIdListRequest;
import com.tencent.biz.qqstory.playvideo.entrance.TroopAssistantHomeFeedPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Iterator;
import java.util.List;

public class TroopAssistantHomeFeedPlayPageLoader
  extends FeedIdBasePlayPageLoader<TroopAssistantHomeFeedPlayInfo>
{
  public TroopAssistantHomeFeedPlayPageLoader(TroopAssistantHomeFeedPlayInfo paramTroopAssistantHomeFeedPlayInfo)
  {
    super(paramTroopAssistantHomeFeedPlayInfo);
    paramTroopAssistantHomeFeedPlayInfo = (FeedManager)SuperManager.a(11);
    if (paramTroopAssistantHomeFeedPlayInfo.b != null) {
      this.a = paramTroopAssistantHomeFeedPlayInfo.b;
    }
  }
  
  public FeedIdListSeqInfo a(String paramString)
  {
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FeedIdListSeqInfo localFeedIdListSeqInfo = (FeedIdListSeqInfo)localIterator.next();
      if (localFeedIdListSeqInfo.a.equals(paramString)) {
        return localFeedIdListSeqInfo;
      }
    }
    return null;
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean, int paramInt, IGroupPageLoader.CallBack paramCallBack)
  {
    Object localObject = this.a.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject).size() > 0))
    {
      List localList = b((List)localObject);
      paramCallBack.a(new ErrorMessage(), localList, this.a.jdField_a_of_type_Boolean);
      SLog.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject).size()));
      return;
    }
    localObject = new GetTroopAssistantFeedIdListRequest();
    ((GetTroopAssistantFeedIdListRequest)localObject).a = this.a.a();
    SLog.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "start request next feed id list with cookie %s", ((GetTroopAssistantFeedIdListRequest)localObject).a);
    CmdTaskManger.a().a((NetworkRequest)localObject, new TroopAssistantHomeFeedPlayPageLoader.1(this, paramCallBack));
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.TroopAssistantHomeFeedPlayPageLoader
 * JD-Core Version:    0.7.0.1
 */