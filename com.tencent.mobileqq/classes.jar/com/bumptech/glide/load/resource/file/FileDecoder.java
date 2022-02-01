package com.bumptech.glide.load.resource.file;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.File;

public class FileDecoder
  implements ResourceDecoder<File, File>
{
  public Resource<File> a(@NonNull File paramFile, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    return new FileResource(paramFile);
  }
  
  public boolean a(@NonNull File paramFile, @NonNull Options paramOptions)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.file.FileDecoder
 * JD-Core Version:    0.7.0.1
 */