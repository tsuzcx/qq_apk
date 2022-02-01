package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.Preconditions;
import java.util.Collections;
import java.util.List;

public class ModelLoader$LoadData<Data>
{
  public final Key a;
  public final List<Key> b;
  public final DataFetcher<Data> c;
  
  public ModelLoader$LoadData(@NonNull Key paramKey, @NonNull DataFetcher<Data> paramDataFetcher)
  {
    this(paramKey, Collections.emptyList(), paramDataFetcher);
  }
  
  public ModelLoader$LoadData(@NonNull Key paramKey, @NonNull List<Key> paramList, @NonNull DataFetcher<Data> paramDataFetcher)
  {
    this.a = ((Key)Preconditions.a(paramKey));
    this.b = ((List)Preconditions.a(paramList));
    this.c = ((DataFetcher)Preconditions.a(paramDataFetcher));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ModelLoader.LoadData
 * JD-Core Version:    0.7.0.1
 */