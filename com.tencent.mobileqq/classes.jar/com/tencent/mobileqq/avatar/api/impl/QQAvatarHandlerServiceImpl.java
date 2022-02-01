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
    if (this.mAvatarHandler != null) {
      this.mAvatarHandler.d(paramString);
    }
  }
  
  public void getApolloHead(String paramString, byte paramByte1, byte paramByte2, int paramInt)
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    if (this.mAvatarHandler != null) {
      this.mAvatarHandler.a(paramString, paramByte1, paramByte2, paramInt);
    }
  }
  
  public String getChoosedIP()
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    if (this.mAvatarHandler != null) {
      return this.mAvatarHandler.a();
    }
    return null;
  }
  
  public String getChoosedStrangerGroupIP()
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    if (this.mAvatarHandler != null) {
      return this.mAvatarHandler.b();
    }
    return null;
  }
  
  public void getCustomHead(String paramString)
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    if (this.mAvatarHandler != null) {
      this.mAvatarHandler.a(paramString);
    }
  }
  
  public void getCustomHead(String paramString, byte paramByte1, byte paramByte2)
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    if (this.mAvatarHandler != null) {
      this.mAvatarHandler.a(paramString, paramByte1, paramByte2);
    }
  }
  
  public void getMobileQQHead(String paramString)
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    if (this.mAvatarHandler != null) {
      this.mAvatarHandler.c(paramString);
    }
  }
  
  public void getMobileQQHead(String paramString, byte paramByte)
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    if (this.mAvatarHandler != null) {
      this.mAvatarHandler.b(paramString, paramByte);
    }
  }
  
  public void getQCallHead(String paramString, int paramInt, byte paramByte1, byte paramByte2)
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    if (this.mAvatarHandler != null) {
      this.mAvatarHandler.b(paramString, paramInt, paramByte1, paramByte2);
    }
  }
  
  public void getStrangerHead(String paramString, int paramInt, byte paramByte1, byte paramByte2)
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    if (this.mAvatarHandler != null) {
      this.mAvatarHandler.a(paramString, paramInt, paramByte1, paramByte2);
    }
  }
  
  public void getTroopHead(String paramString)
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    if (this.mAvatarHandler != null) {
      this.mAvatarHandler.b(paramString);
    }
  }
  
  public void getTroopHead(String paramString, byte paramByte)
  {
    if (this.mAvatarHandler == null) {
      initAvatarHandler();
    }
    if (this.mAvatarHandler != null) {
      this.mAvatarHandler.a(paramString, paramByte);
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
    if (this.mAvatarHandler != null) {
      this.mAvatarHandler.b();
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
    if (this.mAvatarHandler != null) {
      this.mAvatarHandler.a(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarHandlerServiceImpl
 * JD-Core Version:    0.7.0.1
 */