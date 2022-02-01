package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Mp4WebvttDecoder
  extends SimpleSubtitleDecoder
{
  private static final int BOX_HEADER_SIZE = 8;
  private static final int TYPE_payl = Util.getIntegerCodeForString("payl");
  private static final int TYPE_sttg = Util.getIntegerCodeForString("sttg");
  private static final int TYPE_vttc = Util.getIntegerCodeForString("vttc");
  private final WebvttCue.Builder builder = new WebvttCue.Builder();
  private final ParsableByteArray sampleData = new ParsableByteArray();
  
  public Mp4WebvttDecoder()
  {
    super("Mp4WebvttDecoder");
  }
  
  private static Cue parseVttCueBox(ParsableByteArray paramParsableByteArray, WebvttCue.Builder paramBuilder, int paramInt)
  {
    paramBuilder.reset();
    while (paramInt > 0)
    {
      if (paramInt < 8) {
        throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
      }
      int i = paramParsableByteArray.readInt();
      int j = paramParsableByteArray.readInt();
      i -= 8;
      String str = new String(paramParsableByteArray.data, paramParsableByteArray.getPosition(), i);
      paramParsableByteArray.skipBytes(i);
      i = paramInt - 8 - i;
      if (j == TYPE_sttg)
      {
        WebvttCueParser.parseCueSettingsList(str, paramBuilder);
        paramInt = i;
      }
      else
      {
        paramInt = i;
        if (j == TYPE_payl)
        {
          WebvttCueParser.parseCueText(null, str.trim(), paramBuilder, Collections.emptyList());
          paramInt = i;
        }
      }
    }
    return paramBuilder.build();
  }
  
  protected Mp4WebvttSubtitle decode(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    this.sampleData.reset(paramArrayOfByte, paramInt);
    paramArrayOfByte = new ArrayList();
    while (this.sampleData.bytesLeft() > 0)
    {
      if (this.sampleData.bytesLeft() < 8) {
        throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
      }
      paramInt = this.sampleData.readInt();
      if (this.sampleData.readInt() == TYPE_vttc) {
        paramArrayOfByte.add(parseVttCueBox(this.sampleData, this.builder, paramInt - 8));
      } else {
        this.sampleData.skipBytes(paramInt - 8);
      }
    }
    return new Mp4WebvttSubtitle(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.text.webvtt.Mp4WebvttDecoder
 * JD-Core Version:    0.7.0.1
 */