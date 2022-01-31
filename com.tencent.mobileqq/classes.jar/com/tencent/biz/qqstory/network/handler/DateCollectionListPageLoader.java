package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.request.GetDateCollectionListRequest;
import com.tencent.biz.qqstory.network.response.GetDateCollectionListResponse;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.DataSortedComparator;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import njv;
import njw;

public class DateCollectionListPageLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback
{
  public DateCollectionListPageLoader.CacheContext a;
  public String a;
  protected String b;
  protected long c;
  protected String c;
  public final String d;
  
  public DateCollectionListPageLoader(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.b = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.d = a(this.b);
  }
  
  public static String a(String paramString)
  {
    return paramString;
  }
  
  private void d()
  {
    int i = UIUtils.a();
    Object localObject;
    MemoryInfoEntry localMemoryInfoEntry;
    long l;
    if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerDateCollectionListPageLoader$CacheContext.jdField_a_of_type_Int != i)
    {
      SLog.d("Q.qqstory.net:DateCollectionListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerDateCollectionListPageLoader$CacheContext.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (MemoryManager)SuperManager.a(19);
      localMemoryInfoEntry = ((MemoryManager)localObject).a(this.d);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.d);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerDateCollectionListPageLoader$CacheContext.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!a(this.jdField_a_of_type_JavaLangString)) {
        break label264;
      }
      l = this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerDateCollectionListPageLoader$CacheContext.jdField_a_of_type_Long;
      label125:
      this.jdField_c_of_type_Long = l;
      localObject = new GetDateCollectionListRequest();
      ((GetDateCollectionListRequest)localObject).c = 10;
      ((GetDateCollectionListRequest)localObject).d = 10;
      ((GetDateCollectionListRequest)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((GetDateCollectionListRequest)localObject).jdField_a_of_type_Long = l;
      ((GetDateCollectionListRequest)localObject).e = this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerDateCollectionListPageLoader$CacheContext.jdField_a_of_type_Int;
      ((GetDateCollectionListRequest)localObject).b = this.b;
      localMemoryInfoEntry = ((MemoryManager)SuperManager.a(19)).a(this.d);
      if (localMemoryInfoEntry != null) {
        if (localMemoryInfoEntry.isFriend != 1) {
          break label269;
        }
      }
    }
    label264:
    label269:
    for (boolean bool = true;; bool = false)
    {
      ((GetDateCollectionListRequest)localObject).jdField_a_of_type_Boolean = bool;
      CmdTaskManger.a().a((NetworkRequest)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((MemoryManager)localObject).a(localMemoryInfoEntry);
      break;
      l = 0L;
      break label125;
    }
  }
  
  public void a(@NonNull GetDateCollectionListRequest paramGetDateCollectionListRequest, @Nullable GetDateCollectionListResponse paramGetDateCollectionListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramGetDateCollectionListRequest.jdField_a_of_type_Long != this.jdField_c_of_type_Long)
    {
      SLog.a("Q.qqstory.net:DateCollectionListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(paramGetDateCollectionListRequest.jdField_a_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long));
      return;
    }
    MemoryManager localMemoryManager = (MemoryManager)SuperManager.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localMemoryManager.a(this.d);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.d);
    }
    for (;;)
    {
      boolean bool2 = a(paramGetDateCollectionListRequest.jdField_a_of_type_JavaLangString);
      DateCollectionListPageLoader.GetCollectionListEvent localGetCollectionListEvent = new DateCollectionListPageLoader.GetCollectionListEvent(this.jdField_c_of_type_JavaLangString, paramErrorMessage);
      localGetCollectionListEvent.c = bool2;
      localGetCollectionListEvent.b = false;
      if ((paramGetDateCollectionListResponse == null) || ((paramErrorMessage.isFail()) && (paramErrorMessage.errorCode != 11111)))
      {
        Dispatchers.get().dispatch(localGetCollectionListEvent);
        return;
      }
      int i;
      boolean bool1;
      label222:
      Object localObject1;
      label284:
      label303:
      long l;
      Object localObject2;
      if ((localMemoryInfoEntry.isFriend != -1) && (localMemoryInfoEntry.isFriend != paramGetDateCollectionListResponse.c))
      {
        i = 1;
        localMemoryInfoEntry.isFriend = paramGetDateCollectionListResponse.c;
        localGetCollectionListEvent.jdField_a_of_type_Boolean = paramGetDateCollectionListResponse.jdField_a_of_type_Boolean;
        localGetCollectionListEvent.jdField_a_of_type_JavaUtilList = paramGetDateCollectionListResponse.jdField_a_of_type_JavaUtilArrayList;
        localGetCollectionListEvent.jdField_a_of_type_Int = paramGetDateCollectionListResponse.b;
        if ((paramGetDateCollectionListResponse.jdField_a_of_type_Long == paramGetDateCollectionListRequest.jdField_a_of_type_Long) && (i == 0)) {
          break label480;
        }
        bool1 = true;
        localGetCollectionListEvent.e = bool1;
        if (!localGetCollectionListEvent.e) {
          break label517;
        }
        localObject1 = paramGetDateCollectionListResponse.jdField_a_of_type_JavaUtilArrayList;
        if (localObject1 != null)
        {
          Collections.sort((List)localObject1, new VideoCollectionItem.DataSortedComparator());
          localMemoryManager.a((List)localObject1, paramGetDateCollectionListRequest.b, bool2);
        }
        if (i == 0) {
          break label486;
        }
        localMemoryInfoEntry.seq = 0L;
        localMemoryInfoEntry.cookie = paramGetDateCollectionListResponse.jdField_a_of_type_JavaLangString;
        if (!paramGetDateCollectionListResponse.jdField_a_of_type_Boolean) {
          break label498;
        }
        i = 1;
        localMemoryInfoEntry.isEnd = i;
        l = this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerDateCollectionListPageLoader$CacheContext.jdField_a_of_type_Long;
        localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerDateCollectionListPageLoader$CacheContext.jdField_a_of_type_JavaLangString;
        if (!paramGetDateCollectionListResponse.jdField_a_of_type_Boolean) {
          break label504;
        }
      }
      label480:
      label486:
      label498:
      label504:
      for (paramGetDateCollectionListRequest = "true";; paramGetDateCollectionListRequest = "false")
      {
        SLog.a("Q.qqstory.net:DateCollectionListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s , %s", Long.valueOf(l), localObject2, paramGetDateCollectionListRequest, localObject1);
        paramGetDateCollectionListRequest = (FeedManager)SuperManager.a(11);
        if (localObject1 == null) {
          break label517;
        }
        paramGetDateCollectionListResponse = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (VideoCollectionItem)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty(((VideoCollectionItem)localObject2).feedId))
          {
            FeedItem localFeedItem = paramGetDateCollectionListRequest.a(((VideoCollectionItem)localObject2).feedId);
            if (localFeedItem != null)
            {
              if ((localFeedItem instanceof VideoListFeedItem)) {
                ((VideoListFeedItem)localFeedItem).mViewTotalTime = ((VideoCollectionItem)localObject2).viewTimes;
              }
              paramGetDateCollectionListResponse.add(localFeedItem);
            }
          }
        }
        i = 0;
        break;
        bool1 = false;
        break label222;
        localMemoryInfoEntry.seq = paramGetDateCollectionListResponse.jdField_a_of_type_Long;
        break label284;
        i = 0;
        break label303;
      }
      paramGetDateCollectionListRequest.a(paramGetDateCollectionListResponse);
      label517:
      if (paramErrorMessage.errorCode == 11111) {
        localMemoryInfoEntry.seq = 0L;
      }
      paramGetDateCollectionListRequest = localMemoryManager.a(localMemoryInfoEntry);
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerDateCollectionListPageLoader$CacheContext.a(paramGetDateCollectionListRequest);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerDateCollectionListPageLoader$CacheContext.jdField_a_of_type_JavaLangString;
      Dispatchers.get().dispatch(localGetCollectionListEvent);
      return;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new njv(this));
  }
  
  protected boolean a(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (paramString.equals("0"));
  }
  
  public void c()
  {
    super.c();
    Bosses.get().postJob(new njw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader
 * JD-Core Version:    0.7.0.1
 */