package com.google.android.exoplayer2.text.cea;

import android.util.Log;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public final class CeaUtil
{
  private static final int COUNTRY_CODE = 181;
  private static final int PAYLOAD_TYPE_CC = 4;
  private static final int PROVIDER_CODE_ATSC = 49;
  private static final int PROVIDER_CODE_DIRECTV = 47;
  private static final String TAG = "CeaUtil";
  private static final int USER_DATA_TYPE_CODE = 3;
  private static final int USER_ID_DTG1 = Util.getIntegerCodeForString("DTG1");
  private static final int USER_ID_GA94 = Util.getIntegerCodeForString("GA94");
  
  public static void consume(long paramLong, ParsableByteArray paramParsableByteArray, TrackOutput[] paramArrayOfTrackOutput)
  {
    int i;
    int k;
    int m;
    int n;
    int j;
    int i1;
    for (;;)
    {
      if (paramParsableByteArray.bytesLeft() > 1)
      {
        i = readNon255TerminatedValue(paramParsableByteArray);
        k = readNon255TerminatedValue(paramParsableByteArray);
        m = paramParsableByteArray.getPosition();
        if ((k == -1) || (k > paramParsableByteArray.bytesLeft()))
        {
          Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
          i = paramParsableByteArray.limit();
          paramParsableByteArray.setPosition(i);
        }
        else
        {
          if ((i != 4) || (k < 8)) {
            break label289;
          }
          i = paramParsableByteArray.readUnsignedByte();
          n = paramParsableByteArray.readUnsignedShort();
          j = 0;
          if (n == 49) {
            j = paramParsableByteArray.readInt();
          }
          i1 = paramParsableByteArray.readUnsignedByte();
          if (n == 47) {
            paramParsableByteArray.skipBytes(1);
          }
          if ((i == 181) && ((n == 49) || (n == 47)) && (i1 == 3))
          {
            i = 1;
            if (n != 49) {
              break label299;
            }
            if ((j != USER_ID_GA94) && (j != USER_ID_DTG1)) {
              break label282;
            }
            j = 1;
            label180:
            i = j & i;
          }
        }
      }
    }
    label282:
    label289:
    label299:
    for (;;)
    {
      if (i != 0)
      {
        i = paramParsableByteArray.readUnsignedByte();
        paramParsableByteArray.skipBytes(1);
        j = (i & 0x1F) * 3;
        n = paramParsableByteArray.getPosition();
        i1 = paramArrayOfTrackOutput.length;
        i = 0;
        for (;;)
        {
          if (i < i1)
          {
            TrackOutput localTrackOutput = paramArrayOfTrackOutput[i];
            paramParsableByteArray.setPosition(n);
            localTrackOutput.sampleData(paramParsableByteArray, j);
            localTrackOutput.sampleMetadata(paramLong, 1, j, 0, null);
            i += 1;
            continue;
            i = 0;
            break;
            j = 0;
            break label180;
            return;
          }
        }
      }
      i = m + k;
      break;
    }
  }
  
  private static int readNon255TerminatedValue(ParsableByteArray paramParsableByteArray)
  {
    int i = 0;
    int k;
    int j;
    do
    {
      if (paramParsableByteArray.bytesLeft() == 0) {
        return -1;
      }
      k = paramParsableByteArray.readUnsignedByte();
      j = i + k;
      i = j;
    } while (k == 255);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.text.cea.CeaUtil
 * JD-Core Version:    0.7.0.1
 */