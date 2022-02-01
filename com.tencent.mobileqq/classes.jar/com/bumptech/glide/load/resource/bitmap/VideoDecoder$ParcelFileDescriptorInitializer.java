package com.bumptech.glide.load.resource.bitmap;

import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;

final class VideoDecoder$ParcelFileDescriptorInitializer
  implements VideoDecoder.MediaMetadataRetrieverInitializer<ParcelFileDescriptor>
{
  public void a(MediaMetadataRetriever paramMediaMetadataRetriever, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    paramMediaMetadataRetriever.setDataSource(paramParcelFileDescriptor.getFileDescriptor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.VideoDecoder.ParcelFileDescriptorInitializer
 * JD-Core Version:    0.7.0.1
 */