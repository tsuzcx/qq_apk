package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.support.logging.SLog;

public class GetUserSelfInfoStep
  extends SimpleStep
  implements CmdTaskManger.CommandCallback<GetUserSelfInfoStep.Request, GetUserSelfInfoStep.Response>
{
  private Repository jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository;
  private boolean jdField_a_of_type_Boolean = false;
  
  public GetUserSelfInfoStep(Repository paramRepository)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository = paramRepository;
  }
  
  public static boolean a(MyStorys paramMyStorys)
  {
    if (paramMyStorys == null) {
      throw new IllegalArgumentException("argument can't be null");
    }
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    paramMyStorys.jdField_b_of_type_Int = ((Integer)localStoryConfigManager.b("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
    if (((Integer)localStoryConfigManager.b("qqstory_i_am_vip", Integer.valueOf(0))).intValue() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramMyStorys.jdField_c_of_type_Boolean = bool;
      paramMyStorys.jdField_c_of_type_Int = ((Integer)localStoryConfigManager.b("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      paramMyStorys.a = ((Integer)localStoryConfigManager.b("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      paramMyStorys.jdField_b_of_type_JavaLangString = ((String)localStoryConfigManager.b("qqstory_my_newest_video_cover", ""));
      paramMyStorys.jdField_c_of_type_JavaLangString = ((String)localStoryConfigManager.b("qqstory_my_newest_video_vid", ""));
      return true;
    }
  }
  
  public String a()
  {
    return "GetUserSelfInfoStep";
  }
  
  public void a()
  {
    SLog.d("Q.qqstory.home.GetUserSelfInfoStep", "run");
    GetUserSelfInfoStep.Request localRequest = new GetUserSelfInfoStep.Request();
    CmdTaskManger.a().a(localRequest, this);
  }
  
  public void a(@NonNull GetUserSelfInfoStep.Request paramRequest, @Nullable GetUserSelfInfoStep.Response paramResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool = true;
    SLog.d("Q.qqstory.home.GetUserSelfInfoStep", "onCmdRespond");
    if (b())
    {
      SLog.e("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest was reseted !");
      d();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      SLog.c("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest is failed", paramErrorMessage);
      b(paramErrorMessage);
      return;
    }
    paramRequest = (UserManager)SuperManager.a(2);
    if (paramRequest.b(paramResponse.a) == null)
    {
      paramErrorMessage = new QQUserUIItem();
      paramErrorMessage.uid = paramResponse.a;
      if (paramResponse.jdField_b_of_type_Int != 1) {
        break label129;
      }
    }
    for (;;)
    {
      paramErrorMessage.isVip = bool;
      paramRequest.a(paramErrorMessage);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.a(new GetUserSelfInfoStep.1(this, paramResponse));
      return;
      label129:
      bool = false;
    }
    SLog.a("Q.qqstory.home.GetUserSelfInfoStep", "receive the user self2 info: %s", paramResponse);
    paramRequest = (StoryConfigManager)SuperManager.a(10);
    paramRequest.b("qqstory_my_fans_count", Integer.valueOf(paramResponse.jdField_c_of_type_Int));
    paramRequest.b("qqstory_i_am_vip", Integer.valueOf(paramResponse.jdField_b_of_type_Int));
    paramRequest.b("qqstory_my_vidoe_count", Integer.valueOf(paramResponse.jdField_d_of_type_Int));
    paramRequest.b("qqstory_my_visiter_count", Integer.valueOf(paramResponse.e));
    paramRequest.b("qqstory_my_newest_video_cover", paramResponse.jdField_c_of_type_JavaLangString);
    paramRequest.b("qqstory_my_newest_video_vid", paramResponse.jdField_d_of_type_JavaLangString);
    QQStoryContext.a().a(paramResponse.a);
    d();
  }
  
  public void b() {}
  
  public boolean b()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep
 * JD-Core Version:    0.7.0.1
 */