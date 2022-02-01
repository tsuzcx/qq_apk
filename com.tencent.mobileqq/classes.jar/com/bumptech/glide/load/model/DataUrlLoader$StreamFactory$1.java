package com.bumptech.glide.load.model;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class DataUrlLoader$StreamFactory$1
  implements DataUrlLoader.DataDecoder<InputStream>
{
  DataUrlLoader$StreamFactory$1(DataUrlLoader.StreamFactory paramStreamFactory) {}
  
  public Class<InputStream> a()
  {
    return InputStream.class;
  }
  
  public void a(InputStream paramInputStream)
  {
    paramInputStream.close();
  }
  
  public InputStream b(String paramString)
  {
    if (paramString.startsWith("data:image"))
    {
      int i = paramString.indexOf(',');
      if (i != -1)
      {
        if (paramString.substring(0, i).endsWith(";base64")) {
          return new ByteArrayInputStream(Base64.decode(paramString.substring(i + 1), 0));
        }
        throw new IllegalArgumentException("Not a base64 image data URL.");
      }
      throw new IllegalArgumentException("Missing comma in data URL.");
    }
    throw new IllegalArgumentException("Not a valid image data URL.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.DataUrlLoader.StreamFactory.1
 * JD-Core Version:    0.7.0.1
 */