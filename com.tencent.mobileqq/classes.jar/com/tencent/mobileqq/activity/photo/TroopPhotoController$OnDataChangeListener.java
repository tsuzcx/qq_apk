package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.troop.utils.TroopUploadingThread.UploadState;

public abstract interface TroopPhotoController$OnDataChangeListener
{
  public abstract void onAddItem(AvatarInfo paramAvatarInfo);
  
  public abstract void onDataSetChanged();
  
  public abstract void onDelItem(AvatarInfo paramAvatarInfo);
  
  public abstract void onItemSelect(int paramInt);
  
  public abstract void onUpdateItem(AvatarInfo paramAvatarInfo, TroopUploadingThread.UploadState paramUploadState);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopPhotoController.OnDataChangeListener
 * JD-Core Version:    0.7.0.1
 */