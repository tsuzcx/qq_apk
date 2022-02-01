package com.tencent.mobileqq.apollo.utils.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.utils.api.ICMShowJumpParserFactory;

public class CMShowJumpParserFactoryImpl
  implements ICMShowJumpParserFactory
{
  public Class getJumpParserClass(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (("mqq://shop/apollo_store".equals(paramString)) || ("mqqapi://shop/apollo_store".equals(paramString)))) {
      return CMShowJumpParser.class;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.CMShowJumpParserFactoryImpl
 * JD-Core Version:    0.7.0.1
 */