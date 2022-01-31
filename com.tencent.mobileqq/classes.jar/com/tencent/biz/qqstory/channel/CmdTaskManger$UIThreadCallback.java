package com.tencent.biz.qqstory.channel;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import naa;

public abstract class CmdTaskManger$UIThreadCallback
  implements CmdTaskManger.CommandCallback
{
  public static Handler a = new Handler(Looper.getMainLooper());
  
  public void a(@NonNull NetworkRequest paramNetworkRequest, @Nullable BaseResponse paramBaseResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (Thread.currentThread() == a.getLooper().getThread())
    {
      b(paramNetworkRequest, paramBaseResponse, paramErrorMessage);
      return;
    }
    a.post(new naa(this, paramNetworkRequest, paramBaseResponse, paramErrorMessage));
  }
  
  public abstract void b(@NonNull NetworkRequest paramNetworkRequest, @Nullable BaseResponse paramBaseResponse, @NonNull ErrorMessage paramErrorMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.CmdTaskManger.UIThreadCallback
 * JD-Core Version:    0.7.0.1
 */