package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;

public class FileDescriptorAssetPathFetcher
  extends AssetPathFetcher<ParcelFileDescriptor>
{
  public FileDescriptorAssetPathFetcher(AssetManager paramAssetManager, String paramString)
  {
    super(paramAssetManager, paramString);
  }
  
  @NonNull
  public Class<ParcelFileDescriptor> a()
  {
    return ParcelFileDescriptor.class;
  }
  
  protected void a(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    paramParcelFileDescriptor.close();
  }
  
  protected ParcelFileDescriptor b(AssetManager paramAssetManager, String paramString)
  {
    return paramAssetManager.openFd(paramString).getParcelFileDescriptor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher
 * JD-Core Version:    0.7.0.1
 */