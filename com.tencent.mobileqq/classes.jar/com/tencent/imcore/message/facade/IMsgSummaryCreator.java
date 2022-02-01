package com.tencent.imcore.message.facade;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;

public abstract interface IMsgSummaryCreator<FT extends BaseQQMessageFacade, AT extends BaseQQAppInterface>
{
  public abstract String a(AT paramAT, FT paramFT, Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.IMsgSummaryCreator
 * JD-Core Version:    0.7.0.1
 */