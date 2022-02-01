package com.tencent.biz.subscribe.widget.comment.component.richtext.element;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ContentElement
  extends RichTextElement
{
  public static final Parcelable.Creator<ContentElement> CREATOR = new ContentElement.1();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ContentElement [content=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", startPosition=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", endPosition=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.comment.component.richtext.element.ContentElement
 * JD-Core Version:    0.7.0.1
 */