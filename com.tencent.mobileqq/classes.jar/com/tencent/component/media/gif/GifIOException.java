package com.tencent.component.media.gif;

import java.io.IOException;

public class GifIOException
  extends IOException
{
  private static final long serialVersionUID = 13038402904505L;
  public final GifError reason;
  
  GifIOException(int paramInt)
  {
    this(GifError.fromCode(paramInt));
  }
  
  private GifIOException(GifError paramGifError)
  {
    super(paramGifError.getFormattedDescription());
    this.reason = paramGifError;
  }
  
  static GifIOException fromCode(int paramInt)
  {
    if (paramInt == 0) {
      return null;
    }
    return new GifIOException(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.gif.GifIOException
 * JD-Core Version:    0.7.0.1
 */