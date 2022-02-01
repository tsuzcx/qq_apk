package com.tencent.av.ui.funchat.record;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(16)
public class AudioFileDecoder
{
  private int jdField_a_of_type_Int;
  private MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private AudioFileDecoder.Callback jdField_a_of_type_ComTencentAvUiFunchatRecordAudioFileDecoder$Callback;
  private BufferedOutputStream jdField_a_of_type_JavaIoBufferedOutputStream;
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public AudioFileDecoder() {}
  
  public AudioFileDecoder(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
  }
  
  private void a()
  {
    ByteBuffer[] arrayOfByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
    int i;
    Object localObject1;
    do
    {
      for (;;)
      {
        i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
        if (i < 0) {
          break;
        }
        localObject1 = arrayOfByteBuffer[i];
        ((ByteBuffer)localObject1).clear();
        int j = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData((ByteBuffer)localObject1, 0);
        if (j < 0)
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, 0, 0L, 0);
          break label97;
        }
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, j, 0L, 0);
        this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
      }
    } while (i != -1);
    label97:
    arrayOfByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
    for (;;)
    {
      i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
      Object localObject2;
      if (i >= 0)
      {
        localObject1 = arrayOfByteBuffer[i];
        localObject2 = new byte[this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size];
        ((ByteBuffer)localObject1).get((byte[])localObject2);
        ((ByteBuffer)localObject1).clear();
        this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(i, false);
        a((byte[])localObject2);
      }
      else
      {
        if (i != -2) {
          break;
        }
        localObject1 = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("encoder output format changed: ");
          ((StringBuilder)localObject2).append(localObject1);
          QLog.d("AudioFileDecoder", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return;
      }
      int i = this.d;
      if (i != 0)
      {
        int j = this.e;
        if (j != 0)
        {
          int k = this.f;
          if (k != 0)
          {
            paramArrayOfByte = PCMConverter.a(paramArrayOfByte, i, j, k, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c);
            try
            {
              this.jdField_a_of_type_JavaIoBufferedOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
              return;
            }
            catch (IOException paramArrayOfByte)
            {
              QLog.e("AudioFileDecoder", 1, "writeFile exception", paramArrayOfByte);
              paramArrayOfByte.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidMediaMediaCodec;
    if (localObject != null)
    {
      ((MediaCodec)localObject).stop();
      this.jdField_a_of_type_AndroidMediaMediaCodec.release();
      this.jdField_a_of_type_AndroidMediaMediaCodec = null;
    }
    localObject = this.jdField_a_of_type_AndroidMediaMediaExtractor;
    if (localObject != null)
    {
      ((MediaExtractor)localObject).release();
      this.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
    try
    {
      if (this.jdField_a_of_type_JavaIoBufferedOutputStream != null)
      {
        this.jdField_a_of_type_JavaIoBufferedOutputStream.flush();
        this.jdField_a_of_type_JavaIoBufferedOutputStream.close();
      }
      if (QLog.isColorLevel())
      {
        QLog.d("AudioFileDecoder", 2, String.format("decode successful, save to %s, size: %sK", new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(new File(this.jdField_b_of_type_JavaLangString).length() / 1024L) }));
        return;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public void a(AudioFileDecoder.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordAudioFileDecoder$Callback = paramCallback;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    paramString1 = new File(this.jdField_a_of_type_JavaLangString);
    boolean bool = paramString1.exists();
    int j = 0;
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioFileDecoder", 2, String.format("audio file %s is not exist", new Object[] { this.jdField_a_of_type_JavaLangString }));
      }
      paramString1 = this.jdField_a_of_type_ComTencentAvUiFunchatRecordAudioFileDecoder$Callback;
      if (paramString1 != null) {
        paramString1.a(-2);
      }
      return;
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
      this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(this.jdField_a_of_type_JavaLangString);
      int i = 0;
      Object localObject;
      while (i < this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackCount())
      {
        paramString2 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(i);
        localObject = paramString2.getString("mime");
        if (((String)localObject).startsWith("audio"))
        {
          this.jdField_a_of_type_AndroidMediaMediaFormat = paramString2;
          this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(i);
          this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType((String)localObject);
          try
          {
            this.jdField_a_of_type_AndroidMediaMediaCodec.configure(paramString2, null, null, 0);
          }
          catch (Throwable paramString2)
          {
            if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordAudioFileDecoder$Callback != null) {
              this.jdField_a_of_type_ComTencentAvUiFunchatRecordAudioFileDecoder$Callback.a(-5);
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("decode configure exception:");
            ((StringBuilder)localObject).append(paramString2);
            QLog.e("AudioFileDecoder", 1, ((StringBuilder)localObject).toString(), paramString2);
          }
        }
        i += 1;
      }
      if (this.jdField_a_of_type_AndroidMediaMediaCodec == null)
      {
        QLog.e("AudioFileDecoder", 1, "init audioCodec fail");
        paramString1 = this.jdField_a_of_type_ComTencentAvUiFunchatRecordAudioFileDecoder$Callback;
        if (paramString1 != null) {
          paramString1.a(-1);
        }
        return;
      }
      this.d = this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("sample-rate");
      this.f = this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("channel-count");
      this.e = 16;
      if (QLog.isColorLevel()) {
        QLog.d("AudioFileDecoder", 2, String.format("decode audio sampleRate: %s, channelCount: %s, bitDeepth: %s", new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.f), Integer.valueOf(this.e) }));
      }
      try
      {
        this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_JavaIoBufferedOutputStream = new BufferedOutputStream(this.jdField_a_of_type_JavaIoFileOutputStream);
      }
      catch (IOException paramString2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("decode io exception:");
        ((StringBuilder)localObject).append(paramString2);
        QLog.e("AudioFileDecoder", 1, ((StringBuilder)localObject).toString(), paramString2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AudioFileDecoder", 2, String.format("start decode file %s, size: %sK", new Object[] { this.jdField_a_of_type_JavaLangString, Long.valueOf(paramString1.length() / 1024L) }));
      }
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec.start();
        paramString1 = this.jdField_a_of_type_ComTencentAvUiFunchatRecordAudioFileDecoder$Callback;
        if (paramString1 != null) {
          paramString1.a(this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_Boolean = false;
        for (;;)
        {
          if (this.jdField_a_of_type_Boolean) {
            break label584;
          }
          try
          {
            a();
          }
          catch (Throwable paramString1)
          {
            paramString2 = new StringBuilder();
            paramString2.append("decode frame exception:");
            paramString2.append(paramString1);
            QLog.e("AudioFileDecoder", 1, paramString2.toString(), paramString1);
            paramString1 = this.jdField_a_of_type_ComTencentAvUiFunchatRecordAudioFileDecoder$Callback;
            i = j;
            if (paramString1 == null) {
              break label586;
            }
          }
        }
        paramString1.a(-6);
        i = j;
        break label586;
        label584:
        i = 1;
        label586:
        b();
        if (i != 0)
        {
          paramString1 = this.jdField_a_of_type_ComTencentAvUiFunchatRecordAudioFileDecoder$Callback;
          if (paramString1 != null) {
            paramString1.b(this.jdField_b_of_type_JavaLangString);
          }
        }
        return;
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("decode start exception:");
        paramString2.append(paramString1);
        QLog.e("AudioFileDecoder", 1, paramString2.toString(), paramString1);
        paramString1 = this.jdField_a_of_type_ComTencentAvUiFunchatRecordAudioFileDecoder$Callback;
        if (paramString1 != null) {
          paramString1.a(-4);
        }
        return;
      }
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      paramString1 = this.jdField_a_of_type_ComTencentAvUiFunchatRecordAudioFileDecoder$Callback;
      if (paramString1 != null) {
        paramString1.a(-3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.AudioFileDecoder
 * JD-Core Version:    0.7.0.1
 */