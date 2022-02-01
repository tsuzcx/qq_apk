package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class NearbyAddFriendHelper$6
  extends ShieldListObserver
{
  NearbyAddFriendHelper$6(NearbyAddFriendHelper paramNearbyAddFriendHelper) {}
  
  protected void a(boolean paramBoolean, List<Long> paramList)
  {
    ChatActivityUtils.b();
    Object localObject = this.a.d;
    Context localContext = this.a.d;
    int i;
    if (paramBoolean) {
      i = 2131916595;
    } else {
      i = 2131916584;
    }
    QQToast.makeText((Context)localObject, 2, localContext.getString(i), 0).show(this.a.a.v());
    if (this.a.e == null) {
      return;
    }
    localObject = this.a.e.b;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    int k = 0;
    int j = 0;
    while ((k == 0) && (j < i))
    {
      if (Utils.a(String.valueOf(paramList.get(j)), localObject)) {
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.NearbyAddFriendHelper.6
 * JD-Core Version:    0.7.0.1
 */