package com.nostra13.universalimageloader.cache.disc.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import com.nostra13.universalimageloader.utils.IoUtils.CopyListener;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LimitedAgeDiskCache
  extends BaseDiskCache
{
  private final Map<File, Long> loadingDates = Collections.synchronizedMap(new HashMap());
  private final long maxFileAge;
  
  public LimitedAgeDiskCache(File paramFile, long paramLong)
  {
    this(paramFile, null, DefaultConfigurationFactory.createFileNameGenerator(), paramLong);
  }
  
  public LimitedAgeDiskCache(File paramFile1, File paramFile2, long paramLong)
  {
    this(paramFile1, paramFile2, DefaultConfigurationFactory.createFileNameGenerator(), paramLong);
  }
  
  public LimitedAgeDiskCache(File paramFile1, File paramFile2, FileNameGenerator paramFileNameGenerator, long paramLong)
  {
    super(paramFile1, paramFile2, paramFileNameGenerator);
    this.maxFileAge = (1000L * paramLong);
  }
  
  private void rememberUsage(String paramString)
  {
    paramString = getFile(paramString);
    long l = System.currentTimeMillis();
    paramString.setLastModified(l);
    this.loadingDates.put(paramString, Long.valueOf(l));
  }
  
  public void clear()
  {
    super.clear();
    this.loadingDates.clear();
  }
  
  public File get(String paramString)
  {
    File localFile = super.get(paramString);
    int i;
    if ((localFile != null) && (localFile.exists()))
    {
      paramString = (Long)this.loadingDates.get(localFile);
      if (paramString != null) {
        break label79;
      }
      i = 0;
      paramString = Long.valueOf(localFile.lastModified());
      if (System.currentTimeMillis() - paramString.longValue() <= this.maxFileAge) {
        break label84;
      }
      localFile.delete();
      this.loadingDates.remove(localFile);
    }
    label79:
    label84:
    while (i != 0)
    {
      return localFile;
      i = 1;
      break;
    }
    this.loadingDates.put(localFile, paramString);
    return localFile;
  }
  
  public boolean remove(String paramString)
  {
    this.loadingDates.remove(getFile(paramString));
    return super.remove(paramString);
  }
  
  public boolean save(String paramString, Bitmap paramBitmap)
  {
    boolean bool = super.save(paramString, paramBitmap);
    rememberUsage(paramString);
    return bool;
  }
  
  public boolean save(String paramString, InputStream paramInputStream, IoUtils.CopyListener paramCopyListener)
  {
    boolean bool = super.save(paramString, paramInputStream, paramCopyListener);
    rememberUsage(paramString);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.LimitedAgeDiskCache
 * JD-Core Version:    0.7.0.1
 */