package com.google.android.material.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.R.layout;

class NavigationMenuPresenter$NormalViewHolder
  extends NavigationMenuPresenter.ViewHolder
{
  public NavigationMenuPresenter$NormalViewHolder(@NonNull LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    super(paramLayoutInflater.inflate(R.layout.e, paramViewGroup, false));
    this.itemView.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.NavigationMenuPresenter.NormalViewHolder
 * JD-Core Version:    0.7.0.1
 */