package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.common.app.business.BaseQQAppInterface;
import java.util.List;

public abstract interface IStickerRecLocalEmoticonHandleListener<T>
{
  public abstract List<? extends IStickerRecEmoticon> a(String paramString, T paramT);
  
  public abstract boolean a(BaseQQAppInterface paramBaseQQAppInterface, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecLocalEmoticonHandleListener
 * JD-Core Version:    0.7.0.1
 */