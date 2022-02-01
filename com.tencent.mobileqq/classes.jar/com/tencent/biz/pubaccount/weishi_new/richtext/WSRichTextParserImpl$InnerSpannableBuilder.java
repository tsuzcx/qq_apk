package com.tencent.biz.pubaccount.weishi_new.richtext;

import android.text.SpannableStringBuilder;
import java.util.ArrayList;

public class WSRichTextParserImpl$InnerSpannableBuilder
  extends SpannableStringBuilder
{
  private ArrayList<WSRichTextParserImpl.WSUser> a;
  private ArrayList<WSRichTextParserImpl.WSTopic> b;
  
  WSRichTextParserImpl$InnerSpannableBuilder(CharSequence paramCharSequence)
  {
    super(paramCharSequence);
  }
  
  public ArrayList<WSRichTextParserImpl.WSUser> a()
  {
    return this.a;
  }
  
  public void a(ArrayList<WSRichTextParserImpl.WSUser> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public ArrayList<WSRichTextParserImpl.WSTopic> b()
  {
    return this.b;
  }
  
  public void b(ArrayList<WSRichTextParserImpl.WSTopic> paramArrayList)
  {
    this.b = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.richtext.WSRichTextParserImpl.InnerSpannableBuilder
 * JD-Core Version:    0.7.0.1
 */