package com.tencent.biz.qqstory.takevideo.tag;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.UIThreadCallback;
import com.tencent.biz.qqstory.network.request.GetTagListRequest;
import com.tencent.biz.qqstory.network.response.GetTagListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

class EditVideoTagPresenter$2
  extends CmdTaskManger.UIThreadCallback<GetTagListRequest, GetTagListResponse>
{
  EditVideoTagPresenter$2(EditVideoTagPresenter paramEditVideoTagPresenter) {}
  
  public void a(@NonNull GetTagListRequest paramGetTagListRequest, @Nullable GetTagListResponse paramGetTagListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.b("EditVideoTagPresenter", "loadMore onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramGetTagListResponse != null))
    {
      SLog.a("EditVideoTagPresenter", "loadMore onCmdRespond, refresh success:[%s]", paramGetTagListResponse.toString());
      EditVideoTagPresenter.a(this.a).addAll(paramGetTagListResponse.jdField_a_of_type_JavaUtilList);
      EditVideoTagPresenter.a(this.a, paramGetTagListResponse.jdField_a_of_type_JavaLangString);
      EditVideoTagPresenter.a(this.a, paramGetTagListResponse.b);
      ThreadManager.executeOnSubThread(new EditVideoTagPresenter.2.1(this));
    }
    for (;;)
    {
      EditVideoTagPresenter.a(this.a).b(paramErrorMessage.errorCode, EditVideoTagPresenter.a(this.a), this.a.a());
      return;
      SLog.e("EditVideoTagPresenter", "loadMore onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.2
 * JD-Core Version:    0.7.0.1
 */