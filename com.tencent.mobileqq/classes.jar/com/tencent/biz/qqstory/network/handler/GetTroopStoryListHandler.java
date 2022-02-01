package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.network.request.GetTroopStoryListRequest;
import com.tencent.biz.qqstory.network.response.GetTroopStoryListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tribe.async.dispatch.Dispatcher;

public class GetTroopStoryListHandler
  implements CmdTaskManger.CommandCallback<GetTroopStoryListRequest, GetTroopStoryListResponse>
{
  StoryConfigManager jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager;
  String jdField_a_of_type_JavaLangString;
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    GetTroopStoryListRequest localGetTroopStoryListRequest = new GetTroopStoryListRequest();
    localGetTroopStoryListRequest.b = paramLong;
    localGetTroopStoryListRequest.d = 20;
    localGetTroopStoryListRequest.c = paramInt2;
    localGetTroopStoryListRequest.f = paramInt1;
    StoryConfigManager localStoryConfigManager = this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TROOP_STORY_TIMEZONE");
    localStringBuilder.append(String.valueOf(paramLong));
    paramInt1 = ((Integer)localStoryConfigManager.b(localStringBuilder.toString(), Integer.valueOf(-1))).intValue();
    paramInt2 = UIUtils.a();
    if (paramInt1 != paramInt2)
    {
      localStoryConfigManager = this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TROOP_STORY_TIMEZONE");
      localStringBuilder.append(String.valueOf(paramLong));
      localStoryConfigManager.b(localStringBuilder.toString(), Integer.valueOf(paramInt2));
      localGetTroopStoryListRequest.f = 0;
    }
    localGetTroopStoryListRequest.e = paramInt2;
    CmdTaskManger.a().a(localGetTroopStoryListRequest, this);
  }
  
  public void a(long paramLong, int paramInt)
  {
    int i = paramInt;
    if (paramInt == -1)
    {
      StoryConfigManager localStoryConfigManager = this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TROOP_STORY_COOKIE");
      localStringBuilder.append(String.valueOf(paramLong));
      i = ((Integer)localStoryConfigManager.b(localStringBuilder.toString(), Integer.valueOf(0))).intValue();
    }
    a(paramLong, 0, i);
  }
  
  public void a(@NonNull GetTroopStoryListRequest paramGetTroopStoryListRequest, @Nullable GetTroopStoryListResponse paramGetTroopStoryListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    GetTroopStoryListHandler.GetTroopStoryListEvent localGetTroopStoryListEvent = new GetTroopStoryListHandler.GetTroopStoryListEvent(this.jdField_a_of_type_JavaLangString, paramErrorMessage);
    int i = paramGetTroopStoryListRequest.c;
    boolean bool2 = true;
    boolean bool1;
    if (i == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localGetTroopStoryListEvent.c = bool1;
    if ((paramGetTroopStoryListResponse != null) && (!paramErrorMessage.isFail()))
    {
      localGetTroopStoryListEvent.b = false;
      localGetTroopStoryListEvent.jdField_a_of_type_Boolean = paramGetTroopStoryListResponse.jdField_a_of_type_Boolean;
      if (paramGetTroopStoryListResponse.c != paramGetTroopStoryListRequest.f) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localGetTroopStoryListEvent.e = bool1;
      localGetTroopStoryListEvent.jdField_a_of_type_JavaUtilList = paramGetTroopStoryListResponse.jdField_a_of_type_JavaUtilArrayList;
      if (localGetTroopStoryListEvent.jdField_a_of_type_JavaLangString.equals("REQUEST_CONTEXT_SAVE_COOKIE"))
      {
        paramErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("TROOP_STORY_COOKIE");
        localStringBuilder.append(String.valueOf(paramGetTroopStoryListRequest.b));
        paramErrorMessage.b(localStringBuilder.toString(), Integer.valueOf(paramGetTroopStoryListResponse.b));
        paramErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("TROOP_STORY_PAGE_IS_END");
        localStringBuilder.append(String.valueOf(paramGetTroopStoryListRequest.b));
        paramErrorMessage.b(localStringBuilder.toString(), Boolean.valueOf(paramGetTroopStoryListResponse.jdField_a_of_type_Boolean));
        if (localGetTroopStoryListEvent.e)
        {
          paramErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("TROOP_STORY_SEQ710");
          localStringBuilder.append(String.valueOf(paramGetTroopStoryListRequest.b));
          paramErrorMessage.b(localStringBuilder.toString(), Integer.valueOf(paramGetTroopStoryListResponse.c));
        }
      }
      else
      {
        localGetTroopStoryListEvent.jdField_a_of_type_Int = paramGetTroopStoryListResponse.b;
      }
      SLog.a("Q.qqstory.troopmemories:GetTroopStoryListHandler", "onCmdRespond：", paramGetTroopStoryListResponse);
      StoryDispatcher.a().dispatch(localGetTroopStoryListEvent);
      return;
    }
    StoryDispatcher.a().dispatch(localGetTroopStoryListEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetTroopStoryListHandler
 * JD-Core Version:    0.7.0.1
 */