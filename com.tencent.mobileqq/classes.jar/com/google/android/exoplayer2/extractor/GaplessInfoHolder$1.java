package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate;

final class GaplessInfoHolder$1
  implements Id3Decoder.FramePredicate
{
  public boolean evaluate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return (paramInt2 == 67) && (paramInt3 == 79) && (paramInt4 == 77) && ((paramInt5 == 77) || (paramInt1 == 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.GaplessInfoHolder.1
 * JD-Core Version:    0.7.0.1
 */