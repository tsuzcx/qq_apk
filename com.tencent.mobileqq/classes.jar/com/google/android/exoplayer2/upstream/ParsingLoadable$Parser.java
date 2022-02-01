package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.InputStream;

public abstract interface ParsingLoadable$Parser<T>
{
  public abstract T parse(Uri paramUri, InputStream paramInputStream);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
 * JD-Core Version:    0.7.0.1
 */