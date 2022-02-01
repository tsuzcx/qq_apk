package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

class DiskCacheStrategy$3
  extends DiskCacheStrategy
{
  public boolean a()
  {
    return false;
  }
  
  public boolean a(DataSource paramDataSource)
  {
    return (paramDataSource != DataSource.DATA_DISK_CACHE) && (paramDataSource != DataSource.MEMORY_CACHE);
  }
  
  public boolean a(boolean paramBoolean, DataSource paramDataSource, EncodeStrategy paramEncodeStrategy)
  {
    return false;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.DiskCacheStrategy.3
 * JD-Core Version:    0.7.0.1
 */