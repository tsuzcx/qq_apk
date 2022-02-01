package com.tencent.biz.pubaccount.weishi_new.util;

import android.text.SpannableStringBuilder;
import java.util.ArrayList;

public class FeedTextParser$InnerSpannableBuilder
  extends SpannableStringBuilder
{
  private ArrayList<FeedTextParser.WSUser> a;
  private ArrayList<FeedTextParser.WSTopic> b;
  
  FeedTextParser$InnerSpannableBuilder(CharSequence paramCharSequence)
  {
    super(paramCharSequence);
  }
  
  public ArrayList<FeedTextParser.WSUser> a()
  {
    return this.a;
  }
  
  public void a(ArrayList<FeedTextParser.WSUser> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public ArrayList<FeedTextParser.WSTopic> b()
  {
    return this.b;
  }
  
  public void b(ArrayList<FeedTextParser.WSTopic> paramArrayList)
  {
    this.b = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.FeedTextParser.InnerSpannableBuilder
 * JD-Core Version:    0.7.0.1
 */