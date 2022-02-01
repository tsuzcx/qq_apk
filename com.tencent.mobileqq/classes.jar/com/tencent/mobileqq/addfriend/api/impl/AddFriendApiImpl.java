package com.tencent.mobileqq.addfriend.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;

public class AddFriendApiImpl
  implements IAddFriendApi
{
  public Intent startAddFriend(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return AddFriendLogicActivity.a(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramString3, paramString4, paramString5, paramString6, paramString7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.api.impl.AddFriendApiImpl
 * JD-Core Version:    0.7.0.1
 */