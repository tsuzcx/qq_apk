package com.tencent.luggage.wxa.qo;

import com.tencent.luggage.wxa.if.e;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class b
  implements IDataSource
{
  public e a;
  
  public b(e parame)
  {
    this.a = parame;
  }
  
  public void close()
  {
    Logger.i("MicroMsg.Audio.InputStreamDataSource", "close");
    e locale = this.a;
    if (locale != null) {
      locale.close();
    }
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    if (this.a == null)
    {
      Logger.e("MicroMsg.Audio.InputStreamDataSource", "[getAudioType] unsupport");
      return AudioFormat.AudioType.UNSUPPORT;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAudioType:");
    localStringBuilder.append(this.a.d());
    Logger.i("MicroMsg.Audio.InputStreamDataSource", localStringBuilder.toString());
    int i = this.a.d();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              Logger.e("MicroMsg.Audio.InputStreamDataSource", "[getAudioType] unsupport");
              return AudioFormat.AudioType.UNSUPPORT;
            }
            return AudioFormat.AudioType.OGG;
          }
          return AudioFormat.AudioType.WAV;
        }
        return AudioFormat.AudioType.MP3;
      }
      return AudioFormat.AudioType.AAC;
    }
    return AudioFormat.AudioType.UNSUPPORT;
  }
  
  public long getSize()
  {
    e locale = this.a;
    if (locale != null) {
      return locale.c();
    }
    return 0L;
  }
  
  public void open()
  {
    Logger.i("MicroMsg.Audio.InputStreamDataSource", "open");
    e locale = this.a;
    if (locale != null) {
      locale.b();
    }
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    e locale = this.a;
    if (locale == null)
    {
      Logger.e("MicroMsg.Audio.InputStreamDataSource", "[readAt]audioDataSource is null");
      return -1;
    }
    return locale.a(paramLong, paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qo.b
 * JD-Core Version:    0.7.0.1
 */