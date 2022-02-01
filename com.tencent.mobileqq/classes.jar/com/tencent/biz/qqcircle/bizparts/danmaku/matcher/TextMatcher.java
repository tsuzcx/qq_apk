package com.tencent.biz.qqcircle.bizparts.danmaku.matcher;

import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCell;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextLayoutBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class TextMatcher
{
  protected String a;
  private Pattern b;
  private int c;
  private String d;
  private Matcher e;
  private int f = -1;
  private boolean g = true;
  
  protected TextMatcher(Pattern paramPattern)
  {
    this.b = paramPattern;
  }
  
  private void b()
  {
    if (this.g)
    {
      this.g = this.e.find();
      if (this.g) {
        this.f = this.e.start();
      }
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public abstract ArrayList<TextCell> a(int paramInt, boolean paramBoolean, TextLayoutBase paramTextLayoutBase, CharSequence paramCharSequence, ArrayList<TextCell> paramArrayList);
  
  public abstract HashMap<String, Object> a(int paramInt, boolean paramBoolean, CharSequence paramCharSequence);
  
  public void a(String paramString)
  {
    this.d = paramString;
    this.e = this.b.matcher(paramString);
    b();
  }
  
  public boolean a(int paramInt)
  {
    if (this.d != null)
    {
      Matcher localMatcher = this.e;
      if (localMatcher == null) {
        return false;
      }
      int i = this.f;
      if (i <= paramInt)
      {
        if (!this.g) {
          return false;
        }
        if (i == paramInt)
        {
          this.a = localMatcher.group();
          this.c = this.e.end();
          b();
          return true;
        }
        b();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.matcher.TextMatcher
 * JD-Core Version:    0.7.0.1
 */