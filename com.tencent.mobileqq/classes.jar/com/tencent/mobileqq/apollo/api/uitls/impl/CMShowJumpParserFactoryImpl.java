package com.tencent.mobileqq.apollo.api.uitls.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.uitls.ICMShowJumpParserFactory;

public class CMShowJumpParserFactoryImpl
  implements ICMShowJumpParserFactory
{
  public Class getJumpParserClass(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (("mqq://shop/apollo_store".equals(paramString)) || ("mqqapi://shop/apollo_store".equals(paramString))) {
        return CMShowParser.class;
      }
      if ("mqqapi://cmshow/game_invite".equals(paramString)) {
        return CMShowGameInviteParser.class;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.impl.CMShowJumpParserFactoryImpl
 * JD-Core Version:    0.7.0.1
 */