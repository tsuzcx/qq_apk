package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.support.annotation.NonNull;
import java.io.FileNotFoundException;

public final class AssetFileDescriptorLocalUriFetcher
  extends LocalUriFetcher<AssetFileDescriptor>
{
  public AssetFileDescriptorLocalUriFetcher(ContentResolver paramContentResolver, Uri paramUri)
  {
    super(paramContentResolver, paramUri);
  }
  
  protected AssetFileDescriptor a(Uri paramUri, ContentResolver paramContentResolver)
  {
    paramContentResolver = paramContentResolver.openAssetFileDescriptor(paramUri, "r");
    if (paramContentResolver != null) {
      return paramContentResolver;
    }
    paramContentResolver = new StringBuilder();
    paramContentResolver.append("FileDescriptor is null for: ");
    paramContentResolver.append(paramUri);
    throw new FileNotFoundException(paramContentResolver.toString());
  }
  
  @NonNull
  public Class<AssetFileDescriptor> a()
  {
    return AssetFileDescriptor.class;
  }
  
  protected void a(AssetFileDescriptor paramAssetFileDescriptor)
  {
    paramAssetFileDescriptor.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.data.AssetFileDescriptorLocalUriFetcher
 * JD-Core Version:    0.7.0.1
 */