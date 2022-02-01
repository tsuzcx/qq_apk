package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.network.handler.UidToVidHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

class VidToVideoInfoPuller$3
  extends SimpleJob<Object>
{
  VidToVideoInfoPuller$3(VidToVideoInfoPuller paramVidToVideoInfoPuller, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (StoryManager)SuperManager.a(5);
    if (!this.a.jdField_a_of_type_Boolean) {
      if (this.a.jdField_b_of_type_Int == 3) {
        paramJobContext = paramJobContext.e(this.a.jdField_b_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      paramVarArgs = paramJobContext;
      if (paramJobContext == null) {
        paramVarArgs = new ArrayList();
      }
      if (paramVarArgs.size() > 0)
      {
        this.a.a(paramVarArgs);
        SLog.d("Q.qqstory.net:VidToVideoInfoPuller", String.format("Found %s vid list from local , pullType is %d , %s", new Object[] { this.a.jdField_b_of_type_JavaLangString, Integer.valueOf(this.a.jdField_b_of_type_Int), paramVarArgs }));
        return null;
        paramJobContext = paramJobContext.b(this.a.jdField_b_of_type_JavaLangString);
      }
      else
      {
        SLog.d("Q.qqstory.net:VidToVideoInfoPuller", String.format("Cannot found %s vid list from local , pullType is %d , request from net", new Object[] { this.a.jdField_b_of_type_JavaLangString, Integer.valueOf(this.a.jdField_b_of_type_Int) }));
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryModelVidToVideoInfoPuller$StoryVidListReceiver == null)
        {
          this.a.jdField_a_of_type_ComTencentBizQqstoryModelVidToVideoInfoPuller$StoryVidListReceiver = new VidToVideoInfoPuller.StoryVidListReceiver(this.a);
          StoryDispatcher.a().registerSubscriber(this.a.jdField_a_of_type_ComTencentBizQqstoryModelVidToVideoInfoPuller$StoryVidListReceiver);
        }
        paramJobContext = new ArrayList();
        paramJobContext.add(this.a.jdField_b_of_type_JavaLangString);
        this.a.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerUidToVidHandler = new UidToVidHandler(paramJobContext, this.a.jdField_b_of_type_Int);
        this.a.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerUidToVidHandler.a();
        return null;
        paramJobContext = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.VidToVideoInfoPuller.3
 * JD-Core Version:    0.7.0.1
 */