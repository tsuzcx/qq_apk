package com.tencent.mobileqq.apollo.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.model.ApolloActionPush;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class ApolloPushManagerImpl$2
  implements Runnable
{
  ApolloPushManagerImpl$2(ApolloPushManagerImpl paramApolloPushManagerImpl, ApolloActionPush paramApolloActionPush, SpriteTaskParam paramSpriteTaskParam) {}
  
  public void run()
  {
    if ((this.a != null) && (this.b != null)) {
      ApolloActionHelperImpl.doActionReport(ApolloPushManagerImpl.access$100(this.this$0), this.b, TextUtils.isEmpty(this.a.mContent) ^ true, this.b.q);
    }
    if ((ApolloPushManagerImpl.access$100(this.this$0) != null) && (this.a != null)) {
      ((ApolloDaoManagerServiceImpl)ApolloPushManagerImpl.access$100(this.this$0).getRuntimeService(IApolloDaoManagerService.class, "all")).removeActionPushDataById(this.a.mId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloPushManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */