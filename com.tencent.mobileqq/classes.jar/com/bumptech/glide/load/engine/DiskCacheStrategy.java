package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

public abstract class DiskCacheStrategy
{
  public static final DiskCacheStrategy a = new DiskCacheStrategy.1();
  public static final DiskCacheStrategy b = new DiskCacheStrategy.2();
  public static final DiskCacheStrategy c = new DiskCacheStrategy.3();
  public static final DiskCacheStrategy d = new DiskCacheStrategy.4();
  public static final DiskCacheStrategy e = new DiskCacheStrategy.5();
  
  public abstract boolean a();
  
  public abstract boolean a(DataSource paramDataSource);
  
  public abstract boolean a(boolean paramBoolean, DataSource paramDataSource, EncodeStrategy paramEncodeStrategy);
  
  public abstract boolean b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.DiskCacheStrategy
 * JD-Core Version:    0.7.0.1
 */