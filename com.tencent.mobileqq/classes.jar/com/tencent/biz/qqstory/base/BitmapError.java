package com.tencent.biz.qqstory.base;

import com.tribe.async.reactive.Optional;

public class BitmapError
  extends Error
{
  public static final int REASON_BITMAP_COPY_FAIL = 3;
  public static final int REASON_BITMAP_ERR_WIDTH_HEIGHT = 8;
  public static final int REASON_BITMAP_GET_ERR = 7;
  public static final int REASON_BITMAP_LOAD_FAIL = 2;
  public static final int REASON_BITMAP_RENDER = 9;
  public static final int REASON_DECODE_ERROR = 6;
  public static final int REASON_FILE_NOT_FOUND = 4;
  public static final int REASON_IO_ERROR = 4;
  public static final int REASON_OUT_OF_MEM = 5;
  public static final int REASON_UNKNOWN = 0;
  public static final int REASON_URL_EMPTY = 1;
  public Optional<String> detail = Optional.empty();
  public final int reason;
  public final String source;
  
  public BitmapError(String paramString, int paramInt)
  {
    this.reason = paramInt;
    this.source = paramString;
  }
  
  public void setDetail(String paramString)
  {
    this.detail = Optional.ofNullable(paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BimapError { reason = ");
    localStringBuilder.append(this.reason);
    localStringBuilder.append(", source = ");
    localStringBuilder.append(this.source);
    localStringBuilder.append(", detail = ");
    localStringBuilder.append((String)this.detail.orElse("(no detail)"));
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.BitmapError
 * JD-Core Version:    0.7.0.1
 */