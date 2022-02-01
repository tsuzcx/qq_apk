package com.google.android.exoplayer2.extractor.mp4;

import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.util.Assertions;

public final class TrackEncryptionBox
{
  private static final String TAG = "TrackEncryptionBox";
  public final TrackOutput.CryptoData cryptoData;
  public final byte[] defaultInitializationVector;
  public final int initializationVectorSize;
  public final boolean isEncrypted;
  @Nullable
  public final String schemeType;
  
  public TrackEncryptionBox(boolean paramBoolean, @Nullable String paramString, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, @Nullable byte[] paramArrayOfByte2)
  {
    int j = 1;
    int i;
    if (paramInt1 == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramArrayOfByte2 != null) {
      j = 0;
    }
    Assertions.checkArgument(j ^ i);
    this.isEncrypted = paramBoolean;
    this.schemeType = paramString;
    this.initializationVectorSize = paramInt1;
    this.defaultInitializationVector = paramArrayOfByte2;
    this.cryptoData = new TrackOutput.CryptoData(schemeToCryptoMode(paramString), paramArrayOfByte1, paramInt2, paramInt3);
  }
  
  private static int schemeToCryptoMode(@Nullable String paramString)
  {
    if (paramString == null) {
      return 1;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 3049895: 
      if (paramString.equals("cens")) {
        i = 1;
      }
      break;
    case 3049879: 
      if (paramString.equals("cenc")) {
        i = 0;
      }
      break;
    case 3046671: 
      if (paramString.equals("cbcs")) {
        i = 3;
      }
      break;
    case 3046605: 
      if (paramString.equals("cbc1")) {
        i = 2;
      }
      break;
    }
    if ((i != 0) && (i != 1))
    {
      if ((i != 2) && (i != 3))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unsupported protection scheme type '");
        localStringBuilder.append(paramString);
        localStringBuilder.append("'. Assuming AES-CTR crypto mode.");
        Log.w("TrackEncryptionBox", localStringBuilder.toString());
        return 1;
      }
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox
 * JD-Core Version:    0.7.0.1
 */