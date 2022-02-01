package com.tencent.biz.subscribe.widget.comment.component.richtext.element;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import zme;

public class ContentElement
  extends RichTextElement
{
  public static final Parcelable.Creator<ContentElement> CREATOR = new zme();
  public String a;
  
  public ContentElement()
  {
    super(4);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ContentElement [content=" + this.a + ", startPosition=" + this.b + ", endPosition=" + this.c + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.comment.component.richtext.element.ContentElement
 * JD-Core Version:    0.7.0.1
 */