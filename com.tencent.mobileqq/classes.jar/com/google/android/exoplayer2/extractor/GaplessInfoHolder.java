package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class GaplessInfoHolder
{
  private static final String GAPLESS_COMMENT_ID = "iTunSMPB";
  private static final Pattern GAPLESS_COMMENT_PATTERN = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
  public static final Id3Decoder.FramePredicate GAPLESS_INFO_ID3_FRAME_PREDICATE = new GaplessInfoHolder.1();
  public int encoderDelay = -1;
  public int encoderPadding = -1;
  
  private boolean setFromComment(String paramString1, String paramString2)
  {
    if (!"iTunSMPB".equals(paramString1)) {}
    for (;;)
    {
      return false;
      paramString1 = GAPLESS_COMMENT_PATTERN.matcher(paramString2);
      if (paramString1.find()) {
        try
        {
          int i = Integer.parseInt(paramString1.group(1), 16);
          int j = Integer.parseInt(paramString1.group(2), 16);
          if ((i > 0) || (j > 0))
          {
            this.encoderDelay = i;
            this.encoderPadding = j;
            return true;
          }
        }
        catch (NumberFormatException paramString1) {}
      }
    }
    return false;
  }
  
  public boolean hasGaplessInfo()
  {
    return (this.encoderDelay != -1) && (this.encoderPadding != -1);
  }
  
  public boolean setFromMetadata(Metadata paramMetadata)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramMetadata.length())
      {
        Object localObject = paramMetadata.get(i);
        if ((localObject instanceof CommentFrame))
        {
          localObject = (CommentFrame)localObject;
          if (setFromComment(((CommentFrame)localObject).description, ((CommentFrame)localObject).text)) {
            bool1 = true;
          }
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean setFromXingHeaderValue(int paramInt)
  {
    int i = paramInt >> 12;
    paramInt &= 0xFFF;
    if ((i > 0) || (paramInt > 0))
    {
      this.encoderDelay = i;
      this.encoderPadding = paramInt;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.GaplessInfoHolder
 * JD-Core Version:    0.7.0.1
 */