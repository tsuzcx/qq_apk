package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.util.Utils;
import java.util.List;

class KanDianPrivateChatAddFriendHelper$1
  extends ShieldListObserver
{
  KanDianPrivateChatAddFriendHelper$1(KanDianPrivateChatAddFriendHelper paramKanDianPrivateChatAddFriendHelper) {}
  
  protected void a(boolean paramBoolean, List<Long> paramList)
  {
    
    if (this.a.e == null) {
      return;
    }
    String str = this.a.e.b;
    if (this.a.e.a == 1006) {
      str = this.a.e.g;
    }
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    int k = 0;
    int j = 0;
    while ((k == 0) && (j < i))
    {
      if (Utils.a(String.valueOf(paramList.get(j)), str)) {
        k = 1;
      }
      j += 1;
    }
    if (k != 0)
    {
      ChatActivityUtils.a(this.a.c, paramBoolean, false);
      if (paramBoolean) {
        this.a.g();
      }
    }
  }
  
  protected void b(boolean paramBoolean, List<Long> paramList)
  {
    
    if (this.a.e == null) {
      return;
    }
    String str = this.a.e.b;
    if (this.a.e.a == 1006) {
      str = this.a.e.g;
    }
    int k = 0;
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    int j = 0;
    while ((k == 0) && (j < i))
    {
      if (Utils.a(String.valueOf(paramList.get(j)), str)) {
        k = 1;
      }
      j += 1;
    }
    if (k != 0)
    {
      ChatActivityUtils.b();
      if (paramBoolean) {
        this.a.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.KanDianPrivateChatAddFriendHelper.1
 * JD-Core Version:    0.7.0.1
 */