package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;

public abstract class BaseLocalEmoticonHandleListener
  implements IStickerRecLocalEmoticonHandleListener<BaseSessionInfo>
{
  protected BaseQQAppInterface a;
  
  public BaseLocalEmoticonHandleListener(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.a = paramBaseQQAppInterface;
  }
  
  public void a() {}
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    paramBaseQQAppInterface = StickerRecManagerImpl.get(paramBaseQQAppInterface);
    if (paramBaseQQAppInterface != null) {
      return paramBaseQQAppInterface.isHandleKeyword(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.BaseLocalEmoticonHandleListener
 * JD-Core Version:    0.7.0.1
 */