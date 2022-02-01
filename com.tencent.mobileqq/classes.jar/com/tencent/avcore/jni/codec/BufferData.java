package com.tencent.avcore.jni.codec;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

@RequiresApi(api=16)
public class BufferData
{
  public ByteBuffer buffer;
  public MediaFormat format;
  public int index;
  public MediaCodec.BufferInfo info = new MediaCodec.BufferInfo();
  public boolean success = true;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.jni.codec.BufferData
 * JD-Core Version:    0.7.0.1
 */