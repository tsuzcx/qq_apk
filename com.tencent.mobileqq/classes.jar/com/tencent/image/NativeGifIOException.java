package com.tencent.image;

import java.io.IOException;

public class NativeGifIOException
  extends IOException
{
  private static final long serialVersionUID = 13038402904505L;
  public final NativeGifIOException.NativeGifError reason;
  
  NativeGifIOException(int paramInt)
  {
    this(NativeGifIOException.NativeGifError.fromCode(paramInt));
  }
  
  NativeGifIOException(NativeGifIOException.NativeGifError paramNativeGifError)
  {
    super(paramNativeGifError.getFormattedDescription());
    this.reason = paramNativeGifError;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.NativeGifIOException
 * JD-Core Version:    0.7.0.1
 */