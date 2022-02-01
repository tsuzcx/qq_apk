package com.google.android.exoplayer2.extractor.ogg;

final class VorbisReader$VorbisSetup
{
  public final VorbisUtil.CommentHeader commentHeader;
  public final int iLogModes;
  public final VorbisUtil.VorbisIdHeader idHeader;
  public final VorbisUtil.Mode[] modes;
  public final byte[] setupHeaderData;
  
  public VorbisReader$VorbisSetup(VorbisUtil.VorbisIdHeader paramVorbisIdHeader, VorbisUtil.CommentHeader paramCommentHeader, byte[] paramArrayOfByte, VorbisUtil.Mode[] paramArrayOfMode, int paramInt)
  {
    this.idHeader = paramVorbisIdHeader;
    this.commentHeader = paramCommentHeader;
    this.setupHeaderData = paramArrayOfByte;
    this.modes = paramArrayOfMode;
    this.iLogModes = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ogg.VorbisReader.VorbisSetup
 * JD-Core Version:    0.7.0.1
 */