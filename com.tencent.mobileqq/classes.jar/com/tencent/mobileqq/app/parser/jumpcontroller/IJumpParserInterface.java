package com.tencent.mobileqq.app.parser.jumpcontroller;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;

public abstract interface IJumpParserInterface
{
  public abstract JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.jumpcontroller.IJumpParserInterface
 * JD-Core Version:    0.7.0.1
 */