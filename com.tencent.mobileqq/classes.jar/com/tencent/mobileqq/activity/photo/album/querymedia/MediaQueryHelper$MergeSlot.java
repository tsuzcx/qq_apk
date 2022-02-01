package com.tencent.mobileqq.activity.photo.album.querymedia;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

class MediaQueryHelper$MergeSlot
{
  private final ICursor mCursor;
  LocalMediaInfo mImage;
  private int mOffset = -1;
  boolean need;
  
  public MediaQueryHelper$MergeSlot(ICursor paramICursor)
  {
    this.mCursor = paramICursor;
  }
  
  public boolean next()
  {
    if (this.mOffset >= this.mCursor.getCount() - 1) {
      return false;
    }
    ICursor localICursor = this.mCursor;
    int i = this.mOffset + 1;
    this.mOffset = i;
    boolean bool = localICursor.moveToPosition(i);
    if (bool)
    {
      this.mImage = this.mCursor.makeMediaInfo();
      this.need = this.mCursor.needMedia(this.mImage);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper.MergeSlot
 * JD-Core Version:    0.7.0.1
 */