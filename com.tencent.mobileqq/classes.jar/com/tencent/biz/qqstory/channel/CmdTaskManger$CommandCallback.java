package com.tencent.biz.qqstory.channel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

public abstract interface CmdTaskManger$CommandCallback<Request extends NetworkRequest, Respond extends BaseResponse>
{
  public abstract void a(@NonNull Request paramRequest, @Nullable Respond paramRespond, @NonNull ErrorMessage paramErrorMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback
 * JD-Core Version:    0.7.0.1
 */