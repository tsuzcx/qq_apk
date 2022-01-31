package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.TroopUidToVidListHandler.GetTroopVidListEvent;
import com.tencent.biz.qqstory.network.response.GetGroupVidListResponse.UserVidList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class TroopVidToVideoInfoPuller$StoryVidListReceiver
  extends QQUIEventReceiver
{
  public TroopVidToVideoInfoPuller$StoryVidListReceiver(@NonNull TroopVidToVideoInfoPuller paramTroopVidToVideoInfoPuller)
  {
    super(paramTroopVidToVideoInfoPuller);
  }
  
  public void a(@NonNull TroopVidToVideoInfoPuller paramTroopVidToVideoInfoPuller, @NonNull TroopUidToVidListHandler.GetTroopVidListEvent paramGetTroopVidListEvent)
  {
    if (paramGetTroopVidListEvent.jdField_a_of_type_Int != paramTroopVidToVideoInfoPuller.jdField_a_of_type_Int) {}
    for (;;)
    {
      return;
      if (paramTroopVidToVideoInfoPuller.jdField_a_of_type_JavaLangString.equals(paramGetTroopVidListEvent.jdField_a_of_type_JavaLangString)) {}
      for (int i = 1; i != 0; i = 0)
      {
        if (paramGetTroopVidListEvent.errorInfo.isFail())
        {
          paramTroopVidToVideoInfoPuller.a(new ArrayList(), paramGetTroopVidListEvent.errorInfo, true, false);
          Dispatchers.get().unRegisterSubscriber(this);
          paramTroopVidToVideoInfoPuller.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller$StoryVidListReceiver = null;
          return;
        }
        ArrayList localArrayList = new ArrayList();
        paramGetTroopVidListEvent = paramGetTroopVidListEvent.jdField_a_of_type_ComTencentBizQqstoryNetworkResponseGetGroupVidListResponse$UserVidList;
        if (paramGetTroopVidListEvent.jdField_a_of_type_JavaLangString.equals(paramTroopVidToVideoInfoPuller.jdField_a_of_type_JavaLangString)) {
          localArrayList.addAll(paramGetTroopVidListEvent.jdField_a_of_type_JavaUtilList);
        }
        SLog.d(this.TAG, String.format("Get %s vid list from net , %s", new Object[] { paramTroopVidToVideoInfoPuller.jdField_a_of_type_JavaLangString, localArrayList }));
        paramTroopVidToVideoInfoPuller.a(localArrayList);
        Dispatchers.get().unRegisterSubscriber(this);
        paramTroopVidToVideoInfoPuller.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller$StoryVidListReceiver = null;
        return;
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return TroopUidToVidListHandler.GetTroopVidListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TroopVidToVideoInfoPuller.StoryVidListReceiver
 * JD-Core Version:    0.7.0.1
 */