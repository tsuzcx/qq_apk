package com.tencent.luggage.wxa.gq;

import android.media.MediaDataSource;
import androidx.annotation.RequiresApi;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;

@RequiresApi(23)
public class i
  extends MediaDataSource
{
  private IDataSource a;
  
  public i(IDataSource paramIDataSource)
  {
    this.a = paramIDataSource;
  }
  
  public void close()
  {
    IDataSource localIDataSource = this.a;
    if (localIDataSource != null)
    {
      localIDataSource.close();
      this.a = null;
    }
  }
  
  public long getSize()
  {
    IDataSource localIDataSource = this.a;
    if (localIDataSource != null) {
      return localIDataSource.getSize();
    }
    return -1L;
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    IDataSource localIDataSource = this.a;
    if (localIDataSource != null) {
      return localIDataSource.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gq.i
 * JD-Core Version:    0.7.0.1
 */