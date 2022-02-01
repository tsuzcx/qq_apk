package com.tencent.mobileqq.activity.photo.album.querymedia;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.Comparator;

class MediaQueryHelper$DataComparator
  implements Comparator<MediaQueryHelper.MergeSlot>
{
  public int compare(MediaQueryHelper.MergeSlot paramMergeSlot1, MediaQueryHelper.MergeSlot paramMergeSlot2)
  {
    if (paramMergeSlot1.mImage == null) {}
    do
    {
      do
      {
        return 1;
        if (paramMergeSlot2.mImage == null) {
          return -1;
        }
        if (paramMergeSlot2.mImage.modifiedDate == paramMergeSlot1.mImage.modifiedDate) {
          break;
        }
      } while (paramMergeSlot2.mImage.modifiedDate - paramMergeSlot1.mImage.modifiedDate > 0L);
      return -1;
    } while (paramMergeSlot2.mImage.addedDate - paramMergeSlot1.mImage.addedDate > 0L);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper.DataComparator
 * JD-Core Version:    0.7.0.1
 */