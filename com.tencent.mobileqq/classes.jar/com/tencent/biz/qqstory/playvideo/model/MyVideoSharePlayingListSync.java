package com.tencent.biz.qqstory.playvideo.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.GetShareVideoListRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.Dispatchers;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import now;
import nox;

public class MyVideoSharePlayingListSync
  extends BasePagePlayingListSync
{
  protected long a;
  protected int c;
  public String c;
  
  public MyVideoSharePlayingListSync(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super(paramString1);
    if ((paramString3 == null) || (Long.parseLong(paramString3) <= 0L))
    {
      this.jdField_a_of_type_Long = (System.currentTimeMillis() / 1000L);
      SLog.b("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "loadUserVideoByTime but time is null ");
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_c_of_type_JavaLangString = paramString2;
      return;
      this.jdField_a_of_type_Long = Long.parseLong(paramString3);
    }
  }
  
  protected int a()
  {
    return 26;
  }
  
  protected void c()
  {
    Object localObject = (StoryManager)SuperManager.a(5);
    Iterator localIterator;
    StoryVideoItem localStoryVideoItem;
    if (QQStoryContext.a().a(this.jdField_c_of_type_JavaLangString))
    {
      localObject = ((StoryManager)localObject).e(this.jdField_c_of_type_JavaLangString);
      if (localObject != null)
      {
        localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext())
        {
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
          if ((!localStoryVideoItem.isUploadFail()) && (!localStoryVideoItem.isUploadSuc())) {
            localIterator.remove();
          }
        }
      }
      Collections.sort((List)localObject, new now(this));
    }
    for (;;)
    {
      localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localStoryVideoItem = (StoryVideoItem)localIterator.next();
        if (TextUtils.isEmpty(localStoryVideoItem.mOwnerUid)) {
          localStoryVideoItem.mOwnerUid = QQStoryContext.a().b();
        }
      }
      localObject = ((StoryManager)localObject).b(this.jdField_c_of_type_JavaLangString);
    }
    if (((List)localObject).size() > 0)
    {
      localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext()) {
        if (((StoryVideoItem)localIterator.next()).mCreateTime / 1000L > this.jdField_a_of_type_Long) {
          localIterator.remove();
        }
      }
      if (((List)localObject).size() != 0) {
        break label224;
      }
    }
    label224:
    while (((StoryVideoItem)((List)localObject).get(((List)localObject).size() - 1)).mCreateTime / 1000L != this.jdField_a_of_type_Long) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    localObject = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
    ((DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent)localObject).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    ((DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent)localObject).jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    ((DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent)localObject).jdField_a_of_type_Boolean = true;
    ((DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent)localObject).jdField_b_of_type_Boolean = true;
    Dispatchers.get().dispatch((Dispatcher.Dispatchable)localObject);
  }
  
  protected void d()
  {
    this.jdField_c_of_type_Boolean = true;
    GetShareVideoListRequest localGetShareVideoListRequest = new GetShareVideoListRequest(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_c_of_type_Int);
    localGetShareVideoListRequest.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    CmdTaskManger.a().a(localGetShareVideoListRequest, new nox(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.MyVideoSharePlayingListSync
 * JD-Core Version:    0.7.0.1
 */