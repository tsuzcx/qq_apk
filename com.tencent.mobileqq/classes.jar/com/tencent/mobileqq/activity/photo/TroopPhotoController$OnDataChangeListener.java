package com.tencent.mobileqq.activity.photo;

import ajnr;
import bfed;

public abstract interface TroopPhotoController$OnDataChangeListener
{
  public abstract void onAddItem(ajnr paramajnr);
  
  public abstract void onDataSetChanged();
  
  public abstract void onDelItem(ajnr paramajnr);
  
  public abstract void onItemSelect(int paramInt);
  
  public abstract void onUpdateItem(ajnr paramajnr, bfed parambfed);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopPhotoController.OnDataChangeListener
 * JD-Core Version:    0.7.0.1
 */