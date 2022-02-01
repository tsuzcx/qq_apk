package com.tencent.mobileqq.avatar.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.avatar.handler.AvatarHandler;
import mqq.app.AppRuntime;

public class QQAvatarHandlerServiceImpl
  implements IQQAvatarHandlerService
{
  private static final String TAG = "IQQAvatarHandlerServiceImpl";
  AppInterface mApp;
  AvatarHandler mAvatarHandler;
  
  public void getApolloHead(String paramString)
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    AvatarHandler localAvatarHandler = this.mAvatarHandler;
    if (localAvatarHandler != null) {
      localAvatarHandler.d(paramString);
    }
  }
  
  public void getApolloHead(String paramString, byte paramByte1, byte paramByte2, int paramInt)
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    AvatarHandler localAvatarHandler = this.mAvatarHandler;
    if (localAvatarHandler != null) {
      localAvatarHandler.a(paramString, paramByte1, paramByte2, paramInt);
    }
  }
  
  public String getChoosedIP()
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    AvatarHandler localAvatarHandler = this.mAvatarHandler;
    if (localAvatarHandler != null) {
      return localAvatarHandler.a();
    }
    return null;
  }
  
  public String getChoosedStrangerGroupIP()
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    AvatarHandler localAvatarHandler = this.mAvatarHandler;
    if (localAvatarHandler != null) {
      return localAvatarHandler.b();
    }
    return null;
  }
  
  public void getCustomHead(String paramString)
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    AvatarHandler localAvatarHandler = this.mAvatarHandler;
    if (localAvatarHandler != null) {
      localAvatarHandler.a(paramString);
    }
  }
  
  public void getCustomHead(String paramString, byte paramByte1, byte paramByte2)
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    AvatarHandler localAvatarHandler = this.mAvatarHandler;
    if (localAvatarHandler != null) {
      localAvatarHandler.a(paramString, paramByte1, paramByte2);
    }
  }
  
  public void getMobileQQHead(String paramString)
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    AvatarHandler localAvatarHandler = this.mAvatarHandler;
    if (localAvatarHandler != null) {
      localAvatarHandler.c(paramString);
    }
  }
  
  public void getMobileQQHead(String paramString, byte paramByte)
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    AvatarHandler localAvatarHandler = this.mAvatarHandler;
    if (localAvatarHandler != null) {
      localAvatarHandler.b(paramString, paramByte);
    }
  }
  
  public void getQCallHead(String paramString, int paramInt, byte paramByte1, byte paramByte2)
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    AvatarHandler localAvatarHandler = this.mAvatarHandler;
    if (localAvatarHandler != null) {
      localAvatarHandler.b(paramString, paramInt, paramByte1, paramByte2);
    }
  }
  
  public void getStrangerHead(String paramString, int paramInt, byte paramByte1, byte paramByte2)
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    AvatarHandler localAvatarHandler = this.mAvatarHandler;
    if (localAvatarHandler != null) {
      localAvatarHandler.a(paramString, paramInt, paramByte1, paramByte2);
    }
  }
  
  public void getTroopHead(String paramString)
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    AvatarHandler localAvatarHandler = this.mAvatarHandler;
    if (localAvatarHandler != null) {
      localAvatarHandler.b(paramString);
    }
  }
  
  public void getTroopHead(String paramString, byte paramByte)
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    AvatarHandler localAvatarHandler = this.mAvatarHandler;
    if (localAvatarHandler != null) {
      localAvatarHandler.a(paramString, paramByte);
    }
  }
  
  void initAvatarHandler()
  {
    this.mAvatarHandler = ((AvatarHandler)this.mApp.getBusinessHandler(QQAvatarHandlerApiImpl.MESSAGE_HANDLER));
  }
  
  public void notifySyncQQHead()
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    AvatarHandler localAvatarHandler = this.mAvatarHandler;
    if (localAvatarHandler != null) {
      localAvatarHandler.b();
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
    initAvatarHandler();
  }
  
  public void onDestroy() {}
  
  public void sendBroadCastHeadChanged(int paramInt, String paramString)
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    AvatarHandler localAvatarHandler = this.mAvatarHandler;
    if (localAvatarHandler != null) {
      localAvatarHandler.a(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarHandlerServiceImpl
 * JD-Core Version:    0.7.0.1
 */