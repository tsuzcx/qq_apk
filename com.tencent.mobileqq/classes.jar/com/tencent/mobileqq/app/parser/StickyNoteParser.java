package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import java.util.Iterator;
import java.util.Set;

public class StickyNoteParser
  extends JumpParserBase
{
  public JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramBaseQQAppInterface = new StickyNoteAction((QQAppInterface)paramBaseQQAppInterface, paramContext);
    paramContext = paramString.split("\\?");
    if (paramContext.length < 1) {
      return paramBaseQQAppInterface;
    }
    paramContext = paramContext[0].substring(9).split("/");
    if (paramContext.length != 2) {
      return paramBaseQQAppInterface;
    }
    paramBaseQQAppInterface.c = paramString;
    paramBaseQQAppInterface.d = paramContext[0];
    paramBaseQQAppInterface.e = paramContext[1];
    paramContext = Uri.parse(paramString);
    paramString = paramContext.getQueryParameterNames().iterator();
    while (paramString.hasNext())
    {
      paramJumpParserResult = (String)paramString.next();
      if (!TextUtils.isEmpty(paramJumpParserResult))
      {
        String str = paramContext.getQueryParameter(paramJumpParserResult);
        if (!TextUtils.isEmpty(str)) {
          paramBaseQQAppInterface.a(paramJumpParserResult.toLowerCase(), str);
        }
      }
    }
    return paramBaseQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.StickyNoteParser
 * JD-Core Version:    0.7.0.1
 */