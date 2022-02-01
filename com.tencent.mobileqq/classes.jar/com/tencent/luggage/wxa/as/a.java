package com.tencent.luggage.wxa.as;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.luggage.wxa.aw.b;

public abstract class a<T extends RecyclerView.ViewHolder>
  extends RecyclerView.Adapter<T>
{
  private final Context a;
  private final LayoutInflater b;
  private final b c;
  
  public a(Context paramContext, b paramb)
  {
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
    this.c = paramb;
  }
  
  public b a()
  {
    return this.c;
  }
  
  public Context b()
  {
    return this.a;
  }
  
  public LayoutInflater c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.as.a
 * JD-Core Version:    0.7.0.1
 */