package com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage;

import android.graphics.drawable.Drawable;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StringAppendTool;

public class URLImageLoader$Config
{
  public String a;
  public Transformation b;
  public int c;
  public int d;
  public Drawable e;
  
  public String a()
  {
    String str = this.a;
    if (str == null) {
      return "?";
    }
    Transformation localTransformation = this.b;
    if (localTransformation == null) {
      return str;
    }
    return StringAppendTool.a(new Object[] { str, "/", localTransformation.a() });
  }
  
  public boolean equals(Object paramObject)
  {
    return a().equals(((Config)paramObject).a());
  }
  
  public int hashCode()
  {
    return a().hashCode();
  }
  
  public String toString()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.URLImageLoader.Config
 * JD-Core Version:    0.7.0.1
 */