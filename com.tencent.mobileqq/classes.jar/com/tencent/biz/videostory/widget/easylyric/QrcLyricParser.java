package com.tencent.biz.videostory.widget.easylyric;

import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.util.ParsingQrc;

public class QrcLyricParser
  implements ILyricParser
{
  public Lyric a(String paramString)
  {
    return new ParsingQrc(paramString).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.easylyric.QrcLyricParser
 * JD-Core Version:    0.7.0.1
 */