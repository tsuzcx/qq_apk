package com.tencent.mobileqq.addfriend.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface INewFriendListApi
  extends QRouteApi
{
  public abstract Intent startNewFriendList(Context paramContext, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.api.INewFriendListApi
 * JD-Core Version:    0.7.0.1
 */