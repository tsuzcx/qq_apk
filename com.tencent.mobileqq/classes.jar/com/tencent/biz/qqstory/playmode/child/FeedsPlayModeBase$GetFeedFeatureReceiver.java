package com.tencent.biz.qqstory.playmode.child;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler.GetFeedFeatureEvent;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;
import nif;

public final class FeedsPlayModeBase$GetFeedFeatureReceiver
  extends QQUIEventReceiver
{
  public FeedsPlayModeBase$GetFeedFeatureReceiver(@NonNull FeedsPlayModeBase paramFeedsPlayModeBase)
  {
    super(paramFeedsPlayModeBase);
  }
  
  public void a(@NonNull FeedsPlayModeBase paramFeedsPlayModeBase, @NonNull GetFeedFeatureHandler.GetFeedFeatureEvent paramGetFeedFeatureEvent)
  {
    if ((paramGetFeedFeatureEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramGetFeedFeatureEvent.jdField_a_of_type_JavaUtilList != null) && (!paramGetFeedFeatureEvent.jdField_a_of_type_JavaUtilList.isEmpty())) {
      paramFeedsPlayModeBase.a.post(new nif(this, paramFeedsPlayModeBase));
    }
  }
  
  public Class acceptEventClass()
  {
    return GetFeedFeatureHandler.GetFeedFeatureEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.FeedsPlayModeBase.GetFeedFeatureReceiver
 * JD-Core Version:    0.7.0.1
 */