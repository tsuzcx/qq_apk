package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.List;

public class GetPhotographyGuideInfoStep
  extends SimpleStep
  implements CmdTaskManger.CommandCallback<GetPhotographyGuideInfoStep.GetPhotographyGuideRequest, GetPhotographyGuideInfoStep.GetPhotographyGuideResponse>
{
  private boolean a = false;
  
  public void a(@NonNull GetPhotographyGuideInfoStep.GetPhotographyGuideRequest paramGetPhotographyGuideRequest, @Nullable GetPhotographyGuideInfoStep.GetPhotographyGuideResponse paramGetPhotographyGuideResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramGetPhotographyGuideResponse != null))
    {
      SLog.b("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond success.");
      paramGetPhotographyGuideRequest = (StoryConfigManager)SuperManager.a(10);
      paramGetPhotographyGuideResponse = paramGetPhotographyGuideResponse.a;
      if ((paramGetPhotographyGuideResponse != null) && (paramGetPhotographyGuideResponse.size() > 0)) {
        paramGetPhotographyGuideRequest.d("StorySvc.get_photography_guide.word", paramGetPhotographyGuideResponse.get(0));
      } else {
        paramGetPhotographyGuideRequest.d("StorySvc.get_photography_guide.word", HardCodeUtil.a(2131903236));
      }
      h();
      return;
    }
    SLog.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramGetPhotographyGuideRequest });
    b(paramErrorMessage);
  }
  
  public void b()
  {
    SLog.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "run");
    GetPhotographyGuideInfoStep.GetPhotographyGuideRequest localGetPhotographyGuideRequest = new GetPhotographyGuideInfoStep.GetPhotographyGuideRequest();
    CmdTaskManger.a().a(localGetPhotographyGuideRequest, this);
  }
  
  public String c()
  {
    return "GetPhotographyGuideInfoStep";
  }
  
  public void e() {}
  
  public void f()
  {
    try
    {
      this.a = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetPhotographyGuideInfoStep
 * JD-Core Version:    0.7.0.1
 */