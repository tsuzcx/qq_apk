package com.tencent.imcore.message.facade;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.Message;

public abstract interface ILastMsgGetter<FT extends BaseQQMessageFacade, AT extends BaseQQAppInterface>
{
  public abstract Message a(FT paramFT, AT paramAT, String paramString, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.ILastMsgGetter
 * JD-Core Version:    0.7.0.1
 */