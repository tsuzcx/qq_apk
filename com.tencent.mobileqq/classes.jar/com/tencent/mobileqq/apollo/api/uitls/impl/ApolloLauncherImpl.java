package com.tencent.mobileqq.apollo.api.uitls.impl;

import com.tencent.mobileqq.apollo.ApolloGameNormalStartHandler;
import com.tencent.mobileqq.apollo.api.uitls.IApolloLauncher;
import com.tencent.mobileqq.app.QQAppInterface;

class ApolloLauncherImpl
  implements IApolloLauncher
{
  public void startGameFromArkApp(QQAppInterface paramQQAppInterface, String paramString)
  {
    ApolloGameNormalStartHandler.a(paramQQAppInterface, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.impl.ApolloLauncherImpl
 * JD-Core Version:    0.7.0.1
 */