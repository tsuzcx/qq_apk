package com.tencent.aelight.camera.ae.camera.util;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaMuxer;
import android.support.annotation.RequiresApi;
import com.tencent.aelight.camera.log.AEQLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public class AEVoiceVideoMergeUtil
{
  @Nullable
  @RequiresApi(api=18)
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    for (;;)
    {
      try
      {
        new File(paramString3).createNewFile();
        MediaExtractor localMediaExtractor = new MediaExtractor();
        localMediaExtractor.setDataSource(paramString2);
        paramString2 = new MediaExtractor();
        paramString2.setDataSource(paramString1);
        paramString1 = new MediaMuxer(paramString3, 0);
        localMediaExtractor.selectTrack(0);
        int k = paramString1.addTrack(localMediaExtractor.getTrackFormat(0));
        paramString2.selectTrack(0);
        int j = paramString1.addTrack(paramString2.getTrackFormat(0));
        ByteBuffer localByteBuffer1 = ByteBuffer.allocate(1048576);
        ByteBuffer localByteBuffer2 = ByteBuffer.allocate(1048576);
        MediaCodec.BufferInfo localBufferInfo1 = new MediaCodec.BufferInfo();
        MediaCodec.BufferInfo localBufferInfo2 = new MediaCodec.BufferInfo();
        localMediaExtractor.seekTo(0L, 2);
        paramString2.seekTo(0L, 2);
        paramString1.start();
        i = 0;
        if (i == 0)
        {
          localBufferInfo1.offset = 0;
          localBufferInfo1.size = localMediaExtractor.readSampleData(localByteBuffer1, 0);
          if ((localBufferInfo1.size >= 0) && (localBufferInfo2.size >= 0))
          {
            localBufferInfo1.presentationTimeUs = localMediaExtractor.getSampleTime();
            localBufferInfo1.flags = localMediaExtractor.getSampleFlags();
            paramString1.writeSampleData(k, localByteBuffer1, localBufferInfo1);
            localMediaExtractor.advance();
            continue;
          }
          localBufferInfo1.size = 0;
          i = 1;
          continue;
          if (i == 0)
          {
            localBufferInfo2.offset = 0;
            localBufferInfo2.size = paramString2.readSampleData(localByteBuffer2, 0);
            if ((localBufferInfo1.size >= 0) && (localBufferInfo2.size >= 0))
            {
              localBufferInfo2.presentationTimeUs = paramString2.getSampleTime();
              localBufferInfo2.flags = paramString2.getSampleFlags();
              paramString1.writeSampleData(j, localByteBuffer2, localBufferInfo2);
              paramString2.advance();
              continue;
            }
            localBufferInfo2.size = 0;
            i = 1;
            continue;
          }
          paramString1.stop();
          paramString1.release();
          paramString2.release();
          localMediaExtractor.release();
          return paramString3;
        }
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("Mixer Error 2 ");
        paramString2.append(paramString1.toString());
        AEQLog.a("AEVoiceVideoMergeUtil", paramString2.toString(), paramString1);
        return null;
      }
      catch (IOException paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("Mixer Error 1 ");
        paramString2.append(paramString1.toString());
        AEQLog.a("AEVoiceVideoMergeUtil", paramString2.toString(), paramString1);
        return null;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.util.AEVoiceVideoMergeUtil
 * JD-Core Version:    0.7.0.1
 */