import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaMuxer;
import android.support.annotation.RequiresApi;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public class bnor
{
  @Nullable
  @RequiresApi(api=18)
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    int j;
    ByteBuffer localByteBuffer2;
    MediaCodec.BufferInfo localBufferInfo1;
    MediaCodec.BufferInfo localBufferInfo2;
    for (;;)
    {
      try
      {
        new File(paramString3).createNewFile();
        localMediaExtractor = new MediaExtractor();
        localMediaExtractor.setDataSource(paramString2);
        paramString2 = new MediaExtractor();
        paramString2.setDataSource(paramString1);
        paramString1 = new MediaMuxer(paramString3, 0);
        localMediaExtractor.selectTrack(0);
        k = paramString1.addTrack(localMediaExtractor.getTrackFormat(0));
        paramString2.selectTrack(0);
        j = paramString1.addTrack(paramString2.getTrackFormat(0));
        i = 0;
        localByteBuffer1 = ByteBuffer.allocate(1048576);
        localByteBuffer2 = ByteBuffer.allocate(1048576);
        localBufferInfo1 = new MediaCodec.BufferInfo();
        localBufferInfo2 = new MediaCodec.BufferInfo();
        localMediaExtractor.seekTo(0L, 2);
        paramString2.seekTo(0L, 2);
        paramString1.start();
      }
      catch (IOException paramString1)
      {
        MediaExtractor localMediaExtractor;
        int k;
        ByteBuffer localByteBuffer1;
        bnzb.a("AEVoiceVideoMergeUtil", "Mixer Error 1 " + paramString1.toString(), paramString1);
        return null;
        localBufferInfo1.presentationTimeUs = localMediaExtractor.getSampleTime();
        localBufferInfo1.flags = localMediaExtractor.getSampleFlags();
        paramString1.writeSampleData(k, localByteBuffer1, localBufferInfo1);
        localMediaExtractor.advance();
        continue;
      }
      catch (Exception paramString1)
      {
        bnzb.a("AEVoiceVideoMergeUtil", "Mixer Error 2 " + paramString1.toString(), paramString1);
        return null;
      }
      if (i != 0) {
        break label286;
      }
      localBufferInfo1.offset = 0;
      localBufferInfo1.size = localMediaExtractor.readSampleData(localByteBuffer1, 0);
      if ((localBufferInfo1.size >= 0) && (localBufferInfo2.size >= 0)) {
        continue;
      }
      i = 1;
      localBufferInfo1.size = 0;
    }
    label286:
    int i = 0;
    while (i == 0)
    {
      localBufferInfo2.offset = 0;
      localBufferInfo2.size = paramString2.readSampleData(localByteBuffer2, 0);
      if ((localBufferInfo1.size < 0) || (localBufferInfo2.size < 0))
      {
        i = 1;
        localBufferInfo2.size = 0;
      }
      else
      {
        localBufferInfo2.presentationTimeUs = paramString2.getSampleTime();
        localBufferInfo2.flags = paramString2.getSampleFlags();
        paramString1.writeSampleData(j, localByteBuffer2, localBufferInfo2);
        paramString2.advance();
      }
    }
    paramString1.stop();
    paramString1.release();
    return paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnor
 * JD-Core Version:    0.7.0.1
 */