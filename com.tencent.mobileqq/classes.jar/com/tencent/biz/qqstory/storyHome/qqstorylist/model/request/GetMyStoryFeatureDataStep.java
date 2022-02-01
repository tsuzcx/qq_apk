package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.network.request.GetFeedFeatureRequest;
import com.tencent.biz.qqstory.network.response.GetFeedFeatureResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Arrays;
import java.util.List;

public class GetMyStoryFeatureDataStep
  implements CmdTaskManger.CommandCallback<GetFeedFeatureRequest, GetFeedFeatureResponse>, Step
{
  protected Step.FinishCallBack a;
  protected Step.ErrorCallBack b;
  protected GetMyStoryVideoListStep.Result c = null;
  
  public Object a()
  {
    return this.c;
  }
  
  public void a(@NonNull GetFeedFeatureRequest paramGetFeedFeatureRequest, @Nullable GetFeedFeatureResponse paramGetFeedFeatureResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramGetFeedFeatureResponse != null) && (paramErrorMessage.isSuccess()) && (paramGetFeedFeatureResponse.a != null) && (paramGetFeedFeatureResponse.a.size() > 0))
    {
      this.c.f = ((FeedFeatureItem)paramGetFeedFeatureResponse.a.get(0));
      paramGetFeedFeatureRequest = (StoryConfigManager)SuperManager.a(10);
      paramGetFeedFeatureRequest.d("qqstory_key_story_latest_feed_feature_feed_id", this.c.f.a);
      paramGetFeedFeatureRequest.d("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(this.c.f.b));
      paramGetFeedFeatureRequest.d("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(this.c.f.c));
      paramGetFeedFeatureRequest.d("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(this.c.f.d));
      paramGetFeedFeatureRequest = this.a;
      if (paramGetFeedFeatureRequest != null)
      {
        paramGetFeedFeatureRequest.a(c());
        return;
      }
      SLog.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    int i = paramErrorMessage.errorCode;
    if (paramGetFeedFeatureResponse == null) {
      paramGetFeedFeatureRequest = "rsp is null";
    } else if (paramGetFeedFeatureResponse.a == null) {
      paramGetFeedFeatureRequest = "features is null";
    } else {
      paramGetFeedFeatureRequest = "invalid rsp";
    }
    SLog.e("GetMyStoryFeatureDataStep", "请求Features失败 errorCode: %d %s", new Object[] { Integer.valueOf(i), paramGetFeedFeatureRequest });
    this.c.f = new FeedFeatureItem();
    this.c.f.a = this.c.b;
    paramGetFeedFeatureRequest = this.a;
    if (paramGetFeedFeatureRequest != null)
    {
      paramGetFeedFeatureRequest.a(c());
      return;
    }
    SLog.d("GetMyStoryFeatureDataStep", "finish callBack is null");
  }
  
  public void a(Step.ErrorCallBack paramErrorCallBack)
  {
    this.b = paramErrorCallBack;
  }
  
  public void a(Step.FinishCallBack paramFinishCallBack)
  {
    this.a = paramFinishCallBack;
  }
  
  public void a(Object paramObject)
  {
    this.c = ((GetMyStoryVideoListStep.Result)paramObject);
  }
  
  public void b()
  {
    SLog.c("GetMyStoryFeatureDataStep", "GetMyStoryFeatureDataStep");
    Object localObject = this.c;
    if ((localObject != null) && (!TextUtils.isEmpty(((GetMyStoryVideoListStep.Result)localObject).b)))
    {
      localObject = new GetFeedFeatureRequest();
      ((GetFeedFeatureRequest)localObject).f = Arrays.asList(new String[] { this.c.b });
      CmdTaskManger.a().a((NetworkRequest)localObject, this);
      return;
    }
    localObject = this.a;
    if (localObject != null)
    {
      ((Step.FinishCallBack)localObject).a(c());
      return;
    }
    SLog.d("GetMyStoryFeatureDataStep", "finish callBack is null");
  }
  
  public String c()
  {
    return getClass().getSimpleName();
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void e() {}
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryFeatureDataStep
 * JD-Core Version:    0.7.0.1
 */