package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import java.io.File;

public class FileLoader$Factory<Data>
  implements ModelLoaderFactory<File, Data>
{
  private final FileLoader.FileOpener<Data> a;
  
  public FileLoader$Factory(FileLoader.FileOpener<Data> paramFileOpener)
  {
    this.a = paramFileOpener;
  }
  
  @NonNull
  public final ModelLoader<File, Data> a(@NonNull MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new FileLoader(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.FileLoader.Factory
 * JD-Core Version:    0.7.0.1
 */