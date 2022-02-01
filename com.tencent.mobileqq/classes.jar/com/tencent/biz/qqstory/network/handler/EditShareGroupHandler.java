package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.request.EditShareGroupRequest;
import com.tencent.biz.qqstory.network.response.EditShareGroupResponse;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;

public class EditShareGroupHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback<EditShareGroupRequest, EditShareGroupResponse>
{
  public ShareGroupItem c;
  
  public void a()
  {
    Object localObject = new EditShareGroupRequest();
    ((EditShareGroupRequest)localObject).f = this.c;
    CmdTaskManger.a().a((NetworkRequest)localObject, this);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ReqEditShareGroupHandler sendRequest shareGroupInfo = ");
      ((StringBuilder)localObject).append(this.c);
      QLog.e("Q.qqstory.shareGroup.ReqEditShareGroupHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(@NonNull EditShareGroupRequest paramEditShareGroupRequest, @Nullable EditShareGroupResponse paramEditShareGroupResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    paramEditShareGroupRequest = (ShareGroupManager)SuperManager.a(7);
    ShareGroupItem localShareGroupItem = paramEditShareGroupRequest.a(this.c.shareGroupId);
    EditShareGroupHandler.EditShareGroupEvent localEditShareGroupEvent = new EditShareGroupHandler.EditShareGroupEvent();
    localEditShareGroupEvent.g = paramErrorMessage;
    if ((localShareGroupItem != null) && (paramErrorMessage.isSuccess()) && (paramEditShareGroupResponse != null))
    {
      localShareGroupItem.name = this.c.name;
      paramEditShareGroupRequest.a(localShareGroupItem);
      c();
    }
    else
    {
      d();
    }
    localEditShareGroupEvent.a = localShareGroupItem;
    StoryDispatcher.a().dispatch(localEditShareGroupEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.EditShareGroupHandler
 * JD-Core Version:    0.7.0.1
 */