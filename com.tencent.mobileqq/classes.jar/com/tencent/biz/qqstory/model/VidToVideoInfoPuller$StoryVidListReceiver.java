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
    if (paramGetUserVidListEvent.jdField_a_of_type_Int != paramVidToVideoInfoPuller.jdField_b_of_type_Int) {}
    for (;;)
    {
      return;
      Object localObject = paramGetUserVidListEvent.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((String)((Iterator)localObject).next()).equals(paramVidToVideoInfoPuller.jdField_b_of_type_JavaLangString));
      for (int i = 1; i != 0; i = 0)
      {
        if (paramGetUserVidListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
        {
          paramVidToVideoInfoPuller.a(new ArrayList(), paramGetUserVidListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, true, false);
          StoryDispatcher.a().unRegisterSubscriber(this);
          paramVidToVideoInfoPuller.a = null;
          return;
        }
        localObject = new ArrayList();
        paramGetUserVidListEvent = paramGetUserVidListEvent.b.iterator();
        while (paramGetUserVidListEvent.hasNext())
        {
          GetVidListResponse.UserVidList localUserVidList = (GetVidListResponse.UserVidList)paramGetUserVidListEvent.next();
          if (localUserVidList.jdField_a_of_type_JavaLangString.equals(paramVidToVideoInfoPuller.jdField_b_of_type_JavaLangString)) {
            ((List)localObject).addAll(localUserVidList.jdField_a_of_type_JavaUtilList);
          }
        }
        SLog.d(this.TAG, String.format("Get %s vid list from net , %s", new Object[] { paramVidToVideoInfoPuller.jdField_b_of_type_JavaLangString, localObject }));
        paramVidToVideoInfoPuller.a((List)localObject);
        StoryDispatcher.a().unRegisterSubscriber(this);
        paramVidToVideoInfoPuller.a = null;
        return;
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return UidToVidHandler.GetUserVidListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.VidToVideoInfoPuller.StoryVidListReceiver
 * JD-Core Version:    0.7.0.1
 */