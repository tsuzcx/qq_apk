package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import java.io.InputStream;

public class StreamAssetPathFetcher
  extends AssetPathFetcher<InputStream>
{
  public StreamAssetPathFetcher(AssetManager paramAssetManager, String paramString)
  {
    super(paramAssetManager, paramString);
  }
  
  @NonNull
  public Class<InputStream> a()
  {
    return InputStream.class;
  }
  
  protected void a(InputStream paramInputStream)
  {
    paramInputStream.close();
  }
  
  protected InputStream b(AssetManager paramAssetManager, String paramString)
  {
    return paramAssetManager.open(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.data.StreamAssetPathFetcher
 * JD-Core Version:    0.7.0.1
 */