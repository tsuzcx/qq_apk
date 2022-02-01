package com.tencent.mobileqq.addfriend.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IAddFriendApi
  extends QRouteApi
{
  public abstract Intent startAddFriend(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.api.IAddFriendApi
 * JD-Core Version:    0.7.0.1
 */