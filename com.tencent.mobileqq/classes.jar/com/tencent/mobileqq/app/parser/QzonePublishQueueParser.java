package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class QzonePublishQueueParser
  extends JumpParserBase
{
  public JumpActionBase a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramQQAppInterface = new QzonePublishQueueAction(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "qzone";
    paramQQAppInterface.c = "to_publish_queue";
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QzonePublishQueueParser
 * JD-Core Version:    0.7.0.1
 */