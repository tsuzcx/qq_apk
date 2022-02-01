package com.tencent.luggage.wxa.nv;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;

final class d$b
  extends RecyclerView.Adapter<d.b.a>
{
  private final List<String> a;
  private final d.a b;
  
  public d$b(List<String> paramList, d.a parama)
  {
    this.a = new ArrayList(paramList);
    this.b = parama;
  }
  
  @NonNull
  public d.b.a a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624228, paramViewGroup, false);
    d.b.a locala = new d.b.a(this, paramViewGroup);
    locala.a = ((TextView)paramViewGroup.findViewById(2131447463));
    return locala;
  }
  
  @SuppressLint({"RecyclerView"})
  public void a(@NonNull d.b.a parama, int paramInt)
  {
    parama.a.setText((CharSequence)this.a.get(paramInt));
    parama.a.setOnClickListener(new d.b.1(this, paramInt));
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nv.d.b
 * JD-Core Version:    0.7.0.1
 */