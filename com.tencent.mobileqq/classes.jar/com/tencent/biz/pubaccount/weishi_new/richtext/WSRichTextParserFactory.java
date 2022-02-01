package com.tencent.biz.pubaccount.weishi_new.richtext;

public class WSRichTextParserFactory
{
  public static IWSRichTextParser a(int paramInt)
  {
    if (paramInt != 1) {
      return new WSRichTextParserImpl();
    }
    return new WSCommentRichParserImpl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.richtext.WSRichTextParserFactory
 * JD-Core Version:    0.7.0.1
 */