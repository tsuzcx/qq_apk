package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.biz.pubaccount.api.IPublicAccountTipsManager;

class PublicAccountChatPie$62
  implements Runnable
{
  PublicAccountChatPie$62(PublicAccountChatPie paramPublicAccountChatPie, boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if (this.a)
    {
      this.this$0.bS.showPendant(this.b, this.c, this.d, this.e, this.f);
      return;
    }
    this.this$0.bS.hidePendant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.62
 * JD-Core Version:    0.7.0.1
 */