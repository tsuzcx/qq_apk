package com.tencent.biz.videostory.widget.easylyric;

import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.util.ParsingLrc;

public class CommonLyricParser
  implements ILyricParser
{
  public Lyric a(String paramString)
  {
    return new ParsingLrc(paramString).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.easylyric.CommonLyricParser
 * JD-Core Version:    0.7.0.1
 */