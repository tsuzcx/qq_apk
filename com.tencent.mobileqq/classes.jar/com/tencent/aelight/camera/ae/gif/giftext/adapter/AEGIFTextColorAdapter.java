package com.tencent.aelight.camera.ae.gif.giftext.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextColorConfig;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextColorConfig.SmartTextColor;
import java.util.List;
import javax.annotation.Nonnull;

public class AEGIFTextColorAdapter
  extends RecyclerView.Adapter<AEGIFTextColorAdapter.TextEditColorViewHolder>
{
  private static List<AEGIFTextColorConfig.SmartTextColor> d;
  private Context a;
  private int b = 0;
  private RecyclerView c;
  private TextView e;
  private String f;
  private String g;
  
  public AEGIFTextColorAdapter(Context paramContext, RecyclerView paramRecyclerView)
  {
    this.a = paramContext;
    this.c = paramRecyclerView;
    d();
    this.f = ((AEGIFTextColorConfig.SmartTextColor)d.get(this.b)).a;
    this.g = ((AEGIFTextColorConfig.SmartTextColor)d.get(this.b)).b;
  }
  
  private void d()
  {
    d = AEGIFTextColorConfig.b;
  }
  
  @NonNull
  public AEGIFTextColorAdapter.TextEditColorViewHolder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (this.a == null) {
      this.a = paramViewGroup.getContext();
    }
    return new AEGIFTextColorAdapter.TextEditColorViewHolder(LayoutInflater.from(this.a).inflate(2064056480, paramViewGroup, false));
  }
  
  public String a()
  {
    return this.f;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    this.f = ((AEGIFTextColorConfig.SmartTextColor)d.get(paramInt)).a;
    this.g = ((AEGIFTextColorConfig.SmartTextColor)d.get(paramInt)).b;
  }
  
  public void a(TextView paramTextView)
  {
    this.e = paramTextView;
  }
  
  public void a(@NonNull AEGIFTextColorAdapter.TextEditColorViewHolder paramTextEditColorViewHolder, int paramInt)
  {
    paramTextEditColorViewHolder.a(((AEGIFTextColorConfig.SmartTextColor)d.get(paramInt)).a);
    if (paramInt == this.b) {
      paramTextEditColorViewHolder.a(true);
    } else {
      paramTextEditColorViewHolder.a(false);
    }
    paramTextEditColorViewHolder.itemView.setOnClickListener(new AEGIFTextColorAdapter.1(this, paramInt, paramTextEditColorViewHolder));
  }
  
  public int b()
  {
    return this.b;
  }
  
  @Nonnull
  public String c()
  {
    return this.g;
  }
  
  public int getItemCount()
  {
    return d.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFTextColorAdapter
 * JD-Core Version:    0.7.0.1
 */