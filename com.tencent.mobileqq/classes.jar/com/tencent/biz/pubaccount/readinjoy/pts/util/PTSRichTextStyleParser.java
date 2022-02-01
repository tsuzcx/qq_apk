package com.tencent.biz.pubaccount.readinjoy.pts.util;

import android.text.SpannableStringBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.TruncateAttr;
import org.json.JSONArray;

public class PTSRichTextStyleParser
{
  public static int a;
  private static TruncateAttr a;
  public static int b = 0;
  public static int c = 0;
  public static int d = 0;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public static void a(Object paramObject, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((paramSpannableStringBuilder == null) || (paramObject == null)) {
      return;
    }
    PTSRichTextStyleParser.RichTextNode.a(PTSRichTextStyleParser.RichTextNode.a((JSONArray)paramObject), paramSpannableStringBuilder);
  }
  
  public static int b()
  {
    return b;
  }
  
  public static int c()
  {
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.util.PTSRichTextStyleParser
 * JD-Core Version:    0.7.0.1
 */