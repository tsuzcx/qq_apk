package com.tencent.mobileqq.addfriend.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgActivity;
import com.tencent.mobileqq.addfriend.api.INewFriendListApi;

public class NewFriendListApiImpl
  implements INewFriendListApi
{
  public Intent startNewFriendList(Context paramContext, int paramInt)
  {
    paramContext = new Intent(paramContext, NewFriendMoreSysMsgActivity.class);
    paramContext.putExtra("first_visible_index", paramInt);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.api.impl.NewFriendListApiImpl
 * JD-Core Version:    0.7.0.1
 */