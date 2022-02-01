package com.tencent.mobileqq.apollo.game.utils;

import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnApolloDownLoadListener;

final class ApolloGameBasicEventUtil$2
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloGameBasicEventUtil$2(ApolloGameBasicEventUtil.NotifyGameDressReady paramNotifyGameDressReady, int paramInt, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ApolloDress paramApolloDress, int[] paramArrayOfInt) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    paramArrayOfInt = this.a;
    if (paramArrayOfInt != null) {
      paramArrayOfInt.a(this.b, this.c, paramString, this.d, this.e, this.f.roleId, this.g, 22);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.utils.ApolloGameBasicEventUtil.2
 * JD-Core Version:    0.7.0.1
 */