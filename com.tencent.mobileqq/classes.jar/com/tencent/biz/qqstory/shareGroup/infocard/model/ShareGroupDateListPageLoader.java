package com.tencent.biz.qqstory.shareGroup.infocard.model;

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
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.network.request.GetShareGroupDateListRequest;
import com.tencent.biz.qqstory.network.response.GetShareGroupDateListResponse;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.DataSortedComparator;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.Collections;
import nsj;
import nsk;

public class ShareGroupDateListPageLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback
{
  protected int a;
  public ShareGroupDateListPageLoader.CacheContext a;
  protected final String a;
  protected final String b;
  protected long c;
  public final String c;
  public String d = "";
  
  public ShareGroupDateListPageLoader(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString1;
  }
  
  private void d()
  {
    int i = UIUtils.a();
    Object localObject;
    MemoryInfoEntry localMemoryInfoEntry;
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDateListPageLoader$CacheContext.jdField_a_of_type_Int != i)
    {
      SLog.d("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDateListPageLoader$CacheContext.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (MemoryManager)SuperManager.a(19);
      localMemoryInfoEntry = ((MemoryManager)localObject).a(this.jdField_c_of_type_JavaLangString);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.jdField_c_of_type_JavaLangString);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDateListPageLoader$CacheContext.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!a(this.d)) {
        break label232;
      }
    }
    label232:
    for (long l = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDateListPageLoader$CacheContext.jdField_a_of_type_Long;; l = 0L)
    {
      this.jdField_c_of_type_Long = l;
      localObject = new GetShareGroupDateListRequest();
      ((GetShareGroupDateListRequest)localObject).c = 10;
      ((GetShareGroupDateListRequest)localObject).d = 10;
      ((GetShareGroupDateListRequest)localObject).b = this.d;
      ((GetShareGroupDateListRequest)localObject).jdField_a_of_type_Long = l;
      ((GetShareGroupDateListRequest)localObject).f = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDateListPageLoader$CacheContext.jdField_a_of_type_Int;
      ((GetShareGroupDateListRequest)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((GetShareGroupDateListRequest)localObject).e = this.jdField_a_of_type_Int;
      CmdTaskManger.a().a((NetworkRequest)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((MemoryManager)localObject).a(localMemoryInfoEntry);
      break;
    }
  }
  
  public void a(@NonNull GetShareGroupDateListRequest paramGetShareGroupDateListRequest, @Nullable GetShareGroupDateListResponse paramGetShareGroupDateListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    int i = 1;
    if (paramGetShareGroupDateListRequest.jdField_a_of_type_Long != this.jdField_c_of_type_Long)
    {
      SLog.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(paramGetShareGroupDateListRequest.jdField_a_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long));
      return;
    }
    MemoryManager localMemoryManager = (MemoryManager)SuperManager.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localMemoryManager.a(this.jdField_c_of_type_JavaLangString);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      boolean bool2 = a(paramGetShareGroupDateListRequest.b);
      paramErrorMessage = new DateCollectionListPageLoader.GetCollectionListEvent(this.b, paramErrorMessage);
      paramErrorMessage.c = bool2;
      paramErrorMessage.b = false;
      if (paramGetShareGroupDateListResponse == null)
      {
        Dispatchers.get().dispatch(paramErrorMessage);
        return;
      }
      paramErrorMessage.jdField_a_of_type_Boolean = paramGetShareGroupDateListResponse.jdField_a_of_type_Boolean;
      paramErrorMessage.jdField_a_of_type_Int = -9527;
      paramErrorMessage.jdField_a_of_type_JavaUtilList = paramGetShareGroupDateListResponse.jdField_a_of_type_JavaUtilArrayList;
      boolean bool1;
      ArrayList localArrayList;
      label236:
      long l;
      String str;
      if (paramGetShareGroupDateListResponse.jdField_a_of_type_Long != paramGetShareGroupDateListRequest.jdField_a_of_type_Long)
      {
        bool1 = true;
        paramErrorMessage.e = bool1;
        if (paramErrorMessage.e)
        {
          localArrayList = paramGetShareGroupDateListResponse.jdField_a_of_type_JavaUtilArrayList;
          if (localArrayList != null)
          {
            Collections.sort(localArrayList, new VideoCollectionItem.DataSortedComparator());
            localMemoryManager.a(localArrayList, paramGetShareGroupDateListRequest.jdField_a_of_type_JavaLangString, bool2);
          }
          localMemoryInfoEntry.seq = paramGetShareGroupDateListResponse.jdField_a_of_type_Long;
          localMemoryInfoEntry.cookie = paramGetShareGroupDateListResponse.jdField_a_of_type_JavaLangString;
          if (!paramGetShareGroupDateListResponse.jdField_a_of_type_Boolean) {
            break label331;
          }
          localMemoryInfoEntry.isEnd = i;
          l = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDateListPageLoader$CacheContext.jdField_a_of_type_Long;
          str = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDateListPageLoader$CacheContext.jdField_a_of_type_JavaLangString;
          if (!paramGetShareGroupDateListResponse.jdField_a_of_type_Boolean) {
            break label337;
          }
        }
      }
      label331:
      label337:
      for (paramGetShareGroupDateListRequest = "true";; paramGetShareGroupDateListRequest = "false")
      {
        SLog.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s , %s", Long.valueOf(l), str, paramGetShareGroupDateListRequest, localArrayList);
        paramGetShareGroupDateListRequest = localMemoryManager.a(localMemoryInfoEntry);
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDateListPageLoader$CacheContext.a(paramGetShareGroupDateListRequest);
        this.d = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDateListPageLoader$CacheContext.jdField_a_of_type_JavaLangString;
        Dispatchers.get().dispatch(paramErrorMessage);
        return;
        bool1 = false;
        break;
        i = 0;
        break label236;
      }
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new nsj(this));
  }
  
  protected boolean a(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (paramString.equals("0"));
  }
  
  public void c()
  {
    super.c();
    Bosses.get().postJob(new nsk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.model.ShareGroupDateListPageLoader
 * JD-Core Version:    0.7.0.1
 */