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
    paramInt1 = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("TROOP_STORY_TIMEZONE" + String.valueOf(paramLong), Integer.valueOf(-1))).intValue();
    paramInt2 = UIUtils.a();
    if (paramInt1 != paramInt2)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("TROOP_STORY_TIMEZONE" + String.valueOf(paramLong), Integer.valueOf(paramInt2));
      localGetTroopStoryListRequest.f = 0;
    }
    localGetTroopStoryListRequest.e = paramInt2;
    CmdTaskManger.a().a(localGetTroopStoryListRequest, this);
  }
  
  public void a(long paramLong, int paramInt)
  {
    int i = paramInt;
    if (paramInt == -1) {
      i = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("TROOP_STORY_COOKIE" + String.valueOf(paramLong), Integer.valueOf(0))).intValue();
    }
    a(paramLong, 0, i);
  }
  
  public void a(@NonNull GetTroopStoryListRequest paramGetTroopStoryListRequest, @Nullable GetTroopStoryListResponse paramGetTroopStoryListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool2 = true;
    GetTroopStoryListHandler.GetTroopStoryListEvent localGetTroopStoryListEvent = new GetTroopStoryListHandler.GetTroopStoryListEvent(this.jdField_a_of_type_JavaLangString, paramErrorMessage);
    if (paramGetTroopStoryListRequest.c == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localGetTroopStoryListEvent.c = bool1;
      if ((paramGetTroopStoryListResponse != null) && (!paramErrorMessage.isFail())) {
        break;
      }
      StoryDispatcher.a().dispatch(localGetTroopStoryListEvent);
      return;
    }
    localGetTroopStoryListEvent.b = false;
    localGetTroopStoryListEvent.jdField_a_of_type_Boolean = paramGetTroopStoryListResponse.jdField_a_of_type_Boolean;
    if (paramGetTroopStoryListResponse.c != paramGetTroopStoryListRequest.f)
    {
      bool1 = bool2;
      localGetTroopStoryListEvent.e = bool1;
      localGetTroopStoryListEvent.jdField_a_of_type_JavaUtilList = paramGetTroopStoryListResponse.jdField_a_of_type_JavaUtilArrayList;
      if (!localGetTroopStoryListEvent.jdField_a_of_type_JavaLangString.equals("REQUEST_CONTEXT_SAVE_COOKIE")) {
        break label271;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("TROOP_STORY_COOKIE" + String.valueOf(paramGetTroopStoryListRequest.b), Integer.valueOf(paramGetTroopStoryListResponse.b));
      this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("TROOP_STORY_PAGE_IS_END" + String.valueOf(paramGetTroopStoryListRequest.b), Boolean.valueOf(paramGetTroopStoryListResponse.jdField_a_of_type_Boolean));
      if (localGetTroopStoryListEvent.e) {
        this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("TROOP_STORY_SEQ710" + String.valueOf(paramGetTroopStoryListRequest.b), Integer.valueOf(paramGetTroopStoryListResponse.c));
      }
    }
    for (;;)
    {
      SLog.a("Q.qqstory.troopmemories:GetTroopStoryListHandler", "onCmdRespond：", paramGetTroopStoryListResponse);
      StoryDispatcher.a().dispatch(localGetTroopStoryListEvent);
      return;
      bool1 = false;
      break;
      label271:
      localGetTroopStoryListEvent.jdField_a_of_type_Int = paramGetTroopStoryListResponse.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetTroopStoryListHandler
 * JD-Core Version:    0.7.0.1
 */