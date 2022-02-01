package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

class DiskCacheStrategy$4
  extends DiskCacheStrategy
{
  public boolean a()
  {
    return true;
  }
  
  public boolean a(DataSource paramDataSource)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean, DataSource paramDataSource, EncodeStrategy paramEncodeStrategy)
  {
    return (paramDataSource != DataSource.RESOURCE_DISK_CACHE) && (paramDataSource != DataSource.MEMORY_CACHE);
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.DiskCacheStrategy.4
 * JD-Core Version:    0.7.0.1
 */