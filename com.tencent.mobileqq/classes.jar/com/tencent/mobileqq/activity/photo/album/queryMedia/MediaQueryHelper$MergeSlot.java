package com.tencent.mobileqq.activity.photo.album.queryMedia;

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
    boolean bool1;
    if (this.mOffset >= this.mCursor.getCount() - 1) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      ICursor localICursor = this.mCursor;
      int i = this.mOffset + 1;
      this.mOffset = i;
      bool2 = localICursor.moveToPosition(i);
      bool1 = bool2;
    } while (!bool2);
    this.mImage = this.mCursor.makeMediaInfo();
    this.need = this.mCursor.needMedia(this.mImage);
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.queryMedia.MediaQueryHelper.MergeSlot
 * JD-Core Version:    0.7.0.1
 */