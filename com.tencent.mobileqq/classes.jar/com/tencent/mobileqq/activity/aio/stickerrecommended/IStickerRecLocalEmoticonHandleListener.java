package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public abstract interface IStickerRecLocalEmoticonHandleListener
{
  public abstract List<? extends IStickerRecEmoticon> a(String paramString, SessionInfo paramSessionInfo);
  
  public abstract boolean a(QQAppInterface paramQQAppInterface, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecLocalEmoticonHandleListener
 * JD-Core Version:    0.7.0.1
 */