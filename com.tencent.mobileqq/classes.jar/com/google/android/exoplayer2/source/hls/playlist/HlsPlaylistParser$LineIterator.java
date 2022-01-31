package com.google.android.exoplayer2.source.hls.playlist;

import java.io.BufferedReader;
import java.util.Queue;

class HlsPlaylistParser$LineIterator
{
  private final Queue<String> extraLines;
  private String next;
  private final BufferedReader reader;
  
  public HlsPlaylistParser$LineIterator(Queue<String> paramQueue, BufferedReader paramBufferedReader)
  {
    this.extraLines = paramQueue;
    this.reader = paramBufferedReader;
  }
  
  public boolean hasNext()
  {
    if (this.next != null) {
      return true;
    }
    if (!this.extraLines.isEmpty())
    {
      this.next = ((String)this.extraLines.poll());
      return true;
    }
    do
    {
      String str = this.reader.readLine();
      this.next = str;
      if (str == null) {
        break;
      }
      this.next = this.next.trim();
    } while (this.next.isEmpty());
    return true;
    return false;
  }
  
  public String next()
  {
    if (hasNext())
    {
      String str = this.next;
      this.next = null;
      return str;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.LineIterator
 * JD-Core Version:    0.7.0.1
 */