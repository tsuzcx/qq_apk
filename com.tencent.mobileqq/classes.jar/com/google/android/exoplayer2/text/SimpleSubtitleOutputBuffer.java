package com.google.android.exoplayer2.text;

final class SimpleSubtitleOutputBuffer
  extends SubtitleOutputBuffer
{
  private final SimpleSubtitleDecoder owner;
  
  public SimpleSubtitleOutputBuffer(SimpleSubtitleDecoder paramSimpleSubtitleDecoder)
  {
    this.owner = paramSimpleSubtitleDecoder;
  }
  
  public final void release()
  {
    this.owner.releaseOutputBuffer(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.text.SimpleSubtitleOutputBuffer
 * JD-Core Version:    0.7.0.1
 */