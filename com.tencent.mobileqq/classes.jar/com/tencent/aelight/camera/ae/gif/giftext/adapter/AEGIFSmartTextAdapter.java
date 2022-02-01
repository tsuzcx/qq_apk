package com.tencent.aelight.camera.ae.gif.giftext.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFSmartTextData;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextMvp;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;

public class AEGIFSmartTextAdapter
  extends RecyclerView.Adapter<AEGIFSmartTextAdapter.QIMGIFSmartTextViewHolder>
{
  private Context a;
  private ArrayList<AEGIFSmartTextData> b;
  private RecyclerView c;
  private int d = -1;
  private AEGIFTextMvp e;
  
  public AEGIFSmartTextAdapter(Context paramContext, AEGIFTextMvp paramAEGIFTextMvp)
  {
    this.a = paramContext;
    this.e = paramAEGIFTextMvp;
    a(this.e.f());
    a(this.e.e());
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    this.c = paramRecyclerView;
  }
  
  private void a(ArrayList<AEGIFSmartTextData> paramArrayList)
  {
    this.b = paramArrayList;
  }
  
  public AEGIFSmartTextAdapter.QIMGIFSmartTextViewHolder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (this.a == null) {
      this.a = paramViewGroup.getContext();
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2064056478, paramViewGroup, false);
    if (paramInt != 0) {
      paramViewGroup.setVisibility(4);
    }
    return new AEGIFSmartTextAdapter.QIMGIFSmartTextViewHolder(paramViewGroup);
  }
  
  public void a()
  {
    AEGIFSmartTextAdapter.QIMGIFSmartTextViewHolder localQIMGIFSmartTextViewHolder = (AEGIFSmartTextAdapter.QIMGIFSmartTextViewHolder)this.c.findViewHolderForLayoutPosition(this.d);
    if (localQIMGIFSmartTextViewHolder != null)
    {
      localQIMGIFSmartTextViewHolder.a(false);
    }
    else
    {
      i = this.d;
      if (i >= 0) {
        notifyItemChanged(i);
      }
    }
    int i = this.d;
    if (i >= 0) {
      ((AEGIFSmartTextData)this.b.get(i - 1)).a(false);
    }
    this.d = -1;
  }
  
  public void a(AEGIFSmartTextAdapter.QIMGIFSmartTextViewHolder paramQIMGIFSmartTextViewHolder, int paramInt)
  {
    if (paramQIMGIFSmartTextViewHolder.getLayoutPosition() == 0)
    {
      localObject = new FrameLayout.LayoutParams(DisplayUtil.a(this.a, 33.0F), DisplayUtil.a(this.a, 33.0F));
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, DisplayUtil.a(this.a, 51.0F), 0);
      paramQIMGIFSmartTextViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    Object localObject = ((AEGIFSmartTextData)this.b.get(paramQIMGIFSmartTextViewHolder.getLayoutPosition() - 1)).a;
    paramQIMGIFSmartTextViewHolder.a.setText((CharSequence)localObject);
    if (this.d == paramQIMGIFSmartTextViewHolder.getLayoutPosition()) {
      paramQIMGIFSmartTextViewHolder.a(true);
    } else {
      paramQIMGIFSmartTextViewHolder.a(false);
    }
    paramQIMGIFSmartTextViewHolder.itemView.setOnClickListener(new AEGIFSmartTextAdapter.1(this, paramQIMGIFSmartTextViewHolder, (String)localObject));
  }
  
  public int getItemCount()
  {
    return this.b.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt != 0) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFSmartTextAdapter
 * JD-Core Version:    0.7.0.1
 */