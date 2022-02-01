package androidx.core.provider;

import java.util.Comparator;

class FontsContractCompat$5
  implements Comparator<byte[]>
{
  public int compare(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j;
    if (paramArrayOfByte1.length != paramArrayOfByte2.length)
    {
      i = paramArrayOfByte1.length;
      j = paramArrayOfByte2.length;
      return i - j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte1.length) {
        break label63;
      }
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i])
      {
        j = paramArrayOfByte1[i];
        int k = paramArrayOfByte2[i];
        i = j;
        j = k;
        break;
      }
      i += 1;
    }
    label63:
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.provider.FontsContractCompat.5
 * JD-Core Version:    0.7.0.1
 */