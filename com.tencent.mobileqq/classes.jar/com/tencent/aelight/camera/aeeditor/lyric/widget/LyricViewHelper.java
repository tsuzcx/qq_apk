package com.tencent.aelight.camera.aeeditor.lyric.widget;

import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Sentence;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.SentenceUI;
import java.util.ArrayList;
import java.util.Iterator;

public class LyricViewHelper
{
  public static final Lyric a(Lyric paramLyric)
  {
    if (paramLyric == null) {
      return new Lyric(2, 0, null);
    }
    Lyric localLyric = new Lyric(2, paramLyric.mOffset, new ArrayList());
    localLyric.mType = paramLyric.mType;
    paramLyric = paramLyric.mSentences.iterator();
    while (paramLyric.hasNext())
    {
      Object localObject = (Sentence)paramLyric.next();
      if (localObject != null)
      {
        localObject = ((Sentence)localObject).mUILine.iterator();
        while (((Iterator)localObject).hasNext())
        {
          SentenceUI localSentenceUI = (SentenceUI)((Iterator)localObject).next();
          localLyric.mSentences.add(new Sentence(localSentenceUI));
        }
      }
    }
    return localLyric;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricViewHelper
 * JD-Core Version:    0.7.0.1
 */