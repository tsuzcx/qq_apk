package com.tencent.TMG.audio;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.TMG.utils.QLog;
import java.io.IOException;
import java.nio.ByteBuffer;

public class AudioDecoder
{
  private static final String TAG = "AudioDecoder";
  boolean IsTenFramesReady = false;
  int channels = 0;
  private boolean codeOver = true;
  private RingBuffer decRingBuffer = null;
  private MediaCodec.BufferInfo decodeBufferInfo = null;
  private ByteBuffer[] decodeInputBuffers = null;
  private ByteBuffer[] decodeOutputBuffers = null;
  private long fileTotalMs = 0L;
  int m_nIndex = 0;
  private MediaCodec mediaDecode = null;
  private MediaExtractor mediaExtractor = null;
  int nFirstThreeFrameInfo = 3;
  int nFrameSize = 3840;
  private AudioDecoder.OnCompleteListener onCompleteListener = null;
  private AudioDecoder.OnProgressListener onProgressListener = null;
  int sampleRate = 0;
  private String srcPath;
  
  private int initMediaDecode(int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        this.mediaExtractor = new MediaExtractor();
        this.mediaExtractor.setDataSource(this.srcPath);
        if (this.mediaExtractor.getTrackCount() <= 1) {
          break label522;
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "m_nIndex: " + this.m_nIndex + " initMediaDecode mediaExtractor container video, getTrackCount: " + this.mediaExtractor.getTrackCount());
        }
        this.codeOver = true;
        return -2;
      }
      catch (IOException localIOException)
      {
        MediaFormat localMediaFormat;
        String str;
        localIOException.printStackTrace();
        this.codeOver = true;
        return -1;
      }
      if (i < this.mediaExtractor.getTrackCount())
      {
        localMediaFormat = this.mediaExtractor.getTrackFormat(i);
        str = localMediaFormat.getString("mime");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "m_nIndex: " + this.m_nIndex + " initMediaDecode mediaExtractor audio type:" + str);
        }
        if (!str.startsWith("audio/mpeg")) {
          continue;
        }
        this.mediaExtractor.selectTrack(i);
        this.mediaDecode = MediaCodec.createDecoderByType(str);
        this.mediaDecode.configure(localMediaFormat, null, null, 0);
        this.sampleRate = localMediaFormat.getInteger("sample-rate");
        this.channels = localMediaFormat.getInteger("channel-count");
        this.fileTotalMs = (localMediaFormat.getLong("durationUs") / 1000L);
        this.nFrameSize = (this.sampleRate * this.channels * 2 * 20 / 1000);
        this.decRingBuffer = new RingBuffer(this.nFrameSize * paramInt);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "m_nIndex: " + this.m_nIndex + " initMediaDecode open succeed, mp3 format:(" + this.sampleRate + "," + this.channels + "), fileTotalMs:" + this.fileTotalMs + "ms RingBufferFrame:" + paramInt);
        }
      }
      if (this.mediaDecode == null)
      {
        Log.e("AudioDecoder", "m_nIndex: " + this.m_nIndex + " initMediaDecode create mediaDecode failed");
        this.codeOver = true;
        return -1;
        i += 1;
      }
      else
      {
        if (this.decRingBuffer == null)
        {
          Log.e("AudioDecoder", "m_nIndex: " + this.m_nIndex + " initMediaDecode create decRingBuffer failed");
          this.codeOver = true;
          return -1;
        }
        this.mediaDecode.start();
        this.decodeInputBuffers = this.mediaDecode.getInputBuffers();
        this.decodeOutputBuffers = this.mediaDecode.getOutputBuffers();
        this.decodeBufferInfo = new MediaCodec.BufferInfo();
        this.codeOver = false;
        this.IsTenFramesReady = false;
        this.nFirstThreeFrameInfo = 3;
        return 0;
        label522:
        i = 0;
      }
    }
  }
  
  private void showLog(String paramString)
  {
    Log.e("AudioCodec", paramString);
  }
  
  private void srcAudioFormatToPCM()
  {
    if (this.decodeInputBuffers.length <= 1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "m_nIndex: " + this.m_nIndex + " srcAudioFormatToPCM decodeInputBuffers.length to small," + this.decodeInputBuffers.length);
      }
      this.codeOver = true;
    }
    int i;
    int j;
    label142:
    int k;
    label207:
    do
    {
      return;
      i = this.mediaDecode.dequeueInputBuffer(-1L);
      if (i < 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "m_nIndex: " + this.m_nIndex + " srcAudioFormatToPCM decodeInputBuffers.inputIndex <0");
        }
        this.codeOver = true;
        return;
      }
      j = Build.VERSION.SDK_INT;
      if (j < 21) {
        break;
      }
      localByteBuffer = this.mediaDecode.getInputBuffer(i);
      localByteBuffer.clear();
      k = this.mediaExtractor.readSampleData(localByteBuffer, 0);
      if (k >= 0) {
        break label435;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "m_nIndex: " + this.m_nIndex + " srcAudioFormatToPCM readSampleData over,end");
      }
      this.codeOver = true;
      i = this.mediaDecode.dequeueOutputBuffer(this.decodeBufferInfo, 10000L);
    } while (i < 0);
    if (j >= 21) {}
    for (ByteBuffer localByteBuffer = this.mediaDecode.getOutputBuffer(i);; localByteBuffer = this.decodeOutputBuffers[i])
    {
      for (;;)
      {
        byte[] arrayOfByte = new byte[this.decodeBufferInfo.size];
        try
        {
          localByteBuffer.get(arrayOfByte);
          localByteBuffer.clear();
          if ((this.decRingBuffer != null) && (this.decodeBufferInfo.size > 0))
          {
            this.decRingBuffer.Push(arrayOfByte, this.decodeBufferInfo.size);
            k = this.nFirstThreeFrameInfo;
            this.nFirstThreeFrameInfo = (k - 1);
            if ((k > 0) && (QLog.isColorLevel())) {
              QLog.w("TRAE", 0, "m_nIndex: " + this.m_nIndex + " DecodeOneFrame size: " + this.decodeBufferInfo.size + " Remain: " + this.decRingBuffer.RemainRead() / this.nFrameSize);
            }
          }
          this.mediaDecode.releaseOutputBuffer(i, false);
          if (this.decodeBufferInfo.size > 0) {
            break;
          }
          i = this.mediaDecode.dequeueOutputBuffer(this.decodeBufferInfo, 10000L);
        }
        catch (Exception localException)
        {
          label435:
          if (!QLog.isColorLevel()) {
            break label515;
          }
          QLog.w("TRAE", 0, "m_nIndex: " + this.m_nIndex + " srcAudioFormatToPCM wrong outputIndex: " + i);
          this.codeOver = true;
        }
      }
      localByteBuffer = this.decodeInputBuffers[i];
      break label142;
      this.mediaDecode.queueInputBuffer(i, 0, k, 0L, 0);
      this.mediaExtractor.advance();
      break label207;
    }
    label515:
  }
  
  public int ReadOneFrame(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 20;
    int i = j;
    if (!this.IsTenFramesReady)
    {
      i = 20;
      while ((this.decRingBuffer.RemainRead() / this.nFrameSize < 10) && (i > 0) && (!this.codeOver))
      {
        srcAudioFormatToPCM();
        i -= 1;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "m_nIndex: " + this.m_nIndex + " 10 FramesReady Remain frame: " + this.decRingBuffer.RemainRead() / this.nFrameSize);
      }
      this.IsTenFramesReady = true;
      i = j;
    }
    while ((!this.codeOver) && (this.decRingBuffer.RemainRead() / this.nFrameSize < 10) && (i > 0))
    {
      srcAudioFormatToPCM();
      i -= 1;
    }
    if (this.decRingBuffer.RemainRead() >= paramInt)
    {
      this.decRingBuffer.Pop(paramArrayOfByte, paramInt);
      return paramInt;
    }
    return -1;
  }
  
  public int SeekTo(int paramInt)
  {
    if (this.mediaExtractor != null)
    {
      long l1 = this.mediaExtractor.getSampleTime();
      paramInt = this.decRingBuffer.RemainRead() * 20 / this.nFrameSize + paramInt;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "m_nIndex: " + this.m_nIndex + " current PlayMs: " + l1 / 1000L + " SeekTo: " + paramInt);
      }
      this.mediaExtractor.seekTo(paramInt * 1000, 2);
      long l2 = this.mediaExtractor.getSampleTime();
      paramInt = (int)((l2 - l1) / 1000L);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "m_nIndex: " + this.m_nIndex + " total SeekTo time: " + paramInt + " t2:" + l2 / 1000L);
      }
      return paramInt;
    }
    return 0;
  }
  
  public int getChannels()
  {
    return this.channels;
  }
  
  public long getFileTotalMs()
  {
    return this.fileTotalMs;
  }
  
  public int getFrameSize()
  {
    return this.nFrameSize;
  }
  
  public int getSampleRate()
  {
    return this.sampleRate;
  }
  
  public int prepare(int paramInt)
  {
    if (this.srcPath == null) {
      return -1;
    }
    return initMediaDecode(paramInt);
  }
  
  public void release()
  {
    if (this.mediaDecode != null)
    {
      this.mediaDecode.stop();
      this.mediaDecode.release();
      this.mediaDecode = null;
    }
    if (this.mediaExtractor != null)
    {
      this.mediaExtractor.release();
      this.mediaExtractor = null;
    }
    if (this.onCompleteListener != null) {
      this.onCompleteListener = null;
    }
    if (this.onProgressListener != null) {
      this.onProgressListener = null;
    }
    showLog("release");
  }
  
  public void setIOPath(String paramString)
  {
    this.srcPath = paramString;
  }
  
  public void setIndex(int paramInt)
  {
    this.m_nIndex = paramInt;
  }
  
  public void setOnCompleteListener(AudioDecoder.OnCompleteListener paramOnCompleteListener)
  {
    this.onCompleteListener = paramOnCompleteListener;
  }
  
  public void setOnProgressListener(AudioDecoder.OnProgressListener paramOnProgressListener)
  {
    this.onProgressListener = paramOnProgressListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.audio.AudioDecoder
 * JD-Core Version:    0.7.0.1
 */