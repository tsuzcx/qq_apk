package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferEncoder
  implements Encoder<ByteBuffer>
{
  public boolean a(@NonNull ByteBuffer paramByteBuffer, @NonNull File paramFile, @NonNull Options paramOptions)
  {
    try
    {
      ByteBufferUtil.a(paramByteBuffer, paramFile);
      return true;
    }
    catch (IOException paramByteBuffer)
    {
      if (Log.isLoggable("ByteBufferEncoder", 3)) {
        Log.d("ByteBufferEncoder", "Failed to write data", paramByteBuffer);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ByteBufferEncoder
 * JD-Core Version:    0.7.0.1
 */