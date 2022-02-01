package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.signature.ObjectKey;

public final class DataUrlLoader<Model, Data>
  implements ModelLoader<Model, Data>
{
  private final DataUrlLoader.DataDecoder<Data> a;
  
  public DataUrlLoader(DataUrlLoader.DataDecoder<Data> paramDataDecoder)
  {
    this.a = paramDataDecoder;
  }
  
  public ModelLoader.LoadData<Data> a(@NonNull Model paramModel, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    return new ModelLoader.LoadData(new ObjectKey(paramModel), new DataUrlLoader.DataUriFetcher(paramModel.toString(), this.a));
  }
  
  public boolean a(@NonNull Model paramModel)
  {
    return paramModel.toString().startsWith("data:image");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.DataUrlLoader
 * JD-Core Version:    0.7.0.1
 */