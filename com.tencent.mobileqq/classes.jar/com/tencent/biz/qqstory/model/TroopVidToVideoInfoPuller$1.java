package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.network.handler.TroopUidToVidListHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

class TroopVidToVideoInfoPuller$1
  extends SimpleJob<Object>
{
  TroopVidToVideoInfoPuller$1(TroopVidToVideoInfoPuller paramTroopVidToVideoInfoPuller, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (StoryManager)SuperManager.a(5);
    if ((!this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_Int == 3)) {}
    for (paramJobContext = paramJobContext.e(this.a.jdField_a_of_type_JavaLangString);; paramJobContext = null)
    {
      paramVarArgs = paramJobContext;
      if (paramJobContext == null) {
        paramVarArgs = new ArrayList();
      }
      if (paramVarArgs.size() > 0)
      {
        this.a.a(paramVarArgs);
        SLog.d("Q.qqstory.net:TroopVidToVideoInfoPuller", String.format("Found %s vid list from local , pullType is %d , %s", new Object[] { this.a.jdField_a_of_type_JavaLangString, Integer.valueOf(this.a.jdField_a_of_type_Int), paramVarArgs }));
        return null;
      }
      SLog.d("Q.qqstory.net:TroopVidToVideoInfoPuller", String.format("Cannot found %s vid list from local , pullType is %d , request from net", new Object[] { this.a.jdField_a_of_type_JavaLangString, Integer.valueOf(this.a.jdField_a_of_type_Int) }));
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller$StoryVidListReceiver == null)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller$StoryVidListReceiver = new TroopVidToVideoInfoPuller.StoryVidListReceiver(this.a);
        StoryDispatcher.a().registerSubscriber(this.a.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller$StoryVidListReceiver);
      }
      this.a.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerTroopUidToVidListHandler = new TroopUidToVidListHandler(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int);
      this.a.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerTroopUidToVidListHandler.a();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TroopVidToVideoInfoPuller.1
 * JD-Core Version:    0.7.0.1
 */