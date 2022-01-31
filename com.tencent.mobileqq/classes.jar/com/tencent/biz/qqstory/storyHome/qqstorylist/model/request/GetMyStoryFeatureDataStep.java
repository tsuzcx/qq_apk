package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.network.request.GetFeedFeatureRequest;
import com.tencent.biz.qqstory.network.response.GetFeedFeatureResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Arrays;
import java.util.List;

public class GetMyStoryFeatureDataStep
  implements CmdTaskManger.CommandCallback, Step
{
  protected GetMyStoryVideoListStep.Result a;
  protected Step.ErrorCallBack a;
  protected Step.FinishCallBack a;
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result;
  }
  
  public String a()
  {
    return getClass().getSimpleName();
  }
  
  public void a()
  {
    SLog.c("GetMyStoryFeatureDataStep", "GetMyStoryFeatureDataStep");
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack.a(a());
        return;
      }
      SLog.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    GetFeedFeatureRequest localGetFeedFeatureRequest = new GetFeedFeatureRequest();
    localGetFeedFeatureRequest.a = Arrays.asList(new String[] { this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result.jdField_a_of_type_JavaLangString });
    CmdTaskManger.a().a(localGetFeedFeatureRequest, this);
  }
  
  public void a(@NonNull GetFeedFeatureRequest paramGetFeedFeatureRequest, @Nullable GetFeedFeatureResponse paramGetFeedFeatureResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramGetFeedFeatureResponse != null) && (paramErrorMessage.isSuccess()) && (paramGetFeedFeatureResponse.a != null) && (paramGetFeedFeatureResponse.a.size() > 0))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem = ((FeedFeatureItem)paramGetFeedFeatureResponse.a.get(0));
      paramGetFeedFeatureRequest = (StoryConfigManager)SuperManager.a(10);
      paramGetFeedFeatureRequest.b("qqstory_key_story_latest_feed_feature_feed_id", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_a_of_type_JavaLangString);
      paramGetFeedFeatureRequest.b("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_a_of_type_Int));
      paramGetFeedFeatureRequest.b("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.b));
      paramGetFeedFeatureRequest.b("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.c));
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack.a(a());
        return;
      }
      SLog.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    int i = paramErrorMessage.errorCode;
    if (paramGetFeedFeatureResponse == null) {
      paramGetFeedFeatureRequest = "rsp is null";
    }
    for (;;)
    {
      SLog.e("GetMyStoryFeatureDataStep", "请求Features失败 errorCode: %d %s", new Object[] { Integer.valueOf(i), paramGetFeedFeatureRequest });
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem = new FeedFeatureItem();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack.a(a());
      return;
      if (paramGetFeedFeatureResponse.a == null) {
        paramGetFeedFeatureRequest = "features is null";
      } else {
        paramGetFeedFeatureRequest = "invalid rsp";
      }
    }
    SLog.d("GetMyStoryFeatureDataStep", "finish callBack is null");
  }
  
  public void a(Step.ErrorCallBack paramErrorCallBack)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack = paramErrorCallBack;
  }
  
  public void a(Step.FinishCallBack paramFinishCallBack)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack = paramFinishCallBack;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result = ((GetMyStoryVideoListStep.Result)paramObject);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryFeatureDataStep
 * JD-Core Version:    0.7.0.1
 */