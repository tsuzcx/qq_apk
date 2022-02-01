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
    while (paramParsableByteArray.bytesLeft() > 1)
    {
      int j = readNon255TerminatedValue(paramParsableByteArray);
      int k = readNon255TerminatedValue(paramParsableByteArray);
      int m = paramParsableByteArray.getPosition() + k;
      int i;
      if ((k != -1) && (k <= paramParsableByteArray.bytesLeft()))
      {
        i = m;
        if (j == 4)
        {
          i = m;
          if (k >= 8)
          {
            i = paramParsableByteArray.readUnsignedByte();
            int i1 = paramParsableByteArray.readUnsignedShort();
            int n = 0;
            if (i1 == 49) {
              j = paramParsableByteArray.readInt();
            } else {
              j = 0;
            }
            k = paramParsableByteArray.readUnsignedByte();
            if (i1 == 47) {
              paramParsableByteArray.skipBytes(1);
            }
            if ((i == 181) && ((i1 == 49) || (i1 == 47)) && (k == 3)) {
              i = 1;
            } else {
              i = 0;
            }
            k = i;
            if (i1 == 49)
            {
              if ((j != USER_ID_GA94) && (j != USER_ID_DTG1)) {
                j = 0;
              } else {
                j = 1;
              }
              k = i & j;
            }
            i = m;
            if (k != 0)
            {
              i = paramParsableByteArray.readUnsignedByte();
              paramParsableByteArray.skipBytes(1);
              k = (i & 0x1F) * 3;
              i1 = paramParsableByteArray.getPosition();
              int i2 = paramArrayOfTrackOutput.length;
              j = n;
              for (;;)
              {
                i = m;
                if (j >= i2) {
                  break;
                }
                TrackOutput localTrackOutput = paramArrayOfTrackOutput[j];
                paramParsableByteArray.setPosition(i1);
                localTrackOutput.sampleData(paramParsableByteArray, k);
                localTrackOutput.sampleMetadata(paramLong, 1, k, 0, null);
                j += 1;
              }
            }
          }
        }
      }
      else
      {
        Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
        i = paramParsableByteArray.limit();
      }
      paramParsableByteArray.setPosition(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.text.cea.CeaUtil
 * JD-Core Version:    0.7.0.1
 */