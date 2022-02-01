package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import java.io.File;

class FileLoader$FileDescriptorFactory$1
  implements FileLoader.FileOpener<ParcelFileDescriptor>
{
  public ParcelFileDescriptor a(File paramFile)
  {
    return ParcelFileDescriptor.open(paramFile, 268435456);
  }
  
  public Class<ParcelFileDescriptor> a()
  {
    return ParcelFileDescriptor.class;
  }
  
  public void a(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    paramParcelFileDescriptor.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.FileLoader.FileDescriptorFactory.1
 * JD-Core Version:    0.7.0.1
 */