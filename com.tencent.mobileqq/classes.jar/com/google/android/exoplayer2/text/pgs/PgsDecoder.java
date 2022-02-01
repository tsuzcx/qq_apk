package com.google.android.exoplayer2.text.pgs;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;

public final class PgsDecoder
  extends SimpleSubtitleDecoder
{
  private static final int SECTION_TYPE_BITMAP_PICTURE = 21;
  private static final int SECTION_TYPE_END = 128;
  private static final int SECTION_TYPE_IDENTIFIER = 22;
  private static final int SECTION_TYPE_PALETTE = 20;
  private final ParsableByteArray buffer = new ParsableByteArray();
  private final PgsDecoder.CueBuilder cueBuilder = new PgsDecoder.CueBuilder();
  
  public PgsDecoder()
  {
    super("PgsDecoder");
  }
  
  private static Cue readNextSection(ParsableByteArray paramParsableByteArray, PgsDecoder.CueBuilder paramCueBuilder)
  {
    int i = paramParsableByteArray.limit();
    int j = paramParsableByteArray.readUnsignedByte();
    int k = paramParsableByteArray.readUnsignedShort();
    int m = paramParsableByteArray.getPosition() + k;
    Cue localCue = null;
    if (m > i)
    {
      paramParsableByteArray.setPosition(i);
      return null;
    }
    if (j != 128)
    {
      switch (j)
      {
      default: 
        paramCueBuilder = localCue;
        break;
      case 22: 
        PgsDecoder.CueBuilder.access$200(paramCueBuilder, paramParsableByteArray, k);
        paramCueBuilder = localCue;
        break;
      case 21: 
        PgsDecoder.CueBuilder.access$100(paramCueBuilder, paramParsableByteArray, k);
        paramCueBuilder = localCue;
        break;
      case 20: 
        PgsDecoder.CueBuilder.access$000(paramCueBuilder, paramParsableByteArray, k);
        paramCueBuilder = localCue;
        break;
      }
    }
    else
    {
      localCue = paramCueBuilder.build();
      paramCueBuilder.reset();
      paramCueBuilder = localCue;
    }
    paramParsableByteArray.setPosition(m);
    return paramCueBuilder;
  }
  
  protected Subtitle decode(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    this.buffer.reset(paramArrayOfByte, paramInt);
    this.cueBuilder.reset();
    paramArrayOfByte = new ArrayList();
    while (this.buffer.bytesLeft() >= 3)
    {
      Cue localCue = readNextSection(this.buffer, this.cueBuilder);
      if (localCue != null) {
        paramArrayOfByte.add(localCue);
      }
    }
    return new PgsSubtitle(Collections.unmodifiableList(paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.text.pgs.PgsDecoder
 * JD-Core Version:    0.7.0.1
 */