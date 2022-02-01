package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.network.handler.UidToVidHandler.GetUserVidListEvent;
import com.tencent.biz.qqstory.network.response.GetVidListResponse.UserVidList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VidToVideoInfoPuller$StoryVidListReceiver
  extends QQUIEventReceiver<VidToVideoInfoPuller, UidToVidHandler.GetUserVidListEvent>
{
  public VidToVideoInfoPuller$StoryVidListReceiver(@NonNull VidToVideoInfoPuller paramVidToVideoInfoPuller)
  {
    super(paramVidToVideoInfoPuller);
  }
  
  public void a(@NonNull VidToVideoInfoPuller paramVidToVideoInfoPuller, @NonNull UidToVidHandler.GetUserVidListEvent paramGetUserVidListEvent)
  {
    if (paramGetUserVidListEvent.a != paramVidToVideoInfoPuller.h) {
      return;
    }
    Object localObject = paramGetUserVidListEvent.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((String)((Iterator)localObject).next()).equals(paramVidToVideoInfoPuller.j))
      {
        i = 1;
        break label60;
      }
    }
    int i = 0;
    label60:
    if (i == 0) {
      return;
    }
    if (paramGetUserVidListEvent.g.isFail())
    {
      paramVidToVideoInfoPuller.a(new ArrayList(), paramGetUserVidListEvent.g, true, false);
      StoryDispatcher.a().unRegisterSubscriber(this);
      paramVidToVideoInfoPuller.c = null;
      return;
    }
    localObject = new ArrayList();
    paramGetUserVidListEvent = paramGetUserVidListEvent.c.iterator();
    while (paramGetUserVidListEvent.hasNext())
    {
      GetVidListResponse.UserVidList localUserVidList = (GetVidListResponse.UserVidList)paramGetUserVidListEvent.next();
      if (localUserVidList.a.equals(paramVidToVideoInfoPuller.j)) {
        ((List)localObject).addAll(localUserVidList.b);
      }
    }
    SLog.d(this.TAG, String.format("Get %s vid list from net , %s", new Object[] { paramVidToVideoInfoPuller.j, localObject }));
    paramVidToVideoInfoPuller.a((List)localObject);
    StoryDispatcher.a().unRegisterSubscriber(this);
    paramVidToVideoInfoPuller.c = null;
  }
  
  public Class acceptEventClass()
  {
    return UidToVidHandler.GetUserVidListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.VidToVideoInfoPuller.StoryVidListReceiver
 * JD-Core Version:    0.7.0.1
 */