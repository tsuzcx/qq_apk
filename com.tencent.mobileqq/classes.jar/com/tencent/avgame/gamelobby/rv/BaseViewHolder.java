package com.tencent.avgame.gamelobby.rv;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.avgame.gamelobby.data.IBaseData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class BaseViewHolder<T extends IBaseData>
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  protected T a;
  protected int b;
  protected BaseViewHolder.OnClickListener c = null;
  
  public BaseViewHolder(@NonNull View paramView)
  {
    super(paramView);
  }
  
  protected void a() {}
  
  public final void a(View paramView)
  {
    if (paramView != null) {
      paramView.setOnClickListener(this);
    }
  }
  
  public void a(BaseViewHolder.OnClickListener paramOnClickListener)
  {
    this.c = paramOnClickListener;
  }
  
  public void a(ViewHolderContext paramViewHolderContext, T paramT, int paramInt) {}
  
  public final void b(ViewHolderContext paramViewHolderContext, IBaseData paramIBaseData, int paramInt)
  {
    if (paramIBaseData != null)
    {
      this.a = paramIBaseData;
      a(paramViewHolderContext, this.a, paramInt);
    }
    else
    {
      this.a = null;
      a(paramViewHolderContext, null, paramInt);
    }
    this.b = paramInt;
  }
  
  public void onClick(View paramView)
  {
    BaseViewHolder.OnClickListener localOnClickListener = this.c;
    if (localOnClickListener != null) {
      localOnClickListener.a(paramView, this.a, this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.BaseViewHolder
 * JD-Core Version:    0.7.0.1
 */