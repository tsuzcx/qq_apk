package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

public final class ExoPlaybackException
  extends Exception
{
  public static final int TYPE_RENDERER = 1;
  public static final int TYPE_SOURCE = 0;
  public static final int TYPE_UNEXPECTED = 2;
  public final int rendererIndex;
  public final int type;
  
  private ExoPlaybackException(int paramInt1, String paramString, Throwable paramThrowable, int paramInt2)
  {
    super(paramString, paramThrowable);
    this.type = paramInt1;
    this.rendererIndex = paramInt2;
  }
  
  public static ExoPlaybackException createForRenderer(Exception paramException, int paramInt)
  {
    return new ExoPlaybackException(1, null, paramException, paramInt);
  }
  
  public static ExoPlaybackException createForSource(IOException paramIOException)
  {
    return new ExoPlaybackException(0, null, paramIOException, -1);
  }
  
  static ExoPlaybackException createForUnexpected(Exception paramException)
  {
    return new ExoPlaybackException(2, null, paramException, -1);
  }
  
  public Exception getRendererException()
  {
    int i = this.type;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    Assertions.checkState(bool);
    return (Exception)getCause();
  }
  
  public IOException getSourceException()
  {
    boolean bool;
    if (this.type == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    return (IOException)getCause();
  }
  
  public RuntimeException getUnexpectedException()
  {
    boolean bool;
    if (this.type == 2) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    return (RuntimeException)getCause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.ExoPlaybackException
 * JD-Core Version:    0.7.0.1
 */