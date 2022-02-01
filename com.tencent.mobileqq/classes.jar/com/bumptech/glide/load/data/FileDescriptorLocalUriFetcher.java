package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import java.io.FileNotFoundException;

public class FileDescriptorLocalUriFetcher
  extends LocalUriFetcher<ParcelFileDescriptor>
{
  public FileDescriptorLocalUriFetcher(ContentResolver paramContentResolver, Uri paramUri)
  {
    super(paramContentResolver, paramUri);
  }
  
  protected ParcelFileDescriptor a(Uri paramUri, ContentResolver paramContentResolver)
  {
    paramContentResolver = paramContentResolver.openAssetFileDescriptor(paramUri, "r");
    if (paramContentResolver != null) {
      return paramContentResolver.getParcelFileDescriptor();
    }
    paramContentResolver = new StringBuilder();
    paramContentResolver.append("FileDescriptor is null for: ");
    paramContentResolver.append(paramUri);
    throw new FileNotFoundException(paramContentResolver.toString());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.data.FileDescriptorLocalUriFetcher
 * JD-Core Version:    0.7.0.1
 */