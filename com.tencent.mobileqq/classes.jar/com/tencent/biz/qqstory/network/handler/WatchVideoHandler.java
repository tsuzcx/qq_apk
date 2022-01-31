package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.ReportWatchVideoManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.WatchVideoRequest;
import com.tencent.biz.qqstory.network.response.WatchVideoResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.HashSet;
import java.util.Set;

public class WatchVideoHandler
  implements CmdTaskManger.CommandCallback
{
  public Set a = new HashSet();
  
  public void a(@NonNull WatchVideoRequest paramWatchVideoRequest, @Nullable WatchVideoResponse paramWatchVideoResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    WatchVideoHandler.WatchVideoEvent localWatchVideoEvent = new WatchVideoHandler.WatchVideoEvent();
    localWatchVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    localWatchVideoEvent.jdField_a_of_type_JavaLangString = paramWatchVideoRequest.b;
    if (TroopStoryUtil.a(localWatchVideoEvent.jdField_a_of_type_JavaLangString)) {
      paramWatchVideoRequest.jdField_c_of_type_JavaLangString = "4_10000";
    }
    localWatchVideoEvent.b = paramWatchVideoRequest.jdField_c_of_type_JavaLangString;
    localWatchVideoEvent.jdField_a_of_type_Boolean = paramWatchVideoRequest.jdField_a_of_type_Boolean;
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    if ((paramWatchVideoRequest.jdField_c_of_type_Int == 3) || (paramWatchVideoRequest.jdField_c_of_type_Int == 4) || (paramWatchVideoRequest.jdField_c_of_type_Int == 31) || (paramWatchVideoRequest.jdField_c_of_type_Int == 62))
    {
      localWatchVideoEvent.jdField_a_of_type_Int = localStoryManager.a("Q.qqstory.player.WatchVideoHandler", paramWatchVideoRequest.jdField_c_of_type_JavaLangString, paramWatchVideoRequest.b);
      StoryItem localStoryItem = localStoryManager.a(paramWatchVideoRequest.jdField_c_of_type_JavaLangString, 1);
      if (localStoryItem != null)
      {
        if (localStoryItem.unReadCount == 0) {
          break label281;
        }
        localStoryItem.unReadCount = localWatchVideoEvent.jdField_a_of_type_Int;
        localStoryManager.a(paramWatchVideoRequest.jdField_c_of_type_JavaLangString, 1, localStoryItem);
        SLog.d("Q.qqstory.player.WatchVideoHandler", String.format("read video %s ,update %s unread count , count = %d", new Object[] { paramWatchVideoRequest.b, localStoryItem.key, Integer.valueOf(localStoryItem.unReadCount) }));
      }
      label210:
      if ((paramWatchVideoResponse == null) || (!paramErrorMessage.isSuccess())) {
        break label294;
      }
      this.a.add(paramWatchVideoRequest.b);
      Dispatchers.get().dispatch(localWatchVideoEvent);
    }
    label281:
    label294:
    do
    {
      return;
      localWatchVideoEvent.jdField_a_of_type_Int = localStoryManager.a(paramWatchVideoRequest.jdField_c_of_type_JavaLangString);
      SLog.a("Q.qqstory.player.WatchVideoHandler", "read video %s , source = %d , not effect recent story", paramWatchVideoRequest.b, Integer.valueOf(paramWatchVideoRequest.jdField_c_of_type_Int));
      break;
      localStoryManager.a(paramWatchVideoRequest.jdField_c_of_type_JavaLangString, 1);
      break label210;
      Dispatchers.get().dispatch(localWatchVideoEvent);
      paramWatchVideoResponse = localStoryManager.a(paramWatchVideoRequest.b);
    } while (paramWatchVideoResponse == null);
    ((ReportWatchVideoManager)SuperManager.a(13)).a(paramWatchVideoRequest.b, paramWatchVideoRequest.jdField_c_of_type_JavaLangString, paramWatchVideoRequest.jdField_a_of_type_Boolean, paramWatchVideoResponse.mCreateTime, paramWatchVideoRequest.jdField_c_of_type_Int, paramWatchVideoRequest.d, true);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    WatchVideoRequest localWatchVideoRequest = new WatchVideoRequest();
    localWatchVideoRequest.b = paramString1;
    localWatchVideoRequest.jdField_c_of_type_JavaLangString = paramString2;
    localWatchVideoRequest.jdField_a_of_type_Boolean = paramBoolean;
    localWatchVideoRequest.jdField_c_of_type_Int = paramInt;
    localWatchVideoRequest.jdField_a_of_type_Long = paramLong;
    CmdTaskManger.a().a(localWatchVideoRequest, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.WatchVideoHandler
 * JD-Core Version:    0.7.0.1
 */