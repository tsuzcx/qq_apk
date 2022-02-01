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
  protected int a;
  protected T a;
  protected BaseViewHolder.OnClickListener a;
  
  public BaseViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseViewHolder$OnClickListener = null;
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
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseViewHolder$OnClickListener = paramOnClickListener;
  }
  
  public void a(ViewHolderContext paramViewHolderContext, T paramT, int paramInt) {}
  
  public final void b(ViewHolderContext paramViewHolderContext, IBaseData paramIBaseData, int paramInt)
  {
    if (paramIBaseData != null)
    {
      this.jdField_a_of_type_ComTencentAvgameGamelobbyDataIBaseData = paramIBaseData;
      a(paramViewHolderContext, this.jdField_a_of_type_ComTencentAvgameGamelobbyDataIBaseData, paramInt);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      this.jdField_a_of_type_ComTencentAvgameGamelobbyDataIBaseData = null;
      a(paramViewHolderContext, null, paramInt);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseViewHolder$OnClickListener != null) {
      this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseViewHolder$OnClickListener.a(paramView, this.jdField_a_of_type_ComTencentAvgameGamelobbyDataIBaseData, this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.BaseViewHolder
 * JD-Core Version:    0.7.0.1
 */