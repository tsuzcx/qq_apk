package com.google.android.exoplayer2.extractor.ts;

public final class TsPayloadReader$TrackIdGenerator
{
  private static final int ID_UNSET = -2147483648;
  private final int firstTrackId;
  private String formatId;
  private final String formatIdPrefix;
  private int trackId;
  private final int trackIdIncrement;
  
  public TsPayloadReader$TrackIdGenerator(int paramInt1, int paramInt2)
  {
    this(-2147483648, paramInt1, paramInt2);
  }
  
  public TsPayloadReader$TrackIdGenerator(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != -2147483648) {}
    for (String str = paramInt1 + "/";; str = "")
    {
      this.formatIdPrefix = str;
      this.firstTrackId = paramInt2;
      this.trackIdIncrement = paramInt3;
      this.trackId = -2147483648;
      return;
    }
  }
  
  private void maybeThrowUninitializedError()
  {
    if (this.trackId == -2147483648) {
      throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
    }
  }
  
  public void generateNewId()
  {
    if (this.trackId == -2147483648) {}
    for (int i = this.firstTrackId;; i = this.trackId + this.trackIdIncrement)
    {
      this.trackId = i;
      this.formatId = (this.formatIdPrefix + this.trackId);
      return;
    }
  }
  
  public String getFormatId()
  {
    maybeThrowUninitializedError();
    return this.formatId;
  }
  
  public int getTrackId()
  {
    maybeThrowUninitializedError();
    return this.trackId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator
 * JD-Core Version:    0.7.0.1
 */