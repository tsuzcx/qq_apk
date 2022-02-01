package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.mobileqq.app.QQAppInterface;

public abstract class BaseLocalEmoticonHandleListener
  implements IStickerRecLocalEmoticonHandleListener
{
  protected QQAppInterface a;
  
  public BaseLocalEmoticonHandleListener(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a() {}
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = StickerRecManager.a(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.a(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.BaseLocalEmoticonHandleListener
 * JD-Core Version:    0.7.0.1
 */