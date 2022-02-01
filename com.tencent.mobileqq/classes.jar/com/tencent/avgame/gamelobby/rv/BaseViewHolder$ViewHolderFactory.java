package com.tencent.avgame.gamelobby.rv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.avgame.gamelobby.data.IBaseData;

public abstract class BaseViewHolder$ViewHolderFactory<VH extends BaseViewHolder<? extends IBaseData>>
{
  public VH a(ViewHolderContext paramViewHolderContext, int paramInt, @NonNull ViewGroup paramViewGroup)
  {
    return b(paramViewHolderContext, LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false));
  }
  
  public VH b(ViewHolderContext paramViewHolderContext, View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.BaseViewHolder.ViewHolderFactory
 * JD-Core Version:    0.7.0.1
 */