package com.tencent.falco.base.imageloader;

import android.content.Context;
import com.nostra13.universalimageloader.core.assist.ContentLengthInputStream;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

class ImageLoaderComponent$3
  extends BaseImageDownloader
{
  ImageLoaderComponent$3(ImageLoaderComponent paramImageLoaderComponent, Context paramContext)
  {
    super(paramContext);
  }
  
  protected InputStream getStreamFromOtherSource(String paramString, Object paramObject)
  {
    if (paramString.startsWith("file:/"))
    {
      paramString = paramString.substring(6);
      return new ContentLengthInputStream(new BufferedInputStream(new FileInputStream(paramString), 32768), (int)new File(paramString).length());
    }
    return super.getStreamFromOtherSource(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.imageloader.ImageLoaderComponent.3
 * JD-Core Version:    0.7.0.1
 */