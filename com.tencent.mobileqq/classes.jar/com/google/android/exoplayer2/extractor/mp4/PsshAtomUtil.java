package com.google.android.exoplayer2.extractor.mp4;

import android.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class PsshAtomUtil
{
  private static final String TAG = "PsshAtomUtil";
  
  public static byte[] buildPsshAtom(UUID paramUUID, byte[] paramArrayOfByte)
  {
    return buildPsshAtom(paramUUID, null, paramArrayOfByte);
  }
  
  public static byte[] buildPsshAtom(UUID paramUUID, UUID[] paramArrayOfUUID, byte[] paramArrayOfByte)
  {
    int m = 0;
    int j;
    int i;
    label17:
    ByteBuffer localByteBuffer;
    if (paramArrayOfUUID != null)
    {
      j = 1;
      if (paramArrayOfByte == null) {
        break label173;
      }
      i = paramArrayOfByte.length;
      int n = i + 32;
      k = n;
      if (j != 0) {
        k = n + (paramArrayOfUUID.length * 16 + 4);
      }
      localByteBuffer = ByteBuffer.allocate(k);
      localByteBuffer.putInt(k);
      localByteBuffer.putInt(Atom.TYPE_pssh);
      if (j == 0) {
        break label178;
      }
    }
    label173:
    label178:
    for (int k = 16777216;; k = 0)
    {
      localByteBuffer.putInt(k);
      localByteBuffer.putLong(paramUUID.getMostSignificantBits());
      localByteBuffer.putLong(paramUUID.getLeastSignificantBits());
      if (j == 0) {
        break label184;
      }
      localByteBuffer.putInt(paramArrayOfUUID.length);
      k = paramArrayOfUUID.length;
      j = m;
      while (j < k)
      {
        paramUUID = paramArrayOfUUID[j];
        localByteBuffer.putLong(paramUUID.getMostSignificantBits());
        localByteBuffer.putLong(paramUUID.getLeastSignificantBits());
        j += 1;
      }
      j = 0;
      break;
      i = 0;
      break label17;
    }
    label184:
    if (i != 0)
    {
      localByteBuffer.putInt(paramArrayOfByte.length);
      localByteBuffer.put(paramArrayOfByte);
    }
    return localByteBuffer.array();
  }
  
  private static PsshAtomUtil.PsshAtom parsePsshAtom(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new ParsableByteArray(paramArrayOfByte);
    if (paramArrayOfByte.limit() < 32) {}
    int i;
    UUID localUUID;
    int j;
    do
    {
      do
      {
        return null;
        paramArrayOfByte.setPosition(0);
      } while ((paramArrayOfByte.readInt() != paramArrayOfByte.bytesLeft() + 4) || (paramArrayOfByte.readInt() != Atom.TYPE_pssh));
      i = Atom.parseFullAtomVersion(paramArrayOfByte.readInt());
      if (i > 1)
      {
        Log.w("PsshAtomUtil", "Unsupported pssh version: " + i);
        return null;
      }
      localUUID = new UUID(paramArrayOfByte.readLong(), paramArrayOfByte.readLong());
      if (i == 1) {
        paramArrayOfByte.skipBytes(paramArrayOfByte.readUnsignedIntToInt() * 16);
      }
      j = paramArrayOfByte.readUnsignedIntToInt();
    } while (j != paramArrayOfByte.bytesLeft());
    byte[] arrayOfByte = new byte[j];
    paramArrayOfByte.readBytes(arrayOfByte, 0, j);
    return new PsshAtomUtil.PsshAtom(localUUID, i, arrayOfByte);
  }
  
  public static byte[] parseSchemeSpecificData(byte[] paramArrayOfByte, UUID paramUUID)
  {
    paramArrayOfByte = parsePsshAtom(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      return null;
    }
    if ((paramUUID != null) && (!paramUUID.equals(PsshAtomUtil.PsshAtom.access$000(paramArrayOfByte))))
    {
      Log.w("PsshAtomUtil", "UUID mismatch. Expected: " + paramUUID + ", got: " + PsshAtomUtil.PsshAtom.access$000(paramArrayOfByte) + ".");
      return null;
    }
    return PsshAtomUtil.PsshAtom.access$200(paramArrayOfByte);
  }
  
  public static UUID parseUuid(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = parsePsshAtom(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      return null;
    }
    return PsshAtomUtil.PsshAtom.access$000(paramArrayOfByte);
  }
  
  public static int parseVersion(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = parsePsshAtom(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      return -1;
    }
    return PsshAtomUtil.PsshAtom.access$100(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil
 * JD-Core Version:    0.7.0.1
 */