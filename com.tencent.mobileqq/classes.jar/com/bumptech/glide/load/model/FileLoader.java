package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;

public class FileLoader<Data>
  implements ModelLoader<File, Data>
{
  private final FileLoader.FileOpener<Data> a;
  
  public FileLoader(FileLoader.FileOpener<Data> paramFileOpener)
  {
    this.a = paramFileOpener;
  }
  
  public ModelLoader.LoadData<Data> a(@NonNull File paramFile, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    return new ModelLoader.LoadData(new ObjectKey(paramFile), new FileLoader.FileFetcher(paramFile, this.a));
  }
  
  public boolean a(@NonNull File paramFile)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.FileLoader
 * JD-Core Version:    0.7.0.1
 */