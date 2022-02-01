package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.network.handler.TroopUidToVidListHandler.GetTroopVidListEvent;
import com.tencent.biz.qqstory.network.response.GetGroupVidListResponse.UserVidList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class TroopVidToVideoInfoPuller$StoryVidListReceiver
  extends QQUIEventReceiver<TroopVidToVideoInfoPuller, TroopUidToVidListHandler.GetTroopVidListEvent>
{
  public TroopVidToVideoInfoPuller$StoryVidListReceiver(@NonNull TroopVidToVideoInfoPuller paramTroopVidToVideoInfoPuller)
  {
    super(paramTroopVidToVideoInfoPuller);
  }
  
  public void a(@NonNull TroopVidToVideoInfoPuller paramTroopVidToVideoInfoPuller, @NonNull TroopUidToVidListHandler.GetTroopVidListEvent paramGetTroopVidListEvent)
  {
    if (paramGetTroopVidListEvent.a != paramTroopVidToVideoInfoPuller.g) {
      return;
    }
    if (!paramTroopVidToVideoInfoPuller.h.equals(paramGetTroopVidListEvent.b)) {
      return;
    }
    if (paramGetTroopVidListEvent.g.isFail())
    {
      paramTroopVidToVideoInfoPuller.a(new ArrayList(), paramGetTroopVidListEvent.g, true, false);
      StoryDispatcher.a().unRegisterSubscriber(this);
      paramTroopVidToVideoInfoPuller.c = null;
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramGetTroopVidListEvent = paramGetTroopVidListEvent.c;
    if (paramGetTroopVidListEvent.a.equals(paramTroopVidToVideoInfoPuller.h)) {
      localArrayList.addAll(paramGetTroopVidListEvent.b);
    }
    SLog.d(this.TAG, String.format("Get %s vid list from net , %s", new Object[] { paramTroopVidToVideoInfoPuller.h, localArrayList }));
    paramTroopVidToVideoInfoPuller.a(localArrayList);
    StoryDispatcher.a().unRegisterSubscriber(this);
    paramTroopVidToVideoInfoPuller.c = null;
  }
  
  public Class acceptEventClass()
  {
    return TroopUidToVidListHandler.GetTroopVidListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TroopVidToVideoInfoPuller.StoryVidListReceiver
 * JD-Core Version:    0.7.0.1
 */