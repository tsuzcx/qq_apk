package com.google.android.exoplayer2.metadata.emsg;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class EventMessageEncoder
{
  private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
  private final DataOutputStream dataOutputStream = new DataOutputStream(this.byteArrayOutputStream);
  
  private static void writeNullTerminatedString(DataOutputStream paramDataOutputStream, String paramString)
  {
    paramDataOutputStream.writeBytes(paramString);
    paramDataOutputStream.writeByte(0);
  }
  
  private static void writeUnsignedInt(DataOutputStream paramDataOutputStream, long paramLong)
  {
    paramDataOutputStream.writeByte((int)(paramLong >>> 24) & 0xFF);
    paramDataOutputStream.writeByte((int)(paramLong >>> 16) & 0xFF);
    paramDataOutputStream.writeByte((int)(paramLong >>> 8) & 0xFF);
    paramDataOutputStream.writeByte((int)paramLong & 0xFF);
  }
  
  @Nullable
  public byte[] encode(EventMessage paramEventMessage, long paramLong)
  {
    boolean bool;
    if (paramLong >= 0L) {
      bool = true;
    }
    for (;;)
    {
      Assertions.checkArgument(bool);
      this.byteArrayOutputStream.reset();
      try
      {
        writeNullTerminatedString(this.dataOutputStream, paramEventMessage.schemeIdUri);
        if (paramEventMessage.value != null) {}
        for (String str = paramEventMessage.value;; str = "")
        {
          writeNullTerminatedString(this.dataOutputStream, str);
          writeUnsignedInt(this.dataOutputStream, paramLong);
          long l = Util.scaleLargeTimestamp(paramEventMessage.presentationTimeUs, paramLong, 1000000L);
          writeUnsignedInt(this.dataOutputStream, l);
          paramLong = Util.scaleLargeTimestamp(paramEventMessage.durationMs, paramLong, 1000L);
          writeUnsignedInt(this.dataOutputStream, paramLong);
          writeUnsignedInt(this.dataOutputStream, paramEventMessage.id);
          this.dataOutputStream.write(paramEventMessage.messageData);
          this.dataOutputStream.flush();
          return this.byteArrayOutputStream.toByteArray();
        }
        bool = false;
      }
      catch (IOException paramEventMessage)
      {
        throw new RuntimeException(paramEventMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder
 * JD-Core Version:    0.7.0.1
 */