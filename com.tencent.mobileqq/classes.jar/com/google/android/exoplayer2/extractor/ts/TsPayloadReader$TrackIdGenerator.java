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
    Object localObject;
    if (paramInt1 != -2147483648)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("/");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    this.formatIdPrefix = ((String)localObject);
    this.firstTrackId = paramInt2;
    this.trackIdIncrement = paramInt3;
    this.trackId = -2147483648;
  }
  
  private void maybeThrowUninitializedError()
  {
    if (this.trackId != -2147483648) {
      return;
    }
    throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
  }
  
  public void generateNewId()
  {
    int i = this.trackId;
    if (i == -2147483648) {
      i = this.firstTrackId;
    } else {
      i += this.trackIdIncrement;
    }
    this.trackId = i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.formatIdPrefix);
    localStringBuilder.append(this.trackId);
    this.formatId = localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator
 * JD-Core Version:    0.7.0.1
 */