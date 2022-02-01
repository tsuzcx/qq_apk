package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class TroopDisbandActivity$8
  extends AvatarObserver
{
  TroopDisbandActivity$8(TroopDisbandActivity paramTroopDisbandActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.q != null) && (this.a.q.a(paramString))) {
      this.a.q.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity.8
 * JD-Core Version:    0.7.0.1
 */