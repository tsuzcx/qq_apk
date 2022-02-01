package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.Set;

public class StickyNoteParser
  extends JumpParserBase
{
  public JumpActionBase a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramQQAppInterface = new StickyNoteAction(paramQQAppInterface, paramContext);
    paramContext = paramString.split("\\?");
    if (paramContext.length < 1) {
      return paramQQAppInterface;
    }
    paramContext = paramContext[0].substring("mqqapi://".length()).split("/");
    if (paramContext.length != 2) {
      return paramQQAppInterface;
    }
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = paramContext[0];
    paramQQAppInterface.c = paramContext[1];
    paramContext = Uri.parse(paramString);
    paramString = paramContext.getQueryParameterNames().iterator();
    while (paramString.hasNext())
    {
      paramJumpParserResult = (String)paramString.next();
      if (!TextUtils.isEmpty(paramJumpParserResult))
      {
        String str = paramContext.getQueryParameter(paramJumpParserResult);
        if (!TextUtils.isEmpty(str)) {
          paramQQAppInterface.a(paramJumpParserResult.toLowerCase(), str);
        }
      }
    }
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.StickyNoteParser
 * JD-Core Version:    0.7.0.1
 */