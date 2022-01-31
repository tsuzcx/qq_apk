package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.request.EditShareGroupRequest;
import com.tencent.biz.qqstory.network.response.EditShareGroupResponse;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class EditShareGroupHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback
{
  public ShareGroupItem a;
  
  public void a()
  {
    EditShareGroupRequest localEditShareGroupRequest = new EditShareGroupRequest();
    localEditShareGroupRequest.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem;
    CmdTaskManger.a().a(localEditShareGroupRequest, this);
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.shareGroup.ReqEditShareGroupHandler", 2, "ReqEditShareGroupHandler sendRequest shareGroupInfo = " + this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
    }
  }
  
  public void a(@NonNull EditShareGroupRequest paramEditShareGroupRequest, @Nullable EditShareGroupResponse paramEditShareGroupResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    paramEditShareGroupRequest = (ShareGroupManager)SuperManager.a(7);
    ShareGroupItem localShareGroupItem = paramEditShareGroupRequest.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.shareGroupId);
    EditShareGroupHandler.EditShareGroupEvent localEditShareGroupEvent = new EditShareGroupHandler.EditShareGroupEvent();
    localEditShareGroupEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isSuccess()) && (paramEditShareGroupResponse != null))
    {
      localShareGroupItem.name = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.name;
      paramEditShareGroupRequest.a(localShareGroupItem);
      b();
    }
    for (;;)
    {
      localEditShareGroupEvent.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = localShareGroupItem;
      Dispatchers.get().dispatch(localEditShareGroupEvent);
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.EditShareGroupHandler
 * JD-Core Version:    0.7.0.1
 */