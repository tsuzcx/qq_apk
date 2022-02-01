package com.tencent.mobileqq.apollo.api.uitls;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IApolloLauncher
  extends QRouteApi
{
  public abstract void startGameFromArkApp(QQAppInterface paramQQAppInterface, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.IApolloLauncher
 * JD-Core Version:    0.7.0.1
 */