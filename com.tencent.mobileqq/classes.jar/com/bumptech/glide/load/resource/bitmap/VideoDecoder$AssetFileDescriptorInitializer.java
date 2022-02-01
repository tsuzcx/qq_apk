package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.media.MediaMetadataRetriever;

final class VideoDecoder$AssetFileDescriptorInitializer
  implements VideoDecoder.MediaMetadataRetrieverInitializer<AssetFileDescriptor>
{
  public void a(MediaMetadataRetriever paramMediaMetadataRetriever, AssetFileDescriptor paramAssetFileDescriptor)
  {
    paramMediaMetadataRetriever.setDataSource(paramAssetFileDescriptor.getFileDescriptor(), paramAssetFileDescriptor.getStartOffset(), paramAssetFileDescriptor.getLength());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.VideoDecoder.AssetFileDescriptorInitializer
 * JD-Core Version:    0.7.0.1
 */