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
    if (paramArrayOfUUID != null) {
      j = 1;
    } else {
      j = 0;
    }
    int i;
    if (paramArrayOfByte != null) {
      i = paramArrayOfByte.length;
    } else {
      i = 0;
    }
    int n = i + 32;
    int k = n;
    if (j != 0) {
      k = n + (paramArrayOfUUID.length * 16 + 4);
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(k);
    localByteBuffer.putInt(k);
    localByteBuffer.putInt(Atom.TYPE_pssh);
    if (j != 0) {
      k = 16777216;
    } else {
      k = 0;
    }
    localByteBuffer.putInt(k);
    localByteBuffer.putLong(paramUUID.getMostSignificantBits());
    localByteBuffer.putLong(paramUUID.getLeastSignificantBits());
    if (j != 0)
    {
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
    }
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
    if (paramArrayOfByte.limit() < 32) {
      return null;
    }
    paramArrayOfByte.setPosition(0);
    if (paramArrayOfByte.readInt() != paramArrayOfByte.bytesLeft() + 4) {
      return null;
    }
    if (paramArrayOfByte.readInt() != Atom.TYPE_pssh) {
      return null;
    }
    int i = Atom.parseFullAtomVersion(paramArrayOfByte.readInt());
    if (i > 1)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("Unsupported pssh version: ");
      paramArrayOfByte.append(i);
      Log.w("PsshAtomUtil", paramArrayOfByte.toString());
      return null;
    }
    UUID localUUID = new UUID(paramArrayOfByte.readLong(), paramArrayOfByte.readLong());
    if (i == 1) {
      paramArrayOfByte.skipBytes(paramArrayOfByte.readUnsignedIntToInt() * 16);
    }
    int j = paramArrayOfByte.readUnsignedIntToInt();
    if (j != paramArrayOfByte.bytesLeft()) {
      return null;
    }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UUID mismatch. Expected: ");
      localStringBuilder.append(paramUUID);
      localStringBuilder.append(", got: ");
      localStringBuilder.append(PsshAtomUtil.PsshAtom.access$000(paramArrayOfByte));
      localStringBuilder.append(".");
      Log.w("PsshAtomUtil", localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil
 * JD-Core Version:    0.7.0.1
 */